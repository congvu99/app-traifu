package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J#\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J%\u0010\u0019\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R4\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "Landroidx/compose/foundation/lazy/grid/ItemIndex;", "index", "getIndex-VZbfaAc", "()I", "setIndex-YGsSkvE", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableState;", "lastKnownFirstItemKey", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPosition", "", "requestPosition-yO3Fmg4", "update", "update-yO3Fmg4", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyGridScrollPosition.kt */
public final class LazyGridScrollPosition {
    private boolean hadFirstNotEmptyLayout;
    private final MutableState index$delegate;
    private Object lastKnownFirstItemKey;
    private final MutableState scrollOffset$delegate;

    public LazyGridScrollPosition() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyGridScrollPosition(int i, int i2) {
        this.index$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ItemIndex.m690boximpl(ItemIndex.m692constructorimpl(i)), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.scrollOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i2), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyGridScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    /* renamed from: setIndex-YGsSkvE  reason: not valid java name */
    private final void m734setIndexYGsSkvE(int i) {
        this.index$delegate.setValue(ItemIndex.m690boximpl(i));
    }

    /* renamed from: getIndex-VZbfaAc  reason: not valid java name */
    public final int m736getIndexVZbfaAc() {
        return ((ItemIndex) this.index$delegate.getValue()).m702unboximpl();
    }

    private final void setScrollOffset(int i) {
        this.scrollOffset$delegate.setValue(Integer.valueOf(i));
    }

    public final int getScrollOffset() {
        return ((Number) this.scrollOffset$delegate.getValue()).intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = (androidx.compose.foundation.lazy.grid.LazyMeasuredItem) kotlin.collections.ArraysKt.firstOrNull((T[]) (r0 = r0.getItems()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateFromMeasureResult(androidx.compose.foundation.lazy.grid.LazyGridMeasureResult r6) {
        /*
            r5 = this;
            java.lang.String r0 = "measureResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.compose.foundation.lazy.grid.LazyMeasuredLine r0 = r6.getFirstVisibleLine()
            if (r0 == 0) goto L_0x001e
            androidx.compose.foundation.lazy.grid.LazyMeasuredItem[] r0 = r0.getItems()
            if (r0 == 0) goto L_0x001e
            java.lang.Object r0 = kotlin.collections.ArraysKt.firstOrNull((T[]) r0)
            androidx.compose.foundation.lazy.grid.LazyMeasuredItem r0 = (androidx.compose.foundation.lazy.grid.LazyMeasuredItem) r0
            if (r0 == 0) goto L_0x001e
            java.lang.Object r0 = r0.getKey()
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            r5.lastKnownFirstItemKey = r0
            boolean r0 = r5.hadFirstNotEmptyLayout
            if (r0 != 0) goto L_0x002b
            int r0 = r6.getTotalItemsCount()
            if (r0 <= 0) goto L_0x006e
        L_0x002b:
            r0 = 1
            r5.hadFirstNotEmptyLayout = r0
            int r1 = r6.getFirstVisibleLineScrollOffset()
            float r2 = (float) r1
            r3 = 0
            r4 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            if (r0 == 0) goto L_0x0079
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion
            androidx.compose.runtime.snapshots.Snapshot r0 = r0.createNonObservableSnapshot()
            androidx.compose.runtime.snapshots.Snapshot r2 = r0.makeCurrent()     // Catch:{ all -> 0x0074 }
            androidx.compose.foundation.lazy.grid.LazyMeasuredLine r6 = r6.getFirstVisibleLine()     // Catch:{ all -> 0x006f }
            if (r6 == 0) goto L_0x005f
            androidx.compose.foundation.lazy.grid.LazyMeasuredItem[] r6 = r6.getItems()     // Catch:{ all -> 0x006f }
            if (r6 == 0) goto L_0x005f
            java.lang.Object r6 = kotlin.collections.ArraysKt.firstOrNull((T[]) r6)     // Catch:{ all -> 0x006f }
            androidx.compose.foundation.lazy.grid.LazyMeasuredItem r6 = (androidx.compose.foundation.lazy.grid.LazyMeasuredItem) r6     // Catch:{ all -> 0x006f }
            if (r6 == 0) goto L_0x005f
            int r4 = r6.m740getIndexVZbfaAc()     // Catch:{ all -> 0x006f }
        L_0x005f:
            int r6 = androidx.compose.foundation.lazy.grid.ItemIndex.m692constructorimpl(r4)     // Catch:{ all -> 0x006f }
            r5.m735updateyO3Fmg4(r6, r1)     // Catch:{ all -> 0x006f }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006f }
            r0.restoreCurrent(r2)     // Catch:{ all -> 0x0074 }
            r0.dispose()
        L_0x006e:
            return
        L_0x006f:
            r6 = move-exception
            r0.restoreCurrent(r2)     // Catch:{ all -> 0x0074 }
            throw r6     // Catch:{ all -> 0x0074 }
        L_0x0074:
            r6 = move-exception
            r0.dispose()
            throw r6
        L_0x0079:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "scrollOffset should be non-negative ("
            r6.append(r0)
            r6.append(r1)
            r0 = 41
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r6 = r6.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridScrollPosition.updateFromMeasureResult(androidx.compose.foundation.lazy.grid.LazyGridMeasureResult):void");
    }

    /* renamed from: requestPosition-yO3Fmg4  reason: not valid java name */
    public final void m737requestPositionyO3Fmg4(int i, int i2) {
        m735updateyO3Fmg4(i, i2);
        this.lastKnownFirstItemKey = null;
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved(LazyGridItemProvider lazyGridItemProvider) {
        Snapshot makeCurrent;
        Intrinsics.checkNotNullParameter(lazyGridItemProvider, "itemProvider");
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            m735updateyO3Fmg4(ItemIndex.m692constructorimpl(LazyLayoutItemProviderKt.findIndexByKey(lazyGridItemProvider, this.lastKnownFirstItemKey, m736getIndexVZbfaAc())), getScrollOffset());
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }

    /* renamed from: update-yO3Fmg4  reason: not valid java name */
    private final void m735updateyO3Fmg4(int i, int i2) {
        if (((float) i) >= 0.0f) {
            if (!ItemIndex.m695equalsimpl0(i, m736getIndexVZbfaAc())) {
                m734setIndexYGsSkvE(i);
            }
            if (i2 != getScrollOffset()) {
                setScrollOffset(i2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("Index should be non-negative (" + i + ')').toString());
    }
}
