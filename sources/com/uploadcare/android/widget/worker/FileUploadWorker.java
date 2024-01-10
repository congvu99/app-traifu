package com.uploadcare.android.widget.worker;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.ForegroundInfo;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import com.uploadcare.android.library.callbacks.ProgressCallback;
import com.uploadcare.android.library.upload.Uploader;
import com.uploadcare.android.widget.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u0011\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ \u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\u000e2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010 \u001a\u00020&H\u0002R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/uploadcare/android/widget/worker/FileUploadWorker;", "Landroidx/work/CoroutineWorker;", "Lcom/uploadcare/android/library/callbacks/ProgressCallback;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "cancelable", "", "notificationManager", "Landroid/app/NotificationManager;", "showProgress", "uploader", "Lcom/uploadcare/android/library/upload/Uploader;", "createChannel", "", "channelId", "", "createForegroundInfo", "Landroidx/work/ForegroundInfo;", "notificationBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "createNotification", "content", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onProgressUpdate", "bytesWritten", "", "contentLength", "progress", "", "prepareUploader", "inputData", "Landroidx/work/Data;", "updateNotificationProgress", "", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: FileUploadWorker.kt */
public final class FileUploadWorker extends CoroutineWorker implements ProgressCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_CANCELABLE = "KEY_CANCELABLE";
    public static final String KEY_ERROR = "KEY_ERROR";
    public static final String KEY_EXPIRE = "KEY_EXPIRE";
    public static final String KEY_FILE_URI = "KEY_FILE_URI";
    public static final String KEY_FILE_URL = "KEY_FILE_URL";
    public static final String KEY_SHOW_PROGRESS = "KEY_SHOW_PROGRESS";
    public static final String KEY_SIGNATURE = "KEY_SIGNATURE";
    public static final String KEY_STORE = "KEY_STORE";
    public static final String KEY_UPLOADCARE_FILE = "KEY_UPLOADCARE_FILE";
    public static final String KEY_WORKER_PROGRESS = "KEY_WORKER_PROGRESS";
    private static final int NOTIFICATION_ID = 641;
    public static final String TAG = "uploadcare_worker";
    private boolean cancelable;
    private final NotificationManager notificationManager;
    private boolean showProgress;
    private Uploader uploader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileUploadWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        Object systemService = context.getSystemService("notification");
        if (systemService != null) {
            this.notificationManager = (NotificationManager) systemService;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Result.failure(workDataOf(KEY_ERROR to e.message))"
            boolean r1 = r9 instanceof com.uploadcare.android.widget.worker.FileUploadWorker$doWork$1
            if (r1 == 0) goto L_0x0016
            r1 = r9
            com.uploadcare.android.widget.worker.FileUploadWorker$doWork$1 r1 = (com.uploadcare.android.widget.worker.FileUploadWorker$doWork$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r9 = r1.label
            int r9 = r9 - r3
            r1.label = r9
            goto L_0x001b
        L_0x0016:
            com.uploadcare.android.widget.worker.FileUploadWorker$doWork$1 r1 = new com.uploadcare.android.widget.worker.FileUploadWorker$doWork$1
            r1.<init>(r8, r9)
        L_0x001b:
            java.lang.Object r9 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0039
            if (r3 != r5) goto L_0x0031
            java.lang.Object r1 = r1.L$0
            com.uploadcare.android.widget.worker.FileUploadWorker r1 = (com.uploadcare.android.widget.worker.FileUploadWorker) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0077
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.work.Data r9 = r8.getInputData()
            java.lang.String r3 = "KEY_CANCELABLE"
            boolean r9 = r9.getBoolean(r3, r4)
            r8.cancelable = r9
            androidx.work.Data r9 = r8.getInputData()
            java.lang.String r3 = "KEY_SHOW_PROGRESS"
            boolean r9 = r9.getBoolean(r3, r4)
            r8.showProgress = r9
            android.content.Context r9 = r8.getApplicationContext()
            int r3 = com.uploadcare.android.widget.R.string.ucw_notification_content_started
            java.lang.String r9 = r9.getString(r3)
            java.lang.String r3 = "applicationContext.getSt…fication_content_started)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            androidx.core.app.NotificationCompat$Builder r9 = r8.createNotification(r9)
            androidx.work.ForegroundInfo r9 = r8.createForegroundInfo(r9)
            r1.L$0 = r8
            r1.label = r5
            java.lang.Object r9 = r8.setForeground(r9, r1)
            if (r9 != r2) goto L_0x0076
            return r2
        L_0x0076:
            r1 = r8
        L_0x0077:
            androidx.work.Data r9 = r1.getInputData()
            java.lang.String r2 = "inputData"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            com.uploadcare.android.library.upload.Uploader r9 = r1.prepareUploader(r9)
            r1.uploader = r9
            r2 = 0
            java.lang.String r3 = "KEY_ERROR"
            java.lang.String r6 = "dataBuilder.build()"
            if (r9 == 0) goto L_0x0105
            r7 = r1
            com.uploadcare.android.library.callbacks.ProgressCallback r7 = (com.uploadcare.android.library.callbacks.ProgressCallback) r7     // Catch:{ Exception -> 0x00cd, RuntimeException -> 0x0095 }
            com.uploadcare.android.library.api.UploadcareFile r9 = r9.upload(r7)     // Catch:{ Exception -> 0x00cd, RuntimeException -> 0x0095 }
            goto L_0x0106
        L_0x0095:
            r9 = move-exception
            r9.printStackTrace()
            kotlin.Pair[] r1 = new kotlin.Pair[r5]
            java.lang.String r9 = r9.getMessage()
            kotlin.Pair r9 = kotlin.TuplesKt.to(r3, r9)
            r1[r4] = r9
            androidx.work.Data$Builder r9 = new androidx.work.Data$Builder
            r9.<init>()
        L_0x00aa:
            if (r4 >= r5) goto L_0x00be
            r2 = r1[r4]
            java.lang.Object r3 = r2.getFirst()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getSecond()
            r9.put(r3, r2)
            int r4 = r4 + 1
            goto L_0x00aa
        L_0x00be:
            androidx.work.Data r9 = r9.build()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r6)
            androidx.work.ListenableWorker$Result r9 = androidx.work.ListenableWorker.Result.failure(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            return r9
        L_0x00cd:
            r9 = move-exception
            r9.printStackTrace()
            kotlin.Pair[] r1 = new kotlin.Pair[r5]
            java.lang.String r9 = r9.getMessage()
            kotlin.Pair r9 = kotlin.TuplesKt.to(r3, r9)
            r1[r4] = r9
            androidx.work.Data$Builder r9 = new androidx.work.Data$Builder
            r9.<init>()
        L_0x00e2:
            if (r4 >= r5) goto L_0x00f6
            r2 = r1[r4]
            java.lang.Object r3 = r2.getFirst()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getSecond()
            r9.put(r3, r2)
            int r4 = r4 + 1
            goto L_0x00e2
        L_0x00f6:
            androidx.work.Data r9 = r9.build()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r6)
            androidx.work.ListenableWorker$Result r9 = androidx.work.ListenableWorker.Result.failure(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            return r9
        L_0x0105:
            r9 = r2
        L_0x0106:
            com.uploadcare.android.library.upload.Uploader r2 = (com.uploadcare.android.library.upload.Uploader) r2
            r1.uploader = r2
            r0 = 100
            if (r9 == 0) goto L_0x016a
            android.content.Context r2 = r1.getApplicationContext()
            int r3 = com.uploadcare.android.widget.R.string.ucw_notification_content_completed
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "applicationContext.getSt…cation_content_completed)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.updateNotificationProgress(r2, r0)
            com.uploadcare.android.widget.controller.UploadcareWidget$Companion r0 = com.uploadcare.android.widget.controller.UploadcareWidget.Companion
            com.uploadcare.android.widget.controller.UploadcareWidget r0 = r0.getInstance()
            com.uploadcare.android.library.api.UploadcareClient r0 = r0.getUploadcareClient()
            com.uploadcare.android.library.data.ObjectMapper r0 = r0.getObjectMapper()
            java.lang.Class<com.uploadcare.android.library.api.UploadcareFile> r1 = com.uploadcare.android.library.api.UploadcareFile.class
            java.lang.reflect.Type r1 = (java.lang.reflect.Type) r1
            java.lang.String r9 = r0.toJson((java.lang.Object) r9, (java.lang.reflect.Type) r1)
            kotlin.Pair[] r0 = new kotlin.Pair[r5]
            java.lang.String r1 = "KEY_UPLOADCARE_FILE"
            kotlin.Pair r9 = kotlin.TuplesKt.to(r1, r9)
            r0[r4] = r9
            androidx.work.Data$Builder r9 = new androidx.work.Data$Builder
            r9.<init>()
        L_0x0145:
            if (r4 >= r5) goto L_0x0159
            r1 = r0[r4]
            java.lang.Object r2 = r1.getFirst()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getSecond()
            r9.put(r2, r1)
            int r4 = r4 + 1
            goto L_0x0145
        L_0x0159:
            androidx.work.Data r9 = r9.build()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r6)
            androidx.work.ListenableWorker$Result r9 = androidx.work.ListenableWorker.Result.success(r9)
            java.lang.String r0 = "Result.success(workDataO…DCARE_FILE to  fileJson))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            goto L_0x01af
        L_0x016a:
            android.content.Context r9 = r1.getApplicationContext()
            int r2 = com.uploadcare.android.widget.R.string.ucw_notification_content_error
            java.lang.String r9 = r9.getString(r2)
            java.lang.String r2 = "applicationContext.getSt…tification_content_error)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            r1.updateNotificationProgress(r9, r0)
            kotlin.Pair[] r9 = new kotlin.Pair[r5]
            java.lang.String r0 = "Error uploading file"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r3, r0)
            r9[r4] = r0
            androidx.work.Data$Builder r0 = new androidx.work.Data$Builder
            r0.<init>()
        L_0x018b:
            if (r4 >= r5) goto L_0x019f
            r1 = r9[r4]
            java.lang.Object r2 = r1.getFirst()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getSecond()
            r0.put(r2, r1)
            int r4 = r4 + 1
            goto L_0x018b
        L_0x019f:
            androidx.work.Data r9 = r0.build()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r6)
            androidx.work.ListenableWorker$Result r9 = androidx.work.ListenableWorker.Result.failure(r9)
            java.lang.String r0 = "Result.failure(workDataO… \"Error uploading file\"))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
        L_0x01af:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.widget.worker.FileUploadWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final NotificationCompat.Builder createNotification(String str) {
        String string = getApplicationContext().getString(R.string.ucw_notification_channel_id);
        Intrinsics.checkNotNullExpressionValue(string, "applicationContext.getSt…_notification_channel_id)");
        String string2 = getApplicationContext().getString(R.string.ucw_notification_title);
        Intrinsics.checkNotNullExpressionValue(string2, "applicationContext.getSt…g.ucw_notification_title)");
        if (Build.VERSION.SDK_INT >= 26) {
            createChannel(string);
        }
        CharSequence charSequence = string2;
        NotificationCompat.Builder ongoing = new NotificationCompat.Builder(getApplicationContext(), string).setContentTitle(charSequence).setTicker(charSequence).setContentText(str).setSmallIcon(R.drawable.ic_ucw_file_upload).setOngoing(true);
        if (this.cancelable) {
            String string3 = getApplicationContext().getString(R.string.ucw_notification_cancel_download);
            Intrinsics.checkNotNullExpressionValue(string3, "applicationContext.getSt…fication_cancel_download)");
            PendingIntent createCancelPendingIntent = WorkManager.getInstance(getApplicationContext()).createCancelPendingIntent(getId());
            Intrinsics.checkNotNullExpressionValue(createCancelPendingIntent, "WorkManager.getInstance(…teCancelPendingIntent(id)");
            ongoing.addAction(17301533, string3, createCancelPendingIntent);
        }
        Intrinsics.checkNotNullExpressionValue(ongoing, "notificationBuilder");
        return ongoing;
    }

    private final ForegroundInfo createForegroundInfo(NotificationCompat.Builder builder) {
        return new ForegroundInfo(NOTIFICATION_ID, builder.build());
    }

    private final void updateNotificationProgress(String str, int i) {
        NotificationCompat.Builder createNotification = createNotification(str);
        if (this.showProgress) {
            createNotification.setProgress(100, i, false);
        }
        if (i == 100) {
            createNotification.setOngoing(false);
            createNotification.setAutoCancel(true);
        }
        setForegroundAsync(createForegroundInfo(createNotification));
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.uploadcare.android.library.upload.Uploader prepareUploader(androidx.work.Data r8) {
        /*
            r7 = this;
            java.lang.String r0 = "KEY_STORE"
            r1 = 0
            boolean r0 = r8.getBoolean(r0, r1)
            java.lang.String r1 = "KEY_SIGNATURE"
            java.lang.String r1 = r8.getString(r1)
            java.lang.String r2 = "KEY_EXPIRE"
            java.lang.String r2 = r8.getString(r2)
            java.lang.String r3 = "KEY_FILE_URL"
            java.lang.String r3 = r8.getString(r3)
            java.lang.String r4 = "KEY_FILE_URI"
            java.lang.String r8 = r8.getString(r4)
            r4 = 0
            if (r8 == 0) goto L_0x002c
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ RuntimeException -> 0x002c }
            java.lang.String r5 = "Uri.parse(this)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r5)     // Catch:{ RuntimeException -> 0x002c }
            goto L_0x002d
        L_0x002c:
            r8 = r4
        L_0x002d:
            com.uploadcare.android.library.upload.Uploader r4 = (com.uploadcare.android.library.upload.Uploader) r4
            if (r3 == 0) goto L_0x0048
            com.uploadcare.android.library.upload.UrlUploader r8 = new com.uploadcare.android.library.upload.UrlUploader
            com.uploadcare.android.widget.controller.UploadcareWidget$Companion r1 = com.uploadcare.android.widget.controller.UploadcareWidget.Companion
            com.uploadcare.android.widget.controller.UploadcareWidget r1 = r1.getInstance()
            com.uploadcare.android.library.api.UploadcareClient r1 = r1.getUploadcareClient()
            r8.<init>(r1, r3)
            com.uploadcare.android.library.upload.UrlUploader r8 = r8.store((boolean) r0)
            r4 = r8
            com.uploadcare.android.library.upload.Uploader r4 = (com.uploadcare.android.library.upload.Uploader) r4
            goto L_0x0077
        L_0x0048:
            if (r8 == 0) goto L_0x0077
            com.uploadcare.android.library.upload.FileUploader r3 = new com.uploadcare.android.library.upload.FileUploader
            com.uploadcare.android.widget.controller.UploadcareWidget$Companion r4 = com.uploadcare.android.widget.controller.UploadcareWidget.Companion
            com.uploadcare.android.widget.controller.UploadcareWidget r4 = r4.getInstance()
            com.uploadcare.android.library.api.UploadcareClient r4 = r4.getUploadcareClient()
            android.content.Context r5 = r7.getApplicationContext()
            java.lang.String r6 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r3.<init>((com.uploadcare.android.library.api.UploadcareClient) r4, (android.net.Uri) r8, (android.content.Context) r5)
            com.uploadcare.android.library.upload.FileUploader r8 = r3.store((boolean) r0)
            java.lang.String r0 = ""
            if (r1 == 0) goto L_0x006b
            goto L_0x006c
        L_0x006b:
            r1 = r0
        L_0x006c:
            if (r2 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = r0
        L_0x0070:
            com.uploadcare.android.library.upload.FileUploader r8 = r8.signedUpload(r1, r2)
            r4 = r8
            com.uploadcare.android.library.upload.Uploader r4 = (com.uploadcare.android.library.upload.Uploader) r4
        L_0x0077:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.widget.worker.FileUploadWorker.prepareUploader(androidx.work.Data):com.uploadcare.android.library.upload.Uploader");
    }

    private final void createChannel(String str) {
        String string = getApplicationContext().getString(R.string.ucw_notification_channel_name);
        Intrinsics.checkNotNullExpressionValue(string, "applicationContext.getSt…otification_channel_name)");
        String string2 = getApplicationContext().getString(R.string.ucw_notification_channel_description);
        Intrinsics.checkNotNullExpressionValue(string2, "applicationContext.getSt…tion_channel_description)");
        NotificationChannel notificationChannel = new NotificationChannel(str, string, 3);
        notificationChannel.setDescription(string2);
        this.notificationManager.createNotificationChannel(notificationChannel);
    }

    public void onProgressUpdate(long j, long j2, double d) {
        if (isStopped()) {
            Uploader uploader2 = this.uploader;
            if (uploader2 != null) {
                uploader2.cancel();
            }
            this.uploader = null;
        }
        int roundToInt = MathKt.roundToInt(d * ((double) 100));
        Pair[] pairArr = {TuplesKt.to(KEY_WORKER_PROGRESS, Integer.valueOf(roundToInt))};
        Data.Builder builder = new Data.Builder();
        for (int i = 0; i < 1; i++) {
            Pair pair = pairArr[i];
            builder.put((String) pair.getFirst(), pair.getSecond());
        }
        Data build = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "dataBuilder.build()");
        setProgressAsync(build);
        String string = getApplicationContext().getString(R.string.ucw_notification_content_progress);
        Intrinsics.checkNotNullExpressionValue(string, "applicationContext.getSt…ication_content_progress)");
        updateNotificationProgress(string, roundToInt);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/uploadcare/android/widget/worker/FileUploadWorker$Companion;", "", "()V", "KEY_CANCELABLE", "", "KEY_ERROR", "KEY_EXPIRE", "KEY_FILE_URI", "KEY_FILE_URL", "KEY_SHOW_PROGRESS", "KEY_SIGNATURE", "KEY_STORE", "KEY_UPLOADCARE_FILE", "KEY_WORKER_PROGRESS", "NOTIFICATION_ID", "", "TAG", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: FileUploadWorker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
