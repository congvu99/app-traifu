package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J[\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J;\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J<\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00052\f\u00101\u001a\b\u0012\u0004\u0012\u00020!022\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020-J\u0018\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\fH\u0002J\"\u00109\u001a\u00020\t*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010:\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u001c\u0010;\u001a\u00020\u0014*\u00020\tH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\t*\u00020\u00148BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "keyToIndexMap", "", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/ItemInfo;", "positionedKeys", "", "viewportEndItemIndex", "viewportEndItemNotVisiblePartSize", "viewportStartItemIndex", "viewportStartItemNotVisiblePartSize", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "calculateExpectedOffset", "index", "sizeWithSpacings", "averageItemsSize", "scrolledBy", "reverseLayout", "mainAxisLayoutSize", "fallback", "visibleItems", "", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "calculateExpectedOffset-diAxcj4", "(IIIJZIILjava/util/List;)I", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "reset", "startAnimationsIfNeeded", "item", "itemInfo", "getItemSize", "itemIndex", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyListItemPlacementAnimator.kt */
public final class LazyListItemPlacementAnimator {
    private final boolean isVertical;
    private Map<Object, Integer> keyToIndexMap = MapsKt.emptyMap();
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private final Set<Object> positionedKeys = new LinkedHashSet();
    private final CoroutineScope scope;
    private int viewportEndItemIndex = -1;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex = -1;
    private int viewportStartItemNotVisiblePartSize;

    public LazyListItemPlacementAnimator(CoroutineScope coroutineScope, boolean z) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.scope = coroutineScope;
        this.isVertical = z;
    }

    /* renamed from: getAnimatedOffset-YT5a7pE  reason: not valid java name */
    public final long m657getAnimatedOffsetYT5a7pE(Object obj, int i, int i2, int i3, long j) {
        Intrinsics.checkNotNullParameter(obj, SDKConstants.PARAM_KEY);
        ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null) {
            return j;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(i);
        long r11 = placeableInfo.getAnimatedOffset().getValue().m4831unboximpl();
        long r0 = itemInfo.m648getNotAnimatableDeltanOccac();
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r11) + IntOffset.m4822getXimpl(r0), IntOffset.m4823getYimpl(r11) + IntOffset.m4823getYimpl(r0));
        long r02 = placeableInfo.m678getTargetOffsetnOccac();
        long r2 = itemInfo.m648getNotAnimatableDeltanOccac();
        long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r02) + IntOffset.m4822getXimpl(r2), IntOffset.m4823getYimpl(r02) + IntOffset.m4823getYimpl(r2));
        if (placeableInfo.getInProgress() && ((m655getMainAxisgyyYBs(IntOffset2) < i2 && m655getMainAxisgyyYBs(IntOffset) < i2) || (m655getMainAxisgyyYBs(IntOffset2) > i3 && m655getMainAxisgyyYBs(IntOffset) > i3))) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyListItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, (Continuation<? super LazyListItemPlacementAnimator$getAnimatedOffset$1>) null), 3, (Object) null);
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

    /* renamed from: calculateExpectedOffset-diAxcj4  reason: not valid java name */
    private final int m654calculateExpectedOffsetdiAxcj4(int i, int i2, int i3, long j, boolean z, int i4, int i5, List<LazyListPositionedItem> list) {
        IntRange intRange;
        IntRange intRange2;
        int i6 = 0;
        int i7 = this.viewportEndItemIndex;
        boolean z2 = z ? i7 > i : i7 < i;
        int i8 = this.viewportStartItemIndex;
        boolean z3 = z ? i8 < i : i8 > i;
        if (z2) {
            if (!z) {
                intRange2 = RangesKt.until(this.viewportEndItemIndex + 1, i);
            } else {
                intRange2 = RangesKt.until(i + 1, this.viewportEndItemIndex);
            }
            int first = intRange2.getFirst();
            int last = intRange2.getLast();
            if (first <= last) {
                while (true) {
                    i6 += getItemSize(list, first, i3);
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
            return i4 + this.viewportEndItemNotVisiblePartSize + i6 + m655getMainAxisgyyYBs(j);
        } else if (!z3) {
            return i5;
        } else {
            if (!z) {
                intRange = RangesKt.until(i + 1, this.viewportStartItemIndex);
            } else {
                intRange = RangesKt.until(this.viewportStartItemIndex + 1, i);
            }
            int first2 = intRange.getFirst();
            int last2 = intRange.getLast();
            if (first2 <= last2) {
                while (true) {
                    i2 += getItemSize(list, first2, i3);
                    if (first2 == last2) {
                        break;
                    }
                    first2++;
                }
            }
            return (this.viewportStartItemNotVisiblePartSize - i2) + m655getMainAxisgyyYBs(j);
        }
    }

    private final int getItemSize(List<LazyListPositionedItem> list, int i, int i2) {
        if (!list.isEmpty() && i >= ((LazyListPositionedItem) CollectionsKt.first(list)).getIndex() && i <= ((LazyListPositionedItem) CollectionsKt.last(list)).getIndex()) {
            if (i - ((LazyListPositionedItem) CollectionsKt.first(list)).getIndex() >= ((LazyListPositionedItem) CollectionsKt.last(list)).getIndex() - i) {
                int lastIndex = CollectionsKt.getLastIndex(list);
                while (-1 < lastIndex) {
                    LazyListPositionedItem lazyListPositionedItem = list.get(lastIndex);
                    if (lazyListPositionedItem.getIndex() != i) {
                        if (lazyListPositionedItem.getIndex() < i) {
                            break;
                        }
                        lastIndex--;
                    } else {
                        return lazyListPositionedItem.getSizeWithSpacings();
                    }
                }
            } else {
                int i3 = 0;
                int size = list.size();
                while (i3 < size) {
                    LazyListPositionedItem lazyListPositionedItem2 = list.get(i3);
                    if (lazyListPositionedItem2.getIndex() != i) {
                        if (lazyListPositionedItem2.getIndex() > i) {
                            break;
                        }
                        i3++;
                    } else {
                        return lazyListPositionedItem2.getSizeWithSpacings();
                    }
                }
            }
        }
        return i2;
    }

    private final void startAnimationsIfNeeded(LazyListPositionedItem lazyListPositionedItem, ItemInfo itemInfo) {
        LazyListPositionedItem lazyListPositionedItem2 = lazyListPositionedItem;
        while (itemInfo.getPlaceables().size() > lazyListPositionedItem.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < lazyListPositionedItem.getPlaceablesCount()) {
            int size = itemInfo.getPlaceables().size();
            long r4 = lazyListPositionedItem2.m667getOffsetBjo55l4(size);
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long r7 = itemInfo.m648getNotAnimatableDeltanOccac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r4) - IntOffset.m4822getXimpl(r7), IntOffset.m4823getYimpl(r4) - IntOffset.m4823getYimpl(r7)), lazyListPositionedItem2.getMainAxisSize(size), (DefaultConstructorMarker) null));
        }
        List<PlaceableInfo> placeables2 = itemInfo.getPlaceables();
        int size2 = placeables2.size();
        for (int i = 0; i < size2; i++) {
            PlaceableInfo placeableInfo = placeables2.get(i);
            long r6 = placeableInfo.m678getTargetOffsetnOccac();
            long r8 = itemInfo.m648getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r6) + IntOffset.m4822getXimpl(r8), IntOffset.m4823getYimpl(r6) + IntOffset.m4823getYimpl(r8));
            long r82 = lazyListPositionedItem2.m667getOffsetBjo55l4(i);
            placeableInfo.setSize(lazyListPositionedItem2.getMainAxisSize(i));
            FiniteAnimationSpec<IntOffset> animationSpec = lazyListPositionedItem2.getAnimationSpec(i);
            if (!IntOffset.m4821equalsimpl0(IntOffset, r82)) {
                long r62 = itemInfo.m648getNotAnimatableDeltanOccac();
                placeableInfo.m679setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r82) - IntOffset.m4822getXimpl(r62), IntOffset.m4823getYimpl(r82) - IntOffset.m4823getYimpl(r62)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, (Continuation<? super LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1>) null), 3, (Object) null);
                }
            }
        }
    }

    /* renamed from: toOffset-Bjo55l4  reason: not valid java name */
    private final long m656toOffsetBjo55l4(int i) {
        int i2 = this.isVertical ? 0 : i;
        if (!this.isVertical) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m655getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m4823getYimpl(j) : IntOffset.m4822getXimpl(j);
    }

    public final void onMeasured(int i, int i2, int i3, boolean z, List<LazyListPositionedItem> list, LazyMeasuredItemProvider lazyMeasuredItemProvider) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        ItemInfo itemInfo;
        LazyListPositionedItem lazyListPositionedItem;
        long j;
        int i6;
        long j2;
        int i7;
        List<LazyListPositionedItem> list2 = list;
        LazyMeasuredItemProvider lazyMeasuredItemProvider2 = lazyMeasuredItemProvider;
        Intrinsics.checkNotNullParameter(list2, "positionedItems");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider2, "itemProvider");
        int size = list.size();
        int i8 = 0;
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
        int i10 = this.isVertical ? i3 : i2;
        int i11 = i;
        if (z) {
            i11 = -i11;
        }
        long r16 = m656toOffsetBjo55l4(i11);
        LazyListPositionedItem lazyListPositionedItem2 = (LazyListPositionedItem) CollectionsKt.first(list);
        LazyListPositionedItem lazyListPositionedItem3 = (LazyListPositionedItem) CollectionsKt.last(list);
        int size2 = list.size();
        int i12 = 0;
        for (int i13 = 0; i13 < size2; i13++) {
            LazyListPositionedItem lazyListPositionedItem4 = list2.get(i13);
            ItemInfo itemInfo2 = this.keyToItemInfoMap.get(lazyListPositionedItem4.getKey());
            if (itemInfo2 != null) {
                itemInfo2.setIndex(lazyListPositionedItem4.getIndex());
            }
            i12 += lazyListPositionedItem4.getSizeWithSpacings();
        }
        int size3 = i12 / list.size();
        this.positionedKeys.clear();
        int size4 = list.size();
        int i14 = 0;
        while (i14 < size4) {
            LazyListPositionedItem lazyListPositionedItem5 = list2.get(i14);
            this.positionedKeys.add(lazyListPositionedItem5.getKey());
            ItemInfo itemInfo3 = this.keyToItemInfoMap.get(lazyListPositionedItem5.getKey());
            if (itemInfo3 != null) {
                LazyListPositionedItem lazyListPositionedItem6 = lazyListPositionedItem5;
                i5 = i14;
                i4 = size4;
                if (lazyListPositionedItem6.getHasAnimations()) {
                    long r1 = itemInfo3.m648getNotAnimatableDeltanOccac();
                    itemInfo3.m649setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r1) + IntOffset.m4822getXimpl(r16), IntOffset.m4823getYimpl(r1) + IntOffset.m4823getYimpl(r16)));
                    startAnimationsIfNeeded(lazyListPositionedItem6, itemInfo3);
                } else {
                    this.keyToItemInfoMap.remove(lazyListPositionedItem6.getKey());
                }
            } else if (lazyListPositionedItem5.getHasAnimations()) {
                ItemInfo itemInfo4 = new ItemInfo(lazyListPositionedItem5.getIndex());
                Integer num = this.keyToIndexMap.get(lazyListPositionedItem5.getKey());
                long r4 = lazyListPositionedItem5.m667getOffsetBjo55l4(i8);
                int mainAxisSize = lazyListPositionedItem5.getMainAxisSize(i8);
                if (num == null) {
                    i6 = m655getMainAxisgyyYBs(r4);
                    j = r4;
                    itemInfo = itemInfo4;
                    lazyListPositionedItem = lazyListPositionedItem5;
                    i5 = i14;
                    i4 = size4;
                } else {
                    if (!z) {
                        i7 = m655getMainAxisgyyYBs(r4);
                    } else {
                        i7 = (m655getMainAxisgyyYBs(r4) - lazyListPositionedItem5.getSizeWithSpacings()) + mainAxisSize;
                    }
                    j = r4;
                    itemInfo = itemInfo4;
                    lazyListPositionedItem = lazyListPositionedItem5;
                    i5 = i14;
                    i4 = size4;
                    i6 = m654calculateExpectedOffsetdiAxcj4(num.intValue(), lazyListPositionedItem5.getSizeWithSpacings(), size3, r16, z, i10, i7, list) + (z ? lazyListPositionedItem.getSize() - mainAxisSize : 0);
                }
                if (this.isVertical) {
                    j2 = IntOffset.m4818copyiSbpLlY$default(j, 0, i6, 1, (Object) null);
                } else {
                    j2 = IntOffset.m4818copyiSbpLlY$default(j, i6, 0, 2, (Object) null);
                }
                int placeablesCount = lazyListPositionedItem.getPlaceablesCount();
                for (int i15 = 0; i15 < placeablesCount; i15++) {
                    LazyListPositionedItem lazyListPositionedItem7 = lazyListPositionedItem;
                    long r5 = lazyListPositionedItem7.m667getOffsetBjo55l4(i15);
                    long IntOffset = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r5) - IntOffset.m4822getXimpl(j), IntOffset.m4823getYimpl(r5) - IntOffset.m4823getYimpl(j));
                    itemInfo.getPlaceables().add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(j2) + IntOffset.m4822getXimpl(IntOffset), IntOffset.m4823getYimpl(j2) + IntOffset.m4823getYimpl(IntOffset)), lazyListPositionedItem7.getMainAxisSize(i15), (DefaultConstructorMarker) null));
                    Unit unit = Unit.INSTANCE;
                }
                LazyListPositionedItem lazyListPositionedItem8 = lazyListPositionedItem;
                ItemInfo itemInfo5 = itemInfo;
                this.keyToItemInfoMap.put(lazyListPositionedItem8.getKey(), itemInfo5);
                startAnimationsIfNeeded(lazyListPositionedItem8, itemInfo5);
            } else {
                i5 = i14;
                i4 = size4;
            }
            i14 = i5 + 1;
            size4 = i4;
            i8 = 0;
        }
        if (!z) {
            this.viewportStartItemIndex = lazyListPositionedItem2.getIndex();
            this.viewportStartItemNotVisiblePartSize = lazyListPositionedItem2.getOffset();
            this.viewportEndItemIndex = lazyListPositionedItem3.getIndex();
            this.viewportEndItemNotVisiblePartSize = (lazyListPositionedItem3.getOffset() + lazyListPositionedItem3.getSizeWithSpacings()) - i10;
        } else {
            this.viewportStartItemIndex = lazyListPositionedItem3.getIndex();
            this.viewportStartItemNotVisiblePartSize = (i10 - lazyListPositionedItem3.getOffset()) - lazyListPositionedItem3.getSize();
            this.viewportEndItemIndex = lazyListPositionedItem2.getIndex();
            this.viewportEndItemNotVisiblePartSize = (-lazyListPositionedItem2.getOffset()) + (lazyListPositionedItem2.getSizeWithSpacings() - lazyListPositionedItem2.getSize());
        }
        Iterator<Map.Entry<Object, ItemInfo>> it = this.keyToItemInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!this.positionedKeys.contains(next.getKey())) {
                ItemInfo itemInfo6 = (ItemInfo) next.getValue();
                long r12 = itemInfo6.m648getNotAnimatableDeltanOccac();
                itemInfo6.m649setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r12) + IntOffset.m4822getXimpl(r16), IntOffset.m4823getYimpl(r12) + IntOffset.m4823getYimpl(r16)));
                Integer num2 = lazyMeasuredItemProvider.getKeyToIndexMap().get(next.getKey());
                List<PlaceableInfo> placeables = itemInfo6.getPlaceables();
                int size5 = placeables.size();
                int i16 = 0;
                while (true) {
                    if (i16 >= size5) {
                        z3 = false;
                        break;
                    }
                    PlaceableInfo placeableInfo = placeables.get(i16);
                    long r52 = placeableInfo.m678getTargetOffsetnOccac();
                    long r7 = itemInfo6.m648getNotAnimatableDeltanOccac();
                    long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m4822getXimpl(r52) + IntOffset.m4822getXimpl(r7), IntOffset.m4823getYimpl(r52) + IntOffset.m4823getYimpl(r7));
                    if (m655getMainAxisgyyYBs(IntOffset2) + placeableInfo.getSize() > 0 && m655getMainAxisgyyYBs(IntOffset2) < i10) {
                        z3 = true;
                        break;
                    }
                    i16++;
                }
                List<PlaceableInfo> placeables2 = itemInfo6.getPlaceables();
                int size6 = placeables2.size();
                int i17 = 0;
                while (true) {
                    if (i17 >= size6) {
                        z4 = false;
                        break;
                    } else if (placeables2.get(i17).getInProgress()) {
                        z4 = true;
                        break;
                    } else {
                        i17++;
                    }
                }
                boolean z5 = !z4;
                if ((z3 || !z5) && num2 != null && !itemInfo6.getPlaceables().isEmpty()) {
                    LazyMeasuredItem r8 = lazyMeasuredItemProvider2.m674getAndMeasureZjPyQlc(DataIndex.m636constructorimpl(num2.intValue()));
                    LazyMeasuredItem lazyMeasuredItem = r8;
                    ItemInfo itemInfo7 = itemInfo6;
                    int r0 = m654calculateExpectedOffsetdiAxcj4(num2.intValue(), r8.getSizeWithSpacings(), size3, r16, z, i10, i10, list);
                    if (z) {
                        r0 = (i10 - r0) - lazyMeasuredItem.getSize();
                    }
                    LazyListPositionedItem position = lazyMeasuredItem.position(r0, i2, i3);
                    list2.add(position);
                    startAnimationsIfNeeded(position, itemInfo7);
                } else {
                    int i18 = i2;
                    int i19 = i3;
                    it.remove();
                }
            } else {
                int i20 = i2;
                int i21 = i3;
            }
        }
        this.keyToIndexMap = lazyMeasuredItemProvider.getKeyToIndexMap();
    }
}
