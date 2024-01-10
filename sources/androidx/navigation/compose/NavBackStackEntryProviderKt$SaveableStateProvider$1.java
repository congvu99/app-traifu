package androidx.navigation.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavBackStackEntryProvider.kt */
final class NavBackStackEntryProviderKt$SaveableStateProvider$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ BackStackEntryIdViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavBackStackEntryProviderKt$SaveableStateProvider$1(BackStackEntryIdViewModel backStackEntryIdViewModel) {
        super(1);
        this.$viewModel = backStackEntryIdViewModel;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new NavBackStackEntryProviderKt$SaveableStateProvider$1$invoke$$inlined$onDispose$1(this.$viewModel);
    }
}
