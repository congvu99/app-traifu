package androidx.compose.runtime.snapshots;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Snapshot.kt */
final class Snapshot$Companion$registerApplyObserver$2 implements ObserverHandle {
    final /* synthetic */ Function2<Set<? extends Object>, Snapshot, Unit> $observer;

    Snapshot$Companion$registerApplyObserver$2(Function2<? super Set<? extends Object>, ? super Snapshot, Unit> function2) {
        this.$observer = function2;
    }

    public final void dispose() {
        Function2<Set<? extends Object>, Snapshot, Unit> function2 = this.$observer;
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.applyObservers.remove(function2);
            Unit unit = Unit.INSTANCE;
        }
    }
}
