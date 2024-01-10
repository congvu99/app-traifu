package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextFieldScroll.kt */
final class TextFieldScrollKt$textFieldScrollable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldScrollKt$textFieldScrollable$2(TextFieldScrollerPosition textFieldScrollerPosition, boolean z, MutableInteractionSource mutableInteractionSource) {
        super(3);
        this.$scrollerPosition = textFieldScrollerPosition;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r13, androidx.compose.runtime.Composer r14, int r15) {
        /*
            r12 = this;
            java.lang.String r0 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r13 = 805428266(0x3001dc2a, float:4.72428E-10)
            r14.startReplaceableGroup(r13)
            java.lang.String r0 = "C64@2701L7,66@2865L388,66@2841L412:TextFieldScroll.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x001c
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:62)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r15, r0, r1)
        L_0x001c:
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r0 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r15, r0)
            java.lang.Object r13 = r14.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r15 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r0 = 1
            r1 = 0
            if (r13 != r15) goto L_0x0039
            r13 = 1
            goto L_0x003a
        L_0x0039:
            r13 = 0
        L_0x003a:
            androidx.compose.foundation.text.TextFieldScrollerPosition r15 = r12.$scrollerPosition
            androidx.compose.foundation.gestures.Orientation r15 = r15.getOrientation()
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r15 == r2) goto L_0x0049
            if (r13 != 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r7 = 0
            goto L_0x004a
        L_0x0049:
            r7 = 1
        L_0x004a:
            androidx.compose.foundation.text.TextFieldScrollerPosition r13 = r12.$scrollerPosition
            r15 = 1157296644(0x44faf204, float:2007.563)
            r14.startReplaceableGroup(r15)
            java.lang.String r15 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r15)
            boolean r15 = r14.changed((java.lang.Object) r13)
            java.lang.Object r2 = r14.rememberedValue()
            if (r15 != 0) goto L_0x0069
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r2 != r15) goto L_0x0074
        L_0x0069:
            androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$controller$1$1 r15 = new androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$controller$1$1
            r15.<init>(r13)
            r2 = r15
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r14.updateRememberedValue(r2)
        L_0x0074:
            r14.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.foundation.gestures.ScrollableState r4 = androidx.compose.foundation.gestures.ScrollableStateKt.rememberScrollableState(r2, r14, r1)
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.text.TextFieldScrollerPosition r15 = r12.$scrollerPosition
            androidx.compose.foundation.gestures.Orientation r5 = r15.getOrientation()
            boolean r15 = r12.$enabled
            if (r15 == 0) goto L_0x009b
            androidx.compose.foundation.text.TextFieldScrollerPosition r15 = r12.$scrollerPosition
            float r15 = r15.getMaximum()
            r2 = 0
            int r15 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
            if (r15 != 0) goto L_0x0096
            r15 = 1
            goto L_0x0097
        L_0x0096:
            r15 = 0
        L_0x0097:
            if (r15 != 0) goto L_0x009b
            r6 = 1
            goto L_0x009c
        L_0x009b:
            r6 = 0
        L_0x009c:
            r3 = r13
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r8 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r12.$interactionSource
            r10 = 16
            r11 = 0
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.gestures.ScrollableKt.scrollable$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x00b2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00b2:
            r14.endReplaceableGroup()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
