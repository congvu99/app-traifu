package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B-\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\tJ\\\u00105\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001062\u0006\u00107\u001a\u00028\u00002\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u0000092'\b\u0002\u0010:\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020<\u0018\u00010;¢\u0006\u0002\b=H@ø\u0001\u0000¢\u0006\u0002\u0010>Jh\u0010?\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001062\u0006\u0010$\u001a\u00028\u00002\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000@2\b\b\u0002\u00107\u001a\u00028\u00002'\b\u0002\u0010:\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020<\u0018\u00010;¢\u0006\u0002\b=H@ø\u0001\u0000¢\u0006\u0002\u0010AJ\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000CJ\u0015\u0010D\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u00020<H\u0002J`\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001062\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010I2\u0006\u00107\u001a\u00028\u00002%\u0010:\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020<\u0018\u00010;¢\u0006\u0002\b=H@ø\u0001\u0000¢\u0006\u0002\u0010JJ\u0019\u0010K\u001a\u00020<2\u0006\u0010$\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u0011\u0010M\u001a\u00020<H@ø\u0001\u0000¢\u0006\u0002\u0010NJ#\u0010O\u001a\u00020<2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010+\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010PJ\u0019\u0010Q\u001a\u00028\u0001*\u00028\u00002\u0006\u0010.\u001a\u00020RH\u0002¢\u0006\u0002\u0010SR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u0004\u0018\u00018\u00002\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000@BX\u000e¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u00028\u0001X\u000e¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010#\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u001fR+\u0010$\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008F@BX\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0019\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010'R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00018\u00002\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000@BX\u000e¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b,\u0010\u001cR\u0010\u0010-\u001a\u00028\u0001X\u000e¢\u0006\u0004\n\u0002\u0010\u001fR\u0011\u0010.\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b/\u0010\u001cR\u0011\u00100\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b1\u0010\u001cR\u0011\u00102\u001a\u00028\u00018F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006T"}, d2 = {"Landroidx/compose/animation/core/Animatable;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "initialValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "visibilityThreshold", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)V", "defaultSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "getDefaultSpringSpec$animation_core_release", "()Landroidx/compose/animation/core/SpringSpec;", "internalState", "Landroidx/compose/animation/core/AnimationState;", "getInternalState$animation_core_release", "()Landroidx/compose/animation/core/AnimationState;", "<set-?>", "", "isRunning", "()Z", "setRunning", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "lowerBound", "getLowerBound", "()Ljava/lang/Object;", "Ljava/lang/Object;", "lowerBoundVector", "Landroidx/compose/animation/core/AnimationVector;", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "negativeInfinityBounds", "positiveInfinityBounds", "targetValue", "getTargetValue", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "upperBound", "getUpperBound", "upperBoundVector", "value", "getValue", "velocity", "getVelocity", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "animateDecay", "Landroidx/compose/animation/core/AnimationResult;", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "Landroidx/compose/animation/core/AnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "clampToBounds", "(Ljava/lang/Object;)Ljava/lang/Object;", "endAnimation", "runAnimation", "animation", "Landroidx/compose/animation/core/Animation;", "(Landroidx/compose/animation/core/Animation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBounds", "(Ljava/lang/Object;Ljava/lang/Object;)V", "createVector", "", "(Ljava/lang/Object;F)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Animatable.kt */
public final class Animatable<T, V extends AnimationVector> {
    public static final int $stable = 8;
    private final SpringSpec<T> defaultSpringSpec;
    private final AnimationState<T, V> internalState;
    private final MutableState isRunning$delegate;
    private T lowerBound;
    private V lowerBoundVector;
    private final MutatorMutex mutatorMutex;
    private final V negativeInfinityBounds;
    private final V positiveInfinityBounds;
    private final MutableState targetValue$delegate;
    private final TwoWayConverter<T, V> typeConverter;
    private T upperBound;
    private V upperBoundVector;
    private final T visibilityThreshold;

    public Animatable(T t, TwoWayConverter<T, V> twoWayConverter, T t2) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        this.typeConverter = twoWayConverter;
        this.visibilityThreshold = t2;
        this.internalState = new AnimationState(this.typeConverter, t, (AnimationVector) null, 0, 0, false, 60, (DefaultConstructorMarker) null);
        this.isRunning$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.targetValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.mutatorMutex = new MutatorMutex();
        this.defaultSpringSpec = new SpringSpec(0.0f, 0.0f, this.visibilityThreshold, 3, (DefaultConstructorMarker) null);
        this.negativeInfinityBounds = createVector(t, Float.NEGATIVE_INFINITY);
        V createVector = createVector(t, Float.POSITIVE_INFINITY);
        this.positiveInfinityBounds = createVector;
        this.lowerBoundVector = this.negativeInfinityBounds;
        this.upperBoundVector = createVector;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Animatable(Object obj, TwoWayConverter twoWayConverter, Object obj2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, twoWayConverter, (i & 4) != 0 ? null : obj2);
    }

    public final TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final AnimationState<T, V> getInternalState$animation_core_release() {
        return this.internalState;
    }

    public final T getValue() {
        return this.internalState.getValue();
    }

    public final V getVelocityVector() {
        return this.internalState.getVelocityVector();
    }

    public final T getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(getVelocityVector());
    }

    /* access modifiers changed from: private */
    public final void setRunning(boolean z) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void setTargetValue(T t) {
        this.targetValue$delegate.setValue(t);
    }

    public final T getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    public final T getLowerBound() {
        return this.lowerBound;
    }

    public final T getUpperBound() {
        return this.upperBound;
    }

    public final SpringSpec<T> getDefaultSpringSpec$animation_core_release() {
        return this.defaultSpringSpec;
    }

    private final V createVector(T t, float f) {
        V v = (AnimationVector) this.typeConverter.getConvertToVector().invoke(t);
        int size$animation_core_release = v.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            v.set$animation_core_release(i, f);
        }
        return v;
    }

    public static /* synthetic */ void updateBounds$default(Animatable animatable, T t, T t2, int i, Object obj) {
        if ((i & 1) != 0) {
            t = animatable.lowerBound;
        }
        if ((i & 2) != 0) {
            t2 = animatable.upperBound;
        }
        animatable.updateBounds(t, t2);
    }

    public final void updateBounds(T t, T t2) {
        V v = null;
        V v2 = t == null ? null : (AnimationVector) getTypeConverter().getConvertToVector().invoke(t);
        if (v2 == null) {
            v2 = this.negativeInfinityBounds;
        }
        if (t2 != null) {
            v = (AnimationVector) getTypeConverter().getConvertToVector().invoke(t2);
        }
        if (v == null) {
            v = this.positiveInfinityBounds;
        }
        int size$animation_core_release = v2.getSize$animation_core_release();
        int i = 0;
        while (i < size$animation_core_release) {
            int i2 = i + 1;
            if (v2.get$animation_core_release(i) <= v.get$animation_core_release(i)) {
                i = i2;
            } else {
                throw new IllegalStateException(("Lower bound must be no greater than upper bound on *all* dimensions. The provided lower bound: " + v2 + " is greater than upper bound " + v + " on index " + i).toString());
            }
        }
        this.lowerBoundVector = v2;
        this.upperBoundVector = v;
        this.upperBound = t2;
        this.lowerBound = t;
        if (!isRunning()) {
            Object clampToBounds = clampToBounds(getValue());
            if (!Intrinsics.areEqual(clampToBounds, getValue())) {
                this.internalState.setValue$animation_core_release(clampToBounds);
            }
        }
    }

    public static /* synthetic */ Object animateTo$default(Animatable animatable, Object obj, AnimationSpec animationSpec, Object obj2, Function1 function1, Continuation continuation, int i, Object obj3) {
        if ((i & 2) != 0) {
            animationSpec = animatable.getDefaultSpringSpec$animation_core_release();
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            obj2 = animatable.getVelocity();
        }
        Object obj4 = obj2;
        if ((i & 8) != 0) {
            function1 = null;
        }
        return animatable.animateTo(obj, animationSpec2, obj4, function1, continuation);
    }

    public final Object animateTo(T t, AnimationSpec<T> animationSpec, T t2, Function1<? super Animatable<T, V>, Unit> function1, Continuation<? super AnimationResult<T, V>> continuation) {
        return runAnimation(AnimationKt.TargetBasedAnimation(animationSpec, getTypeConverter(), getValue(), t, t2), t2, function1, continuation);
    }

    public static /* synthetic */ Object animateDecay$default(Animatable animatable, Object obj, DecayAnimationSpec decayAnimationSpec, Function1 function1, Continuation continuation, int i, Object obj2) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        return animatable.animateDecay(obj, decayAnimationSpec, function1, continuation);
    }

    public final Object animateDecay(T t, DecayAnimationSpec<T> decayAnimationSpec, Function1<? super Animatable<T, V>, Unit> function1, Continuation<? super AnimationResult<T, V>> continuation) {
        return runAnimation(new DecayAnimation(decayAnimationSpec, getTypeConverter(), getValue(), (AnimationVector) getTypeConverter().getConvertToVector().invoke(t)), t, function1, continuation);
    }

    /* access modifiers changed from: private */
    public final Object runAnimation(Animation<T, V> animation, T t, Function1<? super Animatable<T, V>, Unit> function1, Continuation<? super AnimationResult<T, V>> continuation) {
        long lastFrameTimeNanos = getInternalState$animation_core_release().getLastFrameTimeNanos();
        return MutatorMutex.mutate$default(this.mutatorMutex, (MutatePriority) null, new Animatable$runAnimation$2(this, t, animation, lastFrameTimeNanos, function1, (Continuation<? super Animatable$runAnimation$2>) null), continuation, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final T clampToBounds(T t) {
        if (Intrinsics.areEqual((Object) this.lowerBoundVector, (Object) this.negativeInfinityBounds) && Intrinsics.areEqual((Object) this.upperBoundVector, (Object) this.positiveInfinityBounds)) {
            return t;
        }
        AnimationVector animationVector = (AnimationVector) this.typeConverter.getConvertToVector().invoke(t);
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        int i = 0;
        boolean z = false;
        while (i < size$animation_core_release) {
            int i2 = i + 1;
            if (animationVector.get$animation_core_release(i) < this.lowerBoundVector.get$animation_core_release(i) || animationVector.get$animation_core_release(i) > this.upperBoundVector.get$animation_core_release(i)) {
                animationVector.set$animation_core_release(i, RangesKt.coerceIn(animationVector.get$animation_core_release(i), this.lowerBoundVector.get$animation_core_release(i), this.upperBoundVector.get$animation_core_release(i)));
                z = true;
            }
            i = i2;
        }
        return z ? this.typeConverter.getConvertFromVector().invoke(animationVector) : t;
    }

    /* access modifiers changed from: private */
    public final void endAnimation() {
        AnimationState<T, V> animationState = this.internalState;
        animationState.getVelocityVector().reset$animation_core_release();
        animationState.setLastFrameTimeNanos$animation_core_release(Long.MIN_VALUE);
        setRunning(false);
    }

    public final Object snapTo(T t, Continuation<? super Unit> continuation) {
        Object mutate$default = MutatorMutex.mutate$default(this.mutatorMutex, (MutatePriority) null, new Animatable$snapTo$2(this, t, (Continuation<? super Animatable$snapTo$2>) null), continuation, 1, (Object) null);
        return mutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    public final Object stop(Continuation<? super Unit> continuation) {
        Object mutate$default = MutatorMutex.mutate$default(this.mutatorMutex, (MutatePriority) null, new Animatable$stop$2(this, (Continuation<? super Animatable$stop$2>) null), continuation, 1, (Object) null);
        return mutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    public final State<T> asState() {
        return this.internalState;
    }
}
