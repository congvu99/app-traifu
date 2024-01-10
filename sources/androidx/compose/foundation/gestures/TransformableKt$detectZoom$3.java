package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoom$3", f = "Transformable.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Transformable.kt */
final class TransformableKt$detectZoom$3 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $lockedToPanZoom;
    final /* synthetic */ Ref.LongRef $pan;
    final /* synthetic */ State<Boolean> $panZoomLock;
    final /* synthetic */ Ref.BooleanRef $pastTouchSlop;
    final /* synthetic */ Ref.FloatRef $rotation;
    final /* synthetic */ PointerInputScope $this_detectZoom;
    final /* synthetic */ float $touchSlop;
    final /* synthetic */ Ref.FloatRef $zoom;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformableKt$detectZoom$3(PointerInputScope pointerInputScope, Ref.BooleanRef booleanRef, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.LongRef longRef, float f, Ref.BooleanRef booleanRef2, State<Boolean> state, Continuation<? super TransformableKt$detectZoom$3> continuation) {
        super(2, continuation);
        this.$this_detectZoom = pointerInputScope;
        this.$pastTouchSlop = booleanRef;
        this.$zoom = floatRef;
        this.$rotation = floatRef2;
        this.$pan = longRef;
        this.$touchSlop = f;
        this.$lockedToPanZoom = booleanRef2;
        this.$panZoomLock = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableKt$detectZoom$3 transformableKt$detectZoom$3 = new TransformableKt$detectZoom$3(this.$this_detectZoom, this.$pastTouchSlop, this.$zoom, this.$rotation, this.$pan, this.$touchSlop, this.$lockedToPanZoom, this.$panZoomLock, continuation);
        transformableKt$detectZoom$3.L$0 = obj;
        return transformableKt$detectZoom$3;
    }

    public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
        return ((TransformableKt$detectZoom$3) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoom$3$1", f = "Transformable.kt", i = {0}, l = {105}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$3$1  reason: invalid class name */
    /* compiled from: Transformable.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(booleanRef, floatRef, floatRef2, longRef, f, booleanRef2, state, transformScope, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0107, code lost:
            if (androidx.compose.ui.geometry.Offset.m1680equalsimpl0(r10, androidx.compose.ui.geometry.Offset.Companion.m1699getZeroF1C5BW0()) != false) goto L_0x010e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0149, code lost:
            if (r8 == false) goto L_0x014b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x012d  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0056 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r0 = r16
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L_0x0020
                if (r2 != r3) goto L_0x0018
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r17)
                r5 = r17
                r4 = r0
                goto L_0x0037
            L_0x0018:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0020:
                kotlin.ResultKt.throwOnFailure(r17)
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                r4 = r0
            L_0x0028:
                r5 = r4
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r4.L$0 = r2
                r4.label = r3
                r6 = 0
                java.lang.Object r5 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r2, r6, r5, r3, r6)
                if (r5 != r1) goto L_0x0037
                return r1
            L_0x0037:
                androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.ui.input.pointer.PointerEvent) r5
                java.util.List r6 = r5.getChanges()
                int r7 = r6.size()
                r8 = 0
                r9 = 0
            L_0x0043:
                if (r9 >= r7) goto L_0x0056
                java.lang.Object r10 = r6.get(r9)
                androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
                boolean r10 = r10.isConsumed()
                if (r10 == 0) goto L_0x0053
                r6 = 1
                goto L_0x0057
            L_0x0053:
                int r9 = r9 + 1
                goto L_0x0043
            L_0x0056:
                r6 = 0
            L_0x0057:
                if (r6 != 0) goto L_0x012b
                float r7 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateZoom(r5)
                float r9 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateRotation(r5)
                long r10 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculatePan(r5)
                kotlin.jvm.internal.Ref$BooleanRef r12 = r4
                boolean r12 = r12.element
                if (r12 != 0) goto L_0x00db
                kotlin.jvm.internal.Ref$FloatRef r12 = r5
                float r13 = r12.element
                float r13 = r13 * r7
                r12.element = r13
                kotlin.jvm.internal.Ref$FloatRef r12 = r6
                float r13 = r12.element
                float r13 = r13 + r9
                r12.element = r13
                kotlin.jvm.internal.Ref$LongRef r12 = r7
                long r13 = r12.element
                long r13 = androidx.compose.ui.geometry.Offset.m1688plusMKHz9U(r13, r10)
                r12.element = r13
                float r12 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroidSize(r5, r8)
                float r13 = (float) r3
                kotlin.jvm.internal.Ref$FloatRef r14 = r5
                float r14 = r14.element
                float r13 = r13 - r14
                float r13 = java.lang.Math.abs(r13)
                float r13 = r13 * r12
                kotlin.jvm.internal.Ref$FloatRef r14 = r6
                float r14 = r14.element
                r15 = 1078530011(0x40490fdb, float:3.1415927)
                float r14 = r14 * r15
                float r14 = r14 * r12
                r12 = 1127481344(0x43340000, float:180.0)
                float r14 = r14 / r12
                float r12 = java.lang.Math.abs(r14)
                kotlin.jvm.internal.Ref$LongRef r14 = r7
                long r14 = r14.element
                float r14 = androidx.compose.ui.geometry.Offset.m1681getDistanceimpl(r14)
                float r15 = r8
                int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r13 > 0) goto L_0x00bc
                int r13 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
                if (r13 > 0) goto L_0x00bc
                int r13 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
                if (r13 <= 0) goto L_0x00db
            L_0x00bc:
                kotlin.jvm.internal.Ref$BooleanRef r13 = r4
                r13.element = r3
                kotlin.jvm.internal.Ref$BooleanRef r13 = r9
                androidx.compose.runtime.State<java.lang.Boolean> r14 = r10
                java.lang.Object r14 = r14.getValue()
                java.lang.Boolean r14 = (java.lang.Boolean) r14
                boolean r14 = r14.booleanValue()
                if (r14 == 0) goto L_0x00d8
                float r14 = r8
                int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r12 >= 0) goto L_0x00d8
                r12 = 1
                goto L_0x00d9
            L_0x00d8:
                r12 = 0
            L_0x00d9:
                r13.element = r12
            L_0x00db:
                kotlin.jvm.internal.Ref$BooleanRef r12 = r4
                boolean r12 = r12.element
                if (r12 == 0) goto L_0x012b
                kotlin.jvm.internal.Ref$BooleanRef r12 = r9
                boolean r12 = r12.element
                r13 = 0
                if (r12 == 0) goto L_0x00e9
                r9 = 0
            L_0x00e9:
                int r12 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
                if (r12 != 0) goto L_0x00ef
                r12 = 1
                goto L_0x00f0
            L_0x00ef:
                r12 = 0
            L_0x00f0:
                if (r12 == 0) goto L_0x0109
                r12 = 1065353216(0x3f800000, float:1.0)
                int r12 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
                if (r12 != 0) goto L_0x00fa
                r12 = 1
                goto L_0x00fb
            L_0x00fa:
                r12 = 0
            L_0x00fb:
                if (r12 == 0) goto L_0x0109
                androidx.compose.ui.geometry.Offset$Companion r12 = androidx.compose.ui.geometry.Offset.Companion
                long r12 = r12.m1699getZeroF1C5BW0()
                boolean r12 = androidx.compose.ui.geometry.Offset.m1680equalsimpl0(r10, r12)
                if (r12 != 0) goto L_0x010e
            L_0x0109:
                androidx.compose.foundation.gestures.TransformScope r12 = r11
                r12.m373transformByd4ec7I(r7, r10, r9)
            L_0x010e:
                java.util.List r7 = r5.getChanges()
                int r9 = r7.size()
                r10 = 0
            L_0x0117:
                if (r10 >= r9) goto L_0x012b
                java.lang.Object r11 = r7.get(r10)
                androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                boolean r12 = androidx.compose.ui.input.pointer.PointerEventKt.positionChanged(r11)
                if (r12 == 0) goto L_0x0128
                r11.consume()
            L_0x0128:
                int r10 = r10 + 1
                goto L_0x0117
            L_0x012b:
                if (r6 != 0) goto L_0x014b
                java.util.List r5 = r5.getChanges()
                int r6 = r5.size()
                r7 = 0
            L_0x0136:
                if (r7 >= r6) goto L_0x0149
                java.lang.Object r9 = r5.get(r7)
                androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                boolean r9 = r9.getPressed()
                if (r9 == 0) goto L_0x0146
                r8 = 1
                goto L_0x0149
            L_0x0146:
                int r7 = r7 + 1
                goto L_0x0136
            L_0x0149:
                if (r8 != 0) goto L_0x0028
            L_0x014b:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt$detectZoom$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final TransformScope transformScope = (TransformScope) this.L$0;
            PointerInputScope pointerInputScope = this.$this_detectZoom;
            final Ref.BooleanRef booleanRef = this.$pastTouchSlop;
            final Ref.FloatRef floatRef = this.$zoom;
            final Ref.FloatRef floatRef2 = this.$rotation;
            final Ref.LongRef longRef = this.$pan;
            final float f = this.$touchSlop;
            final Ref.BooleanRef booleanRef2 = this.$lockedToPanZoom;
            final State<Boolean> state = this.$panZoomLock;
            this.label = 1;
            if (pointerInputScope.awaitPointerEventScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
