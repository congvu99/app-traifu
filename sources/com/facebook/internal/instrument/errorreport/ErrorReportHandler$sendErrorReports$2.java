package com.facebook.internal.instrument.errorreport;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "response", "Lcom/facebook/GraphResponse;", "kotlin.jvm.PlatformType", "onCompleted"}, k = 3, mv = {1, 4, 0})
/* compiled from: ErrorReportHandler.kt */
final class ErrorReportHandler$sendErrorReports$2 implements GraphRequest.Callback {
    final /* synthetic */ ArrayList $validReports;

    ErrorReportHandler$sendErrorReports$2(ArrayList arrayList) {
        this.$validReports = arrayList;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        try {
            Intrinsics.checkNotNullExpressionValue(graphResponse, "response");
            if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                for (ErrorReportData clear : this.$validReports) {
                    clear.clear();
                }
            }
        } catch (JSONException unused) {
        }
    }
}
