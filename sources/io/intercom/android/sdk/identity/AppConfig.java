package io.intercom.android.sdk.identity;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.google.gson.Gson;
import com.squareup.otto.Bus;
import io.intercom.android.nexus.NexusConfig;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.Config;
import io.intercom.android.sdk.models.ConfigModules;
import io.intercom.android.sdk.models.events.ConfigUpdateEvent;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.PreferenceKeys;
import java.util.HashSet;
import java.util.Set;

public class AppConfig {
    private static final String APP_ACCESS_TEAMMATE_ENABLED = "access_to_teammate_enabled";
    private static final String APP_ATTACHMENTS_ENABLED = "app_user_conversation_attachments_enabled";
    private static final String APP_AUDIO_ENABLED = "app_audio_enabled";
    private static final String APP_BACKGROUND_REQUESTS_ENABLED = "app_background_requests_enabled";
    private static final String APP_FEATURES = "features";
    private static final String APP_GIFS_ENABLED = "app_user_conversation_gifs_enabled";
    private static final String APP_HAS_OPEN_CONVERSATIONS = "has_open_conversations";
    private static final String APP_HELP_CENTER_COLOR_RENDER_DARK_TEXT = "app_help_center_color_render_dark_text";
    private static final String APP_HELP_CENTER_LOCALE = "help_center_locale";
    private static final String APP_HELP_CENTER_PRIMARY_COLOR = "app_help_center_primary_color";
    private static final String APP_HELP_CENTER_REQUIRE_SEARCH = "help_center_require_search";
    private static final String APP_HELP_CENTER_URL = "help_center_url";
    private static final String APP_HELP_CENTER_URLS = "help_center_urls";
    private static final String APP_HUB_HEADER_CONFIG = "hub_config";
    private static final String APP_IDENTITY_VERIFICATION_ENABLED = "app_identity_verification_enabled";
    private static final String APP_INBOUND_MESSAGES = "app_inbound_messages";
    private static final String APP_INTERCOM_LINK = "app_intercom_link";
    private static final String APP_LAUNCHER_LOGO_URL = "app_launcher_logo_url";
    private static final String APP_LOCALE = "app_locale";
    private static final String APP_MESSENGER_LOGO_URL = "app_messenger_logo_url";
    private static final String APP_METRICS_ENABLED = "app_metrics_enabled";
    private static final String APP_NAME = "app_name";
    private static final String APP_NEW_SESSION_THRESHOLD_MS = "new_session_threshold_ms";
    private static final String APP_PREVENT_MULTIPLE_INBOUND_CONVERSATIONS_ENABLED = "prevent_multiple_inbound_conversations_enabled";
    private static final String APP_PRIMARY_COLOR = "app_primary_color";
    private static final String APP_PRIMARY_COLOR_RENDER_DARK_TEXT = "app_primary_color_render_dark_text";
    private static final String APP_RATE_LIMIT_COUNT = "app_rate_limit_count";
    private static final String APP_RATE_LIMIT_PERIOD_MS = "app_rate_limit_period_ms";
    private static final String APP_RECEIVED_FROM_SERVER = "app_received_from_server";
    private static final String APP_SECONDARY_COLOR = "app_secondary_color";
    private static final String APP_SECONDARY_COLOR_RENDER_DARK_TEXT = "app_secondary_color_render_dark_text";
    private static final String APP_SOFT_RESET_TIMEOUT_MS = "app_soft_reset_timeout_ms";
    private static final String APP_TEAM_BIO = "app_team_bio";
    private static final String APP_TEAM_GREETING = "app_team_greeting";
    private static final String APP_TEAM_INTRO = "app_team_intro";
    private static final String APP_TEMPORARY_EXPECTATIONS_MESSAGE = "app_temporary_expectations_message";
    private static final String APP_UPLOAD_SIZE_LIMIT = "upload_size_limit";
    private static final String APP_USER_UPDATE_CACHE_MAX_AGE_MS = "app_user_update_cache_max_age_ms";
    private static final String APP_WALLPAPER = "app_wallpaper";
    private boolean accessToTeammateEnabled;
    private boolean attachmentsEnabled;
    private boolean audioEnabled;
    private boolean backgroundRequestsEnabled;
    private ConfigModules configModules;
    private final int defaultColor;
    private Set<String> features;
    private boolean gifsEnabled;
    private final Gson gson = new Gson();
    private boolean hasOpenConversations;
    private int helpCenterBaseColor;
    private boolean helpCenterColorRenderDarkText;
    private String helpCenterLocale;
    private boolean helpCenterRequireSearch;
    private String helpCenterUrl;
    private Set<String> helpCenterUrls;
    private boolean identityVerificationEnabled;
    private boolean inboundMessages;
    private String launcherLogoUrl;
    private String locale;
    private String messengerLogoUrl;
    private boolean metricsEnabled;
    private String name;
    private long newSessionThresholdMs;
    private final SharedPreferences prefs;
    private boolean preventMultipleInboundConversationsEnabled;
    private int primaryColor;
    private int primaryColorDark;
    private boolean primaryColorRenderDarkText;
    private int rateLimitCount;
    private long rateLimitPeriodMs;
    private NexusConfig realTimeConfig = new NexusConfig();
    private boolean receivedFromServer;
    private int secondaryColor;
    private int secondaryColorDark;
    private boolean secondaryColorRenderDarkText;
    private boolean showIntercomLink;
    private long softResetTimeoutMs;
    private String teamGreeting;
    private String teamIntro;
    private String teamProfileBio;
    private String temporaryExpectationsMessage;
    private long uploadSizeLimit;
    private long userUpdateCacheMaxAgeMs;
    private String wallpaper;

