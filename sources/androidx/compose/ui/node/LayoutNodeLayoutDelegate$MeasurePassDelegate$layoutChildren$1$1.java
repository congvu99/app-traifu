package androidx.compose.ui.node;

import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
final class LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LayoutNode $this_with;
    final /* synthetic */ LayoutNodeLayoutDelegate this$0;
    final /* synthetic */ LayoutNodeLayoutDelegate.MeasurePassDelegate this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate, LayoutNode layoutNode) {
        super(0);
        this.this$0 = layoutNodeLayoutDelegate;
        this.this$1 = measurePassDelegate;
        this.$this_with = layoutNode;
    }

    public final void invoke() {
        this.this$0.layoutNode.clearPlaceOrder$ui_release();
        this.this$1.forEachChildAlignmentLinesOwner(AnonymousClass1.INSTANCE);
        this.$this_with.getInnerCoordinator$ui_release().getMeasureResult$ui_release().placeChildren();
        this.this$0.layoutNode.checkChildrenPlaceOrderForUpdates$ui_release();
        this.this$1.forEachChildAlignmentLinesOwner(AnonymousClass2.INSTANCE);
    }
}
