package io.intercom.android.sdk.tickets;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/tickets/TicketDetailViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomTicketActivity.kt */
final class IntercomTicketActivity$ticketViewModel$2 extends Lambda implements Function0<TicketDetailViewModel> {
    final /* synthetic */ IntercomTicketActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomTicketActivity$ticketViewModel$2(IntercomTicketActivity intercomTicketActivity) {
        super(0);
        this.this$0 = intercomTicketActivity;
    }

    public final TicketDetailViewModel invoke() {
        return TicketDetailViewModel.Companion.create(this.this$0);
    }
}
