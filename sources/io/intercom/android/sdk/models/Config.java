package io.intercom.android.sdk.models;

import io.intercom.android.nexus.NexusConfig;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class Config {
    public static final long DEFAULT_CACHE_MAX_AGE_MS = TimeUnit.MINUTES.toMillis(5);
    public static final int DEFAULT_RATE_LIMIT_COUNT = 100;
    public static final long DEFAULT_RATE_LIMIT_PERIOD_MS = TimeUnit.MINUTES.toMillis(1);
    public static final long DEFAULT_SESSION_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(20);
    public static final long DEFAULT_SOFT_RESET_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(1);
    public static final long DEFAULT_UPLOAD_SIZE_LIMIT = 41943040;
    public static final Config NULL = new Builder().build();

    public abstract boolean accessToTeammateEnabled();

    public abstract Set<String> getFeatures();

    public abstract String getHelpCenterBaseColor();

    public abstract String getHelpCenterLocale();

    public abstract String getHelpCenterUrl();

    public abstract Set<String> getHelpCenterUrls();

    public abstract boolean getIdentityVerificationEnabled();

    public abstract String getLauncherLogoUrl();

    public abstract String getLocale();

    public abstract String getMessenger4Background();

    public abstract String getMessengerBackground();

    public abstract String getMessengerLogoUrl();

    public abstract String getName();

    public abstract long getNewSessionThreshold();

    public abstract String getPrimaryColor();

    public abstract int getRateLimitCount();

    public abstract long getRateLimitPeriod();

    public abstract NexusConfig getRealTimeConfig();

    public abstract String getSecondaryColor();

    public abstract long getSoftResetTimeout();

    public abstract String getTeamGreeting();

    public abstract String getTeamIntro();

    public abstract long getUploadSizeLimit();

    public abstract long getUserUpdateCacheMaxAge();

    public abstract String getWelcomeMessage();

    public abstract boolean hasOpenConversations();

    public abstract boolean helpCenterRequireSearch();

    public abstract boolean isAttachmentsEnabled();

    public abstract boolean isAudioEnabled();

    public abstract boolean isBackgroundRequestsEnabled();

    public abstract boolean isFirstRequest();

    public abstract boolean isGifsEnabled();

    public abstract boolean isHelpCenterColorRenderDarkText();

    public abstract boolean isInboundMessages();

    public abstract boolean isMetricsEnabled();

    public abstract boolean isPrimaryColorRenderDarkText();

    public abstract boolean isSecondaryColorRenderDarkText();

    public abstract boolean isShowPoweredBy();

    public abstract ConfigModules modules();

    public abstract boolean preventMultipleInboundConversationsEnabled();

    public abstract String temporaryExpectationsMessage();

    public static final class Builder {
        Boolean access_to_teammate_enabled;
        Boolean audio_enabled;
        Boolean background_requests_enabled;
        String base_color;
        Set<String> features;
        Boolean has_open_conversations;
        String help_center_base_color;
        Boolean help_center_color_render_dark_text;
        String help_center_locale;
        Boolean help_center_require_search;
        String help_center_url;
        Set<String> help_center_urls;
        Boolean identity_verification_enabled;
        Boolean inbound_messages;
        Boolean is_first_request;
        String launcher_logo_url;
        Integer local_rate_limit;
        Long local_rate_limit_period;
        String locale;
        String messenger4_background;
        String messenger_background;
        String messenger_logo_url;
        Boolean metrics_enabled;
        ConfigModules modules;
        String name;
        Long new_session_threshold;
        Boolean prevent_multiple_inbound_conversations_enabled;
        Boolean primary_color_render_dark_text;
        NexusConfig.Builder real_time_config;
        String secondary_color;
        Boolean secondary_color_render_dark_text;
        Boolean show_powered_by;
        Long soft_reset_timeout;
        String team_greeting;
        String team_intro;
        String temporary_expectations_message;
        Long upload_size_limit;
        Boolean user_conversation_attachments_enabled;
        Boolean user_conversation_gifs_enabled;
        Long user_update_dup_cache_max_age;
        String welcome_message_plain_text;

        public Config build() {
            long j;
            long millis = this.local_rate_limit_period == null ? Config.DEFAULT_RATE_LIMIT_PERIOD_MS : TimeUnit.SECONDS.toMillis(this.local_rate_limit_period.longValue());
            Integer num = this.local_rate_limit;
            int intValue = num == null ? 100 : num.intValue();
            long millis2 = this.user_update_dup_cache_max_age == null ? Config.DEFAULT_CACHE_MAX_AGE_MS : TimeUnit.SECONDS.toMillis(this.user_update_dup_cache_max_age.longValue());
            long millis3 = this.soft_reset_timeout == null ? Config.DEFAULT_SOFT_RESET_TIMEOUT_MS : TimeUnit.SECONDS.toMillis(this.soft_reset_timeout.longValue());
            long millis4 = this.new_session_threshold == null ? Config.DEFAULT_SESSION_TIMEOUT_MS : TimeUnit.SECONDS.toMillis(this.new_session_threshold.longValue());
            Long l = this.upload_size_limit;
            if (l == null) {
                j = Config.DEFAULT_UPLOAD_SIZE_LIMIT;
            } else {
                j = l.longValue();
            }
            long j2 = j;
            NexusConfig.Builder builder = this.real_time_config;
            NexusConfig nexusConfig = builder == null ? new NexusConfig() : builder.build();
            Set<String> set = this.help_center_urls;
            if (set == null) {
                set = Collections.emptySet();
            }
            Set<String> set2 = set;
            Set<String> set3 = this.features;
            if (set3 == null) {
                set3 = Collections.emptySet();
            }
            Set<String> set4 = set3;
            ConfigModules configModules = this.modules;
            if (configModules == null) {
                configModules = ConfigModules.Companion.getDEFAULT();
            }
            AutoValue_Config autoValue_Config = r3;
            AutoValue_Config autoValue_Config2 = new AutoValue_Config(NullSafety.valueOrEmpty(this.name), this.base_color, this.secondary_color, NullSafety.valueOrEmpty(this.welcome_message_plain_text), NullSafety.valueOrEmpty(this.messenger_background), NullSafety.valueOrEmpty(this.messenger4_background), NullSafety.valueOrEmpty(this.locale), NullSafety.valueOrEmpty(this.help_center_locale), NullSafety.valueOrEmpty(this.launcher_logo_url), NullSafety.valueOrEmpty(this.messenger_logo_url), NullSafety.valueOrEmpty(this.team_intro), NullSafety.valueOrEmpty(this.team_greeting), NullSafety.valueOrDefault(this.is_first_request, false), NullSafety.valueOrDefault(this.inbound_messages, false), NullSafety.valueOrDefault(this.user_conversation_attachments_enabled, true), NullSafety.valueOrDefault(this.user_conversation_gifs_enabled, true), NullSafety.valueOrEmpty(this.temporary_expectations_message), NullSafety.valueOrDefault(this.show_powered_by, true), NullSafety.valueOrDefault(this.audio_enabled, true), NullSafety.valueOrDefault(this.metrics_enabled, true), NullSafety.valueOrDefault(this.background_requests_enabled, true), NullSafety.valueOrDefault(this.primary_color_render_dark_text, false), NullSafety.valueOrDefault(this.secondary_color_render_dark_text, false), NullSafety.valueOrDefault(this.help_center_color_render_dark_text, false), millis, intValue, millis2, millis3, millis4, j2, nexusConfig, NullSafety.valueOrEmpty(this.help_center_url), set2, this.help_center_base_color, set4, NullSafety.valueOrDefault(this.identity_verification_enabled, false), NullSafety.valueOrDefault(this.access_to_teammate_enabled, true), NullSafety.valueOrDefault(this.help_center_require_search, false), NullSafety.valueOrDefault(this.prevent_multiple_inbound_conversations_enabled, false), NullSafety.valueOrDefault(this.has_open_conversations, false), configModules);
            return autoValue_Config;
        }
    }
}
