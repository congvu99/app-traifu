package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyStaggeredGridSemantics.kt */
public final class LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1 implements LazyLayoutSemanticState {
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;
    final /* synthetic */ boolean $reverseScrolling;
    final /* synthetic */ LazyStaggeredGridState $state;

    LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1(boolean z, LazyStaggeredGridState lazyStaggeredGridState, LazyLayoutItemProvider lazyLayoutItemProvider) {
        this.$reverseScrolling = z;
        this.$state = lazyStaggeredGridState;
        this.$itemProvider = lazyLayoutItemProvider;
    }

    public ScrollAxisRange scrollAxisRange() {
        return new ScrollAxisRange(new LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$1(this.$state), new LazyStaggeredGridSemanticsKt$rememberLazyStaggeredGridSemanticState$1$1$scrollAxisRange$2(this.$state, this.$itemProvider), this.$reverseScrolling);
    }

    public Object animateScrollBy(float f, Continuation<? super Unit> continuation) {
        Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.$state, f, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateScrollBy$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
    }

    public Object scrollToItem(int i, Continuation<? super Unit> continuation) {
        Object scrollToItem$default = LazyStaggeredGridState.scrollToItem$default(this.$state, i, 0, continuation, 2, (Object) null);
        return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
    }

    public CollectionInfo collectionInfo() {
        return new CollectionInfo(-1, -1);
    }
}
