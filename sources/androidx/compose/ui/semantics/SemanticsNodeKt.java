package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.Nodes;
import androidx.compose.ui.node.SemanticsModifierNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2Connection;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\fH\u0002\u001a\"\u0010\u0011\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001a\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016*\u00020\u00022\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018H\u0002\u001a\f\u0010\u0019\u001a\u00020\u0010*\u00020\fH\u0002\" \u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\" \u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\f8BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"outerMergingSemantics", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/LayoutNode;", "getOuterMergingSemantics$annotations", "(Landroidx/compose/ui/node/LayoutNode;)V", "getOuterMergingSemantics", "(Landroidx/compose/ui/node/LayoutNode;)Landroidx/compose/ui/node/SemanticsModifierNode;", "outerSemantics", "getOuterSemantics$annotations", "getOuterSemantics", "role", "Landroidx/compose/ui/semantics/Role;", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRole", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/semantics/Role;", "contentDescriptionFakeNodeId", "", "findClosestParentNode", "selector", "Lkotlin/Function1;", "", "findOneLayerOfSemanticsWrappers", "", "list", "", "roleFakeNodeId", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SemanticsNode.kt */
public final class SemanticsNodeKt {
    public static /* synthetic */ void getOuterMergingSemantics$annotations(LayoutNode layoutNode) {
    }

    public static /* synthetic */ void getOuterSemantics$annotations(LayoutNode layoutNode) {
    }

    public static final SemanticsModifierNode getOuterSemantics(LayoutNode layoutNode) {
        Modifier.Node node;
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        NodeChain nodes$ui_release = layoutNode.getNodes$ui_release();
        int r0 = Nodes.INSTANCE.m3941getSemanticsOLwlOKw();
        if ((nodes$ui_release.getAggregateChildKindSet() & r0) != 0) {
            node = nodes$ui_release.getHead$ui_release();
            while (true) {
                if (node != null) {
                    if ((node.getKindSet$ui_release() & r0) == 0 || !(node instanceof SemanticsModifierNode)) {
                        if ((node.getAggregateChildKindSet$ui_release() & r0) == 0) {
                            break;
                        }
                        node = node.getChild$ui_release();
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        node = null;
        return (SemanticsModifierNode) node;
    }

    public static final SemanticsModifierNode getOuterMergingSemantics(LayoutNode layoutNode) {
        Modifier.Node node;
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        NodeChain nodes$ui_release = layoutNode.getNodes$ui_release();
        int r0 = Nodes.INSTANCE.m3941getSemanticsOLwlOKw();
        if ((nodes$ui_release.getAggregateChildKindSet() & r0) != 0) {
            node = nodes$ui_release.getHead$ui_release();
            while (true) {
                if (node != null) {
                    if ((node.getKindSet$ui_release() & r0) == 0 || !(node instanceof SemanticsModifierNode) || !((SemanticsModifierNode) node).getSemanticsConfiguration().isMergingSemanticsOfDescendants()) {
                        if ((node.getAggregateChildKindSet$ui_release() & r0) == 0) {
                            break;
                        }
                        node = node.getChild$ui_release();
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        node = null;
        return (SemanticsModifierNode) node;
    }

    static /* synthetic */ List findOneLayerOfSemanticsWrappers$default(LayoutNode layoutNode, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return findOneLayerOfSemanticsWrappers(layoutNode, list);
    }

    private static final List<SemanticsModifierNode> findOneLayerOfSemanticsWrappers(LayoutNode layoutNode, List<SemanticsModifierNode> list) {
        MutableVector<LayoutNode> zSortedChildren = layoutNode.getZSortedChildren();
        int size = zSortedChildren.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = zSortedChildren.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode layoutNode2 = (LayoutNode) content[i];
                SemanticsModifierNode outerSemantics = getOuterSemantics(layoutNode2);
                if (outerSemantics != null) {
                    list.add(outerSemantics);
                } else {
                    findOneLayerOfSemanticsWrappers(layoutNode2, list);
                }
                i++;
            } while (i < size);
        }
        return list;
    }

    /* access modifiers changed from: private */
    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (function1.invoke(parent$ui_release).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final Role getRole(SemanticsNode semanticsNode) {
        return (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
    }

    /* access modifiers changed from: private */
    public static final int contentDescriptionFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 2000000000;
    }

    /* access modifiers changed from: private */
    public static final int roleFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
    }
}
