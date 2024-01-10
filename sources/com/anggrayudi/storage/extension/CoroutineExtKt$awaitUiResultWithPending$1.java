package com.anggrayudi.storage.extension;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "com.anggrayudi.storage.extension.CoroutineExtKt$awaitUiResultWithPending$1", f = "CoroutineExt.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CoroutineExt.kt */
public final class CoroutineExtKt$awaitUiResultWithPending$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function1<CancellableContinuation<? super R>, Unit> $action;
    final /* synthetic */ CoroutineScope $uiScope;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineExtKt$awaitUiResultWithPending$1(CoroutineScope coroutineScope, Function1<? super CancellableContinuation<? super R>, Unit> function1, Continuation<? super CoroutineExtKt$awaitUiResultWithPending$1> continuation) {
        super(2, continuation);
        this.$uiScope = coroutineScope;
        this.$action = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineExtKt$awaitUiResultWithPending$1(this.$uiScope, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((CoroutineExtKt$awaitUiResultWithPending$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.$uiScope;
            Function1<CancellableContinuation<? super R>, Unit> function1 = this.$action;
            this.L$0 = coroutineScope;
            this.L$1 = function1;
            this.label = 1;
            Continuation continuation = this;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), (CoroutineStart) null, new CoroutineExtKt$awaitUiResultWithPending$1$1$1(function1, cancellableContinuationImpl, (Continuation<? super CoroutineExtKt$awaitUiResultWithPending$1$1$1>) null), 2, (Object) null);
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            Function1 function12 = (Function1) this.L$1;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        CoroutineScope coroutineScope = this.$uiScope;
        Function1<CancellableContinuation<? super R>, Unit> function1 = this.$action;
        InlineMarker.mark(0);
        Continuation continuation = this;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), (CoroutineStart) null, new CoroutineExtKt$awaitUiResultWithPending$1$1$1(function1, cancellableContinuationImpl, (Continuation<? super CoroutineExtKt$awaitUiResultWithPending$1$1$1>) null), 2, (Object) null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }
}
