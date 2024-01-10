package io.intercom.android.sdk.tickets;

import io.intercom.android.sdk.tickets.TicketTimelineCardState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lio/intercom/android/sdk/tickets/TicketAttribute;", "", "title", "", "description", "Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes;", "(Ljava/lang/String;Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes;)V", "getDescription", "()Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketDetailState.kt */
public final class TicketAttribute {
    private final TicketTimelineCardState.ActualStringOrRes description;
    private final String title;

    public static /* synthetic */ TicketAttribute copy$default(TicketAttribute ticketAttribute, String str, TicketTimelineCardState.ActualStringOrRes actualStringOrRes, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ticketAttribute.title;
        }
        if ((i & 2) != 0) {
            actualStringOrRes = ticketAttribute.description;
        }
        return ticketAttribute.copy(str, actualStringOrRes);
    }

    public final String component1() {
        return this.title;
    }

    public final TicketTimelineCardState.ActualStringOrRes component2() {
        return this.description;
    }

    public final TicketAttribute copy(String str, TicketTimelineCardState.ActualStringOrRes actualStringOrRes) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(actualStringOrRes, "description");
        return new TicketAttribute(str, actualStringOrRes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TicketAttribute)) {
            return false;
        }
        TicketAttribute ticketAttribute = (TicketAttribute) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) ticketAttribute.title) && Intrinsics.areEqual((Object) this.description, (Object) ticketAttribute.description);
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.description.hashCode();
    }

    public String toString() {
        return "TicketAttribute(title=" + this.title + ", description=" + this.description + ')';
    }

    public TicketAttribute(String str, TicketTimelineCardState.ActualStringOrRes actualStringOrRes) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(actualStringOrRes, "description");
        this.title = str;
        this.description = actualStringOrRes;
    }

    public final TicketTimelineCardState.ActualStringOrRes getDescription() {
        return this.description;
    }

    public final String getTitle() {
        return this.title;
    }
}
