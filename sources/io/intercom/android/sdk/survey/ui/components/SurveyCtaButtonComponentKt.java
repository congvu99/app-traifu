package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import io.intercom.android.sdk.survey.SurveyState;
import io.intercom.android.sdk.survey.SurveyViewModelKt;
import io.intercom.android.sdk.survey.model.SurveyCustomization;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a]\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"DarkButtonPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "LightButtonPreview", "SecondaryCtaPreview", "SurveyCtaButtonComponent", "modifier", "Landroidx/compose/ui/Modifier;", "primaryCtaText", "", "secondaryCtas", "", "Lio/intercom/android/sdk/survey/SurveyState$Content$SecondaryCta;", "onPrimaryCtaClicked", "Lkotlin/Function0;", "onSecondaryCtaClicked", "Lkotlin/Function1;", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lio/intercom/android/sdk/survey/SurveyUiColors;Landroidx/compose/runtime/Composer;II)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyCtaButtonComponent.kt */
public final class SurveyCtaButtonComponentKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v37, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03f7  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x023f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SurveyCtaButtonComponent(androidx.compose.ui.Modifier r32, java.lang.String r33, java.util.List<io.intercom.android.sdk.survey.SurveyState.Content.SecondaryCta> r34, kotlin.jvm.functions.Function0<kotlin.Unit> r35, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.survey.SurveyState.Content.SecondaryCta, kotlin.Unit> r36, io.intercom.android.sdk.survey.SurveyUiColors r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r2 = r33
            r6 = r37
            r7 = r39
            java.lang.String r0 = "primaryCtaText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "surveyUiColors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = -1455595547(0xffffffffa93d5fe5, float:-4.2049606E-14)
            r1 = r38
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r40 & 1
            r3 = 4
            if (r1 == 0) goto L_0x0024
            r5 = r7 | 6
            r8 = r5
            r5 = r32
            goto L_0x0038
        L_0x0024:
            r5 = r7 & 14
            if (r5 != 0) goto L_0x0035
            r5 = r32
            boolean r8 = r0.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x0032
            r8 = 4
            goto L_0x0033
        L_0x0032:
            r8 = 2
        L_0x0033:
            r8 = r8 | r7
            goto L_0x0038
        L_0x0035:
            r5 = r32
            r8 = r7
        L_0x0038:
            r9 = r40 & 2
            if (r9 == 0) goto L_0x003f
            r8 = r8 | 48
            goto L_0x004f
        L_0x003f:
            r9 = r7 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x004f
            boolean r9 = r0.changed((java.lang.Object) r2)
            if (r9 == 0) goto L_0x004c
            r9 = 32
            goto L_0x004e
        L_0x004c:
            r9 = 16
        L_0x004e:
            r8 = r8 | r9
        L_0x004f:
            r9 = r40 & 4
            if (r9 == 0) goto L_0x0055
            r8 = r8 | 128(0x80, float:1.794E-43)
        L_0x0055:
            r11 = r40 & 8
            if (r11 == 0) goto L_0x005c
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x006f
        L_0x005c:
            r12 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x006f
            r12 = r35
            boolean r13 = r0.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x006b
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x006d
        L_0x006b:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x006d:
            r8 = r8 | r13
            goto L_0x0071
        L_0x006f:
            r12 = r35
        L_0x0071:
            r13 = r40 & 16
            if (r13 == 0) goto L_0x0078
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            goto L_0x008d
        L_0x0078:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r7
            if (r14 != 0) goto L_0x008d
            r14 = r36
            boolean r15 = r0.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x0089
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x008b
        L_0x0089:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x008b:
            r8 = r8 | r15
            goto L_0x008f
        L_0x008d:
            r14 = r36
        L_0x008f:
            r15 = r40 & 32
            if (r15 == 0) goto L_0x0097
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x0095:
            r8 = r8 | r15
            goto L_0x00a8
        L_0x0097:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r7
            if (r15 != 0) goto L_0x00a8
            boolean r15 = r0.changed((java.lang.Object) r6)
            if (r15 == 0) goto L_0x00a5
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0095
        L_0x00a5:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0095
        L_0x00a8:
            if (r9 != r3) goto L_0x00c4
            r3 = 374491(0x5b6db, float:5.24774E-40)
            r3 = r3 & r8
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r3 != r15) goto L_0x00c4
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x00ba
            goto L_0x00c4
        L_0x00ba:
            r0.skipToGroupEnd()
            r3 = r34
            r1 = r5
            r4 = r12
            r5 = r14
            goto L_0x03f0
        L_0x00c4:
            r0.startDefaults()
            r3 = r7 & 1
            if (r3 == 0) goto L_0x00e0
            boolean r3 = r0.getDefaultsInvalid()
            if (r3 == 0) goto L_0x00d2
            goto L_0x00e0
        L_0x00d2:
            r0.skipToGroupEnd()
            if (r9 == 0) goto L_0x00d9
            r8 = r8 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00d9:
            r3 = r34
            r1 = r5
        L_0x00dc:
            r13 = r8
            r5 = r12
            r15 = r14
            goto L_0x0103
        L_0x00e0:
            if (r1 == 0) goto L_0x00e7
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00e8
        L_0x00e7:
            r1 = r5
        L_0x00e8:
            if (r9 == 0) goto L_0x00f1
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            r8 = r8 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00f3
        L_0x00f1:
            r3 = r34
        L_0x00f3:
            if (r11 == 0) goto L_0x00fa
            io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$1 r5 = io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$1.INSTANCE
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r12 = r5
        L_0x00fa:
            if (r13 == 0) goto L_0x00dc
            io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$2 r5 = io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$2.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r15 = r5
            r13 = r8
            r5 = r12
        L_0x0103:
            r0.endDefaults()
            r14 = 1
            float r8 = (float) r14
            float r8 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r8)
            long r11 = r37.m5275getButtonBorder0d7_KjU()
            androidx.compose.foundation.BorderStroke r21 = androidx.compose.foundation.BorderStrokeKt.m191BorderStrokecXLIe8U(r8, r11)
            r8 = 8
            float r11 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r11)
            androidx.compose.foundation.shape.RoundedCornerShape r22 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m855RoundedCornerShape0680j_4(r8)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            r9 = 0
            r12 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r8, r9, r14, r12)
            r9 = 56
            float r9 = (float) r9
            float r9 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r9)
            androidx.compose.ui.Modifier r23 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r8, r9)
            r8 = r13 & 14
            r9 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r9)
            java.lang.String r9 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r9 = r9.getTop()
            androidx.compose.ui.Alignment$Companion r16 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r12 = r16.getStart()
            int r16 = r8 >> 3
            r17 = r16 & 14
            r16 = r16 & 112(0x70, float:1.57E-43)
            r14 = r17 | r16
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r9, r12, r0, r14)
            int r12 = r8 << 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r14)
            java.lang.String r14 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r4)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r7 = r17
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r4)
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r18 = r11
            r11 = r17
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r4)
            java.lang.Object r4 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r11 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            int r12 = r12 << 9
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r35 = r15
            r15 = 6
            r12 = r12 | r15
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x01c6
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01c6:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x01d3
            r0.createNode(r10)
            goto L_0x01d6
        L_0x01d3:
            r0.useNode()
        L_0x01d6:
            r0.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r9, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r14, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r7, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r4, r7)
            r0.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r4)
            int r7 = r12 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r11.invoke(r4, r0, r7)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r4)
            int r4 = r12 >> 9
            r4 = r4 & 14
            r7 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            r4 = r4 & 11
            r7 = 2
            if (r4 != r7) goto L_0x023f
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x0238
            goto L_0x023f
        L_0x0238:
            r0.skipToGroupEnd()
        L_0x023b:
            r24 = r35
            goto L_0x03de
        L_0x023f:
            androidx.compose.foundation.layout.ColumnScopeInstance r4 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            r7 = 6
            int r8 = r8 >> r7
            r8 = r8 & 112(0x70, float:1.57E-43)
            r8 = r8 | r7
            androidx.compose.foundation.layout.ColumnScope r4 = (androidx.compose.foundation.layout.ColumnScope) r4
            r4 = r8 & 81
            r8 = 16
            if (r4 != r8) goto L_0x0259
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x0255
            goto L_0x0259
        L_0x0255:
            r0.skipToGroupEnd()
            goto L_0x023b
        L_0x0259:
            r4 = 1146156825(0x4450f719, float:835.8609)
            r0.startReplaceableGroup(r4)
            r4 = r3
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0266:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x0315
            java.lang.Object r8 = r4.next()
            r15 = r8
            io.intercom.android.sdk.survey.SurveyState$Content$SecondaryCta r15 = (io.intercom.android.sdk.survey.SurveyState.Content.SecondaryCta) r15
            androidx.compose.material.ButtonDefaults r8 = androidx.compose.material.ButtonDefaults.INSTANCE
            long r9 = r37.m5274getButton0d7_KjU()
            r11 = 0
            r16 = 0
            r19 = 0
            r24 = 32768(0x8000, float:4.5918E-41)
            r25 = 14
            r26 = r18
            r27 = 0
            r7 = r13
            r13 = r16
            r29 = r35
            r28 = r15
            r15 = r19
            r17 = r0
            r18 = r24
            r19 = r25
            androidx.compose.material.ButtonColors r15 = r8.m1164buttonColorsro_MJ88(r9, r11, r13, r15, r17, r18, r19)
            r8 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            r14 = r29
            boolean r8 = r0.changed((java.lang.Object) r14)
            r9 = r28
            boolean r10 = r0.changed((java.lang.Object) r9)
            r8 = r8 | r10
            java.lang.Object r10 = r0.rememberedValue()
            if (r8 != 0) goto L_0x02c1
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r10 != r8) goto L_0x02cc
        L_0x02c1:
            io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$3$1$1$1 r8 = new io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$3$1$1$1
            r8.<init>(r14, r9)
            r10 = r8
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r0.updateRememberedValue(r10)
        L_0x02cc:
            r0.endReplaceableGroup()
            r8 = r10
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r10 = 0
            r13 = r22
            androidx.compose.ui.graphics.Shape r13 = (androidx.compose.ui.graphics.Shape) r13
            r16 = 0
            r12 = 468620518(0x1bee94e6, float:3.947002E-22)
            io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$3$1$2 r11 = new io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$3$1$2
            r11.<init>(r9, r6)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r12, r9, r11)
            r17 = r11
            kotlin.jvm.functions.Function3 r17 = (kotlin.jvm.functions.Function3) r17
            r19 = 805306416(0x30000030, float:4.6566395E-10)
            r20 = 284(0x11c, float:3.98E-43)
            r12 = 1
            r9 = r23
            r11 = 0
            r12 = 0
            r24 = r14
            r14 = r21
            r18 = r0
            androidx.compose.material.ButtonKt.Button(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            float r9 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r26)
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r8, r9)
            r9 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r8, r0, r9)
            r13 = r7
            r35 = r24
            r18 = r26
            r7 = 6
            goto L_0x0266
        L_0x0315:
            r24 = r35
            r7 = r13
            r27 = 0
            r0.endReplaceableGroup()
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0339
            kotlin.Pair r4 = new kotlin.Pair
            long r8 = r37.m5274getButton0d7_KjU()
            androidx.compose.ui.graphics.Color r8 = androidx.compose.ui.graphics.Color.m1922boximpl(r8)
            long r9 = r37.m5278getOnButton0d7_KjU()
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m1922boximpl(r9)
            r4.<init>(r8, r9)
            goto L_0x0350
        L_0x0339:
            kotlin.Pair r4 = new kotlin.Pair
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            long r8 = r8.m1967getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r8 = androidx.compose.ui.graphics.Color.m1922boximpl(r8)
            long r9 = r37.m5277getOnBackground0d7_KjU()
            androidx.compose.ui.graphics.Color r9 = androidx.compose.ui.graphics.Color.m1922boximpl(r9)
            r4.<init>(r8, r9)
        L_0x0350:
            java.lang.Object r8 = r4.component1()
            androidx.compose.ui.graphics.Color r8 = (androidx.compose.ui.graphics.Color) r8
            long r17 = r8.m1942unboximpl()
            java.lang.Object r4 = r4.component2()
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            long r14 = r4.m1942unboximpl()
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x036b
            goto L_0x036d
        L_0x036b:
            r21 = r27
        L_0x036d:
            r4 = 1146158169(0x4450fc59, float:835.94293)
            r0.startReplaceableGroup(r4)
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x038f
            androidx.compose.material.ButtonDefaults r8 = androidx.compose.material.ButtonDefaults.INSTANCE
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = 262144(0x40000, float:3.67342E-40)
            r16 = 31
            r30 = r14
            r14 = r0
            r15 = r4
            androidx.compose.material.ButtonElevation r4 = r8.m1165elevationR_JCAzs(r9, r10, r11, r12, r13, r14, r15, r16)
            r27 = r4
            goto L_0x0391
        L_0x038f:
            r30 = r14
        L_0x0391:
            r0.endReplaceableGroup()
            androidx.compose.material.ButtonDefaults r8 = androidx.compose.material.ButtonDefaults.INSTANCE
            r11 = 0
            r13 = 0
            r15 = 0
            r4 = 32768(0x8000, float:4.5918E-41)
            r19 = 14
            r9 = r17
            r17 = r0
            r18 = r4
            androidx.compose.material.ButtonColors r15 = r8.m1164buttonColorsro_MJ88(r9, r11, r13, r15, r17, r18, r19)
            r10 = 0
            r13 = r22
            androidx.compose.ui.graphics.Shape r13 = (androidx.compose.ui.graphics.Shape) r13
            r16 = 0
            r4 = 767351755(0x2dbcdbcb, float:2.1470733E-11)
            io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$3$2 r8 = new io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$3$2
            r11 = r30
            r8.<init>(r2, r11, r7)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r4, r9, r8)
            r17 = r4
            kotlin.jvm.functions.Function3 r17 = (kotlin.jvm.functions.Function3) r17
            r4 = 805306416(0x30000030, float:4.6566395E-10)
            int r7 = r7 >> 9
            r7 = r7 & 14
            r19 = r7 | r4
            r20 = 268(0x10c, float:3.76E-43)
            r8 = r5
            r9 = r23
            r4 = 0
            r11 = r4
            r12 = r27
            r14 = r21
            r18 = r0
            androidx.compose.material.ButtonKt.Button(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
        L_0x03de:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r4 = r5
            r5 = r24
        L_0x03f0:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x03f7
            goto L_0x040a
        L_0x03f7:
            io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$4 r10 = new io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt$SurveyCtaButtonComponent$4
            r0 = r10
            r2 = r33
            r6 = r37
            r7 = r39
            r8 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x040a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.components.SurveyCtaButtonComponentKt.SurveyCtaButtonComponent(androidx.compose.ui.Modifier, java.lang.String, java.util.List, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, io.intercom.android.sdk.survey.SurveyUiColors, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void LightButtonPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1401512691);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r5 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r5, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r5, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r5, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r5, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            SurveyCtaButtonComponent((Modifier) null, "Submit", (List<SurveyState.Content.SecondaryCta>) null, (Function0<Unit>) null, (Function1<? super SurveyState.Content.SecondaryCta, Unit>) null, SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)), startRestartGroup, 48, 29);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SurveyCtaButtonComponentKt$LightButtonPreview$2(i));
        }
    }

    public static final void DarkButtonPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-41399177);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r5 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r5, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r5, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r5, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r5, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            SurveyCtaButtonComponent((Modifier) null, "Submit", (List<SurveyState.Content.SecondaryCta>) null, (Function0<Unit>) null, (Function1<? super SurveyState.Content.SecondaryCta, Unit>) null, SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, "#222222", 1, (DefaultConstructorMarker) null)), startRestartGroup, 48, 29);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SurveyCtaButtonComponentKt$DarkButtonPreview$2(i));
        }
    }

    public static final void SecondaryCtaPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1826494403);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r5 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r5, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r5, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r5, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r5, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            SurveyCtaButtonComponent((Modifier) null, "Submit", CollectionsKt.listOf(new SurveyState.Content.SecondaryCta("Open website", "https://www.google.com", true)), (Function0<Unit>) null, (Function1<? super SurveyState.Content.SecondaryCta, Unit>) null, SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)), startRestartGroup, 48, 25);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SurveyCtaButtonComponentKt$SecondaryCtaPreview$2(i));
        }
    }
}
