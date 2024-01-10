package io.intercom.android.sdk.models;

import io.intercom.android.nexus.NexusConfig;
import java.util.Set;

final class AutoValue_Config extends Config {
    private final boolean accessToTeammateEnabled;
    private final Set<String> getFeatures;
    private final String getHelpCenterBaseColor;
    private final String getHelpCenterLocale;
    private final String getHelpCenterUrl;
    private final Set<String> getHelpCenterUrls;
    private final boolean getIdentityVerificationEnabled;
    private final String getLauncherLogoUrl;
    private final String getLocale;
    private final String getMessenger4Background;
    private final String getMessengerBackground;
    private final String getMessengerLogoUrl;
    private final String getName;
    private final long getNewSessionThreshold;
    private final String getPrimaryColor;
    private final int getRateLimitCount;
    private final long getRateLimitPeriod;
    private final NexusConfig getRealTimeConfig;
    private final String getSecondaryColor;
    private final long getSoftResetTimeout;
    private final String getTeamGreeting;
    private final String getTeamIntro;
    private final long getUploadSizeLimit;
    private final long getUserUpdateCacheMaxAge;
    private final String getWelcomeMessage;
    private final boolean hasOpenConversations;
    private final boolean helpCenterRequireSearch;
    private final boolean isAttachmentsEnabled;
    private final boolean isAudioEnabled;
    private final boolean isBackgroundRequestsEnabled;
    private final boolean isFirstRequest;
    private final boolean isGifsEnabled;
    private final boolean isHelpCenterColorRenderDarkText;
    private final boolean isInboundMessages;
    private final boolean isMetricsEnabled;
    private final boolean isPrimaryColorRenderDarkText;
    private final boolean isSecondaryColorRenderDarkText;
    private final boolean isShowPoweredBy;
    private final ConfigModules modules;
    private final boolean preventMultipleInboundConversationsEnabled;
    private final String temporaryExpectationsMessage;

