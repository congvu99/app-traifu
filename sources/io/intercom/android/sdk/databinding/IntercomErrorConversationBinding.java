package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.IntercomErrorView;

public final class IntercomErrorConversationBinding implements ViewBinding {
    public final Button actionButton;
    public final TextView emptyTextSubtitle;
    public final TextView emptyTextTitle;
    public final IntercomErrorView errorLayoutConversation;
    private final IntercomErrorView rootView;

    private IntercomErrorConversationBinding(IntercomErrorView intercomErrorView, Button button, TextView textView, TextView textView2, IntercomErrorView intercomErrorView2) {
        this.rootView = intercomErrorView;
        this.actionButton = button;
        this.emptyTextSubtitle = textView;
        this.emptyTextTitle = textView2;
        this.errorLayoutConversation = intercomErrorView2;
    }

    public IntercomErrorView getRoot() {
        return this.rootView;
    }

    public static IntercomErrorConversationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomErrorConversationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_error_conversation, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomErrorConversationBinding bind(View view) {
        int i = R.id.action_button;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.empty_text_subtitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.empty_text_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    IntercomErrorView intercomErrorView = (IntercomErrorView) view;
                    return new IntercomErrorConversationBinding(intercomErrorView, button, textView, textView2, intercomErrorView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}