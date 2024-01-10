package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"com/anggrayudi/storage/file/DocumentFileUtils$copyTo$SourceInfo", "", "children", "", "Landroidx/documentfile/provider/DocumentFile;", "size", "", "totalFiles", "", "conflictResolution", "Lcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;", "(Ljava/util/List;JILcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;)V", "getChildren", "()Ljava/util/List;", "getConflictResolution", "()Lcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;", "getSize", "()J", "getTotalFiles", "()I", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileExt.kt */
public final class DocumentFileUtils$copyTo$SourceInfo {
    private final List<DocumentFile> children;
    private final FolderCallback.ConflictResolution conflictResolution;
    private final long size;
    private final int totalFiles;

    public DocumentFileUtils$copyTo$SourceInfo(List<? extends DocumentFile> list, long j, int i, FolderCallback.ConflictResolution conflictResolution2) {
        Intrinsics.checkNotNullParameter(list, "children");
        Intrinsics.checkNotNullParameter(conflictResolution2, "conflictResolution");
        this.children = list;
        this.size = j;
        this.totalFiles = i;
        this.conflictResolution = conflictResolution2;
    }

    public final List<DocumentFile> getChildren() {
        return this.children;
    }

    public final FolderCallback.ConflictResolution getConflictResolution() {
        return this.conflictResolution;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getTotalFiles() {
        return this.totalFiles;
    }
}