    public AppConfig(Context context) {
        this.defaultColor = ContextCompat.getColor(context, R.color.intercom_main_blue);
        SharedPreferences sharedPreferences = context.getSharedPreferences(PreferenceKeys.INTERCOM_PREFS, 0);
        this.prefs = sharedPreferences;
        this.name = sharedPreferences.getString("app_name", "");
        int i = this.prefs.getInt(APP_PRIMARY_COLOR, this.defaultColor);
        this.primaryColor = i;
        this.primaryColorDark = ColorUtils.darkenColor(i);
        this.secondaryColor = this.prefs.getInt(APP_SECONDARY_COLOR, this.primaryColor);
        this.secondaryColorDark = darkSecondaryColor();
        this.primaryColorRenderDarkText = this.prefs.getBoolean(APP_PRIMARY_COLOR_RENDER_DARK_TEXT, false);
        this.secondaryColorRenderDarkText = this.prefs.getBoolean(APP_SECONDARY_COLOR_RENDER_DARK_TEXT, false);
        this.helpCenterColorRenderDarkText = this.prefs.getBoolean(APP_HELP_CENTER_COLOR_RENDER_DARK_TEXT, false);
        this.showIntercomLink = this.prefs.getBoolean(APP_INTERCOM_LINK, true);
        this.inboundMessages = this.prefs.getBoolean(APP_INBOUND_MESSAGES, false);
        this.attachmentsEnabled = this.prefs.getBoolean(APP_ATTACHMENTS_ENABLED, true);
        this.gifsEnabled = this.prefs.getBoolean(APP_GIFS_ENABLED, true);
        this.temporaryExpectationsMessage = this.prefs.getString(APP_TEMPORARY_EXPECTATIONS_MESSAGE, "");
        this.rateLimitCount = this.prefs.getInt(APP_RATE_LIMIT_COUNT, 100);
        this.rateLimitPeriodMs = this.prefs.getLong(APP_RATE_LIMIT_PERIOD_MS, Config.DEFAULT_RATE_LIMIT_PERIOD_MS);
        this.userUpdateCacheMaxAgeMs = this.prefs.getLong(APP_USER_UPDATE_CACHE_MAX_AGE_MS, Config.DEFAULT_CACHE_MAX_AGE_MS);
        this.newSessionThresholdMs = this.prefs.getLong(APP_NEW_SESSION_THRESHOLD_MS, Config.DEFAULT_SESSION_TIMEOUT_MS);
        this.softResetTimeoutMs = this.prefs.getLong(APP_SOFT_RESET_TIMEOUT_MS, Config.DEFAULT_SOFT_RESET_TIMEOUT_MS);
        this.uploadSizeLimit = this.prefs.getLong(APP_UPLOAD_SIZE_LIMIT, Config.DEFAULT_UPLOAD_SIZE_LIMIT);
        this.metricsEnabled = this.prefs.getBoolean(APP_METRICS_ENABLED, true);
        this.audioEnabled = this.prefs.getBoolean(APP_AUDIO_ENABLED, true);
        this.teamProfileBio = this.prefs.getString(APP_TEAM_BIO, "");
        this.wallpaper = this.prefs.getString(APP_WALLPAPER, "");
        this.locale = this.prefs.getString(APP_LOCALE, "");
        this.helpCenterLocale = this.prefs.getString(APP_HELP_CENTER_LOCALE, "");
        this.receivedFromServer = this.prefs.getBoolean(APP_RECEIVED_FROM_SERVER, false);
        this.backgroundRequestsEnabled = this.prefs.getBoolean(APP_BACKGROUND_REQUESTS_ENABLED, true);
        this.helpCenterUrl = this.prefs.getString(APP_HELP_CENTER_URL, "");
        this.helpCenterUrls = this.prefs.getStringSet(APP_HELP_CENTER_URLS, new HashSet());
        this.helpCenterBaseColor = this.prefs.getInt(APP_HELP_CENTER_PRIMARY_COLOR, this.defaultColor);
        this.features = this.prefs.getStringSet(APP_FEATURES, new HashSet());
        this.launcherLogoUrl = this.prefs.getString(APP_LAUNCHER_LOGO_URL, "");
        this.messengerLogoUrl = this.prefs.getString(APP_MESSENGER_LOGO_URL, "");
        this.teamIntro = this.prefs.getString(APP_TEAM_INTRO, "");
        this.teamGreeting = this.prefs.getString(APP_TEAM_GREETING, "");
        this.identityVerificationEnabled = this.prefs.getBoolean(APP_IDENTITY_VERIFICATION_ENABLED, false);
        this.accessToTeammateEnabled = this.prefs.getBoolean(APP_ACCESS_TEAMMATE_ENABLED, true);
        this.helpCenterRequireSearch = this.prefs.getBoolean(APP_HELP_CENTER_REQUIRE_SEARCH, false);
        this.preventMultipleInboundConversationsEnabled = this.prefs.getBoolean(APP_PREVENT_MULTIPLE_INBOUND_CONVERSATIONS_ENABLED, false);
        this.hasOpenConversations = this.prefs.getBoolean(APP_HAS_OPEN_CONVERSATIONS, false);
        this.configModules = (ConfigModules) this.gson.fromJson(this.prefs.getString(APP_HUB_HEADER_CONFIG, (String) null), ConfigModules.class);
    }

