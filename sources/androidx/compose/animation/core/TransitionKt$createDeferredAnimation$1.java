package androidx.compose.animation.core;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Transition.kt */
final class TransitionKt$createDeferredAnimation$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Transition<S>.DeferredAnimation<T, V> $lazyAnim;
    final /* synthetic */ Transition<S> $this_createDeferredAnimation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransitionKt$createDeferredAnimation$1(Transition<S> transition, Transition<S>.DeferredAnimation<T, V> deferredAnimation) {
        super(1);
        this.$this_createDeferredAnimation = transition;
        this.$lazyAnim = deferredAnimation;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new TransitionKt$createDeferredAnimation$1$invoke$$inlined$onDispose$1(this.$this_createDeferredAnimation, this.$lazyAnim);
    }
}
