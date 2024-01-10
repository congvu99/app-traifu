package io.intercom.android.sdk.m5.home.components;

import android.content.Context;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.m5.home.data.Link;
import io.intercom.android.sdk.utilities.LinkOpener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExternalLinkCard.kt */
final class ExternalLinkCardKt$ExternalLinkCard$1$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Link $item;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExternalLinkCardKt$ExternalLinkCard$1$1$1$1(Link link, Context context) {
        super(0);
        this.$item = link;
        this.$context = context;
    }

    public final void invoke() {
        Injector.get().getMetricTracker().clickedExternalLinkCard();
        LinkOpener.handleUrl(this.$item.getUrl(), this.$context, Injector.get().getApi());
    }
}
