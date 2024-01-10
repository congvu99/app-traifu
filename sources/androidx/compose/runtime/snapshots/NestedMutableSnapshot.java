package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "parent", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "deactivated", "", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "root", "Landroidx/compose/runtime/snapshots/Snapshot;", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "deactivate", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Snapshot.kt */
public final class NestedMutableSnapshot extends MutableSnapshot {
    private boolean deactivated;
    private final MutableSnapshot parent;

    public final MutableSnapshot getParent() {
        return this.parent;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedMutableSnapshot(int i, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12, MutableSnapshot mutableSnapshot) {
        super(i, snapshotIdSet, function1, function12);
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalid");
        Intrinsics.checkNotNullParameter(mutableSnapshot, "parent");
        this.parent = mutableSnapshot;
        mutableSnapshot.nestedActivated$runtime_release(this);
    }

    public Snapshot getRoot() {
        return this.parent.getRoot();
    }

    public void dispose() {
        if (!getDisposed$runtime_release()) {
            super.dispose();
            deactivate();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            r6 = this;
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent
            boolean r0 = r0.getApplied$runtime_release()
            if (r0 != 0) goto L_0x00cf
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent
            boolean r0 = r0.getDisposed$runtime_release()
            if (r0 == 0) goto L_0x0012
            goto L_0x00cf
        L_0x0012:
            java.util.Set r0 = r6.getModified$runtime_release()
            int r1 = r6.getId()
            if (r0 == 0) goto L_0x002a
            androidx.compose.runtime.snapshots.MutableSnapshot r2 = r6.parent
            r3 = r6
            androidx.compose.runtime.snapshots.MutableSnapshot r3 = (androidx.compose.runtime.snapshots.MutableSnapshot) r3
            androidx.compose.runtime.snapshots.SnapshotIdSet r4 = r2.getInvalid$runtime_release()
            java.util.Map r2 = androidx.compose.runtime.snapshots.SnapshotKt.optimisticMerges(r2, r3, r4)
            goto L_0x002b
        L_0x002a:
            r2 = 0
        L_0x002b:
            java.lang.Object r3 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r3)
            r4 = r6
            androidx.compose.runtime.snapshots.Snapshot r4 = (androidx.compose.runtime.snapshots.Snapshot) r4     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.SnapshotKt.validateOpen(r4)     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x0076
            int r4 = r0.size()     // Catch:{ all -> 0x00cc }
            if (r4 != 0) goto L_0x003f
            goto L_0x0076
        L_0x003f:
            androidx.compose.runtime.snapshots.MutableSnapshot r4 = r6.parent     // Catch:{ all -> 0x00cc }
            int r4 = r4.getId()     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.MutableSnapshot r5 = r6.parent     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.SnapshotIdSet r5 = r5.getInvalid$runtime_release()     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.SnapshotApplyResult r2 = r6.innerApplyLocked$runtime_release(r4, r2, r5)     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r4 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE     // Catch:{ all -> 0x00cc }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x00cc }
            if (r4 != 0) goto L_0x0059
            monitor-exit(r3)
            return r2
        L_0x0059:
            androidx.compose.runtime.snapshots.MutableSnapshot r2 = r6.parent     // Catch:{ all -> 0x00cc }
            java.util.Set r2 = r2.getModified$runtime_release()     // Catch:{ all -> 0x00cc }
            if (r2 != 0) goto L_0x0070
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x00cc }
            r2.<init>()     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.MutableSnapshot r4 = r6.parent     // Catch:{ all -> 0x00cc }
            r5 = r2
            java.util.Set r5 = (java.util.Set) r5     // Catch:{ all -> 0x00cc }
            r4.setModified(r5)     // Catch:{ all -> 0x00cc }
            java.util.Set r2 = (java.util.Set) r2     // Catch:{ all -> 0x00cc }
        L_0x0070:
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x00cc }
            r2.addAll(r0)     // Catch:{ all -> 0x00cc }
            goto L_0x0079
        L_0x0076:
            r6.closeAndReleasePinning$runtime_release()     // Catch:{ all -> 0x00cc }
        L_0x0079:
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00cc }
            int r0 = r0.getId()     // Catch:{ all -> 0x00cc }
            if (r0 >= r1) goto L_0x0086
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00cc }
            r0.advance$runtime_release()     // Catch:{ all -> 0x00cc }
        L_0x0086:
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.MutableSnapshot r2 = r6.parent     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.getInvalid$runtime_release()     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.clear(r1)     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.SnapshotIdSet r4 = r6.getPreviousIds$runtime_release()     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.andNot(r4)     // Catch:{ all -> 0x00cc }
            r0.setInvalid$runtime_release(r2)     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00cc }
            r0.recordPrevious$runtime_release(r1)     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00cc }
            int r1 = r6.takeoverPinnedSnapshot$runtime_release()     // Catch:{ all -> 0x00cc }
            r0.recordPreviousPinnedSnapshot$runtime_release(r1)     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.SnapshotIdSet r1 = r6.getPreviousIds$runtime_release()     // Catch:{ all -> 0x00cc }
            r0.recordPreviousList$runtime_release(r1)     // Catch:{ all -> 0x00cc }
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00cc }
            int[] r1 = r6.getPreviousPinnedSnapshots$runtime_release()     // Catch:{ all -> 0x00cc }
            r0.recordPreviousPinnedSnapshots$runtime_release(r1)     // Catch:{ all -> 0x00cc }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00cc }
            monitor-exit(r3)
            r0 = 1
            r6.setApplied$runtime_release(r0)
            r6.deactivate()
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r0 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE
            androidx.compose.runtime.snapshots.SnapshotApplyResult r0 = (androidx.compose.runtime.snapshots.SnapshotApplyResult) r0
            return r0
        L_0x00cc:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x00cf:
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure r0 = new androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure
            r1 = r6
            androidx.compose.runtime.snapshots.Snapshot r1 = (androidx.compose.runtime.snapshots.Snapshot) r1
            r0.<init>(r1)
            androidx.compose.runtime.snapshots.SnapshotApplyResult r0 = (androidx.compose.runtime.snapshots.SnapshotApplyResult) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.NestedMutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    private final void deactivate() {
        if (!this.deactivated) {
            this.deactivated = true;
            this.parent.nestedDeactivated$runtime_release(this);
        }
    }
}
