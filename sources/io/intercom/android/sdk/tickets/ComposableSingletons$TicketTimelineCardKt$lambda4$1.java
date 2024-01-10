package io.intercom.android.sdk.tickets;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import io.intercom.android.sdk.tickets.TicketTimelineCardState;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.tickets.ComposableSingletons$TicketTimelineCardKt$lambda-4$1  reason: invalid class name */
/* compiled from: TicketTimelineCard.kt */
final class ComposableSingletons$TicketTimelineCardKt$lambda4$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$TicketTimelineCardKt$lambda4$1 INSTANCE = new ComposableSingletons$TicketTimelineCardKt$lambda4$1();

    ComposableSingletons$TicketTimelineCardKt$lambda4$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        if ((i & 11) != 2 || !composer.getSkipping()) {
            TicketTimelineCardKt.TicketTimelineCard(TicketTimelineCardState.m5383copyBx497Mc$default(TicketTimelineCardKt.getSampleTicketTimelineCardState(), (List) null, (String) null, (String) null, TicketStatus.InProgress.m5382getColor0d7_KjU(), CollectionsKt.listOf(new TicketTimelineCardState.ProgressSection(true, new TicketTimelineCardState.ActualStringOrRes.ActualString("Submitted"), 1634889351, false), new TicketTimelineCardState.ProgressSection(true, new TicketTimelineCardState.ActualStringOrRes.ActualString("In progress"), Calendar.getInstance().getTimeInMillis(), true), new TicketTimelineCardState.ProgressSection(false, new TicketTimelineCardState.ActualStringOrRes.ActualString("Resolved"), Calendar.getInstance().getTimeInMillis(), false)), (Integer) null, 39, (Object) null), BackgroundKt.m177backgroundbw27NRU$default(Modifier.Companion, MaterialTheme.INSTANCE.getColors(composer2, 8).m1218getSurface0d7_KjU(), (Shape) null, 2, (Object) null), composer2, 8, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
