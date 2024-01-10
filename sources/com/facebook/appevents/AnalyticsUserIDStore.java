package com.facebook.appevents;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class AnalyticsUserIDStore {
    private static final String ANALYTICS_USER_ID_KEY = "com.facebook.appevents.AnalyticsUserIDStore.userID";
    private static final String TAG = AnalyticsUserIDStore.class.getSimpleName();
    private static volatile boolean initialized = false;
    /* access modifiers changed from: private */
    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /* access modifiers changed from: private */
    public static String userID;

    AnalyticsUserIDStore() {
    }

    public static void initStore() {
        if (!initialized) {
            InternalAppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
                public void run() {
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        try {
                            AnalyticsUserIDStore.initAndWait();
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                }
            });
        }
    }

    public static void setUserID(final String str) {
        AppEventUtility.assertIsNotMainThread();
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            initAndWait();
        }
        InternalAppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            public void run() {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        AnalyticsUserIDStore.lock.writeLock().lock();
                        String unused = AnalyticsUserIDStore.userID = str;
                        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
                        edit.putString(AnalyticsUserIDStore.ANALYTICS_USER_ID_KEY, AnalyticsUserIDStore.userID);
                        edit.apply();
                        AnalyticsUserIDStore.lock.writeLock().unlock();
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            }
        });
    }

    public static String getUserID() {
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            initAndWait();
        }
        lock.readLock().lock();
        try {
            return userID;
        } finally {
            lock.readLock().unlock();
        }
    }

    /* access modifiers changed from: private */
    public static void initAndWait() {
        if (!initialized) {
            lock.writeLock().lock();
            try {
                if (!initialized) {
                    userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString(ANALYTICS_USER_ID_KEY, (String) null);
                    initialized = true;
                    lock.writeLock().unlock();
                }
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}
