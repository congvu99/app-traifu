package androidx.compose.foundation;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÂ\u0003J9\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0006\u0010\u0015\u001a\u00020\tJ\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001JF\u0010\u0018\u001a\u00020\u0003*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f¢\u0006\u0002\b\"H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010$R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/compose/foundation/BorderCache;", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "borderPath", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;Landroidx/compose/ui/graphics/Path;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "obtainPath", "toString", "", "drawBorderCache", "Landroidx/compose/ui/draw/CacheDrawScope;", "borderSize", "Landroidx/compose/ui/unit/IntSize;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawBorderCache-EMwLDEs", "(Landroidx/compose/ui/draw/CacheDrawScope;JILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/ImageBitmap;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Border.kt */
final class BorderCache {
    private Path borderPath;
    /* access modifiers changed from: private */
    public Canvas canvas;
    /* access modifiers changed from: private */
    public CanvasDrawScope canvasDrawScope;
    /* access modifiers changed from: private */
    public ImageBitmap imageBitmap;

    public BorderCache() {
        this((ImageBitmap) null, (Canvas) null, (CanvasDrawScope) null, (Path) null, 15, (DefaultConstructorMarker) null);
    }

    private final ImageBitmap component1() {
        return this.imageBitmap;
    }

    private final Canvas component2() {
        return this.canvas;
    }

    private final CanvasDrawScope component3() {
        return this.canvasDrawScope;
    }

    private final Path component4() {
        return this.borderPath;
    }

