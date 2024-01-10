package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomRowCardLoadingBinding implements ViewBinding {
    public final FrameLayout loadingLayout;
    private final FrameLayout rootView;

    private IntercomRowCardLoadingBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.loadingLayout = frameLayout2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomRowCardLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomRowCardLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_row_card_loading, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomRowCardLoadingBinding bind(View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new IntercomRowCardLoadingBinding(frameLayout, frameLayout);
        }
        throw new NullPointerException("rootView");
    }
}
