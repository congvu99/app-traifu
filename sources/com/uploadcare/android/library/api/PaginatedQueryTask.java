package com.uploadcare.android.library.api;

import android.os.AsyncTask;
import com.facebook.internal.NativeProtocol;
import com.uploadcare.android.library.callbacks.UploadcareAllFilesCallback;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ-\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\f\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/uploadcare/android/library/api/PaginatedQueryTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "Lcom/uploadcare/android/library/api/UploadcareFile;", "queryBuilder", "Lcom/uploadcare/android/library/api/FilesQueryBuilder;", "callback", "Lcom/uploadcare/android/library/callbacks/UploadcareAllFilesCallback;", "(Lcom/uploadcare/android/library/api/FilesQueryBuilder;Lcom/uploadcare/android/library/callbacks/UploadcareAllFilesCallback;)V", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/util/List;", "onPostExecute", "", "result", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: FilesQueryBuilder.kt */
final class PaginatedQueryTask extends AsyncTask<Void, Void, List<? extends UploadcareFile>> {
    private final UploadcareAllFilesCallback callback;
    private final FilesQueryBuilder queryBuilder;

    public PaginatedQueryTask(FilesQueryBuilder filesQueryBuilder, UploadcareAllFilesCallback uploadcareAllFilesCallback) {
        Intrinsics.checkNotNullParameter(filesQueryBuilder, "queryBuilder");
        this.queryBuilder = filesQueryBuilder;
        this.callback = uploadcareAllFilesCallback;
    }

    /* access modifiers changed from: protected */
    public List<UploadcareFile> doInBackground(Void... voidArr) {
        Intrinsics.checkNotNullParameter(voidArr, NativeProtocol.WEB_DIALOG_PARAMS);
        try {
            return this.queryBuilder.asList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<UploadcareFile> list) {
        Unit unit;
        if (list != null) {
            UploadcareAllFilesCallback uploadcareAllFilesCallback = this.callback;
            if (uploadcareAllFilesCallback != null) {
                uploadcareAllFilesCallback.onSuccess(list);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        UploadcareAllFilesCallback uploadcareAllFilesCallback2 = this.callback;
        if (uploadcareAllFilesCallback2 != null) {
            uploadcareAllFilesCallback2.onFailure(new UploadcareApiException("Unexpected error"));
            Unit unit2 = Unit.INSTANCE;
        }
    }
}
