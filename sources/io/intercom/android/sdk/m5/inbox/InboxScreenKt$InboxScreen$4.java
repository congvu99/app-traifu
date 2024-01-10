package io.intercom.android.sdk.m5.inbox;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.FloatingActionButtonElevation;
import androidx.compose.material.FloatingActionButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.inbox.InboxScreenState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxScreen.kt */
final class InboxScreenKt$InboxScreen$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function0<Unit> $onSendMessageButtonClick;
    final /* synthetic */ State<InboxScreenState> $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InboxScreenKt$InboxScreen$4(State<? extends InboxScreenState> state, Function0<Unit> function0, int i) {
        super(2);
        this.$state = state;
        this.$onSendMessageButtonClick = function0;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        if ((i & 11) != 2 || !composer.getSkipping()) {
            InboxScreenState value = this.$state.getValue();
            if ((value instanceof InboxScreenState.Content) && ((InboxScreenState.Content) value).getShowSendMessageFab()) {
                long r5 = MaterialTheme.INSTANCE.getColors(composer2, 8).m1214getPrimary0d7_KjU();
                long r7 = MaterialTheme.INSTANCE.getColors(composer2, 8).m1211getOnPrimary0d7_KjU();
                FloatingActionButtonKt.m1311FloatingActionButtonbogVsAg(this.$onSendMessageButtonClick, PaddingKt.m514paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.m4704constructorimpl((float) 38), 7, (Object) null), (MutableInteractionSource) null, (Shape) null, r5, r7, (FloatingActionButtonElevation) null, ComposableSingletons$InboxScreenKt.INSTANCE.m5254getLambda1$intercom_sdk_base_release(), composer, 12582960 | ((this.$$dirty >> 3) & 14), 76);
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
