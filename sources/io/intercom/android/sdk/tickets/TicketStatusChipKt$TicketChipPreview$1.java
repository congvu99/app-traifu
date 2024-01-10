package io.intercom.android.sdk.tickets;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketStatusChip.kt */
final class TicketStatusChipKt$TicketChipPreview$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ StatusChip $statusChip;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TicketStatusChipKt$TicketChipPreview$1(StatusChip statusChip) {
        super(2);
        this.$statusChip = statusChip;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            Modifier wrapContentSize$default = SizeKt.wrapContentSize$default(Modifier.Companion, (Alignment) null, false, 3, (Object) null);
            final StatusChip statusChip = this.$statusChip;
            Composer composer2 = composer;
            SurfaceKt.m1419SurfaceFjzlyU(wrapContentSize$default, (Shape) null, 0, 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -218336345, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        TicketStatusChipKt.TicketStatusChip(statusChip, composer, 0);
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer2, 1572870, 62);
            return;
        }
        composer.skipToGroupEnd();
    }
}