    public void update(Config config, Bus bus) {
        if (config != Config.NULL) {
            this.realTimeConfig = config.getRealTimeConfig();
            this.receivedFromServer = true;
            if (isNewConfig(config)) {
                this.name = config.getName();
                this.teamProfileBio = config.getWelcomeMessage();
                this.wallpaper = getWallpaperFromConfig(config);
                int configColor = getConfigColor(config.getPrimaryColor());
                this.primaryColor = configColor;
                this.primaryColorDark = ColorUtils.darkenColor(configColor);
                this.secondaryColor = getConfigColor(config.getSecondaryColor());
                this.primaryColorRenderDarkText = config.isPrimaryColorRenderDarkText();
                this.secondaryColorRenderDarkText = config.isSecondaryColorRenderDarkText();
                this.helpCenterColorRenderDarkText = config.isHelpCenterColorRenderDarkText();
                this.inboundMessages = config.isInboundMessages();
                this.attachmentsEnabled = config.isAttachmentsEnabled();
                this.gifsEnabled = config.isGifsEnabled();
                this.temporaryExpectationsMessage = config.temporaryExpectationsMessage();
                this.secondaryColorDark = darkSecondaryColor();
                this.showIntercomLink = config.isShowPoweredBy();
                this.audioEnabled = config.isAudioEnabled();
                this.metricsEnabled = config.isMetricsEnabled();
                this.userUpdateCacheMaxAgeMs = config.getUserUpdateCacheMaxAge();
                this.rateLimitPeriodMs = config.getRateLimitPeriod();
                this.rateLimitCount = config.getRateLimitCount();
                this.newSessionThresholdMs = config.getNewSessionThreshold();
                this.softResetTimeoutMs = config.getSoftResetTimeout();
                this.uploadSizeLimit = config.getUploadSizeLimit();
                this.backgroundRequestsEnabled = config.isBackgroundRequestsEnabled();
                this.locale = config.getLocale();
                this.helpCenterLocale = config.getHelpCenterLocale();
                this.helpCenterUrl = config.getHelpCenterUrl();
                this.helpCenterUrls = config.getHelpCenterUrls();
                this.helpCenterBaseColor = getConfigColor(config.getHelpCenterBaseColor());
                this.features = config.getFeatures();
                this.launcherLogoUrl = config.getLauncherLogoUrl();
                this.messengerLogoUrl = config.getMessengerLogoUrl();
                this.teamIntro = config.getTeamIntro();
                this.teamGreeting = config.getTeamGreeting();
                this.identityVerificationEnabled = config.getIdentityVerificationEnabled();
                this.accessToTeammateEnabled = config.accessToTeammateEnabled();
                this.helpCenterRequireSearch = config.helpCenterRequireSearch();
                this.preventMultipleInboundConversationsEnabled = config.preventMultipleInboundConversationsEnabled();
                this.hasOpenConversations = config.hasOpenConversations();
                this.configModules = config.modules();
                this.prefs.edit().putString("app_name", this.name).putString(APP_TEAM_BIO, this.teamProfileBio).putString(APP_WALLPAPER, this.wallpaper).putString(APP_LOCALE, this.locale).putString(APP_HELP_CENTER_LOCALE, this.helpCenterLocale).putString(APP_LAUNCHER_LOGO_URL, this.launcherLogoUrl).putString(APP_MESSENGER_LOGO_URL, this.messengerLogoUrl).putString(APP_TEAM_INTRO, this.teamIntro).putString(APP_TEAM_GREETING, this.teamGreeting).putInt(APP_PRIMARY_COLOR, this.primaryColor).putInt(APP_SECONDARY_COLOR, this.secondaryColor).putInt(APP_HELP_CENTER_PRIMARY_COLOR, this.helpCenterBaseColor).putInt(APP_RATE_LIMIT_COUNT, this.rateLimitCount).putLong(APP_USER_UPDATE_CACHE_MAX_AGE_MS, this.userUpdateCacheMaxAgeMs).putLong(APP_RATE_LIMIT_PERIOD_MS, this.rateLimitPeriodMs).putLong(APP_NEW_SESSION_THRESHOLD_MS, this.newSessionThresholdMs).putLong(APP_SOFT_RESET_TIMEOUT_MS, this.softResetTimeoutMs).putLong(APP_UPLOAD_SIZE_LIMIT, this.uploadSizeLimit).putBoolean(APP_INTERCOM_LINK, this.showIntercomLink).putBoolean(APP_INBOUND_MESSAGES, this.inboundMessages).putBoolean(APP_ATTACHMENTS_ENABLED, this.attachmentsEnabled).putBoolean(APP_GIFS_ENABLED, this.gifsEnabled).putString(APP_TEMPORARY_EXPECTATIONS_MESSAGE, this.temporaryExpectationsMessage).putBoolean(APP_AUDIO_ENABLED, this.audioEnabled).putBoolean(APP_METRICS_ENABLED, this.metricsEnabled).putBoolean(APP_RECEIVED_FROM_SERVER, true).putBoolean(APP_BACKGROUND_REQUESTS_ENABLED, this.backgroundRequestsEnabled).putBoolean(APP_PRIMARY_COLOR_RENDER_DARK_TEXT, this.primaryColorRenderDarkText).putBoolean(APP_SECONDARY_COLOR_RENDER_DARK_TEXT, this.secondaryColorRenderDarkText).putBoolean(APP_HELP_CENTER_COLOR_RENDER_DARK_TEXT, this.helpCenterColorRenderDarkText).putString(APP_HELP_CENTER_URL, this.helpCenterUrl).putStringSet(APP_HELP_CENTER_URLS, this.helpCenterUrls).putStringSet(APP_FEATURES, this.features).putBoolean(APP_ACCESS_TEAMMATE_ENABLED, this.accessToTeammateEnabled).putBoolean(APP_HELP_CENTER_REQUIRE_SEARCH, this.helpCenterRequireSearch).putBoolean(APP_PREVENT_MULTIPLE_INBOUND_CONVERSATIONS_ENABLED, this.preventMultipleInboundConversationsEnabled).putBoolean(APP_HAS_OPEN_CONVERSATIONS, this.hasOpenConversations).putString(APP_HUB_HEADER_CONFIG, this.gson.toJson((Object) this.configModules)).apply();
                bus.post(new ConfigUpdateEvent());
            }
        }
    }

