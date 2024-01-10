package io.intercom.android.sdk.m5.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"DayDivider", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DayDividerPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: DayDivider.kt */
public final class DayDividerKt {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DayDivider(java.lang.String r26, androidx.compose.ui.Modifier r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r0 = r26
            r15 = r29
            r13 = r30
            java.lang.String r1 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = 2031997384(0x791dd1c8, float:5.121534E34)
            r2 = r28
            androidx.compose.runtime.Composer r14 = r2.startRestartGroup(r1)
            r1 = r13 & 1
            r2 = 4
            if (r1 == 0) goto L_0x001c
            r1 = r15 | 6
            goto L_0x002c
        L_0x001c:
            r1 = r15 & 14
            if (r1 != 0) goto L_0x002b
            boolean r1 = r14.changed((java.lang.Object) r0)
            if (r1 == 0) goto L_0x0028
            r1 = 4
            goto L_0x0029
        L_0x0028:
            r1 = 2
        L_0x0029:
            r1 = r1 | r15
            goto L_0x002c
        L_0x002b:
            r1 = r15
        L_0x002c:
            r3 = r13 & 2
            if (r3 == 0) goto L_0x0033
            r1 = r1 | 48
            goto L_0x0046
        L_0x0033:
            r4 = r15 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0046
            r4 = r27
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0042
            r5 = 32
            goto L_0x0044
        L_0x0042:
            r5 = 16
        L_0x0044:
            r1 = r1 | r5
            goto L_0x0048
        L_0x0046:
            r4 = r27
        L_0x0048:
            r20 = r1
            r1 = r20 & 91
            r5 = 18
            if (r1 != r5) goto L_0x005e
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x0057
            goto L_0x005e
        L_0x0057:
            r14.skipToGroupEnd()
            r25 = r14
            goto L_0x01c4
        L_0x005e:
            if (r3 == 0) goto L_0x0066
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r12 = r1
            goto L_0x0067
        L_0x0066:
            r12 = r4
        L_0x0067:
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r1 = r1.getCenter()
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r3 = r3.getCenterVertically()
            r4 = 3
            r5 = 0
            r6 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r12, r5, r6, r4, r5)
            r7 = 4294309365(0xfff5f5f5, double:2.12167073E-314)
            long r7 = androidx.compose.ui.graphics.ColorKt.Color((long) r7)
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            r11 = 8
            androidx.compose.material.Shapes r5 = r5.getShapes(r14, r11)
            androidx.compose.foundation.shape.CornerBasedShape r5 = r5.getMedium()
            androidx.compose.ui.graphics.Shape r5 = (androidx.compose.ui.graphics.Shape) r5
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r4, r7, r5)
            r5 = 12
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r5)
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r2)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m511paddingVpY3zN4(r4, r5, r2)
            r4 = 693286680(0x2952b718, float:4.6788176E-14)
            r14.startReplaceableGroup(r4)
            java.lang.String r4 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r4)
            androidx.compose.foundation.layout.Arrangement$Horizontal r1 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r1
            r4 = 54
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r1, r3, r14, r4)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r14.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r5)
            java.lang.Object r3 = r14.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r5)
            java.lang.Object r7 = r14.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r5)
            java.lang.Object r4 = r14.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r8 = r14.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0113
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0113:
            r14.startReusableNode()
            boolean r8 = r14.getInserting()
            if (r8 == 0) goto L_0x0120
            r14.createNode(r5)
            goto L_0x0123
        L_0x0120:
            r14.useNode()
        L_0x0123:
            r14.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1543constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r1, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r3, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r7, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r4, r1)
            r14.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            r2.invoke(r1, r14, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r1)
            r1 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            r1 = 0
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r16 = 0
            r1 = 8
            r11 = r16
            r24 = r12
            r12 = r16
            r16 = 0
            r2 = r14
            r13 = r16
            r3 = 0
            r15 = r3
            r16 = 0
            r17 = 0
            r18 = 0
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r1 = r3.getTypography(r2, r1)
            androidx.compose.ui.text.TextStyle r19 = r1.getCaption()
            r21 = r20 & 14
            r22 = 0
            r23 = 32766(0x7ffe, float:4.5915E-41)
            r1 = r0
            r0 = r26
            r20 = r2
            r25 = r2
            r1 = 0
            r2 = 0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r25.endReplaceableGroup()
            r25.endReplaceableGroup()
            r25.endNode()
            r25.endReplaceableGroup()
            r25.endReplaceableGroup()
            r4 = r24
        L_0x01c4:
            androidx.compose.runtime.ScopeUpdateScope r0 = r25.endRestartGroup()
            if (r0 != 0) goto L_0x01cb
            goto L_0x01db
        L_0x01cb:
            io.intercom.android.sdk.m5.components.DayDividerKt$DayDivider$2 r1 = new io.intercom.android.sdk.m5.components.DayDividerKt$DayDivider$2
            r2 = r26
            r3 = r29
            r5 = r30
            r1.<init>(r2, r4, r3, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0.updateScope(r1)
        L_0x01db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.components.DayDividerKt.DayDivider(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void DayDividerPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(2024327134);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$DayDividerKt.INSTANCE.m5146getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DayDividerKt$DayDividerPreview$1(i));
        }
    }
}
