package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aL\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001aZ\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u00132\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u0014\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"RippleRadius", "Landroidx/compose/ui/unit/Dp;", "F", "IconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: IconButton.kt */
public final class IconButtonKt {
    private static final float RippleRadius = Dp.m4704constructorimpl((float) 24);

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void IconButton(kotlin.jvm.functions.Function0<kotlin.Unit> r19, androidx.compose.ui.Modifier r20, boolean r21, androidx.compose.foundation.interaction.MutableInteractionSource r22, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r9 = r19
            r10 = r23
            r11 = r25
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -111063634(0xfffffffff9614dae, float:-7.3115145E34)
            r1 = r24
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(IconButton)P(4,3,1,2)62@2761L39,73@3131L54,65@2846L598:IconButton.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = r26 & 1
            if (r0 == 0) goto L_0x0025
            r0 = r11 | 6
            goto L_0x0035
        L_0x0025:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x0034
            boolean r0 = r12.changed((java.lang.Object) r9)
            if (r0 == 0) goto L_0x0031
            r0 = 4
            goto L_0x0032
        L_0x0031:
            r0 = 2
        L_0x0032:
            r0 = r0 | r11
            goto L_0x0035
        L_0x0034:
            r0 = r11
        L_0x0035:
            r1 = r26 & 2
            if (r1 == 0) goto L_0x003c
            r0 = r0 | 48
            goto L_0x004f
        L_0x003c:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004f
            r2 = r20
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x004b
            r3 = 32
            goto L_0x004d
        L_0x004b:
            r3 = 16
        L_0x004d:
            r0 = r0 | r3
            goto L_0x0051
        L_0x004f:
            r2 = r20
        L_0x0051:
            r3 = r26 & 4
            if (r3 == 0) goto L_0x0058
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0058:
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006b
            r4 = r21
            boolean r5 = r12.changed((boolean) r4)
            if (r5 == 0) goto L_0x0067
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r0 = r0 | r5
            goto L_0x006d
        L_0x006b:
            r4 = r21
        L_0x006d:
            r5 = r26 & 8
            if (r5 == 0) goto L_0x0074
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0087
        L_0x0074:
            r6 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0087
            r6 = r22
            boolean r7 = r12.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0083
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r0 = r0 | r7
            goto L_0x0089
        L_0x0087:
            r6 = r22
        L_0x0089:
            r7 = r26 & 16
            if (r7 == 0) goto L_0x0090
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x0090:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r11
            if (r7 != 0) goto L_0x00a2
            boolean r7 = r12.changed((java.lang.Object) r10)
            if (r7 == 0) goto L_0x009f
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r0 = r0 | r7
        L_0x00a2:
            r13 = r0
            r0 = 46811(0xb6db, float:6.5596E-41)
            r0 = r0 & r13
            r7 = 9362(0x2492, float:1.3119E-41)
            if (r0 != r7) goto L_0x00b9
            boolean r0 = r12.getSkipping()
            if (r0 != 0) goto L_0x00b2
            goto L_0x00b9
        L_0x00b2:
            r12.skipToGroupEnd()
            r3 = r4
            r4 = r6
            goto L_0x0265
        L_0x00b9:
            if (r1 == 0) goto L_0x00c1
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r14 = r0
            goto L_0x00c2
        L_0x00c1:
            r14 = r2
        L_0x00c2:
            if (r3 == 0) goto L_0x00c7
            r16 = 1
            goto L_0x00c9
        L_0x00c7:
            r16 = r4
        L_0x00c9:
            if (r5 == 0) goto L_0x00f1
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            java.lang.Object r0 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x00e9
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r12.updateRememberedValue(r0)
        L_0x00e9:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r17 = r0
            goto L_0x00f3
        L_0x00f1:
            r17 = r6
        L_0x00f3:
            androidx.compose.ui.Modifier r0 = androidx.compose.material.TouchTargetKt.minimumTouchTargetSize(r14)
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r8 = r1.m4091getButtono7Vup1c()
            r1 = 0
            float r2 = RippleRadius
            r3 = 0
            r6 = 54
            r7 = 4
            r5 = r12
            androidx.compose.foundation.Indication r2 = androidx.compose.material.ripple.RippleKt.m1521rememberRipple9IZ8Weo(r1, r2, r3, r5, r6, r7)
            r4 = 0
            androidx.compose.ui.semantics.Role r5 = androidx.compose.ui.semantics.Role.m4084boximpl(r8)
            r7 = 8
            r8 = 0
            r1 = r17
            r3 = r16
            r6 = r19
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r12.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            r2 = 0
            r3 = 6
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r2, r12, r3)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12.startReplaceableGroup(r4)
            java.lang.String r4 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r5, r6)
            java.lang.Object r4 = r12.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r5, r6)
            java.lang.Object r7 = r12.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r5, r6)
            java.lang.Object r8 = r12.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r18.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r3 = r12.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x018e
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x018e:
            r12.startReusableNode()
            boolean r3 = r12.getInserting()
            if (r3 == 0) goto L_0x019b
            r12.createNode(r15)
            goto L_0x019e
        L_0x019b:
            r12.useNode()
        L_0x019e:
            r12.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m1543constructorimpl(r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r1, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r7, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r8, r1)
            r12.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r12, r3)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r0)
            r0 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -2146259096(0xffffffff8012af68, float:-1.715963E-39)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "C78@3354L84:IconButton.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            if (r16 == 0) goto L_0x021f
            r0 = 753555775(0x2cea593f, float:6.6605883E-12)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "77@3311L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r5, r6)
            java.lang.Object r0 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            goto L_0x0231
        L_0x021f:
            r0 = 753555801(0x2cea5959, float:6.6605996E-12)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "77@3337L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            androidx.compose.material.ContentAlpha r0 = androidx.compose.material.ContentAlpha.INSTANCE
            r1 = 6
            float r0 = r0.getDisabled(r12, r1)
        L_0x0231:
            r12.endReplaceableGroup()
            r1 = 1
            androidx.compose.runtime.ProvidedValue[] r1 = new androidx.compose.runtime.ProvidedValue[r1]
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            androidx.compose.runtime.ProvidedValue r0 = r3.provides(r0)
            r1[r2] = r0
            int r0 = r13 >> 9
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 8
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r1, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r10, (androidx.compose.runtime.Composer) r12, (int) r0)
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            r2 = r14
            r3 = r16
            r4 = r17
        L_0x0265:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 != 0) goto L_0x026c
            goto L_0x027f
        L_0x026c:
            androidx.compose.material.IconButtonKt$IconButton$3 r12 = new androidx.compose.material.IconButtonKt$IconButton$3
            r0 = r12
            r1 = r19
            r5 = r23
            r6 = r25
            r7 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r8.updateScope(r12)
        L_0x027f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.IconButtonKt.IconButton(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void IconToggleButton(boolean r21, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r22, androidx.compose.ui.Modifier r23, boolean r24, androidx.compose.foundation.interaction.MutableInteractionSource r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r7 = r22
            r8 = r26
            r9 = r28
            java.lang.String r0 = "onCheckedChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -54657793(0xfffffffffcbdfcff, float:-7.891804E36)
            r1 = r27
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(IconToggleButton)P(!1,5,4,2,3)106@4690L39,118@5086L54,109@4775L620:IconButton.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r0 = r29 & 1
            if (r0 == 0) goto L_0x0027
            r0 = r9 | 6
            r5 = r21
            goto L_0x0039
        L_0x0027:
            r0 = r9 & 14
            r5 = r21
            if (r0 != 0) goto L_0x0038
            boolean r0 = r6.changed((boolean) r5)
            if (r0 == 0) goto L_0x0035
            r0 = 4
            goto L_0x0036
        L_0x0035:
            r0 = 2
        L_0x0036:
            r0 = r0 | r9
            goto L_0x0039
        L_0x0038:
            r0 = r9
        L_0x0039:
            r1 = r29 & 2
            if (r1 == 0) goto L_0x0040
            r0 = r0 | 48
            goto L_0x0050
        L_0x0040:
            r1 = r9 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0050
            boolean r1 = r6.changed((java.lang.Object) r7)
            if (r1 == 0) goto L_0x004d
            r1 = 32
            goto L_0x004f
        L_0x004d:
            r1 = 16
        L_0x004f:
            r0 = r0 | r1
        L_0x0050:
            r1 = r29 & 4
            if (r1 == 0) goto L_0x0057
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x0057:
            r2 = r9 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x006a
            r2 = r23
            boolean r3 = r6.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0066
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r0 = r0 | r3
            goto L_0x006c
        L_0x006a:
            r2 = r23
        L_0x006c:
            r3 = r29 & 8
            if (r3 == 0) goto L_0x0073
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0073:
            r4 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0086
            r4 = r24
            boolean r10 = r6.changed((boolean) r4)
            if (r10 == 0) goto L_0x0082
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r0 = r0 | r10
            goto L_0x0088
        L_0x0086:
            r4 = r24
        L_0x0088:
            r10 = r29 & 16
            if (r10 == 0) goto L_0x008f
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a4
        L_0x008f:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r9
            if (r11 != 0) goto L_0x00a4
            r11 = r25
            boolean r12 = r6.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x00a0
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r0 = r0 | r12
            goto L_0x00a6
        L_0x00a4:
            r11 = r25
        L_0x00a6:
            r12 = r29 & 32
            if (r12 == 0) goto L_0x00ae
            r12 = 196608(0x30000, float:2.75506E-40)
        L_0x00ac:
            r0 = r0 | r12
            goto L_0x00bf
        L_0x00ae:
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r9
            if (r12 != 0) goto L_0x00bf
            boolean r12 = r6.changed((java.lang.Object) r8)
            if (r12 == 0) goto L_0x00bc
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ac
        L_0x00bc:
            r12 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ac
        L_0x00bf:
            r17 = r0
            r0 = 374491(0x5b6db, float:5.24774E-40)
            r0 = r17 & r0
            r12 = 74898(0x12492, float:1.04954E-40)
            if (r0 != r12) goto L_0x00da
            boolean r0 = r6.getSkipping()
            if (r0 != 0) goto L_0x00d2
            goto L_0x00da
        L_0x00d2:
            r6.skipToGroupEnd()
            r3 = r2
            r10 = r6
            r5 = r11
            goto L_0x028a
        L_0x00da:
            if (r1 == 0) goto L_0x00e3
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r18 = r0
            goto L_0x00e5
        L_0x00e3:
            r18 = r2
        L_0x00e5:
            r2 = 1
            if (r3 == 0) goto L_0x00eb
            r19 = 1
            goto L_0x00ed
        L_0x00eb:
            r19 = r4
        L_0x00ed:
            if (r10 == 0) goto L_0x0115
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            java.lang.Object r0 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x010d
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r6.updateRememberedValue(r0)
        L_0x010d:
            r6.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r20 = r0
            goto L_0x0117
        L_0x0115:
            r20 = r11
        L_0x0117:
            androidx.compose.ui.Modifier r0 = androidx.compose.material.TouchTargetKt.minimumTouchTargetSize(r18)
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m4092getCheckboxo7Vup1c()
            r10 = 0
            float r11 = RippleRadius
            r12 = 0
            r15 = 54
            r16 = 4
            r14 = r6
            androidx.compose.foundation.Indication r3 = androidx.compose.material.ripple.RippleKt.m1521rememberRipple9IZ8Weo(r10, r11, r12, r14, r15, r16)
            androidx.compose.ui.semantics.Role r10 = androidx.compose.ui.semantics.Role.m4084boximpl(r1)
            r1 = r21
            r11 = 1
            r2 = r20
            r4 = r19
            r5 = r10
            r10 = r6
            r6 = r22
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m820toggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            r2 = 0
            r3 = 6
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r2, r10, r3)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r10.startReplaceableGroup(r4)
            java.lang.String r4 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r6)
            java.lang.Object r4 = r10.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r6)
            java.lang.Object r12 = r10.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r6)
            java.lang.Object r13 = r10.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.ViewConfiguration r13 = (androidx.compose.ui.platform.ViewConfiguration) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r15 = r10.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x01b4
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01b4:
            r10.startReusableNode()
            boolean r15 = r10.getInserting()
            if (r15 == 0) goto L_0x01c1
            r10.createNode(r14)
            goto L_0x01c4
        L_0x01c1:
            r10.useNode()
        L_0x01c4:
            r10.disableReusing()
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m1543constructorimpl(r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r1, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r12, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r13, r1)
            r10.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r10)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r10, r4)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r10.startReplaceableGroup(r0)
            r0 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -430124743(0xffffffffe65cd139, float:-2.6069503E23)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C123@5305L84:IconButton.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            if (r19 == 0) goto L_0x0245
            r0 = -1866758102(0xffffffff90bb882a, float:-7.396829E-29)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "122@5262L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r5, r6)
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            goto L_0x0256
        L_0x0245:
            r0 = -1866758076(0xffffffff90bb8844, float:-7.3968445E-29)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "122@5288L8"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            androidx.compose.material.ContentAlpha r0 = androidx.compose.material.ContentAlpha.INSTANCE
            float r0 = r0.getDisabled(r10, r3)
        L_0x0256:
            r10.endReplaceableGroup()
            androidx.compose.runtime.ProvidedValue[] r1 = new androidx.compose.runtime.ProvidedValue[r11]
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            androidx.compose.runtime.ProvidedValue r0 = r3.provides(r0)
            r1[r2] = r0
            int r0 = r17 >> 12
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 8
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r1, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r8, (androidx.compose.runtime.Composer) r10, (int) r0)
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r3 = r18
            r4 = r19
            r5 = r20
        L_0x028a:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x0291
            goto L_0x02a6
        L_0x0291:
            androidx.compose.material.IconButtonKt$IconToggleButton$3 r11 = new androidx.compose.material.IconButtonKt$IconToggleButton$3
            r0 = r11
            r1 = r21
            r2 = r22
            r6 = r26
            r7 = r28
            r8 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x02a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.IconButtonKt.IconToggleButton(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
