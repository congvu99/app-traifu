package io.intercom.android.sdk.helpcenter.articles;

import android.content.Intent;
import io.intercom.android.sdk.helpcenter.articles.ArticleActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/helpcenter/articles/ArticleActivity$ArticleActivityArguments;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleFragment.kt */
final class ArticleFragment$arguments$2 extends Lambda implements Function0<ArticleActivity.ArticleActivityArguments> {
    final /* synthetic */ ArticleFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleFragment$arguments$2(ArticleFragment articleFragment) {
        super(0);
        this.this$0 = articleFragment;
    }

    public final ArticleActivity.ArticleActivityArguments invoke() {
        ArticleActivity.Companion companion = ArticleActivity.Companion;
        Intent intent = this.this$0.requireActivity().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "requireActivity().intent");
        return companion.getArguments(intent);
    }
}
