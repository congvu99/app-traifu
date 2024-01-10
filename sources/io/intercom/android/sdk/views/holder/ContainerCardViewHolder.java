package io.intercom.android.sdk.views.holder;

import android.content.ClipboardManager;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.view.OneShotPreDrawListener;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.android.sdk.views.LockableScrollView;

public class ContainerCardViewHolder extends BlocksPartViewHolder {
    private Provider<AppConfig> appConfigProvider;
    ImageView arrowExpander;
    private final View fade;
    final LockableScrollView lockableScrollView;
    private final TextView title;
    private final int viewType;

    public /* bridge */ /* synthetic */ boolean onLongClick(View view) {
        return super.onLongClick(view);
    }

    public ContainerCardViewHolder(View view, int i, ConversationListener conversationListener, ClipboardManager clipboardManager, boolean z, Provider<AppConfig> provider) {
        super(view, conversationListener, clipboardManager);
        this.viewType = i;
        this.appConfigProvider = provider;
        this.title = (TextView) view.findViewById(R.id.intercom_container_card_title);
        this.fade = view.findViewById(R.id.intercom_container_fade_view);
        LockableScrollView lockableScrollView2 = (LockableScrollView) view.findViewById(R.id.cell_content);
        this.lockableScrollView = lockableScrollView2;
        lockableScrollView2.setScrollingEnabled(false);
        if (i == 3) {
            if (z) {
                this.arrowExpander = (ImageView) view.findViewById(R.id.expand_arrow);
            }
            this.lockableScrollView.setExpanded(!z);
            return;
        }
        this.lockableScrollView.setExpanded(false);
    }

    public void bind(Part part, ViewGroup viewGroup) {
        View findViewById = this.itemView.findViewById(R.id.cellLayout);
        ComposeView composeView = (ComposeView) this.itemView.findViewById(R.id.intercom_container_footer);
        OneShotPreDrawListener.add(findViewById, new Runnable() {
            public final void run() {
                ContainerCardViewHolder.this.setupViews();
            }
        });
        ViewGroup upHolderBlocks = setUpHolderBlocks(part, this.cellLayout, this.bubble, viewGroup);
        showAvatar(part.getParticipant(), this.networkAvatar, this.appConfigProvider.get());
        this.title.setText(Phrase.from(this.title.getContext(), R.string.intercom_teammate_from_company).put("name", (CharSequence) part.getParticipant().getForename()).put("company", (CharSequence) this.appConfigProvider.get().getName()).format());
        if (composeView != null) {
            PostCardFooterKt.bindPostCardFooter(composeView);
        }
        checkForEntranceAnimation(this.viewType, part, this.networkAvatar, this.cellLayout, upHolderBlocks);
    }

    public void onClick(View view) {
        int adapterPosition = getAdapterPosition();
        if (adapterPosition != -1) {
            this.conversationListener.onContainerCardClicked(adapterPosition, this);
        }
    }

    public void toggleExpanded() {
        runOnMainThread(new Runnable() {
            public void run() {
                if (ContainerCardViewHolder.this.arrowExpander != null && ContainerCardViewHolder.this.arrowExpander.getVisibility() == 0) {
                    ContainerCardViewHolder.this.lockableScrollView.toggleExpanded();
                    ContainerCardViewHolder.this.setupViews();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setupViews() {
        if (this.viewType == 2) {
            layoutForPost();
        } else if (this.arrowExpander == null) {
            layoutForExpandedNoteWithoutArrow();
        } else if (this.lockableScrollView.isExpanded()) {
            layoutForExpandedNoteWithArrow();
        } else {
            layoutForCollapsedNoteWithArrow();
        }
    }

    private void layoutForPost() {
        ImageView imageView = this.arrowExpander;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.fade.setVisibility(contentIsOverflowing() ? 0 : 4);
    }

    private boolean contentIsOverflowing() {
        if (this.lockableScrollView.getChildAt(0).getMeasuredHeight() > this.lockableScrollView.getMaxHeight()) {
            return true;
        }
        return false;
    }

    private void layoutForExpandedNoteWithoutArrow() {
        ImageView imageView = this.arrowExpander;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.fade.setVisibility(4);
    }

    private void layoutForExpandedNoteWithArrow() {
        ImageView imageView = this.arrowExpander;
        if (imageView != null) {
            imageView.setVisibility(contentIsOverflowing() ? 0 : 8);
            this.arrowExpander.setScaleY(-1.0f);
        }
        this.fade.setVisibility(4);
    }

    private void layoutForCollapsedNoteWithArrow() {
        ImageView imageView = this.arrowExpander;
        int i = 0;
        if (imageView != null) {
            imageView.setVisibility(contentIsOverflowing() ? 0 : 8);
            this.arrowExpander.setScaleY(1.0f);
        }
        View view = this.fade;
        if (!contentIsOverflowing()) {
            i = 4;
        }
        view.setVisibility(i);
    }

    private void runOnMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.lockableScrollView.post(runnable);
        }
    }
}
