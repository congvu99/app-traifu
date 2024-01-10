package io.intercom.android.sdk.helpcenter.utils;

import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"setMaxWidthToScreen", "", "Landroid/widget/TextView;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: RtlUtil.kt */
public final class RtlUtilKt {
    public static final void setMaxWidthToScreen(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        int i = textView.getResources().getDisplayMetrics().widthPixels;
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        textView.setMaxWidth((i - marginLayoutParams.getMarginStart()) - marginLayoutParams.getMarginEnd());
    }
}
