package io.intercom.android.sdk.helpcenter.webview;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.brentvatne.react.ReactVideoView;
import com.google.gson.Gson;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.helpcenter.utils.ConstantsKt;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.util.HashMap;
import java.util.Map;

public class HelpCenterWebViewInterface {
    public static final String METRIC_EVENT = "METRIC_EVENT";
    public static final String TRACK_REACTION = "TRACK_REACTION";
    private final Api api;
    private final Gson gson;
    private final boolean isFromSearchBrowse;
    private final MetricTracker metricTracker;
    private final WebView webView;

    public HelpCenterWebViewInterface(WebView webView2, Gson gson2, MetricTracker metricTracker2, Api api2, boolean z) {
        this.webView = webView2;
        this.gson = gson2;
        this.metricTracker = metricTracker2;
        this.api = api2;
        this.isFromSearchBrowse = z;
    }

    @JavascriptInterface
    public void handleAction(String str) {
        HelpCenterWebViewAction helpCenterWebViewAction = (HelpCenterWebViewAction) this.gson.fromJson(str, HelpCenterWebViewAction.class);
        String type = helpCenterWebViewAction.getType();
        Map<String, Object> value = helpCenterWebViewAction.getValue();
        if (type != null && value != null) {
            char c = 65535;
            int hashCode = type.hashCode();
            if (hashCode != 9315005) {
                if (hashCode == 899662635 && type.equals(METRIC_EVENT)) {
                    c = 0;
                }
            } else if (type.equals(TRACK_REACTION)) {
                c = 1;
            }
            if (c == 0) {
                this.webView.post(new Runnable(value) {
                    public final /* synthetic */ Map f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        HelpCenterWebViewInterface.this.lambda$handleAction$0$HelpCenterWebViewInterface(this.f$1);
                    }
                });
            } else if (c == 1) {
                this.webView.post(new Runnable(value) {
                    public final /* synthetic */ Map f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        HelpCenterWebViewInterface.this.lambda$handleAction$1$HelpCenterWebViewInterface(this.f$1);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$handleAction$0$HelpCenterWebViewInterface(Map map) {
        String str = (String) map.get("action");
        String str2 = (String) map.get("object");
        String str3 = (String) map.get("place");
        HashMap hashMap = new HashMap();
        if (map.get(ReactVideoView.EVENT_PROP_METADATA) instanceof Map) {
            hashMap.putAll((Map) map.get(ReactVideoView.EVENT_PROP_METADATA));
        }
        if (this.isFromSearchBrowse) {
            hashMap.put(ConstantsKt.KEY_ARTICLE_SOURCE, "search_browse");
        }
        this.metricTracker.educateWebviewMetric(str, str2, str3, hashMap, MetricTracker.Context.FROM_HELP_CENTER_WEBVIEW);
    }

    public /* synthetic */ void lambda$handleAction$1$HelpCenterWebViewInterface(Map map) {
        Double d = (Double) map.get("article_id");
        Double d2 = (Double) map.get("article_content_id");
        Double d3 = (Double) map.get("reaction_index");
        if (d != null && d2 != null && d3 != null) {
            this.api.reactToLink(String.valueOf(d.intValue()), String.valueOf(d2.intValue()), d3.intValue(), true);
        }
    }
}
