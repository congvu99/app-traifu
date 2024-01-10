package io.intercom.android.sdk.helpcenter.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.databinding.IntercomRowComposeViewBinding;
import io.intercom.android.sdk.helpcenter.search.ArticleSearchResultRow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u0000 \u001b2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0004\u001b\u001c\u001d\u001eB\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u001c\u0010\u0012\u001a\u00020\u00062\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0014\u0010\u0018\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001aR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter$SearchResultBaseViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "searchResults", "", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow;", "clearData", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateResults", "results", "", "Companion", "SearchResultBaseViewHolder", "SearchResultViewHolder", "TeammateHelpViewHolder", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SearchResultAdapter.kt */
public final class SearchResultAdapter extends RecyclerView.Adapter<SearchResultBaseViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SEARCH_RESULT = 1;
    public static final int TEAMMATE_HELP = 2;
    private final Function1<String, Unit> onClick;
    private final List<ArticleSearchResultRow> searchResults = new ArrayList();

    public final Function1<String, Unit> getOnClick() {
        return this.onClick;
    }

    public SearchResultAdapter(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onClick");
        this.onClick = function1;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter$SearchResultBaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter;Landroid/view/View;)V", "bind", "", "articleSearchResultRow", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SearchResultAdapter.kt */
    public abstract class SearchResultBaseViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ SearchResultAdapter this$0;

        public abstract void bind(ArticleSearchResultRow articleSearchResultRow);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SearchResultBaseViewHolder(SearchResultAdapter searchResultAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = searchResultAdapter;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter$TeammateHelpViewHolder;", "Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter$SearchResultBaseViewHolder;", "Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter;", "binding", "Lio/intercom/android/sdk/databinding/IntercomRowComposeViewBinding;", "(Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter;Lio/intercom/android/sdk/databinding/IntercomRowComposeViewBinding;)V", "getBinding", "()Lio/intercom/android/sdk/databinding/IntercomRowComposeViewBinding;", "bind", "", "articleSearchResultRow", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SearchResultAdapter.kt */
    public final class TeammateHelpViewHolder extends SearchResultBaseViewHolder {
        private final IntercomRowComposeViewBinding binding;
        final /* synthetic */ SearchResultAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public TeammateHelpViewHolder(io.intercom.android.sdk.helpcenter.search.SearchResultAdapter r3, io.intercom.android.sdk.databinding.IntercomRowComposeViewBinding r4) {
            /*
                r2 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r2.this$0 = r3
                androidx.compose.ui.platform.ComposeView r0 = r4.getRoot()
                java.lang.String r1 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                android.view.View r0 = (android.view.View) r0
                r2.<init>(r3, r0)
                r2.binding = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.helpcenter.search.SearchResultAdapter.TeammateHelpViewHolder.<init>(io.intercom.android.sdk.helpcenter.search.SearchResultAdapter, io.intercom.android.sdk.databinding.IntercomRowComposeViewBinding):void");
        }

        public final IntercomRowComposeViewBinding getBinding() {
            return this.binding;
        }

        public void bind(ArticleSearchResultRow articleSearchResultRow) {
            Intrinsics.checkNotNullParameter(articleSearchResultRow, "articleSearchResultRow");
            this.binding.composeView.setContent(ComposableLambdaKt.composableLambdaInstance(133601252, true, new SearchResultAdapter$TeammateHelpViewHolder$bind$1$1$1((ArticleSearchResultRow.TeammateHelpRow) articleSearchResultRow)));
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter$SearchResultViewHolder;", "Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter$SearchResultBaseViewHolder;", "Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter;", "binding", "Lio/intercom/android/sdk/databinding/IntercomRowComposeViewBinding;", "(Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter;Lio/intercom/android/sdk/databinding/IntercomRowComposeViewBinding;)V", "getBinding", "()Lio/intercom/android/sdk/databinding/IntercomRowComposeViewBinding;", "bind", "", "articleSearchResultRow", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SearchResultAdapter.kt */
    public final class SearchResultViewHolder extends SearchResultBaseViewHolder {
        private final IntercomRowComposeViewBinding binding;
        final /* synthetic */ SearchResultAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public SearchResultViewHolder(io.intercom.android.sdk.helpcenter.search.SearchResultAdapter r3, io.intercom.android.sdk.databinding.IntercomRowComposeViewBinding r4) {
            /*
                r2 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r2.this$0 = r3
                androidx.compose.ui.platform.ComposeView r0 = r4.getRoot()
                java.lang.String r1 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                android.view.View r0 = (android.view.View) r0
                r2.<init>(r3, r0)
                r2.binding = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.helpcenter.search.SearchResultAdapter.SearchResultViewHolder.<init>(io.intercom.android.sdk.helpcenter.search.SearchResultAdapter, io.intercom.android.sdk.databinding.IntercomRowComposeViewBinding):void");
        }

        public final IntercomRowComposeViewBinding getBinding() {
            return this.binding;
        }

        public void bind(ArticleSearchResultRow articleSearchResultRow) {
            Intrinsics.checkNotNullParameter(articleSearchResultRow, "articleSearchResultRow");
            this.binding.composeView.setContent(ComposableLambdaKt.composableLambdaInstance(184851526, true, new SearchResultAdapter$SearchResultViewHolder$bind$1$1$1((ArticleSearchResultRow.ArticleResultRow) articleSearchResultRow, this.this$0)));
        }
    }

    public final void updateResults(List<? extends ArticleSearchResultRow> list) {
        Intrinsics.checkNotNullParameter(list, "results");
        this.searchResults.clear();
        this.searchResults.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearData() {
        this.searchResults.clear();
        notifyDataSetChanged();
    }

    public SearchResultBaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == 2) {
            IntercomRowComposeViewBinding inflate = IntercomRowComposeViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
            return new TeammateHelpViewHolder(this, inflate);
        }
        IntercomRowComposeViewBinding inflate2 = IntercomRowComposeViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(LayoutInflater.f….context), parent, false)");
        return new SearchResultViewHolder(this, inflate2);
    }

    public int getItemCount() {
        return this.searchResults.size();
    }

    public void onBindViewHolder(SearchResultBaseViewHolder searchResultBaseViewHolder, int i) {
        Intrinsics.checkNotNullParameter(searchResultBaseViewHolder, "holder");
        searchResultBaseViewHolder.bind(this.searchResults.get(i));
    }

    public int getItemViewType(int i) {
        ArticleSearchResultRow articleSearchResultRow = this.searchResults.get(i);
        if (articleSearchResultRow instanceof ArticleSearchResultRow.ArticleResultRow) {
            return 1;
        }
        if (articleSearchResultRow instanceof ArticleSearchResultRow.TeammateHelpRow) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/SearchResultAdapter$Companion;", "", "()V", "SEARCH_RESULT", "", "TEAMMATE_HELP", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SearchResultAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
