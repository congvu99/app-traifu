package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0007\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0002H\u0007\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"useMinimumTouchTarget", "", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getUseMinimumTouchTarget$annotations", "(Landroidx/compose/ui/node/SemanticsModifierNode;)V", "getUseMinimumTouchTarget", "(Landroidx/compose/ui/node/SemanticsModifierNode;)Z", "collapsedSemanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "invalidateSemantics", "", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SemanticsModifierNode.kt */
public final class SemanticsModifierNodeKt {
    public static /* synthetic */ void getUseMinimumTouchTarget$annotations(SemanticsModifierNode semanticsModifierNode) {
    }

    @ExperimentalComposeUiApi
    public static final void invalidateSemantics(SemanticsModifierNode semanticsModifierNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "<this>");
        DelegatableNodeKt.requireOwner(semanticsModifierNode).onSemanticsChange();
    }

    @ExperimentalComposeUiApi
    public static final SemanticsConfiguration collapsedSemanticsConfiguration(SemanticsModifierNode semanticsModifierNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "<this>");
        Modifier.Node localChild = DelegatableNodeKt.localChild(semanticsModifierNode, Nodes.INSTANCE.m3941getSemanticsOLwlOKw());
        if (!(localChild instanceof SemanticsModifierNode)) {
            localChild = null;
        }
        SemanticsModifierNode semanticsModifierNode2 = (SemanticsModifierNode) localChild;
        if (semanticsModifierNode2 == null || semanticsModifierNode.getSemanticsConfiguration().isClearingSemantics()) {
            return semanticsModifierNode.getSemanticsConfiguration();
        }
        SemanticsConfiguration copy = semanticsModifierNode.getSemanticsConfiguration().copy();
        copy.collapsePeer$ui_release(collapsedSemanticsConfiguration(semanticsModifierNode2));
        return copy;
    }

    public static final boolean getUseMinimumTouchTarget(SemanticsModifierNode semanticsModifierNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "<this>");
        return SemanticsConfigurationKt.getOrNull(semanticsModifierNode.getSemanticsConfiguration(), SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    public static final Rect touchBoundsInRoot(SemanticsModifierNode semanticsModifierNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "<this>");
        if (!semanticsModifierNode.getNode().isAttached()) {
            return Rect.Companion.getZero();
        }
        if (!getUseMinimumTouchTarget(semanticsModifierNode)) {
            return LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.m3750requireCoordinator64DMado(semanticsModifierNode, Nodes.INSTANCE.m3941getSemanticsOLwlOKw()));
        }
        return DelegatableNodeKt.m3750requireCoordinator64DMado(semanticsModifierNode, Nodes.INSTANCE.m3941getSemanticsOLwlOKw()).touchBoundsInRoot();
    }
}
