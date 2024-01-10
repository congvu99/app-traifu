package com.anggrayudi.storage.extension;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1", f = "CoroutineExt.kt", i = {}, l = {16, 24}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CoroutineExt.kt */
final class CoroutineExtKt$startCoroutineTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $action;
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $repeatMillis;
    final /* synthetic */ boolean $runActionOnUiThread;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineExtKt$startCoroutineTimer$1(long j, long j2, boolean z, Function0<Unit> function0, Continuation<? super CoroutineExtKt$startCoroutineTimer$1> continuation) {
        super(2, continuation);
        this.$delayMillis = j;
        this.$repeatMillis = j2;
        this.$runActionOnUiThread = z;
        this.$action = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineExtKt$startCoroutineTimer$1(this.$delayMillis, this.$repeatMillis, this.$runActionOnUiThread, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineExtKt$startCoroutineTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 == r4) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0038
        L_0x0013:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0030
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r9)
            long r5 = r8.$delayMillis
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.label = r4
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r5, r9)
            if (r9 != r0) goto L_0x0030
            return r0
        L_0x0030:
            long r4 = r8.$repeatMillis
            r6 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x005d
        L_0x0038:
            r9 = r8
        L_0x0039:
            boolean r1 = r9.$runActionOnUiThread
            if (r1 == 0) goto L_0x004a
            com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$1 r1 = new com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$1
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r9.$action
            r1.<init>(r4, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            com.anggrayudi.storage.extension.CoroutineExtKt.launchOnUiThread(r1)
            goto L_0x004f
        L_0x004a:
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r9.$action
            r1.invoke()
        L_0x004f:
            long r4 = r9.$repeatMillis
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r9.label = r3
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r4, r1)
            if (r1 != r0) goto L_0x0039
            return r0
        L_0x005d:
            boolean r9 = r8.$runActionOnUiThread
            if (r9 == 0) goto L_0x006e
            com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$2 r9 = new com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$2
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r8.$action
            r9.<init>(r0, r2)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            com.anggrayudi.storage.extension.CoroutineExtKt.launchOnUiThread(r9)
            goto L_0x0073
        L_0x006e:
            kotlin.jvm.functions.Function0<kotlin.Unit> r9 = r8.$action
            r9.invoke()
        L_0x0073:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
