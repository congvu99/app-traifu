package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a#\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aC\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a;\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a6\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a\u001e\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0012\u001a\u001f\u00101\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0015\u0010\f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000b\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"boundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isCircle", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isEllipse", "isEmpty", "isFinite", "isRect", "isSimple", "maxDimension", "", "getMaxDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "minDimension", "getMinDimension", "safeInnerRect", "getSafeInnerRect", "RoundRect", "rect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "radiusX", "radiusY", "left", "top", "right", "bottom", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "lerp", "start", "stop", "fraction", "translate", "offset", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoundRect.kt */
public final class RoundRectKt {
    public static final RoundRect RoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        long CornerRadius = CornerRadiusKt.CornerRadius(f5, f6);
        return new RoundRect(f, f2, f3, f4, CornerRadius, CornerRadius, CornerRadius, CornerRadius, (DefaultConstructorMarker) null);
    }

    /* renamed from: RoundRect-gG7oq9Y  reason: not valid java name */
    public static final RoundRect m1737RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        return RoundRect(f, f2, f3, f4, CornerRadius.m1658getXimpl(j), CornerRadius.m1659getYimpl(j));
    }

    public static final RoundRect RoundRect(Rect rect, float f, float f2) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f2);
    }

    /* renamed from: RoundRect-sniSvfs  reason: not valid java name */
    public static final RoundRect m1738RoundRectsniSvfs(Rect rect, long j) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect, CornerRadius.m1658getXimpl(j), CornerRadius.m1659getYimpl(j));
    }

    /* renamed from: RoundRect-ZAM2FJo$default  reason: not valid java name */
    public static /* synthetic */ RoundRect m1736RoundRectZAM2FJo$default(Rect rect, long j, long j2, long j3, long j4, int i, Object obj) {
        return m1735RoundRectZAM2FJo(rect, (i & 2) != 0 ? CornerRadius.Companion.m1668getZerokKHJgLs() : j, (i & 4) != 0 ? CornerRadius.Companion.m1668getZerokKHJgLs() : j2, (i & 8) != 0 ? CornerRadius.Companion.m1668getZerokKHJgLs() : j3, (i & 16) != 0 ? CornerRadius.Companion.m1668getZerokKHJgLs() : j4);
    }

    /* renamed from: RoundRect-ZAM2FJo  reason: not valid java name */
    public static final RoundRect m1735RoundRectZAM2FJo(Rect rect, long j, long j2, long j3, long j4) {
        Rect rect2 = rect;
        Intrinsics.checkNotNullParameter(rect, "rect");
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, (DefaultConstructorMarker) null);
    }

    /* renamed from: translate-Uv8p0NA  reason: not valid java name */
    public static final RoundRect m1739translateUv8p0NA(RoundRect roundRect, long j) {
        RoundRect roundRect2 = roundRect;
        Intrinsics.checkNotNullParameter(roundRect, "$this$translate");
        return new RoundRect(roundRect.getLeft() + Offset.m1683getXimpl(j), roundRect.getTop() + Offset.m1684getYimpl(j), roundRect.getRight() + Offset.m1683getXimpl(j), roundRect.getBottom() + Offset.m1684getYimpl(j), roundRect.m1733getTopLeftCornerRadiuskKHJgLs(), roundRect.m1734getTopRightCornerRadiuskKHJgLs(), roundRect.m1732getBottomRightCornerRadiuskKHJgLs(), roundRect.m1731getBottomLeftCornerRadiuskKHJgLs(), (DefaultConstructorMarker) null);
    }

    public static final Rect getBoundingRect(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final Rect getSafeInnerRect(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return new Rect(roundRect.getLeft() + (Math.max(CornerRadius.m1658getXimpl(roundRect.m1731getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m1658getXimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getTop() + (Math.max(CornerRadius.m1659getYimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m1659getYimpl(roundRect.m1734getTopRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getRight() - (Math.max(CornerRadius.m1658getXimpl(roundRect.m1734getTopRightCornerRadiuskKHJgLs()), CornerRadius.m1658getXimpl(roundRect.m1732getBottomRightCornerRadiuskKHJgLs())) * 0.29289323f), roundRect.getBottom() - (Math.max(CornerRadius.m1659getYimpl(roundRect.m1732getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m1659getYimpl(roundRect.m1731getBottomLeftCornerRadiuskKHJgLs())) * 0.29289323f));
    }

    public static final boolean isEmpty(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom();
    }

    public static final boolean isFinite(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        float left = roundRect.getLeft();
        if (!Float.isInfinite(left) && !Float.isNaN(left)) {
            float top = roundRect.getTop();
            if (!Float.isInfinite(top) && !Float.isNaN(top)) {
                float right = roundRect.getRight();
                if (!Float.isInfinite(right) && !Float.isNaN(right)) {
                    float bottom = roundRect.getBottom();
                    if (!Float.isInfinite(bottom) && !Float.isNaN(bottom)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if ((androidx.compose.ui.geometry.CornerRadius.m1659getYimpl(r6.m1734getTopRightCornerRadiuskKHJgLs()) == 0.0f) != false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
        if ((androidx.compose.ui.geometry.CornerRadius.m1659getYimpl(r6.m1731getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if ((androidx.compose.ui.geometry.CornerRadius.m1659getYimpl(r6.m1733getTopLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isRect(androidx.compose.ui.geometry.RoundRect r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            long r0 = r6.m1733getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1658getXimpl(r0)
            r1 = 0
            r2 = 1
            r3 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            if (r0 != 0) goto L_0x002a
            long r4 = r6.m1733getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1659getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 == 0) goto L_0x0091
        L_0x002a:
            long r4 = r6.m1734getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1658getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 != 0) goto L_0x004c
            long r4 = r6.m1734getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1659getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0049
            r0 = 1
            goto L_0x004a
        L_0x0049:
            r0 = 0
        L_0x004a:
            if (r0 == 0) goto L_0x0091
        L_0x004c:
            long r4 = r6.m1731getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1658getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x005a
            r0 = 1
            goto L_0x005b
        L_0x005a:
            r0 = 0
        L_0x005b:
            if (r0 != 0) goto L_0x006e
            long r4 = r6.m1731getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1659getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x006b
            r0 = 1
            goto L_0x006c
        L_0x006b:
            r0 = 0
        L_0x006c:
            if (r0 == 0) goto L_0x0091
        L_0x006e:
            long r4 = r6.m1732getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1658getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x007c
            r0 = 1
            goto L_0x007d
        L_0x007c:
            r0 = 0
        L_0x007d:
            if (r0 != 0) goto L_0x0092
            long r4 = r6.m1732getBottomRightCornerRadiuskKHJgLs()
            float r6 = androidx.compose.ui.geometry.CornerRadius.m1659getYimpl(r4)
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 != 0) goto L_0x008d
            r6 = 1
            goto L_0x008e
        L_0x008d:
            r6 = 0
        L_0x008e:
            if (r6 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0091:
            r2 = 0
        L_0x0092:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.geometry.RoundRectKt.isRect(androidx.compose.ui.geometry.RoundRect):boolean");
    }

    public static final boolean isEllipse(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        if (CornerRadius.m1658getXimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1658getXimpl(roundRect.m1734getTopRightCornerRadiuskKHJgLs())) {
            if (CornerRadius.m1659getYimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1659getYimpl(roundRect.m1734getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m1658getXimpl(roundRect.m1734getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m1658getXimpl(roundRect.m1732getBottomRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m1659getYimpl(roundRect.m1734getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m1659getYimpl(roundRect.m1732getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m1658getXimpl(roundRect.m1732getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m1658getXimpl(roundRect.m1731getBottomLeftCornerRadiuskKHJgLs())) {
                            if (!(CornerRadius.m1659getYimpl(roundRect.m1732getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m1659getYimpl(roundRect.m1731getBottomLeftCornerRadiuskKHJgLs())) || ((double) roundRect.getWidth()) > ((double) CornerRadius.m1658getXimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs())) * 2.0d || ((double) roundRect.getHeight()) > ((double) CornerRadius.m1659getYimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs())) * 2.0d) {
                                return false;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isCircle(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return ((roundRect.getWidth() > roundRect.getHeight() ? 1 : (roundRect.getWidth() == roundRect.getHeight() ? 0 : -1)) == 0) && isEllipse(roundRect);
    }

    public static final float getMinDimension(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMaxDimension(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final long getCenter(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        return OffsetKt.Offset(roundRect.getLeft() + (roundRect.getWidth() / 2.0f), roundRect.getTop() + (roundRect.getHeight() / 2.0f));
    }

    public static final boolean isSimple(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        if (CornerRadius.m1658getXimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1659getYimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs())) {
            if (CornerRadius.m1658getXimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1658getXimpl(roundRect.m1734getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m1658getXimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1659getYimpl(roundRect.m1734getTopRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m1658getXimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1658getXimpl(roundRect.m1732getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m1658getXimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1659getYimpl(roundRect.m1732getBottomRightCornerRadiuskKHJgLs())) {
                            if (CornerRadius.m1658getXimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1658getXimpl(roundRect.m1731getBottomLeftCornerRadiuskKHJgLs())) {
                                if (CornerRadius.m1658getXimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1659getYimpl(roundRect.m1731getBottomLeftCornerRadiuskKHJgLs())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final RoundRect lerp(RoundRect roundRect, RoundRect roundRect2, float f) {
        float f2 = f;
        Intrinsics.checkNotNullParameter(roundRect, "start");
        Intrinsics.checkNotNullParameter(roundRect2, "stop");
        return new RoundRect(MathHelpersKt.lerp(roundRect.getLeft(), roundRect2.getLeft(), f2), MathHelpersKt.lerp(roundRect.getTop(), roundRect2.getTop(), f2), MathHelpersKt.lerp(roundRect.getRight(), roundRect2.getRight(), f2), MathHelpersKt.lerp(roundRect.getBottom(), roundRect2.getBottom(), f2), CornerRadiusKt.m1669lerp3Ry4LBc(roundRect.m1733getTopLeftCornerRadiuskKHJgLs(), roundRect2.m1733getTopLeftCornerRadiuskKHJgLs(), f2), CornerRadiusKt.m1669lerp3Ry4LBc(roundRect.m1734getTopRightCornerRadiuskKHJgLs(), roundRect2.m1734getTopRightCornerRadiuskKHJgLs(), f2), CornerRadiusKt.m1669lerp3Ry4LBc(roundRect.m1732getBottomRightCornerRadiuskKHJgLs(), roundRect2.m1732getBottomRightCornerRadiuskKHJgLs(), f2), CornerRadiusKt.m1669lerp3Ry4LBc(roundRect.m1731getBottomLeftCornerRadiuskKHJgLs(), roundRect2.m1731getBottomLeftCornerRadiuskKHJgLs(), f2), (DefaultConstructorMarker) null);
    }
}
