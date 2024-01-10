package io.intercom.android.sdk.inbox;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.views.InboxRowLayout;

class InboxRowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final ConversationClickListener conversationClickListener;
    private final InboxRowLayout inboxRowLayout;
    private final TimeFormatter timeFormatter;

    InboxRowViewHolder(InboxRowLayout inboxRowLayout2, ConversationClickListener conversationClickListener2, TimeFormatter timeFormatter2) {
        super(inboxRowLayout2);
        this.conversationClickListener = conversationClickListener2;
        this.timeFormatter = timeFormatter2;
        inboxRowLayout2.setOnClickListener(this);
        this.inboxRowLayout = inboxRowLayout2;
    }

    /* access modifiers changed from: package-private */
    public void bindData(Conversation conversation, UserIdentity userIdentity, AppConfig appConfig, TeamPresence teamPresence) {
        this.inboxRowLayout.updateConversation(conversation, userIdentity, appConfig, teamPresence, this.timeFormatter);
    }

    public void onClick(View view) {
        int adapterPosition = getAdapterPosition();
        if (adapterPosition != -1) {
            this.conversationClickListener.onConversationClicked(adapterPosition);
        }
    }
}
