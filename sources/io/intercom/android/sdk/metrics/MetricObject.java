package io.intercom.android.sdk.metrics;

import com.google.gson.annotations.SerializedName;
import com.intercom.commons.utilities.TimeProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.JsonLexerKt;

public class MetricObject {
    static final String KEY_ACTION = "action";
    private static final String KEY_ANDROID_INSTALLER_PACKAGE_NAME = "android_installer_package_name";
    private static final String KEY_ANDROID_IS_DEBUG_BUILD = "android_is_debug_build";
    static final String KEY_APP_VERSION = "app_version";
    static final String KEY_CONTEXT = "context";
    static final String KEY_CONVERSATION_SHOWN = "conversation_shown";
    static final String KEY_OBJECT = "object";
    static final String KEY_OWNER = "owner";
    static final String KEY_PLACE = "place";
    static final String KEY_SDK_VERSION = "sdk_version";
    static final String KEY_USER_ID = "user_id";
    @SerializedName("created_at")
    private final long createdAt;
    private final String id;
    private final Map<String, Object> metadata = new HashMap();
    private final String name;

    MetricObject(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, TimeProvider timeProvider, String str9, String str10) {
        this.name = str;
        this.createdAt = TimeUnit.MILLISECONDS.toSeconds(timeProvider.currentTimeMillis());
        this.id = str3;
        this.metadata.put("action", str5);
        this.metadata.put(KEY_OBJECT, str6);
        this.metadata.put(KEY_PLACE, str7);
        this.metadata.put(KEY_CONTEXT, str8);
        this.metadata.put(KEY_OWNER, str2);
        if (!str4.isEmpty()) {
            this.metadata.put("user_id", str4);
        }
        this.metadata.put(KEY_SDK_VERSION, str10);
        this.metadata.put(KEY_APP_VERSION, str9);
    }

    /* access modifiers changed from: package-private */
    public MetricObject addMetaData(String str, Object obj) {
        this.metadata.put(str, obj);
        return this;
    }

    /* access modifiers changed from: package-private */
    public MetricObject addIsDebugBuild(boolean z) {
        addMetaData(KEY_ANDROID_IS_DEBUG_BUILD, Boolean.valueOf(z));
        return this;
    }

    /* access modifiers changed from: package-private */
    public MetricObject addInstallerPackageName(String str) {
        addMetaData(KEY_ANDROID_INSTALLER_PACKAGE_NAME, str);
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public String getName() {
        return this.name;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MetricObject metricObject = (MetricObject) obj;
        if (this.createdAt != metricObject.createdAt || !this.metadata.equals(metricObject.metadata)) {
            return false;
        }
        String str = this.id;
        String str2 = metricObject.id;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.metadata.hashCode() * 31;
        String str = this.id;
        int hashCode2 = str != null ? str.hashCode() : 0;
        long j = this.createdAt;
        return ((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "MetricObject{metadata=" + this.metadata + ", id='" + this.id + '\'' + ", createdAt=" + this.createdAt + JsonLexerKt.END_OBJ;
    }
}
