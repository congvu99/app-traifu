package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "applied", "", "", "<anonymous parameter 1>", "Landroidx/compose/runtime/snapshots/Snapshot;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SnapshotStateObserver.kt */
final class SnapshotStateObserver$applyObserver$1 extends Lambda implements Function2<Set<? extends Object>, Snapshot, Unit> {
    final /* synthetic */ SnapshotStateObserver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotStateObserver$applyObserver$1(SnapshotStateObserver snapshotStateObserver) {
        super(2);
        this.this$0 = snapshotStateObserver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Set<? extends Object>) (Set) obj, (Snapshot) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Set<? extends Object> set, Snapshot snapshot) {
        boolean z;
        Intrinsics.checkNotNullParameter(set, "applied");
        Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
        SnapshotStateObserver snapshotStateObserver = this.this$0;
        synchronized (snapshotStateObserver.observedScopeMaps) {
            MutableVector access$getObservedScopeMaps$p = snapshotStateObserver.observedScopeMaps;
            int size = access$getObservedScopeMaps$p.getSize();
            z = false;
            if (size > 0) {
                Object[] content = access$getObservedScopeMaps$p.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                int i = 0;
                boolean z2 = false;
                do {
                    if (!((SnapshotStateObserver.ObservedScopeMap) content[i]).recordInvalidation(set)) {
                        if (!z2) {
                            z2 = false;
                            i++;
                        }
                    }
                    z2 = true;
                    i++;
                } while (i < size);
                z = z2;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            Function1 access$getOnChangedExecutor$p = this.this$0.onChangedExecutor;
            final SnapshotStateObserver snapshotStateObserver2 = this.this$0;
            access$getOnChangedExecutor$p.invoke(new Function0<Unit>() {
                public final void invoke() {
                    SnapshotStateObserver snapshotStateObserver = snapshotStateObserver2;
                    synchronized (snapshotStateObserver.observedScopeMaps) {
                        MutableVector access$getObservedScopeMaps$p = snapshotStateObserver.observedScopeMaps;
                        int size = access$getObservedScopeMaps$p.getSize();
                        if (size > 0) {
                            int i = 0;
                            Object[] content = access$getObservedScopeMaps$p.getContent();
                            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                            do {
                                ((SnapshotStateObserver.ObservedScopeMap) content[i]).notifyInvalidatedScopes();
                                i++;
                            } while (i < size);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            });
        }
    }
}
