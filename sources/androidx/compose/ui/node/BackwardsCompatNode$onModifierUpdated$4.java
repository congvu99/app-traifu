package androidx.compose.ui.node;

import androidx.compose.ui.node.Owner;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/ui/node/BackwardsCompatNode$onModifierUpdated$4", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "onLayoutComplete", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BackwardsCompatNode.kt */
public final class BackwardsCompatNode$onModifierUpdated$4 implements Owner.OnLayoutCompletedListener {
    final /* synthetic */ BackwardsCompatNode this$0;

    BackwardsCompatNode$onModifierUpdated$4(BackwardsCompatNode backwardsCompatNode) {
        this.this$0 = backwardsCompatNode;
    }

    public void onLayoutComplete() {
        if (this.this$0.lastOnPlacedCoordinates == null) {
            BackwardsCompatNode backwardsCompatNode = this.this$0;
            backwardsCompatNode.onPlaced(DelegatableNodeKt.m3750requireCoordinator64DMado(backwardsCompatNode, Nodes.INSTANCE.m3937getLayoutAwareOLwlOKw()));
        }
    }
}
