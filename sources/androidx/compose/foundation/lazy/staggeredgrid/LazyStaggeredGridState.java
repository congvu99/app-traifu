package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalFoundationApi
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 {2\u00020\u0001:\u0001{B\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0017\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ#\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u00032\b\b\u0002\u0010[\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\\J\u0015\u0010]\u001a\u00020Y2\u0006\u0010^\u001a\u00020_H\u0000¢\u0006\u0002\b`J\u0010\u0010a\u001a\u00020Y2\u0006\u0010b\u001a\u000201H\u0002J\u0010\u0010c\u001a\u00020N2\u0006\u0010d\u001a\u00020NH\u0016J\u0018\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0010\u0010g\u001a\u00020Y2\u0006\u0010d\u001a\u00020NH\u0002J\u0010\u0010h\u001a\u00020N2\u0006\u0010i\u001a\u00020NH\u0002JB\u0010j\u001a\u00020Y2\u0006\u0010k\u001a\u00020l2'\u0010m\u001a#\b\u0001\u0012\u0004\u0012\u00020o\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0p\u0012\u0006\u0012\u0004\u0018\u00010q0n¢\u0006\u0002\brH@ø\u0001\u0000¢\u0006\u0002\u0010sJ#\u0010t\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u00032\b\b\u0002\u0010[\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\\J\u0015\u0010u\u001a\u00020Y2\u0006\u0010v\u001a\u00020wH\u0000¢\u0006\u0002\bxJ!\u0010y\u001a\u00020Y*\u00020o2\u0006\u0010Z\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u0003H\u0000¢\u0006\u0002\bzR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0010R\u001a\u0010&\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012R\u0014\u0010)\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001eR\u001a\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u00100\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020105X\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u00109R\u0014\u0010:\u001a\u00020;X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020@X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0010\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020FX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020JX\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u001e\u0010O\u001a\u00020N2\u0006\u0010M\u001a\u00020N@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\u00020TX\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006|"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemOffset", "(II)V", "initialFirstVisibleItems", "", "initialFirstVisibleOffsets", "([I[I)V", "animateScrollScope", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridAnimateScrollScope;", "canScrollBackward", "", "canScrollForward", "getCanScrollForward$foundation_release", "()Z", "setCanScrollForward$foundation_release", "(Z)V", "currentItemPrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "firstVisibleItemIndex", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "isScrollInProgress", "isVertical", "isVertical$foundation_release", "setVertical$foundation_release", "laneCount", "getLaneCount$foundation_release", "laneWidthsPrefixSum", "getLaneWidthsPrefixSum$foundation_release", "()[I", "setLaneWidthsPrefixSum$foundation_release", "([I)V", "layoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "measurePassCount", "getMeasurePassCount$foundation_release", "setMeasurePassCount$foundation_release", "(I)V", "mutableInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getMutableInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "prefetchBaseIndex", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "remeasurement", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "getScrollPosition$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "<set-?>", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "spans", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpans;", "getSpans$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpans;", "wasScrollingForward", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "applyMeasureResult$foundation_release", "cancelPrefetchIfVisibleItemsChanged", "info", "dispatchRawDelta", "delta", "fillNearestIndices", "itemIndex", "notifyPrefetch", "onScroll", "distance", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "snapToItemInternal", "snapToItemInternal$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyStaggeredGridState.kt */
public final class LazyStaggeredGridState implements ScrollableState {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Saver<LazyStaggeredGridState, Object> Saver = ListSaverKt.listSaver(LazyStaggeredGridState$Companion$Saver$1.INSTANCE, LazyStaggeredGridState$Companion$Saver$2.INSTANCE);
    private final LazyStaggeredGridAnimateScrollScope animateScrollScope;
    private boolean canScrollBackward;
    private boolean canScrollForward;
    private final MutableVector<LazyLayoutPrefetchState.PrefetchHandle> currentItemPrefetchHandles;
    private Density density;
    private boolean isVertical;
    private int[] laneWidthsPrefixSum;
    private final MutableState<LazyStaggeredGridLayoutInfo> layoutInfoState;
    private int measurePassCount;
    private final MutableInteractionSource mutableInteractionSource;
    private int prefetchBaseIndex;
    private final LazyLayoutPrefetchState prefetchState;
    /* access modifiers changed from: private */
    public Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyStaggeredGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;
    private final LazyStaggeredGridSpans spans;
    private boolean wasScrollingForward;

    public /* synthetic */ LazyStaggeredGridState(int[] iArr, int[] iArr2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, iArr2);
    }

    private LazyStaggeredGridState(int[] iArr, int[] iArr2) {
        this.scrollPosition = new LazyStaggeredGridScrollPosition(iArr, iArr2, new LazyStaggeredGridState$scrollPosition$1(this));
        this.layoutInfoState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(EmptyLazyStaggeredGridLayoutInfo.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.spans = new LazyStaggeredGridSpans();
        this.canScrollForward = true;
        this.canScrollBackward = true;
        this.animateScrollScope = new LazyStaggeredGridAnimateScrollScope(this);
        this.remeasurementModifier = new LazyStaggeredGridState$remeasurementModifier$1(this);
        this.prefetchState = new LazyLayoutPrefetchState();
        this.scrollableState = ScrollableStateKt.ScrollableState(new LazyStaggeredGridState$scrollableState$1(this));
        this.wasScrollingForward = true;
        this.laneWidthsPrefixSum = new int[0];
        this.prefetchBaseIndex = -1;
        this.currentItemPrefetchHandles = new MutableVector<>(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);
        this.density = DensityKt.Density(1.0f, 1.0f);
        this.mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyStaggeredGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public LazyStaggeredGridState(int i, int i2) {
        this(new int[]{i}, new int[]{i2});
    }

    public final int getFirstVisibleItemIndex() {
        Integer minOrNull = ArraysKt.minOrNull(this.scrollPosition.getIndices());
        if (minOrNull != null) {
            return minOrNull.intValue();
        }
        return 0;
    }

    public final int getFirstVisibleItemScrollOffset() {
        int[] offsets = this.scrollPosition.getOffsets();
        if (offsets.length == 0) {
            return 0;
        }
        return offsets[LazyStaggeredGridMeasureKt.indexOfMinValue(this.scrollPosition.getIndices())];
    }

    public final LazyStaggeredGridScrollPosition getScrollPosition$foundation_release() {
        return this.scrollPosition;
    }

    public final LazyStaggeredGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final LazyStaggeredGridSpans getSpans$foundation_release() {
        return this.spans;
    }

    public final boolean getCanScrollForward$foundation_release() {
        return this.canScrollForward;
    }

    public final void setCanScrollForward$foundation_release(boolean z) {
        this.canScrollForward = z;
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    public final int getMeasurePassCount$foundation_release() {
        return this.measurePassCount;
    }

    public final void setMeasurePassCount$foundation_release(int i) {
        this.measurePassCount = i;
    }

    public final boolean isVertical$foundation_release() {
        return this.isVertical;
    }

    public final void setVertical$foundation_release(boolean z) {
        this.isVertical = z;
    }

    public final int[] getLaneWidthsPrefixSum$foundation_release() {
        return this.laneWidthsPrefixSum;
    }

    public final void setLaneWidthsPrefixSum$foundation_release(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.laneWidthsPrefixSum = iArr;
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density density2) {
        Intrinsics.checkNotNullParameter(density2, "<set-?>");
        this.density = density2;
    }

    public final int getLaneCount$foundation_release() {
        return this.laneWidthsPrefixSum.length;
    }

    public final InteractionSource getInteractionSource() {
        return this.mutableInteractionSource;
    }

    public final MutableInteractionSource getMutableInteractionSource$foundation_release() {
        return this.mutableInteractionSource;
    }

    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll = this.scrollableState.scroll(mutatePriority, function2, continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    /* access modifiers changed from: private */
    public final float onScroll(float f) {
        if ((f < 0.0f && !this.canScrollForward) || (f > 0.0f && !this.canScrollBackward)) {
            return 0.0f;
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            float f2 = this.scrollToBeConsumed + f;
            this.scrollToBeConsumed = f2;
            if (Math.abs(f2) > 0.5f) {
                float f3 = this.scrollToBeConsumed;
                Remeasurement remeasurement2 = this.remeasurement;
                if (remeasurement2 != null) {
                    remeasurement2.forceRemeasure();
                }
                notifyPrefetch(f3 - this.scrollToBeConsumed);
            }
            if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
                return f;
            }
            float f4 = f - this.scrollToBeConsumed;
            this.scrollToBeConsumed = 0.0f;
            return f4;
        }
        throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.scrollToBeConsumed).toString());
    }

    public static /* synthetic */ Object scrollToItem$default(LazyStaggeredGridState lazyStaggeredGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyStaggeredGridState.scrollToItem(i, i2, continuation);
    }

    public final Object scrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.CC.scroll$default(this, (MutatePriority) null, new LazyStaggeredGridState$scrollToItem$2(this, i, i2, (Continuation<? super LazyStaggeredGridState$scrollToItem$2>) null), continuation, 1, (Object) null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyStaggeredGridState lazyStaggeredGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyStaggeredGridState.animateScrollToItem(i, i2, continuation);
    }

    public final Object animateScrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object animateScrollToItem = LazyAnimateScrollKt.animateScrollToItem(this.animateScrollScope, i, i2, continuation);
        return animateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem : Unit.INSTANCE;
    }

    public final void snapToItemInternal$foundation_release(ScrollScope scrollScope, int i, int i2) {
        Intrinsics.checkNotNullParameter(scrollScope, "<this>");
        LazyStaggeredGridItemInfo findVisibleItem = LazyStaggeredGridMeasureResultKt.findVisibleItem(getLayoutInfo(), i);
        if (findVisibleItem != null) {
            boolean z = this.isVertical;
            long r0 = findVisibleItem.m802getOffsetnOccac();
            scrollScope.scrollBy((float) ((z ? IntOffset.m4823getYimpl(r0) : IntOffset.m4822getXimpl(r0)) + i2));
            return;
        }
        this.scrollPosition.requestPosition(i, i2);
        Remeasurement remeasurement2 = this.remeasurement;
        if (remeasurement2 != null) {
            remeasurement2.forceRemeasure();
        }
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyLayoutItemProvider lazyLayoutItemProvider) {
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(lazyLayoutItemProvider);
    }

    public float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void notifyPrefetch(float r11) {
        /*
            r10 = this;
            androidx.compose.runtime.MutableState<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo> r0 = r10.layoutInfoState
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo r0 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo) r0
            java.util.List r1 = r0.getVisibleItemsInfo()
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x00be
            r1 = 0
            r3 = 0
            int r11 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r11 >= 0) goto L_0x001e
            r11 = 1
            goto L_0x001f
        L_0x001e:
            r11 = 0
        L_0x001f:
            boolean r1 = r10.wasScrollingForward
            if (r1 == r11) goto L_0x003f
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r1 = r10.currentItemPrefetchHandles
            int r4 = r1.getSize()
            if (r4 <= 0) goto L_0x003f
            java.lang.Object[] r1 = r1.getContent()
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r5)
            r5 = 0
        L_0x0035:
            r6 = r1[r5]
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle r6 = (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle) r6
            r6.cancel()
            int r5 = r5 + r2
            if (r5 < r4) goto L_0x0035
        L_0x003f:
            r10.wasScrollingForward = r11
            if (r11 == 0) goto L_0x0052
            java.util.List r1 = r0.getVisibleItemsInfo()
            java.lang.Object r1 = kotlin.collections.CollectionsKt.last(r1)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo r1 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo) r1
            int r1 = r1.getIndex()
            goto L_0x0060
        L_0x0052:
            java.util.List r1 = r0.getVisibleItemsInfo()
            java.lang.Object r1 = kotlin.collections.CollectionsKt.first(r1)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo r1 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo) r1
            int r1 = r1.getIndex()
        L_0x0060:
            int r4 = r10.prefetchBaseIndex
            if (r1 != r4) goto L_0x0065
            return
        L_0x0065:
            r10.prefetchBaseIndex = r1
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r4 = r10.currentItemPrefetchHandles
            r4.clear()
            int[] r4 = r10.laneWidthsPrefixSum
            int r4 = r4.length
            r5 = 0
        L_0x0070:
            if (r5 >= r4) goto L_0x00be
            if (r11 == 0) goto L_0x007b
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpans r6 = r10.spans
            int r6 = r6.findNextItemIndex(r1, r5)
            goto L_0x0081
        L_0x007b:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpans r6 = r10.spans
            int r6 = r6.findPreviousItemIndex(r1, r5)
        L_0x0081:
            if (r6 < 0) goto L_0x008b
            int r7 = r0.getTotalItemsCount()
            if (r6 >= r7) goto L_0x008b
            r7 = 1
            goto L_0x008c
        L_0x008b:
            r7 = 0
        L_0x008c:
            if (r7 == 0) goto L_0x00be
            if (r1 != r6) goto L_0x0091
            goto L_0x00be
        L_0x0091:
            int[] r1 = r10.laneWidthsPrefixSum
            r7 = r1[r5]
            if (r5 != 0) goto L_0x0099
            r1 = 0
            goto L_0x009d
        L_0x0099:
            int r8 = r5 + -1
            r1 = r1[r8]
        L_0x009d:
            int r7 = r7 - r1
            boolean r1 = r10.isVertical
            if (r1 == 0) goto L_0x00a9
            androidx.compose.ui.unit.Constraints$Companion r1 = androidx.compose.ui.unit.Constraints.Companion
            long r7 = r1.m4634fixedWidthOenEA2s(r7)
            goto L_0x00af
        L_0x00a9:
            androidx.compose.ui.unit.Constraints$Companion r1 = androidx.compose.ui.unit.Constraints.Companion
            long r7 = r1.m4633fixedHeightOenEA2s(r7)
        L_0x00af:
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r1 = r10.currentItemPrefetchHandles
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r9 = r10.prefetchState
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle r7 = r9.m794schedulePrefetch0kLqBqw(r6, r7)
            r1.add(r7)
            int r5 = r5 + 1
            r1 = r6
            goto L_0x0070
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.notifyPrefetch(float):void");
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo) {
        List<LazyStaggeredGridItemInfo> visibleItemsInfo = lazyStaggeredGridLayoutInfo.getVisibleItemsInfo();
        if (this.prefetchBaseIndex != -1 && (!visibleItemsInfo.isEmpty())) {
            int index = ((LazyStaggeredGridItemInfo) CollectionsKt.first(visibleItemsInfo)).getIndex();
            int index2 = ((LazyStaggeredGridItemInfo) CollectionsKt.last(visibleItemsInfo)).getIndex();
            int i = this.prefetchBaseIndex;
            int i2 = 0;
            if (!(index <= i && i <= index2)) {
                this.prefetchBaseIndex = -1;
                MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector = this.currentItemPrefetchHandles;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    do {
                        ((LazyLayoutPrefetchState.PrefetchHandle) content[i2]).cancel();
                        i2++;
                    } while (i2 < size);
                }
                this.currentItemPrefetchHandles.clear();
            }
        }
    }

    public final void applyMeasureResult$foundation_release(LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult) {
        Intrinsics.checkNotNullParameter(lazyStaggeredGridMeasureResult, "result");
        this.scrollToBeConsumed -= lazyStaggeredGridMeasureResult.getConsumedScroll();
        this.canScrollBackward = lazyStaggeredGridMeasureResult.getCanScrollBackward();
        this.canScrollForward = lazyStaggeredGridMeasureResult.getCanScrollForward();
        this.layoutInfoState.setValue(lazyStaggeredGridMeasureResult);
        cancelPrefetchIfVisibleItemsChanged(lazyStaggeredGridMeasureResult);
        this.scrollPosition.updateFromMeasureResult(lazyStaggeredGridMeasureResult);
        this.measurePassCount++;
    }

    /* access modifiers changed from: private */
    public final int[] fillNearestIndices(int i, int i2) {
        int i3;
        this.spans.ensureValidIndex(i + i2);
        int span = this.spans.getSpan(i);
        if (span == -1) {
            i3 = 0;
        } else {
            i3 = Math.min(span, i2);
        }
        int[] iArr = new int[i2];
        int i4 = i3 - 1;
        int i5 = i;
        while (true) {
            if (-1 >= i4) {
                break;
            }
            iArr[i4] = this.spans.findPreviousItemIndex(i5, i4);
            if (iArr[i4] == -1) {
                ArraysKt.fill$default(iArr, -1, 0, i4, 2, (Object) null);
                break;
            }
            i5 = iArr[i4];
            i4--;
        }
        iArr[i3] = i;
        while (true) {
            i3++;
            if (i3 >= i2) {
                return iArr;
            }
            iArr[i3] = this.spans.findNextItemIndex(i, i3);
            i = iArr[i3];
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: LazyStaggeredGridState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazyStaggeredGridState, Object> getSaver() {
            return LazyStaggeredGridState.Saver;
        }
    }
}
