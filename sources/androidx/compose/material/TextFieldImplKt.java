package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aß\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&2\u0006\u0010'\u001a\u00020(2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&H\u0001¢\u0006\u0002\u00108\u001aW\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2 \u0010@\u001a\u001c\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0000H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010D\u001a\u0012\u0010E\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u0012\u0010H\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0013\u0010\u0005\"\u000e\u0010\u0014\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"AnimationDuration", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material/TextFieldColors;", "border", "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", "index", "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    private static final float HorizontalIconPadding = Dp.m4704constructorimpl((float) 12);
    private static final Modifier IconDefaultSizeModifier;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding = Dp.m4704constructorimpl((float) 16);
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);

    public static final void CommonDecorationBox(TextFieldType textFieldType, String str, Function2<? super Composer, ? super Integer, Unit> function2, VisualTransformation visualTransformation, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, boolean z, boolean z2, boolean z3, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, Function2<? super Composer, ? super Integer, Unit> function26, Composer composer, int i, int i2, int i3) {
        int i4;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function27;
        boolean z4;
        boolean z5;
        boolean z6;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Composer composer2;
        InputPhase inputPhase;
        TextFieldType textFieldType2 = textFieldType;
        String str2 = str;
        Function2<? super Composer, ? super Integer, Unit> function211 = function2;
        VisualTransformation visualTransformation2 = visualTransformation;
        Function2<? super Composer, ? super Integer, Unit> function212 = function22;
        InteractionSource interactionSource2 = interactionSource;
        PaddingValues paddingValues2 = paddingValues;
        TextFieldColors textFieldColors2 = textFieldColors;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        Intrinsics.checkNotNullParameter(textFieldType2, "type");
        Intrinsics.checkNotNullParameter(str2, "value");
        Intrinsics.checkNotNullParameter(function211, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation2, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(paddingValues2, "contentPadding");
        Intrinsics.checkNotNullParameter(textFieldColors2, "colors");
        Composer startRestartGroup = composer.startRestartGroup(-712568069);
        ComposerKt.sourceInformation(startRestartGroup, "C(CommonDecorationBox)P(12,13,4,14,7,9,8,11,10,3,6,5,2,1)80@3167L105,84@3322L25,101@3932L10,*113@4554L10,114@4648L22,108@4267L5060:TextFieldImpl.kt#jmzs0o");
        if ((i8 & 1) != 0) {
            i4 = i6 | 6;
        } else if ((i6 & 14) == 0) {
            i4 = (startRestartGroup.changed((Object) textFieldType2) ? 4 : 2) | i6;
        } else {
            i4 = i6;
        }
        int i9 = 32;
        if ((i8 & 2) != 0) {
            i4 |= 48;
        } else if ((i6 & 112) == 0) {
            i4 |= startRestartGroup.changed((Object) str2) ? 32 : 16;
        }
        int i10 = 256;
        if ((i8 & 4) != 0) {
            i4 |= BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        } else if ((i6 & 896) == 0) {
            i4 |= startRestartGroup.changed((Object) function211) ? 256 : 128;
        }
        int i11 = 2048;
        if ((i8 & 8) != 0) {
            i4 |= 3072;
        } else if ((i6 & 7168) == 0) {
            i4 |= startRestartGroup.changed((Object) visualTransformation2) ? 2048 : 1024;
        }
        int i12 = 16384;
        if ((i8 & 16) != 0) {
            i4 |= 24576;
        } else if ((i6 & 57344) == 0) {
            i4 |= startRestartGroup.changed((Object) function212) ? 16384 : 8192;
        }
        int i13 = i8 & 32;
        if (i13 != 0) {
            i4 |= 196608;
            Function2<? super Composer, ? super Integer, Unit> function213 = function23;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function214 = function23;
            if ((i6 & 458752) == 0) {
                i4 |= startRestartGroup.changed((Object) function214) ? 131072 : 65536;
            }
        }
        int i14 = i8 & 64;
        if (i14 != 0) {
            i4 |= 1572864;
            Function2<? super Composer, ? super Integer, Unit> function215 = function24;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function216 = function24;
            if ((i6 & 3670016) == 0) {
                i4 |= startRestartGroup.changed((Object) function216) ? 1048576 : 524288;
            }
        }
        int i15 = i8 & 128;
        if (i15 != 0) {
            i4 |= 12582912;
            Function2<? super Composer, ? super Integer, Unit> function217 = function25;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function218 = function25;
            if ((i6 & 29360128) == 0) {
                i4 |= startRestartGroup.changed((Object) function218) ? 8388608 : 4194304;
            }
        }
        int i16 = i8 & 256;
        if (i16 != 0) {
            i4 |= 100663296;
            boolean z7 = z;
        } else {
            boolean z8 = z;
            if ((i6 & 234881024) == 0) {
                i4 |= startRestartGroup.changed(z8) ? 67108864 : 33554432;
            }
        }
        int i17 = i8 & 512;
        if (i17 != 0) {
            i4 |= 805306368;
            boolean z9 = z2;
        } else {
            int i18 = i6 & 1879048192;
            boolean z10 = z2;
            if (i18 == 0) {
                i4 |= startRestartGroup.changed(z10) ? 536870912 : 268435456;
            }
        }
        int i19 = i4;
        int i20 = i8 & 1024;
        if (i20 != 0) {
            i5 = i7 | 6;
            boolean z11 = z3;
        } else {
            boolean z12 = z3;
            if ((i7 & 14) == 0) {
                i5 = i7 | (startRestartGroup.changed(z12) ? 4 : 2);
            } else {
                i5 = i7;
            }
        }
        if ((i8 & 2048) != 0) {
            i5 |= 48;
        } else if ((i7 & 112) == 0) {
            if (!startRestartGroup.changed((Object) interactionSource2)) {
                i9 = 16;
            }
            i5 |= i9;
        }
        int i21 = i5;
        if ((i8 & 4096) != 0) {
            i21 |= BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        } else if ((i7 & 896) == 0) {
            if (!startRestartGroup.changed((Object) paddingValues2)) {
                i10 = 128;
            }
            i21 |= i10;
        }
        if ((i8 & 8192) != 0) {
            i21 |= 3072;
        } else if ((i7 & 7168) == 0) {
            if (!startRestartGroup.changed((Object) textFieldColors2)) {
                i11 = 1024;
            }
            i21 |= i11;
        }
        int i22 = i8 & 16384;
        if (i22 != 0) {
            i21 |= 24576;
            Function2<? super Composer, ? super Integer, Unit> function219 = function26;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function220 = function26;
            if ((i7 & 57344) == 0) {
                if (!startRestartGroup.changed((Object) function220)) {
                    i12 = 8192;
                }
                i21 |= i12;
            }
        }
        if ((i19 & 1533916891) == 306783378 && (46811 & i21) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function210 = function23;
            function29 = function24;
            function28 = function25;
            z6 = z;
            z5 = z2;
            z4 = z3;
            function27 = function26;
            composer2 = startRestartGroup;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function221 = i13 != 0 ? null : function23;
            Function2<? super Composer, ? super Integer, Unit> function222 = i14 != 0 ? null : function24;
            Function2<? super Composer, ? super Integer, Unit> function223 = i15 != 0 ? null : function25;
            boolean z13 = i16 != 0 ? false : z;
            boolean z14 = i17 != 0 ? true : z2;
            boolean z15 = i20 != 0 ? false : z3;
            Function2<? super Composer, ? super Integer, Unit> function224 = i22 != 0 ? null : function26;
            startRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) str2) | startRestartGroup.changed((Object) visualTransformation2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = visualTransformation2.filter(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            String text = ((TransformedText) rememberedValue).getText().getText();
            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource2, startRestartGroup, (i21 >> 3) & 14).getValue().booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else {
                if (text.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
            }
            InputPhase inputPhase2 = inputPhase;
            Composer composer3 = startRestartGroup;
            Function3 textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z14, z15, interactionSource, i19, i21);
            Typography typography = MaterialTheme.INSTANCE.getTypography(composer3, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            boolean z16 = (Color.m1933equalsimpl0(subtitle1.m4238getColor0d7_KjU(), Color.Companion.m1968getUnspecified0d7_KjU()) && !Color.m1933equalsimpl0(caption.m4238getColor0d7_KjU(), Color.Companion.m1968getUnspecified0d7_KjU())) || (!Color.m1933equalsimpl0(subtitle1.m4238getColor0d7_KjU(), Color.Companion.m1968getUnspecified0d7_KjU()) && Color.m1933equalsimpl0(caption.m4238getColor0d7_KjU(), Color.Companion.m1968getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            composer3.startReplaceableGroup(2129141006);
            ComposerKt.sourceInformation(composer3, "*110@4363L10,111@4455L22");
            long r0 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getCaption().m4238getColor0d7_KjU();
            if (z16) {
                if (!(r0 != Color.Companion.m1968getUnspecified0d7_KjU())) {
                    r0 = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composer3, 0)).m1942unboximpl();
                }
            }
            long j = r0;
            composer3.endReplaceableGroup();
            long r02 = MaterialTheme.INSTANCE.getTypography(composer3, 6).getSubtitle1().m4238getColor0d7_KjU();
            if (z16) {
                if (!(r02 != Color.Companion.m1968getUnspecified0d7_KjU())) {
                    r02 = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composer3, 0)).m1942unboximpl();
                }
            }
            long j2 = r02;
            boolean z17 = function212 != null;
            TextFieldImplKt$CommonDecorationBox$3 textFieldImplKt$CommonDecorationBox$3 = r0;
            TextFieldImplKt$CommonDecorationBox$3 textFieldImplKt$CommonDecorationBox$32 = new TextFieldImplKt$CommonDecorationBox$3(function22, function221, text, z15, i21, textFieldColors, z14, interactionSource, i19, function222, function223, textFieldType, function2, z13, paddingValues, z16, function224);
            composer2 = composer3;
            textFieldTransitionScope.m1494TransitionDTcfvLk(inputPhase2, j, j2, textFieldImplKt$CommonDecorationBox$labelColor$1, z17, ComposableLambdaKt.composableLambda(composer2, 341865432, true, textFieldImplKt$CommonDecorationBox$3), composer2, 1769472);
            function210 = function221;
            function29 = function222;
            function28 = function223;
            z6 = z13;
            z5 = z14;
            z4 = z15;
            function27 = function224;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldImplKt$CommonDecorationBox$4(textFieldType, str, function2, visualTransformation, function22, function210, function29, function28, z6, z5, z4, interactionSource, paddingValues, textFieldColors, function27, i, i2, i3));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* renamed from: Decoration-euL9pac  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1481DecorationeuL9pac(long r16, androidx.compose.ui.text.TextStyle r18, java.lang.Float r19, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r6 = r20
            r7 = r22
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = -399493340(0xffffffffe8303724, float:-3.3286147E24)
            r1 = r21
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Decoration)P(2:c#ui.graphics.Color,3,1):TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r23 & 1
            if (r0 == 0) goto L_0x0020
            r0 = r7 | 6
            r9 = r16
            goto L_0x0032
        L_0x0020:
            r0 = r7 & 14
            r9 = r16
            if (r0 != 0) goto L_0x0031
            boolean r0 = r8.changed((long) r9)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r7
            goto L_0x0032
        L_0x0031:
            r0 = r7
        L_0x0032:
            r1 = r23 & 2
            if (r1 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x004c
        L_0x0039:
            r2 = r7 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004c
            r2 = r18
            boolean r3 = r8.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0048
            r3 = 32
            goto L_0x004a
        L_0x0048:
            r3 = 16
        L_0x004a:
            r0 = r0 | r3
            goto L_0x004e
        L_0x004c:
            r2 = r18
        L_0x004e:
            r3 = r23 & 4
            if (r3 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r4 = r7 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0068
            r4 = r19
            boolean r5 = r8.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0064
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r5
            goto L_0x006a
        L_0x0068:
            r4 = r19
        L_0x006a:
            r5 = r23 & 8
            if (r5 == 0) goto L_0x0071
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x0071:
            r5 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0081
            boolean r5 = r8.changed((java.lang.Object) r6)
            if (r5 == 0) goto L_0x007e
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r0 = r0 | r5
        L_0x0081:
            r11 = r0
            r0 = r11 & 5851(0x16db, float:8.199E-42)
            r5 = 1170(0x492, float:1.64E-42)
            if (r0 != r5) goto L_0x0094
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x008f
            goto L_0x0094
        L_0x008f:
            r8.skipToGroupEnd()
            r3 = r2
            goto L_0x00e4
        L_0x0094:
            r0 = 0
            if (r1 == 0) goto L_0x0099
            r12 = r0
            goto L_0x009a
        L_0x0099:
            r12 = r2
        L_0x009a:
            if (r3 == 0) goto L_0x009e
            r13 = r0
            goto L_0x009f
        L_0x009e:
            r13 = r4
        L_0x009f:
            r14 = 494684590(0x1d7c49ae, float:3.3390014E-21)
            androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1 r15 = new androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
            r0 = r15
            r1 = r16
            r3 = r13
            r4 = r20
            r5 = r11
            r0.<init>(r1, r3, r4, r5)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r14, r0, r15)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            if (r12 == 0) goto L_0x00cc
            r1 = -2009952864(0xffffffff88328da0, float:-5.3731406E-34)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "252@10230L46"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            int r1 = r11 >> 3
            r1 = r1 & 14
            r1 = r1 | 48
            androidx.compose.material.TextKt.ProvideTextStyle(r12, r0, r8, r1)
            goto L_0x00df
        L_0x00cc:
            r1 = -2009952812(0xffffffff88328dd4, float:-5.3731645E-34)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "252@10282L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.invoke(r8, r1)
        L_0x00df:
            r8.endReplaceableGroup()
            r3 = r12
            r4 = r13
        L_0x00e4:
            androidx.compose.runtime.ScopeUpdateScope r8 = r8.endRestartGroup()
            if (r8 != 0) goto L_0x00eb
            goto L_0x00fe
        L_0x00eb:
            androidx.compose.material.TextFieldImplKt$Decoration$1 r11 = new androidx.compose.material.TextFieldImplKt$Decoration$1
            r0 = r11
            r1 = r16
            r5 = r20
            r6 = r22
            r7 = r23
            r0.<init>(r1, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r8.updateScope(r11)
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.m1481DecorationeuL9pac(long, androidx.compose.ui.text.TextStyle, java.lang.Float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "<this>");
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    static {
        float f = (float) 48;
        IconDefaultSizeModifier = SizeKt.m566defaultMinSizeVpY3zN4(Modifier.Companion, Dp.m4704constructorimpl(f), Dp.m4704constructorimpl(f));
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
