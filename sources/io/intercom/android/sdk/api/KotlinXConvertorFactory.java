package io.intercom.android.sdk.api;

import com.jakewharton.retrofit2.converter.kotlinx.serialization.KotlinSerializationConverterFactory;
import com.loopj.android.http.RequestParams;
import kotlin.Metadata;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import okhttp3.MediaType;
import retrofit2.Converter;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lio/intercom/android/sdk/api/KotlinXConvertorFactory;", "", "()V", "getConvertorFactory", "Lretrofit2/Converter$Factory;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: KotlinXConvertorFactory.kt */
public final class KotlinXConvertorFactory {
    public static final KotlinXConvertorFactory INSTANCE = new KotlinXConvertorFactory();

    private KotlinXConvertorFactory() {
    }

    public final Converter.Factory getConvertorFactory() {
        return KotlinSerializationConverterFactory.create((StringFormat) JsonKt.Json$default((Json) null, KotlinXConvertorFactory$getConvertorFactory$1.INSTANCE, 1, (Object) null), MediaType.Companion.get(RequestParams.APPLICATION_JSON));
    }
}
