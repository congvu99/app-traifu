package io.intercom.android.sdk.blocks.lib;

import io.intercom.android.sdk.blocks.lib.interfaces.AttachmentListBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.ButtonBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.CodeBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.ConversationRatingBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.FacebookBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.HeadingBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.ImageBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.ImageTextBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.LinkBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.LinkListBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.LocalAttachmentBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.LocalImageBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.MessengerCardBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.OrderedListBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.ParagraphBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.SubheadingBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.TwitterBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.UnorderedListBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.VideoBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.VideoFileBlock;

public class BlocksViewHolder {
    private AttachmentListBlock attachmentList;
    private ButtonBlock button;
    private CodeBlock code;
    private ConversationRatingBlock conversationRating;
    private FacebookBlock facebookButton;
    private HeadingBlock heading;
    private ImageBlock image;
    private ImageTextBlock imageText;
    private int layout;
    private LinkBlock link;
    private LinkListBlock linkList;
    private LocalAttachmentBlock localAttachment;
    private LocalImageBlock localImage;
    private MessengerCardBlock messengerCardBlock;
    private OrderedListBlock orderedList;
    private ParagraphBlock paragraph;
    private SubheadingBlock subheading;
    private TwitterBlock twitterButton;
    private UnorderedListBlock unorderedList;
    private VideoBlock video;
    private VideoFileBlock videoFile;

    public int getLayout() {
        return this.layout;
    }

    public void setLayout(int i) {
        this.layout = i;
    }

    public ParagraphBlock getParagraph() {
        return this.paragraph;
    }

    public void setParagraph(ParagraphBlock paragraphBlock) {
        this.paragraph = paragraphBlock;
    }

    public HeadingBlock getHeading() {
        return this.heading;
    }

    public void setHeading(HeadingBlock headingBlock) {
        this.heading = headingBlock;
    }

    public SubheadingBlock getSubheading() {
        return this.subheading;
    }

    public void setSubheading(SubheadingBlock subheadingBlock) {
        this.subheading = subheadingBlock;
    }

    public CodeBlock getCode() {
        return this.code;
    }

    public void setCode(CodeBlock codeBlock) {
        this.code = codeBlock;
    }

    public LinkBlock getLink() {
        return this.link;
    }

    public void setLink(LinkBlock linkBlock) {
        this.link = linkBlock;
    }

    public LinkListBlock getLinkList() {
        return this.linkList;
    }

    public void setLinkList(LinkListBlock linkListBlock) {
        this.linkList = linkListBlock;
    }

    public ConversationRatingBlock getConversationRating() {
        return this.conversationRating;
    }

    public void setConversationRating(ConversationRatingBlock conversationRatingBlock) {
        this.conversationRating = conversationRatingBlock;
    }

    public MessengerCardBlock getMessengerCardBlock() {
        return this.messengerCardBlock;
    }

    public void setMessengerCardBlock(MessengerCardBlock messengerCardBlock2) {
        this.messengerCardBlock = messengerCardBlock2;
    }

    public UnorderedListBlock getUnorderedList() {
        return this.unorderedList;
    }

    public void setUnorderedList(UnorderedListBlock unorderedListBlock) {
        this.unorderedList = unorderedListBlock;
    }

    public OrderedListBlock getOrderedList() {
        return this.orderedList;
    }

    public void setOrderedList(OrderedListBlock orderedListBlock) {
        this.orderedList = orderedListBlock;
    }

    public ImageBlock getImage() {
        return this.image;
    }

    public void setImage(ImageBlock imageBlock) {
        this.image = imageBlock;
    }

    public ImageTextBlock getImageText() {
        return this.imageText;
    }

    public void setImageText(ImageTextBlock imageTextBlock) {
        this.imageText = imageTextBlock;
    }

    public LocalImageBlock getLocalImage() {
        return this.localImage;
    }

    public void setLocalImage(LocalImageBlock localImageBlock) {
        this.localImage = localImageBlock;
    }

    public ButtonBlock getButton() {
        return this.button;
    }

    public void setButton(ButtonBlock buttonBlock) {
        this.button = buttonBlock;
    }

    public FacebookBlock getFacebookButton() {
        return this.facebookButton;
    }

    public void setFacebookButton(FacebookBlock facebookBlock) {
        this.facebookButton = facebookBlock;
    }

    public TwitterBlock getTwitterButton() {
        return this.twitterButton;
    }

    public void setTwitterButton(TwitterBlock twitterBlock) {
        this.twitterButton = twitterBlock;
    }

    public VideoBlock getVideo() {
        return this.video;
    }

    public void setVideo(VideoBlock videoBlock) {
        this.video = videoBlock;
    }

    public AttachmentListBlock getAttachmentList() {
        return this.attachmentList;
    }

    public void setAttachmentList(AttachmentListBlock attachmentListBlock) {
        this.attachmentList = attachmentListBlock;
    }

    public LocalAttachmentBlock getLocalAttachment() {
        return this.localAttachment;
    }

    public void setLocalAttachment(LocalAttachmentBlock localAttachmentBlock) {
        this.localAttachment = localAttachmentBlock;
    }

    public VideoFileBlock getVideoFile() {
        return this.videoFile;
    }

    public void setVideoFile(VideoFileBlock videoFileBlock) {
        this.videoFile = videoFileBlock;
    }
}
