package io.intercom.android.sdk.blocks.messengercard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.appcompat.app.AlertDialog;
import com.brentvatne.react.ReactVideoView;
import com.facebook.internal.NativeProtocol;
import com.google.gson.Gson;
import io.intercom.android.sdk.activities.IntercomSheetActivity;
import io.intercom.android.sdk.helpcenter.articles.ArticleActivity;
import io.intercom.android.sdk.m5.IntercomRootActivityLauncher;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class MessengerCardWebViewInterface {
    private static final String HEIGHT_CHANGE_EVENT = "HEIGHT_CHANGE_EVENT";
    private static final String INPUT_TEXT = "INPUT_TEXT";
    /* access modifiers changed from: private */
    public static final Double MESSENGER_APP_ID_ARTICLE_SEARCH = Double.valueOf(27.0d);
    private static final String METRIC_EVENT = "METRIC_EVENT";
    private static final String OPEN_SHEET = "OPEN_SHEET";
    private static final String OPEN_URL = "OPEN_URL";
    /* access modifiers changed from: private */
    public final Context context;
    private final String conversationId;
    private final Gson gson;
    /* access modifiers changed from: private */
    public final Boolean isHomescreen;
    /* access modifiers changed from: private */
    public final View loadingView;
    /* access modifiers changed from: private */
    public final MetricTracker metricTracker;
    private final int primaryColor;
    /* access modifiers changed from: private */
    public final WebView webView;

    MessengerCardWebViewInterface(WebView webView2, View view, Gson gson2, int i, MetricTracker metricTracker2, String str, boolean z, Context context2) {
        this.webView = webView2;
        this.loadingView = view;
        this.gson = gson2;
        this.primaryColor = i;
        this.metricTracker = metricTracker2;
        this.conversationId = str;
        this.isHomescreen = Boolean.valueOf(z);
        this.context = context2;
    }

    @JavascriptInterface
    public void handleAction(String str) {
        final MessengerCardWebViewAction messengerCardWebViewAction = (MessengerCardWebViewAction) this.gson.fromJson(str, MessengerCardWebViewAction.class);
        final Map<String, Object> payload = messengerCardWebViewAction.getPayload();
        String type = messengerCardWebViewAction.getType();
        if (type != null && payload != null) {
            char c = 65535;
            switch (type.hashCode()) {
                case 279273946:
                    if (type.equals(OPEN_URL)) {
                        c = 0;
                        break;
                    }
                    break;
                case 387980611:
                    if (type.equals(HEIGHT_CHANGE_EVENT)) {
                        c = 3;
                        break;
                    }
                    break;
                case 899662635:
                    if (type.equals("METRIC_EVENT")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1901318306:
                    if (type.equals(INPUT_TEXT)) {
                        c = 2;
                        break;
                    }
                    break;
                case 2092140298:
                    if (type.equals(OPEN_SHEET)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                this.webView.post(new Runnable() {
                    public void run() {
                        MessengerCardWebViewInterface messengerCardWebViewInterface = MessengerCardWebViewInterface.this;
                        messengerCardWebViewInterface.openUrl(payload, messengerCardWebViewInterface.context);
                    }
                });
            } else if (c == 1) {
                this.webView.post(new Runnable() {
                    public void run() {
                        MessengerCardWebViewInterface messengerCardWebViewInterface = MessengerCardWebViewInterface.this;
                        messengerCardWebViewInterface.openSheet(payload, messengerCardWebViewInterface.context);
                    }
                });
            } else if (c == 2) {
                this.webView.post(new Runnable() {
                    public void run() {
                        if (MessengerCardWebViewInterface.MESSENGER_APP_ID_ARTICLE_SEARCH.equals((Double) payload.get("messengerAppId"))) {
                            IntercomRootActivityLauncher.INSTANCE.startHelpCenterCollections(MessengerCardWebViewInterface.this.webView.getContext(), Collections.emptyList(), MetricTracker.Place.LEGACY_ARTICLE_SEARCH_APP);
                            return;
                        }
                        MessengerCardWebViewInterface messengerCardWebViewInterface = MessengerCardWebViewInterface.this;
                        messengerCardWebViewInterface.showTextInputDialog(payload, messengerCardWebViewInterface.context);
                    }
                });
            } else if (c != 3) {
                if (c == 4) {
                    this.webView.post(new Runnable() {
                        public void run() {
                            Map<String, Object> payload = messengerCardWebViewAction.getPayload();
                            MessengerCardWebViewInterface.this.metricTracker.messengerCardWebViewEvent((String) payload.get("action"), (String) payload.get("object"), (String) payload.get("place"), payload.get(ReactVideoView.EVENT_PROP_METADATA) instanceof Map ? (Map) payload.get(ReactVideoView.EVENT_PROP_METADATA) : null, MessengerCardWebViewInterface.this.isHomescreen.booleanValue());
                        }
                    });
                }
            } else if (this.loadingView.getVisibility() == 0) {
                this.webView.post(new Runnable() {
                    public void run() {
                        MessengerCardWebViewInterface.this.loadingView.setVisibility(8);
                        MessengerCardWebViewInterface.this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void openUrl(Map<String, Object> map, Context context2) {
        context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String) map.get("url"))));
    }

    /* access modifiers changed from: private */
    public void openSheet(Map<String, Object> map, Context context2) {
        Map map2;
        String str = (String) map.get("url");
        if (map.containsKey(NativeProtocol.WEB_DIALOG_PARAMS)) {
            map2 = (Map) map.get(NativeProtocol.WEB_DIALOG_PARAMS);
        } else {
            map2 = new HashMap();
        }
        String stringFromMap = getStringFromMap(map2, "uri");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(stringFromMap)) {
            if ("article-link".equals(getStringFromMap(map2, "action_id")) && map2.containsKey("values")) {
                String stringFromMap2 = getStringFromMap((Map) map2.get("values"), "article_id");
                if (!TextUtils.isEmpty(stringFromMap2)) {
                    displayArticle(stringFromMap2, context2);
                    return;
                }
            }
            context2.startActivity(IntercomSheetActivity.buildIntent(context2, str, map2, stringFromMap, this.conversationId));
        }
    }

    private String getStringFromMap(Map<String, Object> map, String str) {
        return map.containsKey(str) ? String.valueOf(map.get(str)) : "";
    }

    private void displayArticle(String str, Context context2) {
        context2.startActivity(ArticleActivity.buildIntent(context2, new ArticleActivity.ArticleActivityArguments(str, this.isHomescreen.booleanValue() ? MetricTracker.Place.MESSENGER_HOME_APP : "conversation")));
    }

    /* access modifiers changed from: private */
    public void showTextInputDialog(Map<String, Object> map, Context context2) {
        AlertDialog create = new MessengerCardAlertDialogBuilder(context2, map, this.primaryColor, this.webView).create();
        create.show();
        create.getWindow().setSoftInputMode(5);
        create.getButton(-2).setTextColor(this.primaryColor);
        create.getButton(-1).setTextColor(this.primaryColor);
    }
}