    AutoValue_Config(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, boolean z2, boolean z3, boolean z4, String str13, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, long j, int i, long j2, long j3, long j4, long j5, NexusConfig nexusConfig, String str14, Set<String> set, String str15, Set<String> set2, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, ConfigModules configModules) {
        String str16 = str;
        String str17 = str4;
        String str18 = str5;
        String str19 = str6;
        String str20 = str7;
        String str21 = str8;
        String str22 = str9;
        String str23 = str10;
        String str24 = str11;
        String str25 = str12;
        String str26 = str13;
        NexusConfig nexusConfig2 = nexusConfig;
        String str27 = str14;
        Set<String> set3 = set;
        Set<String> set4 = set2;
        if (str16 != null) {
            this.getName = str16;
            this.getPrimaryColor = str2;
            this.getSecondaryColor = str3;
            if (str17 != null) {
                this.getWelcomeMessage = str17;
                if (str18 != null) {
                    this.getMessengerBackground = str18;
                    if (str19 != null) {
                        this.getMessenger4Background = str19;
                        if (str20 != null) {
                            this.getLocale = str20;
                            if (str21 != null) {
                                this.getHelpCenterLocale = str21;
                                if (str22 != null) {
                                    this.getLauncherLogoUrl = str22;
                                    if (str23 != null) {
                                        this.getMessengerLogoUrl = str23;
                                        if (str24 != null) {
                                            this.getTeamIntro = str24;
                                            if (str25 != null) {
                                                this.getTeamGreeting = str25;
                                                this.isFirstRequest = z;
                                                this.isInboundMessages = z2;
                                                this.isAttachmentsEnabled = z3;
                                                this.isGifsEnabled = z4;
                                                if (str26 != null) {
                                                    this.temporaryExpectationsMessage = str26;
                                                    this.isShowPoweredBy = z5;
                                                    this.isAudioEnabled = z6;
                                                    this.isMetricsEnabled = z7;
                                                    this.isBackgroundRequestsEnabled = z8;
                                                    this.isPrimaryColorRenderDarkText = z9;
                                                    this.isSecondaryColorRenderDarkText = z10;
                                                    this.isHelpCenterColorRenderDarkText = z11;
                                                    this.getRateLimitPeriod = j;
                                                    this.getRateLimitCount = i;
                                                    this.getUserUpdateCacheMaxAge = j2;
                                                    this.getSoftResetTimeout = j3;
                                                    this.getNewSessionThreshold = j4;
                                                    this.getUploadSizeLimit = j5;
                                                    if (nexusConfig2 != null) {
                                                        this.getRealTimeConfig = nexusConfig2;
                                                        if (str27 != null) {
                                                            this.getHelpCenterUrl = str27;
                                                            if (set3 != null) {
                                                                this.getHelpCenterUrls = set3;
                                                                this.getHelpCenterBaseColor = str15;
                                                                if (set4 != null) {
                                                                    this.getFeatures = set4;
                                                                    this.getIdentityVerificationEnabled = z12;
                                                                    this.accessToTeammateEnabled = z13;
                                                                    this.helpCenterRequireSearch = z14;
                                                                    this.preventMultipleInboundConversationsEnabled = z15;
                                                                    this.hasOpenConversations = z16;
                                                                    ConfigModules configModules2 = configModules;
                                                                    if (configModules2 != null) {
                                                                        this.modules = configModules2;
                                                                        return;
                                                                    }
                                                                    throw new NullPointerException("Null modules");
                                                                }
                                                                throw new NullPointerException("Null getFeatures");
                                                            }
                                                            throw new NullPointerException("Null getHelpCenterUrls");
                                                        }
                                                        throw new NullPointerException("Null getHelpCenterUrl");
                                                    }
                                                    throw new NullPointerException("Null getRealTimeConfig");
                                                }
                                                throw new NullPointerException("Null temporaryExpectationsMessage");
                                            }
                                            throw new NullPointerException("Null getTeamGreeting");
                                        }
                                        throw new NullPointerException("Null getTeamIntro");
                                    }
                                    throw new NullPointerException("Null getMessengerLogoUrl");
                                }
                                throw new NullPointerException("Null getLauncherLogoUrl");
                            }
                            throw new NullPointerException("Null getHelpCenterLocale");
                        }
                        throw new NullPointerException("Null getLocale");
                    }
                    throw new NullPointerException("Null getMessenger4Background");
                }
                throw new NullPointerException("Null getMessengerBackground");
            }
            throw new NullPointerException("Null getWelcomeMessage");
        }
        throw new NullPointerException("Null getName");
    }

    public String getName() {
        return this.getName;
    }

    public String getPrimaryColor() {
        return this.getPrimaryColor;
    }

    public String getSecondaryColor() {
        return this.getSecondaryColor;
    }

    public String getWelcomeMessage() {
        return this.getWelcomeMessage;
    }

    public String getMessengerBackground() {
        return this.getMessengerBackground;
    }

    public String getMessenger4Background() {
        return this.getMessenger4Background;
    }

    public String getLocale() {
        return this.getLocale;
    }

    public String getHelpCenterLocale() {
        return this.getHelpCenterLocale;
    }

    public String getLauncherLogoUrl() {
        return this.getLauncherLogoUrl;
    }

    public String getMessengerLogoUrl() {
        return this.getMessengerLogoUrl;
    }

    public String getTeamIntro() {
        return this.getTeamIntro;
    }

    public String getTeamGreeting() {
        return this.getTeamGreeting;
    }

    public boolean isFirstRequest() {
        return this.isFirstRequest;
    }

    public boolean isInboundMessages() {
        return this.isInboundMessages;
    }

    public boolean isAttachmentsEnabled() {
        return this.isAttachmentsEnabled;
    }

    public boolean isGifsEnabled() {
        return this.isGifsEnabled;
    }

