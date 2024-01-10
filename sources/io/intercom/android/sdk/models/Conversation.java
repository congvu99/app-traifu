package io.intercom.android.sdk.models;

import io.intercom.android.sdk.models.ComposerState;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.OperatorClientCondition;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.annotation.Nullable;

public class Conversation {
    public static final int RECENCY_THRESHOLD_FOR_HOMESCREEN_CONVERSATION = 864000000;
    private final ComposerState composerState;
    private final List<Part> conversationParts;
    private final List<Participant> groupConversationParticipants;
    private final String id;
    private final boolean inboundConversationsDisabled;
    private final String intercomLinkSolution;
    private final boolean isInbound;
    private final LastParticipatingAdmin lastParticipatingAdmin;
    private final String notificationStatus;
    private final List<OperatorClientCondition> operatorClientConditions;
    private final Map<String, Participant> participants;
    private final boolean preventEndUserReplies;
    private final boolean read;
    private final String state;
    private final Ticket ticket;

    public Conversation() {
        this(new Builder());
    }

    Conversation(Builder builder) {
        LastParticipatingAdmin lastParticipatingAdmin2;
        ComposerState composerState2;
        this.id = NullSafety.valueOrEmpty(builder.id);
        this.read = builder.read;
        this.participants = new LinkedHashMap();
        this.intercomLinkSolution = NullSafety.valueOrEmpty(builder.intercom_link_solution);
        if (builder.participants != null) {
            for (Participant.Builder build : builder.participants) {
                Participant build2 = build.build();
                this.participants.put(build2.getId(), build2);
            }
        }
        this.conversationParts = new ArrayList();
        if (builder.conversation_parts != null) {
            for (Part.Builder build3 : builder.conversation_parts) {
                Part build4 = build3.build();
                build4.setParticipant(getParticipant(build4.getParticipantId()));
                this.conversationParts.add(build4);
            }
        }
        this.groupConversationParticipants = new ArrayList();
        if (builder.group_conversation_participant_ids != null) {
            for (String next : builder.group_conversation_participant_ids) {
                if (next != null) {
                    this.groupConversationParticipants.add(getParticipant(next));
                }
            }
        }
        this.operatorClientConditions = new ArrayList();
        if (builder.operator_client_conditions != null) {
            for (OperatorClientCondition.Builder next2 : builder.operator_client_conditions) {
                if (next2 != null) {
                    this.operatorClientConditions.add(next2.build());
                }
            }
        }
        if (builder.last_participating_admin != null) {
            lastParticipatingAdmin2 = builder.last_participating_admin.build();
        } else {
            lastParticipatingAdmin2 = LastParticipatingAdmin.NULL;
        }
        this.lastParticipatingAdmin = lastParticipatingAdmin2;
        if (builder.composer_state != null) {
            composerState2 = builder.composer_state.build();
        } else {
            composerState2 = ComposerState.NULL;
        }
        this.composerState = composerState2;
        this.preventEndUserReplies = builder.prevent_end_user_replies;
        this.inboundConversationsDisabled = NullSafety.valueOrDefault(Boolean.valueOf(builder.inbound_conversations_disabled), false);
        this.notificationStatus = NullSafety.valueOrEmpty(builder.notification_status);
        this.state = NullSafety.valueOrEmpty(builder.state);
        this.isInbound = NullSafety.valueOrDefault(Boolean.valueOf(builder.is_inbound), false);
        if (builder.ticket == null) {
            this.ticket = Ticket.Companion.getNULL();
        } else {
            this.ticket = builder.ticket;
        }
    }

