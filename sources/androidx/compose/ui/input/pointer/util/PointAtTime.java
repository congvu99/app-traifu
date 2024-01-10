package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\bJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J*\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/input/pointer/util/PointAtTime;", "", "point", "Landroidx/compose/ui/geometry/Offset;", "time", "", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPoint-F1C5BW0", "()J", "J", "getTime", "component1", "component1-F1C5BW0", "component2", "copy", "copy-3MmeM6k", "(JJ)Landroidx/compose/ui/input/pointer/util/PointAtTime;", "equals", "", "other", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VelocityTracker.kt */
final class PointAtTime {
    private final long point;
    private final long time;

    public /* synthetic */ PointAtTime(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    /* renamed from: copy-3MmeM6k$default  reason: not valid java name */
    public static /* synthetic */ PointAtTime m3550copy3MmeM6k$default(PointAtTime pointAtTime, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = pointAtTime.point;
        }
        if ((i & 2) != 0) {
            j2 = pointAtTime.time;
        }
        return pointAtTime.m3552copy3MmeM6k(j, j2);
    }

    /* renamed from: component1-F1C5BW0  reason: not valid java name */
    public final long m3551component1F1C5BW0() {
        return this.point;
    }

    public final long component2() {
        return this.time;
    }

    /* renamed from: copy-3MmeM6k  reason: not valid java name */
    public final PointAtTime m3552copy3MmeM6k(long j, long j2) {
        return new PointAtTime(j, j2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointAtTime)) {
            return false;
        }
        PointAtTime pointAtTime = (PointAtTime) obj;
        return Offset.m1680equalsimpl0(this.point, pointAtTime.point) && this.time == pointAtTime.time;
    }

    public int hashCode() {
        return (Offset.m1685hashCodeimpl(this.point) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.time);
    }

    public String toString() {
        return "PointAtTime(point=" + Offset.m1691toStringimpl(this.point) + ", time=" + this.time + ')';
    }

    private PointAtTime(long j, long j2) {
        this.point = j;
        this.time = j2;
    }

    /* renamed from: getPoint-F1C5BW0  reason: not valid java name */
    public final long m3553getPointF1C5BW0() {
        return this.point;
    }

    public final long getTime() {
        return this.time;
    }
}
