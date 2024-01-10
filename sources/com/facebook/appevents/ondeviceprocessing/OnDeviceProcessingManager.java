package com.facebook.appevents.ondeviceprocessing;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OnDeviceProcessingManager {
    private static final Set<String> ALLOWED_IMPLICIT_EVENTS = new HashSet(Arrays.asList(new String[]{AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_START_TRIAL, AppEventsConstants.EVENT_NAME_SUBSCRIBE}));

    public static boolean isOnDeviceProcessingEnabled() {
        Class<OnDeviceProcessingManager> cls = OnDeviceProcessingManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (!(!FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext()) && !Utility.isDataProcessingRestricted()) || !RemoteServiceWrapper.isServiceAvailable()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static void sendInstallEventAsync(final String str, final String str2) {
        Class<OnDeviceProcessingManager> cls = OnDeviceProcessingManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                final Context applicationContext = FacebookSdk.getApplicationContext();
                if (applicationContext != null && str != null && str2 != null) {
                    FacebookSdk.getExecutor().execute(new Runnable() {
                        public void run() {
                            if (!CrashShieldHandler.isObjectCrashing(this)) {
                                try {
                                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
                                    String str = str + "pingForOnDevice";
                                    if (sharedPreferences.getLong(str, 0) == 0) {
                                        RemoteServiceWrapper.sendInstallEvent(str);
                                        SharedPreferences.Editor edit = sharedPreferences.edit();
                                        edit.putLong(str, System.currentTimeMillis());
                                        edit.apply();
                                    }
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void sendCustomEventAsync(final String str, final AppEvent appEvent) {
        Class<OnDeviceProcessingManager> cls = OnDeviceProcessingManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (isEventEligibleForOnDeviceProcessing(appEvent)) {
                    FacebookSdk.getExecutor().execute(new Runnable() {
                        public void run() {
                            if (!CrashShieldHandler.isObjectCrashing(this)) {
                                try {
                                    RemoteServiceWrapper.sendCustomEvents(str, Arrays.asList(new AppEvent[]{appEvent}));
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static boolean isEventEligibleForOnDeviceProcessing(AppEvent appEvent) {
        Class<OnDeviceProcessingManager> cls = OnDeviceProcessingManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            boolean z = appEvent.getIsImplicit() && ALLOWED_IMPLICIT_EVENTS.contains(appEvent.getName());
            if ((!appEvent.getIsImplicit()) || z) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }
}
