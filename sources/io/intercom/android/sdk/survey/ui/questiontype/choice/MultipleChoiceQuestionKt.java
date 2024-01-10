package io.intercom.android.sdk.survey.ui.questiontype.choice;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import io.intercom.android.sdk.survey.SurveyUiColors;
import io.intercom.android.sdk.survey.SurveyViewModelKt;
import io.intercom.android.sdk.survey.model.SurveyCustomization;
import io.intercom.android.sdk.survey.ui.ThemeKt;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001aZ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0013\b\u0002\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0015\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"MultipleChoiceQuestion", "", "modifier", "Landroidx/compose/ui/Modifier;", "multipleChoiceQuestionModel", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$MultipleChoiceQuestionModel;", "answer", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "onAnswer", "Lkotlin/Function1;", "colors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "questionHeader", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$MultipleChoiceQuestionModel;Lio/intercom/android/sdk/survey/ui/models/Answer;Lkotlin/jvm/functions/Function1;Lio/intercom/android/sdk/survey/SurveyUiColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "MultipleChoiceQuestionPreview", "(Landroidx/compose/runtime/Composer;I)V", "MultipleChoiceQuestionPreviewDark", "PreviewQuestion", "surveyUiColors", "(Lio/intercom/android/sdk/survey/SurveyUiColors;Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultipleChoiceQuestion.kt */
public final class MultipleChoiceQuestionKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v9, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v10, resolved type: kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: type inference failed for: r3v38, types: [java.util.Set] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0503  */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MultipleChoiceQuestion(androidx.compose.ui.Modifier r30, io.intercom.android.sdk.survey.model.SurveyData.Step.Question.MultipleChoiceQuestionModel r31, io.intercom.android.sdk.survey.ui.models.Answer r32, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.survey.ui.models.Answer, kotlin.Unit> r33, io.intercom.android.sdk.survey.SurveyUiColors r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r4 = r33
            java.lang.String r0 = "multipleChoiceQuestionModel"
            r2 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onAnswer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "colors"
            r3 = r34
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 278916651(0x109fee2b, float:6.30814E-29)
            r1 = r36
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r38 & 1
            if (r1 == 0) goto L_0x0027
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0029
        L_0x0027:
            r1 = r30
        L_0x0029:
            r5 = r38 & 4
            if (r5 == 0) goto L_0x0033
            io.intercom.android.sdk.survey.ui.models.Answer$NoAnswer$InitialNoAnswer r5 = io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer.InitialNoAnswer.INSTANCE
            io.intercom.android.sdk.survey.ui.models.Answer r5 = (io.intercom.android.sdk.survey.ui.models.Answer) r5
            r14 = r5
            goto L_0x0035
        L_0x0033:
            r14 = r32
        L_0x0035:
            r5 = r38 & 32
            if (r5 == 0) goto L_0x0041
            io.intercom.android.sdk.survey.ui.questiontype.choice.ComposableSingletons$MultipleChoiceQuestionKt r5 = io.intercom.android.sdk.survey.ui.questiontype.choice.ComposableSingletons$MultipleChoiceQuestionKt.INSTANCE
            kotlin.jvm.functions.Function2 r5 = r5.m5327getLambda1$intercom_sdk_base_release()
            r15 = r5
            goto L_0x0043
        L_0x0041:
            r15 = r35
        L_0x0043:
            r5 = r37 & 14
            r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getTopStart()
            int r7 = r5 >> 3
            r8 = r7 & 14
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | r8
            r13 = 0
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r13, r0, r7)
            int r7 = r5 << 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r8)
            java.lang.String r9 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r12 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r12)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r8 = r16
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r12)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r13 = r16
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r12)
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r13 = (androidx.compose.ui.platform.ViewConfiguration) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            int r7 = r7 << 9
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r3 = 6
            r7 = r7 | r3
            androidx.compose.runtime.Applier r3 = r0.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x00cb
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00cb:
            r0.startReusableNode()
            boolean r3 = r0.getInserting()
            if (r3 == 0) goto L_0x00d8
            r0.createNode(r11)
            goto L_0x00db
        L_0x00d8:
            r0.useNode()
        L_0x00db:
            r0.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r6, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r10, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r8, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r13, r6)
            r0.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r3)
            int r6 = r7 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2.invoke(r3, r0, r6)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            int r3 = r7 >> 9
            r3 = r3 & 14
            r6 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            r21 = 11
            r3 = r3 & 11
            r13 = 2
            if (r3 != r13) goto L_0x0148
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x013f
            goto L_0x0148
        L_0x013f:
            r0.skipToGroupEnd()
        L_0x0142:
            r32 = r14
            r29 = r15
            goto L_0x04ed
        L_0x0148:
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r6 = 6
            int r5 = r5 >> r6
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r3 = r5 & 81
            r5 = 16
            if (r3 != r5) goto L_0x0162
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x015e
            goto L_0x0162
        L_0x015e:
            r0.skipToGroupEnd()
            goto L_0x0142
        L_0x0162:
            r3 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r5 = r5.getTop()
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r6 = r6.getStart()
            r7 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r5, r6, r0, r7)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r12)
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r12)
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r12)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            androidx.compose.runtime.Applier r10 = r0.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x01d9
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01d9:
            r0.startReusableNode()
            boolean r10 = r0.getInserting()
            if (r10 == 0) goto L_0x01e6
            r0.createNode(r9)
            goto L_0x01e9
        L_0x01e6:
            r0.useNode()
        L_0x01e9:
            r0.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r5, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r6, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r7, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r8, r5)
            r0.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r5)
            r16 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r16)
            r3.invoke(r5, r0, r6)
            r0.startReplaceableGroup(r2)
            r2 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.foundation.layout.ColumnScopeInstance r2 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r2 = (androidx.compose.foundation.layout.ColumnScope) r2
            int r2 = r37 >> 15
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r15.invoke(r0, r2)
            r2 = -792968906(0xffffffffd0bc4136, float:-2.52671222E10)
            r0.startReplaceableGroup(r2)
            java.util.List r2 = r31.getOptions()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0255:
            boolean r3 = r2.hasNext()
            java.lang.String r5 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            r6 = 1618982084(0x607fb4c4, float:7.370227E19)
            r10 = 1
            r9 = 8
            if (r3 == 0) goto L_0x0327
            java.lang.Object r3 = r2.next()
            r7 = r3
            java.lang.String r7 = (java.lang.String) r7
            boolean r3 = r14 instanceof io.intercom.android.sdk.survey.ui.models.Answer.MultipleAnswer
            if (r3 == 0) goto L_0x027a
            r3 = r14
            io.intercom.android.sdk.survey.ui.models.Answer$MultipleAnswer r3 = (io.intercom.android.sdk.survey.ui.models.Answer.MultipleAnswer) r3
            java.util.Set r3 = r3.getAnswers()
            boolean r3 = r3.contains(r7)
            goto L_0x027b
        L_0x027a:
            r3 = 0
        L_0x027b:
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            float r11 = (float) r9
            float r11 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r11)
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r8, r11)
            r11 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r8, r0, r11)
            r8 = -792968586(0xffffffffd0bc4276, float:-2.52677775E10)
            r0.startReplaceableGroup(r8)
            if (r3 == 0) goto L_0x029d
            long r8 = r34.m5274getButton0d7_KjU()
            long r8 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5398getAccessibleColorOnWhiteBackground8_81llA(r8)
            goto L_0x02a7
        L_0x029d:
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r8 = r8.getColors(r0, r9)
            long r8 = r8.m1218getSurface0d7_KjU()
        L_0x02a7:
            r17 = r8
            r0.endReplaceableGroup()
            long r8 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5397getAccessibleBorderColor8_81llA(r17)
            if (r3 == 0) goto L_0x02b4
            float r10 = (float) r13
            goto L_0x02b5
        L_0x02b4:
            float r10 = (float) r10
        L_0x02b5:
            float r10 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r10)
            androidx.compose.ui.text.font.FontWeight$Companion r11 = androidx.compose.ui.text.font.FontWeight.Companion
            if (r3 == 0) goto L_0x02c2
            androidx.compose.ui.text.font.FontWeight r11 = r11.getBold()
            goto L_0x02c6
        L_0x02c2:
            androidx.compose.ui.text.font.FontWeight r11 = r11.getNormal()
        L_0x02c6:
            r19 = r11
            r0.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            boolean r5 = r0.changed((java.lang.Object) r14)
            boolean r6 = r0.changed((java.lang.Object) r4)
            r5 = r5 | r6
            boolean r6 = r0.changed((java.lang.Object) r7)
            r5 = r5 | r6
            java.lang.Object r6 = r0.rememberedValue()
            if (r5 != 0) goto L_0x02ea
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x02f5
        L_0x02ea:
            io.intercom.android.sdk.survey.ui.questiontype.choice.MultipleChoiceQuestionKt$MultipleChoiceQuestion$1$1$1$1$1 r5 = new io.intercom.android.sdk.survey.ui.questiontype.choice.MultipleChoiceQuestionKt$MultipleChoiceQuestion$1$1$1$1$1
            r5.<init>(r14, r4, r7)
            r6 = r5
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.updateRememberedValue(r6)
        L_0x02f5:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r22 = 0
            r20 = 0
            r24 = 128(0x80, float:1.794E-43)
            r5 = r3
            r3 = r12
            r11 = r17
            r30 = r2
            r2 = 2
            r25 = 0
            r13 = r19
            r2 = r14
            r29 = r15
            r14 = r22
            r16 = r0
            r17 = r20
            r18 = r24
            io.intercom.android.sdk.survey.ui.questiontype.choice.ChoicePillKt.m5322ChoicePillUdaoDFU(r5, r6, r7, r8, r10, r11, r13, r14, r16, r17, r18)
            r14 = r2
            r12 = r3
            r15 = r29
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            r13 = 2
            r16 = 0
            r2 = r30
            goto L_0x0255
        L_0x0327:
            r3 = r12
            r2 = r14
            r29 = r15
            r25 = 0
            r0.endReplaceableGroup()
            r7 = -792967602(0xffffffffd0bc464e, float:-2.52697928E10)
            r0.startReplaceableGroup(r7)
            boolean r7 = r31.getIncludeOther()
            if (r7 == 0) goto L_0x043b
            boolean r7 = r2 instanceof io.intercom.android.sdk.survey.ui.models.Answer.MultipleAnswer
            if (r7 == 0) goto L_0x0351
            r14 = r2
            io.intercom.android.sdk.survey.ui.models.Answer$MultipleAnswer r14 = (io.intercom.android.sdk.survey.ui.models.Answer.MultipleAnswer) r14
            io.intercom.android.sdk.survey.ui.models.Answer$MultipleAnswer$OtherAnswer r8 = r14.getOtherAnswer()
            io.intercom.android.sdk.survey.ui.models.Answer$MultipleAnswer$OtherAnswer$NotSelected r11 = io.intercom.android.sdk.survey.ui.models.Answer.MultipleAnswer.OtherAnswer.NotSelected.INSTANCE
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r11)
            if (r8 != 0) goto L_0x0351
            r8 = 1
            goto L_0x0352
        L_0x0351:
            r8 = 0
        L_0x0352:
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            float r12 = (float) r9
            float r12 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r12)
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r11, r12)
            r12 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r11, r0, r12)
            r11 = -792966650(0xffffffffd0bc4a06, float:-2.52717425E10)
            r0.startReplaceableGroup(r11)
            if (r8 == 0) goto L_0x0374
            long r11 = r34.m5274getButton0d7_KjU()
            long r11 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5398getAccessibleColorOnWhiteBackground8_81llA(r11)
            goto L_0x037e
        L_0x0374:
            androidx.compose.material.MaterialTheme r11 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r11 = r11.getColors(r0, r9)
            long r11 = r11.m1218getSurface0d7_KjU()
        L_0x037e:
            r13 = r11
            r0.endReplaceableGroup()
            long r11 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5397getAccessibleBorderColor8_81llA(r13)
            if (r8 == 0) goto L_0x038b
            r15 = 2
            float r15 = (float) r15
            goto L_0x038c
        L_0x038b:
            float r15 = (float) r10
        L_0x038c:
            float r15 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r15)
            androidx.compose.ui.text.font.FontWeight$Companion r16 = androidx.compose.ui.text.font.FontWeight.Companion
            if (r8 == 0) goto L_0x0399
            androidx.compose.ui.text.font.FontWeight r16 = r16.getBold()
            goto L_0x039d
        L_0x0399:
            androidx.compose.ui.text.font.FontWeight r16 = r16.getNormal()
        L_0x039d:
            if (r7 == 0) goto L_0x03ab
            r7 = r2
            io.intercom.android.sdk.survey.ui.models.Answer$MultipleAnswer r7 = (io.intercom.android.sdk.survey.ui.models.Answer.MultipleAnswer) r7
            io.intercom.android.sdk.survey.ui.models.Answer$MultipleAnswer$OtherAnswer r7 = r7.getOtherAnswer()
            java.lang.String r7 = r7.toString()
            goto L_0x03ad
        L_0x03ab:
            java.lang.String r7 = ""
        L_0x03ad:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r8)
            r0.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            boolean r5 = r0.changed((java.lang.Object) r9)
            boolean r6 = r0.changed((java.lang.Object) r2)
            r5 = r5 | r6
            boolean r6 = r0.changed((java.lang.Object) r4)
            r5 = r5 | r6
            java.lang.Object r6 = r0.rememberedValue()
            if (r5 != 0) goto L_0x03d3
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x03de
        L_0x03d3:
            io.intercom.android.sdk.survey.ui.questiontype.choice.MultipleChoiceQuestionKt$MultipleChoiceQuestion$1$1$2$1 r5 = new io.intercom.android.sdk.survey.ui.questiontype.choice.MultipleChoiceQuestionKt$MultipleChoiceQuestion$1$1$2$1
            r5.<init>(r8, r2, r4)
            r6 = r5
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r0.updateRememberedValue(r6)
        L_0x03de:
            r0.endReplaceableGroup()
            r9 = r6
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            boolean r5 = r0.changed((java.lang.Object) r2)
            boolean r6 = r0.changed((java.lang.Object) r4)
            r5 = r5 | r6
            java.lang.Object r6 = r0.rememberedValue()
            if (r5 != 0) goto L_0x0406
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x0411
        L_0x0406:
            io.intercom.android.sdk.survey.ui.questiontype.choice.MultipleChoiceQuestionKt$MultipleChoiceQuestion$1$1$3$1 r5 = new io.intercom.android.sdk.survey.ui.questiontype.choice.MultipleChoiceQuestionKt$MultipleChoiceQuestion$1$1$3$1
            r5.<init>(r2, r4)
            r6 = r5
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.updateRememberedValue(r6)
        L_0x0411:
            r0.endReplaceableGroup()
            r17 = r6
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r18 = 0
            int r5 = r37 >> 9
            r20 = r5 & 112(0x70, float:1.57E-43)
            r22 = 512(0x200, float:7.175E-43)
            r5 = r8
            r6 = r34
            r8 = r9
            r32 = r2
            r2 = 8
            r9 = r17
            r2 = 1
            r10 = r11
            r12 = r15
            r15 = r16
            r16 = r18
            r18 = r0
            r19 = r20
            r20 = r22
            io.intercom.android.sdk.survey.ui.questiontype.choice.OtherOptionKt.m5332OtherOptionYCJL08c(r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r18, r19, r20)
            goto L_0x043e
        L_0x043b:
            r32 = r2
            r2 = 1
        L_0x043e:
            r0.endReplaceableGroup()
            r5 = -792965350(0xffffffffd0bc4f1a, float:-2.52744049E10)
            r0.startReplaceableGroup(r5)
            int r5 = r31.getMinSelection()
            if (r5 <= r2) goto L_0x04c8
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r5, r3)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.content.Context r2 = (android.content.Context) r2
            int r3 = io.intercom.android.sdk.R.string.intercom_surveys_multi_select_too_few_responses
            io.intercom.android.sdk.utilities.Phrase r2 = io.intercom.android.sdk.utilities.Phrase.from((android.content.Context) r2, (int) r3)
            int r3 = r31.getMinSelection()
            java.lang.String r5 = "response_count"
            r2.put((java.lang.String) r5, (int) r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r5 = r3
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r6 = 0
            r3 = 8
            float r7 = (float) r3
            float r7 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            r8 = 0
            r9 = 0
            r10 = 13
            r11 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r5, r6, r7, r8, r9, r10, r11)
            java.lang.CharSequence r2 = r2.format()
            java.lang.String r5 = r2.toString()
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 8
            androidx.compose.material.Typography r2 = r2.getTypography(r0, r3)
            androidx.compose.ui.text.TextStyle r24 = r2.getCaption()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r2.m1962getGray0d7_KjU()
            long r9 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r21)
            androidx.compose.ui.text.font.FontWeight$Companion r2 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r12 = r2.getNormal()
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 200112(0x30db0, float:2.80417E-40)
            r27 = 0
            r28 = 32720(0x7fd0, float:4.585E-41)
            r25 = r0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r5, r6, r7, r9, r11, r12, r13, r14, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28)
        L_0x04c8:
            r0.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 8
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r2, r3)
            r3 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r2, r0, r3)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x04ed:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x0503
            goto L_0x051d
        L_0x0503:
            io.intercom.android.sdk.survey.ui.questiontype.choice.MultipleChoiceQuestionKt$MultipleChoiceQuestion$2 r10 = new io.intercom.android.sdk.survey.ui.questiontype.choice.MultipleChoiceQuestionKt$MultipleChoiceQuestion$2
            r0 = r10
            r5 = r32
            r2 = r31
            r3 = r5
            r4 = r33
            r5 = r34
            r6 = r29
            r7 = r37
            r8 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x051d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.choice.MultipleChoiceQuestionKt.MultipleChoiceQuestion(androidx.compose.ui.Modifier, io.intercom.android.sdk.survey.model.SurveyData$Step$Question$MultipleChoiceQuestionModel, io.intercom.android.sdk.survey.ui.models.Answer, kotlin.jvm.functions.Function1, io.intercom.android.sdk.survey.SurveyUiColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: MultipleChoiceQuestion$lambda-5$lambda-4$switchOtherAnswer  reason: not valid java name */
    public static final void m5330MultipleChoiceQuestion$lambda5$lambda4$switchOtherAnswer(Answer answer, Function1<? super Answer, Unit> function1, Answer.MultipleAnswer.OtherAnswer otherAnswer) {
        if (answer instanceof Answer.MultipleAnswer) {
            function1.invoke(((Answer.MultipleAnswer) answer).copyWithOther(otherAnswer));
        } else {
            function1.invoke(new Answer.MultipleAnswer(SetsKt.emptySet(), otherAnswer));
        }
    }

    public static final void MultipleChoiceQuestionPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1537454351);
        ComposerKt.sourceInformation(startRestartGroup, "C(MultipleChoiceQuestionPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            PreviewQuestion(SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)), startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MultipleChoiceQuestionKt$MultipleChoiceQuestionPreview$1(i));
        }
    }

    public static final void MultipleChoiceQuestionPreviewDark(Composer composer, int i) {
        int i2 = i;
        Composer startRestartGroup = composer.startRestartGroup(756027931);
        ComposerKt.sourceInformation(startRestartGroup, "C(MultipleChoiceQuestionPreviewDark)");
        if (i2 != 0 || !startRestartGroup.getSkipping()) {
            PreviewQuestion(SurveyUiColors.m5266copyqa9m3tE$default(SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)), 0, 0, Color.Companion.m1959getBlue0d7_KjU(), 0, (Color) null, 27, (Object) null), startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MultipleChoiceQuestionKt$MultipleChoiceQuestionPreviewDark$1(i2));
        }
    }

    public static final void PreviewQuestion(SurveyUiColors surveyUiColors, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(surveyUiColors, "surveyUiColors");
        Composer startRestartGroup = composer.startRestartGroup(-1753720526);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) surveyUiColors) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableLambdaKt.composableLambda(startRestartGroup, -958673708, true, new MultipleChoiceQuestionKt$PreviewQuestion$1(surveyUiColors, i2)), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MultipleChoiceQuestionKt$PreviewQuestion$2(surveyUiColors, i));
        }
    }
}
