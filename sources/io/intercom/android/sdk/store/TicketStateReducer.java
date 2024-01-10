package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.state.TicketLegacyState;
import io.intercom.android.sdk.store.Store;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lio/intercom/android/sdk/store/TicketStateReducer;", "Lio/intercom/android/sdk/store/Store$Reducer;", "Lio/intercom/android/sdk/state/TicketLegacyState;", "()V", "reduce", "action", "Lio/intercom/android/sdk/actions/Action;", "currentState", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketStateReducer.kt */
public final class TicketStateReducer implements Store.Reducer<TicketLegacyState> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TicketLegacyState initialState = new TicketLegacyState((Ticket) null, 1, (DefaultConstructorMarker) null);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TicketStateReducer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Action.Type.values().length];
            iArr[Action.Type.FETCH_CONVERSATION_SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TicketLegacyState reduce(Action<?> action, TicketLegacyState ticketLegacyState) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(ticketLegacyState, "currentState");
        Action.Type type = action.type();
        if ((type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) != 1) {
            return ticketLegacyState;
        }
        Object value = action.value();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type io.intercom.android.sdk.models.Conversation");
        Ticket ticket = ((Conversation) value).getTicket();
        Intrinsics.checkNotNullExpressionValue(ticket, "conversation.ticket");
        return new TicketLegacyState(ticket);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/store/TicketStateReducer$Companion;", "", "()V", "initialState", "Lio/intercom/android/sdk/state/TicketLegacyState;", "getInitialState", "()Lio/intercom/android/sdk/state/TicketLegacyState;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TicketStateReducer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TicketLegacyState getInitialState() {
            return TicketStateReducer.initialState;
        }
    }
}
