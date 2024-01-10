package io.intercom.android.sdk.m5.components;

import android.content.Context;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.helpcenter.articles.ArticleActivity;
import io.intercom.android.sdk.m5.home.data.SuggestedArticle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SearchBrowseCard.kt */
final class SearchBrowseCardKt$SearchBrowseCard$1$1$3$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SuggestedArticle $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBrowseCardKt$SearchBrowseCard$1$1$3$2$1(SuggestedArticle suggestedArticle, Context context) {
        super(0);
        this.$it = suggestedArticle;
        this.$context = context;
    }

    public final void invoke() {
        Injector.get().getMetricTracker().clickedArticleSuggestion(this.$it.getId());
        this.$context.startActivity(ArticleActivity.Companion.buildIntent(this.$context, new ArticleActivity.ArticleActivityArguments(this.$it.getId(), "search_browse_card", true)));
    }
}
