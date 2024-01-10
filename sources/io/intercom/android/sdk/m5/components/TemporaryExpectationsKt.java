package io.intercom.android.sdk.m5.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"TemporaryExpectations", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TemporaryExpectationsPreview", "(Landroidx/compose/runtime/Composer;I)V", "TemporaryExpectationsShortTextPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TemporaryExpectations.kt */
public final class TemporaryExpectationsKt {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TemporaryExpectations(java.lang.String r26, androidx.compose.ui.Modifier r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r0 = r26
            r15 = r29
            r13 = r30
            java.lang.String r1 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = -699496526(0xffffffffd64e87b2, float:-5.6770551E13)
            r2 = r28
            androidx.compose.runtime.Composer r14 = r2.startRestartGroup(r1)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r15 | 6
            goto L_0x002b
        L_0x001b:
            r1 = r15 & 14
            if (r1 != 0) goto L_0x002a
            boolean r1 = r14.changed((java.lang.Object) r0)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r15
            goto L_0x002b
        L_0x002a:
            r1 = r15
        L_0x002b:
            r2 = r13 & 2
            r3 = 16
            if (r2 == 0) goto L_0x0034
            r1 = r1 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r15 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0047
            r4 = r27
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r1 = r1 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r27
        L_0x0049:
            r20 = r1
            r1 = r20 & 91
            r5 = 18
            if (r1 != r5) goto L_0x005f
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x0058
            goto L_0x005f
        L_0x0058:
            r14.skipToGroupEnd()
            r25 = r14
            goto L_0x01ee
        L_0x005f:
            if (r2 == 0) goto L_0x0067
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r12 = r1
            goto L_0x0068
        L_0x0067:
            r12 = r4
        L_0x0068:
            androidx.compose.foundation.layout.Arrangement r1 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r1 = r1.getStart()
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r2 = r2.getCenterVertically()
            r4 = 0
            r5 = 0
            r6 = 1
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r12, r4, r6, r5)
            r5 = 4294309365(0xfff5f5f5, double:2.12167073E-314)
            long r5 = androidx.compose.ui.graphics.ColorKt.Color((long) r5)
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            r11 = 8
            androidx.compose.material.Shapes r7 = r7.getShapes(r14, r11)
            androidx.compose.foundation.shape.CornerBasedShape r7 = r7.getMedium()
            androidx.compose.ui.graphics.Shape r7 = (androidx.compose.ui.graphics.Shape) r7
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r4, r5, r7)
            r5 = 12
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r5)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r4, r5)
            r5 = 693286680(0x2952b718, float:4.6788176E-14)
            r14.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            r5 = 54
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r1, r2, r14, r5)
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r14.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r6)
            java.lang.Object r2 = r14.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r6)
            java.lang.Object r7 = r14.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r6)
            java.lang.Object r5 = r14.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            androidx.compose.runtime.Applier r8 = r14.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x010d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x010d:
            r14.startReusableNode()
            boolean r8 = r14.getInserting()
            if (r8 == 0) goto L_0x011a
            r14.createNode(r6)
            goto L_0x011d
        L_0x011a:
            r14.useNode()
        L_0x011d:
            r14.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1543constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r1, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r2, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r7, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r5, r1)
            r14.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.invoke(r1, r14, r2)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r1)
            r1 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            androidx.compose.material.icons.Icons$Outlined r1 = androidx.compose.material.icons.Icons.Outlined.INSTANCE
            androidx.compose.ui.graphics.vector.ImageVector r2 = androidx.compose.material.icons.outlined.InfoKt.getInfo(r1)
            r1 = 0
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            float r10 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r10)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.m582size3ABfNKs(r4, r3)
            r5 = 0
            r8 = 432(0x1b0, float:6.05E-43)
            r9 = 8
            r3 = r1
            r7 = r14
            androidx.compose.material.IconKt.m1314Iconww6aTOc((androidx.compose.ui.graphics.vector.ImageVector) r2, (java.lang.String) r3, (androidx.compose.ui.Modifier) r4, (long) r5, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r2 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r10)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r1, r2)
            r2 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r14, r2)
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
        L_0x01ee:
            androidx.compose.runtime.ScopeUpdateScope r0 = r25.endRestartGroup()
            if (r0 != 0) goto L_0x01f5
            goto L_0x0205
        L_0x01f5:
            io.intercom.android.sdk.m5.components.TemporaryExpectationsKt$TemporaryExpectations$2 r1 = new io.intercom.android.sdk.m5.components.TemporaryExpectationsKt$TemporaryExpectations$2
            r2 = r26
            r3 = r29
            r5 = r30
            r1.<init>(r2, r4, r3, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0.updateScope(r1)
        L_0x0205:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.components.TemporaryExpectationsKt.TemporaryExpectations(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void TemporaryExpectationsPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2059122468);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TemporaryExpectationsKt.INSTANCE.m5167getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TemporaryExpectationsKt$TemporaryExpectationsPreview$1(i));
        }
    }

    public static final void TemporaryExpectationsShortTextPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-414669689);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TemporaryExpectationsKt.INSTANCE.m5168getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TemporaryExpectationsKt$TemporaryExpectationsShortTextPreview$1(i));
        }
    }
}
