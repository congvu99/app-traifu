package androidx.compose.foundation.gestures;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a1\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a&\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"awaitTwoDowns", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectZoom", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "Landroidx/compose/runtime/State;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformable", "Landroidx/compose/ui/Modifier;", "lockRotationOnZoomPan", "enabled", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Transformable.kt */
public final class TransformableKt {
    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00fb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.PointerInputScope r22, androidx.compose.runtime.State<java.lang.Boolean> r23, androidx.compose.runtime.State<? extends androidx.compose.foundation.gestures.TransformableState> r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            r0 = r22
            r1 = r25
            boolean r2 = r1 instanceof androidx.compose.foundation.gestures.TransformableKt$detectZoom$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            androidx.compose.foundation.gestures.TransformableKt$detectZoom$1 r2 = (androidx.compose.foundation.gestures.TransformableKt$detectZoom$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.TransformableKt$detectZoom$1 r2 = new androidx.compose.foundation.gestures.TransformableKt$detectZoom$1
            r2.<init>(r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x006e
            if (r4 == r6) goto L_0x003b
            if (r4 != r5) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ CancellationException -> 0x00fc }
            goto L_0x00fc
        L_0x0033:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003b:
            float r0 = r2.F$0
            java.lang.Object r4 = r2.L$7
            kotlin.jvm.internal.Ref$BooleanRef r4 = (kotlin.jvm.internal.Ref.BooleanRef) r4
            java.lang.Object r6 = r2.L$6
            kotlin.jvm.internal.Ref$BooleanRef r6 = (kotlin.jvm.internal.Ref.BooleanRef) r6
            java.lang.Object r8 = r2.L$5
            kotlin.jvm.internal.Ref$LongRef r8 = (kotlin.jvm.internal.Ref.LongRef) r8
            java.lang.Object r9 = r2.L$4
            kotlin.jvm.internal.Ref$FloatRef r9 = (kotlin.jvm.internal.Ref.FloatRef) r9
            java.lang.Object r10 = r2.L$3
            kotlin.jvm.internal.Ref$FloatRef r10 = (kotlin.jvm.internal.Ref.FloatRef) r10
            java.lang.Object r11 = r2.L$2
            androidx.compose.runtime.State r11 = (androidx.compose.runtime.State) r11
            java.lang.Object r12 = r2.L$1
            androidx.compose.runtime.State r12 = (androidx.compose.runtime.State) r12
            java.lang.Object r13 = r2.L$0
            androidx.compose.ui.input.pointer.PointerInputScope r13 = (androidx.compose.ui.input.pointer.PointerInputScope) r13
            kotlin.ResultKt.throwOnFailure(r1)
            r18 = r0
            r19 = r4
            r1 = r6
            r17 = r8
            r15 = r9
            r16 = r10
            r14 = r11
            r20 = r12
            goto L_0x00d0
        L_0x006e:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$FloatRef r10 = new kotlin.jvm.internal.Ref$FloatRef
            r10.<init>()
            kotlin.jvm.internal.Ref$FloatRef r9 = new kotlin.jvm.internal.Ref$FloatRef
            r9.<init>()
            r1 = 1065353216(0x3f800000, float:1.0)
            r9.element = r1
            kotlin.jvm.internal.Ref$LongRef r8 = new kotlin.jvm.internal.Ref$LongRef
            r8.<init>()
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r11 = r1.m1699getZeroF1C5BW0()
            r8.element = r11
            kotlin.jvm.internal.Ref$BooleanRef r1 = new kotlin.jvm.internal.Ref$BooleanRef
            r1.<init>()
            androidx.compose.ui.platform.ViewConfiguration r4 = r22.getViewConfiguration()
            float r4 = r4.getTouchSlop()
            kotlin.jvm.internal.Ref$BooleanRef r11 = new kotlin.jvm.internal.Ref$BooleanRef
            r11.<init>()
            androidx.compose.foundation.gestures.TransformableKt$detectZoom$2 r12 = new androidx.compose.foundation.gestures.TransformableKt$detectZoom$2
            r12.<init>(r7)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r2.L$0 = r0
            r13 = r23
            r2.L$1 = r13
            r14 = r24
            r2.L$2 = r14
            r2.L$3 = r10
            r2.L$4 = r9
            r2.L$5 = r8
            r2.L$6 = r1
            r2.L$7 = r11
            r2.F$0 = r4
            r2.label = r6
            java.lang.Object r6 = r0.awaitPointerEventScope(r12, r2)
            if (r6 != r3) goto L_0x00c4
            return r3
        L_0x00c4:
            r18 = r4
            r17 = r8
            r15 = r9
            r16 = r10
            r19 = r11
            r20 = r13
            r13 = r0
        L_0x00d0:
            java.lang.Object r0 = r14.getValue()     // Catch:{ CancellationException -> 0x00fc }
            androidx.compose.foundation.gestures.TransformableState r0 = (androidx.compose.foundation.gestures.TransformableState) r0     // Catch:{ CancellationException -> 0x00fc }
            androidx.compose.foundation.MutatePriority r4 = androidx.compose.foundation.MutatePriority.UserInput     // Catch:{ CancellationException -> 0x00fc }
            androidx.compose.foundation.gestures.TransformableKt$detectZoom$3 r6 = new androidx.compose.foundation.gestures.TransformableKt$detectZoom$3     // Catch:{ CancellationException -> 0x00fc }
            r21 = 0
            r12 = r6
            r14 = r1
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ CancellationException -> 0x00fc }
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ CancellationException -> 0x00fc }
            r2.L$0 = r7     // Catch:{ CancellationException -> 0x00fc }
            r2.L$1 = r7     // Catch:{ CancellationException -> 0x00fc }
            r2.L$2 = r7     // Catch:{ CancellationException -> 0x00fc }
            r2.L$3 = r7     // Catch:{ CancellationException -> 0x00fc }
            r2.L$4 = r7     // Catch:{ CancellationException -> 0x00fc }
            r2.L$5 = r7     // Catch:{ CancellationException -> 0x00fc }
            r2.L$6 = r7     // Catch:{ CancellationException -> 0x00fc }
            r2.L$7 = r7     // Catch:{ CancellationException -> 0x00fc }
            r2.label = r5     // Catch:{ CancellationException -> 0x00fc }
            java.lang.Object r0 = r0.transform(r4, r6, r2)     // Catch:{ CancellationException -> 0x00fc }
            if (r0 != r3) goto L_0x00fc
            return r3
        L_0x00fc:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.PointerInputScope, androidx.compose.runtime.State, androidx.compose.runtime.State, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object awaitTwoDowns(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, boolean r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r0 = r19
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.TransformableKt$awaitTwoDowns$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.TransformableKt$awaitTwoDowns$1 r1 = (androidx.compose.foundation.gestures.TransformableKt$awaitTwoDowns$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.TransformableKt$awaitTwoDowns$1 r1 = new androidx.compose.foundation.gestures.TransformableKt$awaitTwoDowns$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0045
            if (r3 != r5) goto L_0x003d
            boolean r3 = r1.Z$0
            java.lang.Object r6 = r1.L$1
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r0)
            r16 = r2
            r2 = r1
            r1 = r3
            r3 = r16
            goto L_0x0068
        L_0x003d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r6 = r0
            r3 = r2
            r0 = r17
            r2 = r1
            r1 = r18
        L_0x0054:
            r2.L$0 = r0
            r2.L$1 = r6
            r2.Z$0 = r1
            r2.label = r5
            java.lang.Object r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r4, r2, r5, r4)
            if (r7 != r3) goto L_0x0063
            return r3
        L_0x0063:
            r16 = r7
            r7 = r0
            r0 = r16
        L_0x0068:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            kotlin.jvm.internal.Ref$IntRef r8 = new kotlin.jvm.internal.Ref$IntRef
            r8.<init>()
            T r9 = r6.element
            if (r9 == 0) goto L_0x0075
            r9 = 1
            goto L_0x0076
        L_0x0075:
            r9 = 0
        L_0x0076:
            r8.element = r9
            java.util.List r0 = r0.getChanges()
            int r9 = r0.size()
            r11 = 0
        L_0x0081:
            if (r11 >= r9) goto L_0x00da
            java.lang.Object r12 = r0.get(r11)
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r1 == 0) goto L_0x0090
            boolean r13 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDown(r12)
            goto L_0x0094
        L_0x0090:
            boolean r13 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r12)
        L_0x0094:
            if (r1 == 0) goto L_0x009b
            boolean r14 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r12)
            goto L_0x009f
        L_0x009b:
            boolean r14 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r12)
        L_0x009f:
            if (r14 == 0) goto L_0x00c4
            long r14 = r12.m3428getIdJ3iCeTQ()
            T r10 = r6.element
            if (r10 != 0) goto L_0x00ab
            r4 = 0
            goto L_0x00b7
        L_0x00ab:
            T r10 = r6.element
            androidx.compose.ui.input.pointer.PointerId r10 = (androidx.compose.ui.input.pointer.PointerId) r10
            long r4 = r10.m3417unboximpl()
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r4, r14)
        L_0x00b7:
            if (r4 == 0) goto L_0x00c3
            r4 = 0
            r6.element = r4
            int r5 = r8.element
            r10 = 1
            int r5 = r5 - r10
            r8.element = r5
            goto L_0x00c5
        L_0x00c3:
            r4 = 0
        L_0x00c4:
            r10 = 1
        L_0x00c5:
            if (r13 == 0) goto L_0x00d6
            long r12 = r12.m3428getIdJ3iCeTQ()
            androidx.compose.ui.input.pointer.PointerId r5 = androidx.compose.ui.input.pointer.PointerId.m3411boximpl(r12)
            r6.element = r5
            int r5 = r8.element
            int r5 = r5 + r10
            r8.element = r5
        L_0x00d6:
            int r11 = r11 + 1
            r5 = 1
            goto L_0x0081
        L_0x00da:
            r10 = 1
            int r0 = r8.element
            if (r0 <= r10) goto L_0x00e1
            r0 = 1
            goto L_0x00e2
        L_0x00e1:
            r0 = 0
        L_0x00e2:
            if (r0 == 0) goto L_0x00e7
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00e7:
            r0 = r7
            r5 = 1
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.awaitTwoDowns(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object awaitTwoDowns$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return awaitTwoDowns(awaitPointerEventScope, z, continuation);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(transformableState, "state");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TransformableKt$transformable$$inlined$debugInspectorInfo$1(transformableState, z2, z) : InspectableValueKt.getNoInspectorInfo(), new TransformableKt$transformable$2(transformableState, z, z2));
    }
}
