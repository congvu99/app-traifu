package com.anggrayudi.storage.file;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import com.anggrayudi.storage.callback.MultipleFileCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileExt.kt */
final class DocumentFileUtils$copyTo$finalize$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ MultipleFileCallback $callback;
    final /* synthetic */ List<FolderCallback.FileConflict> $conflictedFiles;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $deleteSourceWhenComplete;
    final /* synthetic */ Map<DocumentFile, DocumentFile> $results;
    final /* synthetic */ Map<DocumentFile, DocumentFileUtils$copyTo$SourceInfo> $sourceInfos;
    final /* synthetic */ Ref.BooleanRef $success;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ int $totalFilesToCopy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyTo$finalize$1(Ref.ObjectRef<Job> objectRef, Ref.BooleanRef booleanRef, List<FolderCallback.FileConflict> list, boolean z, Map<DocumentFile, DocumentFileUtils$copyTo$SourceInfo> map, Map<DocumentFile, DocumentFile> map2, int i, Ref.IntRef intRef, MultipleFileCallback multipleFileCallback, Context context) {
        super(0);
        this.$timer = objectRef;
        this.$success = booleanRef;
        this.$conflictedFiles = list;
        this.$deleteSourceWhenComplete = z;
        this.$sourceInfos = map;
        this.$results = map2;
        this.$totalFilesToCopy = i;
        this.$totalCopiedFiles = intRef;
        this.$callback = multipleFileCallback;
        this.$context = context;
    }

    public final Boolean invoke() {
        Job job = (Job) this.$timer.element;
        boolean z = true;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (!this.$success.element || this.$conflictedFiles.isEmpty()) {
            if (this.$deleteSourceWhenComplete && this.$success.element) {
                Map<DocumentFile, DocumentFileUtils$copyTo$SourceInfo> map = this.$sourceInfos;
                Context context = this.$context;
                for (Map.Entry<DocumentFile, DocumentFileUtils$copyTo$SourceInfo> key : map.entrySet()) {
                    DocumentFileUtils.deleteRecursively$default((DocumentFile) key.getKey(), context, false, 2, (Object) null);
                }
            }
            Map<DocumentFile, DocumentFile> map2 = this.$results;
            Collection arrayList = new ArrayList(map2.size());
            for (Map.Entry<DocumentFile, DocumentFile> value : map2.entrySet()) {
                arrayList.add((DocumentFile) value.getValue());
            }
            MultipleFileCallback.Result result = new MultipleFileCallback.Result((List) arrayList, this.$totalFilesToCopy, this.$totalCopiedFiles.element, this.$success.element);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.$callback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyTo$finalize$1$invoke$$inlined$postToUi$1((Continuation) null, this.$callback, result), 2, (Object) null);
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
