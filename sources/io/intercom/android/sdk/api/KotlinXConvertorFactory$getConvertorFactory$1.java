package io.intercom.android.sdk.api;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonBuilder;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/serialization/json/JsonBuilder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: KotlinXConvertorFactory.kt */
final class KotlinXConvertorFactory$getConvertorFactory$1 extends Lambda implements Function1<JsonBuilder, Unit> {
    public static final KotlinXConvertorFactory$getConvertorFactory$1 INSTANCE = new KotlinXConvertorFactory$getConvertorFactory$1();

    KotlinXConvertorFactory$getConvertorFactory$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JsonBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(JsonBuilder jsonBuilder) {
        Intrinsics.checkNotNullParameter(jsonBuilder, "$this$Json");
        jsonBuilder.setLenient(true);
        jsonBuilder.setIgnoreUnknownKeys(true);
    }
}
