package com.intercom.composer.animation;

import android.animation.Animator;
import androidx.recyclerview.widget.RecyclerView;
import com.intercom.composer.ComposerAnimationStateListener;
import com.intercom.composer.input.Input;
import com.intercom.composer.pager.ComposerPagerAdapter;
import java.util.List;

public class HideSendButtonAnimatorListener extends SendButtonAnimatorListener {
    public /* bridge */ /* synthetic */ void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
    }

    public HideSendButtonAnimatorListener(List<Input> list, ComposerPagerAdapter composerPagerAdapter, RecyclerView.Adapter adapter, ComposerAnimationStateListener composerAnimationStateListener) {
        super(list, composerPagerAdapter, adapter, composerAnimationStateListener);
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.animationStateListener.setSendButtonVisibility(8);
        if (!this.animationCanceled && emptyInputAdded()) {
            this.animationStateListener.onAnimationStateChanged(AnimationStatus.HIDDEN);
            this.inputs.remove(this.inputs.size() - 1);
            this.composerPagerAdapter.notifyDataSetChanged();
            this.recyclerAdapter.notifyItemRemoved(this.inputs.size());
        }
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        this.animationStateListener.onAnimationStateChanged(AnimationStatus.HIDING);
    }
}
