package com.uploadcare.android.library.conversion;

import com.uploadcare.android.library.api.UploadcareClient;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.callbacks.ConversionFilesCallback;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000  2\u00020\u0001:\u0001 B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH$J\b\u0010\u001c\u001a\u00020\u0019H$J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/uploadcare/android/library/conversion/Converter;", "", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "conversionJobs", "", "Lcom/uploadcare/android/library/conversion/ConversionJob;", "(Lcom/uploadcare/android/library/api/UploadcareClient;Ljava/util/List;)V", "isCanceled", "", "job", "Lkotlinx/coroutines/Job;", "store", "", "cancel", "", "checkConvertCanceled", "convert", "Lcom/uploadcare/android/library/api/UploadcareFile;", "pollingInterval", "", "convertAsync", "callback", "Lcom/uploadcare/android/library/callbacks/ConversionFilesCallback;", "getConversionStatusUri", "Ljava/net/URI;", "token", "", "getConversionUri", "getPaths", "sleep", "millis", "Companion", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Converter.kt */
public abstract class Converter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_CONVERSION_STATUS_ATTEMPTS = 10;
    private static final long PROCESSING_TIMEOUT = 300000;
    private final UploadcareClient client;
    private final List<ConversionJob> conversionJobs;
    private boolean isCanceled;
    private Job job;
    private String store;

    /* access modifiers changed from: protected */
    public abstract URI getConversionStatusUri(int i);

    /* access modifiers changed from: protected */
    public abstract URI getConversionUri();

    public Converter(UploadcareClient uploadcareClient, List<? extends ConversionJob> list) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(list, "conversionJobs");
        this.client = uploadcareClient;
        this.conversionJobs = list;
    }

    public final List<UploadcareFile> convert() throws UploadcareApiException {
        return convert(500);
    }

    public final void convertAsync(ConversionFilesCallback conversionFilesCallback) {
        Intrinsics.checkNotNullParameter(conversionFilesCallback, "callback");
        this.job = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new Converter$convertAsync$1(this, conversionFilesCallback, (Continuation) null), 2, (Object) null);
    }

    public final void cancel() {
        this.isCanceled = true;
        Job job2 = this.job;
        if (job2 != null) {
            JobKt.cancel(job2, "canceled", new UploadcareApiException("Canceled"));
        }
        this.job = null;
    }

    public final Converter store(boolean z) {
        this.store = String.valueOf(z ? 1 : 0);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00dc, code lost:
        checkConvertCanceled();
        r1.add(r0.client.getFile(r11.getResult().getUuid()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.uploadcare.android.library.api.UploadcareFile> convert(long r23) throws com.uploadcare.android.library.exceptions.UploadcareApiException {
        /*
            r22 = this;
            r0 = r22
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.uploadcare.android.library.data.ConvertData r2 = new com.uploadcare.android.library.data.ConvertData
            java.util.List r3 = r22.getPaths()
            java.lang.String r4 = r0.store
            r2.<init>(r3, r4)
            com.uploadcare.android.library.api.UploadcareClient r3 = r0.client
            com.uploadcare.android.library.data.ObjectMapper r3 = r3.getObjectMapper()
            java.lang.Class<com.uploadcare.android.library.data.ConvertData> r4 = com.uploadcare.android.library.data.ConvertData.class
            java.lang.reflect.Type r4 = (java.lang.reflect.Type) r4
            java.lang.String r2 = r3.toJson((java.lang.Object) r2, (java.lang.reflect.Type) r4)
            okhttp3.RequestBody$Companion r3 = okhttp3.RequestBody.Companion
            okio.ByteString$Companion r4 = okio.ByteString.Companion
            okio.ByteString r4 = r4.encodeUtf8(r2)
            com.uploadcare.android.library.api.RequestHelper$Companion r5 = com.uploadcare.android.library.api.RequestHelper.Companion
            okhttp3.MediaType r5 = r5.getJSON$library_release()
            okhttp3.RequestBody r11 = r3.create((okio.ByteString) r4, (okhttp3.MediaType) r5)
            java.net.URI r3 = r22.getConversionUri()
            com.uploadcare.android.library.api.UploadcareClient r4 = r0.client
            com.uploadcare.android.library.api.RequestHelper r6 = r4.getRequestHelper()
            java.lang.String r8 = r3.toString()
            java.lang.String r3 = "url.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            java.lang.Class<com.uploadcare.android.library.data.ConvertResultData> r10 = com.uploadcare.android.library.data.ConvertResultData.class
            com.uploadcare.android.library.api.RequestHelper$Companion r3 = com.uploadcare.android.library.api.RequestHelper.Companion
            java.lang.String r12 = r3.md5((java.lang.String) r2)
            java.lang.String r7 = "POST"
            r9 = 1
            r13 = 0
            r14 = 64
            r15 = 0
            java.lang.Object r2 = com.uploadcare.android.library.api.RequestHelper.executeQuery$default((com.uploadcare.android.library.api.RequestHelper) r6, (java.lang.String) r7, (java.lang.String) r8, (boolean) r9, (java.lang.Class) r10, (okhttp3.RequestBody) r11, (java.lang.String) r12, (java.util.Collection) r13, (int) r14, (java.lang.Object) r15)
            com.uploadcare.android.library.data.ConvertResultData r2 = (com.uploadcare.android.library.data.ConvertResultData) r2
            java.util.List r3 = r2.getResult()
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0184
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            java.util.List r2 = r2.getResult()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0075:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x008d
            java.lang.Object r4 = r2.next()
            com.uploadcare.android.library.data.ConvertResult r4 = (com.uploadcare.android.library.data.ConvertResult) r4
            int r4 = r4.getToken()
            java.net.URI r4 = r0.getConversionStatusUri(r4)
            r3.add(r4)
            goto L_0x0075
        L_0x008d:
            java.util.Iterator r2 = r3.iterator()
        L_0x0091:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0181
            java.lang.Object r3 = r2.next()
            java.net.URI r3 = (java.net.URI) r3
            r4 = 0
            r6 = 0
            long r7 = java.lang.System.currentTimeMillis()
            r9 = r23
        L_0x00a6:
            r22.checkConvertCanceled()
            r0.sleep(r9)
            com.uploadcare.android.library.api.UploadcareClient r11 = r0.client
            com.uploadcare.android.library.api.RequestHelper r12 = r11.getRequestHelper()
            java.lang.String r14 = r3.toString()
            java.lang.String r11 = "statusUrl.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r11)
            r15 = 1
            java.lang.Class<com.uploadcare.android.library.data.ConvertStatusData> r16 = com.uploadcare.android.library.data.ConvertStatusData.class
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 112(0x70, float:1.57E-43)
            r21 = 0
            java.lang.String r13 = "GET"
            java.lang.Object r11 = com.uploadcare.android.library.api.RequestHelper.executeQuery$default((com.uploadcare.android.library.api.RequestHelper) r12, (java.lang.String) r13, (java.lang.String) r14, (boolean) r15, (java.lang.Class) r16, (okhttp3.RequestBody) r17, (java.lang.String) r18, (java.util.Collection) r19, (int) r20, (java.lang.Object) r21)
            com.uploadcare.android.library.data.ConvertStatusData r11 = (com.uploadcare.android.library.data.ConvertStatusData) r11
            java.lang.String r12 = r11.getStatus()
            java.lang.String r13 = "finished"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x00f1
            r22.checkConvertCanceled()
            com.uploadcare.android.library.api.UploadcareClient r3 = r0.client
            com.uploadcare.android.library.data.ConvertStatusResultData r4 = r11.getResult()
            java.lang.String r4 = r4.getUuid()
            com.uploadcare.android.library.api.UploadcareFile r3 = r3.getFile(r4)
            r1.add(r3)
            goto L_0x0091
        L_0x00f1:
            java.lang.String r12 = r11.getStatus()
            java.lang.String r13 = "processing"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 != 0) goto L_0x0158
            java.lang.String r12 = r11.getStatus()
            java.lang.String r13 = "pending"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x010a
            goto L_0x0158
        L_0x010a:
            java.lang.String r1 = r11.getStatus()
            java.lang.String r2 = "failed"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x0149
            java.lang.String r1 = r11.getStatus()
            java.lang.String r2 = "canceled"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x012c
            com.uploadcare.android.library.exceptions.UploadcareApiException r1 = new com.uploadcare.android.library.exceptions.UploadcareApiException
            java.lang.String r2 = "Canceled"
            r1.<init>((java.lang.String) r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x012c:
            com.uploadcare.android.library.exceptions.UploadcareApiException r1 = new com.uploadcare.android.library.exceptions.UploadcareApiException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unsupported conversion status: "
            r2.append(r3)
            java.lang.String r3 = r11.getStatus()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0149:
            r22.checkConvertCanceled()
            com.uploadcare.android.library.exceptions.UploadcareApiException r1 = new com.uploadcare.android.library.exceptions.UploadcareApiException
            java.lang.String r2 = r11.getError()
            r1.<init>((java.lang.String) r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0158:
            r11 = 10
            if (r6 >= r11) goto L_0x0177
            r11 = 300000(0x493e0, double:1.482197E-318)
            int r13 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x016d
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r7
            r22.checkConvertCanceled()
            goto L_0x00a6
        L_0x016d:
            com.uploadcare.android.library.upload.UrlUploader$Companion r9 = com.uploadcare.android.library.upload.UrlUploader.Companion
            long r9 = r9.calculateTimeToWait$library_release(r6)
            int r6 = r6 + 1
            goto L_0x00a6
        L_0x0177:
            com.uploadcare.android.library.exceptions.UploadcareApiException r1 = new com.uploadcare.android.library.exceptions.UploadcareApiException
            java.lang.String r2 = "Conversion error: Unexpected processing error."
            r1.<init>((java.lang.String) r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0181:
            java.util.List r1 = (java.util.List) r1
            return r1
        L_0x0184:
            com.uploadcare.android.library.exceptions.UploadcareApiException r1 = new com.uploadcare.android.library.exceptions.UploadcareApiException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Convert Error: "
            r3.append(r4)
            java.util.Map r2 = r2.getProblems()
            java.lang.String r2 = r2.toString()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>((java.lang.String) r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.library.conversion.Converter.convert(long):java.util.List");
    }

    private final void checkConvertCanceled() {
        if (this.isCanceled) {
            throw new UploadcareApiException("Canceled");
        }
    }

    private final void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> getPaths() {
        List<String> arrayList = new ArrayList<>();
        for (ConversionJob path : this.conversionJobs) {
            arrayList.add(path.getPath());
        }
        return arrayList;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/uploadcare/android/library/conversion/Converter$Companion;", "", "()V", "MAX_CONVERSION_STATUS_ATTEMPTS", "", "PROCESSING_TIMEOUT", "", "library_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Converter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
