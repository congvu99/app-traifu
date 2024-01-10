package androidx.compose.ui.viewinterop;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
final class AndroidViewHolder$runUpdate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$runUpdate$1(AndroidViewHolder androidViewHolder) {
        super(0);
        this.this$0 = androidViewHolder;
    }

    public final void invoke() {
        if (this.this$0.hasUpdateBlock) {
            SnapshotStateObserver access$getSnapshotObserver$p = this.this$0.snapshotObserver;
            AndroidViewHolder androidViewHolder = this.this$0;
            access$getSnapshotObserver$p.observeReads(androidViewHolder, androidViewHolder.onCommitAffectingUpdate, this.this$0.getUpdate());
        }
    }
}
