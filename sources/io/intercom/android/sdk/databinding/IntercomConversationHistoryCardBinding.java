package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomConversationHistoryCardBinding implements ViewBinding {
    public final View divider;
    public final LinearLayout inboxLayout;
    public final ConstraintLayout recentConversationCardLayout;
    public final TextView recentConversationHeader;
    private final ConstraintLayout rootView;
    public final TextView seePrevious;
    public final Group seePreviousLayout;
    public final Space topPadding;

    private IntercomConversationHistoryCardBinding(ConstraintLayout constraintLayout, View view, LinearLayout linearLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, Group group, Space space) {
        this.rootView = constraintLayout;
        this.divider = view;
        this.inboxLayout = linearLayout;
        this.recentConversationCardLayout = constraintLayout2;
        this.recentConversationHeader = textView;
        this.seePrevious = textView2;
        this.seePreviousLayout = group;
        this.topPadding = space;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static IntercomConversationHistoryCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomConversationHistoryCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_conversation_history_card, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomConversationHistoryCardBinding bind(View view) {
        int i = R.id.divider;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.inbox_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.recent_conversation_header;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.see_previous;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.see_previous_layout;
                        Group group = (Group) ViewBindings.findChildViewById(view, i);
                        if (group != null) {
                            i = R.id.top_padding;
                            Space space = (Space) ViewBindings.findChildViewById(view, i);
                            if (space != null) {
                                return new IntercomConversationHistoryCardBinding(constraintLayout, findChildViewById, linearLayout, constraintLayout, textView, textView2, group, space);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
