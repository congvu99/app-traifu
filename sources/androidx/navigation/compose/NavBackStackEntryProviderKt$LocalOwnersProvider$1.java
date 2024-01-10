package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavBackStackEntryProvider.kt */
final class NavBackStackEntryProviderKt$LocalOwnersProvider$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ SaveableStateHolder $saveableStateHolder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavBackStackEntryProviderKt$LocalOwnersProvider$1(SaveableStateHolder saveableStateHolder, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$saveableStateHolder = saveableStateHolder;
        this.$content = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C51@2114L30:NavBackStackEntryProvider.kt#opm8kd");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            NavBackStackEntryProviderKt.SaveableStateProvider(this.$saveableStateHolder, this.$content, composer, ((this.$$dirty >> 3) & 112) | 8);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
