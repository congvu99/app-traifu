package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "Landroidx/compose/ui/Modifier$Node;", "invoke", "()Landroidx/compose/ui/Modifier$Node;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DelegatingNode.kt */
final class DelegatingNode$lazyDelegated$1 extends Lambda implements Function0<T> {
    final /* synthetic */ Function0<T> $fn;
    final /* synthetic */ DelegatingNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DelegatingNode$lazyDelegated$1(DelegatingNode delegatingNode, Function0<? extends T> function0) {
        super(0);
        this.this$0 = delegatingNode;
        this.$fn = function0;
    }

    public final T invoke() {
        return this.this$0.delegated(this.$fn);
    }
}