    private int getConfigColor(String str) {
        return str == null ? this.defaultColor : ColorUtils.parseColor(str);
    }

    public String getName() {
        return this.name;
    }

    public String getTeamProfileBio() {
        return removeLineSeparator(this.teamProfileBio);
    }

    public String getWallpaper() {
        return this.wallpaper;
    }

    public int getPrimaryColor() {
        return this.primaryColor;
    }

    public int getPrimaryColorDark() {
        return this.primaryColorDark;
    }

    public int getSecondaryColor() {
        return this.secondaryColor;
    }

    public int getSecondaryColorDark() {
        return this.secondaryColorDark;
    }

    public boolean primaryColorRenderDarkText() {
        return this.primaryColorRenderDarkText;
    }

    public boolean secondaryColorRenderDarkText() {
        return this.secondaryColorRenderDarkText;
    }

    public boolean helpCenterColorRenderDarkText() {
        return this.helpCenterColorRenderDarkText;
    }

    public boolean shouldShowIntercomLink() {
        return this.showIntercomLink;
    }

    public boolean isInboundMessages() {
        return this.inboundMessages;
    }

    public boolean isAttachmentsEnabled() {
        return this.attachmentsEnabled;
    }

    public boolean isGifsEnabled() {
        return this.gifsEnabled;
    }

