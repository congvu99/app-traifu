package io.intercom.android.sdk.tickets;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a)\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\n"}, d2 = {"SimplePreview", "", "(Landroidx/compose/runtime/Composer;I)V", "TicketStatusRow", "ticketStatus", "", "time", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "WithNamePreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketStatusRow.kt */
public final class TicketStatusRowKt {
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TicketStatusRow(java.lang.String r31, java.lang.String r32, java.lang.String r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r1 = r31
            r2 = r32
            r4 = r35
            java.lang.String r0 = "ticketStatus"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "time"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = 1124460482(0x4305e7c2, float:133.9053)
            r3 = r34
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            r3 = r36 & 1
            if (r3 == 0) goto L_0x0020
            r3 = r4 | 6
            goto L_0x0030
        L_0x0020:
            r3 = r4 & 14
            if (r3 != 0) goto L_0x002f
            boolean r3 = r0.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r4
            goto L_0x0030
        L_0x002f:
            r3 = r4
        L_0x0030:
            r5 = r36 & 2
            if (r5 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x0047
        L_0x0037:
            r5 = r4 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0047
            boolean r5 = r0.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x0044
            r5 = 32
            goto L_0x0046
        L_0x0044:
            r5 = 16
        L_0x0046:
            r3 = r3 | r5
        L_0x0047:
            r5 = r36 & 4
            if (r5 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r6 = r4 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0061
            r6 = r33
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005d
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r7
            goto L_0x0063
        L_0x0061:
            r6 = r33
        L_0x0063:
            r3 = r3 & 731(0x2db, float:1.024E-42)
            r7 = 146(0x92, float:2.05E-43)
            if (r3 != r7) goto L_0x0076
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x0070
            goto L_0x0076
        L_0x0070:
            r0.skipToGroupEnd()
            r3 = r6
            goto L_0x029c
        L_0x0076:
            r3 = 0
            if (r5 == 0) goto L_0x007c
            r30 = r3
            goto L_0x007e
        L_0x007c:
            r30 = r6
        L_0x007e:
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r14 = 0
            r15 = 1
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r5, r14, r15, r3)
            r6 = 3
            r12 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.wrapContentHeight$default(r5, r3, r12, r6, r3)
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r6 = r6.getCenter()
            androidx.compose.foundation.layout.Arrangement$Horizontal r6 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r6
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r7 = r7.getCenterVertically()
            r8 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            r8 = 54
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r6, r7, r0, r8)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r10)
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r10)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r10)
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            androidx.compose.runtime.Applier r14 = r0.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0108
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0108:
            r0.startReusableNode()
            boolean r14 = r0.getInserting()
            if (r14 == 0) goto L_0x0115
            r0.createNode(r11)
            goto L_0x0118
        L_0x0115:
            r0.useNode()
        L_0x0118:
            r0.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r6, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r7, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r8, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r9, r6)
            r0.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)
            r5.invoke(r6, r0, r7)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r5)
            r5 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            androidx.compose.foundation.layout.RowScopeInstance r5 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r5 = (androidx.compose.foundation.layout.RowScope) r5
            int r5 = io.intercom.android.sdk.R.drawable.intercom_ticket_detail_icon
            androidx.compose.ui.graphics.painter.Painter r5 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r5, r0, r12)
            r6 = 0
            r7 = 0
            r16 = 4285756278(0xff737376, double:2.1174449434E-314)
            long r8 = androidx.compose.ui.graphics.ColorKt.Color((long) r16)
            r11 = 3128(0xc38, float:4.383E-42)
            r14 = 4
            r13 = r10
            r10 = r0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            r15 = 0
            r12 = r14
            androidx.compose.material.IconKt.m1313Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r5, (java.lang.String) r6, (androidx.compose.ui.Modifier) r7, (long) r8, (androidx.compose.runtime.Composer) r10, (int) r11, (int) r12)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r6 = 8
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r5, r6)
            r6 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r5, r0, r6)
            java.lang.String r5 = "timestamp"
            java.lang.String r6 = "</b>"
            java.lang.String r7 = "<b>"
            if (r30 == 0) goto L_0x01f8
            r8 = -810272809(0xffffffffcfb437d7, float:-6.0471168E9)
            r0.startReplaceableGroup(r8)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r3, r13)
            java.lang.Object r3 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.content.Context r3 = (android.content.Context) r3
            int r8 = io.intercom.android.sdk.R.string.intercom_tickets_status_event_moved
            io.intercom.android.sdk.utilities.Phrase r3 = io.intercom.android.sdk.utilities.Phrase.from((android.content.Context) r3, (int) r8)
            r8 = r30
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.lang.String r9 = "teammate"
            io.intercom.android.sdk.utilities.Phrase r3 = r3.put((java.lang.String) r9, (java.lang.CharSequence) r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r1)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r7 = "status"
            io.intercom.android.sdk.utilities.Phrase r3 = r3.put((java.lang.String) r7, (java.lang.CharSequence) r6)
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            io.intercom.android.sdk.utilities.Phrase r3 = r3.put((java.lang.String) r5, (java.lang.CharSequence) r6)
            java.lang.CharSequence r3 = r3.format()
            java.lang.String r3 = r3.toString()
            r0.endReplaceableGroup()
            goto L_0x0242
        L_0x01f8:
            r8 = -810272512(0xffffffffcfb43900, float:-6.0472689E9)
            r0.startReplaceableGroup(r8)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r3, r13)
            java.lang.Object r3 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.content.Context r3 = (android.content.Context) r3
            int r8 = io.intercom.android.sdk.R.string.intercom_tickets_status_event_submitted
            io.intercom.android.sdk.utilities.Phrase r3 = io.intercom.android.sdk.utilities.Phrase.from((android.content.Context) r3, (int) r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r1)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r7 = "submitted_status"
            io.intercom.android.sdk.utilities.Phrase r3 = r3.put((java.lang.String) r7, (java.lang.CharSequence) r6)
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            io.intercom.android.sdk.utilities.Phrase r3 = r3.put((java.lang.String) r5, (java.lang.CharSequence) r6)
            java.lang.CharSequence r3 = r3.format()
            java.lang.String r3 = r3.toString()
            r0.endReplaceableGroup()
        L_0x0242:
            android.text.Spanned r3 = androidx.core.text.HtmlCompat.fromHtml(r3, r15)
            java.lang.String r5 = "fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r6 = 1
            r9 = 0
            androidx.compose.ui.text.AnnotatedString r5 = io.intercom.android.sdk.survey.block.BlockExtensionsKt.toAnnotatedString$default(r3, r9, r6, r9)
            long r7 = androidx.compose.ui.graphics.ColorKt.Color((long) r16)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r10 = 4
            float r10 = (float) r10
            float r10 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r10)
            r11 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.PaddingKt.m512paddingVpY3zN4$default(r3, r11, r10, r6, r9)
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 432(0x1b0, float:6.05E-43)
            r28 = 0
            r29 = 131064(0x1fff8, float:1.8366E-40)
            r26 = r0
            androidx.compose.material.TextKt.m1495Text4IGK_g(r5, r6, r7, r9, r11, r12, r13, r14, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r3 = r30
        L_0x029c:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x02a3
            goto L_0x02b6
        L_0x02a3:
            io.intercom.android.sdk.tickets.TicketStatusRowKt$TicketStatusRow$2 r7 = new io.intercom.android.sdk.tickets.TicketStatusRowKt$TicketStatusRow$2
            r0 = r7
            r1 = r31
            r2 = r32
            r4 = r35
            r5 = r36
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x02b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.tickets.TicketStatusRowKt.TicketStatusRow(java.lang.String, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void SimplePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(305887565);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TicketStatusRowKt.INSTANCE.m5363getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TicketStatusRowKt$SimplePreview$1(i));
        }
    }

    public static final void WithNamePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1155031278);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TicketStatusRowKt.INSTANCE.m5364getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TicketStatusRowKt$WithNamePreview$1(i));
        }
    }
}
