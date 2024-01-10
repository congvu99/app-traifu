package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.models.ComposerSuggestions;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.state.ActiveConversationState;
import io.intercom.android.sdk.state.BotIntroState;
import io.intercom.android.sdk.state.HostAppState;
import io.intercom.android.sdk.state.InboxState;
import io.intercom.android.sdk.state.MessengerState;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.ProgrammaticCarouselState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.state.SurveyState;
import io.intercom.android.sdk.state.TicketLegacyState;
import io.intercom.android.sdk.state.UiState;
import io.intercom.android.sdk.store.Store;
import java.util.Set;

class StateReducer implements Store.Reducer<State> {
    private final Store.Reducer<ActiveConversationState> activeConversationStateReducer;
    private final Store.Reducer<BotIntroState> botIntroStateReducer;
    private final Store.Reducer<ComposerSuggestions> composerSuggestionsReducer;
    private final Store.Reducer<Boolean> hasConversationsReducer;
    private final Store.Reducer<HostAppState> hostAppStateReducer;
    private final Store.Reducer<InboxState> inboxStateReducer;
    private final Store.Reducer<MessengerState> messengerStateReducer;
    private final Store.Reducer<OverlayState> overlayStateReducer;
    private final Store.Reducer<ProgrammaticCarouselState> programmaticCarouselStateReducer;
    private final Store.Reducer<SurveyState> surveyStateReducer;
    private final Store.Reducer<TeamPresence> teamPresenceReducer;
    private Store.Reducer<TicketLegacyState> ticketLegacyStateReducer;
    private final Store.Reducer<UiState> uiStateReducer;
    private final Store.Reducer<Set<String>> unreadConversationIdsReducer;

    StateReducer(Store.Reducer<Boolean> reducer, Store.Reducer<UiState> reducer2, Store.Reducer<TeamPresence> reducer3, Store.Reducer<Set<String>> reducer4, Store.Reducer<InboxState> reducer5, Store.Reducer<HostAppState> reducer6, Store.Reducer<OverlayState> reducer7, Store.Reducer<ActiveConversationState> reducer8, Store.Reducer<ComposerSuggestions> reducer9, Store.Reducer<MessengerState> reducer10, Store.Reducer<ProgrammaticCarouselState> reducer11, Store.Reducer<BotIntroState> reducer12, Store.Reducer<SurveyState> reducer13, Store.Reducer<TicketLegacyState> reducer14) {
        this.hasConversationsReducer = reducer;
        this.uiStateReducer = reducer2;
        this.teamPresenceReducer = reducer3;
        this.unreadConversationIdsReducer = reducer4;
        this.inboxStateReducer = reducer5;
        this.hostAppStateReducer = reducer6;
        this.overlayStateReducer = reducer7;
        this.activeConversationStateReducer = reducer8;
        this.composerSuggestionsReducer = reducer9;
        this.messengerStateReducer = reducer10;
        this.programmaticCarouselStateReducer = reducer11;
        this.botIntroStateReducer = reducer12;
        this.surveyStateReducer = reducer13;
        this.ticketLegacyStateReducer = reducer14;
    }

    public State reduce(Action<?> action, State state) {
        Action<?> action2 = action;
        return State.create(this.hasConversationsReducer.reduce(action2, Boolean.valueOf(state.hasConversations())).booleanValue(), this.uiStateReducer.reduce(action2, state.uiState()), this.teamPresenceReducer.reduce(action2, state.teamPresence()), this.unreadConversationIdsReducer.reduce(action2, state.unreadConversationIds()), this.inboxStateReducer.reduce(action2, state.inboxState()), this.hostAppStateReducer.reduce(action2, state.hostAppState()), this.overlayStateReducer.reduce(action2, state.overlayState()), this.activeConversationStateReducer.reduce(action2, state.activeConversationState()), this.composerSuggestionsReducer.reduce(action2, state.composerSuggestions()), this.messengerStateReducer.reduce(action2, state.messengerState()), this.programmaticCarouselStateReducer.reduce(action2, state.programmaticCarouselState()), this.botIntroStateReducer.reduce(action2, state.botIntroState()), this.surveyStateReducer.reduce(action2, state.surveyState()), this.ticketLegacyStateReducer.reduce(action2, state.ticketLegacyState()));
    }
}
