package io.intercom.android.sdk.actions;

import android.app.Activity;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.models.BotIntro;
import io.intercom.android.sdk.models.ComposerSuggestions;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.ConversationsResponse;
import io.intercom.android.sdk.models.HomeCardsResponse;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.models.UsersResponse;
import io.intercom.android.sdk.models.carousel.Carousel;
import io.intercom.android.sdk.models.events.failure.FetchCarouselFailedEvent;
import io.intercom.android.sdk.state.ReplyPart;
import io.intercom.android.sdk.survey.model.SurveyData;

public class Actions {
    private static final Object NONE = "No Value";

    public static Action<BaseResponse> baseResponseReceived(BaseResponse baseResponse) {
        return new Action<>(Action.Type.BASE_RESPONSE_RECEIVED, baseResponse);
    }

    public static Action<?> softReset() {
        return noValueAction(Action.Type.SOFT_RESET);
    }

    public static Action<?> hardReset() {
        return noValueAction(Action.Type.HARD_RESET);
    }

    public static Action<Conversation> newConversationSuccess(Conversation conversation) {
        return new Action<>(Action.Type.NEW_CONVERSATION_SUCCESS, conversation);
    }

    public static Action<?> inboxOpened() {
        return noValueAction(Action.Type.INBOX_OPENED);
    }

    public static Action<?> homeOpened() {
        return noValueAction(Action.Type.HOME_OPENED);
    }

    public static Action<?> composerOpened() {
        return noValueAction(Action.Type.NEW_CONVERSATION_SCREEN_OPENED);
    }

    public static Action<?> composerInputChanged() {
        return noValueAction(Action.Type.COMPOSER_INPUT_CHANGED);
    }

    public static Action<?> composerSendButtonPressed() {
        return noValueAction(Action.Type.COMPOSER_SEND_BUTTON_PRESSED);
    }

    public static Action<String> composerSuggestionSelected(String str) {
        return new Action<>(Action.Type.COMPOSER_SUGGESTION_SELECTED, str);
    }

    public static Action<String> conversationOpened(String str) {
        return new Action<>(Action.Type.CONVERSATION_OPENED, str);
    }

    public static Action<?> conversationClosed() {
        return noValueAction(Action.Type.CONVERSATION_CLOSED);
    }

    public static Action<String> conversationMarkedAsRead(String str) {
        return new Action<>(Action.Type.CONVERSATION_MARKED_AS_READ, str);
    }

    public static Action<Conversation> conversationMarkedAsDismissed(Conversation conversation) {
        return new Action<>(Action.Type.CONVERSATION_MARKED_AS_DISMISSED, conversation);
    }

    public static Action<UsersResponse> unreadConversationsSuccess(UsersResponse usersResponse) {
        return new Action<>(Action.Type.UNREAD_CONVERSATIONS_SUCCESS, usersResponse);
    }

    public static Action<?> fetchInboxRequest() {
        return noValueAction(Action.Type.FETCH_INBOX_REQUEST);
    }

    public static Action<Long> fetchInboxBeforeDateRequest(long j) {
        return new Action<>(Action.Type.FETCH_INBOX_BEFORE_DATE_REQUEST, Long.valueOf(j));
    }

    public static Action<?> fetchInboxFailed() {
        return noValueAction(Action.Type.FETCH_INBOX_FAILED);
    }

    public static Action<ConversationsResponse> fetchInboxSuccess(ConversationsResponse conversationsResponse) {
        return new Action<>(Action.Type.FETCH_INBOX_SUCCESS, conversationsResponse);
    }

    public static Action<HomeCardsResponse> fetchHomeCardsSuccess(HomeCardsResponse homeCardsResponse) {
        return new Action<>(Action.Type.FETCH_HOME_CARDS_SUCCESS, homeCardsResponse);
    }

    public static Action<Conversation> fetchConversationSuccess(Conversation conversation) {
        return new Action<>(Action.Type.FETCH_CONVERSATION_SUCCESS, conversation);
    }

    public static Action<TeamPresence> teamPresenceUpdated(TeamPresence teamPresence) {
        return new Action<>(Action.Type.TEAM_PRESENCE_UPDATED, teamPresence);
    }

