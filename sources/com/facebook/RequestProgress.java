package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;

class RequestProgress {
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;
    private final GraphRequest request;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    RequestProgress(Handler handler, GraphRequest graphRequest) {
        this.request = graphRequest;
        this.callbackHandler = handler;
    }

    /* access modifiers changed from: package-private */
    public long getProgress() {
        return this.progress;
    }

    /* access modifiers changed from: package-private */
    public long getMaxProgress() {
        return this.maxProgress;
    }

    /* access modifiers changed from: package-private */
    public void addProgress(long j) {
        long j2 = this.progress + j;
        this.progress = j2;
        if (j2 >= this.lastReportedProgress + this.threshold || j2 >= this.maxProgress) {
            reportProgress();
        }
    }

    /* access modifiers changed from: package-private */
    public void addToMax(long j) {
        this.maxProgress += j;
    }

    /* access modifiers changed from: package-private */
    public void reportProgress() {
        if (this.progress > this.lastReportedProgress) {
            GraphRequest.Callback callback = this.request.getCallback();
            final long j = this.maxProgress;
            if (j > 0 && (callback instanceof GraphRequest.OnProgressCallback)) {
                final long j2 = this.progress;
                final GraphRequest.OnProgressCallback onProgressCallback = (GraphRequest.OnProgressCallback) callback;
                Handler handler = this.callbackHandler;
                if (handler == null) {
                    onProgressCallback.onProgress(j2, j);
                } else {
                    handler.post(new Runnable() {
                        public void run() {
                            if (!CrashShieldHandler.isObjectCrashing(this)) {
                                try {
                                    onProgressCallback.onProgress(j2, j);
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            }
                        }
                    });
                }
                this.lastReportedProgress = this.progress;
            }
        }
    }
}
