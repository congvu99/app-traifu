package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.FullscreenFrameLayout;

public final class IntercomActivityMessengerBinding implements ViewBinding {
    public final FrameLayout inboxFragment;
    public final FullscreenFrameLayout messengerContainer;
    private final FullscreenFrameLayout rootView;

    private IntercomActivityMessengerBinding(FullscreenFrameLayout fullscreenFrameLayout, FrameLayout frameLayout, FullscreenFrameLayout fullscreenFrameLayout2) {
        this.rootView = fullscreenFrameLayout;
        this.inboxFragment = frameLayout;
        this.messengerContainer = fullscreenFrameLayout2;
    }

    public FullscreenFrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomActivityMessengerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomActivityMessengerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_activity_messenger, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomActivityMessengerBinding bind(View view) {
        int i = R.id.inbox_fragment;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            FullscreenFrameLayout fullscreenFrameLayout = (FullscreenFrameLayout) view;
            return new IntercomActivityMessengerBinding(fullscreenFrameLayout, frameLayout, fullscreenFrameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
