package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.intercom.input.gallery.GalleryImage;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.models.Attachments;
import io.intercom.android.sdk.models.ComposerSuggestions;
import io.intercom.android.sdk.models.EventData;
import io.intercom.android.sdk.models.Form;
import io.intercom.android.sdk.models.ReactionReply;
import io.intercom.android.sdk.models.ReplyOption;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Part implements Parcelable {
    public static final String ADMIN_IS_TYPING_STYLE = "admin_is_typing_style";
    public static final String ATTRIBUTE_COLLECTOR_STYLE = "attribute_collector";
    public static final String BIG_TICKET_STYLE = "big_ticket";
    public static final String CHAT_MESSAGE_STYLE = "chat";
    public static final String COMPOSER_SUGGESTIONS_STYLE = "composer_suggestions_style";
    public static final Parcelable.Creator<Part> CREATOR = new Parcelable.Creator<Part>() {
        public Part createFromParcel(Parcel parcel) {
            return new Part(parcel);
        }

        public Part[] newArray(int i) {
            return new Part[i];
        }
    };
    public static final String DAY_DIVIDER_STYLE = "day_divider_style";
    public static final String LEGACY_ANNOUNCEMENT_STYLE = "announcement";
    public static final String LEGACY_SMALL_ANNOUNCEMENT_STYLE = "small-announcement";
    public static final String LOADING_LAYOUT = "loading_layout_style";
    public static final String NOTE_MESSAGE_STYLE = "note";
    public static final Part NULL = new Part(new Builder());
    public static final String POST_MESSAGE_STYLE = "post";
    public static final String QUICK_REPLY_STYLE = "quick_reply";
    public static final String TEAM_PRESENCE_STYLE = "team_presence_style";
    public static final String TEMPORARY_EXPECTATIONS_LAYOUT = "temporary_expectations_style";
    public static final String TICKET_UPDATED_MESSAGE_STYLE = "ticket_state_updated";
    private final List<Attachments> attachments;
    private final List<Block> blocks;
    private String clientAssignedUuid;
    private ComposerSuggestions composerSuggestions;
    private final long createdAt;
    private final DeliveryOption deliveryOption;
    private boolean displayDelivered;
    private boolean entranceAnimation;
    private final EventData eventData;
    private final Form form;
    private final String id;
    private final boolean isInitialMessage;
    private MessageState messageState;
    private final String messageStyle;
    private Conversation parentConversation;
    private Participant participant;
    private String participantId;
    private final boolean participantIsAdmin;
    private final ReactionReply reactionReply;
    private final List<ReplyOption> replyOptions;
    private String seenByAdmin;
    private final String summary;
    private GalleryImage uploadImage;

    public enum DeliveryOption {
        FULL,
        SUMMARY,
        BADGE
    }

    public enum MessageState {
        SENDING,
        FAILED,
        UPLOAD_FAILED,
        NORMAL
    }

    public int describeContents() {
        return 0;
    }

    public Part() {
        this(new Builder());
    }

    private Part(Builder builder) {
        ReactionReply reactionReply2;
        ComposerSuggestions composerSuggestions2;
        this.id = builder.id == null ? UUID.randomUUID().toString() : builder.id;
        this.participantId = NullSafety.valueOrEmpty(builder.participant_id);
        this.participantIsAdmin = builder.participant_is_admin;
        this.summary = NullSafety.valueOrEmpty(builder.summary);
        this.createdAt = builder.created_at;
        this.messageStyle = convertLegacyMessageStyle(builder.message_style);
        this.deliveryOption = convertDeliveryOption(builder.delivery_option);
        this.blocks = new ArrayList();
        if (builder.body != null) {
            for (Block.Builder build : builder.body) {
                this.blocks.add(build.build());
            }
        }
        if (builder.reactions_reply == null) {
            reactionReply2 = ReactionReply.NULL;
        } else {
            reactionReply2 = builder.reactions_reply.build();
        }
        this.reactionReply = reactionReply2;
        this.seenByAdmin = builder.seen_by_admin == null ? "hide" : builder.seen_by_admin;
        this.attachments = new ArrayList();
        if (builder.attachments != null) {
            for (Attachments.Builder build2 : builder.attachments) {
                this.attachments.add(build2.build());
            }
        }
        this.eventData = builder.event_data == null ? EventData.NULL : builder.event_data.build();
        this.parentConversation = new Conversation();
        this.participant = Participant.NULL;
        this.displayDelivered = false;
        this.entranceAnimation = false;
        this.isInitialMessage = builder.is_initial_message;
        this.messageState = MessageState.NORMAL;
        this.replyOptions = new ArrayList();
        if (builder.reply_options != null) {
            for (ReplyOption.Builder build3 : builder.reply_options) {
                this.replyOptions.add(build3.build());
            }
        }
        this.form = builder.form == null ? Form.NULL : builder.form.build();
        if (builder.composer_suggestions == null) {
            composerSuggestions2 = ComposerSuggestions.NULL;
        } else {
            composerSuggestions2 = builder.composer_suggestions.build();
        }
        this.composerSuggestions = composerSuggestions2;
        this.clientAssignedUuid = NullSafety.valueOrEmpty(builder.client_assigned_uuid);
    }

    private static DeliveryOption convertDeliveryOption(String str) {
        if (str == null) {
            return DeliveryOption.SUMMARY;
        }
        try {
            return DeliveryOption.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException unused) {
            return DeliveryOption.SUMMARY;
        }
    }

    public DeliveryOption getDeliveryOption() {
        return this.deliveryOption;
    }

    public String getId() {
        return this.id;
    }

    public String getParticipantId() {
        return this.participantId;
    }

    public boolean isAdmin() {
        return this.participantIsAdmin;
    }

    public boolean isUser() {
        return !isAdmin();
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    public List<Attachments> getAttachments() {
        return this.attachments;
    }

    public List<ReplyOption> getReplyOptions() {
        return this.replyOptions;
    }

    public Form getForm() {
        return this.form;
    }

    public boolean hasAttachments() {
        return !this.attachments.isEmpty();
    }

    public String getMessageStyle() {
        return this.messageStyle;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getSummary() {
        return this.summary;
    }

    public ReactionReply getReactionReply() {
        return this.reactionReply;
    }

    public String getSeenByAdmin() {
        return this.participantIsAdmin ? "hide" : this.seenByAdmin;
    }

    public void setSeenByAdmin(String str) {
        this.seenByAdmin = str;
    }

    public Participant getParticipant() {
        return this.participant;
    }

    public void setParticipant(Participant participant2) {
        this.participant = participant2;
        this.participantId = participant2.getId();
    }

    public Conversation getParentConversation() {
        return this.parentConversation;
    }

    public void setParentConversation(Conversation conversation) {
        this.parentConversation = conversation;
    }

    public boolean isDisplayDelivered() {
        return this.displayDelivered;
    }

    public void setDisplayDelivered(boolean z) {
        this.displayDelivered = z;
    }

    public boolean hasEntranceAnimation() {
        return this.entranceAnimation;
    }

    public void setEntranceAnimation(boolean z) {
        this.entranceAnimation = z;
    }

    public MessageState getMessageState() {
        return this.messageState;
    }

    public void setMessageState(MessageState messageState2) {
        this.messageState = messageState2;
    }

    public boolean isInitialMessage() {
        return this.isInitialMessage;
    }

    public boolean isReply() {
        return !this.isInitialMessage;
    }

    public void setUpload(GalleryImage galleryImage) {
        this.uploadImage = galleryImage;
    }

    public ComposerSuggestions getComposerSuggestions() {
        return this.composerSuggestions;
    }

    public void setComposerSuggestions(ComposerSuggestions composerSuggestions2) {
        this.composerSuggestions = composerSuggestions2;
    }

    public String getUuid() {
        return this.clientAssignedUuid;
    }

    public GalleryImage getUpload() {
        return this.uploadImage;
    }

    public EventData getEventData() {
        return this.eventData;
    }

    public Boolean isEvent() {
        return Boolean.valueOf(!this.eventData.getEventAsPlainText().isEmpty());
    }

    /* access modifiers changed from: package-private */
    public Boolean isQuickReplyOnly() {
        return Boolean.valueOf(this.replyOptions.size() > 0 && this.blocks.size() == 0);
    }

    static String convertLegacyMessageStyle(String str) {
        if (LEGACY_ANNOUNCEMENT_STYLE.equals(str)) {
            return POST_MESSAGE_STYLE;
        }
        if (LEGACY_SMALL_ANNOUNCEMENT_STYLE.equals(str)) {
            return NOTE_MESSAGE_STYLE;
        }
        if (ADMIN_IS_TYPING_STYLE.equals(str)) {
            return ADMIN_IS_TYPING_STYLE;
        }
        if (DAY_DIVIDER_STYLE.equals(str)) {
            return DAY_DIVIDER_STYLE;
        }
        if (LOADING_LAYOUT.equals(str)) {
            return LOADING_LAYOUT;
        }
        if ("quick_reply".equals(str)) {
            return "quick_reply";
        }
        if (ATTRIBUTE_COLLECTOR_STYLE.equals(str)) {
            return ATTRIBUTE_COLLECTOR_STYLE;
        }
        if (COMPOSER_SUGGESTIONS_STYLE.equals(str)) {
            return COMPOSER_SUGGESTIONS_STYLE;
        }
        if (TEMPORARY_EXPECTATIONS_LAYOUT.equals(str)) {
            return TEMPORARY_EXPECTATIONS_LAYOUT;
        }
        if (TICKET_UPDATED_MESSAGE_STYLE.equals(str)) {
            return TICKET_UPDATED_MESSAGE_STYLE;
        }
        if (BIG_TICKET_STYLE.equals(str)) {
            return BIG_TICKET_STYLE;
        }
        if (TEAM_PRESENCE_STYLE.equals(str)) {
            return TEAM_PRESENCE_STYLE;
        }
        return CHAT_MESSAGE_STYLE;
    }

    public static final class Builder {
        List<Attachments.Builder> attachments;
        List<Block.Builder> body;
        String client_assigned_uuid;
        ComposerSuggestions.Builder composer_suggestions;
        long created_at;
        String delivery_option;
        EventData.Builder event_data;
        Form.Builder form;
        String id;
        boolean is_initial_message;
        String message_style;
        String participant_id;
        boolean participant_is_admin;
        ReactionReply.Builder reactions_reply;
        List<ReplyOption.Builder> reply_options;
        String seen_by_admin;
        String summary;

        public Builder withId(String str) {
            this.id = str;
            return this;
        }

        public Builder withStyle(String str) {
            this.message_style = str;
            return this;
        }

        public Builder withSummary(String str) {
            this.summary = str;
            return this;
        }

        public Builder withCreatedAt(long j) {
            this.created_at = j;
            return this;
        }

        public Builder withParticipantIsAdmin(boolean z) {
            this.participant_is_admin = z;
            return this;
        }

        public Builder withBlocks(List<Block.Builder> list) {
            this.body = list;
            return this;
        }

        public Builder withReplyOptions(List<ReplyOption.Builder> list) {
            this.reply_options = list;
            return this;
        }

        public Builder withForm(Form.Builder builder) {
            this.form = builder;
            return this;
        }

        public Builder withComposerSuggestions(ComposerSuggestions.Builder builder) {
            this.composer_suggestions = builder;
            return this;
        }

        public Builder withClientAssignedUuid(String str) {
            this.client_assigned_uuid = str;
            return this;
        }

        public Part build() {
            return new Part(this);
        }
    }

    private Part(Parcel parcel) {
        this.id = parcel.readString();
        this.participantId = parcel.readString();
        boolean z = true;
        this.participantIsAdmin = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        this.blocks = arrayList;
        parcel.readList(arrayList, Block.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.attachments = arrayList2;
        parcel.readList(arrayList2, Attachments.class.getClassLoader());
        ArrayList arrayList3 = new ArrayList();
        this.replyOptions = arrayList3;
        parcel.readList(arrayList3, ReplyOption.class.getClassLoader());
        this.messageStyle = parcel.readString();
        this.createdAt = parcel.readLong();
        this.summary = parcel.readString();
        if (parcel.readByte() == 0) {
            this.reactionReply = ReactionReply.NULL;
        } else {
            this.reactionReply = (ReactionReply) parcel.readValue(ReactionReply.class.getClassLoader());
        }
        this.seenByAdmin = parcel.readString();
        this.participant = (Participant) parcel.readValue(Participant.class.getClassLoader());
        this.eventData = (EventData) parcel.readValue(EventData.class.getClassLoader());
        this.isInitialMessage = parcel.readByte() == 0 ? false : z;
        this.deliveryOption = convertDeliveryOption(parcel.readString());
        this.form = (Form) parcel.readValue(Form.class.getClassLoader());
        this.composerSuggestions = (ComposerSuggestions) parcel.readValue(ComposerSuggestions.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.participantId);
        parcel.writeByte(this.participantIsAdmin ? (byte) 1 : 0);
        parcel.writeList(this.blocks);
        parcel.writeList(this.attachments);
        parcel.writeList(this.replyOptions);
        parcel.writeString(this.messageStyle);
        parcel.writeLong(this.createdAt);
        parcel.writeString(this.summary);
        if (ReactionReply.isNull(this.reactionReply)) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeValue(this.reactionReply);
        }
        parcel.writeString(this.seenByAdmin);
        parcel.writeValue(this.participant);
        parcel.writeValue(this.eventData);
        parcel.writeByte(this.isInitialMessage ? (byte) 1 : 0);
        parcel.writeString(this.deliveryOption.name());
        parcel.writeValue(this.form);
        parcel.writeValue(this.composerSuggestions);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Part) {
            return this.id.equals(((Part) obj).id);
        }
        return false;
    }

    public static boolean shouldConcatenate(Part part, Part part2) {
        if (DAY_DIVIDER_STYLE.equals(part.getMessageStyle()) || part.isLinkCard() || part.isEvent().booleanValue() || part2.isEvent().booleanValue() || part2.isQuickReplyOnly().booleanValue() || Math.abs(part2.getCreatedAt() - part.getCreatedAt()) >= TimeUnit.MINUTES.toSeconds(3) || !nextPartFromSameParticipant(part, part2) || part2.getCreatedAt() == 0) {
            return false;
        }
        return true;
    }

    private static boolean nextPartFromSameParticipant(Part part, Part part2) {
        return part.getParticipantId().equals(part2.getParticipantId());
    }

    public boolean isMessagePart() {
        return POST_MESSAGE_STYLE.equals(this.messageStyle) || NOTE_MESSAGE_STYLE.equals(this.messageStyle) || CHAT_MESSAGE_STYLE.equals(this.messageStyle);
    }

    public boolean isLinkCard() {
        return isSingleBlockPartOfType(BlockType.LINK) && CHAT_MESSAGE_STYLE.equals(this.messageStyle);
    }

    public boolean isLinkList() {
        return isSingleBlockPartOfType(BlockType.LINKLIST) && CHAT_MESSAGE_STYLE.equals(this.messageStyle);
    }

    public boolean isSingleBlockPartOfType(BlockType blockType) {
        return this.blocks.size() == 1 && this.blocks.get(0).getType() == blockType;
    }

    public Block getLinkBlock() {
        return this.blocks.get(0);
    }

    public boolean isGifOnlyPart() {
        return this.blocks.size() == 1 && !TextUtils.isEmpty(this.blocks.get(0).getAttribution());
    }

    public boolean isSendingPart() {
        return getMessageState().equals(MessageState.SENDING);
    }
}
