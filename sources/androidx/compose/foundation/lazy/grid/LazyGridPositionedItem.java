package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0019\u00106\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001072\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000J\u0006\u00108\u001a\u00020\u0006J\u0006\u00109\u001a\u00020\u0006J\u000e\u00104\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=R\u0014\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010#\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b$\u0010\u001bR\u0011\u0010%\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010\u001bR\u000e\u0010\u000e\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0011\u0010+\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b,\u0010\u001bR\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u001f\u0010\u000b\u001a\u00020\fX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010)\u001a\u0004\b.\u0010(R\u0019\u0010\u0018\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u00020\u0006*\u00020\u00038BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b0\u00101R\u0018\u00102\u001a\u00020\u0006*\u0002038BX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "placeableOffset", "index", "", "key", "", "row", "column", "size", "Landroidx/compose/ui/unit/IntSize;", "lineMainAxisSize", "mainAxisSpacing", "minMainAxisOffset", "maxMainAxisOffset", "isVertical", "", "wrappers", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPlaceableWrapper;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "visualOffset", "(JJILjava/lang/Object;IIJIIIIZLjava/util/List;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColumn", "()I", "hasAnimations", "getHasAnimations", "()Z", "getIndex", "getKey", "()Ljava/lang/Object;", "getLineMainAxisSize", "lineMainAxisSizeWithSpacings", "getLineMainAxisSizeWithSpacings", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "getOffset-nOcc-ac", "()J", "J", "getPlaceableOffset-nOcc-ac", "placeablesCount", "getPlaceablesCount", "getRow", "getSize-YbymL2g", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "Landroidx/compose/ui/layout/Placeable;", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "getAnimationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "getCrossAxisOffset", "getCrossAxisSize", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyMeasuredItem.kt */
public final class LazyGridPositionedItem implements LazyGridItemInfo {
    private final int column;
    private final boolean hasAnimations;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lineMainAxisSize;
    private final int mainAxisSpacing;
    private final int maxMainAxisOffset;
    private final int minMainAxisOffset;
    private final long offset;
    private final long placeableOffset;
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final int row;
    private final long size;
    private final long visualOffset;
    private final List<LazyGridPlaceableWrapper> wrappers;

    public /* synthetic */ LazyGridPositionedItem(long j, long j2, int i, Object obj, int i2, int i3, long j3, int i4, int i5, int i6, int i7, boolean z, List list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, i, obj, i2, i3, j3, i4, i5, i6, i7, z, list, lazyGridItemPlacementAnimator, j4);
    }

    private LazyGridPositionedItem(long j, long j2, int i, Object obj, int i2, int i3, long j3, int i4, int i5, int i6, int i7, boolean z, List<LazyGridPlaceableWrapper> list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j4) {
        this.offset = j;
        this.placeableOffset = j2;
        this.index = i;
        this.key = obj;
        this.row = i2;
        this.column = i3;
        this.size = j3;
        this.lineMainAxisSize = i4;
        this.mainAxisSpacing = i5;
        this.minMainAxisOffset = i6;
        this.maxMainAxisOffset = i7;
        this.isVertical = z;
        this.wrappers = list;
        this.placementAnimator = lazyGridItemPlacementAnimator;
        this.visualOffset = j4;
        LazyGridPositionedItem lazyGridPositionedItem = this;
        int placeablesCount = lazyGridPositionedItem.getPlaceablesCount();
        boolean z2 = false;
        int i8 = 0;
        while (true) {
            if (i8 >= placeablesCount) {
                break;
            } else if (lazyGridPositionedItem.getAnimationSpec(i8) != null) {
                z2 = true;
                break;
            } else {
                i8++;
            }
        }
        this.hasAnimations = z2;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public long m729getOffsetnOccac() {
        return this.offset;
    }

    /* renamed from: getPlaceableOffset-nOcc-ac  reason: not valid java name */
    public final long m730getPlaceableOffsetnOccac() {
        return this.placeableOffset;
    }

    public int getIndex() {
        return this.index;
    }

    public Object getKey() {
        return this.key;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m731getSizeYbymL2g() {
        return this.size;
    }

    public final int getLineMainAxisSize() {
        return this.lineMainAxisSize;
    }

    public final int getPlaceablesCount() {
        return this.wrappers.size();
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSpacing + (this.isVertical ? IntSize.m4863getHeightimpl(m731getSizeYbymL2g()) : IntSize.m4864getWidthimpl(m731getSizeYbymL2g()));
    }

    public final int getLineMainAxisSizeWithSpacings() {
        return this.mainAxisSpacing + this.lineMainAxisSize;
    }

    public final int getMainAxisSize(int i) {
        return getMainAxisSize(this.wrappers.get(i).getPlaceable());
    }

    public final int getCrossAxisSize() {
        return this.isVertical ? IntSize.m4864getWidthimpl(m731getSizeYbymL2g()) : IntSize.m4863getHeightimpl(m731getSizeYbymL2g());
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m4822getXimpl(m729getOffsetnOccac()) : IntOffset.m4823getYimpl(m729getOffsetnOccac());
    }

    public final FiniteAnimationSpec<IntOffset> getAnimationSpec(int i) {
        Object parentData = this.wrappers.get(i).getParentData();
        if (parentData instanceof FiniteAnimationSpec) {
            return (FiniteAnimationSpec) parentData;
        }
        return null;
    }

    public final boolean getHasAnimations() {
        return this.hasAnimations;
    }

    public final void place(Placeable.PlacementScope placementScope) {
        long j;
        Intrinsics.checkNotNullParameter(placementScope, "scope");
        int placeablesCount = getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            Placeable placeable = this.wrappers.get(i).getPlaceable();
            int mainAxisSize = this.minMainAxisOffset - getMainAxisSize(placeable);
            int i2 = this.maxMainAxisOffset;
            if (getAnimationSpec(i) != null) {
                j = this.placementAnimator.m716getAnimatedOffsetYT5a7pE(getKey(), i, mainAxisSize, i2, this.placeableOffset);
            } else {
                j = this.placeableOffset;
            }
            if (m728getMainAxisgyyYBs(j) > mainAxisSize && m728getMainAxisgyyYBs(j) < i2) {
                if (this.isVertical) {
                    long j2 = this.visualOffset;
                    Placeable.PlacementScope.m3692placeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(j) + IntOffset.m4822getXimpl(j2), IntOffset.m4823getYimpl(j) + IntOffset.m4823getYimpl(j2)), 0.0f, (Function1) null, 6, (Object) null);
                } else {
                    long j3 = this.visualOffset;
                    Placeable.PlacementScope.m3691placeRelativeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(j) + IntOffset.m4822getXimpl(j3), IntOffset.m4823getYimpl(j) + IntOffset.m4823getYimpl(j3)), 0.0f, (Function1) null, 6, (Object) null);
                }
            }
        }
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m728getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m4823getYimpl(j) : IntOffset.m4822getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }
}
