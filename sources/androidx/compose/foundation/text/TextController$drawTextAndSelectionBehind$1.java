package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoreText.kt */
final class TextController$drawTextAndSelectionBehind$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ TextController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextController$drawTextAndSelectionBehind$1(TextController textController) {
        super(1);
        this.this$0 = textController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0020, code lost:
        r2 = r2.getSubselections();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.ui.graphics.drawscope.DrawScope r12) {
        /*
            r11 = this;
            java.lang.String r0 = "$this$drawBehind"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            androidx.compose.foundation.text.TextController r0 = r11.this$0
            androidx.compose.foundation.text.TextState r0 = r0.getState()
            androidx.compose.ui.text.TextLayoutResult r0 = r0.getLayoutResult()
            if (r0 == 0) goto L_0x0094
            androidx.compose.foundation.text.TextController r1 = r11.this$0
            androidx.compose.foundation.text.TextState r2 = r1.getState()
            r2.getDrawScopeInvalidation()
            androidx.compose.foundation.text.selection.SelectionRegistrar r2 = r1.selectionRegistrar
            if (r2 == 0) goto L_0x0039
            java.util.Map r2 = r2.getSubselections()
            if (r2 == 0) goto L_0x0039
            androidx.compose.foundation.text.TextState r3 = r1.getState()
            long r3 = r3.getSelectableId()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object r2 = r2.get(r3)
            androidx.compose.foundation.text.selection.Selection r2 = (androidx.compose.foundation.text.selection.Selection) r2
            goto L_0x003a
        L_0x0039:
            r2 = 0
        L_0x003a:
            if (r2 == 0) goto L_0x0087
            boolean r3 = r2.getHandlesCrossed()
            if (r3 != 0) goto L_0x004b
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r3 = r2.getStart()
            int r3 = r3.getOffset()
            goto L_0x0053
        L_0x004b:
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r3 = r2.getEnd()
            int r3 = r3.getOffset()
        L_0x0053:
            boolean r4 = r2.getHandlesCrossed()
            if (r4 != 0) goto L_0x0062
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r2 = r2.getEnd()
            int r2 = r2.getOffset()
            goto L_0x006a
        L_0x0062:
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r2 = r2.getStart()
            int r2 = r2.getOffset()
        L_0x006a:
            if (r3 == r2) goto L_0x0087
            androidx.compose.ui.text.MultiParagraph r4 = r0.getMultiParagraph()
            androidx.compose.ui.graphics.Path r2 = r4.getPathForRange(r3, r2)
            androidx.compose.foundation.text.TextState r1 = r1.getState()
            long r3 = r1.m973getSelectionBackgroundColor0d7_KjU()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 60
            r10 = 0
            r1 = r12
            androidx.compose.ui.graphics.drawscope.DrawScope.CC.m2510drawPathLG529CI$default(r1, r2, r3, r5, r6, r7, r8, r9, r10)
        L_0x0087:
            androidx.compose.ui.graphics.drawscope.DrawContext r1 = r12.getDrawContext()
            androidx.compose.ui.graphics.Canvas r1 = r1.getCanvas()
            androidx.compose.foundation.text.TextDelegate$Companion r2 = androidx.compose.foundation.text.TextDelegate.Companion
            r2.paint(r1, r0)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextController$drawTextAndSelectionBehind$1.invoke(androidx.compose.ui.graphics.drawscope.DrawScope):void");
    }
}
