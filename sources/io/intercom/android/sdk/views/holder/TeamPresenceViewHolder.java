package io.intercom.android.sdk.views.holder;

import android.view.View;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/views/holder/TeamPresenceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "bind", "", "teamPresenceState", "Lio/intercom/android/sdk/views/holder/TeamPresenceState;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TeamPresenceViewHolder.kt */
public final class TeamPresenceViewHolder extends RecyclerView.ViewHolder {
    private final View itemView;

    public final View getItemView() {
        return this.itemView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TeamPresenceViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.itemView = view;
    }

    public final void bind(TeamPresenceState teamPresenceState) {
        ComposeView composeView = (ComposeView) this.itemView.findViewById(R.id.compose_view);
        if (teamPresenceState != null) {
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-777785657, true, new TeamPresenceViewHolder$bind$1$1(teamPresenceState)));
        }
    }
}
