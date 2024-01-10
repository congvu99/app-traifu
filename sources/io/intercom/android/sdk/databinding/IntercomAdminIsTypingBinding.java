package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomAdminIsTypingBinding implements ViewBinding {
    public final ImageView dot1;
    public final ImageView dot2;
    public final ImageView dot3;
    private final LinearLayout rootView;

    private IntercomAdminIsTypingBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        this.rootView = linearLayout;
        this.dot1 = imageView;
        this.dot2 = imageView2;
        this.dot3 = imageView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomAdminIsTypingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomAdminIsTypingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_admin_is_typing, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomAdminIsTypingBinding bind(View view) {
        int i = R.id.dot1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.dot2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.dot3;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    return new IntercomAdminIsTypingBinding((LinearLayout) view, imageView, imageView2, imageView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
