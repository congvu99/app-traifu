package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J7\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010#\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\bJ7\u0010&\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u001a\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0002J\u0006\u0010*\u001a\u00020\u001fJ\b\u0010+\u001a\u00020,H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u0014X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "pointerInputNode", "Landroidx/compose/ui/node/PointerInputModifierNode;", "(Landroidx/compose/ui/node/PointerInputModifierNode;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/PointerId;", "getPointerIds", "()Landroidx/compose/runtime/collection/MutableVector;", "getPointerInputNode", "()Landroidx/compose/ui/node/PointerInputModifierNode;", "relevantChanges", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HitPathTracker.kt */
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;
    private boolean hasExited = true;
    private boolean isIn = true;
    private PointerEvent pointerEvent;
    private final MutableVector<PointerId> pointerIds = new MutableVector<>(new PointerId[16], 0);
    private final PointerInputModifierNode pointerInputNode;
    private final Map<PointerId, PointerInputChange> relevantChanges = new LinkedHashMap();
    private boolean wasIn;

    public Node(PointerInputModifierNode pointerInputModifierNode) {
        Intrinsics.checkNotNullParameter(pointerInputModifierNode, "pointerInputNode");
        this.pointerInputNode = pointerInputModifierNode;
    }

    public final PointerInputModifierNode getPointerInputNode() {
        return this.pointerInputNode;
    }

    public final MutableVector<PointerId> getPointerIds() {
        return this.pointerIds;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean buildCache(java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r31, androidx.compose.ui.layout.LayoutCoordinates r32, androidx.compose.ui.input.pointer.InternalPointerEvent r33, boolean r34) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            java.lang.String r4 = "changes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "parentCoordinates"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "internalPointerEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            boolean r4 = super.buildCache(r31, r32, r33, r34)
            androidx.compose.ui.node.PointerInputModifierNode r5 = r0.pointerInputNode
            boolean r5 = androidx.compose.ui.node.PointerInputModifierNodeKt.isAttached(r5)
            r6 = 1
            if (r5 != 0) goto L_0x0026
            return r6
        L_0x0026:
            androidx.compose.ui.node.PointerInputModifierNode r5 = r0.pointerInputNode
            androidx.compose.ui.layout.LayoutCoordinates r5 = androidx.compose.ui.node.PointerInputModifierNodeKt.getLayoutCoordinates(r5)
            r0.coordinates = r5
            java.util.Set r5 = r31.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0036:
            boolean r7 = r5.hasNext()
            r8 = 0
            if (r7 == 0) goto L_0x00dd
            java.lang.Object r7 = r5.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r9 = r7.getKey()
            androidx.compose.ui.input.pointer.PointerId r9 = (androidx.compose.ui.input.pointer.PointerId) r9
            long r9 = r9.m3417unboximpl()
            java.lang.Object r7 = r7.getValue()
            r11 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.input.pointer.PointerId> r7 = r0.pointerIds
            androidx.compose.ui.input.pointer.PointerId r12 = androidx.compose.ui.input.pointer.PointerId.m3411boximpl(r9)
            boolean r7 = r7.contains(r12)
            if (r7 == 0) goto L_0x0036
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            java.util.List r12 = r11.getHistorical()
            int r13 = r12.size()
        L_0x006f:
            if (r8 >= r13) goto L_0x009f
            java.lang.Object r14 = r12.get(r8)
            androidx.compose.ui.input.pointer.HistoricalChange r14 = (androidx.compose.ui.input.pointer.HistoricalChange) r14
            androidx.compose.ui.input.pointer.HistoricalChange r15 = new androidx.compose.ui.input.pointer.HistoricalChange
            long r16 = r14.getUptimeMillis()
            androidx.compose.ui.layout.LayoutCoordinates r6 = r0.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r21 = r12
            r22 = r13
            long r12 = r14.m3359getPositionF1C5BW0()
            long r18 = r6.m3612localPositionOfR5De75A(r2, r12)
            r20 = 0
            r6 = r15
            r15.<init>(r16, r18, r20)
            r7.add(r6)
            int r8 = r8 + 1
            r12 = r21
            r13 = r22
            r6 = 1
            goto L_0x006f
        L_0x009f:
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r6 = r0.relevantChanges
            androidx.compose.ui.input.pointer.PointerId r8 = androidx.compose.ui.input.pointer.PointerId.m3411boximpl(r9)
            androidx.compose.ui.layout.LayoutCoordinates r9 = r0.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            long r12 = r11.m3430getPreviousPositionF1C5BW0()
            long r21 = r9.m3612localPositionOfR5De75A(r2, r12)
            androidx.compose.ui.layout.LayoutCoordinates r9 = r0.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            long r12 = r11.m3429getPositionF1C5BW0()
            long r16 = r9.m3612localPositionOfR5De75A(r2, r12)
            r12 = 0
            r14 = 0
            r18 = 0
            r19 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r28 = 731(0x2db, float:1.024E-42)
            r29 = 0
            r25 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r7 = androidx.compose.ui.input.pointer.PointerInputChange.m3421copyOHpmEuE$default(r11, r12, r14, r16, r18, r19, r21, r23, r24, r25, r26, r28, r29)
            r6.put(r8, r7)
            r6 = 1
            goto L_0x0036
        L_0x00dd:
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r2 = r0.relevantChanges
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x00f3
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.input.pointer.PointerId> r1 = r0.pointerIds
            r1.clear()
            androidx.compose.runtime.collection.MutableVector r1 = r30.getChildren()
            r1.clear()
            r2 = 1
            return r2
        L_0x00f3:
            r2 = 1
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.input.pointer.PointerId> r5 = r0.pointerIds
            int r5 = r5.getSize()
            int r5 = r5 - r2
        L_0x00fb:
            r2 = -1
            if (r2 >= r5) goto L_0x011e
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.input.pointer.PointerId> r2 = r0.pointerIds
            java.lang.Object[] r2 = r2.getContent()
            r2 = r2[r5]
            androidx.compose.ui.input.pointer.PointerId r2 = (androidx.compose.ui.input.pointer.PointerId) r2
            long r6 = r2.m3417unboximpl()
            androidx.compose.ui.input.pointer.PointerId r2 = androidx.compose.ui.input.pointer.PointerId.m3411boximpl(r6)
            boolean r2 = r1.containsKey(r2)
            if (r2 != 0) goto L_0x011b
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.input.pointer.PointerId> r2 = r0.pointerIds
            r2.removeAt(r5)
        L_0x011b:
            int r5 = r5 + -1
            goto L_0x00fb
        L_0x011e:
            androidx.compose.ui.input.pointer.PointerEvent r1 = new androidx.compose.ui.input.pointer.PointerEvent
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r2 = r0.relevantChanges
            java.util.Collection r2 = r2.values()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)
            r1.<init>(r2, r3)
            java.util.List r2 = r1.getChanges()
            int r5 = r2.size()
            r6 = 0
        L_0x0138:
            if (r6 >= r5) goto L_0x014f
            java.lang.Object r7 = r2.get(r6)
            r9 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            long r9 = r9.m3428getIdJ3iCeTQ()
            boolean r9 = r3.m3361issuesEnterExitEvent0FcD4WY(r9)
            if (r9 == 0) goto L_0x014c
            goto L_0x0150
        L_0x014c:
            int r6 = r6 + 1
            goto L_0x0138
        L_0x014f:
            r7 = 0
        L_0x0150:
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 == 0) goto L_0x020d
            if (r34 != 0) goto L_0x0159
            r0.isIn = r8
            goto L_0x017b
        L_0x0159:
            boolean r2 = r0.isIn
            if (r2 != 0) goto L_0x017b
            boolean r2 = r7.getPressed()
            if (r2 != 0) goto L_0x0169
            boolean r2 = r7.getPreviousPressed()
            if (r2 == 0) goto L_0x017b
        L_0x0169:
            androidx.compose.ui.layout.LayoutCoordinates r2 = r0.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            long r2 = r2.m3611getSizeYbymL2g()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.m3376isOutOfBoundsO0kMr_c(r7, r2)
            r3 = 1
            r2 = r2 ^ r3
            r0.isIn = r2
            goto L_0x017c
        L_0x017b:
            r3 = 1
        L_0x017c:
            boolean r2 = r0.isIn
            boolean r5 = r0.wasIn
            if (r2 == r5) goto L_0x01c7
            int r2 = r1.m3374getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m3387getMove7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m3381equalsimpl0(r2, r5)
            if (r2 != 0) goto L_0x01b2
            int r2 = r1.m3374getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m3385getEnter7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m3381equalsimpl0(r2, r5)
            if (r2 != 0) goto L_0x01b2
            int r2 = r1.m3374getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m3386getExit7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m3381equalsimpl0(r2, r5)
            if (r2 == 0) goto L_0x01c7
        L_0x01b2:
            boolean r2 = r0.isIn
            if (r2 == 0) goto L_0x01bd
            androidx.compose.ui.input.pointer.PointerEventType$Companion r2 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r2 = r2.m3385getEnter7fucELk()
            goto L_0x01c3
        L_0x01bd:
            androidx.compose.ui.input.pointer.PointerEventType$Companion r2 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r2 = r2.m3386getExit7fucELk()
        L_0x01c3:
            r1.m3375setTypeEhbLWgg$ui_release(r2)
            goto L_0x020e
        L_0x01c7:
            int r2 = r1.m3374getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m3385getEnter7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m3381equalsimpl0(r2, r5)
            if (r2 == 0) goto L_0x01e9
            boolean r2 = r0.wasIn
            if (r2 == 0) goto L_0x01e9
            boolean r2 = r0.hasExited
            if (r2 != 0) goto L_0x01e9
            androidx.compose.ui.input.pointer.PointerEventType$Companion r2 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r2 = r2.m3387getMove7fucELk()
            r1.m3375setTypeEhbLWgg$ui_release(r2)
            goto L_0x020e
        L_0x01e9:
            int r2 = r1.m3374getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r5 = r5.m3386getExit7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m3381equalsimpl0(r2, r5)
            if (r2 == 0) goto L_0x020e
            boolean r2 = r0.isIn
            if (r2 == 0) goto L_0x020e
            boolean r2 = r7.getPressed()
            if (r2 == 0) goto L_0x020e
            androidx.compose.ui.input.pointer.PointerEventType$Companion r2 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r2 = r2.m3387getMove7fucELk()
            r1.m3375setTypeEhbLWgg$ui_release(r2)
            goto L_0x020e
        L_0x020d:
            r3 = 1
        L_0x020e:
            if (r4 != 0) goto L_0x022b
            int r2 = r1.m3374getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r4 = r4.m3387getMove7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m3381equalsimpl0(r2, r4)
            if (r2 == 0) goto L_0x022b
            androidx.compose.ui.input.pointer.PointerEvent r2 = r0.pointerEvent
            boolean r2 = r0.hasPositionChanged(r2, r1)
            if (r2 == 0) goto L_0x0229
            goto L_0x022b
        L_0x0229:
            r6 = 0
            goto L_0x022c
        L_0x022b:
            r6 = 1
        L_0x022c:
            r0.pointerEvent = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.buildCache(java.util.Map, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    private final boolean hasPositionChanged(PointerEvent pointerEvent2, PointerEvent pointerEvent3) {
        if (pointerEvent2 == null || pointerEvent2.getChanges().size() != pointerEvent3.getChanges().size()) {
            return true;
        }
        int size = pointerEvent3.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m1680equalsimpl0(pointerEvent2.getChanges().get(i).m3429getPositionF1C5BW0(), pointerEvent3.getChanges().get(i).m3429getPositionF1C5BW0())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> function0) {
        if (this.relevantChanges.isEmpty() || !PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
            return false;
        }
        function0.invoke();
        return true;
    }

    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = children.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                ((Node) content[i]).dispatchCancel();
                i++;
            } while (i < size);
        }
        this.pointerInputNode.onCancelPointerInput();
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent2 = this.pointerEvent;
        if (pointerEvent2 != null) {
            this.wasIn = this.isIn;
            List<PointerInputChange> changes = pointerEvent2.getChanges();
            int size = changes.size();
            for (int i = 0; i < size; i++) {
                PointerInputChange pointerInputChange = changes.get(i);
                if (!pointerInputChange.getPressed() && (!internalPointerEvent.m3361issuesEnterExitEvent0FcD4WY(pointerInputChange.m3428getIdJ3iCeTQ()) || !this.isIn)) {
                    this.pointerIds.remove(PointerId.m3411boximpl(pointerInputChange.m3428getIdJ3iCeTQ()));
                }
            }
            this.isIn = false;
            this.hasExited = PointerEventType.m3381equalsimpl0(pointerEvent2.m3374getType7fucELk(), PointerEventType.Companion.m3386getExit7fucELk());
        }
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.pointerInputNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0042, code lost:
        r3 = getChildren();
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchMainEventPass(java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r9, androidx.compose.ui.layout.LayoutCoordinates r10, androidx.compose.ui.input.pointer.InternalPointerEvent r11, boolean r12) {
        /*
            r8 = this;
            java.lang.String r0 = "changes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r9 = "parentCoordinates"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r9)
            java.lang.String r9 = "internalPointerEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r9)
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r9 = r8.relevantChanges
            boolean r9 = r9.isEmpty()
            r10 = 1
            r0 = 0
            if (r9 == 0) goto L_0x001c
        L_0x001a:
            r10 = 0
            goto L_0x0075
        L_0x001c:
            androidx.compose.ui.node.PointerInputModifierNode r9 = r8.pointerInputNode
            boolean r9 = androidx.compose.ui.node.PointerInputModifierNodeKt.isAttached(r9)
            if (r9 != 0) goto L_0x0025
            goto L_0x001a
        L_0x0025:
            androidx.compose.ui.input.pointer.PointerEvent r9 = r8.pointerEvent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            androidx.compose.ui.layout.LayoutCoordinates r1 = r8.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            long r1 = r1.m3611getSizeYbymL2g()
            androidx.compose.ui.node.PointerInputModifierNode r3 = r8.pointerInputNode
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            r3.m3953onPointerEventH0pRuoY(r9, r4, r1)
            androidx.compose.ui.node.PointerInputModifierNode r3 = r8.pointerInputNode
            boolean r3 = androidx.compose.ui.node.PointerInputModifierNodeKt.isAttached(r3)
            if (r3 == 0) goto L_0x0066
            androidx.compose.runtime.collection.MutableVector r3 = r8.getChildren()
            int r4 = r3.getSize()
            if (r4 <= 0) goto L_0x0066
            java.lang.Object[] r3 = r3.getContent()
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r5)
        L_0x0055:
            r5 = r3[r0]
            androidx.compose.ui.input.pointer.Node r5 = (androidx.compose.ui.input.pointer.Node) r5
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r6 = r8.relevantChanges
            androidx.compose.ui.layout.LayoutCoordinates r7 = r8.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r5.dispatchMainEventPass(r6, r7, r11, r12)
            int r0 = r0 + r10
            if (r0 < r4) goto L_0x0055
        L_0x0066:
            androidx.compose.ui.node.PointerInputModifierNode r11 = r8.pointerInputNode
            boolean r11 = androidx.compose.ui.node.PointerInputModifierNodeKt.isAttached(r11)
            if (r11 == 0) goto L_0x0075
            androidx.compose.ui.node.PointerInputModifierNode r11 = r8.pointerInputNode
            androidx.compose.ui.input.pointer.PointerEventPass r12 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r11.m3953onPointerEventH0pRuoY(r9, r12, r1)
        L_0x0075:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchMainEventPass(java.util.Map, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0037, code lost:
        r0 = getChildren();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchFinalEventPass(androidx.compose.ui.input.pointer.InternalPointerEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "internalPointerEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r0 = r7.relevantChanges
            boolean r0 = r0.isEmpty()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0011
        L_0x000f:
            r1 = 0
            goto L_0x0054
        L_0x0011:
            androidx.compose.ui.node.PointerInputModifierNode r0 = r7.pointerInputNode
            boolean r0 = androidx.compose.ui.node.PointerInputModifierNodeKt.isAttached(r0)
            if (r0 != 0) goto L_0x001a
            goto L_0x000f
        L_0x001a:
            androidx.compose.ui.input.pointer.PointerEvent r0 = r7.pointerEvent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.compose.ui.layout.LayoutCoordinates r3 = r7.coordinates
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            long r3 = r3.m3611getSizeYbymL2g()
            androidx.compose.ui.node.PointerInputModifierNode r5 = r7.pointerInputNode
            androidx.compose.ui.input.pointer.PointerEventPass r6 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5.m3953onPointerEventH0pRuoY(r0, r6, r3)
            androidx.compose.ui.node.PointerInputModifierNode r0 = r7.pointerInputNode
            boolean r0 = androidx.compose.ui.node.PointerInputModifierNodeKt.isAttached(r0)
            if (r0 == 0) goto L_0x0054
            androidx.compose.runtime.collection.MutableVector r0 = r7.getChildren()
            int r3 = r0.getSize()
            if (r3 <= 0) goto L_0x0054
            java.lang.Object[] r0 = r0.getContent()
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r4)
        L_0x004a:
            r4 = r0[r2]
            androidx.compose.ui.input.pointer.Node r4 = (androidx.compose.ui.input.pointer.Node) r4
            r4.dispatchFinalEventPass(r8)
            int r2 = r2 + r1
            if (r2 < r3) goto L_0x004a
        L_0x0054:
            r7.cleanUpHits(r8)
            r7.clearCache()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.dispatchFinalEventPass(androidx.compose.ui.input.pointer.InternalPointerEvent):boolean");
    }
}
