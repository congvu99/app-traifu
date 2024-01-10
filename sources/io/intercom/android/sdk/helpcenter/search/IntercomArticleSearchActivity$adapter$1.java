package io.intercom.android.sdk.helpcenter.search;

import io.intercom.android.sdk.helpcenter.articles.ArticleActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomArticleSearchActivity.kt */
final class IntercomArticleSearchActivity$adapter$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ IntercomArticleSearchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomArticleSearchActivity$adapter$1(IntercomArticleSearchActivity intercomArticleSearchActivity) {
        super(1);
        this.this$0 = intercomArticleSearchActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.this$0.getViewModel().updateTeammateHelpRow();
        this.this$0.getViewModel().sendClickOnSearchResultMetric();
        this.this$0.startActivity(ArticleActivity.Companion.buildIntent(this.this$0, new ArticleActivity.ArticleActivityArguments(str, "search_results", false, 4, (DefaultConstructorMarker) null)));
    }
}
