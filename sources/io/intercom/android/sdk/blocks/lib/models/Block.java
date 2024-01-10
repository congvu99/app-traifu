package io.intercom.android.sdk.blocks.lib.models;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.ConversationRatingOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlinx.serialization.json.internal.JsonLexerKt;

public class Block implements Parcelable {
    public static final Parcelable.Creator<Block> CREATOR = new Parcelable.Creator<Block>() {
        public Block createFromParcel(Parcel parcel) {
            return new Block(parcel);
        }

        public Block[] newArray(int i) {
            return new Block[i];
        }
    };
    private final BlockAlignment align;
    private final String articleId;
    private final List<BlockAttachment> attachments;
    private final String attribution;
    private final Author author;
    private final Map<String, String> data;
    private final String description;
    private final String fallbackUrl;
    private final Link footerLink;
    private final int height;
    private final String id;
    private final Image image;
    private final int imageHeight;
    private final String imageUrl;
    private final int imageWidth;
    private final List<String> items;
    private final String language;
    private final String linkType;
    private final String linkUrl;
    private final List<Link> links;
    private final List<ConversationRatingOption> options;
    private final String previewUrl;
    private final String provider;
    private final int ratingIndex;
    private final String remark;
    private final String siteName;
    private final String text;
    private final String thumbnailUrl;
    private int ticketTypeId;
    private final TicketType ticket_type;
    private final String ticket_type_title;
    private final String title;
    private final String trackingUrl;
    private final BlockType type;
    private final Uri uri;
    private final String url;
    private final String username;
    private final int width;

    public int describeContents() {
        return 0;
    }

    Block() {
        this(new Builder());
    }

    private Block(Builder builder) {
        this.type = BlockType.typeValueOf(builder.type);
        String str = "";
        this.text = builder.text == null ? str : builder.text;
        this.title = builder.title == null ? str : builder.title;
        this.description = builder.description == null ? str : builder.description;
        this.linkType = builder.linkType == null ? str : builder.linkType;
        this.siteName = builder.siteName == null ? str : builder.siteName;
        this.articleId = builder.articleId == null ? str : builder.articleId;
        this.author = builder.author == null ? new Author() : builder.author;
        this.image = builder.image == null ? new Image() : builder.image;
        this.data = builder.data == null ? Collections.emptyMap() : builder.data;
        this.language = builder.language == null ? str : builder.language;
        this.url = builder.url == null ? str : builder.url;
        this.thumbnailUrl = builder.thumbnailUrl == null ? str : builder.thumbnailUrl;
        this.linkUrl = builder.linkUrl == null ? str : builder.linkUrl;
        this.trackingUrl = builder.trackingUrl == null ? str : builder.trackingUrl;
        this.fallbackUrl = builder.fallbackUrl == null ? str : builder.fallbackUrl;
        this.username = builder.username == null ? str : builder.username;
        this.provider = builder.provider == null ? str : builder.provider;
        this.id = builder.id == null ? str : builder.id;
        this.align = BlockAlignment.alignValueOf(builder.align);
        int i = 0;
        this.width = builder.width == null ? 0 : builder.width.intValue();
        this.height = builder.height == null ? 0 : builder.height.intValue();
        this.previewUrl = builder.previewUrl == null ? str : builder.previewUrl;
        this.attribution = builder.attribution == null ? str : builder.attribution;
        this.uri = builder.uri == null ? Uri.EMPTY : builder.uri;
        this.imageUrl = builder.imageUrl == null ? str : builder.imageUrl;
        this.imageWidth = builder.imageWidth == null ? 0 : builder.imageWidth.intValue();
        this.imageHeight = builder.imageHeight != null ? builder.imageHeight.intValue() : i;
        this.attachments = new ArrayList();
        if (builder.attachments != null) {
            for (BlockAttachment next : builder.attachments) {
                if (next != null) {
                    this.attachments.add(next);
                }
            }
        }
        this.items = new ArrayList();
        if (builder.items != null) {
            for (String next2 : builder.items) {
                if (next2 != null) {
                    this.items.add(next2);
                }
            }
        }
        if (builder.ratingIndex != null) {
            this.ratingIndex = builder.ratingIndex.intValue();
        } else if (builder.rating_index != null) {
            this.ratingIndex = builder.rating_index.intValue();
        } else {
            this.ratingIndex = -1;
        }
        this.remark = builder.remark == null ? str : builder.remark;
        this.options = new ArrayList();
        if (builder.options != null) {
            for (ConversationRatingOption.Builder next3 : builder.options) {
                if (next3 != null) {
                    this.options.add(next3.build());
                }
            }
        }
        this.links = new ArrayList();
        if (builder.links != null) {
            for (Builder next4 : builder.links) {
                if (next4 != null) {
                    this.links.add(Link.fromBlock(next4.build()));
                }
            }
        }
        this.footerLink = builder.footerLink == null ? new Link() : Link.fromBlock(builder.footerLink.build());
        this.ticket_type_title = builder.ticket_type_title != null ? builder.ticket_type_title : str;
        this.ticket_type = builder.ticket_type == null ? TicketType.Companion.getNULL() : builder.ticket_type;
        this.ticketTypeId = builder.ticket_type_id;
    }

