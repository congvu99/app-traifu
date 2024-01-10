package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextFieldCursor.kt */
final class TextFieldCursorKt$cursor$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Brush $cursorBrush;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldCursorKt$cursor$1(Brush brush, TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        super(3);
        this.$cursorBrush = brush;
        this.$state = textFieldState;
        this.$value = textFieldValue;
        this.$offsetMapping = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0060, code lost:
        if ((((androidx.compose.ui.graphics.SolidColor) r12).m2269getValue0d7_KjU() == androidx.compose.ui.graphics.Color.Companion.m1968getUnspecified0d7_KjU()) == false) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r10, androidx.compose.runtime.Composer r11, int r12) {
        /*
            r9 = this;
            java.lang.String r0 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1634330012(0x6169e59c, float:2.6966478E20)
            r11.startReplaceableGroup(r0)
            java.lang.String r1 = "C44@1689L27,47@1891L326:TextFieldCursor.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x001c
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:43)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r1, r2)
        L_0x001c:
            r12 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            java.lang.Object r12 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            r1 = 0
            if (r12 != r0) goto L_0x003f
            r12 = 1065353216(0x3f800000, float:1.0)
            r0 = 0
            r2 = 2
            androidx.compose.animation.core.Animatable r12 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r12, r0, r2, r1)
            r11.updateRememberedValue(r12)
        L_0x003f:
            r11.endReplaceableGroup()
            r3 = r12
            androidx.compose.animation.core.Animatable r3 = (androidx.compose.animation.core.Animatable) r3
            androidx.compose.ui.graphics.Brush r12 = r9.$cursorBrush
            boolean r0 = r12 instanceof androidx.compose.ui.graphics.SolidColor
            r2 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0062
            androidx.compose.ui.graphics.SolidColor r12 = (androidx.compose.ui.graphics.SolidColor) r12
            long r5 = r12.m2269getValue0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r12.m1968getUnspecified0d7_KjU()
            int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x005f
            r12 = 1
            goto L_0x0060
        L_0x005f:
            r12 = 0
        L_0x0060:
            if (r12 != 0) goto L_0x0063
        L_0x0062:
            r2 = 1
        L_0x0063:
            androidx.compose.foundation.text.TextFieldState r12 = r9.$state
            boolean r12 = r12.getHasFocus()
            if (r12 == 0) goto L_0x00aa
            androidx.compose.ui.text.input.TextFieldValue r12 = r9.$value
            long r4 = r12.m4422getSelectiond9O1mEE()
            boolean r12 = androidx.compose.ui.text.TextRange.m4214getCollapsedimpl(r4)
            if (r12 == 0) goto L_0x00aa
            if (r2 == 0) goto L_0x00aa
            androidx.compose.ui.text.input.TextFieldValue r12 = r9.$value
            androidx.compose.ui.text.AnnotatedString r12 = r12.getAnnotatedString()
            androidx.compose.ui.text.input.TextFieldValue r0 = r9.$value
            long r4 = r0.m4422getSelectiond9O1mEE()
            androidx.compose.ui.text.TextRange r0 = androidx.compose.ui.text.TextRange.m4208boximpl(r4)
            androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1 r2 = new androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1
            r2.<init>(r3, r1)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r1 = 512(0x200, float:7.175E-43)
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r12, r0, r2, r11, r1)
            androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$2 r12 = new androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$2
            androidx.compose.ui.text.input.OffsetMapping r4 = r9.$offsetMapping
            androidx.compose.ui.text.input.TextFieldValue r5 = r9.$value
            androidx.compose.foundation.text.TextFieldState r6 = r9.$state
            androidx.compose.ui.graphics.Brush r7 = r9.$cursorBrush
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            androidx.compose.ui.Modifier r10 = androidx.compose.ui.draw.DrawModifierKt.drawWithContent(r10, r12)
            goto L_0x00ae
        L_0x00aa:
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
        L_0x00ae:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x00b7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00b7:
            r11.endReplaceableGroup()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
