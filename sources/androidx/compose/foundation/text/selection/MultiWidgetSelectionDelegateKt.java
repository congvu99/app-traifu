package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a-\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001ak\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"getAssembledSelectionInfo", "Landroidx/compose/foundation/text/selection/Selection;", "newSelectionRange", "Landroidx/compose/ui/text/TextRange;", "handlesCrossed", "", "selectableId", "", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getAssembledSelectionInfo-vJH6DeI", "(JZJLandroidx/compose/ui/text/TextLayoutResult;)Landroidx/compose/foundation/text/selection/Selection;", "getOffsetForPosition", "", "bounds", "Landroidx/compose/ui/geometry/Rect;", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-0AR0LA0", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/geometry/Rect;J)I", "getTextSelectionInfo", "Lkotlin/Pair;", "startHandlePosition", "endHandlePosition", "previousHandlePosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "previousSelection", "isStartHandle", "getTextSelectionInfo-yM0VcXU", "(Landroidx/compose/ui/text/TextLayoutResult;JJLandroidx/compose/ui/geometry/Offset;JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Landroidx/compose/foundation/text/selection/Selection;Z)Lkotlin/Pair;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultiWidgetSelectionDelegate.kt */
public final class MultiWidgetSelectionDelegateKt {
    /* renamed from: getTextSelectionInfo-yM0VcXU$default  reason: not valid java name */
    public static /* synthetic */ Pair m994getTextSelectionInfoyM0VcXU$default(TextLayoutResult textLayoutResult, long j, long j2, Offset offset, long j3, SelectionAdjustment selectionAdjustment, Selection selection, boolean z, int i, Object obj) {
        int i2 = i;
        return m993getTextSelectionInfoyM0VcXU(textLayoutResult, j, j2, offset, j3, selectionAdjustment, (i2 & 64) != 0 ? null : selection, (i2 & 128) != 0 ? true : z);
    }

    /* renamed from: getTextSelectionInfo-yM0VcXU  reason: not valid java name */
    public static final Pair<Selection, Boolean> m993getTextSelectionInfoyM0VcXU(TextLayoutResult textLayoutResult, long j, long j2, Offset offset, long j3, SelectionAdjustment selectionAdjustment, Selection selection, boolean z) {
        TextLayoutResult textLayoutResult2 = textLayoutResult;
        Selection selection2 = selection;
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        Rect rect = new Rect(0.0f, 0.0f, (float) IntSize.m4864getWidthimpl(textLayoutResult.m4196getSizeYbymL2g()), (float) IntSize.m4863getHeightimpl(textLayoutResult.m4196getSizeYbymL2g()));
        boolean z2 = false;
        if (!SelectionMode.Vertical.m1067isSelected2x9bVx0$foundation_release(rect, j, j2)) {
            return new Pair<>(null, false);
        }
        int r10 = m992getOffsetForPosition0AR0LA0(textLayoutResult, rect, j);
        int r11 = m992getOffsetForPosition0AR0LA0(textLayoutResult, rect, j2);
        int r12 = offset != null ? m992getOffsetForPosition0AR0LA0(textLayoutResult, rect, offset.m1693unboximpl()) : -1;
        long r0 = selectionAdjustment.m1000adjustZXO7KMw(textLayoutResult, TextRangeKt.TextRange(r10, r11), r12, z, selection2 != null ? TextRange.m4208boximpl(selection.m999toTextRanged9O1mEE()) : null);
        Selection r02 = m991getAssembledSelectionInfovJH6DeI(r0, TextRange.m4219getReversedimpl(r0), j3, textLayoutResult);
        boolean z3 = !Intrinsics.areEqual((Object) r02, (Object) selection2);
        if ((!z ? r11 != r12 : r10 != r12) || z3) {
            z2 = true;
        }
        return new Pair<>(r02, Boolean.valueOf(z2));
    }

    /* renamed from: getOffsetForPosition-0AR0LA0  reason: not valid java name */
    public static final int m992getOffsetForPosition0AR0LA0(TextLayoutResult textLayoutResult, Rect rect, long j) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(rect, "bounds");
        int length = textLayoutResult.getLayoutInput().getText().length();
        if (rect.m1709containsk4lQ0M(j)) {
            return RangesKt.coerceIn(textLayoutResult.m4195getOffsetForPositionk4lQ0M(j), 0, length);
        }
        if (SelectionMode.Vertical.m1066compare3MmeM6k$foundation_release(j, rect) < 0) {
            return 0;
        }
        return length;
    }

    /* access modifiers changed from: private */
    /* renamed from: getAssembledSelectionInfo-vJH6DeI  reason: not valid java name */
    public static final Selection m991getAssembledSelectionInfovJH6DeI(long j, boolean z, long j2, TextLayoutResult textLayoutResult) {
        return new Selection(new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(TextRange.m4220getStartimpl(j)), TextRange.m4220getStartimpl(j), j2), new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(Math.max(TextRange.m4215getEndimpl(j) - 1, 0)), TextRange.m4215getEndimpl(j), j2), z);
    }
}
