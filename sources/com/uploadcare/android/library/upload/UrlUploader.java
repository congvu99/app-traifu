package com.uploadcare.android.library.upload;

import com.uploadcare.android.library.api.UploadcareClient;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.callbacks.ProgressCallback;
import com.uploadcare.android.library.callbacks.UploadFileCallback;
import com.uploadcare.android.library.data.UploadFromUrlStatusData;
import com.uploadcare.android.library.exceptions.UploadFailureException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000bJ\b\u0010\u0014\u001a\u00020\u0012H\u0002J-\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0012\u0010\"\u001a\u00020#2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020!2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/uploadcare/android/library/upload/UrlUploader;", "Lcom/uploadcare/android/library/upload/Uploader;", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "sourceUrl", "", "(Lcom/uploadcare/android/library/api/UploadcareClient;Ljava/lang/String;)V", "checkURLDuplicates", "expire", "filename", "isCanceled", "", "job", "Lkotlinx/coroutines/Job;", "saveURLDuplicates", "signature", "store", "cancel", "", "checkDuplicates", "checkUploadCanceled", "reportProgress", "data", "Lcom/uploadcare/android/library/data/UploadFromUrlStatusData;", "progress", "", "progressCallback", "Lcom/uploadcare/android/library/callbacks/ProgressCallback;", "(Lcom/uploadcare/android/library/data/UploadFromUrlStatusData;DLcom/uploadcare/android/library/callbacks/ProgressCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDuplicates", "signedUpload", "sleep", "millis", "", "upload", "Lcom/uploadcare/android/library/api/UploadcareFile;", "pollingInterval", "uploadAsync", "callback", "Lcom/uploadcare/android/library/callbacks/UploadFileCallback;", "Companion", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UrlUploader.kt */
public final class UrlUploader implements Uploader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_POLLING_INTERVAL = 500;
    public static final int MAX_UPLOAD_STATUS_ATTEMPTS = 25;
    private String checkURLDuplicates;
    private final UploadcareClient client;
    private String expire;
    private String filename;
    private boolean isCanceled;
    private Job job;
    private String saveURLDuplicates;
    private String signature;
    private final String sourceUrl;
    private String store = "auto";

    public UrlUploader(UploadcareClient uploadcareClient, String str) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(str, "sourceUrl");
        this.client = uploadcareClient;
        this.sourceUrl = str;
    }

    public UploadcareFile upload(ProgressCallback progressCallback) {
        return upload(500, progressCallback);
    }

    public void uploadAsync(UploadFileCallback uploadFileCallback) {
        Intrinsics.checkNotNullParameter(uploadFileCallback, "callback");
        this.job = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new UrlUploader$uploadAsync$1(this, uploadFileCallback, (Continuation) null), 2, (Object) null);
    }

    public void cancel() {
        this.isCanceled = true;
        Job job2 = this.job;
        if (job2 != null) {
            JobKt.cancel(job2, "canceled", new UploadFailureException("Canceled"));
        }
        this.job = null;
    }

    public UrlUploader store(boolean z) {
        this.store = String.valueOf(z ? 1 : 0);
        return this;
    }

    public final UrlUploader checkDuplicates(boolean z) {
        this.checkURLDuplicates = String.valueOf(z ? 1 : 0);
        return this;
    }

    public final UrlUploader saveDuplicates(boolean z) {
        this.saveURLDuplicates = String.valueOf(z ? 1 : 0);
        return this;
    }

    public final UrlUploader saveDuplicates(String str) {
        Intrinsics.checkNotNullParameter(str, "filename");
        this.filename = str;
        return this;
    }

    public final UrlUploader signedUpload(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "signature");
        Intrinsics.checkNotNullParameter(str2, "expire");
        this.signature = str;
        this.expire = str2;
        return this;
    }

    public static /* synthetic */ UploadcareFile upload$default(UrlUploader urlUploader, long j, ProgressCallback progressCallback, int i, Object obj) throws UploadFailureException {
        if ((i & 2) != 0) {
            progressCallback = null;
        }
        return urlUploader.upload(j, progressCallback);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01e0, code lost:
        throw new com.uploadcare.android.library.exceptions.UploadFailureException(org.apache.http.HttpHeaders.TIMEOUT);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.uploadcare.android.library.api.UploadcareFile upload(long r21, com.uploadcare.android.library.callbacks.ProgressCallback r23) throws com.uploadcare.android.library.exceptions.UploadFailureException {
        /*
            r20 = this;
            r6 = r20
            okhttp3.MultipartBody$Builder r0 = new okhttp3.MultipartBody$Builder
            r1 = 0
            r2 = 1
            r0.<init>(r1, r2, r1)
            okhttp3.MediaType r1 = okhttp3.MultipartBody.FORM
            okhttp3.MultipartBody$Builder r0 = r0.setType(r1)
            com.uploadcare.android.library.api.UploadcareClient r1 = r6.client
            java.lang.String r1 = r1.getPublicKey()
            java.lang.String r2 = "pub_key"
            okhttp3.MultipartBody$Builder r0 = r0.addFormDataPart(r2, r1)
            java.lang.String r1 = r6.sourceUrl
            java.lang.String r2 = "source_url"
            okhttp3.MultipartBody$Builder r0 = r0.addFormDataPart(r2, r1)
            java.lang.String r1 = r6.store
            java.lang.String r2 = "store"
            okhttp3.MultipartBody$Builder r0 = r0.addFormDataPart(r2, r1)
            java.lang.String r1 = r6.filename
            if (r1 == 0) goto L_0x0034
            java.lang.String r2 = "filename"
            r0.addFormDataPart(r2, r1)
        L_0x0034:
            java.lang.String r1 = r6.checkURLDuplicates
            if (r1 == 0) goto L_0x003d
            java.lang.String r2 = "check_URL_duplicates"
            r0.addFormDataPart(r2, r1)
        L_0x003d:
            java.lang.String r1 = r6.saveURLDuplicates
            if (r1 == 0) goto L_0x0046
            java.lang.String r2 = "save_URL_duplicates"
            r0.addFormDataPart(r2, r1)
        L_0x0046:
            java.lang.String r1 = r6.signature
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x006e
            java.lang.String r1 = r6.expire
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x006e
            java.lang.String r1 = r6.signature
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r2 = "signature"
            r0.addFormDataPart(r2, r1)
            java.lang.String r1 = r6.expire
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r2 = "expire"
            r0.addFormDataPart(r2, r1)
        L_0x006e:
            com.uploadcare.android.library.urls.Urls$Companion r1 = com.uploadcare.android.library.urls.Urls.Companion
            java.net.URI r1 = r1.uploadFromUrl()
            okhttp3.MultipartBody r0 = r0.build()
            com.uploadcare.android.library.api.UploadcareClient r2 = r6.client
            com.uploadcare.android.library.api.RequestHelper r7 = r2.getRequestHelper()
            java.lang.String r9 = r1.toString()
            java.lang.String r1 = "uploadUrl.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
            r10 = 0
            java.lang.Class<com.uploadcare.android.library.data.UploadFromUrlData> r11 = com.uploadcare.android.library.data.UploadFromUrlData.class
            r12 = r0
            okhttp3.RequestBody r12 = (okhttp3.RequestBody) r12
            r13 = 0
            r14 = 0
            r15 = 96
            r16 = 0
            java.lang.String r8 = "POST"
            java.lang.Object r0 = com.uploadcare.android.library.api.RequestHelper.executeQuery$default((com.uploadcare.android.library.api.RequestHelper) r7, (java.lang.String) r8, (java.lang.String) r9, (boolean) r10, (java.lang.Class) r11, (okhttp3.RequestBody) r12, (java.lang.String) r13, (java.util.Collection) r14, (int) r15, (java.lang.Object) r16)
            com.uploadcare.android.library.data.UploadFromUrlData r0 = (com.uploadcare.android.library.data.UploadFromUrlData) r0
            java.lang.String r0 = r0.getToken()
            com.uploadcare.android.library.urls.Urls$Companion r1 = com.uploadcare.android.library.urls.Urls.Companion
            java.net.URI r7 = r1.uploadFromUrlStatus(r0)
            kotlin.jvm.internal.Ref$DoubleRef r8 = new kotlin.jvm.internal.Ref$DoubleRef
            r8.<init>()
            r0 = 0
            r8.element = r0
            r9 = 0
        L_0x00af:
            r0 = r21
            r2 = 0
        L_0x00b2:
            r20.checkUploadCanceled()
            r6.sleep(r0)
            com.uploadcare.android.library.api.UploadcareClient r3 = r6.client
            com.uploadcare.android.library.api.RequestHelper r10 = r3.getRequestHelper()
            java.lang.String r12 = r7.toString()
            java.lang.String r3 = "statusUrl.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r3)
            r13 = 0
            java.lang.Class<com.uploadcare.android.library.data.UploadFromUrlStatusData> r14 = com.uploadcare.android.library.data.UploadFromUrlStatusData.class
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 112(0x70, float:1.57E-43)
            r19 = 0
            java.lang.String r11 = "GET"
            java.lang.Object r3 = com.uploadcare.android.library.api.RequestHelper.executeQuery$default((com.uploadcare.android.library.api.RequestHelper) r10, (java.lang.String) r11, (java.lang.String) r12, (boolean) r13, (java.lang.Class) r14, (okhttp3.RequestBody) r15, (java.lang.String) r16, (java.util.Collection) r17, (int) r18, (java.lang.Object) r19)
            r10 = r3
            com.uploadcare.android.library.data.UploadFromUrlStatusData r10 = (com.uploadcare.android.library.data.UploadFromUrlStatusData) r10
            java.lang.String r3 = r10.getStatus()
            java.lang.String r4 = "success"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r3 == 0) goto L_0x0136
            java.lang.String r3 = r10.getFileId()
            if (r3 == 0) goto L_0x0136
            r8.element = r4
            kotlinx.coroutines.GlobalScope r0 = kotlinx.coroutines.GlobalScope.INSTANCE
            r11 = r0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
            r12 = r0
            kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12
            r13 = 0
            com.uploadcare.android.library.upload.UrlUploader$upload$4 r7 = new com.uploadcare.android.library.upload.UrlUploader$upload$4
            r5 = 0
            r0 = r7
            r1 = r20
            r2 = r10
            r3 = r8
            r4 = r23
            r0.<init>(r1, r2, r3, r4, r5)
            r14 = r7
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r15 = 2
            r16 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r11, r12, r13, r14, r15, r16)
            r20.checkUploadCanceled()
            com.uploadcare.android.library.api.UploadcareClient r0 = r6.client
            java.lang.String r0 = r0.getSecretKey()
            if (r0 == 0) goto L_0x012b
            com.uploadcare.android.library.api.UploadcareClient r0 = r6.client
            java.lang.String r1 = r10.getFileId()
            com.uploadcare.android.library.api.UploadcareFile r0 = r0.getFile(r1)
            goto L_0x0135
        L_0x012b:
            com.uploadcare.android.library.api.UploadcareClient r0 = r6.client
            java.lang.String r1 = r10.getFileId()
            com.uploadcare.android.library.api.UploadcareFile r0 = r0.getUploadedFile(r1)
        L_0x0135:
            return r0
        L_0x0136:
            java.lang.String r3 = r10.getStatus()
            java.lang.String r11 = "progress"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r11)
            r11 = 25
            if (r3 == 0) goto L_0x0189
            long r0 = r10.getDone()
            double r0 = (double) r0
            double r0 = r0 * r4
            long r3 = r10.getTotal()
            double r3 = (double) r3
            double r0 = r0 / r3
            if (r2 >= r11) goto L_0x01d7
            double r3 = r8.element
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0182
            r8.element = r0
            r20.checkUploadCanceled()
            kotlinx.coroutines.GlobalScope r0 = kotlinx.coroutines.GlobalScope.INSTANCE
            r11 = r0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
            r12 = r0
            kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12
            r13 = 0
            com.uploadcare.android.library.upload.UrlUploader$upload$5 r14 = new com.uploadcare.android.library.upload.UrlUploader$upload$5
            r5 = 0
            r0 = r14
            r1 = r20
            r2 = r10
            r3 = r8
            r4 = r23
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r15 = 2
            r16 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r11, r12, r13, r14, r15, r16)
            goto L_0x00af
        L_0x0182:
            com.uploadcare.android.library.upload.UrlUploader$Companion r0 = Companion
            long r0 = r0.calculateTimeToWait$library_release(r2)
            goto L_0x01d3
        L_0x0189:
            java.lang.String r3 = r10.getStatus()
            java.lang.String r4 = "waiting"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x01cb
            java.lang.String r3 = r10.getStatus()
            java.lang.String r4 = "unknown"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x01a2
            goto L_0x01cb
        L_0x01a2:
            java.lang.String r3 = r10.getStatus()
            java.lang.String r4 = "error"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x01bc
            java.lang.String r3 = r10.getStatus()
            java.lang.String r4 = "failed"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x01bc
            goto L_0x00b2
        L_0x01bc:
            r20.checkUploadCanceled()
            com.uploadcare.android.library.exceptions.UploadFailureException r0 = new com.uploadcare.android.library.exceptions.UploadFailureException
            java.lang.String r1 = r10.getError()
            r0.<init>((java.lang.String) r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x01cb:
            if (r2 >= r11) goto L_0x01d7
            com.uploadcare.android.library.upload.UrlUploader$Companion r0 = Companion
            long r0 = r0.calculateTimeToWait$library_release(r2)
        L_0x01d3:
            int r2 = r2 + 1
            goto L_0x00b2
        L_0x01d7:
            com.uploadcare.android.library.exceptions.UploadFailureException r0 = new com.uploadcare.android.library.exceptions.UploadFailureException
            java.lang.String r1 = "Timeout"
            r0.<init>((java.lang.String) r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.library.upload.UrlUploader.upload(long, com.uploadcare.android.library.callbacks.ProgressCallback):com.uploadcare.android.library.api.UploadcareFile");
    }

    private final void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    private final void checkUploadCanceled() {
        if (this.isCanceled) {
            throw new UploadFailureException("Canceled");
        }
    }

    static /* synthetic */ Object reportProgress$default(UrlUploader urlUploader, UploadFromUrlStatusData uploadFromUrlStatusData, double d, ProgressCallback progressCallback, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            progressCallback = null;
        }
        return urlUploader.reportProgress(uploadFromUrlStatusData, d, progressCallback, continuation);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object reportProgress(UploadFromUrlStatusData uploadFromUrlStatusData, double d, ProgressCallback progressCallback, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new UrlUploader$reportProgress$2(progressCallback, uploadFromUrlStatusData, d, (Continuation) null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/uploadcare/android/library/upload/UrlUploader$Companion;", "", "()V", "DEFAULT_POLLING_INTERVAL", "", "MAX_UPLOAD_STATUS_ATTEMPTS", "", "calculateTimeToWait", "retryCount", "calculateTimeToWait$library_release", "library_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UrlUploader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long calculateTimeToWait$library_release(int i) {
            if (i == 0) {
                return 500;
            }
            return 500 * ((long) Math.pow(2.0d, (double) i));
        }
    }
}
