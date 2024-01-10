package io.intercom.android.sdk.views.holder;

import android.content.ClipboardManager;
import android.view.View;
import android.view.ViewGroup;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Part;

public class LinkViewHolder extends BlocksPartViewHolder {
    private final Provider<AppConfig> appConfigProvider;
    private final int viewType;

    public /* bridge */ /* synthetic */ boolean onLongClick(View view) {
        return super.onLongClick(view);
    }

    public LinkViewHolder(View view, int i, ConversationListener conversationListener, ClipboardManager clipboardManager, Provider<AppConfig> provider) {
        super(view, conversationListener, clipboardManager);
        this.viewType = i;
        this.appConfigProvider = provider;
    }

    public void bind(Part part, ViewGroup viewGroup) {
        ViewGroup upHolderBlocks = setUpHolderBlocks(part, this.cellLayout, this.bubble, viewGroup);
        int dpToPx = ScreenUtils.dpToPx(16.0f, this.itemView.getContext());
        int dpToPx2 = ScreenUtils.dpToPx(24.0f, this.itemView.getContext());
        upHolderBlocks.setPadding(dpToPx, dpToPx2, dpToPx, dpToPx2);
        checkForEntranceAnimation(this.viewType, part, this.networkAvatar, this.cellLayout, upHolderBlocks);
        if (this.networkAvatar != null) {
            showAvatar(part.getParticipant(), this.networkAvatar, this.appConfigProvider.get());
            updateAvatarMarginForCard(part);
        }
    }

    public void onClick(View view) {
        int adapterPosition = getAdapterPosition();
        if (adapterPosition != -1) {
            this.conversationListener.onLinkClicked(adapterPosition, this.cellLayout);
        }
    }
}
