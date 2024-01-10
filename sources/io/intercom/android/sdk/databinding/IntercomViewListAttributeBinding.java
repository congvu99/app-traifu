package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomViewListAttributeBinding implements ViewBinding {
    public final TextView attributeInput;
    private final LinearLayout rootView;

    private IntercomViewListAttributeBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.attributeInput = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomViewListAttributeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomViewListAttributeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_view_list_attribute, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomViewListAttributeBinding bind(View view) {
        int i = R.id.attribute_input;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new IntercomViewListAttributeBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
