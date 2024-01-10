package io.intercom.android.sdk.m5.home.screens;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import io.intercom.android.sdk.m5.home.topbars.HomeHeaderBackdropKt;
import io.intercom.android.sdk.m5.home.viewmodel.HeaderState;
import io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeScreen.kt */
final class HomeScreenKt$HomeScreen$2$1 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Float> $headerHeightPx;
    final /* synthetic */ State<HeaderState> $headerState;
    final /* synthetic */ HomeViewModel $homeViewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeScreenKt$HomeScreen$2$1(State<? extends HeaderState> state, HomeViewModel homeViewModel, MutableState<Float> mutableState) {
        super(3);
        this.$headerState = state;
        this.$homeViewModel = homeViewModel;
        this.$headerHeightPx = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        HeaderState value = this.$headerState.getValue();
        if (value instanceof HeaderState.HeaderContent) {
            HeaderState.HeaderContent headerContent = (HeaderState.HeaderContent) value;
            if (headerContent instanceof HeaderState.HeaderContent.Expanded) {
                HeaderState.HeaderBackdropStyle headerBackdropStyle = ((HeaderState.HeaderContent.Expanded) value).getHeaderBackdropStyle();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer);
                HomeHeaderBackdropKt.m5232HomeHeaderBackdroporJrPs(((Density) consume).m4645toDpu2uoSUM(this.$headerHeightPx.getValue().floatValue()), headerBackdropStyle, new Function0<Unit>(this.$homeViewModel) {
                    public final void invoke() {
                        ((HomeViewModel) this.receiver).onHeaderImageLoaded();
                    }
                }, composer, 0);
                return;
            }
            boolean z = headerContent instanceof HeaderState.HeaderContent.Reduced;
            return;
        }
        Intrinsics.areEqual((Object) value, (Object) HeaderState.NoHeader.INSTANCE);
    }
}
