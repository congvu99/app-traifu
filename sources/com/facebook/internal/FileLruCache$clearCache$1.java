package com.facebook.internal;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: FileLruCache.kt */
final class FileLruCache$clearCache$1 implements Runnable {
    final /* synthetic */ File[] $filesToDelete;

    FileLruCache$clearCache$1(File[] fileArr) {
        this.$filesToDelete = fileArr;
    }

    public final void run() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    for (File delete : this.$filesToDelete) {
                        delete.delete();
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
