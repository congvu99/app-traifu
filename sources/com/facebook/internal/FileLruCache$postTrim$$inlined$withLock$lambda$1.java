package com.facebook.internal;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/facebook/internal/FileLruCache$postTrim$1$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: FileLruCache.kt */
final class FileLruCache$postTrim$$inlined$withLock$lambda$1 implements Runnable {
    final /* synthetic */ FileLruCache this$0;

    FileLruCache$postTrim$$inlined$withLock$lambda$1(FileLruCache fileLruCache) {
        this.this$0 = fileLruCache;
    }

    public final void run() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    this.this$0.trim();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
