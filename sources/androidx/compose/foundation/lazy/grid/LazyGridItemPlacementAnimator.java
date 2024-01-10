package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JM\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J;\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0015ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)JD\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00052\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020+J\u0018\u00105\u001a\u00020+2\u0006\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\fH\u0002J\u001c\u00108\u001a\u00020\u0015*\u00020\tH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\t*\u00020\u00158BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "keyToIndexMap", "", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "positionedKeys", "", "slotsPerLine", "viewportEndItemIndex", "viewportEndItemNotVisiblePartSize", "viewportStartItemIndex", "viewportStartItemNotVisiblePartSize", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "calculateExpectedOffset", "index", "mainAxisSizeWithSpacings", "averageLineMainAxisSize", "scrolledBy", "reverseLayout", "mainAxisLayoutSize", "fallback", "calculateExpectedOffset-tGxSNXI", "(IIIJZII)I", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "reset", "startAnimationsIfNeeded", "item", "itemInfo", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyGridItemPlacementAnimator.kt */
public final class LazyGridItemPlacementAnimator {
    /* access modifiers changed from: private */
    public final boolean isVertical;
    private Map<Object, Integer> keyToIndexMap = MapsKt.emptyMap();
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private final Set<Object> positionedKeys = new LinkedHashSet();
    private final CoroutineScope scope;
    private int slotsPerLine;
    private int viewportEndItemIndex = -1;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex = -1;
    private int viewportStartItemNotVisiblePartSize;

