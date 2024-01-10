package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.widget.LinearLayout;
import com.google.gson.Gson;
import com.squareup.otto.Bus;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.Blocks;
import io.intercom.android.sdk.blocks.lib.BlocksViewHolder;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.blocks.lib.models.BlockAttachment;
import io.intercom.android.sdk.blocks.messengercard.MessengerCard;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Attachments;
import io.intercom.android.sdk.models.Part;
import java.util.ArrayList;
import java.util.List;

public class ViewHolderGenerator {
    private final Api api;
    private final Provider<AppConfig> appConfigProvider;
    private final Bus bus;
    private final ButtonClickListener buttonClickListener;
    private final Context context;
    private final String conversationId;
    private final Gson gson;
    private final ImageClickListener imageListener;
    private final MetricTracker metricTracker;
    private final UploadingImageCache uploadingImageCache;

    public ViewHolderGenerator(UploadingImageCache uploadingImageCache2, Api api2, Provider<AppConfig> provider, String str, ImageClickListener imageClickListener, ButtonClickListener buttonClickListener2, Gson gson2, Bus bus2, MetricTracker metricTracker2, Context context2) {
        this.uploadingImageCache = uploadingImageCache2;
        this.api = api2;
        this.appConfigProvider = provider;
        this.conversationId = str;
        this.imageListener = imageClickListener;
        this.buttonClickListener = buttonClickListener2;
        this.gson = gson2;
        this.bus = bus2;
        this.metricTracker = metricTracker2;
        this.context = context2;
    }

    public BlocksViewHolder getAdminHolder() {
        return generateHolder(R.layout.intercom_blocks_admin_layout, StyleType.ADMIN);
    }

    public BlocksViewHolder getUserHolder() {
        return generateHolder(R.layout.intercom_blocks_user_layout, StyleType.USER);
    }

    public BlocksViewHolder getPreviewHolder() {
        return generateHolder(R.layout.intercom_blocks_user_layout, StyleType.PREVIEW);
    }

    public BlocksViewHolder getPostHolder() {
        return generateHolder(R.layout.intercom_blocks_container_layout, StyleType.POST);
    }

    public BlocksViewHolder getNoteHolder() {
        return generateHolder(R.layout.intercom_blocks_note_layout, StyleType.NOTE);
    }

    public BlocksViewHolder getArticleHolder() {
        return generateHolder(R.layout.intercom_blocks_article_layout, StyleType.ARTICLE);
    }

    public BlocksViewHolder getContainerCardHolder() {
        return generateHolder(R.layout.intercom_blocks_container_card_layout, StyleType.CONTAINER_CARD);
    }

    public BlocksViewHolder getChatFullHolder() {
        return generateHolder(R.layout.intercom_blocks_admin_layout, StyleType.CHAT_FULL);
    }

    public BlocksViewHolder getLinkHolder() {
        return generateHolder(R.layout.intercom_blocks_container_layout, StyleType.CHAT_FULL);
    }

    public BlocksViewHolder getConversationRatingHolder() {
        return generateHolder(R.layout.intercom_blocks_container_layout, StyleType.CHAT_FULL);
    }

    public BlocksViewHolder getLinkListHolder() {
        return generateHolder(R.layout.intercom_blocks_container_card_layout, StyleType.CHAT_FULL);
    }

    public BlocksViewHolder getCarouselHolder() {
        return generateHolder(R.layout.intercom_blocks_carousel_layout, StyleType.CAROUSEL);
    }

    private BlocksViewHolder generateHolder(int i, StyleType styleType) {
        BlocksViewHolder blocksViewHolder = new BlocksViewHolder();
        Button button = new Button(styleType, this.appConfigProvider, this.buttonClickListener);
        Heading heading = new Heading(styleType, this.appConfigProvider);
        ListBlock listBlock = new ListBlock(styleType, this.appConfigProvider);
        Attachment attachment = new Attachment(styleType, this.appConfigProvider);
        blocksViewHolder.setLayout(i);
        blocksViewHolder.setParagraph(new Paragraph(styleType, this.appConfigProvider));
        blocksViewHolder.setHeading(heading);
        blocksViewHolder.setSubheading(heading);
        blocksViewHolder.setCode(new Code());
        blocksViewHolder.setUnorderedList(listBlock);
        blocksViewHolder.setOrderedList(listBlock);
        blocksViewHolder.setImage(new NetworkImage(styleType, this.uploadingImageCache, this.imageListener));
        blocksViewHolder.setLocalImage(new LocalImage(styleType));
        blocksViewHolder.setButton(button);
        blocksViewHolder.setAttachmentList(attachment);
        blocksViewHolder.setLocalAttachment(attachment);
        blocksViewHolder.setTwitterButton(button);
        blocksViewHolder.setFacebookButton(button);
        blocksViewHolder.setVideo(new Video(styleType, this.api, this.appConfigProvider));
        blocksViewHolder.setVideoFile(new VideoFile(styleType, this.appConfigProvider, this.metricTracker));
        blocksViewHolder.setLink(new LinkCard(styleType, this.appConfigProvider, this.conversationId));
        blocksViewHolder.setConversationRating(new ConversationRatingCard(this.api, this.conversationId, this.appConfigProvider));
        blocksViewHolder.setLinkList(new LinkListRenderer(this.api, this.appConfigProvider, this.conversationId));
        blocksViewHolder.setImageText(new ImageText(styleType, this.uploadingImageCache));
        if (!styleType.equals(StyleType.CHAT_FULL)) {
            blocksViewHolder.setMessengerCardBlock(new MessengerCard(this.appConfigProvider, this.gson, this.bus, this.metricTracker, this.conversationId, styleType, this.context));
        }
        return blocksViewHolder;
    }

    public static LinearLayout createPartsLayout(BlocksViewHolder blocksViewHolder, Part part, Context context2) {
        List<Block> blocks = part.getBlocks();
        if (!part.getAttachments().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Attachments next : part.getAttachments()) {
                arrayList.add(new BlockAttachment.Builder().withName(next.getName()).withUrl(next.getUrl()).build());
            }
            blocks.add(new Block.Builder().withType(BlockType.ATTACHMENTLIST.name()).withAttachments(arrayList).build());
        }
        return new Blocks(context2, LumberMill.getBlocksTwig()).createBlocks(blocks, blocksViewHolder);
    }

    public static LinearLayout createLayoutFromBlocks(BlocksViewHolder blocksViewHolder, List<Block> list, Context context2) {
        return new Blocks(context2, LumberMill.getBlocksTwig()).createBlocks(list, blocksViewHolder);
    }
}