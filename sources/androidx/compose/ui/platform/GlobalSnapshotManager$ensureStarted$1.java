package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.android.kt", i = {0}, l = {63}, m = "invokeSuspend", n = {"$this$consume$iv$iv"}, s = {"L$0"})
/* compiled from: GlobalSnapshotManager.android.kt */
final class GlobalSnapshotManager$ensureStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Unit> $channel;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalSnapshotManager$ensureStarted$1(Channel<Unit> channel, Continuation<? super GlobalSnapshotManager$ensureStarted$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalSnapshotManager$ensureStarted$1(this.$channel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlobalSnapshotManager$ensureStarted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d A[Catch:{ all -> 0x0063 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r3 = r7.L$0
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0066 }
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r7
            goto L_0x0044
        L_0x001b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r8 = r7.$channel
            r3 = r8
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            kotlinx.coroutines.channels.ChannelIterator r8 = r3.iterator()     // Catch:{ all -> 0x0066 }
            r1 = r8
            r8 = r7
        L_0x0031:
            r8.L$0 = r3     // Catch:{ all -> 0x0066 }
            r8.L$1 = r1     // Catch:{ all -> 0x0066 }
            r8.label = r2     // Catch:{ all -> 0x0066 }
            java.lang.Object r4 = r1.hasNext(r8)     // Catch:{ all -> 0x0066 }
            if (r4 != r0) goto L_0x003e
            return r0
        L_0x003e:
            r6 = r0
            r0 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r6
        L_0x0044:
            r5 = 0
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0063 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0063 }
            if (r8 == 0) goto L_0x005d
            java.lang.Object r8 = r3.next()     // Catch:{ all -> 0x0063 }
            kotlin.Unit r8 = (kotlin.Unit) r8     // Catch:{ all -> 0x0063 }
            androidx.compose.runtime.snapshots.Snapshot$Companion r8 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0063 }
            r8.sendApplyNotifications()     // Catch:{ all -> 0x0063 }
            r8 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L_0x0031
        L_0x005d:
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r5)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0063:
            r8 = move-exception
            r3 = r4
            goto L_0x0067
        L_0x0066:
            r8 = move-exception
        L_0x0067:
            throw r8     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r3, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
