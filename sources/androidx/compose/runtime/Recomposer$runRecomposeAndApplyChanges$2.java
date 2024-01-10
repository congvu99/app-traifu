package androidx.compose.runtime;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {485, 503}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation<? super Recomposer$runRecomposeAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.this$0, continuation);
        recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
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
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r1 = r20
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0068
            if (r2 == r4) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r2 = r1.L$5
            java.util.Set r2 = (java.util.Set) r2
            java.lang.Object r5 = r1.L$4
            java.util.Set r5 = (java.util.Set) r5
            java.lang.Object r6 = r1.L$3
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r1.L$2
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.L$1
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r1.L$0
            androidx.compose.runtime.MonotonicFrameClock r9 = (androidx.compose.runtime.MonotonicFrameClock) r9
            kotlin.ResultKt.throwOnFailure(r21)
            r10 = r1
            r17 = r9
            r9 = r2
            r2 = r17
            r18 = r8
            r8 = r5
            r5 = r18
            r19 = r7
            r7 = r6
            r6 = r19
            goto L_0x0110
        L_0x003d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0045:
            java.lang.Object r2 = r1.L$5
            java.util.Set r2 = (java.util.Set) r2
            java.lang.Object r5 = r1.L$4
            java.util.Set r5 = (java.util.Set) r5
            java.lang.Object r6 = r1.L$3
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r1.L$2
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.L$1
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r1.L$0
            androidx.compose.runtime.MonotonicFrameClock r9 = (androidx.compose.runtime.MonotonicFrameClock) r9
            kotlin.ResultKt.throwOnFailure(r21)
            r10 = r1
            r11 = r2
            r15 = r5
            r14 = r6
            r13 = r7
            r12 = r8
            r2 = r9
            goto L_0x00ba
        L_0x0068:
            kotlin.ResultKt.throwOnFailure(r21)
            java.lang.Object r2 = r1.L$0
            androidx.compose.runtime.MonotonicFrameClock r2 = (androidx.compose.runtime.MonotonicFrameClock) r2
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet
            r8.<init>()
            java.util.Set r8 = (java.util.Set) r8
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            java.util.Set r9 = (java.util.Set) r9
            r10 = r1
        L_0x0093:
            androidx.compose.runtime.Recomposer r11 = r10.this$0
            boolean r11 = r11.getShouldKeepRecomposing()
            if (r11 == 0) goto L_0x011b
            androidx.compose.runtime.Recomposer r11 = r10.this$0
            r12 = r10
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r10.L$0 = r2
            r10.L$1 = r5
            r10.L$2 = r6
            r10.L$3 = r7
            r10.L$4 = r8
            r10.L$5 = r9
            r10.label = r4
            java.lang.Object r11 = r11.awaitWorkAvailable(r12)
            if (r11 != r0) goto L_0x00b5
            return r0
        L_0x00b5:
            r12 = r5
            r13 = r6
            r14 = r7
            r15 = r8
            r11 = r9
        L_0x00ba:
            androidx.compose.runtime.Recomposer r5 = r10.this$0
            java.lang.Object r5 = r5.stateLock
            androidx.compose.runtime.Recomposer r6 = r10.this$0
            monitor-enter(r5)
            boolean r7 = r6.getHasFrameWorkLocked()     // Catch:{ all -> 0x0118 }
            r8 = 0
            if (r7 != 0) goto L_0x00d4
            r6.recordComposerModificationsLocked()     // Catch:{ all -> 0x0118 }
            boolean r6 = r6.getHasFrameWorkLocked()     // Catch:{ all -> 0x0118 }
            if (r6 != 0) goto L_0x00d4
            r8 = 1
        L_0x00d4:
            monitor-exit(r5)
            if (r8 == 0) goto L_0x00dd
            r9 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            goto L_0x0093
        L_0x00dd:
            androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$2 r16 = new androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$2
            androidx.compose.runtime.Recomposer r6 = r10.this$0
            r5 = r16
            r7 = r12
            r8 = r13
            r9 = r15
            r4 = r10
            r10 = r14
            r21 = r11
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r5 = r16
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r10 = r4
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r4.L$0 = r2
            r4.L$1 = r12
            r4.L$2 = r13
            r4.L$3 = r14
            r4.L$4 = r15
            r9 = r21
            r4.L$5 = r9
            r4.label = r3
            java.lang.Object r5 = r2.withFrameNanos(r5, r10)
            if (r5 != r0) goto L_0x010b
            return r0
        L_0x010b:
            r10 = r4
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
        L_0x0110:
            androidx.compose.runtime.Recomposer r4 = r10.this$0
            r4.discardUnusedValues()
            r4 = 1
            goto L_0x0093
        L_0x0118:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x011b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$clearRecompositionState(List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, Set<ControlledComposition> set, Set<ControlledComposition> set2) {
        list.clear();
        list2.clear();
        list3.clear();
        set.clear();
        set2.clear();
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
        list.clear();
        synchronized (recomposer.stateLock) {
            List access$getCompositionValuesAwaitingInsert$p = recomposer.compositionValuesAwaitingInsert;
            int size = access$getCompositionValuesAwaitingInsert$p.size();
            for (int i = 0; i < size; i++) {
                list.add((MovableContentStateReference) access$getCompositionValuesAwaitingInsert$p.get(i));
            }
            recomposer.compositionValuesAwaitingInsert.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
