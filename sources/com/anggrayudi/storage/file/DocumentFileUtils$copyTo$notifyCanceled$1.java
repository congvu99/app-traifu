package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.MultipleFileCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "errorCode", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ErrorCode;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileExt.kt */
final class DocumentFileUtils$copyTo$notifyCanceled$1 extends Lambda implements Function1<MultipleFileCallback.ErrorCode, Unit> {
    final /* synthetic */ MultipleFileCallback $callback;
    final /* synthetic */ Ref.BooleanRef $canceled;
    final /* synthetic */ Map<DocumentFile, DocumentFile> $results;
    final /* synthetic */ Ref.ObjectRef<DocumentFile> $targetFile;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ int $totalFilesToCopy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyTo$notifyCanceled$1(Ref.BooleanRef booleanRef, Ref.ObjectRef<Job> objectRef, Ref.ObjectRef<DocumentFile> objectRef2, Map<DocumentFile, DocumentFile> map, int i, Ref.IntRef intRef, MultipleFileCallback multipleFileCallback) {
        super(1);
        this.$canceled = booleanRef;
        this.$timer = objectRef;
        this.$targetFile = objectRef2;
        this.$results = map;
        this.$totalFilesToCopy = i;
        this.$totalCopiedFiles = intRef;
        this.$callback = multipleFileCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MultipleFileCallback.ErrorCode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(MultipleFileCallback.ErrorCode errorCode) {
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
            Map<DocumentFile, DocumentFile> map = this.$results;
            Collection arrayList = new ArrayList(map.size());
            for (Map.Entry<DocumentFile, DocumentFile> value : map.entrySet()) {
                arrayList.add((DocumentFile) value.getValue());
            }
            MultipleFileCallback.Result result = new MultipleFileCallback.Result((List) arrayList, this.$totalFilesToCopy, this.$totalCopiedFiles.element, false);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.$callback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyTo$notifyCanceled$1$invoke$$inlined$postToUi$1((Continuation) null, this.$callback, errorCode, result), 2, (Object) null);
        }
    }
}
