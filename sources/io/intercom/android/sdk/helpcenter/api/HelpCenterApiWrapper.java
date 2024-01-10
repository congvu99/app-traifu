package io.intercom.android.sdk.helpcenter.api;

import io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013J\f\u0010\u0017\u001a\u00020\b*\u00020\bH\u0002¨\u0006\u0018"}, d2 = {"Lio/intercom/android/sdk/helpcenter/api/HelpCenterApiWrapper;", "", "()V", "fetchHelpCenterCollection", "", "metricTracker", "Lio/intercom/android/sdk/metrics/MetricTracker;", "collectionId", "", "collectionContentRequestCallback", "Lio/intercom/android/sdk/helpcenter/api/CollectionContentRequestCallback;", "fetchHelpCenterCollections", "collectionRequestCallback", "Lio/intercom/android/sdk/helpcenter/api/CollectionRequestCallback;", "fetchHelpCenterResultsForSearchTerm", "searchTerm", "searchRequestCallback", "Lio/intercom/android/sdk/helpcenter/api/SearchRequestCallback;", "transformSearchResponse", "", "Lio/intercom/android/sdk/helpcenter/api/HelpCenterArticleSearchResult;", "response", "Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse;", "removeHighlightTags", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterApiWrapper.kt */
public final class HelpCenterApiWrapper {
    public static final HelpCenterApiWrapper INSTANCE = new HelpCenterApiWrapper();

    private HelpCenterApiWrapper() {
    }

    public final void fetchHelpCenterCollections(MetricTracker metricTracker, CollectionRequestCallback collectionRequestCallback) {
        Intrinsics.checkNotNullParameter(metricTracker, "metricTracker");
        Intrinsics.checkNotNullParameter(collectionRequestCallback, "collectionRequestCallback");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new HelpCenterApiWrapper$fetchHelpCenterCollections$1(metricTracker, collectionRequestCallback, (Continuation<? super HelpCenterApiWrapper$fetchHelpCenterCollections$1>) null), 2, (Object) null);
    }

    public final void fetchHelpCenterResultsForSearchTerm(MetricTracker metricTracker, String str, SearchRequestCallback searchRequestCallback) {
        Intrinsics.checkNotNullParameter(metricTracker, "metricTracker");
        Intrinsics.checkNotNullParameter(str, "searchTerm");
        Intrinsics.checkNotNullParameter(searchRequestCallback, "searchRequestCallback");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new HelpCenterApiWrapper$fetchHelpCenterResultsForSearchTerm$1(metricTracker, str, searchRequestCallback, (Continuation<? super HelpCenterApiWrapper$fetchHelpCenterResultsForSearchTerm$1>) null), 2, (Object) null);
    }

    public final void fetchHelpCenterCollection(MetricTracker metricTracker, String str, CollectionContentRequestCallback collectionContentRequestCallback) {
        Intrinsics.checkNotNullParameter(metricTracker, "metricTracker");
        Intrinsics.checkNotNullParameter(str, "collectionId");
        Intrinsics.checkNotNullParameter(collectionContentRequestCallback, "collectionContentRequestCallback");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new HelpCenterApiWrapper$fetchHelpCenterCollection$1(metricTracker, str, collectionContentRequestCallback, (Continuation<? super HelpCenterApiWrapper$fetchHelpCenterCollection$1>) null), 2, (Object) null);
    }

    public final List<HelpCenterArticleSearchResult> transformSearchResponse(List<HelpCenterArticleSearchResponse> list) {
        String str;
        Intrinsics.checkNotNullParameter(list, "response");
        Iterable<HelpCenterArticleSearchResponse> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (HelpCenterArticleSearchResponse helpCenterArticleSearchResponse : iterable) {
            CharSequence title = helpCenterArticleSearchResponse.getHighlight().getTitle();
            if (title == null || title.length() == 0) {
                str = helpCenterArticleSearchResponse.getTitle();
            } else {
                str = helpCenterArticleSearchResponse.getHighlight().getTitle();
            }
            String summary = helpCenterArticleSearchResponse.getHighlight().getSummary();
            String str2 = "";
            if (summary == null) {
                summary = str2;
            }
            String articleId = helpCenterArticleSearchResponse.getArticleId();
            String removeHighlightTags = INSTANCE.removeHighlightTags(str);
            String summary2 = helpCenterArticleSearchResponse.getSummary();
            if (summary2 != null) {
                str2 = summary2;
            }
            arrayList.add(new HelpCenterArticleSearchResult(articleId, removeHighlightTags, str2, INSTANCE.removeHighlightTags(summary)));
        }
        return (List) arrayList;
    }

    private final String removeHighlightTags(String str) {
        return StringsKt.replace$default(StringsKt.replace$default(str, "<highlight>", "", false, 4, (Object) null), "</highlight>", "", false, 4, (Object) null);
    }
}
