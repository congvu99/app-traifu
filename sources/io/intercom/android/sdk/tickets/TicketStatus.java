package io.intercom.android.sdk.tickets;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0012\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/tickets/TicketStatus;", "", "color", "Landroidx/compose/ui/graphics/Color;", "(Ljava/lang/String;IJ)V", "getColor-0d7_KjU", "()J", "J", "Submitted", "InProgress", "WaitingOnCustomer", "Resolved", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketDetailReducer.kt */
public enum TicketStatus {
    Submitted(ColorKt.Color(4278212607L)),
    InProgress(ColorKt.Color(4278212607L)),
    WaitingOnCustomer(ColorKt.Color(4291644690L)),
    Resolved(ColorKt.Color(4279072050L));
    
    private final long color;

    private TicketStatus(long j) {
        this.color = j;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m5382getColor0d7_KjU() {
        return this.color;
    }
}
