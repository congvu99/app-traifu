package com.uploadcare.android.library.urls;

import android.net.Uri;
import androidx.core.provider.FontsContractCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.uploadcare.android.library.urls.UrlUtils;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/uploadcare/android/library/urls/Urls;", "", "()V", "Companion", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Urls.kt */
public final class Urls {
    public static final String API_BASE = "https://api.uploadcare.com";
    private static final String CDN_BASE = "https://ucarecdn.com";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String UPLOAD_BASE = "https://upload.uploadcare.com";

    @JvmStatic
    public static final URI apiConvertDocument() {
        return Companion.apiConvertDocument();
    }

    @JvmStatic
    public static final URI apiConvertDocumentStatus(int i) {
        return Companion.apiConvertDocumentStatus(i);
    }

    @JvmStatic
    public static final URI apiConvertVideo() {
        return Companion.apiConvertVideo();
    }

    @JvmStatic
    public static final URI apiConvertVideoStatus(int i) {
        return Companion.apiConvertVideoStatus(i);
    }

    @JvmStatic
    public static final URI apiCreateGroup() {
        return Companion.apiCreateGroup();
    }

    @JvmStatic
    public static final URI apiFile(String str) {
        return Companion.apiFile(str);
    }

    @JvmStatic
    public static final URI apiFileLocalCopy() {
        return Companion.apiFileLocalCopy();
    }

    @JvmStatic
    public static final URI apiFileRemoteCopy() {
        return Companion.apiFileRemoteCopy();
    }

    @JvmStatic
    public static final URI apiFileStorage(String str) {
        return Companion.apiFileStorage(str);
    }

    @JvmStatic
    public static final URI apiFiles() {
        return Companion.apiFiles();
    }

    @JvmStatic
    public static final URI apiFilesBatch() {
        return Companion.apiFilesBatch();
    }

    @JvmStatic
    public static final URI apiGroup(String str) {
        return Companion.apiGroup(str);
    }

    @JvmStatic
    public static final URI apiGroupStorage(String str) {
        return Companion.apiGroupStorage(str);
    }

    @JvmStatic
    public static final URI apiGroups() {
        return Companion.apiGroups();
    }

    @JvmStatic
    public static final URI apiProject() {
        return Companion.apiProject();
    }

    @JvmStatic
    public static final URI apiUploadedFile(String str, String str2) {
        return Companion.apiUploadedFile(str, str2);
    }

    @JvmStatic
    public static final URI apiUploadedGroup(String str, String str2) {
        return Companion.apiUploadedGroup(str, str2);
    }

    @JvmStatic
    public static final URI cdn(CdnPathBuilder cdnPathBuilder) {
        return Companion.cdn(cdnPathBuilder);
    }

    @JvmStatic
    public static final URI cdnAkamai(String str, CdnPathBuilder cdnPathBuilder, String str2, String str3) {
        return Companion.cdnAkamai(str, cdnPathBuilder, str2, str3);
    }

    @JvmStatic
    public static final URI cdnKeyCDN(String str, CdnPathBuilder cdnPathBuilder, String str2, String str3) {
        return Companion.cdnKeyCDN(str, cdnPathBuilder, str2, str3);
    }

    @JvmStatic
    public static final URI uploadBase() {
        return Companion.uploadBase();
    }

    @JvmStatic
    public static final URI uploadFromUrl() {
        return Companion.uploadFromUrl();
    }

    @JvmStatic
    public static final URI uploadFromUrlStatus(String str) {
        return Companion.uploadFromUrlStatus(str);
    }

    @JvmStatic
    public static final URI uploadMultipartComplete() {
        return Companion.uploadMultipartComplete();
    }

    @JvmStatic
    public static final URI uploadMultipartPart(String str) {
        return Companion.uploadMultipartPart(str);
    }

    @JvmStatic
    public static final URI uploadMultipartStart() {
        return Companion.uploadMultipartStart();
    }

