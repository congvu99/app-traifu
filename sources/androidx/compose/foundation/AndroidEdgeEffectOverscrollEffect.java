package androidx.compose.foundation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00101\u001a\u00020&H\u0002J!\u00102\u001a\u00020&2\u0006\u00103\u001a\u000204H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b5\u00106J-\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020;H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J!\u0010>\u001a\u0002042\u0006\u00103\u001a\u000204H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b?\u00106J%\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020*2\u0006\u0010:\u001a\u00020;H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\b\u0010D\u001a\u00020&H\u0002J%\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ%\u0010K\u001a\u00020F2\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010JJ%\u0010M\u001a\u00020F2\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010JJ%\u0010O\u001a\u00020F2\u0006\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010JJ\u001d\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020*H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010TJ\b\u0010U\u001a\u00020\u0014H\u0002J \u0010V\u001a\u00020\u0014*\u00020W2\u0006\u0010X\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[H\u0002J \u0010\\\u001a\u00020\u0014*\u00020W2\u0006\u0010]\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[H\u0002J\n\u0010^\u001a\u00020&*\u00020WJ \u0010_\u001a\u00020\u0014*\u00020W2\u0006\u0010`\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[H\u0002J \u0010a\u001a\u00020\u0014*\u00020W2\u0006\u0010b\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\rX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00148V@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u000e\u0010!\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010'\u001a\u0004\u0018\u00010(X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0019\u0010)\u001a\u0004\u0018\u00010*X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020&0\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006c"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "allEffects", "", "Landroid/widget/EdgeEffect;", "bottomEffect", "bottomEffectNegation", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "value", "isEnabled", "setEnabled", "isEnabledState", "Landroidx/compose/runtime/MutableState;", "isInProgress", "leftEffect", "leftEffectNegation", "onNewSize", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "redrawSignal", "rightEffect", "rightEffectNegation", "scrollCycleInProgress", "topEffect", "topEffectNegation", "animateToRelease", "consumePostFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "consumePostFling-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePostScroll", "initialDragDelta", "overscrollDelta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "consumePostScroll-OMhpSzk", "(JJI)V", "consumePreFling", "consumePreFling-QWom1Mo", "consumePreScroll", "scrollDelta", "consumePreScroll-OzD1aCk", "(JI)J", "invalidateOverscroll", "pullBottom", "", "scroll", "displacement", "pullBottom-0a9Yr6o", "(JJ)F", "pullLeft", "pullLeft-0a9Yr6o", "pullRight", "pullRight-0a9Yr6o", "pullTop", "pullTop-0a9Yr6o", "releaseOppositeOverscroll", "delta", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "drawBottom", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "bottom", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeft", "left", "drawOverscroll", "drawRight", "right", "drawTop", "top", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidOverscroll.kt */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    private final List<EdgeEffect> allEffects;
    /* access modifiers changed from: private */
    public final EdgeEffect bottomEffect;
    /* access modifiers changed from: private */
    public final EdgeEffect bottomEffectNegation;
    /* access modifiers changed from: private */
    public long containerSize;
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    private boolean isEnabled;
    private final MutableState<Boolean> isEnabledState;
    /* access modifiers changed from: private */
    public final EdgeEffect leftEffect;
    /* access modifiers changed from: private */
    public final EdgeEffect leftEffectNegation;
    private final Function1<IntSize, Unit> onNewSize;
    private final OverscrollConfiguration overscrollConfig;
    /* access modifiers changed from: private */
    public PointerId pointerId;
    /* access modifiers changed from: private */
    public Offset pointerPosition;
    private final MutableState<Unit> redrawSignal;
    /* access modifiers changed from: private */
    public final EdgeEffect rightEffect;
    /* access modifiers changed from: private */
    public final EdgeEffect rightEffectNegation;
    private boolean scrollCycleInProgress;
    /* access modifiers changed from: private */
    public final EdgeEffect topEffect;
    /* access modifiers changed from: private */
    public final EdgeEffect topEffectNegation;

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(overscrollConfiguration, "overscrollConfig");
        this.overscrollConfig = overscrollConfiguration;
        this.topEffect = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.bottomEffect = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.leftEffect = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        EdgeEffect create = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.rightEffect = create;
        this.allEffects = CollectionsKt.listOf(this.leftEffect, this.topEffect, create, this.bottomEffect);
        this.topEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.bottomEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.leftEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.rightEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).setColor(ColorKt.m1987toArgb8_81llA(this.overscrollConfig.m250getGlowColor0d7_KjU()));
        }
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.m1761getZeroNHjbRc();
        this.isEnabledState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onNewSize = new AndroidEdgeEffectOverscrollEffect$onNewSize$1(this);
        this.effectModifier = OnRemeasuredModifierKt.onSizeChanged(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion.then(AndroidOverscrollKt.StretchOverscrollNonClippingLayer), (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, (Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1>) null)), this.onNewSize).then(new DrawOverscrollModifier(this, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1(this) : InspectableValueKt.getNoInspectorInfo()));
    }

    public final boolean getInvalidationEnabled$foundation_release() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0105  */
    /* renamed from: consumePreScroll-OzD1aCk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m168consumePreScrollOzD1aCk(long r8, int r10) {
        /*
            r7 = this;
            long r0 = r7.containerSize
            boolean r10 = androidx.compose.ui.geometry.Size.m1754isEmptyimpl(r0)
            if (r10 == 0) goto L_0x000f
            androidx.compose.ui.geometry.Offset$Companion r8 = androidx.compose.ui.geometry.Offset.Companion
            long r8 = r8.m1699getZeroF1C5BW0()
            return r8
        L_0x000f:
            boolean r10 = r7.scrollCycleInProgress
            r0 = 1
            if (r10 != 0) goto L_0x0019
            r7.stopOverscrollAnimation()
            r7.scrollCycleInProgress = r0
        L_0x0019:
            androidx.compose.ui.geometry.Offset r10 = r7.pointerPosition
            if (r10 == 0) goto L_0x0022
            long r1 = r10.m1693unboximpl()
            goto L_0x0028
        L_0x0022:
            long r1 = r7.containerSize
            long r1 = androidx.compose.ui.geometry.SizeKt.m1762getCenteruvyYCjk(r1)
        L_0x0028:
            float r10 = androidx.compose.ui.geometry.Offset.m1684getYimpl(r8)
            r3 = 0
            r4 = 0
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x0034
            r10 = 1
            goto L_0x0035
        L_0x0034:
            r10 = 0
        L_0x0035:
            if (r10 == 0) goto L_0x0039
        L_0x0037:
            r10 = 0
            goto L_0x0090
        L_0x0039:
            androidx.compose.foundation.EdgeEffectCompat r10 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r5 = r7.topEffect
            float r10 = r10.getDistanceCompat(r5)
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x0047
            r10 = 1
            goto L_0x0048
        L_0x0047:
            r10 = 0
        L_0x0048:
            if (r10 != 0) goto L_0x0065
            float r10 = r7.m163pullTop0a9Yr6o(r8, r1)
            androidx.compose.foundation.EdgeEffectCompat r5 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r6 = r7.topEffect
            float r5 = r5.getDistanceCompat(r6)
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x005c
            r5 = 1
            goto L_0x005d
        L_0x005c:
            r5 = 0
        L_0x005d:
            if (r5 == 0) goto L_0x0090
            android.widget.EdgeEffect r5 = r7.topEffect
            r5.onRelease()
            goto L_0x0090
        L_0x0065:
            androidx.compose.foundation.EdgeEffectCompat r10 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r5 = r7.bottomEffect
            float r10 = r10.getDistanceCompat(r5)
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x0073
            r10 = 1
            goto L_0x0074
        L_0x0073:
            r10 = 0
        L_0x0074:
            if (r10 != 0) goto L_0x0037
            float r10 = r7.m160pullBottom0a9Yr6o(r8, r1)
            androidx.compose.foundation.EdgeEffectCompat r5 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r6 = r7.bottomEffect
            float r5 = r5.getDistanceCompat(r6)
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x0088
            r5 = 1
            goto L_0x0089
        L_0x0088:
            r5 = 0
        L_0x0089:
            if (r5 == 0) goto L_0x0090
            android.widget.EdgeEffect r5 = r7.bottomEffect
            r5.onRelease()
        L_0x0090:
            float r5 = androidx.compose.ui.geometry.Offset.m1683getXimpl(r8)
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x009a
            r5 = 1
            goto L_0x009b
        L_0x009a:
            r5 = 0
        L_0x009b:
            if (r5 == 0) goto L_0x009e
            goto L_0x00f5
        L_0x009e:
            androidx.compose.foundation.EdgeEffectCompat r5 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r6 = r7.leftEffect
            float r5 = r5.getDistanceCompat(r6)
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x00ac
            r5 = 1
            goto L_0x00ad
        L_0x00ac:
            r5 = 0
        L_0x00ad:
            if (r5 != 0) goto L_0x00ca
            float r8 = r7.m161pullLeft0a9Yr6o(r8, r1)
            androidx.compose.foundation.EdgeEffectCompat r9 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r1 = r7.leftEffect
            float r9 = r9.getDistanceCompat(r1)
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 != 0) goto L_0x00c0
            goto L_0x00c1
        L_0x00c0:
            r0 = 0
        L_0x00c1:
            if (r0 == 0) goto L_0x00c8
            android.widget.EdgeEffect r9 = r7.leftEffect
            r9.onRelease()
        L_0x00c8:
            r4 = r8
            goto L_0x00f5
        L_0x00ca:
            androidx.compose.foundation.EdgeEffectCompat r5 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r6 = r7.rightEffect
            float r5 = r5.getDistanceCompat(r6)
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x00d8
            r5 = 1
            goto L_0x00d9
        L_0x00d8:
            r5 = 0
        L_0x00d9:
            if (r5 != 0) goto L_0x00f5
            float r8 = r7.m162pullRight0a9Yr6o(r8, r1)
            androidx.compose.foundation.EdgeEffectCompat r9 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r1 = r7.rightEffect
            float r9 = r9.getDistanceCompat(r1)
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 != 0) goto L_0x00ec
            goto L_0x00ed
        L_0x00ec:
            r0 = 0
        L_0x00ed:
            if (r0 == 0) goto L_0x00c8
            android.widget.EdgeEffect r9 = r7.rightEffect
            r9.onRelease()
            goto L_0x00c8
        L_0x00f5:
            long r8 = androidx.compose.ui.geometry.OffsetKt.Offset(r4, r10)
            androidx.compose.ui.geometry.Offset$Companion r10 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r10.m1699getZeroF1C5BW0()
            boolean r10 = androidx.compose.ui.geometry.Offset.m1680equalsimpl0(r8, r0)
            if (r10 != 0) goto L_0x0108
            r7.invalidateOverscroll()
        L_0x0108:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m168consumePreScrollOzD1aCk(long, int):long");
    }

    /* renamed from: consumePostScroll-OMhpSzk  reason: not valid java name */
    public void m166consumePostScrollOMhpSzk(long j, long j2, int i) {
        boolean z;
        if (!Size.m1754isEmptyimpl(this.containerSize)) {
            boolean z2 = true;
            if (NestedScrollSource.m3322equalsimpl0(i, NestedScrollSource.Companion.m3327getDragWNlRxjI())) {
                Offset offset = this.pointerPosition;
                long r2 = offset != null ? offset.m1693unboximpl() : SizeKt.m1762getCenteruvyYCjk(this.containerSize);
                if (Offset.m1683getXimpl(j2) > 0.0f) {
                    m161pullLeft0a9Yr6o(j2, r2);
                } else if (Offset.m1683getXimpl(j2) < 0.0f) {
                    m162pullRight0a9Yr6o(j2, r2);
                }
                if (Offset.m1684getYimpl(j2) > 0.0f) {
                    m163pullTop0a9Yr6o(j2, r2);
                } else if (Offset.m1684getYimpl(j2) < 0.0f) {
                    m160pullBottom0a9Yr6o(j2, r2);
                }
                z = !Offset.m1680equalsimpl0(j2, Offset.Companion.m1699getZeroF1C5BW0());
            } else {
                z = false;
            }
            if (!m164releaseOppositeOverscrollk4lQ0M(j) && !z) {
                z2 = false;
            }
            if (z2) {
                invalidateOverscroll();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00db  */
    /* renamed from: consumePreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m167consumePreFlingQWom1Mo(long r6, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r8) {
        /*
            r5 = this;
            long r0 = r5.containerSize
            boolean r8 = androidx.compose.ui.geometry.Size.m1754isEmptyimpl(r0)
            if (r8 == 0) goto L_0x0013
            androidx.compose.ui.unit.Velocity$Companion r6 = androidx.compose.ui.unit.Velocity.Companion
            long r6 = r6.m4940getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m4920boximpl(r6)
            return r6
        L_0x0013:
            float r8 = androidx.compose.ui.unit.Velocity.m4929getXimpl(r6)
            r0 = 1
            r1 = 0
            r2 = 0
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0043
            androidx.compose.foundation.EdgeEffectCompat r8 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r3 = r5.leftEffect
            float r8 = r8.getDistanceCompat(r3)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x002c
            r8 = 1
            goto L_0x002d
        L_0x002c:
            r8 = 0
        L_0x002d:
            if (r8 != 0) goto L_0x0043
            androidx.compose.foundation.EdgeEffectCompat r8 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r3 = r5.leftEffect
            float r4 = androidx.compose.ui.unit.Velocity.m4929getXimpl(r6)
            int r4 = kotlin.math.MathKt.roundToInt((float) r4)
            r8.onAbsorbCompat(r3, r4)
            float r8 = androidx.compose.ui.unit.Velocity.m4929getXimpl(r6)
            goto L_0x0072
        L_0x0043:
            float r8 = androidx.compose.ui.unit.Velocity.m4929getXimpl(r6)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x0071
            androidx.compose.foundation.EdgeEffectCompat r8 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r3 = r5.rightEffect
            float r8 = r8.getDistanceCompat(r3)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0059
            r8 = 1
            goto L_0x005a
        L_0x0059:
            r8 = 0
        L_0x005a:
            if (r8 != 0) goto L_0x0071
            androidx.compose.foundation.EdgeEffectCompat r8 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r3 = r5.rightEffect
            float r4 = androidx.compose.ui.unit.Velocity.m4929getXimpl(r6)
            int r4 = kotlin.math.MathKt.roundToInt((float) r4)
            int r4 = -r4
            r8.onAbsorbCompat(r3, r4)
            float r8 = androidx.compose.ui.unit.Velocity.m4929getXimpl(r6)
            goto L_0x0072
        L_0x0071:
            r8 = 0
        L_0x0072:
            float r3 = androidx.compose.ui.unit.Velocity.m4930getYimpl(r6)
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x009f
            androidx.compose.foundation.EdgeEffectCompat r3 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r5.topEffect
            float r3 = r3.getDistanceCompat(r4)
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0088
            r3 = 1
            goto L_0x0089
        L_0x0088:
            r3 = 0
        L_0x0089:
            if (r3 != 0) goto L_0x009f
            androidx.compose.foundation.EdgeEffectCompat r0 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r1 = r5.topEffect
            float r2 = androidx.compose.ui.unit.Velocity.m4930getYimpl(r6)
            int r2 = kotlin.math.MathKt.roundToInt((float) r2)
            r0.onAbsorbCompat(r1, r2)
            float r2 = androidx.compose.ui.unit.Velocity.m4930getYimpl(r6)
            goto L_0x00cb
        L_0x009f:
            float r3 = androidx.compose.ui.unit.Velocity.m4930getYimpl(r6)
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x00cb
            androidx.compose.foundation.EdgeEffectCompat r3 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r5.bottomEffect
            float r3 = r3.getDistanceCompat(r4)
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            r0 = 0
        L_0x00b5:
            if (r0 != 0) goto L_0x00cb
            androidx.compose.foundation.EdgeEffectCompat r0 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r1 = r5.bottomEffect
            float r2 = androidx.compose.ui.unit.Velocity.m4930getYimpl(r6)
            int r2 = kotlin.math.MathKt.roundToInt((float) r2)
            int r2 = -r2
            r0.onAbsorbCompat(r1, r2)
            float r2 = androidx.compose.ui.unit.Velocity.m4930getYimpl(r6)
        L_0x00cb:
            long r6 = androidx.compose.ui.unit.VelocityKt.Velocity(r8, r2)
            androidx.compose.ui.unit.Velocity$Companion r8 = androidx.compose.ui.unit.Velocity.Companion
            long r0 = r8.m4940getZero9UxMQ8M()
            boolean r8 = androidx.compose.ui.unit.Velocity.m4928equalsimpl0(r6, r0)
            if (r8 != 0) goto L_0x00de
            r5.invalidateOverscroll()
        L_0x00de:
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m4920boximpl(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m167consumePreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: consumePostFling-sF-c-tU  reason: not valid java name */
    public Object m165consumePostFlingsFctU(long j, Continuation<? super Unit> continuation) {
        if (Size.m1754isEmptyimpl(this.containerSize)) {
            return Unit.INSTANCE;
        }
        this.scrollCycleInProgress = false;
        if (Velocity.m4929getXimpl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.leftEffect, MathKt.roundToInt(Velocity.m4929getXimpl(j)));
        } else if (Velocity.m4929getXimpl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.rightEffect, -MathKt.roundToInt(Velocity.m4929getXimpl(j)));
        }
        if (Velocity.m4930getYimpl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.topEffect, MathKt.roundToInt(Velocity.m4930getYimpl(j)));
        } else if (Velocity.m4930getYimpl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.bottomEffect, -MathKt.roundToInt(Velocity.m4930getYimpl(j)));
        }
        if (!Velocity.m4928equalsimpl0(j, Velocity.Companion.m4940getZero9UxMQ8M())) {
            invalidateOverscroll();
        }
        animateToRelease();
        return Unit.INSTANCE;
    }

    public boolean isEnabled() {
        return this.isEnabledState.getValue().booleanValue();
    }

    public void setEnabled(boolean z) {
        boolean z2 = this.isEnabled != z;
        this.isEnabledState.setValue(Boolean.valueOf(z));
        this.isEnabled = z;
        if (z2) {
            this.scrollCycleInProgress = false;
            animateToRelease();
        }
    }

    public boolean isInProgress() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(list.get(i)) == 0.0f)) {
                return true;
            }
        }
        return false;
    }

    private final boolean stopOverscrollAnimation() {
        boolean z;
        long r0 = SizeKt.m1762getCenteruvyYCjk(this.containerSize);
        boolean z2 = false;
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f)) {
            m161pullLeft0a9Yr6o(Offset.Companion.m1699getZeroF1C5BW0(), r0);
            z = true;
        } else {
            z = false;
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f)) {
            m162pullRight0a9Yr6o(Offset.Companion.m1699getZeroF1C5BW0(), r0);
            z = true;
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f)) {
            m163pullTop0a9Yr6o(Offset.Companion.m1699getZeroF1C5BW0(), r0);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
            z2 = true;
        }
        if (z2) {
            return z;
        }
        m160pullBottom0a9Yr6o(Offset.Companion.m1699getZeroF1C5BW0(), r0);
        return true;
    }

    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final void drawOverscroll(DrawScope drawScope) {
        boolean z;
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (!Size.m1754isEmptyimpl(this.containerSize)) {
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            this.redrawSignal.getValue();
            android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
            boolean z2 = true;
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffectNegation) == 0.0f)) {
                drawRight(drawScope, this.leftEffectNegation, nativeCanvas);
                this.leftEffectNegation.finish();
            }
            if (!this.leftEffect.isFinished()) {
                z = drawLeft(drawScope, this.leftEffect, nativeCanvas);
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect), 0.0f);
            } else {
                z = false;
            }
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffectNegation) == 0.0f)) {
                drawBottom(drawScope, this.topEffectNegation, nativeCanvas);
                this.topEffectNegation.finish();
            }
            if (!this.topEffect.isFinished()) {
                z = drawTop(drawScope, this.topEffect, nativeCanvas) || z;
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect), 0.0f);
            }
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffectNegation) == 0.0f)) {
                drawLeft(drawScope, this.rightEffectNegation, nativeCanvas);
                this.rightEffectNegation.finish();
            }
            if (!this.rightEffect.isFinished()) {
                z = drawRight(drawScope, this.rightEffect, nativeCanvas) || z;
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect), 0.0f);
            }
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffectNegation) == 0.0f)) {
                drawTop(drawScope, this.bottomEffectNegation, nativeCanvas);
                this.bottomEffectNegation.finish();
            }
            if (!this.bottomEffect.isFinished()) {
                if (!drawBottom(drawScope, this.bottomEffect, nativeCanvas) && !z) {
                    z2 = false;
                }
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect), 0.0f);
                z = z2;
            }
            if (z) {
                invalidateOverscroll();
            }
        }
    }

    private final boolean drawLeft(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m1749getHeightimpl(this.containerSize), drawScope.m4649toPx0680j_4(this.overscrollConfig.getDrawPadding().m521calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection())));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawTop(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        canvas.translate(0.0f, drawScope.m4649toPx0680j_4(this.overscrollConfig.getDrawPadding().m523calculateTopPaddingD9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawRight(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        int roundToInt = MathKt.roundToInt(Size.m1752getWidthimpl(this.containerSize));
        float r2 = this.overscrollConfig.getDrawPadding().m522calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-((float) roundToInt)) + drawScope.m4649toPx0680j_4(r2));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawBottom(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(180.0f);
        canvas.translate(-Size.m1752getWidthimpl(this.containerSize), (-Size.m1749getHeightimpl(this.containerSize)) + drawScope.m4649toPx0680j_4(this.overscrollConfig.getDrawPadding().m520calculateBottomPaddingD9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    /* access modifiers changed from: private */
    public final void invalidateOverscroll() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void animateToRelease() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            EdgeEffect edgeEffect = list.get(i);
            edgeEffect.onRelease();
            z = edgeEffect.isFinished() || z;
        }
        if (z) {
            invalidateOverscroll();
        }
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M  reason: not valid java name */
    private final boolean m164releaseOppositeOverscrollk4lQ0M(long j) {
        boolean z;
        boolean z2 = false;
        if (this.leftEffect.isFinished() || Offset.m1683getXimpl(j) >= 0.0f) {
            z = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.leftEffect, Offset.m1683getXimpl(j));
            z = this.leftEffect.isFinished();
        }
        if (!this.rightEffect.isFinished() && Offset.m1683getXimpl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.rightEffect, Offset.m1683getXimpl(j));
            z = z || this.rightEffect.isFinished();
        }
        if (!this.topEffect.isFinished() && Offset.m1684getYimpl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.topEffect, Offset.m1684getYimpl(j));
            z = z || this.topEffect.isFinished();
        }
        if (this.bottomEffect.isFinished() || Offset.m1684getYimpl(j) <= 0.0f) {
            return z;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.bottomEffect, Offset.m1684getYimpl(j));
        if (z || this.bottomEffect.isFinished()) {
            z2 = true;
        }
        return z2;
    }

    /* renamed from: pullTop-0a9Yr6o  reason: not valid java name */
    private final float m163pullTop0a9Yr6o(long j, long j2) {
        float r5 = Offset.m1683getXimpl(j2) / Size.m1752getWidthimpl(this.containerSize);
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffect, Offset.m1684getYimpl(j) / Size.m1749getHeightimpl(this.containerSize), r5) * Size.m1749getHeightimpl(this.containerSize);
    }

    /* renamed from: pullBottom-0a9Yr6o  reason: not valid java name */
    private final float m160pullBottom0a9Yr6o(long j, long j2) {
        float r5 = Offset.m1683getXimpl(j2) / Size.m1752getWidthimpl(this.containerSize);
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffect, -(Offset.m1684getYimpl(j) / Size.m1749getHeightimpl(this.containerSize)), ((float) 1) - r5)) * Size.m1749getHeightimpl(this.containerSize);
    }

    /* renamed from: pullLeft-0a9Yr6o  reason: not valid java name */
    private final float m161pullLeft0a9Yr6o(long j, long j2) {
        float r5 = Offset.m1684getYimpl(j2) / Size.m1749getHeightimpl(this.containerSize);
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffect, Offset.m1683getXimpl(j) / Size.m1752getWidthimpl(this.containerSize), ((float) 1) - r5) * Size.m1752getWidthimpl(this.containerSize);
    }

    /* renamed from: pullRight-0a9Yr6o  reason: not valid java name */
    private final float m162pullRight0a9Yr6o(long j, long j2) {
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffect, -(Offset.m1683getXimpl(j) / Size.m1752getWidthimpl(this.containerSize)), Offset.m1684getYimpl(j2) / Size.m1749getHeightimpl(this.containerSize))) * Size.m1752getWidthimpl(this.containerSize);
    }
}
