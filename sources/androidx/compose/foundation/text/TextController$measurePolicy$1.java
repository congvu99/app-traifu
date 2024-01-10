package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\t\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016J/\u0010\u000b\u001a\u00020\f*\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"androidx/compose/foundation/text/TextController$measurePolicy$1", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoreText.kt */
public final class TextController$measurePolicy$1 implements MeasurePolicy {
    final /* synthetic */ TextController this$0;

    TextController$measurePolicy$1(TextController textController) {
        this.this$0 = textController;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m925measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        Pair pair;
        SelectionRegistrar access$getSelectionRegistrar$p;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$measure");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        TextLayoutResult layoutResult = this.this$0.getState().getLayoutResult();
        TextLayoutResult r4 = this.this$0.getState().getTextDelegate().m936layoutNN6EwU(j, measureScope.getLayoutDirection(), layoutResult);
        if (!Intrinsics.areEqual((Object) layoutResult, (Object) r4)) {
            this.this$0.getState().getOnTextLayout().invoke(r4);
            if (layoutResult != null) {
                TextController textController = this.this$0;
                if (!Intrinsics.areEqual((Object) layoutResult.getLayoutInput().getText(), (Object) r4.getLayoutInput().getText()) && (access$getSelectionRegistrar$p = textController.selectionRegistrar) != null) {
                    access$getSelectionRegistrar$p.notifySelectableChange(textController.getState().getSelectableId());
                }
            }
        }
        this.this$0.getState().setLayoutResult(r4);
        if (list.size() >= r4.getPlaceholderRects().size()) {
            List<Rect> placeholderRects = r4.getPlaceholderRects();
            ArrayList arrayList = new ArrayList(placeholderRects.size());
            int size = placeholderRects.size();
            int i2 = 0;
            while (i2 < size) {
                Rect rect = placeholderRects.get(i2);
                if (rect != null) {
                    i = size;
                    pair = new Pair(((Measurable) list2.get(i2)).m3649measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) ((float) Math.floor((double) rect.getWidth())), 0, (int) ((float) Math.floor((double) rect.getHeight())), 5, (Object) null)), IntOffset.m4813boximpl(IntOffsetKt.IntOffset(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()))));
                } else {
                    i = size;
                    pair = null;
                }
                if (pair != null) {
                    arrayList.add(pair);
                }
                i2++;
                size = i;
            }
            return measureScope2.layout(IntSize.m4864getWidthimpl(r4.m4196getSizeYbymL2g()), IntSize.m4863getHeightimpl(r4.m4196getSizeYbymL2g()), MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(r4.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(r4.getLastBaseline())))), new TextController$measurePolicy$1$measure$2(arrayList));
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        this.this$0.getState().getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
        return this.this$0.getState().getTextDelegate().getMinIntrinsicWidth();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return IntSize.m4863getHeightimpl(TextDelegate.m933layoutNN6EwU$default(this.this$0.getState().getTextDelegate(), ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE), intrinsicMeasureScope.getLayoutDirection(), (TextLayoutResult) null, 4, (Object) null).m4196getSizeYbymL2g());
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        this.this$0.getState().getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
        return this.this$0.getState().getTextDelegate().getMaxIntrinsicWidth();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return IntSize.m4863getHeightimpl(TextDelegate.m933layoutNN6EwU$default(this.this$0.getState().getTextDelegate(), ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE), intrinsicMeasureScope.getLayoutDirection(), (TextLayoutResult) null, 4, (Object) null).m4196getSizeYbymL2g());
    }
}
