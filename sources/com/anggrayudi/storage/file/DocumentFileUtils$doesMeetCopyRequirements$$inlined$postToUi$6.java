package com.anggrayudi.storage.file;

import com.anggrayudi.storage.callback.MultipleFileCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/anggrayudi/storage/extension/CoroutineExtKt$postToUi$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.anggrayudi.storage.file.DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$6", f = "DocumentFileExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CoroutineExt.kt */
public final class DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MultipleFileCallback $callback$inlined;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$6(Continuation continuation, MultipleFileCallback multipleFileCallback) {
        super(2, continuation);
        this.$callback$inlined = multipleFileCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$6(continuation, this.$callback$inlined);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocumentFileUtils$doesMeetCopyRequirements$$inlined$postToUi$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$callback$inlined.onFailed(MultipleFileCallback.ErrorCode.STORAGE_PERMISSION_DENIED);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
