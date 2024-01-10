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
import com.uploadcare.android.library.callbacks.UploadFileCallback;
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
import java.io.InputStream;
import java.net.URI;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 G2\u00020\u0001:\u0001GB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0013B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0015J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020-H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000fH\u0002J\"\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00192\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u001209H\u0002J\u001a\u0010:\u001a\u0004\u0018\u00010;2\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u0019H\u0002J\b\u0010<\u001a\u00020\u001cH\u0002J\"\u0010=\u001a\u0002032\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00192\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0006\u0010>\u001a\u00020\u001cJ\u0006\u0010?\u001a\u00020\u001cJ\u0010\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020&H\u0002J\u0016\u0010B\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fJ \u0010C\u001a\u00020$2\u0006\u00104\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u0019H\u0002J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u001cH\u0016J\u0012\u0010D\u001a\u0002032\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u0010E\u001a\u00020-2\u0006\u0010A\u001a\u00020&H\u0016J*\u0010F\u001a\u0002032\u0006\u0010#\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00192\b\u00106\u001a\u0004\u0018\u000107H\u0002R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/uploadcare/android/library/upload/FileUploader;", "Lcom/uploadcare/android/library/upload/Uploader;", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "file", "Ljava/io/File;", "(Lcom/uploadcare/android/library/api/UploadcareClient;Ljava/io/File;)V", "uri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "(Lcom/uploadcare/android/library/api/UploadcareClient;Landroid/net/Uri;Landroid/content/Context;)V", "stream", "Ljava/io/InputStream;", "filename", "", "(Lcom/uploadcare/android/library/api/UploadcareClient;Ljava/io/InputStream;Ljava/lang/String;)V", "bytes", "", "(Lcom/uploadcare/android/library/api/UploadcareClient;[BLjava/lang/String;)V", "content", "(Lcom/uploadcare/android/library/api/UploadcareClient;Ljava/lang/String;Ljava/lang/String;)V", "allBytesWritten", "", "contentMediaType", "Lokhttp3/MediaType;", "expire", "isAsyncUpload", "", "<set-?>", "isCanceled", "()Z", "isPaused", "job", "Lkotlinx/coroutines/Job;", "multipartData", "Lcom/uploadcare/android/library/data/UploadMultipartStartData;", "resultCallback", "Lcom/uploadcare/android/library/callbacks/UploadFileCallback;", "signature", "size", "store", "uploadChunkNumber", "", "cancel", "", "checkUploadCanceled", "completeMultipartUpload", "Lcom/uploadcare/android/library/data/UploadMultipartCompleteData;", "uuid", "directUpload", "Lcom/uploadcare/android/library/api/UploadcareFile;", "name", "contentType", "progressCallback", "Lcom/uploadcare/android/library/callbacks/ProgressCallback;", "getChunkedSequence", "Lkotlin/sequences/Sequence;", "getRequestBody", "Lokhttp3/RequestBody;", "isPauseResumeSupported", "multipartUpload", "pause", "resume", "resumeUpload", "callback", "signedUpload", "startMultipartUpload", "upload", "uploadAsync", "uploadChunks", "Companion", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: FileUploader.kt */
public final class FileUploader implements Uploader {
    private static final int CHUNK_SIZE = 5242880;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_FILE_NAME = "default_filename";
    private static final long MIN_MULTIPART_SIZE = 10485760;
    /* access modifiers changed from: private */
    public long allBytesWritten;
    private final byte[] bytes;
    private final UploadcareClient client;
    private final String content;
    /* access modifiers changed from: private */
    public MediaType contentMediaType;
    private final Context context;
    private String expire;
    private final File file;
    private final String filename;
    private boolean isAsyncUpload;
    private boolean isCanceled;
    private boolean isPaused;
    private Job job;
    /* access modifiers changed from: private */
    public UploadMultipartStartData multipartData;
    /* access modifiers changed from: private */
    public UploadFileCallback resultCallback;
    private String signature;
    /* access modifiers changed from: private */
    public long size;
    private String store;
    private final InputStream stream;
    private int uploadChunkNumber;
    private final Uri uri;

    public final boolean isCanceled() {
        return this.isCanceled;
    }

    public final boolean isPaused() {
        return this.isPaused;
    }

    public FileUploader(UploadcareClient uploadcareClient, File file2) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(file2, "file");
        this.store = "auto";
        this.uploadChunkNumber = -1;
        this.client = uploadcareClient;
        this.file = file2;
        this.stream = null;
        this.bytes = null;
        String str = null;
        this.filename = str;
        this.uri = null;
        this.context = null;
        this.content = str;
    }

    public FileUploader(UploadcareClient uploadcareClient, Uri uri2, Context context2) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.store = "auto";
        this.uploadChunkNumber = -1;
        this.client = uploadcareClient;
        this.file = null;
        this.stream = null;
        this.bytes = null;
        String str = null;
        this.filename = str;
        this.uri = uri2;
        this.context = context2;
        this.content = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileUploader(UploadcareClient uploadcareClient, InputStream inputStream, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uploadcareClient, inputStream, (i & 4) != 0 ? DEFAULT_FILE_NAME : str);
    }

    public FileUploader(UploadcareClient uploadcareClient, InputStream inputStream, String str) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(inputStream, "stream");
        Intrinsics.checkNotNullParameter(str, "filename");
        this.store = "auto";
        this.uploadChunkNumber = -1;
        this.client = uploadcareClient;
        this.file = null;
        this.stream = inputStream;
        this.bytes = null;
        this.filename = str;
        this.uri = null;
        this.context = null;
        this.content = null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileUploader(UploadcareClient uploadcareClient, byte[] bArr, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uploadcareClient, bArr, (i & 4) != 0 ? DEFAULT_FILE_NAME : str);
    }

    public FileUploader(UploadcareClient uploadcareClient, byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(str, "filename");
        this.store = "auto";
        this.uploadChunkNumber = -1;
        this.client = uploadcareClient;
        this.file = null;
        this.stream = null;
        this.bytes = bArr;
        this.filename = str;
        this.uri = null;
        this.context = null;
        this.content = null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileUploader(UploadcareClient uploadcareClient, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uploadcareClient, str, (i & 4) != 0 ? DEFAULT_FILE_NAME : str2);
    }

    public FileUploader(UploadcareClient uploadcareClient, String str, String str2) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "filename");
        this.store = "auto";
        this.uploadChunkNumber = -1;
        this.client = uploadcareClient;
        this.file = null;
        this.stream = null;
        this.bytes = null;
        this.filename = str2;
        this.uri = null;
        this.context = null;
        this.content = str;
    }

    public UploadcareFile upload(ProgressCallback progressCallback) throws UploadFailureException {
        MediaType mediaType;
        String str;
        String str2;
        MediaType mimeType;
        File file2 = this.file;
        if (file2 != null) {
            str = file2.getName();
            Intrinsics.checkNotNullExpressionValue(str, "file.name");
            this.size = this.file.length();
            mediaType = UploadUtils.Companion.getMimeType(this.file);
            if (mediaType == null) {
                throw new UploadFailureException("Cannot get mime type for file: " + str);
            }
        } else if (this.uri == null || this.context == null) {
            String str3 = this.content;
            if (str3 != null && (str2 = this.filename) != null) {
                this.size = (long) str3.length();
                mimeType = UploadUtils.Companion.getMimeType(this.filename);
                if (mimeType == null) {
                    throw new UploadFailureException("Cannot get mime type for file: " + this.filename);
                }
            } else if (this.stream == null || (str = this.filename) == null) {
                byte[] bArr = this.bytes;
                if (bArr == null || (str2 = this.filename) == null) {
                    throw new UploadFailureException((Throwable) new IllegalArgumentException());
                }
                this.size = (long) bArr.length;
                mimeType = UploadUtils.Companion.getMimeType(this.filename);
                if (mimeType == null) {
                    throw new UploadFailureException("Cannot get mime type for file: " + this.filename);
                }
            } else {
                this.size = 0;
                mediaType = UploadUtils.Companion.getMimeType(this.filename);
                if (mediaType == null) {
                    throw new UploadFailureException("Cannot get mime type for file: " + this.filename);
                }
            }
            String str4 = str2;
            mediaType = mimeType;
            str = str4;
        } else {
            str = UploadUtils.Companion.getFileName(this.uri, this.context);
            Long fileSize = UploadUtils.Companion.getFileSize(this.uri, this.context);
            if (fileSize != null) {
                this.size = fileSize.longValue();
                UploadUtils.Companion companion = UploadUtils.Companion;
                ContentResolver contentResolver = this.context.getContentResolver();
                Intrinsics.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                mediaType = companion.getMimeType(contentResolver, this.uri);
                if (mediaType == null) {
                    throw new UploadFailureException("Cannot get mime type for uri: " + this.uri);
                }
            } else {
                throw new UploadFailureException("Cannot get file size for uri: " + this.uri);
            }
        }
        this.contentMediaType = mediaType;
        if (this.size > MIN_MULTIPART_SIZE) {
            return multipartUpload(str, mediaType, progressCallback);
        }
        return directUpload(str, mediaType, progressCallback);
    }

    public void uploadAsync(UploadFileCallback uploadFileCallback) {
        Intrinsics.checkNotNullParameter(uploadFileCallback, "callback");
        this.isAsyncUpload = true;
        this.resultCallback = uploadFileCallback;
        this.job = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new FileUploader$uploadAsync$1(this, uploadFileCallback, (Continuation) null), 2, (Object) null);
    }

    public void cancel() {
        this.isCanceled = true;
        Job job2 = this.job;
        if (job2 != null) {
            JobKt.cancel(job2, "canceled", new UploadFailureException("Canceled"));
        }
        this.job = null;
    }

    public FileUploader store(boolean z) {
        this.store = String.valueOf(z ? 1 : 0);
        return this;
    }

    public final FileUploader signedUpload(String str, String str2) {
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
        if (!isPauseResumeSupported() || this.uploadChunkNumber < 0) {
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
        UploadFileCallback uploadFileCallback = this.resultCallback;
        if (uploadFileCallback == null) {
            return false;
        }
        resumeUpload(uploadFileCallback);
        return true;
    }

    private final void resumeUpload(UploadFileCallback uploadFileCallback) {
        this.job = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new FileUploader$resumeUpload$1(this, uploadFileCallback, (Continuation) null), 2, (Object) null);
    }

    private final boolean isPauseResumeSupported() {
        return this.size > MIN_MULTIPART_SIZE && this.isAsyncUpload;
    }

    private final UploadcareFile directUpload(String str, MediaType mediaType, ProgressCallback progressCallback) {
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
        RequestBody requestBody = getRequestBody(str, mediaType);
        if (requestBody != null) {
            addFormDataPart.addFormDataPart("file", str, new CountingRequestBody(requestBody, new FileUploader$directUpload$countingRequestBody$1(this, progressCallback)));
            MultipartBody build = addFormDataPart.build();
            RequestHelper requestHelper = this.client.getRequestHelper();
            String uri2 = uploadBase.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uploadUrl.toString()");
            String file2 = ((UploadBaseData) RequestHelper.executeQuery$default(requestHelper, RequestHelper.REQUEST_POST, uri2, false, UploadBaseData.class, (RequestBody) build, (String) null, (Collection) null, 96, (Object) null)).getFile();
            checkUploadCanceled();
            if (this.client.getSecretKey() != null) {
                return this.client.getFile(file2);
            }
            return this.client.getUploadedFile(file2);
        }
        throw new UploadFailureException("Cannot read file: " + str);
    }

    private final RequestBody getRequestBody(String str, MediaType mediaType) {
        Context context2;
        if (this.file != null) {
            return RequestBody.Companion.create(this.file, mediaType);
        }
        if (this.uri != null && (context2 = this.context) != null) {
            try {
                ContentResolver contentResolver = context2.getContentResolver();
                byte[] bytes2 = UploadUtils.Companion.getBytes(contentResolver != null ? contentResolver.openInputStream(this.uri) : null);
                if (bytes2 != null) {
                    return RequestBody.Companion.create$default(RequestBody.Companion, bytes2, mediaType, 0, 0, 6, (Object) null);
                }
                return null;
            } catch (IOException e) {
                throw new UploadFailureException((Throwable) e);
            } catch (NullPointerException e2) {
                throw new UploadFailureException((Throwable) e2);
            } catch (Exception e3) {
                throw new UploadFailureException((Throwable) e3);
            }
        } else if (this.content != null && this.filename != null) {
            return RequestBody.Companion.create(this.content, mediaType);
        } else {
            if (this.stream != null && this.filename != null) {
                byte[] bytes3 = UploadUtils.Companion.getBytes(this.stream);
                if (bytes3 != null) {
                    return RequestBody.Companion.create$default(RequestBody.Companion, bytes3, mediaType, 0, 0, 6, (Object) null);
                }
                return null;
            } else if (this.bytes != null && this.filename != null) {
                return RequestBody.Companion.create$default(RequestBody.Companion, this.bytes, mediaType, 0, 0, 6, (Object) null);
            } else {
                throw new UploadFailureException((Throwable) new IllegalArgumentException());
            }
        }
    }

    private final UploadcareFile multipartUpload(String str, MediaType mediaType, ProgressCallback progressCallback) {
        UploadMultipartStartData startMultipartUpload = startMultipartUpload(str, this.size, mediaType);
        this.multipartData = startMultipartUpload;
        this.uploadChunkNumber = 0;
        this.allBytesWritten = 0;
        return uploadChunks(startMultipartUpload, this.size, mediaType, progressCallback);
    }

    /* access modifiers changed from: private */
    public final UploadcareFile uploadChunks(UploadMultipartStartData uploadMultipartStartData, long j, MediaType mediaType, ProgressCallback progressCallback) {
        List<byte[]> list = SequencesKt.toList(getChunkedSequence());
        while (this.uploadChunkNumber < list.size()) {
            checkUploadCanceled();
            if (!this.isPaused) {
                RequestHelper.executeCommand$default(this.client.getRequestHelper(), RequestHelper.REQUEST_PUT, uploadMultipartStartData.getParts().get(this.uploadChunkNumber), false, new CountingRequestBody(RequestBody.Companion.create$default(RequestBody.Companion, list.get(this.uploadChunkNumber), mediaType, 0, 0, 6, (Object) null), new FileUploader$uploadChunks$chunk$1(this, j, progressCallback)), (String) null, 16, (Object) null);
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
        String uri2 = uploadMultipartStart.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uploadUrl.toString()");
        return (UploadMultipartStartData) RequestHelper.executeQuery$default(requestHelper, RequestHelper.REQUEST_POST, uri2, false, UploadMultipartStartData.class, (RequestBody) build, (String) null, (Collection) null, 96, (Object) null);
    }

    private final UploadMultipartCompleteData completeMultipartUpload(String str) {
        checkUploadCanceled();
        MultipartBody.Builder addFormDataPart = new MultipartBody.Builder((String) null, 1, (DefaultConstructorMarker) null).setType(MultipartBody.FORM).addFormDataPart("UPLOADCARE_PUB_KEY", this.client.getPublicKey());
        addFormDataPart.addFormDataPart("uuid", str);
        URI uploadMultipartComplete = Urls.Companion.uploadMultipartComplete();
        MultipartBody build = addFormDataPart.build();
        RequestHelper requestHelper = this.client.getRequestHelper();
        String uri2 = uploadMultipartComplete.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uploadCompleteUrl.toString()");
        return (UploadMultipartCompleteData) RequestHelper.executeQuery$default(requestHelper, RequestHelper.REQUEST_POST, uri2, false, UploadMultipartCompleteData.class, (RequestBody) build, (String) null, (Collection) null, 96, (Object) null);
    }

    private final Sequence<byte[]> getChunkedSequence() {
        if (this.file != null) {
            return UploadUtils.Companion.chunkedSequence(this.file, (int) CHUNK_SIZE);
        }
        if (this.uri != null && this.context != null) {
            return UploadUtils.Companion.chunkedSequence(this.uri, this.context, CHUNK_SIZE);
        }
        if (this.content != null && this.filename != null) {
            return UploadUtils.Companion.chunkedSequence(this.content, (int) CHUNK_SIZE);
        }
        if (this.stream != null && this.filename != null) {
            return UploadUtils.Companion.chunkedSequence(this.stream, (int) CHUNK_SIZE);
        }
        if (this.bytes != null && this.filename != null) {
            return UploadUtils.Companion.chunkedSequence(this.bytes, (int) CHUNK_SIZE);
        }
        throw new UploadFailureException((Throwable) new IllegalArgumentException());
    }

    /* access modifiers changed from: private */
    public final void checkUploadCanceled() {
        if (this.isCanceled) {
            throw new UploadFailureException("Canceled");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/uploadcare/android/library/upload/FileUploader$Companion;", "", "()V", "CHUNK_SIZE", "", "DEFAULT_FILE_NAME", "", "MIN_MULTIPART_SIZE", "", "library_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: FileUploader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
