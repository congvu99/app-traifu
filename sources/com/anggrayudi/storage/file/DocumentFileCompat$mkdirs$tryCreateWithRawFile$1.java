package com.anggrayudi.storage.file;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/documentfile/provider/DocumentFile;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileCompat.kt */
final class DocumentFileCompat$mkdirs$tryCreateWithRawFile$1 extends Lambda implements Function0<DocumentFile> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fullPath;
    final /* synthetic */ boolean $requiresWriteAccess;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileCompat$mkdirs$tryCreateWithRawFile$1(String str, boolean z, Context context) {
        super(0);
        this.$fullPath = str;
        this.$requiresWriteAccess = z;
        this.$context = context;
    }

    public final DocumentFile invoke() {
        File file = new File(DocumentFileCompat.INSTANCE.removeForbiddenCharsFromFilename$storage_release(this.$fullPath));
        file.mkdirs();
        if (!file.isDirectory() || !file.canRead() || ((!this.$requiresWriteAccess || !FileUtils.isWritable(file, this.$context)) && this.$requiresWriteAccess)) {
            return null;
        }
        return DocumentFile.fromFile(file);
    }
}
