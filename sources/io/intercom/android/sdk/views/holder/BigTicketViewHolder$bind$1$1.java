package io.intercom.android.sdk.views.holder;

import android.content.Intent;
import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.ComposeView;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.tickets.BigTicketCardKt;
import io.intercom.android.sdk.tickets.IntercomTicketActivity;
import io.intercom.android.sdk.tickets.TicketDetailState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BigTicketViewHolder.kt */
final class BigTicketViewHolder$bind$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ComposeView $this_apply;
    final /* synthetic */ TicketDetailState.TicketDetailContentState $ticketViewState;
    final /* synthetic */ boolean $visible;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BigTicketViewHolder$bind$1$1(TicketDetailState.TicketDetailContentState ticketDetailContentState, boolean z, ComposeView composeView) {
        super(2);
        this.$ticketViewState = ticketDetailContentState;
        this.$visible = z;
        this.$this_apply = composeView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final TicketDetailState.TicketDetailContentState ticketDetailContentState = this.$ticketViewState;
            final boolean z = this.$visible;
            final ComposeView composeView = this.$this_apply;
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(composer, 38293454, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        TicketDetailState.TicketDetailContentState ticketDetailContentState = ticketDetailContentState;
                        final ComposeView composeView = composeView;
                        BigTicketCardKt.BigTicketCard(ticketDetailContentState, new Function0<Unit>() {
                            public final void invoke() {
                                composeView.getContext().startActivity(new Intent(composeView.getContext(), IntercomTicketActivity.class));
                            }
                        }, z, (Modifier) null, composer, 8, 8);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 3072, 7);
            return;
        }
        composer.skipToGroupEnd();
    }
}
