package io.intercom.android.sdk.inbox;

import io.intercom.android.sdk.models.Conversation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/inbox/InboxScreenEffects;", "", "()V", "NavigateToConversation", "ScrollToTop", "Lio/intercom/android/sdk/inbox/InboxScreenEffects$NavigateToConversation;", "Lio/intercom/android/sdk/inbox/InboxScreenEffects$ScrollToTop;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomInboxViewModel.kt */
public abstract class InboxScreenEffects {
    public /* synthetic */ InboxScreenEffects(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private InboxScreenEffects() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/inbox/InboxScreenEffects$NavigateToConversation;", "Lio/intercom/android/sdk/inbox/InboxScreenEffects;", "conversation", "Lio/intercom/android/sdk/models/Conversation;", "(Lio/intercom/android/sdk/models/Conversation;)V", "getConversation", "()Lio/intercom/android/sdk/models/Conversation;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomInboxViewModel.kt */
    public static final class NavigateToConversation extends InboxScreenEffects {
        public static final int $stable = 8;
        private final Conversation conversation;

        public static /* synthetic */ NavigateToConversation copy$default(NavigateToConversation navigateToConversation, Conversation conversation2, int i, Object obj) {
            if ((i & 1) != 0) {
                conversation2 = navigateToConversation.conversation;
            }
            return navigateToConversation.copy(conversation2);
        }

        public final Conversation component1() {
            return this.conversation;
        }

        public final NavigateToConversation copy(Conversation conversation2) {
            Intrinsics.checkNotNullParameter(conversation2, "conversation");
            return new NavigateToConversation(conversation2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NavigateToConversation) && Intrinsics.areEqual((Object) this.conversation, (Object) ((NavigateToConversation) obj).conversation);
        }

        public int hashCode() {
            return this.conversation.hashCode();
        }

        public String toString() {
            return "NavigateToConversation(conversation=" + this.conversation + ')';
        }

        public final Conversation getConversation() {
            return this.conversation;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NavigateToConversation(Conversation conversation2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(conversation2, "conversation");
            this.conversation = conversation2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/inbox/InboxScreenEffects$ScrollToTop;", "Lio/intercom/android/sdk/inbox/InboxScreenEffects;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomInboxViewModel.kt */
    public static final class ScrollToTop extends InboxScreenEffects {
        public static final int $stable = 0;
        public static final ScrollToTop INSTANCE = new ScrollToTop();

        private ScrollToTop() {
            super((DefaultConstructorMarker) null);
        }
    }
}
