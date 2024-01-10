package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 1}, l = {730, 750, 751}, m = "invokeSuspend", n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.$recomposeCoroutineContext = coroutineContext;
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(this.$recomposeCoroutineContext, this.this$0, continuation);
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = coroutineScope;
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = monotonicFrameClock;
        return recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 3
            r4 = 2
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 == r7) goto L_0x002c
            if (r2 == r4) goto L_0x0021
            if (r2 != r3) goto L_0x0019
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x01a8
        L_0x0019:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0021:
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            kotlin.ResultKt.throwOnFailure(r20)
            r10 = r1
            r5 = r6
            goto L_0x0199
        L_0x002c:
            java.lang.Object r2 = r1.L$2
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r8 = r1.L$1
            androidx.compose.runtime.ProduceFrameSignal r8 = (androidx.compose.runtime.ProduceFrameSignal) r8
            java.lang.Object r9 = r1.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r20)
            r14 = r1
            r15 = r9
            goto L_0x00b5
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r1.L$0
            r8 = r2
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            java.lang.Object r2 = r1.L$1
            androidx.compose.runtime.MonotonicFrameClock r2 = (androidx.compose.runtime.MonotonicFrameClock) r2
            kotlin.coroutines.CoroutineContext r9 = r1.$recomposeCoroutineContext
            kotlinx.coroutines.Job$Key r10 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r10 = (kotlin.coroutines.CoroutineContext.Key) r10
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r10)
            if (r9 != 0) goto L_0x0059
            r9 = 1
            goto L_0x005a
        L_0x0059:
            r9 = 0
        L_0x005a:
            kotlin.coroutines.CoroutineContext r10 = r1.$recomposeCoroutineContext
            if (r9 == 0) goto L_0x01ab
            kotlin.coroutines.CoroutineContext r9 = r8.getCoroutineContext()
            kotlin.coroutines.CoroutineContext r10 = r1.$recomposeCoroutineContext
            kotlin.coroutines.CoroutineContext r9 = r9.plus(r10)
            kotlin.coroutines.CoroutineContext r10 = r8.getCoroutineContext()
            kotlinx.coroutines.Job r10 = kotlinx.coroutines.JobKt.getJob(r10)
            kotlinx.coroutines.CompletableJob r10 = kotlinx.coroutines.JobKt.Job((kotlinx.coroutines.Job) r10)
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            kotlin.coroutines.CoroutineContext r9 = r9.plus(r10)
            kotlinx.coroutines.CoroutineScope r14 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r9)
            androidx.compose.runtime.ProduceFrameSignal r15 = new androidx.compose.runtime.ProduceFrameSignal
            r15.<init>()
            r9 = 0
            r10 = 0
            androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1 r11 = new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1
            androidx.compose.runtime.Recomposer r12 = r1.this$0
            r11.<init>(r12, r2, r15, r6)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r12 = 3
            r13 = 0
            kotlinx.coroutines.Job r2 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r8, r9, r10, r11, r12, r13)
            r10 = r1
            r9 = r14
            r8 = r15
        L_0x0097:
            androidx.compose.runtime.Recomposer r11 = r10.this$0
            boolean r11 = r11.getShouldKeepRecomposing()
            if (r11 == 0) goto L_0x017d
            androidx.compose.runtime.Recomposer r11 = r10.this$0
            r12 = r10
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r10.L$0 = r9
            r10.L$1 = r8
            r10.L$2 = r2
            r10.label = r7
            java.lang.Object r11 = r11.awaitWorkAvailable(r12)
            if (r11 != r0) goto L_0x00b3
            return r0
        L_0x00b3:
            r15 = r9
            r14 = r10
        L_0x00b5:
            androidx.compose.runtime.Recomposer r9 = r14.this$0
            java.lang.Object r16 = r9.stateLock
            androidx.compose.runtime.Recomposer r13 = r14.this$0
            monitor-enter(r16)
            java.util.List r9 = r13.snapshotInvalidations     // Catch:{ all -> 0x017a }
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ all -> 0x017a }
            boolean r9 = r9.isEmpty()     // Catch:{ all -> 0x017a }
            r9 = r9 ^ r7
            if (r9 == 0) goto L_0x0103
            java.util.List r9 = r13.snapshotInvalidations     // Catch:{ all -> 0x017a }
            int r10 = r9.size()     // Catch:{ all -> 0x017a }
            r11 = 0
        L_0x00d4:
            if (r11 >= r10) goto L_0x00fc
            java.lang.Object r12 = r9.get(r11)     // Catch:{ all -> 0x017a }
            java.util.Set r12 = (java.util.Set) r12     // Catch:{ all -> 0x017a }
            java.util.List r5 = r13.knownCompositions     // Catch:{ all -> 0x017a }
            int r3 = r5.size()     // Catch:{ all -> 0x017a }
            r4 = 0
        L_0x00e5:
            if (r4 >= r3) goto L_0x00f6
            java.lang.Object r17 = r5.get(r4)     // Catch:{ all -> 0x017a }
            r6 = r17
            androidx.compose.runtime.ControlledComposition r6 = (androidx.compose.runtime.ControlledComposition) r6     // Catch:{ all -> 0x017a }
            r6.recordModificationsOf(r12)     // Catch:{ all -> 0x017a }
            int r4 = r4 + 1
            r6 = 0
            goto L_0x00e5
        L_0x00f6:
            int r11 = r11 + 1
            r3 = 3
            r4 = 2
            r6 = 0
            goto L_0x00d4
        L_0x00fc:
            java.util.List r3 = r13.snapshotInvalidations     // Catch:{ all -> 0x017a }
            r3.clear()     // Catch:{ all -> 0x017a }
        L_0x0103:
            java.util.List r3 = r13.compositionInvalidations     // Catch:{ all -> 0x017a }
            int r4 = r3.size()     // Catch:{ all -> 0x017a }
            r5 = 0
        L_0x010c:
            if (r5 >= r4) goto L_0x013d
            java.lang.Object r6 = r3.get(r5)     // Catch:{ all -> 0x017a }
            androidx.compose.runtime.ControlledComposition r6 = (androidx.compose.runtime.ControlledComposition) r6     // Catch:{ all -> 0x017a }
            int r9 = r13.concurrentCompositionsOutstanding     // Catch:{ all -> 0x017a }
            int r9 = r9 + r7
            r13.concurrentCompositionsOutstanding = r9     // Catch:{ all -> 0x017a }
            kotlin.coroutines.CoroutineContext r10 = androidx.compose.runtime.CompositionKt.getRecomposeCoroutineContext(r6)     // Catch:{ all -> 0x017a }
            r11 = 0
            androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1 r9 = new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1     // Catch:{ all -> 0x017a }
            r12 = 0
            r9.<init>(r13, r6, r12)     // Catch:{ all -> 0x017a }
            r12 = r9
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12     // Catch:{ all -> 0x017a }
            r6 = 2
            r17 = 0
            r9 = r15
            r18 = r13
            r13 = r6
            r6 = r14
            r14 = r17
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x017a }
            int r5 = r5 + 1
            r14 = r6
            r13 = r18
            goto L_0x010c
        L_0x013d:
            r18 = r13
            r6 = r14
            java.util.List r3 = r18.compositionInvalidations     // Catch:{ all -> 0x017a }
            r3.clear()     // Catch:{ all -> 0x017a }
            kotlinx.coroutines.CancellableContinuation r3 = r18.deriveStateLocked()     // Catch:{ all -> 0x017a }
            if (r3 != 0) goto L_0x016e
            boolean r3 = r18.getHasConcurrentFrameWorkLocked()     // Catch:{ all -> 0x017a }
            if (r3 == 0) goto L_0x0158
            kotlin.coroutines.Continuation r12 = r8.requestFrameLocked()     // Catch:{ all -> 0x017a }
            goto L_0x0159
        L_0x0158:
            r12 = 0
        L_0x0159:
            monitor-exit(r16)
            if (r12 == 0) goto L_0x0167
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            java.lang.Object r3 = kotlin.Result.m5428constructorimpl(r3)
            r12.resumeWith(r3)
        L_0x0167:
            r10 = r6
            r9 = r15
            r3 = 3
            r4 = 2
            r6 = 0
            goto L_0x0097
        L_0x016e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x017a }
            java.lang.String r2 = "called outside of runRecomposeAndApplyChanges"
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x017a }
            r0.<init>(r2)     // Catch:{ all -> 0x017a }
            throw r0     // Catch:{ all -> 0x017a }
        L_0x017a:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        L_0x017d:
            kotlin.coroutines.CoroutineContext r3 = r9.getCoroutineContext()
            kotlinx.coroutines.Job r3 = kotlinx.coroutines.JobKt.getJob(r3)
            r4 = r10
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r10.L$0 = r2
            r5 = 0
            r10.L$1 = r5
            r10.L$2 = r5
            r6 = 2
            r10.label = r6
            java.lang.Object r3 = kotlinx.coroutines.JobKt.cancelAndJoin(r3, r4)
            if (r3 != r0) goto L_0x0199
            return r0
        L_0x0199:
            r3 = r10
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r10.L$0 = r5
            r4 = 3
            r10.label = r4
            java.lang.Object r2 = kotlinx.coroutines.JobKt.cancelAndJoin(r2, r3)
            if (r2 != r0) goto L_0x01a8
            return r0
        L_0x01a8:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01ab:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "recomposeCoroutineContext may not contain a Job; found "
            r0.append(r2)
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2
            kotlin.coroutines.CoroutineContext$Element r2 = r10.get(r2)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
