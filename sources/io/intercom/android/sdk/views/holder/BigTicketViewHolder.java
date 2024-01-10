package io.intercom.android.sdk.views.holder;

import android.view.View;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.tickets.TicketDetailReducerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lio/intercom/android/sdk/views/holder/BigTicketViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "ticket", "Lio/intercom/android/sdk/models/Ticket;", "(Landroid/view/View;Lio/intercom/android/sdk/models/Ticket;)V", "getItemView", "()Landroid/view/View;", "getTicket", "()Lio/intercom/android/sdk/models/Ticket;", "bind", "", "visible", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BigTicketViewHolder.kt */
public final class BigTicketViewHolder extends RecyclerView.ViewHolder {
    private final View itemView;
    private final Ticket ticket;

    public final View getItemView() {
        return this.itemView;
    }

    public final Ticket getTicket() {
        return this.ticket;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BigTicketViewHolder(View view, Ticket ticket2) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.itemView = view;
        this.ticket = ticket2;
    }

    public final void bind(boolean z, Ticket ticket2) {
        ComposeView composeView = (ComposeView) this.itemView.findViewById(R.id.compose_view);
        if (ticket2 != null) {
            UserIdentity userIdentity = Injector.get().getUserIdentity();
            Intrinsics.checkNotNullExpressionValue(userIdentity, "userIdentity");
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(300151972, true, new BigTicketViewHolder$bind$1$1(TicketDetailReducerKt.computeTicketViewState$default(ticket2, userIdentity, (List) null, 4, (Object) null), z, composeView)));
        }
    }
}
