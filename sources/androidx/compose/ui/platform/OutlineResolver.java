package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u001b\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u001fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u00020,2\u0006\u0010$\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J6\u00103\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u0006\u00106\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00062\u0006\u00107\u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003J\b\u00108\u001a\u00020,H\u0002J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\nH\u0002J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020(H\u0002J3\u0010@\u001a\u00020\u0006*\u0004\u0018\u00010(2\u0006\u0010A\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020!H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\u00020\u001cX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u0019\u0010\u001e\u001a\u00020\u001fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010$\u001a\u00020\u001cX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010%\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/compose/ui/platform/OutlineResolver;", "", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "cacheIsDirty", "", "cachedOutline", "Landroid/graphics/Outline;", "cachedRrectPath", "Landroidx/compose/ui/graphics/Path;", "calculatedOutline", "Landroidx/compose/ui/graphics/Outline;", "clipPath", "getClipPath", "()Landroidx/compose/ui/graphics/Path;", "isSupportedOutline", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outline", "getOutline", "()Landroid/graphics/Outline;", "outlineClipSupported", "getOutlineClipSupported", "()Z", "outlineNeeded", "outlinePath", "rectSize", "Landroidx/compose/ui/geometry/Size;", "J", "rectTopLeft", "Landroidx/compose/ui/geometry/Offset;", "roundedCornerRadius", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "size", "tmpOpPath", "tmpPath", "tmpRoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "tmpTouchPointPath", "usePathForClip", "clipToOutline", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "isInOutline", "position", "isInOutline-k-4lQ0M", "(J)Z", "update", "update-uvyYCjk", "(J)V", "alpha", "elevation", "updateCache", "updateCacheWithPath", "composePath", "updateCacheWithRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateCacheWithRoundRect", "roundRect", "isSameBounds", "offset", "radius", "isSameBounds-4L21HEs", "(Landroidx/compose/ui/geometry/RoundRect;JJF)Z", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OutlineResolver.android.kt */
public final class OutlineResolver {
    private boolean cacheIsDirty;
    private final Outline cachedOutline;
    private Path cachedRrectPath;
    private androidx.compose.ui.graphics.Outline calculatedOutline;
    private Density density;
    private boolean isSupportedOutline = true;
    private LayoutDirection layoutDirection;
    private boolean outlineNeeded;
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    private Shape shape;
    private long size;
    private Path tmpOpPath;
    private Path tmpPath;
    private RoundRect tmpRoundRect;
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver(Density density2) {
        Intrinsics.checkNotNullParameter(density2, "density");
        this.density = density2;
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.cachedOutline = outline;
        this.size = Size.Companion.m1761getZeroNHjbRc();
        this.shape = RectangleShapeKt.getRectangleShape();
        this.rectTopLeft = Offset.Companion.m1699getZeroF1C5BW0();
        this.rectSize = Size.Companion.m1761getZeroNHjbRc();
        this.layoutDirection = LayoutDirection.Ltr;
    }

    public final Outline getOutline() {
        updateCache();
        if (!this.outlineNeeded || !this.isSupportedOutline) {
            return null;
        }
        return this.cachedOutline;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    public final boolean update(Shape shape2, float f, boolean z, float f2, LayoutDirection layoutDirection2, Density density2) {
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection2, ViewProps.LAYOUT_DIRECTION);
        Intrinsics.checkNotNullParameter(density2, "density");
        this.cachedOutline.setAlpha(f);
        boolean z2 = !Intrinsics.areEqual((Object) this.shape, (Object) shape2);
        if (z2) {
            this.shape = shape2;
            this.cacheIsDirty = true;
        }
        boolean z3 = z || f2 > 0.0f;
        if (this.outlineNeeded != z3) {
            this.outlineNeeded = z3;
            this.cacheIsDirty = true;
        }
        if (this.layoutDirection != layoutDirection2) {
            this.layoutDirection = layoutDirection2;
            this.cacheIsDirty = true;
        }
        if (!Intrinsics.areEqual((Object) this.density, (Object) density2)) {
            this.density = density2;
            this.cacheIsDirty = true;
        }
        return z2;
    }

    /* renamed from: isInOutline-k-4lQ0M  reason: not valid java name */
    public final boolean m4046isInOutlinek4lQ0M(long j) {
        androidx.compose.ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.calculatedOutline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Offset.m1683getXimpl(j), Offset.m1684getYimpl(j), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        if (m4045isSameBounds4L21HEs(r1, r7.rectTopLeft, r7.rectSize, r6) == false) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clipToOutline(androidx.compose.ui.graphics.Canvas r21) {
        /*
            r20 = this;
            r7 = r20
            r8 = r21
            java.lang.String r0 = "canvas"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            androidx.compose.ui.graphics.Path r0 = r20.getClipPath()
            r9 = 0
            r10 = 0
            r11 = 2
            if (r0 == 0) goto L_0x0017
            androidx.compose.ui.graphics.Canvas.CC.m1904clipPathmtrdDE$default(r8, r0, r9, r11, r10)
            goto L_0x00a8
        L_0x0017:
            float r6 = r7.roundedCornerRadius
            r12 = 0
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x0077
            androidx.compose.ui.graphics.Path r13 = r7.tmpPath
            androidx.compose.ui.geometry.RoundRect r1 = r7.tmpRoundRect
            if (r13 == 0) goto L_0x0030
            long r2 = r7.rectTopLeft
            long r4 = r7.rectSize
            r0 = r20
            boolean r0 = r0.m4045isSameBounds4L21HEs(r1, r2, r4, r6)
            if (r0 != 0) goto L_0x0073
        L_0x0030:
            long r0 = r7.rectTopLeft
            float r14 = androidx.compose.ui.geometry.Offset.m1683getXimpl(r0)
            long r0 = r7.rectTopLeft
            float r15 = androidx.compose.ui.geometry.Offset.m1684getYimpl(r0)
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m1683getXimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m1752getWidthimpl(r1)
            float r16 = r0 + r1
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m1684getYimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m1749getHeightimpl(r1)
            float r17 = r0 + r1
            float r0 = r7.roundedCornerRadius
            long r18 = androidx.compose.ui.geometry.CornerRadiusKt.CornerRadius$default(r0, r12, r11, r10)
            androidx.compose.ui.geometry.RoundRect r0 = androidx.compose.ui.geometry.RoundRectKt.m1737RoundRectgG7oq9Y(r14, r15, r16, r17, r18)
            if (r13 != 0) goto L_0x0069
            androidx.compose.ui.graphics.Path r13 = androidx.compose.ui.graphics.AndroidPath_androidKt.Path()
            goto L_0x006c
        L_0x0069:
            r13.reset()
        L_0x006c:
            r13.addRoundRect(r0)
            r7.tmpRoundRect = r0
            r7.tmpPath = r13
        L_0x0073:
            androidx.compose.ui.graphics.Canvas.CC.m1904clipPathmtrdDE$default(r8, r13, r9, r11, r10)
            goto L_0x00a8
        L_0x0077:
            long r0 = r7.rectTopLeft
            float r9 = androidx.compose.ui.geometry.Offset.m1683getXimpl(r0)
            long r0 = r7.rectTopLeft
            float r10 = androidx.compose.ui.geometry.Offset.m1684getYimpl(r0)
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m1683getXimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m1752getWidthimpl(r1)
            float r11 = r0 + r1
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m1684getYimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m1749getHeightimpl(r1)
            float r12 = r0 + r1
            r13 = 0
            r14 = 16
            r15 = 0
            r8 = r21
            androidx.compose.ui.graphics.Canvas.CC.m1905clipRectN_I0leg$default(r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.OutlineResolver.clipToOutline(androidx.compose.ui.graphics.Canvas):void");
    }

    /* renamed from: update-uvyYCjk  reason: not valid java name */
    public final void m4047updateuvyYCjk(long j) {
        if (!Size.m1748equalsimpl0(this.size, j)) {
            this.size = j;
            this.cacheIsDirty = true;
        }
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.m1699getZeroF1C5BW0();
            long j = this.size;
            this.rectSize = j;
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            if (!this.outlineNeeded || Size.m1752getWidthimpl(j) <= 0.0f || Size.m1749getHeightimpl(this.size) <= 0.0f) {
                this.cachedOutline.setEmpty();
                return;
            }
            this.isSupportedOutline = true;
            androidx.compose.ui.graphics.Outline r0 = this.shape.m2266createOutlinePq9zytI(this.size, this.layoutDirection, this.density);
            this.calculatedOutline = r0;
            if (r0 instanceof Outline.Rectangle) {
                updateCacheWithRect(((Outline.Rectangle) r0).getRect());
            } else if (r0 instanceof Outline.Rounded) {
                updateCacheWithRoundRect(((Outline.Rounded) r0).getRoundRect());
            } else if (r0 instanceof Outline.Generic) {
                updateCacheWithPath(((Outline.Generic) r0).getPath());
            }
        }
    }

    private final void updateCacheWithRect(Rect rect) {
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        this.cachedOutline.setRect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float r0 = CornerRadius.m1658getXimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            this.cachedOutline.setRoundRect(MathKt.roundToInt(roundRect.getLeft()), MathKt.roundToInt(roundRect.getTop()), MathKt.roundToInt(roundRect.getRight()), MathKt.roundToInt(roundRect.getBottom()), r0);
            this.roundedCornerRadius = r0;
            return;
        }
        Path path = this.cachedRrectPath;
        if (path == null) {
            path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = path;
        }
        path.reset();
        path.addRoundRect(roundRect);
        updateCacheWithPath(path);
    }

    private final void updateCacheWithPath(Path path) {
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            android.graphics.Outline outline = this.cachedOutline;
            if (path instanceof AndroidPath) {
                outline.setConvexPath(((AndroidPath) path).getInternalPath());
                this.usePathForClip = !this.cachedOutline.canClip();
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = path;
    }

    /* renamed from: isSameBounds-4L21HEs  reason: not valid java name */
    private final boolean m4045isSameBounds4L21HEs(RoundRect roundRect, long j, long j2, float f) {
        if (roundRect == null || !RoundRectKt.isSimple(roundRect)) {
            return false;
        }
        if (!(roundRect.getLeft() == Offset.m1683getXimpl(j))) {
            return false;
        }
        if (!(roundRect.getTop() == Offset.m1684getYimpl(j))) {
            return false;
        }
        if (!(roundRect.getRight() == Offset.m1683getXimpl(j) + Size.m1752getWidthimpl(j2))) {
            return false;
        }
        if (!(roundRect.getBottom() == Offset.m1684getYimpl(j) + Size.m1749getHeightimpl(j2))) {
            return false;
        }
        if (CornerRadius.m1658getXimpl(roundRect.m1733getTopLeftCornerRadiuskKHJgLs()) == f) {
            return true;
        }
        return false;
    }
}
