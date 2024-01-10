package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Landroidx/documentfile/provider/DocumentFile;", "kotlin.jvm.PlatformType", "invoke", "(Landroidx/documentfile/provider/DocumentFile;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileExt.kt */
final class DocumentFileUtils$search$5 extends Lambda implements Function1<DocumentFile, Boolean> {
    final /* synthetic */ String[] $mimeTypes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$search$5(String[] strArr) {
        super(1);
        this.$mimeTypes = strArr;
    }

    public final Boolean invoke(DocumentFile documentFile) {
        Intrinsics.checkNotNullExpressionValue(documentFile, "it");
        String[] strArr = this.$mimeTypes;
        Intrinsics.checkNotNull(strArr);
        return Boolean.valueOf(DocumentFileUtils.matchesMimeTypes(documentFile, strArr));
    }
}
