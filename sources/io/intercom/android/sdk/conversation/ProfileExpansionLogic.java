package io.intercom.android.sdk.conversation;

import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;

class ProfileExpansionLogic {
    ProfileExpansionLogic() {
    }

    /* access modifiers changed from: package-private */
    public boolean shouldExpandProfile(Conversation conversation) {
        return hasOnlyUserParts(conversation) || hasNoUserReplies(conversation);
    }

    private static boolean hasOnlyUserParts(Conversation conversation) {
        for (Part isAdmin : conversation.getParts()) {
            if (isAdmin.isAdmin()) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasNoUserReplies(Conversation conversation) {
        boolean z = false;
        for (Part next : conversation.getParts()) {
            if (next.isAdmin()) {
                z = true;
            }
            if (z && !next.isAdmin()) {
                return false;
            }
        }
        return true;
    }
}
