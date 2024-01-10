package io.intercom.android.sdk.state;

import io.intercom.android.sdk.models.Ticket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/state/TicketLegacyState;", "", "ticket", "Lio/intercom/android/sdk/models/Ticket;", "(Lio/intercom/android/sdk/models/Ticket;)V", "getTicket", "()Lio/intercom/android/sdk/models/Ticket;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketLegacyState.kt */
public final class TicketLegacyState {
    private final Ticket ticket;

    public TicketLegacyState() {
        this((Ticket) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TicketLegacyState copy$default(TicketLegacyState ticketLegacyState, Ticket ticket2, int i, Object obj) {
        if ((i & 1) != 0) {
            ticket2 = ticketLegacyState.ticket;
        }
        return ticketLegacyState.copy(ticket2);
    }

    public final Ticket component1() {
        return this.ticket;
    }

    public final TicketLegacyState copy(Ticket ticket2) {
        Intrinsics.checkNotNullParameter(ticket2, "ticket");
        return new TicketLegacyState(ticket2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TicketLegacyState) && Intrinsics.areEqual((Object) this.ticket, (Object) ((TicketLegacyState) obj).ticket);
    }

    public int hashCode() {
        return this.ticket.hashCode();
    }

    public String toString() {
        return "TicketLegacyState(ticket=" + this.ticket + ')';
    }

    public TicketLegacyState(Ticket ticket2) {
        Intrinsics.checkNotNullParameter(ticket2, "ticket");
        this.ticket = ticket2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TicketLegacyState(Ticket ticket2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Ticket.Companion.getNULL() : ticket2);
    }

    public final Ticket getTicket() {
        return this.ticket;
    }
}