    public static /* synthetic */ BorderCache copy$default(BorderCache borderCache, ImageBitmap imageBitmap2, Canvas canvas2, CanvasDrawScope canvasDrawScope2, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            imageBitmap2 = borderCache.imageBitmap;
        }
        if ((i & 2) != 0) {
            canvas2 = borderCache.canvas;
        }
        if ((i & 4) != 0) {
            canvasDrawScope2 = borderCache.canvasDrawScope;
        }
        if ((i & 8) != 0) {
            path = borderCache.borderPath;
        }
        return borderCache.copy(imageBitmap2, canvas2, canvasDrawScope2, path);
    }

    public final BorderCache copy(ImageBitmap imageBitmap2, Canvas canvas2, CanvasDrawScope canvasDrawScope2, Path path) {
        return new BorderCache(imageBitmap2, canvas2, canvasDrawScope2, path);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderCache)) {
            return false;
        }
        BorderCache borderCache = (BorderCache) obj;
        return Intrinsics.areEqual((Object) this.imageBitmap, (Object) borderCache.imageBitmap) && Intrinsics.areEqual((Object) this.canvas, (Object) borderCache.canvas) && Intrinsics.areEqual((Object) this.canvasDrawScope, (Object) borderCache.canvasDrawScope) && Intrinsics.areEqual((Object) this.borderPath, (Object) borderCache.borderPath);
    }

    public int hashCode() {
        ImageBitmap imageBitmap2 = this.imageBitmap;
        int i = 0;
        int hashCode = (imageBitmap2 == null ? 0 : imageBitmap2.hashCode()) * 31;
        Canvas canvas2 = this.canvas;
        int hashCode2 = (hashCode + (canvas2 == null ? 0 : canvas2.hashCode())) * 31;
        CanvasDrawScope canvasDrawScope2 = this.canvasDrawScope;
        int hashCode3 = (hashCode2 + (canvasDrawScope2 == null ? 0 : canvasDrawScope2.hashCode())) * 31;
        Path path = this.borderPath;
        if (path != null) {
            i = path.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "BorderCache(imageBitmap=" + this.imageBitmap + ", canvas=" + this.canvas + ", canvasDrawScope=" + this.canvasDrawScope + ", borderPath=" + this.borderPath + ')';
    }

    public BorderCache(ImageBitmap imageBitmap2, Canvas canvas2, CanvasDrawScope canvasDrawScope2, Path path) {
        this.imageBitmap = imageBitmap2;
        this.canvas = canvas2;
        this.canvasDrawScope = canvasDrawScope2;
        this.borderPath = path;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BorderCache(ImageBitmap imageBitmap2, Canvas canvas2, CanvasDrawScope canvasDrawScope2, Path path, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : imageBitmap2, (i & 2) != 0 ? null : canvas2, (i & 4) != 0 ? null : canvasDrawScope2, (i & 8) != 0 ? null : path);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m2117equalsimpl(r33, r5) != false) goto L_0x004f;
     */
    /* renamed from: drawBorderCache-EMwLDEs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.graphics.ImageBitmap m178drawBorderCacheEMwLDEs(androidx.compose.ui.draw.CacheDrawScope r30, long r31, int r33, kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, kotlin.Unit> r34) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r34
            java.lang.String r3 = "$this$drawBorderCache"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            androidx.compose.ui.graphics.ImageBitmap r3 = r29.imageBitmap
            androidx.compose.ui.graphics.Canvas r4 = r29.canvas
            r5 = 0
            if (r3 == 0) goto L_0x0024
            int r6 = r3.m2114getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r6 = androidx.compose.ui.graphics.ImageBitmapConfig.m2115boximpl(r6)
            goto L_0x0025
        L_0x0024:
            r6 = r5
        L_0x0025:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r7 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r7 = r7.m2123getArgb8888_sVssgQ()
            r8 = 0
            if (r6 != 0) goto L_0x0030
            r6 = 0
            goto L_0x0038
        L_0x0030:
            int r6 = r6.m2121unboximpl()
            boolean r6 = androidx.compose.ui.graphics.ImageBitmapConfig.m2118equalsimpl0(r6, r7)
        L_0x0038:
            if (r6 != 0) goto L_0x004d
            if (r3 == 0) goto L_0x0044
            int r5 = r3.m2114getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r5 = androidx.compose.ui.graphics.ImageBitmapConfig.m2115boximpl(r5)
        L_0x0044:
            r6 = r33
            boolean r5 = androidx.compose.ui.graphics.ImageBitmapConfig.m2117equalsimpl(r6, r5)
            if (r5 == 0) goto L_0x0050
            goto L_0x004f
        L_0x004d:
            r6 = r33
        L_0x004f:
            r8 = 1
        L_0x0050:
            if (r3 == 0) goto L_0x0078
            if (r4 == 0) goto L_0x0078
            long r9 = r30.m1580getSizeNHjbRc()
            float r5 = androidx.compose.ui.geometry.Size.m1752getWidthimpl(r9)
            int r7 = r3.getWidth()
            float r7 = (float) r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 > 0) goto L_0x0078
            long r9 = r30.m1580getSizeNHjbRc()
            float r5 = androidx.compose.ui.geometry.Size.m1749getHeightimpl(r9)
            int r7 = r3.getHeight()
            float r7 = (float) r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 > 0) goto L_0x0078
            if (r8 != 0) goto L_0x0095
        L_0x0078:
            int r9 = androidx.compose.ui.unit.IntSize.m4864getWidthimpl(r31)
            int r10 = androidx.compose.ui.unit.IntSize.m4863getHeightimpl(r31)
            r12 = 0
            r13 = 0
            r14 = 24
            r15 = 0
            r11 = r33
            androidx.compose.ui.graphics.ImageBitmap r3 = androidx.compose.ui.graphics.ImageBitmapKt.m2128ImageBitmapx__hDU$default(r9, r10, r11, r12, r13, r14, r15)
            r0.imageBitmap = r3
            androidx.compose.ui.graphics.Canvas r4 = androidx.compose.ui.graphics.CanvasKt.Canvas(r3)
            r0.canvas = r4
        L_0x0095:
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r5 = r29.canvasDrawScope
            if (r5 != 0) goto L_0x00a3
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r5 = new androidx.compose.ui.graphics.drawscope.CanvasDrawScope
            r5.<init>()
            r0.canvasDrawScope = r5
        L_0x00a3:
            long r11 = androidx.compose.ui.unit.IntSizeKt.m4874toSizeozmzZPI(r31)
            androidx.compose.ui.unit.LayoutDirection r6 = r30.getLayoutDirection()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r7 = r5.getDrawParams()
            androidx.compose.ui.unit.Density r15 = r7.component1()
            androidx.compose.ui.unit.LayoutDirection r14 = r7.component2()
            androidx.compose.ui.graphics.Canvas r13 = r7.component3()
            long r9 = r7.m2413component4NHjbRc()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r7 = r5.getDrawParams()
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            r7.setDensity(r1)
            r7.setLayoutDirection(r6)
            r7.setCanvas(r4)
            r7.m2416setSizeuvyYCjk(r11)
            r4.save()
            r1 = r5
            androidx.compose.ui.graphics.drawscope.DrawScope r1 = (androidx.compose.ui.graphics.drawscope.DrawScope) r1
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r6.m1958getBlack0d7_KjU()
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.ui.graphics.BlendMode$Companion r6 = androidx.compose.ui.graphics.BlendMode.Companion
            int r21 = r6.m1837getClear0nO6VwU()
            r22 = 58
            r23 = 0
            r6 = r1
            r24 = r9
            r9 = r16
            r26 = r13
            r13 = r18
            r27 = r14
            r14 = r19
            r28 = r15
            r15 = r20
            r16 = r21
            r17 = r22
            r18 = r23
            androidx.compose.ui.graphics.drawscope.DrawScope.CC.m2514drawRectnJ9OG0$default(r6, r7, r9, r11, r13, r14, r15, r16, r17, r18)
            r2.invoke(r1)
            r4.restore()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r1 = r5.getDrawParams()
            r2 = r28
            r1.setDensity(r2)
            r2 = r27
            r1.setLayoutDirection(r2)
            r2 = r26
            r1.setCanvas(r2)
            r4 = r24
            r1.m2416setSizeuvyYCjk(r4)
            r3.prepareToDraw()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderCache.m178drawBorderCacheEMwLDEs(androidx.compose.ui.draw.CacheDrawScope, long, int, kotlin.jvm.functions.Function1):androidx.compose.ui.graphics.ImageBitmap");
    }

    public final Path obtainPath() {
        Path path = this.borderPath;
        if (path != null) {
            return path;
        }
        Path Path = AndroidPath_androidKt.Path();
        this.borderPath = Path;
        return Path;
    }
}
