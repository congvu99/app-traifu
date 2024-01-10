package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0001¨\u0006\u0005"}, d2 = {"invalidateLayer", "", "Landroidx/compose/ui/node/LayoutModifierNode;", "requestRelayout", "requestRemeasure", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LayoutModifierNode.kt */
public final class LayoutModifierNodeKt {
    @ExperimentalComposeUiApi
    public static final void invalidateLayer(LayoutModifierNode layoutModifierNode) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "<this>");
        DelegatableNodeKt.m3750requireCoordinator64DMado(layoutModifierNode, Nodes.INSTANCE.m3936getLayoutOLwlOKw()).invalidateLayer();
    }

    @ExperimentalComposeUiApi
    public static final void requestRelayout(LayoutModifierNode layoutModifierNode) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "<this>");
        LayoutNode.requestRelayout$ui_release$default(DelegatableNodeKt.requireLayoutNode(layoutModifierNode), false, 1, (Object) null);
    }

    @ExperimentalComposeUiApi
    public static final void requestRemeasure(LayoutModifierNode layoutModifierNode) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "<this>");
        LayoutNode.requestRemeasure$ui_release$default(DelegatableNodeKt.requireLayoutNode(layoutModifierNode), false, 1, (Object) null);
    }
}