    private Urls() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007J\u0006\u0010\u000f\u001a\u00020\bJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\bH\u0007J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0015\u001a\u00020\bH\u0007J\b\u0010\u0016\u001a\u00020\bH\u0007J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\b\u0010\u001a\u001a\u00020\bH\u0007J\b\u0010\u001b\u001a\u00020\bH\u0007J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\bJ\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0007J(\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0007J(\u0010(\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0007J\b\u0010)\u001a\u00020\bH\u0007J\b\u0010*\u001a\u00020\bH\u0007J\u0010\u0010+\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010,\u001a\u00020\bH\u0007J\u0010\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0004H\u0007J\b\u0010/\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/uploadcare/android/library/urls/Urls$Companion;", "", "()V", "API_BASE", "", "CDN_BASE", "UPLOAD_BASE", "apiConvertDocument", "Ljava/net/URI;", "apiConvertDocumentStatus", "token", "", "apiConvertVideo", "apiConvertVideoStatus", "apiCreateGroup", "apiDeleteWebhook", "apiFile", "fileId", "apiFileLocalCopy", "apiFileRemoteCopy", "apiFileStorage", "apiFiles", "apiFilesBatch", "apiGroup", "groupId", "apiGroupStorage", "apiGroups", "apiProject", "apiUploadedFile", "publicKey", "apiUploadedGroup", "apiWebhook", "webhookId", "apiWebhooks", "cdn", "builder", "Lcom/uploadcare/android/library/urls/CdnPathBuilder;", "cdnAkamai", "domain", "expire", "cdnKeyCDN", "uploadBase", "uploadFromUrl", "uploadFromUrlStatus", "uploadMultipartComplete", "uploadMultipartPart", "preSignedPartUrl", "uploadMultipartStart", "library_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Urls.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final URI apiProject() {
            URI create = URI.create("https://api.uploadcare.com/project/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/project/\")");
            return create;
        }

        @JvmStatic
        public final URI apiUploadedFile(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "publicKey");
            Intrinsics.checkNotNullParameter(str2, "fileId");
            Uri.Builder appendQueryParameter = Uri.parse(Urls.UPLOAD_BASE).buildUpon().appendPath("/info/").appendQueryParameter("pub_key", str).appendQueryParameter(FontsContractCompat.Columns.FILE_ID, str2);
            UrlUtils.Companion companion = UrlUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(appendQueryParameter, "builder");
            return companion.trustedBuild(appendQueryParameter);
        }

        @JvmStatic
        public final URI apiFile(String str) {
            Intrinsics.checkNotNullParameter(str, "fileId");
            URI create = URI.create("https://api.uploadcare.com/files/" + str + '/');
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/files/$fileId/\")");
            return create;
        }

