package com.uploadcare.android.library.utils;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/uploadcare/android/library/utils/AsStringAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "", "()V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "Companion", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: AsStringAdapter.kt */
public final class AsStringAdapter extends JsonAdapter<String> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static JsonAdapter.Factory FACTORY = AsStringAdapter$Companion$FACTORY$1.INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/uploadcare/android/library/utils/AsStringAdapter$Companion;", "", "()V", "FACTORY", "Lcom/squareup/moshi/JsonAdapter$Factory;", "getFACTORY", "()Lcom/squareup/moshi/JsonAdapter$Factory;", "setFACTORY", "(Lcom/squareup/moshi/JsonAdapter$Factory;)V", "library_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AsStringAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JsonAdapter.Factory getFACTORY() {
            return AsStringAdapter.FACTORY;
        }

        public final void setFACTORY(JsonAdapter.Factory factory) {
            Intrinsics.checkNotNullParameter(factory, "<set-?>");
            AsStringAdapter.FACTORY = factory;
        }
    }

    public void toJson(JsonWriter jsonWriter, String str) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (str != null) {
            jsonWriter.value((BufferedSource) new Buffer().writeUtf8(str.toString()));
        }
    }

    public String fromJson(JsonReader jsonReader) {
        Object obj;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Object readJsonValue = jsonReader.readJsonValue();
        if (!(readJsonValue instanceof Map)) {
            readJsonValue = null;
        }
        Map map = (Map) readJsonValue;
        if (map == null) {
            return null;
        }
        try {
            obj = new JSONObject(map);
        } catch (JSONException unused) {
            obj = Unit.INSTANCE;
        }
        return obj.toString();
    }
}
