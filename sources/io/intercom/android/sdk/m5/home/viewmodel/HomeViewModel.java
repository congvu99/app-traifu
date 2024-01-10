package io.intercom.android.sdk.m5.home.viewmodel;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import io.intercom.android.sdk.api.MessengerApi;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeState;
import io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeStateReducer;
import io.intercom.android.sdk.m5.home.topbars.HeaderEvent;
import io.intercom.android.sdk.m5.home.topbars.HomeHeaderStateReducer;
import io.intercom.android.sdk.m5.home.viewmodel.HeaderState;
import io.intercom.android.sdk.m5.home.viewmodel.HomeViewState;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.ConfigModules;
import io.intercom.android.sdk.models.OpenToSpace;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.models.events.ConfigUpdateEvent;
import io.intercom.android.sdk.models.events.ConversationEvent;
import io.intercom.android.sdk.models.events.NewConversationEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
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

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 <2\u00020\u0001:\u0002<=BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0007J\u0010\u0010/\u001a\u00020,2\u0006\u0010-\u001a\u000200H\u0007J\b\u00101\u001a\u00020,H\u0002J\u0010\u00102\u001a\u00020,2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020,2\u0006\u0010-\u001a\u000206H\u0007J\b\u00107\u001a\u00020,H\u0014J\u0006\u00108\u001a\u00020,J\u0006\u00109\u001a\u00020,J\u0006\u0010:\u001a\u00020,J\u0006\u0010;\u001a\u00020,R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0 ¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180 ¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "messengerApi", "Lio/intercom/android/sdk/api/MessengerApi;", "config", "Lio/intercom/android/sdk/identity/AppConfig;", "teamPresence", "Lio/intercom/android/sdk/models/TeamPresence;", "metricTracker", "Lio/intercom/android/sdk/metrics/MetricTracker;", "bus", "Lcom/squareup/otto/Bus;", "intercomBadgeStateReducer", "Lio/intercom/android/sdk/m5/components/intercombadge/IntercomBadgeStateReducer;", "homeHeaderStateReducer", "Lio/intercom/android/sdk/m5/home/topbars/HomeHeaderStateReducer;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lio/intercom/android/sdk/api/MessengerApi;Lio/intercom/android/sdk/identity/AppConfig;Lio/intercom/android/sdk/models/TeamPresence;Lio/intercom/android/sdk/metrics/MetricTracker;Lcom/squareup/otto/Bus;Lio/intercom/android/sdk/m5/components/intercombadge/IntercomBadgeStateReducer;Lio/intercom/android/sdk/m5/home/topbars/HomeHeaderStateReducer;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_effect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeScreenEffects;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState;", "effect", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "headerEvents", "Lio/intercom/android/sdk/m5/home/topbars/HeaderEvent;", "headerState", "Lkotlinx/coroutines/flow/StateFlow;", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState;", "getHeaderState", "()Lkotlinx/coroutines/flow/StateFlow;", "intercomBadgeState", "Lio/intercom/android/sdk/m5/components/intercombadge/IntercomBadgeState;", "getIntercomBadgeState", "state", "getState", "viewStatus", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewModel$ViewStatus;", "configUpdated", "", "event", "Lio/intercom/android/sdk/models/events/ConfigUpdateEvent;", "conversationSuccess", "Lio/intercom/android/sdk/models/events/ConversationEvent;", "fetchHomeData", "handleOpening", "openToSpace", "Lio/intercom/android/sdk/models/OpenToSpace;", "newConversation", "Lio/intercom/android/sdk/models/events/NewConversationEvent;", "onCleared", "onHeaderImageLoaded", "onPause", "onResume", "onRetryClicked", "Companion", "ViewStatus", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeViewModel.kt */
public final class HomeViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final MutableSharedFlow<HomeScreenEffects> _effect;
    /* access modifiers changed from: private */
    public final MutableStateFlow<HomeViewState> _state;
    private final Bus bus;
    private final AppConfig config;
    private final CoroutineDispatcher dispatcher;
    private final SharedFlow<HomeScreenEffects> effect;
    private final MutableStateFlow<HeaderEvent> headerEvents;
    private final StateFlow<HeaderState> headerState;
    /* access modifiers changed from: private */
    public final HomeHeaderStateReducer homeHeaderStateReducer;
    private final StateFlow<IntercomBadgeState> intercomBadgeState;
    /* access modifiers changed from: private */
    public final IntercomBadgeStateReducer intercomBadgeStateReducer;
    /* access modifiers changed from: private */
    public final MessengerApi messengerApi;
    private final MetricTracker metricTracker;
    private final StateFlow<HomeViewState> state;
    private final TeamPresence teamPresence;
    private ViewStatus viewStatus;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewModel$ViewStatus;", "", "(Ljava/lang/String;I)V", "FOREGROUND", "BACKGROUND", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeViewModel.kt */
    private enum ViewStatus {
        FOREGROUND,
        BACKGROUND
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OpenToSpace.values().length];
            iArr[OpenToSpace.HOME.ordinal()] = 1;
            iArr[OpenToSpace.MESSAGES.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HomeViewModel(io.intercom.android.sdk.api.MessengerApi r13, io.intercom.android.sdk.identity.AppConfig r14, io.intercom.android.sdk.models.TeamPresence r15, io.intercom.android.sdk.metrics.MetricTracker r16, com.squareup.otto.Bus r17, io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeStateReducer r18, io.intercom.android.sdk.m5.home.topbars.HomeHeaderStateReducer r19, kotlinx.coroutines.CoroutineDispatcher r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0015
            io.intercom.android.sdk.Injector r1 = io.intercom.android.sdk.Injector.get()
            com.squareup.otto.Bus r1 = r1.getBus()
            java.lang.String r2 = "get().bus"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r8 = r1
            goto L_0x0017
        L_0x0015:
            r8 = r17
        L_0x0017:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0028
            io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeStateReducer r1 = new io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeStateReducer
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 7
            r7 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            r9 = r1
            goto L_0x002a
        L_0x0028:
            r9 = r18
        L_0x002a:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0037
            io.intercom.android.sdk.m5.home.topbars.HomeHeaderStateReducer r1 = new io.intercom.android.sdk.m5.home.topbars.HomeHeaderStateReducer
            r2 = r14
            r6 = r15
            r1.<init>(r15, r14)
            r10 = r1
            goto L_0x003b
        L_0x0037:
            r2 = r14
            r6 = r15
            r10 = r19
        L_0x003b:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0045
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
            r11 = r0
            goto L_0x0047
        L_0x0045:
            r11 = r20
        L_0x0047:
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel.<init>(io.intercom.android.sdk.api.MessengerApi, io.intercom.android.sdk.identity.AppConfig, io.intercom.android.sdk.models.TeamPresence, io.intercom.android.sdk.metrics.MetricTracker, com.squareup.otto.Bus, io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeStateReducer, io.intercom.android.sdk.m5.home.topbars.HomeHeaderStateReducer, kotlinx.coroutines.CoroutineDispatcher, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public HomeViewModel(MessengerApi messengerApi2, AppConfig appConfig, TeamPresence teamPresence2, MetricTracker metricTracker2, Bus bus2, IntercomBadgeStateReducer intercomBadgeStateReducer2, HomeHeaderStateReducer homeHeaderStateReducer2, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(messengerApi2, "messengerApi");
        Intrinsics.checkNotNullParameter(appConfig, "config");
        Intrinsics.checkNotNullParameter(teamPresence2, "teamPresence");
        Intrinsics.checkNotNullParameter(metricTracker2, "metricTracker");
        Intrinsics.checkNotNullParameter(bus2, "bus");
        Intrinsics.checkNotNullParameter(intercomBadgeStateReducer2, "intercomBadgeStateReducer");
        Intrinsics.checkNotNullParameter(homeHeaderStateReducer2, "homeHeaderStateReducer");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.messengerApi = messengerApi2;
        this.config = appConfig;
        this.teamPresence = teamPresence2;
        this.metricTracker = metricTracker2;
        this.bus = bus2;
        this.intercomBadgeStateReducer = intercomBadgeStateReducer2;
        this.homeHeaderStateReducer = homeHeaderStateReducer2;
        this.dispatcher = coroutineDispatcher;
        this.viewStatus = ViewStatus.FOREGROUND;
        MutableSharedFlow<HomeScreenEffects> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._effect = MutableSharedFlow$default;
        ViewModel viewModel = this;
        this.effect = FlowKt.shareIn(MutableSharedFlow$default, ViewModelKt.getViewModelScope(viewModel), SharingStarted.Companion.getEagerly(), 1);
        MutableStateFlow<HomeViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(HomeViewState.Initial.INSTANCE);
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
        this.intercomBadgeState = FlowKt.stateIn(new HomeViewModel$special$$inlined$map$1(this._state, this), ViewModelKt.getViewModelScope(viewModel), SharingStarted.Companion.getLazily(), IntercomBadgeState.Hidden.INSTANCE);
        MutableStateFlow<HeaderEvent> MutableStateFlow2 = StateFlowKt.MutableStateFlow(HeaderEvent.INITIAL);
        this.headerEvents = MutableStateFlow2;
        HeaderState.NoHeader noHeader = HeaderState.NoHeader.INSTANCE;
        Intrinsics.checkNotNull(noHeader, "null cannot be cast to non-null type io.intercom.android.sdk.m5.home.viewmodel.HeaderState");
        this.headerState = FlowKt.stateIn(FlowKt.scan(new HomeViewModel$special$$inlined$filter$1(FlowKt.combine(MutableStateFlow2, this._state, new HomeViewModel$headerState$1((Continuation<? super HomeViewModel$headerState$1>) null))), noHeader, new HomeViewModel$headerState$3(this, (Continuation<? super HomeViewModel$headerState$3>) null)), ViewModelKt.getViewModelScope(viewModel), SharingStarted.Companion.getLazily(), HeaderState.NoHeader.INSTANCE);
        this._state.setValue(HomeViewState.Loading.INSTANCE);
        this.bus.register(this);
    }

    public final SharedFlow<HomeScreenEffects> getEffect() {
        return this.effect;
    }

    public final StateFlow<HomeViewState> getState() {
        return this.state;
    }

    public final StateFlow<IntercomBadgeState> getIntercomBadgeState() {
        return this.intercomBadgeState;
    }

    public final StateFlow<HeaderState> getHeaderState() {
        return this.headerState;
    }

    public final void onResume() {
        this.viewStatus = ViewStatus.FOREGROUND;
        ConfigModules configModules = this.config.getConfigModules();
        if (configModules != null) {
            handleOpening(configModules.getHome().getOpenConfig().getOpenTo());
        }
    }

    public final void onPause() {
        this.viewStatus = ViewStatus.BACKGROUND;
    }

    private final void handleOpening(OpenToSpace openToSpace) {
        int i = WhenMappings.$EnumSwitchMapping$0[openToSpace.ordinal()];
        if (i == 1) {
            fetchHomeData();
        } else if (i == 2) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new HomeViewModel$handleOpening$1(this, (Continuation<? super HomeViewModel$handleOpening$1>) null), 3, (Object) null);
        }
    }

    private final void fetchHomeData() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new HomeViewModel$fetchHomeData$1(this, (Continuation<? super HomeViewModel$fetchHomeData$1>) null), 2, (Object) null);
    }

    public final void onHeaderImageLoaded() {
        this.headerEvents.setValue(HeaderEvent.IMAGE_LOADED);
    }

    public final void onRetryClicked() {
        this._state.setValue(HomeViewState.Loading.INSTANCE);
        fetchHomeData();
    }

    @Subscribe
    public final void conversationSuccess(ConversationEvent conversationEvent) {
        Intrinsics.checkNotNullParameter(conversationEvent, NotificationCompat.CATEGORY_EVENT);
        if (this.viewStatus == ViewStatus.FOREGROUND) {
            fetchHomeData();
        }
    }

    @Subscribe
    public final void configUpdated(ConfigUpdateEvent configUpdateEvent) {
        ConfigModules configModules;
        Intrinsics.checkNotNullParameter(configUpdateEvent, NotificationCompat.CATEGORY_EVENT);
        if (this.viewStatus == ViewStatus.FOREGROUND && (configModules = this.config.getConfigModules()) != null) {
            handleOpening(configModules.getHome().getOpenConfig().getOpenTo());
        }
    }

    @Subscribe
    public final void newConversation(NewConversationEvent newConversationEvent) {
        Intrinsics.checkNotNullParameter(newConversationEvent, NotificationCompat.CATEGORY_EVENT);
        fetchHomeData();
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.bus.unregister(this);
    }

    @Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003*\u0001\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewModel$Companion;", "", "()V", "create", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewModel;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "messengerApi", "Lio/intercom/android/sdk/api/MessengerApi;", "factory", "io/intercom/android/sdk/m5/home/viewmodel/HomeViewModel$Companion$factory$1", "(Lio/intercom/android/sdk/api/MessengerApi;)Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewModel$Companion$factory$1;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeViewModel create(ViewModelStoreOwner viewModelStoreOwner, MessengerApi messengerApi) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
            Intrinsics.checkNotNullParameter(messengerApi, "messengerApi");
            return (HomeViewModel) new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) factory(messengerApi)).get(HomeViewModel.class);
        }

        private final HomeViewModel$Companion$factory$1 factory(MessengerApi messengerApi) {
            return new HomeViewModel$Companion$factory$1(messengerApi);
        }
    }
}
