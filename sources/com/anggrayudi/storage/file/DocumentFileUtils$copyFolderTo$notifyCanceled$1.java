package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "errorCode", "Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileExt.kt */
final class DocumentFileUtils$copyFolderTo$notifyCanceled$1 extends Lambda implements Function1<FolderCallback.ErrorCode, Unit> {
    final /* synthetic */ FolderCallback $callback;
    final /* synthetic */ Ref.BooleanRef $canceled;
    final /* synthetic */ Ref.ObjectRef<DocumentFile> $targetFile;
    final /* synthetic */ DocumentFile $targetFolder;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ Ref.IntRef $totalFilesToCopy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyFolderTo$notifyCanceled$1(Ref.BooleanRef booleanRef, Ref.ObjectRef<Job> objectRef, Ref.ObjectRef<DocumentFile> objectRef2, FolderCallback folderCallback, DocumentFile documentFile, Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(1);
        this.$canceled = booleanRef;
        this.$timer = objectRef;
        this.$targetFile = objectRef2;
        this.$callback = folderCallback;
        this.$targetFolder = documentFile;
        this.$totalFilesToCopy = intRef;
        this.$totalCopiedFiles = intRef2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FolderCallback.ErrorCode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FolderCallback.ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (!this.$canceled.element) {
            this.$canceled.element = true;
            Job job = (Job) this.$timer.element;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            DocumentFile documentFile = (DocumentFile) this.$targetFile.element;
            if (documentFile != null) {
                documentFile.delete();
            }
            CoroutineScope uiScope = this.$callback.getUiScope();
            FolderCallback folderCallback = this.$callback;
            DocumentFile documentFile2 = this.$targetFolder;
            Ref.IntRef intRef = this.$totalFilesToCopy;
            Ref.IntRef intRef2 = this.$totalCopiedFiles;
            Job unused = BuildersKt__Builders_commonKt.launch$default(uiScope, Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFolderTo$notifyCanceled$1$invoke$$inlined$postToUi$1((Continuation) null, folderCallback, errorCode, documentFile2, intRef, intRef2), 2, (Object) null);
        }
    }
}
