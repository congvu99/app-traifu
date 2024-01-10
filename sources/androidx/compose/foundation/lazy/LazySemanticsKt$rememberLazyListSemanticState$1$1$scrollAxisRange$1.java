package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazySemantics.kt */
final class LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ LazyListState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$1(LazyListState lazyListState) {
        super(0);
        this.$state = lazyListState;
    }

    public final Float invoke() {
        return Float.valueOf(((float) this.$state.getFirstVisibleItemIndex()) + (((float) this.$state.getFirstVisibleItemScrollOffset()) / 100000.0f));
    }
}
