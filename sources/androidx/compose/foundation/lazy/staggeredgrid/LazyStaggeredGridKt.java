package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u000bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slotSizesSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyStaggeredGrid.kt */
public final class LazyStaggeredGridKt {
    @ExperimentalFoundationApi
    public static final void LazyStaggeredGrid(LazyStaggeredGridState lazyStaggeredGridState, Orientation orientation, Function2<? super Density, ? super Constraints, int[]> function2, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, int i, int i2, int i3) {
        Modifier modifier2;
        FlingBehavior flingBehavior2;
        int i4;
        LazyStaggeredGridState lazyStaggeredGridState2 = lazyStaggeredGridState;
        Function1<? super LazyStaggeredGridScope, Unit> function12 = function1;
        int i5 = i2;
        int i6 = i3;
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState2, "state");
        Intrinsics.checkNotNullParameter(orientation, ReactVideoView.EVENT_PROP_ORIENTATION);
        Intrinsics.checkNotNullParameter(function2, "slotSizesSums");
        Intrinsics.checkNotNullParameter(function12, "content");
        Composer startRestartGroup = composer.startRestartGroup(845690866);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyStaggeredGrid)P(8,5,7,4,1,6,2,9,10,3)53@2453L15,63@2948L18,65@2991L49,66@3065L254,77@3344L74,79@3424L42,89@3832L7,99@4197L215,81@3472L1067:LazyStaggeredGrid.kt#fzvcnm");
        if ((i6 & 8) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        PaddingValues r16 = (i6 & 16) != 0 ? PaddingKt.m503PaddingValues0680j_4(Dp.m4704constructorimpl((float) 0)) : paddingValues;
        boolean z3 = (i6 & 32) != 0 ? false : z;
        if ((i6 & 64) != 0) {
            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
            i4 = i & -3670017;
        } else {
            flingBehavior2 = flingBehavior;
            i4 = i;
        }
        boolean z4 = (i6 & 128) != 0 ? true : z2;
        Arrangement.Vertical top = (i6 & 256) != 0 ? Arrangement.INSTANCE.getTop() : vertical;
        Arrangement.Horizontal start = (i6 & 512) != 0 ? Arrangement.INSTANCE.getStart() : horizontal;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(845690866, i4, i5, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:39)");
        }
        OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
        LazyLayoutItemProvider rememberStaggeredGridItemProvider = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProvider(lazyStaggeredGridState2, function12, startRestartGroup, ((i5 << 3) & 112) | 8);
        int i7 = i4 >> 6;
        int i8 = i4 >> 9;
        int i9 = i8;
        LazyLayoutItemProvider lazyLayoutItemProvider = rememberStaggeredGridItemProvider;
        OverscrollEffect overscrollEffect2 = overscrollEffect;
        boolean z5 = z3;
        Modifier modifier3 = modifier2;
        Composer composer2 = startRestartGroup;
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> rememberStaggeredGridMeasurePolicy = LazyStaggeredGridMeasurePolicyKt.rememberStaggeredGridMeasurePolicy(lazyStaggeredGridState, rememberStaggeredGridItemProvider, r16, z3, orientation, top, start, function2, overscrollEffect2, startRestartGroup, (i7 & 7168) | (i7 & 896) | 8 | ((i4 << 9) & 57344) | (458752 & i8) | (3670016 & i8) | ((i4 << 15) & 29360128));
        LazyLayoutSemanticState rememberLazyStaggeredGridSemanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState2, lazyLayoutItemProvider, z5, startRestartGroup, (i9 & 896) | 8);
        ScrollPositionUpdater(lazyLayoutItemProvider, lazyStaggeredGridState2, startRestartGroup, 64);
        Modifier then = modifier3.then(lazyStaggeredGridState.getRemeasurementModifier$foundation_release());
        Modifier modifier4 = modifier3;
        Orientation orientation2 = orientation;
        OverscrollEffect overscrollEffect3 = overscrollEffect2;
        Modifier overscroll = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(then, orientation2), overscrollEffect3);
        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LazyLayoutKt.LazyLayout(lazyLayoutItemProvider, LazyLayoutSemanticsKt.lazyLayoutSemantics(ScrollableKt.scrollable(overscroll, lazyStaggeredGridState2, orientation, overscrollEffect3, z4, scrollableDefaults.reverseDirection((LayoutDirection) consume, orientation2, z5), flingBehavior2, lazyStaggeredGridState.getMutableInteractionSource$foundation_release()), lazyLayoutItemProvider, rememberLazyStaggeredGridSemanticState, orientation, z4, startRestartGroup, ((i4 << 6) & 7168) | (i9 & 57344)), lazyStaggeredGridState.getPrefetchState$foundation_release(), rememberStaggeredGridMeasurePolicy, startRestartGroup, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyStaggeredGridKt$LazyStaggeredGrid$1(lazyStaggeredGridState, orientation, function2, modifier4, r16, z5, flingBehavior2, z4, top, start, function1, i, i2, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void ScrollPositionUpdater(LazyLayoutItemProvider lazyLayoutItemProvider, LazyStaggeredGridState lazyStaggeredGridState, Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(231106410);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollPositionUpdater):LazyStaggeredGrid.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231106410, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.ScrollPositionUpdater (LazyStaggeredGrid.kt:114)");
        }
        if (lazyLayoutItemProvider.getItemCount() > 0) {
            lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyLayoutItemProvider);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyStaggeredGridKt$ScrollPositionUpdater$1(lazyLayoutItemProvider, lazyStaggeredGridState, i));
        }
    }
}
