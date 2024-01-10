package com.uploadcare.android.library.upload;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.uploadcare.android.library.api.RequestHelper;
import com.uploadcare.android.library.api.UploadcareClient;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.callbacks.ProgressCallback;
import com.uploadcare.android.library.callbacks.UploadFilesCallback;
import com.uploadcare.android.library.data.UploadBaseData;
import com.uploadcare.android.library.data.UploadMultipartCompleteData;
import com.uploadcare.android.library.data.UploadMultipartStartData;
import com.uploadcare.android.library.exceptions.UploadFailureException;
import com.uploadcare.android.library.exceptions.UploadPausedException;
import com.uploadcare.android.library.upload.UploadUtils;
import com.uploadcare.android.library.urls.Urls;
import com.uploadcare.android.library.utils.CountingRequestBody;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u000f\u0018\u0000 J2\u00020\u0001:\u0001JB\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010*\u001a\u00020\u000eH\u0002J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012H\u0002J\"\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0002J\b\u00107\u001a\u00020\u0014H\u0002J0\u00108\u001a\u00020!2\u0006\u00102\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u00102\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0006\u0010=\u001a\u00020\u0014J\u0006\u0010>\u001a\u00020\u0014J\u0010\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020\u001eH\u0002J\u0016\u0010A\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J \u0010B\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0014H\u0016J\"\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0018\u0010F\u001a\b\u0012\u0004\u0012\u00020!0\u00052\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010G\u001a\u00020,2\u0006\u0010@\u001a\u00020\u001eH\u0016J0\u0010H\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u00102\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0018\u0010I\u001a\b\u0012\u0004\u0012\u00020!0\u00052\b\u00105\u001a\u0004\u0018\u000106H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/uploadcare/android/library/upload/MultipleFilesUploader;", "Lcom/uploadcare/android/library/upload/MultipleUploader;", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "files", "", "Ljava/io/File;", "(Lcom/uploadcare/android/library/api/UploadcareClient;Ljava/util/List;)V", "uris", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "(Lcom/uploadcare/android/library/api/UploadcareClient;Ljava/util/List;Landroid/content/Context;)V", "allBytesWritten", "", "contentMediaType", "Lokhttp3/MediaType;", "expire", "", "isAsyncUpload", "", "<set-?>", "isCanceled", "()Z", "isPaused", "job", "Lkotlinx/coroutines/Job;", "multipartData", "Lcom/uploadcare/android/library/data/UploadMultipartStartData;", "resultCallback", "Lcom/uploadcare/android/library/callbacks/UploadFilesCallback;", "results", "Ljava/util/ArrayList;", "Lcom/uploadcare/android/library/api/UploadcareFile;", "signature", "size", "store", "totalBytesWritten", "totalFilesSize", "uploadChunkNumber", "", "uploadFileNumber", "calculateTotalSize", "cancel", "", "checkUploadCanceled", "completeMultipartUpload", "Lcom/uploadcare/android/library/data/UploadMultipartCompleteData;", "uuid", "directUpload", "name", "requestBody", "Lokhttp3/RequestBody;", "progressCallback", "Lcom/uploadcare/android/library/callbacks/ProgressCallback;", "isPauseResumeSupported", "multipartUpload", "contentType", "chunkedSequence", "Lkotlin/sequences/Sequence;", "", "pause", "resume", "resumeUpload", "callback", "signedUpload", "startMultipartUpload", "updateProgress", "fileBytesWritten", "totalFileSize", "upload", "uploadAsync", "uploadChunks", "uploadFiles", "Companion", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: MultipleFilesUploader.kt */
public final class MultipleFilesUploader implements MultipleUploader {
    private static final int CHUNK_SIZE = 5242880;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long MIN_MULTIPART_SIZE = 10485760;
    /* access modifiers changed from: private */
    public long allBytesWritten;
    private final UploadcareClient client;
    private MediaType contentMediaType;
    private final Context context;
    private String expire;
    private final List<File> files;
    private boolean isAsyncUpload;
    private boolean isCanceled;
    private boolean isPaused;
    private Job job;
    private UploadMultipartStartData multipartData;
    private UploadFilesCallback resultCallback;
    private final ArrayList<UploadcareFile> results = new ArrayList<>();
    private String signature;
    /* access modifiers changed from: private */
    public long size;
    private String store = "auto";
    private long totalBytesWritten;
    private long totalFilesSize;
    private int uploadChunkNumber = -1;
    private int uploadFileNumber = -1;
    private final List<Uri> uris;

