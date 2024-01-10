package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomOnboardingLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;

    private IntercomOnboardingLayoutBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomOnboardingLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomOnboardingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_onboarding_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomOnboardingLayoutBinding bind(View view) {
        if (view != null) {
            return new IntercomOnboardingLayoutBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }
}
