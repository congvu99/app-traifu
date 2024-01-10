package androidx.navigation.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavHost.kt */
final class NavHostKt$NavHost$4$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ ComposeNavigator $composeNavigator;
    final /* synthetic */ MutableState<Boolean> $initialCrossfade$delegate;
    final /* synthetic */ State<List<NavBackStackEntry>> $visibleEntries$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$4$1$1(MutableState<Boolean> mutableState, State<? extends List<NavBackStackEntry>> state, ComposeNavigator composeNavigator) {
        super(1);
        this.$initialCrossfade$delegate = mutableState;
        this.$visibleEntries$delegate = state;
        this.$composeNavigator = composeNavigator;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        if (NavHostKt.m4979NavHost$lambda7(this.$initialCrossfade$delegate)) {
            ComposeNavigator composeNavigator = this.$composeNavigator;
            for (NavBackStackEntry onTransitionComplete$navigation_compose_release : NavHostKt.m4978NavHost$lambda5(this.$visibleEntries$delegate)) {
                composeNavigator.onTransitionComplete$navigation_compose_release(onTransitionComplete$navigation_compose_release);
            }
            NavHostKt.m4980NavHost$lambda8(this.$initialCrossfade$delegate, false);
        }
        return new NavHostKt$NavHost$4$1$1$invoke$$inlined$onDispose$1(this.$visibleEntries$delegate, this.$composeNavigator);
    }
}
