package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.json.internal.JsonLexerKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J \u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0012H\bø\u0001\u0000J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", "clear", "bit", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SnapshotIdSet.kt */
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, (int[]) null);
    /* access modifiers changed from: private */
    public final int[] belowBound;
    /* access modifiers changed from: private */
    public final int lowerBound;
    /* access modifiers changed from: private */
    public final long lowerSet;
    /* access modifiers changed from: private */
    public final long upperSet;

    private SnapshotIdSet(long j, long j2, int i, int[] iArr) {
        this.upperSet = j;
        this.lowerSet = j2;
        this.lowerBound = i;
        this.belowBound = iArr;
    }

    public final boolean get(int i) {
        int[] iArr;
        int i2 = i - this.lowerBound;
        boolean z = true;
        if (i2 < 0 || i2 >= 64) {
            if (i2 < 64 || i2 >= 128) {
                if (i2 > 0 || (iArr = this.belowBound) == null) {
                    return false;
                }
                if (SnapshotIdSetKt.binarySearch(iArr, i) < 0) {
                    z = false;
                }
                return z;
            } else if (((1 << (i2 - 64)) & this.upperSet) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (((1 << i2) & this.lowerSet) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final SnapshotIdSet set(int i) {
        int i2;
        long j;
        int[] iArr;
        int i3 = i;
        int i4 = i3 - this.lowerBound;
        if (i4 >= 0 && i4 < 64) {
            long j2 = 1 << i4;
            if ((this.lowerSet & j2) == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet | j2, this.lowerBound, this.belowBound);
            }
        } else if (i4 >= 64 && i4 < 128) {
            long j3 = 1 << (i4 - 64);
            if ((this.upperSet & j3) == 0) {
                return new SnapshotIdSet(this.upperSet | j3, this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (i4 < 128) {
            int[] iArr2 = this.belowBound;
            if (iArr2 == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, new int[]{i3});
            }
            int binarySearch = SnapshotIdSetKt.binarySearch(iArr2, i3);
            if (binarySearch < 0) {
                int i5 = -(binarySearch + 1);
                int length = iArr2.length + 1;
                int[] iArr3 = new int[length];
                ArraysKt.copyInto(iArr2, iArr3, 0, 0, i5);
                ArraysKt.copyInto(iArr2, iArr3, i5 + 1, i5, length - 1);
                iArr3[i5] = i3;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr3);
            }
        } else if (!get(i)) {
            long j4 = this.upperSet;
            long j5 = this.lowerSet;
            int i6 = this.lowerBound;
            List list = null;
            int i7 = ((i3 + 1) / 64) * 64;
            long j6 = j4;
            while (true) {
                if (i6 >= i7) {
                    i2 = i6;
                    j = j5;
                    break;
                }
                if (j5 != 0) {
                    if (list == null) {
                        list = new ArrayList();
                        int[] iArr4 = this.belowBound;
                        if (iArr4 != null) {
                            for (int valueOf : iArr4) {
                                list.add(Integer.valueOf(valueOf));
                            }
                        }
                    }
                    for (int i8 = 0; i8 < 64; i8++) {
                        if (((1 << i8) & j5) != 0) {
                            list.add(Integer.valueOf(i8 + i6));
                        }
                    }
                }
                if (j6 == 0) {
                    j = 0;
                    i2 = i7;
                    break;
                }
                i6 += 64;
                j5 = j6;
                j6 = 0;
            }
            if (list == null || (iArr = CollectionsKt.toIntArray(list)) == null) {
                iArr = this.belowBound;
            }
            return new SnapshotIdSet(j6, j, i2, iArr).set(i3);
        }
        return this;
    }

    public final SnapshotIdSet clear(int i) {
        int[] iArr;
        int binarySearch;
        int i2 = i;
        int i3 = i2 - this.lowerBound;
        if (i3 >= 0 && i3 < 64) {
            long j = 1 << i3;
            if ((this.lowerSet & j) != 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet & (~j), this.lowerBound, this.belowBound);
            }
        } else if (i3 >= 64 && i3 < 128) {
            long j2 = 1 << (i3 - 64);
            if ((this.upperSet & j2) != 0) {
                return new SnapshotIdSet(this.upperSet & (~j2), this.lowerSet, this.lowerBound, this.belowBound);
            }
        } else if (i3 < 0 && (iArr = this.belowBound) != null && (binarySearch = SnapshotIdSetKt.binarySearch(iArr, i2)) >= 0) {
            int length = iArr.length - 1;
            if (length == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, (int[]) null);
            }
            int[] iArr2 = new int[length];
            if (binarySearch > 0) {
                ArraysKt.copyInto(iArr, iArr2, 0, 0, binarySearch);
            }
            if (binarySearch < length) {
                ArraysKt.copyInto(iArr, iArr2, binarySearch, binarySearch + 1, length + 1);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr2);
        }
        return this;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "bits");
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (snapshotIdSet == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet2;
        }
        if (snapshotIdSet.lowerBound == this.lowerBound && snapshotIdSet.belowBound == this.belowBound) {
            return new SnapshotIdSet((~snapshotIdSet.upperSet) & this.upperSet, (~snapshotIdSet.lowerSet) & this.lowerSet, this.lowerBound, this.belowBound);
        }
        Iterator it = snapshotIdSet.iterator();
        SnapshotIdSet snapshotIdSet3 = this;
        while (it.hasNext()) {
            snapshotIdSet3 = snapshotIdSet3.clear(((Number) it.next()).intValue());
        }
        return snapshotIdSet3;
    }

    public final SnapshotIdSet and(SnapshotIdSet snapshotIdSet) {
        int[] iArr;
        Intrinsics.checkNotNullParameter(snapshotIdSet, "bits");
        if (Intrinsics.areEqual((Object) snapshotIdSet, (Object) EMPTY)) {
            return EMPTY;
        }
        if (Intrinsics.areEqual((Object) this, (Object) EMPTY)) {
            return EMPTY;
        }
        if (snapshotIdSet.lowerBound == this.lowerBound && snapshotIdSet.belowBound == (iArr = this.belowBound)) {
            long j = this.upperSet & snapshotIdSet.upperSet;
            long j2 = this.lowerSet & snapshotIdSet.lowerSet;
            if (j == 0 && j2 == 0 && iArr == null) {
                return EMPTY;
            }
            return new SnapshotIdSet(this.upperSet & snapshotIdSet.upperSet, this.lowerSet & snapshotIdSet.lowerSet, this.lowerBound, this.belowBound);
        } else if (this.belowBound == null) {
            SnapshotIdSet snapshotIdSet2 = EMPTY;
            Iterator it = iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                if (snapshotIdSet.get(intValue)) {
                    snapshotIdSet2 = snapshotIdSet2.set(intValue);
                }
            }
            return snapshotIdSet2;
        } else {
            SnapshotIdSet snapshotIdSet3 = EMPTY;
            Iterator it2 = snapshotIdSet.iterator();
            while (it2.hasNext()) {
                int intValue2 = ((Number) it2.next()).intValue();
                if (get(intValue2)) {
                    snapshotIdSet3 = snapshotIdSet3.set(intValue2);
                }
            }
            return snapshotIdSet3;
        }
    }

    public final SnapshotIdSet or(SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "bits");
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (snapshotIdSet == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet;
        }
        if (snapshotIdSet.lowerBound == this.lowerBound && snapshotIdSet.belowBound == this.belowBound) {
            return new SnapshotIdSet(snapshotIdSet.upperSet | this.upperSet, snapshotIdSet.lowerSet | this.lowerSet, this.lowerBound, this.belowBound);
        } else if (this.belowBound == null) {
            Iterator it = iterator();
            while (it.hasNext()) {
                snapshotIdSet = snapshotIdSet.set(((Number) it.next()).intValue());
            }
            return snapshotIdSet;
        } else {
            Iterator it2 = snapshotIdSet.iterator();
            SnapshotIdSet snapshotIdSet3 = this;
            while (it2.hasNext()) {
                snapshotIdSet3 = snapshotIdSet3.set(((Number) it2.next()).intValue());
            }
            return snapshotIdSet3;
        }
    }

    public Iterator<Integer> iterator() {
        return SequencesKt.sequence(new SnapshotIdSet$iterator$1(this, (Continuation<? super SnapshotIdSet$iterator$1>) null)).iterator();
    }

    public final void fastForEach(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        int[] access$getBelowBound$p = this.belowBound;
        if (access$getBelowBound$p != null) {
            for (int valueOf : access$getBelowBound$p) {
                function1.invoke(Integer.valueOf(valueOf));
            }
        }
        if (this.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((this.lowerSet & (1 << i)) != 0) {
                    function1.invoke(Integer.valueOf(this.lowerBound + i));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((this.upperSet & (1 << i2)) != 0) {
                    function1.invoke(Integer.valueOf(i2 + 64 + this.lowerBound));
                }
            }
        }
    }

    public final int lowest(int i) {
        int[] iArr = this.belowBound;
        if (iArr != null) {
            return iArr[0];
        }
        long j = this.lowerSet;
        if (j != 0) {
            return this.lowerBound + SnapshotIdSetKt.lowestBitOf(j);
        }
        long j2 = this.upperSet;
        return j2 != 0 ? this.lowerBound + 64 + SnapshotIdSetKt.lowestBitOf(j2) : i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        Iterable<Number> iterable = this;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Number intValue : iterable) {
            arrayList.add(String.valueOf(intValue.intValue()));
        }
        sb.append(ListUtilsKt.fastJoinToString$default((List) arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        sb.append(JsonLexerKt.END_LIST);
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SnapshotIdSet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }
}
