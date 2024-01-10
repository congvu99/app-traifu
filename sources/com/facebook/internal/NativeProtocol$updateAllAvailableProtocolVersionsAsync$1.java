package com.facebook.internal;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: NativeProtocol.kt */
final class NativeProtocol$updateAllAvailableProtocolVersionsAsync$1 implements Runnable {
    public static final NativeProtocol$updateAllAvailableProtocolVersionsAsync$1 INSTANCE = new NativeProtocol$updateAllAvailableProtocolVersionsAsync$1();

    NativeProtocol$updateAllAvailableProtocolVersionsAsync$1() {
    }

    public final void run() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        for (NativeProtocol.NativeAppInfo fetchAvailableVersions : NativeProtocol.access$getFacebookAppInfoList$p(NativeProtocol.INSTANCE)) {
                            fetchAvailableVersions.fetchAvailableVersions(true);
                        }
                        NativeProtocol.access$getProtocolVersionsAsyncUpdating$p(NativeProtocol.INSTANCE).set(false);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }
}
