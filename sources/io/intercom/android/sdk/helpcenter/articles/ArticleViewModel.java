package io.intercom.android.sdk.helpcenter.articles;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.articles.ArticleWebViewListener;
import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import io.intercom.android.sdk.helpcenter.component.TeammateHelpKt;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.models.events.NewConversationEvent;
import io.intercom.android.sdk.utilities.extensions.AppConfigExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.apache.http.HttpStatus;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014BS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0006J\b\u0010!\u001a\u00020\u001fH\u0016J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u001fJ\u0006\u0010$\u001a\u00020\u001fJ\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0007J\b\u0010(\u001a\u00020\u001fH\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\b\u0010*\u001a\u00020\u001fH\u0016J\b\u0010+\u001a\u00020\u001fH\u0014J\u0006\u0010,\u001a\u00020\u001fJ\u0019\u0010-\u001a\u00020\u001f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0002\u00100J \u00101\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u00102\u001a\u00020/H\u0002J\b\u00103\u001a\u00020\u000fH\u0002R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewModel;", "Landroidx/lifecycle/ViewModel;", "Lio/intercom/android/sdk/articles/ArticleWebViewListener;", "helpCenterApi", "Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;", "baseUrl", "", "appConfig", "Lio/intercom/android/sdk/identity/AppConfig;", "teamPresence", "Lio/intercom/android/sdk/models/TeamPresence;", "metricTracker", "Lio/intercom/android/sdk/metrics/MetricTracker;", "metricPlace", "isFromSearchBrowse", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "bus", "Lcom/squareup/otto/Bus;", "(Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;Ljava/lang/String;Lio/intercom/android/sdk/identity/AppConfig;Lio/intercom/android/sdk/models/TeamPresence;Lio/intercom/android/sdk/metrics/MetricTracker;Ljava/lang/String;ZLkotlinx/coroutines/CoroutineDispatcher;Lcom/squareup/otto/Bus;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewState;", "articleContentId", "articleId", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "articleContentIdFetched", "", "value", "articleNotFound", "fragmentLoaded", "happyReactionTapped", "neutralReactionTapped", "newConversation", "event", "Lio/intercom/android/sdk/models/events/NewConversationEvent;", "onArticleFinishedLoading", "onArticleLoadingError", "onArticleStartedLoading", "onCleared", "sadReactionTapped", "sendFailedMetric", "errorCode", "", "(Ljava/lang/Integer;)V", "sendReactionToServer", "reactionIndex", "shouldAddSendMessageRow", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleViewModel.kt */
public final class ArticleViewModel extends ViewModel implements ArticleWebViewListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int HAPPY_SERVER_INDEX = 0;
    public static final int NEUTRAL_SERVER_INDEX = 1;
    public static final int SAD_SERVER_INDEX = 2;
    private final MutableStateFlow<ArticleViewState> _state;
    private final AppConfig appConfig;
    private String articleContentId;
    private String articleId;
    private final String baseUrl;
    private final Bus bus;
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    public final HelpCenterApi helpCenterApi;
    /* access modifiers changed from: private */
    public final boolean isFromSearchBrowse;
    private final MetricTracker metricTracker;
    private final StateFlow<ArticleViewState> state;
    private final TeamPresence teamPresence;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ArticleViewModel(io.intercom.android.sdk.helpcenter.api.HelpCenterApi r13, java.lang.String r14, io.intercom.android.sdk.identity.AppConfig r15, io.intercom.android.sdk.models.TeamPresence r16, io.intercom.android.sdk.metrics.MetricTracker r17, java.lang.String r18, boolean r19, kotlinx.coroutines.CoroutineDispatcher r20, com.squareup.otto.Bus r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r9 = 0
            goto L_0x000b
        L_0x0009:
            r9 = r19
        L_0x000b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0015
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
            r10 = r1
            goto L_0x0017
        L_0x0015:
            r10 = r20
        L_0x0017:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x002a
            io.intercom.android.sdk.Injector r0 = io.intercom.android.sdk.Injector.get()
            com.squareup.otto.Bus r0 = r0.getBus()
            java.lang.String r1 = "get().bus"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r11 = r0
            goto L_0x002c
        L_0x002a:
            r11 = r21
        L_0x002c:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.helpcenter.articles.ArticleViewModel.<init>(io.intercom.android.sdk.helpcenter.api.HelpCenterApi, java.lang.String, io.intercom.android.sdk.identity.AppConfig, io.intercom.android.sdk.models.TeamPresence, io.intercom.android.sdk.metrics.MetricTracker, java.lang.String, boolean, kotlinx.coroutines.CoroutineDispatcher, com.squareup.otto.Bus, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public ArticleViewModel(HelpCenterApi helpCenterApi2, String str, AppConfig appConfig2, TeamPresence teamPresence2, MetricTracker metricTracker2, String str2, boolean z, CoroutineDispatcher coroutineDispatcher, Bus bus2) {
        Intrinsics.checkNotNullParameter(helpCenterApi2, "helpCenterApi");
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(teamPresence2, "teamPresence");
        Intrinsics.checkNotNullParameter(metricTracker2, "metricTracker");
        Intrinsics.checkNotNullParameter(str2, "metricPlace");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(bus2, "bus");
        this.helpCenterApi = helpCenterApi2;
        this.baseUrl = str;
        this.appConfig = appConfig2;
        this.teamPresence = teamPresence2;
        this.metricTracker = metricTracker2;
        this.isFromSearchBrowse = z;
        this.dispatcher = coroutineDispatcher;
        this.bus = bus2;
        MutableStateFlow<ArticleViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(ArticleViewState.Initial.INSTANCE);
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
        this.articleContentId = "";
        this.articleId = "";
        if (!Intrinsics.areEqual((Object) str2, (Object) MetricTracker.Place.COLLECTION_LIST)) {
            String str3 = "article";
            if (!Intrinsics.areEqual((Object) str2, (Object) str3)) {
                this.metricTracker.openedNativeHelpCenter(str2, !Intrinsics.areEqual((Object) str2, (Object) MetricTracker.Place.API) ? MetricTracker.Context.NO_CONTEXT : str3);
            }
        }
        this.bus.register(this);
    }

    public final StateFlow<ArticleViewState> getState() {
        return this.state;
    }

    public final void fragmentLoaded(String str) {
        Intrinsics.checkNotNullParameter(str, "articleId");
        this.articleId = str;
        this._state.setValue(new ArticleViewState.Content(this.baseUrl + "/articles/" + str, str, ArticleViewState.WebViewStatus.Idle, ArticleViewState.ReactionState.Companion.getDefaultReactionState(), ArticleViewState.TeamPresenceState.Companion.getDefaultTeamPresenceState()));
    }

    public void onArticleFinishedLoading() {
        this.metricTracker.viewedNativeHelpCenter("article", (Boolean) null, this.isFromSearchBrowse);
        ArticleViewState value = this._state.getValue();
        if (value instanceof ArticleViewState.Content) {
            this._state.setValue(ArticleViewState.Content.copy$default((ArticleViewState.Content) value, (String) null, (String) null, ArticleViewState.WebViewStatus.Ready, (ArticleViewState.ReactionState) null, (ArticleViewState.TeamPresenceState) null, 27, (Object) null));
        } else if (!Intrinsics.areEqual((Object) value, (Object) ArticleViewState.Initial.INSTANCE)) {
            boolean z = value instanceof ArticleViewState.Error;
        }
    }

    public void onArticleLoadingError() {
        sendFailedMetric$default(this, (Integer) null, 1, (Object) null);
        this._state.setValue(new ArticleViewState.Error(R.string.intercom_something_went_wrong_try_again, 0, this.appConfig.getPrimaryColor()));
    }

    public void articleNotFound() {
        sendFailedMetric(Integer.valueOf(HttpStatus.SC_NOT_FOUND));
        this._state.setValue(new ArticleViewState.Error(R.string.intercom_page_not_found, 8, this.appConfig.getPrimaryColor()));
    }

    public void onArticleStartedLoading() {
        ArticleViewState value = this._state.getValue();
        if (value instanceof ArticleViewState.Content) {
            this._state.setValue(ArticleViewState.Content.copy$default((ArticleViewState.Content) value, (String) null, (String) null, ArticleViewState.WebViewStatus.Loading, (ArticleViewState.ReactionState) null, (ArticleViewState.TeamPresenceState) null, 27, (Object) null));
            return;
        }
        if (!(Intrinsics.areEqual((Object) value, (Object) ArticleViewState.Initial.INSTANCE) ? true : value instanceof ArticleViewState.Error)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void sadReactionTapped() {
        boolean z;
        int i;
        ArticleViewState value = this._state.getValue();
        boolean z2 = true;
        if (value instanceof ArticleViewState.Content) {
            MutableStateFlow<ArticleViewState> mutableStateFlow = this._state;
            ArticleViewState.Content content = (ArticleViewState.Content) value;
            this.metricTracker.sentArticleReaction(MetricTracker.Context.REACTION_SAD, Boolean.valueOf(this.appConfig.isInboundMessages()), this.isFromSearchBrowse);
            sendReactionToServer(content.getArticleId(), this.articleContentId, 2);
            int i2 = R.id.sad_end;
            if (shouldAddSendMessageRow()) {
                i = 0;
                z = true;
            } else {
                i = 8;
                z = false;
            }
            mutableStateFlow.setValue(ArticleViewState.Content.copy$default(content, (String) null, (String) null, (ArticleViewState.WebViewStatus) null, ArticleViewState.ReactionState.copy$default(content.getReactionState(), 0, i2, i, z, 1, (Object) null), TeammateHelpKt.computeViewState(content.getArticleId(), content.getTeamPresenceState(), this.appConfig, this.teamPresence, "article", this.isFromSearchBrowse), 7, (Object) null));
            return;
        }
        if (!Intrinsics.areEqual((Object) value, (Object) ArticleViewState.Initial.INSTANCE)) {
            z2 = value instanceof ArticleViewState.Error;
        }
        if (!z2) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void happyReactionTapped() {
        ArticleViewState value = this._state.getValue();
        if (value instanceof ArticleViewState.Content) {
            MutableStateFlow<ArticleViewState> mutableStateFlow = this._state;
            ArticleViewState.Content content = (ArticleViewState.Content) value;
            this.metricTracker.sentArticleReaction(MetricTracker.Context.REACTION_HAPPY, (Boolean) null, this.isFromSearchBrowse);
            sendReactionToServer(content.getArticleId(), this.articleContentId, 0);
            mutableStateFlow.setValue(ArticleViewState.Content.copy$default(content, (String) null, (String) null, (ArticleViewState.WebViewStatus) null, ArticleViewState.ReactionState.copy$default(content.getReactionState(), 0, R.id.happy_end, 8, false, 1, (Object) null), (ArticleViewState.TeamPresenceState) null, 23, (Object) null));
            return;
        }
        if (!(Intrinsics.areEqual((Object) value, (Object) ArticleViewState.Initial.INSTANCE) ? true : value instanceof ArticleViewState.Error)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void neutralReactionTapped() {
        ArticleViewState value = this._state.getValue();
        boolean z = true;
        if (value instanceof ArticleViewState.Content) {
            MutableStateFlow<ArticleViewState> mutableStateFlow = this._state;
            ArticleViewState.Content content = (ArticleViewState.Content) value;
            this.metricTracker.sentArticleReaction(MetricTracker.Context.REACTION_NEUTRAL, (Boolean) null, this.isFromSearchBrowse);
            sendReactionToServer(content.getArticleId(), this.articleContentId, 1);
            mutableStateFlow.setValue(ArticleViewState.Content.copy$default(content, (String) null, (String) null, (ArticleViewState.WebViewStatus) null, ArticleViewState.ReactionState.copy$default(content.getReactionState(), 0, R.id.neutral_end, 8, false, 1, (Object) null), (ArticleViewState.TeamPresenceState) null, 23, (Object) null));
            return;
        }
        if (!Intrinsics.areEqual((Object) value, (Object) ArticleViewState.Initial.INSTANCE)) {
            z = value instanceof ArticleViewState.Error;
        }
        if (!z) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void sendReactionToServer(String str, String str2, int i) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new ArticleViewModel$sendReactionToServer$1(this, str, i, str2, (Continuation<? super ArticleViewModel$sendReactionToServer$1>) null), 2, (Object) null);
    }

    public final void articleContentIdFetched(String str) {
        if (str != null) {
            this.articleContentId = str;
            ArticleViewState value = this._state.getValue();
            if (value instanceof ArticleViewState.Content) {
                ArticleViewState.Content content = (ArticleViewState.Content) value;
                this._state.setValue(ArticleViewState.Content.copy$default(content, (String) null, (String) null, (ArticleViewState.WebViewStatus) null, ArticleViewState.ReactionState.copy$default(content.getReactionState(), 0, 0, 0, false, 14, (Object) null), (ArticleViewState.TeamPresenceState) null, 23, (Object) null));
            } else if (!Intrinsics.areEqual((Object) value, (Object) ArticleViewState.Initial.INSTANCE)) {
                boolean z = value instanceof ArticleViewState.Error;
            }
        }
    }

    static /* synthetic */ void sendFailedMetric$default(ArticleViewModel articleViewModel, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        articleViewModel.sendFailedMetric(num);
    }

    private final void sendFailedMetric(Integer num) {
        this.metricTracker.failedHelpCenter("help_center", "article", num != null ? num.toString() : null, this.isFromSearchBrowse);
    }

    private final boolean shouldAddSendMessageRow() {
        return AppConfigExtensionsKt.canStartNewConversation(this.appConfig);
    }

    @Subscribe
    public final void newConversation(NewConversationEvent newConversationEvent) {
        Intrinsics.checkNotNullParameter(newConversationEvent, NotificationCompat.CATEGORY_EVENT);
        ArticleViewState value = this._state.getValue();
        if (value instanceof ArticleViewState.Content) {
            ArticleViewState.Content content = (ArticleViewState.Content) value;
            if (content.getReactionState().getTransitionState() == R.id.sad_end) {
                MutableStateFlow<ArticleViewState> mutableStateFlow = this._state;
                ArticleViewState.TeamPresenceState teamPresenceState = content.getTeamPresenceState();
                int i = R.string.intercom_continue_the_conversation;
                String id = newConversationEvent.getConversation().getId();
                Intrinsics.checkNotNullExpressionValue(id, "event.conversation.id");
                LastParticipatingAdmin lastParticipatingAdmin = newConversationEvent.getConversation().getLastParticipatingAdmin();
                Intrinsics.checkNotNullExpressionValue(lastParticipatingAdmin, "event.conversation.lastParticipatingAdmin");
                mutableStateFlow.setValue(ArticleViewState.Content.copy$default(content, (String) null, (String) null, (ArticleViewState.WebViewStatus) null, (ArticleViewState.ReactionState) null, ArticleViewState.TeamPresenceState.copy$default(teamPresenceState, (String) null, new ArticleViewState.ConversationState(id, lastParticipatingAdmin), 0, i, 0, 0, 0, (List) null, (String) null, (String) null, false, 2037, (Object) null), 15, (Object) null));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.bus.unregister(this);
    }

    @Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003*\u0001\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J-\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleViewModel$Companion;", "", "()V", "HAPPY_SERVER_INDEX", "", "NEUTRAL_SERVER_INDEX", "SAD_SERVER_INDEX", "create", "Lio/intercom/android/sdk/helpcenter/articles/ArticleViewModel;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "helpCenterApi", "Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;", "baseUrl", "", "metricPlace", "isFromSearchBrowse", "", "factory", "io/intercom/android/sdk/helpcenter/articles/ArticleViewModel$Companion$factory$1", "(Lio/intercom/android/sdk/helpcenter/api/HelpCenterApi;Ljava/lang/String;Ljava/lang/String;Z)Lio/intercom/android/sdk/helpcenter/articles/ArticleViewModel$Companion$factory$1;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArticleViewModel create(ViewModelStoreOwner viewModelStoreOwner, HelpCenterApi helpCenterApi, String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
            Intrinsics.checkNotNullParameter(helpCenterApi, "helpCenterApi");
            Intrinsics.checkNotNullParameter(str, "baseUrl");
            Intrinsics.checkNotNullParameter(str2, "metricPlace");
            return (ArticleViewModel) new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) factory(helpCenterApi, str, str2, z)).get(ArticleViewModel.class);
        }

        private final ArticleViewModel$Companion$factory$1 factory(HelpCenterApi helpCenterApi, String str, String str2, boolean z) {
            return new ArticleViewModel$Companion$factory$1(helpCenterApi, str, str2, z);
        }
    }
}
