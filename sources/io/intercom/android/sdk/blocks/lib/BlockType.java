package io.intercom.android.sdk.blocks.lib;

import android.view.View;
import android.view.ViewGroup;
import com.github.scribejava.core.model.OAuthConstants;
import com.intercom.commons.utilities.HtmlCompat;
import io.intercom.android.sdk.blocks.lib.interfaces.TwitterBlock;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.blocks.lib.models.ConversationRating;
import io.intercom.android.sdk.blocks.lib.models.Link;
import io.intercom.android.sdk.blocks.lib.models.LinkList;
import java.util.Locale;

public enum BlockType {
    PARAGRAPH("paragraph") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getParagraph().addParagraph(HtmlCompat.fromHtml(block.getText()), block.getAlign(), blockMetadata, viewGroup);
        }
    },
    HEADING("heading") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getHeading().addHeading(HtmlCompat.fromHtml(block.getText()), block.getAlign(), blockMetadata, viewGroup);
        }
    },
    SUBHEADING("subheading") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getSubheading().addSubheading(HtmlCompat.fromHtml(block.getText()), block.getAlign(), blockMetadata, viewGroup);
        }
    },
    CODE(OAuthConstants.CODE) {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getCode().addCode(HtmlCompat.fromHtml(block.getText()), blockMetadata, viewGroup);
        }
    },
    LINK("link") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getLink().addLinkBlock(Link.fromBlock(block), blockMetadata, viewGroup);
        }
    },
    CONVERSATIONRATING("conversationRating") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getConversationRating().addConversationRatingBlock(ConversationRating.fromBlock(block), blockMetadata, viewGroup);
        }
    },
    LINKLIST("linkList") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getLinkList().addLinkListBlock(LinkList.fromBlock(block), blockMetadata, viewGroup);
        }
    },
    UNORDEREDLIST("unorderedList") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getUnorderedList().addUnorderedList(block.getItems(), blockMetadata, viewGroup);
        }
    },
    ORDEREDLIST("orderedList") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getOrderedList().addOrderedList(block.getItems(), blockMetadata, viewGroup);
        }
    },
    ATTACHMENTLIST("attachmentList") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getAttachmentList().addAttachmentList(block.getAttachments(), blockMetadata, viewGroup);
        }
    },
    IMAGE("image") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getImage().addImage(block.getUrl(), getLinkUrl(block), block.getDescription(), block.getWidth(), block.getHeight(), block.getAlign(), blockMetadata, viewGroup);
        }
    },
    IMAGETEXT("imageText") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            block.getImage();
            return blocksViewHolder.getImageText().addImageText(HtmlCompat.fromHtml(block.getTitle()), HtmlCompat.fromHtml(block.getText()), block.getImageUrl(), block.getDescription(), block.getImageWidth(), block.getImageHeight(), blockMetadata, viewGroup);
        }
    },
    BUTTON("button") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getButton().addButton(HtmlCompat.fromHtml(block.getText()), getLinkUrl(block), block.getAlign(), blockMetadata, viewGroup);
        }
    },
    FACEBOOKLIKEBUTTON("facebookLikeButton") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getFacebookButton().addFacebookButton(block.getUrl(), block.getAlign(), blockMetadata, viewGroup);
        }
    },
    TWITTERFOLLOWBUTTON("twitterFollowButton") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            TwitterBlock twitterButton = blocksViewHolder.getTwitterButton();
            return twitterButton.addTwitterButton("https://twitter.com/" + block.getUsername(), block.getAlign(), blockMetadata, viewGroup);
        }
    },
    VIDEO("video") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getVideo().addVideo(block.getText(), VideoProvider.videoValueOf(block.getProvider()), block.getId(), blockMetadata, viewGroup);
        }
    },
    VIDEOFILE("videoFile") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getVideoFile().addVideoFile(block.getText(), block.getUrl(), block.getThumbnailUrl(), blockMetadata, viewGroup);
        }
    },
    MESSENGERCARD("messengerCard") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getMessengerCardBlock().addCard(block.getText(), block.getFallbackUrl(), blockMetadata, viewGroup);
        }
    },
    LOCALIMAGE("localImage") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getLocalImage().addImage(block.getUri(), block.getWidth(), block.getHeight(), block.getAlign(), blockMetadata, viewGroup);
        }
    },
    LOCAL_ATTACHMENT("local_attachment") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getLocalAttachment().addAttachment(block.getAttachments().get(0), blockMetadata, viewGroup);
        }
    },
    CREATETICKETCARD("createTicketCard") {
        /* access modifiers changed from: package-private */
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            return blocksViewHolder.getParagraph().addParagraph(HtmlCompat.fromHtml(block.getText()), block.getAlign(), blockMetadata, viewGroup);
        }
    },
    UNKNOWN("unknown") {
        public View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata) {
            if (!block.getText().isEmpty() && blocksViewHolder.getParagraph() != null) {
                return PARAGRAPH.generateViewFromBlockAndLayout(blocksViewHolder, block, viewGroup, blockMetadata);
            }
            throw new BlockTypeNotImplementedException();
        }
    };
    
    private final String serializedName;

    /* access modifiers changed from: package-private */
    public abstract View generateViewFromBlockAndLayout(BlocksViewHolder blocksViewHolder, Block block, ViewGroup viewGroup, BlockMetadata blockMetadata);

    private BlockType(String str) {
        this.serializedName = str;
    }

    public String getSerializedName() {
        return this.serializedName;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
        return UNKNOWN.generateViewFromBlockAndLayout(r2, r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        throw new io.intercom.android.sdk.blocks.lib.BlockTypeNotImplementedException();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(io.intercom.android.sdk.blocks.lib.BlocksViewHolder r2, io.intercom.android.sdk.blocks.lib.models.Block r3, android.view.ViewGroup r4, io.intercom.android.sdk.blocks.lib.models.BlockMetadata r5) throws io.intercom.android.sdk.blocks.lib.BlockTypeNotImplementedException {
        /*
            r1 = this;
            android.view.View r2 = r1.generateViewFromBlockAndLayout(r2, r3, r4, r5)     // Catch:{ NullPointerException -> 0x0005 }
            return r2
        L_0x0005:
            io.intercom.android.sdk.blocks.lib.BlockType r0 = UNKNOWN     // Catch:{ BlockTypeNotImplementedException | NullPointerException -> 0x000c }
            android.view.View r2 = r0.generateViewFromBlockAndLayout(r2, r3, r4, r5)     // Catch:{ BlockTypeNotImplementedException | NullPointerException -> 0x000c }
            return r2
        L_0x000c:
            io.intercom.android.sdk.blocks.lib.BlockTypeNotImplementedException r2 = new io.intercom.android.sdk.blocks.lib.BlockTypeNotImplementedException
            r2.<init>()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.blocks.lib.BlockType.getView(io.intercom.android.sdk.blocks.lib.BlocksViewHolder, io.intercom.android.sdk.blocks.lib.models.Block, android.view.ViewGroup, io.intercom.android.sdk.blocks.lib.models.BlockMetadata):android.view.View");
    }

    protected static String getLinkUrl(Block block) {
        return block.getTrackingUrl().isEmpty() ? block.getLinkUrl() : block.getTrackingUrl();
    }

    public static BlockType typeValueOf(String str) {
        try {
            return valueOf(str.toUpperCase(Locale.ENGLISH));
        } catch (IllegalArgumentException | NullPointerException unused) {
            return UNKNOWN;
        }
    }
}
