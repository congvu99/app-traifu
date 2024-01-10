package com.facebook.appevents.ondeviceprocessing;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

class RemoteServiceParametersHelper {
    private static final String TAG = RemoteServiceWrapper.class.getSimpleName();

    RemoteServiceParametersHelper() {
    }

    static Bundle buildEventsBundle(RemoteServiceWrapper.EventType eventType, String str, List<AppEvent> list) {
        Class<RemoteServiceParametersHelper> cls = RemoteServiceParametersHelper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList(list);
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompat.CATEGORY_EVENT, eventType.toString());
            bundle.putString("app_id", str);
            if (RemoteServiceWrapper.EventType.CUSTOM_APP_EVENTS == eventType) {
                JSONArray buildEventsJson = buildEventsJson(arrayList, str);
                if (buildEventsJson.length() == 0) {
                    return null;
                }
                bundle.putString("custom_events", buildEventsJson.toString());
            }
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static JSONArray buildEventsJson(List<AppEvent> list, String str) {
        Class<RemoteServiceParametersHelper> cls = RemoteServiceParametersHelper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            EventDeactivationManager.processEvents(list);
            boolean includeImplicitEvents = includeImplicitEvents(str);
            for (AppEvent next : list) {
                if (!next.isChecksumValid()) {
                    String str2 = TAG;
                    Utility.logd(str2, "Event with invalid checksum: " + next.toString());
                } else if ((!next.getIsImplicit()) || (next.getIsImplicit() && includeImplicitEvents)) {
                    jSONArray.put(next.getJSONObject());
                }
            }
            return jSONArray;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static boolean includeImplicitEvents(String str) {
        Class<RemoteServiceParametersHelper> cls = RemoteServiceParametersHelper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(str, false);
            if (queryAppSettings != null) {
                return queryAppSettings.supportsImplicitLogging();
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }
}
