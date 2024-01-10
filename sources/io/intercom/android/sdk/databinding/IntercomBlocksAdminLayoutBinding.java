package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomBlocksAdminLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;

    private IntercomBlocksAdminLayoutBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomBlocksAdminLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomBlocksAdminLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_blocks_admin_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomBlocksAdminLayoutBinding bind(View view) {
        if (view != null) {
            return new IntercomBlocksAdminLayoutBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }
}
