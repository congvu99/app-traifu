package io.intercom.android.sdk.m5.home.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.blocks.messengercard.CardWebView;
import io.intercom.android.sdk.blocks.messengercard.MessengerCardWebViewClient;
import io.intercom.android.sdk.blocks.messengercard.MessengerCardWebViewPresenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LegacyMessengerAppCard.kt */
final class LegacyMessengerAppCardKt$LegacyMessengerAppCard$1$1$1 extends Lambda implements Function1<Context, CardWebView> {
    final /* synthetic */ String $url;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyMessengerAppCardKt$LegacyMessengerAppCard$1$1$1(String str) {
        super(1);
        this.$url = str;
    }

    public final CardWebView invoke(Context context) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        CardWebView cardWebView = new CardWebView(context2);
        String str = this.$url;
        cardWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, 160));
        cardWebView.getSettings().setJavaScriptEnabled(true);
        cardWebView.getSettings().setUseWideViewPort(true);
        cardWebView.getSettings().setCacheMode(-1);
        cardWebView.getSettings().setMixedContentMode(0);
        cardWebView.setVerticalScrollBarEnabled(false);
        cardWebView.setHorizontalScrollBarEnabled(false);
        cardWebView.setWebViewClient(new MessengerCardWebViewClient(str));
        ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setContent(ComposableSingletons$LegacyMessengerAppCardKt.INSTANCE.m5213getLambda2$intercom_sdk_base_release());
        new MessengerCardWebViewPresenter(cardWebView, composeView, str, Injector.get().getBus(), Injector.get().getAppConfigProvider().get().getPrimaryColor(), Injector.get().getGson(), Injector.get().getMetricTracker(), cardWebView.getContext().getCacheDir(), "", true, context2).setUpWebView();
        cardWebView.loadUrl(str);
        return cardWebView;
    }
}
