package com.facebook.internal;

import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "response", "Lcom/facebook/GraphResponse;", "kotlin.jvm.PlatformType", "onCompleted"}, k = 3, mv = {1, 4, 0})
/* compiled from: Utility.kt */
final class Utility$getGraphMeRequestWithCacheAsync$graphCallback$1 implements GraphRequest.Callback {
    final /* synthetic */ String $accessToken;
    final /* synthetic */ Utility.GraphMeRequestWithCacheCallback $callback;

    Utility$getGraphMeRequestWithCacheAsync$graphCallback$1(Utility.GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback, String str) {
        this.$callback = graphMeRequestWithCacheCallback;
        this.$accessToken = str;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        Intrinsics.checkNotNullExpressionValue(graphResponse, "response");
        if (graphResponse.getError() != null) {
            Utility.GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback = this.$callback;
            FacebookRequestError error = graphResponse.getError();
            Intrinsics.checkNotNullExpressionValue(error, "response.error");
            graphMeRequestWithCacheCallback.onFailure(error.getException());
            return;
        }
        String str = this.$accessToken;
        JSONObject jSONObject = graphResponse.getJSONObject();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "response.jsonObject");
        ProfileInformationCache.putProfileInformation(str, jSONObject);
        this.$callback.onSuccess(graphResponse.getJSONObject());
    }
}
