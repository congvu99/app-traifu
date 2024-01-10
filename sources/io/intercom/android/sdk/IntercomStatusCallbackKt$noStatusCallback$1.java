package io.intercom.android.sdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"io/intercom/android/sdk/IntercomStatusCallbackKt$noStatusCallback$1", "Lio/intercom/android/sdk/IntercomStatusCallback;", "onFailure", "", "intercomError", "Lio/intercom/android/sdk/IntercomError;", "onSuccess", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomStatusCallback.kt */
public final class IntercomStatusCallbackKt$noStatusCallback$1 implements IntercomStatusCallback {
    public void onFailure(IntercomError intercomError) {
        Intrinsics.checkNotNullParameter(intercomError, "intercomError");
    }

    public void onSuccess() {
    }

    IntercomStatusCallbackKt$noStatusCallback$1() {
    }
}