    public String getTemporaryExpectationsMessage() {
        return this.temporaryExpectationsMessage;
    }

    public int getRateLimitCount() {
        return this.rateLimitCount;
    }

    public long getUserUpdateCacheMaxAgeMs() {
        return this.userUpdateCacheMaxAgeMs;
    }

    public long getRateLimitPeriodMs() {
        return this.rateLimitPeriodMs;
    }

    public long getNewSessionThresholdMs() {
        return this.newSessionThresholdMs;
    }

    public long getSoftResetTimeoutMs() {
        return this.softResetTimeoutMs;
    }

    public long getUploadSizeLimit() {
        return this.uploadSizeLimit;
    }

    public NexusConfig getRealTimeConfig() {
        return this.realTimeConfig;
    }

    public boolean isAudioEnabled() {
        return this.audioEnabled;
    }

    public boolean isMetricsEnabled() {
        return this.metricsEnabled;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getHelpCenterLocale() {
        return this.helpCenterLocale;
    }

    public boolean isReceivedFromServer() {
        return this.receivedFromServer;
    }

    public void reset() {
        this.realTimeConfig = new NexusConfig();
        this.teamGreeting = "";
    }

    public boolean backgroundRequestsDisabled() {
        return !this.backgroundRequestsEnabled;
    }

    public String getHelpCenterUrl() {
        return this.helpCenterUrl;
    }

    public Set<String> getHelpCenterUrls() {
        return this.helpCenterUrls;
    }

    public int getHelpCenterBaseColor() {
        return this.helpCenterBaseColor;
    }

    public boolean hasFeature(String str) {
        return this.features.contains(str);
    }

    public String getLauncherLogoUrl() {
        return this.launcherLogoUrl;
    }

    public String getMessengerLogoUrl() {
        return this.messengerLogoUrl;
    }

    public String getTeamIntro() {
        return removeLineSeparator(this.teamIntro);
    }

    public String getTeamGreeting() {
        return this.teamGreeting;
    }

    public boolean isIdentityVerificationEnabled() {
        return this.identityVerificationEnabled;
    }

    public boolean isAccessToTeammateEnabled() {
        return this.accessToTeammateEnabled;
    }

    public boolean isHelpCenterRequireSearchEnabled() {
        return this.helpCenterRequireSearch;
    }

    public boolean isPreventMultipleInboundConversationsEnabled() {
        return this.preventMultipleInboundConversationsEnabled;
    }

    public boolean hasOpenConversations() {
        return this.hasOpenConversations;
    }

    public ConfigModules getConfigModules() {
        return this.configModules;
    }

    private boolean isNewConfig(Config config) {
        return (config.getWelcomeMessage().equals(this.teamProfileBio) && getWallpaperFromConfig(config).equals(this.wallpaper) && config.getName().equals(this.name) && config.getLocale().equals(this.locale) && config.getHelpCenterLocale().equals(this.helpCenterLocale) && getConfigColor(config.getPrimaryColor()) == this.primaryColor && getConfigColor(config.getSecondaryColor()) == this.secondaryColor && config.isPrimaryColorRenderDarkText() == this.primaryColorRenderDarkText && config.isSecondaryColorRenderDarkText() == this.secondaryColorRenderDarkText && config.isHelpCenterColorRenderDarkText() == this.helpCenterColorRenderDarkText && config.getUserUpdateCacheMaxAge() == this.userUpdateCacheMaxAgeMs && config.isMetricsEnabled() == this.metricsEnabled && config.isAudioEnabled() == this.audioEnabled && config.isShowPoweredBy() == this.showIntercomLink && config.isInboundMessages() == this.inboundMessages && config.isAttachmentsEnabled() == this.attachmentsEnabled && config.isGifsEnabled() == this.gifsEnabled && config.getRateLimitCount() == this.rateLimitCount && config.getRateLimitPeriod() == this.rateLimitPeriodMs && config.getNewSessionThreshold() == this.newSessionThresholdMs && config.getSoftResetTimeout() == this.softResetTimeoutMs && config.getUploadSizeLimit() == this.uploadSizeLimit && config.isBackgroundRequestsEnabled() == this.backgroundRequestsEnabled && config.getHelpCenterUrl().equals(this.helpCenterUrl) && config.getHelpCenterUrls().equals(this.helpCenterUrls) && getConfigColor(config.getHelpCenterBaseColor()) == this.helpCenterBaseColor && config.getFeatures().equals(this.features) && config.getLauncherLogoUrl().equals(this.launcherLogoUrl) && config.getMessengerLogoUrl().equals(this.messengerLogoUrl) && config.getTeamIntro().equals(this.teamIntro) && config.getTeamGreeting().equals(this.teamGreeting) && config.getTeamGreeting().equals(this.teamGreeting) && config.getIdentityVerificationEnabled() == this.identityVerificationEnabled && config.accessToTeammateEnabled() == this.accessToTeammateEnabled && config.temporaryExpectationsMessage().equals(this.temporaryExpectationsMessage) && config.helpCenterRequireSearch() == this.helpCenterRequireSearch && config.preventMultipleInboundConversationsEnabled() == this.preventMultipleInboundConversationsEnabled && config.hasOpenConversations() == this.hasOpenConversations && config.modules() == this.configModules) ? false : true;
    }

    private int darkSecondaryColor() {
        return ColorUtils.darkenColor(this.secondaryColor);
    }

    private String getWallpaperFromConfig(Config config) {
        String messenger4Background = config.getMessenger4Background();
        return TextUtils.isEmpty(messenger4Background) ? config.getMessengerBackground() : messenger4Background;
    }

    private String removeLineSeparator(String str) {
        return str.replaceAll(System.getProperty("line.separator"), "");
    }
}
