package io.intercom.android.sdk.survey.ui.questiontype.choice;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import com.facebook.internal.ServerProtocol;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.survey.SurveyUiColors;
import io.intercom.android.sdk.survey.SurveyViewModelKt;
import io.intercom.android.sdk.survey.model.SurveyCustomization;
import io.intercom.android.sdk.survey.ui.ThemeKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\u001aZ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0013\b\u0002\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0014\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0000¨\u0006\u0019"}, d2 = {"SingleChoiceQuestion", "", "modifier", "Landroidx/compose/ui/Modifier;", "singleChoiceQuestionModel", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$SingleChoiceQuestionModel;", "answer", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "onAnswer", "Lkotlin/Function1;", "colors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "questionHeader", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$SingleChoiceQuestionModel;Lio/intercom/android/sdk/survey/ui/models/Answer;Lkotlin/jvm/functions/Function1;Lio/intercom/android/sdk/survey/SurveyUiColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SingleChoiceQuestionPreview", "surveyUiColors", "(Lio/intercom/android/sdk/survey/SurveyUiColors;Landroidx/compose/runtime/Composer;I)V", "SingleChoiceQuestionPreviewDark", "(Landroidx/compose/runtime/Composer;I)V", "SingleChoiceQuestionPreviewLight", "booleanToQuestion", "", "", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SingleChoiceQuestion.kt */
public final class SingleChoiceQuestionKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0487  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SingleChoiceQuestion(androidx.compose.ui.Modifier r29, io.intercom.android.sdk.survey.model.SurveyData.Step.Question.SingleChoiceQuestionModel r30, io.intercom.android.sdk.survey.ui.models.Answer r31, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.survey.ui.models.Answer, kotlin.Unit> r32, io.intercom.android.sdk.survey.SurveyUiColors r33, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r4 = r32
            java.lang.String r0 = "singleChoiceQuestionModel"
            r2 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onAnswer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "colors"
            r3 = r33
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = -719720125(0xffffffffd519f143, float:-1.05788431E13)
            r1 = r35
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r37 & 1
            if (r1 == 0) goto L_0x0027
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0029
        L_0x0027:
            r1 = r29
        L_0x0029:
            r5 = r37 & 4
            if (r5 == 0) goto L_0x0033
            io.intercom.android.sdk.survey.ui.models.Answer$NoAnswer$InitialNoAnswer r5 = io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer.InitialNoAnswer.INSTANCE
            io.intercom.android.sdk.survey.ui.models.Answer r5 = (io.intercom.android.sdk.survey.ui.models.Answer) r5
            r14 = r5
            goto L_0x0035
        L_0x0033:
            r14 = r31
        L_0x0035:
            r5 = r37 & 32
            if (r5 == 0) goto L_0x0041
            io.intercom.android.sdk.survey.ui.questiontype.choice.ComposableSingletons$SingleChoiceQuestionKt r5 = io.intercom.android.sdk.survey.ui.questiontype.choice.ComposableSingletons$SingleChoiceQuestionKt.INSTANCE
            kotlin.jvm.functions.Function2 r5 = r5.m5329getLambda1$intercom_sdk_base_release()
            r15 = r5
            goto L_0x0043
        L_0x0041:
            r15 = r34
        L_0x0043:
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r7)
            java.lang.Object r5 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            r13 = r5
            androidx.compose.ui.focus.FocusManager r13 = (androidx.compose.ui.focus.FocusManager) r13
            r5 = r36 & 14
            r8 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getTopStart()
            int r9 = r5 >> 3
            r10 = r9 & 14
            r9 = r9 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            r11 = 0
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r8, r11, r0, r9)
            int r9 = r5 << 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r10)
            java.lang.String r12 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r10 = r16
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r7)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r11 = r16
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r7)
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r7)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            int r9 = r9 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r35 = r1
            r1 = 6
            r9 = r9 | r1
            androidx.compose.runtime.Applier r1 = r0.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x00e2
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00e2:
            r0.startReusableNode()
            boolean r1 = r0.getInserting()
            if (r1 == 0) goto L_0x00ef
            r0.createNode(r6)
            goto L_0x00f2
        L_0x00ef:
            r0.useNode()
        L_0x00f2:
            r0.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r8, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r10, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r11, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r2, r6)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            int r2 = r9 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3.invoke(r1, r0, r2)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            int r2 = r9 >> 9
            r2 = r2 & 14
            r3 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r2 = r2 & 11
            r3 = 2
            if (r2 != r3) goto L_0x015c
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x0154
            goto L_0x015c
        L_0x0154:
            r0.skipToGroupEnd()
        L_0x0157:
            r3 = r14
            r26 = r15
            goto L_0x0471
        L_0x015c:
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r6 = 6
            int r5 = r5 >> r6
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r2 = r5 & 81
            r5 = 16
            if (r2 != r5) goto L_0x0176
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x0172
            goto L_0x0176
        L_0x0172:
            r0.skipToGroupEnd()
            goto L_0x0157
        L_0x0176:
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            java.lang.Object r2 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r2 != r5) goto L_0x019a
            r5 = 0
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r5)
            r5 = 0
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r5, r3, r5)
            r0.updateRememberedValue(r2)
        L_0x019a:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r2 = (androidx.compose.runtime.MutableState) r2
            r5 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r6 = r6.getTop()
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r8 = r8.getStart()
            r9 = 0
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r6, r8, r0, r9)
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r7)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r7)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r7)
            java.lang.Object r7 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            androidx.compose.runtime.Applier r11 = r0.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0216
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0216:
            r0.startReusableNode()
            boolean r11 = r0.getInserting()
            if (r11 == 0) goto L_0x0223
            r0.createNode(r9)
            goto L_0x0226
        L_0x0223:
            r0.useNode()
        L_0x0226:
            r0.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r6, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r8, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r10, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r7, r6)
            r0.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r6)
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r5.invoke(r6, r0, r8)
            r0.startReplaceableGroup(r1)
            r1 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r1 = (androidx.compose.foundation.layout.ColumnScope) r1
            int r1 = r36 >> 15
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r15.invoke(r0, r1)
            r1 = 1275695718(0x4c099266, float:3.606364E7)
            r0.startReplaceableGroup(r1)
            java.util.List r1 = r30.getOptions()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0291:
            boolean r5 = r1.hasNext()
            r6 = 1
            r7 = 8
            if (r5 == 0) goto L_0x037c
            java.lang.Object r5 = r1.next()
            java.lang.String r5 = (java.lang.String) r5
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            float r9 = (float) r7
            float r9 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r9)
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r8, r9)
            r9 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r8, r0, r9)
            boolean r8 = r14 instanceof io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer
            if (r8 == 0) goto L_0x02c4
            r8 = r14
            io.intercom.android.sdk.survey.ui.models.Answer$SingleAnswer r8 = (io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer) r8
            java.lang.String r8 = r8.getAnswer()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r5)
            if (r8 == 0) goto L_0x02c4
            r8 = 1
            goto L_0x02c5
        L_0x02c4:
            r8 = 0
        L_0x02c5:
            r9 = 1275695951(0x4c09934f, float:3.6064572E7)
            r0.startReplaceableGroup(r9)
            if (r8 == 0) goto L_0x02d6
            long r9 = r33.m5274getButton0d7_KjU()
            long r9 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5398getAccessibleColorOnWhiteBackground8_81llA(r9)
            goto L_0x02e0
        L_0x02d6:
            androidx.compose.material.MaterialTheme r9 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r9 = r9.getColors(r0, r7)
            long r9 = r9.m1218getSurface0d7_KjU()
        L_0x02e0:
            r11 = r9
            r0.endReplaceableGroup()
            androidx.compose.material.MaterialTheme r9 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r9 = r9.getColors(r0, r7)
            long r20 = r9.m1213getOnSurface0d7_KjU()
            r22 = 1036831949(0x3dcccccd, float:0.1)
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 14
            r27 = 0
            long r9 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r20, r22, r23, r24, r25, r26, r27)
            float r6 = (float) r6
            float r16 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.text.font.FontWeight$Companion r6 = androidx.compose.ui.text.font.FontWeight.Companion
            if (r8 == 0) goto L_0x030d
            androidx.compose.ui.text.font.FontWeight r6 = r6.getBold()
            goto L_0x0311
        L_0x030d:
            androidx.compose.ui.text.font.FontWeight r6 = r6.getNormal()
        L_0x0311:
            r17 = r6
            long r20 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5396generateTextColor8_81llA(r11)
            if (r8 == 0) goto L_0x0326
            r6 = 1240428574(0x49ef701e, float:1961475.8)
            r0.startReplaceableGroup(r6)
            androidx.compose.material.ContentAlpha r6 = androidx.compose.material.ContentAlpha.INSTANCE
            float r6 = r6.getHigh(r0, r7)
            goto L_0x0332
        L_0x0326:
            r6 = 1240428597(0x49ef7035, float:1961478.6)
            r0.startReplaceableGroup(r6)
            androidx.compose.material.ContentAlpha r6 = androidx.compose.material.ContentAlpha.INSTANCE
            float r6 = r6.getMedium(r0, r7)
        L_0x0332:
            r0.endReplaceableGroup()
            r22 = r6
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 14
            r27 = 0
            long r20 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r20, r22, r23, r24, r25, r26, r27)
            int r6 = booleanToQuestion(r5)
            r7 = 0
            java.lang.String r18 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r6, r0, r7)
            io.intercom.android.sdk.survey.ui.questiontype.choice.SingleChoiceQuestionKt$SingleChoiceQuestion$1$1$1$1 r6 = new io.intercom.android.sdk.survey.ui.questiontype.choice.SingleChoiceQuestionKt$SingleChoiceQuestion$1$1$1$1
            r6.<init>(r13, r2, r4, r5)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r22 = 24576(0x6000, float:3.4438E-41)
            r23 = 0
            r5 = r8
            r24 = 0
            r7 = r18
            r8 = r9
            r10 = r16
            r25 = r13
            r13 = r17
            r28 = r14
            r26 = r15
            r14 = r20
            r16 = r0
            r17 = r22
            r18 = r23
            io.intercom.android.sdk.survey.ui.questiontype.choice.ChoicePillKt.m5322ChoicePillUdaoDFU(r5, r6, r7, r8, r10, r11, r13, r14, r16, r17, r18)
            r13 = r25
            r15 = r26
            r14 = r28
            goto L_0x0291
        L_0x037c:
            r28 = r14
            r26 = r15
            r0.endReplaceableGroup()
            boolean r1 = r30.getIncludeOther()
            if (r1 == 0) goto L_0x0460
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r5 = (float) r7
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r5)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r1, r5)
            r5 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r0, r5)
            java.lang.Object r1 = r2.getValue()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r5 = r1.booleanValue()
            r1 = 1275697306(0x4c09989a, float:3.6069992E7)
            r0.startReplaceableGroup(r1)
            if (r5 == 0) goto L_0x03b5
            long r7 = r33.m5274getButton0d7_KjU()
            long r7 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5398getAccessibleColorOnWhiteBackground8_81llA(r7)
            goto L_0x03bf
        L_0x03b5:
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r7)
            long r7 = r1.m1218getSurface0d7_KjU()
        L_0x03bf:
            r13 = r7
            r0.endReplaceableGroup()
            long r10 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5397getAccessibleBorderColor8_81llA(r13)
            if (r5 == 0) goto L_0x03cb
            float r1 = (float) r3
            goto L_0x03cc
        L_0x03cb:
            float r1 = (float) r6
        L_0x03cc:
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r1)
            r12 = r1
            androidx.compose.ui.text.font.FontWeight$Companion r1 = androidx.compose.ui.text.font.FontWeight.Companion
            if (r5 == 0) goto L_0x03da
            androidx.compose.ui.text.font.FontWeight r1 = r1.getBold()
            goto L_0x03de
        L_0x03da:
            androidx.compose.ui.text.font.FontWeight r1 = r1.getNormal()
        L_0x03de:
            r15 = r1
            r3 = r28
            boolean r1 = r3 instanceof io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer
            if (r1 == 0) goto L_0x03ed
            r1 = r3
            io.intercom.android.sdk.survey.ui.models.Answer$SingleAnswer r1 = (io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer) r1
            java.lang.String r1 = r1.getAnswer()
            goto L_0x03ef
        L_0x03ed:
            java.lang.String r1 = ""
        L_0x03ef:
            r7 = r1
            int r1 = r36 >> 9
            r6 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            boolean r6 = r0.changed((java.lang.Object) r4)
            boolean r8 = r0.changed((java.lang.Object) r2)
            r6 = r6 | r8
            java.lang.Object r8 = r0.rememberedValue()
            if (r6 != 0) goto L_0x0414
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r8 != r6) goto L_0x041f
        L_0x0414:
            io.intercom.android.sdk.survey.ui.questiontype.choice.SingleChoiceQuestionKt$SingleChoiceQuestion$1$1$2$1 r6 = new io.intercom.android.sdk.survey.ui.questiontype.choice.SingleChoiceQuestionKt$SingleChoiceQuestion$1$1$2$1
            r6.<init>(r4, r2)
            r8 = r6
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r0.updateRememberedValue(r8)
        L_0x041f:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r2 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            boolean r2 = r0.changed((java.lang.Object) r4)
            java.lang.Object r6 = r0.rememberedValue()
            if (r2 != 0) goto L_0x0441
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r6 != r2) goto L_0x044c
        L_0x0441:
            io.intercom.android.sdk.survey.ui.questiontype.choice.SingleChoiceQuestionKt$SingleChoiceQuestion$1$1$3$1 r2 = new io.intercom.android.sdk.survey.ui.questiontype.choice.SingleChoiceQuestionKt$SingleChoiceQuestion$1$1$3$1
            r2.<init>(r4)
            r6 = r2
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.updateRememberedValue(r6)
        L_0x044c:
            r0.endReplaceableGroup()
            r9 = r6
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r16 = 0
            r19 = r1 & 112(0x70, float:1.57E-43)
            r20 = 512(0x200, float:7.175E-43)
            r6 = r33
            r18 = r0
            io.intercom.android.sdk.survey.ui.questiontype.choice.OtherOptionKt.m5332OtherOptionYCJL08c(r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r18, r19, r20)
            goto L_0x0462
        L_0x0460:
            r3 = r28
        L_0x0462:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x0471:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x0487
            goto L_0x04a0
        L_0x0487:
            io.intercom.android.sdk.survey.ui.questiontype.choice.SingleChoiceQuestionKt$SingleChoiceQuestion$2 r10 = new io.intercom.android.sdk.survey.ui.questiontype.choice.SingleChoiceQuestionKt$SingleChoiceQuestion$2
            r0 = r10
            r1 = r35
            r2 = r30
            r4 = r32
            r5 = r33
            r6 = r26
            r7 = r36
            r8 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x04a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.choice.SingleChoiceQuestionKt.SingleChoiceQuestion(androidx.compose.ui.Modifier, io.intercom.android.sdk.survey.model.SurveyData$Step$Question$SingleChoiceQuestionModel, io.intercom.android.sdk.survey.ui.models.Answer, kotlin.jvm.functions.Function1, io.intercom.android.sdk.survey.SurveyUiColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final int booleanToQuestion(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (Intrinsics.areEqual((Object) lowerCase, (Object) ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return R.string.intercom_attribute_collector_positive;
        }
        return R.string.intercom_attribute_collector_negative;
    }

    public static final void SingleChoiceQuestionPreviewLight(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1626655857);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            SingleChoiceQuestionPreview(SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)), startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SingleChoiceQuestionKt$SingleChoiceQuestionPreviewLight$1(i));
        }
    }

    public static final void SingleChoiceQuestionPreviewDark(Composer composer, int i) {
        int i2 = i;
        Composer startRestartGroup = composer.startRestartGroup(567326043);
        if (i2 != 0 || !startRestartGroup.getSkipping()) {
            SingleChoiceQuestionPreview(SurveyUiColors.m5266copyqa9m3tE$default(SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)), 0, 0, Color.Companion.m1959getBlue0d7_KjU(), 0, (Color) null, 27, (Object) null), startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SingleChoiceQuestionKt$SingleChoiceQuestionPreviewDark$1(i2));
        }
    }

    public static final void SingleChoiceQuestionPreview(SurveyUiColors surveyUiColors, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(surveyUiColors, "surveyUiColors");
        Composer startRestartGroup = composer.startRestartGroup(1547860655);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) surveyUiColors) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableLambdaKt.composableLambda(startRestartGroup, -521450543, true, new SingleChoiceQuestionKt$SingleChoiceQuestionPreview$1(surveyUiColors, i2)), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SingleChoiceQuestionKt$SingleChoiceQuestionPreview$2(surveyUiColors, i));
        }
    }
}
