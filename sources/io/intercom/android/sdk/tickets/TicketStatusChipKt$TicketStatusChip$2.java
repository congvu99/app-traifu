package io.intercom.android.sdk.tickets;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketStatusChip.kt */
final class TicketStatusChipKt$TicketStatusChip$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ StatusChip $statusChip;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TicketStatusChipKt$TicketStatusChip$2(StatusChip statusChip, int i) {
        super(2);
        this.$statusChip = statusChip;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TicketStatusChipKt.TicketStatusChip(this.$statusChip, composer, this.$$changed | 1);
    }
}
