package com.anggrayudi.storage.file;

import com.anggrayudi.storage.callback.FolderCallback;
import com.anggrayudi.storage.extension.CoroutineExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "start", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileExt.kt */
final class DocumentFileUtils$copyFolderTo$startTimer$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Ref.LongRef $bytesMoved;
    final /* synthetic */ FolderCallback $callback;
    final /* synthetic */ long $reportInterval;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ Ref.LongRef $totalSizeToCopy;
    final /* synthetic */ Ref.IntRef $writeSpeed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyFolderTo$startTimer$1(long j, Ref.ObjectRef<Job> objectRef, Ref.LongRef longRef, Ref.LongRef longRef2, Ref.IntRef intRef, Ref.IntRef intRef2, FolderCallback folderCallback) {
        super(1);
        this.$reportInterval = j;
        this.$timer = objectRef;
        this.$bytesMoved = longRef;
        this.$totalSizeToCopy = longRef2;
        this.$writeSpeed = intRef;
        this.$totalCopiedFiles = intRef2;
        this.$callback = folderCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            long j = this.$reportInterval;
            if (j > 0) {
                Ref.ObjectRef<Job> objectRef = this.$timer;
                final Ref.LongRef longRef = this.$bytesMoved;
                final Ref.LongRef longRef2 = this.$totalSizeToCopy;
                final Ref.IntRef intRef = this.$writeSpeed;
                final Ref.IntRef intRef2 = this.$totalCopiedFiles;
                final FolderCallback folderCallback = this.$callback;
                objectRef.element = CoroutineExtKt.startCoroutineTimer$default(0, j, false, new Function0<Unit>() {
                    public final void invoke() {
                        FolderCallback.Report report = new FolderCallback.Report((((float) longRef.element) * 100.0f) / ((float) longRef2.element), longRef.element, intRef.element, intRef2.element);
                        Job unused = BuildersKt__Builders_commonKt.launch$default(folderCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$copyFolderTo$startTimer$1$1$invoke$$inlined$postToUi$1((Continuation) null, folderCallback, report), 2, (Object) null);
                        intRef.element = 0;
                    }
                }, 5, (Object) null);
            }
        }
    }
}