    public static Action<ReplyPart> conversationReplySuccess(ReplyPart replyPart) {
        return new Action<>(Action.Type.CONVERSATION_REPLY_SUCCESS, replyPart);
    }

    public static Action<Intercom.Visibility> setInAppNotificationVisibility(Intercom.Visibility visibility) {
        return new Action<>(Action.Type.SET_IN_APP_NOTIFICATION_VISIBILITY, visibility);
    }

    public static Action<Intercom.Visibility> setLauncherVisibility(Intercom.Visibility visibility) {
        return new Action<>(Action.Type.SET_LAUNCHER_VISIBILITY, visibility);
    }

    public static Action<String> newCommentEventReceived(String str) {
        return new Action<>(Action.Type.NEW_COMMENT_EVENT_RECEIVED, str);
    }

    public static Action<Integer> setBottomPadding(int i) {
        return new Action<>(Action.Type.SET_BOTTOM_PADDING, Integer.valueOf(i));
    }

    public static Action<String> composerTypedIn(String str) {
        return new Action<>(Action.Type.COMPOSER_TYPED_IN, str);
    }

    public static Action<String> composerCleared(String str) {
        return new Action<>(Action.Type.COMPOSER_CLEARED, str);
    }

    public static Action<ComposerSuggestions> composerSuggestionsUpdated(ComposerSuggestions composerSuggestions) {
        return new Action<>(Action.Type.COMPOSER_SUGGESTIONS_UPDATED, composerSuggestions);
    }

    public static Action<Carousel> carouselUpdated(Carousel carousel) {
        return new Action<>(Action.Type.CAROUSEL_UPDATED, carousel);
    }

    public static Action<?> surveyDismissed() {
        return noValueAction(Action.Type.SURVEY_DISMISSED);
    }

    public static Action<?> carouselDismissed() {
        return noValueAction(Action.Type.CAROUSEL_DISMISSED);
    }

    public static Action<?> openProgrammaticCarousel(String str) {
        return new Action<>(Action.Type.OPEN_PROGRAMMATIC_CAROUSEL, str);
    }

    public static Action<?> programmaticCarouselLoading(String str) {
        return new Action<>(Action.Type.PROGRAMMATIC_CAROUSEL_LOADING, str);
    }

    public static Action<?> programmaticCarouselSuccess(Carousel carousel) {
        return new Action<>(Action.Type.PROGRAMMATIC_CAROUSEL_SUCCESS, carousel);
    }

    public static Action<?> programmaticCarouselError(FetchCarouselFailedEvent fetchCarouselFailedEvent) {
        return new Action<>(Action.Type.PROGRAMMATIC_CAROUSEL_ERROR, fetchCarouselFailedEvent);
    }

    public static Action<?> messengerOpened() {
        return noValueAction(Action.Type.MESSENGER_OPENED);
    }

    public static Action<?> messengerClosed() {
        return noValueAction(Action.Type.MESSENGER_CLOSED);
    }

    public static Action<Long> appEnteredForeground(long j) {
        return new Action<>(Action.Type.APP_ENTERED_FOREGROUND, Long.valueOf(j));
    }

    public static Action<Activity> activityReadyForViewAttachment(Activity activity) {
        return new Action<>(Action.Type.ACTIVITY_READY_FOR_VIEW_ATTACHMENT, activity);
    }

    public static Action<Activity> activityPaused(Activity activity) {
        return new Action<>(Action.Type.ACTIVITY_PAUSED, activity);
    }

    public static Action<Activity> activityStopped(Activity activity) {
        return new Action<>(Action.Type.ACTIVITY_STOPPED, activity);
    }

    public static Action<Long> appEnteredBackground(long j) {
        return new Action<>(Action.Type.APP_ENTERED_BACKGROUND, Long.valueOf(j));
    }

    public static Action<?> sessionStarted() {
        return noValueAction(Action.Type.SESSION_STARTED);
    }

    private static Action<?> noValueAction(Action.Type type) {
        return new Action<>(type, NONE);
    }

    public static Action<?> botIntroUpdated(BotIntro botIntro) {
        return new Action<>(Action.Type.BOT_INTRO_UPDATED, botIntro);
    }

    public static Action<?> surveyUpdated(SurveyData surveyData) {
        return new Action<>(Action.Type.SURVEY_UPDATED, surveyData);
    }
}
