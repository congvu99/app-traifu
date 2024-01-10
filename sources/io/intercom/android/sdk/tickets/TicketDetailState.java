package io.intercom.android.sdk.tickets;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/tickets/TicketDetailState;", "", "()V", "Initial", "TicketDetailContentState", "Lio/intercom/android/sdk/tickets/TicketDetailState$Initial;", "Lio/intercom/android/sdk/tickets/TicketDetailState$TicketDetailContentState;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketDetailState.kt */
public abstract class TicketDetailState {
    public /* synthetic */ TicketDetailState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/tickets/TicketDetailState$Initial;", "Lio/intercom/android/sdk/tickets/TicketDetailState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TicketDetailState.kt */
    public static final class Initial extends TicketDetailState {
        public static final int $stable = 0;
        public static final Initial INSTANCE = new Initial();

        private Initial() {
            super((DefaultConstructorMarker) null);
        }
    }

    private TicketDetailState() {
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lio/intercom/android/sdk/tickets/TicketDetailState$TicketDetailContentState;", "Lio/intercom/android/sdk/tickets/TicketDetailState;", "ticketName", "", "ticketTimelineCardState", "Lio/intercom/android/sdk/tickets/TicketTimelineCardState;", "ticketAttributes", "", "Lio/intercom/android/sdk/tickets/TicketAttribute;", "userEmail", "(Ljava/lang/String;Lio/intercom/android/sdk/tickets/TicketTimelineCardState;Ljava/util/List;Ljava/lang/String;)V", "getTicketAttributes", "()Ljava/util/List;", "getTicketName", "()Ljava/lang/String;", "getTicketTimelineCardState", "()Lio/intercom/android/sdk/tickets/TicketTimelineCardState;", "getUserEmail", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TicketDetailState.kt */
    public static final class TicketDetailContentState extends TicketDetailState {
        public static final int $stable = 8;
        private final List<TicketAttribute> ticketAttributes;
        private final String ticketName;
        private final TicketTimelineCardState ticketTimelineCardState;
        private final String userEmail;

        public static /* synthetic */ TicketDetailContentState copy$default(TicketDetailContentState ticketDetailContentState, String str, TicketTimelineCardState ticketTimelineCardState2, List<TicketAttribute> list, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ticketDetailContentState.ticketName;
            }
            if ((i & 2) != 0) {
                ticketTimelineCardState2 = ticketDetailContentState.ticketTimelineCardState;
            }
            if ((i & 4) != 0) {
                list = ticketDetailContentState.ticketAttributes;
            }
            if ((i & 8) != 0) {
                str2 = ticketDetailContentState.userEmail;
            }
            return ticketDetailContentState.copy(str, ticketTimelineCardState2, list, str2);
        }

        public final String component1() {
            return this.ticketName;
        }

        public final TicketTimelineCardState component2() {
            return this.ticketTimelineCardState;
        }

        public final List<TicketAttribute> component3() {
            return this.ticketAttributes;
        }

        public final String component4() {
            return this.userEmail;
        }

        public final TicketDetailContentState copy(String str, TicketTimelineCardState ticketTimelineCardState2, List<TicketAttribute> list, String str2) {
            Intrinsics.checkNotNullParameter(str, "ticketName");
            Intrinsics.checkNotNullParameter(ticketTimelineCardState2, "ticketTimelineCardState");
            Intrinsics.checkNotNullParameter(list, "ticketAttributes");
            Intrinsics.checkNotNullParameter(str2, "userEmail");
            return new TicketDetailContentState(str, ticketTimelineCardState2, list, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TicketDetailContentState)) {
                return false;
            }
            TicketDetailContentState ticketDetailContentState = (TicketDetailContentState) obj;
            return Intrinsics.areEqual((Object) this.ticketName, (Object) ticketDetailContentState.ticketName) && Intrinsics.areEqual((Object) this.ticketTimelineCardState, (Object) ticketDetailContentState.ticketTimelineCardState) && Intrinsics.areEqual((Object) this.ticketAttributes, (Object) ticketDetailContentState.ticketAttributes) && Intrinsics.areEqual((Object) this.userEmail, (Object) ticketDetailContentState.userEmail);
        }

        public int hashCode() {
            return (((((this.ticketName.hashCode() * 31) + this.ticketTimelineCardState.hashCode()) * 31) + this.ticketAttributes.hashCode()) * 31) + this.userEmail.hashCode();
        }

        public String toString() {
            return "TicketDetailContentState(ticketName=" + this.ticketName + ", ticketTimelineCardState=" + this.ticketTimelineCardState + ", ticketAttributes=" + this.ticketAttributes + ", userEmail=" + this.userEmail + ')';
        }

        public final String getTicketName() {
            return this.ticketName;
        }

        public final TicketTimelineCardState getTicketTimelineCardState() {
            return this.ticketTimelineCardState;
        }

        public final List<TicketAttribute> getTicketAttributes() {
            return this.ticketAttributes;
        }

        public final String getUserEmail() {
            return this.userEmail;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TicketDetailContentState(String str, TicketTimelineCardState ticketTimelineCardState2, List<TicketAttribute> list, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "ticketName");
            Intrinsics.checkNotNullParameter(ticketTimelineCardState2, "ticketTimelineCardState");
            Intrinsics.checkNotNullParameter(list, "ticketAttributes");
            Intrinsics.checkNotNullParameter(str2, "userEmail");
            this.ticketName = str;
            this.ticketTimelineCardState = ticketTimelineCardState2;
            this.ticketAttributes = list;
            this.userEmail = str2;
        }
    }
}