    public String temporaryExpectationsMessage() {
        return this.temporaryExpectationsMessage;
    }

    public boolean isShowPoweredBy() {
        return this.isShowPoweredBy;
    }

    public boolean isAudioEnabled() {
        return this.isAudioEnabled;
    }

    public boolean isMetricsEnabled() {
        return this.isMetricsEnabled;
    }

    public boolean isBackgroundRequestsEnabled() {
        return this.isBackgroundRequestsEnabled;
    }

    public boolean isPrimaryColorRenderDarkText() {
        return this.isPrimaryColorRenderDarkText;
    }

    public boolean isSecondaryColorRenderDarkText() {
        return this.isSecondaryColorRenderDarkText;
    }

    public boolean isHelpCenterColorRenderDarkText() {
        return this.isHelpCenterColorRenderDarkText;
    }

    public long getRateLimitPeriod() {
        return this.getRateLimitPeriod;
    }

    public int getRateLimitCount() {
        return this.getRateLimitCount;
    }

    public long getUserUpdateCacheMaxAge() {
        return this.getUserUpdateCacheMaxAge;
    }

    public long getSoftResetTimeout() {
        return this.getSoftResetTimeout;
    }

    public long getNewSessionThreshold() {
        return this.getNewSessionThreshold;
    }

    public long getUploadSizeLimit() {
        return this.getUploadSizeLimit;
    }

    public NexusConfig getRealTimeConfig() {
        return this.getRealTimeConfig;
    }

    public String getHelpCenterUrl() {
        return this.getHelpCenterUrl;
    }

    public Set<String> getHelpCenterUrls() {
        return this.getHelpCenterUrls;
    }

    public String getHelpCenterBaseColor() {
        return this.getHelpCenterBaseColor;
    }

    public Set<String> getFeatures() {
        return this.getFeatures;
    }

    public boolean getIdentityVerificationEnabled() {
        return this.getIdentityVerificationEnabled;
    }

    public boolean accessToTeammateEnabled() {
        return this.accessToTeammateEnabled;
    }

    public boolean helpCenterRequireSearch() {
        return this.helpCenterRequireSearch;
    }

    public boolean preventMultipleInboundConversationsEnabled() {
        return this.preventMultipleInboundConversationsEnabled;
    }

    public boolean hasOpenConversations() {
        return this.hasOpenConversations;
    }

    public ConfigModules modules() {
        return this.modules;
    }

