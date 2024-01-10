package androidx.compose.ui.node;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/Measurable;", "it", "Landroidx/compose/ui/node/LayoutNode;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
final class LayoutNodeLayoutDelegate$LookaheadPassDelegate$childMeasurables$2 extends Lambda implements Function1<LayoutNode, Measurable> {
    public static final LayoutNodeLayoutDelegate$LookaheadPassDelegate$childMeasurables$2 INSTANCE = new LayoutNodeLayoutDelegate$LookaheadPassDelegate$childMeasurables$2();

    LayoutNodeLayoutDelegate$LookaheadPassDelegate$childMeasurables$2() {
        super(1);
    }

    public final Measurable invoke(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "it");
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        return lookaheadPassDelegate$ui_release;
    }
}
