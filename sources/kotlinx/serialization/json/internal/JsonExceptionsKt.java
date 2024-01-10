package kotlinx.serialization.json.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.intercom.android.sdk.metrics.MetricTracker;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0000\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0000\u001a \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0016\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0000¨\u0006\u0018"}, d2 = {"InvalidFloatingPointDecoded", "Lkotlinx/serialization/json/internal/JsonDecodingException;", "value", "", "key", "", "output", "InvalidFloatingPointEncoded", "Lkotlinx/serialization/json/internal/JsonEncodingException;", "InvalidKeyKindException", "keyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "JsonDecodingException", "offset", "", "message", "input", "UnknownKeyException", "unexpectedFpErrorMessage", "minify", "throwInvalidFloatingPointDecoded", "", "Lkotlinx/serialization/json/internal/JsonLexer;", "result", "kotlinx-serialization-json"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonExceptions.kt */
public final class JsonExceptionsKt {
    public static final JsonDecodingException JsonDecodingException(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (i >= 0) {
            str = "Unexpected JSON token at offset " + i + ": " + str;
        }
        return new JsonDecodingException(str);
    }

    public static final JsonDecodingException JsonDecodingException(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, MetricTracker.Object.INPUT);
        return JsonDecodingException(i, str + "\nJSON input: " + minify(str2, i));
    }

    public static final JsonEncodingException InvalidFloatingPointEncoded(Number number, String str) {
        Intrinsics.checkNotNullParameter(number, "value");
        Intrinsics.checkNotNullParameter(str, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + minify$default(str, 0, 1, (Object) null));
    }

    public static final JsonEncodingException InvalidFloatingPointEncoded(Number number, String str, String str2) {
        Intrinsics.checkNotNullParameter(number, "value");
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_KEY);
        Intrinsics.checkNotNullParameter(str2, "output");
        return new JsonEncodingException(unexpectedFpErrorMessage(number, str, str2));
    }

    public static final JsonDecodingException InvalidFloatingPointDecoded(Number number, String str, String str2) {
        Intrinsics.checkNotNullParameter(number, "value");
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_KEY);
        Intrinsics.checkNotNullParameter(str2, "output");
        return JsonDecodingException(-1, unexpectedFpErrorMessage(number, str, str2));
    }

    public static final Void throwInvalidFloatingPointDecoded(JsonLexer jsonLexer, Number number) {
        Intrinsics.checkNotNullParameter(jsonLexer, "<this>");
        Intrinsics.checkNotNullParameter(number, "result");
        JsonLexer.fail$default(jsonLexer, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    private static final String unexpectedFpErrorMessage(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + minify$default(str2, 0, 1, (Object) null);
    }

    public static final JsonDecodingException UnknownKeyException(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_KEY);
        Intrinsics.checkNotNullParameter(str2, MetricTracker.Object.INPUT);
        return JsonDecodingException(-1, "Encountered unknown key '" + str + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + minify$default(str2, 0, 1, (Object) null));
    }

    public static final JsonEncodingException InvalidKeyKindException(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + serialDescriptor.getSerialName() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + serialDescriptor.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    static /* synthetic */ String minify$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return minify(str, i);
    }

    private static final String minify(String str, int i) {
        if (str.length() < 200) {
            return str;
        }
        String str2 = ".....";
        if (i == -1) {
            int length = str.length() - 60;
            if (length <= 0) {
                return str;
            }
            if (str != null) {
                String substring = str.substring(length);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return Intrinsics.stringPlus(str2, substring);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        int i2 = i - 30;
        int i3 = i + 30;
        String str3 = i2 <= 0 ? "" : str2;
        if (i3 >= str.length()) {
            str2 = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        int coerceAtLeast = RangesKt.coerceAtLeast(i2, 0);
        int coerceAtMost = RangesKt.coerceAtMost(i3, str.length());
        if (str != null) {
            String substring2 = str.substring(coerceAtLeast, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring2);
            sb.append(str2);
            return sb.toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
