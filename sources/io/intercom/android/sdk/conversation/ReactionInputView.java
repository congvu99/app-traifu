package io.intercom.android.sdk.conversation;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import coil.request.ImageRequest;
import coil.target.Target;
import com.intercom.commons.utilities.DeviceUtils;
import com.intercom.commons.utilities.ScreenUtils;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.models.Reaction;
import io.intercom.android.sdk.models.ReactionReply;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.IntercomCoilKt;
import java.util.ArrayList;
import java.util.List;

public class ReactionInputView extends LinearLayout {
    private static final float REACTION_SCALE = 2.5f;
    private static final int VIBRATION_DURATION_MS = 10;
    private final ColorFilter deselectedFilter;
    Integer highlightedViewIndex;
    private ReactionListener listener;
    private ReactionReply reactionReply;
    private final List<ImageView> reactionViews;
    int reactionsLoaded;
    private final View.OnTouchListener touchListener;
    private final Twig twig;
    private final Vibrator vibrator;

    public ReactionInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ReactionInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.twig = LumberMill.getLogger();
        this.highlightedViewIndex = null;
        this.reactionsLoaded = 0;
        this.touchListener = new View.OnTouchListener() {
            private final Rect touchRect = new Rect();

            /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
                if (r3 != 2) goto L_0x0016;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean onTouch(android.view.View r3, android.view.MotionEvent r4) {
                /*
                    r2 = this;
                    int r3 = r4.getActionMasked()
                    r0 = 1
                    if (r3 == 0) goto L_0x0013
                    if (r3 == r0) goto L_0x000d
                    r1 = 2
                    if (r3 == r1) goto L_0x0013
                    goto L_0x0016
                L_0x000d:
                    io.intercom.android.sdk.conversation.ReactionInputView r3 = io.intercom.android.sdk.conversation.ReactionInputView.this
                    r3.handleTouchUp()
                    goto L_0x0016
                L_0x0013:
                    r2.handleTouchMove(r4)
                L_0x0016:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.conversation.ReactionInputView.AnonymousClass2.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }

            private void handleTouchMove(MotionEvent motionEvent) {
                ReactionInputView.this.getHitRect(this.touchRect);
                if (this.touchRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    for (int i = 0; i < ReactionInputView.this.getChildCount(); i++) {
                        ReactionInputView.this.getChildAt(i).getHitRect(this.touchRect);
                        if (this.touchRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            if (ReactionInputView.this.highlightedViewIndex == null || ReactionInputView.this.highlightedViewIndex.intValue() != i) {
                                ReactionInputView.this.vibrateForSelection();
                                ReactionInputView.this.selectViewAtIndex(ReactionInputView.REACTION_SCALE, i);
                            }
                            if (ReactionInputView.this.highlightedViewIndex == null) {
                                Integer currentSelectedIndex = ReactionInputView.this.getCurrentSelectedIndex();
                                if (!(currentSelectedIndex == null || currentSelectedIndex.intValue() == i)) {
                                    ReactionInputView.this.deselectViewAtIndex(currentSelectedIndex.intValue());
                                }
                            } else if (ReactionInputView.this.highlightedViewIndex.intValue() != i) {
                                ReactionInputView reactionInputView = ReactionInputView.this;
                                reactionInputView.deselectViewAtIndex(reactionInputView.highlightedViewIndex.intValue());
                            }
                            ReactionInputView.this.highlightedViewIndex = Integer.valueOf(i);
                        }
                    }
                    return;
                }
                if (ReactionInputView.this.highlightedViewIndex != null) {
                    ReactionInputView.this.highlightSelectedReaction();
                }
                ReactionInputView.this.highlightedViewIndex = null;
            }
        };
        this.reactionViews = new ArrayList();
        setVisibility(8);
        if (isInEditMode()) {
            this.vibrator = null;
        } else {
            this.vibrator = (Vibrator) context.getSystemService("vibrator");
        }
        this.deselectedFilter = ColorUtils.newGreyscaleFilter();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnTouchListener(this.touchListener);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnTouchListener((View.OnTouchListener) null);
    }

    public void setUpReactions(ReactionReply reactionReply2, boolean z, ReactionListener reactionListener) {
        Context context = getContext();
        this.reactionReply = reactionReply2;
        this.listener = reactionListener;
        resetView();
        List<Reaction> reactionSet = reactionReply2.getReactionSet();
        int size = reactionSet.size();
        boolean z2 = false;
        int i = 0;
        while (i < reactionSet.size()) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setClipChildren(z2);
            frameLayout.setClipToPadding(z2);
            frameLayout.setLayoutParams(new LinearLayout.LayoutParams(z2 ? 1 : 0, -1, 1.0f));
            final ImageView imageView = new ImageView(context);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.intercom_reaction_size);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize, 17));
            imageView.setPivotY((float) getResources().getDimensionPixelSize(R.dimen.intercom_reaction_offset));
            imageView.setPivotX((float) (dimensionPixelSize / 2));
            this.reactionViews.add(imageView);
            frameLayout.addView(imageView);
            Reaction reaction = reactionSet.get(i);
            ImageRequest.Builder builder = new ImageRequest.Builder(context);
            final int i2 = size;
            final boolean z3 = z;
            AnonymousClass1 r11 = r0;
            final Context context2 = context;
            AnonymousClass1 r0 = new Target() {
                public void onError(Drawable drawable) {
                }

                public void onStart(Drawable drawable) {
                }

                public void onSuccess(Drawable drawable) {
                    imageView.setImageDrawable(drawable);
                    ReactionInputView.this.reactionsLoaded++;
                    if (ReactionInputView.this.reactionsLoaded != i2) {
                        return;
                    }
                    if (z3) {
                        ReactionInputView.this.setVisibility(0);
                        ReactionInputView reactionInputView = ReactionInputView.this;
                        reactionInputView.setY((float) (reactionInputView.getHeight() + ScreenUtils.dpToPx(60.0f, context2)));
                        ReactionInputView.this.animate().setInterpolator(new OvershootInterpolator(0.6f)).translationY(0.0f).setDuration(300).start();
                        return;
                    }
                    ReactionInputView.this.setVisibility(0);
                }
            };
            IntercomCoilKt.loadIntercomImage(context, builder.target((Target) r11).data(reaction.getImageUrl()).build());
            Integer reactionIndex = reactionReply2.getReactionIndex();
            if (reactionIndex != null && !reactionIndex.equals(Integer.valueOf(reaction.getIndex()))) {
                deselectViewAtIndex(i);
            }
            addView(frameLayout);
            i++;
            z2 = false;
        }
    }

    public void preloadReactionImages(ReactionReply reactionReply2) {
        for (Reaction imageUrl : reactionReply2.getReactionSet()) {
            IntercomCoilKt.loadIntercomImage(getContext(), new ImageRequest.Builder(getContext()).data(imageUrl.getImageUrl()).build());
        }
    }

    /* access modifiers changed from: package-private */
    public void vibrateForSelection() {
        if (DeviceUtils.hasPermission(getContext(), "android.permission.VIBRATE")) {
            this.vibrator.vibrate(10);
        }
    }

    /* access modifiers changed from: package-private */
    public void handleTouchUp() {
        Reaction reaction;
        Integer num = this.highlightedViewIndex;
        if (num != null && num.intValue() >= 0 && this.highlightedViewIndex.intValue() < this.reactionReply.getReactionSet().size() && (reaction = this.reactionReply.getReactionSet().get(this.highlightedViewIndex.intValue())) != null && (this.reactionReply.getReactionIndex() == null || reaction.getIndex() != this.reactionReply.getReactionIndex().intValue())) {
            this.reactionReply.setReactionIndex(reaction.getIndex());
            ReactionListener reactionListener = this.listener;
            if (reactionListener != null) {
                reactionListener.onReactionSelected(reaction);
            }
        }
        highlightSelectedReaction();
        this.highlightedViewIndex = null;
    }

    /* access modifiers changed from: package-private */
    public void highlightSelectedReaction() {
        for (int i = 0; i < getChildCount(); i++) {
            Integer reactionIndex = this.reactionReply.getReactionIndex();
            Reaction reaction = this.reactionReply.getReactionSet().get(i);
            if (reactionIndex == null || reactionIndex.equals(Integer.valueOf(reaction.getIndex()))) {
                selectViewAtIndex(1.0f, i);
            } else {
                deselectViewAtIndex(i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Integer getCurrentSelectedIndex() {
        for (int i = 0; i < getChildCount(); i++) {
            Integer reactionIndex = this.reactionReply.getReactionIndex();
            Reaction reaction = this.reactionReply.getReactionSet().get(i);
            if (reactionIndex == null || reactionIndex.equals(Integer.valueOf(reaction.getIndex()))) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void selectViewAtIndex(float f, int i) {
        ImageView imageView = this.reactionViews.get(i);
        imageView.animate().setInterpolator(new OvershootInterpolator(2.0f)).scaleX(f).scaleY(f).setDuration(200).start();
        imageView.clearColorFilter();
    }

    /* access modifiers changed from: package-private */
    public void deselectViewAtIndex(int i) {
        ImageView imageView = this.reactionViews.get(i);
        imageView.animate().setInterpolator(new OvershootInterpolator(0.6f)).scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
        imageView.setColorFilter(this.deselectedFilter);
    }

    private void resetView() {
        removeAllViews();
        this.reactionViews.clear();
    }
}
