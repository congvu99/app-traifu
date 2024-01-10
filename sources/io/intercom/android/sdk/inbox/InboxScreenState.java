package io.intercom.android.sdk.inbox;

import io.intercom.android.sdk.m5.components.ErrorState;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.EmptyState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lio/intercom/android/sdk/inbox/InboxScreenState;", "", "()V", "Content", "Empty", "Error", "Initial", "Loading", "Lio/intercom/android/sdk/inbox/InboxScreenState$Content;", "Lio/intercom/android/sdk/inbox/InboxScreenState$Empty;", "Lio/intercom/android/sdk/inbox/InboxScreenState$Error;", "Lio/intercom/android/sdk/inbox/InboxScreenState$Initial;", "Lio/intercom/android/sdk/inbox/InboxScreenState$Loading;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomInboxViewModel.kt */
public abstract class InboxScreenState {
    public /* synthetic */ InboxScreenState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/inbox/InboxScreenState$Initial;", "Lio/intercom/android/sdk/inbox/InboxScreenState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomInboxViewModel.kt */
    public static final class Initial extends InboxScreenState {
        public static final int $stable = 0;
        public static final Initial INSTANCE = new Initial();

        private Initial() {
            super((DefaultConstructorMarker) null);
        }
    }

    private InboxScreenState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/inbox/InboxScreenState$Loading;", "Lio/intercom/android/sdk/inbox/InboxScreenState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomInboxViewModel.kt */
    public static final class Loading extends InboxScreenState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lio/intercom/android/sdk/inbox/InboxScreenState$Content;", "Lio/intercom/android/sdk/inbox/InboxScreenState;", "inboxConversations", "", "Lio/intercom/android/sdk/models/Conversation;", "showSendMessageFab", "", "moreConversationsAvailable", "(Ljava/util/List;ZZ)V", "getInboxConversations", "()Ljava/util/List;", "getMoreConversationsAvailable", "()Z", "getShowSendMessageFab", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomInboxViewModel.kt */
    public static final class Content extends InboxScreenState {
        public static final int $stable = 8;
        private final List<Conversation> inboxConversations;
        private final boolean moreConversationsAvailable;
        private final boolean showSendMessageFab;

        public static /* synthetic */ Content copy$default(Content content, List<Conversation> list, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = content.inboxConversations;
            }
            if ((i & 2) != 0) {
                z = content.showSendMessageFab;
            }
            if ((i & 4) != 0) {
                z2 = content.moreConversationsAvailable;
            }
            return content.copy(list, z, z2);
        }

        public final List<Conversation> component1() {
            return this.inboxConversations;
        }

        public final boolean component2() {
            return this.showSendMessageFab;
        }

        public final boolean component3() {
            return this.moreConversationsAvailable;
        }

        public final Content copy(List<? extends Conversation> list, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(list, "inboxConversations");
            return new Content(list, z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            return Intrinsics.areEqual((Object) this.inboxConversations, (Object) content.inboxConversations) && this.showSendMessageFab == content.showSendMessageFab && this.moreConversationsAvailable == content.moreConversationsAvailable;
        }

        public int hashCode() {
            int hashCode = this.inboxConversations.hashCode() * 31;
            boolean z = this.showSendMessageFab;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i = (hashCode + (z ? 1 : 0)) * 31;
            boolean z3 = this.moreConversationsAvailable;
            if (!z3) {
                z2 = z3;
            }
            return i + (z2 ? 1 : 0);
        }

        public String toString() {
            return "Content(inboxConversations=" + this.inboxConversations + ", showSendMessageFab=" + this.showSendMessageFab + ", moreConversationsAvailable=" + this.moreConversationsAvailable + ')';
        }

        public final List<Conversation> getInboxConversations() {
            return this.inboxConversations;
        }

        public final boolean getShowSendMessageFab() {
            return this.showSendMessageFab;
        }

        public final boolean getMoreConversationsAvailable() {
            return this.moreConversationsAvailable;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Content(List<? extends Conversation> list, boolean z, boolean z2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "inboxConversations");
            this.inboxConversations = list;
            this.showSendMessageFab = z;
            this.moreConversationsAvailable = z2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lio/intercom/android/sdk/inbox/InboxScreenState$Empty;", "Lio/intercom/android/sdk/inbox/InboxScreenState;", "emptyState", "Lio/intercom/android/sdk/models/EmptyState;", "showActionButton", "", "(Lio/intercom/android/sdk/models/EmptyState;Z)V", "getEmptyState", "()Lio/intercom/android/sdk/models/EmptyState;", "getShowActionButton", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomInboxViewModel.kt */
    public static final class Empty extends InboxScreenState {
        public static final int $stable = 0;
        private final EmptyState emptyState;
        private final boolean showActionButton;

        public static /* synthetic */ Empty copy$default(Empty empty, EmptyState emptyState2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                emptyState2 = empty.emptyState;
            }
            if ((i & 2) != 0) {
                z = empty.showActionButton;
            }
            return empty.copy(emptyState2, z);
        }

        public final EmptyState component1() {
            return this.emptyState;
        }

        public final boolean component2() {
            return this.showActionButton;
        }

        public final Empty copy(EmptyState emptyState2, boolean z) {
            Intrinsics.checkNotNullParameter(emptyState2, "emptyState");
            return new Empty(emptyState2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Empty)) {
                return false;
            }
            Empty empty = (Empty) obj;
            return Intrinsics.areEqual((Object) this.emptyState, (Object) empty.emptyState) && this.showActionButton == empty.showActionButton;
        }

        public int hashCode() {
            int hashCode = this.emptyState.hashCode() * 31;
            boolean z = this.showActionButton;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "Empty(emptyState=" + this.emptyState + ", showActionButton=" + this.showActionButton + ')';
        }

        public final EmptyState getEmptyState() {
            return this.emptyState;
        }

        public final boolean getShowActionButton() {
            return this.showActionButton;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Empty(EmptyState emptyState2, boolean z) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(emptyState2, "emptyState");
            this.emptyState = emptyState2;
            this.showActionButton = z;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/inbox/InboxScreenState$Error;", "Lio/intercom/android/sdk/inbox/InboxScreenState;", "errorState", "Lio/intercom/android/sdk/m5/components/ErrorState;", "(Lio/intercom/android/sdk/m5/components/ErrorState;)V", "getErrorState", "()Lio/intercom/android/sdk/m5/components/ErrorState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomInboxViewModel.kt */
    public static final class Error extends InboxScreenState {
        public static final int $stable = 0;
        private final ErrorState errorState;

        public static /* synthetic */ Error copy$default(Error error, ErrorState errorState2, int i, Object obj) {
            if ((i & 1) != 0) {
                errorState2 = error.errorState;
            }
            return error.copy(errorState2);
        }

        public final ErrorState component1() {
            return this.errorState;
        }

        public final Error copy(ErrorState errorState2) {
            Intrinsics.checkNotNullParameter(errorState2, "errorState");
            return new Error(errorState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual((Object) this.errorState, (Object) ((Error) obj).errorState);
        }

        public int hashCode() {
            return this.errorState.hashCode();
        }

        public String toString() {
            return "Error(errorState=" + this.errorState + ')';
        }

        public final ErrorState getErrorState() {
            return this.errorState;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(ErrorState errorState2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(errorState2, "errorState");
            this.errorState = errorState2;
        }
    }
}
