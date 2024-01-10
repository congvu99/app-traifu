package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.NodeLocationHolder;
import io.intercom.android.sdk.views.holder.AttributeType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\"\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0000¨\u0006\f"}, d2 = {"findCoordinatorToGetBounds", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LayoutNode;", "findNodeByPredicateTraversal", "predicate", "Lkotlin/Function1;", "", "findOneLayerOfSemanticsWrappersSortedByBounds", "", "Landroidx/compose/ui/node/SemanticsModifierNode;", "list", "", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SemanticsSort.kt */
public final class SemanticsSortKt {
    public static /* synthetic */ List findOneLayerOfSemanticsWrappersSortedByBounds$default(LayoutNode layoutNode, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return findOneLayerOfSemanticsWrappersSortedByBounds(layoutNode, list);
    }

    private static final List<NodeLocationHolder> findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy(List<NodeLocationHolder> list) {
        try {
            NodeLocationHolder.Companion.setComparisonStrategy$ui_release(NodeLocationHolder.ComparisonStrategy.Stripe);
            List<NodeLocationHolder> mutableList = CollectionsKt.toMutableList(list);
            CollectionsKt.sort(mutableList);
            return mutableList;
        } catch (IllegalArgumentException unused) {
            NodeLocationHolder.Companion.setComparisonStrategy$ui_release(NodeLocationHolder.ComparisonStrategy.Location);
            List<NodeLocationHolder> mutableList2 = CollectionsKt.toMutableList(list);
            CollectionsKt.sort(mutableList2);
            return mutableList2;
        }
    }

    public static final List<SemanticsModifierNode> findOneLayerOfSemanticsWrappersSortedByBounds(LayoutNode layoutNode, List<SemanticsModifierNode> list) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Intrinsics.checkNotNullParameter(list, AttributeType.LIST);
        if (!layoutNode.isAttached()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = children$ui_release.get(i);
            if (layoutNode2.isAttached()) {
                arrayList.add(new NodeLocationHolder(layoutNode, layoutNode2));
            }
        }
        List<NodeLocationHolder> findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy = findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy(arrayList);
        ArrayList arrayList2 = new ArrayList(findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy.size());
        int size2 = findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy.size();
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList2.add(findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy.get(i2).getNode$ui_release());
        }
        List list2 = arrayList2;
        int size3 = list2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            LayoutNode layoutNode3 = (LayoutNode) list2.get(i3);
            SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode3);
            if (outerSemantics != null) {
                list.add(outerSemantics);
            } else {
                findOneLayerOfSemanticsWrappersSortedByBounds(layoutNode3, list);
            }
        }
        return list;
    }

    public static final LayoutNode findNodeByPredicateTraversal(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (function1.invoke(layoutNode).booleanValue()) {
            return layoutNode;
        }
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i = 0; i < size; i++) {
            LayoutNode findNodeByPredicateTraversal = findNodeByPredicateTraversal(children$ui_release.get(i), function1);
            if (findNodeByPredicateTraversal != null) {
                return findNodeByPredicateTraversal;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        r0 = (r0 = r0.getNode()).getCoordinator$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.node.NodeCoordinator findCoordinatorToGetBounds(androidx.compose.ui.node.LayoutNode r1) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            androidx.compose.ui.node.SemanticsModifierNode r0 = androidx.compose.ui.semantics.SemanticsNodeKt.getOuterMergingSemantics(r1)
            if (r0 != 0) goto L_0x000f
            androidx.compose.ui.node.SemanticsModifierNode r0 = androidx.compose.ui.semantics.SemanticsNodeKt.getOuterSemantics(r1)
        L_0x000f:
            if (r0 == 0) goto L_0x001d
            androidx.compose.ui.Modifier$Node r0 = r0.getNode()
            if (r0 == 0) goto L_0x001d
            androidx.compose.ui.node.NodeCoordinator r0 = r0.getCoordinator$ui_release()
            if (r0 != 0) goto L_0x0021
        L_0x001d:
            androidx.compose.ui.node.NodeCoordinator r0 = r1.getInnerCoordinator$ui_release()
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsSortKt.findCoordinatorToGetBounds(androidx.compose.ui.node.LayoutNode):androidx.compose.ui.node.NodeCoordinator");
    }
}
