package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomWebviewCardInputBinding implements ViewBinding {
    public final AutoCompleteTextView input;
    private final FrameLayout rootView;

    private IntercomWebviewCardInputBinding(FrameLayout frameLayout, AutoCompleteTextView autoCompleteTextView) {
        this.rootView = frameLayout;
        this.input = autoCompleteTextView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomWebviewCardInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomWebviewCardInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_webview_card_input, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomWebviewCardInputBinding bind(View view) {
        int i = R.id.input;
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) ViewBindings.findChildViewById(view, i);
        if (autoCompleteTextView != null) {
            return new IntercomWebviewCardInputBinding((FrameLayout) view, autoCompleteTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
