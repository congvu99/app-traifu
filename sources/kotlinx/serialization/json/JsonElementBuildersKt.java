package kotlinx.serialization.json;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a2\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a2\u0010\n\u001a\u00020\u000b2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u0019\u0010\r\u001a\u00020\u000e*\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u001a#\u0010\u0012\u001a\u00020\u000e*\u00020\u00072\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t\u001a#\u0010\u0013\u001a\u00020\u000e*\u00020\u00072\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t\u001a#\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011\u001a\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u001a-\u0010\u0018\u001a\u0004\u0018\u00010\u0015*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t\u001a-\u0010\u0019\u001a\u0004\u0018\u00010\u0015*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001a"}, d2 = {"infixToDeprecated", "", "unaryPlusDeprecated", "buildJsonArray", "Lkotlinx/serialization/json/JsonArray;", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonArrayBuilder;", "", "Lkotlin/ExtensionFunctionType;", "buildJsonObject", "Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonObjectBuilder;", "add", "", "value", "(Lkotlinx/serialization/json/JsonArrayBuilder;Ljava/lang/Boolean;)Z", "", "addJsonArray", "addJsonObject", "put", "Lkotlinx/serialization/json/JsonElement;", "key", "(Lkotlinx/serialization/json/JsonObjectBuilder;Ljava/lang/String;Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonElement;", "putJsonArray", "putJsonObject", "kotlinx-serialization-json"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonElementBuilders.kt */
public final class JsonElementBuildersKt {
    private static final String infixToDeprecated = "Infix 'to' operator is deprecated for removal for the favour of 'add'";
    private static final String unaryPlusDeprecated = "Unary plus is deprecated for removal for the favour of 'add'";

    public static final JsonObject buildJsonObject(Function1<? super JsonObjectBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        function1.invoke(jsonObjectBuilder);
        return jsonObjectBuilder.build();
    }

    public static final JsonArray buildJsonArray(Function1<? super JsonArrayBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
        function1.invoke(jsonArrayBuilder);
        return jsonArrayBuilder.build();
    }

    public static final JsonElement put(JsonObjectBuilder jsonObjectBuilder, String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(jsonObjectBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_KEY);
        return jsonObjectBuilder.put(str, JsonElementKt.JsonPrimitive(bool));
    }

    public static final JsonElement put(JsonObjectBuilder jsonObjectBuilder, String str, Number number) {
        Intrinsics.checkNotNullParameter(jsonObjectBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_KEY);
        return jsonObjectBuilder.put(str, JsonElementKt.JsonPrimitive(number));
    }

    public static final JsonElement put(JsonObjectBuilder jsonObjectBuilder, String str, String str2) {
        Intrinsics.checkNotNullParameter(jsonObjectBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_KEY);
        return jsonObjectBuilder.put(str, JsonElementKt.JsonPrimitive(str2));
    }

    public static final boolean add(JsonArrayBuilder jsonArrayBuilder, Boolean bool) {
        Intrinsics.checkNotNullParameter(jsonArrayBuilder, "<this>");
        return jsonArrayBuilder.add(JsonElementKt.JsonPrimitive(bool));
    }

    public static final boolean add(JsonArrayBuilder jsonArrayBuilder, Number number) {
        Intrinsics.checkNotNullParameter(jsonArrayBuilder, "<this>");
        return jsonArrayBuilder.add(JsonElementKt.JsonPrimitive(number));
    }

    public static final boolean add(JsonArrayBuilder jsonArrayBuilder, String str) {
        Intrinsics.checkNotNullParameter(jsonArrayBuilder, "<this>");
        return jsonArrayBuilder.add(JsonElementKt.JsonPrimitive(str));
    }

    public static final JsonElement putJsonObject(JsonObjectBuilder jsonObjectBuilder, String str, Function1<? super JsonObjectBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(jsonObjectBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_KEY);
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
        function1.invoke(jsonObjectBuilder2);
        return jsonObjectBuilder.put(str, jsonObjectBuilder2.build());
    }

    public static final JsonElement putJsonArray(JsonObjectBuilder jsonObjectBuilder, String str, Function1<? super JsonArrayBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(jsonObjectBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_KEY);
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
        function1.invoke(jsonArrayBuilder);
        return jsonObjectBuilder.put(str, jsonArrayBuilder.build());
    }

    public static final boolean addJsonObject(JsonArrayBuilder jsonArrayBuilder, Function1<? super JsonObjectBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(jsonArrayBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        function1.invoke(jsonObjectBuilder);
        return jsonArrayBuilder.add(jsonObjectBuilder.build());
    }

    public static final boolean addJsonArray(JsonArrayBuilder jsonArrayBuilder, Function1<? super JsonArrayBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(jsonArrayBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonArrayBuilder jsonArrayBuilder2 = new JsonArrayBuilder();
        function1.invoke(jsonArrayBuilder2);
        return jsonArrayBuilder.add(jsonArrayBuilder2.build());
    }
}
