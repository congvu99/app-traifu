package io.intercom.android.sdk.tickets.create.ui;

import io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomCreateTicketActivity.kt */
final class IntercomCreateTicketActivity$viewModel$2 extends Lambda implements Function0<CreateTicketViewModel> {
    final /* synthetic */ IntercomCreateTicketActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomCreateTicketActivity$viewModel$2(IntercomCreateTicketActivity intercomCreateTicketActivity) {
        super(0);
        this.this$0 = intercomCreateTicketActivity;
    }

    public final CreateTicketViewModel invoke() {
        CreateTicketViewModel.Companion companion = CreateTicketViewModel.Companion;
        IntercomCreateTicketActivity intercomCreateTicketActivity = this.this$0;
        return companion.create(intercomCreateTicketActivity, intercomCreateTicketActivity, intercomCreateTicketActivity.getIntent().getExtras());
    }
}
