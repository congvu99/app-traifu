package io.intercom.android.sdk.models;

import com.intercom.commons.utilities.CollectionUtils;
import io.intercom.android.sdk.models.Conversation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class ConversationList {
    public abstract List<Conversation> getConversations();

    public abstract EmptyState getEmptyState();

    public abstract Set<String> getUnreadConversationIds();

    public abstract boolean hasMorePages();

    public static ConversationList create(List<Conversation> list, Set<String> set, EmptyState emptyState, boolean z) {
        return new AutoValue_ConversationList(list, set, emptyState, z);
    }

    public static final class Builder {
        List<Conversation.Builder> conversations;
        EmptyState empty_state;
        boolean more_pages_available;
        List<String> unread_conversation_ids;

        public ConversationList build() {
            ArrayList arrayList = new ArrayList(CollectionUtils.capacityFor(this.conversations));
            List<Conversation.Builder> list = this.conversations;
            if (list != null) {
                for (Conversation.Builder next : list) {
                    if (next != null) {
                        arrayList.add(next.build());
                    }
                }
            }
            HashSet hashSet = new HashSet(CollectionUtils.capacityFor(this.unread_conversation_ids));
            List<String> list2 = this.unread_conversation_ids;
            if (list2 != null) {
                for (String next2 : list2) {
                    if (next2 != null) {
                        hashSet.add(next2);
                    }
                }
            }
            EmptyState emptyState = this.empty_state;
            if (emptyState == null) {
                emptyState = EmptyState.Companion.getNULL();
            }
            return ConversationList.create(arrayList, hashSet, emptyState, this.more_pages_available);
        }

        public Builder withConversations(List<Conversation.Builder> list) {
            this.conversations = list;
            return this;
        }

        public Builder withMorePagesAvailable(boolean z) {
            this.more_pages_available = z;
            return this;
        }

        public Builder withEmptyState(EmptyState emptyState) {
            this.empty_state = emptyState;
            return this;
        }
    }
}
