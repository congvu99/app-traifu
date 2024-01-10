package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u001c\u001aM\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010!\u001a9\u0010\"\u001a\u00020\f*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+\u001aA\u0010,\u001a\u00020\f*\u00020#2\u0006\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\b\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\t\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\n\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxRippleRadius", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/CheckboxColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material/CheckDrawingCache;)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Checkbox.kt */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxRippleRadius = Dp.m4704constructorimpl((float) 24);
    private static final float CheckboxSize = Dp.m4704constructorimpl((float) 20);
    /* access modifiers changed from: private */
    public static final float RadiusSize;
    /* access modifiers changed from: private */
    public static final float StrokeWidth;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Checkbox.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Off.ordinal()] = 2;
            iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0158  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Checkbox(boolean r26, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, boolean r29, androidx.compose.foundation.interaction.MutableInteractionSource r30, androidx.compose.material.CheckboxColors r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r1 = r26
            r2 = r27
            r7 = r33
            r0 = -2118660998(0xffffffff81b7cc7a, float:-6.751699E-38)
            r3 = r32
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(Checkbox)P(!1,5,4,2,3)90@4153L39,91@4240L8,93@4257L284:Checkbox.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r3 = r34 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r7 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r7 & 14
            if (r3 != 0) goto L_0x002a
            boolean r3 = r0.changed((boolean) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r7
            goto L_0x002b
        L_0x002a:
            r3 = r7
        L_0x002b:
            r4 = r34 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0042
        L_0x0032:
            r4 = r7 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0042
            boolean r4 = r0.changed((java.lang.Object) r2)
            if (r4 == 0) goto L_0x003f
            r4 = 32
            goto L_0x0041
        L_0x003f:
            r4 = 16
        L_0x0041:
            r3 = r3 | r4
        L_0x0042:
            r4 = r34 & 4
            if (r4 == 0) goto L_0x0049
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005c
        L_0x0049:
            r5 = r7 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x005c
            r5 = r28
            boolean r6 = r0.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0058
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r3 = r3 | r6
            goto L_0x005e
        L_0x005c:
            r5 = r28
        L_0x005e:
            r6 = r34 & 8
            if (r6 == 0) goto L_0x0065
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0078
        L_0x0065:
            r8 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0078
            r8 = r29
            boolean r9 = r0.changed((boolean) r8)
            if (r9 == 0) goto L_0x0074
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0076
        L_0x0074:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0076:
            r3 = r3 | r9
            goto L_0x007a
        L_0x0078:
            r8 = r29
        L_0x007a:
            r9 = r34 & 16
            r22 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0084
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0084:
            r10 = r7 & r22
            if (r10 != 0) goto L_0x0097
            r10 = r30
            boolean r11 = r0.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0093
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r3 = r3 | r11
            goto L_0x0099
        L_0x0097:
            r10 = r30
        L_0x0099:
            r23 = 458752(0x70000, float:6.42848E-40)
            r11 = r7 & r23
            if (r11 != 0) goto L_0x00b4
            r11 = r34 & 32
            if (r11 != 0) goto L_0x00ae
            r11 = r31
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x00b0
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00ae:
            r11 = r31
        L_0x00b0:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r3 = r3 | r12
            goto L_0x00b6
        L_0x00b4:
            r11 = r31
        L_0x00b6:
            r12 = 374491(0x5b6db, float:5.24774E-40)
            r12 = r12 & r3
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r13) goto L_0x00cf
            boolean r12 = r0.getSkipping()
            if (r12 != 0) goto L_0x00c6
            goto L_0x00cf
        L_0x00c6:
            r0.skipToGroupEnd()
            r3 = r5
            r4 = r8
            r5 = r10
            r6 = r11
            goto L_0x01b3
        L_0x00cf:
            r0.startDefaults()
            r12 = r7 & 1
            r24 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r12 == 0) goto L_0x00ef
            boolean r12 = r0.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00e0
            goto L_0x00ef
        L_0x00e0:
            r0.skipToGroupEnd()
            r4 = r34 & 32
            if (r4 == 0) goto L_0x00e9
            r3 = r3 & r24
        L_0x00e9:
            r4 = r5
            r5 = r8
            r6 = r10
        L_0x00ec:
            r8 = r3
            r3 = r11
            goto L_0x0144
        L_0x00ef:
            if (r4 == 0) goto L_0x00f6
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00f7
        L_0x00f6:
            r4 = r5
        L_0x00f7:
            if (r6 == 0) goto L_0x00fb
            r5 = 1
            goto L_0x00fc
        L_0x00fb:
            r5 = r8
        L_0x00fc:
            if (r9 == 0) goto L_0x0122
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            java.lang.Object r6 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x011c
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r6)
        L_0x011c:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = (androidx.compose.foundation.interaction.MutableInteractionSource) r6
            goto L_0x0123
        L_0x0122:
            r6 = r10
        L_0x0123:
            r8 = r34 & 32
            if (r8 == 0) goto L_0x00ec
            androidx.compose.material.CheckboxDefaults r8 = androidx.compose.material.CheckboxDefaults.INSTANCE
            r9 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r20 = 196608(0x30000, float:2.75506E-40)
            r21 = 31
            r19 = r0
            androidx.compose.material.CheckboxColors r8 = r8.m1179colorszjMxDiM(r9, r11, r13, r15, r17, r19, r20, r21)
            r3 = r3 & r24
            r25 = r8
            r8 = r3
            r3 = r25
        L_0x0144:
            r0.endDefaults()
            androidx.compose.ui.state.ToggleableState r9 = androidx.compose.ui.state.ToggleableStateKt.ToggleableState(r26)
            r10 = 1433125990(0x556bc466, float:1.62017973E13)
            r0.startReplaceableGroup(r10)
            java.lang.String r10 = "95@4366L29"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r10)
            if (r2 == 0) goto L_0x0190
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r26)
            r11 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            boolean r11 = r0.changed((java.lang.Object) r2)
            boolean r10 = r0.changed((java.lang.Object) r10)
            r10 = r10 | r11
            java.lang.Object r11 = r0.rememberedValue()
            if (r10 != 0) goto L_0x017e
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x0189
        L_0x017e:
            androidx.compose.material.CheckboxKt$Checkbox$2$1 r10 = new androidx.compose.material.CheckboxKt$Checkbox$2$1
            r10.<init>(r2, r1)
            r11 = r10
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r0.updateRememberedValue(r11)
        L_0x0189:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r10 = r11
            goto L_0x0191
        L_0x0190:
            r10 = 0
        L_0x0191:
            r0.endReplaceableGroup()
            r11 = r8 & 896(0x380, float:1.256E-42)
            r12 = r8 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = r8 & r22
            r11 = r11 | r12
            r8 = r8 & r23
            r15 = r11 | r8
            r16 = 0
            r8 = r9
            r9 = r10
            r10 = r4
            r11 = r5
            r12 = r6
            r13 = r3
            r14 = r0
            TriStateCheckbox(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r25 = r6
            r6 = r3
            r3 = r4
            r4 = r5
            r5 = r25
        L_0x01b3:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x01ba
            goto L_0x01cd
        L_0x01ba:
            androidx.compose.material.CheckboxKt$Checkbox$3 r10 = new androidx.compose.material.CheckboxKt$Checkbox$3
            r0 = r10
            r1 = r26
            r2 = r27
            r7 = r33
            r8 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x01cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxKt.Checkbox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.CheckboxColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0196  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TriStateCheckbox(androidx.compose.ui.state.ToggleableState r25, kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.Modifier r27, boolean r28, androidx.compose.foundation.interaction.MutableInteractionSource r29, androidx.compose.material.CheckboxColors r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r7 = r25
            r8 = r26
            r9 = r32
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 2031255194(0x79127e9a, float:4.7540195E34)
            r1 = r31
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TriStateCheckbox)P(5,4,3,1,2)136@6460L39,137@6547L8,155@7071L301:Checkbox.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r0 = r33 & 1
            if (r0 == 0) goto L_0x0021
            r0 = r9 | 6
            goto L_0x0031
        L_0x0021:
            r0 = r9 & 14
            if (r0 != 0) goto L_0x0030
            boolean r0 = r6.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x002d
            r0 = 4
            goto L_0x002e
        L_0x002d:
            r0 = 2
        L_0x002e:
            r0 = r0 | r9
            goto L_0x0031
        L_0x0030:
            r0 = r9
        L_0x0031:
            r1 = r33 & 2
            if (r1 == 0) goto L_0x0038
            r0 = r0 | 48
            goto L_0x0048
        L_0x0038:
            r1 = r9 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0048
            boolean r1 = r6.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x0045
            r1 = 32
            goto L_0x0047
        L_0x0045:
            r1 = 16
        L_0x0047:
            r0 = r0 | r1
        L_0x0048:
            r1 = r33 & 4
            if (r1 == 0) goto L_0x004f
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0062
        L_0x004f:
            r2 = r9 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0062
            r2 = r27
            boolean r3 = r6.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x005e
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0060
        L_0x005e:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0060:
            r0 = r0 | r3
            goto L_0x0064
        L_0x0062:
            r2 = r27
        L_0x0064:
            r3 = r33 & 8
            if (r3 == 0) goto L_0x006b
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r4 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x007e
            r4 = r28
            boolean r5 = r6.changed((boolean) r4)
            if (r5 == 0) goto L_0x007a
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r0 = r0 | r5
            goto L_0x0080
        L_0x007e:
            r4 = r28
        L_0x0080:
            r5 = r33 & 16
            if (r5 == 0) goto L_0x0087
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009c
        L_0x0087:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r9
            if (r10 != 0) goto L_0x009c
            r10 = r29
            boolean r11 = r6.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0098
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r0 = r0 | r11
            goto L_0x009e
        L_0x009c:
            r10 = r29
        L_0x009e:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r9
            if (r11 != 0) goto L_0x00b8
            r11 = r33 & 32
            if (r11 != 0) goto L_0x00b2
            r11 = r30
            boolean r12 = r6.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x00b4
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b2:
            r11 = r30
        L_0x00b4:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r0 = r0 | r12
            goto L_0x00ba
        L_0x00b8:
            r11 = r30
        L_0x00ba:
            r12 = 374491(0x5b6db, float:5.24774E-40)
            r12 = r12 & r0
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r13) goto L_0x00d3
            boolean r12 = r6.getSkipping()
            if (r12 != 0) goto L_0x00ca
            goto L_0x00d3
        L_0x00ca:
            r6.skipToGroupEnd()
            r3 = r2
            r5 = r10
            r10 = r6
            r6 = r11
            goto L_0x01d7
        L_0x00d3:
            r6.startDefaults()
            r12 = r9 & 1
            r24 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r12 == 0) goto L_0x00f8
            boolean r12 = r6.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00e4
            goto L_0x00f8
        L_0x00e4:
            r6.skipToGroupEnd()
            r1 = r33 & 32
            if (r1 == 0) goto L_0x00ed
            r0 = r0 & r24
        L_0x00ed:
            r20 = r0
            r5 = r2
            r17 = r4
            r18 = r10
        L_0x00f4:
            r19 = r11
            goto L_0x015a
        L_0x00f8:
            if (r1 == 0) goto L_0x00ff
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0100
        L_0x00ff:
            r1 = r2
        L_0x0100:
            if (r3 == 0) goto L_0x0104
            r2 = 1
            goto L_0x0105
        L_0x0104:
            r2 = r4
        L_0x0105:
            if (r5 == 0) goto L_0x012b
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r3)
            java.lang.Object r3 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0125
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r6.updateRememberedValue(r3)
        L_0x0125:
            r6.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            goto L_0x012c
        L_0x012b:
            r3 = r10
        L_0x012c:
            r4 = r33 & 32
            if (r4 == 0) goto L_0x0152
            androidx.compose.material.CheckboxDefaults r10 = androidx.compose.material.CheckboxDefaults.INSTANCE
            r11 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r22 = 196608(0x30000, float:2.75506E-40)
            r23 = 31
            r21 = r6
            androidx.compose.material.CheckboxColors r4 = r10.m1179colorszjMxDiM(r11, r13, r15, r17, r19, r21, r22, r23)
            r0 = r0 & r24
            r20 = r0
            r5 = r1
            r17 = r2
            r18 = r3
            r19 = r4
            goto L_0x015a
        L_0x0152:
            r20 = r0
            r5 = r1
            r17 = r2
            r18 = r3
            goto L_0x00f4
        L_0x015a:
            r6.endDefaults()
            r0 = -1517549514(0xffffffffa58c0836, float:-2.4291693E-16)
            r6.startReplaceableGroup(r0)
            java.lang.String r0 = "147@6884L120"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            if (r8 == 0) goto L_0x0196
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m4092getCheckboxo7Vup1c()
            r10 = 0
            float r11 = CheckboxRippleRadius
            r12 = 0
            r15 = 54
            r16 = 4
            r14 = r6
            androidx.compose.foundation.Indication r3 = androidx.compose.material.ripple.RippleKt.m1521rememberRipple9IZ8Weo(r10, r11, r12, r14, r15, r16)
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.semantics.Role r10 = androidx.compose.ui.semantics.Role.m4084boximpl(r1)
            r1 = r25
            r2 = r18
            r4 = r17
            r11 = r5
            r5 = r10
            r10 = r6
            r6 = r26
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m824triStateToggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x019c
        L_0x0196:
            r11 = r5
            r10 = r6
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x019c:
            r10.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            if (r8 == 0) goto L_0x01a9
            androidx.compose.ui.Modifier r1 = androidx.compose.material.TouchTargetKt.minimumTouchTargetSize(r1)
        L_0x01a9:
            androidx.compose.ui.Modifier r1 = r11.then(r1)
            androidx.compose.ui.Modifier r0 = r1.then(r0)
            float r1 = CheckboxDefaultPadding
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r0, r1)
            int r0 = r20 >> 9
            r0 = r0 & 14
            int r1 = r20 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r20 >> 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r5 = r0 | r1
            r0 = r17
            r1 = r25
            r3 = r19
            r4 = r10
            CheckboxImpl(r0, r1, r2, r3, r4, r5)
            r3 = r11
            r4 = r17
            r5 = r18
            r6 = r19
        L_0x01d7:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x01de
            goto L_0x01f1
        L_0x01de:
            androidx.compose.material.CheckboxKt$TriStateCheckbox$2 r11 = new androidx.compose.material.CheckboxKt$TriStateCheckbox$2
            r0 = r11
            r1 = r25
            r2 = r26
            r7 = r32
            r8 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x01f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxKt.TriStateCheckbox(androidx.compose.ui.state.ToggleableState, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.CheckboxColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: androidx.compose.material.CheckDrawingCache} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v42, resolved type: androidx.compose.material.CheckDrawingCache} */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CheckboxImpl(boolean r34, androidx.compose.ui.state.ToggleableState r35, androidx.compose.ui.Modifier r36, androidx.compose.material.CheckboxColors r37, androidx.compose.runtime.Composer r38, int r39) {
        /*
            r1 = r34
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r39
            r0 = -2118895727(0xffffffff81b43791, float:-6.620129E-38)
            r6 = r38
            androidx.compose.runtime.Composer r0 = r6.startRestartGroup(r0)
            java.lang.String r6 = "C(CheckboxImpl)P(1,3,2)258@10957L23,259@11021L443,275@11524L458,290@12004L32,291@12066L21,292@12115L24,293@12170L27,294@12280L508,294@12202L586:Checkbox.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            r6 = r5 & 14
            r15 = 2
            if (r6 != 0) goto L_0x0028
            boolean r6 = r0.changed((boolean) r1)
            if (r6 == 0) goto L_0x0025
            r6 = 4
            goto L_0x0026
        L_0x0025:
            r6 = 2
        L_0x0026:
            r6 = r6 | r5
            goto L_0x0029
        L_0x0028:
            r6 = r5
        L_0x0029:
            r7 = r5 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0039
            boolean r7 = r0.changed((java.lang.Object) r2)
            if (r7 == 0) goto L_0x0036
            r7 = 32
            goto L_0x0038
        L_0x0036:
            r7 = 16
        L_0x0038:
            r6 = r6 | r7
        L_0x0039:
            r7 = r5 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0049
            boolean r7 = r0.changed((java.lang.Object) r3)
            if (r7 == 0) goto L_0x0046
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0048
        L_0x0046:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0048:
            r6 = r6 | r7
        L_0x0049:
            r7 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0059
            boolean r7 = r0.changed((java.lang.Object) r4)
            if (r7 == 0) goto L_0x0056
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0058
        L_0x0056:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0058:
            r6 = r6 | r7
        L_0x0059:
            r13 = r6
            r6 = r13 & 5851(0x16db, float:8.199E-42)
            r7 = 1170(0x492, float:1.64E-42)
            if (r6 != r7) goto L_0x006c
            boolean r6 = r0.getSkipping()
            if (r6 != 0) goto L_0x0067
            goto L_0x006c
        L_0x0067:
            r0.skipToGroupEnd()
            goto L_0x0279
        L_0x006c:
            int r12 = r13 >> 3
            r11 = r12 & 14
            r10 = 0
            androidx.compose.animation.core.Transition r16 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r10, (androidx.compose.runtime.Composer) r0, (int) r11, (int) r15)
            androidx.compose.material.CheckboxKt$CheckboxImpl$checkDrawFraction$2 r6 = androidx.compose.material.CheckboxKt$CheckboxImpl$checkDrawFraction$2.INSTANCE
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            r9 = 1399891485(0x5370a61d, float:1.03357907E12)
            r0.startReplaceableGroup(r9)
            java.lang.String r8 = "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            kotlin.jvm.internal.FloatCompanionObject r7 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r17 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r7)
            r7 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r7)
            java.lang.String r14 = "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            java.lang.Object r18 = r16.getCurrentState()
            androidx.compose.ui.state.ToggleableState r18 = (androidx.compose.ui.state.ToggleableState) r18
            r7 = -1798345588(0xffffffff94cf6c8c, float:-2.0944473E-26)
            r0.startReplaceableGroup(r7)
            r19 = r13
            java.lang.String r13 = "C:Checkbox.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            int[] r20 = androidx.compose.material.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r18 = r18.ordinal()
            r9 = r20[r18]
            r18 = 0
            r20 = 1065353216(0x3f800000, float:1.0)
            r7 = 1
            r5 = 3
            if (r9 == r7) goto L_0x00c5
            if (r9 == r15) goto L_0x00c3
            if (r9 != r5) goto L_0x00bd
            goto L_0x00c5
        L_0x00bd:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00c3:
            r9 = 0
            goto L_0x00c7
        L_0x00c5:
            r9 = 1065353216(0x3f800000, float:1.0)
        L_0x00c7:
            r0.endReplaceableGroup()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.Object r22 = r16.getTargetState()
            androidx.compose.ui.state.ToggleableState r22 = (androidx.compose.ui.state.ToggleableState) r22
            r10 = -1798345588(0xffffffff94cf6c8c, float:-2.0944473E-26)
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            int[] r10 = androidx.compose.material.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r21 = r22.ordinal()
            r10 = r10[r21]
            if (r10 == r7) goto L_0x00f4
            if (r10 == r15) goto L_0x00f2
            if (r10 != r5) goto L_0x00ec
            goto L_0x00f4
        L_0x00ec:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00f2:
            r10 = 0
            goto L_0x00f6
        L_0x00f4:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x00f6:
            r0.endReplaceableGroup()
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            androidx.compose.animation.core.Transition$Segment r7 = r16.getSegment()
            r5 = 0
            java.lang.Integer r15 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r6.invoke(r7, r0, r15)
            r15 = r6
            androidx.compose.animation.core.FiniteAnimationSpec r15 = (androidx.compose.animation.core.FiniteAnimationSpec) r15
            r23 = 0
            java.lang.String r24 = "FloatAnimation"
            r6 = r16
            r5 = 1847725064(0x6e220c08, float:1.2537779E28)
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r9
            r5 = 1399891485(0x5370a61d, float:1.03357907E12)
            r9 = r15
            r15 = r10
            r10 = r17
            r17 = r11
            r11 = r24
            r25 = r12
            r12 = r0
            r26 = r13
            r13 = r23
            androidx.compose.runtime.State r32 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r6, r7, r8, r9, r10, r11, r12, r13)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2 r6 = androidx.compose.material.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$2.INSTANCE
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            r0.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            kotlin.jvm.internal.FloatCompanionObject r5 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r10 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r5)
            r5 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            java.lang.Object r5 = r16.getCurrentState()
            androidx.compose.ui.state.ToggleableState r5 = (androidx.compose.ui.state.ToggleableState) r5
            r7 = -2098942571(0xffffffff82e4ad95, float:-3.360122E-37)
            r0.startReplaceableGroup(r7)
            r8 = r26
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            int[] r9 = androidx.compose.material.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r9[r5]
            r14 = 1
            if (r5 == r14) goto L_0x017a
            r9 = 2
            if (r5 == r9) goto L_0x017a
            r9 = 3
            if (r5 != r9) goto L_0x0174
            r5 = 1065353216(0x3f800000, float:1.0)
            goto L_0x017b
        L_0x0174:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x017a:
            r5 = 0
        L_0x017b:
            r0.endReplaceableGroup()
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.Object r9 = r16.getTargetState()
            androidx.compose.ui.state.ToggleableState r9 = (androidx.compose.ui.state.ToggleableState) r9
            r0.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            int[] r7 = androidx.compose.material.CheckboxKt.WhenMappings.$EnumSwitchMapping$0
            int r8 = r9.ordinal()
            r7 = r7[r8]
            if (r7 == r14) goto L_0x01a7
            r8 = 2
            if (r7 == r8) goto L_0x01a7
            r8 = 3
            if (r7 != r8) goto L_0x01a1
            r18 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01a7
        L_0x01a1:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01a7:
            r0.endReplaceableGroup()
            java.lang.Float r8 = java.lang.Float.valueOf(r18)
            androidx.compose.animation.core.Transition$Segment r7 = r16.getSegment()
            r9 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
            java.lang.Object r6 = r6.invoke(r7, r0, r11)
            r9 = r6
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            java.lang.String r11 = "FloatAnimation"
            r6 = r16
            r7 = r5
            r12 = r0
            r13 = r23
            androidx.compose.runtime.State r33 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r6, r7, r8, r9, r10, r11, r12, r13)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            java.lang.Object r5 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x01f5
            androidx.compose.material.CheckDrawingCache r5 = new androidx.compose.material.CheckDrawingCache
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 7
            r12 = 0
            r7 = r5
            r7.<init>(r8, r9, r10, r11, r12)
            r0.updateRememberedValue(r5)
        L_0x01f5:
            r0.endReplaceableGroup()
            r28 = r5
            androidx.compose.material.CheckDrawingCache r28 = (androidx.compose.material.CheckDrawingCache) r28
            int r5 = r19 >> 6
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r17 | r5
            androidx.compose.runtime.State r31 = r4.checkmarkColor(r2, r0, r5)
            r5 = r19 & 14
            r6 = r19 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            r6 = r25
            r6 = r6 & 896(0x380, float:1.256E-42)
            r5 = r5 | r6
            androidx.compose.runtime.State r29 = r4.boxColor(r1, r2, r0, r5)
            androidx.compose.runtime.State r30 = r4.borderColor(r1, r2, r0, r5)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenter()
            r6 = 0
            r7 = 0
            r8 = 2
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r3, r5, r7, r8, r6)
            float r6 = CheckboxSize
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m574requiredSize3ABfNKs(r5, r6)
            r6 = 6
            java.lang.Object[] r9 = new java.lang.Object[r6]
            r9[r7] = r29
            r9[r14] = r30
            r9[r8] = r31
            r7 = 3
            r9[r7] = r32
            r7 = 4
            r9[r7] = r33
            r7 = 5
            r9[r7] = r28
            r7 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            r7 = 0
            r8 = 0
        L_0x024a:
            if (r7 >= r6) goto L_0x0256
            r10 = r9[r7]
            boolean r10 = r0.changed((java.lang.Object) r10)
            r8 = r8 | r10
            int r7 = r7 + 1
            goto L_0x024a
        L_0x0256:
            java.lang.Object r6 = r0.rememberedValue()
            if (r8 != 0) goto L_0x0264
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r6 != r7) goto L_0x0270
        L_0x0264:
            androidx.compose.material.CheckboxKt$CheckboxImpl$1$1 r6 = new androidx.compose.material.CheckboxKt$CheckboxImpl$1$1
            r27 = r6
            r27.<init>(r28, r29, r30, r31, r32, r33)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.updateRememberedValue(r6)
        L_0x0270:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r5, r6, r0, r7)
        L_0x0279:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x0280
            goto L_0x0295
        L_0x0280:
            androidx.compose.material.CheckboxKt$CheckboxImpl$2 r7 = new androidx.compose.material.CheckboxKt$CheckboxImpl$2
            r0 = r7
            r1 = r34
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r39
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x0295:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxKt.CheckboxImpl(boolean, androidx.compose.ui.state.ToggleableState, androidx.compose.ui.Modifier, androidx.compose.material.CheckboxColors, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawBox-1wkBAMs  reason: not valid java name */
    public static final void m1192drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        float f3 = f;
        float f4 = f2;
        float f5 = f4 / 2.0f;
        Stroke stroke = new Stroke(f2, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null);
        float r1 = Size.m1752getWidthimpl(drawScope.m2478getSizeNHjbRc());
        if (Color.m1933equalsimpl0(j, j2)) {
            DrawScope.CC.m2516drawRoundRectuAw5IA$default(drawScope, j, 0, SizeKt.Size(r1, r1), CornerRadiusKt.CornerRadius$default(f3, 0.0f, 2, (Object) null), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 226, (Object) null);
            return;
        }
        float f6 = r1 - (((float) 2) * f4);
        DrawScope.CC.m2516drawRoundRectuAw5IA$default(drawScope, j, OffsetKt.Offset(f4, f4), SizeKt.Size(f6, f6), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f3 - f4), 0.0f, 2, (Object) null), Fill.INSTANCE, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
        float f7 = r1 - f4;
        DrawScope.CC.m2516drawRoundRectuAw5IA$default(drawScope, j2, OffsetKt.Offset(f5, f5), SizeKt.Size(f7, f7), CornerRadiusKt.CornerRadius$default(f3 - f5, 0.0f, 2, (Object) null), stroke, 0.0f, (ColorFilter) null, 0, 224, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawCheck-3IgeMak  reason: not valid java name */
    public static final void m1193drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        float f4 = f2;
        Stroke stroke = new Stroke(f3, 0.0f, StrokeCap.Companion.m2289getSquareKaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
        float r1 = Size.m1752getWidthimpl(drawScope.m2478getSizeNHjbRc());
        float lerp = MathHelpersKt.lerp(0.4f, 0.5f, f4);
        float lerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f4);
        float lerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f4);
        float lerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f4);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * r1, lerp3 * r1);
        checkDrawingCache.getCheckPath().lineTo(lerp * r1, lerp2 * r1);
        checkDrawingCache.getCheckPath().lineTo(0.8f * r1, r1 * lerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.CC.m2510drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, (ColorFilter) null, 0, 52, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-4  reason: not valid java name */
    public static final float m1181CheckboxImpl$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-6  reason: not valid java name */
    public static final float m1182CheckboxImpl$lambda6(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-8  reason: not valid java name */
    public static final long m1183CheckboxImpl$lambda8(State<Color> state) {
        return state.getValue().m1942unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-9  reason: not valid java name */
    public static final long m1184CheckboxImpl$lambda9(State<Color> state) {
        return state.getValue().m1942unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: CheckboxImpl$lambda-10  reason: not valid java name */
    public static final long m1180CheckboxImpl$lambda10(State<Color> state) {
        return state.getValue().m1942unboximpl();
    }

    static {
        float f = (float) 2;
        CheckboxDefaultPadding = Dp.m4704constructorimpl(f);
        StrokeWidth = Dp.m4704constructorimpl(f);
        RadiusSize = Dp.m4704constructorimpl(f);
    }
}
