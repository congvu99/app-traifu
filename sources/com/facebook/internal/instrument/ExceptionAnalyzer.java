package com.facebook.internal.instrument;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/internal/instrument/ExceptionAnalyzer;", "", "()V", "enabled", "", "enable", "", "execute", "e", "", "isDebug", "sendExceptionAnalysisReports", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ExceptionAnalyzer.kt */
public final class ExceptionAnalyzer {
    public static final ExceptionAnalyzer INSTANCE = new ExceptionAnalyzer();
    private static boolean enabled;

    @JvmStatic
    public static final boolean isDebug() {
        return false;
    }

    private ExceptionAnalyzer() {
    }

    @JvmStatic
    public static final void enable() {
        enabled = true;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            INSTANCE.sendExceptionAnalysisReports();
        }
    }

    @JvmStatic
    public static final void execute(Throwable th) {
        if (enabled && !isDebug() && th != null) {
            Set hashSet = new HashSet();
            StackTraceElement[] stackTrace = th.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
            for (StackTraceElement stackTraceElement : stackTrace) {
                Intrinsics.checkNotNullExpressionValue(stackTraceElement, "it");
                String className = stackTraceElement.getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "it.className");
                FeatureManager.Feature feature = FeatureManager.getFeature(className);
                if (feature != FeatureManager.Feature.Unknown) {
                    FeatureManager.disableFeature(feature);
                    hashSet.add(feature.toString());
                }
            }
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                Collection collection = hashSet;
                if (!collection.isEmpty()) {
                    InstrumentData.Builder.build(new JSONArray(collection)).save();
                }
            }
        }
    }

    public final void sendExceptionAnalysisReports() {
        if (!Utility.isDataProcessingRestricted()) {
            File[] listExceptionAnalysisReportFiles = InstrumentUtility.listExceptionAnalysisReportFiles();
            List arrayList = new ArrayList();
            for (File load : listExceptionAnalysisReportFiles) {
                InstrumentData load2 = InstrumentData.Builder.load(load);
                Intrinsics.checkNotNullExpressionValue(load2, "instrumentData");
                if (load2.isValid()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("crash_shield", load2.toString());
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                        GraphRequest newPostRequest = GraphRequest.newPostRequest((AccessToken) null, format, jSONObject, new ExceptionAnalyzer$sendExceptionAnalysisReports$request$1(load2));
                        Intrinsics.checkNotNullExpressionValue(newPostRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
                        arrayList.add(newPostRequest);
                    } catch (JSONException unused) {
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                new GraphRequestBatch((Collection<GraphRequest>) arrayList).executeAsync();
            }
        }
    }
}
