package com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.utils;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/pierfrancescosoffritti/androidyoutubeplayer/core/ui/utils/FadeViewHelper$fade$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: FadeViewHelper.kt */
public final class FadeViewHelper$fade$1 implements Animator.AnimatorListener {
    final /* synthetic */ float $finalAlpha;
    final /* synthetic */ FadeViewHelper this$0;

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
    }

    FadeViewHelper$fade$1(FadeViewHelper fadeViewHelper, float f) {
        this.this$0 = fadeViewHelper;
        this.$finalAlpha = f;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        if (this.$finalAlpha == 1.0f) {
            this.this$0.getTargetView().setVisibility(0);
        }
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        if (this.$finalAlpha == 0.0f) {
            this.this$0.getTargetView().setVisibility(8);
        }
    }
}
