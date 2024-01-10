package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FileCallback;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileExt.kt */
final class DocumentFileUtils$moveFileTo$11 extends Lambda implements Function2<InputStream, OutputStream, Unit> {
    final /* synthetic */ FileCallback $callback;
    final /* synthetic */ long $reportInterval;
    final /* synthetic */ DocumentFile $targetFile;
    final /* synthetic */ DocumentFile $this_moveFileTo;
    final /* synthetic */ boolean $watchProgress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$moveFileTo$11(DocumentFile documentFile, DocumentFile documentFile2, boolean z, long j, FileCallback fileCallback) {
        super(2);
        this.$this_moveFileTo = documentFile;
        this.$targetFile = documentFile2;
        this.$watchProgress = z;
        this.$reportInterval = j;
        this.$callback = fileCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((InputStream) obj, (OutputStream) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(InputStream inputStream, OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        DocumentFileUtils.copyFileStream(this.$this_moveFileTo, inputStream, outputStream, this.$targetFile, this.$watchProgress, this.$reportInterval, true, this.$callback);
    }
}
