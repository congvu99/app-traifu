package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aU\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2C\b\u0002\u0010\t\u001a=\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0007\u001a\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014\u001a_\u0010\u0015\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182A\u0010\t\u001a=\u0012\u0004\u0012\u00020\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\u0011H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0019"}, d2 = {"singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "positionInLayout", "Lkotlin/Function3;", "Landroidx/compose/ui/unit/Density;", "", "Lkotlin/ParameterName;", "name", "layoutSize", "itemSize", "Lkotlin/ExtensionFunctionType;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/FlingBehavior;", "calculateDistanceToDesiredSnapPosition", "layoutInfo", "item", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyListSnapLayoutInfoProvider.kt */
public final class LazyListSnapLayoutInfoProviderKt {
    public static /* synthetic */ SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyListState lazyListState, Function3 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1.INSTANCE;
        }
        return SnapLayoutInfoProvider(lazyListState, function3);
    }

    @ExperimentalFoundationApi
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(LazyListState lazyListState, Function3<? super Density, ? super Float, ? super Float, Float> function3) {
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(function3, "positionInLayout");
        return new LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$2(lazyListState, function3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.foundation.ExperimentalFoundationApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.gestures.FlingBehavior rememberSnapFlingBehavior(androidx.compose.foundation.lazy.LazyListState r7, androidx.compose.runtime.Composer r8, int r9) {
        /*
            java.lang.String r0 = "lazyListState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1148456277(0x44740d55, float:976.2083)
            r8.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberSnapFlingBehavior)94@3659L65,95@3736L41:LazyListSnapLayoutInfoProvider.kt#ppz6w6"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x001c
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (LazyListSnapLayoutInfoProvider.kt:93)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r1, r2)
        L_0x001c:
            r9 = 1157296644(0x44faf204, float:2007.563)
            r8.startReplaceableGroup(r9)
            java.lang.String r9 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r9)
            boolean r9 = r8.changed((java.lang.Object) r7)
            java.lang.Object r0 = r8.rememberedValue()
            if (r9 != 0) goto L_0x0039
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r0 != r9) goto L_0x0042
        L_0x0039:
            r9 = 2
            r0 = 0
            androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r0 = SnapLayoutInfoProvider$default(r7, r0, r9, r0)
            r8.updateRememberedValue(r0)
        L_0x0042:
            r8.endReplaceableGroup()
            r1 = r0
            androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r1 = (androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider) r1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 6
            r4 = r8
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r7 = androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.rememberSnapFlingBehavior(r1, r2, r3, r4, r5, r6)
            boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r9 == 0) goto L_0x005a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x005a:
            r8.endReplaceableGroup()
            androidx.compose.foundation.gestures.FlingBehavior r7 = (androidx.compose.foundation.gestures.FlingBehavior) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt.rememberSnapFlingBehavior(androidx.compose.foundation.lazy.LazyListState, androidx.compose.runtime.Composer, int):androidx.compose.foundation.gestures.FlingBehavior");
    }

    public static final float calculateDistanceToDesiredSnapPosition(Density density, LazyListLayoutInfo lazyListLayoutInfo, LazyListItemInfo lazyListItemInfo, Function3<? super Density, ? super Float, ? super Float, Float> function3) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(lazyListLayoutInfo, "layoutInfo");
        Intrinsics.checkNotNullParameter(lazyListItemInfo, "item");
        Intrinsics.checkNotNullParameter(function3, "positionInLayout");
        return ((float) lazyListItemInfo.getOffset()) - function3.invoke(density, Float.valueOf((float) ((getSingleAxisViewportSize(lazyListLayoutInfo) - lazyListLayoutInfo.getBeforeContentPadding()) - lazyListLayoutInfo.getAfterContentPadding())), Float.valueOf((float) lazyListItemInfo.getSize())).floatValue();
    }

    private static final int getSingleAxisViewportSize(LazyListLayoutInfo lazyListLayoutInfo) {
        return lazyListLayoutInfo.getOrientation() == Orientation.Vertical ? IntSize.m4863getHeightimpl(lazyListLayoutInfo.m660getViewportSizeYbymL2g()) : IntSize.m4864getWidthimpl(lazyListLayoutInfo.m660getViewportSizeYbymL2g());
    }
}
