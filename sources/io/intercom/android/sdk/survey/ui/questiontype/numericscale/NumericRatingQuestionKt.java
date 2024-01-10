package io.intercom.android.sdk.survey.ui.questiontype.numericscale;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.exifinterface.media.ExifInterface;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.ThemeKt;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a-\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001aZ\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0013\b\u0002\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0018H\u0001¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u001b"}, d2 = {"EmojiRatingQuestionPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "GeneratePreview", "start", "", "end", "questionSubType", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionData$QuestionSubType;", "answer", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "(IILio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionData$QuestionSubType;Lio/intercom/android/sdk/survey/ui/models/Answer;Landroidx/compose/runtime/Composer;I)V", "NPSQuestionPreview", "NumericRatingQuestion", "modifier", "Landroidx/compose/ui/Modifier;", "numericRatingQuestionModel", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$NumericRatingQuestionModel;", "onAnswer", "Lkotlin/Function1;", "colors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "questionHeader", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$NumericRatingQuestionModel;Lio/intercom/android/sdk/survey/ui/models/Answer;Lkotlin/jvm/functions/Function1;Lio/intercom/android/sdk/survey/SurveyUiColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "StarQuestionPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: NumericRatingQuestion.kt */
public final class NumericRatingQuestionKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NumericRatingQuestion.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyData.Step.Question.QuestionData.QuestionSubType.values().length];
            iArr[SurveyData.Step.Question.QuestionData.QuestionSubType.NPS.ordinal()] = 1;
            iArr[SurveyData.Step.Question.QuestionData.QuestionSubType.UNSUPPORTED.ordinal()] = 2;
            iArr[SurveyData.Step.Question.QuestionData.QuestionSubType.NUMERIC.ordinal()] = 3;
            iArr[SurveyData.Step.Question.QuestionData.QuestionSubType.STARS.ordinal()] = 4;
            iArr[SurveyData.Step.Question.QuestionData.QuestionSubType.EMOJI.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v17, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v18, resolved type: kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0961  */
    /* JADX WARNING: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NumericRatingQuestion(androidx.compose.ui.Modifier r61, io.intercom.android.sdk.survey.model.SurveyData.Step.Question.NumericRatingQuestionModel r62, io.intercom.android.sdk.survey.ui.models.Answer r63, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.survey.ui.models.Answer, kotlin.Unit> r64, io.intercom.android.sdk.survey.SurveyUiColors r65, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r66, androidx.compose.runtime.Composer r67, int r68, int r69) {
        /*
            r4 = r64
            java.lang.String r0 = "numericRatingQuestionModel"
            r2 = r62
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onAnswer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "colors"
            r5 = r65
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = -452111568(0xffffffffe50d5330, float:-4.1711763E22)
            r1 = r67
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r69 & 1
            if (r1 == 0) goto L_0x0027
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0029
        L_0x0027:
            r1 = r61
        L_0x0029:
            r3 = r69 & 4
            if (r3 == 0) goto L_0x0032
            io.intercom.android.sdk.survey.ui.models.Answer$NoAnswer$InitialNoAnswer r3 = io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer.InitialNoAnswer.INSTANCE
            io.intercom.android.sdk.survey.ui.models.Answer r3 = (io.intercom.android.sdk.survey.ui.models.Answer) r3
            goto L_0x0034
        L_0x0032:
            r3 = r63
        L_0x0034:
            r6 = r69 & 32
            if (r6 == 0) goto L_0x0040
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.ComposableSingletons$NumericRatingQuestionKt r6 = io.intercom.android.sdk.survey.ui.questiontype.numericscale.ComposableSingletons$NumericRatingQuestionKt.INSTANCE
            kotlin.jvm.functions.Function2 r6 = r6.m5340getLambda1$intercom_sdk_base_release()
            r15 = r6
            goto L_0x0042
        L_0x0040:
            r15 = r66
        L_0x0042:
            r6 = r68 & 14
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopStart()
            int r8 = r6 >> 3
            r9 = r8 & 14
            r8 = r8 & 112(0x70, float:1.57E-43)
            r8 = r8 | r9
            r14 = 0
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r14, r0, r8)
            int r8 = r6 << 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r13)
            java.lang.String r12 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r11 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r11)
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r13 = r16
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r11)
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r13 = (androidx.compose.ui.unit.LayoutDirection) r13
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r14 = r16
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r11)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r14 = (androidx.compose.ui.platform.ViewConfiguration) r14
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            int r8 = r8 << 9
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r5 = 6
            r8 = r8 | r5
            androidx.compose.runtime.Applier r5 = r0.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x00ca
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00ca:
            r0.startReusableNode()
            boolean r5 = r0.getInserting()
            if (r5 == 0) goto L_0x00d7
            r0.createNode(r10)
            goto L_0x00da
        L_0x00d7:
            r0.useNode()
        L_0x00da:
            r0.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r7, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r9, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r13, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r14, r7)
            r0.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r5)
            int r7 = r8 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r2.invoke(r5, r0, r7)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            int r5 = r8 >> 9
            r5 = r5 & 14
            r7 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            r5 = r5 & 11
            r14 = 2
            if (r5 != r14) goto L_0x0143
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x013c
            goto L_0x0143
        L_0x013c:
            r0.skipToGroupEnd()
        L_0x013f:
            r54 = r15
            goto L_0x094b
        L_0x0143:
            androidx.compose.foundation.layout.BoxScopeInstance r5 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r7 = 6
            int r6 = r6 >> r7
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            androidx.compose.foundation.layout.BoxScope r5 = (androidx.compose.foundation.layout.BoxScope) r5
            r5 = r6 & 81
            r6 = 16
            if (r5 != r6) goto L_0x015d
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x0159
            goto L_0x015d
        L_0x0159:
            r0.skipToGroupEnd()
            goto L_0x013f
        L_0x015d:
            r5 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r7 = r7.getTop()
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r8 = r8.getStart()
            r9 = 0
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r7, r8, r0, r9)
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r11)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r11)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r11)
            java.lang.Object r9 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            androidx.compose.runtime.Applier r14 = r0.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x01d4
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01d4:
            r0.startReusableNode()
            boolean r14 = r0.getInserting()
            if (r14 == 0) goto L_0x01e1
            r0.createNode(r13)
            goto L_0x01e4
        L_0x01e1:
            r0.useNode()
        L_0x01e4:
            r0.disableReusing()
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r7, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r8, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r10, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r9, r7)
            r0.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r7)
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r5.invoke(r7, r0, r9)
            r0.startReplaceableGroup(r2)
            r5 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            androidx.compose.foundation.layout.ColumnScopeInstance r5 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r5 = (androidx.compose.foundation.layout.ColumnScope) r5
            int r5 = r68 >> 15
            r5 = r5 & 14
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r15.invoke(r0, r5)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r5, r6)
            r6 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r5, r0, r6)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionData$QuestionSubType r5 = r62.getQuestionSubType()
            int[] r6 = io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingQuestionKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r6[r5]
            java.lang.String r14 = "C80@4021L9:Row.kt#2w3rfo"
            java.lang.String r10 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            r7 = 0
            r8 = 0
            r6 = 4
            r17 = r15
            r15 = 8
            r13 = 1
            if (r5 == r13) goto L_0x04e3
            r2 = 2
            if (r5 == r2) goto L_0x04e3
            r2 = 3
            if (r5 == r2) goto L_0x04e3
            if (r5 == r6) goto L_0x02d5
            r2 = 5
            if (r5 == r2) goto L_0x028e
            r2 = 1108510226(0x42128612, float:36.630928)
            r0.startReplaceableGroup(r2)
            r0.endReplaceableGroup()
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0280:
            r2 = r10
            r60 = r11
            r58 = r12
            r59 = r14
            r54 = r17
            r66 = 0
        L_0x028b:
            r5 = 0
            goto L_0x0763
        L_0x028e:
            r2 = 1108509949(0x421284fd, float:36.62987)
            r0.startReplaceableGroup(r2)
            java.util.List r2 = r62.getOptions()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r6)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r2 = r2.iterator()
        L_0x02ab:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x02c2
            java.lang.Object r6 = r2.next()
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption r6 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption) r6
            java.lang.String r9 = "null cannot be cast to non-null type io.intercom.android.sdk.survey.model.SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r9)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption$EmojiRatingOption r6 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption) r6
            r5.add(r6)
            goto L_0x02ab
        L_0x02c2:
            java.util.List r5 = (java.util.List) r5
            int r2 = r68 >> 3
            r6 = r2 & 112(0x70, float:1.57E-43)
            r6 = r6 | r15
            r2 = r2 & 896(0x380, float:1.256E-42)
            r2 = r2 | r6
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.EmojiQuestionKt.EmojiQuestion(r5, r3, r4, r0, r2)
            r0.endReplaceableGroup()
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x0280
        L_0x02d5:
            r2 = 1108508228(0x42127e44, float:36.623306)
            r0.startReplaceableGroup(r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r2, r8, r13, r7)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r5 = r5.getCenter()
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r5
            r9 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r10)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r6 = r6.getTop()
            r7 = 6
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r6, r0, r7)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r11)
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r21 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r7 = r21
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r11)
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r21 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r8 = r21
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r11)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r21 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r21.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r13 = r0.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x035a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x035a:
            r0.startReusableNode()
            boolean r13 = r0.getInserting()
            if (r13 == 0) goto L_0x0367
            r0.createNode(r9)
            goto L_0x036a
        L_0x0367:
            r0.useNode()
        L_0x036a:
            r0.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r5, r13)
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
            r24 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r24)
            r2.invoke(r5, r0, r6)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r2 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            androidx.compose.foundation.layout.RowScopeInstance r5 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r5 = (androidx.compose.foundation.layout.RowScope) r5
            java.util.List r5 = r62.getOptions()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x03c6:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x04bb
            java.lang.Object r6 = r5.next()
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption r6 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption) r6
            java.lang.String r7 = "null cannot be cast to non-null type io.intercom.android.sdk.survey.model.SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.NumericRatingOption"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption$NumericRatingOption r6 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.NumericRatingOption) r6
            boolean r7 = r3 instanceof io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer
            if (r7 == 0) goto L_0x03f0
            int r7 = r6.getValue()
            r8 = r3
            io.intercom.android.sdk.survey.ui.models.Answer$SingleAnswer r8 = (io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer) r8
            java.lang.String r8 = r8.getAnswer()
            int r8 = java.lang.Integer.parseInt(r8)
            if (r7 > r8) goto L_0x03f0
            r9 = 1
            goto L_0x03f1
        L_0x03f0:
            r9 = 0
        L_0x03f1:
            r7 = -738585541(0xffffffffd3fa143b, float:-2.14816247E12)
            r0.startReplaceableGroup(r7)
            if (r9 == 0) goto L_0x0402
            long r7 = r65.m5274getButton0d7_KjU()
            long r7 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5398getAccessibleColorOnWhiteBackground8_81llA(r7)
            goto L_0x040c
        L_0x0402:
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r7 = r7.getColors(r0, r15)
            long r7 = r7.m1218getSurface0d7_KjU()
        L_0x040c:
            r0.endReplaceableGroup()
            long r25 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5397getAccessibleBorderColor8_81llA(r7)
            if (r9 == 0) goto L_0x041e
            r13 = 2
            float r9 = (float) r13
            float r9 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r9)
            r2 = r9
            r9 = 1
            goto L_0x0425
        L_0x041e:
            r9 = 1
            r13 = 2
            float r2 = (float) r9
            float r2 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r2)
        L_0x0425:
            androidx.compose.ui.Modifier$Companion r16 = androidx.compose.ui.Modifier.Companion
            r9 = r16
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r13 = 44
            float r13 = (float) r13
            float r15 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r13)
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r9, r15)
            float r13 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r13)
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r9, r13)
            r13 = 8
            float r15 = (float) r13
            float r13 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r15)
            androidx.compose.ui.Modifier r27 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r9, r13)
            r28 = 0
            r29 = 0
            r30 = 0
            r9 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r9)
            java.lang.String r9 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            boolean r9 = r0.changed((java.lang.Object) r6)
            boolean r13 = r0.changed((java.lang.Object) r4)
            r9 = r9 | r13
            java.lang.Object r13 = r0.rememberedValue()
            if (r9 != 0) goto L_0x0471
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r13 != r9) goto L_0x047c
        L_0x0471:
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingQuestionKt$NumericRatingQuestion$1$1$2$1$1$1 r9 = new io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingQuestionKt$NumericRatingQuestion$1$1$2$1$1$1
            r9.<init>(r6, r4)
            r13 = r9
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r0.updateRememberedValue(r13)
        L_0x047c:
            r0.endReplaceableGroup()
            r31 = r13
            kotlin.jvm.functions.Function0 r31 = (kotlin.jvm.functions.Function0) r31
            r32 = 7
            r33 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r27, r28, r29, r30, r31, r32, r33)
            r13 = 0
            r15 = 0
            r9 = 0
            r20 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r22 = 1
            r9 = r2
            r2 = r10
            r55 = r11
            r10 = r25
            r56 = r12
            r12 = r0
            r61 = r5
            r5 = 1
            r16 = 2
            r57 = r14
            r66 = 0
            r14 = r15
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.StarRatingKt.m5342StarRatingtAjK0ZQ(r6, r7, r9, r10, r12, r13, r14)
            r5 = r61
            r10 = r2
            r11 = r55
            r12 = r56
            r14 = r57
            r2 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r15 = 8
            r24 = 0
            goto L_0x03c6
        L_0x04bb:
            r2 = r10
            r55 = r11
            r56 = r12
            r57 = r14
            r66 = 0
            r5 = 1
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r54 = r17
            r60 = r55
            r58 = r56
            r59 = r57
            goto L_0x028b
        L_0x04e3:
            r2 = r10
            r55 = r11
            r56 = r12
            r57 = r14
            r66 = 0
            r5 = 1
            r7 = 1108505808(0x421274d0, float:36.614075)
            r0.startReplaceableGroup(r7)
            java.util.List r7 = r62.getOptions()
            int r7 = r7.size()
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r14 = r55
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r14)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.content.res.Configuration r8 = (android.content.res.Configuration) r8
            int r8 = r8.screenWidthDp
            int r8 = r8 + -60
            int r8 = r8 / 60
            double r9 = (double) r7
            double r7 = (double) r8
            double r7 = r9 / r7
            double r7 = java.lang.Math.ceil(r7)
            int r7 = (int) r7
            double r7 = (double) r7
            double r9 = r9 / r7
            double r7 = java.lang.Math.ceil(r9)
            int r7 = (int) r7
            java.util.List r8 = r62.getOptions()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.List r7 = kotlin.collections.CollectionsKt.chunked(r8, r7)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r21 = r7.iterator()
        L_0x0538:
            boolean r7 = r21.hasNext()
            if (r7 == 0) goto L_0x0755
            java.lang.Object r7 = r21.next()
            java.util.List r7 = (java.util.List) r7
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            r11 = 0
            r13 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r8, r11, r5, r13)
            androidx.compose.foundation.layout.Arrangement$Absolute r9 = androidx.compose.foundation.layout.Arrangement.Absolute.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r9 = r9.getCenter()
            r12 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r10 = r10.getTop()
            r11 = 6
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r9, r10, r0, r11)
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r10)
            r11 = r56
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r14)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r12 = r16
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r14)
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r13 = r16
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r14)
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r13 = (androidx.compose.ui.platform.ViewConfiguration) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.materializerOf(r8)
            androidx.compose.runtime.Applier r6 = r0.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x05c2
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x05c2:
            r0.startReusableNode()
            boolean r6 = r0.getInserting()
            if (r6 == 0) goto L_0x05cf
            r0.createNode(r15)
            goto L_0x05d2
        L_0x05cf:
            r0.useNode()
        L_0x05d2:
            r0.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r9, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r10, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r12, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r13, r9)
            r0.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r6)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r66)
            r8.invoke(r6, r0, r9)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r6)
            r6 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r6)
            r15 = r57
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            androidx.compose.foundation.layout.RowScopeInstance r6 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r6 = (androidx.compose.foundation.layout.RowScope) r6
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r23 = r7.iterator()
        L_0x062a:
            boolean r6 = r23.hasNext()
            if (r6 == 0) goto L_0x072c
            java.lang.Object r6 = r23.next()
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption r6 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption) r6
            java.lang.String r7 = "null cannot be cast to non-null type io.intercom.android.sdk.survey.model.SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.NumericRatingOption"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption$NumericRatingOption r6 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.NumericRatingOption) r6
            boolean r7 = r3 instanceof io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer
            if (r7 == 0) goto L_0x0658
            r7 = r3
            io.intercom.android.sdk.survey.ui.models.Answer$SingleAnswer r7 = (io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer) r7
            java.lang.String r7 = r7.getAnswer()
            int r8 = r6.getValue()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x0658
            r7 = 1
            goto L_0x0659
        L_0x0658:
            r7 = 0
        L_0x0659:
            r8 = 8664798(0x8436de, float:1.2141968E-38)
            r0.startReplaceableGroup(r8)
            if (r7 == 0) goto L_0x066e
            long r8 = r65.m5274getButton0d7_KjU()
            long r8 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5398getAccessibleColorOnWhiteBackground8_81llA(r8)
            r24 = r8
            r13 = 8
            goto L_0x067c
        L_0x066e:
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            r13 = 8
            androidx.compose.material.Colors r8 = r8.getColors(r0, r13)
            long r8 = r8.m1218getSurface0d7_KjU()
            r24 = r8
        L_0x067c:
            r0.endReplaceableGroup()
            long r8 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5397getAccessibleBorderColor8_81llA(r24)
            if (r7 == 0) goto L_0x0688
            r12 = 2
            float r10 = (float) r12
            goto L_0x068a
        L_0x0688:
            r12 = 2
            float r10 = (float) r5
        L_0x068a:
            float r10 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r10)
            if (r7 == 0) goto L_0x0697
            androidx.compose.ui.text.font.FontWeight$Companion r7 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r7 = r7.getBold()
            goto L_0x069d
        L_0x0697:
            androidx.compose.ui.text.font.FontWeight$Companion r7 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r7 = r7.getNormal()
        L_0x069d:
            r16 = r7
            int r7 = r6.getValue()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            androidx.compose.ui.Modifier$Companion r18 = androidx.compose.ui.Modifier.Companion
            r12 = r18
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            r13 = 4
            float r5 = (float) r13
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r5)
            androidx.compose.ui.Modifier r26 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r12, r5)
            r27 = 0
            r28 = 0
            r29 = 0
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            boolean r5 = r0.changed((java.lang.Object) r4)
            boolean r12 = r0.changed((java.lang.Object) r6)
            r5 = r5 | r12
            java.lang.Object r12 = r0.rememberedValue()
            if (r5 != 0) goto L_0x06df
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r12 != r5) goto L_0x06ea
        L_0x06df:
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingQuestionKt$NumericRatingQuestion$1$1$1$1$1$1$1 r5 = new io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingQuestionKt$NumericRatingQuestion$1$1$1$1$1$1$1
            r5.<init>(r4, r6)
            r12 = r5
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r0.updateRememberedValue(r12)
        L_0x06ea:
            r0.endReplaceableGroup()
            r30 = r12
            kotlin.jvm.functions.Function0 r30 = (kotlin.jvm.functions.Function0) r30
            r31 = 7
            r32 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r26, r27, r28, r29, r30, r31, r32)
            r26 = 0
            r18 = 0
            r28 = 64
            r29 = 4
            r6 = r7
            r7 = r5
            r58 = r11
            r5 = 693286680(0x2952b718, float:4.6788176E-14)
            r13 = 0
            r11 = r24
            r5 = 0
            r24 = 8
            r13 = r16
            r60 = r14
            r59 = r15
            r54 = r17
            r14 = r26
            r16 = r0
            r17 = r18
            r18 = r28
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingCellKt.m5341NumericRatingCellchV7uOw(r6, r7, r8, r10, r11, r13, r14, r16, r17, r18)
            r17 = r54
            r11 = r58
            r15 = r59
            r14 = r60
            r5 = 1
            goto L_0x062a
        L_0x072c:
            r58 = r11
            r60 = r14
            r59 = r15
            r54 = r17
            r5 = 0
            r29 = 4
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r17 = r54
            r56 = r58
            r57 = r59
            r14 = r60
            r5 = 1
            r6 = 4
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            goto L_0x0538
        L_0x0755:
            r60 = r14
            r54 = r17
            r58 = r56
            r59 = r57
            r5 = 0
            r0.endReplaceableGroup()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L_0x0763:
            java.lang.String r6 = r62.getLowerLabel()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            r7 = 1
            r6 = r6 ^ r7
            java.lang.String r8 = r62.getUpperLabel()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = kotlin.text.StringsKt.isBlank(r8)
            r8 = r8 ^ r7
            r6 = r6 & r8
            if (r6 == 0) goto L_0x093c
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r8 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r6, r5, r7, r8)
            r6 = 8
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r5, r6)
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r6 = r6.getSpaceBetween()
            androidx.compose.foundation.layout.Arrangement$Horizontal r6 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r6
            r7 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r2 = r2.getTop()
            r7 = 6
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r6, r2, r0, r7)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r6)
            r6 = r58
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = r60
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r7)
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r7)
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r7)
            java.lang.Object r7 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            androidx.compose.runtime.Applier r10 = r0.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0808
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0808:
            r0.startReusableNode()
            boolean r10 = r0.getInserting()
            if (r10 == 0) goto L_0x0815
            r0.createNode(r8)
            goto L_0x0818
        L_0x0815:
            r0.useNode()
        L_0x0818:
            r0.disableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r2, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r6, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r9, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r7, r2)
            r0.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r2)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r66)
            r5.invoke(r2, r0, r6)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r2 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r2)
            r2 = r59
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.foundation.layout.RowScopeInstance r2 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r2 = (androidx.compose.foundation.layout.RowScope) r2
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionData$QuestionSubType r2 = r62.getQuestionSubType()
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionData$QuestionSubType r5 = io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionData.QuestionSubType.EMOJI
            if (r2 != r5) goto L_0x0889
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r5 = r62.getLowerLabel()
            r6 = 0
            r2[r6] = r5
            java.lang.String r5 = r62.getUpperLabel()
            r7 = 1
            r2[r7] = r5
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            r7 = 1
            goto L_0x08ce
        L_0x0889:
            r2 = 2
            r6 = 0
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r7 = r62.getScaleStart()
            r5.append(r7)
            java.lang.String r7 = " - "
            r5.append(r7)
            java.lang.String r7 = r62.getLowerLabel()
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            r2[r6] = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r7 = r62.getScaleEnd()
            r5.append(r7)
            java.lang.String r7 = " - "
            r5.append(r7)
            java.lang.String r7 = r62.getUpperLabel()
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            r7 = 1
            r2[r7] = r5
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
        L_0x08ce:
            java.lang.Object r5 = r2.get(r6)
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r2.get(r7)
            r30 = r2
            java.lang.String r30 = (java.lang.String) r30
            r7 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r29 = 65534(0xfffe, float:9.1833E-41)
            r26 = r0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r6, r7, r8, r10, r12, r13, r14, r15, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r31 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r51 = 0
            r52 = 0
            r53 = 65534(0xfffe, float:9.1833E-41)
            r50 = r0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r30, r31, r32, r34, r36, r37, r38, r39, r41, r42, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x093c:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x094b:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x0961
            goto L_0x0978
        L_0x0961:
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingQuestionKt$NumericRatingQuestion$2 r10 = new io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingQuestionKt$NumericRatingQuestion$2
            r0 = r10
            r2 = r62
            r4 = r64
            r5 = r65
            r6 = r54
            r7 = r68
            r8 = r69
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x0978:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingQuestionKt.NumericRatingQuestion(androidx.compose.ui.Modifier, io.intercom.android.sdk.survey.model.SurveyData$Step$Question$NumericRatingQuestionModel, io.intercom.android.sdk.survey.ui.models.Answer, kotlin.jvm.functions.Function1, io.intercom.android.sdk.survey.SurveyUiColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void NPSQuestionPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-752808306);
        ComposerKt.sourceInformation(startRestartGroup, "C(NPSQuestionPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            GeneratePreview(0, 10, SurveyData.Step.Question.QuestionData.QuestionSubType.NPS, new Answer.SingleAnswer("4"), startRestartGroup, 438);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NumericRatingQuestionKt$NPSQuestionPreview$1(i));
        }
    }

    public static final void StarQuestionPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1791167217);
        ComposerKt.sourceInformation(startRestartGroup, "C(StarQuestionPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            GeneratePreview(1, 5, SurveyData.Step.Question.QuestionData.QuestionSubType.STARS, new Answer.MultipleAnswer(SetsKt.setOf("1", ExifInterface.GPS_MEASUREMENT_2D), (Answer.MultipleAnswer.OtherAnswer) null, 2, (DefaultConstructorMarker) null), startRestartGroup, 4534);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NumericRatingQuestionKt$StarQuestionPreview$1(i));
        }
    }

    public static final void EmojiRatingQuestionPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1678291132);
        ComposerKt.sourceInformation(startRestartGroup, "C(EmojiRatingQuestionPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            GeneratePreview(1, 5, SurveyData.Step.Question.QuestionData.QuestionSubType.EMOJI, new Answer.SingleAnswer("4"), startRestartGroup, 438);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NumericRatingQuestionKt$EmojiRatingQuestionPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void GeneratePreview(int i, int i2, SurveyData.Step.Question.QuestionData.QuestionSubType questionSubType, Answer answer, Composer composer, int i3) {
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1397971036);
        if ((i3 & 14) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 112) == 0) {
            i4 |= startRestartGroup.changed(i2) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i4 |= startRestartGroup.changed((Object) questionSubType) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i4 |= startRestartGroup.changed((Object) answer) ? 2048 : 1024;
        }
        int i5 = i4;
        if ((i5 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableLambdaKt.composableLambda(startRestartGroup, 1017064770, true, new NumericRatingQuestionKt$GeneratePreview$1(questionSubType, i, i2, answer, i5)), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NumericRatingQuestionKt$GeneratePreview$2(i, i2, questionSubType, answer, i3));
        }
    }
}
