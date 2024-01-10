package coil.compose;

import android.os.SystemClock;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactorKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020 H\u0014J\u0012\u0010+\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J%\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J\u0018\u00101\u001a\u00020\u0016H\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b2\u0010\u0018J\u001e\u00103\u001a\u000204*\u0002052\b\u00106\u001a\u0004\u0018\u00010\u00012\u0006\u0010*\u001a\u00020 H\u0002J\f\u00107\u001a\u000204*\u000205H\u0014R/\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u00020\u00168VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R+\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R+\u0010!\u001a\u00020 2\u0006\u0010\f\u001a\u00020 8B@BX\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0014\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Lcoil/compose/CrossfadePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "start", "end", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "durationMillis", "", "fadeStart", "", "preferExactIntrinsicSize", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/layout/ContentScale;IZZ)V", "<set-?>", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "invalidateTick", "getInvalidateTick", "()I", "setInvalidateTick", "(I)V", "invalidateTick$delegate", "isDone", "", "maxAlpha", "getMaxAlpha", "()F", "setMaxAlpha", "(F)V", "maxAlpha$delegate", "startTimeMillis", "", "applyAlpha", "alpha", "applyColorFilter", "computeDrawSize", "srcSize", "dstSize", "computeDrawSize-x8L_9b0", "(JJ)J", "computeIntrinsicSize", "computeIntrinsicSize-NH-jbRc", "drawPainter", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "painter", "onDraw", "coil-compose-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CrossfadePainter.kt */
public final class CrossfadePainter extends Painter {
    private final MutableState colorFilter$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final ContentScale contentScale;
    private final int durationMillis;
    private final Painter end;
    private final boolean fadeStart;
    private final MutableState invalidateTick$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
    private boolean isDone;
    private final MutableState maxAlpha$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final boolean preferExactIntrinsicSize;
    private Painter start;
    private long startTimeMillis = -1;

    public CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale2, int i, boolean z, boolean z2) {
        this.start = painter;
        this.end = painter2;
        this.contentScale = contentScale2;
        this.durationMillis = i;
        this.fadeStart = z;
        this.preferExactIntrinsicSize = z2;
    }

    private final int getInvalidateTick() {
        return ((Number) this.invalidateTick$delegate.getValue()).intValue();
    }

    private final void setInvalidateTick(int i) {
        this.invalidateTick$delegate.setValue(Integer.valueOf(i));
    }

    private final float getMaxAlpha() {
        return ((Number) this.maxAlpha$delegate.getValue()).floatValue();
    }

    private final void setMaxAlpha(float f) {
        this.maxAlpha$delegate.setValue(Float.valueOf(f));
    }

    private final ColorFilter getColorFilter() {
        return (ColorFilter) this.colorFilter$delegate.getValue();
    }

    private final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter$delegate.setValue(colorFilter);
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m5008getIntrinsicSizeNHjbRc() {
        return m5007computeIntrinsicSizeNHjbRc();
    }

    /* access modifiers changed from: protected */
    public void onDraw(DrawScope drawScope) {
        if (this.isDone) {
            drawPainter(drawScope, this.end, getMaxAlpha());
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.startTimeMillis == -1) {
            this.startTimeMillis = uptimeMillis;
        }
        float f = ((float) (uptimeMillis - this.startTimeMillis)) / ((float) this.durationMillis);
        float coerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f) * getMaxAlpha();
        float maxAlpha = this.fadeStart ? getMaxAlpha() - coerceIn : getMaxAlpha();
        this.isDone = f >= 1.0f;
        drawPainter(drawScope, this.start, maxAlpha);
        drawPainter(drawScope, this.end, coerceIn);
        if (this.isDone) {
            this.start = null;
        } else {
            setInvalidateTick(getInvalidateTick() + 1);
        }
    }

    /* access modifiers changed from: protected */
    public boolean applyAlpha(float f) {
        setMaxAlpha(f);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean applyColorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return true;
    }

    /* renamed from: computeIntrinsicSize-NH-jbRc  reason: not valid java name */
    private final long m5007computeIntrinsicSizeNHjbRc() {
        Painter painter = this.start;
        Size size = null;
        Size r0 = painter == null ? null : Size.m1740boximpl(painter.m2613getIntrinsicSizeNHjbRc());
        long r2 = r0 == null ? Size.Companion.m1761getZeroNHjbRc() : r0.m1757unboximpl();
        Painter painter2 = this.end;
        if (painter2 != null) {
            size = Size.m1740boximpl(painter2.m2613getIntrinsicSizeNHjbRc());
        }
        long r02 = size == null ? Size.Companion.m1761getZeroNHjbRc() : size.m1757unboximpl();
        boolean z = true;
        boolean z2 = r2 != Size.Companion.m1760getUnspecifiedNHjbRc();
        if (r02 == Size.Companion.m1760getUnspecifiedNHjbRc()) {
            z = false;
        }
        if (z2 && z) {
            return SizeKt.Size(Math.max(Size.m1752getWidthimpl(r2), Size.m1752getWidthimpl(r02)), Math.max(Size.m1749getHeightimpl(r2), Size.m1749getHeightimpl(r02)));
        }
        if (this.preferExactIntrinsicSize) {
            if (z2) {
                return r2;
            }
            if (z) {
                return r02;
            }
        }
        return Size.Companion.m1760getUnspecifiedNHjbRc();
    }

    private final void drawPainter(DrawScope drawScope, Painter painter, float f) {
        if (painter != null && f > 0.0f) {
            long r0 = drawScope.m2478getSizeNHjbRc();
            long r6 = m5006computeDrawSizex8L_9b0(painter.m2613getIntrinsicSizeNHjbRc(), r0);
            if ((r0 == Size.Companion.m1760getUnspecifiedNHjbRc()) || Size.m1754isEmptyimpl(r0)) {
                painter.m2612drawx_KDEd0(drawScope, r6, f, getColorFilter());
                return;
            }
            float f2 = (float) 2;
            float r2 = (Size.m1752getWidthimpl(r0) - Size.m1752getWidthimpl(r6)) / f2;
            float r02 = (Size.m1749getHeightimpl(r0) - Size.m1749getHeightimpl(r6)) / f2;
            drawScope.getDrawContext().getTransform().inset(r2, r02, r2, r02);
            painter.m2612drawx_KDEd0(drawScope, r6, f, getColorFilter());
            float f3 = -r2;
            float f4 = -r02;
            drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
        }
    }

    /* renamed from: computeDrawSize-x8L_9b0  reason: not valid java name */
    private final long m5006computeDrawSizex8L_9b0(long j, long j2) {
        boolean z = true;
        if (!(j == Size.Companion.m1760getUnspecifiedNHjbRc()) && !Size.m1754isEmptyimpl(j)) {
            if (j2 != Size.Companion.m1760getUnspecifiedNHjbRc()) {
                z = false;
            }
            if (!z && !Size.m1754isEmptyimpl(j2)) {
                return ScaleFactorKt.m3724timesUQTWf7w(j, this.contentScale.m3579computeScaleFactorH7hwNQA(j, j2));
            }
        }
        return j2;
    }
}
