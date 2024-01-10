package io.intercom.android.sdk.views.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.TimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lio/intercom/android/sdk/views/holder/TicketStatusViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lio/intercom/android/sdk/views/holder/ConversationPartViewHolder;", "itemView", "Landroid/view/View;", "timeFormatter", "Lio/intercom/android/sdk/utilities/TimeFormatter;", "(Landroid/view/View;Lio/intercom/android/sdk/utilities/TimeFormatter;)V", "getItemView", "()Landroid/view/View;", "getTimeFormatter", "()Lio/intercom/android/sdk/utilities/TimeFormatter;", "bind", "", "part", "Lio/intercom/android/sdk/models/Part;", "blocksLayout", "Landroid/view/ViewGroup;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketStatusViewHolder.kt */
public final class TicketStatusViewHolder extends RecyclerView.ViewHolder implements ConversationPartViewHolder {
    private final View itemView;
    private final TimeFormatter timeFormatter;

    public final View getItemView() {
        return this.itemView;
    }

    public final TimeFormatter getTimeFormatter() {
        return this.timeFormatter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TicketStatusViewHolder(View view, TimeFormatter timeFormatter2) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(timeFormatter2, "timeFormatter");
        this.itemView = view;
        this.timeFormatter = timeFormatter2;
    }

    public void bind(Part part, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(viewGroup, "blocksLayout");
        ((ComposeView) this.itemView.findViewById(R.id.compose_view)).setContent(ComposableLambdaKt.composableLambdaInstance(1037819344, true, new TicketStatusViewHolder$bind$1$1(part, this)));
    }
}
