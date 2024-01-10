package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazySemantics.kt */
final class LazySemanticsKt$rememberLazyGridSemanticState$1$1$scrollAxisRange$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;
    final /* synthetic */ LazyGridState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazySemanticsKt$rememberLazyGridSemanticState$1$1$scrollAxisRange$2(LazyGridState lazyGridState, LazyLayoutItemProvider lazyLayoutItemProvider) {
        super(0);
        this.$state = lazyGridState;
        this.$itemProvider = lazyLayoutItemProvider;
    }

    public final Float invoke() {
        float f;
        float f2;
        if (this.$state.getCanScrollForward$foundation_release()) {
            f2 = (float) this.$itemProvider.getItemCount();
            f = 1.0f;
        } else {
            f2 = (float) this.$state.getFirstVisibleItemIndex();
            f = ((float) this.$state.getFirstVisibleItemScrollOffset()) / 100000.0f;
        }
        return Float.valueOf(f2 + f);
    }
}
