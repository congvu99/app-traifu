package io.intercom.android.sdk.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.logger.LumberMill;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"extractErrorString", "", "errorObject", "Lio/intercom/android/sdk/api/ErrorObject;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ErrorStringExtractor.kt */
public final class ErrorStringExtractorKt {
    public static final String extractErrorString(ErrorObject errorObject) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(errorObject, "errorObject");
        Twig logger = LumberMill.getLogger();
        String str = "Something went wrong";
        if (!errorObject.hasErrorBody() || errorObject.getErrorBody() == null) {
            return str;
        }
        try {
            JsonObject jsonObject = (JsonObject) Injector.get().getGson().fromJson(errorObject.getErrorBody(), JsonObject.class);
            if (jsonObject == null) {
                return str;
            }
            if (jsonObject.has("error")) {
                joinToString$default = jsonObject.get("error").getAsString();
            } else {
                if (jsonObject.has("errors")) {
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("errors");
                    Intrinsics.checkNotNullExpressionValue(asJsonArray, "jsonObject.getAsJsonArray(\"errors\")");
                    joinToString$default = CollectionsKt.joinToString$default(asJsonArray, " - ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ErrorStringExtractorKt$extractErrorString$1.INSTANCE, 30, (Object) null);
                }
                Intrinsics.checkNotNullExpressionValue(str, "{\n        val jsonObject…        }\n        }\n    }");
                return str;
            }
            str = joinToString$default;
            Intrinsics.checkNotNullExpressionValue(str, "{\n        val jsonObject…        }\n        }\n    }");
            return str;
        } catch (Exception e) {
            logger.e(e);
            String message = errorObject.getThrowable().getMessage();
            return message == null ? str : message;
        }
    }
}
