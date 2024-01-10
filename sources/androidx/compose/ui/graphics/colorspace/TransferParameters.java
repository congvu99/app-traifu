package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\""}, d2 = {"Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "", "gamma", "", "a", "b", "c", "d", "e", "f", "(DDDDDDD)V", "getA", "()D", "getB", "getC", "getD", "getE", "getF", "getGamma", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TransferParameters.kt */
public final class TransferParameters {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double gamma;

    public static /* synthetic */ TransferParameters copy$default(TransferParameters transferParameters, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, Object obj) {
        TransferParameters transferParameters2 = transferParameters;
        return transferParameters.copy((i & 1) != 0 ? transferParameters2.gamma : d2, (i & 2) != 0 ? transferParameters2.a : d3, (i & 4) != 0 ? transferParameters2.b : d4, (i & 8) != 0 ? transferParameters2.c : d5, (i & 16) != 0 ? transferParameters2.d : d6, (i & 32) != 0 ? transferParameters2.e : d7, (i & 64) != 0 ? transferParameters2.f : d8);
    }

    public final double component1() {
        return this.gamma;
    }

    public final double component2() {
        return this.a;
    }

    public final double component3() {
        return this.b;
    }

    public final double component4() {
        return this.c;
    }

    public final double component5() {
        return this.d;
    }

    public final double component6() {
        return this.e;
    }

    public final double component7() {
        return this.f;
    }

    public final TransferParameters copy(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return new TransferParameters(d2, d3, d4, d5, d6, d7, d8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransferParameters)) {
            return false;
        }
        TransferParameters transferParameters = (TransferParameters) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.gamma), (Object) Double.valueOf(transferParameters.gamma)) && Intrinsics.areEqual((Object) Double.valueOf(this.a), (Object) Double.valueOf(transferParameters.a)) && Intrinsics.areEqual((Object) Double.valueOf(this.b), (Object) Double.valueOf(transferParameters.b)) && Intrinsics.areEqual((Object) Double.valueOf(this.c), (Object) Double.valueOf(transferParameters.c)) && Intrinsics.areEqual((Object) Double.valueOf(this.d), (Object) Double.valueOf(transferParameters.d)) && Intrinsics.areEqual((Object) Double.valueOf(this.e), (Object) Double.valueOf(transferParameters.e)) && Intrinsics.areEqual((Object) Double.valueOf(this.f), (Object) Double.valueOf(transferParameters.f));
    }

    public int hashCode() {
        return (((((((((((Double.doubleToLongBits(this.gamma) * 31) + Double.doubleToLongBits(this.a)) * 31) + Double.doubleToLongBits(this.b)) * 31) + Double.doubleToLongBits(this.c)) * 31) + Double.doubleToLongBits(this.d)) * 31) + Double.doubleToLongBits(this.e)) * 31) + Double.doubleToLongBits(this.f);
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.gamma + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + this.f + ')';
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0074, code lost:
        if ((r0.gamma == com.github.mikephil.charting.utils.Utils.DOUBLE_EPSILON) == false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ad, code lost:
        if ((r0.gamma == com.github.mikephil.charting.utils.Utils.DOUBLE_EPSILON) != false) goto L_0x00af;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TransferParameters(double r1, double r3, double r5, double r7, double r9, double r11, double r13) {
        /*
            r0 = this;
            r0.<init>()
            r0.gamma = r1
            r0.a = r3
            r0.b = r5
            r0.c = r7
            r0.d = r9
            r0.e = r11
            r0.f = r13
            boolean r1 = java.lang.Double.isNaN(r3)
            if (r1 != 0) goto L_0x00fd
            double r1 = r0.b
            boolean r1 = java.lang.Double.isNaN(r1)
            if (r1 != 0) goto L_0x00fd
            double r1 = r0.c
            boolean r1 = java.lang.Double.isNaN(r1)
            if (r1 != 0) goto L_0x00fd
            double r1 = r0.d
            boolean r1 = java.lang.Double.isNaN(r1)
            if (r1 != 0) goto L_0x00fd
            double r1 = r0.e
            boolean r1 = java.lang.Double.isNaN(r1)
            if (r1 != 0) goto L_0x00fd
            double r1 = r0.f
            boolean r1 = java.lang.Double.isNaN(r1)
            if (r1 != 0) goto L_0x00fd
            double r1 = r0.gamma
            boolean r1 = java.lang.Double.isNaN(r1)
            if (r1 != 0) goto L_0x00fd
            double r1 = r0.d
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x00e4
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x00e4
            r7 = 1
            r8 = 0
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x005d
            r1 = 1
            goto L_0x005e
        L_0x005d:
            r1 = 0
        L_0x005e:
            if (r1 == 0) goto L_0x007f
            double r1 = r0.a
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x0068
            r1 = 1
            goto L_0x0069
        L_0x0068:
            r1 = 0
        L_0x0069:
            if (r1 != 0) goto L_0x0077
            double r1 = r0.gamma
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x0073
            r1 = 1
            goto L_0x0074
        L_0x0073:
            r1 = 0
        L_0x0074:
            if (r1 != 0) goto L_0x0077
            goto L_0x007f
        L_0x0077:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Parameter a or g is zero, the transfer function is constant"
            r1.<init>(r2)
            throw r1
        L_0x007f:
            double r1 = r0.d
            int r9 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r9 < 0) goto L_0x0099
            double r1 = r0.c
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x008d
            r1 = 1
            goto L_0x008e
        L_0x008d:
            r1 = 0
        L_0x008e:
            if (r1 != 0) goto L_0x0091
            goto L_0x0099
        L_0x0091:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Parameter c is zero, the transfer function is constant"
            r1.<init>(r2)
            throw r1
        L_0x0099:
            double r1 = r0.a
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x00a1
            r1 = 1
            goto L_0x00a2
        L_0x00a1:
            r1 = 0
        L_0x00a2:
            if (r1 != 0) goto L_0x00af
            double r1 = r0.gamma
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x00ac
            r1 = 1
            goto L_0x00ad
        L_0x00ac:
            r1 = 0
        L_0x00ad:
            if (r1 == 0) goto L_0x00b9
        L_0x00af:
            double r1 = r0.c
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x00b6
            goto L_0x00b7
        L_0x00b6:
            r7 = 0
        L_0x00b7:
            if (r7 != 0) goto L_0x00dc
        L_0x00b9:
            double r1 = r0.c
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x00d4
            double r1 = r0.a
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x00cc
            double r1 = r0.gamma
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x00cc
            return
        L_0x00cc:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "The transfer function must be positive or increasing"
            r1.<init>(r2)
            throw r1
        L_0x00d4:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "The transfer function must be increasing"
            r1.<init>(r2)
            throw r1
        L_0x00dc:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Parameter a or g is zero, and c is zero, the transfer function is constant"
            r1.<init>(r2)
            throw r1
        L_0x00e4:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Parameter d must be in the range [0..1], was "
            r2.append(r3)
            double r3 = r0.d
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00fd:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Parameters cannot be NaN"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.TransferParameters.<init>(double, double, double, double, double, double, double):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TransferParameters(double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d2, d3, d4, d5, d6, (i & 32) != 0 ? 0.0d : d7, (i & 64) != 0 ? 0.0d : d8);
    }

    public final double getGamma() {
        return this.gamma;
    }

    public final double getA() {
        return this.a;
    }

    public final double getB() {
        return this.b;
    }

    public final double getC() {
        return this.c;
    }

    public final double getD() {
        return this.d;
    }

    public final double getE() {
        return this.e;
    }

    public final double getF() {
        return this.f;
    }
}