    public int getTicketTypeId() {
        return this.ticketTypeId;
    }

    public static final class Builder {
        String align;
        String articleId;
        List<BlockAttachment> attachments;
        String attribution;
        Author author;
        Map<String, String> data;
        String description;
        String fallbackUrl;
        Builder footerLink;
        Integer height;
        String id;
        Image image;
        Integer imageHeight;
        String imageUrl;
        Integer imageWidth;
        List<String> items;
        String language;
        String linkType;
        String linkUrl;
        List<Builder> links;
        List<ConversationRatingOption.Builder> options;
        String previewUrl;
        String provider;
        Integer ratingIndex;
        Integer rating_index;
        String remark;
        String siteName;
        String text;
        String thumbnailUrl;
        TicketType ticket_type;
        int ticket_type_id;
        String ticket_type_title;
        String title;
        String trackingUrl;
        String type;
        Uri uri;
        String url;
        String username;
        Integer width;

        public Builder withText(String str) {
            this.text = str;
            return this;
        }

        public Builder withTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder withDescription(String str) {
            this.description = str;
            return this;
        }

        public Builder withLinkType(String str) {
            this.linkType = str;
            return this;
        }

        public Builder withSiteName(String str) {
            this.siteName = str;
            return this;
        }

        public Builder withArticleId(String str) {
            this.articleId = str;
            return this;
        }

        public Builder withAuthor(Author author2) {
            this.author = author2;
            return this;
        }

        public Builder withImage(Image image2) {
            this.image = image2;
            return this;
        }

        public Builder withData(Map<String, String> map) {
            this.data = map;
            return this;
        }

        public Builder withType(String str) {
            this.type = str;
            return this;
        }

        public Builder withUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder withThumbnailUrl(String str) {
            this.thumbnailUrl = str;
            return this;
        }

        public Builder withAlign(String str) {
            this.align = str;
            return this;
        }

        public Builder withHeight(int i) {
            this.height = Integer.valueOf(i);
            return this;
        }

        public Builder withWidth(int i) {
            this.width = Integer.valueOf(i);
            return this;
        }

        public Builder withItems(List<String> list) {
            this.items = list;
            return this;
        }

        public Builder withPreviewUrl(String str) {
            this.previewUrl = str;
            return this;
        }

        public Builder withAttribution(String str) {
            this.attribution = str;
            return this;
        }

        public Builder withAttachments(List<BlockAttachment> list) {
            this.attachments = list;
            return this;
        }

        public Builder withRatingIndex(Integer num) {
            this.ratingIndex = num;
            return this;
        }

        public Builder withRemark(String str) {
            this.remark = str;
            return this;
        }

        public Builder withOptions(List<ConversationRatingOption.Builder> list) {
            this.options = list;
            return this;
        }

        public Builder withUri(Uri uri2) {
            this.uri = uri2;
            return this;
        }

        public Builder withImageUrl(String str) {
            this.imageUrl = str;
            return this;
        }

        public Builder withImageWidth(int i) {
            this.imageWidth = Integer.valueOf(i);
            return this;
        }

        public Builder withImageHeight(int i) {
            this.imageHeight = Integer.valueOf(i);
            return this;
        }

