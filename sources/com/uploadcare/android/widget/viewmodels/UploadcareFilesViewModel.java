package com.uploadcare.android.widget.viewmodels;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.library.upload.Uploader;
import com.uploadcare.android.library.upload.UrlUploader;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.controller.UploadcareWidget;
import com.uploadcare.android.widget.data.SelectedFile;
import com.uploadcare.android.widget.data.SocialSource;
import com.uploadcare.android.widget.utils.SingleLiveEvent;
import com.uploadcare.android.widget.worker.FileUploadWorker;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010%\u001a\u00020&J\u0014\u0010'\u001a\u00020&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010)\u001a\u00020*H\u0002J\u000e\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0014J\u000e\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020\u0014J\u0006\u0010/\u001a\u00020&J.\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u00103\u001a\u00020&2\u0006\u00104\u001a\u000205H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\f¨\u00066"}, d2 = {"Lcom/uploadcare/android/widget/viewmodels/UploadcareFilesViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "backgroundUpload", "", "cancelable", "closeWidgetCommand", "Lcom/uploadcare/android/widget/utils/SingleLiveEvent;", "Lcom/uploadcare/android/library/exceptions/UploadcareApiException;", "getCloseWidgetCommand", "()Lcom/uploadcare/android/widget/utils/SingleLiveEvent;", "isRoot", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "progressDialogCommand", "Lcom/uploadcare/android/widget/viewmodels/ProgressData;", "getProgressDialogCommand", "showErrorCommand", "", "getShowErrorCommand", "showProgress", "socialSource", "Lcom/uploadcare/android/widget/data/SocialSource;", "storeUponUpload", "uploadCompleteCommand", "Lcom/uploadcare/android/library/api/UploadcareFile;", "getUploadCompleteCommand", "uploadProgress", "", "getUploadProgress", "uploader", "Lcom/uploadcare/android/library/upload/Uploader;", "uploadingInBackgroundCommand", "Ljava/util/UUID;", "getUploadingInBackgroundCommand", "canlcelUpload", "", "error", "e", "getContext", "Landroid/content/Context;", "saveCookie", "cookie", "selectFile", "fileUrl", "signOut", "start", "source", "store", "uploadFileFromUrl", "file", "Lcom/uploadcare/android/widget/data/SelectedFile;", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFilesViewModel.kt */
public final class UploadcareFilesViewModel extends AndroidViewModel {
    private boolean backgroundUpload;
    private boolean cancelable;
    private final SingleLiveEvent<UploadcareApiException> closeWidgetCommand = new SingleLiveEvent<>();
    private final MutableLiveData<Boolean> isRoot;
    private final SingleLiveEvent<ProgressData> progressDialogCommand = new SingleLiveEvent<>();
    private final SingleLiveEvent<String> showErrorCommand = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public boolean showProgress;
    private SocialSource socialSource;
    private boolean storeUponUpload;
    private final SingleLiveEvent<UploadcareFile> uploadCompleteCommand = new SingleLiveEvent<>();
    private final MutableLiveData<Integer> uploadProgress;
    /* access modifiers changed from: private */
    public Uploader uploader;
    private final SingleLiveEvent<UUID> uploadingInBackgroundCommand = new SingleLiveEvent<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadcareFilesViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(0);
        Unit unit = Unit.INSTANCE;
        this.uploadProgress = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(true);
        Unit unit2 = Unit.INSTANCE;
        this.isRoot = mutableLiveData2;
    }

    public final SingleLiveEvent<ProgressData> getProgressDialogCommand() {
        return this.progressDialogCommand;
    }

    public final SingleLiveEvent<UploadcareApiException> getCloseWidgetCommand() {
        return this.closeWidgetCommand;
    }

    public final SingleLiveEvent<UploadcareFile> getUploadCompleteCommand() {
        return this.uploadCompleteCommand;
    }

    public final SingleLiveEvent<UUID> getUploadingInBackgroundCommand() {
        return this.uploadingInBackgroundCommand;
    }

    public final SingleLiveEvent<String> getShowErrorCommand() {
        return this.showErrorCommand;
    }

    public final MutableLiveData<Integer> getUploadProgress() {
        return this.uploadProgress;
    }

    public final MutableLiveData<Boolean> isRoot() {
        return this.isRoot;
    }

    public final void start(SocialSource socialSource2, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(socialSource2, "source");
        this.socialSource = socialSource2;
        this.storeUponUpload = z;
        this.cancelable = z2;
        this.showProgress = z3;
        this.backgroundUpload = z4;
    }

    public final void selectFile(String str) {
        Intrinsics.checkNotNullParameter(str, "fileUrl");
        SocialSource socialSource2 = this.socialSource;
        if (socialSource2 != null) {
            this.progressDialogCommand.postValue(new ProgressData(true, getContext().getString(R.string.ucw_action_loading_image), this.cancelable, this.showProgress));
            UploadcareWidget.Companion.getInstance().getSocialApi$widget_release().selectFile(socialSource2.getCookie(getContext()), socialSource2.getUrls().getDone(), str).enqueue(new UploadcareFilesViewModel$selectFile$$inlined$let$lambda$1(this, str));
        }
    }

    public final void saveCookie(String str) {
        Intrinsics.checkNotNullParameter(str, "cookie");
        SocialSource socialSource2 = this.socialSource;
        if (socialSource2 != null) {
            socialSource2.saveCookie(getContext(), str);
        }
    }

    public final void signOut() {
        SocialSource socialSource2 = this.socialSource;
        if (socialSource2 != null) {
            this.progressDialogCommand.postValue(new ProgressData(true, getContext().getString(R.string.ucw_action_signout), false, false, 12, (DefaultConstructorMarker) null));
            UploadcareWidget.Companion.getInstance().getSocialApi$widget_release().signOut(socialSource2.getCookie(getContext()), socialSource2.getUrls().getSession()).enqueue(new UploadcareFilesViewModel$signOut$$inlined$let$lambda$1(socialSource2, this));
        }
    }

    public final void canlcelUpload() {
        Uploader uploader2 = this.uploader;
        if (uploader2 != null) {
            uploader2.cancel();
        }
        this.uploader = null;
        this.closeWidgetCommand.postValue(new UploadcareApiException("Canceled"));
    }

    /* access modifiers changed from: private */
    public final void uploadFileFromUrl(SelectedFile selectedFile) {
        if (this.backgroundUpload) {
            OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(FileUploadWorker.class);
            builder.addTag(FileUploadWorker.TAG);
            Pair[] pairArr = {TuplesKt.to(FileUploadWorker.KEY_FILE_URL, selectedFile.getUrl()), TuplesKt.to(FileUploadWorker.KEY_CANCELABLE, Boolean.valueOf(this.cancelable)), TuplesKt.to(FileUploadWorker.KEY_SHOW_PROGRESS, Boolean.valueOf(this.showProgress)), TuplesKt.to(FileUploadWorker.KEY_STORE, Boolean.valueOf(this.storeUponUpload))};
            Data.Builder builder2 = new Data.Builder();
            for (int i = 0; i < 4; i++) {
                Pair pair = pairArr[i];
                builder2.put((String) pair.getFirst(), pair.getSecond());
            }
            Data build = builder2.build();
            Intrinsics.checkExpressionValueIsNotNull(build, "dataBuilder.build()");
            builder.setInputData(build);
            WorkRequest build2 = builder.build();
            Intrinsics.checkNotNullExpressionValue(build2, "requestBuilder.build()");
            WorkManager.getInstance(getContext()).enqueue(build2);
            this.uploadingInBackgroundCommand.postValue(build2.getId());
            return;
        }
        Uploader store = new UrlUploader(UploadcareWidget.Companion.getInstance().getUploadcareClient(), selectedFile.getUrl()).store(this.storeUponUpload);
        this.uploader = store;
        Intrinsics.checkNotNull(store);
        store.uploadAsync(new UploadcareFilesViewModel$uploadFileFromUrl$1(this));
    }

    static /* synthetic */ void error$default(UploadcareFilesViewModel uploadcareFilesViewModel, UploadcareApiException uploadcareApiException, int i, Object obj) {
        if ((i & 1) != 0) {
            uploadcareApiException = null;
        }
        uploadcareFilesViewModel.error(uploadcareApiException);
    }

    /* access modifiers changed from: private */
    public final void error(UploadcareApiException uploadcareApiException) {
        this.progressDialogCommand.postValue(new ProgressData(false, (String) null, false, false, 14, (DefaultConstructorMarker) null));
        this.closeWidgetCommand.postValue(uploadcareApiException);
        this.uploader = null;
    }

    /* access modifiers changed from: private */
    public final Context getContext() {
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        return application;
    }
}
