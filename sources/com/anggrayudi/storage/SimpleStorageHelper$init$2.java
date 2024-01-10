package com.anggrayudi.storage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.StorageAccessCallback;
import com.anggrayudi.storage.file.DocumentFileUtils;
import com.anggrayudi.storage.file.FileFullPath;
import com.anggrayudi.storage.file.StorageType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J0\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J0\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0018"}, d2 = {"com/anggrayudi/storage/SimpleStorageHelper$init$2", "Lcom/anggrayudi/storage/callback/StorageAccessCallback;", "onActivityHandlerNotFound", "", "requestCode", "", "intent", "Landroid/content/Intent;", "onCanceledByUser", "onExpectedStorageNotSelected", "selectedFolder", "Landroidx/documentfile/provider/DocumentFile;", "selectedStorageType", "Lcom/anggrayudi/storage/file/StorageType;", "expectedBasePath", "", "expectedStorageType", "onRootPathNotSelected", "rootPath", "uri", "Landroid/net/Uri;", "onRootPathPermissionGranted", "root", "onStoragePermissionDenied", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleStorageHelper.kt */
public final class SimpleStorageHelper$init$2 implements StorageAccessCallback {
    final /* synthetic */ SimpleStorageHelper this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SimpleStorageHelper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StorageType.values().length];
            iArr[StorageType.EXTERNAL.ordinal()] = 1;
            iArr[StorageType.SD_CARD.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    SimpleStorageHelper$init$2(SimpleStorageHelper simpleStorageHelper) {
        this.this$0 = simpleStorageHelper;
    }

    public void onRootPathNotSelected(int i, String str, Uri uri, StorageType storageType, StorageType storageType2) {
        Intrinsics.checkNotNullParameter(str, "rootPath");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(storageType, "selectedStorageType");
        Intrinsics.checkNotNullParameter(storageType2, "expectedStorageType");
        if (!storageType2.isExpected(storageType)) {
            storageType = storageType2;
        }
        new AlertDialog.Builder(this.this$0.getStorage().getContext()).setCancelable(false).setMessage(storageType == StorageType.SD_CARD ? R.string.ss_please_select_root_storage_sdcard : R.string.ss_please_select_root_storage_primary).setNegativeButton(17039360, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                SimpleStorageHelper$init$2.m5039onRootPathNotSelected$lambda0(SimpleStorageHelper.this, dialogInterface, i);
            }
        }).setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(storageType, storageType2) {
            public final /* synthetic */ StorageType f$1;
            public final /* synthetic */ StorageType f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                SimpleStorageHelper$init$2.m5040onRootPathNotSelected$lambda1(SimpleStorageHelper.this, this.f$1, this.f$2, dialogInterface, i);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: onRootPathNotSelected$lambda-0  reason: not valid java name */
    public static final void m5039onRootPathNotSelected$lambda0(SimpleStorageHelper simpleStorageHelper, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(simpleStorageHelper, "this$0");
        simpleStorageHelper.reset();
    }

    /* access modifiers changed from: private */
    /* renamed from: onRootPathNotSelected$lambda-1  reason: not valid java name */
    public static final void m5040onRootPathNotSelected$lambda1(SimpleStorageHelper simpleStorageHelper, StorageType storageType, StorageType storageType2, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(simpleStorageHelper, "this$0");
        Intrinsics.checkNotNullParameter(storageType, "$storageType");
        Intrinsics.checkNotNullParameter(storageType2, "$expectedStorageType");
        SimpleStorage.requestStorageAccess$default(simpleStorageHelper.getStorage(), 0, storageType, storageType2, (String) null, 9, (Object) null);
    }

    public void onRootPathPermissionGranted(int i, DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "root");
        if (i == this.this$0.originalRequestCode) {
            this.this$0.reset();
            Function2<Integer, DocumentFile, Unit> onStorageAccessGranted = this.this$0.getOnStorageAccessGranted();
            if (onStorageAccessGranted != null) {
                onStorageAccessGranted.invoke(Integer.valueOf(i), documentFile);
                return;
            }
            return;
        }
        Context context = this.this$0.getStorage().getContext();
        Function0 simpleStorageHelper$init$2$onRootPathPermissionGranted$toastFilePicker$1 = new SimpleStorageHelper$init$2$onRootPathPermissionGranted$toastFilePicker$1(context, documentFile);
        int access$getPickerToOpenOnceGranted$p = this.this$0.pickerToOpenOnceGranted;
        if (access$getPickerToOpenOnceGranted$p == 1) {
            SimpleStorage storage = this.this$0.getStorage();
            Set access$getFilterMimeTypes$p = this.this$0.filterMimeTypes;
            if (access$getFilterMimeTypes$p == null) {
                access$getFilterMimeTypes$p = SetsKt.emptySet();
            }
            Object[] array = access$getFilterMimeTypes$p.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                SimpleStorage.openFilePicker$default(storage, 0, false, (String[]) Arrays.copyOf(strArr, strArr.length), 3, (Object) null);
                simpleStorageHelper$init$2$onRootPathPermissionGranted$toastFilePicker$1.invoke();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        } else if (access$getPickerToOpenOnceGranted$p != 2) {
            Toast.makeText(context, context.getString(R.string.ss_selecting_root_path_success_without_open_folder_picker, new Object[]{DocumentFileUtils.getAbsolutePath(documentFile, context)}), 0).show();
        } else {
            SimpleStorage.openFolderPicker$default(this.this$0.getStorage(), 0, (FileFullPath) null, 3, (Object) null);
            simpleStorageHelper$init$2$onRootPathPermissionGranted$toastFilePicker$1.invoke();
        }
        this.this$0.reset();
    }

    public void onExpectedStorageNotSelected(int i, DocumentFile documentFile, StorageType storageType, String str, StorageType storageType2) {
        int i2;
        Intrinsics.checkNotNullParameter(documentFile, "selectedFolder");
        Intrinsics.checkNotNullParameter(storageType, "selectedStorageType");
        Intrinsics.checkNotNullParameter(str, "expectedBasePath");
        Intrinsics.checkNotNullParameter(storageType2, "expectedStorageType");
        Context context = this.this$0.getStorage().getContext();
        int i3 = WhenMappings.$EnumSwitchMapping$0[storageType2.ordinal()];
        if (i3 == 1) {
            i2 = R.string.ss_please_select_base_path_with_storage_type_primary;
        } else if (i3 != 2) {
            i2 = R.string.ss_please_select_base_path;
        } else {
            i2 = R.string.ss_please_select_base_path_with_storage_type_sd_card;
        }
        String string = context.getString(i2, new Object[]{str});
        Intrinsics.checkNotNullExpressionValue(string, "storage.context.getStrin…asePath\n                )");
        new AlertDialog.Builder(this.this$0.getStorage().getContext()).setCancelable(false).setMessage((CharSequence) string).setNegativeButton(17039360, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                SimpleStorageHelper$init$2.m5037onExpectedStorageNotSelected$lambda2(SimpleStorageHelper.this, dialogInterface, i);
            }
        }).setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(storageType2, str) {
            public final /* synthetic */ StorageType f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                SimpleStorageHelper$init$2.m5038onExpectedStorageNotSelected$lambda3(SimpleStorageHelper.this, this.f$1, this.f$2, dialogInterface, i);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: onExpectedStorageNotSelected$lambda-2  reason: not valid java name */
    public static final void m5037onExpectedStorageNotSelected$lambda2(SimpleStorageHelper simpleStorageHelper, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(simpleStorageHelper, "this$0");
        simpleStorageHelper.reset();
    }

    /* access modifiers changed from: private */
    /* renamed from: onExpectedStorageNotSelected$lambda-3  reason: not valid java name */
    public static final void m5038onExpectedStorageNotSelected$lambda3(SimpleStorageHelper simpleStorageHelper, StorageType storageType, String str, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(simpleStorageHelper, "this$0");
        Intrinsics.checkNotNullParameter(storageType, "$expectedStorageType");
        Intrinsics.checkNotNullParameter(str, "$expectedBasePath");
        SimpleStorage.requestStorageAccess$default(simpleStorageHelper.getStorage(), 0, storageType, storageType, str, 1, (Object) null);
    }

    public void onStoragePermissionDenied(int i) {
        SimpleStorageHelper simpleStorageHelper = this.this$0;
        simpleStorageHelper.requestStoragePermission(new SimpleStorageHelper$init$2$onStoragePermissionDenied$1(simpleStorageHelper));
    }

    public void onCanceledByUser(int i) {
        this.this$0.reset();
    }

    public void onActivityHandlerNotFound(int i, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        this.this$0.handleMissingActivityHandler();
    }
}
