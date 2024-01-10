package io.intercom.android.sdk.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lio/intercom/android/sdk/models/ConfigModules;", "", "customization", "Lio/intercom/android/sdk/models/CustomizationModel;", "home", "Lio/intercom/android/sdk/models/HomeConfig;", "(Lio/intercom/android/sdk/models/CustomizationModel;Lio/intercom/android/sdk/models/HomeConfig;)V", "getCustomization", "()Lio/intercom/android/sdk/models/CustomizationModel;", "getHome", "()Lio/intercom/android/sdk/models/HomeConfig;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModules.kt */
public final class ConfigModules {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ConfigModules DEFAULT = new ConfigModules(new CustomizationModel(new CustomizationColorsModel("", "", (String) null, 4, (DefaultConstructorMarker) null), new CustomizationColorsModel("", "", (String) null, 4, (DefaultConstructorMarker) null), "", "", new CustomizationColorsModel("", "", (String) null, 4, (DefaultConstructorMarker) null), 0, "", "", 0), (HomeConfig) null, 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ConfigModules DEFAULT_WITH_ACTION_COLORS = new ConfigModules(new CustomizationModel(new CustomizationColorsModel("#000000", "#FFFFFF", "#FFFFFF"), new CustomizationColorsModel("#000000", "#FAFAFA", (String) null, 4, (DefaultConstructorMarker) null), "", "", new CustomizationColorsModel("", "", (String) null, 4, (DefaultConstructorMarker) null), 0, "", "", 0), (HomeConfig) null, 2, (DefaultConstructorMarker) null);
    @SerializedName("customization")
    private final CustomizationModel customization;
    @SerializedName("home")
    private final HomeConfig home;

    public static /* synthetic */ ConfigModules copy$default(ConfigModules configModules, CustomizationModel customizationModel, HomeConfig homeConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            customizationModel = configModules.customization;
        }
        if ((i & 2) != 0) {
            homeConfig = configModules.home;
        }
        return configModules.copy(customizationModel, homeConfig);
    }

    public static final ConfigModules getDEFAULT_WITH_ACTION_COLORS() {
        return Companion.getDEFAULT_WITH_ACTION_COLORS();
    }

    public final CustomizationModel component1() {
        return this.customization;
    }

    public final HomeConfig component2() {
        return this.home;
    }

    public final ConfigModules copy(CustomizationModel customizationModel, HomeConfig homeConfig) {
        Intrinsics.checkNotNullParameter(customizationModel, "customization");
        Intrinsics.checkNotNullParameter(homeConfig, "home");
        return new ConfigModules(customizationModel, homeConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigModules)) {
            return false;
        }
        ConfigModules configModules = (ConfigModules) obj;
        return Intrinsics.areEqual((Object) this.customization, (Object) configModules.customization) && Intrinsics.areEqual((Object) this.home, (Object) configModules.home);
    }

    public int hashCode() {
        return (this.customization.hashCode() * 31) + this.home.hashCode();
    }

    public String toString() {
        return "ConfigModules(customization=" + this.customization + ", home=" + this.home + ')';
    }

    public ConfigModules(CustomizationModel customizationModel, HomeConfig homeConfig) {
        Intrinsics.checkNotNullParameter(customizationModel, "customization");
        Intrinsics.checkNotNullParameter(homeConfig, "home");
        this.customization = customizationModel;
        this.home = homeConfig;
    }

    public final CustomizationModel getCustomization() {
        return this.customization;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConfigModules(CustomizationModel customizationModel, HomeConfig homeConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(customizationModel, (i & 2) != 0 ? new HomeConfig((HeaderConfig) null, (OpenConfig) null, 3, (DefaultConstructorMarker) null) : homeConfig);
    }

    public final HomeConfig getHome() {
        return this.home;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lio/intercom/android/sdk/models/ConfigModules$Companion;", "", "()V", "DEFAULT", "Lio/intercom/android/sdk/models/ConfigModules;", "getDEFAULT", "()Lio/intercom/android/sdk/models/ConfigModules;", "DEFAULT_WITH_ACTION_COLORS", "getDEFAULT_WITH_ACTION_COLORS$annotations", "getDEFAULT_WITH_ACTION_COLORS", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ConfigModules.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getDEFAULT_WITH_ACTION_COLORS$annotations() {
        }

        private Companion() {
        }

        public final ConfigModules getDEFAULT() {
            return ConfigModules.DEFAULT;
        }

        public final ConfigModules getDEFAULT_WITH_ACTION_COLORS() {
            return ConfigModules.DEFAULT_WITH_ACTION_COLORS;
        }
    }
}
