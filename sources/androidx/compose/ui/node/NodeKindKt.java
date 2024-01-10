package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.IntermediateLayoutModifier;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.LookaheadOnPlacedModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.semantics.SemanticsModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a&\u0010\r\u001a\u00020\b*\u00020\b2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\"%\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028@X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"includeSelfInTraversal", "", "Landroidx/compose/ui/node/NodeKind;", "getIncludeSelfInTraversal-H91voCI$annotations", "(I)V", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "calculateNodeKindSetFrom", "", "element", "Landroidx/compose/ui/Modifier$Element;", "node", "Landroidx/compose/ui/Modifier$Node;", "or", "other", "or-64DMado", "(II)I", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: NodeKind.kt */
public final class NodeKindKt {
    /* renamed from: getIncludeSelfInTraversal-H91voCI$annotations  reason: not valid java name */
    public static /* synthetic */ void m3931getIncludeSelfInTraversalH91voCI$annotations(int i) {
    }

    /* renamed from: or-64DMado  reason: not valid java name */
    public static final int m3932or64DMado(int i, int i2) {
        return i | i2;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI  reason: not valid java name */
    public static final boolean m3930getIncludeSelfInTraversalH91voCI(int i) {
        return (i & Nodes.INSTANCE.m3937getLayoutAwareOLwlOKw()) != 0;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        int i = 0;
        if (element instanceof LayoutModifier) {
            i = m3932or64DMado(0, Nodes.INSTANCE.m3936getLayoutOLwlOKw());
        }
        if (element instanceof IntermediateLayoutModifier) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3935getIntermediateMeasureOLwlOKw());
        }
        if (element instanceof DrawModifier) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3933getDrawOLwlOKw());
        }
        if (element instanceof SemanticsModifier) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3941getSemanticsOLwlOKw());
        }
        if (element instanceof PointerInputModifier) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3940getPointerInputOLwlOKw());
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider) || (element instanceof FocusOrderModifier)) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3938getLocalsOLwlOKw());
        }
        if (element instanceof OnGloballyPositionedModifier) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3934getGlobalPositionAwareOLwlOKw());
        }
        if (element instanceof ParentDataModifier) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3939getParentDataOLwlOKw());
        }
        return ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier) || (element instanceof LookaheadOnPlacedModifier)) ? m3932or64DMado(i, Nodes.INSTANCE.m3937getLayoutAwareOLwlOKw()) : i;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int i = 0;
        if (node instanceof LayoutModifierNode) {
            i = m3932or64DMado(0, Nodes.INSTANCE.m3936getLayoutOLwlOKw());
        }
        if (node instanceof DrawModifierNode) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3933getDrawOLwlOKw());
        }
        if (node instanceof SemanticsModifierNode) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3941getSemanticsOLwlOKw());
        }
        if (node instanceof PointerInputModifierNode) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3940getPointerInputOLwlOKw());
        }
        if (node instanceof ModifierLocalNode) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3938getLocalsOLwlOKw());
        }
        if (node instanceof ParentDataModifierNode) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3939getParentDataOLwlOKw());
        }
        if (node instanceof LayoutAwareModifierNode) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3937getLayoutAwareOLwlOKw());
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            i = m3932or64DMado(i, Nodes.INSTANCE.m3934getGlobalPositionAwareOLwlOKw());
        }
        return node instanceof IntermediateLayoutModifierNode ? m3932or64DMado(i, Nodes.INSTANCE.m3935getIntermediateMeasureOLwlOKw()) : i;
    }
}
