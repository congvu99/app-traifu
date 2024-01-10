package io.intercom.android.sdk.blocks.messengercard;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import com.google.gson.Gson;
import com.squareup.otto.Bus;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.io.File;

public class MessengerCardWebViewPresenter {
    private final Bus bus;
    private final File cache;
    private final Context context;
    private final String conversationId;
    private final String fallbackUrl;
    private final Gson gson;
    private final boolean isHomeScreen;
    private final View loadingView;
    private final MetricTracker metricTracker;
    private final int primaryColor;
    private final CardWebView webView;

    public MessengerCardWebViewPresenter(CardWebView cardWebView, View view, String str, Bus bus2, int i, Gson gson2, MetricTracker metricTracker2, File file, String str2, boolean z, Context context2) {
        this.webView = cardWebView;
        this.loadingView = view;
        this.fallbackUrl = str;
        this.bus = bus2;
        this.primaryColor = i;
        this.gson = gson2;
        this.metricTracker = metricTracker2;
        this.conversationId = str2;
        this.cache = file;
        this.isHomeScreen = z;
        this.context = context2;
    }

    public void setUpWebView() {
        this.webView.setUp(this.bus);
        this.webView.setBackgroundColor(0);
        this.webView.setWebViewClient(new MessengerCardWebViewClient(Uri.parse(this.fallbackUrl).getHost()));
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setCacheMode(-1);
        settings.setMixedContentMode(0);
        this.webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.addJavascriptInterface(new MessengerCardWebViewInterface(this.webView, this.loadingView, this.gson, this.primaryColor, this.metricTracker, this.conversationId, this.isHomeScreen, this.context), "AndroidHost");
    }

    public static CardWebView createCardWebView(Context context2) {
        CardWebView cardWebView;
        try {
            cardWebView = new CardWebView(context2);
        } catch (Resources.NotFoundException unused) {
            cardWebView = new CardWebView(Injector.get().getApplication());
        }
        cardWebView.setAlpha(0.0f);
        cardWebView.setId(R.id.intercom_messenger_card_webview);
        cardWebView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        return cardWebView;
    }
}
