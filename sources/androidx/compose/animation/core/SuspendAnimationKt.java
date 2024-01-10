package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u001a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\u0007\u001a\u0002H\u00022\u0006\u0010\b\u001a\u0002H\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u0001H\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b26\u0010\f\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00132\b\b\u0002\u0010\t\u001a\u00020\u00132\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b26\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001aa\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u001626\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001av\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2%\b\u0002\u0010\f\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001e\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 \u001ap\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00182\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2%\b\u0002\u0010\f\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001e\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010$\u001az\u0010%\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00182\u0006\u0010\b\u001a\u0002H\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020#2%\b\u0002\u0010\f\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001e\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010&\u001aZ\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001a2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(*\u0012\u0004\u0012\u0002H(0\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010+\u001a}\u0010,\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001e2\u0006\u0010*\u001a\u00020\u001c2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001a2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00182#\u0010\f\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001e\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001fH\u0002\u001a<\u0010/\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u001e2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0018H\u0000\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"animate", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "velocity", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(FFFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(FFLandroidx/compose/animation/core/FloatDecayAnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/AnimationState;", "animation", "Landroidx/compose/animation/core/Animation;", "startTimeNanos", "", "Lkotlin/Function1;", "Landroidx/compose/animation/core/AnimationScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/Animation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "sequentialAnimation", "", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callWithFrameNanos", "R", "onFrame", "frameTimeNanos", "(Landroidx/compose/animation/core/Animation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doAnimationFrame", "anim", "state", "updateState", "animation-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SuspendAnimation.kt */
public final class SuspendAnimationKt {
    public static /* synthetic */ Object animate$default(float f, float f2, float f3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj) {
        float f4 = (i & 4) != 0 ? 0.0f : f3;
        if ((i & 8) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        return animate(f, f2, f4, animationSpec, function2, continuation);
    }

    public static final Object animate(float f, float f2, float f3, AnimationSpec<Float> animationSpec, Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object animate = animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(f), Boxing.boxFloat(f2), Boxing.boxFloat(f3), animationSpec, function2, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static final Object animateDecay(float f, float f2, FloatDecayAnimationSpec floatDecayAnimationSpec, Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        float f3 = f;
        float f4 = f2;
        Object animate$default = animate$default(AnimationStateKt.AnimationState$default(f3, f4, 0, 0, false, 28, (Object) null), AnimationKt.DecayAnimation(floatDecayAnimationSpec, f3, f4), 0, new SuspendAnimationKt$animateDecay$2(function2), continuation, 2, (Object) null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animate$default(TwoWayConverter twoWayConverter, Object obj, Object obj2, Object obj3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj4) {
        AnimationSpec animationSpec2;
        Object obj5 = (i & 8) != 0 ? null : obj3;
        if ((i & 16) != 0) {
            animationSpec2 = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        } else {
            animationSpec2 = animationSpec;
        }
        return animate(twoWayConverter, obj, obj2, obj5, animationSpec2, function2, continuation);
    }

    public static final <T, V extends AnimationVector> Object animate(TwoWayConverter<T, V> twoWayConverter, T t, T t2, T t3, AnimationSpec<T> animationSpec, Function2<? super T, ? super T, Unit> function2, Continuation<? super Unit> continuation) {
        T t4 = t3;
        AnimationVector animationVector = t4 == null ? null : (AnimationVector) twoWayConverter.getConvertToVector().invoke(t4);
        if (animationVector == null) {
            animationVector = AnimationVectorsKt.newInstance((AnimationVector) twoWayConverter.getConvertToVector().invoke(t));
        } else {
            T t5 = t;
        }
        TwoWayConverter<T, V> twoWayConverter2 = twoWayConverter;
        Object animate$default = animate$default(new AnimationState(twoWayConverter, t, animationVector, 0, 0, false, 56, (DefaultConstructorMarker) null), new TargetBasedAnimation(animationSpec, twoWayConverter, t, t2, animationVector), 0, new SuspendAnimationKt$animate$3(function2, twoWayConverter), continuation, 2, (Object) null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        boolean z2 = (i & 4) != 0 ? false : z;
        if ((i & 8) != 0) {
            function1 = SuspendAnimationKt$animateTo$2.INSTANCE;
        }
        return animateTo(animationState, obj, animationSpec2, z2, function1, continuation);
    }

    public static final <T, V extends AnimationVector> Object animateTo(AnimationState<T, V> animationState, T t, AnimationSpec<T> animationSpec, boolean z, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        Object animate = animate(animationState, new TargetBasedAnimation(animationSpec, animationState.getTypeConverter(), animationState.getValue(), t, animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = SuspendAnimationKt$animateDecay$4.INSTANCE;
        }
        return animateDecay(animationState, decayAnimationSpec, z, function1, (Continuation<? super Unit>) continuation);
    }

    public static final <T, V extends AnimationVector> Object animateDecay(AnimationState<T, V> animationState, DecayAnimationSpec<T> decayAnimationSpec, boolean z, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        Object animate = animate(animationState, new DecayAnimation(decayAnimationSpec, animationState.getTypeConverter(), animationState.getValue(), animationState.getVelocityVector()), z ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ea A[Catch:{ CancellationException -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0102 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, V extends androidx.compose.animation.core.AnimationVector> java.lang.Object animate(androidx.compose.animation.core.AnimationState<T, V> r24, androidx.compose.animation.core.Animation<T, V> r25, long r26, kotlin.jvm.functions.Function1<? super androidx.compose.animation.core.AnimationScope<T, V>, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super kotlin.Unit> r29) {
        /*
            r8 = r24
            r0 = r25
            r1 = r29
            boolean r2 = r1 instanceof androidx.compose.animation.core.SuspendAnimationKt$animate$4
            if (r2 == 0) goto L_0x001a
            r2 = r1
            androidx.compose.animation.core.SuspendAnimationKt$animate$4 r2 = (androidx.compose.animation.core.SuspendAnimationKt$animate$4) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x001a
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001f
        L_0x001a:
            androidx.compose.animation.core.SuspendAnimationKt$animate$4 r2 = new androidx.compose.animation.core.SuspendAnimationKt$animate$4
            r2.<init>(r1)
        L_0x001f:
            r9 = r2
            java.lang.Object r1 = r9.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            r11 = 2
            r12 = 1
            if (r2 == 0) goto L_0x0066
            if (r2 == r12) goto L_0x004a
            if (r2 != r11) goto L_0x0042
            java.lang.Object r0 = r9.L$3
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r0 = r9.L$2
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.lang.Object r3 = r9.L$1
            androidx.compose.animation.core.Animation r3 = (androidx.compose.animation.core.Animation) r3
            java.lang.Object r4 = r9.L$0
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4
            goto L_0x005b
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004a:
            java.lang.Object r0 = r9.L$3
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r0 = r9.L$2
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.lang.Object r3 = r9.L$1
            androidx.compose.animation.core.Animation r3 = (androidx.compose.animation.core.Animation) r3
            java.lang.Object r4 = r9.L$0
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ CancellationException -> 0x0062 }
            r7 = r0
            r0 = r3
            goto L_0x00dd
        L_0x0062:
            r0 = move-exception
            r8 = r4
            goto L_0x010d
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = 0
            java.lang.Object r14 = r0.getValueFromNanos(r1)
            androidx.compose.animation.core.AnimationVector r16 = r0.getVelocityVectorFromNanos(r1)
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            r1 = -9223372036854775808
            int r3 = (r26 > r1 ? 1 : (r26 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x00aa
            androidx.compose.animation.core.SuspendAnimationKt$animate$6 r13 = new androidx.compose.animation.core.SuspendAnimationKt$animate$6     // Catch:{ CancellationException -> 0x00a6 }
            r1 = r13
            r2 = r15
            r3 = r14
            r4 = r25
            r5 = r16
            r6 = r24
            r7 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ CancellationException -> 0x00a6 }
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13     // Catch:{ CancellationException -> 0x00a6 }
            r9.L$0 = r8     // Catch:{ CancellationException -> 0x00a6 }
            r9.L$1 = r0     // Catch:{ CancellationException -> 0x00a6 }
            r7 = r28
            r9.L$2 = r7     // Catch:{ CancellationException -> 0x00a6 }
            r9.L$3 = r15     // Catch:{ CancellationException -> 0x00a6 }
            r9.label = r12     // Catch:{ CancellationException -> 0x00a6 }
            java.lang.Object r1 = callWithFrameNanos(r0, r13, r9)     // Catch:{ CancellationException -> 0x00a6 }
            if (r1 != r10) goto L_0x00a3
            return r10
        L_0x00a3:
            r4 = r8
            r2 = r15
            goto L_0x00dd
        L_0x00a6:
            r0 = move-exception
            r2 = r15
            goto L_0x010d
        L_0x00aa:
            r7 = r28
            androidx.compose.animation.core.AnimationScope r6 = new androidx.compose.animation.core.AnimationScope     // Catch:{ CancellationException -> 0x010a }
            androidx.compose.animation.core.TwoWayConverter r1 = r25.getTypeConverter()     // Catch:{ CancellationException -> 0x010a }
            java.lang.Object r19 = r25.getTargetValue()     // Catch:{ CancellationException -> 0x010a }
            r22 = 1
            androidx.compose.animation.core.SuspendAnimationKt$animate$7 r2 = new androidx.compose.animation.core.SuspendAnimationKt$animate$7     // Catch:{ CancellationException -> 0x010a }
            r2.<init>(r8)     // Catch:{ CancellationException -> 0x010a }
            r23 = r2
            kotlin.jvm.functions.Function0 r23 = (kotlin.jvm.functions.Function0) r23     // Catch:{ CancellationException -> 0x010a }
            r13 = r6
            r5 = r15
            r15 = r1
            r17 = r26
            r20 = r26
            r13.<init>(r14, r15, r16, r17, r19, r20, r22, r23)     // Catch:{ CancellationException -> 0x0107 }
            r1 = r6
            r2 = r26
            r4 = r25
            r13 = r5
            r5 = r24
            r14 = r6
            r6 = r28
            doAnimationFrame(r1, r2, r4, r5, r6)     // Catch:{ CancellationException -> 0x0105 }
            r13.element = r14     // Catch:{ CancellationException -> 0x0105 }
            r4 = r8
            r2 = r13
        L_0x00dd:
            T r1 = r2.element     // Catch:{ CancellationException -> 0x0062 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ CancellationException -> 0x0062 }
            androidx.compose.animation.core.AnimationScope r1 = (androidx.compose.animation.core.AnimationScope) r1     // Catch:{ CancellationException -> 0x0062 }
            boolean r1 = r1.isRunning()     // Catch:{ CancellationException -> 0x0062 }
            if (r1 == 0) goto L_0x0102
            androidx.compose.animation.core.SuspendAnimationKt$animate$9 r1 = new androidx.compose.animation.core.SuspendAnimationKt$animate$9     // Catch:{ CancellationException -> 0x0062 }
            r1.<init>(r2, r0, r4, r7)     // Catch:{ CancellationException -> 0x0062 }
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1     // Catch:{ CancellationException -> 0x0062 }
            r9.L$0 = r4     // Catch:{ CancellationException -> 0x0062 }
            r9.L$1 = r0     // Catch:{ CancellationException -> 0x0062 }
            r9.L$2 = r7     // Catch:{ CancellationException -> 0x0062 }
            r9.L$3 = r2     // Catch:{ CancellationException -> 0x0062 }
            r9.label = r11     // Catch:{ CancellationException -> 0x0062 }
            java.lang.Object r1 = callWithFrameNanos(r0, r1, r9)     // Catch:{ CancellationException -> 0x0062 }
            if (r1 != r10) goto L_0x00dd
            return r10
        L_0x0102:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0105:
            r0 = move-exception
            goto L_0x010c
        L_0x0107:
            r0 = move-exception
            r13 = r5
            goto L_0x010c
        L_0x010a:
            r0 = move-exception
            r13 = r15
        L_0x010c:
            r2 = r13
        L_0x010d:
            T r1 = r2.element
            androidx.compose.animation.core.AnimationScope r1 = (androidx.compose.animation.core.AnimationScope) r1
            r3 = 0
            if (r1 != 0) goto L_0x0115
            goto L_0x0118
        L_0x0115:
            r1.setRunning$animation_core_release(r3)
        L_0x0118:
            T r1 = r2.element
            androidx.compose.animation.core.AnimationScope r1 = (androidx.compose.animation.core.AnimationScope) r1
            if (r1 != 0) goto L_0x0120
        L_0x011e:
            r12 = 0
            goto L_0x012c
        L_0x0120:
            long r1 = r1.getLastFrameTimeNanos()
            long r4 = r8.getLastFrameTimeNanos()
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x011e
        L_0x012c:
            if (r12 == 0) goto L_0x0131
            r8.setRunning$animation_core_release(r3)
        L_0x0131:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SuspendAnimationKt.animate(androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.Animation, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animate$default(AnimationState animationState, Animation animation, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MIN_VALUE;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            function1 = SuspendAnimationKt$animate$5.INSTANCE;
        }
        return animate(animationState, animation, j2, function1, continuation);
    }

    /* access modifiers changed from: private */
    public static final <R, T, V extends AnimationVector> Object callWithFrameNanos(Animation<T, V> animation, Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        if (animation.isInfinite()) {
            return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(function1, continuation);
        }
        return MonotonicFrameClockKt.withFrameNanos(new SuspendAnimationKt$callWithFrameNanos$2(function1), continuation);
    }

    public static final <T, V extends AnimationVector> void updateState(AnimationScope<T, V> animationScope, AnimationState<T, V> animationState) {
        Intrinsics.checkNotNullParameter(animationScope, "<this>");
        Intrinsics.checkNotNullParameter(animationState, "state");
        animationState.setValue$animation_core_release(animationScope.getValue());
        AnimationVectorsKt.copyFrom(animationState.getVelocityVector(), animationScope.getVelocityVector());
        animationState.setFinishedTimeNanos$animation_core_release(animationScope.getFinishedTimeNanos());
        animationState.setLastFrameTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
        animationState.setRunning$animation_core_release(animationScope.isRunning());
    }

    /* access modifiers changed from: private */
    public static final <T, V extends AnimationVector> void doAnimationFrame(AnimationScope<T, V> animationScope, long j, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        animationScope.setLastFrameTimeNanos$animation_core_release(j);
        long startTimeNanos = j - animationScope.getStartTimeNanos();
        animationScope.setValue$animation_core_release(animation.getValueFromNanos(startTimeNanos));
        animationScope.setVelocityVector$animation_core_release(animation.getVelocityVectorFromNanos(startTimeNanos));
        if (animation.isFinishedFromNanos(startTimeNanos)) {
            animationScope.setFinishedTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
            animationScope.setRunning$animation_core_release(false);
        }
        updateState(animationScope, animationState);
        function1.invoke(animationScope);
    }
}