        public Builder withTicketTypeTitle(String str) {
            this.ticket_type_title = str;
            return this;
        }

        public Builder withTicketType(TicketType ticketType) {
            this.ticket_type = ticketType;
            return this;
        }

        public Block build() {
            return new Block(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Builder builder = (Builder) obj;
            String str = this.type;
            if (str == null ? builder.type != null : !str.equals(builder.type)) {
                return false;
            }
            String str2 = this.text;
            if (str2 == null ? builder.text != null : !str2.equals(builder.text)) {
                return false;
            }
            String str3 = this.title;
            if (str3 == null ? builder.title != null : !str3.equals(builder.title)) {
                return false;
            }
            String str4 = this.description;
            if (str4 == null ? builder.description != null : !str4.equals(builder.description)) {
                return false;
            }
            String str5 = this.linkType;
            if (str5 == null ? builder.linkType != null : !str5.equals(builder.linkType)) {
                return false;
            }
            String str6 = this.siteName;
            if (str6 == null ? builder.siteName != null : !str6.equals(builder.siteName)) {
                return false;
            }
            String str7 = this.articleId;
            if (str7 == null ? builder.articleId != null : !str7.equals(builder.articleId)) {
                return false;
            }
            Author author2 = this.author;
            if (author2 == null ? builder.author != null : !author2.equals(builder.author)) {
                return false;
            }
            Image image2 = this.image;
            if (image2 == null ? builder.image != null : !image2.equals(builder.image)) {
                return false;
            }
            Map<String, String> map = this.data;
            if (map == null ? builder.data != null : !map.equals(builder.data)) {
                return false;
            }
            String str8 = this.language;
            if (str8 == null ? builder.language != null : !str8.equals(builder.language)) {
                return false;
            }
            String str9 = this.url;
            if (str9 == null ? builder.url != null : !str9.equals(builder.url)) {
                return false;
            }
            String str10 = this.thumbnailUrl;
            if (str10 == null ? builder.thumbnailUrl != null : !str10.equals(builder.thumbnailUrl)) {
                return false;
            }
            String str11 = this.linkUrl;
            if (str11 == null ? builder.linkUrl != null : !str11.equals(builder.linkUrl)) {
                return false;
            }
            String str12 = this.trackingUrl;
            if (str12 == null ? builder.trackingUrl != null : !str12.equals(builder.trackingUrl)) {
                return false;
            }
            String str13 = this.fallbackUrl;
            if (str13 == null ? builder.fallbackUrl != null : !str13.equals(builder.fallbackUrl)) {
                return false;
            }
            String str14 = this.username;
            if (str14 == null ? builder.username != null : !str14.equals(builder.username)) {
                return false;
            }
            String str15 = this.provider;
            if (str15 == null ? builder.provider != null : !str15.equals(builder.provider)) {
                return false;
            }
            String str16 = this.id;
            if (str16 == null ? builder.id != null : !str16.equals(builder.id)) {
                return false;
            }
            String str17 = this.align;
            if (str17 == null ? builder.align != null : !str17.equals(builder.align)) {
                return false;
            }
            Integer num = this.width;
            if (num == null ? builder.width != null : !num.equals(builder.width)) {
                return false;
            }
            Integer num2 = this.height;
            if (num2 == null ? builder.height != null : !num2.equals(builder.height)) {
                return false;
            }
            String str18 = this.previewUrl;
            if (str18 == null ? builder.previewUrl != null : !str18.equals(builder.previewUrl)) {
                return false;
            }
            String str19 = this.attribution;
            if (str19 == null ? builder.attribution != null : !str19.equals(builder.attribution)) {
                return false;
            }
            List<BlockAttachment> list = this.attachments;
            if (list == null ? builder.attachments != null : !list.equals(builder.attachments)) {
                return false;
            }
            List<String> list2 = this.items;
            if (list2 == null ? builder.items != null : !list2.equals(builder.items)) {
                return false;
            }
            Integer num3 = this.rating_index;
            if (num3 == null ? builder.rating_index != null : !num3.equals(builder.rating_index)) {
                return false;
            }
            Integer num4 = this.ratingIndex;
            if (num4 == null ? builder.ratingIndex != null : !num4.equals(builder.ratingIndex)) {
                return false;
            }
            String str20 = this.remark;
            if (str20 == null ? builder.remark != null : !str20.equals(builder.remark)) {
                return false;
            }
            List<ConversationRatingOption.Builder> list3 = this.options;
            if (list3 == null ? builder.options != null : !list3.equals(builder.options)) {
                return false;
            }
            List<Builder> list4 = this.links;
            if (list4 == null ? builder.links != null : !list4.equals(builder.links)) {
                return false;
            }
            String str21 = this.imageUrl;
            if (str21 == null ? builder.imageUrl != null : !str21.equals(builder.imageUrl)) {
                return false;
            }
            Integer num5 = this.imageWidth;
            if (num5 == null ? builder.imageWidth != null : !num5.equals(builder.imageWidth)) {
                return false;
            }
            Integer num6 = this.imageHeight;
            if (num6 == null ? builder.imageHeight != null : !num6.equals(builder.imageHeight)) {
                return false;
            }
            String str22 = this.ticket_type_title;
            if (str22 == null ? builder.ticket_type_title != null : !str22.equals(builder.ticket_type_title)) {
                return false;
            }
            TicketType ticketType = this.ticket_type;
            if (ticketType == null ? builder.ticket_type != null : !ticketType.equals(builder.ticket_type)) {
                return false;
            }
            if (!Objects.equals(Integer.valueOf(this.ticket_type_id), Integer.valueOf(builder.ticket_type_id))) {
                return false;
            }
            Builder builder2 = this.footerLink;
            Builder builder3 = builder.footerLink;
            if (builder2 != null) {
                return builder2.equals(builder3);
            }
            if (builder3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.type;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.text;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.title;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.description;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.linkType;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.siteName;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.articleId;
            int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            Author author2 = this.author;
            int hashCode8 = (hashCode7 + (author2 != null ? author2.hashCode() : 0)) * 31;
            Image image2 = this.image;
            int hashCode9 = (hashCode8 + (image2 != null ? image2.hashCode() : 0)) * 31;
            Map<String, String> map = this.data;
            int hashCode10 = (hashCode9 + (map != null ? map.hashCode() : 0)) * 31;
            String str8 = this.language;
            int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.url;
            int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
            String str10 = this.thumbnailUrl;
            int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
            String str11 = this.linkUrl;
            int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
            String str12 = this.trackingUrl;
            int hashCode15 = (hashCode14 + (str12 != null ? str12.hashCode() : 0)) * 31;
            String str13 = this.fallbackUrl;
            int hashCode16 = (hashCode15 + (str13 != null ? str13.hashCode() : 0)) * 31;
            String str14 = this.username;
            int hashCode17 = (hashCode16 + (str14 != null ? str14.hashCode() : 0)) * 31;
            String str15 = this.provider;
            int hashCode18 = (hashCode17 + (str15 != null ? str15.hashCode() : 0)) * 31;
            String str16 = this.id;
            int hashCode19 = (hashCode18 + (str16 != null ? str16.hashCode() : 0)) * 31;
            String str17 = this.align;
            int hashCode20 = (hashCode19 + (str17 != null ? str17.hashCode() : 0)) * 31;
            Integer num = this.width;
            int hashCode21 = (hashCode20 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.height;
            int hashCode22 = (hashCode21 + (num2 != null ? num2.hashCode() : 0)) * 31;
            String str18 = this.previewUrl;
            int hashCode23 = (hashCode22 + (str18 != null ? str18.hashCode() : 0)) * 31;
            String str19 = this.attribution;
            int hashCode24 = (hashCode23 + (str19 != null ? str19.hashCode() : 0)) * 31;
            List<BlockAttachment> list = this.attachments;
            int hashCode25 = (hashCode24 + (list != null ? list.hashCode() : 0)) * 31;
            List<String> list2 = this.items;
            int hashCode26 = (hashCode25 + (list2 != null ? list2.hashCode() : 0)) * 31;
            Integer num3 = this.rating_index;
            int hashCode27 = (hashCode26 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Integer num4 = this.ratingIndex;
            int hashCode28 = (hashCode27 + (num4 != null ? num4.hashCode() : 0)) * 31;
            String str20 = this.remark;
            int hashCode29 = (hashCode28 + (str20 != null ? str20.hashCode() : 0)) * 31;
            List<ConversationRatingOption.Builder> list3 = this.options;
            int hashCode30 = (hashCode29 + (list3 != null ? list3.hashCode() : 0)) * 31;
            List<Builder> list4 = this.links;
            int hashCode31 = (hashCode30 + (list4 != null ? list4.hashCode() : 0)) * 31;
            Builder builder = this.footerLink;
            int hashCode32 = (hashCode31 + (builder != null ? builder.hashCode() : 0)) * 31;
            String str21 = this.imageUrl;
            int hashCode33 = (hashCode32 + (str21 != null ? str21.hashCode() : 0)) * 31;
            Integer num5 = this.imageWidth;
            int hashCode34 = (hashCode33 + (num5 != null ? num5.hashCode() : 0)) * 31;
            Integer num6 = this.imageHeight;
            int hashCode35 = (hashCode34 + (num6 != null ? num6.hashCode() : 0)) * 31;
            String str22 = this.ticket_type_title;
            int hashCode36 = (hashCode35 + (str22 != null ? str22.hashCode() : 0)) * 31;
            TicketType ticketType = this.ticket_type;
            if (ticketType != null) {
                i = ticketType.hashCode();
            }
            return ((hashCode36 + i) * 31) + this.ticket_type_id;
        }
    }

    /* renamed from: io.intercom.android.sdk.blocks.lib.models.Block$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.intercom.android.sdk.blocks.lib.BlockType[] r0 = io.intercom.android.sdk.blocks.lib.BlockType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType = r0
                io.intercom.android.sdk.blocks.lib.BlockType r1 = io.intercom.android.sdk.blocks.lib.BlockType.PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.blocks.lib.BlockType r1 = io.intercom.android.sdk.blocks.lib.BlockType.LOCALIMAGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.blocks.lib.BlockType r1 = io.intercom.android.sdk.blocks.lib.BlockType.IMAGE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.blocks.lib.BlockType r1 = io.intercom.android.sdk.blocks.lib.BlockType.LOCAL_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.blocks.lib.models.Block.AnonymousClass2.<clinit>():void");
        }
    }

    public Builder toBuilder() {
        Builder builder = new Builder();
        int i = AnonymousClass2.$SwitchMap$io$intercom$android$sdk$blocks$lib$BlockType[this.type.ordinal()];
        if (i == 1) {
            builder.withText(this.text).withType(this.type.getSerializedName());
        } else if (i == 2 || i == 3) {
            String str = null;
            Builder withAttribution = builder.withType(this.type.getSerializedName()).withUrl(this.url).withUri(this.uri).withAttribution(this.attribution.isEmpty() ? null : this.attribution);
            if (!this.previewUrl.isEmpty()) {
                str = this.previewUrl;
            }
            withAttribution.withPreviewUrl(str).withHeight(this.height).withWidth(this.width);
        } else if (i == 4) {
            builder.withType(this.type.getSerializedName()).withAttachments(this.attachments);
        }
        return builder;
    }

    public BlockType getType() {
        return this.type;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public String getArticleId() {
        return this.articleId;
    }

    public Author getAuthor() {
        return this.author;
    }

    public Image getImage() {
        return this.image;
    }

    public Map<String, String> getData() {
        return this.data;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getUrl() {
        return this.url;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public String getTrackingUrl() {
        return this.trackingUrl;
    }

    public String getFallbackUrl() {
        return this.fallbackUrl;
    }

    public String getUsername() {
        return this.username;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getId() {
        return this.id;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getPreviewUrl() {
        return this.previewUrl;
    }

    public String getAttribution() {
        return this.attribution;
    }

    public List<String> getItems() {
        return this.items;
    }

    public List<BlockAttachment> getAttachments() {
        return this.attachments;
    }

    public BlockAlignment getAlign() {
        return this.align;
    }

    public int getRatingIndex() {
        return this.ratingIndex;
    }

    public String getRemark() {
        return this.remark;
    }

    public List<ConversationRatingOption> getOptions() {
        return this.options;
    }

    public List<Link> getLinks() {
        return this.links;
    }

    public Link getFooterLink() {
        return this.footerLink;
    }

    public Uri getUri() {
        return this.uri;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public String getTicketTypeTitle() {
        return this.ticket_type_title;
    }

    public TicketType getTicketType() {
        return this.ticket_type;
    }

    public String toString() {
        return "Block{attachments=" + this.attachments + ", items=" + this.items + ", data=" + this.data + ", type=" + this.type + ", align=" + this.align + ", author=" + this.author + ", image=" + this.image + ", text='" + this.text + '\'' + ", title='" + this.title + '\'' + ", description='" + this.description + '\'' + ", linkType='" + this.linkType + '\'' + ", siteName='" + this.siteName + '\'' + ", articleId='" + this.articleId + '\'' + ", language='" + this.language + '\'' + ", url='" + this.url + '\'' + ", thumbnailUrl='" + this.thumbnailUrl + '\'' + ", previewUrl='" + this.previewUrl + '\'' + ", attribution='" + this.attribution + '\'' + ", linkUrl='" + this.linkUrl + '\'' + ", trackingUrl='" + this.trackingUrl + '\'' + ", fallbackUrl='" + this.fallbackUrl + '\'' + ", username='" + this.username + '\'' + ", provider='" + this.provider + '\'' + ", id='" + this.id + '\'' + ", width=" + this.width + ", height=" + this.height + ", ratingIndex=" + this.ratingIndex + ", remark='" + this.remark + '\'' + ", options=" + this.options + ", links=" + this.links + ", footerLink=" + this.footerLink + ", imageUrl=" + this.imageUrl + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", ticket_type_title=" + this.ticket_type_title + ", ticket_type=" + this.ticket_type + JsonLexerKt.END_OBJ;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Block block = (Block) obj;
        if (this.width != block.width || this.height != block.height || this.ratingIndex != block.ratingIndex) {
            return false;
        }
        List<BlockAttachment> list = this.attachments;
        if (list == null ? block.attachments != null : !list.equals(block.attachments)) {
            return false;
        }
        List<String> list2 = this.items;
        if (list2 == null ? block.items != null : !list2.equals(block.items)) {
            return false;
        }
        Map<String, String> map = this.data;
        if (map == null ? block.data != null : !map.equals(block.data)) {
            return false;
        }
        if (this.type != block.type || this.align != block.align) {
            return false;
        }
        Author author2 = this.author;
        if (author2 == null ? block.author != null : !author2.equals(block.author)) {
            return false;
        }
        Image image2 = this.image;
        if (image2 == null ? block.image != null : !image2.equals(block.image)) {
            return false;
        }
        String str = this.text;
        if (str == null ? block.text != null : !str.equals(block.text)) {
            return false;
        }
        String str2 = this.title;
        if (str2 == null ? block.title != null : !str2.equals(block.title)) {
            return false;
        }
        String str3 = this.description;
        if (str3 == null ? block.description != null : !str3.equals(block.description)) {
            return false;
        }
        String str4 = this.linkType;
        if (str4 == null ? block.linkType != null : !str4.equals(block.linkType)) {
            return false;
        }
        String str5 = this.siteName;
        if (str5 == null ? block.siteName != null : !str5.equals(block.siteName)) {
            return false;
        }
        String str6 = this.articleId;
        if (str6 == null ? block.articleId != null : !str6.equals(block.articleId)) {
            return false;
        }
        String str7 = this.language;
        if (str7 == null ? block.language != null : !str7.equals(block.language)) {
            return false;
        }
        String str8 = this.url;
        if (str8 == null ? block.url != null : !str8.equals(block.url)) {
            return false;
        }
        String str9 = this.thumbnailUrl;
        if (str9 == null ? block.thumbnailUrl != null : !str9.equals(block.thumbnailUrl)) {
            return false;
        }
        String str10 = this.previewUrl;
        if (str10 == null ? block.previewUrl != null : !str10.equals(block.previewUrl)) {
            return false;
        }
        String str11 = this.attribution;
        if (str11 == null ? block.attribution != null : !str11.equals(block.attribution)) {
            return false;
        }
        String str12 = this.linkUrl;
        if (str12 == null ? block.linkUrl != null : !str12.equals(block.linkUrl)) {
            return false;
        }
        String str13 = this.trackingUrl;
        if (str13 == null ? block.trackingUrl != null : !str13.equals(block.trackingUrl)) {
            return false;
        }
        String str14 = this.fallbackUrl;
        if (str14 == null ? block.fallbackUrl != null : !str14.equals(block.fallbackUrl)) {
            return false;
        }
        String str15 = this.username;
        if (str15 == null ? block.username != null : !str15.equals(block.username)) {
            return false;
        }
        String str16 = this.provider;
        if (str16 == null ? block.provider != null : !str16.equals(block.provider)) {
            return false;
        }
        String str17 = this.id;
        if (str17 == null ? block.id != null : !str17.equals(block.id)) {
            return false;
        }
        String str18 = this.remark;
        if (str18 == null ? block.remark != null : !str18.equals(block.remark)) {
            return false;
        }
        List<ConversationRatingOption> list3 = this.options;
        if (list3 == null ? block.options != null : !list3.equals(block.options)) {
            return false;
        }
        List<Link> list4 = this.links;
        if (list4 == null ? block.links != null : !list4.equals(block.links)) {
            return false;
        }
        Uri uri2 = this.uri;
        if (uri2 == null ? block.uri != null : !uri2.equals(block.uri)) {
            return false;
        }
        String str19 = this.imageUrl;
        if (str19 == null ? block.imageUrl != null : !str19.equals(block.imageUrl)) {
            return false;
        }
        if (this.imageWidth != block.imageWidth || this.imageHeight != block.imageHeight) {
            return false;
        }
        String str20 = this.ticket_type_title;
        if (str20 == null ? block.ticket_type_title != null : !str20.equals(block.ticket_type_title)) {
            return false;
        }
        TicketType ticketType = this.ticket_type;
        if (ticketType == null ? block.ticket_type != null : !ticketType.equals(block.ticket_type)) {
            return false;
        }
        Link link = this.footerLink;
        Link link2 = block.footerLink;
        if (link != null) {
            return link.equals(link2);
        }
        if (link2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        List<BlockAttachment> list = this.attachments;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.items;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        Map<String, String> map = this.data;
        int hashCode3 = (hashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        BlockType blockType = this.type;
        int hashCode4 = (hashCode3 + (blockType != null ? blockType.hashCode() : 0)) * 31;
        BlockAlignment blockAlignment = this.align;
        int hashCode5 = (hashCode4 + (blockAlignment != null ? blockAlignment.hashCode() : 0)) * 31;
        Author author2 = this.author;
        int hashCode6 = (hashCode5 + (author2 != null ? author2.hashCode() : 0)) * 31;
        Image image2 = this.image;
        int hashCode7 = (hashCode6 + (image2 != null ? image2.hashCode() : 0)) * 31;
        String str = this.text;
        int hashCode8 = (hashCode7 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.title;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.linkType;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.siteName;
        int hashCode12 = (hashCode11 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.articleId;
        int hashCode13 = (hashCode12 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.language;
        int hashCode14 = (hashCode13 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.url;
        int hashCode15 = (hashCode14 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.thumbnailUrl;
        int hashCode16 = (hashCode15 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.previewUrl;
        int hashCode17 = (hashCode16 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.attribution;
        int hashCode18 = (hashCode17 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.linkUrl;
        int hashCode19 = (hashCode18 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.trackingUrl;
        int hashCode20 = (hashCode19 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.fallbackUrl;
        int hashCode21 = (hashCode20 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.username;
        int hashCode22 = (hashCode21 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.provider;
        int hashCode23 = (hashCode22 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.id;
        int hashCode24 = (((((((hashCode23 + (str17 != null ? str17.hashCode() : 0)) * 31) + this.width) * 31) + this.height) * 31) + this.ratingIndex) * 31;
        String str18 = this.remark;
        int hashCode25 = (hashCode24 + (str18 != null ? str18.hashCode() : 0)) * 31;
        List<ConversationRatingOption> list3 = this.options;
        int hashCode26 = (hashCode25 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<Link> list4 = this.links;
        int hashCode27 = (hashCode26 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Link link = this.footerLink;
        int hashCode28 = (hashCode27 + (link != null ? link.hashCode() : 0)) * 31;
        Uri uri2 = this.uri;
        int hashCode29 = (hashCode28 + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        String str19 = this.imageUrl;
        int hashCode30 = (((((hashCode29 + (str19 != null ? str19.hashCode() : 0)) * 31) + this.imageWidth) * 31) + this.imageHeight) * 31;
        String str20 = this.ticket_type_title;
        int hashCode31 = (hashCode30 + (str20 != null ? str20.hashCode() : 0)) * 31;
        TicketType ticketType = this.ticket_type;
        if (ticketType != null) {
            i = ticketType.hashCode();
        }
        return hashCode31 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.attachments);
        parcel.writeStringList(this.items);
        parcel.writeInt(this.data.size());
        for (Map.Entry next : this.data.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
        BlockType blockType = this.type;
        int i2 = -1;
        parcel.writeInt(blockType == null ? -1 : blockType.ordinal());
        BlockAlignment blockAlignment = this.align;
        if (blockAlignment != null) {
            i2 = blockAlignment.ordinal();
        }
        parcel.writeInt(i2);
        parcel.writeParcelable(this.author, i);
        parcel.writeParcelable(this.image, i);
        parcel.writeString(this.text);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.linkType);
        parcel.writeString(this.siteName);
        parcel.writeString(this.articleId);
        parcel.writeString(this.language);
        parcel.writeString(this.url);
        parcel.writeString(this.thumbnailUrl);
        parcel.writeString(this.linkUrl);
        parcel.writeString(this.trackingUrl);
        parcel.writeString(this.fallbackUrl);
        parcel.writeString(this.username);
        parcel.writeString(this.provider);
        parcel.writeString(this.previewUrl);
        parcel.writeString(this.attribution);
        parcel.writeString(this.id);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.ratingIndex);
        parcel.writeString(this.remark);
        parcel.writeTypedList(this.options);
        parcel.writeTypedList(this.links);
        parcel.writeParcelable(this.footerLink, i);
        parcel.writeParcelable(this.uri, i);
        parcel.writeString(this.imageUrl);
        parcel.writeInt(this.imageWidth);
        parcel.writeInt(this.imageHeight);
        parcel.writeString(this.ticket_type_title);
        parcel.writeParcelable(this.ticket_type, i);
    }

    protected Block(Parcel parcel) {
        BlockType blockType;
        this.attachments = parcel.createTypedArrayList(BlockAttachment.CREATOR);
        this.items = parcel.createStringArrayList();
        int readInt = parcel.readInt();
        this.data = new HashMap(readInt);
        for (int i = 0; i < readInt; i++) {
            this.data.put(parcel.readString(), parcel.readString());
        }
        int readInt2 = parcel.readInt();
        BlockAlignment blockAlignment = null;
        if (readInt2 == -1) {
            blockType = null;
        } else {
            blockType = BlockType.values()[readInt2];
        }
        this.type = blockType;
        int readInt3 = parcel.readInt();
        this.align = readInt3 != -1 ? BlockAlignment.values()[readInt3] : blockAlignment;
        this.author = (Author) parcel.readParcelable(Author.class.getClassLoader());
        this.image = (Image) parcel.readParcelable(Image.class.getClassLoader());
        this.text = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.linkType = parcel.readString();
        this.siteName = parcel.readString();
        this.articleId = parcel.readString();
        this.language = parcel.readString();
        this.url = parcel.readString();
        this.thumbnailUrl = parcel.readString();
        this.linkUrl = parcel.readString();
        this.trackingUrl = parcel.readString();
        this.fallbackUrl = parcel.readString();
        this.username = parcel.readString();
        this.provider = parcel.readString();
        this.previewUrl = parcel.readString();
        this.attribution = parcel.readString();
        this.id = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.ratingIndex = parcel.readInt();
        this.remark = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.options = arrayList;
        parcel.readList(arrayList, ConversationRatingOption.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.links = arrayList2;
        parcel.readList(arrayList2, Link.class.getClassLoader());
        this.footerLink = (Link) parcel.readParcelable(Link.class.getClassLoader());
        this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.imageUrl = parcel.readString();
        this.imageWidth = parcel.readInt();
        this.imageHeight = parcel.readInt();
        this.ticket_type_title = parcel.readString();
        this.ticket_type = (TicketType) parcel.readParcelable(TicketType.class.getClassLoader());
    }
}
