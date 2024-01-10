package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomShowPreviousConversationCardBinding implements ViewBinding {
    public final TextView intercomTextviewSeePrevious;
    private final ConstraintLayout rootView;

    private IntercomShowPreviousConversationCardBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.intercomTextviewSeePrevious = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static IntercomShowPreviousConversationCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomShowPreviousConversationCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_show_previous_conversation_card, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomShowPreviousConversationCardBinding bind(View view) {
        int i = R.id.intercom_textview_see_previous;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new IntercomShowPreviousConversationCardBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
