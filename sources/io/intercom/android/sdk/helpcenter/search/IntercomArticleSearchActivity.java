package io.intercom.android.sdk.helpcenter.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.databinding.IntercomActivityArticleSearchBinding;
import io.intercom.android.sdk.helpcenter.IntercomHelpCenterBaseActivity;
import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import io.intercom.android.sdk.helpcenter.utils.PaddedDividerItemDecoration;
import io.intercom.android.sdk.m5.helpcenter.HelpCenterLoadingScreen;
import io.intercom.android.sdk.m5.helpcenter.components.TeamPresenceComponent;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.android.sdk.utilities.extensions.ViewExtensionsKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u0002/0B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010\u001f\u001a\u00020\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010'\u001a\u00020\u0016H\u0016J\u0012\u0010(\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020\u0016H\u0002J\u0012\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001d0-*\u00020.H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u00061"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/IntercomArticleSearchActivity;", "Lio/intercom/android/sdk/helpcenter/IntercomHelpCenterBaseActivity;", "()V", "_binding", "Lio/intercom/android/sdk/databinding/IntercomActivityArticleSearchBinding;", "adapter", "Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter;", "args", "Lio/intercom/android/sdk/helpcenter/search/IntercomArticleSearchActivity$ArticleSearchArgs;", "getArgs", "()Lio/intercom/android/sdk/helpcenter/search/IntercomArticleSearchActivity$ArticleSearchArgs;", "args$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lio/intercom/android/sdk/databinding/IntercomActivityArticleSearchBinding;", "viewModel", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchViewModel;", "getViewModel", "()Lio/intercom/android/sdk/helpcenter/search/ArticleSearchViewModel;", "viewModel$delegate", "displayError", "", "displayInitialState", "displayLoading", "displayNoResults", "teamPresenceState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "searchTerm", "", "displayNoResultsWithoutTeamHelp", "displaySearchResults", "results", "", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow;", "getNoResultsMessage", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "subscribeToStates", "textChanged", "Lkotlinx/coroutines/flow/StateFlow;", "Landroid/widget/EditText;", "ArticleSearchArgs", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomArticleSearchActivity.kt */
public final class IntercomArticleSearchActivity extends IntercomHelpCenterBaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String IS_FROM_SEARCH_BROWSE = "IS_SEARCH_BROWSE";
    private IntercomActivityArticleSearchBinding _binding;
    private final SearchResultAdapter adapter = new SearchResultAdapter(new IntercomArticleSearchActivity$adapter$1(this));
    private final Lazy args$delegate = LazyKt.lazy(new IntercomArticleSearchActivity$args$2(this));
    private final Lazy viewModel$delegate = LazyKt.lazy(new IntercomArticleSearchActivity$viewModel$2(this));

    @JvmStatic
    public static final Intent buildIntent(Context context, boolean z) {
        return Companion.buildIntent(context, z);
    }

    private final IntercomActivityArticleSearchBinding getBinding() {
        IntercomActivityArticleSearchBinding intercomActivityArticleSearchBinding = this._binding;
        if (intercomActivityArticleSearchBinding != null) {
            return intercomActivityArticleSearchBinding;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public final ArticleSearchViewModel getViewModel() {
        return (ArticleSearchViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ArticleSearchArgs getArgs() {
        return (ArticleSearchArgs) this.args$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this._binding = IntercomActivityArticleSearchBinding.inflate(getLayoutInflater());
        setContentView((View) getBinding().getRoot());
        IntercomActivityArticleSearchBinding binding = getBinding();
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                IntercomArticleSearchActivity.m5101onCreate$lambda3$lambda0(IntercomArticleSearchActivity.this, view);
            }
        });
        binding.searchBar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return IntercomArticleSearchActivity.m5102onCreate$lambda3$lambda1(IntercomActivityArticleSearchBinding.this, textView, i, keyEvent);
            }
        });
        binding.searchBar.addTextChangedListener(new IntercomArticleSearchActivity$onCreate$1$3(binding));
        binding.searchBar.requestFocus();
        ArticleSearchViewModel viewModel = getViewModel();
        EditText editText = binding.searchBar;
        Intrinsics.checkNotNullExpressionValue(editText, "searchBar");
        viewModel.searchForArticles(textChanged(editText));
        binding.clearSearch.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                IntercomArticleSearchActivity.m5103onCreate$lambda3$lambda2(IntercomActivityArticleSearchBinding.this, view);
            }
        });
        Context context = binding.searchResultRecyclerView.getContext();
        binding.searchResultRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        binding.searchResultRecyclerView.setAdapter(this.adapter);
        RecyclerView recyclerView = binding.searchResultRecyclerView;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        recyclerView.addItemDecoration(new PaddedDividerItemDecoration(context));
        subscribeToStates();
        overridePendingTransition(R.anim.intercom_fade_in, R.anim.intercom_donothing);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3$lambda-0  reason: not valid java name */
    public static final void m5101onCreate$lambda3$lambda0(IntercomArticleSearchActivity intercomArticleSearchActivity, View view) {
        Intrinsics.checkNotNullParameter(intercomArticleSearchActivity, "this$0");
        intercomArticleSearchActivity.onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3$lambda-1  reason: not valid java name */
    public static final boolean m5102onCreate$lambda3$lambda1(IntercomActivityArticleSearchBinding intercomActivityArticleSearchBinding, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(intercomActivityArticleSearchBinding, "$this_with");
        String obj = intercomActivityArticleSearchBinding.searchBar.getText().toString();
        if (i == 3) {
            if (obj.length() > 0) {
                FlowKt.flowOf(obj);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3$lambda-2  reason: not valid java name */
    public static final void m5103onCreate$lambda3$lambda2(IntercomActivityArticleSearchBinding intercomActivityArticleSearchBinding, View view) {
        Intrinsics.checkNotNullParameter(intercomActivityArticleSearchBinding, "$this_with");
        intercomActivityArticleSearchBinding.searchBar.getText().clear();
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.intercom_donothing, R.anim.intercom_fade_out);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/IntercomArticleSearchActivity$Companion;", "", "()V", "IS_FROM_SEARCH_BROWSE", "", "buildIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "isFromSearchBrowse", "", "getArguments", "Lio/intercom/android/sdk/helpcenter/search/IntercomArticleSearchActivity$ArticleSearchArgs;", "intent", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomArticleSearchActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Intent buildIntent(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, IntercomArticleSearchActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(IntercomArticleSearchActivity.IS_FROM_SEARCH_BROWSE, z);
            return intent;
        }

        public final ArticleSearchArgs getArguments(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
            return new ArticleSearchArgs(intent.getBooleanExtra(IntercomArticleSearchActivity.IS_FROM_SEARCH_BROWSE, false));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/IntercomArticleSearchActivity$ArticleSearchArgs;", "", "isFromSearchBrowse", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomArticleSearchActivity.kt */
    public static final class ArticleSearchArgs {
        private final boolean isFromSearchBrowse;

        public ArticleSearchArgs() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ArticleSearchArgs copy$default(ArticleSearchArgs articleSearchArgs, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = articleSearchArgs.isFromSearchBrowse;
            }
            return articleSearchArgs.copy(z);
        }

        public final boolean component1() {
            return this.isFromSearchBrowse;
        }

        public final ArticleSearchArgs copy(boolean z) {
            return new ArticleSearchArgs(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ArticleSearchArgs) && this.isFromSearchBrowse == ((ArticleSearchArgs) obj).isFromSearchBrowse;
        }

        public int hashCode() {
            boolean z = this.isFromSearchBrowse;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "ArticleSearchArgs(isFromSearchBrowse=" + this.isFromSearchBrowse + ')';
        }

        public ArticleSearchArgs(boolean z) {
            this.isFromSearchBrowse = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ArticleSearchArgs(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean isFromSearchBrowse() {
            return this.isFromSearchBrowse;
        }
    }

    private final void subscribeToStates() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new IntercomArticleSearchActivity$subscribeToStates$1(this, (Continuation<? super IntercomArticleSearchActivity$subscribeToStates$1>) null));
    }

    /* access modifiers changed from: private */
    public final void displayLoading() {
        IntercomActivityArticleSearchBinding binding = getBinding();
        RecyclerView recyclerView = binding.searchResultRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "searchResultRecyclerView");
        ViewExtensionsKt.hide(recyclerView);
        Group group = binding.searchErrors;
        Intrinsics.checkNotNullExpressionValue(group, "searchErrors");
        ViewExtensionsKt.hide(group);
        HelpCenterLoadingScreen helpCenterLoadingScreen = binding.searchLoading;
        Intrinsics.checkNotNullExpressionValue(helpCenterLoadingScreen, "searchLoading");
        ViewExtensionsKt.show(helpCenterLoadingScreen);
    }

    /* access modifiers changed from: private */
    public final void displaySearchResults(List<? extends ArticleSearchResultRow> list) {
        IntercomActivityArticleSearchBinding binding = getBinding();
        RecyclerView recyclerView = binding.searchResultRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "searchResultRecyclerView");
        ViewExtensionsKt.show(recyclerView);
        Group group = binding.searchErrors;
        Intrinsics.checkNotNullExpressionValue(group, "searchErrors");
        ViewExtensionsKt.hide(group);
        HelpCenterLoadingScreen helpCenterLoadingScreen = binding.searchLoading;
        Intrinsics.checkNotNullExpressionValue(helpCenterLoadingScreen, "searchLoading");
        ViewExtensionsKt.hide(helpCenterLoadingScreen);
        this.adapter.updateResults(list);
    }

    /* access modifiers changed from: private */
    public final void displayNoResults(ArticleViewState.TeamPresenceState teamPresenceState, String str) {
        IntercomActivityArticleSearchBinding binding = getBinding();
        RecyclerView recyclerView = binding.searchResultRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "searchResultRecyclerView");
        ViewExtensionsKt.hide(recyclerView);
        HelpCenterLoadingScreen helpCenterLoadingScreen = binding.searchLoading;
        Intrinsics.checkNotNullExpressionValue(helpCenterLoadingScreen, "searchLoading");
        ViewExtensionsKt.hide(helpCenterLoadingScreen);
        binding.searchErrorTeamHelp.setTeamPresenceState(teamPresenceState);
        Group group = binding.searchErrors;
        Intrinsics.checkNotNullExpressionValue(group, "searchErrors");
        ViewExtensionsKt.show(group);
        binding.searchError.setText(getNoResultsMessage(this, str));
    }

    /* access modifiers changed from: private */
    public final void displayNoResultsWithoutTeamHelp(String str) {
        IntercomActivityArticleSearchBinding binding = getBinding();
        RecyclerView recyclerView = binding.searchResultRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "searchResultRecyclerView");
        ViewExtensionsKt.hide(recyclerView);
        HelpCenterLoadingScreen helpCenterLoadingScreen = binding.searchLoading;
        Intrinsics.checkNotNullExpressionValue(helpCenterLoadingScreen, "searchLoading");
        ViewExtensionsKt.hide(helpCenterLoadingScreen);
        TeamPresenceComponent teamPresenceComponent = binding.searchErrorTeamHelp;
        Intrinsics.checkNotNullExpressionValue(teamPresenceComponent, "searchErrorTeamHelp");
        ViewExtensionsKt.hide(teamPresenceComponent);
        Group group = binding.searchErrors;
        Intrinsics.checkNotNullExpressionValue(group, "searchErrors");
        ViewExtensionsKt.show(group);
        binding.searchError.setText(getNoResultsMessage(this, str));
    }

    /* access modifiers changed from: private */
    public final void displayError() {
        IntercomActivityArticleSearchBinding binding = getBinding();
        RecyclerView recyclerView = binding.searchResultRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "searchResultRecyclerView");
        ViewExtensionsKt.hide(recyclerView);
        HelpCenterLoadingScreen helpCenterLoadingScreen = binding.searchLoading;
        Intrinsics.checkNotNullExpressionValue(helpCenterLoadingScreen, "searchLoading");
        ViewExtensionsKt.hide(helpCenterLoadingScreen);
        TextView textView = binding.searchError;
        Intrinsics.checkNotNullExpressionValue(textView, "searchError");
        ViewExtensionsKt.show(textView);
        TeamPresenceComponent teamPresenceComponent = binding.searchErrorTeamHelp;
        Intrinsics.checkNotNullExpressionValue(teamPresenceComponent, "searchErrorTeamHelp");
        ViewExtensionsKt.hide(teamPresenceComponent);
        binding.searchError.setText(R.string.intercom_something_went_wrong_try_again);
    }

    /* access modifiers changed from: private */
    public final void displayInitialState() {
        IntercomActivityArticleSearchBinding binding = getBinding();
        ImageButton imageButton = binding.clearSearch;
        Intrinsics.checkNotNullExpressionValue(imageButton, "clearSearch");
        ViewExtensionsKt.hide(imageButton);
        HelpCenterLoadingScreen helpCenterLoadingScreen = binding.searchLoading;
        Intrinsics.checkNotNullExpressionValue(helpCenterLoadingScreen, "searchLoading");
        ViewExtensionsKt.hide(helpCenterLoadingScreen);
        Group group = binding.searchErrors;
        Intrinsics.checkNotNullExpressionValue(group, "searchErrors");
        ViewExtensionsKt.hide(group);
        RecyclerView recyclerView = binding.searchResultRecyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "searchResultRecyclerView");
        ViewExtensionsKt.show(recyclerView);
        this.adapter.clearData();
    }

    private final StateFlow<String> textChanged(EditText editText) {
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow("");
        editText.addTextChangedListener(new IntercomArticleSearchActivity$textChanged$1(MutableStateFlow));
        return MutableStateFlow;
    }

    private final SpannableString getNoResultsMessage(Context context, String str) {
        String str2 = '\'' + str + '\'';
        SpannableString spannableString = new SpannableString(Phrase.from(context, R.string.intercom_no_results_for_searchterm).put("searchTerm", (CharSequence) str2).format().toString());
        int indexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, str2, 0, false, 6, (Object) null);
        spannableString.setSpan(new StyleSpan(1), indexOf$default, str2.length() + indexOf$default, 0);
        return spannableString;
    }
}
