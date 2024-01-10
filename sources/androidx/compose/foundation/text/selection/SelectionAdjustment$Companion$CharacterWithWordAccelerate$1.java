package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002J8\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002J@\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0014\u0010\u0019\u001a\u00020\n*\u00020\u00052\u0006\u0010\u001a\u001a\u00020\bH\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"androidx/compose/foundation/text/selection/SelectionAdjustment$Companion$CharacterWithWordAccelerate$1", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "adjust", "Landroidx/compose/ui/text/TextRange;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "newRawSelectionRange", "previousHandleOffset", "", "isStartHandle", "", "previousSelectionRange", "adjust-ZXO7KMw", "(Landroidx/compose/ui/text/TextLayoutResult;JIZLandroidx/compose/ui/text/TextRange;)J", "isExpanding", "newRawOffset", "previousRawOffset", "isStart", "previousReversed", "snapToWordBoundary", "currentLine", "otherBoundaryOffset", "isReversed", "updateSelectionBoundary", "previousAdjustedOffset", "isAtWordBoundary", "offset", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SelectionAdjustment.kt */
public final class SelectionAdjustment$Companion$CharacterWithWordAccelerate$1 implements SelectionAdjustment {
    private final boolean isExpanding(int i, int i2, boolean z, boolean z2) {
        if (i2 == -1) {
            return true;
        }
        if (i == i2) {
            return false;
        }
        if (z ^ z2) {
            if (i < i2) {
                return true;
            }
        } else if (i > i2) {
            return true;
        }
        return false;
    }

    SelectionAdjustment$Companion$CharacterWithWordAccelerate$1() {
    }

    /* renamed from: adjust-ZXO7KMw  reason: not valid java name */
    public long m1004adjustZXO7KMw(TextLayoutResult textLayoutResult, long j, int i, boolean z, TextRange textRange) {
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        if (textRange == null) {
            return SelectionAdjustment.Companion.$$INSTANCE.getWord().m1000adjustZXO7KMw(textLayoutResult, j, i, z, textRange);
        }
        if (TextRange.m4214getCollapsedimpl(j)) {
            return SelectionAdjustmentKt.ensureAtLeastOneChar(TextRange.m4220getStartimpl(j), StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText()), z, TextRange.m4219getReversedimpl(textRange.m4224unboximpl()));
        }
        if (z) {
            i3 = updateSelectionBoundary(textLayoutResult, TextRange.m4220getStartimpl(j), i, TextRange.m4220getStartimpl(textRange.m4224unboximpl()), TextRange.m4215getEndimpl(j), true, TextRange.m4219getReversedimpl(j));
            i2 = TextRange.m4215getEndimpl(j);
        } else {
            int r13 = TextRange.m4220getStartimpl(j);
            i2 = updateSelectionBoundary(textLayoutResult, TextRange.m4215getEndimpl(j), i, TextRange.m4215getEndimpl(textRange.m4224unboximpl()), TextRange.m4220getStartimpl(j), false, TextRange.m4219getReversedimpl(j));
            i3 = r13;
        }
        return TextRangeKt.TextRange(i3, i2);
    }

    private final int updateSelectionBoundary(TextLayoutResult textLayoutResult, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (i == i2) {
            return i3;
        }
        int lineForOffset = textLayoutResult.getLineForOffset(i);
        if (lineForOffset != textLayoutResult.getLineForOffset(i3)) {
            return snapToWordBoundary(textLayoutResult, i, lineForOffset, i4, z, z2);
        }
        if (isExpanding(i, i2, z, z2) && isAtWordBoundary(textLayoutResult, i3)) {
            return snapToWordBoundary(textLayoutResult, i, lineForOffset, i4, z, z2);
        }
        return i;
    }

    private final int snapToWordBoundary(TextLayoutResult textLayoutResult, int i, int i2, int i3, boolean z, boolean z2) {
        int i4;
        int i5;
        long r0 = textLayoutResult.m4197getWordBoundaryjx7JFs(i);
        if (textLayoutResult.getLineForOffset(TextRange.m4220getStartimpl(r0)) == i2) {
            i4 = TextRange.m4220getStartimpl(r0);
        } else {
            i4 = textLayoutResult.getLineStart(i2);
        }
        if (textLayoutResult.getLineForOffset(TextRange.m4215getEndimpl(r0)) == i2) {
            i5 = TextRange.m4215getEndimpl(r0);
        } else {
            i5 = TextLayoutResult.getLineEnd$default(textLayoutResult, i2, false, 2, (Object) null);
        }
        if (i4 == i3) {
            return i5;
        }
        if (i5 == i3) {
            return i4;
        }
        int i6 = (i4 + i5) / 2;
        if (z ^ z2) {
            if (i <= i6) {
                return i4;
            }
        } else if (i < i6) {
            return i4;
        }
        return i5;
    }

    private final boolean isAtWordBoundary(TextLayoutResult textLayoutResult, int i) {
        long r0 = textLayoutResult.m4197getWordBoundaryjx7JFs(i);
        return i == TextRange.m4220getStartimpl(r0) || i == TextRange.m4215getEndimpl(r0);
    }
}
