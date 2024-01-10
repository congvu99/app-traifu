package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/anggrayudi/storage/extension/CoroutineExtKt$postToUi$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$notifyCanceled$1$invoke$$inlined$postToUi$1", f = "DocumentFileExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CoroutineExt.kt */
public final class DocumentFileUtils$copyFolderTo$notifyCanceled$1$invoke$$inlined$postToUi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FolderCallback $callback$inlined;
    final /* synthetic */ FolderCallback.ErrorCode $errorCode$inlined;
    final /* synthetic */ DocumentFile $targetFolder$inlined;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles$inlined;
    final /* synthetic */ Ref.IntRef $totalFilesToCopy$inlined;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$copyFolderTo$notifyCanceled$1$invoke$$inlined$postToUi$1(Continuation continuation, FolderCallback folderCallback, FolderCallback.ErrorCode errorCode, DocumentFile documentFile, Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(2, continuation);
        this.$callback$inlined = folderCallback;
        this.$errorCode$inlined = errorCode;
        this.$targetFolder$inlined = documentFile;
        this.$totalFilesToCopy$inlined = intRef;
        this.$totalCopiedFiles$inlined = intRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentFileUtils$copyFolderTo$notifyCanceled$1$invoke$$inlined$postToUi$1(continuation, this.$callback$inlined, this.$errorCode$inlined, this.$targetFolder$inlined, this.$totalFilesToCopy$inlined, this.$totalCopiedFiles$inlined);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocumentFileUtils$copyFolderTo$notifyCanceled$1$invoke$$inlined$postToUi$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$callback$inlined.onFailed(this.$errorCode$inlined);
            this.$callback$inlined.onCompleted(new FolderCallback.Result(this.$targetFolder$inlined, this.$totalFilesToCopy$inlined.element, this.$totalCopiedFiles$inlined.element, false));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
