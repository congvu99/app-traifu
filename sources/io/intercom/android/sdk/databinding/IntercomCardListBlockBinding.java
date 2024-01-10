package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomCardListBlockBinding implements ViewBinding {
    public final LinearLayout cardLinks;
    private final FrameLayout rootView;

    private IntercomCardListBlockBinding(FrameLayout frameLayout, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.cardLinks = linearLayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomCardListBlockBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomCardListBlockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_card_list_block, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomCardListBlockBinding bind(View view) {
        int i = R.id.card_links;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            return new IntercomCardListBlockBinding((FrameLayout) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
