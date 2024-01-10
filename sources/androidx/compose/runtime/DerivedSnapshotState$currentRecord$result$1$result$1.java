package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.snapshots.StateObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DerivedState.kt */
final class DerivedSnapshotState$currentRecord$result$1$result$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ int $nestedCalculationLevel;
    final /* synthetic */ IdentityArrayMap<StateObject, Integer> $newDependencies;
    final /* synthetic */ DerivedSnapshotState<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DerivedSnapshotState$currentRecord$result$1$result$1(DerivedSnapshotState<T> derivedSnapshotState, IdentityArrayMap<StateObject, Integer> identityArrayMap, int i) {
        super(1);
        this.this$0 = derivedSnapshotState;
        this.$newDependencies = identityArrayMap;
        this.$nestedCalculationLevel = i;
    }

    public final void invoke(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        if (obj == this.this$0) {
            throw new IllegalStateException("A derived state calculation cannot read itself".toString());
        } else if (obj instanceof StateObject) {
            Object obj2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
            Intrinsics.checkNotNull(obj2);
            int intValue = ((Number) obj2).intValue();
            IdentityArrayMap<StateObject, Integer> identityArrayMap = this.$newDependencies;
            int i = intValue - this.$nestedCalculationLevel;
            Integer num = identityArrayMap.get(obj);
            identityArrayMap.set(obj, Integer.valueOf(Math.min(i, num != null ? num.intValue() : Integer.MAX_VALUE)));
        }
    }
}
