package io.intercom.android.sdk.state;

import io.intercom.android.sdk.models.ComposerSuggestions;
import io.intercom.android.sdk.models.TeamPresence;
import java.util.Set;

final class AutoValue_State extends State {
    private final ActiveConversationState activeConversationState;
    private final BotIntroState botIntroState;
    private final ComposerSuggestions composerSuggestions;
    private final boolean hasConversations;
    private final HostAppState hostAppState;
    private final InboxState inboxState;
    private final MessengerState messengerState;
    private final OverlayState overlayState;
    private final ProgrammaticCarouselState programmaticCarouselState;
    private final SurveyState surveyState;
    private final TeamPresence teamPresence;
    private final TicketLegacyState ticketLegacyState;
    private final UiState uiState;
    private final Set<String> unreadConversationIds;

    AutoValue_State(boolean z, UiState uiState2, TeamPresence teamPresence2, Set<String> set, InboxState inboxState2, HostAppState hostAppState2, OverlayState overlayState2, ActiveConversationState activeConversationState2, ComposerSuggestions composerSuggestions2, MessengerState messengerState2, ProgrammaticCarouselState programmaticCarouselState2, BotIntroState botIntroState2, SurveyState surveyState2, TicketLegacyState ticketLegacyState2) {
        this.hasConversations = z;
        if (uiState2 != null) {
            this.uiState = uiState2;
            if (teamPresence2 != null) {
                this.teamPresence = teamPresence2;
                if (set != null) {
                    this.unreadConversationIds = set;
                    if (inboxState2 != null) {
                        this.inboxState = inboxState2;
                        if (hostAppState2 != null) {
                            this.hostAppState = hostAppState2;
                            if (overlayState2 != null) {
                                this.overlayState = overlayState2;
                                if (activeConversationState2 != null) {
                                    this.activeConversationState = activeConversationState2;
                                    if (composerSuggestions2 != null) {
                                        this.composerSuggestions = composerSuggestions2;
                                        if (messengerState2 != null) {
                                            this.messengerState = messengerState2;
                                            if (programmaticCarouselState2 != null) {
                                                this.programmaticCarouselState = programmaticCarouselState2;
                                                if (botIntroState2 != null) {
                                                    this.botIntroState = botIntroState2;
                                                    if (surveyState2 != null) {
                                                        this.surveyState = surveyState2;
                                                        if (ticketLegacyState2 != null) {
                                                            this.ticketLegacyState = ticketLegacyState2;
                                                            return;
                                                        }
                                                        throw new NullPointerException("Null ticketLegacyState");
                                                    }
                                                    throw new NullPointerException("Null surveyState");
                                                }
                                                throw new NullPointerException("Null botIntroState");
                                            }
                                            throw new NullPointerException("Null programmaticCarouselState");
                                        }
                                        throw new NullPointerException("Null messengerState");
                                    }
                                    throw new NullPointerException("Null composerSuggestions");
                                }
                                throw new NullPointerException("Null activeConversationState");
                            }
                            throw new NullPointerException("Null overlayState");
                        }
                        throw new NullPointerException("Null hostAppState");
                    }
                    throw new NullPointerException("Null inboxState");
                }
                throw new NullPointerException("Null unreadConversationIds");
            }
            throw new NullPointerException("Null teamPresence");
        }
        throw new NullPointerException("Null uiState");
    }

    public boolean hasConversations() {
        return this.hasConversations;
    }

    public UiState uiState() {
        return this.uiState;
    }

    public TeamPresence teamPresence() {
        return this.teamPresence;
    }

    public Set<String> unreadConversationIds() {
        return this.unreadConversationIds;
    }

    public InboxState inboxState() {
        return this.inboxState;
    }

    public HostAppState hostAppState() {
        return this.hostAppState;
    }

    public OverlayState overlayState() {
        return this.overlayState;
    }

    public ActiveConversationState activeConversationState() {
        return this.activeConversationState;
    }

    public ComposerSuggestions composerSuggestions() {
        return this.composerSuggestions;
    }

    public MessengerState messengerState() {
        return this.messengerState;
    }

    public ProgrammaticCarouselState programmaticCarouselState() {
        return this.programmaticCarouselState;
    }

    public BotIntroState botIntroState() {
        return this.botIntroState;
    }

    public SurveyState surveyState() {
        return this.surveyState;
    }

    public TicketLegacyState ticketLegacyState() {
        return this.ticketLegacyState;
    }

    public String toString() {
        return "State{hasConversations=" + this.hasConversations + ", uiState=" + this.uiState + ", teamPresence=" + this.teamPresence + ", unreadConversationIds=" + this.unreadConversationIds + ", inboxState=" + this.inboxState + ", hostAppState=" + this.hostAppState + ", overlayState=" + this.overlayState + ", activeConversationState=" + this.activeConversationState + ", composerSuggestions=" + this.composerSuggestions + ", messengerState=" + this.messengerState + ", programmaticCarouselState=" + this.programmaticCarouselState + ", botIntroState=" + this.botIntroState + ", surveyState=" + this.surveyState + ", ticketLegacyState=" + this.ticketLegacyState + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof State)) {
            return false;
        }
        State state = (State) obj;
        if (this.hasConversations != state.hasConversations() || !this.uiState.equals(state.uiState()) || !this.teamPresence.equals(state.teamPresence()) || !this.unreadConversationIds.equals(state.unreadConversationIds()) || !this.inboxState.equals(state.inboxState()) || !this.hostAppState.equals(state.hostAppState()) || !this.overlayState.equals(state.overlayState()) || !this.activeConversationState.equals(state.activeConversationState()) || !this.composerSuggestions.equals(state.composerSuggestions()) || !this.messengerState.equals(state.messengerState()) || !this.programmaticCarouselState.equals(state.programmaticCarouselState()) || !this.botIntroState.equals(state.botIntroState()) || !this.surveyState.equals(state.surveyState()) || !this.ticketLegacyState.equals(state.ticketLegacyState())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.hasConversations ? 1231 : 1237) ^ 1000003) * 1000003) ^ this.uiState.hashCode()) * 1000003) ^ this.teamPresence.hashCode()) * 1000003) ^ this.unreadConversationIds.hashCode()) * 1000003) ^ this.inboxState.hashCode()) * 1000003) ^ this.hostAppState.hashCode()) * 1000003) ^ this.overlayState.hashCode()) * 1000003) ^ this.activeConversationState.hashCode()) * 1000003) ^ this.composerSuggestions.hashCode()) * 1000003) ^ this.messengerState.hashCode()) * 1000003) ^ this.programmaticCarouselState.hashCode()) * 1000003) ^ this.botIntroState.hashCode()) * 1000003) ^ this.surveyState.hashCode()) * 1000003) ^ this.ticketLegacyState.hashCode();
    }
}
