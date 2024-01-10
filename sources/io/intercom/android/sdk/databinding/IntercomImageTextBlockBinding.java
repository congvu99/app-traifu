package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomImageTextBlockBinding implements ViewBinding {
    public final FrameLayout imageHolder;
    private final LinearLayout rootView;
    public final TextView text;
    public final TextView title;

    private IntercomImageTextBlockBinding(LinearLayout linearLayout, FrameLayout frameLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.imageHolder = frameLayout;
        this.text = textView;
        this.title = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomImageTextBlockBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomImageTextBlockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_image_text_block, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomImageTextBlockBinding bind(View view) {
        int i = R.id.image_holder;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new IntercomImageTextBlockBinding((LinearLayout) view, frameLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
