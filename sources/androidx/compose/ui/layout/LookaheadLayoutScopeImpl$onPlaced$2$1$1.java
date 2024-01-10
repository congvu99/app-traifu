package androidx.compose.ui.layout;

import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LookaheadLayout.kt */
final class LookaheadLayoutScopeImpl$onPlaced$2$1$1 extends Lambda implements Function0<LookaheadLayoutCoordinates> {
    final /* synthetic */ LookaheadLayoutScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LookaheadLayoutScopeImpl$onPlaced$2$1$1(LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl) {
        super(0);
        this.this$0 = lookaheadLayoutScopeImpl;
    }

    public final LookaheadLayoutCoordinates invoke() {
        NodeCoordinator root = this.this$0.getRoot();
        if (root != null) {
            LookaheadDelegate lookaheadDelegate$ui_release = root.getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates = lookaheadDelegate$ui_release.getLookaheadLayoutCoordinates();
            if (lookaheadLayoutCoordinates != null) {
                return lookaheadLayoutCoordinates;
            }
        }
        throw new IllegalStateException("Lookahead root has not been set up yet".toString());
    }
}
