package io.intercom.android.sdk.api;

import android.content.Context;
import android.content.SharedPreferences;
import com.intercom.commons.utilities.DeviceUtils;
import com.intercom.commons.utilities.TimeProvider;
import io.intercom.android.sdk.BuildConfig;
import io.intercom.android.sdk.identity.AppIdentity;
import io.intercom.android.sdk.utilities.PreferenceKeys;

public class ShutdownState {
    private static final String PREFS_SHUTDOWN_EXPIRY = "ShutdownExpiry";
    private static final String PREFS_SHUTDOWN_FINGERPRINT = "ShutdownFingerprint";
    private static final String PREFS_SHUTDOWN_REASON = "ShutdownReason";
    private final AppIdentity appIdentity;
    private final Context context;
    private final SharedPreferences prefs;
    long shutdownExpiry;
    String shutdownFingerprint;
    private String shutdownReason = this.prefs.getString(PREFS_SHUTDOWN_REASON, "");
    private final TimeProvider timeProvider;

    public ShutdownState(Context context2, AppIdentity appIdentity2, TimeProvider timeProvider2) {
        this.context = context2;
        this.appIdentity = appIdentity2;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(PreferenceKeys.INTERCOM_SHUTDOWN_PREFS, 0);
        this.prefs = sharedPreferences;
        this.timeProvider = timeProvider2;
        this.shutdownExpiry = sharedPreferences.getLong(PREFS_SHUTDOWN_EXPIRY, timeProvider2.currentTimeMillis());
        this.shutdownFingerprint = this.prefs.getString(PREFS_SHUTDOWN_FINGERPRINT, generateAppFingerprint(context2, appIdentity2));
    }

    public boolean canSendNetworkRequests() {
        boolean z = this.shutdownExpiry <= this.timeProvider.currentTimeMillis();
        boolean equals = this.shutdownFingerprint.equals(generateAppFingerprint(this.context, this.appIdentity));
        if (z || !equals) {
            return true;
        }
        return false;
    }

    public void updateShutdownState(long j, String str) {
        this.shutdownExpiry = this.timeProvider.currentTimeMillis() + j;
        this.shutdownReason = str;
        this.shutdownFingerprint = generateAppFingerprint(this.context, this.appIdentity);
        persistCachedAttributes();
    }

    public String getShutdownReason() {
        return this.shutdownReason;
    }

    private void persistCachedAttributes() {
        this.prefs.edit().putString(PREFS_SHUTDOWN_FINGERPRINT, this.shutdownFingerprint).putString(PREFS_SHUTDOWN_REASON, this.shutdownReason).putLong(PREFS_SHUTDOWN_EXPIRY, this.shutdownExpiry).apply();
    }

    private static String generateAppFingerprint(Context context2, AppIdentity appIdentity2) {
        return context2.getPackageName() + "-" + DeviceUtils.getAppVersion(context2) + "-" + appIdentity2.appId() + "-" + BuildConfig.VERSION_NAME;
    }
}
