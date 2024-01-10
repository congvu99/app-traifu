package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioButtonRippleRadius", "RadioButtonSize", "RadioRadius", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/RadioButtonColors;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/RadioButtonColors;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: RadioButton.kt */
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize = Dp.m4704constructorimpl((float) 12);
    private static final float RadioButtonPadding;
    private static final float RadioButtonRippleRadius = Dp.m4704constructorimpl((float) 24);
    private static final float RadioButtonSize;
    /* access modifiers changed from: private */
    public static final float RadioRadius;
    /* access modifiers changed from: private */
    public static final float RadioStrokeWidth;

    /* JADX WARNING: Removed duplicated region for block: B:113:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RadioButton(boolean r22, kotlin.jvm.functions.Function0<kotlin.Unit> r23, androidx.compose.ui.Modifier r24, boolean r25, androidx.compose.foundation.interaction.MutableInteractionSource r26, androidx.compose.material.RadioButtonColors r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r7 = r22
            r8 = r23
            r9 = r29
            r0 = 1314435585(0x4e58b201, float:9.0888608E8)
            r1 = r28
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(RadioButton)P(5,4,3,1,2)78@3687L39,79@3780L8,81@3813L164,85@4006L29,109@4847L385,102@4551L681:RadioButton.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r30 & 1
            r6 = 2
            if (r1 == 0) goto L_0x001c
            r1 = r9 | 6
            goto L_0x002c
        L_0x001c:
            r1 = r9 & 14
            if (r1 != 0) goto L_0x002b
            boolean r1 = r0.changed((boolean) r7)
            if (r1 == 0) goto L_0x0028
            r1 = 4
            goto L_0x0029
        L_0x0028:
            r1 = 2
        L_0x0029:
            r1 = r1 | r9
            goto L_0x002c
        L_0x002b:
            r1 = r9
        L_0x002c:
            r2 = r30 & 2
            if (r2 == 0) goto L_0x0033
            r1 = r1 | 48
            goto L_0x0043
        L_0x0033:
            r2 = r9 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0043
            boolean r2 = r0.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x0040
            r2 = 32
            goto L_0x0042
        L_0x0040:
            r2 = 16
        L_0x0042:
            r1 = r1 | r2
        L_0x0043:
            r2 = r30 & 4
            if (r2 == 0) goto L_0x004a
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005d
        L_0x004a:
            r3 = r9 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x005d
            r3 = r24
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0059
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0059:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r1 = r1 | r4
            goto L_0x005f
        L_0x005d:
            r3 = r24
        L_0x005f:
            r4 = r30 & 8
            if (r4 == 0) goto L_0x0066
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r5 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0079
            r5 = r25
            boolean r10 = r0.changed((boolean) r5)
            if (r10 == 0) goto L_0x0075
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r1 = r1 | r10
            goto L_0x007b
        L_0x0079:
            r5 = r25
        L_0x007b:
            r10 = r30 & 16
            if (r10 == 0) goto L_0x0082
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0097
        L_0x0082:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r9
            if (r11 != 0) goto L_0x0097
            r11 = r26
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0093
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0095
        L_0x0093:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0095:
            r1 = r1 | r12
            goto L_0x0099
        L_0x0097:
            r11 = r26
        L_0x0099:
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r9
            if (r12 != 0) goto L_0x00b3
            r12 = r30 & 32
            if (r12 != 0) goto L_0x00ad
            r12 = r27
            boolean r13 = r0.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00af
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00ad:
            r12 = r27
        L_0x00af:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r1 = r1 | r13
            goto L_0x00b5
        L_0x00b3:
            r12 = r27
        L_0x00b5:
            r13 = 374491(0x5b6db, float:5.24774E-40)
            r13 = r13 & r1
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r13 != r14) goto L_0x00ce
            boolean r13 = r0.getSkipping()
            if (r13 != 0) goto L_0x00c5
            goto L_0x00ce
        L_0x00c5:
            r0.skipToGroupEnd()
            r4 = r5
            r5 = r11
            r6 = r12
            r11 = r0
            goto L_0x0241
        L_0x00ce:
            r0.startDefaults()
            r13 = r9 & 1
            r20 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r13 == 0) goto L_0x00ee
            boolean r13 = r0.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00df
            goto L_0x00ee
        L_0x00df:
            r0.skipToGroupEnd()
            r2 = r30 & 32
            if (r2 == 0) goto L_0x00e8
            r1 = r1 & r20
        L_0x00e8:
            r10 = r1
            r15 = r3
            r14 = r5
            r17 = r11
            goto L_0x0146
        L_0x00ee:
            if (r2 == 0) goto L_0x00f5
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00f6
        L_0x00f5:
            r2 = r3
        L_0x00f6:
            if (r4 == 0) goto L_0x00fa
            r3 = 1
            goto L_0x00fb
        L_0x00fa:
            r3 = r5
        L_0x00fb:
            if (r10 == 0) goto L_0x0121
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            java.lang.Object r4 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x011b
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r4)
        L_0x011b:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            goto L_0x0122
        L_0x0121:
            r4 = r11
        L_0x0122:
            r5 = r30 & 32
            if (r5 == 0) goto L_0x0141
            androidx.compose.material.RadioButtonDefaults r10 = androidx.compose.material.RadioButtonDefaults.INSTANCE
            r11 = 0
            r13 = 0
            r15 = 0
            r18 = 3072(0xc00, float:4.305E-42)
            r19 = 7
            r17 = r0
            androidx.compose.material.RadioButtonColors r5 = r10.m1387colorsRGew2ao(r11, r13, r15, r17, r18, r19)
            r1 = r1 & r20
            r10 = r1
            r15 = r2
            r14 = r3
            r17 = r4
            r12 = r5
            goto L_0x0146
        L_0x0141:
            r10 = r1
            r15 = r2
            r14 = r3
            r17 = r4
        L_0x0146:
            r0.endDefaults()
            r13 = 0
            if (r7 == 0) goto L_0x0155
            float r1 = RadioButtonDotSize
            float r2 = (float) r6
            float r1 = r1 / r2
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r1)
            goto L_0x015a
        L_0x0155:
            float r1 = (float) r13
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r1)
        L_0x015a:
            r2 = 100
            r11 = 0
            r3 = 6
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r2, r13, r11, r3, r11)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r3 = 0
            r5 = 48
            r16 = 4
            r4 = r0
            r6 = r16
            androidx.compose.runtime.State r6 = androidx.compose.animation.core.AnimateAsStateKt.m102animateDpAsStateKz89ssw(r1, r2, r3, r4, r5, r6)
            int r1 = r10 >> 9
            r2 = r1 & 14
            int r3 = r10 << 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            androidx.compose.runtime.State r5 = r12.radioColor(r14, r7, r0, r1)
            r1 = 1941632354(0x73baf562, float:2.962476E31)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "94@4361L123"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            if (r8 == 0) goto L_0x01c8
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r2 = androidx.compose.ui.semantics.Role.Companion
            int r2 = r2.m4094getRadioButtono7Vup1c()
            r10 = 0
            float r3 = RadioButtonRippleRadius
            r18 = 0
            r4 = 54
            r16 = 4
            r11 = r3
            r20 = r12
            r3 = 0
            r12 = r18
            r18 = r14
            r14 = r0
            r21 = r15
            r15 = r4
            androidx.compose.foundation.Indication r4 = androidx.compose.material.ripple.RippleKt.m1521rememberRipple9IZ8Weo(r10, r11, r12, r14, r15, r16)
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.semantics.Role r10 = androidx.compose.ui.semantics.Role.m4084boximpl(r2)
            r11 = r0
            r0 = r1
            r1 = r22
            r2 = r17
            r12 = 0
            r3 = r4
            r4 = r18
            r13 = r5
            r5 = r10
            r10 = r6
            r6 = r23
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.SelectableKt.m816selectableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x01d6
        L_0x01c8:
            r11 = r0
            r13 = r5
            r10 = r6
            r20 = r12
            r18 = r14
            r21 = r15
            r12 = 0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x01d6:
            r11.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            if (r8 == 0) goto L_0x01e3
            androidx.compose.ui.Modifier r1 = androidx.compose.material.TouchTargetKt.minimumTouchTargetSize(r1)
        L_0x01e3:
            r2 = r21
            androidx.compose.ui.Modifier r1 = r2.then(r1)
            androidx.compose.ui.Modifier r0 = r1.then(r0)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r3 = 0
            r4 = 2
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r0, r1, r12, r4, r3)
            float r1 = RadioButtonPadding
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r0, r1)
            float r1 = RadioButtonSize
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m574requiredSize3ABfNKs(r0, r1)
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            boolean r1 = r11.changed((java.lang.Object) r13)
            boolean r3 = r11.changed((java.lang.Object) r10)
            r1 = r1 | r3
            java.lang.Object r3 = r11.rememberedValue()
            if (r1 != 0) goto L_0x0227
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x0232
        L_0x0227:
            androidx.compose.material.RadioButtonKt$RadioButton$2$1 r1 = new androidx.compose.material.RadioButtonKt$RadioButton$2$1
            r1.<init>(r13, r10)
            r3 = r1
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r11.updateRememberedValue(r3)
        L_0x0232:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.foundation.CanvasKt.Canvas(r0, r3, r11, r12)
            r3 = r2
            r5 = r17
            r4 = r18
            r6 = r20
        L_0x0241:
            androidx.compose.runtime.ScopeUpdateScope r10 = r11.endRestartGroup()
            if (r10 != 0) goto L_0x0248
            goto L_0x025b
        L_0x0248:
            androidx.compose.material.RadioButtonKt$RadioButton$3 r11 = new androidx.compose.material.RadioButtonKt$RadioButton$3
            r0 = r11
            r1 = r22
            r2 = r23
            r7 = r29
            r8 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x025b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.RadioButtonKt.RadioButton(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.RadioButtonColors, androidx.compose.runtime.Composer, int, int):void");
    }

    static {
        float f = (float) 2;
        RadioButtonPadding = Dp.m4704constructorimpl(f);
        float r1 = Dp.m4704constructorimpl((float) 20);
        RadioButtonSize = r1;
        RadioRadius = Dp.m4704constructorimpl(r1 / f);
        RadioStrokeWidth = Dp.m4704constructorimpl(f);
    }
}
