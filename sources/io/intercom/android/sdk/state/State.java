package io.intercom.android.sdk.state;

import io.intercom.android.sdk.models.ComposerSuggestions;
import io.intercom.android.sdk.models.TeamPresence;
import java.util.Set;

public abstract class State {
    public abstract ActiveConversationState activeConversationState();

    public abstract BotIntroState botIntroState();

    public abstract ComposerSuggestions composerSuggestions();

    public abstract boolean hasConversations();

    public abstract HostAppState hostAppState();

    public abstract InboxState inboxState();

    public abstract MessengerState messengerState();

    public abstract OverlayState overlayState();

    public abstract ProgrammaticCarouselState programmaticCarouselState();

    public abstract SurveyState surveyState();

    public abstract TeamPresence teamPresence();

    public abstract TicketLegacyState ticketLegacyState();

    public abstract UiState uiState();

    public abstract Set<String> unreadConversationIds();

    public static State create(boolean z, UiState uiState, TeamPresence teamPresence, Set<String> set, InboxState inboxState, HostAppState hostAppState, OverlayState overlayState, ActiveConversationState activeConversationState, ComposerSuggestions composerSuggestions, MessengerState messengerState, ProgrammaticCarouselState programmaticCarouselState, BotIntroState botIntroState, SurveyState surveyState, TicketLegacyState ticketLegacyState) {
        return new AutoValue_State(z, uiState, teamPresence, set, inboxState, hostAppState, overlayState, activeConversationState, composerSuggestions, messengerState, programmaticCarouselState, botIntroState, surveyState, ticketLegacyState);
    }
}
