package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SnapshotStateObserver.kt */
final class SnapshotStateObserver$observeReads$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $block;
    final /* synthetic */ SnapshotStateObserver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotStateObserver$observeReads$1$1(SnapshotStateObserver snapshotStateObserver, Function0<Unit> function0) {
        super(0);
        this.this$0 = snapshotStateObserver;
        this.$block = function0;
    }

    public final void invoke() {
        Snapshot.Companion.observe(this.this$0.readObserver, (Function1<Object, Unit>) null, this.$block);
    }
}
