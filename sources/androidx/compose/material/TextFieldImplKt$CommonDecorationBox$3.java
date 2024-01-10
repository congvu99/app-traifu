package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$3 extends Lambda implements Function6<Float, Color, Color, Float, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $border;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $innerTextField;
    final /* synthetic */ InteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ boolean $shouldOverrideTextStyleColor;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ String $transformedText;
    final /* synthetic */ TextFieldType $type;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextFieldType.values().length];
            iArr[TextFieldType.Filled.ordinal()] = 1;
            iArr[TextFieldType.Outlined.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, String str, boolean z, int i, TextFieldColors textFieldColors, boolean z2, InteractionSource interactionSource, int i2, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, TextFieldType textFieldType, Function2<? super Composer, ? super Integer, Unit> function25, boolean z3, PaddingValues paddingValues, boolean z4, Function2<? super Composer, ? super Integer, Unit> function26) {
        super(6);
        this.$label = function2;
        this.$placeholder = function22;
        this.$transformedText = str;
        this.$isError = z;
        this.$$dirty1 = i;
        this.$colors = textFieldColors;
        this.$enabled = z2;
        this.$interactionSource = interactionSource;
        this.$$dirty = i2;
        this.$leadingIcon = function23;
        this.$trailingIcon = function24;
        this.$type = textFieldType;
        this.$innerTextField = function25;
        this.$singleLine = z3;
        this.$contentPadding = paddingValues;
        this.$shouldOverrideTextStyleColor = z4;
        this.$border = function26;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        m1482invokeRIQooxk(((Number) obj).floatValue(), ((Color) obj2).m1942unboximpl(), ((Color) obj3).m1942unboximpl(), ((Number) obj4).floatValue(), (Composer) obj5, ((Number) obj6).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0308  */
    /* renamed from: invoke-RIQooxk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1482invokeRIQooxk(float r21, long r22, long r24, float r26, androidx.compose.runtime.Composer r27, int r28) {
        /*
            r20 = this;
            r0 = r20
            r10 = r21
            r15 = r27
            r1 = r28
            java.lang.String r2 = "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)149@6201L30,150@6287L43:TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r1 & 14
            if (r2 != 0) goto L_0x001c
            boolean r2 = r15.changed((float) r10)
            if (r2 == 0) goto L_0x0019
            r2 = 4
            goto L_0x001a
        L_0x0019:
            r2 = 2
        L_0x001a:
            r2 = r2 | r1
            goto L_0x001d
        L_0x001c:
            r2 = r1
        L_0x001d:
            r3 = r1 & 112(0x70, float:1.57E-43)
            r8 = r22
            if (r3 != 0) goto L_0x002f
            boolean r3 = r15.changed((long) r8)
            if (r3 == 0) goto L_0x002c
            r3 = 32
            goto L_0x002e
        L_0x002c:
            r3 = 16
        L_0x002e:
            r2 = r2 | r3
        L_0x002f:
            r3 = r1 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0042
            r3 = r24
            boolean r5 = r15.changed((long) r3)
            if (r5 == 0) goto L_0x003e
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0040
        L_0x003e:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0040:
            r2 = r2 | r5
            goto L_0x0044
        L_0x0042:
            r3 = r24
        L_0x0044:
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r12 = r26
            if (r1 != 0) goto L_0x0056
            boolean r1 = r15.changed((float) r12)
            if (r1 == 0) goto L_0x0053
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x0055
        L_0x0053:
            r1 = 1024(0x400, float:1.435E-42)
        L_0x0055:
            r2 = r2 | r1
        L_0x0056:
            r13 = r2
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r1 & r13
            r2 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r2) goto L_0x006b
            boolean r1 = r27.getSkipping()
            if (r1 != 0) goto L_0x0066
            goto L_0x006b
        L_0x0066:
            r27.skipToGroupEnd()
            goto L_0x0348
        L_0x006b:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r5 = r0.$label
            r7 = 1
            if (r5 == 0) goto L_0x0093
            boolean r6 = r0.$shouldOverrideTextStyleColor
            r2 = 362863774(0x15a0dc9e, float:6.497156E-26)
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1 r1 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
            r28 = r1
            r11 = 362863774(0x15a0dc9e, float:6.497156E-26)
            r2 = r21
            r3 = r24
            r17 = r6
            r6 = r13
            r14 = 1
            r7 = r17
            r8 = r22
            r1.<init>(r2, r3, r5, r6, r7, r8)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r11, r14, r1)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r11 = r1
            goto L_0x0095
        L_0x0093:
            r14 = 1
            r11 = 0
        L_0x0095:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$placeholder
            r2 = 0
            if (r1 == 0) goto L_0x00cb
            java.lang.String r1 = r0.$transformedText
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00a6
            r7 = 1
            goto L_0x00a7
        L_0x00a6:
            r7 = 0
        L_0x00a7:
            if (r7 == 0) goto L_0x00cb
            r1 = 1120552650(0x42ca46ca, float:101.13826)
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1 r9 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
            androidx.compose.material.TextFieldColors r5 = r0.$colors
            boolean r6 = r0.$enabled
            int r7 = r0.$$dirty
            int r8 = r0.$$dirty1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r0.$placeholder
            r3 = r9
            r17 = r4
            r4 = r26
            r12 = r9
            r9 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r1, r14, r12)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r7 = r1
            goto L_0x00cc
        L_0x00cb:
            r7 = 0
        L_0x00cc:
            androidx.compose.material.Strings$Companion r1 = androidx.compose.material.Strings.Companion
            int r1 = r1.m1412getDefaultErrorMessageUdPEhr4()
            r8 = 6
            java.lang.String r1 = androidx.compose.material.Strings_androidKt.m1417getString4foXLRw(r1, r15, r8)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            boolean r4 = r0.$isError
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            boolean r5 = r0.$isError
            r9 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r15.startReplaceableGroup(r9)
            java.lang.String r12 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r12)
            boolean r4 = r15.changed((java.lang.Object) r4)
            boolean r6 = r15.changed((java.lang.Object) r1)
            r4 = r4 | r6
            java.lang.Object r6 = r27.rememberedValue()
            if (r4 != 0) goto L_0x0105
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r6 != r4) goto L_0x0110
        L_0x0105:
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1 r4 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1
            r4.<init>(r5, r1)
            r6 = r4
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r15.updateRememberedValue(r6)
        L_0x0110:
            r27.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r1 = 0
            androidx.compose.ui.Modifier r17 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r3, r2, r6, r14, r1)
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r1 = r1 instanceof androidx.compose.material.TextFieldColorsWithIcons
            if (r1 == 0) goto L_0x015c
            r1 = -1083197894(0xffffffffbf6fb63a, float:-0.9363743)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "153@6424L53"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            androidx.compose.material.TextFieldColorsWithIcons r1 = (androidx.compose.material.TextFieldColorsWithIcons) r1
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r4 = r0.$interactionSource
            int r5 = r0.$$dirty
            int r5 = r5 >> 27
            r5 = r5 & 14
            int r6 = r0.$$dirty1
            int r18 = r6 << 3
            r18 = r18 & 112(0x70, float:1.57E-43)
            r5 = r5 | r18
            int r6 = r6 << 3
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | r5
            r5 = r27
            androidx.compose.runtime.State r1 = r1.leadingIconColor(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m1942unboximpl()
            r27.endReplaceableGroup()
            goto L_0x0190
        L_0x015c:
            r1 = -1083197798(0xffffffffbf6fb69a, float:-0.93638)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "155@6520L34"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            int r4 = r0.$$dirty
            int r4 = r4 >> 27
            r4 = r4 & 14
            int r5 = r0.$$dirty1
            int r6 = r5 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            int r5 = r5 >> 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            androidx.compose.runtime.State r1 = r1.leadingIconColor(r2, r3, r15, r4)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m1942unboximpl()
            r27.endReplaceableGroup()
        L_0x0190:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$leadingIcon
            if (r3 == 0) goto L_0x01a5
            r4 = 1505327088(0x59b977f0, float:6.5255929E15)
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1 r5 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
            r5.<init>(r1, r3)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r4, r14, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r18 = r1
            goto L_0x01a7
        L_0x01a5:
            r18 = 0
        L_0x01a7:
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r1 = r1 instanceof androidx.compose.material.TextFieldColorsWithIcons
            if (r1 == 0) goto L_0x01e9
            r1 = -1083197452(0xffffffffbf6fb7f4, float:-0.93640065)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "164@6866L54"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            androidx.compose.material.TextFieldColorsWithIcons r1 = (androidx.compose.material.TextFieldColorsWithIcons) r1
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            androidx.compose.foundation.interaction.InteractionSource r4 = r0.$interactionSource
            int r5 = r0.$$dirty
            int r5 = r5 >> 27
            r5 = r5 & 14
            int r6 = r0.$$dirty1
            int r19 = r6 << 3
            r19 = r19 & 112(0x70, float:1.57E-43)
            r5 = r5 | r19
            int r6 = r6 << 3
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | r5
            r5 = r27
            androidx.compose.runtime.State r1 = r1.trailingIconColor(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m1942unboximpl()
            r27.endReplaceableGroup()
            goto L_0x021d
        L_0x01e9:
            r1 = -1083197355(0xffffffffbf6fb855, float:-0.93640643)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "166@6963L35"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            int r4 = r0.$$dirty
            int r4 = r4 >> 27
            r4 = r4 & 14
            int r5 = r0.$$dirty1
            int r6 = r5 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            int r5 = r5 >> 3
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            androidx.compose.runtime.State r1 = r1.trailingIconColor(r2, r3, r15, r4)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m1942unboximpl()
            r27.endReplaceableGroup()
        L_0x021d:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$trailingIcon
            if (r3 == 0) goto L_0x0231
            r4 = -1894727196(0xffffffff8f10c1e4, float:-7.13709E-30)
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1 r5 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
            r5.<init>(r1, r3)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r4, r14, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r6 = r1
            goto L_0x0232
        L_0x0231:
            r6 = 0
        L_0x0232:
            androidx.compose.material.TextFieldType r1 = r0.$type
            int[] r2 = androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            if (r1 == r14) goto L_0x0308
            r4 = 2
            if (r1 == r4) goto L_0x024e
            r1 = -1083194976(0xffffffffbf6fc1a0, float:-0.93654823)
            r15.startReplaceableGroup(r1)
            r27.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x0348
        L_0x024e:
            r1 = -1083196463(0xffffffffbf6fbbd1, float:-0.9364596)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "190@7903L38,208@8711L420,200@8303L994"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            java.lang.Object r1 = r27.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r1 != r4) goto L_0x0283
            androidx.compose.ui.geometry.Size$Companion r1 = androidx.compose.ui.geometry.Size.Companion
            long r4 = r1.m1761getZeroNHjbRc()
            androidx.compose.ui.geometry.Size r1 = androidx.compose.ui.geometry.Size.m1740boximpl(r4)
            r4 = 2
            r5 = 0
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r5, r4, r5)
            r15.updateRememberedValue(r1)
        L_0x0283:
            r27.endReplaceableGroup()
            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
            r4 = 139886979(0x8568183, float:6.4550523E-34)
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1 r5 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
            androidx.compose.foundation.layout.PaddingValues r2 = r0.$contentPadding
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$border
            int r8 = r0.$$dirty1
            r5.<init>(r1, r2, r3, r8)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r4, r14, r5)
            r14 = r2
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.$innerTextField
            boolean r8 = r0.$singleLine
            java.lang.Float r3 = java.lang.Float.valueOf(r21)
            r15.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r12)
            boolean r3 = r15.changed((java.lang.Object) r3)
            boolean r4 = r15.changed((java.lang.Object) r1)
            r3 = r3 | r4
            java.lang.Object r4 = r27.rememberedValue()
            if (r3 != 0) goto L_0x02c2
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x02cd
        L_0x02c2:
            androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1 r3 = new androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
            r3.<init>(r10, r1)
            r4 = r3
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r15.updateRememberedValue(r4)
        L_0x02cd:
            r27.endReplaceableGroup()
            r9 = r4
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.foundation.layout.PaddingValues r12 = r0.$contentPadding
            r1 = 805306368(0x30000000, float:4.656613E-10)
            int r3 = r0.$$dirty
            int r4 = r3 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            r1 = r1 | r4
            r4 = 6
            int r3 = r3 >> r4
            r5 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r5
            r1 = r1 | r3
            int r3 = r13 << 21
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r5
            r13 = r1 | r3
            int r1 = r0.$$dirty1
            int r1 = r1 >> r4
            r16 = r1 & 14
            r1 = r17
            r3 = r7
            r4 = r11
            r5 = r18
            r7 = r8
            r8 = r21
            r10 = r14
            r11 = r12
            r12 = r27
            r14 = r16
            androidx.compose.material.OutlinedTextFieldKt.OutlinedTextFieldLayout(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r27.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x0348
        L_0x0308:
            r1 = -1083197019(0xffffffffbf6fb9a5, float:-0.93642646)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "176@7296L485"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.$innerTextField
            boolean r8 = r0.$singleLine
            androidx.compose.foundation.layout.PaddingValues r9 = r0.$contentPadding
            int r1 = r0.$$dirty
            int r3 = r1 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r4 = 6
            int r1 = r1 >> r4
            r4 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r4
            r1 = r1 | r3
            int r3 = r13 << 21
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r4
            r1 = r1 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            int r4 = r0.$$dirty1
            int r4 = r4 << 18
            r3 = r3 & r4
            r12 = r1 | r3
            r1 = r17
            r3 = r11
            r4 = r7
            r5 = r18
            r7 = r8
            r8 = r21
            r10 = r27
            r11 = r12
            androidx.compose.material.TextFieldKt.TextFieldLayout(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r27.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0348:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3.m1482invokeRIQooxk(float, long, long, float, androidx.compose.runtime.Composer, int):void");
    }
}
