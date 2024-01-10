package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2", f = "Clickable.kt", i = {0, 1, 2}, l = {445, 447, 454, 455, 464}, m = "invokeSuspend", n = {"delayJob", "success", "releaseInteraction"}, s = {"L$0", "Z$0", "L$0"})
/* compiled from: Clickable.kt */
final class ClickableKt$handlePressInteraction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Boolean>> $delayPressInteraction;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $pressPoint;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    final /* synthetic */ PressGestureScope $this_handlePressInteraction;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$handlePressInteraction$2(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, State<? extends Function0<Boolean>> state, Continuation<? super ClickableKt$handlePressInteraction$2> continuation) {
        super(2, continuation);
        this.$this_handlePressInteraction = pressGestureScope;
        this.$pressPoint = j;
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = mutableState;
        this.$delayPressInteraction = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickableKt$handlePressInteraction$2 clickableKt$handlePressInteraction$2 = new ClickableKt$handlePressInteraction$2(this.$this_handlePressInteraction, this.$pressPoint, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, continuation);
        clickableKt$handlePressInteraction$2.L$0 = obj;
        return clickableKt$handlePressInteraction$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$handlePressInteraction$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c7 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r7) goto L_0x0037
            if (r2 == r6) goto L_0x0031
            if (r2 == r5) goto L_0x0028
            if (r2 == r4) goto L_0x0023
            if (r2 != r3) goto L_0x001b
            goto L_0x0023
        L_0x001b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x00f3
        L_0x0028:
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.interaction.PressInteraction$Release r2 = (androidx.compose.foundation.interaction.PressInteraction.Release) r2
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x00b6
        L_0x0031:
            boolean r2 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x0095
        L_0x0037:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            kotlin.ResultKt.throwOnFailure(r20)
            r3 = r20
            goto L_0x0078
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r0.L$0
            r9 = r2
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            r10 = 0
            r11 = 0
            androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1 r2 = new androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1
            androidx.compose.runtime.State<kotlin.jvm.functions.Function0<java.lang.Boolean>> r13 = r0.$delayPressInteraction
            long r14 = r0.$pressPoint
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = r0.$interactionSource
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r3 = r0.$pressedInteraction
            r18 = 0
            r16 = r12
            r12 = r2
            r17 = r3
            r12.<init>(r13, r14, r16, r17, r18)
            r12 = r2
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = 3
            r14 = 0
            kotlinx.coroutines.Job r2 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, r10, r11, r12, r13, r14)
            androidx.compose.foundation.gestures.PressGestureScope r3 = r0.$this_handlePressInteraction
            r9 = r0
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r0.L$0 = r2
            r0.label = r7
            java.lang.Object r3 = r3.tryAwaitRelease(r9)
            if (r3 != r1) goto L_0x0078
            return r1
        L_0x0078:
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            boolean r7 = r2.isActive()
            if (r7 == 0) goto L_0x00c8
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r0.L$0 = r8
            r0.Z$0 = r3
            r0.label = r6
            java.lang.Object r2 = kotlinx.coroutines.JobKt.cancelAndJoin(r2, r7)
            if (r2 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r2 = r3
        L_0x0095:
            if (r2 == 0) goto L_0x00f3
            androidx.compose.foundation.interaction.PressInteraction$Press r2 = new androidx.compose.foundation.interaction.PressInteraction$Press
            long r6 = r0.$pressPoint
            r2.<init>(r6, r8)
            androidx.compose.foundation.interaction.PressInteraction$Release r3 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r3.<init>(r2)
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = r0.$interactionSource
            androidx.compose.foundation.interaction.Interaction r2 = (androidx.compose.foundation.interaction.Interaction) r2
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r0.L$0 = r3
            r0.label = r5
            java.lang.Object r2 = r6.emit(r2, r7)
            if (r2 != r1) goto L_0x00b5
            return r1
        L_0x00b5:
            r2 = r3
        L_0x00b6:
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r0.$interactionSource
            androidx.compose.foundation.interaction.Interaction r2 = (androidx.compose.foundation.interaction.Interaction) r2
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r2 = r3.emit(r2, r5)
            if (r2 != r1) goto L_0x00f3
            return r1
        L_0x00c8:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r2 = r0.$pressedInteraction
            java.lang.Object r2 = r2.getValue()
            androidx.compose.foundation.interaction.PressInteraction$Press r2 = (androidx.compose.foundation.interaction.PressInteraction.Press) r2
            if (r2 == 0) goto L_0x00f3
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.$interactionSource
            if (r3 == 0) goto L_0x00de
            androidx.compose.foundation.interaction.PressInteraction$Release r3 = new androidx.compose.foundation.interaction.PressInteraction$Release
            r3.<init>(r2)
            androidx.compose.foundation.interaction.PressInteraction r3 = (androidx.compose.foundation.interaction.PressInteraction) r3
            goto L_0x00e5
        L_0x00de:
            androidx.compose.foundation.interaction.PressInteraction$Cancel r3 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
            r3.<init>(r2)
            androidx.compose.foundation.interaction.PressInteraction r3 = (androidx.compose.foundation.interaction.PressInteraction) r3
        L_0x00e5:
            androidx.compose.foundation.interaction.Interaction r3 = (androidx.compose.foundation.interaction.Interaction) r3
            r0.L$0 = r8
            r2 = 5
            r0.label = r2
            java.lang.Object r2 = r4.emit(r3, r0)
            if (r2 != r1) goto L_0x00f3
            return r1
        L_0x00f3:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r1 = r0.$pressedInteraction
            r1.setValue(r8)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt$handlePressInteraction$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
