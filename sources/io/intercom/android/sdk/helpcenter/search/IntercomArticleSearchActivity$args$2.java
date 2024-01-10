package io.intercom.android.sdk.helpcenter.search;

import android.content.Intent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.intercom.android.sdk.helpcenter.search.IntercomArticleSearchActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/helpcenter/search/IntercomArticleSearchActivity$ArticleSearchArgs;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomArticleSearchActivity.kt */
final class IntercomArticleSearchActivity$args$2 extends Lambda implements Function0<IntercomArticleSearchActivity.ArticleSearchArgs> {
    final /* synthetic */ IntercomArticleSearchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomArticleSearchActivity$args$2(IntercomArticleSearchActivity intercomArticleSearchActivity) {
        super(0);
        this.this$0 = intercomArticleSearchActivity;
    }

    public final IntercomArticleSearchActivity.ArticleSearchArgs invoke() {
        IntercomArticleSearchActivity.Companion companion = IntercomArticleSearchActivity.Companion;
        Intent intent = this.this$0.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, SDKConstants.PARAM_INTENT);
        return companion.getArguments(intent);
    }
}
