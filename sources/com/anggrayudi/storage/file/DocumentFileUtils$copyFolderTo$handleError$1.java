package com.anggrayudi.storage.file;

import com.anggrayudi.storage.callback.FolderCallback;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke", "(Ljava/lang/Exception;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileExt.kt */
final class DocumentFileUtils$copyFolderTo$handleError$1 extends Lambda implements Function1<Exception, Boolean> {
    final /* synthetic */ FolderCallback $callback;
    final /* synthetic */ Function1<FolderCallback.ErrorCode, Unit> $notifyCanceled;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyFolderTo$handleError$1(Function1<? super FolderCallback.ErrorCode, Unit> function1, Ref.ObjectRef<Job> objectRef, FolderCallback folderCallback) {
        super(1);
        this.$notifyCanceled = function1;
        this.$timer = objectRef;
        this.$callback = folderCallback;
    }

    public final Boolean invoke(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        FolderCallback.ErrorCode access$toFolderCallbackErrorCode = DocumentFileUtils.toFolderCallbackErrorCode(exc);
        boolean z = true;
        if (access$toFolderCallbackErrorCode == FolderCallback.ErrorCode.CANCELED || access$toFolderCallbackErrorCode == FolderCallback.ErrorCode.UNKNOWN_IO_ERROR) {
            this.$notifyCanceled.invoke(access$toFolderCallbackErrorCode);
        } else {
            Job job = (Job) this.$timer.element;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.$callback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFolderTo$handleError$1$invoke$$inlined$postToUi$1((Continuation) null, this.$callback, access$toFolderCallbackErrorCode), 2, (Object) null);
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
