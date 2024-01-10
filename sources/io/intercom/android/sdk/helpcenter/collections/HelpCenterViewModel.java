package io.intercom.android.sdk.helpcenter.collections;

import android.content.Context;
import android.content.res.Configuration;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow;
import io.intercom.android.sdk.helpcenter.collections.CollectionListRow;
import io.intercom.android.sdk.helpcenter.collections.CollectionViewState;
import io.intercom.android.sdk.helpcenter.sections.HelpCenterArticle;
import io.intercom.android.sdk.helpcenter.sections.HelpCenterCollectionContent;
import io.intercom.android.sdk.helpcenter.sections.HelpCenterSection;
import io.intercom.android.sdk.helpcenter.utils.HelpCenterEligibilityChecker;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.m5.components.ErrorState;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.models.events.ConfigUpdateEvent;
import io.intercom.android.sdk.utilities.ContextLocaliser;
import io.intercom.android.sdk.utilities.extensions.AppConfigExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 N2\u00020\u0001:\u0001NBK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0007J\u0016\u00101\u001a\u00020\u001e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020.03H\u0002J\u0016\u00104\u001a\u00020.2\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\t06J\u000e\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020\tJ\b\u00109\u001a\u00020 H\u0002J\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;J\u000e\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020\tJ\b\u0010?\u001a\u00020.H\u0014J\u0019\u0010@\u001a\u00020.2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0002\u0010CJ\u0019\u0010D\u001a\u00020.2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0002\u0010CJ\b\u0010E\u001a\u00020 H\u0002J\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010I\u001a\u00020JH\u0002J\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020K0G2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020M0GH\u0002R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/HelpCenterViewModel;", "Landroidx/lifecycle/ViewModel;", "helpCenterApi", "Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;", "appConfig", "Lio/intercom/android/sdk/identity/AppConfig;", "metricTracker", "Lio/intercom/android/sdk/metrics/MetricTracker;", "place", "", "helpCenterEligibilityChecker", "Lio/intercom/android/sdk/helpcenter/utils/HelpCenterEligibilityChecker;", "teamPresence", "Lio/intercom/android/sdk/models/TeamPresence;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "bus", "Lcom/squareup/otto/Bus;", "(Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;Lio/intercom/android/sdk/identity/AppConfig;Lio/intercom/android/sdk/metrics/MetricTracker;Ljava/lang/String;Lio/intercom/android/sdk/helpcenter/utils/HelpCenterEligibilityChecker;Lio/intercom/android/sdk/models/TeamPresence;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/squareup/otto/Bus;)V", "_effect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/intercom/android/sdk/helpcenter/collections/HelpCenterEffects;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState;", "effect", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "genericError", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Error;", "hasClickedAtLeastOneArticle", "", "isPartialHelpCenterLoaded", "notFoundError", "searchBrowseTeamPresenceState", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "getSearchBrowseTeamPresenceState", "()Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState$TeamPresenceState;", "searchBrowseTeamPresenceState$delegate", "Lkotlin/Lazy;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "configUpdated", "", "event", "Lio/intercom/android/sdk/models/events/ConfigUpdateEvent;", "errorWithRetry", "onClick", "Lkotlin/Function0;", "fetchCollections", "collectionIds", "", "fetchSingleCollection", "collectionId", "isFromSearchBrowse", "localizedContext", "Landroid/content/Context;", "context", "onArticleClicked", "articleId", "onCleared", "sendFailedCollectionListMetric", "errorCode", "", "(Ljava/lang/Integer;)V", "sendFailedSingleCollectionMetric", "shouldAddSendMessageRow", "transformToUiModel", "", "Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow;", "networkResponse", "Lio/intercom/android/sdk/helpcenter/sections/HelpCenterCollectionContent;", "Lio/intercom/android/sdk/helpcenter/collections/CollectionListRow$CollectionRow;", "body", "Lio/intercom/android/sdk/helpcenter/collections/HelpCenterCollection;", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterViewModel.kt */
public final class HelpCenterViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final MutableSharedFlow<HelpCenterEffects> _effect;
    /* access modifiers changed from: private */
    public final MutableStateFlow<CollectionViewState> _state;
    /* access modifiers changed from: private */
    public final AppConfig appConfig;
    private final Bus bus;
    private final CoroutineDispatcher dispatcher;
    private final SharedFlow<HelpCenterEffects> effect;
    /* access modifiers changed from: private */
    public final CollectionViewState.Error genericError;
    /* access modifiers changed from: private */
    public boolean hasClickedAtLeastOneArticle;
    /* access modifiers changed from: private */
    public final HelpCenterApi helpCenterApi;
    private final HelpCenterEligibilityChecker helpCenterEligibilityChecker;
    /* access modifiers changed from: private */
    public boolean isPartialHelpCenterLoaded;
    /* access modifiers changed from: private */
    public final MetricTracker metricTracker;
    /* access modifiers changed from: private */
    public final CollectionViewState.Error notFoundError;
    /* access modifiers changed from: private */
    public final String place;
    private final Lazy searchBrowseTeamPresenceState$delegate;
    private final StateFlow<CollectionViewState> state;
    /* access modifiers changed from: private */
    public final TeamPresence teamPresence;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HelpCenterViewModel(io.intercom.android.sdk.helpcenter.api.HelpCenterApi r12, io.intercom.android.sdk.identity.AppConfig r13, io.intercom.android.sdk.metrics.MetricTracker r14, java.lang.String r15, io.intercom.android.sdk.helpcenter.utils.HelpCenterEligibilityChecker r16, io.intercom.android.sdk.models.TeamPresence r17, kotlinx.coroutines.CoroutineDispatcher r18, com.squareup.otto.Bus r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 16
            if (r1 == 0) goto L_0x000a
            io.intercom.android.sdk.helpcenter.utils.HelpCenterEligibilityChecker r1 = io.intercom.android.sdk.helpcenter.utils.HelpCenterEligibilityChecker.INSTANCE
            r7 = r1
            goto L_0x000c
        L_0x000a:
            r7 = r16
        L_0x000c:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0016
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
            r9 = r1
            goto L_0x0018
        L_0x0016:
            r9 = r18
        L_0x0018:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x002b
            io.intercom.android.sdk.Injector r0 = io.intercom.android.sdk.Injector.get()
            com.squareup.otto.Bus r0 = r0.getBus()
            java.lang.String r1 = "get().bus"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r10 = r0
            goto L_0x002d
        L_0x002b:
            r10 = r19
        L_0x002d:
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r8 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel.<init>(io.intercom.android.sdk.helpcenter.api.HelpCenterApi, io.intercom.android.sdk.identity.AppConfig, io.intercom.android.sdk.metrics.MetricTracker, java.lang.String, io.intercom.android.sdk.helpcenter.utils.HelpCenterEligibilityChecker, io.intercom.android.sdk.models.TeamPresence, kotlinx.coroutines.CoroutineDispatcher, com.squareup.otto.Bus, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public HelpCenterViewModel(HelpCenterApi helpCenterApi2, AppConfig appConfig2, MetricTracker metricTracker2, String str, HelpCenterEligibilityChecker helpCenterEligibilityChecker2, TeamPresence teamPresence2, CoroutineDispatcher coroutineDispatcher, Bus bus2) {
        Intrinsics.checkNotNullParameter(helpCenterApi2, "helpCenterApi");
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(metricTracker2, "metricTracker");
        Intrinsics.checkNotNullParameter(str, "place");
        Intrinsics.checkNotNullParameter(helpCenterEligibilityChecker2, "helpCenterEligibilityChecker");
        Intrinsics.checkNotNullParameter(teamPresence2, "teamPresence");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(bus2, "bus");
        this.helpCenterApi = helpCenterApi2;
        this.appConfig = appConfig2;
        this.metricTracker = metricTracker2;
        this.place = str;
        this.helpCenterEligibilityChecker = helpCenterEligibilityChecker2;
        this.teamPresence = teamPresence2;
        this.dispatcher = coroutineDispatcher;
        this.bus = bus2;
        MutableStateFlow<CollectionViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionViewState.Initial.INSTANCE);
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
        boolean z = false;
        MutableSharedFlow<HelpCenterEffects> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._effect = MutableSharedFlow$default;
        this.effect = FlowKt__ShareKt.shareIn$default(MutableSharedFlow$default, ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getEagerly(), 0, 4, (Object) null);
        this.genericError = new CollectionViewState.Error(new ErrorState.WithoutCTA(0, 0, (Integer) null, 7, (DefaultConstructorMarker) null));
        this.notFoundError = new CollectionViewState.Error(new ErrorState.WithoutCTA(0, R.string.intercom_page_not_found, (Integer) null, 5, (DefaultConstructorMarker) null));
        this.searchBrowseTeamPresenceState$delegate = LazyKt.lazy(new HelpCenterViewModel$searchBrowseTeamPresenceState$2(this));
        if (this.place.length() > 0 ? true : z) {
            this.metricTracker.openedNativeHelpCenter(this.place, (String) null);
        }
        this.bus.register(this);
    }

    public final StateFlow<CollectionViewState> getState() {
        return this.state;
    }

    public final SharedFlow<HelpCenterEffects> getEffect() {
        return this.effect;
    }

    /* access modifiers changed from: private */
    public final CollectionViewState.Error errorWithRetry(Function0<Unit> function0) {
        return new CollectionViewState.Error(new ErrorState.WithCTA(0, 0, (Integer) null, 0, function0, 15, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public final ArticleViewState.TeamPresenceState getSearchBrowseTeamPresenceState() {
        return (ArticleViewState.TeamPresenceState) this.searchBrowseTeamPresenceState$delegate.getValue();
    }

    public final Context localizedContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(ContextLocaliser.convertToLocale(this.appConfig.getHelpCenterLocale()));
        Context createConfigurationContext = context.createConfigurationContext(configuration);
        Intrinsics.checkNotNullExpressionValue(createConfigurationContext, "context.createConfigurat…t(localisedConfiguration)");
        return createConfigurationContext;
    }

    public static /* synthetic */ void fetchCollections$default(HelpCenterViewModel helpCenterViewModel, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = SetsKt.emptySet();
        }
        helpCenterViewModel.fetchCollections(set);
    }

    public final void fetchCollections(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "collectionIds");
        if (!this.helpCenterEligibilityChecker.isEligibleUser()) {
            this._state.setValue(this.genericError);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new HelpCenterViewModel$fetchCollections$1(this, set, (Continuation<? super HelpCenterViewModel$fetchCollections$1>) null), 2, (Object) null);
        }
    }

    static /* synthetic */ void sendFailedCollectionListMetric$default(HelpCenterViewModel helpCenterViewModel, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        helpCenterViewModel.sendFailedCollectionListMetric(num);
    }

    /* access modifiers changed from: private */
    public final void sendFailedCollectionListMetric(Integer num) {
        this.metricTracker.failedHelpCenter("help_center", MetricTracker.Place.COLLECTION_LIST, num != null ? num.toString() : null, isFromSearchBrowse());
    }

    /* access modifiers changed from: private */
    public final List<CollectionListRow.CollectionRow> transformToUiModel(List<HelpCenterCollection> list) {
        Iterable<HelpCenterCollection> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (HelpCenterCollection helpCenterCollection : iterable) {
            String id = helpCenterCollection.getId();
            String title = helpCenterCollection.getTitle();
            int i = 0;
            if (helpCenterCollection.getSummary().length() == 0) {
                i = 8;
            }
            arrayList.add(new CollectionListRow.CollectionRow(id, title, i, helpCenterCollection.getSummary(), helpCenterCollection.getArticlesCount()));
        }
        return (List) arrayList;
    }

    public final void fetchSingleCollection(String str) {
        Intrinsics.checkNotNullParameter(str, "collectionId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new HelpCenterViewModel$fetchSingleCollection$1(this, str, (Continuation<? super HelpCenterViewModel$fetchSingleCollection$1>) null), 2, (Object) null);
    }

    public final void onArticleClicked(String str) {
        Intrinsics.checkNotNullParameter(str, "articleId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new HelpCenterViewModel$onArticleClicked$1(this, str, (Continuation<? super HelpCenterViewModel$onArticleClicked$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final boolean shouldAddSendMessageRow() {
        return AppConfigExtensionsKt.canStartNewConversation(this.appConfig) && this.hasClickedAtLeastOneArticle;
    }

    static /* synthetic */ void sendFailedSingleCollectionMetric$default(HelpCenterViewModel helpCenterViewModel, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        helpCenterViewModel.sendFailedSingleCollectionMetric(num);
    }

    /* access modifiers changed from: private */
    public final void sendFailedSingleCollectionMetric(Integer num) {
        this.metricTracker.failedHelpCenter("help_center", MetricTracker.Place.ARTICLE_LIST, num != null ? num.toString() : null, isFromSearchBrowse());
    }

    /* access modifiers changed from: private */
    public final List<ArticleSectionRow> transformToUiModel(HelpCenterCollectionContent helpCenterCollectionContent) {
        List<ArticleSectionRow> arrayList = new ArrayList<>();
        Iterable<HelpCenterArticle> helpCenterArticles = helpCenterCollectionContent.getHelpCenterArticles();
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(helpCenterArticles, 10));
        for (HelpCenterArticle helpCenterArticle : helpCenterArticles) {
            arrayList2.add(new ArticleSectionRow.ArticleRow(helpCenterArticle.getArticleId(), helpCenterArticle.getTitle()));
        }
        arrayList.addAll((List) arrayList2);
        for (HelpCenterSection helpCenterSection : helpCenterCollectionContent.getHelpCenterSections()) {
            arrayList.add(new ArticleSectionRow.SectionRow(helpCenterSection.getTitle()));
            Iterable<HelpCenterArticle> helpCenterArticles2 = helpCenterSection.getHelpCenterArticles();
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(helpCenterArticles2, 10));
            for (HelpCenterArticle helpCenterArticle2 : helpCenterArticles2) {
                arrayList3.add(new ArticleSectionRow.ArticleRow(helpCenterArticle2.getArticleId(), helpCenterArticle2.getTitle()));
            }
            arrayList.addAll((List) arrayList3);
        }
        return arrayList;
    }

    @Subscribe
    public final void configUpdated(ConfigUpdateEvent configUpdateEvent) {
        CollectionViewState collectionViewState;
        Intrinsics.checkNotNullParameter(configUpdateEvent, NotificationCompat.CATEGORY_EVENT);
        CollectionViewState value = this._state.getValue();
        if (value instanceof CollectionViewState.Content) {
            MutableStateFlow<CollectionViewState> mutableStateFlow = this._state;
            if (shouldAddSendMessageRow()) {
                collectionViewState = ((CollectionViewState.Content) value).copyWithSingleSendMessageRow(getSearchBrowseTeamPresenceState());
            } else {
                collectionViewState = ((CollectionViewState.Content) value).copyWithoutSendMessageRow();
            }
            mutableStateFlow.setValue(collectionViewState);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isFromSearchBrowse() {
        return Intrinsics.areEqual((Object) this.place, (Object) "search_browse");
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.bus.unregister(this);
    }

    @Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0004*\u0001\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/intercom/android/sdk/helpcenter/collections/HelpCenterViewModel$Companion;", "", "()V", "create", "Lio/intercom/android/sdk/helpcenter/collections/HelpCenterViewModel;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "helpCenterApi", "Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;", "place", "", "factory", "io/intercom/android/sdk/helpcenter/collections/HelpCenterViewModel$Companion$factory$1", "metricContext", "(Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;Ljava/lang/String;)Lio/intercom/android/sdk/helpcenter/collections/HelpCenterViewModel$Companion$factory$1;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HelpCenterViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HelpCenterViewModel create(ViewModelStoreOwner viewModelStoreOwner, HelpCenterApi helpCenterApi, String str) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
            Intrinsics.checkNotNullParameter(helpCenterApi, "helpCenterApi");
            Intrinsics.checkNotNullParameter(str, "place");
            return (HelpCenterViewModel) new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) factory(helpCenterApi, str)).get(HelpCenterViewModel.class);
        }

        private final HelpCenterViewModel$Companion$factory$1 factory(HelpCenterApi helpCenterApi, String str) {
            return new HelpCenterViewModel$Companion$factory$1(helpCenterApi, str);
        }
    }
}
