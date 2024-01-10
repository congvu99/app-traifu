package io.intercom.android.sdk.helpcenter.articles;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.articles.ArticleWebViewClient;
import io.intercom.android.sdk.databinding.IntercomFragmentHelpCenterArticleBinding;
import io.intercom.android.sdk.helpcenter.articles.ArticleActivity;
import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import io.intercom.android.sdk.helpcenter.webview.HelpCenterWebViewInterface;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.extensions.ViewExtensionsKt;
import io.intercom.android.sdk.views.IntercomShimmerLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0003J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lio/intercom/android/sdk/databinding/IntercomFragmentHelpCenterArticleBinding;", "arguments", "Lio/intercom/android/sdk/helpcenter/articles/ArticleActivity$ArticleActivityArguments;", "getArguments", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleActivity$ArticleActivityArguments;", "arguments$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lio/intercom/android/sdk/databinding/IntercomFragmentHelpCenterArticleBinding;", "viewModel", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewModel;", "getViewModel", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleViewModel;", "viewModel$delegate", "initViews", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "renderContent", "content", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$Content;", "renderErrors", "error", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$Error;", "requestData", "setCookies", "subscribeToStates", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleFragment.kt */
public final class ArticleFragment extends Fragment {
    private IntercomFragmentHelpCenterArticleBinding _binding;
    private final Lazy arguments$delegate = LazyKt.lazy(new ArticleFragment$arguments$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new ArticleFragment$viewModel$2(this));

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArticleViewState.WebViewStatus.values().length];
            iArr[ArticleViewState.WebViewStatus.Idle.ordinal()] = 1;
            iArr[ArticleViewState.WebViewStatus.Loading.ordinal()] = 2;
            iArr[ArticleViewState.WebViewStatus.Ready.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ArticleFragment() {
        super(R.layout.intercom_fragment_help_center_article);
    }

    private final IntercomFragmentHelpCenterArticleBinding getBinding() {
        IntercomFragmentHelpCenterArticleBinding intercomFragmentHelpCenterArticleBinding = this._binding;
        if (intercomFragmentHelpCenterArticleBinding != null) {
            return intercomFragmentHelpCenterArticleBinding;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public final ArticleActivity.ArticleActivityArguments getArguments() {
        return (ArticleActivity.ArticleActivityArguments) this.arguments$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ArticleViewModel getViewModel() {
        return (ArticleViewModel) this.viewModel$delegate.getValue();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        initViews();
        subscribeToStates();
        requestData();
    }

    private final void requestData() {
        getViewModel().fragmentLoaded(getArguments().getArticleId());
    }

    private final void subscribeToStates() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new ArticleFragment$subscribeToStates$1(this, (Continuation<? super ArticleFragment$subscribeToStates$1>) null));
    }

    /* access modifiers changed from: private */
    public final void renderErrors(ArticleViewState.Error error) {
        IntercomFragmentHelpCenterArticleBinding binding = getBinding();
        IntercomShimmerLayout intercomShimmerLayout = binding.articleLoadingView;
        Intrinsics.checkNotNullExpressionValue(intercomShimmerLayout, "articleLoadingView");
        ViewExtensionsKt.hide(intercomShimmerLayout);
        LinearLayout linearLayout = binding.articleContents;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "articleContents");
        ViewExtensionsKt.hide(linearLayout);
        TextView textView = binding.articleErrorTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "articleErrorTextView");
        ViewExtensionsKt.show(textView);
        binding.articleErrorTextView.setText(error.getMessage());
        TextView textView2 = binding.articleRetryButton;
        textView2.setVisibility(error.getRetryButtonVisibility());
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ArticleFragment.m5098renderErrors$lambda2$lambda1$lambda0(ArticleFragment.this, view);
            }
        });
        textView2.setBackgroundTintList(ColorStateList.valueOf(ColorUtils.buttonBackgroundColorVariant(error.getRetryButtonPrimaryColor())));
        textView2.setTextColor(error.getRetryButtonPrimaryColor());
    }

    /* access modifiers changed from: private */
    /* renamed from: renderErrors$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m5098renderErrors$lambda2$lambda1$lambda0(ArticleFragment articleFragment, View view) {
        Intrinsics.checkNotNullParameter(articleFragment, "this$0");
        articleFragment.requestData();
    }

    /* access modifiers changed from: private */
    public final void renderContent(ArticleViewState.Content content) {
        IntercomFragmentHelpCenterArticleBinding binding = getBinding();
        Group group = binding.articleErrorViews;
        Intrinsics.checkNotNullExpressionValue(group, "articleErrorViews");
        ViewExtensionsKt.hide(group);
        binding.articleReactions.getRoot().setVisibility(content.getReactionState().getReactionComponentVisibility());
        binding.articleTeamHelp.setVisibility(content.getReactionState().getReactionComponentVisibility());
        int i = WhenMappings.$EnumSwitchMapping$0[content.getWebViewStatus().ordinal()];
        if (i == 1) {
            IntercomShimmerLayout intercomShimmerLayout = binding.articleLoadingView;
            Intrinsics.checkNotNullExpressionValue(intercomShimmerLayout, "articleLoadingView");
            ViewExtensionsKt.show(intercomShimmerLayout);
            LinearLayout linearLayout = binding.articleContents;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "articleContents");
            ViewExtensionsKt.hide(linearLayout);
            binding.articleWebView.setWebViewClient(new ArticleWebViewClient(content.getArticleUrl(), getViewModel(), Injector.get().getAppConfigProvider().get().getHelpCenterUrls()));
            setCookies();
            binding.articleWebView.loadUrl(content.getArticleUrl(), MapsKt.mapOf(TuplesKt.to("MobileClientDisplayType", "AndroidIntercomHeaderless"), TuplesKt.to("MobileClient", "AndroidIntercomWebView"), TuplesKt.to("MobileClientReactionsHidden", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)));
        } else if (i == 2) {
            IntercomShimmerLayout intercomShimmerLayout2 = binding.articleLoadingView;
            Intrinsics.checkNotNullExpressionValue(intercomShimmerLayout2, "articleLoadingView");
            ViewExtensionsKt.show(intercomShimmerLayout2);
            LinearLayout linearLayout2 = binding.articleContents;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "articleContents");
            ViewExtensionsKt.hide(linearLayout2);
        } else if (i == 3) {
            IntercomShimmerLayout intercomShimmerLayout3 = binding.articleLoadingView;
            Intrinsics.checkNotNullExpressionValue(intercomShimmerLayout3, "articleLoadingView");
            ViewExtensionsKt.hide(intercomShimmerLayout3);
            LinearLayout linearLayout3 = binding.articleContents;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "articleContents");
            ViewExtensionsKt.show(linearLayout3);
            binding.articleWebView.evaluateJavascript("window.alexandriaArticleContentId", new ValueCallback() {
                public final void onReceiveValue(Object obj) {
                    ArticleFragment.m5097renderContent$lambda4$lambda3(ArticleFragment.this, (String) obj);
                }
            });
        }
        binding.articleTeamHelp.setVisibility(content.getReactionState().getTeamHelpVisibility());
        binding.articleTeamHelp.setTeamPresenceState(content.getTeamPresenceState());
        if (content.getReactionState().getShouldScrollToBottom()) {
            binding.articleReactions.motionLayout.setTransitionListener(new ArticleFragment$renderContent$1$2(binding));
        }
        binding.articleReactions.motionLayout.transitionToState(content.getReactionState().getTransitionState());
    }

    /* access modifiers changed from: private */
    /* renamed from: renderContent$lambda-4$lambda-3  reason: not valid java name */
    public static final void m5097renderContent$lambda4$lambda3(ArticleFragment articleFragment, String str) {
        Intrinsics.checkNotNullParameter(articleFragment, "this$0");
        ArticleViewModel viewModel = articleFragment.getViewModel();
        Intrinsics.checkNotNullExpressionValue(str, "value");
        viewModel.articleContentIdFetched(StringsKt.removeSurrounding(str, (CharSequence) "\""));
    }

    private final void setCookies() {
        Injector injector = Injector.get();
        String str = "intercom-session-" + injector.getAppIdentity().appId();
        String encryptedUserId = injector.getUserIdentity().getEncryptedUserId();
        Intrinsics.checkNotNullExpressionValue(encryptedUserId, "userIdentity.encryptedUserId");
        CookieManager.getInstance().setCookie(injector.getAppConfigProvider().get().getHelpCenterUrl(), str + '=' + encryptedUserId);
    }

    private final void initViews() {
        this._binding = IntercomFragmentHelpCenterArticleBinding.bind(requireView());
        IntercomFragmentHelpCenterArticleBinding binding = getBinding();
        binding.articleToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ArticleFragment.m5092initViews$lambda10$lambda6(ArticleFragment.this, view);
            }
        });
        binding.articleWebView.getSettings().setJavaScriptEnabled(true);
        binding.articleWebView.addJavascriptInterface(new HelpCenterWebViewInterface(binding.articleWebView, Injector.get().getGson(), Injector.get().getMetricTracker(), Injector.get().getApiProvider().get(), getArguments().isFromSearchBrowse()), "AndroidHost");
        binding.articleReactions.intercomReactionHappy.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ArticleFragment.m5093initViews$lambda10$lambda7(ArticleFragment.this, view);
            }
        });
        binding.articleReactions.intercomReactionNeutral.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ArticleFragment.m5094initViews$lambda10$lambda8(ArticleFragment.this, view);
            }
        });
        binding.articleReactions.intercomReactionSad.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ArticleFragment.m5095initViews$lambda10$lambda9(ArticleFragment.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: initViews$lambda-10$lambda-6  reason: not valid java name */
    public static final void m5092initViews$lambda10$lambda6(ArticleFragment articleFragment, View view) {
        Intrinsics.checkNotNullParameter(articleFragment, "this$0");
        FragmentActivity activity = articleFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initViews$lambda-10$lambda-7  reason: not valid java name */
    public static final void m5093initViews$lambda10$lambda7(ArticleFragment articleFragment, View view) {
        Intrinsics.checkNotNullParameter(articleFragment, "this$0");
        articleFragment.getViewModel().happyReactionTapped();
    }

    /* access modifiers changed from: private */
    /* renamed from: initViews$lambda-10$lambda-8  reason: not valid java name */
    public static final void m5094initViews$lambda10$lambda8(ArticleFragment articleFragment, View view) {
        Intrinsics.checkNotNullParameter(articleFragment, "this$0");
        articleFragment.getViewModel().neutralReactionTapped();
    }

    /* access modifiers changed from: private */
    /* renamed from: initViews$lambda-10$lambda-9  reason: not valid java name */
    public static final void m5095initViews$lambda10$lambda9(ArticleFragment articleFragment, View view) {
        Intrinsics.checkNotNullParameter(articleFragment, "this$0");
        articleFragment.getViewModel().sadReactionTapped();
    }
}
