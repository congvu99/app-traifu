package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.ExpandableLayout;

public final class IntercomRowUserPartBinding implements ViewBinding {
    public final TextView attribution;
    public final LinearLayout cellLayout;
    public final ExpandableLayout intercomBubble;
    public final TextView metadata;
    private final LinearLayout rootView;

    private IntercomRowUserPartBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, ExpandableLayout expandableLayout, TextView textView2) {
        this.rootView = linearLayout;
        this.attribution = textView;
        this.cellLayout = linearLayout2;
        this.intercomBubble = expandableLayout;
        this.metadata = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomRowUserPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomRowUserPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_row_user_part, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomRowUserPartBinding bind(View view) {
        int i = R.id.attribution;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.cellLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.intercom_bubble;
                ExpandableLayout expandableLayout = (ExpandableLayout) ViewBindings.findChildViewById(view, i);
                if (expandableLayout != null) {
                    i = R.id.metadata;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new IntercomRowUserPartBinding((LinearLayout) view, textView, linearLayout, expandableLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
