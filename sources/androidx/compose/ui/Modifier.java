package androidx.compose.ui;

import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u00112\u00020\u0001:\u0003\u0011\u0012\u0013J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J5\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\rJ5\u0010\u000e\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u0002H\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/Modifier;", "", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "then", "other", "Companion", "Element", "Node", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Modifier.kt */
public interface Modifier {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean all(Function1<? super Element, Boolean> function1);

    boolean any(Function1<? super Element, Boolean> function1);

    <R> R foldIn(R r, Function2<? super R, ? super Element, ? extends R> function2);

    <R> R foldOut(R r, Function2<? super Element, ? super R, ? extends R> function2);

    Modifier then(Modifier modifier);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Modifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static Modifier then(Modifier modifier, Modifier modifier2) {
            Intrinsics.checkNotNullParameter(modifier2, "other");
            return CC.$default$then(modifier, modifier2);
        }
    }

    /* renamed from: androidx.compose.ui.Modifier$-CC  reason: invalid class name */
    /* compiled from: Modifier.kt */
    public final /* synthetic */ class CC {
        public static Modifier $default$then(Modifier _this, Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return modifier == Modifier.Companion ? _this : new CombinedModifier(_this, modifier);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J5\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u0002H\b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fJ5\u0010\r\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u0002H\b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/Modifier;", "all", "", "predicate", "Lkotlin/Function1;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Modifier.kt */
    public interface Element extends Modifier {
        boolean all(Function1<? super Element, Boolean> function1);

        boolean any(Function1<? super Element, Boolean> function1);

        <R> R foldIn(R r, Function2<? super R, ? super Element, ? extends R> function2);

        <R> R foldOut(R r, Function2<? super Element, ? super R, ? extends R> function2);

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: Modifier.kt */
        public static final class DefaultImpls {
            @Deprecated
            public static Modifier then(Element element, Modifier modifier) {
                Intrinsics.checkNotNullParameter(modifier, "other");
                return CC.$default$then(element, modifier);
            }

            @Deprecated
            public static <R> R foldIn(Element element, R r, Function2<? super R, ? super Element, ? extends R> function2) {
                Intrinsics.checkNotNullParameter(function2, "operation");
                return CC.$default$foldIn(element, r, function2);
            }

            @Deprecated
            public static <R> R foldOut(Element element, R r, Function2<? super Element, ? super R, ? extends R> function2) {
                Intrinsics.checkNotNullParameter(function2, "operation");
                return CC.$default$foldOut(element, r, function2);
            }

            @Deprecated
            public static boolean any(Element element, Function1<? super Element, Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "predicate");
                return CC.$default$any(element, function1);
            }

            @Deprecated
            public static boolean all(Element element, Function1<? super Element, Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "predicate");
                return CC.$default$all(element, function1);
            }
        }

        /* renamed from: androidx.compose.ui.Modifier$Element$-CC  reason: invalid class name */
        /* compiled from: Modifier.kt */
        public final /* synthetic */ class CC {
            public static <R> Object $default$foldIn(Element _this, Object obj, Function2 function2) {
                Intrinsics.checkNotNullParameter(function2, "operation");
                return function2.invoke(obj, _this);
            }

            public static <R> Object $default$foldOut(Element _this, Object obj, Function2 function2) {
                Intrinsics.checkNotNullParameter(function2, "operation");
                return function2.invoke(_this, obj);
            }

            public static boolean $default$any(Element _this, Function1 function1) {
                Intrinsics.checkNotNullParameter(function1, "predicate");
                return ((Boolean) function1.invoke(_this)).booleanValue();
            }

            public static boolean $default$all(Element _this, Function1 function1) {
                Intrinsics.checkNotNullParameter(function1, "predicate");
                return ((Boolean) function1.invoke(_this)).booleanValue();
            }
        }
    }

    @ExperimentalComposeUiApi
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\r\u0010\"\u001a\u00020 H\u0000¢\u0006\u0002\b#J\"\u0010$\u001a\u00020\u00132\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\b\u0010)\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020 H\u0016J\u0015\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0000H\u0000¢\u0006\u0002\b-J\u0014\u0010.\u001a\u00020 2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020 00J\u0017\u00101\u001a\u00020 2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0010¢\u0006\u0002\b2R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0013@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00063"}, d2 = {"Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "()V", "aggregateChildKindSet", "", "getAggregateChildKindSet$ui_release", "()I", "setAggregateChildKindSet$ui_release", "(I)V", "child", "getChild$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "setChild$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", "<set-?>", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "getCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "", "isAttached", "()Z", "kindSet", "getKindSet$ui_release", "setKindSet$ui_release", "node", "getNode$annotations", "getNode", "parent", "getParent$ui_release", "setParent$ui_release", "attach", "", "attach$ui_release", "detach", "detach$ui_release", "isKind", "kind", "Landroidx/compose/ui/node/NodeKind;", "isKind-H91voCI$ui_release", "(I)Z", "onAttach", "onDetach", "setAsDelegateTo", "owner", "setAsDelegateTo$ui_release", "sideEffect", "effect", "Lkotlin/Function0;", "updateCoordinator", "updateCoordinator$ui_release", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Modifier.kt */
    public static abstract class Node implements DelegatableNode {
        public static final int $stable = 8;
        private int aggregateChildKindSet;
        private Node child;
        private NodeCoordinator coordinator;
        private boolean isAttached;
        private int kindSet;
        private Node node = this;
        private Node parent;

        public static /* synthetic */ void getNode$annotations() {
        }

        public void onAttach() {
        }

        public void onDetach() {
        }

        public final Node getNode() {
            return this.node;
        }

        public final int getKindSet$ui_release() {
            return this.kindSet;
        }

        public final void setKindSet$ui_release(int i) {
            this.kindSet = i;
        }

        public final int getAggregateChildKindSet$ui_release() {
            return this.aggregateChildKindSet;
        }

        public final void setAggregateChildKindSet$ui_release(int i) {
            this.aggregateChildKindSet = i;
        }

        public final Node getParent$ui_release() {
            return this.parent;
        }

        public final void setParent$ui_release(Node node2) {
            this.parent = node2;
        }

        public final Node getChild$ui_release() {
            return this.child;
        }

        public final void setChild$ui_release(Node node2) {
            this.child = node2;
        }

        public final NodeCoordinator getCoordinator$ui_release() {
            return this.coordinator;
        }

        public final boolean isAttached() {
            return this.isAttached;
        }

        public void updateCoordinator$ui_release(NodeCoordinator nodeCoordinator) {
            this.coordinator = nodeCoordinator;
        }

        /* renamed from: isKind-H91voCI$ui_release  reason: not valid java name */
        public final boolean m1564isKindH91voCI$ui_release(int i) {
            return (i & getKindSet$ui_release()) != 0;
        }

        public final void attach$ui_release() {
            if (!this.isAttached) {
                if (this.coordinator != null) {
                    this.isAttached = true;
                    onAttach();
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public final void detach$ui_release() {
            if (this.isAttached) {
                if (this.coordinator != null) {
                    onDetach();
                    this.isAttached = false;
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public final void sideEffect(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "effect");
            DelegatableNodeKt.requireOwner(this).registerOnEndApplyChangesListener(function0);
        }

        public final void setAsDelegateTo$ui_release(Node node2) {
            Intrinsics.checkNotNullParameter(node2, "owner");
            this.node = node2;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\u001c\u0010\b\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ5\u0010\u000f\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/Modifier$Companion;", "Landroidx/compose/ui/Modifier;", "()V", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Element;", "any", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "then", "other", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Modifier.kt */
    public static final class Companion implements Modifier {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public boolean all(Function1<? super Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return true;
        }

        public boolean any(Function1<? super Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return false;
        }

        public <R> R foldIn(R r, Function2<? super R, ? super Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return r;
        }

        public <R> R foldOut(R r, Function2<? super Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return r;
        }

        public Modifier then(Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return modifier;
        }

        public String toString() {
            return "Modifier";
        }

        private Companion() {
        }
    }
}