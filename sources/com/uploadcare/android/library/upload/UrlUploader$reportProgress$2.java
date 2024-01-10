package com.uploadcare.android.library.upload;

import com.uploadcare.android.library.callbacks.ProgressCallback;
import com.uploadcare.android.library.data.UploadFromUrlStatusData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "com.uploadcare.android.library.upload.UrlUploader$reportProgress$2", f = "UrlUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: UrlUploader.kt */
final class UrlUploader$reportProgress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UploadFromUrlStatusData $data;
    final /* synthetic */ double $progress;
    final /* synthetic */ ProgressCallback $progressCallback;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UrlUploader$reportProgress$2(ProgressCallback progressCallback, UploadFromUrlStatusData uploadFromUrlStatusData, double d, Continuation continuation) {
        super(2, continuation);
        this.$progressCallback = progressCallback;
        this.$data = uploadFromUrlStatusData;
        this.$progress = d;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        UrlUploader$reportProgress$2 urlUploader$reportProgress$2 = new UrlUploader$reportProgress$2(this.$progressCallback, this.$data, this.$progress, continuation);
        urlUploader$reportProgress$2.p$ = (CoroutineScope) obj;
        return urlUploader$reportProgress$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UrlUploader$reportProgress$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ProgressCallback progressCallback = this.$progressCallback;
            if (progressCallback == null) {
                return null;
            }
            progressCallback.onProgressUpdate(this.$data.getDone(), this.$data.getTotal(), this.$progress);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
