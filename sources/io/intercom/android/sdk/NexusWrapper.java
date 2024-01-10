package io.intercom.android.sdk;

import androidx.webkit.ProxyConfig;
import com.intercom.twig.Twig;
import com.squareup.otto.Bus;
import io.intercom.android.nexus.NexusClient;
import io.intercom.android.nexus.NexusConfig;
import io.intercom.android.nexus.NexusEvent;
import io.intercom.android.nexus.NexusListener;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.conversation.events.AdminIsTypingEvent;
import io.intercom.android.sdk.models.events.realtime.UserContentSeenByAdminEvent;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

class NexusWrapper extends NexusClient implements NexusListener {
    private static final String ADMIN_AVATAR = "adminAvatar";
    private static final String ADMIN_ID = "adminId";
    private static final String ADMIN_NAME = "adminName";
    private static final String CONVERSATION_ID = "conversationId";
    private ScheduledFuture actionFuture;
    private final Api api;
    private final Bus bus;
    private final long debouncePeriodMs;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final Store<State> store;
    private final Twig twig;

    public void onConnect() {
    }

    public void onConnectFailed() {
    }

    public void onShutdown() {
    }

    NexusWrapper(Twig twig2, OkHttpClient okHttpClient, Bus bus2, Store<State> store2, Api api2, long j) {
        super(twig2, okHttpClient);
        this.twig = twig2;
        this.bus = bus2;
        this.store = store2;
        this.api = api2;
        this.debouncePeriodMs = j;
    }

    public void connect(final NexusConfig nexusConfig, final boolean z) {
        if (nexusConfig.getEndpoints().isEmpty()) {
            this.twig.w("No realtime endpoints present so we can't connect", new Object[0]);
            return;
        }
        removeCallbacks();
        this.actionFuture = this.executor.schedule(new Runnable() {
            public void run() {
                NexusWrapper.this.connectNow(nexusConfig, z);
            }
        }, this.debouncePeriodMs, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public void connectNow(NexusConfig nexusConfig, boolean z) {
        if (!isConnected()) {
            super.connect(nexusConfig, z);
            setTopics(Collections.singletonList(ProxyConfig.MATCH_ALL_SCHEMES));
            addEventListener(this);
        }
    }

    public void disconnect() {
        removeCallbacks();
        this.actionFuture = this.executor.schedule(new Runnable() {
            public void run() {
                NexusWrapper.this.disconnectNow();
            }
        }, this.debouncePeriodMs, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public void disconnectNow() {
        removeEventListener(this);
        super.disconnect();
    }

    private void removeCallbacks() {
        ScheduledFuture scheduledFuture = this.actionFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    /* renamed from: io.intercom.android.sdk.NexusWrapper$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$nexus$NexusEventType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.intercom.android.nexus.NexusEventType[] r0 = io.intercom.android.nexus.NexusEventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$intercom$android$nexus$NexusEventType = r0
                io.intercom.android.nexus.NexusEventType r1 = io.intercom.android.nexus.NexusEventType.AdminIsTyping     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$nexus$NexusEventType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.nexus.NexusEventType r1 = io.intercom.android.nexus.NexusEventType.NewComment     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$nexus$NexusEventType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.nexus.NexusEventType r1 = io.intercom.android.nexus.NexusEventType.UserContentSeenByAdmin     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$nexus$NexusEventType     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.nexus.NexusEventType r1 = io.intercom.android.nexus.NexusEventType.ConversationSeen     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$intercom$android$nexus$NexusEventType     // Catch:{ NoSuchFieldError -> 0x003e }
                io.intercom.android.nexus.NexusEventType r1 = io.intercom.android.nexus.NexusEventType.NewContent     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.NexusWrapper.AnonymousClass3.<clinit>():void");
        }
    }

    public void notifyEvent(NexusEvent nexusEvent) {
        String optString = nexusEvent.getEventData().optString(CONVERSATION_ID);
        int i = AnonymousClass3.$SwitchMap$io$intercom$android$nexus$NexusEventType[nexusEvent.getEventType().ordinal()];
        if (i == 1) {
            logKnownEvent(nexusEvent);
            this.bus.post(new AdminIsTypingEvent(nexusEvent.getEventData().optString(ADMIN_ID), optString, nexusEvent.getEventData().optString(ADMIN_NAME), nexusEvent.getEventData().optString(ADMIN_AVATAR)));
        } else if (i == 2) {
            logKnownEvent(nexusEvent);
            this.store.dispatch(Actions.newCommentEventReceived(optString));
        } else if (i == 3) {
            logKnownEvent(nexusEvent);
            this.bus.post(new UserContentSeenByAdminEvent(optString));
        } else if (i == 4) {
            logKnownEvent(nexusEvent);
            this.store.dispatch(Actions.conversationMarkedAsRead(optString));
        } else if (i != 5) {
            Twig twig2 = this.twig;
            twig2.internal("Nexus", "Unexpected event: " + nexusEvent.getEventType());
        } else {
            logKnownEvent(nexusEvent);
            if (nexusEvent.getEventData().optLong("entity_type") == 44) {
                this.api.fetchCarouselByEntityId(nexusEvent.getEventData().optString("entity_id"));
            }
        }
    }

    private void logKnownEvent(NexusEvent nexusEvent) {
        Twig twig2 = this.twig;
        twig2.internal("Nexus", "Received " + nexusEvent.getEventType() + " event");
    }
}
