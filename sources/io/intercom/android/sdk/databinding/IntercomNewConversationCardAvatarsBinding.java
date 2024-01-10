package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import io.intercom.android.sdk.R;

public final class IntercomNewConversationCardAvatarsBinding implements ViewBinding {
    public final ShapeableImageView helpCenterArticleAvatar1;
    public final ShapeableImageView helpCenterArticleAvatar2;
    public final ShapeableImageView helpCenterArticleAvatar3;
    private final FrameLayout rootView;

    private IntercomNewConversationCardAvatarsBinding(FrameLayout frameLayout, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, ShapeableImageView shapeableImageView3) {
        this.rootView = frameLayout;
        this.helpCenterArticleAvatar1 = shapeableImageView;
        this.helpCenterArticleAvatar2 = shapeableImageView2;
        this.helpCenterArticleAvatar3 = shapeableImageView3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomNewConversationCardAvatarsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomNewConversationCardAvatarsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_new_conversation_card_avatars, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomNewConversationCardAvatarsBinding bind(View view) {
        int i = R.id.help_center_article_avatar1;
        ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view, i);
        if (shapeableImageView != null) {
            i = R.id.help_center_article_avatar2;
            ShapeableImageView shapeableImageView2 = (ShapeableImageView) ViewBindings.findChildViewById(view, i);
            if (shapeableImageView2 != null) {
                i = R.id.help_center_article_avatar3;
                ShapeableImageView shapeableImageView3 = (ShapeableImageView) ViewBindings.findChildViewById(view, i);
                if (shapeableImageView3 != null) {
                    return new IntercomNewConversationCardAvatarsBinding((FrameLayout) view, shapeableImageView, shapeableImageView2, shapeableImageView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
