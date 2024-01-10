package io.intercom.android.nexus;

import com.intercom.twig.Twig;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.json.JSONException;
import org.json.JSONObject;

class NexusSocket {
    private static final WebSocket CLOSED_SOCKET = new WebSocket() {
        public void cancel() {
        }

        public boolean close(int i, String str) {
            return false;
        }

        public long queueSize() {
            return 0;
        }

        public boolean send(String str) {
            return false;
        }

        public boolean send(ByteString byteString) {
            return false;
        }

        public Request request() {
            throw new NullPointerException("ClosedSocket has no request");
        }
    };
    private static final String HEADER = "?X-Nexus-Version=android.1.3.0";
    private static final int MAX_RECONNECT_TIME_SECONDS = 900;
    private static final int N_TIMEOUT_DISCONNECT = 4001;
    private static final int OK_CLIENT_DISCONNECT = 4000;
    private final OkHttpClient client;
    private final long connectionTimeoutSeconds;
    private long lastReconnectAt = 0;
    /* access modifiers changed from: private */
    public final NexusListener listener;
    private int reconnectAttempts = 0;
    /* access modifiers changed from: private */
    public ScheduledFuture reconnectFuture;
    /* access modifiers changed from: private */
    public final boolean shouldSendPresence;
    /* access modifiers changed from: private */
    public WebSocket socket = CLOSED_SOCKET;
    private final ScheduledExecutorService timeoutExecutor;
    private ScheduledFuture timeoutFuture;
    private final Runnable timeoutRunnable = new Runnable() {
        public void run() {
            NexusSocket.this.timedOut();
        }
    };
    /* access modifiers changed from: private */
    public final NexusTopicProvider topicProvider;
    /* access modifiers changed from: private */
    public final Twig twig;
    private final String url;
    private final WebSocketListener webSocketListener = new WebSocketListener() {
        public void onOpen(WebSocket webSocket, Response response) {
            Twig access$200 = NexusSocket.this.twig;
            access$200.internal("onOpen: " + response.message());
            WebSocket unused = NexusSocket.this.socket = webSocket;
            NexusSocket.this.resetTimeout();
            List<String> topics = NexusSocket.this.topicProvider.getTopics();
            if (!topics.isEmpty()) {
                NexusSocket.this.fire(NexusEvent.getSubscribeEvent(topics).toStringEncodedJsonObject());
            }
            if (NexusSocket.this.shouldSendPresence) {
                NexusSocket.this.fire(NexusEvent.getUserPresenceEvent().toStringEncodedJsonObject());
            }
            NexusSocket.this.listener.onConnect();
        }

        public void onMessage(WebSocket webSocket, String str) {
            NexusSocket.this.resetTimeout();
            parseJsonString(str);
        }

        private void parseJsonString(String str) {
            if (!str.isEmpty() && !str.equals(" ") && !str.endsWith("|")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("eventName");
                    if (!optString.isEmpty()) {
                        if (!optString.equals("ACK")) {
                            Twig access$200 = NexusSocket.this.twig;
                            access$200.internal("onMessage TEXT: " + str);
                            NexusSocket.this.listener.notifyEvent(new NexusEvent(jSONObject));
                            return;
                        }
                    }
                    Twig access$2002 = NexusSocket.this.twig;
                    access$2002.internal("onMessage ACK: " + str);
                } catch (JSONException e) {
                    Twig access$2003 = NexusSocket.this.twig;
                    access$2003.internal("onMessage: json parse exception for message: '" + str + " " + e);
                }
            }
        }

        public void onMessage(WebSocket webSocket, ByteString byteString) {
            Twig access$200 = NexusSocket.this.twig;
            access$200.internal("Received bytes message " + byteString + ", resetting timeout");
            NexusSocket.this.resetTimeout();
        }

        public void onClosing(WebSocket webSocket, int i, String str) {
            Twig access$200 = NexusSocket.this.twig;
            access$200.internal("Server requested close:  " + i + " - '" + str + "'");
            webSocket.close(i, str);
        }

