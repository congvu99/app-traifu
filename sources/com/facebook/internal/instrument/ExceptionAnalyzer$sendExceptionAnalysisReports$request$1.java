package com.facebook.internal.instrument;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "response", "Lcom/facebook/GraphResponse;", "kotlin.jvm.PlatformType", "onCompleted"}, k = 3, mv = {1, 4, 0})
/* compiled from: ExceptionAnalyzer.kt */
final class ExceptionAnalyzer$sendExceptionAnalysisReports$request$1 implements GraphRequest.Callback {
    final /* synthetic */ InstrumentData $instrumentData;

    ExceptionAnalyzer$sendExceptionAnalysisReports$request$1(InstrumentData instrumentData) {
        this.$instrumentData = instrumentData;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        try {
            Intrinsics.checkNotNullExpressionValue(graphResponse, "response");
            if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                this.$instrumentData.clear();
            }
        } catch (JSONException unused) {
        }
    }
}
