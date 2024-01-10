package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomViewConversationCardAvatarBinding implements ViewBinding {
    public final ImageView avatarView;
    private final ImageView rootView;

    private IntercomViewConversationCardAvatarBinding(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.avatarView = imageView2;
    }

    public ImageView getRoot() {
        return this.rootView;
    }

    public static IntercomViewConversationCardAvatarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomViewConversationCardAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_view_conversation_card_avatar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomViewConversationCardAvatarBinding bind(View view) {
        if (view != null) {
            ImageView imageView = (ImageView) view;
            return new IntercomViewConversationCardAvatarBinding(imageView, imageView);
        }
        throw new NullPointerException("rootView");
    }
}
