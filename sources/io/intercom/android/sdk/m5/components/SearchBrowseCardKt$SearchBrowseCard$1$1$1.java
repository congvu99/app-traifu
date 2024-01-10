package io.intercom.android.sdk.m5.components;

import android.content.Context;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.helpcenter.search.IntercomArticleSearchActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SearchBrowseCard.kt */
final class SearchBrowseCardKt$SearchBrowseCard$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBrowseCardKt$SearchBrowseCard$1$1$1(Context context) {
        super(0);
        this.$context = context;
    }

    public final void invoke() {
        Injector.get().getMetricTracker().clickedSearchBrowseCard();
        this.$context.startActivity(IntercomArticleSearchActivity.Companion.buildIntent(this.$context, true));
    }
}
