package io.intercom.android.sdk.views.holder;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.flexbox.FlexboxLayout;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.ReplyOption;
import io.intercom.android.sdk.models.Suggestion;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.android.sdk.views.PartMetadataFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PartViewHolder extends BlocksPartViewHolder {
    /* access modifiers changed from: private */
    public static final long TIMESTAMP_UPDATE_PERIOD = TimeUnit.MINUTES.toMillis(1);
    private final Provider<AppConfig> appConfigProvider;
    private final TextView attribution;
    private ViewGroup blocks;
    final TextView metaData;
    private final MetricTracker metricTracker;
    /* access modifiers changed from: private */
    public final PartMetadataFormatter partMetadataFormatter;
    private final int viewType;

    public /* bridge */ /* synthetic */ boolean onLongClick(View view) {
        return super.onLongClick(view);
    }

    public PartViewHolder(View view, int i, ConversationListener conversationListener, ClipboardManager clipboardManager, PartMetadataFormatter partMetadataFormatter2, Provider<AppConfig> provider, MetricTracker metricTracker2) {
        super(view, conversationListener, clipboardManager);
        this.viewType = i;
        this.partMetadataFormatter = partMetadataFormatter2;
        this.appConfigProvider = provider;
        this.metricTracker = metricTracker2;
        this.metaData = (TextView) view.findViewById(R.id.metadata);
        this.attribution = (TextView) view.findViewById(R.id.attribution);
    }

    /* JADX WARNING: type inference failed for: r8v12, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(io.intercom.android.sdk.models.Part r7, android.view.ViewGroup r8) {
        /*
            r6 = this;
            int r0 = r6.getAdapterPosition()
            boolean r1 = r6.shouldConcatenate(r7, r0)
            android.view.ViewGroup r2 = r6.cellLayout
            io.intercom.android.sdk.views.ExpandableLayout r3 = r6.bubble
            android.view.ViewGroup r8 = r6.setUpHolderBlocks(r7, r2, r3, r8)
            r6.blocks = r8
            int r8 = r6.viewType
            r6.setupHolderBackground(r8, r7, r1, r0)
            boolean r8 = r7.isAdmin()
            if (r8 == 0) goto L_0x0023
            r6.setAdminEndMargin(r7)
            r6.updateAvatarMarginForCard(r7)
        L_0x0023:
            int r8 = r6.viewType
            r6.setupMetaData(r8, r7)
            r6.setupAttribution(r7)
            int r1 = r6.viewType
            android.widget.ImageView r3 = r6.networkAvatar
            android.view.ViewGroup r4 = r6.cellLayout
            android.view.ViewGroup r5 = r6.blocks
            r0 = r6
            r2 = r7
            r0.checkForEntranceAnimation(r1, r2, r3, r4, r5)
            io.intercom.android.sdk.views.ExpandableLayout r8 = r6.bubble
            if (r8 == 0) goto L_0x0046
            io.intercom.android.sdk.views.ExpandableLayout r8 = r6.bubble
            boolean r0 = r6.shouldExpand(r7)
            r1 = 0
            r8.setExpanded(r0, r1)
        L_0x0046:
            boolean r8 = r6.isLastPart(r7)
            if (r8 == 0) goto L_0x0087
            java.util.List r8 = r7.getReplyOptions()
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x0087
            android.view.View r8 = r6.itemView
            android.content.Context r8 = r8.getContext()
            android.view.LayoutInflater r8 = android.view.LayoutInflater.from(r8)
            android.view.View r0 = r6.itemView
            android.view.View r0 = r0.getRootView()
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            int r1 = io.intercom.android.sdk.R.id.intercom_reply_options
            android.view.View r1 = r0.findViewById(r1)
            com.google.android.flexbox.FlexboxLayout r1 = (com.google.android.flexbox.FlexboxLayout) r1
            if (r1 != 0) goto L_0x0084
            int r1 = io.intercom.android.sdk.R.layout.intercom_quick_reply_layout
            r2 = 0
            android.view.View r8 = r8.inflate(r1, r2)
            r1 = r8
            com.google.android.flexbox.FlexboxLayout r1 = (com.google.android.flexbox.FlexboxLayout) r1
            int r8 = io.intercom.android.sdk.R.id.intercom_reply_options
            r1.setId(r8)
            r0.addView(r1)
        L_0x0084:
            r6.addReplyOptions(r7, r1)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.views.holder.PartViewHolder.bind(io.intercom.android.sdk.models.Part, android.view.ViewGroup):void");
    }

    /* access modifiers changed from: package-private */
    public void addReplyOptions(final Part part, final FlexboxLayout flexboxLayout) {
        if (isLastPart(part)) {
            flexboxLayout.setVisibility(0);
        } else {
            flexboxLayout.setVisibility(8);
        }
        flexboxLayout.removeAllViews();
        LayoutInflater from = LayoutInflater.from(flexboxLayout.getContext());
        List<ReplyOption> replyOptions = part.getReplyOptions();
        for (int i = 0; i < replyOptions.size(); i++) {
            final ReplyOption replyOption = replyOptions.get(i);
            TextView textView = (TextView) from.inflate(R.layout.intercom_quick_reply_button, (ViewGroup) null);
            textView.setText(replyOption.text());
            BackgroundUtils.setButtonColor(textView, this.appConfigProvider.get().getPrimaryColor());
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    flexboxLayout.setVisibility(8);
                    PartViewHolder.this.conversationListener.onQuickReplyClicked(part.getParticipant(), part, replyOption);
                }
            });
            flexboxLayout.addView(textView);
            this.metricTracker.receivedQuickReply(replyOption.uuid(), this.conversationListener.getConversationId(), part.getId());
        }
    }

    /* access modifiers changed from: package-private */
    public void addComposerSuggestions(Part part, TextView textView, FlexboxLayout flexboxLayout) {
        if (isLastPart(part)) {
            flexboxLayout.setVisibility(0);
        } else {
            flexboxLayout.setVisibility(8);
            textView.setVisibility(8);
        }
        flexboxLayout.removeAllViews();
        LayoutInflater from = LayoutInflater.from(flexboxLayout.getContext());
        List<Suggestion> suggestions = part.getComposerSuggestions().getSuggestions();
        for (int i = 0; i < suggestions.size(); i++) {
            Suggestion suggestion = suggestions.get(i);
            TextView textView2 = (TextView) from.inflate(R.layout.intercom_quick_reply_button, (ViewGroup) null);
            textView2.setText(suggestion.getText());
            BackgroundUtils.setButtonColor(textView2, this.appConfigProvider.get().getPrimaryColor());
            final FlexboxLayout flexboxLayout2 = flexboxLayout;
            final TextView textView3 = textView;
            final Part part2 = part;
            final Suggestion suggestion2 = suggestion;
            textView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    flexboxLayout2.setVisibility(8);
                    textView3.setVisibility(8);
                    PartViewHolder.this.conversationListener.onComposerSuggestionClicked(part2, suggestion2);
                }
            });
            flexboxLayout.addView(textView2);
            this.metricTracker.receivedComposerSuggestions(suggestion.getUuid(), this.conversationListener.getConversationId(), part.getId());
        }
    }

    private void setAdminEndMargin(Part part) {
        float f;
        Context context = this.cellLayout.getContext();
        if (isSingleCardPart(part)) {
            f = context.getResources().getDimension(R.dimen.intercom_conversation_row_card_margin);
        } else {
            f = context.getResources().getDimension(R.dimen.intercom_conversation_row_margin);
        }
        int i = (int) f;
        if (this.cellLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cellLayout.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, i, marginLayoutParams.bottomMargin);
        }
    }

    private boolean shouldExpand(Part part) {
        return isSelectedPart(part) || isLastPart(part) || isNextPartTyping(getAdapterPosition());
    }

    /* access modifiers changed from: package-private */
    public boolean isSelectedPart(Part part) {
        return part == this.conversationListener.getSelectedPart();
    }

    /* access modifiers changed from: package-private */
    public boolean isLastPart(Part part) {
        if (part != this.conversationListener.getPart(this.conversationListener.getCount() - 1) || Part.ADMIN_IS_TYPING_STYLE.equals(part.getMessageStyle())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isNextPartTyping(int i) {
        int i2;
        if (i != -1 && (i2 = i + 1) <= this.conversationListener.getCount() - 1 && Part.ADMIN_IS_TYPING_STYLE.equals(this.conversationListener.getPart(i2).getMessageStyle())) {
            return true;
        }
        return false;
    }

    private void setupHolderBackground(int i, Part part, boolean z, int i2) {
        setBubbleBackground(part, this.blocks, i, z, i2);
        if (this.networkAvatar == null) {
            return;
        }
        if (z) {
            this.networkAvatar.setVisibility(4);
        } else if (i == 1 || i == 5 || i == 4) {
            showAvatar(part.getParticipant(), this.networkAvatar, this.appConfigProvider.get());
        }
    }

    public void onClick(View view) {
        int adapterPosition = getAdapterPosition();
        if (adapterPosition != -1) {
            this.conversationListener.onPartClicked(adapterPosition, this);
        }
    }

    public void setExpanded(boolean z) {
        if (this.bubble != null) {
            this.bubble.setExpanded(z, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void setupMetaData(int i, final Part part) {
        if (this.metaData != null) {
            if (i == 2 || i == 3) {
                this.metaData.setVisibility(4);
                TextView textView = this.metaData;
                textView.setHeight(ScreenUtils.dpToPx(10.0f, textView.getContext()));
                return;
            }
            boolean z = true;
            if (part != this.conversationListener.getPart(this.conversationListener.getCount() - 1)) {
                z = false;
            }
            final Resources resources = this.metaData.getResources();
            this.metaData.setText(this.partMetadataFormatter.getMetadataString(part, z, resources));
            if (z) {
                this.metaData.postDelayed(new Runnable() {
                    public void run() {
                        PartViewHolder.this.metaData.setText(PartViewHolder.this.partMetadataFormatter.getMetadataString(part, true, resources));
                        PartViewHolder.this.metaData.postDelayed(this, PartViewHolder.TIMESTAMP_UPDATE_PERIOD);
                    }
                }, TIMESTAMP_UPDATE_PERIOD);
            }
            if (Part.MessageState.UPLOAD_FAILED == part.getMessageState()) {
                this.metaData.setCompoundDrawablesWithIntrinsicBounds(R.drawable.intercom_message_error, 0, 0, 0);
            } else {
                this.metaData.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
    }

    private void setupAttribution(Part part) {
        if (this.attribution != null) {
            if (shouldShowAttribution(part)) {
                CharSequence format = Phrase.from(this.metaData.getContext(), R.string.intercom_gif_attribution).put("providername", (CharSequence) part.getBlocks().get(0).getAttribution()).format();
                this.attribution.setVisibility(0);
                this.attribution.setText(format);
                return;
            }
            this.attribution.setVisibility(8);
        }
    }

    private boolean shouldShowAttribution(Part part) {
        if (!isSingleImagePart(part) || TextUtils.isEmpty(part.getBlocks().get(0).getAttribution()) || !part.getMessageState().equals(Part.MessageState.NORMAL)) {
            return false;
        }
        return true;
    }

    private boolean shouldConcatenate(Part part, int i) {
        int i2;
        if (i != -1 && (i2 = i + 1) < this.conversationListener.getCount()) {
            return Part.shouldConcatenate(part, this.conversationListener.getPart(i2));
        }
        return false;
    }

    private void setBubbleBackground(Part part, View view, int i, boolean z, int i2) {
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        if (isSingleImagePart(part) || isSingleCardPart(part)) {
            this.cellLayout.setBackgroundColor(0);
            this.cellLayout.setPadding(0, 0, 0, 0);
            View view2 = view;
            paddingTop = 0;
            paddingBottom = 0;
        } else {
            Context context = this.cellLayout.getContext();
            int dimension = (int) context.getResources().getDimension(R.dimen.intercom_cell_horizontal_padding);
            this.cellLayout.setPadding(dimension, 0, dimension, 0);
            Drawable backgroundDrawable = getBackgroundDrawable(context, i, z, i2, part);
            if (!part.isAdmin() && i != 4) {
                backgroundDrawable.setColorFilter(this.appConfigProvider.get().getPrimaryColor(), PorterDuff.Mode.SRC_IN);
            }
            BackgroundUtils.setBackground(this.cellLayout, backgroundDrawable);
            View view3 = view;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    private Drawable getBackgroundDrawable(Context context, int i, boolean z, int i2, Part part) {
        boolean hasPreviousConcatPart = hasPreviousConcatPart(part, i2);
        if (z) {
            return ContextCompat.getDrawable(context, hasPreviousConcatPart ? getMiddleDrawable(i) : getTopDrawable(i));
        }
        return ContextCompat.getDrawable(context, hasPreviousConcatPart ? getBottomDrawable(i) : R.drawable.intercom_bubble_background);
    }

    private int getTopDrawable(int i) {
        if (i == 0) {
            return R.drawable.intercom_bubble_background_user_top;
        }
        return R.drawable.intercom_bubble_background_admin_top;
    }

    private int getMiddleDrawable(int i) {
        if (i == 0) {
            return R.drawable.intercom_bubble_background_user_middle;
        }
        return R.drawable.intercom_bubble_background_admin_middle;
    }

    private int getBottomDrawable(int i) {
        if (i == 0) {
            return R.drawable.intercom_bubble_background_user_bottom;
        }
        return R.drawable.intercom_bubble_background_admin_bottom;
    }

    private boolean hasPreviousConcatPart(Part part, int i) {
        if (i > 0) {
            return Part.shouldConcatenate(part, this.conversationListener.getPart(i - 1));
        }
        return false;
    }

    private boolean isSingleImagePart(Part part) {
        List<Block> blocks2 = part.getBlocks();
        if (blocks2.size() != 1) {
            return false;
        }
        BlockType type = blocks2.get(0).getType();
        if (type == BlockType.LOCALIMAGE || type == BlockType.IMAGE) {
            return true;
        }
        return false;
    }
}
