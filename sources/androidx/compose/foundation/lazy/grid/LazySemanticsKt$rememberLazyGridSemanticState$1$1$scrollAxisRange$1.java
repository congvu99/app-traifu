package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazySemantics.kt */
final class LazySemanticsKt$rememberLazyGridSemanticState$1$1$scrollAxisRange$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ LazyGridState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazySemanticsKt$rememberLazyGridSemanticState$1$1$scrollAxisRange$1(LazyGridState lazyGridState) {
        super(0);
        this.$state = lazyGridState;
    }

    public final Float invoke() {
        return Float.valueOf(((float) this.$state.getFirstVisibleItemIndex()) + (((float) this.$state.getFirstVisibleItemScrollOffset()) / 100000.0f));
    }
}
