package androidx.compose.ui.node;

import androidx.compose.ui.layout.Measurable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/Measurable;", "it", "Landroidx/compose/ui/node/LayoutNode;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
final class LayoutNodeLayoutDelegate$MeasurePassDelegate$childMeasurables$1 extends Lambda implements Function1<LayoutNode, Measurable> {
    public static final LayoutNodeLayoutDelegate$MeasurePassDelegate$childMeasurables$1 INSTANCE = new LayoutNodeLayoutDelegate$MeasurePassDelegate$childMeasurables$1();

    LayoutNodeLayoutDelegate$MeasurePassDelegate$childMeasurables$1() {
        super(1);
    }

    public final Measurable invoke(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "it");
        return layoutNode.getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release();
    }
}
