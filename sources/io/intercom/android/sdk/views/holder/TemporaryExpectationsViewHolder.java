package io.intercom.android.sdk.views.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.Part;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lio/intercom/android/sdk/views/holder/TemporaryExpectationsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lio/intercom/android/sdk/views/holder/ConversationPartViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "bind", "", "part", "Lio/intercom/android/sdk/models/Part;", "blocksLayout", "Landroid/view/ViewGroup;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TemporaryExpectationsViewHolder.kt */
public final class TemporaryExpectationsViewHolder extends RecyclerView.ViewHolder implements ConversationPartViewHolder {
    private final View itemView;

    public final View getItemView() {
        return this.itemView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TemporaryExpectationsViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.itemView = view;
    }

    public void bind(Part part, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(viewGroup, "blocksLayout");
        ((ComposeView) this.itemView.findViewById(R.id.compose_view)).setContent(ComposableLambdaKt.composableLambdaInstance(-1096380126, true, new TemporaryExpectationsViewHolder$bind$1$1(part)));
    }
}
