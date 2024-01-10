package com.anggrayudi.storage.file;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/anggrayudi/storage/file/StorageId;", "", "()V", "DATA", "", "PRIMARY", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StorageId.kt */
public final class StorageId {
    public static final String DATA = "data";
    public static final StorageId INSTANCE = new StorageId();
    public static final String PRIMARY = "primary";

    private StorageId() {
    }
}
