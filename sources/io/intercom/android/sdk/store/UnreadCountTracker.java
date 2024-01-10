package io.intercom.android.sdk.store;

import io.intercom.android.sdk.UnreadConversationCountListener;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UnreadCountTracker {
    final Map<UnreadConversationCountListener, Store.Subscription> listeners = new ConcurrentHashMap();
    private final Store<State> store;

    public UnreadCountTracker(Store<State> store2) {
        this.store = store2;
    }

    public void addListener(final UnreadConversationCountListener unreadConversationCountListener) {
        this.listeners.put(unreadConversationCountListener, this.store.subscribeToChanges(Selectors.UNREAD_COUNT, new Store.Subscriber<Integer>() {
            public void onStateChange(Integer num) {
                unreadConversationCountListener.onCountUpdate(num.intValue());
            }
        }));
    }

    public void removeListener(UnreadConversationCountListener unreadConversationCountListener) {
        if (this.listeners.containsKey(unreadConversationCountListener)) {
            this.listeners.remove(unreadConversationCountListener).unsubscribe();
        }
    }
}