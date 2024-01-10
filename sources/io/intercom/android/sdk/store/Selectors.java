package io.intercom.android.sdk.store;

import io.intercom.android.sdk.models.ComposerSuggestions;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.state.InboxState;
import io.intercom.android.sdk.state.MessengerState;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.ProgrammaticCarouselState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;

public class Selectors {
    public static final Store.Selector<State, Boolean> APP_IS_BACKGROUNDED = new Store.Selector<State, Boolean>() {
        public Boolean transform(State state) {
            return Boolean.valueOf(state.hostAppState().isBackgrounded());
        }
    };
    public static final Store.Selector<State, ComposerSuggestions> COMPOSER_SUGGESTIONS = new Store.Selector<State, ComposerSuggestions>() {
        public ComposerSuggestions transform(State state) {
            return state.composerSuggestions();
        }
    };
    public static final Store.Selector<State, InboxState> INBOX = new Store.Selector<State, InboxState>() {
        public InboxState transform(State state) {
            return state.inboxState();
        }
    };
    public static final Store.Selector<State, MessengerState> MESSENGER_STATE = new Store.Selector<State, MessengerState>() {
        public MessengerState transform(State state) {
            return state.messengerState();
        }
    };
    public static final Store.Selector<State, OverlayState> OVERLAY = new Store.Selector<State, OverlayState>() {
        public OverlayState transform(State state) {
            return state.overlayState();
        }
    };
    public static final Store.Selector<State, ProgrammaticCarouselState> PROGRAMMATIC_CAROUSEL_STATE = $$Lambda$mtd0puWsfmWoTIfw2NvrIx7si0.INSTANCE;
    public static final Store.Selector<State, Boolean> SESSION_STARTED_SINCE_LAST_BACKGROUNDED = new Store.Selector<State, Boolean>() {
        public Boolean transform(State state) {
            return Boolean.valueOf(state.hostAppState().sessionStartedSinceLastBackgrounded());
        }
    };
    public static final Store.Selector<State, TeamPresence> TEAM_PRESENCE = new Store.Selector<State, TeamPresence>() {
        public TeamPresence transform(State state) {
            return state.teamPresence();
        }
    };
    public static final Store.Selector<State, Integer> UNREAD_COUNT = new Store.Selector<State, Integer>() {
        public Integer transform(State state) {
            return Integer.valueOf(state.unreadConversationIds().size());
        }
    };
}
