package io.intercom.android.sdk.blocks.messengercard;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.google.gson.Gson;
import com.intercom.commons.utilities.HtmlCompat;
import com.squareup.otto.Bus;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.StyleType;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.interfaces.MessengerCardBlock;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.blocks.views.ParagraphView;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.utilities.ColorUtils;

public class MessengerCard implements MessengerCardBlock {
    private final Provider<AppConfig> appConfigProvider;
    private final Bus bus;
    private final Context context;
    private final String conversationId;
    private final Gson gson;
    private final MetricTracker metricTracker;
    private final StyleType styleType;

    public MessengerCard(Provider<AppConfig> provider, Gson gson2, Bus bus2, MetricTracker metricTracker2, String str, StyleType styleType2, Context context2) {
        this.appConfigProvider = provider;
        this.gson = gson2;
        this.bus = bus2;
        this.metricTracker = metricTracker2;
        this.conversationId = str;
        this.styleType = styleType2;
        this.context = context2;
    }

    public View addCard(String str, String str2, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = viewGroup;
        if (TextUtils.isEmpty(str2)) {
            return textFallback(str, viewGroup2);
        }
        Context context2 = viewGroup.getContext();
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context2).inflate(R.layout.intercom_messenger_card_block, viewGroup2, false);
        frameLayout.getLayoutTransition().enableTransitionType(4);
        CardWebView createCardWebView = MessengerCardWebViewPresenter.createCardWebView(context2);
        frameLayout.addView(createCardWebView);
        CardWebView cardWebView = createCardWebView;
        String str3 = str2;
        new MessengerCardWebViewPresenter(cardWebView, (ProgressBar) frameLayout.findViewById(R.id.loading_view), str3, this.bus, ColorUtils.primaryOrDarkColor(createCardWebView.getContext(), this.appConfigProvider.get()), this.gson, this.metricTracker, context2.getCacheDir(), this.conversationId, false, context2).setUpWebView();
        createCardWebView.loadUrl(str2);
        return frameLayout;
    }

    private View textFallback(String str, ViewGroup viewGroup) {
        ParagraphView paragraphView = new ParagraphView(viewGroup.getContext(), StyleType.ADMIN, BlockAlignment.LEFT, this.appConfigProvider.get());
        paragraphView.setText(HtmlCompat.fromHtml(str));
        return paragraphView;
    }
}
