package com.anggrayudi.storage.file;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.MultipleFileCallback;
import com.anggrayudi.storage.extension.IOUtils;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "sourceFile", "Landroidx/documentfile/provider/DocumentFile;", "destFile", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileExt.kt */
final class DocumentFileUtils$copyTo$copy$1 extends Lambda implements Function2<DocumentFile, DocumentFile, Unit> {
    final /* synthetic */ byte[] $buffer;
    final /* synthetic */ Ref.LongRef $bytesMoved;
    final /* synthetic */ MultipleFileCallback $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $deleteSourceWhenComplete;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ Ref.IntRef $writeSpeed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyTo$copy$1(Context context, MultipleFileCallback multipleFileCallback, Ref.IntRef intRef, boolean z, byte[] bArr, Ref.LongRef longRef, Ref.IntRef intRef2) {
        super(2);
        this.$context = context;
        this.$callback = multipleFileCallback;
        this.$totalCopiedFiles = intRef;
        this.$deleteSourceWhenComplete = z;
        this.$buffer = bArr;
        this.$bytesMoved = longRef;
        this.$writeSpeed = intRef2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((DocumentFile) obj, (DocumentFile) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(DocumentFile documentFile, DocumentFile documentFile2) {
        Intrinsics.checkNotNullParameter(documentFile, "sourceFile");
        Intrinsics.checkNotNullParameter(documentFile2, "destFile");
        final byte[] bArr = this.$buffer;
        final Ref.LongRef longRef = this.$bytesMoved;
        final Ref.IntRef intRef = this.$writeSpeed;
        DocumentFileUtils.createFileStreams(this.$context, documentFile, documentFile2, this.$callback, (Function2<? super InputStream, ? super OutputStream, Unit>) new Function2<InputStream, OutputStream, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((InputStream) obj, (OutputStream) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(InputStream inputStream, OutputStream outputStream) {
                Intrinsics.checkNotNullParameter(inputStream, "inputStream");
                Intrinsics.checkNotNullParameter(outputStream, "outputStream");
                try {
                    int read = inputStream.read(bArr);
                    while (read != -1) {
                        outputStream.write(bArr, 0, read);
                        longRef.element += (long) read;
                        intRef.element += read;
                        read = inputStream.read(bArr);
                    }
                } finally {
                    IOUtils.closeStream(inputStream);
                    IOUtils.closeStream(outputStream);
                }
            }
        });
        this.$totalCopiedFiles.element++;
        if (this.$deleteSourceWhenComplete) {
            documentFile.delete();
        }
    }
}
