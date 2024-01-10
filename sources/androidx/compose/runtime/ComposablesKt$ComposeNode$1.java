package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: Composables.kt */
public final class ComposablesKt$ComposeNode$1 extends Lambda implements Function0<T> {
    final /* synthetic */ Function0<T> $factory;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposablesKt$ComposeNode$1(Function0<? extends T> function0) {
        super(0);
        this.$factory = function0;
    }

    public final T invoke() {
        return this.$factory.invoke();
    }
}
