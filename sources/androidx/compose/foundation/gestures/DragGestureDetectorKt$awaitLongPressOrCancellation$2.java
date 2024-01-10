package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", f = "DragGestureDetector.kt", i = {0, 0, 1, 1, 1}, l = {819, 836}, m = "invokeSuspend", n = {"$this$withTimeout", "finished", "$this$withTimeout", "event", "finished"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$awaitLongPressOrCancellation$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $currentDown;
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $longPress;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$awaitLongPressOrCancellation$2(Ref.ObjectRef<PointerInputChange> objectRef, Ref.ObjectRef<PointerInputChange> objectRef2, Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$2> continuation) {
        super(2, continuation);
        this.$currentDown = objectRef;
        this.$longPress = objectRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(this.$currentDown, this.$longPress, continuation);
        dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = obj;
        return dragGestureDetectorKt$awaitLongPressOrCancellation$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$awaitLongPressOrCancellation$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x007c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00b1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 == r6) goto L_0x002b
            if (r2 != r3) goto L_0x0023
            int r2 = r0.I$0
            java.lang.Object r7 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r18)
            r4 = r18
            r5 = r0
            goto L_0x00cb
        L_0x0023:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002b:
            int r2 = r0.I$0
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r18)
            r9 = r18
            r8 = r7
            r7 = r0
            goto L_0x005e
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            r8 = r0
            r7 = r2
            r2 = 0
        L_0x0043:
            if (r2 != 0) goto L_0x0169
            androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r10 = r8
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r8.L$0 = r7
            r8.L$1 = r4
            r8.I$0 = r2
            r8.label = r6
            java.lang.Object r9 = r7.awaitPointerEvent(r9, r10)
            if (r9 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r16 = r8
            r8 = r7
            r7 = r16
        L_0x005e:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
            java.util.List r10 = r9.getChanges()
            int r11 = r10.size()
            r12 = 0
        L_0x0069:
            if (r12 >= r11) goto L_0x007c
            java.lang.Object r13 = r10.get(r12)
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            boolean r13 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r13)
            if (r13 != 0) goto L_0x0079
            r10 = 0
            goto L_0x007d
        L_0x0079:
            int r12 = r12 + 1
            goto L_0x0069
        L_0x007c:
            r10 = 1
        L_0x007d:
            if (r10 == 0) goto L_0x0080
            r2 = 1
        L_0x0080:
            java.util.List r10 = r9.getChanges()
            int r11 = r10.size()
            r12 = 0
        L_0x0089:
            if (r12 >= r11) goto L_0x00b1
            java.lang.Object r13 = r10.get(r12)
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            boolean r14 = r13.isConsumed()
            if (r14 != 0) goto L_0x00a8
            long r14 = r8.m3331getSizeYbymL2g()
            long r4 = r8.m3330getExtendedTouchPaddingNHjbRc()
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.m3377isOutOfBoundsjwHxaWs(r13, r14, r4)
            if (r4 == 0) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r4 = 0
            goto L_0x00a9
        L_0x00a8:
            r4 = 1
        L_0x00a9:
            if (r4 == 0) goto L_0x00ad
            r4 = 1
            goto L_0x00b2
        L_0x00ad:
            int r12 = r12 + 1
            r4 = 0
            goto L_0x0089
        L_0x00b1:
            r4 = 0
        L_0x00b2:
            if (r4 == 0) goto L_0x00b5
            r2 = 1
        L_0x00b5:
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.L$0 = r8
            r7.L$1 = r9
            r7.I$0 = r2
            r7.label = r3
            java.lang.Object r4 = r8.awaitPointerEvent(r4, r5)
            if (r4 != r1) goto L_0x00c9
            return r1
        L_0x00c9:
            r5 = r7
            r7 = r9
        L_0x00cb:
            androidx.compose.ui.input.pointer.PointerEvent r4 = (androidx.compose.ui.input.pointer.PointerEvent) r4
            java.util.List r4 = r4.getChanges()
            int r9 = r4.size()
            r10 = 0
        L_0x00d6:
            if (r10 >= r9) goto L_0x00e9
            java.lang.Object r11 = r4.get(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.isConsumed()
            if (r11 == 0) goto L_0x00e6
            r4 = 1
            goto L_0x00ea
        L_0x00e6:
            int r10 = r10 + 1
            goto L_0x00d6
        L_0x00e9:
            r4 = 0
        L_0x00ea:
            if (r4 == 0) goto L_0x00ed
            r2 = 1
        L_0x00ed:
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r5.$currentDown
            T r4 = r4.element
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            long r9 = r4.m3428getIdJ3iCeTQ()
            boolean r4 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m286isPointerUpDmW0f2w(r7, r9)
            if (r4 == 0) goto L_0x012f
            java.util.List r4 = r7.getChanges()
            int r7 = r4.size()
            r9 = 0
        L_0x0106:
            if (r9 >= r7) goto L_0x0119
            java.lang.Object r10 = r4.get(r9)
            r11 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x0116
            goto L_0x011a
        L_0x0116:
            int r9 = r9 + 1
            goto L_0x0106
        L_0x0119:
            r10 = 0
        L_0x011a:
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 == 0) goto L_0x012b
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r5.$currentDown
            r4.element = r10
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r5.$longPress
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r7 = r5.$currentDown
            T r7 = r7.element
            r4.element = r7
            goto L_0x0163
        L_0x012b:
            r7 = r8
            r2 = 1
            r4 = 0
            goto L_0x0166
        L_0x012f:
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r5.$longPress
            java.util.List r7 = r7.getChanges()
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r9 = r5.$currentDown
            int r10 = r7.size()
            r11 = 0
        L_0x013c:
            if (r11 >= r10) goto L_0x0160
            java.lang.Object r12 = r7.get(r11)
            r13 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            long r13 = r13.m3428getIdJ3iCeTQ()
            T r15 = r9.element
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r18 = r7
            long r6 = r15.m3428getIdJ3iCeTQ()
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r13, r6)
            if (r6 == 0) goto L_0x015a
            goto L_0x0161
        L_0x015a:
            int r11 = r11 + 1
            r7 = r18
            r6 = 1
            goto L_0x013c
        L_0x0160:
            r12 = 0
        L_0x0161:
            r4.element = r12
        L_0x0163:
            r7 = r8
            r4 = 0
            r6 = 1
        L_0x0166:
            r8 = r5
            goto L_0x0043
        L_0x0169:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
