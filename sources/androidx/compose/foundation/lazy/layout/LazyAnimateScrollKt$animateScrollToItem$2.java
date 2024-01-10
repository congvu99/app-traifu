package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", f = "LazyAnimateScroll.kt", i = {0, 0, 0, 0, 0, 0, 0, 1}, l = {134, 230}, m = "invokeSuspend", n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "forward", "$this$scroll"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "I$0", "L$0"})
/* compiled from: LazyAnimateScroll.kt */
final class LazyAnimateScrollKt$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ int $scrollOffset;
    final /* synthetic */ LazyAnimateScrollScope $this_animateScrollToItem;
    float F$0;
    float F$1;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyAnimateScrollKt$animateScrollToItem$2(int i, LazyAnimateScrollScope lazyAnimateScrollScope, int i2, Continuation<? super LazyAnimateScrollKt$animateScrollToItem$2> continuation) {
        super(2, continuation);
        this.$index = i;
        this.$this_animateScrollToItem = lazyAnimateScrollScope;
        this.$scrollOffset = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2 = new LazyAnimateScrollKt$animateScrollToItem$2(this.$index, this.$this_animateScrollToItem, this.$scrollOffset, continuation);
        lazyAnimateScrollKt$animateScrollToItem$2.L$0 = obj;
        return lazyAnimateScrollKt$animateScrollToItem$2;
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyAnimateScrollKt$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: androidx.compose.foundation.gestures.ScrollScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e1 A[Catch:{ ItemFoundInScroll -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e2 A[Catch:{ ItemFoundInScroll -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0124 A[Catch:{ ItemFoundInScroll -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0126 A[Catch:{ ItemFoundInScroll -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0129 A[Catch:{ ItemFoundInScroll -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x012c A[Catch:{ ItemFoundInScroll -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0136 A[Catch:{ ItemFoundInScroll -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0139 A[Catch:{ ItemFoundInScroll -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x021c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r44) {
        /*
            r43 = this;
            r1 = r43
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            r3 = 2
            r4 = 0
            r6 = 1
            if (r0 == 0) goto L_0x004d
            if (r0 == r6) goto L_0x0023
            if (r0 != r3) goto L_0x001b
            java.lang.Object r0 = r1.L$0
            androidx.compose.foundation.gestures.ScrollScope r0 = (androidx.compose.foundation.gestures.ScrollScope) r0
            kotlin.ResultKt.throwOnFailure(r44)
            r9 = r1
            goto L_0x021d
        L_0x001b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0023:
            int r0 = r1.I$0
            float r7 = r1.F$1
            float r8 = r1.F$0
            java.lang.Object r9 = r1.L$3
            kotlin.jvm.internal.Ref$IntRef r9 = (kotlin.jvm.internal.Ref.IntRef) r9
            java.lang.Object r10 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.internal.Ref$BooleanRef r11 = (kotlin.jvm.internal.Ref.BooleanRef) r11
            java.lang.Object r12 = r1.L$0
            androidx.compose.foundation.gestures.ScrollScope r12 = (androidx.compose.foundation.gestures.ScrollScope) r12
            kotlin.ResultKt.throwOnFailure(r44)     // Catch:{ ItemFoundInScroll -> 0x0047 }
            r15 = r7
            r14 = r8
            r13 = r9
            r9 = r1
            r42 = r12
            r12 = r10
            r10 = r42
            goto L_0x0190
        L_0x0047:
            r0 = move-exception
            r3 = r0
            r9 = r1
            r0 = r12
            goto L_0x01be
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r44)
            java.lang.Object r0 = r1.L$0
            r7 = r0
            androidx.compose.foundation.gestures.ScrollScope r7 = (androidx.compose.foundation.gestures.ScrollScope) r7
            int r0 = r1.$index
            float r0 = (float) r0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x005e
            r0 = 1
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            int r8 = r1.$index
            if (r0 == 0) goto L_0x0229
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r0 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01ba }
            androidx.compose.ui.unit.Density r0 = r0.getDensity()     // Catch:{ ItemFoundInScroll -> 0x01ba }
            float r8 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.TargetDistance     // Catch:{ ItemFoundInScroll -> 0x01ba }
            float r0 = r0.m4649toPx0680j_4(r8)     // Catch:{ ItemFoundInScroll -> 0x01ba }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r8 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01ba }
            androidx.compose.ui.unit.Density r8 = r8.getDensity()     // Catch:{ ItemFoundInScroll -> 0x01ba }
            float r9 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.BoundDistance     // Catch:{ ItemFoundInScroll -> 0x01ba }
            float r8 = r8.m4649toPx0680j_4(r9)     // Catch:{ ItemFoundInScroll -> 0x01ba }
            kotlin.jvm.internal.Ref$BooleanRef r9 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch:{ ItemFoundInScroll -> 0x01ba }
            r9.<init>()     // Catch:{ ItemFoundInScroll -> 0x01ba }
            r9.element = r6     // Catch:{ ItemFoundInScroll -> 0x01ba }
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ ItemFoundInScroll -> 0x01ba }
            r10.<init>()     // Catch:{ ItemFoundInScroll -> 0x01ba }
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r18 = 30
            r19 = 0
            androidx.compose.animation.core.AnimationState r11 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r11, r12, r13, r15, r17, r18, r19)     // Catch:{ ItemFoundInScroll -> 0x01ba }
            r10.element = r11     // Catch:{ ItemFoundInScroll -> 0x01ba }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r11 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01ba }
            int r12 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x01ba }
            java.lang.Integer r11 = r11.getTargetItemOffset(r12)     // Catch:{ ItemFoundInScroll -> 0x01ba }
            if (r11 != 0) goto L_0x01ac
            int r11 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x01ba }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r12 = r1.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01ba }
            int r12 = r12.getFirstVisibleItemIndex()     // Catch:{ ItemFoundInScroll -> 0x01ba }
            if (r11 <= r12) goto L_0x00b3
            r11 = 1
            goto L_0x00b4
        L_0x00b3:
            r11 = 0
        L_0x00b4:
            kotlin.jvm.internal.Ref$IntRef r12 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ ItemFoundInScroll -> 0x01ba }
            r12.<init>()     // Catch:{ ItemFoundInScroll -> 0x01ba }
            r12.element = r6     // Catch:{ ItemFoundInScroll -> 0x01ba }
            r14 = r0
            r15 = r8
            r0 = r11
            r13 = r12
            r11 = r9
            r12 = r10
            r9 = r1
            r10 = r7
        L_0x00c3:
            boolean r7 = r11.element     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            if (r7 == 0) goto L_0x0226
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r7 = r9.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            int r7 = r7.getItemCount()     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            if (r7 <= 0) goto L_0x0226
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r7 = r9.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            int r8 = r9.$index     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            int r5 = r9.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            float r5 = r7.expectedDistanceTo(r8, r5)     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            float r7 = java.lang.Math.abs(r5)     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            int r7 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r7 >= 0) goto L_0x00e2
            goto L_0x00e7
        L_0x00e2:
            if (r0 == 0) goto L_0x00e6
            r5 = r14
            goto L_0x00e7
        L_0x00e6:
            float r5 = -r14
        L_0x00e7:
            T r7 = r12.element     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            r20 = r7
            androidx.compose.animation.core.AnimationState r20 = (androidx.compose.animation.core.AnimationState) r20     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r28 = 30
            r29 = 0
            androidx.compose.animation.core.AnimationState r7 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r20, (float) r21, (float) r22, (long) r23, (long) r25, (boolean) r27, (int) r28, (java.lang.Object) r29)     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            r12.element = r7     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            kotlin.jvm.internal.Ref$FloatRef r16 = new kotlin.jvm.internal.Ref$FloatRef     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            r16.<init>()     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            T r7 = r12.element     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            r20 = r7
            androidx.compose.animation.core.AnimationState r20 = (androidx.compose.animation.core.AnimationState) r20     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            java.lang.Float r21 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            r22 = 0
            T r7 = r12.element     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            androidx.compose.animation.core.AnimationState r7 = (androidx.compose.animation.core.AnimationState) r7     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            java.lang.Object r7 = r7.getVelocity()     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            java.lang.Number r7 = (java.lang.Number) r7     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            float r7 = r7.floatValue()     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x0126
            r7 = 1
            goto L_0x0127
        L_0x0126:
            r7 = 0
        L_0x0127:
            if (r7 != 0) goto L_0x012c
            r23 = 1
            goto L_0x012e
        L_0x012c:
            r23 = 0
        L_0x012e:
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3 r24 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r8 = r9.$this_animateScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            int r7 = r9.$index     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            if (r0 == 0) goto L_0x0139
            r17 = 1
            goto L_0x013b
        L_0x0139:
            r17 = 0
        L_0x013b:
            int r3 = r9.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x01a7 }
            r18 = r7
            r7 = r24
            r4 = r9
            r9 = r18
            r44 = r10
            r10 = r5
            r5 = r11
            r11 = r16
            r30 = r12
            r12 = r44
            r31 = r13
            r13 = r5
            r6 = r14
            r14 = r17
            r32 = r15
            r16 = r31
            r17 = r3
            r18 = r30
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ ItemFoundInScroll -> 0x01a1 }
            kotlin.jvm.functions.Function1 r24 = (kotlin.jvm.functions.Function1) r24     // Catch:{ ItemFoundInScroll -> 0x01a1 }
            r25 = r4
            kotlin.coroutines.Continuation r25 = (kotlin.coroutines.Continuation) r25     // Catch:{ ItemFoundInScroll -> 0x01a1 }
            r26 = 2
            r27 = 0
            r7 = r44
            r4.L$0 = r7     // Catch:{ ItemFoundInScroll -> 0x019f }
            r4.L$1 = r5     // Catch:{ ItemFoundInScroll -> 0x019f }
            r10 = r30
            r4.L$2 = r10     // Catch:{ ItemFoundInScroll -> 0x019f }
            r12 = r31
            r4.L$3 = r12     // Catch:{ ItemFoundInScroll -> 0x019f }
            r4.F$0 = r6     // Catch:{ ItemFoundInScroll -> 0x019f }
            r8 = r32
            r4.F$1 = r8     // Catch:{ ItemFoundInScroll -> 0x019f }
            r4.I$0 = r0     // Catch:{ ItemFoundInScroll -> 0x019f }
            r3 = 1
            r4.label = r3     // Catch:{ ItemFoundInScroll -> 0x019f }
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r20, r21, r22, r23, r24, r25, r26, r27)     // Catch:{ ItemFoundInScroll -> 0x019f }
            if (r3 != r2) goto L_0x0189
            return r2
        L_0x0189:
            r9 = r4
            r11 = r5
            r14 = r6
            r15 = r8
            r13 = r12
            r12 = r10
            r10 = r7
        L_0x0190:
            int r3 = r13.element     // Catch:{ ItemFoundInScroll -> 0x019b }
            r4 = 1
            int r3 = r3 + r4
            r13.element = r3     // Catch:{ ItemFoundInScroll -> 0x019b }
            r3 = 2
            r4 = 0
            r6 = 1
            goto L_0x00c3
        L_0x019b:
            r0 = move-exception
            r3 = r0
            r0 = r10
            goto L_0x01be
        L_0x019f:
            r0 = move-exception
            goto L_0x01a4
        L_0x01a1:
            r0 = move-exception
            r7 = r44
        L_0x01a4:
            r3 = r0
            r9 = r4
            goto L_0x01bd
        L_0x01a7:
            r0 = move-exception
            r4 = r9
            r7 = r10
            r3 = r0
            goto L_0x01bd
        L_0x01ac:
            androidx.compose.foundation.lazy.layout.ItemFoundInScroll r0 = new androidx.compose.foundation.lazy.layout.ItemFoundInScroll     // Catch:{ ItemFoundInScroll -> 0x01ba }
            int r3 = r11.intValue()     // Catch:{ ItemFoundInScroll -> 0x01ba }
            T r4 = r10.element     // Catch:{ ItemFoundInScroll -> 0x01ba }
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4     // Catch:{ ItemFoundInScroll -> 0x01ba }
            r0.<init>(r3, r4)     // Catch:{ ItemFoundInScroll -> 0x01ba }
            throw r0     // Catch:{ ItemFoundInScroll -> 0x01ba }
        L_0x01ba:
            r0 = move-exception
            r3 = r0
            r9 = r1
        L_0x01bd:
            r0 = r7
        L_0x01be:
            androidx.compose.animation.core.AnimationState r32 = r3.getPreviousAnimation()
            r33 = 0
            r34 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r40 = 30
            r41 = 0
            androidx.compose.animation.core.AnimationState r10 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r32, (float) r33, (float) r34, (long) r35, (long) r37, (boolean) r39, (int) r40, (java.lang.Object) r41)
            int r3 = r3.getItemOffset()
            int r4 = r9.$scrollOffset
            int r3 = r3 + r4
            float r3 = (float) r3
            kotlin.jvm.internal.Ref$FloatRef r4 = new kotlin.jvm.internal.Ref$FloatRef
            r4.<init>()
            java.lang.Float r11 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            r12 = 0
            java.lang.Object r5 = r10.getVelocity()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 != 0) goto L_0x01f7
            r5 = 1
            goto L_0x01f8
        L_0x01f7:
            r5 = 0
        L_0x01f8:
            r6 = 1
            r13 = r5 ^ 1
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5 r5 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5
            r5.<init>(r3, r4, r0)
            r14 = r5
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r15 = r9
            kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15
            r16 = 2
            r17 = 0
            r9.L$0 = r0
            r3 = 0
            r9.L$1 = r3
            r9.L$2 = r3
            r9.L$3 = r3
            r3 = 2
            r9.label = r3
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r10, r11, r12, r13, r14, r15, r16, r17)
            if (r3 != r2) goto L_0x021d
            return r2
        L_0x021d:
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r2 = r9.$this_animateScrollToItem
            int r3 = r9.$index
            int r4 = r9.$scrollOffset
            r2.snapToItem(r0, r3, r4)
        L_0x0226:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0229:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Index should be non-negative ("
            r0.append(r2)
            r0.append(r8)
            r2 = 41
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final boolean invokeSuspend$isOvershot(boolean z, LazyAnimateScrollScope lazyAnimateScrollScope, int i, int i2) {
        if (z) {
            if (lazyAnimateScrollScope.getFirstVisibleItemIndex() <= i && (lazyAnimateScrollScope.getFirstVisibleItemIndex() != i || lazyAnimateScrollScope.getFirstVisibleItemScrollOffset() <= i2)) {
                return false;
            }
        } else if (lazyAnimateScrollScope.getFirstVisibleItemIndex() >= i && (lazyAnimateScrollScope.getFirstVisibleItemIndex() != i || lazyAnimateScrollScope.getFirstVisibleItemScrollOffset() >= i2)) {
            return false;
        }
        return true;
    }
}
