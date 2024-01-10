package io.intercom.android.sdk.m5.home.screens;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.ScrollState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import io.intercom.android.sdk.m5.home.topbars.HomeHeaderKt;
import io.intercom.android.sdk.m5.home.viewmodel.HeaderState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeScreen.kt */
final class HomeScreenKt$HomeScreen$2$2$1 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ MutableState<Float> $headerHeightPx;
    final /* synthetic */ State<HeaderState> $headerState;
    final /* synthetic */ Function0<Unit> $onCloseClick;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ float $topPadding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeScreenKt$HomeScreen$2$2$1(ScrollState scrollState, MutableState<Float> mutableState, State<? extends HeaderState> state, float f, Function0<Unit> function0, int i) {
        super(3);
        this.$scrollState = scrollState;
        this.$headerHeightPx = mutableState;
        this.$headerState = state;
        this.$topPadding = f;
        this.$onCloseClick = function0;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    private static final float invoke$getHeaderContentOpacity(State<? extends HeaderState> state, int i, float f) {
        if (state.getValue() instanceof HeaderState.HeaderContent.Reduced) {
            return 1.0f;
        }
        return RangesKt.coerceIn((f - ((float) i)) / f, 0.0f, 1.0f);
    }

    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        Modifier alpha = AlphaKt.alpha(Modifier.Companion, invoke$getHeaderContentOpacity(this.$headerState, this.$scrollState.getValue(), this.$headerHeightPx.getValue().floatValue()));
        MutableState<Float> mutableState = this.$headerHeightPx;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) mutableState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new HomeScreenKt$HomeScreen$2$2$1$1$1(mutableState);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        float f = this.$topPadding;
        Function0<Unit> function0 = this.$onCloseClick;
        int i2 = this.$$dirty;
        HomeHeaderKt.m5233HomeHeader942rkJo(OnGloballyPositionedModifierKt.onGloballyPositioned(alpha, (Function1) rememberedValue), this.$headerState.getValue(), f, function0, composer, ((i2 << 3) & 896) | ((i2 >> 12) & 7168), 0);
    }
}
