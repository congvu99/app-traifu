package io.intercom.android.sdk.views.holder;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.tickets.TicketStatusRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketStatusViewHolder.kt */
final class TicketStatusViewHolder$bind$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Part $part;
    final /* synthetic */ TicketStatusViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TicketStatusViewHolder$bind$1$1(Part part, TicketStatusViewHolder ticketStatusViewHolder) {
        super(2);
        this.$part = part;
        this.this$0 = ticketStatusViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            String eventAsPlainText = this.$part.getEventData().getEventAsPlainText();
            Intrinsics.checkNotNullExpressionValue(eventAsPlainText, "part.eventData.eventAsPlainText");
            TicketStatusRowKt.TicketStatusRow(eventAsPlainText, this.this$0.getTimeFormatter().getFormattedTime(this.$part.getCreatedAt()).toString(), Intrinsics.areEqual((Object) this.$part.getEventData().getStatus(), (Object) MetricTracker.Action.SUBMITTED) ? null : this.$part.getParticipant().getForename(), composer, 0, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
