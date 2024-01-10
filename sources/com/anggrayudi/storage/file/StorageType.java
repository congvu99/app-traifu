package com.anggrayudi.storage.file;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/anggrayudi/storage/file/StorageType;", "", "(Ljava/lang/String;I)V", "isExpected", "", "actualStorageType", "EXTERNAL", "DATA", "SD_CARD", "UNKNOWN", "Companion", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StorageType.kt */
public enum StorageType {
    EXTERNAL,
    DATA,
    SD_CARD,
    UNKNOWN;
    
    public static final Companion Companion = null;

    @JvmStatic
    public static final StorageType fromStorageId(String str) {
        return Companion.fromStorageId(str);
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public final boolean isExpected(StorageType storageType) {
        Intrinsics.checkNotNullParameter(storageType, "actualStorageType");
        return this == UNKNOWN || this == storageType;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/anggrayudi/storage/file/StorageType$Companion;", "", "()V", "fromStorageId", "Lcom/anggrayudi/storage/file/StorageType;", "storageId", "", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StorageType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final StorageType fromStorageId(String str) {
            Intrinsics.checkNotNullParameter(str, "storageId");
            if (Intrinsics.areEqual((Object) str, (Object) StorageId.PRIMARY)) {
                return StorageType.EXTERNAL;
            }
            if (Intrinsics.areEqual((Object) str, (Object) "data")) {
                return StorageType.DATA;
            }
            if (new Regex("[A-Z0-9]{4}-[A-Z0-9]{4}").matches(str)) {
                return StorageType.SD_CARD;
            }
            return StorageType.UNKNOWN;
        }
    }
}
