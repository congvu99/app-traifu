package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.VelocityKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u0018ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u0011R%\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "", "()V", "currentPointerPositionAccumulator", "Landroidx/compose/ui/geometry/Offset;", "getCurrentPointerPositionAccumulator-F1C5BW0$ui_release", "()J", "setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release", "(J)V", "J", "index", "", "samples", "", "Landroidx/compose/ui/input/pointer/util/PointAtTime;", "[Landroidx/compose/ui/input/pointer/util/PointAtTime;", "addPosition", "", "timeMillis", "", "position", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "calculateVelocity-9UxMQ8M", "getVelocityEstimate", "Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "resetTracking", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VelocityTracker.kt */
public final class VelocityTracker {
    public static final int $stable = 8;
    private long currentPointerPositionAccumulator;
    private int index;
    private final PointAtTime[] samples;

    public VelocityTracker() {
        PointAtTime[] pointAtTimeArr = new PointAtTime[20];
        for (int i = 0; i < 20; i++) {
            pointAtTimeArr[i] = null;
        }
        this.samples = pointAtTimeArr;
        this.currentPointerPositionAccumulator = Offset.Companion.m1699getZeroF1C5BW0();
    }

    /* renamed from: getCurrentPointerPositionAccumulator-F1C5BW0$ui_release  reason: not valid java name */
    public final long m3562getCurrentPointerPositionAccumulatorF1C5BW0$ui_release() {
        return this.currentPointerPositionAccumulator;
    }

    /* renamed from: setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release  reason: not valid java name */
    public final void m3563setCurrentPointerPositionAccumulatork4lQ0M$ui_release(long j) {
        this.currentPointerPositionAccumulator = j;
    }

    /* renamed from: addPosition-Uv8p0NA  reason: not valid java name */
    public final void m3560addPositionUv8p0NA(long j, long j2) {
        int i = (this.index + 1) % 20;
        this.index = i;
        this.samples[i] = new PointAtTime(j2, j, (DefaultConstructorMarker) null);
    }

    /* renamed from: calculateVelocity-9UxMQ8M  reason: not valid java name */
    public final long m3561calculateVelocity9UxMQ8M() {
        long r0 = getVelocityEstimate().m3559getPixelsPerSecondF1C5BW0();
        return VelocityKt.Velocity(Offset.m1683getXimpl(r0), Offset.m1684getYimpl(r0));
    }

    public final void resetTracking() {
        ArraysKt.fill$default((Object[]) this.samples, (Object) null, 0, 0, 6, (Object) null);
    }

    private final VelocityEstimate getVelocityEstimate() {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        int i = this.index;
        PointAtTime pointAtTime = this.samples[i];
        if (pointAtTime == null) {
            return VelocityEstimate.Companion.getNone();
        }
        int i2 = 0;
        PointAtTime pointAtTime2 = pointAtTime;
        while (true) {
            PointAtTime pointAtTime3 = this.samples[i];
            if (pointAtTime3 != null) {
                float time = (float) (pointAtTime.getTime() - pointAtTime3.getTime());
                float abs = (float) Math.abs(pointAtTime3.getTime() - pointAtTime2.getTime());
                if (time > 100.0f || abs > 40.0f) {
                    break;
                }
                long r11 = pointAtTime3.m3553getPointF1C5BW0();
                arrayList.add(Float.valueOf(Offset.m1683getXimpl(r11)));
                arrayList2.add(Float.valueOf(Offset.m1684getYimpl(r11)));
                arrayList3.add(Float.valueOf(-time));
                if (i == 0) {
                    i = 20;
                }
                i--;
                i2++;
                if (i2 >= 20) {
                    pointAtTime2 = pointAtTime3;
                    break;
                }
                pointAtTime2 = pointAtTime3;
            } else {
                break;
            }
        }
        if (i2 >= 3) {
            try {
                PolynomialFit polyFitLeastSquares = VelocityTrackerKt.polyFitLeastSquares(arrayList3, arrayList, 2);
                PolynomialFit polyFitLeastSquares2 = VelocityTrackerKt.polyFitLeastSquares(arrayList3, arrayList2, 2);
                float f = (float) 1000;
                return new VelocityEstimate(OffsetKt.Offset(polyFitLeastSquares.getCoefficients().get(1).floatValue() * f, polyFitLeastSquares2.getCoefficients().get(1).floatValue() * f), polyFitLeastSquares.getConfidence() * polyFitLeastSquares2.getConfidence(), pointAtTime.getTime() - pointAtTime2.getTime(), Offset.m1687minusMKHz9U(pointAtTime.m3553getPointF1C5BW0(), pointAtTime2.m3553getPointF1C5BW0()), (DefaultConstructorMarker) null);
            } catch (IllegalArgumentException unused) {
                return VelocityEstimate.Companion.getNone();
            }
        } else {
            return new VelocityEstimate(Offset.Companion.m1699getZeroF1C5BW0(), 1.0f, pointAtTime.getTime() - pointAtTime2.getTime(), Offset.m1687minusMKHz9U(pointAtTime.m3553getPointF1C5BW0(), pointAtTime2.m3553getPointF1C5BW0()), (DefaultConstructorMarker) null);
        }
    }
}
