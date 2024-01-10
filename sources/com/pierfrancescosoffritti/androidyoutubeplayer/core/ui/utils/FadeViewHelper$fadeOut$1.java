package com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.utils;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
/* compiled from: FadeViewHelper.kt */
final class FadeViewHelper$fadeOut$1 implements Runnable {
    final /* synthetic */ FadeViewHelper this$0;

    FadeViewHelper$fadeOut$1(FadeViewHelper fadeViewHelper) {
        this.this$0 = fadeViewHelper;
    }

    public final void run() {
        this.this$0.fade(0.0f);
    }
}