        public void onClosed(WebSocket webSocket, int i, String str) {
            if (i != NexusSocket.OK_CLIENT_DISCONNECT) {
                NexusSocket.this.scheduleReconnect();
            } else {
                NexusSocket.this.shutdown();
            }
            Twig access$200 = NexusSocket.this.twig;
            access$200.internal("onClose code: " + i + " reason: " + str);
        }

        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            if (NexusSocket.shouldReconnectFromFailure(response)) {
                NexusSocket.this.scheduleReconnect();
            } else {
                NexusSocket.this.shutdown();
            }
            Twig access$200 = NexusSocket.this.twig;
            access$200.internal("onFailure: " + th.getMessage());
            NexusSocket.this.listener.onConnectFailed();
        }
    };

    NexusSocket(String str, int i, boolean z, Twig twig2, ScheduledExecutorService scheduledExecutorService, OkHttpClient okHttpClient, NexusListener nexusListener, NexusTopicProvider nexusTopicProvider) {
        this.url = str;
        this.connectionTimeoutSeconds = (long) i;
        this.shouldSendPresence = z;
        this.twig = twig2;
        this.listener = nexusListener;
        this.topicProvider = nexusTopicProvider;
        this.client = okHttpClient;
        this.timeoutExecutor = scheduledExecutorService;
    }

    /* access modifiers changed from: package-private */
    public void connect() {
        this.twig.d("connecting to a socket...", new Object[0]);
        Request.Builder builder = new Request.Builder();
        this.client.newWebSocket(builder.url(this.url + HEADER).build(), this.webSocketListener);
        this.timeoutFuture = this.timeoutExecutor.schedule(this.timeoutRunnable, this.connectionTimeoutSeconds, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public void fire(String str) {
        if (!str.isEmpty()) {
            try {
                Twig twig2 = this.twig;
                twig2.internal("firing: " + str);
                this.socket.send(str);
            } catch (IllegalStateException e) {
                Twig twig3 = this.twig;
                twig3.internal("Error when firing '" + str + "': " + e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void disconnect() {
        disconnect(OK_CLIENT_DISCONNECT, "Disconnect called by client");
    }

    /* access modifiers changed from: package-private */
    public boolean isConnected() {
        return this.socket != CLOSED_SOCKET;
    }

    private void disconnect(int i, String str) {
        if (!this.socket.close(i, str)) {
            this.twig.internal("Could not close socket while disconnecting, it may be already closed");
        }
    }

    /* access modifiers changed from: private */
    public void timedOut() {
        if (this.socket == CLOSED_SOCKET) {
            scheduleReconnect();
        } else {
            disconnect(N_TIMEOUT_DISCONNECT, "Socket timed out");
        }
        this.listener.onConnectFailed();
    }

    /* access modifiers changed from: private */
    public void resetTimeout() {
        ScheduledFuture scheduledFuture = this.timeoutFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        this.timeoutFuture = this.timeoutExecutor.schedule(this.timeoutRunnable, this.connectionTimeoutSeconds, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: private */
    public void scheduleReconnect() {
        if (this.reconnectFuture == null) {
            modifyReconnectAttempts();
            long calculateReconnectTimerInSeconds = calculateReconnectTimerInSeconds(this.reconnectAttempts);
            Twig twig2 = this.twig;
            twig2.internal("Scheduling reconnect in: " + calculateReconnectTimerInSeconds + " for attempt: " + this.reconnectAttempts);
            this.reconnectFuture = this.timeoutExecutor.schedule(new Runnable() {
                public void run() {
                    NexusSocket.this.connect();
                    ScheduledFuture unused = NexusSocket.this.reconnectFuture = null;
                }
            }, calculateReconnectTimerInSeconds, TimeUnit.SECONDS);
        }
    }

    private void modifyReconnectAttempts() {
        if (System.currentTimeMillis() - this.lastReconnectAt > TimeUnit.SECONDS.toMillis(900) * 2) {
            this.twig.d("resetting reconnection attempts", new Object[0]);
            this.reconnectAttempts = 1;
        } else {
            this.twig.d("incrementing reconnection attempts", new Object[0]);
            this.reconnectAttempts++;
        }
        this.lastReconnectAt = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public void shutdown() {
        this.socket = CLOSED_SOCKET;
        ScheduledFuture scheduledFuture = this.timeoutFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        this.listener.onShutdown();
    }

    static long calculateReconnectTimerInSeconds(int i) {
        int min = (int) Math.min(Math.pow(2.0d, (double) i), 900.0d);
        return (long) (min + new Random().nextInt(min + 1));
    }

    static boolean shouldReconnectFromFailure(Response response) {
        if (response == null) {
            return true;
        }
        int code = response.code();
        return code >= 500 && code <= 599;
    }
}
