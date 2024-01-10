package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/runtime/State;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SnapshotStateObserver.kt */
final class SnapshotStateObserver$ObservedScopeMap$derivedStateEnterObserver$1 extends Lambda implements Function1<State<?>, Unit> {
    final /* synthetic */ SnapshotStateObserver.ObservedScopeMap this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotStateObserver$ObservedScopeMap$derivedStateEnterObserver$1(SnapshotStateObserver.ObservedScopeMap observedScopeMap) {
        super(1);
        this.this$0 = observedScopeMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State<?>) (State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(State<?> state) {
        Intrinsics.checkNotNullParameter(state, "it");
        SnapshotStateObserver.ObservedScopeMap observedScopeMap = this.this$0;
        observedScopeMap.deriveStateScopeCount = observedScopeMap.deriveStateScopeCount + 1;
    }
}
