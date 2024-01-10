package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\nH\u0016J%\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J%\u0010)\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001d\u00100\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010/J%\u00102\u001a\u0002032\u0006\u0010\"\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001d\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010/R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u00020\u001a8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isAttached", "", "()Z", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "relativeToSource", "localLookaheadPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;J)J", "localPositionOf", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToWindow", "localToWindow-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LookaheadLayoutCoordinates.kt */
public final class LookaheadLayoutCoordinatesImpl implements LookaheadLayoutCoordinates {
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinatesImpl(LookaheadDelegate lookaheadDelegate2) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate2, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    /* renamed from: localLookaheadPositionOf-R5De75A  reason: not valid java name */
    public long m3643localLookaheadPositionOfR5De75A(LookaheadLayoutCoordinates lookaheadLayoutCoordinates, long j) {
        Intrinsics.checkNotNullParameter(lookaheadLayoutCoordinates, "sourceCoordinates");
        LookaheadDelegate lookaheadDelegate2 = ((LookaheadLayoutCoordinatesImpl) lookaheadLayoutCoordinates).lookaheadDelegate;
        LookaheadDelegate lookaheadDelegate$ui_release = getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate2.getCoordinator()).getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release != null) {
            long r1 = lookaheadDelegate2.m3862positionInBjo55l4$ui_release(lookaheadDelegate$ui_release);
            long IntOffset = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m1683getXimpl(j)), MathKt.roundToInt(Offset.m1684getYimpl(j)));
            long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r1) + IntOffset.m4822getXimpl(IntOffset), IntOffset.m4823getYimpl(r1) + IntOffset.m4823getYimpl(IntOffset));
            long r0 = this.lookaheadDelegate.m3862positionInBjo55l4$ui_release(lookaheadDelegate$ui_release);
            long IntOffset3 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(IntOffset2) - IntOffset.m4822getXimpl(r0), IntOffset.m4823getYimpl(IntOffset2) - IntOffset.m4823getYimpl(r0));
            return OffsetKt.Offset((float) IntOffset.m4822getXimpl(IntOffset3), (float) IntOffset.m4823getYimpl(IntOffset3));
        }
        LookaheadDelegate access$getRootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate2);
        long r12 = lookaheadDelegate2.m3862positionInBjo55l4$ui_release(access$getRootLookaheadDelegate);
        long r3 = access$getRootLookaheadDelegate.m3859getPositionnOccac();
        long IntOffset4 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r12) + IntOffset.m4822getXimpl(r3), IntOffset.m4823getYimpl(r12) + IntOffset.m4823getYimpl(r3));
        long IntOffset5 = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m1683getXimpl(j)), MathKt.roundToInt(Offset.m1684getYimpl(j)));
        long IntOffset6 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(IntOffset4) + IntOffset.m4822getXimpl(IntOffset5), IntOffset.m4823getYimpl(IntOffset4) + IntOffset.m4823getYimpl(IntOffset5));
        LookaheadDelegate lookaheadDelegate3 = this.lookaheadDelegate;
        long r13 = lookaheadDelegate3.m3862positionInBjo55l4$ui_release(LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate3));
        long r32 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate3).m3859getPositionnOccac();
        long IntOffset7 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r13) + IntOffset.m4822getXimpl(r32), IntOffset.m4823getYimpl(r13) + IntOffset.m4823getYimpl(r32));
        long IntOffset8 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(IntOffset6) - IntOffset.m4822getXimpl(IntOffset7), IntOffset.m4823getYimpl(IntOffset6) - IntOffset.m4823getYimpl(IntOffset7));
        NodeCoordinator wrappedBy$ui_release = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate).getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release);
        NodeCoordinator wrappedBy$ui_release2 = access$getRootLookaheadDelegate.getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release2);
        return wrappedBy$ui_release.m3902localPositionOfR5De75A(wrappedBy$ui_release2, OffsetKt.Offset((float) IntOffset.m4822getXimpl(IntOffset8), (float) IntOffset.m4823getYimpl(IntOffset8)));
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m3642getSizeYbymL2g() {
        return getCoordinator().m3895getSizeYbymL2g();
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    public LayoutCoordinates getParentLayoutCoordinates() {
        return getCoordinator().getParentLayoutCoordinates();
    }

    public LayoutCoordinates getParentCoordinates() {
        return getCoordinator().getParentCoordinates();
    }

    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m3648windowToLocalMKHz9U(long j) {
        return getCoordinator().m3911windowToLocalMKHz9U(j);
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m3646localToWindowMKHz9U(long j) {
        return getCoordinator().m3904localToWindowMKHz9U(j);
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m3645localToRootMKHz9U(long j) {
        return getCoordinator().m3903localToRootMKHz9U(j);
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m3644localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        return getCoordinator().m3902localPositionOfR5De75A(layoutCoordinates, j);
    }

    public Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        return getCoordinator().localBoundingBoxOf(layoutCoordinates, z);
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    public void m3647transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        getCoordinator().m3909transformFromEL8BTi8(layoutCoordinates, fArr);
    }

    public int get(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return getCoordinator().get(alignmentLine);
    }
}
