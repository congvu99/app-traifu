package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: FetchedAppSettingsManager.kt */
final class FetchedAppSettingsManager$loadAppSettingsAsync$1 implements Runnable {
    final /* synthetic */ String $applicationId;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $settingsKey;

    FetchedAppSettingsManager$loadAppSettingsAsync$1(Context context, String str, String str2) {
        this.$context = context;
        this.$settingsKey = str;
        this.$applicationId = str2;
    }

    public final void run() {
        SharedPreferences sharedPreferences;
        FetchedAppSettings fetchedAppSettings;
        FetchedAppSettingsManager.FetchAppSettingState fetchAppSettingState;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        sharedPreferences = this.$context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
                        String string = sharedPreferences.getString(this.$settingsKey, (String) null);
                        fetchedAppSettings = null;
                        if (!Utility.isNullOrEmpty(string)) {
                            if (string != null) {
                                JSONObject jSONObject = null;
                                jSONObject = new JSONObject(string);
                                if (jSONObject != null) {
                                    FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                                    String str = this.$applicationId;
                                    Intrinsics.checkNotNullExpressionValue(str, "applicationId");
                                    fetchedAppSettings = fetchedAppSettingsManager.parseAppSettingsFromJSON(str, jSONObject);
                                }
                            } else {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                        }
                    } catch (JSONException e) {
                        Utility.logd(Utility.LOG_TAG, (Exception) e);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                        return;
                    }
                    FetchedAppSettingsManager fetchedAppSettingsManager2 = FetchedAppSettingsManager.INSTANCE;
                    String str2 = this.$applicationId;
                    Intrinsics.checkNotNullExpressionValue(str2, "applicationId");
                    JSONObject access$getAppSettingsQueryResponse = fetchedAppSettingsManager2.getAppSettingsQueryResponse(str2);
                    if (access$getAppSettingsQueryResponse != null) {
                        FetchedAppSettingsManager fetchedAppSettingsManager3 = FetchedAppSettingsManager.INSTANCE;
                        String str3 = this.$applicationId;
                        Intrinsics.checkNotNullExpressionValue(str3, "applicationId");
                        fetchedAppSettingsManager3.parseAppSettingsFromJSON(str3, access$getAppSettingsQueryResponse);
                        sharedPreferences.edit().putString(this.$settingsKey, access$getAppSettingsQueryResponse.toString()).apply();
                    }
                    if (fetchedAppSettings != null) {
                        String sdkUpdateMessage = fetchedAppSettings.getSdkUpdateMessage();
                        if (!FetchedAppSettingsManager.printedSDKUpdatedMessage && sdkUpdateMessage != null && sdkUpdateMessage.length() > 0) {
                            FetchedAppSettingsManager.printedSDKUpdatedMessage = true;
                            Log.w(FetchedAppSettingsManager.TAG, sdkUpdateMessage);
                        }
                    }
                    String str4 = this.$applicationId;
                    Intrinsics.checkNotNullExpressionValue(str4, "applicationId");
                    FetchedAppGateKeepersManager.queryAppGateKeepers(str4, true);
                    AutomaticAnalyticsLogger.logActivateAppEvent();
                    AtomicReference access$getLoadingState$p = FetchedAppSettingsManager.loadingState;
                    if (FetchedAppSettingsManager.fetchedAppSettings.containsKey(this.$applicationId)) {
                        fetchAppSettingState = FetchedAppSettingsManager.FetchAppSettingState.SUCCESS;
                    } else {
                        fetchAppSettingState = FetchedAppSettingsManager.FetchAppSettingState.ERROR;
                    }
                    access$getLoadingState$p.set(fetchAppSettingState);
                    FetchedAppSettingsManager.INSTANCE.pollCallbacks();
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }
}
