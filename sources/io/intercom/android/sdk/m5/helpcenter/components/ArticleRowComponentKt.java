package io.intercom.android.sdk.m5.helpcenter.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0001¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"ArticleRowComponent", "", "modifier", "Landroidx/compose/ui/Modifier;", "articleRow", "Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow$ArticleRow;", "onClick", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/helpcenter/collections/ArticleSectionRow$ArticleRow;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ArticleRowComponentLongTextPreview", "(Landroidx/compose/runtime/Composer;I)V", "ArticleRowComponentPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleRowComponent.kt */
public final class ArticleRowComponentKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ArticleRowComponent(androidx.compose.ui.Modifier r29, io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow.ArticleRow r30, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r2 = r30
            r4 = r33
            java.lang.String r0 = "articleRow"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = 1139600872(0x43ecede8, float:473.85864)
            r1 = r32
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r34 & 1
            if (r1 == 0) goto L_0x001c
            r3 = r4 | 6
            r5 = r3
            r3 = r29
            goto L_0x0030
        L_0x001c:
            r3 = r4 & 14
            if (r3 != 0) goto L_0x002d
            r3 = r29
            boolean r5 = r0.changed((java.lang.Object) r3)
            if (r5 == 0) goto L_0x002a
            r5 = 4
            goto L_0x002b
        L_0x002a:
            r5 = 2
        L_0x002b:
            r5 = r5 | r4
            goto L_0x0030
        L_0x002d:
            r3 = r29
            r5 = r4
        L_0x0030:
            r6 = r34 & 2
            r7 = 16
            if (r6 == 0) goto L_0x0039
            r5 = r5 | 48
            goto L_0x0049
        L_0x0039:
            r6 = r4 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0049
            boolean r6 = r0.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r5 = r5 | r6
        L_0x0049:
            r6 = r34 & 4
            if (r6 == 0) goto L_0x0050
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r8 = r4 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0063
            r8 = r31
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r5 = r5 | r9
            goto L_0x0065
        L_0x0063:
            r8 = r31
        L_0x0065:
            r5 = r5 & 731(0x2db, float:1.024E-42)
            r9 = 146(0x92, float:2.05E-43)
            if (r5 != r9) goto L_0x0079
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x0072
            goto L_0x0079
        L_0x0072:
            r0.skipToGroupEnd()
            r1 = r3
            r3 = r8
            goto L_0x0228
        L_0x0079:
            if (r1 == 0) goto L_0x0080
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0081
        L_0x0080:
            r1 = r3
        L_0x0081:
            if (r6 == 0) goto L_0x0088
            io.intercom.android.sdk.m5.helpcenter.components.ArticleRowComponentKt$ArticleRowComponent$1 r3 = io.intercom.android.sdk.m5.helpcenter.components.ArticleRowComponentKt$ArticleRowComponent$1.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            goto L_0x0089
        L_0x0088:
            r3 = r8
        L_0x0089:
            r5 = 0
            r6 = 1
            r8 = 0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r5, r6, r8)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            boolean r13 = r0.changed((java.lang.Object) r3)
            boolean r14 = r0.changed((java.lang.Object) r2)
            r13 = r13 | r14
            java.lang.Object r14 = r0.rememberedValue()
            if (r13 != 0) goto L_0x00b5
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x00c0
        L_0x00b5:
            io.intercom.android.sdk.m5.helpcenter.components.ArticleRowComponentKt$ArticleRowComponent$2$1 r13 = new io.intercom.android.sdk.m5.helpcenter.components.ArticleRowComponentKt$ArticleRowComponent$2$1
            r13.<init>(r3, r2)
            r14 = r13
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r0.updateRememberedValue(r14)
        L_0x00c0:
            r0.endReplaceableGroup()
            r13 = r14
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r14 = 7
            r15 = 0
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r9, r10, r11, r12, r13, r14, r15)
            float r7 = (float) r7
            float r17 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 14
            r22 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r16, r17, r18, r19, r20, r21, r22)
            r9 = 12
            float r9 = (float) r9
            float r9 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r9)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.PaddingKt.m512paddingVpY3zN4$default(r7, r5, r9, r6, r8)
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r6 = r6.getSpaceBetween()
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
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r9)
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r9)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r9)
            java.lang.Object r8 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            androidx.compose.runtime.Applier r11 = r0.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0164
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0164:
            r0.startReusableNode()
            boolean r11 = r0.getInserting()
            if (r11 == 0) goto L_0x0171
            r0.createNode(r9)
            goto L_0x0174
        L_0x0171:
            r0.useNode()
        L_0x0174:
            r0.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r6, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r7, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r10, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r8, r6)
            r0.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r6)
            r14 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r14)
            r5.invoke(r6, r0, r7)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r5)
            r5 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            androidx.compose.foundation.layout.RowScopeInstance r5 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r15 = r5
            androidx.compose.foundation.layout.RowScope r15 = (androidx.compose.foundation.layout.RowScope) r15
            java.lang.String r5 = r30.getTitle()
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            r7 = 8
            androidx.compose.material.Typography r6 = r6.getTypography(r0, r7)
            androidx.compose.ui.text.TextStyle r24 = r6.getBody2()
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r6 = r6.getColors(r0, r7)
            long r7 = r6.m1213getOnSurface0d7_KjU()
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            r16 = r6
            androidx.compose.ui.Modifier r16 = (androidx.compose.ui.Modifier) r16
            r17 = 1065353216(0x3f800000, float:1.0)
            r18 = 0
            r19 = 2
            r20 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r15, r16, r17, r18, r19, r20)
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r14 = r15
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 32760(0x7ff8, float:4.5907E-41)
            r25 = r0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r5, r6, r7, r9, r11, r12, r13, r14, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r5 = 0
            io.intercom.android.sdk.m5.components.IntercomChevronKt.IntercomChevron(r0, r5)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x0228:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x022f
            goto L_0x0240
        L_0x022f:
            io.intercom.android.sdk.m5.helpcenter.components.ArticleRowComponentKt$ArticleRowComponent$4 r7 = new io.intercom.android.sdk.m5.helpcenter.components.ArticleRowComponentKt$ArticleRowComponent$4
            r0 = r7
            r2 = r30
            r4 = r33
            r5 = r34
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x0240:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.helpcenter.components.ArticleRowComponentKt.ArticleRowComponent(androidx.compose.ui.Modifier, io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow$ArticleRow, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void ArticleRowComponentPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-394242294);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ArticleRowComponentKt.INSTANCE.m5195getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ArticleRowComponentKt$ArticleRowComponentPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void ArticleRowComponentLongTextPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1522762701);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ArticleRowComponentKt.INSTANCE.m5196getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ArticleRowComponentKt$ArticleRowComponentLongTextPreview$1(i));
        }
    }
}
