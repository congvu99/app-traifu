package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5", f = "DragGestureDetector.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$detectDragGestures$5 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super DragGestureDetectorKt$detectDragGestures$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDrag = function2;
        this.$onDragCancel = function0;
        this.$onDragEnd = function02;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGestures$5 dragGestureDetectorKt$detectDragGestures$5 = new DragGestureDetectorKt$detectDragGestures$5(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        dragGestureDetectorKt$detectDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$5;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$5) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {177, 898, 948, 194}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointerDirectionConfig$iv", "pointer$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv", "$this$awaitPointerEventScope", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointerDirectionConfig$iv", "pointer$iv", "dragEvent$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "F$0", "F$1", "F$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "F$0", "F$1", "F$2"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1  reason: invalid class name */
    /* compiled from: DragGestureDetector.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(function1, function2, function0, function02, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x011a A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0128  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0174  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x01a8  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0263  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x026a  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x02b5  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x02bb  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0150 A[SYNTHETIC] */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                r22 = this;
                r0 = r22
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 4
                r4 = 3
                r5 = 2
                r7 = 0
                r8 = 1
                r9 = 0
                if (r2 == 0) goto L_0x00a1
                if (r2 == r8) goto L_0x0097
                if (r2 == r5) goto L_0x0061
                if (r2 == r4) goto L_0x0028
                if (r2 != r3) goto L_0x0020
                kotlin.ResultKt.throwOnFailure(r23)
                r5 = r0
                r0 = r23
                goto L_0x02ad
            L_0x0020:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0028:
                float r2 = r0.F$2
                float r10 = r0.F$1
                float r11 = r0.F$0
                int r12 = r0.I$0
                java.lang.Object r13 = r0.L$6
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                java.lang.Object r14 = r0.L$5
                kotlin.jvm.internal.Ref$LongRef r14 = (kotlin.jvm.internal.Ref.LongRef) r14
                java.lang.Object r15 = r0.L$4
                androidx.compose.foundation.gestures.PointerDirectionConfig r15 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r15
                java.lang.Object r6 = r0.L$3
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
                java.lang.Object r3 = r0.L$2
                kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
                java.lang.Object r4 = r0.L$1
                androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                java.lang.Object r5 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                kotlin.ResultKt.throwOnFailure(r23)
                r8 = 3
                r20 = r11
                r11 = r0
                r0 = r12
                r12 = r20
                r21 = r4
                r4 = r2
                r2 = r6
                r6 = r10
                r10 = r3
                r3 = r5
                r5 = r21
                goto L_0x0211
            L_0x0061:
                float r2 = r0.F$2
                float r3 = r0.F$1
                float r4 = r0.F$0
                int r5 = r0.I$0
                java.lang.Object r6 = r0.L$5
                kotlin.jvm.internal.Ref$LongRef r6 = (kotlin.jvm.internal.Ref.LongRef) r6
                java.lang.Object r10 = r0.L$4
                androidx.compose.foundation.gestures.PointerDirectionConfig r10 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r10
                java.lang.Object r11 = r0.L$3
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
                java.lang.Object r12 = r0.L$2
                kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
                java.lang.Object r13 = r0.L$1
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                java.lang.Object r14 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
                kotlin.ResultKt.throwOnFailure(r23)
                r7 = r23
                r15 = r5
                r5 = r13
                r13 = r10
                r10 = r12
                r12 = r4
                r4 = r2
                r2 = r11
                r11 = r0
                r0 = 2
                r20 = r6
                r6 = r3
                r3 = r14
                r14 = r20
                goto L_0x011b
            L_0x0097:
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r23)
                r3 = r23
                goto L_0x00b6
            L_0x00a1:
                kotlin.ResultKt.throwOnFailure(r23)
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                r3 = r0
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r0.L$0 = r2
                r0.label = r8
                java.lang.Object r3 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r2, r7, r3)
                if (r3 != r1) goto L_0x00b6
                return r1
            L_0x00b6:
                androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
                kotlin.jvm.internal.Ref$LongRef r4 = new kotlin.jvm.internal.Ref$LongRef
                r4.<init>()
                androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.Companion
                long r5 = r5.m1699getZeroF1C5BW0()
                r4.element = r5
                r5 = r0
            L_0x00c6:
                long r10 = r3.m3428getIdJ3iCeTQ()
                int r6 = r3.m3432getTypeT8wyACA()
                androidx.compose.foundation.gestures.PointerDirectionConfig r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.getHorizontalPointerDirectionConfig()
                androidx.compose.ui.input.pointer.PointerEvent r13 = r2.getCurrentEvent()
                boolean r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m286isPointerUpDmW0f2w(r13, r10)
                if (r13 == 0) goto L_0x00df
                r0 = r9
                goto L_0x025a
            L_0x00df:
                androidx.compose.ui.platform.ViewConfiguration r13 = r2.getViewConfiguration()
                float r6 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m287pointerSlopE8SPZFQ(r13, r6)
                kotlin.jvm.internal.Ref$LongRef r13 = new kotlin.jvm.internal.Ref$LongRef
                r13.<init>()
                r13.element = r10
                r10 = r4
                r11 = r5
                r14 = r13
                r4 = 0
                r15 = 0
                r5 = r3
                r13 = r12
                r3 = r2
                r12 = r6
                r6 = 0
            L_0x00f8:
                r7 = r11
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r11.L$0 = r3
                r11.L$1 = r5
                r11.L$2 = r10
                r11.L$3 = r2
                r11.L$4 = r13
                r11.L$5 = r14
                r11.L$6 = r9
                r11.I$0 = r15
                r11.F$0 = r12
                r11.F$1 = r6
                r11.F$2 = r4
                r0 = 2
                r11.label = r0
                java.lang.Object r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r2, r9, r7, r8, r9)
                if (r7 != r1) goto L_0x011b
                return r1
            L_0x011b:
                androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
                java.util.List r0 = r7.getChanges()
                int r8 = r0.size()
                r9 = 0
            L_0x0126:
                if (r9 >= r8) goto L_0x0150
                java.lang.Object r16 = r0.get(r9)
                r17 = r16
                androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
                r18 = r0
                r23 = r1
                long r0 = r17.m3428getIdJ3iCeTQ()
                r17 = r2
                r19 = r3
                long r2 = r14.element
                boolean r0 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r0, r2)
                if (r0 == 0) goto L_0x0145
                goto L_0x0158
            L_0x0145:
                int r9 = r9 + 1
                r1 = r23
                r2 = r17
                r0 = r18
                r3 = r19
                goto L_0x0126
            L_0x0150:
                r23 = r1
                r17 = r2
                r19 = r3
                r16 = 0
            L_0x0158:
                r0 = r16
                androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
                if (r0 != 0) goto L_0x0167
            L_0x015e:
                r1 = r23
                r3 = r5
                r4 = r10
                r5 = r11
                r2 = r19
                goto L_0x021b
            L_0x0167:
                boolean r1 = r0.isConsumed()
                if (r1 == 0) goto L_0x016e
                goto L_0x015e
            L_0x016e:
                boolean r1 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r0)
                if (r1 == 0) goto L_0x01a8
                java.util.List r0 = r7.getChanges()
                int r1 = r0.size()
                r2 = 0
            L_0x017d:
                if (r2 >= r1) goto L_0x0190
                java.lang.Object r3 = r0.get(r2)
                r7 = r3
                androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                boolean r7 = r7.getPressed()
                if (r7 == 0) goto L_0x018d
                goto L_0x0191
            L_0x018d:
                int r2 = r2 + 1
                goto L_0x017d
            L_0x0190:
                r3 = 0
            L_0x0191:
                androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
                if (r3 != 0) goto L_0x0196
                goto L_0x015e
            L_0x0196:
                long r0 = r3.m3428getIdJ3iCeTQ()
                r14.element = r0
                r0 = r22
                r1 = r23
                r2 = r17
                r3 = r19
            L_0x01a4:
                r8 = 1
                r9 = 0
                goto L_0x00f8
            L_0x01a8:
                long r1 = r0.m3429getPositionF1C5BW0()
                long r7 = r0.m3430getPreviousPositionF1C5BW0()
                float r3 = r13.m313mainAxisDeltak4lQ0M(r1)
                float r9 = r13.m313mainAxisDeltak4lQ0M(r7)
                float r3 = r3 - r9
                float r1 = r13.m312crossAxisDeltak4lQ0M(r1)
                float r2 = r13.m312crossAxisDeltak4lQ0M(r7)
                float r1 = r1 - r2
                float r2 = r6 + r3
                float r1 = r1 + r4
                if (r15 == 0) goto L_0x01cc
                float r3 = java.lang.Math.abs(r2)
                goto L_0x01d4
            L_0x01cc:
                long r3 = r13.m314offsetFromChangesdBAh8RU(r2, r1)
                float r3 = androidx.compose.ui.geometry.Offset.m1681getDistanceimpl(r3)
            L_0x01d4:
                int r4 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
                if (r4 >= 0) goto L_0x0225
                androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Final
                r4 = r11
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r6 = r19
                r11.L$0 = r6
                r11.L$1 = r5
                r11.L$2 = r10
                r7 = r17
                r11.L$3 = r7
                r11.L$4 = r13
                r11.L$5 = r14
                r11.L$6 = r0
                r11.I$0 = r15
                r11.F$0 = r12
                r11.F$1 = r2
                r11.F$2 = r1
                r8 = 3
                r11.label = r8
                java.lang.Object r3 = r7.awaitPointerEvent(r3, r4)
                r4 = r23
                if (r3 != r4) goto L_0x0203
                return r4
            L_0x0203:
                r3 = r6
                r6 = r2
                r2 = r7
                r20 = r13
                r13 = r0
                r0 = r15
                r15 = r20
                r21 = r4
                r4 = r1
                r1 = r21
            L_0x0211:
                boolean r7 = r13.isConsumed()
                if (r7 == 0) goto L_0x021d
                r2 = r3
                r3 = r5
                r4 = r10
                r5 = r11
            L_0x021b:
                r0 = 0
                goto L_0x025a
            L_0x021d:
                r13 = r15
                r8 = 1
                r9 = 0
                r15 = r0
                r0 = r22
                goto L_0x00f8
            L_0x0225:
                r4 = r23
                r7 = r17
                r6 = r19
                r8 = 3
                if (r15 == 0) goto L_0x023a
                float r3 = java.lang.Math.signum(r2)
                float r3 = r3 * r12
                float r2 = r2 - r3
                long r1 = r13.m314offsetFromChangesdBAh8RU(r2, r1)
                goto L_0x024a
            L_0x023a:
                long r1 = r13.m314offsetFromChangesdBAh8RU(r2, r1)
                long r8 = androidx.compose.ui.geometry.Offset.m1678divtuRUvjQ(r1, r3)
                long r8 = androidx.compose.ui.geometry.Offset.m1690timestuRUvjQ(r8, r12)
                long r1 = androidx.compose.ui.geometry.Offset.m1687minusMKHz9U(r1, r8)
            L_0x024a:
                r0.consume()
                r10.element = r1
                boolean r1 = r0.isConsumed()
                if (r1 == 0) goto L_0x02c3
                r1 = r4
                r3 = r5
                r2 = r6
                r4 = r10
                r5 = r11
            L_0x025a:
                if (r0 == 0) goto L_0x026a
                boolean r6 = r0.isConsumed()
                if (r6 == 0) goto L_0x0263
                goto L_0x026a
            L_0x0263:
                r0 = r22
                r7 = 0
                r8 = 1
                r9 = 0
                goto L_0x00c6
            L_0x026a:
                if (r0 == 0) goto L_0x02c0
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r4
                long r6 = r0.m3429getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m1672boximpl(r6)
                r3.invoke(r6)
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r5
                long r6 = r4.element
                androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m1672boximpl(r6)
                r3.invoke(r0, r4)
                long r3 = r0.m3428getIdJ3iCeTQ()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1$2 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1$2
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r6 = r5
                r0.<init>(r6)
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                r6 = r5
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r8 = 0
                r5.L$0 = r8
                r5.L$1 = r8
                r5.L$2 = r8
                r5.L$3 = r8
                r5.L$4 = r8
                r5.L$5 = r8
                r5.L$6 = r8
                r9 = 4
                r5.label = r9
                java.lang.Object r0 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m284dragjO51t88(r2, r3, r0, r6)
                if (r0 != r1) goto L_0x02ad
                return r1
            L_0x02ad:
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r0 = r0.booleanValue()
                if (r0 != 0) goto L_0x02bb
                kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r6
                r0.invoke()
                goto L_0x02c0
            L_0x02bb:
                kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r7
                r0.invoke()
            L_0x02c0:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x02c3:
                r0 = r22
                r1 = r4
                r3 = r6
                r2 = r7
                r4 = 0
                r6 = 0
                goto L_0x01a4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Function1<Offset, Unit> function1 = this.$onDragStart;
            final Function2<PointerInputChange, Offset, Unit> function2 = this.$onDrag;
            final Function0<Unit> function0 = this.$onDragCancel;
            final Function0<Unit> function02 = this.$onDragEnd;
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
