package com.facebook.internal;

import android.graphics.Bitmap;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: ImageDownloader.kt */
final class ImageDownloader$issueResponse$1 implements Runnable {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ ImageRequest.Callback $callback;
    final /* synthetic */ Exception $error;
    final /* synthetic */ boolean $isCachedRedirect;
    final /* synthetic */ ImageRequest $request;

    ImageDownloader$issueResponse$1(ImageRequest imageRequest, Exception exc, boolean z, Bitmap bitmap, ImageRequest.Callback callback) {
        this.$request = imageRequest;
        this.$error = exc;
        this.$isCachedRedirect = z;
        this.$bitmap = bitmap;
        this.$callback = callback;
    }

    public final void run() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    this.$callback.onCompleted(new ImageResponse(this.$request, this.$error, this.$isCachedRedirect, this.$bitmap));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
