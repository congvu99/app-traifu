package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomPreviewNotificationBinding implements ViewBinding {
    public final TextView inAppNotificationMessageSummary;
    public final FrameLayout notificationRoot;
    public final ImageView previewAvatar;
    public final TextView replyFromTextview;
    private final FrameLayout rootView;
    public final ComposeView ticketHeaderComposeView;

    private IntercomPreviewNotificationBinding(FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, ImageView imageView, TextView textView2, ComposeView composeView) {
        this.rootView = frameLayout;
        this.inAppNotificationMessageSummary = textView;
        this.notificationRoot = frameLayout2;
        this.previewAvatar = imageView;
        this.replyFromTextview = textView2;
        this.ticketHeaderComposeView = composeView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomPreviewNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomPreviewNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_preview_notification, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomPreviewNotificationBinding bind(View view) {
        int i = R.id.in_app_notification_message_summary;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i = R.id.preview_avatar;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.reply_from_textview;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.ticket_header_compose_view;
                    ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
                    if (composeView != null) {
                        return new IntercomPreviewNotificationBinding(frameLayout, textView, frameLayout, imageView, textView2, composeView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
