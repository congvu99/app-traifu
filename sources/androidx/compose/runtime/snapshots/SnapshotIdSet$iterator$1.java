package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", i = {0, 0, 1, 1, 2, 2}, l = {295, 300, 307}, m = "invokeSuspend", n = {"$this$sequence", "belowBound", "$this$sequence", "index", "$this$sequence", "index"}, s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
/* compiled from: SnapshotIdSet.kt */
final class SnapshotIdSet$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SnapshotIdSet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotIdSet$iterator$1(SnapshotIdSet snapshotIdSet, Continuation<? super SnapshotIdSet$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = snapshotIdSet;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1 = new SnapshotIdSet$iterator$1(this.this$0, continuation);
        snapshotIdSet$iterator$1.L$0 = obj;
        return snapshotIdSet$iterator$1;
    }

    public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SnapshotIdSet$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            r6 = 3
            r7 = 2
            r8 = 64
            r10 = 0
            r12 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r12) goto L_0x003c
            if (r2 == r7) goto L_0x0030
            if (r2 != r6) goto L_0x0028
            int r2 = r0.I$0
            java.lang.Object r7 = r0.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlin.ResultKt.throwOnFailure(r19)
            r9 = r2
            r14 = 3
            r2 = r0
            goto L_0x00ff
        L_0x0028:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0030:
            int r2 = r0.I$0
            java.lang.Object r13 = r0.L$0
            kotlin.sequences.SequenceScope r13 = (kotlin.sequences.SequenceScope) r13
            kotlin.ResultKt.throwOnFailure(r19)
            r9 = r0
            goto L_0x00be
        L_0x003c:
            int r2 = r0.I$1
            int r13 = r0.I$0
            java.lang.Object r14 = r0.L$1
            int[] r14 = (int[]) r14
            java.lang.Object r15 = r0.L$0
            kotlin.sequences.SequenceScope r15 = (kotlin.sequences.SequenceScope) r15
            kotlin.ResultKt.throwOnFailure(r19)
            r9 = r0
            goto L_0x007e
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r19)
            java.lang.Object r2 = r0.L$0
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            androidx.compose.runtime.snapshots.SnapshotIdSet r13 = r0.this$0
            int[] r13 = r13.belowBound
            if (r13 == 0) goto L_0x0084
            int r14 = r13.length
            r9 = r0
            r15 = r2
            r2 = r14
            r14 = r13
            r13 = 0
        L_0x0062:
            if (r13 >= r2) goto L_0x0082
            r17 = r14[r13]
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            r7 = r9
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r9.L$0 = r15
            r9.L$1 = r14
            r9.I$0 = r13
            r9.I$1 = r2
            r9.label = r12
            java.lang.Object r6 = r15.yield(r6, r7)
            if (r6 != r1) goto L_0x007e
            return r1
        L_0x007e:
            int r13 = r13 + r12
            r6 = 3
            r7 = 2
            goto L_0x0062
        L_0x0082:
            r2 = r15
            goto L_0x0085
        L_0x0084:
            r9 = r0
        L_0x0085:
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r9.this$0
            long r6 = r6.lowerSet
            int r13 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r13 == 0) goto L_0x00c2
            r13 = r2
            r2 = 0
        L_0x0091:
            if (r2 >= r8) goto L_0x00c1
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r9.this$0
            long r6 = r6.lowerSet
            long r14 = r4 << r2
            long r6 = r6 & r14
            int r14 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r14 == 0) goto L_0x00be
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r9.this$0
            int r6 = r6.lowerBound
            int r6 = r6 + r2
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            r7 = r9
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r9.L$0 = r13
            r9.L$1 = r3
            r9.I$0 = r2
            r14 = 2
            r9.label = r14
            java.lang.Object r6 = r13.yield(r6, r7)
            if (r6 != r1) goto L_0x00bf
            return r1
        L_0x00be:
            r14 = 2
        L_0x00bf:
            int r2 = r2 + r12
            goto L_0x0091
        L_0x00c1:
            r2 = r13
        L_0x00c2:
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r9.this$0
            long r6 = r6.upperSet
            int r13 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r13 == 0) goto L_0x0101
            r7 = r2
            r2 = r9
            r9 = 0
        L_0x00cf:
            if (r9 >= r8) goto L_0x0101
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r2.this$0
            long r13 = r6.upperSet
            long r15 = r4 << r9
            long r13 = r13 & r15
            int r6 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x00fe
            int r6 = r9 + 64
            androidx.compose.runtime.snapshots.SnapshotIdSet r13 = r2.this$0
            int r13 = r13.lowerBound
            int r6 = r6 + r13
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            r13 = r2
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r2.L$0 = r7
            r2.L$1 = r3
            r2.I$0 = r9
            r14 = 3
            r2.label = r14
            java.lang.Object r6 = r7.yield(r6, r13)
            if (r6 != r1) goto L_0x00ff
            return r1
        L_0x00fe:
            r14 = 3
        L_0x00ff:
            int r9 = r9 + r12
            goto L_0x00cf
        L_0x0101:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