    public String toString() {
        return "Config{getName=" + this.getName + ", getPrimaryColor=" + this.getPrimaryColor + ", getSecondaryColor=" + this.getSecondaryColor + ", getWelcomeMessage=" + this.getWelcomeMessage + ", getMessengerBackground=" + this.getMessengerBackground + ", getMessenger4Background=" + this.getMessenger4Background + ", getLocale=" + this.getLocale + ", getHelpCenterLocale=" + this.getHelpCenterLocale + ", getLauncherLogoUrl=" + this.getLauncherLogoUrl + ", getMessengerLogoUrl=" + this.getMessengerLogoUrl + ", getTeamIntro=" + this.getTeamIntro + ", getTeamGreeting=" + this.getTeamGreeting + ", isFirstRequest=" + this.isFirstRequest + ", isInboundMessages=" + this.isInboundMessages + ", isAttachmentsEnabled=" + this.isAttachmentsEnabled + ", isGifsEnabled=" + this.isGifsEnabled + ", temporaryExpectationsMessage=" + this.temporaryExpectationsMessage + ", isShowPoweredBy=" + this.isShowPoweredBy + ", isAudioEnabled=" + this.isAudioEnabled + ", isMetricsEnabled=" + this.isMetricsEnabled + ", isBackgroundRequestsEnabled=" + this.isBackgroundRequestsEnabled + ", isPrimaryColorRenderDarkText=" + this.isPrimaryColorRenderDarkText + ", isSecondaryColorRenderDarkText=" + this.isSecondaryColorRenderDarkText + ", isHelpCenterColorRenderDarkText=" + this.isHelpCenterColorRenderDarkText + ", getRateLimitPeriod=" + this.getRateLimitPeriod + ", getRateLimitCount=" + this.getRateLimitCount + ", getUserUpdateCacheMaxAge=" + this.getUserUpdateCacheMaxAge + ", getSoftResetTimeout=" + this.getSoftResetTimeout + ", getNewSessionThreshold=" + this.getNewSessionThreshold + ", getUploadSizeLimit=" + this.getUploadSizeLimit + ", getRealTimeConfig=" + this.getRealTimeConfig + ", getHelpCenterUrl=" + this.getHelpCenterUrl + ", getHelpCenterUrls=" + this.getHelpCenterUrls + ", getHelpCenterBaseColor=" + this.getHelpCenterBaseColor + ", getFeatures=" + this.getFeatures + ", getIdentityVerificationEnabled=" + this.getIdentityVerificationEnabled + ", accessToTeammateEnabled=" + this.accessToTeammateEnabled + ", helpCenterRequireSearch=" + this.helpCenterRequireSearch + ", preventMultipleInboundConversationsEnabled=" + this.preventMultipleInboundConversationsEnabled + ", hasOpenConversations=" + this.hasOpenConversations + ", modules=" + this.modules + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Config)) {
            return false;
        }
        Config config = (Config) obj;
        if (this.getName.equals(config.getName()) && ((str = this.getPrimaryColor) != null ? str.equals(config.getPrimaryColor()) : config.getPrimaryColor() == null) && ((str2 = this.getSecondaryColor) != null ? str2.equals(config.getSecondaryColor()) : config.getSecondaryColor() == null) && this.getWelcomeMessage.equals(config.getWelcomeMessage()) && this.getMessengerBackground.equals(config.getMessengerBackground()) && this.getMessenger4Background.equals(config.getMessenger4Background()) && this.getLocale.equals(config.getLocale()) && this.getHelpCenterLocale.equals(config.getHelpCenterLocale()) && this.getLauncherLogoUrl.equals(config.getLauncherLogoUrl()) && this.getMessengerLogoUrl.equals(config.getMessengerLogoUrl()) && this.getTeamIntro.equals(config.getTeamIntro()) && this.getTeamGreeting.equals(config.getTeamGreeting()) && this.isFirstRequest == config.isFirstRequest() && this.isInboundMessages == config.isInboundMessages() && this.isAttachmentsEnabled == config.isAttachmentsEnabled() && this.isGifsEnabled == config.isGifsEnabled() && this.temporaryExpectationsMessage.equals(config.temporaryExpectationsMessage()) && this.isShowPoweredBy == config.isShowPoweredBy() && this.isAudioEnabled == config.isAudioEnabled() && this.isMetricsEnabled == config.isMetricsEnabled() && this.isBackgroundRequestsEnabled == config.isBackgroundRequestsEnabled() && this.isPrimaryColorRenderDarkText == config.isPrimaryColorRenderDarkText() && this.isSecondaryColorRenderDarkText == config.isSecondaryColorRenderDarkText() && this.isHelpCenterColorRenderDarkText == config.isHelpCenterColorRenderDarkText() && this.getRateLimitPeriod == config.getRateLimitPeriod() && this.getRateLimitCount == config.getRateLimitCount() && this.getUserUpdateCacheMaxAge == config.getUserUpdateCacheMaxAge() && this.getSoftResetTimeout == config.getSoftResetTimeout() && this.getNewSessionThreshold == config.getNewSessionThreshold() && this.getUploadSizeLimit == config.getUploadSizeLimit() && this.getRealTimeConfig.equals(config.getRealTimeConfig()) && this.getHelpCenterUrl.equals(config.getHelpCenterUrl()) && this.getHelpCenterUrls.equals(config.getHelpCenterUrls()) && ((str3 = this.getHelpCenterBaseColor) != null ? str3.equals(config.getHelpCenterBaseColor()) : config.getHelpCenterBaseColor() == null) && this.getFeatures.equals(config.getFeatures()) && this.getIdentityVerificationEnabled == config.getIdentityVerificationEnabled() && this.accessToTeammateEnabled == config.accessToTeammateEnabled() && this.helpCenterRequireSearch == config.helpCenterRequireSearch() && this.preventMultipleInboundConversationsEnabled == config.preventMultipleInboundConversationsEnabled() && this.hasOpenConversations == config.hasOpenConversations() && this.modules.equals(config.modules())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.getName.hashCode() ^ 1000003) * 1000003;
        String str = this.getPrimaryColor;
        int i = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.getSecondaryColor;
        int i2 = 1231;
        int hashCode3 = (((((((((((((((((((((((((((((((((((((((((hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.getWelcomeMessage.hashCode()) * 1000003) ^ this.getMessengerBackground.hashCode()) * 1000003) ^ this.getMessenger4Background.hashCode()) * 1000003) ^ this.getLocale.hashCode()) * 1000003) ^ this.getHelpCenterLocale.hashCode()) * 1000003) ^ this.getLauncherLogoUrl.hashCode()) * 1000003) ^ this.getMessengerLogoUrl.hashCode()) * 1000003) ^ this.getTeamIntro.hashCode()) * 1000003) ^ this.getTeamGreeting.hashCode()) * 1000003) ^ (this.isFirstRequest ? 1231 : 1237)) * 1000003) ^ (this.isInboundMessages ? 1231 : 1237)) * 1000003) ^ (this.isAttachmentsEnabled ? 1231 : 1237)) * 1000003) ^ (this.isGifsEnabled ? 1231 : 1237)) * 1000003) ^ this.temporaryExpectationsMessage.hashCode()) * 1000003) ^ (this.isShowPoweredBy ? 1231 : 1237)) * 1000003) ^ (this.isAudioEnabled ? 1231 : 1237)) * 1000003) ^ (this.isMetricsEnabled ? 1231 : 1237)) * 1000003) ^ (this.isBackgroundRequestsEnabled ? 1231 : 1237)) * 1000003) ^ (this.isPrimaryColorRenderDarkText ? 1231 : 1237)) * 1000003) ^ (this.isSecondaryColorRenderDarkText ? 1231 : 1237)) * 1000003;
        int i3 = this.isHelpCenterColorRenderDarkText ? 1231 : 1237;
        long j = this.getRateLimitPeriod;
        long j2 = this.getUserUpdateCacheMaxAge;
        long j3 = this.getSoftResetTimeout;
        long j4 = this.getNewSessionThreshold;
        long j5 = this.getUploadSizeLimit;
        int hashCode4 = (((((((((((((((((((hashCode3 ^ i3) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.getRateLimitCount) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ this.getRealTimeConfig.hashCode()) * 1000003) ^ this.getHelpCenterUrl.hashCode()) * 1000003) ^ this.getHelpCenterUrls.hashCode()) * 1000003;
        String str3 = this.getHelpCenterBaseColor;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int hashCode5 = (((((((((((hashCode4 ^ i) * 1000003) ^ this.getFeatures.hashCode()) * 1000003) ^ (this.getIdentityVerificationEnabled ? 1231 : 1237)) * 1000003) ^ (this.accessToTeammateEnabled ? 1231 : 1237)) * 1000003) ^ (this.helpCenterRequireSearch ? 1231 : 1237)) * 1000003) ^ (this.preventMultipleInboundConversationsEnabled ? 1231 : 1237)) * 1000003;
        if (!this.hasOpenConversations) {
            i2 = 1237;
        }
        return ((hashCode5 ^ i2) * 1000003) ^ this.modules.hashCode();
    }
}
