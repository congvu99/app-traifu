package io.intercom.android.sdk.helpcenter.api;

import io.intercom.android.sdk.helpcenter.collections.HelpCenterCollection;
import io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse;
import io.intercom.android.sdk.helpcenter.sections.HelpCenterCollectionContent;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0014\b\u0003\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ7\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\b2\u0014\b\u0003\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\rJa\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\b2\b\b\u0003\u0010\u0014\u001a\u00020\u00152\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0014\b\u0003\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017JI\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00040\u00032\b\b\u0001\u0010\u001a\u001a\u00020\b2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0014\b\u0003\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;", "", "fetchCollectionList", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse;", "", "Lio/intercom/android/sdk/helpcenter/collections/HelpCenterCollection;", "options", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchSectionsList", "Lio/intercom/android/sdk/helpcenter/sections/HelpCenterCollectionContent;", "id", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reactToArticle", "", "articleId", "reactionIndex", "", "articleContentId", "allowAutoResponses", "", "articleSource", "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchForArticles", "Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse;", "searchPhrase", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterApi.kt */
public interface HelpCenterApi {
    @POST("help_center/collections")
    Object fetchCollectionList(@Body Map<String, String> map, Continuation<? super NetworkResponse<? extends List<HelpCenterCollection>>> continuation);

    @POST("help_center/collections/{id}")
    Object fetchSectionsList(@Path("id") String str, @Body Map<String, String> map, Continuation<? super NetworkResponse<HelpCenterCollectionContent>> continuation);

    @POST("articles/{articleId}/react")
    Object reactToArticle(@Path("articleId") String str, @Query("reaction_index") int i, @Query("article_content_id") String str2, @Query("allow_auto_responses") boolean z, @Query("article_source") String str3, @Body Map<String, String> map, Continuation<? super NetworkResponse<Unit>> continuation);

    @POST("help_center/search")
    Object searchForArticles(@Query("phrase") String str, @Query("article_source") String str2, @Body Map<String, String> map, Continuation<? super NetworkResponse<? extends List<HelpCenterArticleSearchResponse>>> continuation);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HelpCenterApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object fetchCollectionList$default(HelpCenterApi helpCenterApi, Map<String, String> map, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    map = HelpCenterApiHelper.INSTANCE.addDefaultOptions();
                }
                return helpCenterApi.fetchCollectionList(map, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchCollectionList");
        }

        public static /* synthetic */ Object fetchSectionsList$default(HelpCenterApi helpCenterApi, String str, Map<String, String> map, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map = HelpCenterApiHelper.INSTANCE.addDefaultOptions();
                }
                return helpCenterApi.fetchSectionsList(str, map, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchSectionsList");
        }

        public static /* synthetic */ Object searchForArticles$default(HelpCenterApi helpCenterApi, String str, String str2, Map<String, String> map, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    map = HelpCenterApiHelper.INSTANCE.addDefaultOptions();
                }
                return helpCenterApi.searchForArticles(str, str2, map, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchForArticles");
        }

        public static /* synthetic */ Object reactToArticle$default(HelpCenterApi helpCenterApi, String str, int i, String str2, boolean z, String str3, Map map, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                return helpCenterApi.reactToArticle(str, i, str2, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? HelpCenterApiHelper.INSTANCE.addDefaultOptions() : map, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reactToArticle");
        }
    }
}
