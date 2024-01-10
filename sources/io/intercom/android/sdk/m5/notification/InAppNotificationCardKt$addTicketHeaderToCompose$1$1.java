package io.intercom.android.sdk.m5.notification;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.tickets.StatusChip;
import io.intercom.android.sdk.tickets.TicketDetailReducerKt;
import io.intercom.android.sdk.tickets.TicketStatusChipKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppNotificationCard.kt */
final class InAppNotificationCardKt$addTicketHeaderToCompose$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Conversation $conversation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppNotificationCardKt$addTicketHeaderToCompose$1$1(Conversation conversation) {
        super(2);
        this.$conversation = conversation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final Conversation conversation = this.$conversation;
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(composer, -1860903769, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                    } else if (!Intrinsics.areEqual((Object) conversation.getTicket(), (Object) Ticket.Companion.getNULL())) {
                        TicketStatusChipKt.TicketStatusChip(new StatusChip(conversation.getTicket().getTitle(), conversation.getTicket().getCurrentStatus().getTitle(), TicketDetailReducerKt.toTicketStatus(conversation.getTicket().getCurrentStatus()).m5382getColor0d7_KjU(), (DefaultConstructorMarker) null), composer, 0);
                    }
                }
            }), composer, 3072, 7);
            return;
        }
        composer.skipToGroupEnd();
    }
}
