package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001fH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b&\u0010\"J-\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.J#\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020)2\u0006\u0010+\u001a\u00020,ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106J\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u0005J\u0006\u00109\u001a\u00020\u0005J'\u0010:\u001a\u00020)*\u00020;2\u0006\u0010<\u001a\u00020)2\u0006\u0010+\u001a\u00020,ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020)*\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u00106J\n\u0010?\u001a\u00020A*\u00020AJ\u0017\u0010B\u001a\u00020)*\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u00106J\u0017\u0010D\u001a\u00020\u001f*\u00020\u001fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u00106J\u0017\u0010F\u001a\u00020A*\u00020)ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HJ\u0017\u0010F\u001a\u00020A*\u00020\u001fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bI\u0010HJ\u001a\u0010J\u001a\u00020)*\u00020Aø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bK\u0010LJ\u001f\u0010M\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010N\u001a\u00020Aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010PR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006Q"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/State;Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/OverscrollEffect;)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "isNestedFlinging", "Landroidx/compose/runtime/MutableState;", "getNestedScrollDispatcher", "()Landroidx/compose/runtime/State;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getReverseDirection", "()Z", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "initialVelocity", "onDragStopped-sF-c-tU", "overscrollPostConsumeDelta", "consumedByChain", "Landroidx/compose/ui/geometry/Offset;", "availableForOverscroll", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "overscrollPostConsumeDelta-OMhpSzk", "(JJI)V", "overscrollPreConsumeDelta", "scrollDelta", "overscrollPreConsumeDelta-OzD1aCk", "(JI)J", "performRawScroll", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "registerNestedFling", "isFlinging", "shouldScrollImmediately", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "availableDelta", "dispatchScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "update", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollingLogic {
    private final FlingBehavior flingBehavior;
    private final MutableState<Boolean> isNestedFlinging = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final State<NestedScrollDispatcher> nestedScrollDispatcher;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    private final ScrollableState scrollableState;

    public ScrollingLogic(Orientation orientation2, boolean z, State<NestedScrollDispatcher> state, ScrollableState scrollableState2, FlingBehavior flingBehavior2, OverscrollEffect overscrollEffect2) {
        Intrinsics.checkNotNullParameter(orientation2, ReactVideoView.EVENT_PROP_ORIENTATION);
        Intrinsics.checkNotNullParameter(state, "nestedScrollDispatcher");
        Intrinsics.checkNotNullParameter(scrollableState2, "scrollableState");
        Intrinsics.checkNotNullParameter(flingBehavior2, "flingBehavior");
        this.orientation = orientation2;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = state;
        this.scrollableState = scrollableState2;
        this.flingBehavior = flingBehavior2;
        this.overscrollEffect = overscrollEffect2;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public final State<NestedScrollDispatcher> getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    /* renamed from: toOffset-tuRUvjQ  reason: not valid java name */
    public final long m368toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.Companion.m1699getZeroF1C5BW0();
        }
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset(f, 0.0f);
        }
        return OffsetKt.Offset(0.0f, f);
    }

    /* renamed from: singleAxisOffset-MK-Hz9U  reason: not valid java name */
    public final long m364singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m1677copydBAh8RU$default(j, 0.0f, 0.0f, 1, (Object) null) : Offset.m1677copydBAh8RU$default(j, 0.0f, 0.0f, 2, (Object) null);
    }

    /* renamed from: toFloat-k-4lQ0M  reason: not valid java name */
    public final float m367toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m1683getXimpl(j) : Offset.m1684getYimpl(j);
    }

    /* renamed from: toFloat-TH1AsA0  reason: not valid java name */
    public final float m366toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m4929getXimpl(j) : Velocity.m4930getYimpl(j);
    }

    /* renamed from: singleAxisVelocity-AH228Gc  reason: not valid java name */
    public final long m365singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m4925copyOhffZ5M$default(j, 0.0f, 0.0f, 1, (Object) null) : Velocity.m4925copyOhffZ5M$default(j, 0.0f, 0.0f, 2, (Object) null);
    }

    /* renamed from: update-QWom1Mo  reason: not valid java name */
    public final long m369updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m4925copyOhffZ5M$default(j, f, 0.0f, 2, (Object) null) : Velocity.m4925copyOhffZ5M$default(j, 0.0f, f, 1, (Object) null);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * ((float) -1) : f;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U  reason: not valid java name */
    public final long m363reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m1690timestuRUvjQ(j, -1.0f) : j;
    }

    /* renamed from: dispatchScroll-3eAAhYA  reason: not valid java name */
    public final long m358dispatchScroll3eAAhYA(ScrollScope scrollScope, long j, int i) {
        ScrollScope scrollScope2 = scrollScope;
        int i2 = i;
        Intrinsics.checkNotNullParameter(scrollScope, "$this$dispatchScroll");
        long r1 = m364singleAxisOffsetMKHz9U(j);
        long r12 = Offset.m1687minusMKHz9U(r1, m361overscrollPreConsumeDeltaOzD1aCk(r1, i2));
        NestedScrollDispatcher value = this.nestedScrollDispatcher.getValue();
        long r8 = Offset.m1687minusMKHz9U(r12, value.m3314dispatchPreScrollOzD1aCk(r12, i2));
        long r13 = m363reverseIfNeededMKHz9U(m368toOffsettuRUvjQ(scrollScope.scrollBy(m367toFloatk4lQ0M(m363reverseIfNeededMKHz9U(r8)))));
        long r10 = Offset.m1687minusMKHz9U(r8, r13);
        int i3 = i;
        long r122 = value.m3312dispatchPostScrollDzOQY0M(r13, r10, i3);
        m357overscrollPostConsumeDeltaOMhpSzk(r8, Offset.m1687minusMKHz9U(r10, r122), i3);
        return Offset.m1687minusMKHz9U(r10, r122);
    }

    /* renamed from: overscrollPreConsumeDelta-OzD1aCk  reason: not valid java name */
    public final long m361overscrollPreConsumeDeltaOzD1aCk(long j, int i) {
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        if (overscrollEffect2 == null || !overscrollEffect2.isEnabled()) {
            return Offset.Companion.m1699getZeroF1C5BW0();
        }
        return this.overscrollEffect.m254consumePreScrollOzD1aCk(j, i);
    }

    /* renamed from: overscrollPostConsumeDelta-OMhpSzk  reason: not valid java name */
    private final void m357overscrollPostConsumeDeltaOMhpSzk(long j, long j2, int i) {
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        if (overscrollEffect2 != null && overscrollEffect2.isEnabled()) {
            this.overscrollEffect.m252consumePostScrollOMhpSzk(j, j2, i);
        }
    }

    /* renamed from: performRawScroll-MK-Hz9U  reason: not valid java name */
    public final long m362performRawScrollMKHz9U(long j) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.Companion.m1699getZeroF1C5BW0();
        }
        return m368toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m367toFloatk4lQ0M(j)))));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0115 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: onDragStopped-sF-c-tU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m360onDragStoppedsFctU(long r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            r0.<init>(r12, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x006e
            if (r1 == r5) goto L_0x0064
            if (r1 == r4) goto L_0x005a
            if (r1 == r3) goto L_0x004e
            if (r1 == r2) goto L_0x0043
            if (r1 != r8) goto L_0x003b
            java.lang.Object r13 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r13 = (androidx.compose.foundation.gestures.ScrollingLogic) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0117
        L_0x003b:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0043:
            long r13 = r0.J$0
            java.lang.Object r1 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r1 = (androidx.compose.foundation.gestures.ScrollingLogic) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00f5
        L_0x004e:
            long r13 = r0.J$0
            java.lang.Object r1 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r1 = (androidx.compose.foundation.gestures.ScrollingLogic) r1
            kotlin.ResultKt.throwOnFailure(r15)
        L_0x0057:
            r9 = r1
            goto L_0x00d0
        L_0x005a:
            long r13 = r0.J$0
            java.lang.Object r1 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r1 = (androidx.compose.foundation.gestures.ScrollingLogic) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00b9
        L_0x0064:
            long r13 = r0.J$0
            java.lang.Object r1 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r1 = (androidx.compose.foundation.gestures.ScrollingLogic) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0092
        L_0x006e:
            kotlin.ResultKt.throwOnFailure(r15)
            r12.registerNestedFling(r5)
            long r13 = r12.m365singleAxisVelocityAH228Gc(r13)
            androidx.compose.foundation.OverscrollEffect r15 = r12.overscrollEffect
            if (r15 == 0) goto L_0x0099
            boolean r15 = r15.isEnabled()
            if (r15 == 0) goto L_0x0099
            androidx.compose.foundation.OverscrollEffect r15 = r12.overscrollEffect
            r0.L$0 = r12
            r0.J$0 = r13
            r0.label = r5
            java.lang.Object r15 = r15.m253consumePreFlingQWom1Mo(r13, r0)
            if (r15 != r7) goto L_0x0091
            return r7
        L_0x0091:
            r1 = r12
        L_0x0092:
            androidx.compose.ui.unit.Velocity r15 = (androidx.compose.ui.unit.Velocity) r15
            long r5 = r15.m4938unboximpl()
            goto L_0x00a0
        L_0x0099:
            androidx.compose.ui.unit.Velocity$Companion r15 = androidx.compose.ui.unit.Velocity.Companion
            long r5 = r15.m4940getZero9UxMQ8M()
            r1 = r12
        L_0x00a0:
            long r13 = androidx.compose.ui.unit.Velocity.m4932minusAH228Gc(r13, r5)
            androidx.compose.runtime.State<androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher> r15 = r1.nestedScrollDispatcher
            java.lang.Object r15 = r15.getValue()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r15 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r15
            r0.L$0 = r1
            r0.J$0 = r13
            r0.label = r4
            java.lang.Object r15 = r15.m3313dispatchPreFlingQWom1Mo(r13, r0)
            if (r15 != r7) goto L_0x00b9
            return r7
        L_0x00b9:
            androidx.compose.ui.unit.Velocity r15 = (androidx.compose.ui.unit.Velocity) r15
            long r4 = r15.m4938unboximpl()
            long r13 = androidx.compose.ui.unit.Velocity.m4932minusAH228Gc(r13, r4)
            r0.L$0 = r1
            r0.J$0 = r13
            r0.label = r3
            java.lang.Object r15 = r1.m359doFlingAnimationQWom1Mo(r13, r0)
            if (r15 != r7) goto L_0x0057
            return r7
        L_0x00d0:
            androidx.compose.ui.unit.Velocity r15 = (androidx.compose.ui.unit.Velocity) r15
            long r10 = r15.m4938unboximpl()
            androidx.compose.runtime.State<androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher> r15 = r9.nestedScrollDispatcher
            java.lang.Object r15 = r15.getValue()
            r1 = r15
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r1
            long r13 = androidx.compose.ui.unit.Velocity.m4932minusAH228Gc(r13, r10)
            r0.L$0 = r9
            r0.J$0 = r10
            r0.label = r2
            r2 = r13
            r4 = r10
            r6 = r0
            java.lang.Object r15 = r1.m3311dispatchPostFlingRZ2iAVY(r2, r4, r6)
            if (r15 != r7) goto L_0x00f3
            return r7
        L_0x00f3:
            r1 = r9
            r13 = r10
        L_0x00f5:
            androidx.compose.ui.unit.Velocity r15 = (androidx.compose.ui.unit.Velocity) r15
            long r2 = r15.m4938unboximpl()
            long r13 = androidx.compose.ui.unit.Velocity.m4932minusAH228Gc(r13, r2)
            androidx.compose.foundation.OverscrollEffect r15 = r1.overscrollEffect
            if (r15 == 0) goto L_0x0118
            boolean r15 = r15.isEnabled()
            if (r15 == 0) goto L_0x0118
            androidx.compose.foundation.OverscrollEffect r15 = r1.overscrollEffect
            r0.L$0 = r1
            r0.label = r8
            java.lang.Object r13 = r15.m251consumePostFlingsFctU(r13, r0)
            if (r13 != r7) goto L_0x0116
            return r7
        L_0x0116:
            r13 = r1
        L_0x0117:
            r1 = r13
        L_0x0118:
            r13 = 0
            r1.registerNestedFling(r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m360onDragStoppedsFctU(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: doFlingAnimation-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m359doFlingAnimationQWom1Mo(long r13, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r12, r15)
        L_0x0019:
            r4 = r0
            java.lang.Object r15 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r13 = r4.L$0
            kotlin.jvm.internal.Ref$LongRef r13 = (kotlin.jvm.internal.Ref.LongRef) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0061
        L_0x002f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            r15.element = r13
            androidx.compose.foundation.gestures.ScrollableState r1 = r12.scrollableState
            r3 = 0
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r11 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r10 = 0
            r5 = r11
            r6 = r12
            r7 = r15
            r8 = r13
            r5.<init>(r6, r7, r8, r10)
            r13 = r11
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r5 = 1
            r6 = 0
            r4.L$0 = r15
            r4.label = r2
            r2 = r3
            r3 = r13
            java.lang.Object r13 = androidx.compose.foundation.gestures.ScrollableState.CC.scroll$default(r1, r2, r3, r4, r5, r6)
            if (r13 != r0) goto L_0x0060
            return r0
        L_0x0060:
            r13 = r15
        L_0x0061:
            long r13 = r13.element
            androidx.compose.ui.unit.Velocity r13 = androidx.compose.ui.unit.Velocity.m4920boximpl(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m359doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress() && !this.isNestedFlinging.getValue().booleanValue()) {
            OverscrollEffect overscrollEffect2 = this.overscrollEffect;
            if (overscrollEffect2 != null ? overscrollEffect2.isInProgress() : false) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final void registerNestedFling(boolean z) {
        this.isNestedFlinging.setValue(Boolean.valueOf(z));
    }
}
