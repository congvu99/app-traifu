package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextFieldSize.kt */
final class TextFieldSizeKt$textFieldMinSize$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ TextStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSizeKt$textFieldMinSize$1(TextStyle textStyle) {
        super(3);
        this.$style = textStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: androidx.compose.runtime.State} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: androidx.compose.foundation.text.TextFieldSize} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r11, androidx.compose.runtime.Composer r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r11 = 1582736677(0x5e56a525, float:3.86670229E18)
            r12.startReplaceableGroup(r11)
            java.lang.String r0 = "C39@1626L7,40@1687L7,41@1742L7,43@1775L88,46@1884L312,55@2221L101:TextFieldSize.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x001c
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.text.textFieldMinSize.<anonymous> (TextFieldSize.kt:38)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r13, r0, r1)
        L_0x001c:
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r0 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r13, r0)
            java.lang.Object r11 = r12.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r13, r0)
            java.lang.Object r1 = r12.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            r7 = r1
            androidx.compose.ui.text.font.FontFamily$Resolver r7 = (androidx.compose.ui.text.font.FontFamily.Resolver) r7
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r13, r0)
            java.lang.Object r13 = r12.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.LayoutDirection r13 = (androidx.compose.ui.unit.LayoutDirection) r13
            androidx.compose.ui.text.TextStyle r0 = r10.$style
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r1)
            java.lang.String r2 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            boolean r3 = r12.changed((java.lang.Object) r0)
            boolean r4 = r12.changed((java.lang.Object) r13)
            r3 = r3 | r4
            java.lang.Object r4 = r12.rememberedValue()
            if (r3 != 0) goto L_0x007c
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0083
        L_0x007c:
            androidx.compose.ui.text.TextStyle r4 = androidx.compose.ui.text.TextStyleKt.resolveDefaults(r0, r13)
            r12.updateRememberedValue(r4)
        L_0x0083:
            r12.endReplaceableGroup()
            r0 = r4
            androidx.compose.ui.text.TextStyle r0 = (androidx.compose.ui.text.TextStyle) r0
            r12.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            boolean r1 = r12.changed((java.lang.Object) r7)
            boolean r2 = r12.changed((java.lang.Object) r0)
            r1 = r1 | r2
            java.lang.Object r2 = r12.rememberedValue()
            if (r1 != 0) goto L_0x00a6
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x00df
        L_0x00a6:
            androidx.compose.ui.text.font.FontFamily r1 = r0.getFontFamily()
            androidx.compose.ui.text.font.FontWeight r2 = r0.getFontWeight()
            if (r2 != 0) goto L_0x00b6
            androidx.compose.ui.text.font.FontWeight$Companion r2 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r2 = r2.getNormal()
        L_0x00b6:
            androidx.compose.ui.text.font.FontStyle r3 = r0.m4240getFontStyle4Lr2A7w()
            if (r3 == 0) goto L_0x00c1
            int r3 = r3.m4311unboximpl()
            goto L_0x00c7
        L_0x00c1:
            androidx.compose.ui.text.font.FontStyle$Companion r3 = androidx.compose.ui.text.font.FontStyle.Companion
            int r3 = r3.m4313getNormal_LCdwA()
        L_0x00c7:
            androidx.compose.ui.text.font.FontSynthesis r4 = r0.m4241getFontSynthesisZQGJjVo()
            if (r4 == 0) goto L_0x00d2
            int r4 = r4.m4322unboximpl()
            goto L_0x00d8
        L_0x00d2:
            androidx.compose.ui.text.font.FontSynthesis$Companion r4 = androidx.compose.ui.text.font.FontSynthesis.Companion
            int r4 = r4.m4323getAllGVVA2EU()
        L_0x00d8:
            androidx.compose.runtime.State r2 = r7.m4283resolveDPcqOEQ(r1, r2, r3, r4)
            r12.updateRememberedValue(r2)
        L_0x00df:
            r12.endReplaceableGroup()
            r8 = r2
            androidx.compose.runtime.State r8 = (androidx.compose.runtime.State) r8
            androidx.compose.ui.text.TextStyle r5 = r10.$style
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            java.lang.Object r1 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x010e
            androidx.compose.foundation.text.TextFieldSize r9 = new androidx.compose.foundation.text.TextFieldSize
            java.lang.Object r6 = m958invoke$lambda2(r8)
            r1 = r9
            r2 = r13
            r3 = r11
            r4 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r12.updateRememberedValue(r9)
        L_0x010e:
            r12.endReplaceableGroup()
            r9 = r1
            androidx.compose.foundation.text.TextFieldSize r9 = (androidx.compose.foundation.text.TextFieldSize) r9
            java.lang.Object r6 = m958invoke$lambda2(r8)
            r1 = r9
            r2 = r13
            r3 = r11
            r4 = r7
            r5 = r0
            r1.update(r2, r3, r4, r5, r6)
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1 r13 = new androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1
            r13.<init>(r9)
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.layout.LayoutModifierKt.layout(r11, r13)
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x0138
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0138:
            r12.endReplaceableGroup()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final Object m958invoke$lambda2(State<? extends Object> state) {
        return state.getValue();
    }
}
