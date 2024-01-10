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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "com.uploadcare.android.library.upload.UrlUploader$upload$5", f = "UrlUploader.kt", i = {0}, l = {215}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: UrlUploader.kt */
final class UrlUploader$upload$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UploadFromUrlStatusData $data;
    final /* synthetic */ Ref.DoubleRef $progress;
    final /* synthetic */ ProgressCallback $progressCallback;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ UrlUploader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UrlUploader$upload$5(UrlUploader urlUploader, UploadFromUrlStatusData uploadFromUrlStatusData, Ref.DoubleRef doubleRef, ProgressCallback progressCallback, Continuation continuation) {
        super(2, continuation);
        this.this$0 = urlUploader;
        this.$data = uploadFromUrlStatusData;
        this.$progress = doubleRef;
        this.$progressCallback = progressCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        UrlUploader$upload$5 urlUploader$upload$5 = new UrlUploader$upload$5(this.this$0, this.$data, this.$progress, this.$progressCallback, continuation);
        urlUploader$upload$5.p$ = (CoroutineScope) obj;
        return urlUploader$upload$5;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((UrlUploader$upload$5) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            UrlUploader urlUploader = this.this$0;
            UploadFromUrlStatusData uploadFromUrlStatusData = this.$data;
            double d = this.$progress.element;
            ProgressCallback progressCallback = this.$progressCallback;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (urlUploader.reportProgress(uploadFromUrlStatusData, d, progressCallback, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
