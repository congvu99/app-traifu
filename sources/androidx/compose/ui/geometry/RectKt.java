package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0006\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\rH\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Rect", "Landroidx/compose/ui/geometry/Rect;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "bottomRight", "Rect-0a9Yr6o", "(JJ)Landroidx/compose/ui/geometry/Rect;", "offset", "size", "Landroidx/compose/ui/geometry/Size;", "Rect-tz77jQw", "center", "radius", "", "Rect-3MmeM6k", "(JF)Landroidx/compose/ui/geometry/Rect;", "lerp", "start", "stop", "fraction", "ui-geometry_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Rect.kt */
public final class RectKt {
    /* renamed from: Rect-tz77jQw  reason: not valid java name */
    public static final Rect m1723Recttz77jQw(long j, long j2) {
        return new Rect(Offset.m1683getXimpl(j), Offset.m1684getYimpl(j), Offset.m1683getXimpl(j) + Size.m1752getWidthimpl(j2), Offset.m1684getYimpl(j) + Size.m1749getHeightimpl(j2));
    }

    /* renamed from: Rect-0a9Yr6o  reason: not valid java name */
    public static final Rect m1721Rect0a9Yr6o(long j, long j2) {
        return new Rect(Offset.m1683getXimpl(j), Offset.m1684getYimpl(j), Offset.m1683getXimpl(j2), Offset.m1684getYimpl(j2));
    }

    /* renamed from: Rect-3MmeM6k  reason: not valid java name */
    public static final Rect m1722Rect3MmeM6k(long j, float f) {
        return new Rect(Offset.m1683getXimpl(j) - f, Offset.m1684getYimpl(j) - f, Offset.m1683getXimpl(j) + f, Offset.m1684getYimpl(j) + f);
    }

    public static final Rect lerp(Rect rect, Rect rect2, float f) {
        Intrinsics.checkNotNullParameter(rect, "start");
        Intrinsics.checkNotNullParameter(rect2, "stop");
        return new Rect(MathHelpersKt.lerp(rect.getLeft(), rect2.getLeft(), f), MathHelpersKt.lerp(rect.getTop(), rect2.getTop(), f), MathHelpersKt.lerp(rect.getRight(), rect2.getRight(), f), MathHelpersKt.lerp(rect.getBottom(), rect2.getBottom(), f));
    }
}
