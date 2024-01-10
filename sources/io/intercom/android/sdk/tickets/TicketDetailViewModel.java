package io.intercom.android.sdk.tickets;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.models.events.ConversationEvent;
import io.intercom.android.sdk.tickets.TicketDetailState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020\u001cH\u0014R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lio/intercom/android/sdk/tickets/TicketDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "ticket", "Lio/intercom/android/sdk/models/Ticket;", "conversationId", "", "teamPresence", "Lio/intercom/android/sdk/models/TeamPresence;", "user", "Lio/intercom/android/sdk/identity/UserIdentity;", "bus", "Lcom/squareup/otto/Bus;", "metricTracker", "Lio/intercom/android/sdk/metrics/MetricTracker;", "(Lio/intercom/android/sdk/models/Ticket;Ljava/lang/String;Lio/intercom/android/sdk/models/TeamPresence;Lio/intercom/android/sdk/identity/UserIdentity;Lcom/squareup/otto/Bus;Lio/intercom/android/sdk/metrics/MetricTracker;)V", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/intercom/android/sdk/tickets/TicketDetailState;", "activeAdminsAvatars", "", "Lio/intercom/android/sdk/models/Avatar;", "getActiveAdminsAvatars", "()Ljava/util/List;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "conversationSuccess", "", "event", "Lio/intercom/android/sdk/models/events/ConversationEvent;", "onCleared", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketDetailViewModel.kt */
public final class TicketDetailViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final MutableStateFlow<TicketDetailState> _stateFlow;
    private final Bus bus;
    private final String conversationId;
    private final MetricTracker metricTracker;
    private final StateFlow<TicketDetailState> stateFlow;
    private final TeamPresence teamPresence;
    private final UserIdentity user;

    public TicketDetailViewModel() {
        this((Ticket) null, (String) null, (TeamPresence) null, (UserIdentity) null, (Bus) null, (MetricTracker) null, 63, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TicketDetailViewModel(io.intercom.android.sdk.models.Ticket r5, java.lang.String r6, io.intercom.android.sdk.models.TeamPresence r7, io.intercom.android.sdk.identity.UserIdentity r8, com.squareup.otto.Bus r9, io.intercom.android.sdk.metrics.MetricTracker r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x001a
            io.intercom.android.sdk.Injector r5 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.store.Store r5 = r5.getStore()
            java.lang.Object r5 = r5.state()
            io.intercom.android.sdk.state.State r5 = (io.intercom.android.sdk.state.State) r5
            io.intercom.android.sdk.state.TicketLegacyState r5 = r5.ticketLegacyState()
            io.intercom.android.sdk.models.Ticket r5 = r5.getTicket()
        L_0x001a:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0039
            io.intercom.android.sdk.Injector r6 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.store.Store r6 = r6.getStore()
            java.lang.Object r6 = r6.state()
            io.intercom.android.sdk.state.State r6 = (io.intercom.android.sdk.state.State) r6
            io.intercom.android.sdk.state.ActiveConversationState r6 = r6.activeConversationState()
            java.lang.String r6 = r6.getConversationId()
            java.lang.String r12 = "get().store.state()\n    …ionState().conversationId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r12)
        L_0x0039:
            r12 = r6
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0055
            io.intercom.android.sdk.Injector r6 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.store.Store r6 = r6.getStore()
            java.lang.Object r6 = r6.state()
            io.intercom.android.sdk.state.State r6 = (io.intercom.android.sdk.state.State) r6
            io.intercom.android.sdk.models.TeamPresence r7 = r6.teamPresence()
            java.lang.String r6 = "get().store.state().teamPresence()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
        L_0x0055:
            r0 = r7
            r6 = r11 & 8
            if (r6 == 0) goto L_0x0067
            io.intercom.android.sdk.Injector r6 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.identity.UserIdentity r8 = r6.getUserIdentity()
            java.lang.String r6 = "get().userIdentity"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)
        L_0x0067:
            r1 = r8
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0079
            io.intercom.android.sdk.Injector r6 = io.intercom.android.sdk.Injector.get()
            com.squareup.otto.Bus r9 = r6.getBus()
            java.lang.String r6 = "get().bus"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r6)
        L_0x0079:
            r2 = r9
            r6 = r11 & 32
            if (r6 == 0) goto L_0x008b
            io.intercom.android.sdk.Injector r6 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.metrics.MetricTracker r10 = r6.getMetricTracker()
            java.lang.String r6 = "get().metricTracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r6)
        L_0x008b:
            r3 = r10
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.tickets.TicketDetailViewModel.<init>(io.intercom.android.sdk.models.Ticket, java.lang.String, io.intercom.android.sdk.models.TeamPresence, io.intercom.android.sdk.identity.UserIdentity, com.squareup.otto.Bus, io.intercom.android.sdk.metrics.MetricTracker, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public TicketDetailViewModel(Ticket ticket, String str, TeamPresence teamPresence2, UserIdentity userIdentity, Bus bus2, MetricTracker metricTracker2) {
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(str, "conversationId");
        Intrinsics.checkNotNullParameter(teamPresence2, "teamPresence");
        Intrinsics.checkNotNullParameter(userIdentity, Participant.USER_TYPE);
        Intrinsics.checkNotNullParameter(bus2, "bus");
        Intrinsics.checkNotNullParameter(metricTracker2, "metricTracker");
        this.conversationId = str;
        this.teamPresence = teamPresence2;
        this.user = userIdentity;
        this.bus = bus2;
        this.metricTracker = metricTracker2;
        MutableStateFlow<TicketDetailState> MutableStateFlow = StateFlowKt.MutableStateFlow(TicketDetailState.Initial.INSTANCE);
        this._stateFlow = MutableStateFlow;
        this.stateFlow = MutableStateFlow;
        MutableStateFlow.setValue(TicketDetailReducerKt.computeTicketViewState(ticket, this.user, getActiveAdminsAvatars()));
        this.bus.register(this);
        this.metricTracker.viewedTicketDetails(Integer.valueOf(ticket.getTicketTypeId()), this.conversationId, ticket.getCurrentStatus().getType());
    }

    public final StateFlow<TicketDetailState> getStateFlow() {
        return this.stateFlow;
    }

    private final List<Avatar> getActiveAdminsAvatars() {
        List<Participant> activeAdmins = this.teamPresence.getActiveAdmins();
        Intrinsics.checkNotNullExpressionValue(activeAdmins, "teamPresence.activeAdmins");
        Iterable<Participant> iterable = activeAdmins;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Participant avatar : iterable) {
            arrayList.add(avatar.getAvatar());
        }
        return (List) arrayList;
    }

    @Subscribe
    public final void conversationSuccess(ConversationEvent conversationEvent) {
        Intrinsics.checkNotNullParameter(conversationEvent, NotificationCompat.CATEGORY_EVENT);
        if (Intrinsics.areEqual((Object) conversationEvent.getResponse().getId(), (Object) this.conversationId)) {
            MutableStateFlow<TicketDetailState> mutableStateFlow = this._stateFlow;
            Ticket ticket = conversationEvent.getResponse().getTicket();
            Intrinsics.checkNotNullExpressionValue(ticket, "event.response.ticket");
            mutableStateFlow.setValue(TicketDetailReducerKt.computeTicketViewState(ticket, this.user, getActiveAdminsAvatars()));
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.bus.unregister(this);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003*\u0001\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\r\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lio/intercom/android/sdk/tickets/TicketDetailViewModel$Companion;", "", "()V", "create", "Lio/intercom/android/sdk/tickets/TicketDetailViewModel;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "factory", "io/intercom/android/sdk/tickets/TicketDetailViewModel$Companion$factory$1", "()Lio/intercom/android/sdk/tickets/TicketDetailViewModel$Companion$factory$1;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TicketDetailViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TicketDetailViewModel create(ViewModelStoreOwner viewModelStoreOwner) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
            return (TicketDetailViewModel) new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) factory()).get(TicketDetailViewModel.class);
        }

        private final TicketDetailViewModel$Companion$factory$1 factory() {
            return new TicketDetailViewModel$Companion$factory$1();
        }
    }
}