    private Conversation(Map<String, Participant> map, List<Part> list, List<Participant> list2, List<OperatorClientCondition> list3, LastParticipatingAdmin lastParticipatingAdmin2, ComposerState composerState2, String str, boolean z, String str2, boolean z2, boolean z3, String str3, String str4, boolean z4, Ticket ticket2) {
        this.participants = map;
        this.conversationParts = list;
        this.groupConversationParticipants = list2;
        this.operatorClientConditions = list3;
        this.lastParticipatingAdmin = lastParticipatingAdmin2;
        this.composerState = composerState2;
        this.id = str;
        this.read = z;
        this.intercomLinkSolution = str2;
        this.preventEndUserReplies = z2;
        this.inboundConversationsDisabled = z3;
        this.notificationStatus = str3;
        this.state = str4;
        this.isInbound = z4;
        this.ticket = ticket2;
    }

    public List<Part> getParts() {
        return this.conversationParts;
    }

    public Part getLastPart() {
        if (this.conversationParts.isEmpty()) {
            return Part.NULL;
        }
        List<Part> list = this.conversationParts;
        return list.get(list.size() - 1);
    }

    public Part getLastNonEventPart() {
        for (int size = this.conversationParts.size() - 1; size >= 0; size--) {
            Part part = this.conversationParts.get(size);
            if (!part.isEvent().booleanValue()) {
                return part;
            }
        }
        return Part.NULL;
    }

    public Part getLastAdminPart() {
        for (int size = this.conversationParts.size() - 1; size >= 0; size--) {
            Part part = this.conversationParts.get(size);
            if (part.isAdmin()) {
                return part;
            }
        }
        return Part.NULL;
    }

    public Participant getParticipant(String str) {
        Participant participant = this.participants.get(str);
        return participant == null ? Participant.NULL : participant;
    }

    public List<Participant> getGroupConversationParticipants() {
        return this.groupConversationParticipants;
    }

    public Ticket getTicket() {
        return this.ticket;
    }

    public String getId() {
        return this.id;
    }

    public boolean isRead() {
        return this.read;
    }

    public String getIntercomLinkSolution() {
        return this.intercomLinkSolution;
    }

    public List<OperatorClientCondition> getOperatorClientConditions() {
        return this.operatorClientConditions;
    }

    public Participant getLastAdmin() {
        ListIterator listIterator = new ArrayList(this.participants.values()).listIterator(this.participants.values().size());
        while (listIterator.hasPrevious()) {
            Participant participant = (Participant) listIterator.previous();
            if (participant.isAdmin()) {
                return participant;
            }
        }
        return Participant.NULL;
    }

    public Map<String, Participant> getParticipants() {
        return this.participants;
    }

    public LastParticipatingAdmin getLastParticipatingAdmin() {
        return this.lastParticipatingAdmin;
    }

    public ComposerState getComposerState() {
        return this.composerState;
    }

    public boolean shouldPreventEndUserReplies() {
        return this.preventEndUserReplies;
    }

    public boolean getInboundConversationsDisabled() {
        return this.inboundConversationsDisabled;
    }

    public String getNotificationStatus() {
        return this.notificationStatus;
    }

    public String getState() {
        return this.state;
    }

    public boolean isInbound() {
        return this.isInbound;
    }

    public boolean isAdminReply() {
        return this.participants.size() > 1;
    }

    public boolean isRecentInboundConversation(long j) {
        return this.isInbound && ConversationState.OPEN.equals(this.state) && createdSince(j - 864000000);
    }

