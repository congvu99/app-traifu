package com.uploadcare.android.library.upload;

import com.uploadcare.android.library.api.UploadcareClient;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.callbacks.ProgressCallback;
import com.uploadcare.android.library.callbacks.UploadFilesCallback;
import com.uploadcare.android.library.exceptions.UploadFailureException;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\fJ\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\u0006\u0010\u001f\u001a\u00020\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/uploadcare/android/library/upload/MultipleUrlsUploader;", "Lcom/uploadcare/android/library/upload/MultipleUploader;", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "sourceUrls", "", "", "(Lcom/uploadcare/android/library/api/UploadcareClient;Ljava/util/List;)V", "checkURLDuplicates", "expire", "filename", "isCanceled", "", "job", "Lkotlinx/coroutines/Job;", "saveURLDuplicates", "signature", "store", "cancel", "", "checkDuplicates", "checkUploadCanceled", "saveDuplicates", "signedUpload", "sleep", "millis", "", "upload", "Lcom/uploadcare/android/library/api/UploadcareFile;", "progressCallback", "Lcom/uploadcare/android/library/callbacks/ProgressCallback;", "pollingInterval", "uploadAsync", "callback", "Lcom/uploadcare/android/library/callbacks/UploadFilesCallback;", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: MultipleUrlsUploader.kt */
public final class MultipleUrlsUploader implements MultipleUploader {
    private String checkURLDuplicates;
    private final UploadcareClient client;
    private String expire;
    private String filename;
    private boolean isCanceled;
    private Job job;
    private String saveURLDuplicates;
    private String signature;
    private final List<String> sourceUrls;
    private String store = "auto";

