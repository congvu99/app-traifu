package com.uploadcare.android.library.data;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import com.uploadcare.android.library.utils.AsStringAdapter;
import com.uploadcare.android.library.utils.MoshiAdapter;
import java.lang.reflect.Type;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\u0010\rJ'\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J-\u0010\u0011\u001a\u00020\n\"\b\b\u0000\u0010\b*\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u0001H\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0013¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/uploadcare/android/library/data/ObjectMapper;", "", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "fromJson", "T", "json", "", "classOfT", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "typeOfT", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "toJson", "src", "Lkotlin/reflect/KClass;", "(Ljava/lang/Object;Lkotlin/reflect/KClass;)Ljava/lang/String;", "typeOfSrc", "Companion", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ObjectMapper.kt */
public final class ObjectMapper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Moshi moshi;

    public ObjectMapper(Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.moshi = moshi2;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final <T> T fromJson(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(cls, "classOfT");
        JsonAdapter<T> adapter = this.moshi.adapter(cls);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(classOfT)");
        return adapter.fromJson(str);
    }

    public final <T> T fromJson(String str, Type type) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        JsonAdapter adapter = this.moshi.adapter(type);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(typeOfT)");
        return adapter.fromJson(str);
    }

    public final <T> String toJson(T t, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "classOfT");
        JsonAdapter<T> adapter = this.moshi.adapter(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(classOfT.java)");
        String json = adapter.toJson(t);
        Intrinsics.checkNotNullExpressionValue(json, "jsonAdapter.toJson(src)");
        return json;
    }

    public final String toJson(Object obj, Type type) {
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        JsonAdapter adapter = this.moshi.adapter(type);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(typeOfSrc)");
        String json = adapter.toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "jsonAdapter.toJson(src)");
        return json;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/uploadcare/android/library/data/ObjectMapper$Companion;", "", "()V", "build", "Lcom/uploadcare/android/library/data/ObjectMapper;", "library_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ObjectMapper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ObjectMapper build() {
            Moshi build = new Moshi.Builder().add(AsStringAdapter.Companion.getFACTORY()).add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).add(Date.class, new Rfc3339DateJsonAdapter().nullSafe()).add((Object) new MoshiAdapter()).build();
            Intrinsics.checkNotNullExpressionValue(build, "Moshi.Builder()\n        …                 .build()");
            return new ObjectMapper(build);
        }
    }
}
