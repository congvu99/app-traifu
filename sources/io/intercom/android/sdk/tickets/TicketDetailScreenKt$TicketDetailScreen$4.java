package io.intercom.android.sdk.tickets;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.tickets.TicketDetailState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketDetailScreen.kt */
final class TicketDetailScreenKt$TicketDetailScreen$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function0<Unit> $onBackClicked;
    final /* synthetic */ boolean $showSubmissionCard;
    final /* synthetic */ TicketDetailState.TicketDetailContentState $ticketDetailContentState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TicketDetailScreenKt$TicketDetailScreen$4(TicketDetailState.TicketDetailContentState ticketDetailContentState, Function0<Unit> function0, boolean z, int i, int i2) {
        super(2);
        this.$ticketDetailContentState = ticketDetailContentState;
        this.$onBackClicked = function0;
        this.$showSubmissionCard = z;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TicketDetailScreenKt.TicketDetailScreen(this.$ticketDetailContentState, this.$onBackClicked, this.$showSubmissionCard, composer, this.$$changed | 1, this.$$default);
    }
}
