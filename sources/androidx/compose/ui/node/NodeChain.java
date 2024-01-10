package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0002`aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010%\u001a\u00020&J\u0018\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0010H\u0002J\r\u0010*\u001a\u00020&H\u0000¢\u0006\u0002\b+J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0010H\u0002JE\u0010.\u001a\u0004\u0018\u0001H/\"\u0006\b\u0000\u0010/\u0018\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u001903H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b4\u00105J0\u00106\u001a\u00060\rR\u00020\u00002\u0006\u0010#\u001a\u00020\u00102\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:J!\u0010<\u001a\u00020\u00192\n\u00100\u001a\u0006\u0012\u0002\b\u000301H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b=\u0010>J.\u0010\u0011\u001a\u0004\u0018\u0001H/\"\u0006\b\u0000\u0010/\u0018\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/01H\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b?\u0010@J%\u0010A\u001a\u00020&2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&03H\bø\u0001\u0000¢\u0006\u0002\bBJC\u0010A\u001a\u00020&\"\u0006\b\u0000\u0010/\u0018\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020&03H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bC\u0010DJ-\u0010A\u001a\u00020&2\u0006\u0010E\u001a\u00020\u00062\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&03H\bø\u0001\u0000¢\u0006\u0002\bBJ%\u0010F\u001a\u00020&2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&03H\bø\u0001\u0000¢\u0006\u0002\bGJ\u0018\u0010H\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0002J\b\u0010I\u001a\u00020&H\u0002J\u0010\u0010J\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0010H\u0002J\u0018\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\u0010H\u0002J<\u0010N\u001a\u00020&2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010O\u001a\u00020\u00062\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010P\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0010H\u0002J\b\u0010Q\u001a\u00020&H\u0002J.\u0010#\u001a\u0004\u0018\u0001H/\"\u0006\b\u0000\u0010/\u0018\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/01H\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bR\u0010@J%\u0010S\u001a\u00020&2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&03H\bø\u0001\u0000¢\u0006\u0002\bTJC\u0010S\u001a\u00020&\"\u0006\b\u0000\u0010/\u0018\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020&03H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bU\u0010DJ-\u0010S\u001a\u00020&2\u0006\u0010E\u001a\u00020\u00062\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&03H\bø\u0001\u0000¢\u0006\u0002\bTJ\b\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020&H\u0002J\u0015\u0010Y\u001a\u00020&2\u0006\u0010Z\u001a\u00020[H\u0000¢\u0006\u0002\b\\J \u0010]\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u0010H\u0002J\u0017\u0010^\u001a\u00020&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\b_R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u001f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006b"}, d2 = {"Landroidx/compose/ui/node/NodeChain;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "aggregateChildKindSet", "", "getAggregateChildKindSet", "()I", "buffer", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "cachedDiffer", "Landroidx/compose/ui/node/NodeChain$Differ;", "current", "<set-?>", "Landroidx/compose/ui/Modifier$Node;", "head", "getHead$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "innerCoordinator", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/InnerNodeCoordinator;", "isUpdating", "", "()Z", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "logger", "Landroidx/compose/ui/node/NodeChain$Logger;", "Landroidx/compose/ui/node/NodeCoordinator;", "outerCoordinator", "getOuterCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "tail", "getTail$ui_release", "attach", "", "createAndInsertNodeAsParent", "element", "child", "detach", "detach$ui_release", "disposeAndRemoveNode", "node", "firstFromHead", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "block", "Lkotlin/Function1;", "firstFromHead-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getDiffer", "before", "after", "getModifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "has", "has-H91voCI$ui_release", "(I)Z", "head-H91voCI$ui_release", "(I)Ljava/lang/Object;", "headToTail", "headToTail$ui_release", "headToTail-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "mask", "headToTailExclusive", "headToTailExclusive$ui_release", "insertParent", "padChain", "removeNode", "replaceNode", "prev", "next", "structuralUpdate", "beforeSize", "afterSize", "syncCoordinators", "tail-H91voCI$ui_release", "tailToHead", "tailToHead$ui_release", "tailToHead-aLcG6gQ$ui_release", "toString", "", "trimChain", "updateFrom", "m", "Landroidx/compose/ui/Modifier;", "updateFrom$ui_release", "updateNodeAndReplaceIfNeeded", "useLogger", "useLogger$ui_release", "Differ", "Logger", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NodeChain.kt */
public final class NodeChain {
    private MutableVector<Modifier.Element> buffer;
    private Differ cachedDiffer;
    private MutableVector<Modifier.Element> current;
    private Modifier.Node head;
    private final InnerNodeCoordinator innerCoordinator;
    private final LayoutNode layoutNode;
    /* access modifiers changed from: private */
    public Logger logger;
    private NodeCoordinator outerCoordinator;
    private final Modifier.Node tail;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J8\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Logger;", "", "linearDiffAborted", "", "index", "", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "node", "Landroidx/compose/ui/Modifier$Node;", "nodeInserted", "atIndex", "newIndex", "element", "child", "inserted", "nodeRemoved", "oldIndex", "nodeReused", "nodeUpdated", "before", "after", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NodeChain.kt */
    public interface Logger {
        void linearDiffAborted(int i, Modifier.Element element, Modifier.Element element2, Modifier.Node node);

        void nodeInserted(int i, int i2, Modifier.Element element, Modifier.Node node, Modifier.Node node2);

        void nodeRemoved(int i, Modifier.Element element, Modifier.Node node);

        void nodeReused(int i, int i2, Modifier.Element element, Modifier.Element element2, Modifier.Node node);

        void nodeUpdated(int i, int i2, Modifier.Element element, Modifier.Element element2, Modifier.Node node, Modifier.Node node2);
    }

    public NodeChain(LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.layoutNode = layoutNode2;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(this.layoutNode);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        Modifier.Node tail2 = innerNodeCoordinator.getTail();
        this.tail = tail2;
        this.head = tail2;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final InnerNodeCoordinator getInnerCoordinator$ui_release() {
        return this.innerCoordinator;
    }

    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.outerCoordinator;
    }

    public final Modifier.Node getTail$ui_release() {
        return this.tail;
    }

    public final Modifier.Node getHead$ui_release() {
        return this.head;
    }

    private final boolean isUpdating() {
        return this.head == NodeChainKt.SentinelHead;
    }

    /* access modifiers changed from: private */
    public final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet$ui_release();
    }

    public final void useLogger$ui_release(Logger logger2) {
        this.logger = logger2;
    }

    private final void padChain() {
        if (this.head != NodeChainKt.SentinelHead) {
            Modifier.Node node = this.head;
            node.setParent$ui_release(NodeChainKt.SentinelHead);
            NodeChainKt.SentinelHead.setChild$ui_release(node);
            this.head = NodeChainKt.SentinelHead;
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void trimChain() {
        boolean z = true;
        if (this.head == NodeChainKt.SentinelHead) {
            Modifier.Node child$ui_release = NodeChainKt.SentinelHead.getChild$ui_release();
            if (child$ui_release == null) {
                child$ui_release = this.tail;
            }
            this.head = child$ui_release;
            child$ui_release.setParent$ui_release((Modifier.Node) null);
            NodeChainKt.SentinelHead.setChild$ui_release((Modifier.Node) null);
            if (this.head == NodeChainKt.SentinelHead) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateFrom$ui_release(androidx.compose.ui.Modifier r18) {
        /*
            r17 = this;
            r6 = r17
            r0 = r18
            java.lang.String r1 = "m"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r17.padChain()
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.Modifier$Element> r1 = r6.current
            r2 = 16
            r3 = 0
            if (r1 != 0) goto L_0x001a
            androidx.compose.runtime.collection.MutableVector r1 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Element[] r4 = new androidx.compose.ui.Modifier.Element[r2]
            r1.<init>(r4, r3)
        L_0x001a:
            r7 = r1
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.Modifier$Element> r1 = r6.buffer
            if (r1 != 0) goto L_0x0026
            androidx.compose.runtime.collection.MutableVector r1 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Element[] r2 = new androidx.compose.ui.Modifier.Element[r2]
            r1.<init>(r2, r3)
        L_0x0026:
            androidx.compose.runtime.collection.MutableVector r8 = androidx.compose.ui.node.NodeChainKt.fillVector(r0, r1)
            int r0 = r8.getSize()
            int r1 = r7.getSize()
            r9 = 1
            if (r0 != r1) goto L_0x00c4
            int r0 = r7.getSize()
            androidx.compose.ui.Modifier$Node r1 = r6.tail
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            int r0 = r0 - r9
            r2 = 0
            r4 = 0
        L_0x0042:
            if (r1 == 0) goto L_0x00a4
            if (r0 < 0) goto L_0x00a4
            java.lang.Object[] r5 = r7.getContent()
            r5 = r5[r0]
            r13 = r5
            androidx.compose.ui.Modifier$Element r13 = (androidx.compose.ui.Modifier.Element) r13
            java.lang.Object[] r5 = r8.getContent()
            r5 = r5[r0]
            r14 = r5
            androidx.compose.ui.Modifier$Element r14 = (androidx.compose.ui.Modifier.Element) r14
            int r5 = androidx.compose.ui.node.NodeChainKt.reuseActionForModifiers(r13, r14)
            if (r5 == 0) goto L_0x0097
            if (r5 == r9) goto L_0x006f
            r10 = 2
            if (r5 == r10) goto L_0x0064
            goto L_0x0088
        L_0x0064:
            androidx.compose.ui.node.NodeChain$Logger r10 = r6.logger
            if (r10 == 0) goto L_0x0088
            r11 = r0
            r12 = r0
            r15 = r1
            r10.nodeReused(r11, r12, r13, r14, r15)
            goto L_0x0088
        L_0x006f:
            androidx.compose.ui.Modifier$Node r5 = r6.updateNodeAndReplaceIfNeeded(r13, r14, r1)
            if (r2 != 0) goto L_0x007a
            if (r1 == r5) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r2 = 0
            goto L_0x007b
        L_0x007a:
            r2 = 1
        L_0x007b:
            androidx.compose.ui.node.NodeChain$Logger r10 = r6.logger
            if (r10 == 0) goto L_0x0087
            r11 = r0
            r12 = r0
            r15 = r1
            r16 = r5
            r10.nodeUpdated(r11, r12, r13, r14, r15, r16)
        L_0x0087:
            r1 = r5
        L_0x0088:
            int r0 = r0 + -1
            int r5 = r1.getKindSet$ui_release()
            r4 = r4 | r5
            r1.setAggregateChildKindSet$ui_release(r4)
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x0042
        L_0x0097:
            androidx.compose.ui.node.NodeChain$Logger r4 = r6.logger
            if (r4 == 0) goto L_0x009e
            r4.linearDiffAborted(r0, r13, r14, r1)
        L_0x009e:
            int r0 = r0 + 1
            androidx.compose.ui.Modifier$Node r1 = r1.getChild$ui_release()
        L_0x00a4:
            r4 = r0
            r5 = r1
            if (r4 <= 0) goto L_0x00c2
            if (r5 == 0) goto L_0x00ab
            r3 = 1
        L_0x00ab:
            if (r3 == 0) goto L_0x00b6
            r0 = r17
            r1 = r7
            r2 = r4
            r3 = r8
            r0.structuralUpdate(r1, r2, r3, r4, r5)
            goto L_0x0107
        L_0x00b6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Check failed."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00c2:
            r9 = r2
            goto L_0x0108
        L_0x00c4:
            int r0 = r7.getSize()
            if (r0 != 0) goto L_0x00f6
            int r0 = r8.getSize()
            int r0 = r0 - r9
            androidx.compose.ui.Modifier$Node r1 = r6.tail
        L_0x00d1:
            r14 = r1
            if (r0 < 0) goto L_0x0107
            java.lang.Object[] r1 = r8.getContent()
            r1 = r1[r0]
            r13 = r1
            androidx.compose.ui.Modifier$Element r13 = (androidx.compose.ui.Modifier.Element) r13
            androidx.compose.ui.Modifier$Node r1 = r6.createAndInsertNodeAsParent(r13, r14)
            androidx.compose.ui.node.NodeChain$Logger r10 = r6.logger
            if (r10 == 0) goto L_0x00eb
            r11 = 0
            r12 = r0
            r15 = r1
            r10.nodeInserted(r11, r12, r13, r14, r15)
        L_0x00eb:
            int r2 = r1.getKindSet$ui_release()
            r3 = r3 | r2
            r1.setAggregateChildKindSet$ui_release(r3)
            int r0 = r0 + -1
            goto L_0x00d1
        L_0x00f6:
            int r2 = r7.getSize()
            int r4 = r8.getSize()
            androidx.compose.ui.Modifier$Node r5 = r6.tail
            r0 = r17
            r1 = r7
            r3 = r8
            r0.structuralUpdate(r1, r2, r3, r4, r5)
        L_0x0107:
            r3 = 1
        L_0x0108:
            r6.current = r8
            r7.clear()
            r6.buffer = r7
            r17.trimChain()
            if (r3 == 0) goto L_0x0117
            r17.syncCoordinators()
        L_0x0117:
            if (r9 == 0) goto L_0x0124
            androidx.compose.ui.node.LayoutNode r0 = r6.layoutNode
            boolean r0 = r0.isAttached()
            if (r0 == 0) goto L_0x0124
            r17.attach()
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeChain.updateFrom$ui_release(androidx.compose.ui.Modifier):void");
    }

    private final void syncCoordinators() {
        LayoutModifierNodeCoordinator layoutModifierNodeCoordinator;
        NodeCoordinator nodeCoordinator = this.innerCoordinator;
        for (Modifier.Node parent$ui_release = this.tail.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (!((Nodes.INSTANCE.m3936getLayoutOLwlOKw() & parent$ui_release.getKindSet$ui_release()) != 0) || !(parent$ui_release instanceof LayoutModifierNode)) {
                parent$ui_release.updateCoordinator$ui_release(nodeCoordinator);
            } else {
                if (parent$ui_release.isAttached()) {
                    NodeCoordinator coordinator$ui_release = parent$ui_release.getCoordinator$ui_release();
                    Intrinsics.checkNotNull(coordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) coordinator$ui_release;
                    LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.getLayoutModifierNode();
                    layoutModifierNodeCoordinator.setLayoutModifierNode$ui_release((LayoutModifierNode) parent$ui_release);
                    if (layoutModifierNode != parent$ui_release) {
                        layoutModifierNodeCoordinator.onLayoutModifierNodeChanged();
                    }
                } else {
                    layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(this.layoutNode, (LayoutModifierNode) parent$ui_release);
                    parent$ui_release.updateCoordinator$ui_release(layoutModifierNodeCoordinator);
                }
                NodeCoordinator nodeCoordinator2 = layoutModifierNodeCoordinator;
                nodeCoordinator.setWrappedBy$ui_release(nodeCoordinator2);
                layoutModifierNodeCoordinator.setWrapped$ui_release(nodeCoordinator);
                nodeCoordinator = nodeCoordinator2;
            }
        }
        LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
        nodeCoordinator.setWrappedBy$ui_release(parent$ui_release2 != null ? parent$ui_release2.getInnerCoordinator$ui_release() : null);
        this.outerCoordinator = nodeCoordinator;
    }

    public final List<ModifierInfo> getModifierInfo() {
        MutableVector<Modifier.Element> mutableVector = this.current;
        if (mutableVector == null) {
            return CollectionsKt.emptyList();
        }
        int i = 0;
        MutableVector mutableVector2 = new MutableVector(new ModifierInfo[mutableVector.getSize()], 0);
        Modifier.Node head$ui_release = getHead$ui_release();
        while (head$ui_release != null && head$ui_release != getTail$ui_release()) {
            NodeCoordinator coordinator$ui_release = head$ui_release.getCoordinator$ui_release();
            if (coordinator$ui_release != null) {
                mutableVector2.add(new ModifierInfo((Modifier) mutableVector.getContent()[i], coordinator$ui_release, coordinator$ui_release.getLayer()));
                head$ui_release = head$ui_release.getChild$ui_release();
                i++;
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        return mutableVector2.asMutableList();
    }

    private final Differ getDiffer(Modifier.Node node, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2) {
        Differ differ = this.cachedDiffer;
        if (differ == null) {
            Differ differ2 = new Differ(this, node, node.getAggregateChildKindSet$ui_release(), mutableVector, mutableVector2);
            this.cachedDiffer = differ2;
            return differ2;
        }
        differ.setNode(node);
        differ.setAggregateChildKindSet(node.getAggregateChildKindSet$ui_release());
        differ.setBefore(mutableVector);
        differ.setAfter(mutableVector2);
        return differ;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/DiffCallback;", "node", "Landroidx/compose/ui/Modifier$Node;", "aggregateChildKindSet", "", "before", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "after", "(Landroidx/compose/ui/node/NodeChain;Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;)V", "getAfter", "()Landroidx/compose/runtime/collection/MutableVector;", "setAfter", "(Landroidx/compose/runtime/collection/MutableVector;)V", "getAggregateChildKindSet", "()I", "setAggregateChildKindSet", "(I)V", "getBefore", "setBefore", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "setNode", "(Landroidx/compose/ui/Modifier$Node;)V", "areItemsTheSame", "", "oldIndex", "newIndex", "insert", "", "atIndex", "remove", "same", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NodeChain.kt */
    private final class Differ implements DiffCallback {
        private MutableVector<Modifier.Element> after;
        private int aggregateChildKindSet;
        private MutableVector<Modifier.Element> before;
        private Modifier.Node node;
        final /* synthetic */ NodeChain this$0;

        public Differ(NodeChain nodeChain, Modifier.Node node2, int i, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2) {
            Intrinsics.checkNotNullParameter(node2, "node");
            Intrinsics.checkNotNullParameter(mutableVector, "before");
            Intrinsics.checkNotNullParameter(mutableVector2, "after");
            this.this$0 = nodeChain;
            this.node = node2;
            this.aggregateChildKindSet = i;
            this.before = mutableVector;
            this.after = mutableVector2;
        }

        public final Modifier.Node getNode() {
            return this.node;
        }

        public final void setNode(Modifier.Node node2) {
            Intrinsics.checkNotNullParameter(node2, "<set-?>");
            this.node = node2;
        }

        public final int getAggregateChildKindSet() {
            return this.aggregateChildKindSet;
        }

        public final void setAggregateChildKindSet(int i) {
            this.aggregateChildKindSet = i;
        }

        public final MutableVector<Modifier.Element> getBefore() {
            return this.before;
        }

        public final void setBefore(MutableVector<Modifier.Element> mutableVector) {
            Intrinsics.checkNotNullParameter(mutableVector, "<set-?>");
            this.before = mutableVector;
        }

        public final MutableVector<Modifier.Element> getAfter() {
            return this.after;
        }

        public final void setAfter(MutableVector<Modifier.Element> mutableVector) {
            Intrinsics.checkNotNullParameter(mutableVector, "<set-?>");
            this.after = mutableVector;
        }

        public boolean areItemsTheSame(int i, int i2) {
            return NodeChainKt.reuseActionForModifiers((Modifier.Element) this.before.getContent()[i], (Modifier.Element) this.after.getContent()[i2]) != 0;
        }

        public void insert(int i, int i2) {
            Modifier.Node node2 = this.node;
            this.node = this.this$0.createAndInsertNodeAsParent((Modifier.Element) this.after.getContent()[i2], node2);
            Logger access$getLogger$p = this.this$0.logger;
            if (access$getLogger$p != null) {
                access$getLogger$p.nodeInserted(i, i2, (Modifier.Element) this.after.getContent()[i2], node2, this.node);
            }
            int kindSet$ui_release = this.aggregateChildKindSet | this.node.getKindSet$ui_release();
            this.aggregateChildKindSet = kindSet$ui_release;
            this.node.setAggregateChildKindSet$ui_release(kindSet$ui_release);
        }

        public void remove(int i) {
            Modifier.Node parent$ui_release = this.node.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release);
            this.node = parent$ui_release;
            Logger access$getLogger$p = this.this$0.logger;
            if (access$getLogger$p != null) {
                access$getLogger$p.nodeRemoved(i, (Modifier.Element) this.before.getContent()[i], this.node);
            }
            this.node = this.this$0.disposeAndRemoveNode(this.node);
        }

        public void same(int i, int i2) {
            Modifier.Node parent$ui_release = this.node.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release);
            this.node = parent$ui_release;
            Modifier.Element element = (Modifier.Element) this.before.getContent()[i];
            Modifier.Element element2 = (Modifier.Element) this.after.getContent()[i2];
            if (!Intrinsics.areEqual((Object) element, (Object) element2)) {
                Modifier.Node node2 = this.node;
                this.node = this.this$0.updateNodeAndReplaceIfNeeded(element, element2, node2);
                Logger access$getLogger$p = this.this$0.logger;
                if (access$getLogger$p != null) {
                    access$getLogger$p.nodeUpdated(i, i2, element, element2, node2, this.node);
                }
            } else {
                Logger access$getLogger$p2 = this.this$0.logger;
                if (access$getLogger$p2 != null) {
                    access$getLogger$p2.nodeReused(i, i2, element, element2, this.node);
                }
            }
            int kindSet$ui_release = this.aggregateChildKindSet | this.node.getKindSet$ui_release();
            this.aggregateChildKindSet = kindSet$ui_release;
            this.node.setAggregateChildKindSet$ui_release(kindSet$ui_release);
        }
    }

    private final void structuralUpdate(MutableVector<Modifier.Element> mutableVector, int i, MutableVector<Modifier.Element> mutableVector2, int i2, Modifier.Node node) {
        MyersDiffKt.executeDiff(i, i2, getDiffer(node, mutableVector, mutableVector2));
    }

    private final Modifier.Node replaceNode(Modifier.Node node, Modifier.Node node2) {
        Modifier.Node parent$ui_release = node.getParent$ui_release();
        if (parent$ui_release != null) {
            node2.setParent$ui_release(parent$ui_release);
            parent$ui_release.setChild$ui_release(node2);
            node.setParent$ui_release((Modifier.Node) null);
        }
        Modifier.Node child$ui_release = node.getChild$ui_release();
        if (child$ui_release != null) {
            node2.setChild$ui_release(child$ui_release);
            child$ui_release.setParent$ui_release(node2);
            node.setChild$ui_release((Modifier.Node) null);
        }
        node2.updateCoordinator$ui_release(node.getCoordinator$ui_release());
        return node2;
    }

    /* access modifiers changed from: private */
    public final Modifier.Node disposeAndRemoveNode(Modifier.Node node) {
        if (node.isAttached()) {
            node.detach$ui_release();
        }
        return removeNode(node);
    }

    private final Modifier.Node removeNode(Modifier.Node node) {
        Modifier.Node child$ui_release = node.getChild$ui_release();
        Modifier.Node parent$ui_release = node.getParent$ui_release();
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(parent$ui_release);
            node.setChild$ui_release((Modifier.Node) null);
        }
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(child$ui_release);
            node.setParent$ui_release((Modifier.Node) null);
        }
        Intrinsics.checkNotNull(child$ui_release);
        return child$ui_release;
    }

    /* access modifiers changed from: private */
    public final Modifier.Node createAndInsertNodeAsParent(Modifier.Element element, Modifier.Node node) {
        Modifier.Node node2;
        if (element instanceof ModifierNodeElement) {
            node2 = ((ModifierNodeElement) element).create();
            node2.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(node2));
        } else {
            node2 = new BackwardsCompatNode(element);
        }
        return insertParent(node2, node);
    }

    private final Modifier.Node insertParent(Modifier.Node node, Modifier.Node node2) {
        Modifier.Node parent$ui_release = node2.getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(node);
            node.setParent$ui_release(parent$ui_release);
        }
        node2.setParent$ui_release(node);
        node.setChild$ui_release(node2);
        return node;
    }

    /* access modifiers changed from: private */
    public final Modifier.Node updateNodeAndReplaceIfNeeded(Modifier.Element element, Modifier.Element element2, Modifier.Node node) {
        if ((element instanceof ModifierNodeElement) && (element2 instanceof ModifierNodeElement)) {
            Modifier.Node access$updateUnsafe = NodeChainKt.updateUnsafe((ModifierNodeElement) element2, node);
            if (access$updateUnsafe == node) {
                return access$updateUnsafe;
            }
            node.detach$ui_release();
            return replaceNode(node, access$updateUnsafe);
        } else if (node instanceof BackwardsCompatNode) {
            ((BackwardsCompatNode) node).setElement(element2);
            return node;
        } else {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final void headToTail$ui_release(int i, Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) != 0) {
            Modifier.Node head$ui_release = getHead$ui_release();
            while (head$ui_release != null) {
                if ((head$ui_release.getKindSet$ui_release() & i) != 0) {
                    function1.invoke(head$ui_release);
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & i) != 0) {
                    head$ui_release = head$ui_release.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public final void headToTail$ui_release(Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        for (Modifier.Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            function1.invoke(head$ui_release);
        }
    }

    public final void headToTailExclusive$ui_release(Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Modifier.Node head$ui_release = getHead$ui_release();
        while (head$ui_release != null && head$ui_release != getTail$ui_release()) {
            function1.invoke(head$ui_release);
            head$ui_release = head$ui_release.getChild$ui_release();
        }
    }

    public final void tailToHead$ui_release(int i, Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                if ((tail$ui_release.getKindSet$ui_release() & i) != 0) {
                    function1.invoke(tail$ui_release);
                }
            }
        }
    }

    public final void tailToHead$ui_release(Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            function1.invoke(tail$ui_release);
        }
    }

    /* renamed from: has-H91voCI$ui_release  reason: not valid java name */
    public final boolean m3873hasH91voCI$ui_release(int i) {
        return (i & getAggregateChildKindSet()) != 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (this.head != this.tail) {
            Modifier.Node head$ui_release = getHead$ui_release();
            while (true) {
                if (head$ui_release == null || head$ui_release == getTail$ui_release()) {
                    break;
                }
                sb.append(String.valueOf(head$ui_release));
                if (head$ui_release.getChild$ui_release() == this.tail) {
                    sb.append("]");
                    break;
                }
                sb.append(",");
                head$ui_release = head$ui_release.getChild$ui_release();
            }
        } else {
            sb.append("]");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final void attach() {
        for (Modifier.Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            if (!head$ui_release.isAttached()) {
                head$ui_release.attach$ui_release();
            }
        }
    }

    public final void detach$ui_release() {
        for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if (tail$ui_release.isAttached()) {
                tail$ui_release.detach$ui_release();
            }
        }
    }

    /* renamed from: firstFromHead-aLcG6gQ$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> T m3872firstFromHeadaLcG6gQ$ui_release(int i, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) == 0) {
            return null;
        }
        for (T head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            T t = (Modifier.Node) head$ui_release;
            if ((t.getKindSet$ui_release() & i) != 0) {
                T t2 = (Modifier.Node) t;
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if ((t2 instanceof Object) && function1.invoke(t2).booleanValue()) {
                    return t2;
                }
            }
            if ((t.getAggregateChildKindSet$ui_release() & i) == 0) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: headToTail-aLcG6gQ$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> void m3875headToTailaLcG6gQ$ui_release(int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) != 0) {
            Modifier.Node head$ui_release = getHead$ui_release();
            while (head$ui_release != null) {
                Modifier.Node node = head$ui_release;
                if ((node.getKindSet$ui_release() & i) != 0) {
                    Modifier.Node node2 = node;
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    if (node2 instanceof Object) {
                        function1.invoke(node2);
                    }
                }
                if ((node.getAggregateChildKindSet$ui_release() & i) != 0) {
                    head$ui_release = head$ui_release.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: tailToHead-aLcG6gQ$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> void m3877tailToHeadaLcG6gQ$ui_release(int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                Modifier.Node node = tail$ui_release;
                if ((node.getKindSet$ui_release() & i) != 0) {
                    Modifier.Node node2 = node;
                    Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                    if (node2 instanceof Object) {
                        function1.invoke(node2);
                    }
                }
            }
        }
    }

    /* renamed from: tail-H91voCI$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> T m3876tailH91voCI$ui_release(int i) {
        if ((getAggregateChildKindSet() & i) == 0) {
            return null;
        }
        for (T tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            T t = (Modifier.Node) tail$ui_release;
            if ((t.getKindSet$ui_release() & i) != 0) {
                T t2 = (Modifier.Node) t;
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (t2 instanceof Object) {
                    return t2;
                }
            }
        }
        return null;
    }

    /* renamed from: head-H91voCI$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> T m3874headH91voCI$ui_release(int i) {
        if ((getAggregateChildKindSet() & i) == 0) {
            return null;
        }
        for (T head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            T t = (Modifier.Node) head$ui_release;
            if ((t.getKindSet$ui_release() & i) != 0) {
                T t2 = (Modifier.Node) t;
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (t2 instanceof Object) {
                    return t2;
                }
            }
            if ((t.getAggregateChildKindSet$ui_release() & i) == 0) {
                return null;
            }
        }
        return null;
    }
}
