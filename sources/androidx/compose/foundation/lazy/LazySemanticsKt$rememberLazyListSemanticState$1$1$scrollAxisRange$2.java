package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazySemantics.kt */
final class LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;
    final /* synthetic */ LazyListState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$2(LazyListState lazyListState, LazyLayoutItemProvider lazyLayoutItemProvider) {
        super(0);
        this.$state = lazyListState;
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
