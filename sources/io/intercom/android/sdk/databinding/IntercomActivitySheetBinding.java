package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.IntercomToolbar;

public final class IntercomActivitySheetBinding implements ViewBinding {
    public final IntercomToolbar intercomToolbar;
    private final LinearLayout rootView;
    public final LinearLayout sheetRoot;
    public final FrameLayout sheetView;

    private IntercomActivitySheetBinding(LinearLayout linearLayout, IntercomToolbar intercomToolbar2, LinearLayout linearLayout2, FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.intercomToolbar = intercomToolbar2;
        this.sheetRoot = linearLayout2;
        this.sheetView = frameLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomActivitySheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomActivitySheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_activity_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomActivitySheetBinding bind(View view) {
        int i = R.id.intercom_toolbar;
        IntercomToolbar intercomToolbar2 = (IntercomToolbar) ViewBindings.findChildViewById(view, i);
        if (intercomToolbar2 != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = R.id.sheet_view;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i2);
            if (frameLayout != null) {
                return new IntercomActivitySheetBinding(linearLayout, intercomToolbar2, linearLayout, frameLayout);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
