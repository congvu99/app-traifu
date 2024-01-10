package com.anggrayudi.storage.file;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/anggrayudi/storage/file/FileSize;", "", "()V", "GB", "", "KB", "MB", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileSize.kt */
public final class FileSize {
    public static final int GB = 1073741824;
    public static final FileSize INSTANCE = new FileSize();
    public static final int KB = 1024;
    public static final int MB = 1048576;

    private FileSize() {
    }
}
