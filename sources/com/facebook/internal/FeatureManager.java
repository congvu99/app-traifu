package com.facebook.internal;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.facebook.FacebookSdk;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/internal/FeatureManager;", "", "()V", "FEATURE_MANAGER_STORE", "", "featureMapping", "", "Lcom/facebook/internal/FeatureManager$Feature;", "", "checkFeature", "", "feature", "callback", "Lcom/facebook/internal/FeatureManager$Callback;", "defaultStatus", "", "disableFeature", "getFeature", "className", "getGKStatus", "initializeFeatureMapping", "isEnabled", "Callback", "Feature", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: FeatureManager.kt */
public final class FeatureManager {
    private static final String FEATURE_MANAGER_STORE = "com.facebook.internal.FEATURE_MANAGER";
    public static final FeatureManager INSTANCE = new FeatureManager();
    private static final Map<Feature, String[]> featureMapping = new HashMap();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/FeatureManager$Callback;", "", "onCompleted", "", "enabled", "", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: FeatureManager.kt */
    public interface Callback {
        void onCompleted(boolean z);
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Feature.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Feature.RestrictiveDataFiltering.ordinal()] = 1;
            $EnumSwitchMapping$0[Feature.Instrument.ordinal()] = 2;
            $EnumSwitchMapping$0[Feature.CrashReport.ordinal()] = 3;
            $EnumSwitchMapping$0[Feature.CrashShield.ordinal()] = 4;
            $EnumSwitchMapping$0[Feature.ThreadCheck.ordinal()] = 5;
            $EnumSwitchMapping$0[Feature.ErrorReport.ordinal()] = 6;
            $EnumSwitchMapping$0[Feature.AAM.ordinal()] = 7;
            $EnumSwitchMapping$0[Feature.PrivacyProtection.ordinal()] = 8;
            $EnumSwitchMapping$0[Feature.SuggestedEvents.ordinal()] = 9;
            $EnumSwitchMapping$0[Feature.IntelligentIntegrity.ordinal()] = 10;
            $EnumSwitchMapping$0[Feature.ModelRequest.ordinal()] = 11;
            $EnumSwitchMapping$0[Feature.EventDeactivation.ordinal()] = 12;
            $EnumSwitchMapping$0[Feature.OnDeviceEventProcessing.ordinal()] = 13;
            $EnumSwitchMapping$0[Feature.OnDevicePostInstallEventProcessing.ordinal()] = 14;
            $EnumSwitchMapping$0[Feature.IapLogging.ordinal()] = 15;
            $EnumSwitchMapping$0[Feature.IapLoggingLib2.ordinal()] = 16;
            $EnumSwitchMapping$0[Feature.ChromeCustomTabsPrefetching.ordinal()] = 17;
            $EnumSwitchMapping$0[Feature.Monitoring.ordinal()] = 18;
            $EnumSwitchMapping$0[Feature.IgnoreAppSwitchToLoggedOut.ordinal()] = 19;
        }
    }

    private FeatureManager() {
    }

    @JvmStatic
    public static final void checkFeature(Feature feature, Callback callback) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        Intrinsics.checkNotNullParameter(callback, "callback");
        FetchedAppGateKeepersManager.loadAppGateKeepersAsync(new FeatureManager$checkFeature$1(callback, feature));
    }

    @JvmStatic
    public static final boolean isEnabled(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        String string = FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).getString(feature.toKey(), (String) null);
        if (string != null && Intrinsics.areEqual((Object) string, (Object) FacebookSdk.getSdkVersion())) {
            return false;
        }
        Feature parent = feature.getParent();
        if (parent == feature) {
            return INSTANCE.getGKStatus(feature);
        }
        if (!isEnabled(parent) || !INSTANCE.getGKStatus(feature)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void disableFeature(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        FacebookSdk.getApplicationContext().getSharedPreferences(FEATURE_MANAGER_STORE, 0).edit().putString(feature.toKey(), FacebookSdk.getSdkVersion()).apply();
    }

    @JvmStatic
    public static final Feature getFeature(String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        INSTANCE.initializeFeatureMapping();
        for (Map.Entry next : featureMapping.entrySet()) {
            Feature feature = (Feature) next.getKey();
            String[] strArr = (String[]) next.getValue();
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (StringsKt.startsWith$default(str, strArr[i], false, 2, (Object) null)) {
                        return feature;
                    }
                    i++;
                }
            }
        }
        return Feature.Unknown;
    }

    private final synchronized void initializeFeatureMapping() {
        if (featureMapping.isEmpty()) {
            featureMapping.put(Feature.AAM, new String[]{"com.facebook.appevents.aam."});
            featureMapping.put(Feature.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
            featureMapping.put(Feature.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
            featureMapping.put(Feature.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
            featureMapping.put(Feature.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
            featureMapping.put(Feature.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
            featureMapping.put(Feature.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
            featureMapping.put(Feature.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
            featureMapping.put(Feature.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
            featureMapping.put(Feature.IapLogging, new String[]{"com.facebook.appevents.iap."});
            featureMapping.put(Feature.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
        }
    }

    private final boolean getGKStatus(Feature feature) {
        return FetchedAppGateKeepersManager.getGateKeeperForKey(feature.toKey(), FacebookSdk.getApplicationId(), defaultStatus(feature));
    }

    private final boolean defaultStatus(Feature feature) {
        switch (WhenMappings.$EnumSwitchMapping$0[feature.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                return false;
            default:
                return true;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0001\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001%B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006&"}, d2 = {"Lcom/facebook/internal/FeatureManager$Feature;", "", "code", "", "(Ljava/lang/String;II)V", "parent", "getParent", "()Lcom/facebook/internal/FeatureManager$Feature;", "toKey", "", "toString", "Unknown", "Core", "AppEvents", "CodelessEvents", "RestrictiveDataFiltering", "AAM", "PrivacyProtection", "SuggestedEvents", "IntelligentIntegrity", "ModelRequest", "EventDeactivation", "OnDeviceEventProcessing", "OnDevicePostInstallEventProcessing", "IapLogging", "IapLoggingLib2", "Instrument", "CrashReport", "CrashShield", "ThreadCheck", "ErrorReport", "Monitoring", "Login", "ChromeCustomTabsPrefetching", "IgnoreAppSwitchToLoggedOut", "Share", "Places", "Companion", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: FeatureManager.kt */
    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        IntelligentIntegrity(66562),
        ModelRequest(66563),
        EventDeactivation(66816),
        OnDeviceEventProcessing(67072),
        OnDevicePostInstallEventProcessing(67073),
        IapLogging(67328),
        IapLoggingLib2(67329),
        Instrument(131072),
        CrashReport(131328),
        CrashShield(131329),
        ThreadCheck(131330),
        ErrorReport(131584),
        Monitoring(196608),
        Login(16777216),
        ChromeCustomTabsPrefetching(16842752),
        IgnoreAppSwitchToLoggedOut(16908288),
        Share(33554432),
        Places(50331648);
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final int code;

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] iArr = new int[Feature.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[Feature.Core.ordinal()] = 1;
                $EnumSwitchMapping$0[Feature.AppEvents.ordinal()] = 2;
                $EnumSwitchMapping$0[Feature.CodelessEvents.ordinal()] = 3;
                $EnumSwitchMapping$0[Feature.RestrictiveDataFiltering.ordinal()] = 4;
                $EnumSwitchMapping$0[Feature.Instrument.ordinal()] = 5;
                $EnumSwitchMapping$0[Feature.CrashReport.ordinal()] = 6;
                $EnumSwitchMapping$0[Feature.CrashShield.ordinal()] = 7;
                $EnumSwitchMapping$0[Feature.ThreadCheck.ordinal()] = 8;
                $EnumSwitchMapping$0[Feature.ErrorReport.ordinal()] = 9;
                $EnumSwitchMapping$0[Feature.AAM.ordinal()] = 10;
                $EnumSwitchMapping$0[Feature.PrivacyProtection.ordinal()] = 11;
                $EnumSwitchMapping$0[Feature.SuggestedEvents.ordinal()] = 12;
                $EnumSwitchMapping$0[Feature.IntelligentIntegrity.ordinal()] = 13;
                $EnumSwitchMapping$0[Feature.ModelRequest.ordinal()] = 14;
                $EnumSwitchMapping$0[Feature.EventDeactivation.ordinal()] = 15;
                $EnumSwitchMapping$0[Feature.OnDeviceEventProcessing.ordinal()] = 16;
                $EnumSwitchMapping$0[Feature.OnDevicePostInstallEventProcessing.ordinal()] = 17;
                $EnumSwitchMapping$0[Feature.IapLogging.ordinal()] = 18;
                $EnumSwitchMapping$0[Feature.IapLoggingLib2.ordinal()] = 19;
                $EnumSwitchMapping$0[Feature.Monitoring.ordinal()] = 20;
                $EnumSwitchMapping$0[Feature.Login.ordinal()] = 21;
                $EnumSwitchMapping$0[Feature.ChromeCustomTabsPrefetching.ordinal()] = 22;
                $EnumSwitchMapping$0[Feature.IgnoreAppSwitchToLoggedOut.ordinal()] = 23;
                $EnumSwitchMapping$0[Feature.Share.ordinal()] = 24;
                $EnumSwitchMapping$0[Feature.Places.ordinal()] = 25;
            }
        }

        private Feature(int i) {
            this.code = i;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public String toString() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return "CoreKit";
                case 2:
                    return "AppEvents";
                case 3:
                    return "CodelessEvents";
                case 4:
                    return "RestrictiveDataFiltering";
                case 5:
                    return "Instrument";
                case 6:
                    return "CrashReport";
                case 7:
                    return "CrashShield";
                case 8:
                    return "ThreadCheck";
                case 9:
                    return "ErrorReport";
                case 10:
                    return "AAM";
                case 11:
                    return "PrivacyProtection";
                case 12:
                    return "SuggestedEvents";
                case 13:
                    return "IntelligentIntegrity";
                case 14:
                    return "ModelRequest";
                case 15:
                    return "EventDeactivation";
                case 16:
                    return "OnDeviceEventProcessing";
                case 17:
                    return "OnDevicePostInstallEventProcessing";
                case 18:
                    return "IAPLogging";
                case 19:
                    return "IAPLoggingLib2";
                case 20:
                    return "Monitoring";
                case 21:
                    return "LoginKit";
                case 22:
                    return "ChromeCustomTabsPrefetching";
                case 23:
                    return "IgnoreAppSwitchToLoggedOut";
                case 24:
                    return "ShareKit";
                case 25:
                    return "PlacesKit";
                default:
                    return "unknown";
            }
        }

        public final String toKey() {
            return "FBSDKFeature" + this;
        }

        public final Feature getParent() {
            int i = this.code;
            if ((i & 255) > 0) {
                return Companion.fromInt(i & InputDeviceCompat.SOURCE_ANY);
            }
            if ((65280 & i) > 0) {
                return Companion.fromInt(i & SupportMenu.CATEGORY_MASK);
            }
            if ((16711680 & i) > 0) {
                return Companion.fromInt(i & ViewCompat.MEASURED_STATE_MASK);
            }
            return Companion.fromInt(0);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FeatureManager$Feature$Companion;", "", "()V", "fromInt", "Lcom/facebook/internal/FeatureManager$Feature;", "code", "", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
        /* compiled from: FeatureManager.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Feature fromInt(int i) {
                for (Feature feature : Feature.values()) {
                    if (feature.code == i) {
                        return feature;
                    }
                }
                return Feature.Unknown;
            }
        }
    }
}
