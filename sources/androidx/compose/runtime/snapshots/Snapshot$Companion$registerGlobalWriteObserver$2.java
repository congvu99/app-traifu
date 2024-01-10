package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Snapshot.kt */
final class Snapshot$Companion$registerGlobalWriteObserver$2 implements ObserverHandle {
    final /* synthetic */ Function1<Object, Unit> $observer;

    Snapshot$Companion$registerGlobalWriteObserver$2(Function1<Object, Unit> function1) {
        this.$observer = function1;
    }

    public final void dispose() {
        Function1<Object, Unit> function1 = this.$observer;
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.globalWriteObservers.remove(function1);
        }
        SnapshotKt.advanceGlobalSnapshot();
    }
}
