package io.intercom.android.sdk.blocks;

import android.text.TextUtils;
import android.view.View;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.utilities.LinkOpener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/intercom/android/sdk/blocks/CarouselImageClickListener;", "Lio/intercom/android/sdk/blocks/ImageClickListener;", "api", "Lio/intercom/android/sdk/api/Api;", "(Lio/intercom/android/sdk/api/Api;)V", "onImageClicked", "", "imageUrl", "", "linkUrl", "imageView", "Landroid/view/View;", "width", "", "height", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CarouselImageClickListener.kt */
public final class CarouselImageClickListener implements ImageClickListener {
    private final Api api;

    public CarouselImageClickListener(Api api2) {
        Intrinsics.checkNotNullParameter(api2, MetricTracker.Place.API);
        this.api = api2;
    }

    public void onImageClicked(String str, String str2, View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        Intrinsics.checkNotNullParameter(str2, "linkUrl");
        Intrinsics.checkNotNullParameter(view, "imageView");
        if (!TextUtils.isEmpty(str2)) {
            LinkOpener.handleUrl(str2, view.getContext(), this.api);
        }
    }
}
