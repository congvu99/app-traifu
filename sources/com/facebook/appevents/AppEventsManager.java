package com.facebook.appevents;

import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;

public class AppEventsManager {
    public static void start() {
        Class<AppEventsManager> cls = AppEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FetchedAppSettingsManager.getAppSettingsAsync(new FetchedAppSettingsManager.FetchedAppSettingsCallback() {
                    public void onError() {
                    }

                    public void onSuccess(FetchedAppSettings fetchedAppSettings) {
                        FeatureManager.checkFeature(FeatureManager.Feature.AAM, new FeatureManager.Callback() {
                            public void onCompleted(boolean z) {
                                if (z) {
                                    MetadataIndexer.enable();
                                }
                            }
                        });
                        FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new FeatureManager.Callback() {
                            public void onCompleted(boolean z) {
                                if (z) {
                                    RestrictiveDataManager.enable();
                                }
                            }
                        });
                        FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new FeatureManager.Callback() {
                            public void onCompleted(boolean z) {
                                if (z) {
                                    ModelManager.enable();
                                }
                            }
                        });
                        FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new FeatureManager.Callback() {
                            public void onCompleted(boolean z) {
                                if (z) {
                                    EventDeactivationManager.enable();
                                }
                            }
                        });
                        FeatureManager.checkFeature(FeatureManager.Feature.IapLogging, new FeatureManager.Callback() {
                            public void onCompleted(boolean z) {
                                if (z) {
                                    InAppPurchaseManager.enableAutoLogging();
                                }
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
