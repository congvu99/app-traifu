package io.intercom.android.sdk.api;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.Gson;
import io.intercom.android.sdk.Injector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0000¢\u0006\u0002\b\bJ\u001c\u0010\t\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0001¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/api/MessengerApiHelper;", "", "()V", "getDefaultRequestBody", "Lokhttp3/RequestBody;", "bodyParams", "", "", "getDefaultRequestBody$intercom_sdk_base_release", "optionsMapToRequestBody", "options", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MessengerApi.kt */
public final class MessengerApiHelper {
    public static final MessengerApiHelper INSTANCE = new MessengerApiHelper();

    private MessengerApiHelper() {
    }

    public final RequestBody optionsMapToRequestBody(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson((Object) map);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(options)");
        return companion.create(json, MediaType.Companion.get("application/json; charset=utf-8"));
    }

    public static /* synthetic */ RequestBody getDefaultRequestBody$intercom_sdk_base_release$default(MessengerApiHelper messengerApiHelper, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return messengerApiHelper.getDefaultRequestBody$intercom_sdk_base_release(map);
    }

    public final RequestBody getDefaultRequestBody$intercom_sdk_base_release(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "bodyParams");
        Injector injector = Injector.get();
        Map<String, Object> map2 = injector.getUserIdentity().toMap();
        injector.getApi().addSecureHash(map2);
        map2.putAll(map);
        Intrinsics.checkNotNullExpressionValue(map2, "userIdentityMap");
        return optionsMapToRequestBody(map2);
    }
}
