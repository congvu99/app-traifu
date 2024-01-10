package androidx.compose.animation.core;

import com.github.mikephil.charting.utils.Utils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000b\u001a4\u0010\f\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a<\u0010\u0012\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a4\u0010\u0014\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a4\u0010\u0015\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a9\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019H\b\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0003H\b¨\u0006\u001d"}, d2 = {"estimateAnimationDurationMillis", "", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "springConstant", "dampingCoefficient", "mass", "", "estimateCriticallyDamped", "roots", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "p0", "v0", "estimateDurationInternal", "initialPosition", "estimateOverDamped", "estimateUnderDamped", "iterateNewtonsMethod", "x", "fn", "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpringEstimation.kt */
public final class SpringEstimationKt {
    public static final long estimateAnimationDurationMillis(float f, float f2, float f3, float f4, float f5) {
        return estimateAnimationDurationMillis((double) f, (double) f2, (double) f3, (double) f4, (double) f5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5) {
        return estimateDurationInternal(ComplexDoubleKt.complexQuadraticFormula(1.0d, 2.0d * d2 * Math.sqrt(d), d), d2, d3, d4, d5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5, double d6) {
        return estimateDurationInternal(ComplexDoubleKt.complexQuadraticFormula(d3, d2, d), d2 / (Math.sqrt(d * d3) * 2.0d), d4, d5, d6);
    }

    private static final double estimateUnderDamped(Pair<ComplexDouble, ComplexDouble> pair, double d, double d2, double d3) {
        double real = pair.getFirst().getReal();
        double imaginary = (d2 - (real * d)) / pair.getFirst().getImaginary();
        return Math.log(d3 / Math.sqrt((d * d) + (imaginary * imaginary))) / real;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bd A[LOOP:0: B:35:0x00b0->B:39:0x00bd, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final double estimateCriticallyDamped(kotlin.Pair<androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble> r19, double r20, double r22, double r24) {
        /*
            r8 = r24
            java.lang.Object r0 = r19.getFirst()
            androidx.compose.animation.core.ComplexDouble r0 = (androidx.compose.animation.core.ComplexDouble) r0
            double r10 = r0.getReal()
            double r0 = r10 * r20
            double r12 = r22 - r0
            double r2 = r8 / r20
            double r2 = java.lang.Math.abs(r2)
            double r2 = java.lang.Math.log(r2)
            double r2 = r2 / r10
            double r4 = r8 / r12
            double r4 = java.lang.Math.abs(r4)
            double r4 = java.lang.Math.log(r4)
            double r4 = estimateCriticallyDamped$t2Iterate(r4, r10)
            double r4 = r4 / r10
            boolean r6 = java.lang.Double.isInfinite(r2)
            r14 = 0
            r7 = 1
            if (r6 != 0) goto L_0x003a
            boolean r6 = java.lang.Double.isNaN(r2)
            if (r6 != 0) goto L_0x003a
            r6 = 1
            goto L_0x003b
        L_0x003a:
            r6 = 0
        L_0x003b:
            r6 = r6 ^ r7
            if (r6 == 0) goto L_0x0040
            r15 = r4
            goto L_0x0058
        L_0x0040:
            boolean r6 = java.lang.Double.isInfinite(r4)
            if (r6 != 0) goto L_0x004e
            boolean r6 = java.lang.Double.isNaN(r4)
            if (r6 != 0) goto L_0x004e
            r6 = 1
            goto L_0x004f
        L_0x004e:
            r6 = 0
        L_0x004f:
            r6 = r6 ^ r7
            if (r6 == 0) goto L_0x0053
            goto L_0x0057
        L_0x0053:
            double r2 = java.lang.Math.max(r2, r4)
        L_0x0057:
            r15 = r2
        L_0x0058:
            double r0 = r0 + r12
            double r0 = -r0
            double r2 = r10 * r12
            double r4 = r0 / r2
            boolean r0 = java.lang.Double.isNaN(r4)
            if (r0 != 0) goto L_0x0091
            r17 = 0
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 > 0) goto L_0x006b
            goto L_0x0091
        L_0x006b:
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x0087
            r0 = r20
            r2 = r10
            r6 = r12
            double r0 = estimateCriticallyDamped$xInflection(r0, r2, r4, r6)
            double r0 = -r0
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0087
            int r0 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r0 >= 0) goto L_0x0091
            int r0 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x0091
            r15 = r17
            goto L_0x0091
        L_0x0087:
            r0 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r0 = r0 / r10
            double r0 = -r0
            double r2 = r20 / r12
            double r15 = r0 - r2
            r7 = r8
            goto L_0x0093
        L_0x0091:
            double r0 = -r8
            r7 = r0
        L_0x0093:
            androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fn$1 r9 = new androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fn$1
            r0 = r9
            r1 = r20
            r3 = r12
            r5 = r10
            r0.<init>(r1, r3, r5, r7)
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fnPrime$1 r7 = new androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fnPrime$1
            r0 = r7
            r1 = r12
            r3 = r10
            r5 = r20
            r0.<init>(r1, r3, r5)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r0 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
        L_0x00b0:
            r2 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x00e6
            r0 = 100
            if (r14 >= r0) goto L_0x00e6
            int r14 = r14 + 1
            java.lang.Double r0 = java.lang.Double.valueOf(r15)
            java.lang.Object r0 = r9.invoke(r0)
            java.lang.Number r0 = (java.lang.Number) r0
            double r0 = r0.doubleValue()
            java.lang.Double r2 = java.lang.Double.valueOf(r15)
            java.lang.Object r2 = r7.invoke(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            double r2 = r2.doubleValue()
            double r0 = r0 / r2
            double r0 = r15 - r0
            double r15 = r15 - r0
            double r2 = java.lang.Math.abs(r15)
            r15 = r0
            r0 = r2
            goto L_0x00b0
        L_0x00e6:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateCriticallyDamped(kotlin.Pair, double, double, double):double");
    }

    private static final double estimateCriticallyDamped$t2Iterate(double d, double d2) {
        int i = 0;
        double d3 = d;
        while (i < 6) {
            i++;
            d3 = d - Math.log(Math.abs(d3 / d2));
        }
        return d3;
    }

    private static final double estimateCriticallyDamped$xInflection(double d, double d2, double d3, double d4) {
        double d5 = d2 * d3;
        return (d * Math.exp(d5)) + (d4 * d3 * Math.exp(d5));
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ec A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final double estimateOverDamped(kotlin.Pair<androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble> r31, double r32, double r34, double r36) {
        /*
            r0 = r36
            java.lang.Object r2 = r31.getFirst()
            androidx.compose.animation.core.ComplexDouble r2 = (androidx.compose.animation.core.ComplexDouble) r2
            double r14 = r2.getReal()
            java.lang.Object r2 = r31.getSecond()
            androidx.compose.animation.core.ComplexDouble r2 = (androidx.compose.animation.core.ComplexDouble) r2
            double r16 = r2.getReal()
            double r2 = r14 * r32
            double r2 = r2 - r34
            double r18 = r14 - r16
            double r11 = r2 / r18
            double r20 = r32 - r11
            double r2 = r0 / r20
            double r2 = java.lang.Math.abs(r2)
            double r2 = java.lang.Math.log(r2)
            double r2 = r2 / r14
            double r4 = r0 / r11
            double r4 = java.lang.Math.abs(r4)
            double r4 = java.lang.Math.log(r4)
            double r4 = r4 / r16
            boolean r6 = java.lang.Double.isInfinite(r2)
            r22 = 0
            r7 = 1
            if (r6 != 0) goto L_0x0048
            boolean r6 = java.lang.Double.isNaN(r2)
            if (r6 != 0) goto L_0x0048
            r6 = 1
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            r6 = r6 ^ r7
            if (r6 == 0) goto L_0x004f
            r23 = r4
            goto L_0x0068
        L_0x004f:
            boolean r6 = java.lang.Double.isInfinite(r4)
            if (r6 != 0) goto L_0x005d
            boolean r6 = java.lang.Double.isNaN(r4)
            if (r6 != 0) goto L_0x005d
            r6 = 1
            goto L_0x005e
        L_0x005d:
            r6 = 0
        L_0x005e:
            r6 = r6 ^ r7
            if (r6 == 0) goto L_0x0062
            goto L_0x0066
        L_0x0062:
            double r2 = java.lang.Math.max(r2, r4)
        L_0x0066:
            r23 = r2
        L_0x0068:
            double r25 = r20 * r14
            double r2 = -r11
            double r2 = r2 * r16
            double r2 = r25 / r2
            double r2 = java.lang.Math.log(r2)
            double r4 = r16 - r14
            double r7 = r2 / r4
            boolean r2 = java.lang.Double.isNaN(r7)
            if (r2 != 0) goto L_0x00b6
            r27 = 0
            int r2 = (r7 > r27 ? 1 : (r7 == r27 ? 0 : -1))
            if (r2 > 0) goto L_0x0084
            goto L_0x00b6
        L_0x0084:
            int r2 = (r7 > r27 ? 1 : (r7 == r27 ? 0 : -1))
            if (r2 <= 0) goto L_0x00a4
            r3 = r20
            r5 = r14
            r9 = r11
            r29 = r11
            r11 = r16
            double r2 = m126estimateOverDamped$xInflection0(r3, r5, r7, r9, r11)
            double r2 = -r2
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x00a6
            int r2 = (r29 > r27 ? 1 : (r29 == r27 ? 0 : -1))
            if (r2 <= 0) goto L_0x00b8
            int r2 = (r20 > r27 ? 1 : (r20 == r27 ? 0 : -1))
            if (r2 >= 0) goto L_0x00b8
            r23 = r27
            goto L_0x00b8
        L_0x00a4:
            r29 = r11
        L_0x00a6:
            double r11 = r29 * r16
            double r11 = r11 * r16
            double r2 = -r11
            double r25 = r25 * r14
            double r2 = r2 / r25
            double r2 = java.lang.Math.log(r2)
            double r23 = r2 / r18
            goto L_0x00b9
        L_0x00b6:
            r29 = r11
        L_0x00b8:
            double r0 = -r0
        L_0x00b9:
            r12 = r0
            androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fn$1 r0 = new androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fn$1
            r3 = r0
            r4 = r20
            r6 = r14
            r8 = r29
            r10 = r16
            r3.<init>(r4, r6, r8, r10, r12)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fnPrime$1 r1 = new androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fnPrime$1
            r3 = r1
            r3.<init>(r4, r6, r8, r10)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.lang.Double r2 = java.lang.Double.valueOf(r23)
            java.lang.Object r2 = r0.invoke(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            double r2 = r2.doubleValue()
            double r2 = java.lang.Math.abs(r2)
            r4 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x00ed
            return r23
        L_0x00ed:
            r2 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r4 = 0
        L_0x00f3:
            r5 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x012b
            r2 = 100
            if (r4 >= r2) goto L_0x012b
            int r4 = r4 + 1
            java.lang.Double r2 = java.lang.Double.valueOf(r23)
            java.lang.Object r2 = r0.invoke(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            double r2 = r2.doubleValue()
            java.lang.Double r5 = java.lang.Double.valueOf(r23)
            java.lang.Object r5 = r1.invoke(r5)
            java.lang.Number r5 = (java.lang.Number) r5
            double r5 = r5.doubleValue()
            double r2 = r2 / r5
            double r2 = r23 - r2
            double r23 = r23 - r2
            double r5 = java.lang.Math.abs(r23)
            r23 = r2
            r2 = r5
            goto L_0x00f3
        L_0x012b:
            return r23
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateOverDamped(kotlin.Pair, double, double, double):double");
    }

    /* renamed from: estimateOverDamped$xInflection-0  reason: not valid java name */
    private static final double m126estimateOverDamped$xInflection0(double d, double d2, double d3, double d4, double d5) {
        return (d * Math.exp(d2 * d3)) + (d4 * Math.exp(d5 * d3));
    }

    private static final long estimateDurationInternal(Pair<ComplexDouble, ComplexDouble> pair, double d, double d2, double d3, double d4) {
        double d5;
        boolean z = true;
        int i = (d3 > Utils.DOUBLE_EPSILON ? 1 : (d3 == Utils.DOUBLE_EPSILON ? 0 : -1));
        if (i == 0) {
            if (d2 != Utils.DOUBLE_EPSILON) {
                z = false;
            }
            if (z) {
                return 0;
            }
        }
        if (i < 0) {
            d2 = -d2;
        }
        double d6 = d2;
        double abs = Math.abs(d3);
        if (d > 1.0d) {
            d5 = estimateOverDamped(pair, abs, d6, d4);
        } else if (d < 1.0d) {
            d5 = estimateUnderDamped(pair, abs, d6, d4);
        } else {
            d5 = estimateCriticallyDamped(pair, abs, d6, d4);
        }
        return (long) (d5 * 1000.0d);
    }

    private static final double iterateNewtonsMethod(double d, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12) {
        return d - (function1.invoke(Double.valueOf(d)).doubleValue() / function12.invoke(Double.valueOf(d)).doubleValue());
    }

    private static final boolean isNotFinite(double d) {
        return !(!Double.isInfinite(d) && !Double.isNaN(d));
    }
}
