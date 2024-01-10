package com.facebook.appevents.iap;

import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicBoolean;

public final class InAppPurchaseManager {
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    private static boolean usingBillingLib2Plus() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
        }
        return false;
    }

    public static void enableAutoLogging() {
        Class<InAppPurchaseManager> cls = InAppPurchaseManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                enabled.set(true);
                startTracking();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void startTracking() {
        Class<InAppPurchaseManager> cls = InAppPurchaseManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!enabled.get()) {
                    return;
                }
                if (!usingBillingLib2Plus() || !FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib2)) {
                    InAppPurchaseActivityLifecycleTracker.startIapLogging();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
