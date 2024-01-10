package com.anggrayudi.storage.extension;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "com.anggrayudi.storage.extension.CoroutineExtKt$awaitUiResult$1$1$1", f = "CoroutineExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CoroutineExt.kt */
public final class CoroutineExtKt$awaitUiResult$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<R> $action;
    final /* synthetic */ CancellableContinuation<R> $it;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineExtKt$awaitUiResult$1$1$1(CancellableContinuation<? super R> cancellableContinuation, Function0<? extends R> function0, Continuation<? super CoroutineExtKt$awaitUiResult$1$1$1> continuation) {
        super(2, continuation);
        this.$it = cancellableContinuation;
        this.$action = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineExtKt$awaitUiResult$1$1$1(this.$it, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineExtKt$awaitUiResult$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CancellableContinuation<R> cancellableContinuation = this.$it;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m5428constructorimpl(this.$action.invoke()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        CancellableContinuation<R> cancellableContinuation = this.$it;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m5428constructorimpl(this.$action.invoke()));
        return Unit.INSTANCE;
    }
}
