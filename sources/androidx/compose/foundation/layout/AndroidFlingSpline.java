package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline;", "", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "deceleration", "", "velocity", "", "friction", "flingPosition", "Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "time", "flingPosition-LfoxSSI", "(F)J", "FlingResult", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WindowInsetsConnection.android.kt */
final class AndroidFlingSpline {
    public static final AndroidFlingSpline INSTANCE = new AndroidFlingSpline();
    private static final int NbSamples = 100;
    private static final float[] SplinePositions = new float[101];
    private static final float[] SplineTimes = new float[101];

    private AndroidFlingSpline() {
    }

    static {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i = 0;
        while (true) {
            float f13 = 1.0f;
            if (i < 100) {
                float f14 = ((float) i) / ((float) 100);
                float f15 = 1.0f;
                while (true) {
                    f = 2.0f;
                    f2 = ((f15 - f11) / 2.0f) + f11;
                    f3 = 3.0f;
                    f4 = f13 - f2;
                    f5 = f2 * 3.0f * f4;
                    f6 = f2 * f2 * f2;
                    float f16 = (((f4 * 0.175f) + (f2 * 0.35000002f)) * f5) + f6;
                    float f17 = f15;
                    if (((double) Math.abs(f16 - f14)) < 1.0E-5d) {
                        break;
                    }
                    if (f16 > f14) {
                        f15 = f2;
                    } else {
                        f11 = f2;
                        f15 = f17;
                    }
                    f13 = 1.0f;
                }
                SplinePositions[i] = (f5 * ((f4 * 0.5f) + f2)) + f6;
                float f18 = 1.0f;
                while (true) {
                    f7 = ((f18 - f12) / f) + f12;
                    f8 = 1.0f - f7;
                    f9 = f7 * f3 * f8;
                    f10 = f7 * f7 * f7;
                    float f19 = (((f8 * 0.5f) + f7) * f9) + f10;
                    if (((double) Math.abs(f19 - f14)) < 1.0E-5d) {
                        break;
                    }
                    if (f19 > f14) {
                        f18 = f7;
                    } else {
                        f12 = f7;
                    }
                    f = 2.0f;
                    f3 = 3.0f;
                }
                SplineTimes[i] = (f9 * ((f8 * 0.175f) + (f7 * 0.35000002f))) + f10;
                i++;
            } else {
                float[] fArr = SplineTimes;
                fArr[100] = 1.0f;
                SplinePositions[100] = fArr[100];
                return;
            }
        }
    }

    /* renamed from: flingPosition-LfoxSSI  reason: not valid java name */
    public final long m397flingPositionLfoxSSI(float f) {
        float f2;
        float f3;
        float f4 = (float) 100;
        int i = (int) (f4 * f);
        if (i < 100) {
            float f5 = ((float) i) / f4;
            int i2 = i + 1;
            float f6 = ((float) i2) / f4;
            float[] fArr = SplinePositions;
            float f7 = fArr[i];
            f3 = (fArr[i2] - f7) / (f6 - f5);
            f2 = f7 + ((f - f5) * f3);
        } else {
            f2 = 1.0f;
            f3 = 0.0f;
        }
        long floatToIntBits = (long) Float.floatToIntBits(f2);
        return FlingResult.m399constructorimpl((((long) Float.floatToIntBits(f3)) & 4294967295L) | (floatToIntBits << 32));
    }

    public final double deceleration(float f, float f2) {
        return Math.log(((double) (Math.abs(f) * 0.35f)) / ((double) f2));
    }

    @JvmInline
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "", "packedValue", "", "constructor-impl", "(J)J", "distanceCoefficient", "", "getDistanceCoefficient-impl", "(J)F", "velocityCoefficient", "getVelocityCoefficient-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WindowInsetsConnection.android.kt */
    public static final class FlingResult {
        private final long packedValue;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ FlingResult m398boximpl(long j) {
            return new FlingResult(j);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static long m399constructorimpl(long j) {
            return j;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m400equalsimpl(long j, Object obj) {
            return (obj instanceof FlingResult) && j == ((FlingResult) obj).m406unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m401equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m404hashCodeimpl(long j) {
            return C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(j);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m405toStringimpl(long j) {
            return "FlingResult(packedValue=" + j + ')';
        }

        public boolean equals(Object obj) {
            return m400equalsimpl(this.packedValue, obj);
        }

        public int hashCode() {
            return m404hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m405toStringimpl(this.packedValue);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ long m406unboximpl() {
            return this.packedValue;
        }

        private /* synthetic */ FlingResult(long j) {
            this.packedValue = j;
        }

        /* renamed from: getDistanceCoefficient-impl  reason: not valid java name */
        public static final float m402getDistanceCoefficientimpl(long j) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j >> 32));
        }

        /* renamed from: getVelocityCoefficient-impl  reason: not valid java name */
        public static final float m403getVelocityCoefficientimpl(long j) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }
    }
}
