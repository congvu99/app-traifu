package androidx.compose.ui.node;

import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/ui/node/DelegatableNode;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NodeCoordinator.kt */
final class NodeCoordinator$hit$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HitTestResult<T> $hitTestResult;
    final /* synthetic */ NodeCoordinator.HitTestSource<T> $hitTestSource;
    final /* synthetic */ boolean $isInLayer;
    final /* synthetic */ boolean $isTouchEvent;
    final /* synthetic */ long $pointerPosition;
    final /* synthetic */ T $this_hit;
    final /* synthetic */ NodeCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NodeCoordinator$hit$1(NodeCoordinator nodeCoordinator, T t, NodeCoordinator.HitTestSource<T> hitTestSource, long j, HitTestResult<T> hitTestResult, boolean z, boolean z2) {
        super(0);
        this.this$0 = nodeCoordinator;
        this.$this_hit = t;
        this.$hitTestSource = hitTestSource;
        this.$pointerPosition = j;
        this.$hitTestResult = hitTestResult;
        this.$isTouchEvent = z;
        this.$isInLayer = z2;
    }

    public final void invoke() {
        this.this$0.m3884hit1hIXUjU((DelegatableNode) NodeCoordinatorKt.m3920nextUncheckedUntilhw7D004(this.$this_hit, this.$hitTestSource.m3918entityTypeOLwlOKw(), Nodes.INSTANCE.m3936getLayoutOLwlOKw()), this.$hitTestSource, this.$pointerPosition, this.$hitTestResult, this.$isTouchEvent, this.$isInLayer);
    }
}
