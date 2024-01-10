package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"AssumePointerMoveStoppedMilliseconds", "", "DefaultWeight", "", "HistorySize", "HorizonMilliseconds", "MinSampleSize", "polyFitLeastSquares", "Landroidx/compose/ui/input/pointer/util/PolynomialFit;", "x", "", "y", "degree", "addPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: VelocityTracker.kt */
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;
    private static final int MinSampleSize = 3;

    public static final void addPointerInputChange(VelocityTracker velocityTracker, PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(velocityTracker, "<this>");
        Intrinsics.checkNotNullParameter(pointerInputChange, NotificationCompat.CATEGORY_EVENT);
        if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
            velocityTracker.m3563setCurrentPointerPositionAccumulatork4lQ0M$ui_release(pointerInputChange.m3429getPositionF1C5BW0());
            velocityTracker.resetTracking();
        }
        long r0 = pointerInputChange.m3430getPreviousPositionF1C5BW0();
        List<HistoricalChange> historical = pointerInputChange.getHistorical();
        int i = 0;
        int size = historical.size();
        while (i < size) {
            HistoricalChange historicalChange = historical.get(i);
            long r02 = Offset.m1687minusMKHz9U(historicalChange.m3359getPositionF1C5BW0(), r0);
            long r6 = historicalChange.m3359getPositionF1C5BW0();
            velocityTracker.m3563setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m1688plusMKHz9U(velocityTracker.m3562getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), r02));
            velocityTracker.m3560addPositionUv8p0NA(historicalChange.getUptimeMillis(), velocityTracker.m3562getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
            i++;
            r0 = r6;
        }
        velocityTracker.m3563setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m1688plusMKHz9U(velocityTracker.m3562getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), Offset.m1687minusMKHz9U(pointerInputChange.m3429getPositionF1C5BW0(), r0)));
        velocityTracker.m3560addPositionUv8p0NA(pointerInputChange.getUptimeMillis(), velocityTracker.m3562getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
    }

    public static final PolynomialFit polyFitLeastSquares(List<Float> list, List<Float> list2, int i) {
        float f;
        float f2;
        float f3;
        List<Float> list3 = list;
        List<Float> list4 = list2;
        int i2 = i;
        Intrinsics.checkNotNullParameter(list3, "x");
        Intrinsics.checkNotNullParameter(list4, "y");
        if (i2 < 1) {
            throw new IllegalArgumentException("The degree must be at positive integer");
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("x and y must be the same length");
        } else if (!list.isEmpty()) {
            int size = i2 >= list.size() ? list.size() - 1 : i2;
            int i3 = i2 + 1;
            ArrayList arrayList = new ArrayList(i3);
            int i4 = 0;
            while (true) {
                f = 0.0f;
                if (i4 >= i3) {
                    break;
                }
                arrayList.add(Float.valueOf(0.0f));
                i4++;
            }
            List list5 = arrayList;
            int size2 = list.size();
            int i5 = size + 1;
            Matrix matrix = new Matrix(i5, size2);
            int i6 = 0;
            while (true) {
                f2 = 1.0f;
                if (i6 >= size2) {
                    break;
                }
                matrix.set(0, i6, 1.0f);
                for (int i7 = 1; i7 < i5; i7++) {
                    matrix.set(i7, i6, matrix.get(i7 - 1, i6) * list3.get(i6).floatValue());
                }
                i6++;
            }
            Matrix matrix2 = new Matrix(i5, size2);
            Matrix matrix3 = new Matrix(i5, i5);
            int i8 = 0;
            while (i8 < i5) {
                for (int i9 = 0; i9 < size2; i9++) {
                    matrix2.set(i8, i9, matrix.get(i8, i9));
                }
                for (int i10 = 0; i10 < i8; i10++) {
                    float times = matrix2.getRow(i8).times(matrix2.getRow(i10));
                    for (int i11 = 0; i11 < size2; i11++) {
                        matrix2.set(i8, i11, matrix2.get(i8, i11) - (matrix2.get(i10, i11) * times));
                    }
                }
                float norm = matrix2.getRow(i8).norm();
                if (((double) norm) >= 1.0E-6d) {
                    float f4 = 1.0f / norm;
                    for (int i12 = 0; i12 < size2; i12++) {
                        matrix2.set(i8, i12, matrix2.get(i8, i12) * f4);
                    }
                    for (int i13 = 0; i13 < i5; i13++) {
                        if (i13 < i8) {
                            f3 = 0.0f;
                        } else {
                            f3 = matrix2.getRow(i8).times(matrix.getRow(i13));
                        }
                        matrix3.set(i8, i13, f3);
                    }
                    i8++;
                } else {
                    throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
                }
            }
            Vector vector = new Vector(size2);
            for (int i14 = 0; i14 < size2; i14++) {
                vector.set(i14, list4.get(i14).floatValue() * 1.0f);
            }
            int i15 = i5 - 1;
            for (int i16 = i15; -1 < i16; i16--) {
                list5.set(i16, Float.valueOf(matrix2.getRow(i16).times(vector)));
                int i17 = i16 + 1;
                if (i17 <= i15) {
                    int i18 = i15;
                    while (true) {
                        list5.set(i16, Float.valueOf(((Number) list5.get(i16)).floatValue() - (matrix3.get(i16, i18) * ((Number) list5.get(i18)).floatValue())));
                        if (i18 == i17) {
                            break;
                        }
                        i18--;
                    }
                }
                list5.set(i16, Float.valueOf(((Number) list5.get(i16)).floatValue() / matrix3.get(i16, i16)));
            }
            float f5 = 0.0f;
            for (int i19 = 0; i19 < size2; i19++) {
                f5 += list4.get(i19).floatValue();
            }
            float f6 = f5 / ((float) size2);
            float f7 = 0.0f;
            for (int i20 = 0; i20 < size2; i20++) {
                float floatValue = list4.get(i20).floatValue() - ((Number) list5.get(0)).floatValue();
                float f8 = 1.0f;
                for (int i21 = 1; i21 < i5; i21++) {
                    f8 *= list3.get(i20).floatValue();
                    floatValue -= ((Number) list5.get(i21)).floatValue() * f8;
                }
                f7 += floatValue * 1.0f * floatValue;
                float floatValue2 = list4.get(i20).floatValue() - f6;
                f += floatValue2 * 1.0f * floatValue2;
            }
            if (f > 1.0E-6f) {
                f2 = 1.0f - (f7 / f);
            }
            return new PolynomialFit(list5, f2);
        } else {
            throw new IllegalArgumentException("At least one point must be provided");
        }
    }
}