    public final boolean isCanceled() {
        return this.isCanceled;
    }

    public final boolean isPaused() {
        return this.isPaused;
    }

    public MultipleFilesUploader(UploadcareClient uploadcareClient, List<? extends File> list) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(list, "files");
        this.client = uploadcareClient;
        this.files = list;
        this.uris = null;
        this.context = null;
    }

    public MultipleFilesUploader(UploadcareClient uploadcareClient, List<? extends Uri> list, Context context2) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(list, "uris");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.client = uploadcareClient;
        this.files = null;
        this.uris = list;
        this.context = context2;
    }

    public List<UploadcareFile> upload(ProgressCallback progressCallback) throws UploadFailureException {
        this.totalFilesSize = calculateTotalSize();
        this.uploadFileNumber = 0;
        this.uploadChunkNumber = 0;
        return uploadFiles(progressCallback);
    }

    public void uploadAsync(UploadFilesCallback uploadFilesCallback) {
        Intrinsics.checkNotNullParameter(uploadFilesCallback, "callback");
        this.isAsyncUpload = true;
        this.resultCallback = uploadFilesCallback;
        this.job = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new MultipleFilesUploader$uploadAsync$1(this, uploadFilesCallback, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final List<UploadcareFile> uploadFiles(ProgressCallback progressCallback) {
        UploadcareFile uploadcareFile;
        RequestBody create$default;
        UploadcareFile uploadcareFile2;
        ProgressCallback progressCallback2 = progressCallback;
        boolean z = false;
        if (this.files != null) {
            while (this.uploadFileNumber < this.files.size()) {
                if (!this.isPaused) {
                    try {
                        File file = this.files.get(this.uploadFileNumber);
                        String name = file.getName();
                        this.size = file.length();
                        MediaType mimeType = UploadUtils.Companion.getMimeType(file);
                        if (mimeType != null) {
                            this.contentMediaType = mimeType;
                            ArrayList<UploadcareFile> arrayList = this.results;
                            if (this.size > MIN_MULTIPART_SIZE) {
                                if (!z) {
                                    if (this.uploadChunkNumber != -1) {
                                        UploadMultipartStartData uploadMultipartStartData = this.multipartData;
                                        Intrinsics.checkNotNull(uploadMultipartStartData);
                                        uploadcareFile2 = uploadChunks(uploadMultipartStartData, mimeType, UploadUtils.Companion.chunkedSequence(file, (int) CHUNK_SIZE), progressCallback2);
                                    }
                                }
                                Intrinsics.checkNotNullExpressionValue(name, "name");
                                uploadcareFile2 = multipartUpload(name, mimeType, UploadUtils.Companion.chunkedSequence(file, (int) CHUNK_SIZE), progressCallback2);
                            } else {
                                Intrinsics.checkNotNullExpressionValue(name, "name");
                                uploadcareFile2 = directUpload(name, RequestBody.Companion.create(file, mimeType), progressCallback2);
                            }
                            arrayList.add(uploadcareFile2);
                            this.uploadFileNumber++;
                            z = true;
                        } else {
                            throw new UploadFailureException("Cannot get mime type for file: " + name);
                        }
                    } catch (UploadFailureException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    this.uploadChunkNumber = -1;
                    throw new UploadPausedException("Paused");
                }
            }
        } else {
            Context context2 = this.context;
            if (!(context2 == null || this.uris == null)) {
                ContentResolver contentResolver = context2.getContentResolver();
                while (this.uploadFileNumber < this.uris.size()) {
                    if (!this.isPaused) {
                        try {
                            Uri uri = this.uris.get(this.uploadFileNumber);
                            String fileName = UploadUtils.Companion.getFileName(uri, this.context);
                            Long fileSize = UploadUtils.Companion.getFileSize(uri, this.context);
                            if (fileSize != null) {
                                this.size = fileSize.longValue();
                                UploadUtils.Companion companion = UploadUtils.Companion;
                                ContentResolver contentResolver2 = this.context.getContentResolver();
                                Intrinsics.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
                                MediaType mimeType2 = companion.getMimeType(contentResolver2, uri);
                                if (mimeType2 != null) {
                                    this.contentMediaType = mimeType2;
                                    ArrayList<UploadcareFile> arrayList2 = this.results;
                                    if (this.size <= MIN_MULTIPART_SIZE) {
                                        byte[] bytes = UploadUtils.Companion.getBytes(contentResolver != null ? contentResolver.openInputStream(uri) : null);
                                        if (bytes == null || (create$default = RequestBody.Companion.create$default(RequestBody.Companion, bytes, mimeType2, 0, 0, 6, (Object) null)) == null) {
                                            throw new UploadFailureException("Cannot read file: " + fileName);
                                        }
                                        uploadcareFile = directUpload(fileName, create$default, progressCallback2);
                                    } else if (z || this.uploadChunkNumber == -1) {
                                        uploadcareFile = multipartUpload(fileName, mimeType2, UploadUtils.Companion.chunkedSequence(uri, this.context, CHUNK_SIZE), progressCallback2);
                                    } else {
                                        UploadMultipartStartData uploadMultipartStartData2 = this.multipartData;
                                        Intrinsics.checkNotNull(uploadMultipartStartData2);
                                        uploadcareFile = uploadChunks(uploadMultipartStartData2, mimeType2, UploadUtils.Companion.chunkedSequence(uri, this.context, CHUNK_SIZE), progressCallback2);
                                    }
                                    arrayList2.add(uploadcareFile);
                                    this.uploadFileNumber++;
                                    z = true;
                                } else {
                                    throw new UploadFailureException("Cannot get mime type for uri: " + uri);
                                }
                            } else {
                                throw new UploadFailureException("Cannot get file size for uri: " + uri);
                            }
                        } catch (IOException e3) {
                            throw new UploadFailureException((Throwable) e3);
                        } catch (NullPointerException e4) {
                            throw new UploadFailureException((Throwable) e4);
                        } catch (Exception e5) {
                            throw new UploadFailureException((Throwable) e5);
                        } catch (UploadFailureException e6) {
                            e6.printStackTrace();
                        }
                    } else {
                        this.uploadChunkNumber = -1;
                        throw new UploadPausedException("Paused");
                    }
                }
            }
        }
        return this.results;
    }

    public void cancel() {
        this.isCanceled = true;
        Job job2 = this.job;
        if (job2 != null) {
            JobKt.cancel(job2, "Canceled", new UploadFailureException("Canceled"));
        }
        this.job = null;
    }

    public MultipleFilesUploader store(boolean z) {
        this.store = String.valueOf(z ? 1 : 0);
        return this;
    }

    public final MultipleFilesUploader signedUpload(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "signature");
        Intrinsics.checkNotNullParameter(str2, "expire");
        this.signature = str;
        this.expire = str2;
        return this;
    }

    public final boolean pause() {
        if (this.isPaused) {
            return true;
        }
        if (!isPauseResumeSupported() || this.uploadFileNumber < 0) {
            return false;
        }
        this.isPaused = true;
        return true;
    }

    public final boolean resume() {
        if (!this.isPaused) {
            return true;
        }
        if (!isPauseResumeSupported()) {
            return false;
        }
        this.isPaused = false;
        UploadFilesCallback uploadFilesCallback = this.resultCallback;
        if (uploadFilesCallback == null) {
            return false;
        }
        resumeUpload(uploadFilesCallback);
        return true;
    }

    private final void resumeUpload(UploadFilesCallback uploadFilesCallback) {
        this.job = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new MultipleFilesUploader$resumeUpload$1(this, uploadFilesCallback, (Continuation) null), 2, (Object) null);
    }

    private final boolean isPauseResumeSupported() {
        return this.isAsyncUpload;
    }

    private final UploadcareFile directUpload(String str, RequestBody requestBody, ProgressCallback progressCallback) {
        URI uploadBase = Urls.Companion.uploadBase();
        MultipartBody.Builder addFormDataPart = new MultipartBody.Builder((String) null, 1, (DefaultConstructorMarker) null).setType(MultipartBody.FORM).addFormDataPart("UPLOADCARE_PUB_KEY", this.client.getPublicKey()).addFormDataPart("UPLOADCARE_STORE", this.store);
        if (!TextUtils.isEmpty(this.signature) && !TextUtils.isEmpty(this.expire)) {
            String str2 = this.signature;
            Intrinsics.checkNotNull(str2);
            addFormDataPart.addFormDataPart("signature", str2);
            String str3 = this.expire;
            Intrinsics.checkNotNull(str3);
            addFormDataPart.addFormDataPart("expire", str3);
        }
        addFormDataPart.addFormDataPart("file", str, new CountingRequestBody(requestBody, new MultipleFilesUploader$directUpload$countingRequestBody$1(this, progressCallback)));
        MultipartBody build = addFormDataPart.build();
        RequestHelper requestHelper = this.client.getRequestHelper();
        String uri = uploadBase.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uploadUrl.toString()");
        String file = ((UploadBaseData) RequestHelper.executeQuery$default(requestHelper, RequestHelper.REQUEST_POST, uri, false, UploadBaseData.class, (RequestBody) build, (String) null, (Collection) null, 96, (Object) null)).getFile();
        checkUploadCanceled();
        if (this.client.getSecretKey() != null) {
            return this.client.getFile(file);
        }
        return this.client.getUploadedFile(file);
    }

    private final UploadcareFile multipartUpload(String str, MediaType mediaType, Sequence<byte[]> sequence, ProgressCallback progressCallback) {
        UploadMultipartStartData startMultipartUpload = startMultipartUpload(str, this.size, mediaType);
        this.multipartData = startMultipartUpload;
        this.uploadChunkNumber = 0;
        this.allBytesWritten = 0;
        return uploadChunks(startMultipartUpload, mediaType, sequence, progressCallback);
    }

    private final UploadcareFile uploadChunks(UploadMultipartStartData uploadMultipartStartData, MediaType mediaType, Sequence<byte[]> sequence, ProgressCallback progressCallback) {
        List<byte[]> list = SequencesKt.toList(sequence);
        while (this.uploadChunkNumber < list.size()) {
            checkUploadCanceled();
            if (!this.isPaused) {
                RequestHelper.executeCommand$default(this.client.getRequestHelper(), RequestHelper.REQUEST_PUT, uploadMultipartStartData.getParts().get(this.uploadChunkNumber), false, new CountingRequestBody(RequestBody.Companion.create$default(RequestBody.Companion, list.get(this.uploadChunkNumber), mediaType, 0, 0, 6, (Object) null), new MultipleFilesUploader$uploadChunks$chunk$1(this, progressCallback)), (String) null, 16, (Object) null);
                this.uploadChunkNumber++;
            } else {
                throw new UploadPausedException("Paused");
            }
        }
        this.uploadChunkNumber = -1;
        UploadMultipartCompleteData completeMultipartUpload = completeMultipartUpload(uploadMultipartStartData.getUuid());
        checkUploadCanceled();
        if (this.client.getSecretKey() != null) {
            return this.client.getFile(completeMultipartUpload.getUuid());
        }
        return this.client.getUploadedFile(completeMultipartUpload.getUuid());
    }

    private final UploadMultipartStartData startMultipartUpload(String str, long j, MediaType mediaType) {
        checkUploadCanceled();
        MultipartBody.Builder addFormDataPart = new MultipartBody.Builder((String) null, 1, (DefaultConstructorMarker) null).setType(MultipartBody.FORM).addFormDataPart("UPLOADCARE_PUB_KEY", this.client.getPublicKey()).addFormDataPart("UPLOADCARE_STORE", this.store);
        if (!TextUtils.isEmpty(this.signature) && !TextUtils.isEmpty(this.expire)) {
            String str2 = this.signature;
            Intrinsics.checkNotNull(str2);
            addFormDataPart.addFormDataPart("signature", str2);
            String str3 = this.expire;
            Intrinsics.checkNotNull(str3);
            addFormDataPart.addFormDataPart("expire", str3);
        }
        addFormDataPart.addFormDataPart("filename", str);
        addFormDataPart.addFormDataPart("size", String.valueOf(j));
        addFormDataPart.addFormDataPart(FirebaseAnalytics.Param.CONTENT_TYPE, mediaType.toString());
        URI uploadMultipartStart = Urls.Companion.uploadMultipartStart();
        MultipartBody build = addFormDataPart.build();
        RequestHelper requestHelper = this.client.getRequestHelper();
        String uri = uploadMultipartStart.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uploadUrl.toString()");
        return (UploadMultipartStartData) RequestHelper.executeQuery$default(requestHelper, RequestHelper.REQUEST_POST, uri, false, UploadMultipartStartData.class, (RequestBody) build, (String) null, (Collection) null, 96, (Object) null);
    }

    private final UploadMultipartCompleteData completeMultipartUpload(String str) {
        checkUploadCanceled();
        MultipartBody.Builder addFormDataPart = new MultipartBody.Builder((String) null, 1, (DefaultConstructorMarker) null).setType(MultipartBody.FORM).addFormDataPart("UPLOADCARE_PUB_KEY", this.client.getPublicKey());
        addFormDataPart.addFormDataPart("uuid", str);
        URI uploadMultipartComplete = Urls.Companion.uploadMultipartComplete();
        MultipartBody build = addFormDataPart.build();
        RequestHelper requestHelper = this.client.getRequestHelper();
        String uri = uploadMultipartComplete.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uploadCompleteUrl.toString()");
        return (UploadMultipartCompleteData) RequestHelper.executeQuery$default(requestHelper, RequestHelper.REQUEST_POST, uri, false, UploadMultipartCompleteData.class, (RequestBody) build, (String) null, (Collection) null, 96, (Object) null);
    }

    private final long calculateTotalSize() {
        List<Uri> list;
        List<File> list2 = this.files;
        long j = 0;
        if (list2 != null) {
            for (File length : list2) {
                j += length.length();
            }
        } else if (!(this.context == null || (list = this.uris) == null)) {
            for (Uri fileSize : list) {
                Long fileSize2 = UploadUtils.Companion.getFileSize(fileSize, this.context);
                if (fileSize2 != null) {
                    j += fileSize2.longValue();
                }
            }
        }
        return j;
    }

    /* access modifiers changed from: private */
    public final void updateProgress(long j, long j2, ProgressCallback progressCallback) {
        if (progressCallback != null) {
            long j3 = this.totalBytesWritten;
            long j4 = j3 + j;
            if (j >= j2) {
                this.totalBytesWritten = j3 + j;
            }
            long j5 = this.totalBytesWritten;
            long j6 = this.totalFilesSize;
            if (j5 > j6) {
                this.totalBytesWritten = j6;
            }
            long j7 = this.totalFilesSize;
            ProgressCallback progressCallback2 = progressCallback;
            progressCallback2.onProgressUpdate(this.totalBytesWritten, j7, (((double) j4) * 1.0d) / ((double) j7));
        }
    }

    /* access modifiers changed from: private */
    public final void checkUploadCanceled() {
        if (this.isCanceled) {
            throw new UploadFailureException("Canceled");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/uploadcare/android/library/upload/MultipleFilesUploader$Companion;", "", "()V", "CHUNK_SIZE", "", "MIN_MULTIPART_SIZE", "", "library_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MultipleFilesUploader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
