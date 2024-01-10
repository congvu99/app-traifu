package com.anggrayudi.storage.file;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileExt.kt */
final class DocumentFileUtils$copyFolderTo$finalize$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ FolderCallback $callback;
    final /* synthetic */ ArrayList<FolderCallback.FileConflict> $conflictedFiles;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $deleteSourceWhenComplete;
    final /* synthetic */ Ref.BooleanRef $success;
    final /* synthetic */ DocumentFile $targetFolder;
    final /* synthetic */ DocumentFile $this_copyFolderTo;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ Ref.IntRef $totalFilesToCopy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyFolderTo$finalize$1(Ref.ObjectRef<Job> objectRef, Ref.BooleanRef booleanRef, ArrayList<FolderCallback.FileConflict> arrayList, boolean z, DocumentFile documentFile, Context context, FolderCallback folderCallback, DocumentFile documentFile2, Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(0);
        this.$timer = objectRef;
        this.$success = booleanRef;
        this.$conflictedFiles = arrayList;
        this.$deleteSourceWhenComplete = z;
        this.$this_copyFolderTo = documentFile;
        this.$context = context;
        this.$callback = folderCallback;
        this.$targetFolder = documentFile2;
        this.$totalFilesToCopy = intRef;
        this.$totalCopiedFiles = intRef2;
    }

    public final Boolean invoke() {
        Job job = (Job) this.$timer.element;
        boolean z = true;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (!this.$success.element || this.$conflictedFiles.isEmpty()) {
            if (this.$deleteSourceWhenComplete && this.$success.element) {
                DocumentFileUtils.forceDelete$default(this.$this_copyFolderTo, this.$context, false, 2, (Object) null);
            }
            CoroutineScope uiScope = this.$callback.getUiScope();
            FolderCallback folderCallback = this.$callback;
            DocumentFile documentFile = this.$targetFolder;
            Ref.IntRef intRef = this.$totalFilesToCopy;
            Ref.IntRef intRef2 = this.$totalCopiedFiles;
            Ref.BooleanRef booleanRef = this.$success;
            Job unused = BuildersKt__Builders_commonKt.launch$default(uiScope, Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFolderTo$finalize$1$invoke$$inlined$postToUi$1((Continuation) null, folderCallback, documentFile, intRef, intRef2, booleanRef), 2, (Object) null);
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
