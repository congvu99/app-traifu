package com.uploadcare.android.widget.viewmodels;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import androidx.core.content.FileProvider;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.library.upload.FileUploader;
import com.uploadcare.android.library.upload.Uploader;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.controller.FileType;
import com.uploadcare.android.widget.controller.SocialNetwork;
import com.uploadcare.android.widget.controller.UploadcareWidget;
import com.uploadcare.android.widget.data.SocialSource;
import com.uploadcare.android.widget.utils.SingleLiveEvent;
import com.uploadcare.android.widget.worker.FileUploadWorker;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00105\u001a\u000206J\b\u00107\u001a\u000206H\u0002J\b\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0014H\u0002J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u0014H\u0002J\u0012\u0010>\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010?\u001a\u0002062\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010@\u001a\u0002062\u0006\u0010A\u001a\u00020\"H\u0002J\u000e\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020DJ\u000e\u0010E\u001a\u0002062\u0006\u0010C\u001a\u00020DJ\u0016\u0010F\u001a\u0002062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u000e\u0010G\u001a\u0002062\u0006\u0010A\u001a\u00020\"J\u000e\u0010H\u001a\u0002062\u0006\u0010C\u001a\u00020DJ\u0012\u0010I\u001a\u0002062\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\fR\u000e\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R)\u0010 \u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!\u0012\u0004\u0012\u00020\u00100\u00120\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0010\u0010$\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\fR\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002030\t¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\f¨\u0006K"}, d2 = {"Lcom/uploadcare/android/widget/viewmodels/UploadcareViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "backgroundUpload", "", "cancelable", "closeWidgetCommand", "Lcom/uploadcare/android/widget/utils/SingleLiveEvent;", "Lcom/uploadcare/android/library/exceptions/UploadcareApiException;", "getCloseWidgetCommand", "()Lcom/uploadcare/android/widget/utils/SingleLiveEvent;", "expire", "", "fileType", "Lcom/uploadcare/android/widget/controller/FileType;", "launchCamera", "Lkotlin/Pair;", "Landroid/net/Uri;", "Lcom/uploadcare/android/widget/viewmodels/MediaType;", "getLaunchCamera", "launchFilePicker", "getLaunchFilePicker", "launchSocialSourceCommand", "Lcom/uploadcare/android/widget/viewmodels/SocialData;", "getLaunchSocialSourceCommand", "network", "progressDialogCommand", "Lcom/uploadcare/android/widget/viewmodels/ProgressData;", "getProgressDialogCommand", "showProgress", "showSocialSourcesCommand", "", "Lcom/uploadcare/android/widget/data/SocialSource;", "getShowSocialSourcesCommand", "signature", "sources", "storeUponUpload", "tempFileUri", "uploadCompleteCommand", "Lcom/uploadcare/android/library/api/UploadcareFile;", "getUploadCompleteCommand", "uploadProgress", "Landroidx/lifecycle/MutableLiveData;", "", "getUploadProgress", "()Landroidx/lifecycle/MutableLiveData;", "uploader", "Lcom/uploadcare/android/library/upload/Uploader;", "uploadingInBackgroundCommand", "Ljava/util/UUID;", "getUploadingInBackgroundCommand", "canlcelUpload", "", "getAvailableNetworks", "getContext", "Landroid/content/Context;", "getOutputMediaFile", "Ljava/io/File;", "mediaType", "getOutputMediaFileUri", "isLocalNetwork", "launchLocalNetwork", "launchNetwork", "socialSource", "onRestoreInstanceState", "bundle", "Landroid/os/Bundle;", "onSaveInstanceState", "showNetworks", "sourceSelected", "start", "uploadFile", "fileUri", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareViewModel.kt */
public final class UploadcareViewModel extends AndroidViewModel {
    private boolean backgroundUpload;
    private boolean cancelable;
    private final SingleLiveEvent<UploadcareApiException> closeWidgetCommand = new SingleLiveEvent<>();
    private String expire;
    private FileType fileType;
    private final SingleLiveEvent<Pair<Uri, MediaType>> launchCamera = new SingleLiveEvent<>();
    private final SingleLiveEvent<FileType> launchFilePicker = new SingleLiveEvent<>();
    private final SingleLiveEvent<SocialData> launchSocialSourceCommand = new SingleLiveEvent<>();
    private String network;
    private final SingleLiveEvent<ProgressData> progressDialogCommand = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public boolean showProgress;
    private final SingleLiveEvent<Pair<List<SocialSource>, FileType>> showSocialSourcesCommand = new SingleLiveEvent<>();
    private String signature;
    /* access modifiers changed from: private */
    public List<SocialSource> sources;
    private boolean storeUponUpload;
    private Uri tempFileUri;
    private final SingleLiveEvent<UploadcareFile> uploadCompleteCommand = new SingleLiveEvent<>();
    private final MutableLiveData<Integer> uploadProgress;
    /* access modifiers changed from: private */
    public Uploader uploader;
    private final SingleLiveEvent<UUID> uploadingInBackgroundCommand = new SingleLiveEvent<>();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MediaType.IMAGE.ordinal()] = 1;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadcareViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(0);
        Unit unit = Unit.INSTANCE;
        this.uploadProgress = mutableLiveData;
        this.fileType = FileType.any;
    }

    public final SingleLiveEvent<ProgressData> getProgressDialogCommand() {
        return this.progressDialogCommand;
    }

    public final SingleLiveEvent<UploadcareApiException> getCloseWidgetCommand() {
        return this.closeWidgetCommand;
    }

    public final SingleLiveEvent<Pair<List<SocialSource>, FileType>> getShowSocialSourcesCommand() {
        return this.showSocialSourcesCommand;
    }

    public final SingleLiveEvent<SocialData> getLaunchSocialSourceCommand() {
        return this.launchSocialSourceCommand;
    }

    public final SingleLiveEvent<Pair<Uri, MediaType>> getLaunchCamera() {
        return this.launchCamera;
    }

    public final SingleLiveEvent<FileType> getLaunchFilePicker() {
        return this.launchFilePicker;
    }

    public final SingleLiveEvent<UploadcareFile> getUploadCompleteCommand() {
        return this.uploadCompleteCommand;
    }

    public final SingleLiveEvent<UUID> getUploadingInBackgroundCommand() {
        return this.uploadingInBackgroundCommand;
    }

    public final MutableLiveData<Integer> getUploadProgress() {
        return this.uploadProgress;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0027, code lost:
        if (r0 != null) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void start(android.os.Bundle r4) {
        /*
            r3 = this;
            java.lang.String r0 = "bundle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "network"
            java.lang.String r0 = r4.getString(r0)
            r3.network = r0
            java.lang.String r0 = "store"
            r1 = 0
            boolean r0 = r4.getBoolean(r0, r1)
            r3.storeUponUpload = r0
            java.lang.String r0 = "fileType"
            java.lang.String r0 = r4.getString(r0)
            if (r0 == 0) goto L_0x002a
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.uploadcare.android.widget.controller.FileType r0 = com.uploadcare.android.widget.controller.FileType.valueOf(r0)
            if (r0 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            com.uploadcare.android.widget.controller.FileType r0 = com.uploadcare.android.widget.controller.FileType.any
        L_0x002c:
            r3.fileType = r0
            java.lang.String r0 = "signature"
            java.lang.String r0 = r4.getString(r0)
            r3.signature = r0
            java.lang.String r0 = "expire"
            java.lang.String r0 = r4.getString(r0)
            r3.expire = r0
            java.lang.String r0 = "cancelable"
            boolean r0 = r4.getBoolean(r0, r1)
            r3.cancelable = r0
            java.lang.String r0 = "showProgress"
            boolean r0 = r4.getBoolean(r0, r1)
            r3.showProgress = r0
            java.lang.String r0 = "backgroundUpload"
            boolean r4 = r4.getBoolean(r0, r1)
            r3.backgroundUpload = r4
            java.lang.String r4 = r3.network
            boolean r4 = r3.isLocalNetwork(r4)
            if (r4 == 0) goto L_0x0064
            java.lang.String r4 = r3.network
            r3.launchLocalNetwork(r4)
            goto L_0x006f
        L_0x0064:
            java.util.List<com.uploadcare.android.widget.data.SocialSource> r4 = r3.sources
            if (r4 == 0) goto L_0x006c
            r3.showNetworks(r4)
            goto L_0x006f
        L_0x006c:
            r3.getAvailableNetworks()
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.widget.viewmodels.UploadcareViewModel.start(android.os.Bundle):void");
    }

    public final void onRestoreInstanceState(Bundle bundle) {
        Class<UploadcareViewModel> cls = UploadcareViewModel.class;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.sources = bundle.getParcelableArrayList(Reflection.getOrCreateKotlinClass(cls).getSimpleName() + "_socialSource");
        String string = bundle.getString(Reflection.getOrCreateKotlinClass(cls).getSimpleName() + "_tempFileUri");
        if (string != null) {
            this.tempFileUri = Uri.parse(string);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        Class<UploadcareViewModel> cls = UploadcareViewModel.class;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        List<SocialSource> list = this.sources;
        if (list != null) {
            bundle.putParcelableArrayList(Reflection.getOrCreateKotlinClass(cls).getSimpleName() + "_socialSource", new ArrayList(list));
        }
        if (this.tempFileUri != null) {
            bundle.putString(Reflection.getOrCreateKotlinClass(cls).getSimpleName() + "_tempFileUri", String.valueOf(this.tempFileUri));
        }
    }

    public final void sourceSelected(SocialSource socialSource) {
        Intrinsics.checkNotNullParameter(socialSource, "socialSource");
        launchNetwork(socialSource);
    }

    public static /* synthetic */ void uploadFile$default(UploadcareViewModel uploadcareViewModel, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        uploadcareViewModel.uploadFile(uri);
    }

    public final void uploadFile(Uri uri) {
        if (uri == null) {
            uri = this.tempFileUri;
        }
        if (uri == null) {
            this.closeWidgetCommand.call();
        } else if (this.backgroundUpload) {
            OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(FileUploadWorker.class);
            builder.addTag(FileUploadWorker.TAG);
            Pair[] pairArr = {TuplesKt.to(FileUploadWorker.KEY_FILE_URI, uri.toString()), TuplesKt.to(FileUploadWorker.KEY_CANCELABLE, Boolean.valueOf(this.cancelable)), TuplesKt.to(FileUploadWorker.KEY_SHOW_PROGRESS, Boolean.valueOf(this.showProgress)), TuplesKt.to(FileUploadWorker.KEY_STORE, Boolean.valueOf(this.storeUponUpload)), TuplesKt.to(FileUploadWorker.KEY_SIGNATURE, this.signature), TuplesKt.to(FileUploadWorker.KEY_EXPIRE, this.expire)};
            Data.Builder builder2 = new Data.Builder();
            for (int i = 0; i < 6; i++) {
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
        } else {
            this.progressDialogCommand.postValue(new ProgressData(true, getContext().getString(R.string.ucw_action_loading_image), this.cancelable, this.showProgress));
            FileUploader store = new FileUploader(UploadcareWidget.Companion.getInstance().getUploadcareClient(), uri, getContext()).store(this.storeUponUpload);
            String str = this.signature;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            String str3 = this.expire;
            if (str3 != null) {
                str2 = str3;
            }
            Uploader signedUpload = store.signedUpload(str, str2);
            this.uploader = signedUpload;
            Intrinsics.checkNotNull(signedUpload);
            signedUpload.uploadAsync(new UploadcareViewModel$uploadFile$1(this));
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

    private final void getAvailableNetworks() {
        this.progressDialogCommand.postValue(new ProgressData(true, getContext().getString(R.string.ucw_action_loading_networks), false, false, 12, (DefaultConstructorMarker) null));
        UploadcareWidget.Companion.getInstance().getSocialApi$widget_release().getSources().enqueue(new UploadcareViewModel$getAvailableNetworks$1(this));
    }

    /* access modifiers changed from: private */
    public final void showNetworks(List<SocialSource> list) {
        SocialSource socialSource;
        if (this.network == null) {
            this.showSocialSourcesCommand.postValue(new Pair(list, this.fileType));
            return;
        }
        SocialSource socialSource2 = null;
        Iterator<SocialSource> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                socialSource = socialSource2;
                break;
            }
            SocialSource next = it.next();
            if (StringsKt.equals(next.getName(), this.network, true)) {
                socialSource = next;
                break;
            }
        }
        if (socialSource != null) {
            this.launchSocialSourceCommand.postValue(new SocialData(socialSource, this.storeUponUpload, this.cancelable, this.showProgress, this.backgroundUpload));
        } else {
            this.closeWidgetCommand.call();
        }
    }

    private final Context getContext() {
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        return application;
    }

    private final void launchNetwork(SocialSource socialSource) {
        String name = socialSource.getName();
        if (!Intrinsics.areEqual((Object) name, (Object) SocialNetwork.SOCIAL_NETWORK_CAMERA.getRawValue()) && !Intrinsics.areEqual((Object) name, (Object) SocialNetwork.SOCIAL_NETWORK_VIDEOCAM.getRawValue()) && !Intrinsics.areEqual((Object) name, (Object) SocialNetwork.SOCIAL_NETWORK_FILE.getRawValue())) {
            this.launchSocialSourceCommand.postValue(new SocialData(socialSource, this.storeUponUpload, this.cancelable, this.showProgress, this.backgroundUpload));
            return;
        }
        launchLocalNetwork(socialSource.getName());
    }

    private final void launchLocalNetwork(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) SocialNetwork.SOCIAL_NETWORK_CAMERA.getRawValue())) {
            Uri outputMediaFileUri = getOutputMediaFileUri(MediaType.IMAGE);
            this.tempFileUri = outputMediaFileUri;
            if (outputMediaFileUri != null) {
                this.launchCamera.postValue(new Pair(outputMediaFileUri, MediaType.IMAGE));
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) SocialNetwork.SOCIAL_NETWORK_VIDEOCAM.getRawValue())) {
            Uri outputMediaFileUri2 = getOutputMediaFileUri(MediaType.VIDEO);
            this.tempFileUri = outputMediaFileUri2;
            if (outputMediaFileUri2 != null) {
                this.launchCamera.postValue(new Pair(outputMediaFileUri2, MediaType.VIDEO));
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) SocialNetwork.SOCIAL_NETWORK_FILE.getRawValue())) {
            this.launchFilePicker.postValue(this.fileType);
        } else {
            throw new IllegalArgumentException("Unsupported SocialSource: " + str);
        }
    }

    private final boolean isLocalNetwork(String str) {
        if (str == null) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) str, (Object) SocialNetwork.SOCIAL_NETWORK_CAMERA.getRawValue()) && !Intrinsics.areEqual((Object) str, (Object) SocialNetwork.SOCIAL_NETWORK_VIDEOCAM.getRawValue()) && !Intrinsics.areEqual((Object) str, (Object) SocialNetwork.SOCIAL_NETWORK_FILE.getRawValue())) {
            return false;
        }
        return true;
    }

    private final Uri getOutputMediaFileUri(MediaType mediaType) {
        Uri uriForFile = FileProvider.getUriForFile(getApplication(), getContext().getPackageName() + ".fileprovider", getOutputMediaFile(mediaType));
        Intrinsics.checkNotNullExpressionValue(uriForFile, "FileProvider.getUriForFi…tputMediaFile(mediaType))");
        return uriForFile;
    }

    private final File getOutputMediaFile(MediaType mediaType) {
        File file = new File(getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "Cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        if (WhenMappings.$EnumSwitchMapping$0[mediaType.ordinal()] != 1) {
            return new File(file.getPath() + File.separator + "VID_" + format + ".mp4");
        }
        return new File(file.getPath() + File.separator + "IMG_" + format + ".jpg");
    }
}
