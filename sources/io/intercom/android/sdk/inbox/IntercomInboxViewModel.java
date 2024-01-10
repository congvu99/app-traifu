package io.intercom.android.sdk.inbox;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.inbox.InboxScreenState;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.events.ConversationEvent;
import io.intercom.android.sdk.utilities.extensions.AppConfigExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
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

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001,B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0017\u0010!\u001a\u00020\u001e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\b\u0010&\u001a\u00020\u001eH\u0014J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001bJ\u0006\u0010)\u001a\u00020\u001eJ\b\u0010*\u001a\u00020+H\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lio/intercom/android/sdk/inbox/IntercomInboxViewModel;", "Landroidx/lifecycle/ViewModel;", "inboxRepository", "Lio/intercom/android/sdk/inbox/InboxRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "bus", "Lcom/squareup/otto/Bus;", "appConfig", "Lio/intercom/android/sdk/identity/AppConfig;", "(Lio/intercom/android/sdk/inbox/InboxRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/squareup/otto/Bus;Lio/intercom/android/sdk/identity/AppConfig;)V", "_effect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/intercom/android/sdk/inbox/InboxScreenEffects;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/intercom/android/sdk/inbox/InboxScreenState;", "effect", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "combineConversations", "", "Lio/intercom/android/sdk/models/Conversation;", "newConversations", "conversationSuccess", "", "event", "Lio/intercom/android/sdk/models/events/ConversationEvent;", "fetchInboxData", "before", "", "(Ljava/lang/Long;)V", "fetchMoreInboxDataIfAvailable", "onCleared", "onConversationClick", "it", "onRetryClicked", "shouldShowSendMessageButton", "", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomInboxViewModel.kt */
public final class IntercomInboxViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final MutableSharedFlow<InboxScreenEffects> _effect;
    /* access modifiers changed from: private */
    public final MutableStateFlow<InboxScreenState> _state;
    /* access modifiers changed from: private */
    public final AppConfig appConfig;
    /* access modifiers changed from: private */
    public final Bus bus;
    private final CoroutineDispatcher dispatcher;
    private final SharedFlow<InboxScreenEffects> effect;
    /* access modifiers changed from: private */
    public final InboxRepository inboxRepository;
    private final StateFlow<InboxScreenState> uiState;

    public IntercomInboxViewModel() {
        this((InboxRepository) null, (CoroutineDispatcher) null, (Bus) null, (AppConfig) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ IntercomInboxViewModel(io.intercom.android.sdk.inbox.InboxRepository r2, kotlinx.coroutines.CoroutineDispatcher r3, com.squareup.otto.Bus r4, io.intercom.android.sdk.identity.AppConfig r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r1 = this;
            r7 = r6 & 1
            if (r7 == 0) goto L_0x000b
            io.intercom.android.sdk.inbox.InboxRepository r2 = new io.intercom.android.sdk.inbox.InboxRepository
            r7 = 0
            r0 = 1
            r2.<init>(r7, r0, r7)
        L_0x000b:
            r7 = r6 & 2
            if (r7 == 0) goto L_0x0013
            kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getIO()
        L_0x0013:
            r7 = r6 & 4
            if (r7 == 0) goto L_0x0024
            io.intercom.android.sdk.Injector r4 = io.intercom.android.sdk.Injector.get()
            com.squareup.otto.Bus r4 = r4.getBus()
            java.lang.String r7 = "get().bus"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
        L_0x0024:
            r6 = r6 & 8
            if (r6 == 0) goto L_0x003b
            io.intercom.android.sdk.Injector r5 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.Provider r5 = r5.getAppConfigProvider()
            java.lang.Object r5 = r5.get()
            java.lang.String r6 = "get().appConfigProvider.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            io.intercom.android.sdk.identity.AppConfig r5 = (io.intercom.android.sdk.identity.AppConfig) r5
        L_0x003b:
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.inbox.IntercomInboxViewModel.<init>(io.intercom.android.sdk.inbox.InboxRepository, kotlinx.coroutines.CoroutineDispatcher, com.squareup.otto.Bus, io.intercom.android.sdk.identity.AppConfig, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public IntercomInboxViewModel(InboxRepository inboxRepository2, CoroutineDispatcher coroutineDispatcher, Bus bus2, AppConfig appConfig2) {
        Intrinsics.checkNotNullParameter(inboxRepository2, "inboxRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(bus2, "bus");
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        this.inboxRepository = inboxRepository2;
        this.dispatcher = coroutineDispatcher;
        this.bus = bus2;
        this.appConfig = appConfig2;
        MutableStateFlow<InboxScreenState> MutableStateFlow = StateFlowKt.MutableStateFlow(InboxScreenState.Initial.INSTANCE);
        this._state = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<InboxScreenEffects> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._effect = MutableSharedFlow$default;
        this.effect = FlowKt__ShareKt.shareIn$default(MutableSharedFlow$default, ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getEagerly(), 0, 4, (Object) null);
        this._state.setValue(InboxScreenState.Loading.INSTANCE);
        this.bus.register(this);
    }

    public final StateFlow<InboxScreenState> getUiState() {
        return this.uiState;
    }

    public final SharedFlow<InboxScreenEffects> getEffect() {
        return this.effect;
    }

    public static /* synthetic */ void fetchInboxData$default(IntercomInboxViewModel intercomInboxViewModel, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        intercomInboxViewModel.fetchInboxData(l);
    }

    public final void fetchInboxData(Long l) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new IntercomInboxViewModel$fetchInboxData$1(this, l, (Continuation<? super IntercomInboxViewModel$fetchInboxData$1>) null), 2, (Object) null);
    }

    public final void fetchMoreInboxDataIfAvailable(long j) {
        InboxScreenState value = this._state.getValue();
        if ((value instanceof InboxScreenState.Content) && ((InboxScreenState.Content) value).getMoreConversationsAvailable()) {
            fetchInboxData(Long.valueOf(j));
        }
    }

    public final void onRetryClicked() {
        this._state.setValue(InboxScreenState.Loading.INSTANCE);
        fetchInboxData$default(this, (Long) null, 1, (Object) null);
    }

    @Subscribe
    public final void conversationSuccess(ConversationEvent conversationEvent) {
        Intrinsics.checkNotNullParameter(conversationEvent, NotificationCompat.CATEGORY_EVENT);
        InboxScreenState value = this._state.getValue();
        if (value instanceof InboxScreenState.Content) {
            MutableStateFlow<InboxScreenState> mutableStateFlow = this._state;
            InboxScreenState.Content content = (InboxScreenState.Content) value;
            Iterable<Conversation> inboxConversations = content.getInboxConversations();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(inboxConversations, 10));
            for (Conversation conversation : inboxConversations) {
                if (Intrinsics.areEqual((Object) conversation.getId(), (Object) conversationEvent.getResponse().getId())) {
                    conversation = conversationEvent.getResponse();
                }
                arrayList.add(conversation);
            }
            mutableStateFlow.setValue(InboxScreenState.Content.copy$default(content, (List) arrayList, false, false, 6, (Object) null));
        }
    }

    public final void onConversationClick(Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "it");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new IntercomInboxViewModel$onConversationClick$1(this, conversation, (Continuation<? super IntercomInboxViewModel$onConversationClick$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final List<Conversation> combineConversations(List<? extends Conversation> list) {
        List<Conversation> list2;
        InboxScreenState value = this._state.getValue();
        InboxScreenState.Content content = value instanceof InboxScreenState.Content ? (InboxScreenState.Content) value : null;
        if (content == null || (list2 = content.getInboxConversations()) == null) {
            list2 = CollectionsKt.emptyList();
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object next : CollectionsKt.sortedWith(CollectionsKt.plus(list2, list), new IntercomInboxViewModel$combineConversations$$inlined$sortedByDescending$1())) {
            if (hashSet.add(((Conversation) next).getId())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final boolean shouldShowSendMessageButton() {
        return AppConfigExtensionsKt.canStartNewConversation(this.appConfig) && !this.appConfig.isHelpCenterRequireSearchEnabled();
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.bus.unregister(this);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003*\u0001\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\r\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lio/intercom/android/sdk/inbox/IntercomInboxViewModel$Companion;", "", "()V", "create", "Lio/intercom/android/sdk/inbox/IntercomInboxViewModel;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "factory", "io/intercom/android/sdk/inbox/IntercomInboxViewModel$Companion$factory$1", "()Lio/intercom/android/sdk/inbox/IntercomInboxViewModel$Companion$factory$1;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomInboxViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IntercomInboxViewModel create(ViewModelStoreOwner viewModelStoreOwner) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
            return (IntercomInboxViewModel) new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) factory()).get(IntercomInboxViewModel.class);
        }

        private final IntercomInboxViewModel$Companion$factory$1 factory() {
            return new IntercomInboxViewModel$Companion$factory$1();
        }
    }
}
