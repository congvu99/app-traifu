package com.facebook.internal;

import android.content.Intent;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.UUID;

public class AppCall {
    private static AppCall currentPendingCall;
    private UUID callId;
    private int requestCode;
    private Intent requestIntent;

    public static AppCall getCurrentPendingCall() {
        Class<AppCall> cls = AppCall.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return currentPendingCall;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.facebook.internal.AppCall finishPendingCall(java.util.UUID r4, int r5) {
        /*
            java.lang.Class<com.facebook.internal.AppCall> r0 = com.facebook.internal.AppCall.class
            monitor-enter(r0)
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)     // Catch:{ all -> 0x0030 }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)
            return r2
        L_0x000c:
            com.facebook.internal.AppCall r1 = getCurrentPendingCall()     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0028
            java.util.UUID r3 = r1.getCallId()     // Catch:{ all -> 0x002a }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x002a }
            if (r4 == 0) goto L_0x0028
            int r4 = r1.getRequestCode()     // Catch:{ all -> 0x002a }
            if (r4 == r5) goto L_0x0023
            goto L_0x0028
        L_0x0023:
            setCurrentPendingCall(r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)
            return r1
        L_0x0028:
            monitor-exit(r0)
            return r2
        L_0x002a:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r0)     // Catch:{ all -> 0x0030 }
            monitor-exit(r0)
            return r2
        L_0x0030:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AppCall.finishPendingCall(java.util.UUID, int):com.facebook.internal.AppCall");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized boolean setCurrentPendingCall(com.facebook.internal.AppCall r3) {
        /*
            java.lang.Class<com.facebook.internal.AppCall> r0 = com.facebook.internal.AppCall.class
            monitor-enter(r0)
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)     // Catch:{ all -> 0x001d }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)
            return r2
        L_0x000c:
            com.facebook.internal.AppCall r1 = getCurrentPendingCall()     // Catch:{ all -> 0x0017 }
            currentPendingCall = r3     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x0015
            r2 = 1
        L_0x0015:
            monitor-exit(r0)
            return r2
        L_0x0017:
            r3 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r0)     // Catch:{ all -> 0x001d }
            monitor-exit(r0)
            return r2
        L_0x001d:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AppCall.setCurrentPendingCall(com.facebook.internal.AppCall):boolean");
    }

    public AppCall(int i) {
        this(i, UUID.randomUUID());
    }

    public AppCall(int i, UUID uuid) {
        this.callId = uuid;
        this.requestCode = i;
    }

    public Intent getRequestIntent() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.requestIntent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public UUID getCallId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.callId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public int getRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return this.requestCode;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public void setRequestCode(int i) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.requestCode = i;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void setRequestIntent(Intent intent) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.requestIntent = intent;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public boolean setPending() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return setCurrentPendingCall(this);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
