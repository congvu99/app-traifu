package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
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
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TransformGestureDetector.kt */
final class TransformGestureDetectorKt$detectTransformGestures$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
    final /* synthetic */ boolean $panZoomLock;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformGestureDetectorKt$detectTransformGestures$2(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2> continuation) {
        super(2, continuation);
        this.$panZoomLock = z;
        this.$onGesture = function4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformGestureDetectorKt$detectTransformGestures$2 transformGestureDetectorKt$detectTransformGestures$2 = new TransformGestureDetectorKt$detectTransformGestures$2(this.$panZoomLock, this.$onGesture, continuation);
        transformGestureDetectorKt$detectTransformGestures$2.L$0 = obj;
        return transformGestureDetectorKt$detectTransformGestures$2;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((TransformGestureDetectorKt$detectTransformGestures$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2$1", f = "TransformGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {60, 62}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitPointerEventScope", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"})
    /* renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2$1  reason: invalid class name */
    /* compiled from: TransformGestureDetector.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(z, function4, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0142, code lost:
            if (androidx.compose.ui.geometry.Offset.m1680equalsimpl0(r6, androidx.compose.ui.geometry.Offset.Companion.m1699getZeroF1C5BW0()) != false) goto L_0x0159;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0097 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00b9  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0176  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x017e  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x00b6 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                r23 = this;
                r0 = r23
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1065353216(0x3f800000, float:1.0)
                r4 = 2
                r5 = 0
                r6 = 0
                r7 = 1
                if (r2 == 0) goto L_0x0047
                if (r2 == r7) goto L_0x0033
                if (r2 != r4) goto L_0x002b
                int r2 = r0.I$1
                float r8 = r0.F$2
                int r9 = r0.I$0
                long r10 = r0.J$0
                float r12 = r0.F$1
                float r13 = r0.F$0
                java.lang.Object r14 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
                kotlin.ResultKt.throwOnFailure(r24)
                r3 = r24
                r15 = r0
                goto L_0x0098
            L_0x002b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0033:
                int r2 = r0.I$1
                float r8 = r0.F$2
                int r9 = r0.I$0
                long r10 = r0.J$0
                float r12 = r0.F$1
                float r13 = r0.F$0
                java.lang.Object r14 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
                kotlin.ResultKt.throwOnFailure(r24)
                goto L_0x007c
            L_0x0047:
                kotlin.ResultKt.throwOnFailure(r24)
                java.lang.Object r2 = r0.L$0
                r14 = r2
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
                androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
                long r10 = r2.m1699getZeroF1C5BW0()
                androidx.compose.ui.platform.ViewConfiguration r2 = r14.getViewConfiguration()
                float r8 = r2.getTouchSlop()
                r2 = r0
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r0.L$0 = r14
                r0.F$0 = r5
                r0.F$1 = r3
                r0.J$0 = r10
                r0.I$0 = r6
                r0.F$2 = r8
                r0.I$1 = r6
                r0.label = r7
                java.lang.Object r2 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r14, r6, r2)
                if (r2 != r1) goto L_0x0077
                return r1
            L_0x0077:
                r2 = 0
                r9 = 0
                r12 = 1065353216(0x3f800000, float:1.0)
                r13 = 0
            L_0x007c:
                r15 = r0
            L_0x007d:
                r3 = r15
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r15.L$0 = r14
                r15.F$0 = r13
                r15.F$1 = r12
                r15.J$0 = r10
                r15.I$0 = r9
                r15.F$2 = r8
                r15.I$1 = r2
                r15.label = r4
                r4 = 0
                java.lang.Object r3 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r14, r4, r3, r7, r4)
                if (r3 != r1) goto L_0x0098
                return r1
            L_0x0098:
                androidx.compose.ui.input.pointer.PointerEvent r3 = (androidx.compose.ui.input.pointer.PointerEvent) r3
                java.util.List r4 = r3.getChanges()
                int r5 = r4.size()
                r7 = 0
            L_0x00a3:
                if (r7 >= r5) goto L_0x00b6
                java.lang.Object r19 = r4.get(r7)
                androidx.compose.ui.input.pointer.PointerInputChange r19 = (androidx.compose.ui.input.pointer.PointerInputChange) r19
                boolean r19 = r19.isConsumed()
                if (r19 == 0) goto L_0x00b3
                r4 = 1
                goto L_0x00b7
            L_0x00b3:
                int r7 = r7 + 1
                goto L_0x00a3
            L_0x00b6:
                r4 = 0
            L_0x00b7:
                if (r4 != 0) goto L_0x0176
                float r5 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateZoom(r3)
                float r7 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateRotation(r3)
                r24 = r7
                long r6 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculatePan(r3)
                if (r9 != 0) goto L_0x010d
                float r12 = r12 * r5
                float r13 = r13 + r24
                long r10 = androidx.compose.ui.geometry.Offset.m1688plusMKHz9U(r10, r6)
                r0 = 0
                float r20 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroidSize(r3, r0)
                r18 = r1
                r0 = 1
                float r1 = (float) r0
                float r1 = r1 - r12
                float r1 = java.lang.Math.abs(r1)
                float r1 = r1 * r20
                r21 = 1078530011(0x40490fdb, float:3.1415927)
                float r21 = r21 * r13
                float r21 = r21 * r20
                r20 = 1127481344(0x43340000, float:180.0)
                float r21 = r21 / r20
                float r20 = java.lang.Math.abs(r21)
                float r21 = androidx.compose.ui.geometry.Offset.m1681getDistanceimpl(r10)
                int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
                if (r1 > 0) goto L_0x0100
                int r1 = (r20 > r8 ? 1 : (r20 == r8 ? 0 : -1))
                if (r1 > 0) goto L_0x0100
                int r1 = (r21 > r8 ? 1 : (r21 == r8 ? 0 : -1))
                if (r1 <= 0) goto L_0x0110
            L_0x0100:
                boolean r1 = r3
                if (r1 == 0) goto L_0x010a
                int r1 = (r20 > r8 ? 1 : (r20 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x010a
                r2 = 1
                goto L_0x010b
            L_0x010a:
                r2 = 0
            L_0x010b:
                r9 = 1
                goto L_0x0110
            L_0x010d:
                r18 = r1
                r0 = 1
            L_0x0110:
                if (r9 == 0) goto L_0x0178
                r1 = 0
                long r19 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroid(r3, r1)
                if (r2 == 0) goto L_0x011c
                r17 = 0
                goto L_0x011e
            L_0x011c:
                r17 = r24
            L_0x011e:
                r21 = 0
                int r22 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
                if (r22 != 0) goto L_0x0127
                r22 = 1
                goto L_0x0129
            L_0x0127:
                r22 = 0
            L_0x0129:
                r16 = 1065353216(0x3f800000, float:1.0)
                if (r22 == 0) goto L_0x0144
                int r22 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
                if (r22 != 0) goto L_0x0134
                r22 = 1
                goto L_0x0136
            L_0x0134:
                r22 = 0
            L_0x0136:
                if (r22 == 0) goto L_0x0144
                androidx.compose.ui.geometry.Offset$Companion r22 = androidx.compose.ui.geometry.Offset.Companion
                long r0 = r22.m1699getZeroF1C5BW0()
                boolean r0 = androidx.compose.ui.geometry.Offset.m1680equalsimpl0(r6, r0)
                if (r0 != 0) goto L_0x0159
            L_0x0144:
                kotlin.jvm.functions.Function4<androidx.compose.ui.geometry.Offset, androidx.compose.ui.geometry.Offset, java.lang.Float, java.lang.Float, kotlin.Unit> r0 = r4
                androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m1672boximpl(r19)
                androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m1672boximpl(r6)
                java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
                java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r17)
                r0.invoke(r1, r6, r5, r7)
            L_0x0159:
                java.util.List r0 = r3.getChanges()
                int r1 = r0.size()
                r5 = 0
            L_0x0162:
                if (r5 >= r1) goto L_0x017c
                java.lang.Object r6 = r0.get(r5)
                androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.positionChanged(r6)
                if (r7 == 0) goto L_0x0173
                r6.consume()
            L_0x0173:
                int r5 = r5 + 1
                goto L_0x0162
            L_0x0176:
                r18 = r1
            L_0x0178:
                r16 = 1065353216(0x3f800000, float:1.0)
                r21 = 0
            L_0x017c:
                if (r4 != 0) goto L_0x01a8
                java.util.List r0 = r3.getChanges()
                int r1 = r0.size()
                r3 = 0
            L_0x0187:
                if (r3 >= r1) goto L_0x019a
                java.lang.Object r4 = r0.get(r3)
                androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                boolean r4 = r4.getPressed()
                if (r4 == 0) goto L_0x0197
                r0 = 1
                goto L_0x019b
            L_0x0197:
                int r3 = r3 + 1
                goto L_0x0187
            L_0x019a:
                r0 = 0
            L_0x019b:
                if (r0 != 0) goto L_0x019e
                goto L_0x01a8
            L_0x019e:
                r0 = r23
                r1 = r18
                r4 = 2
                r5 = 0
                r6 = 0
                r7 = 1
                goto L_0x007d
            L_0x01a8:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final boolean z = this.$panZoomLock;
            final Function4<Offset, Offset, Float, Float, Unit> function4 = this.$onGesture;
            this.label = 1;
            if (((PointerInputScope) this.L$0).awaitPointerEventScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
