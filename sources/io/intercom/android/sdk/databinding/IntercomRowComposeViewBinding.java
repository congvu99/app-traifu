package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomRowComposeViewBinding implements ViewBinding {
    public final ComposeView composeView;
    private final ComposeView rootView;

    private IntercomRowComposeViewBinding(ComposeView composeView2, ComposeView composeView3) {
        this.rootView = composeView2;
        this.composeView = composeView3;
    }

    public ComposeView getRoot() {
        return this.rootView;
    }

    public static IntercomRowComposeViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomRowComposeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_row_compose_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomRowComposeViewBinding bind(View view) {
        if (view != null) {
            ComposeView composeView2 = (ComposeView) view;
            return new IntercomRowComposeViewBinding(composeView2, composeView2);
        }
        throw new NullPointerException("rootView");
    }
}
