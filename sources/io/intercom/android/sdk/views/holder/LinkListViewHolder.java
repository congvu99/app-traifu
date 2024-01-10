package io.intercom.android.sdk.views.holder;

import android.content.ClipboardManager;
import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Part;

public class LinkListViewHolder extends BlocksPartViewHolder {
    private final Provider<AppConfig> appConfigProvider;

    public void onClick(View view) {
    }

    public /* bridge */ /* synthetic */ boolean onLongClick(View view) {
        return super.onLongClick(view);
    }

    public LinkListViewHolder(View view, ConversationListener conversationListener, Provider<AppConfig> provider) {
        super(view, conversationListener, (ClipboardManager) null);
        this.appConfigProvider = provider;
    }

    public void bind(Part part, ViewGroup viewGroup) {
        setUpHolderBlocks(part, this.cellLayout, this.bubble, viewGroup);
        if (this.networkAvatar != null) {
            showAvatar(part.getParticipant(), this.networkAvatar, this.appConfigProvider.get());
            updateAvatarMarginForCard(part);
        }
    }
}
