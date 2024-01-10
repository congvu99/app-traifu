package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a \u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001aE\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\u0007H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000e\u001aE\u0010\u000f\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\u0007H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000e\u001a \u0010\u0010\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a=\u0010\u0011\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a5\u0010\u0018\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a \u0010\u001b\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a \u0010\u001c\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a=\u0010\u001d\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"InvalidFocusDirection", "", "NoActiveChild", "backwardFocusSearch", "", "Landroidx/compose/ui/focus/FocusModifier;", "onFound", "Lkotlin/Function1;", "forEachItemAfter", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "item", "action", "(Landroidx/compose/runtime/collection/MutableVector;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachItemBefore", "forwardFocusSearch", "generateAndSearchChildren", "focusedItem", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusModifier;Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "isRoot", "oneDimensionalFocusSearch", "oneDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusModifier;ILkotlin/jvm/functions/Function1;)Z", "pickChildForBackwardSearch", "pickChildForForwardSearch", "searchChildren", "searchChildren-4C6V_qg", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: OneDimensionalFocusSearch.kt */
public final class OneDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OneDimensionalFocusSearch.kt */
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

    /* renamed from: oneDimensionalFocusSearch--OM-vw8  reason: not valid java name */
    public static final boolean m1638oneDimensionalFocusSearchOMvw8(FocusModifier focusModifier, int i, Function1<? super FocusModifier, Boolean> function1) {
        Intrinsics.checkNotNullParameter(focusModifier, "$this$oneDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(function1, "onFound");
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1620getNextdhqQ8s())) {
            return forwardFocusSearch(focusModifier, function1);
        }
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1622getPreviousdhqQ8s())) {
            return backwardFocusSearch(focusModifier, function1);
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final boolean forwardFocusSearch(FocusModifier focusModifier, Function1<? super FocusModifier, Boolean> function1) {
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild != null) {
                    return forwardFocusSearch(focusedChild, function1) || m1637generateAndSearchChildren4C6V_qg(focusModifier, focusedChild, FocusDirection.Companion.m1620getNextdhqQ8s(), function1);
                }
                throw new IllegalStateException(NoActiveChild.toString());
            case 3:
            case 4:
            case 5:
                return pickChildForForwardSearch(focusModifier, function1);
            case 6:
                return function1.invoke(focusModifier).booleanValue();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean backwardFocusSearch(androidx.compose.ui.focus.FocusModifier r6, kotlin.jvm.functions.Function1<? super androidx.compose.ui.focus.FocusModifier, java.lang.Boolean> r7) {
        /*
            androidx.compose.ui.focus.FocusStateImpl r0 = r6.getFocusState()
            int[] r1 = androidx.compose.ui.focus.OneDimensionalFocusSearchKt.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 0
            r2 = 1
            switch(r0) {
                case 1: goto L_0x0030;
                case 2: goto L_0x0030;
                case 3: goto L_0x002b;
                case 4: goto L_0x002b;
                case 5: goto L_0x002b;
                case 6: goto L_0x0017;
                default: goto L_0x0011;
            }
        L_0x0011:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x0017:
            boolean r0 = pickChildForBackwardSearch(r6, r7)
            if (r0 != 0) goto L_0x0029
            java.lang.Object r6 = r7.invoke(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0088
        L_0x0029:
            r1 = 1
            goto L_0x0088
        L_0x002b:
            boolean r1 = pickChildForBackwardSearch(r6, r7)
            goto L_0x0088
        L_0x0030:
            androidx.compose.ui.focus.FocusModifier r0 = r6.getFocusedChild()
            java.lang.String r3 = "ActiveParent must have a focusedChild"
            if (r0 == 0) goto L_0x0089
            androidx.compose.ui.focus.FocusStateImpl r4 = r0.getFocusState()
            int[] r5 = androidx.compose.ui.focus.OneDimensionalFocusSearchKt.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r5[r4]
            switch(r4) {
                case 1: goto L_0x0075;
                case 2: goto L_0x0062;
                case 3: goto L_0x0057;
                case 4: goto L_0x0057;
                case 5: goto L_0x004d;
                case 6: goto L_0x004d;
                default: goto L_0x0047;
            }
        L_0x0047:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x004d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = r3.toString()
            r6.<init>(r7)
            throw r6
        L_0x0057:
            androidx.compose.ui.focus.FocusDirection$Companion r1 = androidx.compose.ui.focus.FocusDirection.Companion
            int r1 = r1.m1622getPreviousdhqQ8s()
            boolean r1 = m1637generateAndSearchChildren4C6V_qg(r6, r0, r1, r7)
            goto L_0x0088
        L_0x0062:
            boolean r3 = backwardFocusSearch(r0, r7)
            if (r3 != 0) goto L_0x0029
            androidx.compose.ui.focus.FocusDirection$Companion r3 = androidx.compose.ui.focus.FocusDirection.Companion
            int r3 = r3.m1622getPreviousdhqQ8s()
            boolean r6 = m1637generateAndSearchChildren4C6V_qg(r6, r0, r3, r7)
            if (r6 == 0) goto L_0x0088
            goto L_0x0029
        L_0x0075:
            boolean r6 = backwardFocusSearch(r0, r7)
            if (r6 != 0) goto L_0x0029
            java.lang.Object r6 = r7.invoke(r0)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0088
            goto L_0x0029
        L_0x0088:
            return r1
        L_0x0089:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = r3.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.OneDimensionalFocusSearchKt.backwardFocusSearch(androidx.compose.ui.focus.FocusModifier, kotlin.jvm.functions.Function1):boolean");
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg  reason: not valid java name */
    private static final boolean m1637generateAndSearchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i, Function1<? super FocusModifier, Boolean> function1) {
        if (m1639searchChildren4C6V_qg(focusModifier, focusModifier2, i, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m1603searchBeyondBoundsOMvw8(focusModifier, i, new OneDimensionalFocusSearchKt$generateAndSearchChildren$1(focusModifier, focusModifier2, i, function1));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg  reason: not valid java name */
    public static final boolean m1639searchChildren4C6V_qg(FocusModifier focusModifier, FocusModifier focusModifier2, int i, Function1<? super FocusModifier, Boolean> function1) {
        if (focusModifier.getFocusState() == FocusStateImpl.ActiveParent || focusModifier.getFocusState() == FocusStateImpl.DeactivatedParent) {
            focusModifier.getChildren().sortWith(FocusableChildrenComparator.INSTANCE);
            if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1620getNextdhqQ8s())) {
                MutableVector<FocusModifier> children = focusModifier.getChildren();
                IntRange intRange = new IntRange(0, children.getSize() - 1);
                int first = intRange.getFirst();
                int last = intRange.getLast();
                if (first <= last) {
                    boolean z = false;
                    while (true) {
                        if (z) {
                            FocusModifier focusModifier3 = (FocusModifier) children.getContent()[first];
                            if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier3) && forwardFocusSearch(focusModifier3, function1)) {
                                return true;
                            }
                        }
                        if (Intrinsics.areEqual(children.getContent()[first], (Object) focusModifier2)) {
                            z = true;
                        }
                        if (first == last) {
                            break;
                        }
                        first++;
                    }
                }
            } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1622getPreviousdhqQ8s())) {
                MutableVector<FocusModifier> children2 = focusModifier.getChildren();
                IntRange intRange2 = new IntRange(0, children2.getSize() - 1);
                int first2 = intRange2.getFirst();
                int last2 = intRange2.getLast();
                if (first2 <= last2) {
                    boolean z2 = false;
                    while (true) {
                        if (z2) {
                            FocusModifier focusModifier4 = (FocusModifier) children2.getContent()[last2];
                            if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier4) && backwardFocusSearch(focusModifier4, function1)) {
                                return true;
                            }
                        }
                        if (Intrinsics.areEqual(children2.getContent()[last2], (Object) focusModifier2)) {
                            z2 = true;
                        }
                        if (last2 == first2) {
                            break;
                        }
                        last2--;
                    }
                }
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1620getNextdhqQ8s()) || focusModifier.getFocusState() == FocusStateImpl.DeactivatedParent || isRoot(focusModifier)) {
                return false;
            }
            return function1.invoke(focusModifier).booleanValue();
        }
        throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
    }

    private static final boolean pickChildForForwardSearch(FocusModifier focusModifier, Function1<? super FocusModifier, Boolean> function1) {
        focusModifier.getChildren().sortWith(FocusableChildrenComparator.INSTANCE);
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        if (size > 0) {
            Object[] content = children.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i = 0;
            do {
                FocusModifier focusModifier2 = (FocusModifier) content[i];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier2) && forwardFocusSearch(focusModifier2, function1)) {
                    return true;
                }
                i++;
            } while (i < size);
        }
        return false;
    }

    private static final boolean pickChildForBackwardSearch(FocusModifier focusModifier, Function1<? super FocusModifier, Boolean> function1) {
        focusModifier.getChildren().sortWith(FocusableChildrenComparator.INSTANCE);
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        if (size <= 0) {
            return false;
        }
        int i = size - 1;
        Object[] content = children.getContent();
        Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            FocusModifier focusModifier2 = (FocusModifier) content[i];
            if (FocusTraversalKt.isEligibleForFocusSearch(focusModifier2) && backwardFocusSearch(focusModifier2, function1)) {
                return true;
            }
            i--;
        } while (i >= 0);
        return false;
    }

    private static final boolean isRoot(FocusModifier focusModifier) {
        return focusModifier.getParent() == null;
    }

    private static final <T> void forEachItemAfter(MutableVector<T> mutableVector, T t, Function1<? super T, Unit> function1) {
        boolean z = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                if (z) {
                    function1.invoke(mutableVector.getContent()[first]);
                }
                if (Intrinsics.areEqual(mutableVector.getContent()[first], (Object) t)) {
                    z = true;
                }
                if (first != last) {
                    first++;
                } else {
                    return;
                }
            }
        }
    }

    private static final <T> void forEachItemBefore(MutableVector<T> mutableVector, T t, Function1<? super T, Unit> function1) {
        boolean z = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                if (z) {
                    function1.invoke(mutableVector.getContent()[last]);
                }
                if (Intrinsics.areEqual(mutableVector.getContent()[last], (Object) t)) {
                    z = true;
                }
                if (last != first) {
                    last--;
                } else {
                    return;
                }
            }
        }
    }
}