    public MultipleUrlsUploader(UploadcareClient uploadcareClient, List<String> list) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(list, "sourceUrls");
        this.client = uploadcareClient;
        this.sourceUrls = list;
    }

    public List<UploadcareFile> upload(ProgressCallback progressCallback) {
        return upload(500, progressCallback);
    }

    public void uploadAsync(UploadFilesCallback uploadFilesCallback) {
        Intrinsics.checkNotNullParameter(uploadFilesCallback, "callback");
        this.job = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new MultipleUrlsUploader$uploadAsync$1(this, uploadFilesCallback, (Continuation) null), 2, (Object) null);
    }

    public void cancel() {
        this.isCanceled = true;
        Job job2 = this.job;
        if (job2 != null) {
            JobKt.cancel(job2, "canceled", new UploadFailureException("Canceled"));
        }
        this.job = null;
    }

    public MultipleUrlsUploader store(boolean z) {
        this.store = String.valueOf(z ? 1 : 0);
        return this;
    }

    public final MultipleUrlsUploader checkDuplicates(boolean z) {
        this.checkURLDuplicates = String.valueOf(z ? 1 : 0);
        return this;
    }

    public final MultipleUrlsUploader saveDuplicates(boolean z) {
        this.saveURLDuplicates = String.valueOf(z ? 1 : 0);
        return this;
    }

    public final MultipleUrlsUploader saveDuplicates(String str) {
        Intrinsics.checkNotNullParameter(str, "filename");
        this.filename = str;
        return this;
    }

    public final MultipleUrlsUploader signedUpload(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "signature");
        Intrinsics.checkNotNullParameter(str2, "expire");
        this.signature = str;
        this.expire = str2;
        return this;
    }

    private final void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public static /* synthetic */ List upload$default(MultipleUrlsUploader multipleUrlsUploader, long j, ProgressCallback progressCallback, int i, Object obj) throws UploadFailureException {
        if ((i & 2) != 0) {
            progressCallback = null;
        }
        return multipleUrlsUploader.upload(j, progressCallback);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x015d, code lost:
        checkUploadCanceled();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0160, code lost:
        if (r25 == null) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0162, code lost:
        r25.onProgressUpdate(r12.getDone(), r12.getTotal(), r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01bd, code lost:
        throw new com.uploadcare.android.library.exceptions.UploadFailureException(r12.getError());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.uploadcare.android.library.api.UploadcareFile> upload(long r23, com.uploadcare.android.library.callbacks.ProgressCallback r25) throws com.uploadcare.android.library.exceptions.UploadFailureException {
        /*
            r22 = this;
            r0 = r22
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List<java.lang.String> r1 = r0.sourceUrls
            java.util.Iterator r9 = r1.iterator()
        L_0x000d:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x01cc
            java.lang.Object r1 = r9.next()
            java.lang.String r1 = (java.lang.String) r1
            r22.checkUploadCanceled()
            okhttp3.MultipartBody$Builder r2 = new okhttp3.MultipartBody$Builder
            r3 = 0
            r4 = 1
            r2.<init>(r3, r4, r3)
            okhttp3.MediaType r3 = okhttp3.MultipartBody.FORM
            okhttp3.MultipartBody$Builder r2 = r2.setType(r3)
            com.uploadcare.android.library.api.UploadcareClient r3 = r0.client
            java.lang.String r3 = r3.getPublicKey()
            java.lang.String r4 = "pub_key"
            okhttp3.MultipartBody$Builder r2 = r2.addFormDataPart(r4, r3)
            java.lang.String r3 = "source_url"
            okhttp3.MultipartBody$Builder r1 = r2.addFormDataPart(r3, r1)
            java.lang.String r2 = r0.store
            java.lang.String r3 = "store"
            okhttp3.MultipartBody$Builder r1 = r1.addFormDataPart(r3, r2)
            java.lang.String r2 = r0.filename
            if (r2 == 0) goto L_0x004c
            java.lang.String r3 = "filename"
            r1.addFormDataPart(r3, r2)
        L_0x004c:
            java.lang.String r2 = r0.checkURLDuplicates
            if (r2 == 0) goto L_0x0055
            java.lang.String r3 = "check_URL_duplicates"
            r1.addFormDataPart(r3, r2)
        L_0x0055:
            java.lang.String r2 = r0.saveURLDuplicates
            if (r2 == 0) goto L_0x005e
            java.lang.String r3 = "save_URL_duplicates"
            r1.addFormDataPart(r3, r2)
        L_0x005e:
            java.lang.String r2 = r0.signature
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0086
            java.lang.String r2 = r0.expire
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0086
            java.lang.String r2 = r0.signature
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r3 = "signature"
            r1.addFormDataPart(r3, r2)
            java.lang.String r2 = r0.expire
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r3 = "expire"
            r1.addFormDataPart(r3, r2)
        L_0x0086:
            com.uploadcare.android.library.urls.Urls$Companion r2 = com.uploadcare.android.library.urls.Urls.Companion
            java.net.URI r2 = r2.uploadFromUrl()
            okhttp3.MultipartBody r1 = r1.build()
            com.uploadcare.android.library.api.UploadcareClient r3 = r0.client
            com.uploadcare.android.library.api.RequestHelper r10 = r3.getRequestHelper()
            java.lang.String r12 = r2.toString()
            java.lang.String r2 = "uploadUrl.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)
            r13 = 0
            java.lang.Class<com.uploadcare.android.library.data.UploadFromUrlData> r14 = com.uploadcare.android.library.data.UploadFromUrlData.class
            r15 = r1
            okhttp3.RequestBody r15 = (okhttp3.RequestBody) r15
            r16 = 0
            r17 = 0
            r18 = 96
            r19 = 0
            java.lang.String r11 = "POST"
            java.lang.Object r1 = com.uploadcare.android.library.api.RequestHelper.executeQuery$default((com.uploadcare.android.library.api.RequestHelper) r10, (java.lang.String) r11, (java.lang.String) r12, (boolean) r13, (java.lang.Class) r14, (okhttp3.RequestBody) r15, (java.lang.String) r16, (java.util.Collection) r17, (int) r18, (java.lang.Object) r19)
            com.uploadcare.android.library.data.UploadFromUrlData r1 = (com.uploadcare.android.library.data.UploadFromUrlData) r1
            java.lang.String r1 = r1.getToken()
            com.uploadcare.android.library.urls.Urls$Companion r2 = com.uploadcare.android.library.urls.Urls.Companion
            java.net.URI r10 = r2.uploadFromUrlStatus(r1)
            r1 = 0
            r11 = 0
            r3 = r23
        L_0x00c4:
            r5 = 0
        L_0x00c5:
            r22.checkUploadCanceled()
            r0.sleep(r3)
            com.uploadcare.android.library.api.UploadcareClient r6 = r0.client
            com.uploadcare.android.library.api.RequestHelper r12 = r6.getRequestHelper()
            java.lang.String r14 = r10.toString()
            java.lang.String r6 = "statusUrl.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r6)
            r15 = 0
            java.lang.Class<com.uploadcare.android.library.data.UploadFromUrlStatusData> r16 = com.uploadcare.android.library.data.UploadFromUrlStatusData.class
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 112(0x70, float:1.57E-43)
            r21 = 0
            java.lang.String r13 = "GET"
            java.lang.Object r6 = com.uploadcare.android.library.api.RequestHelper.executeQuery$default((com.uploadcare.android.library.api.RequestHelper) r12, (java.lang.String) r13, (java.lang.String) r14, (boolean) r15, (java.lang.Class) r16, (okhttp3.RequestBody) r17, (java.lang.String) r18, (java.util.Collection) r19, (int) r20, (java.lang.Object) r21)
            r12 = r6
            com.uploadcare.android.library.data.UploadFromUrlStatusData r12 = (com.uploadcare.android.library.data.UploadFromUrlStatusData) r12
            java.lang.String r6 = r12.getStatus()
            java.lang.String r7 = "success"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0138
            java.lang.String r6 = r12.getFileId()
            if (r6 == 0) goto L_0x0138
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r25 == 0) goto L_0x0113
            long r2 = r12.getDone()
            long r4 = r12.getTotal()
            r1 = r25
            r1.onProgressUpdate(r2, r4, r6)
        L_0x0113:
            r22.checkUploadCanceled()
            com.uploadcare.android.library.api.UploadcareClient r1 = r0.client
            java.lang.String r1 = r1.getSecretKey()
            if (r1 == 0) goto L_0x0129
            com.uploadcare.android.library.api.UploadcareClient r1 = r0.client
            java.lang.String r2 = r12.getFileId()
            com.uploadcare.android.library.api.UploadcareFile r1 = r1.getFile(r2)
            goto L_0x0133
        L_0x0129:
            com.uploadcare.android.library.api.UploadcareClient r1 = r0.client
            java.lang.String r2 = r12.getFileId()
            com.uploadcare.android.library.api.UploadcareFile r1 = r1.getUploadedFile(r2)
        L_0x0133:
            r8.add(r1)
            goto L_0x000d
        L_0x0138:
            java.lang.String r6 = r12.getStatus()
            java.lang.String r7 = "progress"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            r7 = 25
            if (r6 == 0) goto L_0x017c
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            long r13 = r12.getDone()
            double r13 = (double) r13
            double r13 = r13 * r3
            long r3 = r12.getTotal()
            double r3 = (double) r3
            double r13 = r13 / r3
            if (r5 < r7) goto L_0x0159
            goto L_0x000d
        L_0x0159:
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0175
            r22.checkUploadCanceled()
            if (r25 == 0) goto L_0x0170
            long r2 = r12.getDone()
            long r4 = r12.getTotal()
            r1 = r25
            r6 = r13
            r1.onProgressUpdate(r2, r4, r6)
        L_0x0170:
            r3 = r23
            r1 = r13
            goto L_0x00c4
        L_0x0175:
            com.uploadcare.android.library.upload.UrlUploader$Companion r3 = com.uploadcare.android.library.upload.UrlUploader.Companion
            long r3 = r3.calculateTimeToWait$library_release(r5)
            goto L_0x01c8
        L_0x017c:
            java.lang.String r6 = r12.getStatus()
            java.lang.String r13 = "waiting"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r13)
            if (r6 != 0) goto L_0x01be
            java.lang.String r6 = r12.getStatus()
            java.lang.String r13 = "unknown"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r13)
            if (r6 == 0) goto L_0x0195
            goto L_0x01be
        L_0x0195:
            java.lang.String r6 = r12.getStatus()
            java.lang.String r7 = "error"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 != 0) goto L_0x01af
            java.lang.String r6 = r12.getStatus()
            java.lang.String r7 = "failed"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 != 0) goto L_0x01af
            goto L_0x00c5
        L_0x01af:
            r22.checkUploadCanceled()
            com.uploadcare.android.library.exceptions.UploadFailureException r1 = new com.uploadcare.android.library.exceptions.UploadFailureException
            java.lang.String r2 = r12.getError()
            r1.<init>((java.lang.String) r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x01be:
            if (r5 < r7) goto L_0x01c2
            goto L_0x000d
        L_0x01c2:
            com.uploadcare.android.library.upload.UrlUploader$Companion r3 = com.uploadcare.android.library.upload.UrlUploader.Companion
            long r3 = r3.calculateTimeToWait$library_release(r5)
        L_0x01c8:
            int r5 = r5 + 1
            goto L_0x00c5
        L_0x01cc:
            java.util.List r8 = (java.util.List) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.library.upload.MultipleUrlsUploader.upload(long, com.uploadcare.android.library.callbacks.ProgressCallback):java.util.List");
    }

    private final void checkUploadCanceled() {
        if (this.isCanceled) {
            throw new UploadFailureException("Canceled");
        }
    }
}
