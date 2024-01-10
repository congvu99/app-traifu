package androidx.compose.ui.node;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.JsonLexerKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\f\u0010\u0012\u001a\u00020\r*\u00020\u0003H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSet;", "postponedMeasureRequests", "", "postponedLookaheadMeasureRequests", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/DepthSortedSet;Ljava/util/List;Ljava/util/List;)V", "assertConsistent", "", "isTreeConsistent", "", "node", "logTree", "", "nodeToString", "consistentLayoutState", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LayoutTreeConsistencyChecker.kt */
public final class LayoutTreeConsistencyChecker {
    private final List<LayoutNode> postponedLookaheadMeasureRequests;
    private final List<LayoutNode> postponedMeasureRequests;
    private final DepthSortedSet relayoutNodes;
    private final LayoutNode root;

    public LayoutTreeConsistencyChecker(LayoutNode layoutNode, DepthSortedSet depthSortedSet, List<LayoutNode> list, List<LayoutNode> list2) {
        Intrinsics.checkNotNullParameter(layoutNode, "root");
        Intrinsics.checkNotNullParameter(depthSortedSet, "relayoutNodes");
        Intrinsics.checkNotNullParameter(list, "postponedMeasureRequests");
        Intrinsics.checkNotNullParameter(list2, "postponedLookaheadMeasureRequests");
        this.root = layoutNode;
        this.relayoutNodes = depthSortedSet;
        this.postponedMeasureRequests = list;
        this.postponedLookaheadMeasureRequests = list2;
    }

    public final void assertConsistent() {
        if (!isTreeConsistent(this.root)) {
            System.out.println(logTree());
            throw new IllegalStateException("Inconsistency found!");
        }
    }

