package com.uploadcare.android.library.api;

import android.content.Context;
import android.net.Uri;
import com.facebook.internal.security.CertificateUtil;
import com.uploadcare.android.library.callbacks.BaseCallback;
import com.uploadcare.android.library.callbacks.RequestCallback;
import com.uploadcare.android.library.callbacks.UploadcareFilesCallback;
import com.uploadcare.android.library.callbacks.UploadcareGroupsCallback;
import com.uploadcare.android.library.data.PageData;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.library.exceptions.UploadcareAuthenticationException;
import com.uploadcare.android.library.exceptions.UploadcareInvalidRequestException;
import com.uploadcare.android.library.urls.UrlParameter;
import com.uploadcare.android.library.urls.UrlUtils;
import com.uploadcare.android.library.urls.Urls;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0002J6\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000eJJ\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000eJ6\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u001eJJ\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H!0 \"\b\b\u0000\u0010!*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\"\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H!0$0#J8\u0010%\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010&Je\u0010'\u001a\u0002H!\"\b\b\u0000\u0010!*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c¢\u0006\u0002\u0010(J_\u0010'\u001a\u0002H!\"\b\b\u0000\u0010!*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c¢\u0006\u0002\u0010+Jz\u0010,\u001a\u00020\u0006\"\b\b\u0000\u0010!*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u0002H!\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJt\u0010,\u001a\u00020\u0006\"\b\b\u0000\u0010!*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u0002H!\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJ6\u0010-\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000eJJ\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u0002022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/uploadcare/android/library/api/RequestHelper;", "", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "(Lcom/uploadcare/android/library/api/UploadcareClient;)V", "checkResponseStatus", "", "response", "Lokhttp3/Response;", "checkResponseStatus$library_release", "callback", "Lcom/uploadcare/android/library/callbacks/BaseCallback;", "executeCommand", "requestType", "", "url", "apiHeaders", "", "requestBody", "Lokhttp3/RequestBody;", "requestBodyMD5", "executeCommandAsync", "context", "Landroid/content/Context;", "Lcom/uploadcare/android/library/callbacks/RequestCallback;", "executeGroupsPaginatedQueryWithOffsetLimitAsync", "Ljava/net/URI;", "urlParameters", "", "Lcom/uploadcare/android/library/urls/UrlParameter;", "Lcom/uploadcare/android/library/callbacks/UploadcareGroupsCallback;", "executePaginatedQuery", "", "T", "dataClass", "Ljava/lang/Class;", "Lcom/uploadcare/android/library/data/PageData;", "executePaginatedQueryWithOffsetLimitAsync", "Lcom/uploadcare/android/library/callbacks/UploadcareFilesCallback;", "executeQuery", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Class;Lokhttp3/RequestBody;Ljava/lang/String;Ljava/util/Collection;)Ljava/lang/Object;", "dataType", "Ljava/lang/reflect/ParameterizedType;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/reflect/ParameterizedType;Lokhttp3/RequestBody;Ljava/lang/String;Ljava/util/Collection;)Ljava/lang/Object;", "executeQueryAsync", "makeSignature", "date", "contentType", "setApiHeaders", "requestBuilder", "Lokhttp3/Request$Builder;", "Companion", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: RequestHelper.kt */
public final class RequestHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss z";
    private static final String DATE_FORMAT_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss";
    /* access modifiers changed from: private */
    public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    /* access modifiers changed from: private */
    public static final MediaType JSON = MediaType.Companion.parse("application/json");
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final String MAC_ALGORITHM = "HmacSHA1";
    public static final String REQUEST_DELETE = "DELETE";
    public static final String REQUEST_GET = "GET";
    public static final String REQUEST_POST = "POST";
    public static final String REQUEST_PUT = "PUT";
    /* access modifiers changed from: private */
    public static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    /* access modifiers changed from: private */
    public final UploadcareClient client;

    public RequestHelper(UploadcareClient uploadcareClient) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        this.client = uploadcareClient;
    }

    public static /* synthetic */ String makeSignature$default(RequestHelper requestHelper, String str, String str2, String str3, String str4, String str5, int i, Object obj) throws NoSuchAlgorithmException, InvalidKeyException, UploadcareApiException {
        if ((i & 8) != 0) {
            str4 = null;
        }
        String str6 = str4;
        if ((i & 16) != 0) {
            str5 = null;
        }
        return requestHelper.makeSignature(str, str2, str3, str6, str5);
    }

    public final String makeSignature(String str, String str2, String str3, String str4, String str5) throws NoSuchAlgorithmException, InvalidKeyException, UploadcareApiException {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "date");
        Intrinsics.checkNotNullParameter(str3, "requestType");
        if (this.client.getSecretKey() != null) {
            String substring = str.substring(StringsKt.indexOf$default((CharSequence) str, Urls.API_BASE, 0, false, 6, (Object) null) + 26, str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            if (str4 == null) {
                str4 = Companion.md5("");
            }
            sb.append(str4);
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            if (str5 == null) {
                str5 = "application/json";
            }
            sb.append(str5);
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            sb.append(str2);
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            sb.append(substring);
            String secretKey = this.client.getSecretKey();
            Charset charset = Charsets.UTF_8;
            if (secretKey != null) {
                byte[] bytes = secretKey.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, MAC_ALGORITHM);
                Mac instance = Mac.getInstance(MAC_ALGORITHM);
                instance.init(secretKeySpec);
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                Charset charset2 = Charsets.UTF_8;
                if (sb2 != null) {
                    byte[] bytes2 = sb2.getBytes(charset2);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                    byte[] doFinal = instance.doFinal(bytes2);
                    Companion companion = Companion;
                    Intrinsics.checkNotNullExpressionValue(doFinal, "hmacBytes");
                    return companion.toHexString(doFinal);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new UploadcareApiException("Secret key is required for this request.");
    }

    public static /* synthetic */ void setApiHeaders$default(RequestHelper requestHelper, Request.Builder builder, String str, String str2, BaseCallback baseCallback, String str3, String str4, int i, Object obj) throws UploadcareApiException {
        requestHelper.setApiHeaders(builder, str, str2, (i & 8) != 0 ? null : baseCallback, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }

    public final void setApiHeaders(Request.Builder builder, String str, String str2, BaseCallback<? extends Object> baseCallback, String str3, String str4) throws UploadcareApiException {
        Intrinsics.checkNotNullParameter(builder, "requestBuilder");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "requestType");
        GregorianCalendar gregorianCalendar = new GregorianCalendar(GMT);
        Companion companion = Companion;
        Date time = gregorianCalendar.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
        String access$rfc2822 = companion.rfc2822(time);
        builder.addHeader("Content-Type", str4 != null ? str4 : "application/json");
        builder.addHeader("Accept", "application/vnd.uploadcare-v0.6+json");
        Intrinsics.checkNotNullExpressionValue(access$rfc2822, "formattedDate");
        builder.addHeader("Date", access$rfc2822);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("javauploadcare-android/%s/%s", Arrays.copyOf(new Object[]{"3.1.0", this.client.getPublicKey()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        builder.addHeader("User-Agent", format);
        String str5 = null;
        if (this.client.getSimpleAuth()) {
            str5 = "Uploadcare.Simple " + this.client.getPublicKey() + CertificateUtil.DELIMITER + this.client.getSecretKey();
        } else {
            try {
                str5 = "Uploadcare " + this.client.getPublicKey() + CertificateUtil.DELIMITER + makeSignature(str, access$rfc2822, str2, str3, str4);
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
                if (baseCallback != null) {
                    baseCallback.onFailure(new UploadcareApiException("Error when signing the request", e));
                } else {
                    throw new UploadcareApiException("Error when signing the request");
                }
            }
        }
        if (str5 != null) {
            builder.addHeader("Authorization", str5);
        }
    }

    public static /* synthetic */ Object executeQuery$default(RequestHelper requestHelper, String str, String str2, boolean z, Class cls, RequestBody requestBody, String str3, Collection collection, int i, Object obj) throws UploadcareApiException {
        return requestHelper.executeQuery(str, str2, z, cls, (i & 16) != 0 ? null : requestBody, (i & 32) != 0 ? null : str3, (Collection<? extends UrlParameter>) (i & 64) != 0 ? null : collection);
    }

    public final <T> T executeQuery(String str, String str2, boolean z, Class<T> cls, RequestBody requestBody, String str3, Collection<? extends UrlParameter> collection) throws UploadcareApiException {
        String string;
        String str4 = str;
        Class<T> cls2 = cls;
        RequestBody requestBody2 = requestBody;
        Collection<? extends UrlParameter> collection2 = collection;
        Intrinsics.checkNotNullParameter(str, "requestType");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(cls2, "dataClass");
        Uri.Builder buildUpon = Uri.parse(str2).buildUpon();
        if (collection2 != null) {
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
            companion.setQueryParameters(buildUpon, collection2);
        }
        UrlUtils.Companion companion2 = UrlUtils.Companion;
        Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
        URI trustedBuild = companion2.trustedBuild(buildUpon);
        Request.Builder builder = new Request.Builder();
        String uri = trustedBuild.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "pageUrl.toString()");
        Request.Builder url = builder.url(uri);
        switch (str.hashCode()) {
            case 70454:
                if (str.equals("GET")) {
                    url.get();
                    break;
                }
                break;
            case 79599:
                if (str.equals(REQUEST_PUT) && requestBody2 != null) {
                    url.put(requestBody2);
                    break;
                }
            case 2461856:
                if (str.equals(REQUEST_POST) && requestBody2 != null) {
                    url.post(requestBody2);
                    break;
                }
            case 2012838315:
                if (str.equals("DELETE") && requestBody2 != null) {
                    url.delete(requestBody2);
                    break;
                }
        }
        if (z) {
            setApiHeaders$default(this, url, str2, str, (BaseCallback) null, str3, String.valueOf(requestBody2 != null ? requestBody.contentType() : null), 8, (Object) null);
        }
        try {
            Response execute = this.client.getHttpClient().newCall(url.build()).execute();
            checkResponseStatus$library_release(execute);
            ResponseBody body = execute.body();
            if (body == null || (string = body.string()) == null) {
                throw new UploadcareApiException("No response");
            }
            T fromJson = this.client.getObjectMapper().fromJson(string, cls2);
            if (fromJson != null) {
                return fromJson;
            }
            throw new UploadcareApiException("Can't parse result");
        } catch (RuntimeException e) {
            throw new UploadcareApiException(e.getMessage());
        } catch (IOException e2) {
            throw new UploadcareApiException(e2.getMessage());
        }
    }

    public static /* synthetic */ Object executeQuery$default(RequestHelper requestHelper, String str, String str2, boolean z, ParameterizedType parameterizedType, RequestBody requestBody, String str3, Collection collection, int i, Object obj) throws UploadcareApiException {
        return requestHelper.executeQuery(str, str2, z, parameterizedType, (i & 16) != 0 ? null : requestBody, (i & 32) != 0 ? null : str3, (Collection<? extends UrlParameter>) (i & 64) != 0 ? null : collection);
    }

    public final <T> T executeQuery(String str, String str2, boolean z, ParameterizedType parameterizedType, RequestBody requestBody, String str3, Collection<? extends UrlParameter> collection) throws UploadcareApiException {
        String string;
        String str4 = str;
        ParameterizedType parameterizedType2 = parameterizedType;
        RequestBody requestBody2 = requestBody;
        Collection<? extends UrlParameter> collection2 = collection;
        Intrinsics.checkNotNullParameter(str, "requestType");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(parameterizedType2, "dataType");
        Uri.Builder buildUpon = Uri.parse(str2).buildUpon();
        if (collection2 != null) {
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
            companion.setQueryParameters(buildUpon, collection2);
        }
        UrlUtils.Companion companion2 = UrlUtils.Companion;
        Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
        URI trustedBuild = companion2.trustedBuild(buildUpon);
        Request.Builder builder = new Request.Builder();
        String uri = trustedBuild.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "pageUrl.toString()");
        Request.Builder url = builder.url(uri);
        switch (str.hashCode()) {
            case 70454:
                if (str.equals("GET")) {
                    url.get();
                    break;
                }
                break;
            case 79599:
                if (str.equals(REQUEST_PUT) && requestBody2 != null) {
                    url.put(requestBody2);
                    break;
                }
            case 2461856:
                if (str.equals(REQUEST_POST) && requestBody2 != null) {
                    url.post(requestBody2);
                    break;
                }
            case 2012838315:
                if (str.equals("DELETE") && requestBody2 != null) {
                    url.delete(requestBody2);
                    break;
                }
        }
        if (z) {
            setApiHeaders$default(this, url, str2, str, (BaseCallback) null, str3, String.valueOf(requestBody2 != null ? requestBody.contentType() : null), 8, (Object) null);
        }
        try {
            Response execute = this.client.getHttpClient().newCall(url.build()).execute();
            checkResponseStatus$library_release(execute);
            ResponseBody body = execute.body();
            if (body == null || (string = body.string()) == null) {
                throw new UploadcareApiException("No response");
            }
            T fromJson = this.client.getObjectMapper().fromJson(string, (Type) parameterizedType2);
            if (fromJson != null) {
                return fromJson;
            }
            throw new UploadcareApiException("Can't parse result");
        } catch (RuntimeException e) {
            throw new UploadcareApiException(e.getMessage());
        } catch (IOException e2) {
            throw new UploadcareApiException(e2.getMessage());
        }
    }

    public static /* synthetic */ void executeQueryAsync$default(RequestHelper requestHelper, Context context, String str, String str2, boolean z, Class cls, BaseCallback baseCallback, RequestBody requestBody, String str3, Collection collection, int i, Object obj) {
        int i2 = i;
        requestHelper.executeQueryAsync(context, str, str2, z, cls, (i2 & 32) != 0 ? null : baseCallback, (i2 & 64) != 0 ? null : requestBody, (i2 & 128) != 0 ? null : str3, (Collection<? extends UrlParameter>) (i2 & 256) != 0 ? null : collection);
    }

    public final <T> void executeQueryAsync(Context context, String str, String str2, boolean z, Class<T> cls, BaseCallback<T> baseCallback, RequestBody requestBody, String str3, Collection<? extends UrlParameter> collection) {
        Context context2 = context;
        String str4 = str;
        Class<T> cls2 = cls;
        RequestBody requestBody2 = requestBody;
        Collection<? extends UrlParameter> collection2 = collection;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "requestType");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(cls2, "dataClass");
        Uri.Builder buildUpon = Uri.parse(str2).buildUpon();
        if (collection2 != null) {
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
            companion.setQueryParameters(buildUpon, collection2);
        }
        UrlUtils.Companion companion2 = UrlUtils.Companion;
        Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
        URI trustedBuild = companion2.trustedBuild(buildUpon);
        Request.Builder builder = new Request.Builder();
        String uri = trustedBuild.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "pageUrl.toString()");
        Request.Builder url = builder.url(uri);
        switch (str.hashCode()) {
            case 70454:
                if (str.equals("GET")) {
                    url.get();
                    break;
                }
                break;
            case 79599:
                if (str.equals(REQUEST_PUT) && requestBody2 != null) {
                    url.put(requestBody2);
                    break;
                }
            case 2461856:
                if (str.equals(REQUEST_POST) && requestBody2 != null) {
                    url.post(requestBody2);
                    break;
                }
            case 2012838315:
                if (str.equals("DELETE") && requestBody2 != null) {
                    url.delete(requestBody2);
                    break;
                }
        }
        if (z) {
            setApiHeaders(url, str2, str, baseCallback, str3, String.valueOf(requestBody2 != null ? requestBody.contentType() : null));
        }
        this.client.getHttpClient().newCall(url.build()).enqueue(new RequestHelper$executeQueryAsync$5(this, baseCallback, cls2, context));
    }

    public static /* synthetic */ void executeQueryAsync$default(RequestHelper requestHelper, Context context, String str, String str2, boolean z, ParameterizedType parameterizedType, BaseCallback baseCallback, RequestBody requestBody, String str3, Collection collection, int i, Object obj) {
        int i2 = i;
        requestHelper.executeQueryAsync(context, str, str2, z, parameterizedType, (i2 & 32) != 0 ? null : baseCallback, (i2 & 64) != 0 ? null : requestBody, (i2 & 128) != 0 ? null : str3, (Collection<? extends UrlParameter>) (i2 & 256) != 0 ? null : collection);
    }

    public final <T> void executeQueryAsync(Context context, String str, String str2, boolean z, ParameterizedType parameterizedType, BaseCallback<T> baseCallback, RequestBody requestBody, String str3, Collection<? extends UrlParameter> collection) {
        Context context2 = context;
        String str4 = str;
        ParameterizedType parameterizedType2 = parameterizedType;
        RequestBody requestBody2 = requestBody;
        Collection<? extends UrlParameter> collection2 = collection;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "requestType");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(parameterizedType2, "dataType");
        Uri.Builder buildUpon = Uri.parse(str2).buildUpon();
        if (collection2 != null) {
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
            companion.setQueryParameters(buildUpon, collection2);
        }
        UrlUtils.Companion companion2 = UrlUtils.Companion;
        Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
        URI trustedBuild = companion2.trustedBuild(buildUpon);
        Request.Builder builder = new Request.Builder();
        String uri = trustedBuild.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "pageUrl.toString()");
        Request.Builder url = builder.url(uri);
        switch (str.hashCode()) {
            case 70454:
                if (str.equals("GET")) {
                    url.get();
                    break;
                }
                break;
            case 79599:
                if (str.equals(REQUEST_PUT) && requestBody2 != null) {
                    url.put(requestBody2);
                    break;
                }
            case 2461856:
                if (str.equals(REQUEST_POST) && requestBody2 != null) {
                    url.post(requestBody2);
                    break;
                }
            case 2012838315:
                if (str.equals("DELETE") && requestBody2 != null) {
                    url.delete(requestBody2);
                    break;
                }
        }
        if (z) {
            setApiHeaders(url, str2, str, baseCallback, str3, String.valueOf(requestBody2 != null ? requestBody.contentType() : null));
        }
        this.client.getHttpClient().newCall(url.build()).enqueue(new RequestHelper$executeQueryAsync$10(this, baseCallback, parameterizedType2, context));
    }

    public final <T> Iterable<T> executePaginatedQuery(URI uri, Collection<? extends UrlParameter> collection, boolean z, Class<? extends PageData<T>> cls) throws UploadcareApiException {
        Intrinsics.checkNotNullParameter(uri, "url");
        Intrinsics.checkNotNullParameter(collection, "urlParameters");
        Intrinsics.checkNotNullParameter(cls, "dataClass");
        return new RequestHelper$executePaginatedQuery$1(this, uri, collection, z, cls);
    }

    public static /* synthetic */ void executePaginatedQueryWithOffsetLimitAsync$default(RequestHelper requestHelper, Context context, URI uri, Collection collection, boolean z, UploadcareFilesCallback uploadcareFilesCallback, int i, Object obj) {
        if ((i & 16) != 0) {
            uploadcareFilesCallback = null;
        }
        requestHelper.executePaginatedQueryWithOffsetLimitAsync(context, uri, collection, z, uploadcareFilesCallback);
    }

    public final void executePaginatedQueryWithOffsetLimitAsync(Context context, URI uri, Collection<? extends UrlParameter> collection, boolean z, UploadcareFilesCallback uploadcareFilesCallback) {
        Context context2 = context;
        Collection<? extends UrlParameter> collection2 = collection;
        UploadcareFilesCallback uploadcareFilesCallback2 = uploadcareFilesCallback;
        Intrinsics.checkNotNullParameter(context, "context");
        URI uri2 = uri;
        Intrinsics.checkNotNullParameter(uri, "url");
        Intrinsics.checkNotNullParameter(collection2, "urlParameters");
        Uri.Builder buildUpon = Uri.parse(uri.toString()).buildUpon();
        Companion companion = Companion;
        Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
        companion.setQueryParameters(buildUpon, collection2);
        URI trustedBuild = UrlUtils.Companion.trustedBuild(buildUpon);
        Request.Builder builder = new Request.Builder();
        String uri3 = trustedBuild.toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "pageUrl.toString()");
        Request.Builder url = builder.url(uri3);
        url.get();
        if (z) {
            try {
                String uri4 = trustedBuild.toString();
                Intrinsics.checkNotNullExpressionValue(uri4, "pageUrl.toString()");
                setApiHeaders$default(this, url, uri4, "GET", (BaseCallback) null, (String) null, (String) null, 48, (Object) null);
            } catch (Exception e) {
                e.printStackTrace();
                if (uploadcareFilesCallback2 != null) {
                    uploadcareFilesCallback2.onFailure(new UploadcareApiException(e.getMessage()));
                    return;
                }
                return;
            }
        }
        this.client.getHttpClient().newCall(url.build()).enqueue(new RequestHelper$executePaginatedQueryWithOffsetLimitAsync$1(this, uploadcareFilesCallback2, context));
    }

    public final void executeGroupsPaginatedQueryWithOffsetLimitAsync(Context context, URI uri, Collection<? extends UrlParameter> collection, boolean z, UploadcareGroupsCallback uploadcareGroupsCallback) {
        Context context2 = context;
        Collection<? extends UrlParameter> collection2 = collection;
        UploadcareGroupsCallback uploadcareGroupsCallback2 = uploadcareGroupsCallback;
        Intrinsics.checkNotNullParameter(context, "context");
        URI uri2 = uri;
        Intrinsics.checkNotNullParameter(uri, "url");
        Intrinsics.checkNotNullParameter(collection2, "urlParameters");
        Uri.Builder buildUpon = Uri.parse(uri.toString()).buildUpon();
        Companion companion = Companion;
        Intrinsics.checkNotNullExpressionValue(buildUpon, "builder");
        companion.setQueryParameters(buildUpon, collection2);
        URI trustedBuild = UrlUtils.Companion.trustedBuild(buildUpon);
        Request.Builder builder = new Request.Builder();
        String uri3 = trustedBuild.toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "pageUrl.toString()");
        Request.Builder url = builder.url(uri3);
        url.get();
        if (z) {
            try {
                String uri4 = trustedBuild.toString();
                Intrinsics.checkNotNullExpressionValue(uri4, "pageUrl.toString()");
                setApiHeaders$default(this, url, uri4, "GET", (BaseCallback) null, (String) null, (String) null, 48, (Object) null);
            } catch (Exception e) {
                e.printStackTrace();
                if (uploadcareGroupsCallback2 != null) {
                    uploadcareGroupsCallback2.onFailure(new UploadcareApiException(e.getMessage()));
                    return;
                }
                return;
            }
        }
        this.client.getHttpClient().newCall(url.build()).enqueue(new RequestHelper$executeGroupsPaginatedQueryWithOffsetLimitAsync$1(this, uploadcareGroupsCallback2, context));
    }

    public static /* synthetic */ Response executeCommand$default(RequestHelper requestHelper, String str, String str2, boolean z, RequestBody requestBody, String str3, int i, Object obj) throws UploadcareApiException {
        if ((i & 8) != 0) {
            requestBody = null;
        }
        RequestBody requestBody2 = requestBody;
        if ((i & 16) != 0) {
            str3 = null;
        }
        return requestHelper.executeCommand(str, str2, z, requestBody2, str3);
    }

    public final Response executeCommand(String str, String str2, boolean z, RequestBody requestBody, String str3) throws UploadcareApiException {
        Intrinsics.checkNotNullParameter(str, "requestType");
        Intrinsics.checkNotNullParameter(str2, "url");
        Request.Builder url = new Request.Builder().url(str2);
        MediaType mediaType = null;
        switch (str.hashCode()) {
            case 70454:
                if (str.equals("GET")) {
                    url.get();
                    break;
                }
                break;
            case 79599:
                if (str.equals(REQUEST_PUT) && requestBody != null) {
                    url.put(requestBody);
                    break;
                }
            case 2461856:
                if (str.equals(REQUEST_POST) && requestBody != null) {
                    url.post(requestBody);
                    break;
                }
            case 2012838315:
                if (str.equals("DELETE") && (requestBody == null || url.delete(requestBody) == null)) {
                    Request.Builder.delete$default(url, (RequestBody) null, 1, (Object) null);
                    break;
                }
        }
        if (z) {
            if (requestBody != null) {
                mediaType = requestBody.contentType();
            }
            setApiHeaders$default(this, url, str2, str, (BaseCallback) null, str3, String.valueOf(mediaType), 8, (Object) null);
        }
        try {
            Response execute = this.client.getHttpClient().newCall(url.build()).execute();
            checkResponseStatus$library_release(execute);
            return execute;
        } catch (IOException e) {
            throw new UploadcareApiException(e.getMessage());
        }
    }

    public static /* synthetic */ void executeCommandAsync$default(RequestHelper requestHelper, Context context, String str, String str2, boolean z, RequestCallback requestCallback, RequestBody requestBody, String str3, int i, Object obj) {
        requestHelper.executeCommandAsync(context, str, str2, z, (i & 16) != 0 ? null : requestCallback, (i & 32) != 0 ? null : requestBody, (i & 64) != 0 ? null : str3);
    }

    public final void executeCommandAsync(Context context, String str, String str2, boolean z, RequestCallback requestCallback, RequestBody requestBody, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "requestType");
        Intrinsics.checkNotNullParameter(str2, "url");
        Request.Builder url = new Request.Builder().url(str2);
        MediaType mediaType = null;
        switch (str.hashCode()) {
            case 70454:
                if (str.equals("GET")) {
                    url.get();
                    break;
                }
                break;
            case 79599:
                if (str.equals(REQUEST_PUT) && requestBody != null) {
                    url.put(requestBody);
                    break;
                }
            case 2461856:
                if (str.equals(REQUEST_POST) && requestBody != null) {
                    url.post(requestBody);
                    break;
                }
            case 2012838315:
                if (str.equals("DELETE") && (requestBody == null || url.delete(requestBody) == null)) {
                    Request.Builder.delete$default(url, (RequestBody) null, 1, (Object) null);
                    break;
                }
        }
        if (z) {
            BaseCallback baseCallback = requestCallback;
            if (requestBody != null) {
                mediaType = requestBody.contentType();
            }
            setApiHeaders(url, str2, str, baseCallback, str3, String.valueOf(mediaType));
        }
        this.client.getHttpClient().newCall(url.build()).enqueue(new RequestHelper$executeCommandAsync$4(this, requestCallback, context));
    }

    public final void checkResponseStatus$library_release(Response response) throws IOException, UploadcareAuthenticationException, UploadcareInvalidRequestException, UploadcareApiException {
        Intrinsics.checkNotNullParameter(response, "response");
        int code = response.code();
        if (200 > code || 299 < code) {
            if (code == 401 || code == 403) {
                throw new UploadcareAuthenticationException(String.valueOf(response));
            } else if (code == 400 || code == 404) {
                throw new UploadcareInvalidRequestException(String.valueOf(response));
            } else {
                throw new UploadcareApiException("Unknown exception during an API call, response: " + response);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void checkResponseStatus(Response response, BaseCallback<Response> baseCallback) {
        int code = response.code();
        try {
            ResponseBody body = response.body();
            String string = body != null ? body.string() : null;
            if (200 > code || 299 < code) {
                if (code == 401 || code == 403) {
                    if (baseCallback != null) {
                        baseCallback.onFailure(new UploadcareAuthenticationException(string));
                    }
                } else if (code == 400 || code == 404) {
                    if (baseCallback != null) {
                        baseCallback.onFailure(new UploadcareInvalidRequestException(string));
                    }
                } else if (baseCallback != null) {
                    baseCallback.onFailure(new UploadcareApiException("Unknown exception during an API call, response: " + string));
                }
            }
        } catch (IOException e) {
            if (baseCallback != null) {
                baseCallback.onFailure(new UploadcareApiException(e.getMessage()));
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0014\u001a\n \b*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\u0018\u0010\u0018\u001a\n \b*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\n\u0010 \u001a\u00020\u0004*\u00020\u0004J\n\u0010 \u001a\u00020\u0004*\u00020!J\n\u0010\"\u001a\u00020\u0004*\u00020#R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/uploadcare/android/library/api/RequestHelper$Companion;", "", "()V", "DATE_FORMAT", "", "DATE_FORMAT_ISO_8601", "GMT", "Ljava/util/TimeZone;", "kotlin.jvm.PlatformType", "JSON", "Lokhttp3/MediaType;", "getJSON$library_release", "()Lokhttp3/MediaType;", "JSON_CONTENT_TYPE", "MAC_ALGORITHM", "REQUEST_DELETE", "REQUEST_GET", "REQUEST_POST", "REQUEST_PUT", "UTC", "iso8601", "date", "Ljava/util/Date;", "iso8601$library_release", "rfc2822", "setQueryParameters", "", "builder", "Landroid/net/Uri$Builder;", "parameters", "", "Lcom/uploadcare/android/library/urls/UrlParameter;", "md5", "Lokhttp3/FormBody;", "toHexString", "", "library_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: RequestHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MediaType getJSON$library_release() {
            return RequestHelper.JSON;
        }

        /* access modifiers changed from: private */
        public final String rfc2822(Date date) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RequestHelper.DATE_FORMAT, Locale.US);
            simpleDateFormat.setTimeZone(RequestHelper.GMT);
            return simpleDateFormat.format(date);
        }

        public final String iso8601$library_release(Date date) {
            Intrinsics.checkNotNullParameter(date, "date");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RequestHelper.DATE_FORMAT_ISO_8601, Locale.US);
            simpleDateFormat.setTimeZone(RequestHelper.UTC);
            return simpleDateFormat.format(date);
        }

        /* access modifiers changed from: private */
        public final void setQueryParameters(Uri.Builder builder, Collection<? extends UrlParameter> collection) {
            for (UrlParameter urlParameter : collection) {
                builder.appendQueryParameter(urlParameter.getParam(), urlParameter.getValue());
            }
        }

        public final String toHexString(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "$this$toHexString");
            return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) RequestHelper$Companion$toHexString$1.INSTANCE, 30, (Object) null);
        }

        public final String md5(FormBody formBody) {
            Intrinsics.checkNotNullParameter(formBody, "$this$md5");
            StringBuilder sb = new StringBuilder();
            int size = formBody.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append("&");
                }
                sb.append(formBody.encodedName(i));
                sb.append("=");
                sb.append(formBody.encodedValue(i));
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            return md5(sb2);
        }

        public final String md5(String str) {
            Intrinsics.checkNotNullParameter(str, "$this$md5");
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] digest = instance.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(digest, "digested");
            return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) RequestHelper$Companion$md5$1.INSTANCE, 30, (Object) null);
        }
    }
}
