package androidx.compose.foundation.layout;

import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0006\u0010$\u001a\u00020!J1\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0017H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u0004\u0018\u00010\rH@ø\u0001\u0001¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\rH\u0016J)\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&2\u0006\u0010'\u001a\u00020&H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b3\u00104J-\u00105\u001a\u0002062\u0006\u00102\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:J!\u0010;\u001a\u00020&2\u0006\u0010'\u001a\u00020&H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b<\u0010=J%\u0010>\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@J\u0018\u0010A\u001a\u00020!2\u0006\u0010/\u001a\u00020\r2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020!H\u0002J%\u0010E\u001a\u0002062\u0006\u0010'\u001a\u0002062\u0006\u0010F\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006I"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "view", "Landroid/view/View;", "sideCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "animationController", "Landroid/view/WindowInsetsAnimationController;", "animationJob", "Lkotlinx/coroutines/Job;", "cancellationSignal", "Landroid/os/CancellationSignal;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "isControllerRequested", "", "partialConsumption", "", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "getView", "()Landroid/view/View;", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "adjustInsets", "", "inset", "animationEnded", "dispose", "fling", "Landroidx/compose/ui/unit/Velocity;", "available", "flingAmount", "towardShown", "fling-huYlsQE", "(JFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnimationController", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelled", "controller", "onFinished", "onPostFling", "consumed", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "onReady", "types", "", "requestAnimationController", "scroll", "scrollAmount", "scroll-8S9VItk", "(JF)J", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WindowInsetsConnection.android.kt */
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {
    /* access modifiers changed from: private */
    public WindowInsetsAnimationController animationController;
    /* access modifiers changed from: private */
    public Job animationJob;
    private final CancellationSignal cancellationSignal = new CancellationSignal();
    /* access modifiers changed from: private */
    public CancellableContinuation<? super WindowInsetsAnimationController> continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final SideCalculator sideCalculator;
    private final View view;
    private final AndroidWindowInsets windowInsets;

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets androidWindowInsets, View view2, SideCalculator sideCalculator2, Density density2) {
        Intrinsics.checkNotNullParameter(androidWindowInsets, "windowInsets");
        Intrinsics.checkNotNullParameter(view2, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(sideCalculator2, "sideCalculator");
        Intrinsics.checkNotNullParameter(density2, "density");
        this.windowInsets = androidWindowInsets;
        this.view = view2;
        this.sideCalculator = sideCalculator2;
        this.density = density2;
    }

    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    public final View getView() {
        return this.view;
    }

    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    public final Density getDensity() {
        return this.density;
    }

    /* access modifiers changed from: private */
    public final void requestAnimationController() {
        if (!this.isControllerRequested) {
            this.isControllerRequested = true;
            WindowInsetsController windowInsetsController = this.view.getWindowInsetsController();
            if (windowInsetsController != null) {
                windowInsetsController.controlWindowInsetsAnimation(this.windowInsets.getType$foundation_layout_release(), -1, (Interpolator) null, this.cancellationSignal, (WindowInsetsAnimationControlListener) this);
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object getAnimationController(Continuation<? super WindowInsetsAnimationController> continuation2) {
        Object obj = this.animationController;
        if (obj == null) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation2), 1);
            cancellableContinuationImpl.initCancellability();
            this.continuation = cancellableContinuationImpl;
            requestAnimationController();
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation2);
            }
        }
        return obj;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m609onPreScrollOzD1aCk(long j, int i) {
        return m605scroll8S9VItk(j, this.sideCalculator.hideMotion(Offset.m1683getXimpl(j), Offset.m1684getYimpl(j)));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m607onPostScrollDzOQY0M(long j, long j2, int i) {
        return m605scroll8S9VItk(j2, this.sideCalculator.showMotion(Offset.m1683getXimpl(j2), Offset.m1684getYimpl(j2)));
    }

    /* renamed from: scroll-8S9VItk  reason: not valid java name */
    private final long m605scroll8S9VItk(long j, float f) {
        Job job = this.animationJob;
        boolean z = true;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            this.animationJob = null;
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (!(f == 0.0f)) {
            boolean isVisible = this.windowInsets.isVisible();
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i <= 0) {
                z = false;
            }
            if (!(isVisible == z && windowInsetsAnimationController == null)) {
                if (windowInsetsAnimationController == null) {
                    this.partialConsumption = 0.0f;
                    requestAnimationController();
                    return this.sideCalculator.m555consumedOffsetsMKHz9U(j);
                }
                SideCalculator sideCalculator2 = this.sideCalculator;
                Insets hiddenStateInsets = windowInsetsAnimationController.getHiddenStateInsets();
                Intrinsics.checkNotNullExpressionValue(hiddenStateInsets, "animationController.hiddenStateInsets");
                int valueOf = sideCalculator2.valueOf(hiddenStateInsets);
                SideCalculator sideCalculator3 = this.sideCalculator;
                Insets shownStateInsets = windowInsetsAnimationController.getShownStateInsets();
                Intrinsics.checkNotNullExpressionValue(shownStateInsets, "animationController.shownStateInsets");
                int valueOf2 = sideCalculator3.valueOf(shownStateInsets);
                Insets currentInsets = windowInsetsAnimationController.getCurrentInsets();
                Intrinsics.checkNotNullExpressionValue(currentInsets, "animationController.currentInsets");
                int valueOf3 = this.sideCalculator.valueOf(currentInsets);
                if (valueOf3 == (i > 0 ? valueOf2 : valueOf)) {
                    this.partialConsumption = 0.0f;
                    return Offset.Companion.m1699getZeroF1C5BW0();
                }
                float f2 = ((float) valueOf3) + f + this.partialConsumption;
                int coerceIn = RangesKt.coerceIn(MathKt.roundToInt(f2), valueOf, valueOf2);
                this.partialConsumption = f2 - ((float) MathKt.roundToInt(f2));
                if (coerceIn != valueOf3) {
                    windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, coerceIn), 1.0f, 0.0f);
                }
                return this.sideCalculator.m555consumedOffsetsMKHz9U(j);
            }
        }
        return Offset.Companion.m1699getZeroF1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object m608onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation2) {
        return m604flinghuYlsQE(j, this.sideCalculator.hideMotion(Velocity.m4929getXimpl(j), Velocity.m4930getYimpl(j)), false, continuation2);
    }

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m606onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation2) {
        return m604flinghuYlsQE(j2, this.sideCalculator.showMotion(Velocity.m4929getXimpl(j2), Velocity.m4930getYimpl(j2)), true, continuation2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* renamed from: fling-huYlsQE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m604flinghuYlsQE(long r27, float r29, boolean r30, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r31) {
        /*
            r26 = this;
            r0 = r26
            r1 = r29
            r2 = r30
            r3 = r31
            boolean r4 = r3 instanceof androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1
            if (r4 == 0) goto L_0x001c
            r4 = r3
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1 r4 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0021
        L_0x001c:
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1 r4 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$1
            r4.<init>(r0, r3)
        L_0x0021:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 3
            r8 = 2
            r10 = 0
            r11 = 0
            r12 = 1
            if (r6 == 0) goto L_0x0064
            if (r6 == r12) goto L_0x0058
            if (r6 == r8) goto L_0x0049
            if (r6 != r7) goto L_0x0041
            long r1 = r4.J$0
            java.lang.Object r4 = r4.L$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r4 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r4
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x015a
        L_0x0041:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0049:
            long r1 = r4.J$0
            java.lang.Object r5 = r4.L$1
            kotlin.jvm.internal.Ref$FloatRef r5 = (kotlin.jvm.internal.Ref.FloatRef) r5
            java.lang.Object r4 = r4.L$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r4 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r4
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x0198
        L_0x0058:
            float r1 = r4.F$0
            long r13 = r4.J$0
            java.lang.Object r2 = r4.L$0
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection r2 = (androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection) r2
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x00a8
        L_0x0064:
            kotlin.ResultKt.throwOnFailure(r3)
            kotlinx.coroutines.Job r3 = r0.animationJob
            if (r3 == 0) goto L_0x006e
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r3, (java.util.concurrent.CancellationException) r10, (int) r12, (java.lang.Object) r10)
        L_0x006e:
            r0.animationJob = r10
            r0.partialConsumption = r11
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0078
            r3 = 1
            goto L_0x0079
        L_0x0078:
            r3 = 0
        L_0x0079:
            if (r3 == 0) goto L_0x007d
            if (r2 == 0) goto L_0x0089
        L_0x007d:
            android.view.WindowInsetsAnimationController r3 = r0.animationController
            if (r3 != 0) goto L_0x0094
            androidx.compose.foundation.layout.AndroidWindowInsets r3 = r0.windowInsets
            boolean r3 = r3.isVisible()
            if (r3 != r2) goto L_0x0094
        L_0x0089:
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.Companion
            long r1 = r1.m4940getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m4920boximpl(r1)
            return r1
        L_0x0094:
            r4.L$0 = r0
            r2 = r27
            r4.J$0 = r2
            r4.F$0 = r1
            r4.label = r12
            java.lang.Object r6 = r0.getAnimationController(r4)
            if (r6 != r5) goto L_0x00a5
            return r5
        L_0x00a5:
            r13 = r2
            r3 = r6
            r2 = r0
        L_0x00a8:
            android.view.WindowInsetsAnimationController r3 = (android.view.WindowInsetsAnimationController) r3
            if (r3 != 0) goto L_0x00b7
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.Companion
            long r1 = r1.m4940getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m4920boximpl(r1)
            return r1
        L_0x00b7:
            androidx.compose.foundation.layout.SideCalculator r6 = r2.sideCalculator
            android.graphics.Insets r15 = r3.getHiddenStateInsets()
            java.lang.String r9 = "animationController.hiddenStateInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r9)
            int r6 = r6.valueOf(r15)
            androidx.compose.foundation.layout.SideCalculator r9 = r2.sideCalculator
            android.graphics.Insets r15 = r3.getShownStateInsets()
            java.lang.String r12 = "animationController.shownStateInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r12)
            int r9 = r9.valueOf(r15)
            android.graphics.Insets r12 = r3.getCurrentInsets()
            java.lang.String r15 = "animationController.currentInsets"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            androidx.compose.foundation.layout.SideCalculator r15 = r2.sideCalculator
            int r12 = r15.valueOf(r12)
            int r15 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r15 > 0) goto L_0x00ea
            if (r12 == r6) goto L_0x00f0
        L_0x00ea:
            int r15 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r15 < 0) goto L_0x0105
            if (r12 != r9) goto L_0x0105
        L_0x00f0:
            if (r12 != r9) goto L_0x00f4
            r9 = 1
            goto L_0x00f5
        L_0x00f4:
            r9 = 0
        L_0x00f5:
            r3.finish(r9)
            r2.animationController = r10
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.Companion
            long r1 = r1.m4940getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m4920boximpl(r1)
            return r1
        L_0x0105:
            androidx.compose.foundation.layout.SplineBasedFloatDecayAnimationSpec r10 = new androidx.compose.foundation.layout.SplineBasedFloatDecayAnimationSpec
            androidx.compose.ui.unit.Density r15 = r2.density
            r10.<init>(r15)
            float r15 = (float) r12
            float r17 = r10.flingDistance(r1)
            float r15 = r15 + r17
            float r8 = (float) r6
            float r17 = r15 - r8
            int r11 = r9 - r6
            float r11 = (float) r11
            float r17 = r17 / r11
            r11 = 1056964608(0x3f000000, float:0.5)
            int r11 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x0124
            r24 = 1
            goto L_0x0126
        L_0x0124:
            r24 = 0
        L_0x0126:
            if (r24 == 0) goto L_0x012b
            r18 = r9
            goto L_0x012d
        L_0x012b:
            r18 = r6
        L_0x012d:
            float r11 = (float) r9
            int r11 = (r15 > r11 ? 1 : (r15 == r11 ? 0 : -1))
            if (r11 > 0) goto L_0x0166
            int r8 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0137
            goto L_0x0166
        L_0x0137:
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3 r6 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3
            r22 = 0
            r15 = r6
            r16 = r2
            r17 = r12
            r19 = r1
            r20 = r3
            r21 = r24
            r15.<init>(r16, r17, r18, r19, r20, r21, r22)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r4.L$0 = r2
            r4.J$0 = r13
            r4.label = r7
            java.lang.Object r1 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r4)
            if (r1 != r5) goto L_0x0158
            return r5
        L_0x0158:
            r4 = r2
            r1 = r13
        L_0x015a:
            androidx.compose.foundation.layout.SideCalculator r3 = r4.sideCalculator
            r4 = 0
            long r1 = r3.m556consumedVelocityQWom1Mo(r1, r4)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m4920boximpl(r1)
            return r1
        L_0x0166:
            kotlin.jvm.internal.Ref$FloatRef r7 = new kotlin.jvm.internal.Ref$FloatRef
            r7.<init>()
            androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2 r8 = new androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2
            r25 = 0
            r15 = r8
            r16 = r2
            r17 = r12
            r18 = r1
            r19 = r10
            r20 = r6
            r21 = r9
            r22 = r7
            r23 = r3
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r4.L$0 = r2
            r4.L$1 = r7
            r4.J$0 = r13
            r1 = 2
            r4.label = r1
            java.lang.Object r1 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r8, r4)
            if (r1 != r5) goto L_0x0195
            return r5
        L_0x0195:
            r4 = r2
            r5 = r7
            r1 = r13
        L_0x0198:
            androidx.compose.foundation.layout.SideCalculator r3 = r4.sideCalculator
            float r4 = r5.element
            long r1 = r3.m556consumedVelocityQWom1Mo(r1, r4)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m4920boximpl(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.m604flinghuYlsQE(long, float, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void adjustInsets(float f) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            Insets currentInsets = windowInsetsAnimationController.getCurrentInsets();
            Intrinsics.checkNotNullExpressionValue(currentInsets, "it.currentInsets");
            windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, MathKt.roundToInt(f)), 1.0f, 0.0f);
        }
    }

    public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i) {
        Intrinsics.checkNotNullParameter(windowInsetsAnimationController, "controller");
        this.animationController = windowInsetsAnimationController;
        this.isControllerRequested = false;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(windowInsetsAnimationController, WindowInsetsNestedScrollConnection$onReady$1.INSTANCE);
        }
        this.continuation = null;
    }

    public final void dispose() {
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(null, WindowInsetsNestedScrollConnection$dispose$1.INSTANCE);
        }
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.finish(!Intrinsics.areEqual((Object) windowInsetsAnimationController.getCurrentInsets(), (Object) windowInsetsAnimationController.getHiddenStateInsets()));
        }
    }

    public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
        Intrinsics.checkNotNullParameter(windowInsetsAnimationController, "controller");
        animationEnded();
    }

    public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
        animationEnded();
    }

    private final void animationEnded() {
        WindowInsetsAnimationController windowInsetsAnimationController;
        WindowInsetsAnimationController windowInsetsAnimationController2 = this.animationController;
        if ((windowInsetsAnimationController2 != null && windowInsetsAnimationController2.isReady()) && (windowInsetsAnimationController = this.animationController) != null) {
            windowInsetsAnimationController.finish(this.windowInsets.isVisible());
        }
        this.animationController = null;
        CancellableContinuation<? super WindowInsetsAnimationController> cancellableContinuation = this.continuation;
        if (cancellableContinuation != null) {
            cancellableContinuation.resume(null, WindowInsetsNestedScrollConnection$animationEnded$1.INSTANCE);
        }
        this.continuation = null;
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.animationJob = null;
        this.partialConsumption = 0.0f;
        this.isControllerRequested = false;
    }
}
