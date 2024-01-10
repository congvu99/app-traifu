package io.intercom.android.sdk.tickets;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.tickets.TicketDetailState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"BigTicketCard", "", "ticketDetailState", "Lio/intercom/android/sdk/tickets/TicketDetailState$TicketDetailContentState;", "onClick", "Lkotlin/Function0;", "visible", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/intercom/android/sdk/tickets/TicketDetailState$TicketDetailContentState;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BigTicketCardPreview", "(Landroidx/compose/runtime/Composer;I)V", "BigTicketCardWaitingPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: BigTicketCard.kt */
public final class BigTicketCardKt {
    public static final void BigTicketCard(TicketDetailState.TicketDetailContentState ticketDetailContentState, Function0<Unit> function0, boolean z, Modifier modifier, Composer composer, int i, int i2) {
        TicketDetailState.TicketDetailContentState ticketDetailContentState2 = ticketDetailContentState;
        Function0<Unit> function02 = function0;
        Intrinsics.checkNotNullParameter(ticketDetailContentState2, "ticketDetailState");
        Intrinsics.checkNotNullParameter(function02, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1350435167);
        Modifier modifier2 = (i2 & 8) != 0 ? Modifier.Companion : modifier;
        AnimatedVisibilityKt.AnimatedVisibility(z, (Modifier) null, EnterExitTransitionKt.expandIn$default(AnimationSpecKt.tween$default(1000, 0, (Easing) null, 6, (Object) null), Alignment.Companion.getTopCenter(), false, (Function1) null, 12, (Object) null).plus(EnterExitTransitionKt.slideInVertically(AnimationSpecKt.tween$default(1000, 500, (Easing) null, 4, (Object) null), BigTicketCardKt$BigTicketCard$1.INSTANCE)).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(1000, 500, (Easing) null, 4, (Object) null), 0.0f, 2, (Object) null)), EnterExitTransitionKt.slideOutVertically(AnimationSpecKt.tween$default(1000, 0, (Easing) null, 6, (Object) null), BigTicketCardKt$BigTicketCard$2.INSTANCE).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(1000, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null)).plus(EnterExitTransitionKt.shrinkOut$default(AnimationSpecKt.tween$default(1000, 500, (Easing) null, 4, (Object) null), Alignment.Companion.getTopCenter(), false, (Function1) null, 12, (Object) null)), (String) null, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 1185188553, true, new BigTicketCardKt$BigTicketCard$3(function02, modifier2, ticketDetailContentState2)), startRestartGroup, ((i >> 6) & 14) | 196992, 18);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BigTicketCardKt$BigTicketCard$4(ticketDetailContentState, function0, z, modifier2, i, i2));
        }
    }

    public static final void BigTicketCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1633906687);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$BigTicketCardKt.INSTANCE.m5355getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BigTicketCardKt$BigTicketCardPreview$1(i));
        }
    }

    public static final void BigTicketCardWaitingPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(830508878);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$BigTicketCardKt.INSTANCE.m5356getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BigTicketCardKt$BigTicketCardWaitingPreview$1(i));
        }
    }
}