    public LazyGridItemPlacementAnimator(CoroutineScope coroutineScope, boolean z) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.scope = coroutineScope;
        this.isVertical = z;
    }

    /* renamed from: getAnimatedOffset-YT5a7pE  reason: not valid java name */
    public final long m716getAnimatedOffsetYT5a7pE(Object obj, int i, int i2, int i3, long j) {
        Intrinsics.checkNotNullParameter(obj, SDKConstants.PARAM_KEY);
        ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null) {
            return j;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(i);
        long r11 = placeableInfo.getAnimatedOffset().getValue().m4831unboximpl();
        long r0 = itemInfo.m703getNotAnimatableDeltanOccac();
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r11) + IntOffset.m4822getXimpl(r0), IntOffset.m4823getYimpl(r11) + IntOffset.m4823getYimpl(r0));
        long r02 = placeableInfo.m761getTargetOffsetnOccac();
        long r2 = itemInfo.m703getNotAnimatableDeltanOccac();
        long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r02) + IntOffset.m4822getXimpl(r2), IntOffset.m4823getYimpl(r02) + IntOffset.m4823getYimpl(r2));
        if (placeableInfo.getInProgress() && ((m714getMainAxisgyyYBs(IntOffset2) < i2 && m714getMainAxisgyyYBs(IntOffset) < i2) || (m714getMainAxisgyyYBs(IntOffset2) > i3 && m714getMainAxisgyyYBs(IntOffset) > i3))) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyGridItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, (Continuation<? super LazyGridItemPlacementAnimator$getAnimatedOffset$1>) null), 3, (Object) null);
        }
        return IntOffset;
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.viewportStartItemIndex = -1;
        this.viewportStartItemNotVisiblePartSize = 0;
        this.viewportEndItemIndex = -1;
        this.viewportEndItemNotVisiblePartSize = 0;
    }

    /* renamed from: calculateExpectedOffset-tGxSNXI  reason: not valid java name */
    private final int m713calculateExpectedOffsettGxSNXI(int i, int i2, int i3, long j, boolean z, int i4, int i5) {
        boolean z2 = false;
        if (this.slotsPerLine != 0) {
            int i6 = this.viewportEndItemIndex;
            boolean z3 = z ? i6 > i : i6 < i;
            if (z ? this.viewportStartItemIndex < i : this.viewportStartItemIndex > i) {
                z2 = true;
            }
            if (z3) {
                int abs = Math.abs(i - this.viewportEndItemIndex);
                int i7 = this.slotsPerLine;
                return i4 + this.viewportEndItemNotVisiblePartSize + (i3 * ((((abs + i7) - 1) / i7) - 1)) + m714getMainAxisgyyYBs(j);
            } else if (!z2) {
                return i5;
            } else {
                int abs2 = Math.abs(this.viewportStartItemIndex - i);
                int i8 = this.slotsPerLine;
                return ((this.viewportStartItemNotVisiblePartSize - i2) - (i3 * ((((abs2 + i8) - 1) / i8) - 1))) + m714getMainAxisgyyYBs(j);
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final void startAnimationsIfNeeded(LazyGridPositionedItem lazyGridPositionedItem, ItemInfo itemInfo) {
        LazyGridPositionedItem lazyGridPositionedItem2 = lazyGridPositionedItem;
        while (itemInfo.getPlaceables().size() > lazyGridPositionedItem.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < lazyGridPositionedItem.getPlaceablesCount()) {
            int size = itemInfo.getPlaceables().size();
            long r4 = lazyGridPositionedItem.m729getOffsetnOccac();
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long r7 = itemInfo.m703getNotAnimatableDeltanOccac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r4) - IntOffset.m4822getXimpl(r7), IntOffset.m4823getYimpl(r4) - IntOffset.m4823getYimpl(r7)), lazyGridPositionedItem2.getMainAxisSize(size), (DefaultConstructorMarker) null));
        }
        List<PlaceableInfo> placeables2 = itemInfo.getPlaceables();
        int size2 = placeables2.size();
        for (int i = 0; i < size2; i++) {
            PlaceableInfo placeableInfo = placeables2.get(i);
            long r6 = placeableInfo.m761getTargetOffsetnOccac();
            long r8 = itemInfo.m703getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r6) + IntOffset.m4822getXimpl(r8), IntOffset.m4823getYimpl(r6) + IntOffset.m4823getYimpl(r8));
            long r82 = lazyGridPositionedItem.m730getPlaceableOffsetnOccac();
            placeableInfo.setMainAxisSize(lazyGridPositionedItem2.getMainAxisSize(i));
            FiniteAnimationSpec<IntOffset> animationSpec = lazyGridPositionedItem2.getAnimationSpec(i);
            if (!IntOffset.m4821equalsimpl0(IntOffset, r82)) {
                long r62 = itemInfo.m703getNotAnimatableDeltanOccac();
                placeableInfo.m762setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r82) - IntOffset.m4822getXimpl(r62), IntOffset.m4823getYimpl(r82) - IntOffset.m4823getYimpl(r62)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, (Continuation<? super LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1>) null), 3, (Object) null);
                }
            }
        }
    }

    /* renamed from: toOffset-Bjo55l4  reason: not valid java name */
    private final long m715toOffsetBjo55l4(int i) {
        int i2 = this.isVertical ? 0 : i;
        if (!this.isVertical) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m714getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m4823getYimpl(j) : IntOffset.m4822getXimpl(j);
    }

    public final void onMeasured(int i, int i2, int i3, int i4, boolean z, List<LazyGridPositionedItem> list, LazyMeasuredItemProvider lazyMeasuredItemProvider) {
        boolean z2;
        boolean z3;
        boolean z4;
        long j;
        int i5;
        int i6;
        LazyGridPositionedItem lazyGridPositionedItem;
        ItemInfo itemInfo;
        long j2;
        int i7;
        long j3;
        int i8;
        List<LazyGridPositionedItem> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "positionedItems");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider, "measuredItemProvider");
        int size = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                z2 = false;
                break;
            } else if (list2.get(i9).getHasAnimations()) {
                z2 = true;
                break;
            } else {
                i9++;
            }
        }
        if (!z2) {
            reset();
            return;
        }
        this.slotsPerLine = i4;
        int i10 = this.isVertical ? i3 : i2;
        int i11 = i;
        if (z) {
            i11 = -i11;
        }
        long r15 = m715toOffsetBjo55l4(i11);
        LazyGridPositionedItem lazyGridPositionedItem2 = (LazyGridPositionedItem) CollectionsKt.first(list);
        LazyGridPositionedItem lazyGridPositionedItem3 = (LazyGridPositionedItem) CollectionsKt.last(list);
        int size2 = list.size();
        for (int i12 = 0; i12 < size2; i12++) {
            LazyGridPositionedItem lazyGridPositionedItem4 = list2.get(i12);
            ItemInfo itemInfo2 = this.keyToItemInfoMap.get(lazyGridPositionedItem4.getKey());
            if (itemInfo2 != null) {
                itemInfo2.setIndex(lazyGridPositionedItem4.getIndex());
                itemInfo2.setCrossAxisSize(lazyGridPositionedItem4.getCrossAxisSize());
                itemInfo2.setCrossAxisOffset(lazyGridPositionedItem4.getCrossAxisOffset());
            }
        }
        Function1 lazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1 = new LazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1(this, list2);
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < list.size()) {
            int intValue = ((Number) lazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1.invoke(Integer.valueOf(i13))).intValue();
            if (intValue == -1) {
                i13++;
            } else {
                int i16 = 0;
                while (i13 < list.size() && ((Number) lazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1.invoke(Integer.valueOf(i13))).intValue() == intValue) {
                    i16 = Math.max(i16, list2.get(i13).getMainAxisSizeWithSpacings());
                    i13++;
                }
                i14 += i16;
                i15++;
            }
        }
        int i17 = i14 / i15;
        this.positionedKeys.clear();
        int i18 = 0;
        for (int size3 = list.size(); i18 < size3; size3 = i5) {
            LazyGridPositionedItem lazyGridPositionedItem5 = list2.get(i18);
            this.positionedKeys.add(lazyGridPositionedItem5.getKey());
            ItemInfo itemInfo3 = this.keyToItemInfoMap.get(lazyGridPositionedItem5.getKey());
            if (itemInfo3 != null) {
                i6 = i18;
                i5 = size3;
                if (lazyGridPositionedItem5.getHasAnimations()) {
                    long r1 = itemInfo3.m703getNotAnimatableDeltanOccac();
                    itemInfo3.m704setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r1) + IntOffset.m4822getXimpl(r15), IntOffset.m4823getYimpl(r1) + IntOffset.m4823getYimpl(r15)));
                    startAnimationsIfNeeded(lazyGridPositionedItem5, itemInfo3);
                } else {
                    this.keyToItemInfoMap.remove(lazyGridPositionedItem5.getKey());
                }
            } else if (lazyGridPositionedItem5.getHasAnimations()) {
                ItemInfo itemInfo4 = new ItemInfo(lazyGridPositionedItem5.getIndex(), lazyGridPositionedItem5.getCrossAxisSize(), lazyGridPositionedItem5.getCrossAxisOffset());
                Integer num = this.keyToIndexMap.get(lazyGridPositionedItem5.getKey());
                long r2 = lazyGridPositionedItem5.m730getPlaceableOffsetnOccac();
                if (num == null) {
                    i7 = m714getMainAxisgyyYBs(r2);
                    j2 = r2;
                    itemInfo = itemInfo4;
                    lazyGridPositionedItem = lazyGridPositionedItem5;
                    i6 = i18;
                    i5 = size3;
                } else {
                    if (!z) {
                        i8 = m714getMainAxisgyyYBs(r2);
                    } else {
                        i8 = m714getMainAxisgyyYBs(r2) - lazyGridPositionedItem5.getMainAxisSizeWithSpacings();
                    }
                    j2 = r2;
                    itemInfo = itemInfo4;
                    lazyGridPositionedItem = lazyGridPositionedItem5;
                    i6 = i18;
                    i5 = size3;
                    i7 = m713calculateExpectedOffsettGxSNXI(num.intValue(), lazyGridPositionedItem5.getMainAxisSizeWithSpacings(), i17, r15, z, i10, i8);
                }
                if (this.isVertical) {
                    j3 = IntOffset.m4818copyiSbpLlY$default(j2, 0, i7, 1, (Object) null);
                } else {
                    j3 = IntOffset.m4818copyiSbpLlY$default(j2, i7, 0, 2, (Object) null);
                }
                int placeablesCount = lazyGridPositionedItem.getPlaceablesCount();
                for (int i19 = 0; i19 < placeablesCount; i19++) {
                    itemInfo.getPlaceables().add(new PlaceableInfo(j3, lazyGridPositionedItem.getMainAxisSize(i19), (DefaultConstructorMarker) null));
                    Unit unit = Unit.INSTANCE;
                }
                LazyGridPositionedItem lazyGridPositionedItem6 = lazyGridPositionedItem;
                ItemInfo itemInfo5 = itemInfo;
                this.keyToItemInfoMap.put(lazyGridPositionedItem6.getKey(), itemInfo5);
                startAnimationsIfNeeded(lazyGridPositionedItem6, itemInfo5);
            } else {
                i6 = i18;
                i5 = size3;
            }
            i18 = i6 + 1;
        }
        if (!z) {
            this.viewportStartItemIndex = lazyGridPositionedItem2.getIndex();
            this.viewportStartItemNotVisiblePartSize = m714getMainAxisgyyYBs(lazyGridPositionedItem2.m729getOffsetnOccac());
            this.viewportEndItemIndex = lazyGridPositionedItem3.getIndex();
            this.viewportEndItemNotVisiblePartSize = (m714getMainAxisgyyYBs(lazyGridPositionedItem3.m729getOffsetnOccac()) + lazyGridPositionedItem3.getLineMainAxisSizeWithSpacings()) - i10;
        } else {
            this.viewportStartItemIndex = lazyGridPositionedItem3.getIndex();
            this.viewportStartItemNotVisiblePartSize = (i10 - m714getMainAxisgyyYBs(lazyGridPositionedItem3.m729getOffsetnOccac())) - lazyGridPositionedItem3.getLineMainAxisSize();
            this.viewportEndItemIndex = lazyGridPositionedItem2.getIndex();
            this.viewportEndItemNotVisiblePartSize = (-m714getMainAxisgyyYBs(lazyGridPositionedItem2.m729getOffsetnOccac())) + (lazyGridPositionedItem2.getLineMainAxisSizeWithSpacings() - (this.isVertical ? IntSize.m4863getHeightimpl(lazyGridPositionedItem2.m731getSizeYbymL2g()) : IntSize.m4864getWidthimpl(lazyGridPositionedItem2.m731getSizeYbymL2g())));
        }
        Iterator<Map.Entry<Object, ItemInfo>> it = this.keyToItemInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!this.positionedKeys.contains(next.getKey())) {
                ItemInfo itemInfo6 = (ItemInfo) next.getValue();
                long r12 = itemInfo6.m703getNotAnimatableDeltanOccac();
                itemInfo6.m704setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r12) + IntOffset.m4822getXimpl(r15), IntOffset.m4823getYimpl(r12) + IntOffset.m4823getYimpl(r15)));
                Integer num2 = lazyMeasuredItemProvider.getKeyToIndexMap().get(next.getKey());
                List<PlaceableInfo> placeables = itemInfo6.getPlaceables();
                int size4 = placeables.size();
                int i20 = 0;
                while (true) {
                    if (i20 >= size4) {
                        z3 = false;
                        break;
                    }
                    PlaceableInfo placeableInfo = placeables.get(i20);
                    long r5 = placeableInfo.m761getTargetOffsetnOccac();
                    long r20 = itemInfo6.m703getNotAnimatableDeltanOccac();
                    long IntOffset = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r5) + IntOffset.m4822getXimpl(r20), IntOffset.m4823getYimpl(r5) + IntOffset.m4823getYimpl(r20));
                    if (m714getMainAxisgyyYBs(IntOffset) + placeableInfo.getMainAxisSize() > 0 && m714getMainAxisgyyYBs(IntOffset) < i10) {
                        z3 = true;
                        break;
                    }
                    i20++;
                }
                List<PlaceableInfo> placeables2 = itemInfo6.getPlaceables();
                int size5 = placeables2.size();
                int i21 = 0;
                while (true) {
                    if (i21 >= size5) {
                        z4 = false;
                        break;
                    } else if (placeables2.get(i21).getInProgress()) {
                        z4 = true;
                        break;
                    } else {
                        i21++;
                    }
                }
                boolean z5 = !z4;
                if ((z3 || !z5) && num2 != null && !itemInfo6.getPlaceables().isEmpty()) {
                    int r22 = ItemIndex.m692constructorimpl(num2.intValue());
                    if (this.isVertical) {
                        j = Constraints.Companion.m4634fixedWidthOenEA2s(itemInfo6.getCrossAxisSize());
                    } else {
                        j = Constraints.Companion.m4633fixedHeightOenEA2s(itemInfo6.getCrossAxisSize());
                    }
                    LazyMeasuredItem r202 = LazyMeasuredItemProvider.m741getAndMeasureednRnyU$default(lazyMeasuredItemProvider, r22, 0, j, 2, (Object) null);
                    ItemInfo itemInfo7 = itemInfo6;
                    int r0 = m713calculateExpectedOffsettGxSNXI(num2.intValue(), r202.getMainAxisSizeWithSpacings(), i17, r15, z, i10, i10);
                    if (z) {
                        r0 = (i10 - r0) - r202.getMainAxisSize();
                    }
                    LazyGridPositionedItem position = r202.position(r0, itemInfo7.getCrossAxisOffset(), i2, i3, -1, -1, r202.getMainAxisSize());
                    list2.add(position);
                    startAnimationsIfNeeded(position, itemInfo7);
                } else {
                    it.remove();
                }
            }
        }
        this.keyToIndexMap = lazyMeasuredItemProvider.getKeyToIndexMap();
    }
}
