package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.IntercomErrorView;

public final class IntercomEmptyScreenBinding implements ViewBinding {
    public final TextView closeButton;
    public final TextView emptyTextSubtitle;
    public final TextView emptyTextTitle;
    public final IntercomErrorView errorLayoutEmptyScreen;
    private final IntercomErrorView rootView;

    private IntercomEmptyScreenBinding(IntercomErrorView intercomErrorView, TextView textView, TextView textView2, TextView textView3, IntercomErrorView intercomErrorView2) {
        this.rootView = intercomErrorView;
        this.closeButton = textView;
        this.emptyTextSubtitle = textView2;
        this.emptyTextTitle = textView3;
        this.errorLayoutEmptyScreen = intercomErrorView2;
    }

    public IntercomErrorView getRoot() {
        return this.rootView;
    }

    public static IntercomEmptyScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomEmptyScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_empty_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomEmptyScreenBinding bind(View view) {
        int i = R.id.close_button;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.empty_text_subtitle;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.empty_text_title;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    IntercomErrorView intercomErrorView = (IntercomErrorView) view;
                    return new IntercomEmptyScreenBinding(intercomErrorView, textView, textView2, textView3, intercomErrorView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
