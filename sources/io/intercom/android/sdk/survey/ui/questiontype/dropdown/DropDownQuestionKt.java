package io.intercom.android.sdk.survey.ui.questiontype.dropdown;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.ThemeKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001aZ\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0013\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"dropDownQuestionModel", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$DropDownQuestionModel;", "ColoredDropDownSelectedQuestionPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "DropDownQuestion", "modifier", "Landroidx/compose/ui/Modifier;", "answer", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "onAnswer", "Lkotlin/Function1;", "colors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "questionHeader", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$DropDownQuestionModel;Lio/intercom/android/sdk/survey/ui/models/Answer;Lkotlin/jvm/functions/Function1;Lio/intercom/android/sdk/survey/SurveyUiColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DropDownQuestionPreview", "DropDownSelectedQuestionPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: DropDownQuestion.kt */
public final class DropDownQuestionKt {
    /* access modifiers changed from: private */
    public static final SurveyData.Step.Question.DropDownQuestionModel dropDownQuestionModel;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x06a3  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropDownQuestion(androidx.compose.ui.Modifier r65, io.intercom.android.sdk.survey.model.SurveyData.Step.Question.DropDownQuestionModel r66, io.intercom.android.sdk.survey.ui.models.Answer r67, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.survey.ui.models.Answer, kotlin.Unit> r68, io.intercom.android.sdk.survey.SurveyUiColors r69, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, androidx.compose.runtime.Composer r71, int r72, int r73) {
        /*
            java.lang.String r0 = "dropDownQuestionModel"
            r6 = r66
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "onAnswer"
            r7 = r68
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "colors"
            r8 = r69
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -881617573(0xffffffffcb73955b, float:-1.5963483E7)
            r1 = r71
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            r0 = r73 & 1
            if (r0 == 0) goto L_0x0029
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r33 = r0
            goto L_0x002b
        L_0x0029:
            r33 = r65
        L_0x002b:
            r0 = r73 & 4
            if (r0 == 0) goto L_0x0035
            io.intercom.android.sdk.survey.ui.models.Answer$NoAnswer$InitialNoAnswer r0 = io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer.InitialNoAnswer.INSTANCE
            io.intercom.android.sdk.survey.ui.models.Answer r0 = (io.intercom.android.sdk.survey.ui.models.Answer) r0
            r4 = r0
            goto L_0x0037
        L_0x0035:
            r4 = r67
        L_0x0037:
            r0 = r73 & 32
            if (r0 == 0) goto L_0x0043
            io.intercom.android.sdk.survey.ui.questiontype.dropdown.ComposableSingletons$DropDownQuestionKt r0 = io.intercom.android.sdk.survey.ui.questiontype.dropdown.ComposableSingletons$DropDownQuestionKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m5333getLambda1$intercom_sdk_base_release()
            r3 = r0
            goto L_0x0045
        L_0x0043:
            r3 = r70
        L_0x0045:
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r5.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            java.lang.Object r0 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            r2 = 2
            r9 = 0
            r15 = 0
            if (r0 != r1) goto L_0x006a
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r15)
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r9, r2, r9)
            r5.updateRememberedValue(r0)
        L_0x006a:
            r5.endReplaceableGroup()
            r1 = r0
            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
            boolean r0 = m5337DropDownQuestion$lambda1(r1)
            r13 = 1
            if (r0 != 0) goto L_0x007e
            boolean r0 = r4 instanceof io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer
            if (r0 != 0) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r0 = 0
            goto L_0x007f
        L_0x007e:
            r0 = 1
        L_0x007f:
            r10 = -1603121235(0xffffffffa0724fad, float:-2.052456E-19)
            r5.startReplaceableGroup(r10)
            r14 = 8
            if (r0 == 0) goto L_0x008e
            long r10 = r69.m5274getButton0d7_KjU()
            goto L_0x0098
        L_0x008e:
            androidx.compose.material.MaterialTheme r10 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r10 = r10.getColors(r5, r14)
            long r10 = r10.m1218getSurface0d7_KjU()
        L_0x0098:
            r17 = r10
            r5.endReplaceableGroup()
            if (r0 == 0) goto L_0x00a8
            long r10 = r69.m5274getButton0d7_KjU()
            long r10 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5396generateTextColor8_81llA(r10)
            goto L_0x00b1
        L_0x00a8:
            r10 = 4285756278(0xff737376, double:2.1174449434E-314)
            long r10 = androidx.compose.ui.graphics.ColorKt.Color((long) r10)
        L_0x00b1:
            r35 = r10
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r0 = r0.getColors(r5, r14)
            long r19 = r0.m1213getOnSurface0d7_KjU()
            r21 = 1036831949(0x3dcccccd, float:0.1)
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 14
            r26 = 0
            long r10 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r19, r21, r22, r23, r24, r25, r26)
            float r0 = (float) r13
            float r0 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r0)
            androidx.compose.ui.graphics.Color r12 = r69.m5276getDropDownSelectedColorQN2ZGVo()
            if (r12 == 0) goto L_0x00e0
            long r19 = r12.m1942unboximpl()
            r60 = r19
            goto L_0x00e2
        L_0x00e0:
            r60 = r35
        L_0x00e2:
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r9, r13)
            java.lang.Object r12 = r5.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r62 = r12
            androidx.compose.ui.focus.FocusManager r62 = (androidx.compose.ui.focus.FocusManager) r62
            r12 = r72 & 14
            r14 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r5.startReplaceableGroup(r14)
            java.lang.String r14 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r14)
            androidx.compose.ui.Alignment$Companion r14 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r14 = r14.getTopStart()
            int r16 = r12 >> 3
            r19 = r16 & 14
            r16 = r16 & 112(0x70, float:1.57E-43)
            r2 = r19 | r16
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r14, r15, r5, r2)
            int r14 = r12 << 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r15)
            java.lang.String r15 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r6 = r16
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r9, r13)
            java.lang.Object r6 = r5.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r7 = r16
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r9, r13)
            java.lang.Object r7 = r5.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r8 = r16
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r9, r13)
            java.lang.Object r8 = r5.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r16.getConstructor()
            r63 = r4
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r33)
            int r14 = r14 << 9
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r64 = r1
            r1 = 6
            r14 = r14 | r1
            androidx.compose.runtime.Applier r1 = r5.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x0184
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0184:
            r5.startReusableNode()
            boolean r1 = r5.getInserting()
            if (r1 == 0) goto L_0x0191
            r5.createNode(r9)
            goto L_0x0194
        L_0x0191:
            r5.useNode()
        L_0x0194:
            r5.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m1543constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r2, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r6, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r7, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r8, r2)
            r5.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            int r2 = r14 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r4.invoke(r1, r5, r2)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r1)
            int r2 = r14 >> 9
            r2 = r2 & 14
            r4 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r5.startReplaceableGroup(r4)
            java.lang.String r4 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r4)
            r2 = r2 & 11
            r4 = 2
            if (r2 != r4) goto L_0x0200
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L_0x01f6
            goto L_0x0200
        L_0x01f6:
            r5.skipToGroupEnd()
        L_0x01f9:
            r19 = r3
            r1 = r5
            r6 = r63
            goto L_0x068d
        L_0x0200:
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r4 = 6
            int r6 = r12 >> 6
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | r4
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r2 = r6 & 81
            r4 = 16
            if (r2 != r4) goto L_0x021b
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L_0x0217
            goto L_0x021b
        L_0x0217:
            r5.skipToGroupEnd()
            goto L_0x01f9
        L_0x021b:
            r2 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r5.startReplaceableGroup(r2)
            java.lang.String r6 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r8 = r8.getTop()
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r9 = r9.getStart()
            r12 = 0
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r8, r9, r5, r12)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r12, r13)
            java.lang.Object r9 = r5.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r12, r13)
            java.lang.Object r14 = r5.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.LayoutDirection r14 = (androidx.compose.ui.unit.LayoutDirection) r14
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r4 = r19
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r12, r13)
            java.lang.Object r4 = r5.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            androidx.compose.runtime.Applier r2 = r5.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x0294
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0294:
            r5.startReusableNode()
            boolean r2 = r5.getInserting()
            if (r2 == 0) goto L_0x02a1
            r5.createNode(r12)
            goto L_0x02a4
        L_0x02a1:
            r5.useNode()
        L_0x02a4:
            r5.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m1543constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r2, r8, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r2, r9, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r2, r14, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r2, r4, r8)
            r5.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r2)
            r4 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            r7.invoke(r2, r5, r8)
            r5.startReplaceableGroup(r1)
            r2 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r5.startReplaceableGroup(r2)
            java.lang.String r4 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r4)
            androidx.compose.foundation.layout.ColumnScopeInstance r7 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r7 = (androidx.compose.foundation.layout.ColumnScope) r7
            int r7 = r72 >> 15
            r7 = r7 & 14
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r3.invoke(r5, r7)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r8 = 8
            float r9 = (float) r8
            float r9 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r9)
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r7, r9)
            r9 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r7, r5, r9)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r9 = 0
            r12 = 0
            r14 = 1
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r7, r9, r14, r12)
            androidx.compose.material.MaterialTheme r12 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r12 = r12.getShapes(r5, r8)
            androidx.compose.foundation.shape.CornerBasedShape r12 = r12.getMedium()
            androidx.compose.ui.graphics.Shape r12 = (androidx.compose.ui.graphics.Shape) r12
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BorderKt.m182borderxT4_qwU(r7, r0, r10, r12)
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r7 = r7.getShapes(r5, r8)
            androidx.compose.foundation.shape.CornerBasedShape r7 = r7.getMedium()
            androidx.compose.ui.graphics.Shape r7 = (androidx.compose.ui.graphics.Shape) r7
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.draw.ClipKt.clip(r0, r7)
            r7 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r5.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r6 = r6.getTop()
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r7 = r7.getStart()
            r10 = 0
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r6, r7, r5, r10)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r10, r13)
            java.lang.Object r7 = r5.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r10, r13)
            java.lang.Object r11 = r5.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r10, r13)
            java.lang.Object r10 = r5.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r14 = r5.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x03ae
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03ae:
            r5.startReusableNode()
            boolean r14 = r5.getInserting()
            if (r14 == 0) goto L_0x03bb
            r5.createNode(r12)
            goto L_0x03be
        L_0x03bb:
            r5.useNode()
        L_0x03be:
            r5.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m1543constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r6, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r7, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r11, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r10, r6)
            r5.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r6)
            r7 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
            r0.invoke(r6, r5, r10)
            r5.startReplaceableGroup(r1)
            r5.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r4)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r2 = 0
            r4 = 1
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r0, r9, r4, r2)
            r19 = 0
            r20 = 2
            r21 = 0
            androidx.compose.ui.Modifier r25 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r16, r17, r19, r20, r21)
            r26 = 0
            r27 = 0
            r28 = 0
            r0 = 1157296644(0x44faf204, float:2007.563)
            r5.startReplaceableGroup(r0)
            java.lang.String r2 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            r2 = r64
            boolean r6 = r5.changed((java.lang.Object) r2)
            java.lang.Object r7 = r5.rememberedValue()
            if (r6 != 0) goto L_0x0442
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x044d
        L_0x0442:
            io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$1$1 r6 = new io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$1$1
            r6.<init>(r2)
            r7 = r6
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r5.updateRememberedValue(r7)
        L_0x044d:
            r5.endReplaceableGroup()
            r29 = r7
            kotlin.jvm.functions.Function0 r29 = (kotlin.jvm.functions.Function0) r29
            r30 = 7
            r31 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r25, r26, r27, r28, r29, r30, r31)
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r7 = r7.getSpaceBetween()
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r7
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r9 = r9.getCenterVertically()
            r10 = 693286680(0x2952b718, float:4.6788176E-14)
            r5.startReplaceableGroup(r10)
            java.lang.String r10 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r10)
            r10 = 54
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r7, r9, r5, r10)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r10, r13)
            java.lang.Object r9 = r5.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r10, r13)
            java.lang.Object r11 = r5.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r10, r13)
            java.lang.Object r10 = r5.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            androidx.compose.runtime.Applier r13 = r5.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x04d2
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x04d2:
            r5.startReusableNode()
            boolean r13 = r5.getInserting()
            if (r13 == 0) goto L_0x04df
            r5.createNode(r12)
            goto L_0x04e2
        L_0x04df:
            r5.useNode()
        L_0x04e2:
            r5.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m1543constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r7, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r9, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r11, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r10, r7)
            r5.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r7)
            r9 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
            r6.invoke(r7, r5, r10)
            r5.startReplaceableGroup(r1)
            r1 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r5.startReplaceableGroup(r1)
            java.lang.String r1 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            r1 = -673291215(0xffffffffd7de6431, float:-4.890438E14)
            r5.startReplaceableGroup(r1)
            java.lang.Integer r1 = r66.getPlaceHolderStringRes()
            if (r1 == 0) goto L_0x054c
            java.lang.Integer r1 = r66.getPlaceHolderStringRes()
            int r1 = r1.intValue()
            r6 = 0
            java.lang.String r1 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r1, r5, r6)
            goto L_0x0550
        L_0x054c:
            java.lang.String r1 = r66.getPlaceholder()
        L_0x0550:
            r5.endReplaceableGroup()
            r6 = r63
            boolean r7 = r6 instanceof io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer
            if (r7 == 0) goto L_0x0560
            r1 = r6
            io.intercom.android.sdk.survey.ui.models.Answer$SingleAnswer r1 = (io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer) r1
            java.lang.String r1 = r1.getAnswer()
        L_0x0560:
            r9 = r1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r7 = 16
            float r7 = (float) r7
            float r10 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r1, r10)
            r10 = 3
            r11 = 0
            r15 = 0
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r1, r11, r15, r10, r11)
            r11 = 0
            r13 = 0
            r1 = 8
            r8 = 1
            r4 = 0
            r8 = 0
            r15 = r4
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r1 = r4.getTypography(r5, r1)
            androidx.compose.ui.text.TextStyle r34 = r1.getBody2()
            r37 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r57 = 0
            r58 = 262142(0x3fffe, float:3.67339E-40)
            r59 = 0
            androidx.compose.ui.text.TextStyle r28 = androidx.compose.ui.text.TextStyle.m4228copyHL5avdY$default(r34, r35, r37, r39, r40, r41, r42, r43, r44, r46, r47, r48, r49, r51, r52, r53, r54, r55, r57, r58, r59)
            r30 = 48
            r31 = 0
            r32 = 32764(0x7ffc, float:4.5912E-41)
            r29 = r5
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r9, r10, r11, r13, r15, r16, r17, r18, r20, r21, r22, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            androidx.compose.material.icons.Icons r1 = androidx.compose.material.icons.Icons.INSTANCE
            androidx.compose.material.icons.Icons$Filled r1 = r1.getDefault()
            androidx.compose.ui.graphics.vector.ImageVector r9 = androidx.compose.material.icons.filled.ArrowDropDownKt.getArrowDropDown(r1)
            int r1 = io.intercom.android.sdk.R.string.intercom_choose_one
            java.lang.String r10 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r1, r5, r8)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r1, r4)
            r15 = 384(0x180, float:5.38E-43)
            r16 = 0
            r12 = r60
            r14 = r5
            androidx.compose.material.IconKt.m1314Iconww6aTOc((androidx.compose.ui.graphics.vector.ImageVector) r9, (java.lang.String) r10, (androidx.compose.ui.Modifier) r11, (long) r12, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16)
            r5.endReplaceableGroup()
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            r5.endReplaceableGroup()
            boolean r9 = m5337DropDownQuestion$lambda1(r2)
            r5.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            boolean r0 = r5.changed((java.lang.Object) r2)
            java.lang.Object r1 = r5.rememberedValue()
            if (r0 != 0) goto L_0x0628
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x0633
        L_0x0628:
            io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$3$1 r0 = new io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$3$1
            r0.<init>(r2)
            r1 = r0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r5.updateRememberedValue(r1)
        L_0x0633:
            r5.endReplaceableGroup()
            r10 = r1
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = 1061997773(0x3f4ccccd, float:0.8)
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth(r0, r1)
            r12 = 0
            r14 = 0
            r7 = -1603025601(0xffffffffa073c53f, float:-2.0648164E-19)
            io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$4 r8 = new io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$4
            r0 = r8
            r4 = r2
            r1 = r66
            r2 = r62
            r19 = r3
            r3 = r68
            r15 = r5
            r5 = r72
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r7, r0, r8)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r17 = 196992(0x30180, float:2.76045E-40)
            r18 = 24
            r1 = r15
            r15 = r0
            r16 = r1
            androidx.compose.material.AndroidMenu_androidKt.m1116DropdownMenuILWXrKs(r9, r10, r11, r12, r14, r15, r16, r17, r18)
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
        L_0x068d:
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r9 = r1.endRestartGroup()
            if (r9 != 0) goto L_0x06a3
            goto L_0x06bd
        L_0x06a3:
            io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$2 r10 = new io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$2
            r0 = r10
            r1 = r33
            r2 = r66
            r3 = r6
            r4 = r68
            r5 = r69
            r6 = r19
            r7 = r72
            r8 = r73
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x06bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt.DropDownQuestion(androidx.compose.ui.Modifier, io.intercom.android.sdk.survey.model.SurveyData$Step$Question$DropDownQuestionModel, io.intercom.android.sdk.survey.ui.models.Answer, kotlin.jvm.functions.Function1, io.intercom.android.sdk.survey.SurveyUiColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: DropDownQuestion$lambda-1  reason: not valid java name */
    private static final boolean m5337DropDownQuestion$lambda1(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DropDownQuestion$lambda-2  reason: not valid java name */
    public static final void m5338DropDownQuestion$lambda2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        dropDownQuestionModel = new SurveyData.Step.Question.DropDownQuestionModel(uuid, CollectionsKt.listOf(new Block.Builder().withType(BlockType.PARAGRAPH.getSerializedName()).withText("Is this a preview?")), true, CollectionsKt.listOf("Option A", "Option B", "Option C"), "Please Select", (Integer) null, 32, (DefaultConstructorMarker) null);
    }

    public static final void DropDownQuestionPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(281876673);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropDownQuestionPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$DropDownQuestionKt.INSTANCE.m5334getLambda2$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DropDownQuestionKt$DropDownQuestionPreview$1(i));
        }
    }

    public static final void DropDownSelectedQuestionPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-891294020);
        ComposerKt.sourceInformation(startRestartGroup, "C(DropDownSelectedQuestionPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$DropDownQuestionKt.INSTANCE.m5335getLambda3$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DropDownQuestionKt$DropDownSelectedQuestionPreview$1(i));
        }
    }

    public static final void ColoredDropDownSelectedQuestionPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2103500414);
        ComposerKt.sourceInformation(startRestartGroup, "C(ColoredDropDownSelectedQuestionPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$DropDownQuestionKt.INSTANCE.m5336getLambda4$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DropDownQuestionKt$ColoredDropDownSelectedQuestionPreview$1(i));
        }
    }
}
