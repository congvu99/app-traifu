package com.uploadcare.android.library.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "com.uploadcare.android.library.utils.CountingRequestBody$reportProgress$2", f = "CountingRequestBody.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CountingRequestBody.kt */
final class CountingRequestBody$reportProgress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $bytesWritten;
    final /* synthetic */ long $contentLength;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ CountingRequestBody this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CountingRequestBody$reportProgress$2(CountingRequestBody countingRequestBody, long j, long j2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = countingRequestBody;
        this.$bytesWritten = j;
        this.$contentLength = j2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        CountingRequestBody$reportProgress$2 countingRequestBody$reportProgress$2 = new CountingRequestBody$reportProgress$2(this.this$0, this.$bytesWritten, this.$contentLength, continuation);
        countingRequestBody$reportProgress$2.p$ = (CoroutineScope) obj;
        return countingRequestBody$reportProgress$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CountingRequestBody$reportProgress$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.onProgressUpdate.invoke(Boxing.boxLong(this.$bytesWritten), Boxing.boxLong(this.$contentLength));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
