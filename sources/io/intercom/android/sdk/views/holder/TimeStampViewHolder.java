package io.intercom.android.sdk.views.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.TimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/intercom/android/sdk/views/holder/TimeStampViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lio/intercom/android/sdk/views/holder/ConversationPartViewHolder;", "itemView", "Landroid/view/View;", "timeFormatter", "Lio/intercom/android/sdk/utilities/TimeFormatter;", "(Landroid/view/View;Lio/intercom/android/sdk/utilities/TimeFormatter;)V", "bind", "", "part", "Lio/intercom/android/sdk/models/Part;", "blocksLayout", "Landroid/view/ViewGroup;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TimeStampViewHolder.kt */
public final class TimeStampViewHolder extends RecyclerView.ViewHolder implements ConversationPartViewHolder {
    /* access modifiers changed from: private */
    public final TimeFormatter timeFormatter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeStampViewHolder(View view, TimeFormatter timeFormatter2) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(timeFormatter2, "timeFormatter");
        this.timeFormatter = timeFormatter2;
    }

    public void bind(Part part, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(viewGroup, "blocksLayout");
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
        ((ComposeView) view).setContent(ComposableLambdaKt.composableLambdaInstance(1865382918, true, new TimeStampViewHolder$bind$1$1(this, part)));
    }
}
