package io.intercom.android.sdk.helpcenter.articles;

import androidx.constraintlayout.motion.widget.MotionLayout;
import io.intercom.android.sdk.databinding.IntercomFragmentHelpCenterArticleBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"io/intercom/android/sdk/helpcenter/articles/ArticleFragment$renderContent$1$2", "Landroidx/constraintlayout/motion/widget/MotionLayout$TransitionListener;", "onTransitionChange", "", "p0", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "p1", "", "p2", "p3", "", "onTransitionCompleted", "onTransitionStarted", "onTransitionTrigger", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleFragment.kt */
public final class ArticleFragment$renderContent$1$2 implements MotionLayout.TransitionListener {
    final /* synthetic */ IntercomFragmentHelpCenterArticleBinding $this_with;

    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
    }

    public void onTransitionStarted(MotionLayout motionLayout, int i, int i2) {
    }

    public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f) {
    }

    ArticleFragment$renderContent$1$2(IntercomFragmentHelpCenterArticleBinding intercomFragmentHelpCenterArticleBinding) {
        this.$this_with = intercomFragmentHelpCenterArticleBinding;
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
        this.$this_with.articleScrollview.post(new Runnable(this) {
            public final /* synthetic */ ArticleFragment$renderContent$1$2 f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ArticleFragment$renderContent$1$2.m5099onTransitionCompleted$lambda0(IntercomFragmentHelpCenterArticleBinding.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onTransitionCompleted$lambda-0  reason: not valid java name */
    public static final void m5099onTransitionCompleted$lambda0(IntercomFragmentHelpCenterArticleBinding intercomFragmentHelpCenterArticleBinding, ArticleFragment$renderContent$1$2 articleFragment$renderContent$1$2) {
        Intrinsics.checkNotNullParameter(intercomFragmentHelpCenterArticleBinding, "$this_with");
        Intrinsics.checkNotNullParameter(articleFragment$renderContent$1$2, "this$0");
        intercomFragmentHelpCenterArticleBinding.articleScrollview.smoothScrollTo(0, intercomFragmentHelpCenterArticleBinding.articleTeamHelp.getBottom());
        intercomFragmentHelpCenterArticleBinding.articleReactions.motionLayout.removeTransitionListener(articleFragment$renderContent$1$2);
    }
}
