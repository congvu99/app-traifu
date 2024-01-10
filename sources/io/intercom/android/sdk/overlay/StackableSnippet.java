package io.intercom.android.sdk.overlay;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Handler;
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
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.overlay.InAppNotification;
import io.intercom.android.sdk.utilities.AvatarUtils;

class StackableSnippet extends InAppNotification implements View.OnTouchListener {
    private static final int BASE_ELEVATION = 18;
    private static final int BASE_MARGIN_DP = 16;
    private static final int ELEVATION_STEP = 3;
    private final Handler handler;

    public StackableSnippet(Context context, Conversation conversation, int i, Handler handler2, int i2, InAppNotification.Listener listener, Provider<AppConfig> provider) {
        super(context, conversation, i, i2, listener, provider);
        this.handler = handler2;
    }

    public void moveBackward(ViewGroup viewGroup, AnimatorListenerAdapter animatorListenerAdapter) {
        this.position++;
        animateToPosition(viewGroup.getContext());
    }

    public void display(ViewGroup viewGroup, LayoutInflater layoutInflater, boolean z, int i) {
        setupView(viewGroup, layoutInflater);
        setViewData(i);
        if (z) {
            animateOnScreen();
        } else {
            this.overlayRoot.setVisibility(0);
        }
    }

    public void update(Conversation conversation, Runnable runnable) {
        this.conversation = conversation;
        performReplyPulse(this.overlayRoot.findViewById(R.id.notification_root), this.overlayRoot.findViewById(R.id.in_app_notification_message_summary), runnable);
    }

    /* access modifiers changed from: protected */
    public void updateViewDataDuringReplyPulse(int i) {
        setViewData(i);
    }

    private void setupView(ViewGroup viewGroup, LayoutInflater layoutInflater) {
        if (this.overlayRoot == null) {
            this.overlayRoot = (ViewGroup) layoutInflater.inflate(R.layout.intercom_preview_notification, viewGroup, false);
        }
        if (!isAttached()) {
            viewGroup.addView(this.overlayRoot, 0);
        }
    }

    private void setViewData(int i) {
        Context context = this.overlayRoot.getContext();
        TextView textView = (TextView) this.overlayRoot.findViewById(R.id.reply_from_textview);
        textView.setText(getHeaderText());
        ((TextView) this.overlayRoot.findViewById(R.id.in_app_notification_message_summary)).setText(this.conversation.getLastPart().getSummary());
        ImageView imageView = (ImageView) this.overlayRoot.findViewById(R.id.preview_avatar);
        AvatarUtils.loadAvatarIntoView(this.conversation.getLastAdmin().getAvatar(), imageView, (AppConfig) this.appConfigProvider.get());
        ((FrameLayout.LayoutParams) this.overlayRoot.getLayoutParams()).bottomMargin = ScreenUtils.dpToPx((float) ((this.position * 8) + 16), context) + context.getResources().getDimensionPixelSize(R.dimen.intercom_bottom_padding) + i;
        ComposeView composeView = (ComposeView) this.overlayRoot.findViewById(R.id.ticket_header_compose_view);
        InAppNotificationCardKt.addTicketHeaderToCompose(composeView, this.conversation);
        if (this.conversation.getTicket() != Ticket.Companion.getNULL()) {
            textView.setVisibility(8);
            composeView.setVisibility(0);
        } else {
            textView.setVisibility(0);
            composeView.setVisibility(8);
        }
        this.overlayRoot.setElevation((float) (18 - (this.position * 3)));
        this.overlayRoot.setScaleX(1.0f - (((float) this.position) * 0.05f));
        if (this.position == 0) {
            beginListeningForTouchEvents();
        }
    }

    private void animateOnScreen() {
        this.handler.postDelayed(new Runnable() {
            public void run() {
                StackableSnippet.this.overlayRoot.setVisibility(0);
                StackableSnippet.this.overlayRoot.setY((float) StackableSnippet.this.screenHeight);
                StackableSnippet.this.overlayRoot.animate().setInterpolator(new OvershootInterpolator(0.6f)).translationY(0.0f).setDuration(300).start();
            }
        }, (long) (this.position * 70));
    }

    /* access modifiers changed from: protected */
    public void onNotificationPressed(View view) {
        view.animate().scaleX(0.95f).scaleY(0.95f).setDuration(50).start();
    }

    /* access modifiers changed from: protected */
    public void onNotificationReleased(View view) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(50).start();
    }
}
