package io.intercom.android.sdk.helpcenter.search;

import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomArticleSearchActivity.kt */
final class IntercomArticleSearchActivity$viewModel$2 extends Lambda implements Function0<ArticleSearchViewModel> {
    final /* synthetic */ IntercomArticleSearchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomArticleSearchActivity$viewModel$2(IntercomArticleSearchActivity intercomArticleSearchActivity) {
        super(0);
        this.this$0 = intercomArticleSearchActivity;
    }

    public final ArticleSearchViewModel invoke() {
        HelpCenterApi helpCenterApi = Injector.get().getHelpCenterApi();
        Intrinsics.checkNotNullExpressionValue(helpCenterApi, "get().helpCenterApi");
        return ArticleSearchViewModel.Companion.create(this.this$0, helpCenterApi, this.this$0.getArgs().isFromSearchBrowse());
    }
}
