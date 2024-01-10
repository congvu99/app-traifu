package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomAttributeErrorBinding implements ViewBinding {
    public final TextView errorText;
    private final TextView rootView;

    private IntercomAttributeErrorBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.errorText = textView2;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static IntercomAttributeErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomAttributeErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_attribute_error, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomAttributeErrorBinding bind(View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new IntercomAttributeErrorBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }
}
