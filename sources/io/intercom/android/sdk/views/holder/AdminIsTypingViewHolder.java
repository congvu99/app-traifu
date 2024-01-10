package io.intercom.android.sdk.views.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.views.AdminIsTypingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/views/holder/AdminIsTypingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lio/intercom/android/sdk/views/holder/ConversationPartViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "part", "Lio/intercom/android/sdk/models/Part;", "blocksLayout", "Landroid/view/ViewGroup;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdminIsTypingViewHolder.kt */
public final class AdminIsTypingViewHolder extends RecyclerView.ViewHolder implements ConversationPartViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdminIsTypingViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    public void bind(Part part, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(viewGroup, "blocksLayout");
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
        ((ComposeView) view).setContent(ComposableLambdaKt.composableLambdaInstance(632180576, true, new AdminIsTypingViewHolder$bind$1(part, viewGroup)));
        View childAt = viewGroup.getChildAt(0);
        AdminIsTypingView adminIsTypingView = childAt instanceof AdminIsTypingView ? (AdminIsTypingView) childAt : null;
        if (adminIsTypingView != null) {
            adminIsTypingView.beginAnimation();
        }
    }
}
