package io.intercom.android.sdk.helpcenter.search;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import io.intercom.android.sdk.helpcenter.component.TeammateHelpKt;
import io.intercom.android.sdk.helpcenter.search.ArticleSearchResultRow;
import io.intercom.android.sdk.helpcenter.search.ArticleSearchState;
import io.intercom.android.sdk.helpcenter.search.HelpCenterArticleSearchResponse;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.models.events.NewConversationEvent;
import io.intercom.android.sdk.utilities.extensions.AppConfigExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 32\u00020\u0001:\u00013BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\b\u0010!\u001a\u00020\u001eH\u0014J\u0016\u0010\"\u001a\u00020\u001e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160$H\u0007J\u0006\u0010%\u001a\u00020\u001eJ\u0019\u0010&\u001a\u00020\u001e2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u000bH\u0002J\b\u0010+\u001a\u00020,H\u0002J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010.H\u0002J\u0006\u00102\u001a\u00020\u001eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/ArticleSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "helpCenterApi", "Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;", "appConfig", "Lio/intercom/android/sdk/identity/AppConfig;", "teamPresence", "Lio/intercom/android/sdk/models/TeamPresence;", "metricTracker", "Lio/intercom/android/sdk/metrics/MetricTracker;", "isFromSearchBrowse", "", "bus", "Lcom/squareup/otto/Bus;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;Lio/intercom/android/sdk/identity/AppConfig;Lio/intercom/android/sdk/models/TeamPresence;Lio/intercom/android/sdk/metrics/MetricTracker;ZLcom/squareup/otto/Bus;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchState;", "hasClickedAtLeastOneArticle", "lastSearchedInput", "", "searchInput", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "newConversation", "", "event", "Lio/intercom/android/sdk/models/events/NewConversationEvent;", "onCleared", "searchForArticles", "textChanged", "Lkotlinx/coroutines/flow/Flow;", "sendClickOnSearchResultMetric", "sendFailedSearchMetric", "errorCode", "", "(Ljava/lang/Integer;)V", "shouldAddSendMessageRow", "teammateHelpRow", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow$TeammateHelpRow;", "transformToUiModel", "", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow;", "searchResponses", "Lio/intercom/android/sdk/helpcenter/search/HelpCenterArticleSearchResponse;", "updateTeammateHelpRow", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleSearchViewModel.kt */
public final class ArticleSearchViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final MutableStateFlow<ArticleSearchState> _state;
    /* access modifiers changed from: private */
    public final AppConfig appConfig;
    private final Bus bus;
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    public boolean hasClickedAtLeastOneArticle;
    /* access modifiers changed from: private */
    public final HelpCenterApi helpCenterApi;
    /* access modifiers changed from: private */
    public final boolean isFromSearchBrowse;
    /* access modifiers changed from: private */
    public String lastSearchedInput;
    /* access modifiers changed from: private */
    public final MetricTracker metricTracker;
    /* access modifiers changed from: private */
    public final MutableSharedFlow<String> searchInput;
    private final StateFlow<ArticleSearchState> state;
    /* access modifiers changed from: private */
    public final TeamPresence teamPresence;

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ArticleSearchViewModel(io.intercom.android.sdk.helpcenter.api.HelpCenterApi r10, io.intercom.android.sdk.identity.AppConfig r11, io.intercom.android.sdk.models.TeamPresence r12, io.intercom.android.sdk.metrics.MetricTracker r13, boolean r14, com.squareup.otto.Bus r15, kotlinx.coroutines.CoroutineDispatcher r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r9 = this;
            r0 = r17 & 16
            if (r0 == 0) goto L_0x0007
            r0 = 0
            r6 = 0
            goto L_0x0008
        L_0x0007:
            r6 = r14
        L_0x0008:
            r0 = r17 & 64
            if (r0 == 0) goto L_0x0012
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
            r8 = r0
            goto L_0x0014
        L_0x0012:
            r8 = r16
        L_0x0014:
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel.<init>(io.intercom.android.sdk.helpcenter.api.HelpCenterApi, io.intercom.android.sdk.identity.AppConfig, io.intercom.android.sdk.models.TeamPresence, io.intercom.android.sdk.metrics.MetricTracker, boolean, com.squareup.otto.Bus, kotlinx.coroutines.CoroutineDispatcher, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public ArticleSearchViewModel(HelpCenterApi helpCenterApi2, AppConfig appConfig2, TeamPresence teamPresence2, MetricTracker metricTracker2, boolean z, Bus bus2, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(helpCenterApi2, "helpCenterApi");
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(teamPresence2, "teamPresence");
        Intrinsics.checkNotNullParameter(metricTracker2, "metricTracker");
        Intrinsics.checkNotNullParameter(bus2, "bus");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.helpCenterApi = helpCenterApi2;
        this.appConfig = appConfig2;
        this.teamPresence = teamPresence2;
        this.metricTracker = metricTracker2;
        this.isFromSearchBrowse = z;
        this.bus = bus2;
        this.dispatcher = coroutineDispatcher;
        MutableStateFlow<ArticleSearchState> MutableStateFlow = StateFlowKt.MutableStateFlow(ArticleSearchState.Initial.INSTANCE);
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
        this.lastSearchedInput = "";
        this.searchInput = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 2, (Object) null);
        this.bus.register(this);
    }

    public final StateFlow<ArticleSearchState> getState() {
        return this.state;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel$1", f = "ArticleSearchViewModel.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel$1  reason: invalid class name */
    /* compiled from: ArticleSearchViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ArticleSearchViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ArticleSearchViewModel articleSearchViewModel = this.this$0;
                this.label = 1;
                if (new ArticleSearchViewModel$1$invokeSuspend$$inlined$map$2(new ArticleSearchViewModel$1$invokeSuspend$$inlined$map$1(FlowKt.transformLatest(this.this$0.searchInput, new ArticleSearchViewModel$1$invokeSuspend$$inlined$flatMapLatest$1((Continuation) null, this.this$0)), this.this$0), this.this$0).collect(new FlowCollector<ArticleSearchState>() {
                    public final Object emit(ArticleSearchState articleSearchState, Continuation<? super Unit> continuation) {
                        articleSearchViewModel._state.setValue(articleSearchState);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.bus.unregister(this);
    }

    public final void searchForArticles(Flow<String> flow) {
        Intrinsics.checkNotNullParameter(flow, "textChanged");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new ArticleSearchViewModel$searchForArticles$1(flow, this, (Continuation<? super ArticleSearchViewModel$searchForArticles$1>) null), 2, (Object) null);
    }

    @Subscribe
    public final void newConversation(NewConversationEvent newConversationEvent) {
        Intrinsics.checkNotNullParameter(newConversationEvent, NotificationCompat.CATEGORY_EVENT);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new ArticleSearchViewModel$newConversation$1(this, (Continuation<? super ArticleSearchViewModel$newConversation$1>) null), 2, (Object) null);
    }

    public final void updateTeammateHelpRow() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new ArticleSearchViewModel$updateTeammateHelpRow$1(this, (Continuation<? super ArticleSearchViewModel$updateTeammateHelpRow$1>) null), 2, (Object) null);
    }

    public final void sendClickOnSearchResultMetric() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new ArticleSearchViewModel$sendClickOnSearchResultMetric$1(this, (Continuation<? super ArticleSearchViewModel$sendClickOnSearchResultMetric$1>) null), 2, (Object) null);
    }

    static /* synthetic */ void sendFailedSearchMetric$default(ArticleSearchViewModel articleSearchViewModel, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        articleSearchViewModel.sendFailedSearchMetric(num);
    }

    /* access modifiers changed from: private */
    public final void sendFailedSearchMetric(Integer num) {
        this.metricTracker.failedHelpCenter("help_center", "search_results", num != null ? num.toString() : null, this.isFromSearchBrowse);
    }

    /* access modifiers changed from: private */
    public final List<ArticleSearchResultRow> transformToUiModel(List<HelpCenterArticleSearchResponse> list) {
        Iterable<HelpCenterArticleSearchResponse> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (HelpCenterArticleSearchResponse helpCenterArticleSearchResponse : iterable) {
            HelpCenterArticleSearchResponse.Highlight highlight = helpCenterArticleSearchResponse.getHighlight();
            String articleId = helpCenterArticleSearchResponse.getArticleId();
            CharSequence title = highlight.getTitle();
            boolean z = true;
            int i = 0;
            String title2 = title == null || title.length() == 0 ? helpCenterArticleSearchResponse.getTitle() : highlight.getTitle();
            String summary = highlight.getSummary();
            if (summary == null) {
                summary = "";
            }
            CharSequence summary2 = highlight.getSummary();
            if (!(summary2 == null || summary2.length() == 0)) {
                z = false;
            }
            if (z) {
                i = 8;
            }
            arrayList.add(new ArticleSearchResultRow.ArticleResultRow(articleId, title2, summary, i));
        }
        List<ArticleSearchResultRow> mutableList = CollectionsKt.toMutableList((List) arrayList);
        if (shouldAddSendMessageRow() && this.hasClickedAtLeastOneArticle) {
            mutableList.add(teammateHelpRow());
        }
        return mutableList;
    }

    /* access modifiers changed from: private */
    public final ArticleSearchResultRow.TeammateHelpRow teammateHelpRow() {
        return new ArticleSearchResultRow.TeammateHelpRow(TeammateHelpKt.computeViewState("", ArticleViewState.TeamPresenceState.Companion.getDefaultTeamPresenceState(), this.appConfig, this.teamPresence, "search_results", this.isFromSearchBrowse));
    }

    /* access modifiers changed from: private */
    public final boolean shouldAddSendMessageRow() {
        return AppConfigExtensionsKt.canStartNewConversation(this.appConfig);
    }

    @Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003*\u0001\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lio/intercom/android/sdk/helpcenter/search/ArticleSearchViewModel$Companion;", "", "()V", "create", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchViewModel;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "helpCenterApi", "Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;", "isFromSearchBrowse", "", "factory", "io/intercom/android/sdk/helpcenter/search/ArticleSearchViewModel$Companion$factory$1", "(Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;Z)Lio/intercom/android/sdk/helpcenter/search/ArticleSearchViewModel$Companion$factory$1;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleSearchViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArticleSearchViewModel create(ViewModelStoreOwner viewModelStoreOwner, HelpCenterApi helpCenterApi, boolean z) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
            Intrinsics.checkNotNullParameter(helpCenterApi, "helpCenterApi");
            return (ArticleSearchViewModel) new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) factory(helpCenterApi, z)).get(ArticleSearchViewModel.class);
        }

        private final ArticleSearchViewModel$Companion$factory$1 factory(HelpCenterApi helpCenterApi, boolean z) {
            return new ArticleSearchViewModel$Companion$factory$1(helpCenterApi, z);
        }
    }
}
