package io.intercom.android.sdk.views.holder;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.intercom.commons.utilities.HtmlCompat;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.views.AdminIsTypingView;
import io.intercom.android.sdk.views.ExpandableLayout;
import java.util.List;

abstract class BlocksPartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener, ConversationPartViewHolder {
    final ExpandableLayout bubble;
    protected final ViewGroup cellLayout;
    private final ClipboardManager clipboardManager;
    private final String clipboardMessage;
    final ConversationListener conversationListener;
    final ImageView networkAvatar;
    private final Twig twig;

    BlocksPartViewHolder(View view, ConversationListener conversationListener2) {
        this(view, conversationListener2, (ClipboardManager) null);
    }

    BlocksPartViewHolder(View view, ConversationListener conversationListener2, ClipboardManager clipboardManager2) {
        super(view);
        this.twig = LumberMill.getLogger();
        this.conversationListener = conversationListener2;
        this.clipboardManager = clipboardManager2;
        this.clipboardMessage = view.getContext().getString(R.string.intercom_copied_to_clipboard);
        this.networkAvatar = (ImageView) view.findViewById(R.id.avatarView);
        this.cellLayout = (ViewGroup) view.findViewById(R.id.cellLayout);
        this.bubble = (ExpandableLayout) view.findViewById(R.id.intercom_bubble);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
    }

    /* access modifiers changed from: package-private */
    public ViewGroup setUpHolderBlocks(Part part, ViewGroup viewGroup, ExpandableLayout expandableLayout, ViewGroup viewGroup2) {
        viewGroup.setVisibility(0);
        if (viewGroup2.getParent() != null) {
            ((ViewGroup) viewGroup2.getParent()).removeView(viewGroup2);
        }
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        viewGroup.addView(viewGroup2, 0);
        setUpRowFocusRules(this.itemView, part, expandableLayout);
        return viewGroup2;
    }

    private void setUpRowFocusRules(View view, Part part, ExpandableLayout expandableLayout) {
        if (expandableLayout != null) {
            expandableLayout.setAlpha(1.0f);
            if (Part.MessageState.FAILED == part.getMessageState() || Part.MessageState.UPLOAD_FAILED == part.getMessageState()) {
                ((ViewGroup) view).setDescendantFocusability(393216);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void checkForEntranceAnimation(int i, Part part, ImageView imageView, View view, ViewGroup viewGroup) {
        if (!part.hasEntranceAnimation()) {
            return;
        }
        if (i == 5) {
            part.setEntranceAnimation(false);
            imageView.setAlpha(0.0f);
            imageView.setScaleX(0.5f);
            imageView.setScaleY(0.5f);
            imageView.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(300).setStartDelay(100).start();
            view.setAlpha(0.0f);
            view.setScaleX(0.5f);
            view.setScaleY(0.5f);
            view.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(300).setStartDelay(150).start();
            ((AdminIsTypingView) viewGroup.getChildAt(0)).beginAnimation();
        } else if (Part.MessageState.SENDING == part.getMessageState()) {
            part.setEntranceAnimation(false);
            view.setAlpha(0.0f);
            view.setTranslationY(view.getTranslationY() + 100.0f);
            view.animate().setStartDelay(100).alpha(1.0f).translationYBy(-100.0f).start();
        }
    }

    /* access modifiers changed from: package-private */
    public void showAvatar(Participant participant, ImageView imageView, AppConfig appConfig) {
        imageView.setVisibility(0);
        AvatarUtils.loadAvatarIntoView(participant.getAvatar(), imageView, appConfig);
    }

    public boolean onLongClick(View view) {
        int adapterPosition;
        if (this.clipboardManager == null || (adapterPosition = getAdapterPosition()) == -1) {
            return false;
        }
        try {
            this.clipboardManager.setPrimaryClip(ClipData.newPlainText("message", getPartText(this.conversationListener.getPart(adapterPosition))));
            Toast.makeText(this.itemView.getContext(), this.clipboardMessage, 0).show();
            return true;
        } catch (Exception e) {
            this.twig.internal(e.getMessage());
            return false;
        }
    }

    static String getPartText(Part part) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (Block next : part.getBlocks()) {
            switch (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType[next.getType().ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    appendLine(spannableStringBuilder, HtmlCompat.fromHtml(next.getText()));
                    break;
                case 5:
                    appendLine(spannableStringBuilder, next.getUrl());
                    break;
                case 6:
                case 7:
                    for (String appendLine : next.getItems()) {
                        appendLine(spannableStringBuilder, appendLine);
                    }
                    break;
            }
        }
        return spannableStringBuilder.length() == 0 ? part.getSummary() : spannableStringBuilder.toString();
    }

    /* renamed from: io.intercom.android.sdk.views.holder.BlocksPartViewHolder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.intercom.android.sdk.blocks.lib.BlockType[] r0 = io.intercom.android.sdk.blocks.lib.BlockType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType = r0
                io.intercom.android.sdk.blocks.lib.BlockType r1 = io.intercom.android.sdk.blocks.lib.BlockType.SUBHEADING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.blocks.lib.BlockType r1 = io.intercom.android.sdk.blocks.lib.BlockType.HEADING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.blocks.lib.BlockType r1 = io.intercom.android.sdk.blocks.lib.BlockType.CODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.blocks.lib.BlockType r1 = io.intercom.android.sdk.blocks.lib.BlockType.PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType     // Catch:{ NoSuchFieldError -> 0x003e }
                io.intercom.android.sdk.blocks.lib.BlockType r1 = io.intercom.android.sdk.blocks.lib.BlockType.LINK     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.intercom.android.sdk.blocks.lib.BlockType r1 = io.intercom.android.sdk.blocks.lib.BlockType.UNORDEREDLIST     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.intercom.android.sdk.blocks.lib.BlockType r1 = io.intercom.android.sdk.blocks.lib.BlockType.ORDEREDLIST     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.views.holder.BlocksPartViewHolder.AnonymousClass1.<clinit>():void");
        }
    }

    private static void appendLine(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateAvatarMarginForCard(Part part) {
        Resources resources = this.networkAvatar.getContext().getResources();
        int i = 0;
        boolean z = part.isLinkCard() || part.isLinkList() || isSingleCardPart(part);
        int dimension = z ? (int) resources.getDimension(R.dimen.intercom_card_shadow_bottom_margin) : 0;
        if (!z) {
            i = (int) resources.getDimension(R.dimen.intercom_conversation_row_icon_spacer);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.networkAvatar.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, i, dimension);
    }

    /* access modifiers changed from: package-private */
    public boolean isSingleCardPart(Part part) {
        List<Block> blocks = part.getBlocks();
        if (blocks.size() != 1) {
            return false;
        }
        Block block = blocks.get(0);
        if (block.getType() != BlockType.MESSENGERCARD || TextUtils.isEmpty(block.getFallbackUrl())) {
            return false;
        }
        return true;
    }
}
