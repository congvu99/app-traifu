package androidx.activity.compose;

import androidx.compose.runtime.DisposableEffectResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Effects.kt */
public final class BackHandlerKt$BackHandler$2$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ BackHandlerKt$BackHandler$backCallback$1$1 $backCallback$inlined;

    public BackHandlerKt$BackHandler$2$invoke$$inlined$onDispose$1(BackHandlerKt$BackHandler$backCallback$1$1 backHandlerKt$BackHandler$backCallback$1$1) {
        this.$backCallback$inlined = backHandlerKt$BackHandler$backCallback$1$1;
    }

    public void dispose() {
        this.$backCallback$inlined.remove();
    }
}
