package com.anggrayudi.storage;

import com.anggrayudi.storage.file.FileFullPath;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleStorageHelper.kt */
final class SimpleStorageHelper$onFolderSelected$1$onStoragePermissionDenied$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ SimpleStorageHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleStorageHelper$onFolderSelected$1$onStoragePermissionDenied$1(SimpleStorageHelper simpleStorageHelper) {
        super(1);
        this.this$0 = simpleStorageHelper;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            SimpleStorage.openFolderPicker$default(this.this$0.getStorage(), 0, (FileFullPath) null, 3, (Object) null);
        } else {
            this.this$0.reset();
        }
    }
}
