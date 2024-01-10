package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyList.kt */
final class LazyListKt$ScrollPositionUpdater$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ LazyListItemProvider $itemProvider;
    final /* synthetic */ LazyListState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListKt$ScrollPositionUpdater$1(LazyListItemProvider lazyListItemProvider, LazyListState lazyListState, int i) {
        super(2);
        this.$itemProvider = lazyListItemProvider;
        this.$state = lazyListState;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LazyListKt.ScrollPositionUpdater(this.$itemProvider, this.$state, composer, this.$$changed | 1);
    }
}
