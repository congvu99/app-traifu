package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "owner", "Landroidx/compose/ui/node/Owner;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
final class AndroidViewHolder$layoutNode$1$4 extends Lambda implements Function1<Owner, Unit> {
    final /* synthetic */ AndroidViewHolder $this_run;
    final /* synthetic */ Ref.ObjectRef<View> $viewRemovedOnDetach;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$layoutNode$1$4(AndroidViewHolder androidViewHolder, Ref.ObjectRef<View> objectRef) {
        super(1);
        this.$this_run = androidViewHolder;
        this.$viewRemovedOnDetach = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Owner) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Owner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
        if (androidComposeView != null) {
            androidComposeView.removeAndroidView(this.$this_run);
        }
        this.$viewRemovedOnDetach.element = this.$this_run.getView();
        this.$this_run.setView$ui_release((View) null);
    }
}
