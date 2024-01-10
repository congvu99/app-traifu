package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 >2\u00020\u0001:\u0001>BP\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0019\u0010!\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0011J\u0019\u0010#\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0011J\u0019\u0010%\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0011J\u0019\u0010'\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\u0011J\u001e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.Jf\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0013\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J(\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003H\u0002J\b\u0010;\u001a\u00020\u0000H\u0002J\b\u0010<\u001a\u00020=H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u000b\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\n\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u001c\u0010\t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006?"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect;", "", "left", "", "top", "right", "bottom", "topLeftCornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "topRightCornerRadius", "bottomRightCornerRadius", "bottomLeftCornerRadius", "(FFFFJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_scaledRadiiRect", "getBottom", "()F", "getBottomLeftCornerRadius-kKHJgLs", "()J", "J", "getBottomRightCornerRadius-kKHJgLs", "height", "getHeight", "getLeft", "getRight", "getTop", "getTopLeftCornerRadius-kKHJgLs", "getTopRightCornerRadius-kKHJgLs", "width", "getWidth", "component1", "component2", "component3", "component4", "component5", "component5-kKHJgLs", "component6", "component6-kKHJgLs", "component7", "component7-kKHJgLs", "component8", "component8-kKHJgLs", "contains", "", "point", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "copy", "copy-MDFrsts", "(FFFFJJJJ)Landroidx/compose/ui/geometry/RoundRect;", "equals", "other", "hashCode", "", "minRadius", "min", "radius1", "radius2", "limit", "scaledRadiiRect", "toString", "", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoundRect.kt */
public final class RoundRect {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final RoundRect Zero = RoundRectKt.m1737RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.Companion.m1668getZerokKHJgLs());
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    public /* synthetic */ RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, j, j2, j3, j4);
    }

    /* renamed from: copy-MDFrsts$default  reason: not valid java name */
    public static /* synthetic */ RoundRect m1724copyMDFrsts$default(RoundRect roundRect, float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, int i, Object obj) {
        RoundRect roundRect2 = roundRect;
        int i2 = i;
        return roundRect.m1730copyMDFrsts((i2 & 1) != 0 ? roundRect2.left : f, (i2 & 2) != 0 ? roundRect2.top : f2, (i2 & 4) != 0 ? roundRect2.right : f3, (i2 & 8) != 0 ? roundRect2.bottom : f4, (i2 & 16) != 0 ? roundRect2.topLeftCornerRadius : j, (i2 & 32) != 0 ? roundRect2.topRightCornerRadius : j2, (i2 & 64) != 0 ? roundRect2.bottomRightCornerRadius : j3, (i2 & 128) != 0 ? roundRect2.bottomLeftCornerRadius : j4);
    }

    public static final RoundRect getZero() {
        return Companion.getZero();
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    /* renamed from: component5-kKHJgLs  reason: not valid java name */
    public final long m1725component5kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: component6-kKHJgLs  reason: not valid java name */
    public final long m1726component6kKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* renamed from: component7-kKHJgLs  reason: not valid java name */
    public final long m1727component7kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* renamed from: component8-kKHJgLs  reason: not valid java name */
    public final long m1728component8kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: copy-MDFrsts  reason: not valid java name */
    public final RoundRect m1730copyMDFrsts(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        return new RoundRect(f, f2, f3, f4, j, j2, j3, j4, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.left), (Object) Float.valueOf(roundRect.left)) && Intrinsics.areEqual((Object) Float.valueOf(this.top), (Object) Float.valueOf(roundRect.top)) && Intrinsics.areEqual((Object) Float.valueOf(this.right), (Object) Float.valueOf(roundRect.right)) && Intrinsics.areEqual((Object) Float.valueOf(this.bottom), (Object) Float.valueOf(roundRect.bottom)) && CornerRadius.m1657equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m1657equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m1657equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m1657equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public int hashCode() {
        return (((((((((((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom)) * 31) + CornerRadius.m1660hashCodeimpl(this.topLeftCornerRadius)) * 31) + CornerRadius.m1660hashCodeimpl(this.topRightCornerRadius)) * 31) + CornerRadius.m1660hashCodeimpl(this.bottomRightCornerRadius)) * 31) + CornerRadius.m1660hashCodeimpl(this.bottomLeftCornerRadius);
    }

    private RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
        this.topLeftCornerRadius = j;
        this.topRightCornerRadius = j2;
        this.bottomRightCornerRadius = j3;
        this.bottomLeftCornerRadius = j4;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RoundRect(float r18, float r19, float r20, float r21, long r22, long r24, long r26, long r28, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r17 = this;
            r0 = r30
            r1 = r0 & 16
            if (r1 == 0) goto L_0x000e
            androidx.compose.ui.geometry.CornerRadius$Companion r1 = androidx.compose.ui.geometry.CornerRadius.Companion
            long r1 = r1.m1668getZerokKHJgLs()
            r8 = r1
            goto L_0x0010
        L_0x000e:
            r8 = r22
        L_0x0010:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001c
            androidx.compose.ui.geometry.CornerRadius$Companion r1 = androidx.compose.ui.geometry.CornerRadius.Companion
            long r1 = r1.m1668getZerokKHJgLs()
            r10 = r1
            goto L_0x001e
        L_0x001c:
            r10 = r24
        L_0x001e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002a
            androidx.compose.ui.geometry.CornerRadius$Companion r1 = androidx.compose.ui.geometry.CornerRadius.Companion
            long r1 = r1.m1668getZerokKHJgLs()
            r12 = r1
            goto L_0x002c
        L_0x002a:
            r12 = r26
        L_0x002c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0038
            androidx.compose.ui.geometry.CornerRadius$Companion r0 = androidx.compose.ui.geometry.CornerRadius.Companion
            long r0 = r0.m1668getZerokKHJgLs()
            r14 = r0
            goto L_0x003a
        L_0x0038:
            r14 = r28
        L_0x003a:
            r16 = 0
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r3.<init>(r4, r5, r6, r7, r8, r10, r12, r14, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.geometry.RoundRect.<init>(float, float, float, float, long, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getTopLeftCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m1733getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: getTopRightCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m1734getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* renamed from: getBottomRightCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m1732getBottomRightCornerRadiuskKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* renamed from: getBottomLeftCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m1731getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect roundRect = this._scaledRadiiRect;
        if (roundRect == null) {
            RoundRect roundRect2 = this;
            float minRadius = roundRect2.minRadius(roundRect2.minRadius(roundRect2.minRadius(roundRect2.minRadius(1.0f, CornerRadius.m1659getYimpl(roundRect2.bottomLeftCornerRadius), CornerRadius.m1659getYimpl(roundRect2.topLeftCornerRadius), roundRect2.getHeight()), CornerRadius.m1658getXimpl(roundRect2.topLeftCornerRadius), CornerRadius.m1658getXimpl(roundRect2.topRightCornerRadius), roundRect2.getWidth()), CornerRadius.m1659getYimpl(roundRect2.topRightCornerRadius), CornerRadius.m1659getYimpl(roundRect2.bottomRightCornerRadius), roundRect2.getHeight()), CornerRadius.m1658getXimpl(roundRect2.bottomRightCornerRadius), CornerRadius.m1658getXimpl(roundRect2.bottomLeftCornerRadius), roundRect2.getWidth());
            RoundRect roundRect3 = r3;
            RoundRect roundRect4 = new RoundRect(roundRect2.left * minRadius, roundRect2.top * minRadius, roundRect2.right * minRadius, roundRect2.bottom * minRadius, CornerRadiusKt.CornerRadius(CornerRadius.m1658getXimpl(roundRect2.topLeftCornerRadius) * minRadius, CornerRadius.m1659getYimpl(roundRect2.topLeftCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.m1658getXimpl(roundRect2.topRightCornerRadius) * minRadius, CornerRadius.m1659getYimpl(roundRect2.topRightCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.m1658getXimpl(roundRect2.bottomRightCornerRadius) * minRadius, CornerRadius.m1659getYimpl(roundRect2.bottomRightCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.m1658getXimpl(roundRect2.bottomLeftCornerRadius) * minRadius, CornerRadius.m1659getYimpl(roundRect2.bottomLeftCornerRadius) * minRadius), (DefaultConstructorMarker) null);
            this._scaledRadiiRect = roundRect3;
            return roundRect3;
        }
        return roundRect;
    }

    private final float minRadius(float f, float f2, float f3, float f4) {
        float f5 = f2 + f3;
        if (f5 <= f4) {
            return f;
        }
        return !((f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1)) == 0) ? Math.min(f, f4 / f5) : f;
    }

    /* renamed from: contains-k-4lQ0M  reason: not valid java name */
    public final boolean m1729containsk4lQ0M(long j) {
        float f;
        float f2;
        float f3;
        float f4;
        if (Offset.m1683getXimpl(j) < this.left || Offset.m1683getXimpl(j) >= this.right || Offset.m1684getYimpl(j) < this.top || Offset.m1684getYimpl(j) >= this.bottom) {
            return false;
        }
        RoundRect scaledRadiiRect = scaledRadiiRect();
        if (Offset.m1683getXimpl(j) < this.left + CornerRadius.m1658getXimpl(scaledRadiiRect.topLeftCornerRadius) && Offset.m1684getYimpl(j) < this.top + CornerRadius.m1659getYimpl(scaledRadiiRect.topLeftCornerRadius)) {
            f3 = (Offset.m1683getXimpl(j) - this.left) - CornerRadius.m1658getXimpl(scaledRadiiRect.topLeftCornerRadius);
            f2 = (Offset.m1684getYimpl(j) - this.top) - CornerRadius.m1659getYimpl(scaledRadiiRect.topLeftCornerRadius);
            f = CornerRadius.m1658getXimpl(scaledRadiiRect.topLeftCornerRadius);
            f4 = CornerRadius.m1659getYimpl(scaledRadiiRect.topLeftCornerRadius);
        } else if (Offset.m1683getXimpl(j) > this.right - CornerRadius.m1658getXimpl(scaledRadiiRect.topRightCornerRadius) && Offset.m1684getYimpl(j) < this.top + CornerRadius.m1659getYimpl(scaledRadiiRect.topRightCornerRadius)) {
            f3 = (Offset.m1683getXimpl(j) - this.right) + CornerRadius.m1658getXimpl(scaledRadiiRect.topRightCornerRadius);
            f2 = (Offset.m1684getYimpl(j) - this.top) - CornerRadius.m1659getYimpl(scaledRadiiRect.topRightCornerRadius);
            f = CornerRadius.m1658getXimpl(scaledRadiiRect.topRightCornerRadius);
            f4 = CornerRadius.m1659getYimpl(scaledRadiiRect.topRightCornerRadius);
        } else if (Offset.m1683getXimpl(j) > this.right - CornerRadius.m1658getXimpl(scaledRadiiRect.bottomRightCornerRadius) && Offset.m1684getYimpl(j) > this.bottom - CornerRadius.m1659getYimpl(scaledRadiiRect.bottomRightCornerRadius)) {
            f3 = (Offset.m1683getXimpl(j) - this.right) + CornerRadius.m1658getXimpl(scaledRadiiRect.bottomRightCornerRadius);
            f2 = (Offset.m1684getYimpl(j) - this.bottom) + CornerRadius.m1659getYimpl(scaledRadiiRect.bottomRightCornerRadius);
            f = CornerRadius.m1658getXimpl(scaledRadiiRect.bottomRightCornerRadius);
            f4 = CornerRadius.m1659getYimpl(scaledRadiiRect.bottomRightCornerRadius);
        } else if (Offset.m1683getXimpl(j) >= this.left + CornerRadius.m1658getXimpl(scaledRadiiRect.bottomLeftCornerRadius) || Offset.m1684getYimpl(j) <= this.bottom - CornerRadius.m1659getYimpl(scaledRadiiRect.bottomLeftCornerRadius)) {
            return true;
        } else {
            f3 = (Offset.m1683getXimpl(j) - this.left) - CornerRadius.m1658getXimpl(scaledRadiiRect.bottomLeftCornerRadius);
            f2 = (Offset.m1684getYimpl(j) - this.bottom) + CornerRadius.m1659getYimpl(scaledRadiiRect.bottomLeftCornerRadius);
            f = CornerRadius.m1658getXimpl(scaledRadiiRect.bottomLeftCornerRadius);
            f4 = CornerRadius.m1659getYimpl(scaledRadiiRect.bottomLeftCornerRadius);
        }
        float f5 = f3 / f;
        float f6 = f2 / f4;
        if ((f5 * f5) + (f6 * f6) <= 1.0f) {
            return true;
        }
        return false;
    }

    public String toString() {
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        long j3 = this.bottomRightCornerRadius;
        long j4 = this.bottomLeftCornerRadius;
        String str = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (!CornerRadius.m1657equalsimpl0(j, j2) || !CornerRadius.m1657equalsimpl0(j2, j3) || !CornerRadius.m1657equalsimpl0(j3, j4)) {
            return "RoundRect(rect=" + str + ", topLeft=" + CornerRadius.m1664toStringimpl(j) + ", topRight=" + CornerRadius.m1664toStringimpl(j2) + ", bottomRight=" + CornerRadius.m1664toStringimpl(j3) + ", bottomLeft=" + CornerRadius.m1664toStringimpl(j4) + ')';
        }
        if (CornerRadius.m1658getXimpl(j) == CornerRadius.m1659getYimpl(j)) {
            return "RoundRect(rect=" + str + ", radius=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m1658getXimpl(j), 1) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m1658getXimpl(j), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m1659getYimpl(j), 1) + ')';
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/geometry/RoundRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RoundRect.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getZero$annotations() {
        }

        private Companion() {
        }

        public final RoundRect getZero() {
            return RoundRect.Zero;
        }
    }
}
