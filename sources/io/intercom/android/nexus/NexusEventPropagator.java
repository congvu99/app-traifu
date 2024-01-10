package io.intercom.android.nexus;

import android.util.LruCache;
import com.intercom.twig.Twig;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class NexusEventPropagator implements NexusListener {
    private final LruCache<String, Boolean> cache = new LruCache<>(100);
    private final List<NexusListener> listeners = new CopyOnWriteArrayList();
    private final Twig twig;

    public NexusEventPropagator(Twig twig2) {
        this.twig = twig2;
    }

    /* access modifiers changed from: package-private */
    public void addListener(NexusListener nexusListener) {
        this.listeners.add(nexusListener);
    }

    /* access modifiers changed from: package-private */
    public void removeListener(NexusListener nexusListener) {
        this.listeners.remove(nexusListener);
    }

    /* access modifiers changed from: package-private */
    public void cacheEvent(NexusEvent nexusEvent) {
        this.cache.put(nexusEvent.getGuid(), true);
    }

    public void notifyEvent(NexusEvent nexusEvent) {
        if (nexusEvent.getEventType() != NexusEventType.UNKNOWN) {
            synchronized (this.cache) {
                if (this.cache.get(nexusEvent.getGuid()) == null) {
                    this.cache.put(nexusEvent.getGuid(), true);
                    Twig twig2 = this.twig;
                    twig2.internal("notifying listeners of event: " + nexusEvent.getEventType());
                    for (NexusListener notifyEvent : this.listeners) {
                        notifyEvent.notifyEvent(nexusEvent);
                    }
                } else {
                    Twig twig3 = this.twig;
                    twig3.internal("dropping event, already in cache: " + nexusEvent.toStringEncodedJsonObject());
                }
            }
        }
    }

    public void onConnect() {
        this.twig.d("notifying listeners that a connection opened", new Object[0]);
        for (NexusListener onConnect : this.listeners) {
            onConnect.onConnect();
        }
    }

    public void onConnectFailed() {
        this.twig.d("notifying listeners that a connection failed to open", new Object[0]);
        for (NexusListener onConnectFailed : this.listeners) {
            onConnectFailed.onConnectFailed();
        }
    }

    public void onShutdown() {
        this.twig.d("notifying listeners that a connection has shutdown", new Object[0]);
        for (NexusListener onShutdown : this.listeners) {
            onShutdown.onShutdown();
        }
    }
}
