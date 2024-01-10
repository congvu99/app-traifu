package com.uploadcare.android.widget.worker;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"doWork", "", "continuation", "Lkotlin/coroutines/Continuation;", "Landroidx/work/ListenableWorker$Result;"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "com.uploadcare.android.widget.worker.FileUploadWorker", f = "FileUploadWorker.kt", i = {0}, l = {35}, m = "doWork", n = {"this"}, s = {"L$0"})
/* compiled from: FileUploadWorker.kt */
final class FileUploadWorker$doWork$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileUploadWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileUploadWorker$doWork$1(FileUploadWorker fileUploadWorker, Continuation continuation) {
        super(continuation);
        this.this$0 = fileUploadWorker;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
