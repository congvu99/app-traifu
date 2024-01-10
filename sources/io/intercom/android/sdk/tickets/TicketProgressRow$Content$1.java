package io.intercom.android.sdk.tickets;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketProgressRow.kt */
final class TicketProgressRow$Content$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TicketProgressRow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TicketProgressRow$Content$1(TicketProgressRow ticketProgressRow) {
        super(2);
        this.this$0 = ticketProgressRow;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            TicketProgressRowKt.TicketProgressRow(this.this$0.getName(), this.this$0.getStatus(), this.this$0.getOnClick(), this.this$0.getVisible(), (Modifier) null, composer, 0, 16);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
