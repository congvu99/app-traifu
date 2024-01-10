package io.intercom.android.sdk.tickets;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0010\u001a\u00020\u0006HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000bJ4\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Lio/intercom/android/sdk/tickets/StatusChip;", "", "title", "", "status", "tint", "Landroidx/compose/ui/graphics/Color;", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStatus", "()Ljava/lang/String;", "getTint-0d7_KjU", "()J", "J", "getTitle", "component1", "component2", "component3", "component3-0d7_KjU", "copy", "copy-mxwnekA", "(Ljava/lang/String;Ljava/lang/String;J)Lio/intercom/android/sdk/tickets/StatusChip;", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketStatusChip.kt */
public final class StatusChip {
    private final String status;
    private final long tint;
    private final String title;

    public /* synthetic */ StatusChip(String str, String str2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j);
    }

    /* renamed from: copy-mxwnekA$default  reason: not valid java name */
    public static /* synthetic */ StatusChip m5369copymxwnekA$default(StatusChip statusChip, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = statusChip.title;
        }
        if ((i & 2) != 0) {
            str2 = statusChip.status;
        }
        if ((i & 4) != 0) {
            j = statusChip.tint;
        }
        return statusChip.m5371copymxwnekA(str, str2, j);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.status;
    }

    /* renamed from: component3-0d7_KjU  reason: not valid java name */
    public final long m5370component30d7_KjU() {
        return this.tint;
    }

    /* renamed from: copy-mxwnekA  reason: not valid java name */
    public final StatusChip m5371copymxwnekA(String str, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "status");
        return new StatusChip(str, str2, j, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatusChip)) {
            return false;
        }
        StatusChip statusChip = (StatusChip) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) statusChip.title) && Intrinsics.areEqual((Object) this.status, (Object) statusChip.status) && Color.m1933equalsimpl0(this.tint, statusChip.tint);
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.status.hashCode()) * 31) + Color.m1939hashCodeimpl(this.tint);
    }

    public String toString() {
        return "StatusChip(title=" + this.title + ", status=" + this.status + ", tint=" + Color.m1940toStringimpl(this.tint) + ')';
    }

    private StatusChip(String str, String str2, long j) {
        this.title = str;
        this.status = str2;
        this.tint = j;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getStatus() {
        return this.status;
    }

    /* renamed from: getTint-0d7_KjU  reason: not valid java name */
    public final long m5372getTint0d7_KjU() {
        return this.tint;
    }
}
