package io.intercom.android.sdk.overlay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.m5.notification.InAppNotificationCardKt;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.overlay.InAppNotification;
import io.intercom.android.sdk.utilities.AvatarUtils;

class ChatSnippet extends ChatNotification {
    private TextView contentBody;

    public ChatSnippet(Context context, Conversation conversation, int i, int i2, InAppNotification.Listener listener, Provider<AppConfig> provider) {
        super(context, conversation, i, i2, listener, provider);
    }

    /* access modifiers changed from: protected */
    public ViewGroup inflateChatRootView(ViewGroup viewGroup, LayoutInflater layoutInflater) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.intercom_preview_chat_snippet_overlay, viewGroup, false);
        this.contentBody = (TextView) viewGroup2.findViewById(R.id.chathead_text_body);
        return viewGroup2;
    }

    /* access modifiers changed from: protected */
    public void updateContentContainer(Part part) {
        setBodyText(part);
    }

    /* access modifiers changed from: protected */
    public View getContentContainer() {
        return this.overlayRoot.findViewById(R.id.chathead_text_body);
    }

    public void update(Conversation conversation, Runnable runnable) {
        this.conversation = conversation;
        View findViewById = this.overlayRoot.findViewById(R.id.chathead_text_body);
        View findViewById2 = this.overlayRoot.findViewById(R.id.chathead_text_container);
        findViewById2.setPivotX(0.0f);
        performReplyPulse(findViewById2, findViewById, runnable);
    }

    /* access modifiers changed from: protected */
    public void updateViewDataDuringReplyPulse(int i) {
        AvatarUtils.loadAvatarIntoView(this.conversation.getLastAdmin().getAvatar(), (ImageView) this.overlayRoot.findViewById(R.id.chathead_avatar), (AppConfig) this.appConfigProvider.get());
        TextView textView = (TextView) this.overlayRoot.findViewById(R.id.chathead_text_header);
        textView.setText(getHeaderText());
        setBodyText(this.conversation.getLastPart());
        ComposeView composeView = (ComposeView) this.overlayRoot.findViewById(R.id.ticket_header_compose_view);
        InAppNotificationCardKt.addTicketHeaderToCompose(composeView, this.conversation);
        if (this.conversation.getTicket() != Ticket.Companion.getNULL()) {
            textView.setVisibility(8);
            composeView.setVisibility(0);
            return;
        }
        textView.setVisibility(0);
        composeView.setVisibility(8);
    }

    private void setBodyText(Part part) {
        if (part.getSummary().isEmpty()) {
            this.contentBody.setText(this.localisedContext.getString(R.string.intercom_image_attached));
        } else {
            this.contentBody.setText(part.getSummary());
        }
    }
}
