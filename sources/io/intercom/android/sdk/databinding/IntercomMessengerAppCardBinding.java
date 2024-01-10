package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomMessengerAppCardBinding implements ViewBinding {
    public final ProgressBar loadingView;
    public final FrameLayout messengerCardLayout;
    private final FrameLayout rootView;

    private IntercomMessengerAppCardBinding(FrameLayout frameLayout, ProgressBar progressBar, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.loadingView = progressBar;
        this.messengerCardLayout = frameLayout2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomMessengerAppCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomMessengerAppCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_messenger_app_card, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomMessengerAppCardBinding bind(View view) {
        int i = R.id.loading_view;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
        if (progressBar != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new IntercomMessengerAppCardBinding(frameLayout, progressBar, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
