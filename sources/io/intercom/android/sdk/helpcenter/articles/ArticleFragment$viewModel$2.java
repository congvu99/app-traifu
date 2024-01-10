package io.intercom.android.sdk.helpcenter.articles;

import androidx.fragment.app.FragmentActivity;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import io.intercom.android.sdk.helpcenter.articles.ArticleViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleFragment.kt */
final class ArticleFragment$viewModel$2 extends Lambda implements Function0<ArticleViewModel> {
    final /* synthetic */ ArticleFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleFragment$viewModel$2(ArticleFragment articleFragment) {
        super(0);
        this.this$0 = articleFragment;
    }

    public final ArticleViewModel invoke() {
        ArticleViewModel.Companion companion = ArticleViewModel.Companion;
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        HelpCenterApi helpCenterApi = Injector.get().getHelpCenterApi();
        Intrinsics.checkNotNullExpressionValue(helpCenterApi, "get().helpCenterApi");
        String helpCenterUrl = Injector.get().getAppConfigProvider().get().getHelpCenterUrl();
        Intrinsics.checkNotNullExpressionValue(helpCenterUrl, "get().appConfigProvider.get().helpCenterUrl");
        return companion.create(requireActivity, helpCenterApi, helpCenterUrl, this.this$0.getArguments().getMetricPlace(), this.this$0.getArguments().isFromSearchBrowse());
    }
}
