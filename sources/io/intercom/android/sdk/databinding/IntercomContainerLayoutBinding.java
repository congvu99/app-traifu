package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomContainerLayoutBinding implements ViewBinding {
    public final LinearLayout cellLayout;
    public final ProgressBar progressBar;
    private final FrameLayout rootView;

    private IntercomContainerLayoutBinding(FrameLayout frameLayout, LinearLayout linearLayout, ProgressBar progressBar2) {
        this.rootView = frameLayout;
        this.cellLayout = linearLayout;
        this.progressBar = progressBar2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomContainerLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomContainerLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_container_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomContainerLayoutBinding bind(View view) {
        int i = R.id.cellLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.progressBar;
            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar2 != null) {
                return new IntercomContainerLayoutBinding((FrameLayout) view, linearLayout, progressBar2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
