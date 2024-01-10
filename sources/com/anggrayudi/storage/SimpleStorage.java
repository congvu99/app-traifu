package com.anggrayudi.storage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment;
import com.anggrayudi.storage.callback.CreateFileCallback;
import com.anggrayudi.storage.callback.FilePickerCallback;
import com.anggrayudi.storage.callback.FileReceiverCallback;
import com.anggrayudi.storage.callback.FolderPickerCallback;
import com.anggrayudi.storage.callback.StorageAccessCallback;
import com.anggrayudi.storage.extension.ContextUtils;
import com.anggrayudi.storage.extension.UriUtils;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.file.DocumentFileUtils;
import com.anggrayudi.storage.file.FileFullPath;
import com.anggrayudi.storage.file.MimeType;
import com.anggrayudi.storage.file.StorageId;
import com.anggrayudi.storage.file.StorageType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 u2\u00020\u0001:\u0001uB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bB\u000f\b\u0002\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u001eJ\b\u0010N\u001a\u00020LH\u0002J&\u0010O\u001a\u00020L2\u0006\u0010P\u001a\u00020\u001a2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010R\u001a\u000204H\u0007J\u0018\u0010S\u001a\u00020L2\u0006\u0010R\u001a\u0002042\u0006\u0010T\u001a\u00020UH\u0002J\u0018\u0010V\u001a\u00020L2\u0006\u0010R\u001a\u0002042\u0006\u0010W\u001a\u00020\u001eH\u0002J\u0018\u0010X\u001a\u00020L2\u0006\u0010R\u001a\u0002042\u0006\u0010T\u001a\u00020UH\u0002J\u0018\u0010Y\u001a\u00020L2\u0006\u0010R\u001a\u0002042\u0006\u0010T\u001a\u00020UH\u0002J\u0018\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[2\b\u0010M\u001a\u0004\u0018\u00010\u001eH\u0002J\u000e\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u001aJ \u0010`\u001a\u00020L2\u0006\u0010R\u001a\u0002042\u0006\u0010a\u001a\u0002042\b\u0010W\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010b\u001a\u00020L2\u0006\u0010c\u001a\u00020\u0005J\u000e\u0010d\u001a\u00020L2\u0006\u0010e\u001a\u00020\u0005J5\u0010f\u001a\u00020L2\b\b\u0002\u0010R\u001a\u0002042\b\b\u0002\u0010g\u001a\u00020^2\u0012\u0010h\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0i\"\u00020\u001aH\u0007¢\u0006\u0002\u0010jJ\u001e\u0010k\u001a\u00020L2\b\b\u0002\u0010R\u001a\u0002042\n\b\u0002\u0010l\u001a\u0004\u0018\u00010mH\u0007J\b\u0010n\u001a\u00020LH\u0007J0\u0010o\u001a\u00020L2\b\b\u0002\u0010R\u001a\u0002042\b\b\u0002\u0010p\u001a\u00020\u001c2\b\b\u0002\u0010q\u001a\u00020\u001c2\b\b\u0002\u0010r\u001a\u00020\u001aH\u0007J\u0010\u0010s\u001a\u00020^2\u0006\u0010t\u001a\u00020UH\u0002R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00105\u001a\u0002042\u0006\u00103\u001a\u000204@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010:\u001a\u0002042\u0006\u00103\u001a\u000204@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00107\"\u0004\b<\u00109R$\u0010=\u001a\u0002042\u0006\u00103\u001a\u000204@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00107\"\u0004\b?\u00109R$\u0010@\u001a\u0002042\u0006\u00103\u001a\u000204@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00107\"\u0004\bB\u00109R\u0014\u0010C\u001a\u00020\u001e8CX\u0004¢\u0006\u0006\u001a\u0004\bD\u0010 R\u001c\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006v"}, d2 = {"Lcom/anggrayudi/storage/SimpleStorage;", "", "activity", "Landroid/app/Activity;", "savedState", "Landroid/os/Bundle;", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "Landroidx/activity/ComponentActivity;", "(Landroidx/activity/ComponentActivity;Landroid/os/Bundle;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;)V", "wrapper", "Lcom/anggrayudi/storage/ComponentWrapper;", "(Lcom/anggrayudi/storage/ComponentWrapper;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "createFileCallback", "Lcom/anggrayudi/storage/callback/CreateFileCallback;", "getCreateFileCallback", "()Lcom/anggrayudi/storage/callback/CreateFileCallback;", "setCreateFileCallback", "(Lcom/anggrayudi/storage/callback/CreateFileCallback;)V", "expectedBasePathForAccessRequest", "", "expectedStorageTypeForAccessRequest", "Lcom/anggrayudi/storage/file/StorageType;", "externalStorageRootAccessIntent", "Landroid/content/Intent;", "getExternalStorageRootAccessIntent", "()Landroid/content/Intent;", "filePickerCallback", "Lcom/anggrayudi/storage/callback/FilePickerCallback;", "getFilePickerCallback", "()Lcom/anggrayudi/storage/callback/FilePickerCallback;", "setFilePickerCallback", "(Lcom/anggrayudi/storage/callback/FilePickerCallback;)V", "fileReceiverCallback", "Lcom/anggrayudi/storage/callback/FileReceiverCallback;", "getFileReceiverCallback", "()Lcom/anggrayudi/storage/callback/FileReceiverCallback;", "setFileReceiverCallback", "(Lcom/anggrayudi/storage/callback/FileReceiverCallback;)V", "folderPickerCallback", "Lcom/anggrayudi/storage/callback/FolderPickerCallback;", "getFolderPickerCallback", "()Lcom/anggrayudi/storage/callback/FolderPickerCallback;", "setFolderPickerCallback", "(Lcom/anggrayudi/storage/callback/FolderPickerCallback;)V", "value", "", "requestCodeCreateFile", "getRequestCodeCreateFile", "()I", "setRequestCodeCreateFile", "(I)V", "requestCodeFilePicker", "getRequestCodeFilePicker", "setRequestCodeFilePicker", "requestCodeFolderPicker", "getRequestCodeFolderPicker", "setRequestCodeFolderPicker", "requestCodeStorageAccess", "getRequestCodeStorageAccess", "setRequestCodeStorageAccess", "sdCardRootAccessIntent", "getSdCardRootAccessIntent", "storageAccessCallback", "Lcom/anggrayudi/storage/callback/StorageAccessCallback;", "getStorageAccessCallback", "()Lcom/anggrayudi/storage/callback/StorageAccessCallback;", "setStorageAccessCallback", "(Lcom/anggrayudi/storage/callback/StorageAccessCallback;)V", "checkIfFileReceived", "", "intent", "checkRequestCode", "createFile", "mimeType", "fileName", "requestCode", "handleActivityResultForCreateFile", "uri", "Landroid/net/Uri;", "handleActivityResultForFilePicker", "data", "handleActivityResultForFolderPicker", "handleActivityResultForStorageAccess", "intentToDocumentFiles", "", "Landroidx/documentfile/provider/DocumentFile;", "isStorageAccessGranted", "", "storageId", "onActivityResult", "resultCode", "onRestoreInstanceState", "savedInstanceState", "onSaveInstanceState", "outState", "openFilePicker", "allowMultiple", "filterMimeTypes", "", "(IZ[Ljava/lang/String;)V", "openFolderPicker", "initialPath", "Lcom/anggrayudi/storage/file/FileFullPath;", "requestFullStorageAccess", "requestStorageAccess", "initialRootPath", "expectedStorageType", "expectedBasePath", "saveUriPermission", "root", "Companion", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleStorage.kt */
public final class SimpleStorage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_EXPECTED_BASE_PATH_FOR_ACCESS_REQUEST = "com.anggrayudi.storage.expectedBasePathForAccessRequest";
    private static final String KEY_EXPECTED_STORAGE_TYPE_FOR_ACCESS_REQUEST = "com.anggrayudi.storage.expectedStorageTypeForAccessRequest";
    private static final String KEY_REQUEST_CODE_CREATE_FILE = "com.anggrayudi.storage.requestCodeCreateFile";
    private static final String KEY_REQUEST_CODE_FILE_PICKER = "com.anggrayudi.storage.requestCodeFilePicker";
    private static final String KEY_REQUEST_CODE_FOLDER_PICKER = "com.anggrayudi.storage.requestCodeFolderPicker";
    private static final String KEY_REQUEST_CODE_FRAGMENT_PICKER = "com.anggrayudi.storage.requestCodeFragmentPicker";
    private static final String KEY_REQUEST_CODE_STORAGE_ACCESS = "com.anggrayudi.storage.requestCodeStorageAccess";
    private CreateFileCallback createFileCallback;
    private String expectedBasePathForAccessRequest;
    private StorageType expectedStorageTypeForAccessRequest;
    private FilePickerCallback filePickerCallback;
    private FileReceiverCallback fileReceiverCallback;
    private FolderPickerCallback folderPickerCallback;
    private int requestCodeCreateFile;
    private int requestCodeFilePicker;
    private int requestCodeFolderPicker;
    private int requestCodeStorageAccess;
    private StorageAccessCallback storageAccessCallback;
    private final ComponentWrapper wrapper;

    @JvmStatic
    public static final void cleanupRedundantUriPermissions(Context context) {
        Companion.cleanupRedundantUriPermissions(context);
    }

    @JvmStatic
    public static final Intent getDefaultExternalStorageIntent(Context context) {
        return Companion.getDefaultExternalStorageIntent(context);
    }

    public static final String getExternalStoragePath() {
        return Companion.getExternalStoragePath();
    }

    @JvmStatic
    public static final boolean hasFullDiskAccess(Context context, String str) {
        return Companion.hasFullDiskAccess(context, str);
    }

    @JvmStatic
    public static final boolean hasStorageAccess(Context context, String str) {
        return Companion.hasStorageAccess(context, str);
    }

    @JvmStatic
    public static final boolean hasStorageAccess(Context context, String str, boolean z) {
        return Companion.hasStorageAccess(context, str, z);
    }

    @JvmStatic
    public static final boolean hasStoragePermission(Context context) {
        return Companion.hasStoragePermission(context);
    }

    @JvmStatic
    public static final boolean hasStorageReadPermission(Context context) {
        return Companion.hasStorageReadPermission(context);
    }

    public static final boolean isSdCardPresent() {
        return Companion.isSdCardPresent();
    }

    public final void createFile(String str) {
        Intrinsics.checkNotNullParameter(str, "mimeType");
        createFile$default(this, str, (String) null, 0, 6, (Object) null);
    }

    public final void createFile(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "mimeType");
        createFile$default(this, str, str2, 0, 4, (Object) null);
    }

    public final void openFilePicker(int i, String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "filterMimeTypes");
        openFilePicker$default(this, i, false, strArr, 2, (Object) null);
    }

    public final void openFilePicker(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "filterMimeTypes");
        openFilePicker$default(this, 0, false, strArr, 3, (Object) null);
    }

    public final void openFolderPicker() {
        openFolderPicker$default(this, 0, (FileFullPath) null, 3, (Object) null);
    }

    public final void openFolderPicker(int i) {
        openFolderPicker$default(this, i, (FileFullPath) null, 2, (Object) null);
    }

    public final void requestStorageAccess() {
        requestStorageAccess$default(this, 0, (StorageType) null, (StorageType) null, (String) null, 15, (Object) null);
    }

    public final void requestStorageAccess(int i) {
        requestStorageAccess$default(this, i, (StorageType) null, (StorageType) null, (String) null, 14, (Object) null);
    }

    public final void requestStorageAccess(int i, StorageType storageType) {
        Intrinsics.checkNotNullParameter(storageType, "initialRootPath");
        requestStorageAccess$default(this, i, storageType, (StorageType) null, (String) null, 12, (Object) null);
    }

    public final void requestStorageAccess(int i, StorageType storageType, StorageType storageType2) {
        Intrinsics.checkNotNullParameter(storageType, "initialRootPath");
        Intrinsics.checkNotNullParameter(storageType2, "expectedStorageType");
        requestStorageAccess$default(this, i, storageType, storageType2, (String) null, 8, (Object) null);
    }

    private SimpleStorage(ComponentWrapper componentWrapper) {
        this.wrapper = componentWrapper;
        this.requestCodeStorageAccess = 1;
        this.requestCodeFolderPicker = 2;
        this.requestCodeFilePicker = 3;
        this.requestCodeCreateFile = 4;
        this.expectedStorageTypeForAccessRequest = StorageType.UNKNOWN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleStorage(Activity activity, Bundle bundle) {
        this(new ActivityWrapper(activity));
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (bundle != null) {
            onRestoreInstanceState(bundle);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleStorage(Activity activity, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i & 2) != 0 ? null : bundle);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleStorage(ComponentActivity componentActivity, Bundle bundle) {
        this(new ComponentActivityWrapper(componentActivity));
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        if (bundle != null) {
            onRestoreInstanceState(bundle);
        }
        ((ComponentActivityWrapper) this.wrapper).setStorage(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleStorage(ComponentActivity componentActivity, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentActivity, (i & 2) != 0 ? null : bundle);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleStorage(Fragment fragment, Bundle bundle) {
        this(new FragmentWrapper(fragment));
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (bundle != null) {
            onRestoreInstanceState(bundle);
        }
        ((FragmentWrapper) this.wrapper).setStorage(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleStorage(Fragment fragment, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, (i & 2) != 0 ? null : bundle);
    }

    public final StorageAccessCallback getStorageAccessCallback() {
        return this.storageAccessCallback;
    }

    public final void setStorageAccessCallback(StorageAccessCallback storageAccessCallback2) {
        this.storageAccessCallback = storageAccessCallback2;
    }

    public final FolderPickerCallback getFolderPickerCallback() {
        return this.folderPickerCallback;
    }

    public final void setFolderPickerCallback(FolderPickerCallback folderPickerCallback2) {
        this.folderPickerCallback = folderPickerCallback2;
    }

    public final FilePickerCallback getFilePickerCallback() {
        return this.filePickerCallback;
    }

    public final void setFilePickerCallback(FilePickerCallback filePickerCallback2) {
        this.filePickerCallback = filePickerCallback2;
    }

    public final CreateFileCallback getCreateFileCallback() {
        return this.createFileCallback;
    }

    public final void setCreateFileCallback(CreateFileCallback createFileCallback2) {
        this.createFileCallback = createFileCallback2;
    }

    public final FileReceiverCallback getFileReceiverCallback() {
        return this.fileReceiverCallback;
    }

    public final void setFileReceiverCallback(FileReceiverCallback fileReceiverCallback2) {
        this.fileReceiverCallback = fileReceiverCallback2;
    }

    public final int getRequestCodeStorageAccess() {
        return this.requestCodeStorageAccess;
    }

    public final void setRequestCodeStorageAccess(int i) {
        this.requestCodeStorageAccess = i;
        checkRequestCode();
    }

    public final int getRequestCodeFolderPicker() {
        return this.requestCodeFolderPicker;
    }

    public final void setRequestCodeFolderPicker(int i) {
        this.requestCodeFolderPicker = i;
        checkRequestCode();
    }

    public final int getRequestCodeFilePicker() {
        return this.requestCodeFilePicker;
    }

    public final void setRequestCodeFilePicker(int i) {
        this.requestCodeFilePicker = i;
        checkRequestCode();
    }

    public final int getRequestCodeCreateFile() {
        return this.requestCodeCreateFile;
    }

    public final void setRequestCodeCreateFile(int i) {
        this.requestCodeCreateFile = i;
        checkRequestCode();
    }

    public final Context getContext() {
        return this.wrapper.getContext();
    }

    private final Intent getExternalStorageRootAccessIntent() {
        if (Build.VERSION.SDK_INT < 29) {
            return Companion.getDefaultExternalStorageIntent(getContext());
        }
        Object systemService = getContext().getSystemService("storage");
        if (systemService != null) {
            Intent createOpenDocumentTreeIntent = ((StorageManager) systemService).getPrimaryStorageVolume().createOpenDocumentTreeIntent();
            Intrinsics.checkNotNullExpressionValue(createOpenDocumentTreeIntent, "{\n            val sm = c…entTreeIntent()\n        }");
            return createOpenDocumentTreeIntent;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.storage.StorageManager");
    }

    private final Intent getSdCardRootAccessIntent() {
        Intent intent;
        Object obj;
        Intent createAccessIntent;
        Object systemService = getContext().getSystemService("storage");
        if (systemService != null) {
            List<StorageVolume> storageVolumes = ((StorageManager) systemService).getStorageVolumes();
            Intrinsics.checkNotNullExpressionValue(storageVolumes, "sm.storageVolumes");
            Iterator it = storageVolumes.iterator();
            while (true) {
                intent = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((StorageVolume) obj).isRemovable()) {
                    break;
                }
            }
            StorageVolume storageVolume = (StorageVolume) obj;
            if (storageVolume != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    createAccessIntent = storageVolume.createOpenDocumentTreeIntent();
                } else if (storageVolume.isPrimary()) {
                    createAccessIntent = Companion.getDefaultExternalStorageIntent(getContext());
                } else {
                    createAccessIntent = storageVolume.createAccessIntent((String) null);
                }
                intent = createAccessIntent;
            }
            return intent == null ? Companion.getDefaultExternalStorageIntent(getContext()) : intent;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.storage.StorageManager");
    }

    public final boolean isStorageAccessGranted(String str) {
        Intrinsics.checkNotNullParameter(str, "storageId");
        return DocumentFileCompat.isAccessGranted(getContext(), str);
    }

    public static /* synthetic */ void requestStorageAccess$default(SimpleStorage simpleStorage, int i, StorageType storageType, StorageType storageType2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = simpleStorage.requestCodeStorageAccess;
        }
        if ((i2 & 2) != 0) {
            storageType = StorageType.EXTERNAL;
        }
        if ((i2 & 4) != 0) {
            storageType2 = StorageType.UNKNOWN;
        }
        if ((i2 & 8) != 0) {
            str = "";
        }
        simpleStorage.requestStorageAccess(i, storageType, storageType2, str);
    }

    public final void requestStorageAccess(int i, StorageType storageType, StorageType storageType2, String str) {
        Intent intent;
        Intrinsics.checkNotNullParameter(storageType, "initialRootPath");
        Intrinsics.checkNotNullParameter(storageType2, "expectedStorageType");
        Intrinsics.checkNotNullParameter(str, "expectedBasePath");
        if (storageType == StorageType.DATA || storageType2 == StorageType.DATA) {
            throw new IllegalArgumentException("Cannot use StorageType.DATA because it is never available in Storage Access Framework's folder selector.");
        } else if (Build.VERSION.SDK_INT < 29 && !Companion.hasStoragePermission(getContext())) {
            StorageAccessCallback storageAccessCallback2 = this.storageAccessCallback;
            if (storageAccessCallback2 != null) {
                storageAccessCallback2.onStoragePermissionDenied(i);
            }
        } else if (storageType != StorageType.EXTERNAL || !storageType2.isExpected(storageType) || Build.VERSION.SDK_INT >= 29 || Companion.isSdCardPresent()) {
            if (storageType != StorageType.SD_CARD || Build.VERSION.SDK_INT < 24) {
                intent = getExternalStorageRootAccessIntent();
            } else {
                intent = getSdCardRootAccessIntent();
            }
            if (this.wrapper.startActivityForResult(intent, i)) {
                setRequestCodeStorageAccess(i);
                this.expectedStorageTypeForAccessRequest = storageType2;
                this.expectedBasePathForAccessRequest = str;
                return;
            }
            StorageAccessCallback storageAccessCallback3 = this.storageAccessCallback;
            if (storageAccessCallback3 != null) {
                storageAccessCallback3.onActivityHandlerNotFound(i, intent);
            }
        } else {
            DocumentFile rootDocumentFile$default = DocumentFileCompat.getRootDocumentFile$default(getContext(), StorageId.PRIMARY, true, false, 8, (Object) null);
            if (rootDocumentFile$default != null) {
                Uri uri = rootDocumentFile$default.getUri();
                Intrinsics.checkNotNullExpressionValue(uri, "root.uri");
                saveUriPermission(uri);
                StorageAccessCallback storageAccessCallback4 = this.storageAccessCallback;
                if (storageAccessCallback4 != null) {
                    storageAccessCallback4.onRootPathPermissionGranted(i, rootDocumentFile$default);
                }
            }
        }
    }

    public final void requestFullStorageAccess() {
        getContext().startActivity(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
    }

    public static /* synthetic */ void createFile$default(SimpleStorage simpleStorage, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            i = simpleStorage.requestCodeCreateFile;
        }
        simpleStorage.createFile(str, str2, i);
    }

    public final void createFile(String str, String str2, int i) {
        CreateFileCallback createFileCallback2;
        Intrinsics.checkNotNullParameter(str, "mimeType");
        setRequestCodeCreateFile(i);
        Intent type = new Intent("android.intent.action.CREATE_DOCUMENT").setType(str);
        Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_CRE…CUMENT).setType(mimeType)");
        if (str2 != null) {
            type.putExtra("android.intent.extra.TITLE", str2);
        }
        if (!this.wrapper.startActivityForResult(type, i) && (createFileCallback2 = this.createFileCallback) != null) {
            createFileCallback2.onActivityHandlerNotFound(i, type);
        }
    }

    public static /* synthetic */ void openFolderPicker$default(SimpleStorage simpleStorage, int i, FileFullPath fileFullPath, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = simpleStorage.requestCodeFolderPicker;
        }
        if ((i2 & 2) != 0) {
            fileFullPath = null;
        }
        simpleStorage.openFolderPicker(i, fileFullPath);
    }

    public final void openFolderPicker(int i, FileFullPath fileFullPath) {
        Intent intent;
        FolderPickerCallback folderPickerCallback2;
        Uri uri;
        setRequestCodeFolderPicker(i);
        if (Build.VERSION.SDK_INT > 28 || Companion.hasStoragePermission(getContext())) {
            if (Build.VERSION.SDK_INT < 30) {
                intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            } else {
                intent = getExternalStorageRootAccessIntent();
            }
            if (!(fileFullPath == null || (uri = fileFullPath.getUri()) == null)) {
                DocumentFile fromTreeUri = ContextUtils.fromTreeUri(getContext(), uri);
                intent.putExtra("android.provider.extra.INITIAL_URI", fromTreeUri == null ? null : fromTreeUri.getUri());
            }
            if (!this.wrapper.startActivityForResult(intent, i) && (folderPickerCallback2 = this.folderPickerCallback) != null) {
                folderPickerCallback2.onActivityHandlerNotFound(i, intent);
                return;
            }
            return;
        }
        FolderPickerCallback folderPickerCallback3 = this.folderPickerCallback;
        if (folderPickerCallback3 != null) {
            folderPickerCallback3.onStoragePermissionDenied(i);
        }
    }

    public static /* synthetic */ void openFilePicker$default(SimpleStorage simpleStorage, int i, boolean z, String[] strArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = simpleStorage.requestCodeFilePicker;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        simpleStorage.openFilePicker(i, z, strArr);
    }

    public final void openFilePicker(int i, boolean z, String... strArr) {
        FilePickerCallback filePickerCallback2;
        Intrinsics.checkNotNullParameter(strArr, "filterMimeTypes");
        setRequestCodeFilePicker(i);
        Intent putExtra = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Intent.ACTION_OPE…_MULTIPLE, allowMultiple)");
        int length = strArr.length;
        String str = MimeType.UNKNOWN;
        if (length > 1) {
            putExtra.setType(str).putExtra("android.intent.extra.MIME_TYPES", strArr);
        } else {
            String str2 = (String) ArraysKt.firstOrNull((T[]) strArr);
            if (str2 != null) {
                str = str2;
            }
            putExtra.setType(str);
        }
        if (!this.wrapper.startActivityForResult(putExtra, i) && (filePickerCallback2 = this.filePickerCallback) != null) {
            filePickerCallback2.onActivityHandlerNotFound(i, putExtra);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) com.anggrayudi.storage.file.DocumentFileUtils.getBasePath(r1, getContext()), (java.lang.Object) r12.expectedBasePathForAccessRequest) == false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleActivityResultForStorageAccess(int r13, android.net.Uri r14) {
        /*
            r12 = this;
            android.content.Context r0 = r12.getContext()
            java.lang.String r0 = com.anggrayudi.storage.extension.UriUtils.getStorageId(r14, r0)
            com.anggrayudi.storage.file.StorageType$Companion r1 = com.anggrayudi.storage.file.StorageType.Companion
            com.anggrayudi.storage.file.StorageType r6 = r1.fromStorageId(r0)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 0
            r4 = 29
            if (r1 <= r4) goto L_0x005f
            android.content.Context r1 = r12.getContext()
            androidx.documentfile.provider.DocumentFile r1 = androidx.documentfile.provider.DocumentFile.fromTreeUri(r1, r14)
            if (r1 != 0) goto L_0x0021
            return
        L_0x0021:
            com.anggrayudi.storage.file.StorageType r5 = r12.expectedStorageTypeForAccessRequest
            boolean r5 = r5.isExpected(r6)
            if (r5 == 0) goto L_0x004b
            java.lang.String r5 = r12.expectedBasePathForAccessRequest
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0038
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r5 = 0
            goto L_0x0039
        L_0x0038:
            r5 = 1
        L_0x0039:
            if (r5 != 0) goto L_0x008e
            android.content.Context r5 = r12.getContext()
            java.lang.String r5 = com.anggrayudi.storage.file.DocumentFileUtils.getBasePath(r1, r5)
            java.lang.String r7 = r12.expectedBasePathForAccessRequest
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 != 0) goto L_0x008e
        L_0x004b:
            com.anggrayudi.storage.callback.StorageAccessCallback r2 = r12.storageAccessCallback
            if (r2 != 0) goto L_0x0050
            goto L_0x005e
        L_0x0050:
            java.lang.String r14 = r12.expectedBasePathForAccessRequest
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            com.anggrayudi.storage.file.StorageType r7 = r12.expectedStorageTypeForAccessRequest
            r3 = r13
            r4 = r1
            r5 = r6
            r6 = r14
            r2.onExpectedStorageNotSelected(r3, r4, r5, r6, r7)
        L_0x005e:
            return
        L_0x005f:
            com.anggrayudi.storage.file.StorageType r1 = r12.expectedStorageTypeForAccessRequest
            boolean r1 = r1.isExpected(r6)
            if (r1 != 0) goto L_0x008e
            android.content.Context r0 = r12.getContext()
            androidx.documentfile.provider.DocumentFile r0 = com.anggrayudi.storage.extension.ContextUtils.fromTreeUri(r0, r14)
            if (r0 != 0) goto L_0x0072
            goto L_0x007a
        L_0x0072:
            android.content.Context r1 = r12.getContext()
            java.lang.String r3 = com.anggrayudi.storage.file.DocumentFileUtils.getAbsolutePath(r0, r1)
        L_0x007a:
            if (r3 != 0) goto L_0x0080
            java.lang.String r0 = ""
            r4 = r0
            goto L_0x0081
        L_0x0080:
            r4 = r3
        L_0x0081:
            com.anggrayudi.storage.callback.StorageAccessCallback r2 = r12.storageAccessCallback
            if (r2 != 0) goto L_0x0086
            goto L_0x008d
        L_0x0086:
            com.anggrayudi.storage.file.StorageType r7 = r12.expectedStorageTypeForAccessRequest
            r3 = r13
            r5 = r14
            r2.onRootPathNotSelected(r3, r4, r5, r6, r7)
        L_0x008d:
            return
        L_0x008e:
            boolean r1 = com.anggrayudi.storage.extension.UriUtils.isDownloadsDocument(r14)
            if (r1 == 0) goto L_0x00e2
            java.lang.String r0 = r14.toString()
            java.lang.String r1 = "content://com.android.providers.downloads.documents/tree/downloads"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x00b7
            r12.saveUriPermission(r14)
            com.anggrayudi.storage.callback.StorageAccessCallback r0 = r12.storageAccessCallback
            if (r0 != 0) goto L_0x00a8
            goto L_0x00e1
        L_0x00a8:
            android.content.Context r1 = r12.getContext()
            androidx.documentfile.provider.DocumentFile r14 = com.anggrayudi.storage.extension.ContextUtils.fromTreeUri(r1, r14)
            if (r14 != 0) goto L_0x00b3
            return
        L_0x00b3:
            r0.onRootPathPermissionGranted(r13, r14)
            goto L_0x00e1
        L_0x00b7:
            com.anggrayudi.storage.callback.StorageAccessCallback r1 = r12.storageAccessCallback
            if (r1 != 0) goto L_0x00bc
            goto L_0x00e1
        L_0x00bc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.anggrayudi.storage.SimpleStorage$Companion r2 = Companion
            java.lang.String r2 = r2.getExternalStoragePath()
            r0.append(r2)
            r2 = 47
            r0.append(r2)
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS
            r0.append(r2)
            java.lang.String r3 = r0.toString()
            com.anggrayudi.storage.file.StorageType r5 = com.anggrayudi.storage.file.StorageType.EXTERNAL
            com.anggrayudi.storage.file.StorageType r6 = r12.expectedStorageTypeForAccessRequest
            r2 = r13
            r4 = r14
            r1.onRootPathNotSelected(r2, r3, r4, r5, r6)
        L_0x00e1:
            return
        L_0x00e2:
            int r1 = android.os.Build.VERSION.SDK_INT
            r5 = 30
            if (r1 >= r5) goto L_0x0103
            boolean r1 = com.anggrayudi.storage.extension.UriUtils.isExternalStorageDocument(r14)
            if (r1 != 0) goto L_0x0103
            com.anggrayudi.storage.callback.StorageAccessCallback r6 = r12.storageAccessCallback
            if (r6 != 0) goto L_0x00f3
            goto L_0x0102
        L_0x00f3:
            com.anggrayudi.storage.SimpleStorage$Companion r0 = Companion
            java.lang.String r8 = r0.getExternalStoragePath()
            com.anggrayudi.storage.file.StorageType r10 = com.anggrayudi.storage.file.StorageType.EXTERNAL
            com.anggrayudi.storage.file.StorageType r11 = r12.expectedStorageTypeForAccessRequest
            r7 = r13
            r9 = r14
            r6.onRootPathNotSelected(r7, r8, r9, r10, r11)
        L_0x0102:
            return
        L_0x0103:
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r6 = "primary"
            if (r1 >= r4) goto L_0x0126
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r1 == 0) goto L_0x0126
            r12.saveUriPermission(r14)
            com.anggrayudi.storage.callback.StorageAccessCallback r0 = r12.storageAccessCallback
            if (r0 != 0) goto L_0x0117
            goto L_0x0125
        L_0x0117:
            android.content.Context r1 = r12.getContext()
            androidx.documentfile.provider.DocumentFile r14 = com.anggrayudi.storage.extension.ContextUtils.fromTreeUri(r1, r14)
            if (r14 != 0) goto L_0x0122
            return
        L_0x0122:
            r0.onRootPathPermissionGranted(r13, r14)
        L_0x0125:
            return
        L_0x0126:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 >= r5) goto L_0x01c9
            boolean r1 = com.anggrayudi.storage.file.DocumentFileCompat.isRootUri(r14)
            if (r1 == 0) goto L_0x0132
            goto L_0x01c9
        L_0x0132:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r1 == 0) goto L_0x014f
            com.anggrayudi.storage.callback.StorageAccessCallback r5 = r12.storageAccessCallback
            if (r5 != 0) goto L_0x013e
            goto L_0x01eb
        L_0x013e:
            com.anggrayudi.storage.SimpleStorage$Companion r0 = Companion
            java.lang.String r7 = r0.getExternalStoragePath()
            com.anggrayudi.storage.file.StorageType r9 = com.anggrayudi.storage.file.StorageType.EXTERNAL
            com.anggrayudi.storage.file.StorageType r10 = r12.expectedStorageTypeForAccessRequest
            r6 = r13
            r8 = r14
            r5.onRootPathNotSelected(r6, r7, r8, r9, r10)
            goto L_0x01eb
        L_0x014f:
            int r1 = android.os.Build.VERSION.SDK_INT
            r5 = 24
            if (r1 < r5) goto L_0x01b3
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 >= r4) goto L_0x01b3
            android.content.Context r1 = r12.getContext()
            java.lang.String r4 = "storage"
            java.lang.Object r1 = r1.getSystemService(r4)
            if (r1 == 0) goto L_0x01ab
            android.os.storage.StorageManager r1 = (android.os.storage.StorageManager) r1
            java.util.List r1 = r1.getStorageVolumes()
            java.lang.String r4 = "sm.storageVolumes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0176:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x018b
            java.lang.Object r4 = r1.next()
            r5 = r4
            android.os.storage.StorageVolume r5 = (android.os.storage.StorageVolume) r5
            boolean r5 = r5.isPrimary()
            r5 = r5 ^ r2
            if (r5 == 0) goto L_0x0176
            goto L_0x018c
        L_0x018b:
            r4 = r3
        L_0x018c:
            android.os.storage.StorageVolume r4 = (android.os.storage.StorageVolume) r4
            if (r4 != 0) goto L_0x0191
            goto L_0x01b3
        L_0x0191:
            android.content.Intent r1 = r4.createAccessIntent(r3)
            if (r1 != 0) goto L_0x0198
            goto L_0x01b3
        L_0x0198:
            com.anggrayudi.storage.ComponentWrapper r14 = r12.wrapper
            boolean r14 = r14.startActivityForResult(r1, r13)
            if (r14 != 0) goto L_0x01aa
            com.anggrayudi.storage.callback.StorageAccessCallback r14 = r12.getStorageAccessCallback()
            if (r14 != 0) goto L_0x01a7
            goto L_0x01aa
        L_0x01a7:
            r14.onActivityHandlerNotFound(r13, r1)
        L_0x01aa:
            return
        L_0x01ab:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            java.lang.String r14 = "null cannot be cast to non-null type android.os.storage.StorageManager"
            r13.<init>(r14)
            throw r13
        L_0x01b3:
            com.anggrayudi.storage.callback.StorageAccessCallback r1 = r12.storageAccessCallback
            if (r1 != 0) goto L_0x01b8
            goto L_0x01eb
        L_0x01b8:
            java.lang.String r2 = "/storage/"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
            com.anggrayudi.storage.file.StorageType r4 = com.anggrayudi.storage.file.StorageType.SD_CARD
            com.anggrayudi.storage.file.StorageType r5 = r12.expectedStorageTypeForAccessRequest
            r0 = r1
            r1 = r13
            r3 = r14
            r0.onRootPathNotSelected(r1, r2, r3, r4, r5)
            goto L_0x01eb
        L_0x01c9:
            boolean r0 = r12.saveUriPermission(r14)
            if (r0 == 0) goto L_0x01e3
            com.anggrayudi.storage.callback.StorageAccessCallback r0 = r12.storageAccessCallback
            if (r0 != 0) goto L_0x01d4
            goto L_0x01eb
        L_0x01d4:
            android.content.Context r1 = r12.getContext()
            androidx.documentfile.provider.DocumentFile r14 = com.anggrayudi.storage.extension.ContextUtils.fromTreeUri(r1, r14)
            if (r14 != 0) goto L_0x01df
            return
        L_0x01df:
            r0.onRootPathPermissionGranted(r13, r14)
            goto L_0x01eb
        L_0x01e3:
            com.anggrayudi.storage.callback.StorageAccessCallback r14 = r12.storageAccessCallback
            if (r14 != 0) goto L_0x01e8
            goto L_0x01eb
        L_0x01e8:
            r14.onStoragePermissionDenied(r13)
        L_0x01eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.SimpleStorage.handleActivityResultForStorageAccess(int, android.net.Uri):void");
    }

    private final void handleActivityResultForFolderPicker(int i, Uri uri) {
        DocumentFile fromTreeUri = ContextUtils.fromTreeUri(getContext(), uri);
        String storageId = UriUtils.getStorageId(uri, getContext());
        StorageType fromStorageId = StorageType.Companion.fromStorageId(storageId);
        if (fromTreeUri == null || !DocumentFileUtils.canModify(fromTreeUri, getContext())) {
            FolderPickerCallback folderPickerCallback2 = this.folderPickerCallback;
            if (folderPickerCallback2 != null) {
                folderPickerCallback2.onStorageAccessDenied(i, fromTreeUri, fromStorageId);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual((Object) uri.toString(), (Object) DocumentFileCompat.DOWNLOADS_TREE_URI) || (DocumentFileCompat.isRootUri(uri) && (((Build.VERSION.SDK_INT < 24 && fromStorageId == StorageType.SD_CARD) || Build.VERSION.SDK_INT == 29) && !DocumentFileCompat.isStorageUriPermissionGranted$default(getContext(), storageId, (String) null, 4, (Object) null)))) {
            saveUriPermission(uri);
        }
        if ((Build.VERSION.SDK_INT >= 29 || fromStorageId != StorageType.EXTERNAL) && ((Build.VERSION.SDK_INT < 30 || !saveUriPermission(uri)) && ((UriUtils.isExternalStorageDocument(uri) || !DocumentFileUtils.canModify(fromTreeUri, getContext())) && !DocumentFileCompat.isStorageUriPermissionGranted$default(getContext(), storageId, (String) null, 4, (Object) null)))) {
            FolderPickerCallback folderPickerCallback3 = this.folderPickerCallback;
            if (folderPickerCallback3 != null) {
                folderPickerCallback3.onStorageAccessDenied(i, fromTreeUri, fromStorageId);
                return;
            }
            return;
        }
        FolderPickerCallback folderPickerCallback4 = this.folderPickerCallback;
        if (folderPickerCallback4 != null) {
            folderPickerCallback4.onFolderSelected(i, fromTreeUri);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        if ((!r4.isEmpty()) != false) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x005c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<androidx.documentfile.provider.DocumentFile> intentToDocumentFiles(android.content.Intent r10) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            if (r10 != 0) goto L_0x0007
        L_0x0005:
            r4 = r2
            goto L_0x003a
        L_0x0007:
            android.content.ClipData r3 = r10.getClipData()
            if (r3 != 0) goto L_0x000e
            goto L_0x0005
        L_0x000e:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
            int r5 = r3.getItemCount()
            r6 = 0
        L_0x001a:
            if (r6 >= r5) goto L_0x0030
            int r7 = r6 + 1
            android.content.ClipData$Item r6 = r3.getItemAt(r6)
            android.net.Uri r6 = r6.getUri()
            java.lang.String r8 = "getItemAt(i).uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
            r4.add(r6)
            r6 = r7
            goto L_0x001a
        L_0x0030:
            r3 = r4
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r0
            if (r3 == 0) goto L_0x0005
        L_0x003a:
            if (r4 != 0) goto L_0x004f
            if (r10 != 0) goto L_0x0040
            r10 = r2
            goto L_0x0044
        L_0x0040:
            android.net.Uri r10 = r10.getData()
        L_0x0044:
            if (r10 != 0) goto L_0x004b
            java.util.List r10 = kotlin.collections.CollectionsKt.emptyList()
            return r10
        L_0x004b:
            java.util.List r4 = kotlin.collections.CollectionsKt.listOf(r10)
        L_0x004f:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r3 = r4.iterator()
        L_0x005c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00b3
            java.lang.Object r4 = r3.next()
            android.net.Uri r4 = (android.net.Uri) r4
            java.lang.String r5 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            boolean r5 = com.anggrayudi.storage.extension.UriUtils.isDownloadsDocument(r4)
            if (r5 == 0) goto L_0x00a4
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 28
            if (r5 >= r6) goto L_0x00a4
            java.lang.String r5 = r4.getPath()
            r6 = 2
            java.lang.String r7 = "/document/raw:"
            if (r5 != 0) goto L_0x0085
        L_0x0083:
            r5 = 0
            goto L_0x008c
        L_0x0085:
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r5, r7, r1, r6, r2)
            if (r5 != r0) goto L_0x0083
            r5 = 1
        L_0x008c:
            if (r5 == 0) goto L_0x00a4
            java.lang.String r4 = r4.getPath()
            if (r4 != 0) goto L_0x0096
            java.lang.String r4 = ""
        L_0x0096:
            java.lang.String r4 = kotlin.text.StringsKt.substringAfterLast$default((java.lang.String) r4, (java.lang.String) r7, (java.lang.String) r2, (int) r6, (java.lang.Object) r2)
            java.io.File r5 = new java.io.File
            r5.<init>(r4)
            androidx.documentfile.provider.DocumentFile r4 = androidx.documentfile.provider.DocumentFile.fromFile(r5)
            goto L_0x00ac
        L_0x00a4:
            android.content.Context r5 = r9.getContext()
            androidx.documentfile.provider.DocumentFile r4 = com.anggrayudi.storage.extension.ContextUtils.fromSingleUri(r5, r4)
        L_0x00ac:
            if (r4 != 0) goto L_0x00af
            goto L_0x005c
        L_0x00af:
            r10.add(r4)
            goto L_0x005c
        L_0x00b3:
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r10 = r10.iterator()
        L_0x00c2:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x00d9
            java.lang.Object r1 = r10.next()
            r2 = r1
            androidx.documentfile.provider.DocumentFile r2 = (androidx.documentfile.provider.DocumentFile) r2
            boolean r2 = r2.isFile()
            if (r2 == 0) goto L_0x00c2
            r0.add(r1)
            goto L_0x00c2
        L_0x00d9:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.SimpleStorage.intentToDocumentFiles(android.content.Intent):java.util.List");
    }

    public final void checkIfFileReceived(Intent intent) {
        String action = intent == null ? null : intent.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1173264947) {
                if (hashCode != -58484670 || !action.equals("android.intent.action.SEND_MULTIPLE")) {
                    return;
                }
            } else if (!action.equals("android.intent.action.SEND")) {
                return;
            }
            List<DocumentFile> intentToDocumentFiles = intentToDocumentFiles(intent);
            if (intentToDocumentFiles.isEmpty()) {
                FileReceiverCallback fileReceiverCallback2 = this.fileReceiverCallback;
                if (fileReceiverCallback2 != null) {
                    fileReceiverCallback2.onNonFileReceived(intent);
                    return;
                }
                return;
            }
            FileReceiverCallback fileReceiverCallback3 = this.fileReceiverCallback;
            if (fileReceiverCallback3 != null) {
                fileReceiverCallback3.onFileReceived(intentToDocumentFiles);
            }
        }
    }

    private final void handleActivityResultForFilePicker(int i, Intent intent) {
        List<DocumentFile> intentToDocumentFiles = intentToDocumentFiles(intent);
        boolean z = true;
        if (!intentToDocumentFiles.isEmpty()) {
            Iterable iterable = intentToDocumentFiles;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((DocumentFile) it.next()).canRead()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z) {
                FilePickerCallback filePickerCallback2 = this.filePickerCallback;
                if (filePickerCallback2 != null) {
                    filePickerCallback2.onFileSelected(i, intentToDocumentFiles);
                    return;
                }
                return;
            }
        }
        FilePickerCallback filePickerCallback3 = this.filePickerCallback;
        if (filePickerCallback3 != null) {
            filePickerCallback3.onStoragePermissionDenied(i, intentToDocumentFiles);
        }
    }

    private final void handleActivityResultForCreateFile(int i, Uri uri) {
        CreateFileCallback createFileCallback2;
        DocumentFile fromUri = DocumentFileCompat.fromUri(getContext(), uri);
        if (fromUri != null && (createFileCallback2 = getCreateFileCallback()) != null) {
            createFileCallback2.onFileCreated(i, fromUri);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        checkRequestCode();
        Uri uri = null;
        if (i == this.requestCodeStorageAccess) {
            if (i2 == -1) {
                if (intent != null) {
                    uri = intent.getData();
                }
                if (uri != null) {
                    handleActivityResultForStorageAccess(i, uri);
                    return;
                }
                return;
            }
            StorageAccessCallback storageAccessCallback2 = this.storageAccessCallback;
            if (storageAccessCallback2 != null) {
                storageAccessCallback2.onCanceledByUser(i);
            }
        } else if (i == this.requestCodeFolderPicker) {
            if (i2 == -1) {
                if (intent != null) {
                    uri = intent.getData();
                }
                if (uri != null) {
                    handleActivityResultForFolderPicker(i, uri);
                    return;
                }
                return;
            }
            FolderPickerCallback folderPickerCallback2 = this.folderPickerCallback;
            if (folderPickerCallback2 != null) {
                folderPickerCallback2.onCanceledByUser(i);
            }
        } else if (i == this.requestCodeFilePicker) {
            if (i2 != -1) {
                FilePickerCallback filePickerCallback2 = this.filePickerCallback;
                if (filePickerCallback2 != null) {
                    filePickerCallback2.onCanceledByUser(i);
                }
            } else if (intent != null) {
                handleActivityResultForFilePicker(i, intent);
            }
        } else if (i == this.requestCodeCreateFile) {
            if (intent != null) {
                uri = intent.getData();
            }
            if (uri != null) {
                handleActivityResultForCreateFile(i, uri);
                return;
            }
            CreateFileCallback createFileCallback2 = this.createFileCallback;
            if (createFileCallback2 != null) {
                createFileCallback2.onCanceledByUser(i);
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putString(KEY_EXPECTED_BASE_PATH_FOR_ACCESS_REQUEST, this.expectedBasePathForAccessRequest);
        bundle.putInt(KEY_REQUEST_CODE_STORAGE_ACCESS, this.expectedStorageTypeForAccessRequest.ordinal());
        bundle.putInt(KEY_REQUEST_CODE_STORAGE_ACCESS, this.requestCodeStorageAccess);
        bundle.putInt(KEY_REQUEST_CODE_FOLDER_PICKER, this.requestCodeFolderPicker);
        bundle.putInt(KEY_REQUEST_CODE_FILE_PICKER, this.requestCodeFilePicker);
        bundle.putInt(KEY_REQUEST_CODE_CREATE_FILE, this.requestCodeCreateFile);
        ComponentWrapper componentWrapper = this.wrapper;
        if (componentWrapper instanceof FragmentWrapper) {
            bundle.putInt(KEY_REQUEST_CODE_FRAGMENT_PICKER, ((FragmentWrapper) componentWrapper).getRequestCode());
        }
    }

    public final void onRestoreInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "savedInstanceState");
        this.expectedBasePathForAccessRequest = bundle.getString(KEY_EXPECTED_BASE_PATH_FOR_ACCESS_REQUEST);
        this.expectedStorageTypeForAccessRequest = StorageType.values()[bundle.getInt(KEY_EXPECTED_STORAGE_TYPE_FOR_ACCESS_REQUEST)];
        setRequestCodeStorageAccess(bundle.getInt(KEY_REQUEST_CODE_STORAGE_ACCESS));
        setRequestCodeFolderPicker(bundle.getInt(KEY_REQUEST_CODE_FOLDER_PICKER));
        setRequestCodeFilePicker(bundle.getInt(KEY_REQUEST_CODE_FILE_PICKER));
        setRequestCodeCreateFile(bundle.getInt(KEY_REQUEST_CODE_CREATE_FILE));
        if ((this.wrapper instanceof FragmentWrapper) && bundle.containsKey(KEY_REQUEST_CODE_FRAGMENT_PICKER)) {
            ((FragmentWrapper) this.wrapper).setRequestCode(bundle.getInt(KEY_REQUEST_CODE_FRAGMENT_PICKER));
        }
    }

    private final void checkRequestCode() {
        if (SetsKt.setOf(Integer.valueOf(this.requestCodeFilePicker), Integer.valueOf(this.requestCodeFolderPicker), Integer.valueOf(this.requestCodeStorageAccess), Integer.valueOf(this.requestCodeCreateFile)).size() < 4) {
            throw new IllegalArgumentException("Request codes must be unique. File picker=" + this.requestCodeFilePicker + ", Folder picker=" + this.requestCodeFolderPicker + ", Storage access=" + this.requestCodeStorageAccess + ", Create file=" + this.requestCodeCreateFile);
        }
    }

    private final boolean saveUriPermission(Uri uri) {
        try {
            getContext().getContentResolver().takePersistableUriPermission(uri, 3);
            Companion companion = Companion;
            Context applicationContext = getContext().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            companion.cleanupRedundantUriPermissions(applicationContext);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J\"\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u0010H\u0007J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00108FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u000f\u0010\u0012¨\u0006 "}, d2 = {"Lcom/anggrayudi/storage/SimpleStorage$Companion;", "", "()V", "KEY_EXPECTED_BASE_PATH_FOR_ACCESS_REQUEST", "", "KEY_EXPECTED_STORAGE_TYPE_FOR_ACCESS_REQUEST", "KEY_REQUEST_CODE_CREATE_FILE", "KEY_REQUEST_CODE_FILE_PICKER", "KEY_REQUEST_CODE_FOLDER_PICKER", "KEY_REQUEST_CODE_FRAGMENT_PICKER", "KEY_REQUEST_CODE_STORAGE_ACCESS", "externalStoragePath", "getExternalStoragePath$annotations", "getExternalStoragePath", "()Ljava/lang/String;", "isSdCardPresent", "", "isSdCardPresent$annotations", "()Z", "cleanupRedundantUriPermissions", "", "context", "Landroid/content/Context;", "getDefaultExternalStorageIntent", "Landroid/content/Intent;", "hasFullDiskAccess", "storageId", "hasStorageAccess", "fullPath", "requiresWriteAccess", "hasStoragePermission", "hasStorageReadPermission", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SimpleStorage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getExternalStoragePath$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void isSdCardPresent$annotations() {
        }

        @JvmStatic
        public final boolean hasStorageAccess(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "fullPath");
            return hasStorageAccess$default(this, context, str, false, 4, (Object) null);
        }

        private Companion() {
        }

        public final String getExternalStoragePath() {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getExternalStorageDirectory().absolutePath");
            return absolutePath;
        }

        public final boolean isSdCardPresent() {
            return Intrinsics.areEqual((Object) Environment.getExternalStorageState(), (Object) "mounted");
        }

        @JvmStatic
        public final Intent getDefaultExternalStorageIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26) {
                Uri uri = null;
                DocumentFile fromTreeUri = ContextUtils.fromTreeUri(context, DocumentFileCompat.createDocumentUri$default(StorageId.PRIMARY, (String) null, 2, (Object) null));
                if (fromTreeUri != null) {
                    uri = fromTreeUri.getUri();
                }
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        @JvmStatic
        public final boolean hasStoragePermission(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && hasStorageReadPermission(context);
        }

        @JvmStatic
        public final boolean hasStorageReadPermission(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
        }

        @JvmStatic
        public final boolean hasFullDiskAccess(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "storageId");
            return hasStorageAccess$default(this, context, DocumentFileCompat.buildAbsolutePath(context, str, ""), false, 4, (Object) null);
        }

        public static /* synthetic */ boolean hasStorageAccess$default(Companion companion, Context context, String str, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            return companion.hasStorageAccess(context, str, z);
        }

        @JvmStatic
        public final boolean hasStorageAccess(Context context, String str, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "fullPath");
            return ((z && hasStoragePermission(context)) || (!z && hasStorageReadPermission(context))) && DocumentFileCompat.getAccessibleRootDocumentFile$default(context, str, z, false, 8, (Object) null) != null;
        }

        @JvmStatic
        public final void cleanupRedundantUriPermissions(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new SimpleStorage$Companion$cleanupRedundantUriPermissions$1(context), 31, (Object) null);
        }
    }
}
