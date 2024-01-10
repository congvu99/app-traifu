package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010G\u001a\u00020\u0005H\u0016J\u0010\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u0005H\u0016J\u0010\u0010J\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u0005H\u0016J=\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020\u001eH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ\b\u0010S\u001a\u00020\u000bH\u0016J\u0010\u0010T\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u0005H\u0016J-\u0010U\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u001b2\u0006\u0010V\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u001eH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010XJ\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u0006072\u0006\u0010Z\u001a\u00020\u001bJ\u0010\u0010[\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\u0006H\u0016J\u0010\u0010]\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\u0006H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fRC\u0010\u0019\u001a(\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001aX\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR7\u0010,\u001a\u001c\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b\u0018\u00010-X\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006038@X\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0006078@X\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>RC\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020@032\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020@038V@VX\u0002¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bB\u00105\"\u0004\bC\u0010D\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006^"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "()V", "_selectableMap", "", "", "Landroidx/compose/foundation/text/selection/Selectable;", "_selectables", "", "afterSelectableUnsubscribe", "Lkotlin/Function1;", "", "getAfterSelectableUnsubscribe$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setAfterSelectableUnsubscribe$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "incrementId", "Ljava/util/concurrent/atomic/AtomicLong;", "Landroidx/compose/foundation/AtomicLong;", "onPositionChangeCallback", "getOnPositionChangeCallback$foundation_release", "setOnPositionChangeCallback$foundation_release", "onSelectableChangeCallback", "getOnSelectableChangeCallback$foundation_release", "setOnSelectableChangeCallback$foundation_release", "onSelectionUpdateCallback", "Lkotlin/Function5;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Offset;", "", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getOnSelectionUpdateCallback$foundation_release", "()Lkotlin/jvm/functions/Function5;", "setOnSelectionUpdateCallback$foundation_release", "(Lkotlin/jvm/functions/Function5;)V", "onSelectionUpdateEndCallback", "Lkotlin/Function0;", "getOnSelectionUpdateEndCallback$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setOnSelectionUpdateEndCallback$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "onSelectionUpdateSelectAll", "getOnSelectionUpdateSelectAll$foundation_release", "setOnSelectionUpdateSelectAll$foundation_release", "onSelectionUpdateStartCallback", "Lkotlin/Function3;", "getOnSelectionUpdateStartCallback$foundation_release", "()Lkotlin/jvm/functions/Function3;", "setOnSelectionUpdateStartCallback$foundation_release", "(Lkotlin/jvm/functions/Function3;)V", "selectableMap", "", "getSelectableMap$foundation_release", "()Ljava/util/Map;", "selectables", "", "getSelectables$foundation_release", "()Ljava/util/List;", "sorted", "getSorted$foundation_release", "()Z", "setSorted$foundation_release", "(Z)V", "<set-?>", "Landroidx/compose/foundation/text/selection/Selection;", "subselections", "getSubselections", "setSubselections", "(Ljava/util/Map;)V", "subselections$delegate", "Landroidx/compose/runtime/MutableState;", "nextSelectableId", "notifyPositionChange", "selectableId", "notifySelectableChange", "notifySelectionUpdate", "layoutCoordinates", "newPosition", "previousPosition", "isStartHandle", "adjustment", "notifySelectionUpdate-5iVPX68", "(Landroidx/compose/ui/layout/LayoutCoordinates;JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "notifySelectionUpdateEnd", "notifySelectionUpdateSelectAll", "notifySelectionUpdateStart", "startPosition", "notifySelectionUpdateStart-d-4ec7I", "(Landroidx/compose/ui/layout/LayoutCoordinates;JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "sort", "containerLayoutCoordinates", "subscribe", "selectable", "unsubscribe", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SelectionRegistrarImpl.kt */
public final class SelectionRegistrarImpl implements SelectionRegistrar {
    private final Map<Long, Selectable> _selectableMap = new LinkedHashMap();
    private final List<Selectable> _selectables = new ArrayList();
    private Function1<? super Long, Unit> afterSelectableUnsubscribe;
    private AtomicLong incrementId = new AtomicLong(1);
    private Function1<? super Long, Unit> onPositionChangeCallback;
    private Function1<? super Long, Unit> onSelectableChangeCallback;
    private Function5<? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> onSelectionUpdateCallback;
    private Function0<Unit> onSelectionUpdateEndCallback;
    private Function1<? super Long, Unit> onSelectionUpdateSelectAll;
    private Function3<? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, Unit> onSelectionUpdateStartCallback;
    private boolean sorted;
    private final MutableState subselections$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), (SnapshotMutationPolicy) null, 2, (Object) null);

    public final boolean getSorted$foundation_release() {
        return this.sorted;
    }

    public final void setSorted$foundation_release(boolean z) {
        this.sorted = z;
    }

    public final List<Selectable> getSelectables$foundation_release() {
        return this._selectables;
    }

    public final Map<Long, Selectable> getSelectableMap$foundation_release() {
        return this._selectableMap;
    }

    public final Function1<Long, Unit> getOnPositionChangeCallback$foundation_release() {
        return this.onPositionChangeCallback;
    }

    public final void setOnPositionChangeCallback$foundation_release(Function1<? super Long, Unit> function1) {
        this.onPositionChangeCallback = function1;
    }

    public final Function3<LayoutCoordinates, Offset, SelectionAdjustment, Unit> getOnSelectionUpdateStartCallback$foundation_release() {
        return this.onSelectionUpdateStartCallback;
    }

    public final void setOnSelectionUpdateStartCallback$foundation_release(Function3<? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, Unit> function3) {
        this.onSelectionUpdateStartCallback = function3;
    }

    public final Function1<Long, Unit> getOnSelectionUpdateSelectAll$foundation_release() {
        return this.onSelectionUpdateSelectAll;
    }

    public final void setOnSelectionUpdateSelectAll$foundation_release(Function1<? super Long, Unit> function1) {
        this.onSelectionUpdateSelectAll = function1;
    }

    public final Function5<LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean> getOnSelectionUpdateCallback$foundation_release() {
        return this.onSelectionUpdateCallback;
    }

    public final void setOnSelectionUpdateCallback$foundation_release(Function5<? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> function5) {
        this.onSelectionUpdateCallback = function5;
    }

    public final Function0<Unit> getOnSelectionUpdateEndCallback$foundation_release() {
        return this.onSelectionUpdateEndCallback;
    }

    public final void setOnSelectionUpdateEndCallback$foundation_release(Function0<Unit> function0) {
        this.onSelectionUpdateEndCallback = function0;
    }

    public final Function1<Long, Unit> getOnSelectableChangeCallback$foundation_release() {
        return this.onSelectableChangeCallback;
    }

    public final void setOnSelectableChangeCallback$foundation_release(Function1<? super Long, Unit> function1) {
        this.onSelectableChangeCallback = function1;
    }

    public final Function1<Long, Unit> getAfterSelectableUnsubscribe$foundation_release() {
        return this.afterSelectableUnsubscribe;
    }

    public final void setAfterSelectableUnsubscribe$foundation_release(Function1<? super Long, Unit> function1) {
        this.afterSelectableUnsubscribe = function1;
    }

    public Map<Long, Selection> getSubselections() {
        return (Map) this.subselections$delegate.getValue();
    }

    public void setSubselections(Map<Long, Selection> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.subselections$delegate.setValue(map);
    }

    public Selectable subscribe(Selectable selectable) {
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        if (!(selectable.getSelectableId() != 0)) {
            throw new IllegalArgumentException(("The selectable contains an invalid id: " + selectable.getSelectableId()).toString());
        } else if (!this._selectableMap.containsKey(Long.valueOf(selectable.getSelectableId()))) {
            this._selectableMap.put(Long.valueOf(selectable.getSelectableId()), selectable);
            this._selectables.add(selectable);
            this.sorted = false;
            return selectable;
        } else {
            throw new IllegalArgumentException(("Another selectable with the id: " + selectable + ".selectableId has already subscribed.").toString());
        }
    }

    public void unsubscribe(Selectable selectable) {
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        if (this._selectableMap.containsKey(Long.valueOf(selectable.getSelectableId()))) {
            this._selectables.remove(selectable);
            this._selectableMap.remove(Long.valueOf(selectable.getSelectableId()));
            Function1<? super Long, Unit> function1 = this.afterSelectableUnsubscribe;
            if (function1 != null) {
                function1.invoke(Long.valueOf(selectable.getSelectableId()));
            }
        }
    }

    public long nextSelectableId() {
        long andIncrement = this.incrementId.getAndIncrement();
        while (andIncrement == 0) {
            andIncrement = this.incrementId.getAndIncrement();
        }
        return andIncrement;
    }

    public final List<Selectable> sort(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "containerLayoutCoordinates");
        if (!this.sorted) {
            CollectionsKt.sortWith(this._selectables, new Comparator() {
                public final int compare(Object obj, Object obj2) {
                    return SelectionRegistrarImpl.m1072sort$lambda2(LayoutCoordinates.this, (Selectable) obj, (Selectable) obj2);
                }
            });
            this.sorted = true;
        }
        return getSelectables$foundation_release();
    }

    /* access modifiers changed from: private */
    /* renamed from: sort$lambda-2  reason: not valid java name */
    public static final int m1072sort$lambda2(LayoutCoordinates layoutCoordinates, Selectable selectable, Selectable selectable2) {
        long j;
        long j2;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "$containerLayoutCoordinates");
        Intrinsics.checkNotNullParameter(selectable, "a");
        Intrinsics.checkNotNullParameter(selectable2, "b");
        LayoutCoordinates layoutCoordinates2 = selectable.getLayoutCoordinates();
        LayoutCoordinates layoutCoordinates3 = selectable2.getLayoutCoordinates();
        if (layoutCoordinates2 != null) {
            j = layoutCoordinates.m3612localPositionOfR5De75A(layoutCoordinates2, Offset.Companion.m1699getZeroF1C5BW0());
        } else {
            j = Offset.Companion.m1699getZeroF1C5BW0();
        }
        if (layoutCoordinates3 != null) {
            j2 = layoutCoordinates.m3612localPositionOfR5De75A(layoutCoordinates3, Offset.Companion.m1699getZeroF1C5BW0());
        } else {
            j2 = Offset.Companion.m1699getZeroF1C5BW0();
        }
        if (Offset.m1684getYimpl(j) == Offset.m1684getYimpl(j2)) {
            return ComparisonsKt.compareValues(Float.valueOf(Offset.m1683getXimpl(j)), Float.valueOf(Offset.m1683getXimpl(j2)));
        }
        return ComparisonsKt.compareValues(Float.valueOf(Offset.m1684getYimpl(j)), Float.valueOf(Offset.m1684getYimpl(j2)));
    }

    public void notifyPositionChange(long j) {
        this.sorted = false;
        Function1<? super Long, Unit> function1 = this.onPositionChangeCallback;
        if (function1 != null) {
            function1.invoke(Long.valueOf(j));
        }
    }

    /* renamed from: notifySelectionUpdateStart-d-4ec7I  reason: not valid java name */
    public void m1074notifySelectionUpdateStartd4ec7I(LayoutCoordinates layoutCoordinates, long j, SelectionAdjustment selectionAdjustment) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        Function3<? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, Unit> function3 = this.onSelectionUpdateStartCallback;
        if (function3 != null) {
            function3.invoke(layoutCoordinates, Offset.m1672boximpl(j), selectionAdjustment);
        }
    }

    public void notifySelectionUpdateSelectAll(long j) {
        Function1<? super Long, Unit> function1 = this.onSelectionUpdateSelectAll;
        if (function1 != null) {
            function1.invoke(Long.valueOf(j));
        }
    }

    /* renamed from: notifySelectionUpdate-5iVPX68  reason: not valid java name */
    public boolean m1073notifySelectionUpdate5iVPX68(LayoutCoordinates layoutCoordinates, long j, long j2, boolean z, SelectionAdjustment selectionAdjustment) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        Function5<? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> function5 = this.onSelectionUpdateCallback;
        if (function5 == null) {
            return true;
        }
        return function5.invoke(layoutCoordinates, Offset.m1672boximpl(j), Offset.m1672boximpl(j2), Boolean.valueOf(z), selectionAdjustment).booleanValue();
    }

    public void notifySelectionUpdateEnd() {
        Function0<Unit> function0 = this.onSelectionUpdateEndCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void notifySelectableChange(long j) {
        Function1<? super Long, Unit> function1 = this.onSelectableChangeCallback;
        if (function1 != null) {
            function1.invoke(Long.valueOf(j));
        }
    }
}
