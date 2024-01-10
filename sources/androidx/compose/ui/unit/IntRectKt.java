package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0006\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"IntRect", "Landroidx/compose/ui/unit/IntRect;", "topLeft", "Landroidx/compose/ui/unit/IntOffset;", "bottomRight", "IntRect-E1MhUcY", "(JJ)Landroidx/compose/ui/unit/IntRect;", "offset", "size", "Landroidx/compose/ui/unit/IntSize;", "IntRect-VbeCjmY", "center", "radius", "", "IntRect-ar5cAso", "(JI)Landroidx/compose/ui/unit/IntRect;", "lerp", "start", "stop", "fraction", "", "ui-unit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntRect.kt */
public final class IntRectKt {
    /* renamed from: IntRect-VbeCjmY  reason: not valid java name */
    public static final IntRect m4854IntRectVbeCjmY(long j, long j2) {
        return new IntRect(IntOffset.m4822getXimpl(j), IntOffset.m4823getYimpl(j), IntOffset.m4822getXimpl(j) + IntSize.m4864getWidthimpl(j2), IntOffset.m4823getYimpl(j) + IntSize.m4863getHeightimpl(j2));
    }

    /* renamed from: IntRect-E1MhUcY  reason: not valid java name */
    public static final IntRect m4853IntRectE1MhUcY(long j, long j2) {
        return new IntRect(IntOffset.m4822getXimpl(j), IntOffset.m4823getYimpl(j), IntOffset.m4822getXimpl(j2), IntOffset.m4823getYimpl(j2));
    }

    /* renamed from: IntRect-ar5cAso  reason: not valid java name */
    public static final IntRect m4855IntRectar5cAso(long j, int i) {
        return new IntRect(IntOffset.m4822getXimpl(j) - i, IntOffset.m4823getYimpl(j) - i, IntOffset.m4822getXimpl(j) + i, IntOffset.m4823getYimpl(j) + i);
    }

    public static final IntRect lerp(IntRect intRect, IntRect intRect2, float f) {
        Intrinsics.checkNotNullParameter(intRect, "start");
        Intrinsics.checkNotNullParameter(intRect2, "stop");
        return new IntRect(MathHelpersKt.lerp(intRect.getLeft(), intRect2.getLeft(), f), MathHelpersKt.lerp(intRect.getTop(), intRect2.getTop(), f), MathHelpersKt.lerp(intRect.getRight(), intRect2.getRight(), f), MathHelpersKt.lerp(intRect.getBottom(), intRect2.getBottom(), f));
    }
}