    private final boolean isTreeConsistent(LayoutNode layoutNode) {
        if (!consistentLayoutState(layoutNode)) {
            return false;
        }
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i = 0; i < size; i++) {
            if (!isTreeConsistent(children$ui_release.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if ((r0 != null && r0.isPlaced()) != false) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean consistentLayoutState(androidx.compose.ui.node.LayoutNode r7) {
        /*
            r6 = this;
            androidx.compose.ui.node.LayoutNode r0 = r7.getParent$ui_release()
            if (r0 == 0) goto L_0x000b
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = r0.getLayoutState$ui_release()
            goto L_0x000c
        L_0x000b:
            r1 = 0
        L_0x000c:
            boolean r2 = r7.isPlaced()
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x002a
            int r2 = r7.getPlaceOrder$ui_release()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r2 == r5) goto L_0x008c
            if (r0 == 0) goto L_0x0027
            boolean r2 = r0.isPlaced()
            if (r2 != r4) goto L_0x0027
            r2 = 1
            goto L_0x0028
        L_0x0027:
            r2 = 0
        L_0x0028:
            if (r2 == 0) goto L_0x008c
        L_0x002a:
            boolean r2 = r7.getMeasurePending$ui_release()
            if (r2 == 0) goto L_0x0039
            java.util.List<androidx.compose.ui.node.LayoutNode> r2 = r6.postponedMeasureRequests
            boolean r2 = r2.contains(r7)
            if (r2 == 0) goto L_0x0039
            return r4
        L_0x0039:
            boolean r2 = r7.getMeasurePending$ui_release()
            if (r2 == 0) goto L_0x005a
            androidx.compose.ui.node.DepthSortedSet r2 = r6.relayoutNodes
            boolean r7 = r2.contains(r7)
            if (r7 != 0) goto L_0x0058
            if (r0 == 0) goto L_0x0051
            boolean r7 = r0.getMeasurePending$ui_release()
            if (r7 != r4) goto L_0x0051
            r7 = 1
            goto L_0x0052
        L_0x0051:
            r7 = 0
        L_0x0052:
            if (r7 != 0) goto L_0x0058
            androidx.compose.ui.node.LayoutNode$LayoutState r7 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring
            if (r1 != r7) goto L_0x0059
        L_0x0058:
            r3 = 1
        L_0x0059:
            return r3
        L_0x005a:
            boolean r2 = r7.getLayoutPending$ui_release()
            if (r2 == 0) goto L_0x008c
            androidx.compose.ui.node.DepthSortedSet r2 = r6.relayoutNodes
            boolean r7 = r2.contains(r7)
            if (r7 != 0) goto L_0x008a
            if (r0 == 0) goto L_0x0072
            boolean r7 = r0.getMeasurePending$ui_release()
            if (r7 != r4) goto L_0x0072
            r7 = 1
            goto L_0x0073
        L_0x0072:
            r7 = 0
        L_0x0073:
            if (r7 != 0) goto L_0x008a
            if (r0 == 0) goto L_0x007f
            boolean r7 = r0.getLayoutPending$ui_release()
            if (r7 != r4) goto L_0x007f
            r7 = 1
            goto L_0x0080
        L_0x007f:
            r7 = 0
        L_0x0080:
            if (r7 != 0) goto L_0x008a
            androidx.compose.ui.node.LayoutNode$LayoutState r7 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring
            if (r1 == r7) goto L_0x008a
            androidx.compose.ui.node.LayoutNode$LayoutState r7 = androidx.compose.ui.node.LayoutNode.LayoutState.LayingOut
            if (r1 != r7) goto L_0x008b
        L_0x008a:
            r3 = 1
        L_0x008b:
            return r3
        L_0x008c:
            java.lang.Boolean r2 = r7.isPlacedInLookahead()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x0138
            boolean r2 = r7.getLookaheadMeasurePending$ui_release()
            if (r2 == 0) goto L_0x00a9
            java.util.List<androidx.compose.ui.node.LayoutNode> r2 = r6.postponedLookaheadMeasureRequests
            boolean r2 = r2.contains(r7)
            if (r2 == 0) goto L_0x00a9
            return r4
        L_0x00a9:
            boolean r2 = r7.getLookaheadMeasurePending$ui_release()
            if (r2 == 0) goto L_0x00e8
            androidx.compose.ui.node.DepthSortedSet r2 = r6.relayoutNodes
            boolean r2 = r2.contains(r7)
            if (r2 != 0) goto L_0x00e6
            if (r0 == 0) goto L_0x00c1
            boolean r2 = r0.getLookaheadMeasurePending$ui_release()
            if (r2 != r4) goto L_0x00c1
            r2 = 1
            goto L_0x00c2
        L_0x00c1:
            r2 = 0
        L_0x00c2:
            if (r2 != 0) goto L_0x00e6
            androidx.compose.ui.node.LayoutNode$LayoutState r2 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring
            if (r1 == r2) goto L_0x00e6
            if (r0 == 0) goto L_0x00d2
            boolean r0 = r0.getMeasurePending$ui_release()
            if (r0 != r4) goto L_0x00d2
            r0 = 1
            goto L_0x00d3
        L_0x00d2:
            r0 = 0
        L_0x00d3:
            if (r0 == 0) goto L_0x00e7
            androidx.compose.ui.layout.LookaheadScope r0 = r7.getMLookaheadScope$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.compose.ui.node.LayoutNode r0 = r0.getRoot()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00e7
        L_0x00e6:
            r3 = 1
        L_0x00e7:
            return r3
        L_0x00e8:
            boolean r2 = r7.getLookaheadLayoutPending$ui_release()
            if (r2 == 0) goto L_0x0138
            androidx.compose.ui.node.DepthSortedSet r2 = r6.relayoutNodes
            boolean r2 = r2.contains(r7)
            if (r2 != 0) goto L_0x0136
            if (r0 == 0) goto L_0x0100
            boolean r2 = r0.getLookaheadMeasurePending$ui_release()
            if (r2 != r4) goto L_0x0100
            r2 = 1
            goto L_0x0101
        L_0x0100:
            r2 = 0
        L_0x0101:
            if (r2 != 0) goto L_0x0136
            if (r0 == 0) goto L_0x010d
            boolean r2 = r0.getLookaheadLayoutPending$ui_release()
            if (r2 != r4) goto L_0x010d
            r2 = 1
            goto L_0x010e
        L_0x010d:
            r2 = 0
        L_0x010e:
            if (r2 != 0) goto L_0x0136
            androidx.compose.ui.node.LayoutNode$LayoutState r2 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring
            if (r1 == r2) goto L_0x0136
            androidx.compose.ui.node.LayoutNode$LayoutState r2 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut
            if (r1 == r2) goto L_0x0136
            if (r0 == 0) goto L_0x0122
            boolean r0 = r0.getLayoutPending$ui_release()
            if (r0 != r4) goto L_0x0122
            r0 = 1
            goto L_0x0123
        L_0x0122:
            r0 = 0
        L_0x0123:
            if (r0 == 0) goto L_0x0137
            androidx.compose.ui.layout.LookaheadScope r0 = r7.getMLookaheadScope$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.compose.ui.node.LayoutNode r0 = r0.getRoot()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0137
        L_0x0136:
            r3 = 1
        L_0x0137:
            return r3
        L_0x0138:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutTreeConsistencyChecker.consistentLayoutState(androidx.compose.ui.node.LayoutNode):boolean");
    }

    private final String nodeToString(LayoutNode layoutNode) {
        StringBuilder sb = new StringBuilder();
        sb.append(layoutNode);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(JsonLexerKt.BEGIN_LIST);
        sb2.append(layoutNode.getLayoutState$ui_release());
        sb2.append(JsonLexerKt.END_LIST);
        sb.append(sb2.toString());
        if (!layoutNode.isPlaced()) {
            sb.append("[!isPlaced]");
        }
        sb.append("[measuredByParent=" + layoutNode.getMeasuredByParent$ui_release() + JsonLexerKt.END_LIST);
        if (!consistentLayoutState(layoutNode)) {
            sb.append("[INCONSISTENT]");
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "with(StringBuilder()) {\n…     toString()\n        }");
        return sb3;
    }

    private final String logTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tree state:");
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        logTree$printSubTree(this, sb, this.root, 0);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return sb2;
    }

    private static final void logTree$printSubTree(LayoutTreeConsistencyChecker layoutTreeConsistencyChecker, StringBuilder sb, LayoutNode layoutNode, int i) {
        String nodeToString = layoutTreeConsistencyChecker.nodeToString(layoutNode);
        if (nodeToString.length() > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append("..");
            }
            sb.append(nodeToString);
            Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            i++;
        }
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i3 = 0; i3 < size; i3++) {
            logTree$printSubTree(layoutTreeConsistencyChecker, sb, children$ui_release.get(i3), i);
        }
    }
}
