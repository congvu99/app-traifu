package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomViewTextAttributeBinding implements ViewBinding {
    public final EditText attributeInput;
    public final ImageView attributeSubmit;
    public final ImageView attributeVerifiedTick;
    public final TextView flagView;
    public final ProgressBar loadingView;
    private final LinearLayout rootView;

    private IntercomViewTextAttributeBinding(LinearLayout linearLayout, EditText editText, ImageView imageView, ImageView imageView2, TextView textView, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.attributeInput = editText;
        this.attributeSubmit = imageView;
        this.attributeVerifiedTick = imageView2;
        this.flagView = textView;
        this.loadingView = progressBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomViewTextAttributeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomViewTextAttributeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_view_text_attribute, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomViewTextAttributeBinding bind(View view) {
        int i = R.id.attribute_input;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = R.id.attribute_submit;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.attribute_verified_tick;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.flag_view;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.loading_view;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            return new IntercomViewTextAttributeBinding((LinearLayout) view, editText, imageView, imageView2, textView, progressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
