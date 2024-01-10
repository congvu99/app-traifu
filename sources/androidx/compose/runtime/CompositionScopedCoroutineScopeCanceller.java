package androidx.compose.runtime;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/CompositionScopedCoroutineScopeCanceller;", "Landroidx/compose/runtime/RememberObserver;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Effects.kt */
public final class CompositionScopedCoroutineScopeCanceller implements RememberObserver {
    private final CoroutineScope coroutineScope;

    public void onRemembered() {
    }

    public CompositionScopedCoroutineScopeCanceller(CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        this.coroutineScope = coroutineScope2;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public void onForgotten() {
        CoroutineScopeKt.cancel$default(this.coroutineScope, (CancellationException) null, 1, (Object) null);
    }

    public void onAbandoned() {
        CoroutineScopeKt.cancel$default(this.coroutineScope, (CancellationException) null, 1, (Object) null);
    }
}