        @JvmStatic
        public final URI apiGroup(String str) {
            Intrinsics.checkNotNullParameter(str, "groupId");
            URI create = URI.create("https://api.uploadcare.com/groups/" + str + '/');
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/groups/$groupId/\")");
            return create;
        }

        @JvmStatic
        public final URI apiUploadedGroup(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "publicKey");
            Intrinsics.checkNotNullParameter(str2, "groupId");
            Uri.Builder appendQueryParameter = Uri.parse(Urls.UPLOAD_BASE).buildUpon().appendPath("/group/info/").appendQueryParameter("pub_key", str).appendQueryParameter(FirebaseAnalytics.Param.GROUP_ID, str2);
            UrlUtils.Companion companion = UrlUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(appendQueryParameter, "builder");
            return companion.trustedBuild(appendQueryParameter);
        }

        @JvmStatic
        public final URI apiFileStorage(String str) {
            Intrinsics.checkNotNullParameter(str, "fileId");
            URI create = URI.create("https://api.uploadcare.com/files/" + str + "/storage/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/files/$fileId/storage/\")");
            return create;
        }

        @JvmStatic
        public final URI apiGroupStorage(String str) {
            Intrinsics.checkNotNullParameter(str, "groupId");
            URI create = URI.create("https://api.uploadcare.com/groups/" + str + "/storage/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/groups/$groupId/storage/\")");
            return create;
        }

        @JvmStatic
        public final URI apiFiles() {
            URI create = URI.create("https://api.uploadcare.com/files/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/files/\")");
            return create;
        }

        @JvmStatic
        public final URI apiFileLocalCopy() {
            URI create = URI.create("https://api.uploadcare.com/files/local_copy/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/files/local_copy/\")");
            return create;
        }

        @JvmStatic
        public final URI apiFileRemoteCopy() {
            URI create = URI.create("https://api.uploadcare.com/files/remote_copy/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/files/remote_copy/\")");
            return create;
        }

        @JvmStatic
        public final URI apiFilesBatch() {
            URI create = URI.create("https://api.uploadcare.com/files/storage/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/files/storage/\")");
            return create;
        }

        @JvmStatic
        public final URI apiGroups() {
            URI create = URI.create("https://api.uploadcare.com/groups/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/groups/\")");
            return create;
        }

        @JvmStatic
        public final URI apiCreateGroup() {
            URI create = URI.create("https://upload.uploadcare.com/group/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$UPLOAD_BASE/group/\")");
            return create;
        }

        @JvmStatic
        public final URI cdn(CdnPathBuilder cdnPathBuilder) {
            Intrinsics.checkNotNullParameter(cdnPathBuilder, "builder");
            URI create = URI.create(Urls.CDN_BASE + cdnPathBuilder.build());
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(CDN_BASE + builder.build())");
            return create;
        }

        @JvmStatic
        public final URI cdnAkamai(String str, CdnPathBuilder cdnPathBuilder, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "domain");
            Intrinsics.checkNotNullParameter(cdnPathBuilder, "builder");
            Intrinsics.checkNotNullParameter(str2, "token");
            Intrinsics.checkNotNullParameter(str3, "expire");
            URI create = URI.create(str + cdnPathBuilder.build() + "?token=exp=" + str3 + "~acl=/" + cdnPathBuilder.getUUID$library_release() + "/~hmac=" + str2);
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$domain${bui…getUUID()}/~hmac=$token\")");
            return create;
        }

        @JvmStatic
        public final URI cdnKeyCDN(String str, CdnPathBuilder cdnPathBuilder, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "domain");
            Intrinsics.checkNotNullParameter(cdnPathBuilder, "builder");
            Intrinsics.checkNotNullParameter(str2, "token");
            Intrinsics.checkNotNullParameter(str3, "expire");
            URI create = URI.create(str + cdnPathBuilder.build() + "?token=" + str2 + "&expire=" + str3);
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$domain${bui…n=$token&expire=$expire\")");
            return create;
        }

        public final URI apiWebhooks() {
            URI create = URI.create("https://api.uploadcare.com/webhooks/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/webhooks/\")");
            return create;
        }

        public final URI apiWebhook(int i) {
            URI create = URI.create("https://api.uploadcare.com/webhooks/" + i + '/');
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/webhooks/$webhookId/\")");
            return create;
        }

        public final URI apiDeleteWebhook() {
            URI create = URI.create("https://api.uploadcare.com/webhooks/unsubscribe/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/webhooks/unsubscribe/\")");
            return create;
        }

        @JvmStatic
        public final URI uploadBase() {
            URI create = URI.create("https://upload.uploadcare.com/base/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$UPLOAD_BASE/base/\")");
            return create;
        }

        @JvmStatic
        public final URI uploadFromUrl() {
            URI create = URI.create("https://upload.uploadcare.com/from_url/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$UPLOAD_BASE/from_url/\")");
            return create;
        }

        @JvmStatic
        public final URI uploadFromUrlStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "token");
            Uri.Builder appendQueryParameter = Uri.parse(Urls.UPLOAD_BASE).buildUpon().appendPath("/from_url/status/").appendQueryParameter("token", str);
            UrlUtils.Companion companion = UrlUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(appendQueryParameter, "builder");
            return companion.trustedBuild(appendQueryParameter);
        }

        @JvmStatic
        public final URI uploadMultipartStart() {
            URI create = URI.create("https://upload.uploadcare.com/multipart/start/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$UPLOAD_BASE/multipart/start/\")");
            return create;
        }

        @JvmStatic
        public final URI uploadMultipartPart(String str) {
            Intrinsics.checkNotNullParameter(str, "preSignedPartUrl");
            URI create = URI.create(Urls.UPLOAD_BASE + str);
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$UPLOAD_BASE$preSignedPartUrl\")");
            return create;
        }

        @JvmStatic
        public final URI uploadMultipartComplete() {
            URI create = URI.create("https://upload.uploadcare.com/multipart/complete/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$UPLOAD_BASE/multipart/complete/\")");
            return create;
        }

        @JvmStatic
        public final URI apiConvertDocument() {
            URI create = URI.create("https://api.uploadcare.com/convert/document/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/convert/document/\")");
            return create;
        }

        @JvmStatic
        public final URI apiConvertDocumentStatus(int i) {
            URI create = URI.create("https://api.uploadcare.com/convert/document/status/" + i + '/');
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/co…document/status/$token/\")");
            return create;
        }

        @JvmStatic
        public final URI apiConvertVideo() {
            URI create = URI.create("https://api.uploadcare.com/convert/video/");
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/convert/video/\")");
            return create;
        }

        @JvmStatic
        public final URI apiConvertVideoStatus(int i) {
            URI create = URI.create("https://api.uploadcare.com/convert/video/status/" + i + '/');
            Intrinsics.checkNotNullExpressionValue(create, "URI.create(\"$API_BASE/co…rt/video/status/$token/\")");
            return create;
        }
    }
}