    public boolean createdSince(long j) {
        return getLastPart().getCreatedAt() * 1000 > j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Conversation conversation = (Conversation) obj;
        if (this.read == conversation.read && this.participants.equals(conversation.participants) && this.conversationParts.equals(conversation.conversationParts) && this.groupConversationParticipants.equals(conversation.groupConversationParticipants) && this.operatorClientConditions.equals(conversation.operatorClientConditions) && this.lastParticipatingAdmin.equals(conversation.lastParticipatingAdmin) && this.composerState.equals(conversation.composerState) && this.intercomLinkSolution.equals(conversation.intercomLinkSolution) && this.preventEndUserReplies == conversation.preventEndUserReplies && this.inboundConversationsDisabled == conversation.inboundConversationsDisabled && this.notificationStatus.equals(conversation.notificationStatus) && this.state.equals(conversation.state) && this.isInbound == conversation.isInbound && this.ticket.equals(conversation.ticket)) {
            return this.id.equals(conversation.id);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.participants.hashCode() * 31) + this.conversationParts.hashCode()) * 31) + this.groupConversationParticipants.hashCode()) * 31) + this.operatorClientConditions.hashCode()) * 31) + this.lastParticipatingAdmin.hashCode()) * 31) + this.composerState.hashCode()) * 31) + this.id.hashCode()) * 31) + (this.read ? 1 : 0)) * 31) + (this.preventEndUserReplies ? 1 : 0)) * 31) + (this.inboundConversationsDisabled ? 1 : 0)) * 31) + this.intercomLinkSolution.hashCode()) * 31) + this.notificationStatus.hashCode()) * 31) + this.state.hashCode()) * 31) + (this.isInbound ? 1 : 0)) * 31) + this.ticket.hashCode();
    }

    public static final class Builder {
        ComposerState.Builder composer_state;
        List<Part.Builder> conversation_parts;
        List<String> group_conversation_participant_ids;
        String id;
        boolean inbound_conversations_disabled;
        String intercom_link_solution;
        boolean is_inbound;
        LastParticipatingAdmin.Builder last_participating_admin;
        String notification_status;
        List<OperatorClientCondition.Builder> operator_client_conditions;
        List<Participant.Builder> participants;
        boolean prevent_end_user_replies;
        boolean read;
        String state;
        @Nullable
        Ticket ticket;
        boolean user_participated;

        public Builder withId(String str) {
            this.id = str;
            return this;
        }

        public Builder withLastParticipatingAdmin(LastParticipatingAdmin.Builder builder) {
            this.last_participating_admin = builder;
            return this;
        }

        public Builder withParticipants(List<Participant.Builder> list) {
            this.participants = list;
            return this;
        }

        public Builder withParts(List<Part.Builder> list) {
            this.conversation_parts = list;
            return this;
        }

        public Builder withPreventUserReplies(boolean z) {
            this.prevent_end_user_replies = z;
            return this;
        }

        public Builder withInboundConversationsDisabled(boolean z) {
            this.inbound_conversations_disabled = z;
            return this;
        }

        public Builder withIsInbound(boolean z) {
            this.is_inbound = z;
            return this;
        }

        public Builder withState(String str) {
            this.state = str;
            return this;
        }

        public Builder withTicket(Ticket ticket2) {
            this.ticket = ticket2;
            return this;
        }

        public Builder withRead(Boolean bool) {
            this.read = bool.booleanValue();
            return this;
        }

        public Builder withConversationParts(List<Part.Builder> list) {
            this.conversation_parts = list;
            return this;
        }

        public Builder withGroupConversationParticipantIds(List<String> list) {
            this.group_conversation_participant_ids = list;
            return this;
        }

        public Builder withOperatorClientConditions(List<OperatorClientCondition.Builder> list) {
            this.operator_client_conditions = list;
            return this;
        }

        public Builder withComposerState(ComposerState.Builder builder) {
            this.composer_state = builder;
            return this;
        }

        public Builder withUserParticipated(boolean z) {
            this.user_participated = z;
            return this;
        }

        public Builder withIntercomLinkSolution(String str) {
            this.intercom_link_solution = str;
            return this;
        }

        public Builder withNotificationStatus(String str) {
            this.notification_status = str;
            return this;
        }

        public Conversation build() {
            return new Conversation(this);
        }
    }

    public Conversation withRead(boolean z) {
        return new Conversation(this.participants, this.conversationParts, this.groupConversationParticipants, this.operatorClientConditions, this.lastParticipatingAdmin, this.composerState, this.id, z, this.intercomLinkSolution, this.preventEndUserReplies, this.inboundConversationsDisabled, this.notificationStatus, this.state, this.isInbound, this.ticket);
    }
}
