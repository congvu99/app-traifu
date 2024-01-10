package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LookaheadLayout.kt */
final class LookaheadLayoutKt$LookaheadLayout$1$1 extends Lambda implements Function2<LayoutNode, LookaheadLayoutScopeImpl, Unit> {
    public static final LookaheadLayoutKt$LookaheadLayout$1$1 INSTANCE = new LookaheadLayoutKt$LookaheadLayout$1$1();

    LookaheadLayoutKt$LookaheadLayout$1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (LookaheadLayoutScopeImpl) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNode layoutNode, LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl) {
        Intrinsics.checkNotNullParameter(layoutNode, "$this$set");
        Intrinsics.checkNotNullParameter(lookaheadLayoutScopeImpl, "scope");
        lookaheadLayoutScopeImpl.setRoot(layoutNode.getInnerCoordinator$ui_release());
    }
}
