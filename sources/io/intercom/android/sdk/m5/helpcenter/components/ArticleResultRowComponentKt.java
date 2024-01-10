package io.intercom.android.sdk.m5.helpcenter.components;

import android.text.Html;
import android.text.Spanned;
import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.core.text.HtmlCompat;
import io.intercom.android.sdk.helpcenter.search.HighlightTagHandler;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¨\u0006\u000f"}, d2 = {"ArticleResultRowComponent", "", "item", "Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow$ArticleResultRow;", "onClick", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/intercom/android/sdk/helpcenter/search/ArticleSearchResultRow$ArticleResultRow;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ArticleRowComponentPreview", "(Landroidx/compose/runtime/Composer;I)V", "highlightedText", "Landroid/text/Spanned;", "rawText", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleResultRowComponent.kt */
public final class ArticleResultRowComponentKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ArticleResultRowComponent(io.intercom.android.sdk.helpcenter.search.ArticleSearchResultRow.ArticleResultRow r30, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r31, androidx.compose.ui.Modifier r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r1 = r30
            r2 = r31
            r4 = r34
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = -1512248495(0xffffffffa5dceb51, float:-3.8323373E-16)
            r3 = r33
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            r3 = r35 & 1
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
            r5 = r35 & 2
            r6 = 16
            if (r5 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x0049
        L_0x0039:
            r5 = r4 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0049
            boolean r5 = r0.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r3 = r3 | r5
        L_0x0049:
            r5 = r35 & 4
            if (r5 == 0) goto L_0x0050
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r7 = r4 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0063
            r7 = r32
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x005f
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r3 = r3 | r8
            goto L_0x0065
        L_0x0063:
            r7 = r32
        L_0x0065:
            r3 = r3 & 731(0x2db, float:1.024E-42)
            r8 = 146(0x92, float:2.05E-43)
            if (r3 != r8) goto L_0x0078
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x0072
            goto L_0x0078
        L_0x0072:
            r0.skipToGroupEnd()
            r3 = r7
            goto L_0x038c
        L_0x0078:
            if (r5 == 0) goto L_0x007f
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0080
        L_0x007f:
            r3 = r7
        L_0x0080:
            r5 = 0
            r15 = 1
            r13 = 0
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r3, r5, r15, r13)
            r17 = 0
            r18 = 0
            r19 = 0
            r7 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            boolean r7 = r0.changed((java.lang.Object) r2)
            boolean r8 = r0.changed((java.lang.Object) r1)
            r7 = r7 | r8
            java.lang.Object r8 = r0.rememberedValue()
            if (r7 != 0) goto L_0x00af
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r8 != r7) goto L_0x00ba
        L_0x00af:
            io.intercom.android.sdk.m5.helpcenter.components.ArticleResultRowComponentKt$ArticleResultRowComponent$1$1 r7 = new io.intercom.android.sdk.m5.helpcenter.components.ArticleResultRowComponentKt$ArticleResultRowComponent$1$1
            r7.<init>(r2, r1)
            r8 = r7
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r0.updateRememberedValue(r8)
        L_0x00ba:
            r0.endReplaceableGroup()
            r20 = r8
            kotlin.jvm.functions.Function0 r20 = (kotlin.jvm.functions.Function0) r20
            r21 = 7
            r22 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r16, r17, r18, r19, r20, r21, r22)
            float r6 = (float) r6
            float r8 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.PaddingKt.m512paddingVpY3zN4$default(r7, r5, r8, r15, r13)
            float r17 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 14
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r16, r17, r18, r19, r20, r21, r22)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r6 = r6.getCenterVertically()
            r7 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r7.getStart()
            r8 = 48
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r7, r6, r0, r8)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r7)
            java.lang.String r8 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r11 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r11)
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r11)
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r14 = r16
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r11)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r14 = (androidx.compose.ui.platform.ViewConfiguration) r14
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x015c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x015c:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x0169
            r0.createNode(r13)
            goto L_0x016c
        L_0x0169:
            r0.useNode()
        L_0x016c:
            r0.disableReusing()
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r6, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r9, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r12, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r14, r6)
            r0.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r6)
            r14 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r14)
            r5.invoke(r6, r0, r9)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r5)
            r6 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            androidx.compose.foundation.layout.RowScopeInstance r6 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r17 = r6
            androidx.compose.foundation.layout.RowScope r17 = (androidx.compose.foundation.layout.RowScope) r17
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            r18 = r6
            androidx.compose.ui.Modifier r18 = (androidx.compose.ui.Modifier) r18
            r19 = 1065353216(0x3f800000, float:1.0)
            r20 = 0
            r21 = 2
            r22 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r17, r18, r19, r20, r21, r22)
            r9 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r9)
            java.lang.String r9 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r9 = r9.getTop()
            androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r12 = r12.getStart()
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r9, r12, r0, r14)
            r0.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r11)
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r11)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r11)
            java.lang.Object r10 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            androidx.compose.runtime.Applier r12 = r0.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x023f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x023f:
            r0.startReusableNode()
            boolean r12 = r0.getInserting()
            if (r12 == 0) goto L_0x024c
            r0.createNode(r11)
            goto L_0x024f
        L_0x024c:
            r0.useNode()
        L_0x024f:
            r0.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r9, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r7, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r8, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r10, r7)
            r0.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r7)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r14)
            r6.invoke(r7, r0, r8)
            r0.startReplaceableGroup(r5)
            r5 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            androidx.compose.foundation.layout.ColumnScopeInstance r5 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r5 = (androidx.compose.foundation.layout.ColumnScope) r5
            java.lang.String r5 = r30.getTitleText()
            android.text.Spanned r5 = highlightedText(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r13 = 0
            r15 = 1
            androidx.compose.ui.text.AnnotatedString r5 = io.intercom.android.sdk.survey.block.BlockExtensionsKt.toAnnotatedString$default(r5, r13, r15, r13)
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            r12 = 8
            androidx.compose.material.Typography r6 = r6.getTypography(r0, r12)
            androidx.compose.ui.text.TextStyle r25 = r6.getSubtitle1()
            androidx.compose.ui.text.style.TextOverflow$Companion r6 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r20 = r6.m4591getEllipsisgIe3tQ8()
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r6 = r6.getColors(r0, r12)
            long r7 = r6.m1213getOnSurface0d7_KjU()
            r6 = 0
            r9 = 0
            r11 = 0
            r16 = 0
            r12 = r16
            r13 = r16
            r16 = 0
            r14 = r16
            r16 = 0
            r17 = 0
            r18 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r27 = 0
            r28 = 48
            r29 = 63482(0xf7fa, float:8.8957E-41)
            r26 = r0
            androidx.compose.material.TextKt.m1495Text4IGK_g(r5, r6, r7, r9, r11, r12, r13, r14, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r5 = -255981092(0xfffffffff0be09dc, float:-4.7051257E29)
            r0.startReplaceableGroup(r5)
            int r5 = r30.getSummaryVisibility()
            if (r5 != 0) goto L_0x0367
            java.lang.String r5 = r30.getSummaryText()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            r6 = 1
            r5 = r5 ^ r6
            if (r5 == 0) goto L_0x0367
            r5 = 4
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r5)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r3, r5)
            r14 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r5, r0, r14)
            java.lang.String r5 = r30.getSummaryText()
            android.text.Spanned r5 = highlightedText(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r7 = 0
            androidx.compose.ui.text.AnnotatedString r5 = io.intercom.android.sdk.survey.block.BlockExtensionsKt.toAnnotatedString$default(r5, r7, r6, r7)
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            r7 = 8
            androidx.compose.material.Typography r6 = r6.getTypography(r0, r7)
            androidx.compose.ui.text.TextStyle r25 = r6.getBody2()
            androidx.compose.ui.text.style.TextOverflow$Companion r6 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r20 = r6.m4591getEllipsisgIe3tQ8()
            r6 = 4286611584(0xff808080, double:2.1178675207E-314)
            long r7 = androidx.compose.ui.graphics.ColorKt.Color((long) r6)
            r6 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r14 = r15
            r16 = 0
            r17 = 0
            r18 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r27 = 384(0x180, float:5.38E-43)
            r28 = 48
            r29 = 63482(0xf7fa, float:8.8957E-41)
            r26 = r0
            androidx.compose.material.TextKt.m1495Text4IGK_g(r5, r6, r7, r9, r11, r12, r13, r14, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
        L_0x0367:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r5 = 0
            io.intercom.android.sdk.m5.components.IntercomChevronKt.IntercomChevron(r0, r5)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x038c:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x0393
            goto L_0x03a6
        L_0x0393:
            io.intercom.android.sdk.m5.helpcenter.components.ArticleResultRowComponentKt$ArticleResultRowComponent$3 r7 = new io.intercom.android.sdk.m5.helpcenter.components.ArticleResultRowComponentKt$ArticleResultRowComponent$3
            r0 = r7
            r1 = r30
            r2 = r31
            r4 = r34
            r5 = r35
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x03a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.helpcenter.components.ArticleResultRowComponentKt.ArticleResultRowComponent(io.intercom.android.sdk.helpcenter.search.ArticleSearchResultRow$ArticleResultRow, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Spanned highlightedText(String str) {
        HighlightTagHandler highlightTagHandler = new HighlightTagHandler();
        Spanned fromHtml = HtmlCompat.fromHtml("&zwj;" + str, 0, (Html.ImageGetter) null, highlightTagHandler);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(\n        \"$invi…\n        tagHandler\n    )");
        return fromHtml;
    }

    /* access modifiers changed from: private */
    public static final void ArticleRowComponentPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1018396845);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ArticleResultRowComponentKt.INSTANCE.m5194getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ArticleResultRowComponentKt$ArticleRowComponentPreview$1(i));
        }
    }
}
