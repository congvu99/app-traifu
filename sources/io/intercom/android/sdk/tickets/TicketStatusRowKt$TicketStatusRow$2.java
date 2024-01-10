package io.intercom.android.sdk.tickets;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketStatusRow.kt */
final class TicketStatusRowKt$TicketStatusRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ String $name;
    final /* synthetic */ String $ticketStatus;
    final /* synthetic */ String $time;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TicketStatusRowKt$TicketStatusRow$2(String str, String str2, String str3, int i, int i2) {
        super(2);
        this.$ticketStatus = str;
        this.$time = str2;
        this.$name = str3;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TicketStatusRowKt.TicketStatusRow(this.$ticketStatus, this.$time, this.$name, composer, this.$$changed | 1, this.$$default);
    }
}
