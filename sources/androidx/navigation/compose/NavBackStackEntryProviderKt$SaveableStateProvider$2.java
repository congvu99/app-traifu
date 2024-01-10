package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavBackStackEntryProvider.kt */
final class NavBackStackEntryProviderKt$SaveableStateProvider$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ SaveableStateHolder $this_SaveableStateProvider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavBackStackEntryProviderKt$SaveableStateProvider$2(SaveableStateHolder saveableStateHolder, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$this_SaveableStateProvider = saveableStateHolder;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        NavBackStackEntryProviderKt.SaveableStateProvider(this.$this_SaveableStateProvider, this.$content, composer, this.$$changed | 1);
    }
}
