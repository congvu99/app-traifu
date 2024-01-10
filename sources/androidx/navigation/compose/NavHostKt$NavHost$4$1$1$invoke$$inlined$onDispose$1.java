package androidx.navigation.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Effects.kt */
public final class NavHostKt$NavHost$4$1$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ ComposeNavigator $composeNavigator$inlined;
    final /* synthetic */ State $visibleEntries$delegate$inlined;

    public NavHostKt$NavHost$4$1$1$invoke$$inlined$onDispose$1(State state, ComposeNavigator composeNavigator) {
        this.$visibleEntries$delegate$inlined = state;
        this.$composeNavigator$inlined = composeNavigator;
    }

    public void dispose() {
        for (NavBackStackEntry onTransitionComplete$navigation_compose_release : NavHostKt.m4978NavHost$lambda5(this.$visibleEntries$delegate$inlined)) {
            this.$composeNavigator$inlined.onTransitionComplete$navigation_compose_release(onTransitionComplete$navigation_compose_release);
        }
    }
}
