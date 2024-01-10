package androidx.compose.ui.window;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J5\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/window/AlignmentOffsetPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getOffset-nOcc-ac", "()J", "J", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Popup.kt */
public final class AlignmentOffsetPositionProvider implements PopupPositionProvider {
    private final Alignment alignment;
    private final long offset;

    public /* synthetic */ AlignmentOffsetPositionProvider(Alignment alignment2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment2, j);
    }

    private AlignmentOffsetPositionProvider(Alignment alignment2, long j) {
        this.alignment = alignment2;
        this.offset = j;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public final long m4949getOffsetnOccac() {
        return this.offset;
    }

    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    public long m4948calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        Intrinsics.checkNotNullParameter(intRect, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, ViewProps.LAYOUT_DIRECTION);
        long IntOffset = IntOffsetKt.IntOffset(0, 0);
        long r0 = this.alignment.m1561alignKFBX0sM(IntSize.Companion.m4869getZeroYbymL2g(), IntSizeKt.IntSize(intRect.getWidth(), intRect.getHeight()), layoutDirection);
        long r13 = this.alignment.m1561alignKFBX0sM(IntSize.Companion.m4869getZeroYbymL2g(), IntSizeKt.IntSize(IntSize.m4864getWidthimpl(j2), IntSize.m4863getHeightimpl(j2)), layoutDirection);
        long IntOffset2 = IntOffsetKt.IntOffset(intRect.getLeft(), intRect.getTop());
        long IntOffset3 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(IntOffset) + IntOffset.m4822getXimpl(IntOffset2), IntOffset.m4823getYimpl(IntOffset) + IntOffset.m4823getYimpl(IntOffset2));
        long IntOffset4 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(IntOffset3) + IntOffset.m4822getXimpl(r0), IntOffset.m4823getYimpl(IntOffset3) + IntOffset.m4823getYimpl(r0));
        long IntOffset5 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r13), IntOffset.m4823getYimpl(r13));
        long IntOffset6 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(IntOffset4) - IntOffset.m4822getXimpl(IntOffset5), IntOffset.m4823getYimpl(IntOffset4) - IntOffset.m4823getYimpl(IntOffset5));
        long IntOffset7 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(this.offset) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1), IntOffset.m4823getYimpl(this.offset));
        return IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(IntOffset6) + IntOffset.m4822getXimpl(IntOffset7), IntOffset.m4823getYimpl(IntOffset6) + IntOffset.m4823getYimpl(IntOffset7));
    }
}
