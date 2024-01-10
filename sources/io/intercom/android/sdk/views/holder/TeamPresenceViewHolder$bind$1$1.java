package io.intercom.android.sdk.views.holder;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TeamPresenceViewHolder.kt */
final class TeamPresenceViewHolder$bind$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TeamPresenceState $teamPresenceState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TeamPresenceViewHolder$bind$1$1(TeamPresenceState teamPresenceState) {
        super(2);
        this.$teamPresenceState = teamPresenceState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final TeamPresenceState teamPresenceState = this.$teamPresenceState;
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(composer, 1090683613, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        TeamPresenceViewHolderKt.TeamPresenceAvatars(teamPresenceState, composer, 8);
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer, 3072, 7);
            return;
        }
        composer.skipToGroupEnd();
    }
}
