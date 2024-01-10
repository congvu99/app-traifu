package io.intercom.android.sdk.metrics;

import com.intercom.commons.utilities.DeviceUtils;
import com.intercom.commons.utilities.TimeProvider;
import io.intercom.android.sdk.BuildConfig;
import io.intercom.android.sdk.IntercomContent;
import io.intercom.android.sdk.IntercomSpace;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.overlay.LauncherOpenBehaviour;
import io.intercom.android.sdk.profile.ProfilePresenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MetricTracker {
    static final String METADATA_BADGE_VALUE = "badge_value";
    static final String METADATA_CLOSED_CONVERSATION_ID = "closed_conversation_id";
    static final String METADATA_COMMENT_ID = "comment_id";
    static final String METADATA_CONTENT_TYPE = "content_type";
    static final String METADATA_CONVERSATION_ID = "conversation_id";
    static final String METADATA_ERROR = "error";
    static final String METADATA_FILTERED = "filtered";
    static final String METADATA_HAS_ARTICLE_CARD = "has_article_card";
    static final String METADATA_HOME_SCREEN_INDEX = "home_screen_index";
    static final String METADATA_INSTANCE_ID = "instance_id";
    static final String METADATA_IS_ATTACHMENT = "is_attachment";
    static final String METADATA_IS_GIF = "is_gif";
    static final String METADATA_MAX_STEPS = "max_steps";
    static final String METADATA_MESSAGE_ID = "message_id";
    static final String METADATA_MESSAGE_TYPE = "message_type";
    static final String METADATA_PART_ID = "part_id";
    static final String METADATA_PERMISSION_GRANTED = "permission_granted";
    static final String METADATA_PLATFORM = "platform";
    static final String METADATA_PUSH_TYPE = "push_type";
    static final String METADATA_QUICK_REPLY_ID = "quick_reply_id";
    static final String METADATA_REACTION_INDEX = "reaction_index";
    static final String METADATA_REQUEST_CONTENT_ID = "requested_content_id";
    static final String METADATA_REQUEST_ERROR_CODE = "error_code";
    static final String METADATA_SCREENS_IN_MESSAGE = "screens_in_message";
    static final String METADATA_SCREENS_SEEN = "screens_seen";
    static final String METADATA_SCREENS_SHOWN = "screens_shown";
    static final String METADATA_SEARCH_QUERY = "search_query";
    static final String METADATA_SOURCE = "source";
    static final String METADATA_SPACE = "space";
    static final String METADATA_STEPS_COMPLETE = "steps_complete";
    static final String METADATA_SUGGESTION_ID = "suggestion_id";
    static final String METADATA_SURVEY_FORMAT = "format";
    static final String METADATA_SURVEY_ID = "survey_id";
    static final String METADATA_TEAMMATE_STATUS = "teammate_status";
    static final String METADATA_TIME_SINCE_LAST_ACTIVE = "time_since_last_active";
    static final String METADATA_URL = "url";
    static final String METADATA_VIDEO_HEIGHT = "video_height";
    static final String METADATA_VIDEO_URL = "video_url";
    static final String METADATA_VIDEO_WIDTH = "video_width";
    static final String METADATA_WITHIN_OFFICE_HOURS = "within_office_hours";
    static final String QUESTIONS_SEEN = "questions_seen";
    static final String TICKET_STATUS = "ticket_status";
    static final String TICKET_TYPE_ID = "ticket_type_id";
    static final String VALUE_ACTIVE = "active";
    static final String VALUE_ANDROID_SDK = "android-sdk";
    static final String VALUE_AWAY = "away";
    static final String VALUE_MESSAGE = "message";
    static final String VALUE_NOTIFICATION = "notification";
    private final String appVersion;
    private final String sdkVersion;
    private final MetricsStore store;
    private final TimeProvider timeProvider;
    private final UserIdentity userIdentity;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Action {
        public static final String CLICKED = "clicked";
        public static final String CLOSED = "closed";
        public static final String COMPLETED = "completed";
        public static final String DISMISSED = "dismissed";
        public static final String FAILED = "failed";
        public static final String LOADED = "loaded";
        public static final String OPENED = "opened";
        public static final String RECEIVED = "received";
        public static final String REQUESTED = "requested";
        public static final String SEARCHED = "searched";
        public static final String SENT = "sent";
        public static final String STARTED = "started";
        public static final String SUBMITTED = "submitted";
        public static final String TYPED = "typed";
        public static final String USED = "used";
        public static final String VIEWED = "viewed";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CarouselSource {
        public static final String AUTOMATIC = "automatic";
        public static final String PROGRAMMATIC = "programmatic";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CloseActionContext {
        public static final int BACK_BUTTON = 1;
        public static final int CLOSE_BUTTON = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Context {
        public static final String ARTICLE = "article";
        public static final String CONVERSATION = "conversation";
        public static final String FROM_ANDROID_BACK_BUTTON = "from_android_back_button";
        public static final String FROM_ARTICLE_ON_BUTTON = "from_article_on_button";
        public static final String FROM_AUTO = "from_auto";
        public static final String FROM_AUTOMATIC = "from_automatic";
        public static final String FROM_CAROUSEL = "from_carousel";
        public static final String FROM_CLICKING = "from_clicking";
        public static final String FROM_CLOSED_CONVERSATION = "from_closed_conversation";
        public static final String FROM_CLOSE_BUTTON = "from_close_button";
        public static final String FROM_CONVERSATION = "from_conversation";
        public static final String FROM_CONVERSATION_LIST = "from_conversation_list";
        public static final String FROM_CTA = "from_cta";
        public static final String FROM_CUSTOM_LAUNCHER = "from_custom_launcher";
        public static final String FROM_FULL = "from_full";
        public static final String FROM_HELP_CENTER_WEBVIEW = "from_help_center_webview";
        public static final String FROM_LAUNCHER = "from_launcher";
        public static final String FROM_NEW_CONVERSATION = "from_new_conversation";
        public static final String FROM_ONWARD_DEEP_LINK = "from_onward_deep_link";
        public static final String FROM_ONWARD_EXTERNAL_LINK = "from_onward_external_link";
        public static final String FROM_PERMISSION = "from_permission";
        public static final String FROM_PERMISSION_SKIPPED = "from_permission_skipped";
        public static final String FROM_PROGRAMMATIC = "from_programmatic";
        public static final String FROM_PUSH = "from_push";
        public static final String FROM_RETRY = "from_retry";
        public static final String FROM_SCROLLING = "from_scrolling";
        public static final String FROM_SNIPPET = "from_snippet";
        public static final String HOME_SCREEN = "home_screen";
        public static final String IN_CONVERSATION = "in_conversation";
        public static final String IN_FOLLOWUP_CONVERSATION = "in_followup_conversation";
        public static final String IN_NEW_CONVERSATION = "in_new_conversation";
        public static final String MESSENGER = "messenger";
        public static final String NO_CONTEXT = "no_context";
        public static final String ON_ARTICLE = "on_article";
        public static final String REACTION_HAPPY = "reaction_happy";
        public static final String REACTION_NEUTRAL = "reaction_neutral";
        public static final String REACTION_SAD = "reaction_sad";
        public static final String SPACE_HELP = "help";
        public static final String SPACE_HOME = "home";
        public static final String SPACE_MESSAGES = "messages";
        public static final String STYLE_BOT = "style_bot";
        public static final String STYLE_HUMAN = "style_human";
    }

    public @interface InAppMessageViewContext {
        public static final int FULL = 1;
        public static final int SNIPPET = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Name {
        public static final String CAROUSEL = "carousel_metric";
        public static final String EDUCATE = "educate_event";
        public static final String MESSENGER = "m5_metric";
        public static final String SEARCH_BROWSE = "search_browse_event";
        public static final String SURVEY = "survey_metric";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Object {
        public static final String ADD_UNREAD_CONVERSATION_COUNT_LISTENER = "add_unread_conversation_count_listener";
        public static final String ARTICLE = "article";
        public static final String ARTICLE_REACTION = "article_reaction";
        public static final String ARTICLE_SUGGESTION = "article_suggestion";
        public static final String ARTICLE_SUGGESTIONS = "article_suggestions";
        public static final String BADGE = "badge";
        public static final String CAROUSEL_MESSAGE = "carousel_message";
        public static final String CAROUSEL_MESSAGE_PRELOAD = "carousel_message_preload";
        public static final String CAROUSEL_PERMISSION_DIALOG = "carousel_permission_dialog";
        public static final String CAROUSEL_PERMISSION_SETTINGS = "carousel_permission_settings";
        public static final String CAROUSEL_PERMISSION_SKIPPED = "carousel_permission_skipped";
        public static final String COMPOSER_SUGGESTIONS = "composer_suggestions";
        public static final String CONVERSATION = "conversation";
        public static final String CONVERSATION_LIST = "conversation_list";
        public static final String CREATE_TICKET_FORM = "create_ticket_form";
        public static final String ENABLE_LOGGING = "enable_logging";
        public static final String EXPANDED_GIF_INPUT = "expanded_gif_input";
        public static final String EXPANDED_IMAGE_INPUT = "expanded_image_input";
        public static final String EXTERNAL_LINK = "external_link";
        public static final String FETCH_HELPCENTER_COLLECTION = "fetch_help_center_collection";
        public static final String FETCH_HELPCENTER_COLLECTIONS = "fetch_help_center_collections";
        public static final String GIF_INPUT = "gif_input";
        public static final String HANDLE_PUSH_NOTIFICATION = "handle_push_notification";
        public static final String HANDLE_PUSH_NOTIFICATION_CUSTOM = "handle_push_notification_custom";
        public static final String HELP_CENTER = "help_center";
        public static final String HELP_CENTER_DATA_API = "help_center_data";
        public static final String HIDE_INTERCOM = "hide_intercom";
        public static final String IMAGE_INPUT = "image_input";
        public static final String INITIALISE = "initialise";
        public static final String INPUT = "input";
        public static final String LAUNCHER = "launcher";
        public static final String LOGIN_IDENTIFIED_USER = "login_identified_user";
        public static final String LOGIN_UNIDENTIFIED_USER = "login_unidentified_user";
        public static final String LOGOUT = "logout";
        public static final String LOG_EVENT = "log_event";
        public static final String LOG_EVENT_METADATA = "log_event_metadata";
        public static final String MESSAGE = "message";
        public static final String MESSENGER = "messenger";
        public static final String MESSENGER_SHEET = "messenger_sheet";
        public static final String NEW_CONVERSATION = "new_conversation";
        public static final String OPERATOR_REPLY = "operator_reply";
        public static final String PRESENT_ARTICLE = "present_articles";
        public static final String PRESENT_CAROUSEL = "present_carousel";
        public static final String PRESENT_CONVERSATION_LIST = "present_conversation_list";
        public static final String PRESENT_HELP_CENTER = "present_help_center";
        public static final String PRESENT_HELP_CENTER_COLLECTIONS = "present_help_center_collections";
        public static final String PRESENT_INTERCOM = "present_intercom";
        public static final String PRESENT_INTERCOM_CONTENT = "present_intercom_content";
        public static final String PRESENT_MESSAGE_COMPOSER = "present_message_composer";
        public static final String PRESENT_MESSAGE_COMPOSER_INITIAL_MESSAGE = "present_message_composer_initial_message";
        public static final String PRESENT_MESSENGER = "present_messenger";
        public static final String PRESENT_SURVEY = "present_survey";
        public static final String QUICK_REPLIES = "quick_replies";
        public static final String QUICK_REPLY = "quick_reply";
        public static final String REACTION = "reaction";
        public static final String REGISTER_IDENTIFIED_USER = "register_identified_user";
        public static final String REGISTER_LATER_INIT = "register_later_init";
        public static final String REGISTER_UNIDENTIFIED_USER = "register_unidentified_user";
        public static final String REMOVE_UNREAD_CONVERSATION_COUNT_LISTENER = "remove_unread_conversation_count_listener";
        public static final String REPLY = "reply";
        public static final String RESET = "reset";
        public static final String SEARCH_BROWSE_CARD = "search_browse_card";
        public static final String SEARCH_BROWSE_CARD_INPUT = "search_browse_card_input";
        public static final String SEARCH_HELP_CENTER = "search_help_center";
        public static final String SET_BOTTOM_PADDING = "set_bottom_padding";
        public static final String SET_INAPP_MESSAGE_VISIBILITY = "set_inapp_message_visibility";
        public static final String SET_LAUNCHER_VISIBILITY = "set_launcher_visibility";
        public static final String SPACE_HELP = "help";
        public static final String SPACE_HOME = "home";
        public static final String SPACE_MESSAGES = "messages";
        public static final String SUGGESTION = "suggestion";
        public static final String SURVEY = "survey";
        public static final String SURVEY_STEP_ERROR = "step_error";
        public static final String SURVEY_STEP_LOADING = "step_load";
        public static final String TEAMMATE_PROFILE = "teammate_profile";
        public static final String TEAM_PROFILE = "team_profile";
        public static final String TICKET_DETAILS = "ticket_details";
        public static final String UNREAD_CONVERSATION_COUNT = "unread_conversation_count";
        public static final String UNREGISTER_LATER_INIT = "unregister_later_init";
        public static final String UPDATE_USER = "update_user";
        public static final String UPDATE_USER_CALLBACK = "update_user_callback";
        public static final String USER_HASH = "user_hash";
        public static final String VIDEO_MESSAGE = "video_auto_message";
        public static final String WE_RUN_ON_INTERCOM = "we_run_on_intercom";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Owner {
        public static final String EDUCATE = "educate";
        public static final String MESSENGER = "messenger";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Place {
        public static final String API = "api";
        public static final String ARTICLE = "article";
        public static final String ARTICLE_LIST = "article_list";
        public static final String CAROUSEL_MESSAGE = "carousel_message";
        public static final String COLLECTION_LIST = "collection_list";
        public static final String CONVERSATION = "conversation";
        public static final String HOME_SCREEN = "home";
        public static final String IN_APP = "in_app";
        public static final String LEGACY_ARTICLE_SEARCH_APP = "legacy_article_search_app";
        public static final String MESSENGER = "messenger";
        public static final String MESSENGER_CARD = "messenger_card";
        public static final String MESSENGER_HOME_APP = "messenger_home_app";
        public static final String PUSH = "push";
        public static final String SEARCH_BROWSE = "search_browse";
        public static final String SEARCH_BROWSE_CARD = "search_browse_card";
        public static final String SEARCH_RESULTS = "search_results";
        public static final String SURVEY = "survey";
    }

    public enum ReactionLocation {
        CONVERSATION,
        IN_APP,
        LINK
    }

    private static String contextForInApp(int i) {
        return i == 0 ? Context.FROM_SNIPPET : Context.FROM_FULL;
    }

    public MetricTracker(UserIdentity userIdentity2, MetricsStore metricsStore, android.content.Context context) {
        this(userIdentity2, metricsStore, TimeProvider.SYSTEM, context);
    }

    MetricTracker(UserIdentity userIdentity2, MetricsStore metricsStore, TimeProvider timeProvider2, android.content.Context context) {
        this.userIdentity = userIdentity2;
        this.timeProvider = timeProvider2;
        this.store = metricsStore;
        this.sdkVersion = BuildConfig.VERSION_NAME;
        this.appVersion = DeviceUtils.getAppVersion(context);
    }

    public void openedMessengerConversationList(LauncherOpenBehaviour.LauncherType launcherType) {
        track(newMetric("opened", Object.CONVERSATION_LIST, "messenger", contextFrom(launcherType)));
    }

    public void openedMessengerConversation(String str, LauncherOpenBehaviour.LauncherType launcherType) {
        track(newMetric("opened", "conversation", "messenger", contextFrom(launcherType)).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void openedMessengerNewConversation(LauncherOpenBehaviour.LauncherType launcherType) {
        track(newMetric("opened", Object.NEW_CONVERSATION, "messenger", contextFrom(launcherType)));
    }

    private static String contextFrom(LauncherOpenBehaviour.LauncherType launcherType) {
        return LauncherOpenBehaviour.LauncherType.DEFAULT == launcherType ? Context.FROM_LAUNCHER : Context.FROM_CUSTOM_LAUNCHER;
    }

    public void closedMessengerBackButton() {
        track(newMetric(Action.CLOSED, "messenger", "messenger", Context.FROM_ANDROID_BACK_BUTTON));
    }

    public void closedMessengerCloseButton() {
        track(newMetric(Action.CLOSED, "messenger", "messenger", Context.FROM_CLOSE_BUTTON));
    }

    /* access modifiers changed from: package-private */
    public void typeInNewConversation() {
        track(newMetric(Action.TYPED, "message", "messenger", Context.IN_NEW_CONVERSATION));
    }

    /* access modifiers changed from: package-private */
    public void typeInNewFollowUpConversation(String str) {
        track(newMetric(Action.TYPED, "message", "messenger", Context.FROM_CLOSED_CONVERSATION).addMetaData(METADATA_CLOSED_CONVERSATION_ID, str));
    }

    /* access modifiers changed from: package-private */
    public void typeInConversation(String str) {
        track(newMetric(Action.TYPED, Object.REPLY, "messenger", Context.IN_CONVERSATION).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void sentInNewConversation(boolean z, boolean z2, String str, String str2, boolean z3) {
        track(newMetric(Action.SENT, "message", "messenger", Context.IN_NEW_CONVERSATION).addMetaData(METADATA_IS_ATTACHMENT, Boolean.valueOf(z)).addMetaData(METADATA_IS_GIF, Boolean.valueOf(z2)).addMetaData("message_id", str).addMetaData(METADATA_CONVERSATION_ID, str2).addMetaData(METADATA_WITHIN_OFFICE_HOURS, Boolean.valueOf(z3)));
    }

    public void sentInNewFollowupConversation(boolean z, boolean z2, String str, String str2, boolean z3, String str3) {
        track(newMetric(Action.SENT, "message", "messenger", Context.IN_FOLLOWUP_CONVERSATION).addMetaData(METADATA_IS_ATTACHMENT, Boolean.valueOf(z)).addMetaData(METADATA_IS_GIF, Boolean.valueOf(z2)).addMetaData("message_id", str).addMetaData(METADATA_CONVERSATION_ID, str2).addMetaData(METADATA_WITHIN_OFFICE_HOURS, Boolean.valueOf(z3)).addMetaData(METADATA_CLOSED_CONVERSATION_ID, str3));
    }

    public void sentInConversation(boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, String str3) {
        track(newMetric(Action.SENT, Object.REPLY, "messenger", Context.IN_CONVERSATION).addMetaData(METADATA_IS_ATTACHMENT, Boolean.valueOf(z)).addMetaData(METADATA_IS_GIF, Boolean.valueOf(z2)).addMetaData("message_id", str).addMetaData(METADATA_CONVERSATION_ID, str2).addMetaData(METADATA_WITHIN_OFFICE_HOURS, Boolean.valueOf(z3)).addMetaData(METADATA_TEAMMATE_STATUS, z4 ? "active" : VALUE_AWAY).addMetaData(METADATA_TIME_SINCE_LAST_ACTIVE, str3));
    }

    public void openConversationsListFromNewConversation() {
        track(newMetric("opened", Object.CONVERSATION_LIST, "messenger", Context.FROM_NEW_CONVERSATION));
    }

    public void startConversation(String str) {
        track(newMetric("opened", "conversation", "messenger", Context.FROM_NEW_CONVERSATION).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void startFollowupConversation(String str, String str2) {
        track(newMetric("opened", "conversation", "messenger", Context.IN_FOLLOWUP_CONVERSATION).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData(METADATA_CLOSED_CONVERSATION_ID, str2));
    }

    public void openConversationsListFromConversation(String str) {
        track(newMetric("opened", Object.CONVERSATION_LIST, "messenger", Context.FROM_CONVERSATION).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void openedConversationFromFull(String str, String str2) {
        track(newMetric("opened", "conversation", "messenger", Context.FROM_FULL).addMetaData(METADATA_COMMENT_ID, str2).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void openedConversationFromSnippet(String str, String str2) {
        track(newMetric("opened", "conversation", "messenger", Context.FROM_SNIPPET).addMetaData(METADATA_COMMENT_ID, str2).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void receivedReply(boolean z, boolean z2, String str, String str2) {
        track(newMetric(Action.RECEIVED, Object.REPLY, "messenger", Context.IN_CONVERSATION).addMetaData(METADATA_IS_ATTACHMENT, Boolean.valueOf(z)).addMetaData(METADATA_HAS_ARTICLE_CARD, Boolean.valueOf(z2)).addMetaData(METADATA_COMMENT_ID, str).addMetaData(METADATA_CONVERSATION_ID, str2));
    }

    public void viewedReply(boolean z, boolean z2, String str, String str2) {
        track(newMetric(Action.VIEWED, Object.REPLY, "messenger", Context.FROM_SNIPPET).addMetaData(METADATA_IS_ATTACHMENT, Boolean.valueOf(z)).addMetaData(METADATA_HAS_ARTICLE_CARD, Boolean.valueOf(z2)).addMetaData(METADATA_COMMENT_ID, str).addMetaData(METADATA_CONVERSATION_ID, str2));
    }

    public void sentReaction(String str, String str2, int i, ReactionLocation reactionLocation) {
        if (ReactionLocation.CONVERSATION == reactionLocation) {
            track(newMetric(Action.SENT, Object.REACTION, "messenger", Context.IN_CONVERSATION).addMetaData("message_id", str2).addMetaData(METADATA_REACTION_INDEX, Integer.valueOf(i)).addMetaData(METADATA_CONVERSATION_ID, str));
        } else if (ReactionLocation.LINK == reactionLocation) {
            track(newEducateMetric(Action.SENT, Object.REACTION, "messenger", Context.ON_ARTICLE).addMetaData("message_id", str2).addMetaData(METADATA_CONVERSATION_ID, str));
        } else {
            track(newMetric(Action.SENT, Object.REACTION, Place.IN_APP, Context.FROM_FULL).addMetaData("message_id", str2).addMetaData(METADATA_CONVERSATION_ID, str));
        }
    }

    public void profileClickedOpen(String str, ProfilePresenter.ProfileType profileType) {
        track(newMetric("opened", objectFrom(profileType), "messenger", Context.FROM_CLICKING).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void profileAutoOpen(String str, ProfilePresenter.ProfileType profileType) {
        track(newMetric("opened", objectFrom(profileType), "messenger", Context.FROM_AUTO).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void profileScrolledOpen(String str, ProfilePresenter.ProfileType profileType) {
        track(newMetric("opened", objectFrom(profileType), "messenger", Context.FROM_SCROLLING).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    private static String objectFrom(ProfilePresenter.ProfileType profileType) {
        return ProfilePresenter.ProfileType.TEAMMATE == profileType ? Object.TEAMMATE_PROFILE : Object.TEAM_PROFILE;
    }

    public void openConversationFromConversationList(String str, boolean z, boolean z2, String str2) {
        track(newMetric("opened", "conversation", "messenger", Context.FROM_CONVERSATION_LIST).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData(METADATA_WITHIN_OFFICE_HOURS, Boolean.valueOf(z)).addMetaData(METADATA_TEAMMATE_STATUS, z2 ? "active" : VALUE_AWAY).addMetaData(METADATA_TIME_SINCE_LAST_ACTIVE, str2));
    }

    public void receivedPushNotification(String str) {
        track(newMetric(Action.RECEIVED, "message", Place.PUSH, Context.FROM_PUSH).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData(METADATA_PUSH_TYPE, VALUE_NOTIFICATION));
    }

    public void receivedPushOnlyNotification(String str, String str2) {
        track(newMetric(Action.RECEIVED, "message", Place.PUSH, Context.FROM_PUSH).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData(METADATA_INSTANCE_ID, str2).addMetaData(METADATA_PUSH_TYPE, "message"));
    }

    public void viewedPushNotification(String str) {
        track(newMetric(Action.VIEWED, "message", Place.IN_APP, Context.FROM_PUSH).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData(METADATA_PUSH_TYPE, VALUE_NOTIFICATION));
    }

    public void openedPushOnlyNotification(String str) {
        track(newMetric("opened", "message", Place.IN_APP, Context.FROM_PUSH).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData(METADATA_PUSH_TYPE, "message"));
    }

    public void dismissedPushNotification(String str) {
        track(newMetric("dismissed", "message", Place.IN_APP, Context.FROM_PUSH).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData(METADATA_PUSH_TYPE, VALUE_NOTIFICATION));
    }

    public void dismissedPushOnlyNotification(String str, String str2) {
        track(newMetric("dismissed", "message", Place.IN_APP, Context.FROM_PUSH).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData(METADATA_INSTANCE_ID, str2).addMetaData(METADATA_PUSH_TYPE, "message"));
    }

    public void receivedMessageFromSnippetWhenClosed(boolean z, boolean z2, String str, String str2, String str3) {
        track(newMetric(Action.RECEIVED, "message", Place.IN_APP, Context.FROM_SNIPPET).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData("message_id", str2).addMetaData("message_type", str3).addMetaData(METADATA_IS_ATTACHMENT, Boolean.valueOf(z)).addMetaData(METADATA_HAS_ARTICLE_CARD, Boolean.valueOf(z2)));
    }

    public void receivedReplyFromSnippetWhenClosed(boolean z, boolean z2, String str, String str2) {
        track(newMetric(Action.RECEIVED, Object.REPLY, Place.IN_APP, Context.FROM_SNIPPET).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData(METADATA_COMMENT_ID, str2).addMetaData(METADATA_IS_ATTACHMENT, Boolean.valueOf(z)).addMetaData(METADATA_HAS_ARTICLE_CARD, Boolean.valueOf(z2)));
    }

    public void receivedMessageFromFullWhenClosed(boolean z, boolean z2, String str, String str2, String str3) {
        track(newMetric(Action.RECEIVED, "message", Place.IN_APP, Context.FROM_FULL).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData("message_id", str2).addMetaData("message_type", str3).addMetaData(METADATA_IS_ATTACHMENT, Boolean.valueOf(z)).addMetaData(METADATA_HAS_ARTICLE_CARD, Boolean.valueOf(z2)));
    }

    public void receivedQuickReply(String str, String str2, String str3) {
        track(newMetric(Action.RECEIVED, Object.QUICK_REPLIES, "messenger", Context.IN_CONVERSATION).addMetaData(METADATA_CONVERSATION_ID, str2).addMetaData(METADATA_PART_ID, str3).addMetaData(METADATA_QUICK_REPLY_ID, str));
    }

    public void clickedQuickReply(String str, String str2, String str3) {
        track(newMetric(Action.CLICKED, "quick_reply", "messenger", Context.IN_CONVERSATION).addMetaData(METADATA_CONVERSATION_ID, str2).addMetaData(METADATA_PART_ID, str3).addMetaData(METADATA_QUICK_REPLY_ID, str));
    }

    public void receivedComposerSuggestions(String str, String str2, String str3) {
        track(newMetric(Action.RECEIVED, Object.COMPOSER_SUGGESTIONS, "messenger", Context.IN_CONVERSATION).addMetaData(METADATA_CONVERSATION_ID, str2).addMetaData(METADATA_PART_ID, str3).addMetaData(METADATA_SUGGESTION_ID, str));
    }

    public void clickedComposerSuggestion(String str, String str2, String str3) {
        track(newMetric(Action.CLICKED, Object.SUGGESTION, "messenger", Context.IN_CONVERSATION).addMetaData(METADATA_CONVERSATION_ID, str2).addMetaData(METADATA_PART_ID, str3).addMetaData(METADATA_SUGGESTION_ID, str));
    }

    public void dismissInAppMessageSnippet(String str, String str2) {
        track(newMetric("dismissed", "message", Place.IN_APP, Context.FROM_SNIPPET).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData("message_id", str2));
    }

    public void dismissInAppCommentSnippet(String str, String str2) {
        track(newMetric("dismissed", Object.REPLY, Place.IN_APP, Context.FROM_SNIPPET).addMetaData(METADATA_CONVERSATION_ID, str).addMetaData(METADATA_COMMENT_ID, str2));
    }

    public void viewedInAppFromMessenger(String str, String str2, String str3) {
        track(newMetric(Action.VIEWED, "message", "messenger", Context.FROM_FULL).addMetaData("message_type", str3).addMetaData("message_id", str2).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void viewedInApp(String str, String str2, int i) {
        track(newMetric(Action.VIEWED, "message", Place.IN_APP, contextForInApp(i)).addMetaData("message_id", str2).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void closedInAppFromFull(String str, String str2) {
        track(newMetric(Action.CLOSED, "message", Place.IN_APP, Context.FROM_FULL).addMetaData("message_id", str2).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void receivedNotificationFromBadgeWhenMessengerClosed(String str) {
        track(newMetric(Action.RECEIVED, Object.BADGE, Place.IN_APP, Context.FROM_LAUNCHER).addMetaData(METADATA_BADGE_VALUE, str));
    }

    public void receivedOperatorReply(String str) {
        track(newEducateMetric(Action.RECEIVED, Object.OPERATOR_REPLY, "messenger", Context.FROM_CONVERSATION).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void openedNativeHelpCenter(String str, String str2) {
        if (str2 == null) {
            str2 = Context.NO_CONTEXT;
        }
        track(newHelpCenterMetric("opened", "help_center", str, str2, "search_browse".equals(str)));
    }

    public void searchedNativeHelpCenter(boolean z) {
        track(newHelpCenterMetric(Action.SEARCHED, "help_center", "search_results", Context.NO_CONTEXT, z));
    }

    public void openedNativeHelpCenterSearchResult(boolean z, String str) {
        track(newHelpCenterMetric(Action.CLICKED, "help_center", "search_results", Context.NO_CONTEXT, z).addMetaData(METADATA_SEARCH_QUERY, str));
    }

    public void clickedNewConversation(String str, String str2, boolean z) {
        track(newHelpCenterMetric(Action.CLICKED, Object.NEW_CONVERSATION, str, str2, z));
    }

    public void sentArticleReaction(String str, Boolean bool, boolean z) {
        MetricObject newHelpCenterMetric = newHelpCenterMetric(Action.SENT, Object.ARTICLE_REACTION, "article", str, z);
        if (bool != null) {
            newHelpCenterMetric.addMetaData("conversation_shown", bool);
        }
        track(newHelpCenterMetric);
    }

    public void failedHelpCenter(String str, String str2, String str3, boolean z) {
        MetricObject newHelpCenterMetric = newHelpCenterMetric(Action.FAILED, str, str2, Context.NO_CONTEXT, z);
        if (str3 != null) {
            newHelpCenterMetric.addMetaData("error", str3);
        }
        track(newHelpCenterMetric);
    }

    public void requestedHelpCenterData(String str) {
        track(newEducateMetric(Action.REQUESTED, Object.HELP_CENTER_DATA_API, str, Context.NO_CONTEXT));
    }

    public void viewedNativeHelpCenter(String str, Boolean bool, boolean z) {
        MetricObject newHelpCenterMetric = newHelpCenterMetric(Action.VIEWED, "help_center", str, Context.NO_CONTEXT, z);
        if (bool != null) {
            newHelpCenterMetric.addMetaData(METADATA_FILTERED, bool);
        }
        track(newHelpCenterMetric);
    }

    public void viewedCreateTicketForm(Integer num, String str) {
        MetricObject newMetric = newMetric(Action.VIEWED, Object.CREATE_TICKET_FORM, "messenger", "conversation");
        if (num != null) {
            newMetric.addMetaData(TICKET_TYPE_ID, num);
        }
        newMetric.addMetaData(METADATA_CONVERSATION_ID, str);
        track(newMetric);
    }

    public void viewedTicketDetails(Integer num, String str, String str2) {
        MetricObject newMetric = newMetric(Action.VIEWED, Object.TICKET_DETAILS, "messenger", "conversation");
        if (num != null) {
            newMetric.addMetaData(TICKET_TYPE_ID, num);
        }
        newMetric.addMetaData(TICKET_STATUS, str2);
        newMetric.addMetaData(METADATA_CONVERSATION_ID, str);
        track(newMetric);
    }

    public void submittedCreateTicketForm(Integer num, String str) {
        MetricObject newMetric = newMetric(Action.SUBMITTED, Object.CREATE_TICKET_FORM, "messenger", "conversation");
        if (num != null) {
            newMetric.addMetaData(TICKET_TYPE_ID, num);
        }
        newMetric.addMetaData(METADATA_CONVERSATION_ID, str);
        track(newMetric);
    }

    public void viewedSearchBrowseCard(int i) {
        MetricObject createMetric = createMetric(Name.SEARCH_BROWSE, "messenger", Action.VIEWED, "search_browse_card", "home", "messenger");
        createMetric.addMetaData(METADATA_HOME_SCREEN_INDEX, Integer.valueOf(i));
        track(createMetric);
    }

    public void clickedSearchBrowseCard() {
        track(createMetric(Name.EDUCATE, "messenger", Action.CLICKED, Object.SEARCH_BROWSE_CARD_INPUT, "home", "messenger"));
    }

    public void clickedArticleSuggestion(String str) {
        track(createMetric(Name.MESSENGER, "messenger", Action.CLICKED, Object.ARTICLE_SUGGESTION, "search_browse_card", "messenger").addMetaData("article_id", str));
    }

    public void viewedArticleSuggestions(List<String> list) {
        track(createMetric(Name.MESSENGER, "messenger", Action.VIEWED, Object.ARTICLE_SUGGESTIONS, "search_browse_card", "messenger").addMetaData("articles_count", Integer.valueOf(list.size())).addMetaData("articles_shown", list));
    }

    public void initialiseAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.INITIALISE, Place.API, Context.NO_CONTEXT));
    }

    public void setUserHashAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.USER_HASH, Place.API, Context.NO_CONTEXT));
    }

    public void loginUnidentifiedUserAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.LOGIN_UNIDENTIFIED_USER, Place.API, Context.NO_CONTEXT));
    }

    public void registerUnidentifiedUserAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.REGISTER_UNIDENTIFIED_USER, Place.API, Context.NO_CONTEXT));
    }

    public void loginIdentifiedUserAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.LOGIN_IDENTIFIED_USER, Place.API, Context.NO_CONTEXT));
    }

    public void registerIdentifiedUserAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.REGISTER_IDENTIFIED_USER, Place.API, Context.NO_CONTEXT));
    }

    public void logoutAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.LOGOUT, Place.API, Context.NO_CONTEXT));
    }

    public void resetAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.RESET, Place.API, Context.NO_CONTEXT));
    }

    public void updateUserCallbackAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.UPDATE_USER_CALLBACK, Place.API, Context.NO_CONTEXT));
    }

    public void updateUserAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.UPDATE_USER, Place.API, Context.NO_CONTEXT));
    }

    public void logEventAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.LOG_EVENT, Place.API, Context.NO_CONTEXT));
    }

    public void logEventMetadataAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.LOG_EVENT_METADATA, Place.API, Context.NO_CONTEXT));
    }

    public void displayMessengerAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.PRESENT_MESSENGER, Place.API, Context.NO_CONTEXT));
    }

    public void displayMessageComposerInitialMessageAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.PRESENT_MESSAGE_COMPOSER_INITIAL_MESSAGE, Place.API, Context.NO_CONTEXT));
    }

    public void displayMessageComposerAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.PRESENT_MESSAGE_COMPOSER, Place.API, Context.NO_CONTEXT));
    }

    public void displayConversationsListAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.PRESENT_CONVERSATION_LIST, Place.API, Context.NO_CONTEXT));
    }

    public void displayHelpCenterAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.PRESENT_HELP_CENTER, Place.API, Context.NO_CONTEXT));
    }

    public void displayHelpCenterCollectionsAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.PRESENT_HELP_CENTER_COLLECTIONS, Place.API, Context.NO_CONTEXT));
    }

    public void displayArticleAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.PRESENT_ARTICLE, Place.API, Context.NO_CONTEXT));
    }

    public void fetchHelpCenterCollectionsAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.FETCH_HELPCENTER_COLLECTIONS, Place.API, Context.NO_CONTEXT));
    }

    public void fetchHelpCenterCollectionAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.FETCH_HELPCENTER_COLLECTION, Place.API, Context.NO_CONTEXT));
    }

    public void searchHelpCenterAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.SEARCH_HELP_CENTER, Place.API, Context.NO_CONTEXT));
    }

    public void displayCarouselAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.PRESENT_CAROUSEL, Place.API, Context.NO_CONTEXT));
    }

    public void displaySurveyAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.PRESENT_SURVEY, Place.API, Context.NO_CONTEXT));
    }

    public void handlePushMessageAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.HANDLE_PUSH_NOTIFICATION, Place.API, Context.NO_CONTEXT));
    }

    public void setBottomPaddingAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.SET_BOTTOM_PADDING, Place.API, Context.NO_CONTEXT));
    }

    public void setInAppMessageVisibilityAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.SET_INAPP_MESSAGE_VISIBILITY, Place.API, Context.NO_CONTEXT));
    }

    public void setLauncherVisibilityAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.SET_LAUNCHER_VISIBILITY, Place.API, Context.NO_CONTEXT));
    }

    public void hideIntercomAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.HIDE_INTERCOM, Place.API, Context.NO_CONTEXT));
    }

    public void unreadConversationCountAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.UNREAD_CONVERSATION_COUNT, Place.API, Context.NO_CONTEXT));
    }

    public void setLogLevelAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.ENABLE_LOGGING, Place.API, Context.NO_CONTEXT));
    }

    public void handlePushMessageCustomStackAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.HANDLE_PUSH_NOTIFICATION_CUSTOM, Place.API, Context.NO_CONTEXT));
    }

    public void addUnreadConversationCountListenerAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.ADD_UNREAD_CONVERSATION_COUNT_LISTENER, Place.API, Context.NO_CONTEXT));
    }

    public void removeUnreadConversationCountListenerAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.REMOVE_UNREAD_CONVERSATION_COUNT_LISTENER, Place.API, Context.NO_CONTEXT));
    }

    public void registerForLateInitialisationAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.REGISTER_LATER_INIT, Place.API, Context.NO_CONTEXT));
    }

    public void unRegisterForLateInitialisationAPICall() {
        track(createMetric(Name.MESSENGER, "messenger", Action.USED, Object.UNREGISTER_LATER_INIT, Place.API, Context.NO_CONTEXT));
    }

    public void presentAPICall(IntercomSpace intercomSpace) {
        String str;
        MetricObject createMetric = createMetric(Name.MESSENGER, "messenger", Action.USED, Object.PRESENT_INTERCOM, Place.API, Context.NO_CONTEXT);
        if (intercomSpace == IntercomSpace.Home) {
            str = "home";
        } else if (intercomSpace == IntercomSpace.HelpCenter) {
            str = "help_center";
        } else {
            str = intercomSpace == IntercomSpace.Messages ? "messages" : "";
        }
        createMetric.addMetaData(METADATA_SPACE, str);
        track(createMetric);
    }

    public void presentContentAPICall(IntercomContent intercomContent) {
        String str;
        MetricObject createMetric = createMetric(Name.MESSENGER, "messenger", Action.USED, Object.PRESENT_INTERCOM_CONTENT, Place.API, Context.NO_CONTEXT);
        if (intercomContent instanceof IntercomContent.Article) {
            str = "article";
        } else if (intercomContent instanceof IntercomContent.Carousel) {
            str = "carousel";
        } else if (intercomContent instanceof IntercomContent.HelpCenterCollections) {
            str = "help_center_collections";
        } else {
            str = intercomContent instanceof IntercomContent.Survey ? "survey" : "";
        }
        createMetric.addMetaData("content_type", str);
        track(createMetric);
    }

    public void clickedInput(String str, String str2) {
        track(newMetric(Action.CLICKED, str2, "messenger", Context.IN_CONVERSATION).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void searchedGifInput(String str) {
        track(newMetric(Action.SEARCHED, Object.EXPANDED_GIF_INPUT, "messenger", Context.IN_CONVERSATION).addMetaData(METADATA_SEARCH_QUERY, str));
    }

    public void expandedInput(String str) {
        track(newMetric("opened", Object.EXPANDED_GIF_INPUT, "messenger", Context.IN_CONVERSATION).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void viewedMessengerSheet(String str, String str2, boolean z) {
        track(newMetric(Action.VIEWED, Object.MESSENGER_SHEET, "messenger", z ? Context.HOME_SCREEN : "conversation").addMetaData("url", str2).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void closedMessengerSheet(String str, String str2, boolean z) {
        track(newMetric(Action.CLOSED, Object.MESSENGER_SHEET, "messenger", z ? Context.HOME_SCREEN : "conversation").addMetaData("url", str2).addMetaData(METADATA_CONVERSATION_ID, str));
    }

    public void messengerCardWebViewEvent(String str, String str2, String str3, Map<String, Object> map, boolean z) {
        MetricObject newEducateMetric = newEducateMetric(str, str2, str3, z ? Context.HOME_SCREEN : "conversation");
        addMetadataToMetricObject(newEducateMetric, map);
        track(newEducateMetric);
    }

    public void clickedSpace(String str) {
        track(newMetric(Action.CLICKED, str, "messenger", "home"));
    }

    public void clickedNewConversation(String str) {
        track(newMetric(Action.CLICKED, Object.NEW_CONVERSATION, "messenger", str));
    }

    public void clickedExternalLinkCard() {
        track(newMetric(Action.CLICKED, Object.EXTERNAL_LINK, "messenger", "home"));
    }

    public void clickedConversation(String str, Conversation conversation) {
        MetricObject newMetric = newMetric(Action.CLICKED, "conversation", "messenger", str);
        if (!conversation.getTicket().equals(Ticket.Companion.getNULL())) {
            newMetric.addMetaData(TICKET_TYPE_ID, Integer.valueOf(conversation.getTicket().getTicketTypeId()));
            newMetric.addMetaData(TICKET_STATUS, conversation.getTicket().getCurrentStatus().getType());
        }
        track(newMetric);
    }

    public void clickedLauncher() {
        track(newMetric(Action.CLICKED, Object.LAUNCHER, "messenger", Context.NO_CONTEXT));
    }

    public void clickedPoweredBy() {
        track(newMetric(Action.CLICKED, Object.WE_RUN_ON_INTERCOM, "messenger", "home"));
    }

    public void viewedSpace(String str) {
        track(newMetric(Action.VIEWED, str, "messenger", Context.NO_CONTEXT));
    }

    public void startedToPlayVideo() {
        track(newMetric(Action.STARTED, Object.VIDEO_MESSAGE, Place.IN_APP, "conversation"));
    }

    public void loadedVideo(String str, int i, int i2) {
        track(newMetric(Action.LOADED, Object.VIDEO_MESSAGE, Place.IN_APP, "conversation").addMetaData(METADATA_VIDEO_URL, str).addMetaData(METADATA_VIDEO_WIDTH, Integer.valueOf(i)).addMetaData(METADATA_VIDEO_HEIGHT, Integer.valueOf(i2)));
    }

    public void failedToPlayVideo(String str) {
        track(newMetric(Action.FAILED, Object.VIDEO_MESSAGE, Place.IN_APP, "conversation").addMetaData(METADATA_VIDEO_URL, str));
    }

    public void completedVideo() {
        track(newMetric(Action.COMPLETED, Object.VIDEO_MESSAGE, Place.IN_APP, "conversation"));
    }

    public void openedCarousel(String str, String str2, int i, int i2) {
        track(newCarouselMetric("opened", "carousel_message", Context.FROM_CAROUSEL, str, str2).addMetaData(METADATA_SCREENS_IN_MESSAGE, Integer.valueOf(i)).addMetaData(METADATA_SCREENS_SHOWN, Integer.valueOf(i2)));
    }

    public void dismissedCarousel(String str, String str2, String str3, int i, int i2, int i3) {
        track(newCarouselMetric("dismissed", "carousel_message", str, str2, str3).addMetaData(METADATA_SCREENS_IN_MESSAGE, Integer.valueOf(i)).addMetaData(METADATA_SCREENS_SHOWN, Integer.valueOf(i2)).addMetaData(METADATA_SCREENS_SEEN, Integer.valueOf(i3)));
    }

    public void dismissedCarouselFetching(String str, String str2, String str3) {
        track(newCarouselMetric("dismissed", Object.CAROUSEL_MESSAGE_PRELOAD, str, str3).addMetaData(METADATA_REQUEST_CONTENT_ID, str2));
    }

    public void failedCarousel(String str, String str2, int i) {
        track(newCarouselMetric(Action.FAILED, Object.CAROUSEL_MESSAGE_PRELOAD, Context.FROM_CAROUSEL, str2).addMetaData("error_code", Integer.valueOf(i)).addMetaData(METADATA_REQUEST_CONTENT_ID, str));
    }

    public void startedCarouselFetching(String str, String str2) {
        track(newCarouselMetric(Action.STARTED, Object.CAROUSEL_MESSAGE_PRELOAD, Context.FROM_CAROUSEL, str2).addMetaData(METADATA_REQUEST_CONTENT_ID, str));
    }

    public void retriedCarouselFetching(String str, String str2) {
        track(newCarouselMetric(Action.CLICKED, Object.CAROUSEL_MESSAGE_PRELOAD, Context.FROM_RETRY, str2).addMetaData(METADATA_REQUEST_CONTENT_ID, str));
    }

    public void completedCarousel(String str, String str2, String str3, int i, int i2) {
        track(newCarouselMetric(Action.COMPLETED, "carousel_message", str, str2, str3).addMetaData(METADATA_SCREENS_IN_MESSAGE, Integer.valueOf(i)).addMetaData(METADATA_SCREENS_SHOWN, Integer.valueOf(i2)));
    }

    public void skippedPermission(String str, String str2, String str3) {
        track(newCarouselMetric(Action.CLICKED, Object.CAROUSEL_PERMISSION_SKIPPED, str, str2, str3));
    }

    public void requestedPermission(String str, String str2, String str3, boolean z) {
        track(newCarouselMetric(Action.CLICKED, Object.CAROUSEL_PERMISSION_DIALOG, str, str2, str3).addMetaData(METADATA_PERMISSION_GRANTED, Boolean.valueOf(z)));
    }

    public void sentToPermissionSettings(String str, String str2, String str3, boolean z) {
        track(newCarouselMetric(Action.CLICKED, Object.CAROUSEL_PERMISSION_SETTINGS, str, str2, str3).addMetaData(METADATA_PERMISSION_GRANTED, Boolean.valueOf(z)));
    }

    public void educateWebviewMetric(String str, String str2, String str3, Map<String, Object> map, String str4) {
        MetricObject newEducateMetric = newEducateMetric(str, str2, str3, str4);
        if (str4.equals(Context.FROM_ARTICLE_ON_BUTTON)) {
            newEducateMetric.addMetaData("source", CarouselSource.PROGRAMMATIC);
        } else {
            newEducateMetric.addMetaData("source", "automatic");
        }
        addMetadataToMetricObject(newEducateMetric, map);
        track(newEducateMetric);
    }

    public void surveyOpened(String str, String str2, String str3, String str4, String str5) {
        track(newSurveyMetric(str, str2, str3).addMetaData(METADATA_PLATFORM, VALUE_ANDROID_SDK).addMetaData(METADATA_SURVEY_ID, str4).addMetaData(METADATA_SURVEY_FORMAT, str5));
    }

    public void surveyCompleted(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3) {
        track(newSurveyMetric(str, str2, str3).addMetaData(METADATA_PLATFORM, VALUE_ANDROID_SDK).addMetaData(METADATA_SURVEY_ID, str4).addMetaData(METADATA_SURVEY_FORMAT, str5).addMetaData(METADATA_STEPS_COMPLETE, Integer.valueOf(i)).addMetaData(QUESTIONS_SEEN, Integer.valueOf(i3)).addMetaData(METADATA_MAX_STEPS, Integer.valueOf(i2)));
    }

    public void surveyDismissed(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3) {
        track(newSurveyMetric(str, str2, str3).addMetaData(METADATA_PLATFORM, VALUE_ANDROID_SDK).addMetaData(METADATA_SURVEY_ID, str4).addMetaData(METADATA_SURVEY_FORMAT, str5).addMetaData(METADATA_STEPS_COMPLETE, Integer.valueOf(i)).addMetaData(QUESTIONS_SEEN, Integer.valueOf(i3)).addMetaData(METADATA_MAX_STEPS, Integer.valueOf(i2)));
    }

    private void track(MetricObject metricObject) {
        this.store.track(metricObject);
    }

    private MetricObject newMetric(String str, String str2, String str3, String str4) {
        return createMetric(Name.MESSENGER, "messenger", str, str2, str3, str4);
    }

    private MetricObject newEducateMetric(String str, String str2, String str3, String str4) {
        return createMetric(Name.EDUCATE, Owner.EDUCATE, str, str2, str3, str4);
    }

    private MetricObject newHelpCenterMetric(String str, String str2, String str3, String str4, boolean z) {
        return createMetric(z ? Name.SEARCH_BROWSE : Name.EDUCATE, Owner.EDUCATE, str, str2, str3, str4);
    }

    private MetricObject newCarouselMetric(String str, String str2, String str3, String str4, String str5) {
        return newCarouselMetric(str, str2, str3, str5).addMetaData(METADATA_INSTANCE_ID, str4);
    }

    private MetricObject newCarouselMetric(String str, String str2, String str3, String str4) {
        return createMetric(Name.CAROUSEL, "messenger", str, str2, "carousel_message", str3).addMetaData("source", str4);
    }

    private MetricObject newSurveyMetric(String str, String str2, String str3) {
        return createMetric(Name.SURVEY, "messenger", str, str2, "survey", str3);
    }

    private MetricObject createMetric(String str, String str2, String str3, String str4, String str5, String str6) {
        return new MetricObject(str, str2, UUID.randomUUID().toString(), this.userIdentity.getIntercomId(), str3, str4, str5, str6, this.timeProvider, this.appVersion, this.sdkVersion);
    }

    private void addMetadataToMetricObject(MetricObject metricObject, Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            for (String next : map.keySet()) {
                metricObject.addMetaData(next, map.get(next));
            }
        }
    }
}
