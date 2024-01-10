package io.intercom.android.sdk.tickets;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.tickets.TicketDetailState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BigTicketCard.kt */
final class BigTicketCardKt$BigTicketCard$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ TicketDetailState.TicketDetailContentState $ticketDetailState;
    final /* synthetic */ boolean $visible;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BigTicketCardKt$BigTicketCard$4(TicketDetailState.TicketDetailContentState ticketDetailContentState, Function0<Unit> function0, boolean z, Modifier modifier, int i, int i2) {
        super(2);
        this.$ticketDetailState = ticketDetailContentState;
        this.$onClick = function0;
        this.$visible = z;
        this.$modifier = modifier;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BigTicketCardKt.BigTicketCard(this.$ticketDetailState, this.$onClick, this.$visible, this.$modifier, composer, this.$$changed | 1, this.$$default);
    }
}
