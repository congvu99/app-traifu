package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b*\u00020\u0004H\u0000\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\u0004*\u00020\u0004H\u0000\u001a\u000e\u0010\r\u001a\u0004\u0018\u00010\u0004*\u00020\u0004H\u0000\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\u0004H\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0004H\u0000\u001a=\u0010\u0011\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\u0017H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"invalidFocusDirection", "", "isEligibleForFocusSearch", "", "Landroidx/compose/ui/focus/FocusModifier;", "(Landroidx/compose/ui/focus/FocusModifier;)Z", "lastOf", "Landroidx/compose/ui/input/key/KeyInputModifier;", "one", "two", "activatedChildren", "Landroidx/compose/runtime/collection/MutableVector;", "findActiveFocusNode", "findActiveParent", "findLastKeyInputModifier", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "onFound", "Lkotlin/Function1;", "focusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusModifier;ILandroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)Z", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: FocusTraversal.kt */
public final class FocusTraversalKt {
    private static final String invalidFocusDirection = "Invalid FocusDirection";

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FocusTraversal.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Rtl.ordinal()] = 1;
            iArr[LayoutDirection.Ltr.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            iArr2[FocusStateImpl.Active.ordinal()] = 1;
            iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr2[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr2[FocusStateImpl.Inactive.ordinal()] = 5;
            iArr2[FocusStateImpl.Deactivated.ordinal()] = 6;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* renamed from: focusSearch-sMXa3k8  reason: not valid java name */
    public static final boolean m1635focusSearchsMXa3k8(FocusModifier focusModifier, int i, LayoutDirection layoutDirection, Function1<? super FocusModifier, Boolean> function1) {
        int i2;
        Intrinsics.checkNotNullParameter(focusModifier, "$this$focusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, ViewProps.LAYOUT_DIRECTION);
        Intrinsics.checkNotNullParameter(function1, "onFound");
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1620getNextdhqQ8s()) ? true : FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1622getPreviousdhqQ8s())) {
            return OneDimensionalFocusSearchKt.m1638oneDimensionalFocusSearchOMvw8(focusModifier, i, function1);
        }
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1619getLeftdhqQ8s()) ? true : FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1623getRightdhqQ8s()) ? true : FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1624getUpdhqQ8s()) ? true : FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1615getDowndhqQ8s())) {
            return TwoDimensionalFocusSearchKt.m1648twoDimensionalFocusSearchOMvw8(focusModifier, i, function1);
        }
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1616getEnterdhqQ8s())) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i3 == 1) {
                i2 = FocusDirection.Companion.m1619getLeftdhqQ8s();
            } else if (i3 == 2) {
                i2 = FocusDirection.Companion.m1623getRightdhqQ8s();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            FocusModifier findActiveFocusNode = findActiveFocusNode(focusModifier);
            if (findActiveFocusNode != null) {
                return TwoDimensionalFocusSearchKt.m1648twoDimensionalFocusSearchOMvw8(findActiveFocusNode, i2, function1);
            }
            return false;
        } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1617getExitdhqQ8s())) {
            FocusModifier findActiveFocusNode2 = findActiveFocusNode(focusModifier);
            FocusModifier findActiveParent = findActiveFocusNode2 != null ? findActiveParent(findActiveFocusNode2) : null;
            if (Intrinsics.areEqual((Object) findActiveParent, (Object) focusModifier) || findActiveParent == null) {
                return false;
            }
            return function1.invoke(findActiveParent).booleanValue();
        } else {
            throw new IllegalStateException(invalidFocusDirection.toString());
        }
    }

    public static final FocusModifier findActiveFocusNode(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
                return focusModifier;
            case 3:
            case 4:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild != null) {
                    return findActiveFocusNode(focusedChild);
                }
                break;
            case 5:
            case 6:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return null;
    }

    public static final FocusModifier findActiveParent(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        FocusModifier parent = focusModifier.getParent();
        if (parent == null) {
            return null;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                return findActiveParent(parent);
            case 3:
                return focusModifier;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final Rect focusRect(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        NodeCoordinator coordinator = focusModifier.getCoordinator();
        if (coordinator != null) {
            LayoutCoordinates layoutCoordinates = coordinator;
            Rect localBoundingBoxOf = LayoutCoordinatesKt.findRootCoordinates(layoutCoordinates).localBoundingBoxOf(layoutCoordinates, false);
            if (localBoundingBoxOf != null) {
                return localBoundingBoxOf;
            }
        }
        return Rect.Companion.getZero();
    }

    public static final MutableVector<FocusModifier> activatedChildren(FocusModifier focusModifier) {
        boolean z;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        if (size > 0) {
            Object[] content = children.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i = 0;
            while (true) {
                if (!((FocusModifier) content[i]).getFocusState().isDeactivated()) {
                    i++;
                    if (i >= size) {
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (!z) {
            return focusModifier.getChildren();
        }
        MutableVector<FocusModifier> mutableVector = new MutableVector<>(new FocusModifier[16], 0);
        MutableVector<FocusModifier> children2 = focusModifier.getChildren();
        int size2 = children2.getSize();
        if (size2 > 0) {
            Object[] content2 = children2.getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i2 = 0;
            do {
                FocusModifier focusModifier2 = (FocusModifier) content2[i2];
                if (!focusModifier2.getFocusState().isDeactivated()) {
                    mutableVector.add(focusModifier2);
                } else {
                    FocusRequester invoke = focusModifier2.getFocusProperties().getEnter().invoke(FocusDirection.m1604boximpl(FocusDirection.Companion.m1616getEnterdhqQ8s()));
                    if (Intrinsics.areEqual((Object) invoke, (Object) FocusRequester.Companion.getCancel())) {
                        return new MutableVector<>(new FocusModifier[16], 0);
                    }
                    if (Intrinsics.areEqual((Object) invoke, (Object) FocusRequester.Companion.getDefault())) {
                        mutableVector.addAll(mutableVector.getSize(), activatedChildren(focusModifier2));
                    } else {
                        MutableVector<FocusRequesterModifierLocal> focusRequesterModifierLocals$ui_release = invoke.getFocusRequesterModifierLocals$ui_release();
                        int size3 = focusRequesterModifierLocals$ui_release.getSize();
                        if (size3 > 0) {
                            Object[] content3 = focusRequesterModifierLocals$ui_release.getContent();
                            Intrinsics.checkNotNull(content3, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                            int i3 = 0;
                            do {
                                FocusModifier findFocusNode = ((FocusRequesterModifierLocal) content3[i3]).findFocusNode();
                                if (findFocusNode != null) {
                                    mutableVector.add(findFocusNode);
                                }
                                i3++;
                            } while (i3 < size3);
                        }
                    }
                }
                i2++;
            } while (i2 < size2);
        }
        return mutableVector;
    }

    public static final KeyInputModifier findLastKeyInputModifier(FocusModifier focusModifier) {
        LayoutNode layoutNode;
        Intrinsics.checkNotNullParameter(focusModifier, "<this>");
        NodeCoordinator coordinator = focusModifier.getCoordinator();
        KeyInputModifier keyInputModifier = null;
        if (coordinator == null || (layoutNode = coordinator.getLayoutNode()) == null) {
            return null;
        }
        MutableVector<KeyInputModifier> keyInputChildren = focusModifier.getKeyInputChildren();
        int size = keyInputChildren.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = keyInputChildren.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                KeyInputModifier keyInputModifier2 = (KeyInputModifier) content[i];
                if (Intrinsics.areEqual((Object) keyInputModifier2.getLayoutNode(), (Object) layoutNode)) {
                    keyInputModifier = lastOf(keyInputModifier2, keyInputModifier);
                }
                i++;
            } while (i < size);
        }
        if (keyInputModifier != null) {
            return keyInputModifier;
        }
        return focusModifier.getKeyInputModifier();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = r0.getLayoutNode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isEligibleForFocusSearch(androidx.compose.ui.focus.FocusModifier r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            androidx.compose.ui.node.NodeCoordinator r0 = r3.getCoordinator()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001b
            androidx.compose.ui.node.LayoutNode r0 = r0.getLayoutNode()
            if (r0 == 0) goto L_0x001b
            boolean r0 = r0.isPlaced()
            if (r0 != r1) goto L_0x001b
            r0 = 1
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            if (r0 == 0) goto L_0x0036
            androidx.compose.ui.node.NodeCoordinator r3 = r3.getCoordinator()
            if (r3 == 0) goto L_0x0032
            androidx.compose.ui.node.LayoutNode r3 = r3.getLayoutNode()
            if (r3 == 0) goto L_0x0032
            boolean r3 = r3.isAttached()
            if (r3 != r1) goto L_0x0032
            r3 = 1
            goto L_0x0033
        L_0x0032:
            r3 = 0
        L_0x0033:
            if (r3 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r1 = 0
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.isEligibleForFocusSearch(androidx.compose.ui.focus.FocusModifier):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.ui.input.key.KeyInputModifier lastOf(androidx.compose.ui.input.key.KeyInputModifier r3, androidx.compose.ui.input.key.KeyInputModifier r4) {
        /*
            if (r4 != 0) goto L_0x0003
            return r3
        L_0x0003:
            androidx.compose.ui.node.LayoutNode r0 = r3.getLayoutNode()
            r1 = r4
        L_0x0008:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r2 != 0) goto L_0x001f
            androidx.compose.ui.input.key.KeyInputModifier r1 = r1.getParent()
            if (r1 == 0) goto L_0x001e
            androidx.compose.ui.node.LayoutNode r2 = r1.getLayoutNode()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r0)
            if (r2 != 0) goto L_0x0008
        L_0x001e:
            return r3
        L_0x001f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.lastOf(androidx.compose.ui.input.key.KeyInputModifier, androidx.compose.ui.input.key.KeyInputModifier):androidx.compose.ui.input.key.KeyInputModifier");
    }
}
