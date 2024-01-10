package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;

@ExperimentalComposeUiApi
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "onMeasureResultChanged", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DrawModifierNode.kt */
public interface DrawModifierNode extends DelegatableNode {

    /* renamed from: androidx.compose.ui.node.DrawModifierNode$-CC  reason: invalid class name */
    /* compiled from: DrawModifierNode.kt */
    public final /* synthetic */ class CC {
        public static void $default$onMeasureResultChanged(DrawModifierNode drawModifierNode) {
        }
    }

    void draw(ContentDrawScope contentDrawScope);

    void onMeasureResultChanged();
}
