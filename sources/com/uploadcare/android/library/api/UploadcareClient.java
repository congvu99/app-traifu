package com.uploadcare.android.library.api;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.facebook.imageutils.JfifUtil;
import com.squareup.moshi.Types;
import com.uploadcare.android.library.callbacks.BaseCallback;
import com.uploadcare.android.library.callbacks.CopyFileCallback;
import com.uploadcare.android.library.callbacks.ProjectCallback;
import com.uploadcare.android.library.callbacks.RequestCallback;
import com.uploadcare.android.library.callbacks.UploadcareFileCallback;
import com.uploadcare.android.library.callbacks.UploadcareGroupCallback;
import com.uploadcare.android.library.callbacks.UploadcareWebhookCallback;
import com.uploadcare.android.library.callbacks.UploadcareWebhooksCallback;
import com.uploadcare.android.library.data.CopyOptionsData;
import com.uploadcare.android.library.data.ObjectMapper;
import com.uploadcare.android.library.data.WebhookOptionsData;
import com.uploadcare.android.library.urls.AddFieldsParameter;
import com.uploadcare.android.library.urls.Urls;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.JsonLexerKt;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 n2\u00020\u0001:\u0001nB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0007J0\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007J\u0018\u0010%\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\bJ,\u0010'\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$J0\u0010(\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010*\u001a\u00020\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003JD\u0010,\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010*\u001a\u00020\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$J \u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0003002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003J,\u00102\u001a\u00020 2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0003002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u000103J?\u00104\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0003002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\b7J0\u00108\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0003002\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003JD\u00109\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0003002\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u000103J \u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\bJ0\u0010@\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\b2\u0006\u0010#\u001a\u00020AJ\u000e\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020\u0003J\u0016\u0010D\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u0003J\"\u0010D\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010EJ\u0014\u0010F\u001a\u00020 2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000300J\u001c\u0010G\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000300J(\u0010G\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0003002\n\b\u0002\u0010#\u001a\u0004\u0018\u00010EJ\u000e\u0010H\u001a\u00020I2\u0006\u0010<\u001a\u00020=J\"\u0010J\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010<\u001a\u00020=2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010EJ%\u0010K\u001a\u0004\u0018\u00010I2\u0006\u0010L\u001a\u00020\u00032\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000300H\u0000¢\u0006\u0002\bMJ\u000e\u0010N\u001a\u00020O2\u0006\u0010C\u001a\u00020\u0003J\"\u0010P\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010QJ\u000e\u0010R\u001a\u00020O2\u0006\u0010C\u001a\u00020\u0003J\"\u0010S\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010QJ\u0006\u0010T\u001a\u00020UJ\u000e\u0010V\u001a\u00020.2\u0006\u0010W\u001a\u00020\u0003J\"\u0010X\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010W\u001a\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u000103J\u0006\u0010Y\u001a\u00020ZJ\u0006\u0010[\u001a\u00020\\J\u001a\u0010]\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010^J\u000e\u0010_\u001a\u00020O2\u0006\u0010C\u001a\u00020\u0003J\u000e\u0010`\u001a\u00020.2\u0006\u0010W\u001a\u00020\u0003J\f\u0010a\u001a\b\u0012\u0004\u0012\u00020;00J\u0016\u0010b\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020cJ\u000e\u0010d\u001a\u00020 2\u0006\u0010C\u001a\u00020\u0003J\u0016\u0010e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u0003J\"\u0010e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010EJ\u0014\u0010f\u001a\u00020 2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000300J\u001c\u0010g\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000300J(\u0010g\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0003002\n\b\u0002\u0010#\u001a\u0004\u0018\u00010EJ\u000e\u0010h\u001a\u00020 2\u0006\u0010W\u001a\u00020\u0003J\"\u0010i\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010W\u001a\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010EJ(\u0010j\u001a\u00020;2\u0006\u0010k\u001a\u00020l2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\bJ8\u0010m\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010k\u001a\u00020l2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\b2\u0006\u0010#\u001a\u00020AR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006o"}, d2 = {"Lcom/uploadcare/android/library/api/UploadcareClient;", "", "publicKey", "", "(Ljava/lang/String;)V", "secretKey", "(Ljava/lang/String;Ljava/lang/String;)V", "simpleAuth", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "httpClient", "Lokhttp3/OkHttpClient;", "getHttpClient", "()Lokhttp3/OkHttpClient;", "objectMapper", "Lcom/uploadcare/android/library/data/ObjectMapper;", "getObjectMapper", "()Lcom/uploadcare/android/library/data/ObjectMapper;", "getPublicKey", "()Ljava/lang/String;", "requestHelper", "Lcom/uploadcare/android/library/api/RequestHelper;", "getRequestHelper", "()Lcom/uploadcare/android/library/api/RequestHelper;", "getSecretKey", "getSimpleAuth", "()Z", "copyFile", "Lcom/uploadcare/android/library/api/UploadcareCopyFile;", "source", "storage", "copyFileAsync", "", "context", "Landroid/content/Context;", "callback", "Lcom/uploadcare/android/library/callbacks/CopyFileCallback;", "copyFileLocalStorage", "store", "copyFileLocalStorageAsync", "copyFileRemoteStorage", "target", "makePublic", "pattern", "copyFileRemoteStorageAsync", "createGroup", "Lcom/uploadcare/android/library/api/UploadcareGroup;", "fileIds", "", "jsonpCallback", "createGroupAsync", "Lcom/uploadcare/android/library/callbacks/UploadcareGroupCallback;", "createGroupInternal", "signature", "expire", "createGroupInternal$library_release", "createGroupSigned", "createGroupSignedAsync", "createWebhook", "Lcom/uploadcare/android/library/api/UploadcareWebhook;", "targetUrl", "Ljava/net/URI;", "event", "isActive", "createWebhookAsync", "Lcom/uploadcare/android/library/callbacks/UploadcareWebhookCallback;", "deleteFile", "fileId", "deleteFileAsync", "Lcom/uploadcare/android/library/callbacks/RequestCallback;", "deleteFiles", "deleteFilesAsync", "deleteWebhook", "Lokhttp3/Response;", "deleteWebhookAsync", "executeSaveDeleteBatchCommand", "requestType", "executeSaveDeleteBatchCommand$library_release", "getFile", "Lcom/uploadcare/android/library/api/UploadcareFile;", "getFileAsync", "Lcom/uploadcare/android/library/callbacks/UploadcareFileCallback;", "getFileWithRekognitionInfo", "getFileWithRekognitionInfoAsync", "getFiles", "Lcom/uploadcare/android/library/api/FilesQueryBuilder;", "getGroup", "groupId", "getGroupAsync", "getGroups", "Lcom/uploadcare/android/library/api/GroupsQueryBuilder;", "getProject", "Lcom/uploadcare/android/library/api/Project;", "getProjectAsync", "Lcom/uploadcare/android/library/callbacks/ProjectCallback;", "getUploadedFile", "getUploadedGroup", "getWebhooks", "getWebhooksAsync", "Lcom/uploadcare/android/library/callbacks/UploadcareWebhooksCallback;", "saveFile", "saveFileAsync", "saveFiles", "saveFilesAsync", "storeGroup", "storeGroupAsync", "updateWebhook", "webhookId", "", "updateWebhookAsync", "Companion", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareClient.kt */
public final class UploadcareClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_SAVE_DELETE_BATCH_SIZE = 100;
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final String publicKey;
    private final RequestHelper requestHelper;
    private final String secretKey;
    private final boolean simpleAuth;

    @JvmStatic
    public static final UploadcareClient demoClient() {
        return Companion.demoClient();
    }

    @JvmStatic
    public static final UploadcareClient demoClientUploadOnly() {
        return Companion.demoClientUploadOnly();
    }

    public UploadcareClient(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "publicKey");
        this.publicKey = str;
        this.secretKey = str2;
        this.simpleAuth = z;
        this.objectMapper = ObjectMapper.Companion.build();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        this.httpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).addInterceptor(new PublicKeyInterceptor(this.publicKey)).callTimeout(5, TimeUnit.MINUTES).writeTimeout(3, TimeUnit.MINUTES).readTimeout(1, TimeUnit.MINUTES).build();
        this.requestHelper = new DefaultRequestHelperProvider().get(this);
    }

    public final String getPublicKey() {
        return this.publicKey;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadcareClient(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z);
    }

    public final String getSecretKey() {
        return this.secretKey;
    }

    public final boolean getSimpleAuth() {
        return this.simpleAuth;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadcareClient(String str) {
        this(str, (String) null, false);
        Intrinsics.checkNotNullParameter(str, "publicKey");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UploadcareClient(String str, String str2) {
        this(str, str2, false);
        Intrinsics.checkNotNullParameter(str, "publicKey");
        Intrinsics.checkNotNullParameter(str2, "secretKey");
    }

    public final OkHttpClient getHttpClient() {
        return this.httpClient;
    }

    public final RequestHelper getRequestHelper() {
        return this.requestHelper;
    }

    public final ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    public final Project getProject() {
        URI apiProject = Urls.Companion.apiProject();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiProject.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        return (Project) RequestHelper.executeQuery$default(requestHelper2, "GET", uri, true, Project.class, (RequestBody) null, (String) null, (Collection) null, 112, (Object) null);
    }

    public static /* synthetic */ void getProjectAsync$default(UploadcareClient uploadcareClient, Context context, ProjectCallback projectCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            projectCallback = null;
        }
        uploadcareClient.getProjectAsync(context, projectCallback);
    }

    public final void getProjectAsync(Context context, ProjectCallback projectCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        URI apiProject = Urls.Companion.apiProject();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiProject.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        RequestHelper.executeQueryAsync$default(requestHelper2, context, "GET", uri, true, Project.class, (BaseCallback) projectCallback, (RequestBody) null, (String) null, (Collection) null, 448, (Object) null);
    }

    public final UploadcareFile getUploadedFile(String str) {
        Intrinsics.checkNotNullParameter(str, "fileId");
        URI apiUploadedFile = Urls.Companion.apiUploadedFile(this.publicKey, str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiUploadedFile.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        return (UploadcareFile) RequestHelper.executeQuery$default(requestHelper2, "GET", uri, false, UploadcareFile.class, (RequestBody) null, (String) null, (Collection) null, 112, (Object) null);
    }

    public final UploadcareFile getFile(String str) {
        Intrinsics.checkNotNullParameter(str, "fileId");
        URI apiFile = Urls.Companion.apiFile(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFile.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        return (UploadcareFile) RequestHelper.executeQuery$default(requestHelper2, "GET", uri, true, UploadcareFile.class, (RequestBody) null, (String) null, (Collection) null, 112, (Object) null);
    }

    public static /* synthetic */ void getFileAsync$default(UploadcareClient uploadcareClient, Context context, String str, UploadcareFileCallback uploadcareFileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            uploadcareFileCallback = null;
        }
        uploadcareClient.getFileAsync(context, str, uploadcareFileCallback);
    }

    public final void getFileAsync(Context context, String str, UploadcareFileCallback uploadcareFileCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fileId");
        URI apiFile = Urls.Companion.apiFile(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFile.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        RequestHelper.executeQueryAsync$default(requestHelper2, context, "GET", uri, true, UploadcareFile.class, (BaseCallback) uploadcareFileCallback, (RequestBody) null, (String) null, (Collection) null, 448, (Object) null);
    }

    public final UploadcareFile getFileWithRekognitionInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "fileId");
        URI apiFile = Urls.Companion.apiFile(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFile.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        return (UploadcareFile) RequestHelper.executeQuery$default(requestHelper2, "GET", uri, true, UploadcareFile.class, (RequestBody) null, (String) null, (Collection) CollectionsKt.listOf(new AddFieldsParameter("rekognition_info")), 48, (Object) null);
    }

    public static /* synthetic */ void getFileWithRekognitionInfoAsync$default(UploadcareClient uploadcareClient, Context context, String str, UploadcareFileCallback uploadcareFileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            uploadcareFileCallback = null;
        }
        uploadcareClient.getFileWithRekognitionInfoAsync(context, str, uploadcareFileCallback);
    }

    public final void getFileWithRekognitionInfoAsync(Context context, String str, UploadcareFileCallback uploadcareFileCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fileId");
        URI apiFile = Urls.Companion.apiFile(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFile.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        RequestHelper.executeQueryAsync$default(requestHelper2, context, "GET", uri, true, UploadcareFile.class, (BaseCallback) uploadcareFileCallback, (RequestBody) null, (String) null, (Collection) CollectionsKt.listOf(new AddFieldsParameter("rekognition_info")), (int) JfifUtil.MARKER_SOFn, (Object) null);
    }

    public final UploadcareGroup getGroup(String str) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        URI apiGroup = Urls.Companion.apiGroup(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiGroup.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        return (UploadcareGroup) RequestHelper.executeQuery$default(requestHelper2, "GET", uri, true, UploadcareGroup.class, (RequestBody) null, (String) null, (Collection) null, 112, (Object) null);
    }

    public final UploadcareGroup getUploadedGroup(String str) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        URI apiUploadedGroup = Urls.Companion.apiUploadedGroup(this.publicKey, str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiUploadedGroup.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        return (UploadcareGroup) RequestHelper.executeQuery$default(requestHelper2, "GET", uri, false, UploadcareGroup.class, (RequestBody) null, (String) null, (Collection) null, 112, (Object) null);
    }

    public static /* synthetic */ void getGroupAsync$default(UploadcareClient uploadcareClient, Context context, String str, UploadcareGroupCallback uploadcareGroupCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            uploadcareGroupCallback = null;
        }
        uploadcareClient.getGroupAsync(context, str, uploadcareGroupCallback);
    }

    public final void getGroupAsync(Context context, String str, UploadcareGroupCallback uploadcareGroupCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "groupId");
        URI apiGroup = Urls.Companion.apiGroup(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiGroup.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        RequestHelper.executeQueryAsync$default(requestHelper2, context, "GET", uri, true, UploadcareGroup.class, (BaseCallback) uploadcareGroupCallback, (RequestBody) null, (String) null, (Collection) null, 448, (Object) null);
    }

    public final void storeGroup(String str) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(str), RequestHelper.Companion.getJSON$library_release());
        URI apiGroupStorage = Urls.Companion.apiGroupStorage(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiGroupStorage.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        requestHelper2.executeCommand(RequestHelper.REQUEST_PUT, uri, true, create, RequestHelper.Companion.md5(str));
    }

    public static /* synthetic */ void storeGroupAsync$default(UploadcareClient uploadcareClient, Context context, String str, RequestCallback requestCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            requestCallback = null;
        }
        uploadcareClient.storeGroupAsync(context, str, requestCallback);
    }

    public final void storeGroupAsync(Context context, String str, RequestCallback requestCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "groupId");
        RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(str), RequestHelper.Companion.getJSON$library_release());
        URI apiGroupStorage = Urls.Companion.apiGroupStorage(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiGroupStorage.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        requestHelper2.executeCommandAsync(context, RequestHelper.REQUEST_PUT, uri, true, requestCallback, create, RequestHelper.Companion.md5(str));
    }

    public final FilesQueryBuilder getFiles() {
        return new FilesQueryBuilder(this);
    }

    public final GroupsQueryBuilder getGroups() {
        return new GroupsQueryBuilder(this);
    }

    public final void deleteFile(String str) {
        Intrinsics.checkNotNullParameter(str, "fileId");
        URI apiFile = Urls.Companion.apiFile(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFile.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        RequestHelper.executeCommand$default(requestHelper2, "DELETE", uri, true, (RequestBody) null, (String) null, 24, (Object) null);
    }

    public final void deleteFileAsync(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fileId");
        URI apiFile = Urls.Companion.apiFile(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFile.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        RequestHelper.executeCommandAsync$default(requestHelper2, context, "DELETE", uri, true, (RequestCallback) null, (RequestBody) null, (String) null, 112, (Object) null);
    }

    public static /* synthetic */ void deleteFileAsync$default(UploadcareClient uploadcareClient, Context context, String str, RequestCallback requestCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            requestCallback = null;
        }
        uploadcareClient.deleteFileAsync(context, str, requestCallback);
    }

    public final void deleteFileAsync(Context context, String str, RequestCallback requestCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fileId");
        URI apiFile = Urls.Companion.apiFile(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFile.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        RequestHelper.executeCommandAsync$default(requestHelper2, context, "DELETE", uri, true, requestCallback, (RequestBody) null, (String) null, 96, (Object) null);
    }

    public final void deleteFiles(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "fileIds");
        URI apiFilesBatch = Urls.Companion.apiFilesBatch();
        if (list.size() <= 100) {
            ObjectMapper objectMapper2 = this.objectMapper;
            ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
            Intrinsics.checkNotNullExpressionValue(newParameterizedType, "Types.newParameterizedTy…java, String::class.java)");
            String json = objectMapper2.toJson((Object) list, (Type) newParameterizedType);
            RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
            RequestHelper requestHelper2 = this.requestHelper;
            String uri = apiFilesBatch.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
            requestHelper2.executeCommand("DELETE", uri, true, create, RequestHelper.Companion.md5(json));
            return;
        }
        executeSaveDeleteBatchCommand$library_release("DELETE", list);
    }

    public final void deleteFilesAsync(Context context, List<String> list) {
        List<String> list2 = list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list2, "fileIds");
        URI apiFilesBatch = Urls.Companion.apiFilesBatch();
        if (list.size() < 100) {
            ObjectMapper objectMapper2 = this.objectMapper;
            ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
            Intrinsics.checkNotNullExpressionValue(newParameterizedType, "Types.newParameterizedTy…java, String::class.java)");
            String json = objectMapper2.toJson((Object) list2, (Type) newParameterizedType);
            RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
            RequestHelper requestHelper2 = this.requestHelper;
            String uri = apiFilesBatch.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
            requestHelper2.executeCommandAsync(context, "DELETE", uri, true, (RequestCallback) null, create, RequestHelper.Companion.md5(json));
            return;
        }
        new SaveDeleteBatchTask(this, "DELETE", list, (RequestCallback) null, 8, (DefaultConstructorMarker) null).execute(new Void[0]);
    }

    public static /* synthetic */ void deleteFilesAsync$default(UploadcareClient uploadcareClient, Context context, List list, RequestCallback requestCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            requestCallback = null;
        }
        uploadcareClient.deleteFilesAsync(context, list, requestCallback);
    }

    public final void deleteFilesAsync(Context context, List<String> list, RequestCallback requestCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "fileIds");
        URI apiFilesBatch = Urls.Companion.apiFilesBatch();
        if (list.size() < 100) {
            ObjectMapper objectMapper2 = this.objectMapper;
            ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
            Intrinsics.checkNotNullExpressionValue(newParameterizedType, "Types.newParameterizedTy…java, String::class.java)");
            String json = objectMapper2.toJson((Object) list, (Type) newParameterizedType);
            RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
            RequestHelper requestHelper2 = this.requestHelper;
            String uri = apiFilesBatch.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
            requestHelper2.executeCommandAsync(context, "DELETE", uri, true, requestCallback, create, RequestHelper.Companion.md5(json));
            return;
        }
        new SaveDeleteBatchTask(this, "DELETE", list, requestCallback).execute(new Void[0]);
    }

    public final void saveFile(String str) {
        Intrinsics.checkNotNullParameter(str, "fileId");
        URI apiFileStorage = Urls.Companion.apiFileStorage(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFileStorage.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        RequestHelper.executeCommand$default(requestHelper2, RequestHelper.REQUEST_POST, uri, true, (RequestBody) null, (String) null, 24, (Object) null);
    }

    public final void saveFileAsync(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fileId");
        URI apiFileStorage = Urls.Companion.apiFileStorage(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFileStorage.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        RequestHelper.executeCommandAsync$default(requestHelper2, context, RequestHelper.REQUEST_POST, uri, true, (RequestCallback) null, (RequestBody) null, (String) null, 112, (Object) null);
    }

    public static /* synthetic */ void saveFileAsync$default(UploadcareClient uploadcareClient, Context context, String str, RequestCallback requestCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            requestCallback = null;
        }
        uploadcareClient.saveFileAsync(context, str, requestCallback);
    }

    public final void saveFileAsync(Context context, String str, RequestCallback requestCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fileId");
        URI apiFileStorage = Urls.Companion.apiFileStorage(str);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFileStorage.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        RequestHelper.executeCommandAsync$default(requestHelper2, context, RequestHelper.REQUEST_POST, uri, true, requestCallback, (RequestBody) null, (String) null, 96, (Object) null);
    }

    public final void saveFiles(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "fileIds");
        URI apiFilesBatch = Urls.Companion.apiFilesBatch();
        if (list.size() < 100) {
            ObjectMapper objectMapper2 = this.objectMapper;
            ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
            Intrinsics.checkNotNullExpressionValue(newParameterizedType, "Types.newParameterizedTy…java, String::class.java)");
            String json = objectMapper2.toJson((Object) list, (Type) newParameterizedType);
            RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
            RequestHelper requestHelper2 = this.requestHelper;
            String uri = apiFilesBatch.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
            requestHelper2.executeCommand(RequestHelper.REQUEST_PUT, uri, true, create, RequestHelper.Companion.md5(json));
            return;
        }
        executeSaveDeleteBatchCommand$library_release(RequestHelper.REQUEST_PUT, list);
    }

    public final void saveFilesAsync(Context context, List<String> list) {
        List<String> list2 = list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list2, "fileIds");
        URI apiFilesBatch = Urls.Companion.apiFilesBatch();
        if (list.size() < 100) {
            ObjectMapper objectMapper2 = this.objectMapper;
            ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
            Intrinsics.checkNotNullExpressionValue(newParameterizedType, "Types.newParameterizedTy…java, String::class.java)");
            String json = objectMapper2.toJson((Object) list2, (Type) newParameterizedType);
            RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
            RequestHelper requestHelper2 = this.requestHelper;
            String uri = apiFilesBatch.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
            requestHelper2.executeCommandAsync(context, RequestHelper.REQUEST_PUT, uri, true, (RequestCallback) null, create, RequestHelper.Companion.md5(json));
            return;
        }
        new SaveDeleteBatchTask(this, RequestHelper.REQUEST_PUT, list, (RequestCallback) null, 8, (DefaultConstructorMarker) null).execute(new Void[0]);
    }

    public static /* synthetic */ void saveFilesAsync$default(UploadcareClient uploadcareClient, Context context, List list, RequestCallback requestCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            requestCallback = null;
        }
        uploadcareClient.saveFilesAsync(context, list, requestCallback);
    }

    public final void saveFilesAsync(Context context, List<String> list, RequestCallback requestCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "fileIds");
        URI apiFilesBatch = Urls.Companion.apiFilesBatch();
        if (list.size() < 100) {
            ObjectMapper objectMapper2 = this.objectMapper;
            ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
            Intrinsics.checkNotNullExpressionValue(newParameterizedType, "Types.newParameterizedTy…java, String::class.java)");
            String json = objectMapper2.toJson((Object) list, (Type) newParameterizedType);
            RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
            RequestHelper requestHelper2 = this.requestHelper;
            String uri = apiFilesBatch.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
            requestHelper2.executeCommandAsync(context, RequestHelper.REQUEST_PUT, uri, true, requestCallback, create, RequestHelper.Companion.md5(json));
            return;
        }
        new SaveDeleteBatchTask(this, RequestHelper.REQUEST_PUT, list, requestCallback).execute(new Void[0]);
    }

    public static /* synthetic */ UploadcareCopyFile copyFile$default(UploadcareClient uploadcareClient, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return uploadcareClient.copyFile(str, str2);
    }

    @Deprecated(message = "Deprecated since v2.3.0", replaceWith = @ReplaceWith(expression = "copyFileRemoteStorage(source, storage)", imports = {}))
    public final UploadcareCopyFile copyFile(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "source");
        if (!TextUtils.isEmpty(str2)) {
            return copyFileRemoteStorage$default(this, str, str2, false, (String) null, 12, (Object) null);
        }
        return copyFileLocalStorage$default(this, str, false, 2, (Object) null);
    }

    public static /* synthetic */ UploadcareCopyFile copyFileLocalStorage$default(UploadcareClient uploadcareClient, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return uploadcareClient.copyFileLocalStorage(str, z);
    }

    public final UploadcareCopyFile copyFileLocalStorage(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "source");
        String json = this.objectMapper.toJson((Object) new CopyOptionsData(str, (String) null, Boolean.valueOf(z), (Boolean) null, (String) null, 26, (DefaultConstructorMarker) null), (Type) CopyOptionsData.class);
        RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
        URI apiFileLocalCopy = Urls.Companion.apiFileLocalCopy();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFileLocalCopy.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        return (UploadcareCopyFile) RequestHelper.executeQuery$default(requestHelper2, RequestHelper.REQUEST_POST, uri, true, UploadcareCopyFile.class, create, RequestHelper.Companion.md5(json), (Collection) null, 64, (Object) null);
    }

    public static /* synthetic */ UploadcareCopyFile copyFileRemoteStorage$default(UploadcareClient uploadcareClient, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return uploadcareClient.copyFileRemoteStorage(str, str2, z, str3);
    }

    public final UploadcareCopyFile copyFileRemoteStorage(String str, String str2, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(str, "source");
        String json = this.objectMapper.toJson((Object) new CopyOptionsData(str, str2, (Boolean) null, Boolean.valueOf(z), str3, 4, (DefaultConstructorMarker) null), (Type) CopyOptionsData.class);
        RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
        URI apiFileRemoteCopy = Urls.Companion.apiFileRemoteCopy();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFileRemoteCopy.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        return (UploadcareCopyFile) RequestHelper.executeQuery$default(requestHelper2, RequestHelper.REQUEST_POST, uri, true, UploadcareCopyFile.class, create, RequestHelper.Companion.md5(json), (Collection) null, 64, (Object) null);
    }

    public static /* synthetic */ void copyFileAsync$default(UploadcareClient uploadcareClient, Context context, String str, String str2, CopyFileCallback copyFileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            copyFileCallback = null;
        }
        uploadcareClient.copyFileAsync(context, str, str2, copyFileCallback);
    }

    @Deprecated(message = "Deprecated since v2.3.0", replaceWith = @ReplaceWith(expression = "copyFileRemoteStorageAsync(context, source, storage, callback)", imports = {}))
    public final void copyFileAsync(Context context, String str, String str2, CopyFileCallback copyFileCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "source");
        if (!TextUtils.isEmpty(str2)) {
            copyFileRemoteStorageAsync$default(this, context, str, str2, false, (String) null, copyFileCallback, 24, (Object) null);
        } else {
            copyFileLocalStorageAsync$default(this, context, str, false, copyFileCallback, 4, (Object) null);
        }
    }

    public static /* synthetic */ void copyFileLocalStorageAsync$default(UploadcareClient uploadcareClient, Context context, String str, boolean z, CopyFileCallback copyFileCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            copyFileCallback = null;
        }
        uploadcareClient.copyFileLocalStorageAsync(context, str, z, copyFileCallback);
    }

    public final void copyFileLocalStorageAsync(Context context, String str, boolean z, CopyFileCallback copyFileCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "source");
        String json = this.objectMapper.toJson((Object) new CopyOptionsData(str, (String) null, Boolean.valueOf(z), (Boolean) null, (String) null, 26, (DefaultConstructorMarker) null), (Type) CopyOptionsData.class);
        RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
        URI apiFileLocalCopy = Urls.Companion.apiFileLocalCopy();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFileLocalCopy.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        String md5 = RequestHelper.Companion.md5(json);
        RequestHelper.executeQueryAsync$default(requestHelper2, context, RequestHelper.REQUEST_POST, uri, true, UploadcareCopyFile.class, (BaseCallback) copyFileCallback, create, md5, (Collection) null, 256, (Object) null);
    }

    public static /* synthetic */ void copyFileRemoteStorageAsync$default(UploadcareClient uploadcareClient, Context context, String str, String str2, boolean z, String str3, CopyFileCallback copyFileCallback, int i, Object obj) {
        uploadcareClient.copyFileRemoteStorageAsync(context, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? true : z, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : copyFileCallback);
    }

    public final void copyFileRemoteStorageAsync(Context context, String str, String str2, boolean z, String str3, CopyFileCallback copyFileCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "source");
        String json = this.objectMapper.toJson((Object) new CopyOptionsData(str, str2, (Boolean) null, Boolean.valueOf(z), str3, 4, (DefaultConstructorMarker) null), (Type) CopyOptionsData.class);
        RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
        URI apiFileRemoteCopy = Urls.Companion.apiFileRemoteCopy();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiFileRemoteCopy.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        String md5 = RequestHelper.Companion.md5(json);
        RequestHelper.executeQueryAsync$default(requestHelper2, context, RequestHelper.REQUEST_POST, uri, true, UploadcareCopyFile.class, (BaseCallback) copyFileCallback, create, md5, (Collection) null, 256, (Object) null);
    }

    public static /* synthetic */ UploadcareGroup createGroup$default(UploadcareClient uploadcareClient, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return uploadcareClient.createGroup(list, str);
    }

    public final UploadcareGroup createGroup(List<String> list, String str) {
        Intrinsics.checkNotNullParameter(list, "fileIds");
        return createGroupInternal$library_release$default(this, list, str, (String) null, (String) null, 12, (Object) null);
    }

    public static /* synthetic */ UploadcareGroup createGroupSigned$default(UploadcareClient uploadcareClient, List list, String str, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        return uploadcareClient.createGroupSigned(list, str, str2, str3);
    }

    public final UploadcareGroup createGroupSigned(List<String> list, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(list, "fileIds");
        Intrinsics.checkNotNullParameter(str, "signature");
        Intrinsics.checkNotNullParameter(str2, "expire");
        return createGroupInternal$library_release(list, str3, str, str2);
    }

    public static /* synthetic */ void createGroupAsync$default(UploadcareClient uploadcareClient, List list, String str, UploadcareGroupCallback uploadcareGroupCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            uploadcareGroupCallback = null;
        }
        uploadcareClient.createGroupAsync(list, str, uploadcareGroupCallback);
    }

    public final void createGroupAsync(List<String> list, String str, UploadcareGroupCallback uploadcareGroupCallback) {
        Intrinsics.checkNotNullParameter(list, "fileIds");
        new CreateGroupTask(this, list, str, (String) null, (String) null, uploadcareGroupCallback, 24, (DefaultConstructorMarker) null).execute(new Void[0]);
    }

    public static /* synthetic */ void createGroupSignedAsync$default(UploadcareClient uploadcareClient, Context context, List list, String str, String str2, String str3, UploadcareGroupCallback uploadcareGroupCallback, int i, Object obj) {
        uploadcareClient.createGroupSignedAsync(context, list, str, str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : uploadcareGroupCallback);
    }

    public final void createGroupSignedAsync(Context context, List<String> list, String str, String str2, String str3, UploadcareGroupCallback uploadcareGroupCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "fileIds");
        Intrinsics.checkNotNullParameter(str, "signature");
        Intrinsics.checkNotNullParameter(str2, "expire");
        new CreateGroupTask(this, list, str3, str, str2, uploadcareGroupCallback).execute(new Void[0]);
    }

    public final List<UploadcareWebhook> getWebhooks() {
        URI apiWebhooks = Urls.Companion.apiWebhooks();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiWebhooks.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, UploadcareWebhook.class);
        Intrinsics.checkNotNullExpressionValue(newParameterizedType, "Types.newParameterizedTy…dcareWebhook::class.java)");
        return (List) RequestHelper.executeQuery$default(requestHelper2, "GET", uri, true, newParameterizedType, (RequestBody) null, (String) null, (Collection) null, 112, (Object) null);
    }

    public final void getWebhooksAsync(Context context, UploadcareWebhooksCallback uploadcareWebhooksCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uploadcareWebhooksCallback, "callback");
        URI apiWebhooks = Urls.Companion.apiWebhooks();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiWebhooks.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, UploadcareWebhook.class);
        Intrinsics.checkNotNullExpressionValue(newParameterizedType, "Types.newParameterizedTy…dcareWebhook::class.java)");
        RequestHelper.executeQueryAsync$default(requestHelper2, context, "GET", uri, true, newParameterizedType, (BaseCallback) uploadcareWebhooksCallback, (RequestBody) null, (String) null, (Collection) null, 448, (Object) null);
    }

    public static /* synthetic */ UploadcareWebhook createWebhook$default(UploadcareClient uploadcareClient, URI uri, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return uploadcareClient.createWebhook(uri, str, z);
    }

    public final UploadcareWebhook createWebhook(URI uri, String str, boolean z) {
        Intrinsics.checkNotNullParameter(uri, "targetUrl");
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EVENT);
        String json = this.objectMapper.toJson((Object) new WebhookOptionsData(uri, str, Boolean.valueOf(z)), (Type) WebhookOptionsData.class);
        RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
        URI apiWebhooks = Urls.Companion.apiWebhooks();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri2 = apiWebhooks.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "url.toString()");
        return (UploadcareWebhook) RequestHelper.executeQuery$default(requestHelper2, RequestHelper.REQUEST_POST, uri2, true, UploadcareWebhook.class, create, RequestHelper.Companion.md5(json), (Collection) null, 64, (Object) null);
    }

    public static /* synthetic */ void createWebhookAsync$default(UploadcareClient uploadcareClient, Context context, URI uri, String str, boolean z, UploadcareWebhookCallback uploadcareWebhookCallback, int i, Object obj) {
        uploadcareClient.createWebhookAsync(context, uri, str, (i & 8) != 0 ? true : z, uploadcareWebhookCallback);
    }

    public final void createWebhookAsync(Context context, URI uri, String str, boolean z, UploadcareWebhookCallback uploadcareWebhookCallback) {
        URI uri2 = uri;
        String str2 = str;
        UploadcareWebhookCallback uploadcareWebhookCallback2 = uploadcareWebhookCallback;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(uri2, "targetUrl");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_EVENT);
        Intrinsics.checkNotNullParameter(uploadcareWebhookCallback2, "callback");
        String json = this.objectMapper.toJson((Object) new WebhookOptionsData(uri2, str2, Boolean.valueOf(z)), (Type) WebhookOptionsData.class);
        RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
        URI apiWebhooks = Urls.Companion.apiWebhooks();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri3 = apiWebhooks.toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "url.toString()");
        RequestHelper.executeQueryAsync$default(requestHelper2, context2, RequestHelper.REQUEST_POST, uri3, true, UploadcareWebhook.class, (BaseCallback) uploadcareWebhookCallback2, create, RequestHelper.Companion.md5(json), (Collection) null, 256, (Object) null);
    }

    public static /* synthetic */ UploadcareWebhook updateWebhook$default(UploadcareClient uploadcareClient, int i, URI uri, String str, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        return uploadcareClient.updateWebhook(i, uri, str, z);
    }

    public final UploadcareWebhook updateWebhook(int i, URI uri, String str, boolean z) {
        Intrinsics.checkNotNullParameter(uri, "targetUrl");
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EVENT);
        String json = this.objectMapper.toJson((Object) new WebhookOptionsData(uri, str, Boolean.valueOf(z)), (Type) WebhookOptionsData.class);
        RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
        URI apiWebhook = Urls.Companion.apiWebhook(i);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri2 = apiWebhook.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "url.toString()");
        return (UploadcareWebhook) RequestHelper.executeQuery$default(requestHelper2, RequestHelper.REQUEST_PUT, uri2, true, UploadcareWebhook.class, create, RequestHelper.Companion.md5(json), (Collection) null, 64, (Object) null);
    }

    public static /* synthetic */ void updateWebhookAsync$default(UploadcareClient uploadcareClient, Context context, int i, URI uri, String str, boolean z, UploadcareWebhookCallback uploadcareWebhookCallback, int i2, Object obj) {
        uploadcareClient.updateWebhookAsync(context, i, uri, str, (i2 & 16) != 0 ? true : z, uploadcareWebhookCallback);
    }

    public final void updateWebhookAsync(Context context, int i, URI uri, String str, boolean z, UploadcareWebhookCallback uploadcareWebhookCallback) {
        URI uri2 = uri;
        String str2 = str;
        UploadcareWebhookCallback uploadcareWebhookCallback2 = uploadcareWebhookCallback;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(uri2, "targetUrl");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_EVENT);
        Intrinsics.checkNotNullParameter(uploadcareWebhookCallback2, "callback");
        String json = this.objectMapper.toJson((Object) new WebhookOptionsData(uri2, str2, Boolean.valueOf(z)), (Type) WebhookOptionsData.class);
        RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
        URI apiWebhook = Urls.Companion.apiWebhook(i);
        RequestHelper requestHelper2 = this.requestHelper;
        String uri3 = apiWebhook.toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "url.toString()");
        RequestHelper.executeQueryAsync$default(requestHelper2, context2, RequestHelper.REQUEST_PUT, uri3, true, UploadcareWebhook.class, (BaseCallback) uploadcareWebhookCallback2, create, RequestHelper.Companion.md5(json), (Collection) null, 256, (Object) null);
    }

    public final Response deleteWebhook(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "targetUrl");
        String json = this.objectMapper.toJson((Object) new WebhookOptionsData(uri, (String) null, (Boolean) null, 6, (DefaultConstructorMarker) null), (Type) WebhookOptionsData.class);
        RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
        URI apiDeleteWebhook = Urls.Companion.apiDeleteWebhook();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri2 = apiDeleteWebhook.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "url.toString()");
        return requestHelper2.executeCommand("DELETE", uri2, true, create, RequestHelper.Companion.md5(json));
    }

    public static /* synthetic */ void deleteWebhookAsync$default(UploadcareClient uploadcareClient, Context context, URI uri, RequestCallback requestCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            requestCallback = null;
        }
        uploadcareClient.deleteWebhookAsync(context, uri, requestCallback);
    }

    public final void deleteWebhookAsync(Context context, URI uri, RequestCallback requestCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "targetUrl");
        String json = this.objectMapper.toJson((Object) new WebhookOptionsData(uri, (String) null, (Boolean) null, 6, (DefaultConstructorMarker) null), (Type) WebhookOptionsData.class);
        RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
        URI apiDeleteWebhook = Urls.Companion.apiDeleteWebhook();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri2 = apiDeleteWebhook.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "url.toString()");
        requestHelper2.executeCommandAsync(context, "DELETE", uri2, true, requestCallback, create, RequestHelper.Companion.md5(json));
    }

    public static /* synthetic */ UploadcareGroup createGroupInternal$library_release$default(UploadcareClient uploadcareClient, List list, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return uploadcareClient.createGroupInternal$library_release(list, str, str2, str3);
    }

    public final UploadcareGroup createGroupInternal$library_release(List<String> list, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(list, "fileIds");
        MultipartBody.Builder addFormDataPart = new MultipartBody.Builder((String) null, 1, (DefaultConstructorMarker) null).setType(MultipartBody.FORM).addFormDataPart("pub_key", this.publicKey);
        if (str != null) {
            addFormDataPart.addFormDataPart("callback", str);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Intrinsics.checkNotNull(str2);
            addFormDataPart.addFormDataPart("signature", str2);
            Intrinsics.checkNotNull(str3);
            addFormDataPart.addFormDataPart("expire", str3);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            addFormDataPart.addFormDataPart("files[" + i + JsonLexerKt.END_LIST, list.get(i));
        }
        URI apiCreateGroup = Urls.Companion.apiCreateGroup();
        MultipartBody build = addFormDataPart.build();
        RequestHelper requestHelper2 = this.requestHelper;
        String uri = apiCreateGroup.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        return (UploadcareGroup) RequestHelper.executeQuery$default(requestHelper2, RequestHelper.REQUEST_POST, uri, false, UploadcareGroup.class, (RequestBody) build, (String) null, (Collection) null, 96, (Object) null);
    }

    public final Response executeSaveDeleteBatchCommand$library_release(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "requestType");
        Intrinsics.checkNotNullParameter(list, "fileIds");
        URI apiFilesBatch = Urls.Companion.apiFilesBatch();
        Response response = null;
        IntProgression step = RangesKt.step((IntProgression) CollectionsKt.getIndices(list), 100);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? first >= last : first <= last) {
            int i = first;
            while (true) {
                List<String> subList = list.subList(i, i + 100 >= list.size() ? list.size() - 1 : i + 99);
                ObjectMapper objectMapper2 = this.objectMapper;
                ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, String.class);
                Intrinsics.checkNotNullExpressionValue(newParameterizedType, "Types.newParameterizedTy…java, String::class.java)");
                String json = objectMapper2.toJson((Object) subList, (Type) newParameterizedType);
                RequestBody create = RequestBody.Companion.create(ByteString.Companion.encodeUtf8(json), RequestHelper.Companion.getJSON$library_release());
                RequestHelper requestHelper2 = this.requestHelper;
                String uri = apiFilesBatch.toString();
                Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
                response = requestHelper2.executeCommand(str, uri, true, create, RequestHelper.Companion.md5(json));
                this.requestHelper.checkResponseStatus$library_release(response);
                if (i == last) {
                    break;
                }
                i += step2;
            }
        }
        return response;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/uploadcare/android/library/api/UploadcareClient$Companion;", "", "()V", "MAX_SAVE_DELETE_BATCH_SIZE", "", "demoClient", "Lcom/uploadcare/android/library/api/UploadcareClient;", "demoClientUploadOnly", "library_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UploadcareClient.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UploadcareClient demoClient() {
            return new UploadcareClient("demopublickey", "demosecretkey");
        }

        @JvmStatic
        public final UploadcareClient demoClientUploadOnly() {
            return new UploadcareClient("demopublickey");
        }
    }
}
