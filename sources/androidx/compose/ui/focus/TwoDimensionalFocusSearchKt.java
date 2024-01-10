package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u001a5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\f\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0013H\u0002\u001a\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a1\u0010\u0015\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a5\u0010\u001a\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u001cH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a=\u0010\u001f\u001a\u00020\u0004*\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u001cH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a=\u0010#\u001a\u00020\u0004*\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u001cH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\"\u001a\f\u0010%\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a5\u0010&\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u001cH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010\u001e\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"InvalidFocusDirection", "", "NoActiveChild", "beamBeats", "", "source", "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "beamBeats-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "activeNode", "Landroidx/compose/ui/focus/FocusModifier;", "bottomRight", "findBestCandidate", "Landroidx/compose/runtime/collection/MutableVector;", "focusRect", "findBestCandidate-4WY_MpI", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/focus/FocusModifier;", "findChildCorrespondingToFocusEnter", "onFound", "Lkotlin/Function1;", "findChildCorrespondingToFocusEnter--OM-vw8", "(Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "generateAndSearchChildren", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusModifier;Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "searchChildren", "searchChildren-4C6V_qg", "topLeft", "twoDimensionalFocusSearch", "twoDimensionalFocusSearch--OM-vw8", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TwoDimensionalFocusSearch.kt */
public final class TwoDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TwoDimensionalFocusSearch.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 2;
            iArr[FocusStateImpl.Active.ordinal()] = 3;
            iArr[FocusStateImpl.Captured.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: twoDimensionalFocusSearch--OM-vw8  reason: not valid java name */
    public static final boolean m1648twoDimensionalFocusSearchOMvw8(FocusModifier focusModifier, int i, Function1<? super FocusModifier, Boolean> function1) {
        Intrinsics.checkNotNullParameter(focusModifier, "$this$twoDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(function1, "onFound");
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild != null) {
                    switch (WhenMappings.$EnumSwitchMapping$0[focusedChild.getFocusState().ordinal()]) {
                        case 1:
                        case 2:
                            if (m1648twoDimensionalFocusSearchOMvw8(focusedChild, i, function1)) {
                                return true;
                            }
                            Boolean performRequestFocus$ui_release = focusedChild.getFocusProperties().getExit().invoke(FocusDirection.m1604boximpl(i)).performRequestFocus$ui_release(function1);
                            if (performRequestFocus$ui_release != null) {
                                return performRequestFocus$ui_release.booleanValue();
                            }
                            return m1645generateAndSearchChildren4C6V_qg(focusModifier, activeNode(focusedChild), i, function1);
                        case 3:
                        case 4:
                            return m1645generateAndSearchChildren4C6V_qg(focusModifier, focusedChild, i, function1);
                        case 5:
                        case 6:
                            throw new IllegalStateException(NoActiveChild.toString());
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                } else {
                    throw new IllegalStateException(NoActiveChild.toString());
                }
            case 3:
            case 4:
                return m1644findChildCorrespondingToFocusEnterOMvw8(focusModifier, i, function1);
            case 5:
                return false;
            case 6:
                return function1.invoke(focusModifier).booleanValue();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8  reason: not valid java name */
    public static final boolean m1644findChildCorrespondingToFocusEnterOMvw8(FocusModifier focusModifier, int i, Function1<? super FocusModifier, Boolean> function1) {
        Rect rect;
        Object obj;
        Intrinsics.checkNotNullParameter(focusModifier, "$this$findChildCorrespondingToFocusEnter");
        Intrinsics.checkNotNullParameter(function1, "onFound");
        Boolean performRequestFocus$ui_release = focusModifier.getFocusProperties().getEnter().invoke(FocusDirection.m1604boximpl(i)).performRequestFocus$ui_release(function1);
        if (performRequestFocus$ui_release != null) {
            return performRequestFocus$ui_release.booleanValue();
        }
        MutableVector<FocusModifier> activatedChildren = FocusTraversalKt.activatedChildren(focusModifier);
        boolean z = true;
        if (activatedChildren.getSize() <= 1) {
            if (activatedChildren.isEmpty()) {
                obj = null;
            } else {
                obj = activatedChildren.getContent()[0];
            }
            FocusModifier focusModifier2 = (FocusModifier) obj;
            if (focusModifier2 != null) {
                return function1.invoke(focusModifier2).booleanValue();
            }
            return false;
        }
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1616getEnterdhqQ8s())) {
            i = FocusDirection.Companion.m1619getLeftdhqQ8s();
        }
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1623getRightdhqQ8s()) ? true : FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1615getDowndhqQ8s())) {
            rect = topLeft(FocusTraversalKt.focusRect(focusModifier));
        } else {
            if (!FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1619getLeftdhqQ8s())) {
                z = FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1624getUpdhqQ8s());
            }
            if (z) {
                rect = bottomRight(FocusTraversalKt.focusRect(focusModifier));
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
        }
        FocusModifier r4 = m1643findBestCandidate4WY_MpI(activatedChildren, rect, i);
        if (r4 != null) {
            return function1.invoke(r4).booleanValue();
        }
        return false;
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg  reason: not valid java name */
    private static final boolean m1645generateAndSearchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i, Function1<? super FocusModifier, Boolean> function1) {
        if (m1647searchChildren4C6V_qg(focusModifier, focusModifier2, i, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m1603searchBeyondBoundsOMvw8(focusModifier, i, new TwoDimensionalFocusSearchKt$generateAndSearchChildren$1(focusModifier, focusModifier2, i, function1));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg  reason: not valid java name */
    public static final boolean m1647searchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i, Function1<? super FocusModifier, Boolean> function1) {
        FocusModifier r4;
        MutableVector mutableVector = new MutableVector(new FocusModifier[focusModifier.getChildren().getSize()], 0);
        mutableVector.addAll(mutableVector.getSize(), focusModifier.getChildren());
        while (mutableVector.isNotEmpty() && (r4 = m1643findBestCandidate4WY_MpI(mutableVector, FocusTraversalKt.focusRect(focusModifier2), i)) != null) {
            if (!r4.getFocusState().isDeactivated()) {
                return function1.invoke(r4).booleanValue();
            }
            Boolean performRequestFocus$ui_release = r4.getFocusProperties().getEnter().invoke(FocusDirection.m1604boximpl(i)).performRequestFocus$ui_release(function1);
            if (performRequestFocus$ui_release != null) {
                return performRequestFocus$ui_release.booleanValue();
            }
            if (m1645generateAndSearchChildren4C6V_qg(r4, focusModifier2, i, function1)) {
                return true;
            }
            mutableVector.remove(r4);
        }
        return false;
    }

    /* renamed from: findBestCandidate-4WY_MpI  reason: not valid java name */
    private static final FocusModifier m1643findBestCandidate4WY_MpI(MutableVector<FocusModifier> mutableVector, Rect rect, int i) {
        Rect rect2;
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1619getLeftdhqQ8s())) {
            rect2 = rect.translate(rect.getWidth() + ((float) 1), 0.0f);
        } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1623getRightdhqQ8s())) {
            rect2 = rect.translate(-(rect.getWidth() + ((float) 1)), 0.0f);
        } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1624getUpdhqQ8s())) {
            rect2 = rect.translate(0.0f, rect.getHeight() + ((float) 1));
        } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1615getDowndhqQ8s())) {
            rect2 = rect.translate(0.0f, -(rect.getHeight() + ((float) 1)));
        } else {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        FocusModifier focusModifier = null;
        int size = mutableVector.getSize();
        if (size > 0) {
            int i2 = 0;
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                FocusModifier focusModifier2 = (FocusModifier) content[i2];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier2)) {
                    Rect focusRect = FocusTraversalKt.focusRect(focusModifier2);
                    if (m1646isBetterCandidateI7lrPNg(focusRect, rect2, rect, i)) {
                        focusModifier = focusModifier2;
                        rect2 = focusRect;
                    }
                }
                i2++;
            } while (i2 < size);
        }
        return focusModifier;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect rect, int i, Rect rect2) {
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1619getLeftdhqQ8s())) {
            if ((rect2.getRight() > rect.getRight() || rect2.getLeft() >= rect.getRight()) && rect2.getLeft() > rect.getLeft()) {
                return true;
            }
        } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1623getRightdhqQ8s())) {
            if ((rect2.getLeft() < rect.getLeft() || rect2.getRight() <= rect.getLeft()) && rect2.getRight() < rect.getRight()) {
                return true;
            }
        } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1624getUpdhqQ8s())) {
            if ((rect2.getBottom() > rect.getBottom() || rect2.getTop() >= rect.getBottom()) && rect2.getTop() > rect.getTop()) {
                return true;
            }
        } else if (!FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1615getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else if ((rect2.getTop() < rect.getTop() || rect2.getBottom() <= rect.getTop()) && rect2.getBottom() < rect.getBottom()) {
            return true;
        }
        return false;
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect rect, int i, Rect rect2) {
        float f;
        float top;
        float bottom;
        float top2;
        float bottom2;
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1619getLeftdhqQ8s())) {
            top2 = rect2.getLeft();
            bottom2 = rect.getRight();
        } else {
            if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1623getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1624getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1615getDowndhqQ8s())) {
                top = rect.getTop();
                bottom = rect2.getBottom();
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            f = top - bottom;
            return Math.max(0.0f, f);
        }
        f = top2 - bottom2;
        return Math.max(0.0f, f);
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect rect, int i, Rect rect2) {
        float f;
        float left;
        float left2;
        float width;
        boolean z = true;
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1619getLeftdhqQ8s()) ? true : FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1623getRightdhqQ8s())) {
            f = (float) 2;
            left = rect2.getTop() + (rect2.getHeight() / f);
            left2 = rect.getTop();
            width = rect.getHeight();
        } else {
            if (!FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1624getUpdhqQ8s())) {
                z = FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1615getDowndhqQ8s());
            }
            if (z) {
                f = (float) 2;
                left = rect2.getLeft() + (rect2.getWidth() / f);
                left2 = rect.getLeft();
                width = rect.getWidth();
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
        }
        return left - (left2 + (width / f));
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int i, Rect rect, Rect rect2) {
        long abs = (long) Math.abs(isBetterCandidate_I7lrPNg$majorAxisDistance(rect2, i, rect));
        long abs2 = (long) Math.abs(isBetterCandidate_I7lrPNg$minorAxisDistance(rect2, i, rect));
        return (((long) 13) * abs * abs) + (abs2 * abs2);
    }

    /* renamed from: isBetterCandidate-I7lrPNg  reason: not valid java name */
    private static final boolean m1646isBetterCandidateI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (isBetterCandidate_I7lrPNg$isCandidate(rect, i, rect3)) {
            if (!isBetterCandidate_I7lrPNg$isCandidate(rect2, i, rect3) || m1641beamBeatsI7lrPNg(rect3, rect, rect2, i)) {
                return true;
            }
            if (!m1641beamBeatsI7lrPNg(rect3, rect2, rect, i) && isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect) < isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean beamBeats_I7lrPNg$inSourceBeam(androidx.compose.ui.geometry.Rect r3, int r4, androidx.compose.ui.geometry.Rect r5) {
        /*
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m1619getLeftdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m1607equalsimpl0(r4, r0)
            r1 = 1
            if (r0 == 0) goto L_0x000f
            r0 = 1
            goto L_0x0019
        L_0x000f:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m1623getRightdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m1607equalsimpl0(r4, r0)
        L_0x0019:
            r2 = 0
            if (r0 == 0) goto L_0x0037
            float r4 = r3.getBottom()
            float r0 = r5.getTop()
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0035
            float r3 = r3.getTop()
            float r4 = r5.getBottom()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0035
            goto L_0x0069
        L_0x0035:
            r1 = 0
            goto L_0x0069
        L_0x0037:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m1624getUpdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m1607equalsimpl0(r4, r0)
            if (r0 == 0) goto L_0x0045
            r4 = 1
            goto L_0x004f
        L_0x0045:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m1615getDowndhqQ8s()
            boolean r4 = androidx.compose.ui.focus.FocusDirection.m1607equalsimpl0(r4, r0)
        L_0x004f:
            if (r4 == 0) goto L_0x006a
            float r4 = r3.getRight()
            float r0 = r5.getLeft()
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0035
            float r3 = r3.getLeft()
            float r4 = r5.getRight()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0035
        L_0x0069:
            return r1
        L_0x006a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "This function should only be used for 2-D focus search"
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$inSourceBeam(androidx.compose.ui.geometry.Rect, int, androidx.compose.ui.geometry.Rect):boolean");
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect rect, int i, Rect rect2) {
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1619getLeftdhqQ8s())) {
            if (rect2.getLeft() >= rect.getRight()) {
                return true;
            }
        } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1623getRightdhqQ8s())) {
            if (rect2.getRight() <= rect.getLeft()) {
                return true;
            }
        } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1624getUpdhqQ8s())) {
            if (rect2.getTop() >= rect.getBottom()) {
                return true;
            }
        } else if (!FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1615getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else if (rect2.getBottom() <= rect.getTop()) {
            return true;
        }
        return false;
    }

    /* renamed from: beamBeats_I7lrPNg$majorAxisDistance-6  reason: not valid java name */
    private static final float m1642beamBeats_I7lrPNg$majorAxisDistance6(Rect rect, int i, Rect rect2) {
        float f;
        float top;
        float bottom;
        float top2;
        float bottom2;
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1619getLeftdhqQ8s())) {
            top2 = rect2.getLeft();
            bottom2 = rect.getRight();
        } else {
            if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1623getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1624getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1615getDowndhqQ8s())) {
                top = rect.getTop();
                bottom = rect2.getBottom();
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            f = top - bottom;
            return Math.max(0.0f, f);
        }
        f = top2 - bottom2;
        return Math.max(0.0f, f);
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect rect, int i, Rect rect2) {
        float f;
        float bottom;
        float bottom2;
        float top;
        float top2;
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1619getLeftdhqQ8s())) {
            top = rect2.getLeft();
            top2 = rect.getLeft();
        } else {
            if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1623getRightdhqQ8s())) {
                bottom = rect.getRight();
                bottom2 = rect2.getRight();
            } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1624getUpdhqQ8s())) {
                top = rect2.getTop();
                top2 = rect.getTop();
            } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1615getDowndhqQ8s())) {
                bottom = rect.getBottom();
                bottom2 = rect2.getBottom();
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            f = bottom - bottom2;
            return Math.max(1.0f, f);
        }
        f = top - top2;
        return Math.max(1.0f, f);
    }

    /* renamed from: beamBeats-I7lrPNg  reason: not valid java name */
    private static final boolean m1641beamBeatsI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect3, i, rect) || !beamBeats_I7lrPNg$inSourceBeam(rect2, i, rect)) {
            return false;
        }
        if (beamBeats_I7lrPNg$isInDirectionOfSearch(rect3, i, rect) && !FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1619getLeftdhqQ8s()) && !FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1623getRightdhqQ8s()) && m1642beamBeats_I7lrPNg$majorAxisDistance6(rect2, i, rect) >= beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect3, i, rect)) {
            return false;
        }
        return true;
    }

    private static final Rect topLeft(Rect rect) {
        return new Rect(rect.getLeft(), rect.getTop(), rect.getLeft(), rect.getTop());
    }

    private static final Rect bottomRight(Rect rect) {
        return new Rect(rect.getRight(), rect.getBottom(), rect.getRight(), rect.getBottom());
    }

    private static final FocusModifier activeNode(FocusModifier focusModifier) {
        if (focusModifier.getFocusState() == FocusStateImpl.ActiveParent || focusModifier.getFocusState() == FocusStateImpl.DeactivatedParent) {
            FocusModifier findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusModifier);
            if (findActiveFocusNode != null) {
                return findActiveFocusNode;
            }
            throw new IllegalStateException(NoActiveChild.toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
