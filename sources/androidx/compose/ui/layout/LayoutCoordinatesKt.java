package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0012\u0010\t\u001a\u00020\u0007*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0012\u0010\n\u001a\u00020\u0007*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRootCoordinates", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LayoutCoordinates.kt */
public final class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return layoutCoordinates.m3613localToRootMKHz9U(Offset.Companion.m1699getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return layoutCoordinates.m3614localToWindowMKHz9U(Offset.Companion.m1699getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return LayoutCoordinates.CC.localBoundingBoxOf$default(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, (Object) null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates findRootCoordinates = findRootCoordinates(layoutCoordinates);
        Rect boundsInRoot = boundsInRoot(layoutCoordinates);
        float r2 = (float) IntSize.m4864getWidthimpl(findRootCoordinates.m3611getSizeYbymL2g());
        float r3 = (float) IntSize.m4863getHeightimpl(findRootCoordinates.m3611getSizeYbymL2g());
        float coerceIn = RangesKt.coerceIn(boundsInRoot.getLeft(), 0.0f, r2);
        float coerceIn2 = RangesKt.coerceIn(boundsInRoot.getTop(), 0.0f, r3);
        float coerceIn3 = RangesKt.coerceIn(boundsInRoot.getRight(), 0.0f, r2);
        float coerceIn4 = RangesKt.coerceIn(boundsInRoot.getBottom(), 0.0f, r3);
        if (!(coerceIn == coerceIn3)) {
            if (!(coerceIn2 == coerceIn4)) {
                long r7 = findRootCoordinates.m3614localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn2));
                long r9 = findRootCoordinates.m3614localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn2));
                long r11 = findRootCoordinates.m3614localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn4));
                long r0 = findRootCoordinates.m3614localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn4));
                return new Rect(ComparisonsKt.minOf(Offset.m1683getXimpl(r7), Offset.m1683getXimpl(r9), Offset.m1683getXimpl(r0), Offset.m1683getXimpl(r11)), ComparisonsKt.minOf(Offset.m1684getYimpl(r7), Offset.m1684getYimpl(r9), Offset.m1684getYimpl(r0), Offset.m1684getYimpl(r11)), ComparisonsKt.maxOf(Offset.m1683getXimpl(r7), Offset.m1683getXimpl(r9), Offset.m1683getXimpl(r0), Offset.m1683getXimpl(r11)), ComparisonsKt.maxOf(Offset.m1684getYimpl(r7), Offset.m1684getYimpl(r9), Offset.m1684getYimpl(r0), Offset.m1684getYimpl(r11)));
            }
        }
        return Rect.Companion.getZero();
    }

    public static final long positionInParent(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.m3612localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m1699getZeroF1C5BW0()) : Offset.Companion.m1699getZeroF1C5BW0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = androidx.compose.ui.layout.LayoutCoordinates.CC.localBoundingBoxOf$default(r0, r4, false, 2, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.geometry.Rect boundsInParent(androidx.compose.ui.layout.LayoutCoordinates r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.compose.ui.layout.LayoutCoordinates r0 = r4.getParentLayoutCoordinates()
            if (r0 == 0) goto L_0x0014
            r1 = 0
            r2 = 2
            r3 = 0
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.ui.layout.LayoutCoordinates.CC.localBoundingBoxOf$default(r0, r4, r1, r2, r3)
            if (r0 != 0) goto L_0x002c
        L_0x0014:
            androidx.compose.ui.geometry.Rect r0 = new androidx.compose.ui.geometry.Rect
            long r1 = r4.m3611getSizeYbymL2g()
            int r1 = androidx.compose.ui.unit.IntSize.m4864getWidthimpl(r1)
            float r1 = (float) r1
            long r2 = r4.m3611getSizeYbymL2g()
            int r4 = androidx.compose.ui.unit.IntSize.m4863getHeightimpl(r2)
            float r4 = (float) r4
            r2 = 0
            r0.<init>(r2, r2, r1, r4)
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(androidx.compose.ui.layout.LayoutCoordinates):androidx.compose.ui.geometry.Rect");
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy$ui_release;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        }
    }
}
