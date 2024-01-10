package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $body;
    final /* synthetic */ Function3<Integer, Composer, Integer, Unit> $bottomSheet;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ State<Float> $sheetOffset;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ BottomSheetState $sheetState;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BottomSheetScaffold.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomSheetValue.values().length];
            iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
            iArr[BottomSheetValue.Expanded.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(State<Float> state, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i, float f, Function2<? super Composer, ? super Integer, Unit> function23, BottomSheetState bottomSheetState, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, int i2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32) {
        super(2);
        this.$sheetOffset = state;
        this.$topBar = function2;
        this.$floatingActionButton = function22;
        this.$floatingActionButtonPosition = i;
        this.$sheetPeekHeight = f;
        this.$snackbarHost = function23;
        this.$sheetState = bottomSheetState;
        this.$bottomSheet = function3;
        this.$$dirty = i2;
        this.$body = function32;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1163invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m4630unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1163invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        int i;
        int i2;
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope2, "$this$SubcomposeLayout");
        int r4 = Constraints.m4624getMaxWidthimpl(j);
        int r5 = Constraints.m4623getMaxHeightimpl(j);
        long r2 = Constraints.m4615copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        Placeable r6 = subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.Sheet, ComposableLambdaKt.composableLambdaInstance(520491296, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceable$1(this.$bottomSheet, r5, this.$$dirty))).get(0).m3649measureBRTryo0(r2);
        int roundToInt = MathKt.roundToInt(this.$sheetOffset.getValue().floatValue());
        Function2<Composer, Integer, Unit> function2 = this.$topBar;
        final Placeable r13 = function2 != null ? subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, ComposableLambdaKt.composableLambdaInstance(1988456983, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$topBarPlaceable$1$1(function2, this.$$dirty))).get(0).m3649measureBRTryo0(r2) : null;
        final int height = r13 != null ? r13.getHeight() : 0;
        Placeable placeable = r6;
        final Placeable r11 = subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.Body, ComposableLambdaKt.composableLambdaInstance(1466287989, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1(this.$body, this.$sheetPeekHeight, this.$$dirty))).get(0).m3649measureBRTryo0(Constraints.m4615copyZbe2FdA$default(r2, 0, 0, 0, r5 - height, 7, (Object) null));
        Function2<Composer, Integer, Unit> function22 = this.$floatingActionButton;
        Placeable r62 = function22 != null ? subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.Fab, function22).get(0).m3649measureBRTryo0(r2) : null;
        int width = r62 != null ? r62.getWidth() : 0;
        int height2 = r62 != null ? r62.getHeight() : 0;
        if (FabPosition.m1299equalsimpl0(this.$floatingActionButtonPosition, FabPosition.Companion.m1303getCenter5ygKITE())) {
            i = (r4 - width) / 2;
        } else {
            i = (r4 - width) - subcomposeMeasureScope2.m4643roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
        }
        final int i3 = i;
        int i4 = height2 / 2;
        int r7 = subcomposeMeasureScope2.m4649toPx0680j_4(this.$sheetPeekHeight) < ((float) i4) ? (roundToInt - height2) - subcomposeMeasureScope2.m4643roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing) : roundToInt - i4;
        final Placeable r19 = subcomposeMeasureScope2.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, this.$snackbarHost).get(0).m3649measureBRTryo0(r2);
        final int width2 = (r4 - r19.getWidth()) / 2;
        int i5 = WhenMappings.$EnumSwitchMapping$0[((BottomSheetValue) this.$sheetState.getCurrentValue()).ordinal()];
        if (i5 == 1) {
            i2 = r7 - r19.getHeight();
        } else if (i5 == 2) {
            i2 = r5 - r19.getHeight();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        final int i6 = i2;
        final Placeable placeable2 = placeable;
        final int i7 = roundToInt;
        final Placeable placeable3 = r62;
        final int i8 = r7;
        return MeasureScope.CC.layout$default(subcomposeMeasureScope2, r4, r5, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(placementScope, r11, 0, height, 0.0f, 4, (Object) null);
                Placeable placeable = r13;
                if (placeable != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, (Object) null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, 0, i7, 0.0f, 4, (Object) null);
                Placeable placeable2 = placeable3;
                if (placeable2 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i3, i8, 0.0f, 4, (Object) null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, r19, width2, i6, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
