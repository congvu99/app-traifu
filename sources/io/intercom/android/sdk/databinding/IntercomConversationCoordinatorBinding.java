package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.components.TopActionBar;
import io.intercom.android.sdk.tickets.TicketProgressRow;

public final class IntercomConversationCoordinatorBinding implements ViewBinding {
    public final ConstraintLayout conversationConstraintLayout;
    public final RecyclerView conversationList;
    public final TicketProgressRow conversationTicketProgressRow;
    public final TopActionBar conversationTopActionBar;
    public final FrameLayout replyOptions;
    private final ConstraintLayout rootView;

    private IntercomConversationCoordinatorBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TicketProgressRow ticketProgressRow, TopActionBar topActionBar, FrameLayout frameLayout) {
        this.rootView = constraintLayout;
        this.conversationConstraintLayout = constraintLayout2;
        this.conversationList = recyclerView;
        this.conversationTicketProgressRow = ticketProgressRow;
        this.conversationTopActionBar = topActionBar;
        this.replyOptions = frameLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static IntercomConversationCoordinatorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomConversationCoordinatorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_conversation_coordinator, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomConversationCoordinatorBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.conversation_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.conversation_ticket_progress_row;
            TicketProgressRow ticketProgressRow = (TicketProgressRow) ViewBindings.findChildViewById(view, i);
            if (ticketProgressRow != null) {
                i = R.id.conversation_top_action_bar;
                TopActionBar topActionBar = (TopActionBar) ViewBindings.findChildViewById(view, i);
                if (topActionBar != null) {
                    i = R.id.reply_options;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        return new IntercomConversationCoordinatorBinding(constraintLayout, constraintLayout, recyclerView, ticketProgressRow, topActionBar, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
