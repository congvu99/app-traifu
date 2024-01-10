package io.intercom.android.sdk.models;

import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.models.ComposerState;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.OperatorClientCondition;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Participant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/models/ConversationResponse;", "Lio/intercom/android/sdk/models/BaseResponse;", "builder", "Lio/intercom/android/sdk/models/ConversationResponse$Builder;", "(Lio/intercom/android/sdk/models/ConversationResponse$Builder;)V", "getBuilder", "()Lio/intercom/android/sdk/models/ConversationResponse$Builder;", "conversation", "Lio/intercom/android/sdk/models/Conversation;", "getConversation", "()Lio/intercom/android/sdk/models/Conversation;", "Builder", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConversationResponse.kt */
public final class ConversationResponse extends BaseResponse {
    private final Builder builder;
    private final Conversation conversation;

    public final Builder getBuilder() {
        return this.builder;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConversationResponse(Builder builder2) {
        super(builder2);
        Intrinsics.checkNotNullParameter(builder2, "builder");
        this.builder = builder2;
        Conversation build = new Conversation.Builder().withId(this.builder.getId()).withRead(Boolean.valueOf(this.builder.getRead())).withParticipants(this.builder.getParticipants()).withConversationParts(this.builder.getConversation_parts()).withGroupConversationParticipantIds(this.builder.getGroup_conversation_participant_ids()).withOperatorClientConditions(this.builder.getOperator_client_conditions()).withLastParticipatingAdmin(this.builder.getLast_participating_admin()).withComposerState(this.builder.getComposer_state()).withUserParticipated(this.builder.getUser_participated()).withIntercomLinkSolution(this.builder.getIntercom_link_solution()).withPreventUserReplies(this.builder.getPrevent_end_user_replies()).withInboundConversationsDisabled(this.builder.getInbound_conversations_disabled()).withNotificationStatus(this.builder.getNotification_status()).withState(this.builder.getState()).withIsInbound(this.builder.is_inbound()).withTicket(this.builder.getTicket()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .withI….ticket)\n        .build()");
        this.conversation = build;
    }

    public final Conversation getConversation() {
        return this.conversation;
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010G\u001a\u00020HH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001a\u0010\"\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\u001eR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\"\u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR\u001a\u00105\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR\u001a\u00108\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001eR\u001c\u0010;\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001c\"\u0004\bF\u0010\u001e¨\u0006I"}, d2 = {"Lio/intercom/android/sdk/models/ConversationResponse$Builder;", "Lio/intercom/android/sdk/models/BaseResponse$Builder;", "()V", "composer_state", "Lio/intercom/android/sdk/models/ComposerState$Builder;", "getComposer_state", "()Lio/intercom/android/sdk/models/ComposerState$Builder;", "setComposer_state", "(Lio/intercom/android/sdk/models/ComposerState$Builder;)V", "conversation_parts", "", "Lio/intercom/android/sdk/models/Part$Builder;", "getConversation_parts", "()Ljava/util/List;", "setConversation_parts", "(Ljava/util/List;)V", "group_conversation_participant_ids", "", "getGroup_conversation_participant_ids", "setGroup_conversation_participant_ids", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "inbound_conversations_disabled", "", "getInbound_conversations_disabled", "()Z", "setInbound_conversations_disabled", "(Z)V", "intercom_link_solution", "getIntercom_link_solution", "setIntercom_link_solution", "is_inbound", "set_inbound", "last_participating_admin", "Lio/intercom/android/sdk/models/LastParticipatingAdmin$Builder;", "getLast_participating_admin", "()Lio/intercom/android/sdk/models/LastParticipatingAdmin$Builder;", "setLast_participating_admin", "(Lio/intercom/android/sdk/models/LastParticipatingAdmin$Builder;)V", "notification_status", "getNotification_status", "setNotification_status", "operator_client_conditions", "Lio/intercom/android/sdk/models/OperatorClientCondition$Builder;", "getOperator_client_conditions", "setOperator_client_conditions", "participants", "Lio/intercom/android/sdk/models/Participant$Builder;", "getParticipants", "setParticipants", "prevent_end_user_replies", "getPrevent_end_user_replies", "setPrevent_end_user_replies", "read", "getRead", "setRead", "state", "getState", "setState", "ticket", "Lio/intercom/android/sdk/models/Ticket;", "getTicket", "()Lio/intercom/android/sdk/models/Ticket;", "setTicket", "(Lio/intercom/android/sdk/models/Ticket;)V", "user_participated", "getUser_participated", "setUser_participated", "build", "Lio/intercom/android/sdk/models/ConversationResponse;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ConversationResponse.kt */
    public static final class Builder extends BaseResponse.Builder {
        public static final int $stable = 8;
        private ComposerState.Builder composer_state;
        private List<Part.Builder> conversation_parts;
        private List<String> group_conversation_participant_ids;
        private String id;
        private boolean inbound_conversations_disabled;
        private String intercom_link_solution;
        private boolean is_inbound;
        private LastParticipatingAdmin.Builder last_participating_admin;
        private String notification_status;
        private List<OperatorClientCondition.Builder> operator_client_conditions;
        private List<Participant.Builder> participants;
        private boolean prevent_end_user_replies;
        private boolean read;
        private String state;
        private Ticket ticket;
        private boolean user_participated;

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final boolean getRead() {
            return this.read;
        }

        public final void setRead(boolean z) {
            this.read = z;
        }

        public final List<Participant.Builder> getParticipants() {
            return this.participants;
        }

        public final void setParticipants(List<Participant.Builder> list) {
            this.participants = list;
        }

        public final List<Part.Builder> getConversation_parts() {
            return this.conversation_parts;
        }

        public final void setConversation_parts(List<Part.Builder> list) {
            this.conversation_parts = list;
        }

        public final List<String> getGroup_conversation_participant_ids() {
            return this.group_conversation_participant_ids;
        }

        public final void setGroup_conversation_participant_ids(List<String> list) {
            this.group_conversation_participant_ids = list;
        }

        public final List<OperatorClientCondition.Builder> getOperator_client_conditions() {
            return this.operator_client_conditions;
        }

        public final void setOperator_client_conditions(List<OperatorClientCondition.Builder> list) {
            this.operator_client_conditions = list;
        }

        public final LastParticipatingAdmin.Builder getLast_participating_admin() {
            return this.last_participating_admin;
        }

        public final void setLast_participating_admin(LastParticipatingAdmin.Builder builder) {
            this.last_participating_admin = builder;
        }

        public final ComposerState.Builder getComposer_state() {
            return this.composer_state;
        }

        public final void setComposer_state(ComposerState.Builder builder) {
            this.composer_state = builder;
        }

        public final boolean getUser_participated() {
            return this.user_participated;
        }

        public final void setUser_participated(boolean z) {
            this.user_participated = z;
        }

        public final String getIntercom_link_solution() {
            return this.intercom_link_solution;
        }

        public final void setIntercom_link_solution(String str) {
            this.intercom_link_solution = str;
        }

        public final boolean getPrevent_end_user_replies() {
            return this.prevent_end_user_replies;
        }

        public final void setPrevent_end_user_replies(boolean z) {
            this.prevent_end_user_replies = z;
        }

        public final boolean getInbound_conversations_disabled() {
            return this.inbound_conversations_disabled;
        }

        public final void setInbound_conversations_disabled(boolean z) {
            this.inbound_conversations_disabled = z;
        }

        public final String getNotification_status() {
            return this.notification_status;
        }

        public final void setNotification_status(String str) {
            this.notification_status = str;
        }

        public final String getState() {
            return this.state;
        }

        public final void setState(String str) {
            this.state = str;
        }

        public final boolean is_inbound() {
            return this.is_inbound;
        }

        public final void set_inbound(boolean z) {
            this.is_inbound = z;
        }

        public final Ticket getTicket() {
            return this.ticket;
        }

        public final void setTicket(Ticket ticket2) {
            this.ticket = ticket2;
        }

        public ConversationResponse build() {
            return new ConversationResponse(this);
        }
    }
}
