package coil.compose;

import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Composables.kt */
public final class AsyncImageKt$Content$$inlined$Layout$1 extends Lambda implements Function0<ComposeUiNode> {
    final /* synthetic */ Function0 $factory;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncImageKt$Content$$inlined$Layout$1(Function0 function0) {
        super(0);
        this.$factory = function0;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
    public final ComposeUiNode invoke() {
        return this.$factory.invoke();
    }
}
