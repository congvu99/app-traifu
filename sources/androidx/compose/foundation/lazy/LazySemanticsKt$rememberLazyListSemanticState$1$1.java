package androidx.compose.foundation.lazy;

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
/* compiled from: LazySemantics.kt */
public final class LazySemanticsKt$rememberLazyListSemanticState$1$1 implements LazyLayoutSemanticState {
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;
    final /* synthetic */ boolean $reverseScrolling;
    final /* synthetic */ LazyListState $state;

    LazySemanticsKt$rememberLazyListSemanticState$1$1(boolean z, LazyListState lazyListState, LazyLayoutItemProvider lazyLayoutItemProvider, boolean z2) {
        this.$reverseScrolling = z;
        this.$state = lazyListState;
        this.$itemProvider = lazyLayoutItemProvider;
        this.$isVertical = z2;
    }

    public ScrollAxisRange scrollAxisRange() {
        return new ScrollAxisRange(new LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$1(this.$state), new LazySemanticsKt$rememberLazyListSemanticState$1$1$scrollAxisRange$2(this.$state, this.$itemProvider), this.$reverseScrolling);
    }

    public Object animateScrollBy(float f, Continuation<? super Unit> continuation) {
        Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.$state, f, (AnimationSpec) null, continuation, 2, (Object) null);
        return animateScrollBy$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
    }

    public Object scrollToItem(int i, Continuation<? super Unit> continuation) {
        Object scrollToItem$default = LazyListState.scrollToItem$default(this.$state, i, 0, continuation, 2, (Object) null);
        return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
    }

    public CollectionInfo collectionInfo() {
        if (this.$isVertical) {
            return new CollectionInfo(-1, 1);
        }
        return new CollectionInfo(1, -1);
    }
}
