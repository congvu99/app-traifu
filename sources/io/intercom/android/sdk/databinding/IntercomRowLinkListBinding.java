package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomRowLinkListBinding implements ViewBinding {
    public final ImageView avatarView;
    public final FrameLayout cellLayout;
    private final LinearLayout rootView;

    private IntercomRowLinkListBinding(LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.avatarView = imageView;
        this.cellLayout = frameLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomRowLinkListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomRowLinkListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_row_link_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomRowLinkListBinding bind(View view) {
        int i = R.id.avatarView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.cellLayout;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                return new IntercomRowLinkListBinding((LinearLayout) view, imageView, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
