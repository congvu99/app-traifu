package io.intercom.android.sdk.tickets.create.data;

import io.intercom.android.sdk.api.MessengerApiHelper;
import io.intercom.android.sdk.api.UserUpdateRequest;
import io.intercom.android.sdk.api.UserUpdater;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J5\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lio/intercom/android/sdk/tickets/create/data/TicketRepository;", "", "api", "Lio/intercom/android/sdk/tickets/create/data/TicketApi;", "userUpdater", "Lio/intercom/android/sdk/api/UserUpdater;", "(Lio/intercom/android/sdk/tickets/create/data/TicketApi;Lio/intercom/android/sdk/api/UserUpdater;)V", "createTicket", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse;", "", "conversationId", "", "ticketId", "", "attributes", "", "Lio/intercom/android/sdk/tickets/create/data/TicketAttributeRequest;", "(Ljava/lang/String;ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "email", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketRepository.kt */
public final class TicketRepository {
    private final TicketApi api;
    private final UserUpdater userUpdater;

    public TicketRepository() {
        this((TicketApi) null, (UserUpdater) null, 3, (DefaultConstructorMarker) null);
    }

    public TicketRepository(TicketApi ticketApi, UserUpdater userUpdater2) {
        Intrinsics.checkNotNullParameter(ticketApi, MetricTracker.Place.API);
        Intrinsics.checkNotNullParameter(userUpdater2, "userUpdater");
        this.api = ticketApi;
        this.userUpdater = userUpdater2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TicketRepository(io.intercom.android.sdk.tickets.create.data.TicketApi r1, io.intercom.android.sdk.api.UserUpdater r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0011
            io.intercom.android.sdk.Injector r1 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.tickets.create.data.TicketApi r1 = r1.getTicketApi()
            java.lang.String r4 = "get().ticketApi"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
        L_0x0011:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0022
            io.intercom.android.sdk.Injector r2 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.api.UserUpdater r2 = r2.getUserUpdater()
            java.lang.String r3 = "get().userUpdater"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x0022:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.tickets.create.data.TicketRepository.<init>(io.intercom.android.sdk.tickets.create.data.TicketApi, io.intercom.android.sdk.api.UserUpdater, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Object createTicket(String str, int i, List<TicketAttributeRequest> list, Continuation<? super NetworkResponse<Unit>> continuation) {
        return this.api.createTicket(MessengerApiHelper.INSTANCE.getDefaultRequestBody$intercom_sdk_base_release(MapsKt.mapOf(TuplesKt.to("conversation_id", str), TuplesKt.to("type_id", Boxing.boxInt(i)), TuplesKt.to("attributes", list))), continuation);
    }

    public final void updateUser(String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        this.userUpdater.updateUser(UserUpdateRequest.create(false, false, MapsKt.mapOf(TuplesKt.to("email", str)), false), new TicketRepository$updateUser$1());
    }
}
