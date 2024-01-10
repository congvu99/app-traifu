package io.intercom.android.sdk.api;

import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/google/gson/JsonElement;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ErrorStringExtractor.kt */
final class ErrorStringExtractorKt$extractErrorString$1 extends Lambda implements Function1<JsonElement, CharSequence> {
    public static final ErrorStringExtractorKt$extractErrorString$1 INSTANCE = new ErrorStringExtractorKt$extractErrorString$1();

    ErrorStringExtractorKt$extractErrorString$1() {
        super(1);
    }

    public final CharSequence invoke(JsonElement jsonElement) {
        if (!jsonElement.isJsonObject() || !jsonElement.getAsJsonObject().has("message")) {
            return "Something went wrong";
        }
        String asString = jsonElement.getAsJsonObject().get("message").getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "{\n                      …ing\n                    }");
        return asString;
    }
}
