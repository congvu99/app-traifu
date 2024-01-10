package io.intercom.android.sdk.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.m5.notification.InAppNotificationCardKt;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.overlay.InAppNotification;
import io.intercom.android.sdk.utilities.AvatarUtils;

abstract class ChatNotification extends InAppNotification {
    private static final int ANIMATION_DURATION = 170;
    private static final int GROWTH_WIDTH = 355;

    /* access modifiers changed from: protected */
    public abstract View getContentContainer();

    /* access modifiers changed from: protected */
    public abstract ViewGroup inflateChatRootView(ViewGroup viewGroup, LayoutInflater layoutInflater);

    /* access modifiers changed from: protected */
    public abstract void updateContentContainer(Part part);

    /* access modifiers changed from: protected */
    public abstract void updateViewDataDuringReplyPulse(int i);

    protected ChatNotification(Context context, Conversation conversation, int i, int i2, InAppNotification.Listener listener, Provider<AppConfig> provider) {
        super(context, conversation, i, i2, listener, provider);
    }

    public void display(ViewGroup viewGroup, LayoutInflater layoutInflater, boolean z, int i) {
        if (this.overlayRoot == null) {
            this.overlayRoot = inflateChatRootView(viewGroup, layoutInflater);
        }
        if (!isAttached()) {
            viewGroup.addView(this.overlayRoot, 0);
        }
        if (this.bottomPadding != i) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.overlayRoot.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin + this.overlayRoot.getResources().getDimensionPixelSize(R.dimen.intercom_bottom_padding) + i);
            this.overlayRoot.setLayoutParams(layoutParams);
            this.bottomPadding = i;
        }
        populateViewsWithData();
        this.overlayRoot.setVisibility(0);
        beginListeningForTouchEvents();
    }

    /* access modifiers changed from: protected */
    public void onNotificationPressed(View view) {
        view.animate().scaleX(0.9f).scaleY(0.9f).alpha(0.9f).setDuration(50).start();
    }

    /* access modifiers changed from: protected */
    public void onNotificationReleased(View view) {
        view.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(50).start();
    }

    public void moveBackward(ViewGroup viewGroup, AnimatorListenerAdapter animatorListenerAdapter) {
        this.position++;
        animateToPosition(viewGroup.getContext());
        expandChat(viewGroup, animatorListenerAdapter);
    }

    private void populateViewsWithData() {
        View findViewById = this.overlayRoot.findViewById(R.id.chathead_root);
        TextView textView = (TextView) findViewById.findViewById(R.id.chathead_text_header);
        textView.setVisibility(0);
        textView.setText(getHeaderText());
        AvatarUtils.loadAvatarIntoView(this.conversation.getLastAdmin().getAvatar(), (ImageView) findViewById.findViewById(R.id.chathead_avatar), (AppConfig) this.appConfigProvider.get());
        updateContentContainer(this.conversation.getLastPart());
        ComposeView composeView = (ComposeView) findViewById.findViewById(R.id.ticket_header_compose_view);
        if (composeView != null) {
            InAppNotificationCardKt.addTicketHeaderToCompose(composeView, this.conversation);
            if (this.conversation.getTicket() != Ticket.Companion.getNULL()) {
                textView.setVisibility(8);
                composeView.setVisibility(0);
                return;
            }
            textView.setVisibility(0);
            composeView.setVisibility(8);
        }
    }

    private void performEntranceAnimation() {
        View findViewById = this.overlayRoot.findViewById(R.id.chat_avatar_container);
        final ViewGroup viewGroup = (ViewGroup) this.overlayRoot.findViewById(R.id.chat_full_body);
        viewGroup.setVisibility(4);
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(findViewById, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})}).setDuration(400);
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ChatNotification.this.animateTextContainer(viewGroup);
            }
        });
        duration.start();
    }

    /* access modifiers changed from: package-private */
    public void animateTextContainer(ViewGroup viewGroup) {
        viewGroup.setScaleX(0.8f);
        viewGroup.setScaleY(0.8f);
        viewGroup.setAlpha(0.8f);
        viewGroup.setX((float) (((int) viewGroup.getX()) - 150));
        viewGroup.setVisibility(0);
        viewGroup.animate().setInterpolator(new OvershootInterpolator(0.6f)).scaleX(1.0f).scaleY(1.0f).alphaBy(1.0f).translationX((float) ((int) viewGroup.getX())).setDuration(300).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ChatNotification.this.beginListeningForTouchEvents();
            }
        }).start();
    }

    private void expandChat(ViewGroup viewGroup, AnimatorListenerAdapter animatorListenerAdapter) {
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.chathead_text_container);
        if (viewGroup2 != null) {
            View contentContainer = getContentContainer();
            View findViewById = viewGroup.findViewById(R.id.chat_avatar_container);
            float translationX = findViewById.getTranslationX();
            float translationY = findViewById.getTranslationY();
            ObjectAnimator.ofPropertyValuesHolder(findViewById, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.8f}), PropertyValuesHolder.ofFloat("translationX", new float[]{translationX, translationX + 100.0f}), PropertyValuesHolder.ofFloat("translationY", new float[]{translationY, translationY - 40.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.8f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.8f})}).setDuration(170).start();
            ObjectAnimator.ofFloat((TextView) viewGroup.findViewById(R.id.chathead_text_header), View.ALPHA, new float[]{1.0f, 0.0f}).setDuration(170).start();
            ObjectAnimator.ofFloat(contentContainer, View.ALPHA, new float[]{1.0f, 0.0f}).setDuration(170).start();
            getWidthAnimator(viewGroup2, animatorListenerAdapter).start();
            getWidthAnimator(this.overlayRoot).start();
            getMarginAnimator(viewGroup2, (FrameLayout.LayoutParams) viewGroup2.getLayoutParams()).start();
        }
    }

    private Animator getMarginAnimator(final ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{layoutParams.leftMargin, 0});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.leftMargin = intValue;
                viewGroup.setLayoutParams(layoutParams);
            }
        });
        ofInt.setDuration(170);
        return ofInt;
    }

    private Animator getWidthAnimator(ViewGroup viewGroup, final Animator.AnimatorListener animatorListener) {
        final int abs = Math.abs(viewGroup.getMeasuredWidth() - ScreenUtils.dpToPx(355.0f, viewGroup.getContext()));
        ValueAnimator widthAnimator = getWidthAnimator(viewGroup);
        widthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            boolean hasSentUpdate = false;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                int i = abs;
                int i2 = 100;
                if (i > 0) {
                    i2 = (intValue / i) * 100;
                }
                if (i2 > 80 && !this.hasSentUpdate) {
                    this.hasSentUpdate = true;
                    animatorListener.onAnimationEnd((Animator) null);
                }
            }
        });
        return widthAnimator;
    }

    private ValueAnimator getWidthAnimator(final ViewGroup viewGroup) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{viewGroup.getMeasuredWidth(), ScreenUtils.dpToPx(355.0f, viewGroup.getContext())});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.width = intValue;
                viewGroup.setLayoutParams(layoutParams);
            }
        });
        ofInt.setDuration(170);
        return ofInt;
    }
}
