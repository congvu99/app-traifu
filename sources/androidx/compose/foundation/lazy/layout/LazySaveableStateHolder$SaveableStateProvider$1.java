package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazySaveableStateHolder.kt */
final class LazySaveableStateHolder$SaveableStateProvider$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Object $key;
    final /* synthetic */ LazySaveableStateHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazySaveableStateHolder$SaveableStateProvider$1(LazySaveableStateHolder lazySaveableStateHolder, Object obj) {
        super(1);
        this.this$0 = lazySaveableStateHolder;
        this.$key = obj;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.this$0.previouslyComposedKeys.remove(this.$key);
        return new LazySaveableStateHolder$SaveableStateProvider$1$invoke$$inlined$onDispose$1(this.this$0, this.$key);
    }
}
