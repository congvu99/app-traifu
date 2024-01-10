package io.intercom.android.sdk.survey.ui.questiontype.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.ThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a}\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u00152\u0013\b\u0002\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0018H\u0001¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"ShortTextAnsweredPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "ShortTextDisabledPreview", "ShortTextPhoneNumberPreview", "ShortTextPreview", "ShortTextQuestion", "modifier", "Landroidx/compose/ui/Modifier;", "textQuestionModel", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$ShortTextQuestionModel;", "answer", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "onAnswer", "Lkotlin/Function1;", "colors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "validationError", "Lio/intercom/android/sdk/survey/ValidationError;", "onImeActionNext", "Landroidx/compose/foundation/text/KeyboardActionScope;", "Lkotlin/ExtensionFunctionType;", "questionHeader", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$ShortTextQuestionModel;Lio/intercom/android/sdk/survey/ui/models/Answer;Lkotlin/jvm/functions/Function1;Lio/intercom/android/sdk/survey/SurveyUiColors;Lio/intercom/android/sdk/survey/ValidationError;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ShortTextQuestion.kt */
public final class ShortTextQuestionKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ShortTextQuestion.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyData.Step.Question.QuestionValidation.ValidationType.values().length];
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.NUMBER.ordinal()] = 1;
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.EMAIL.ordinal()] = 2;
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.PHONE.ordinal()] = 3;
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.FLOAT.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x066f  */
    /* JADX WARNING: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ShortTextQuestion(androidx.compose.ui.Modifier r38, io.intercom.android.sdk.survey.model.SurveyData.Step.Question.ShortTextQuestionModel r39, io.intercom.android.sdk.survey.ui.models.Answer r40, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.survey.ui.models.Answer, kotlin.Unit> r41, io.intercom.android.sdk.survey.SurveyUiColors r42, io.intercom.android.sdk.survey.ValidationError r43, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.text.KeyboardActionScope, kotlin.Unit> r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, int r47, int r48) {
        /*
            r2 = r39
            r4 = r41
            r5 = r42
            r6 = r43
            r9 = r47
            r10 = r48
            java.lang.String r0 = "textQuestionModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onAnswer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "validationError"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = -350441423(0xffffffffeb1cb031, float:-1.8942447E26)
            r1 = r46
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r10 & 1
            if (r1 == 0) goto L_0x0033
            r8 = r9 | 6
            r11 = r8
            r8 = r38
            goto L_0x0047
        L_0x0033:
            r8 = r9 & 14
            if (r8 != 0) goto L_0x0044
            r8 = r38
            boolean r11 = r0.changed((java.lang.Object) r8)
            if (r11 == 0) goto L_0x0041
            r11 = 4
            goto L_0x0042
        L_0x0041:
            r11 = 2
        L_0x0042:
            r11 = r11 | r9
            goto L_0x0047
        L_0x0044:
            r8 = r38
            r11 = r9
        L_0x0047:
            r12 = r10 & 2
            if (r12 == 0) goto L_0x004e
            r11 = r11 | 48
            goto L_0x005e
        L_0x004e:
            r12 = r9 & 112(0x70, float:1.57E-43)
            if (r12 != 0) goto L_0x005e
            boolean r12 = r0.changed((java.lang.Object) r2)
            if (r12 == 0) goto L_0x005b
            r12 = 32
            goto L_0x005d
        L_0x005b:
            r12 = 16
        L_0x005d:
            r11 = r11 | r12
        L_0x005e:
            r12 = r10 & 4
            if (r12 == 0) goto L_0x0065
            r11 = r11 | 384(0x180, float:5.38E-43)
            goto L_0x0078
        L_0x0065:
            r13 = r9 & 896(0x380, float:1.256E-42)
            if (r13 != 0) goto L_0x0078
            r13 = r40
            boolean r14 = r0.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0074
            r14 = 256(0x100, float:3.59E-43)
            goto L_0x0076
        L_0x0074:
            r14 = 128(0x80, float:1.794E-43)
        L_0x0076:
            r11 = r11 | r14
            goto L_0x007a
        L_0x0078:
            r13 = r40
        L_0x007a:
            r14 = r10 & 8
            if (r14 == 0) goto L_0x0081
            r11 = r11 | 3072(0xc00, float:4.305E-42)
            goto L_0x0091
        L_0x0081:
            r14 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r14 != 0) goto L_0x0091
            boolean r14 = r0.changed((java.lang.Object) r4)
            if (r14 == 0) goto L_0x008e
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x0090
        L_0x008e:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x0090:
            r11 = r11 | r14
        L_0x0091:
            r14 = r10 & 16
            if (r14 == 0) goto L_0x0098
            r11 = r11 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00aa
        L_0x0098:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r9
            if (r14 != 0) goto L_0x00aa
            boolean r14 = r0.changed((java.lang.Object) r5)
            if (r14 == 0) goto L_0x00a7
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a9
        L_0x00a7:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a9:
            r11 = r11 | r14
        L_0x00aa:
            r14 = r10 & 32
            if (r14 == 0) goto L_0x00b2
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00b0:
            r11 = r11 | r14
            goto L_0x00c3
        L_0x00b2:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r9
            if (r14 != 0) goto L_0x00c3
            boolean r14 = r0.changed((java.lang.Object) r6)
            if (r14 == 0) goto L_0x00c0
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00c0:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b0
        L_0x00c3:
            r14 = r10 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00cd
            r11 = r11 | r15
            r15 = r44
            goto L_0x00e2
        L_0x00cd:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r9 & r16
            r15 = r44
            if (r16 != 0) goto L_0x00e2
            boolean r16 = r0.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00de
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e0
        L_0x00de:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e0:
            r11 = r11 | r16
        L_0x00e2:
            r7 = r10 & 128(0x80, float:1.794E-43)
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            if (r7 == 0) goto L_0x00ef
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r11 = r11 | r17
            r3 = r45
            goto L_0x0102
        L_0x00ef:
            r17 = r9 & r16
            r3 = r45
            if (r17 != 0) goto L_0x0102
            boolean r18 = r0.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x00fe
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0100
        L_0x00fe:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x0100:
            r11 = r11 | r18
        L_0x0102:
            r18 = 23967451(0x16db6db, float:4.3661218E-38)
            r2 = r11 & r18
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r2 != r3) goto L_0x011d
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x0113
            goto L_0x011d
        L_0x0113:
            r0.skipToGroupEnd()
            r1 = r8
            r3 = r13
            r7 = r15
            r8 = r45
            goto L_0x0668
        L_0x011d:
            if (r1 == 0) goto L_0x0124
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r8 = r1
        L_0x0124:
            if (r12 == 0) goto L_0x012b
            io.intercom.android.sdk.survey.ui.models.Answer$NoAnswer$InitialNoAnswer r1 = io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer.InitialNoAnswer.INSTANCE
            io.intercom.android.sdk.survey.ui.models.Answer r1 = (io.intercom.android.sdk.survey.ui.models.Answer) r1
            goto L_0x012c
        L_0x012b:
            r1 = r13
        L_0x012c:
            if (r14 == 0) goto L_0x0133
            io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt$ShortTextQuestion$1 r2 = io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt$ShortTextQuestion$1.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            goto L_0x0134
        L_0x0133:
            r2 = r15
        L_0x0134:
            if (r7 == 0) goto L_0x013d
            io.intercom.android.sdk.survey.ui.questiontype.text.ComposableSingletons$ShortTextQuestionKt r3 = io.intercom.android.sdk.survey.ui.questiontype.text.ComposableSingletons$ShortTextQuestionKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m5344getLambda1$intercom_sdk_base_release()
            goto L_0x013f
        L_0x013d:
            r3 = r45
        L_0x013f:
            r7 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r7)
            java.lang.String r12 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            java.lang.Object r13 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r13 != r14) goto L_0x015d
            androidx.compose.foundation.relocation.BringIntoViewRequester r13 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.BringIntoViewRequester()
            r0.updateRememberedValue(r13)
        L_0x015d:
            r0.endReplaceableGroup()
            androidx.compose.foundation.relocation.BringIntoViewRequester r13 = (androidx.compose.foundation.relocation.BringIntoViewRequester) r13
            r14 = 773894976(0x2e20b340, float:3.6538994E-11)
            r0.startReplaceableGroup(r14)
            java.lang.String r14 = "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            r0.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            java.lang.Object r7 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r7 != r12) goto L_0x0190
            kotlin.coroutines.EmptyCoroutineContext r7 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            kotlinx.coroutines.CoroutineScope r7 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r7, r0)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r12 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r12.<init>(r7)
            r0.updateRememberedValue(r12)
            r7 = r12
        L_0x0190:
            r0.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r7 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r7
            kotlinx.coroutines.CoroutineScope r7 = r7.getCoroutineScope()
            r0.endReplaceableGroup()
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.bringIntoViewRequester(r8, r13)
            io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt$ShortTextQuestion$2 r14 = new io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt$ShortTextQuestion$2
            r14.<init>(r7, r13)
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.focus.FocusEventModifierKt.onFocusEvent(r12, r14)
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r12 = r12.getTopStart()
            r15 = 0
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r15, r0, r15)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r13)
            java.lang.String r14 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r13 = r18
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r5)
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r35 = r8
            r8 = r18
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r5)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r9 = r18
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r5)
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r18.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            androidx.compose.runtime.Applier r10 = r0.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0224
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0224:
            r0.startReusableNode()
            boolean r10 = r0.getInserting()
            if (r10 == 0) goto L_0x0231
            r0.createNode(r15)
            goto L_0x0234
        L_0x0231:
            r0.useNode()
        L_0x0234:
            r0.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r12, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r13, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r8, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r9, r8)
            r0.enableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r8)
            r9 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
            r7.invoke(r8, r0, r10)
            r7 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r7)
            r8 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            androidx.compose.foundation.layout.BoxScopeInstance r8 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r8 = (androidx.compose.foundation.layout.BoxScope) r8
            r8 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r9 = r9.getTop()
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r10 = r10.getStart()
            r12 = 0
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r9, r10, r0, r12)
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r12, r5)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r12, r5)
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r13 = (androidx.compose.ui.unit.LayoutDirection) r13
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r12, r5)
            java.lang.Object r12 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r12 = (androidx.compose.ui.platform.ViewConfiguration) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.materializerOf(r8)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x02fe
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02fe:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x030b
            r0.createNode(r14)
            goto L_0x030e
        L_0x030b:
            r0.useNode()
        L_0x030e:
            r0.disableReusing()
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r9, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r10, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r13, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r12, r9)
            r0.enableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r9 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r9)
            r10 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            r8.invoke(r9, r0, r12)
            r0.startReplaceableGroup(r7)
            r7 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            androidx.compose.foundation.layout.ColumnScopeInstance r7 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r7 = (androidx.compose.foundation.layout.ColumnScope) r7
            int r8 = r11 >> 21
            r8 = r8 & 14
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r3.invoke(r0, r8)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            r9 = 8
            float r10 = (float) r9
            float r10 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r10)
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r8, r10)
            r10 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r8, r0, r10)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType r8 = r39.getValidationType()
            int[] r10 = io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r8 = r10[r8]
            r10 = 3
            r15 = 1
            if (r8 == r15) goto L_0x03b0
            r12 = 2
            if (r8 == r12) goto L_0x03a9
            if (r8 == r10) goto L_0x03a2
            r12 = 4
            if (r8 == r12) goto L_0x039b
            androidx.compose.ui.text.input.KeyboardType$Companion r8 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r8 = r8.m4415getTextPjHm6EE()
            goto L_0x03b6
        L_0x039b:
            androidx.compose.ui.text.input.KeyboardType$Companion r8 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r8 = r8.m4411getNumberPjHm6EE()
            goto L_0x03b6
        L_0x03a2:
            androidx.compose.ui.text.input.KeyboardType$Companion r8 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r8 = r8.m4414getPhonePjHm6EE()
            goto L_0x03b6
        L_0x03a9:
            androidx.compose.ui.text.input.KeyboardType$Companion r8 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r8 = r8.m4410getEmailPjHm6EE()
            goto L_0x03b6
        L_0x03b0:
            androidx.compose.ui.text.input.KeyboardType$Companion r8 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r8 = r8.m4411getNumberPjHm6EE()
        L_0x03b6:
            r20 = r8
            boolean r8 = r1 instanceof io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer
            if (r8 == 0) goto L_0x03c4
            r8 = r1
            io.intercom.android.sdk.survey.ui.models.Answer$SingleAnswer r8 = (io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer) r8
            java.lang.String r8 = r8.getAnswer()
            goto L_0x03c6
        L_0x03c4:
            java.lang.String r8 = ""
        L_0x03c6:
            r12 = -1468505660(0xffffffffa87861c4, float:-1.3787965E-14)
            r0.startReplaceableGroup(r12)
            java.lang.Integer r12 = r39.getPlaceHolderStringRes()
            if (r12 == 0) goto L_0x03e0
            java.lang.Integer r12 = r39.getPlaceHolderStringRes()
            int r12 = r12.intValue()
            r13 = 0
            java.lang.String r12 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r12, r0, r13)
            goto L_0x03e4
        L_0x03e0:
            java.lang.String r12 = r39.getPlaceholder()
        L_0x03e4:
            r0.endReplaceableGroup()
            r13 = -1468505391(0xffffffffa87862d1, float:-1.3788193E-14)
            r0.startReplaceableGroup(r13)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType r13 = r39.getValidationType()
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType r14 = io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionValidation.ValidationType.PHONE
            r17 = 0
            if (r13 != r14) goto L_0x04b7
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r5)
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.content.Context r12 = (android.content.Context) r12
            io.intercom.android.sdk.utilities.PhoneNumberValidator.loadCountryAreaCodes(r12)
            int r12 = android.os.Build.VERSION.SDK_INT
            r13 = 24
            if (r12 < r13) goto L_0x0449
            r12 = -1468505180(0xffffffffa87863a4, float:-1.3788372E-14)
            r0.startReplaceableGroup(r12)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r5)
            java.lang.Object r5 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.content.Context r5 = (android.content.Context) r5
            android.content.Context r5 = r5.getApplicationContext()
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            android.os.LocaleList r5 = r5.getLocales()
            r14 = 0
            java.util.Locale r5 = r5.get(r14)
            r0.endReplaceableGroup()
            goto L_0x0476
        L_0x0449:
            r14 = 0
            r12 = -1468505056(0xffffffffa8786420, float:-1.3788477E-14)
            r0.startReplaceableGroup(r12)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r5)
            java.lang.Object r5 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.content.Context r5 = (android.content.Context) r5
            android.content.Context r5 = r5.getApplicationContext()
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            java.util.Locale r5 = r5.locale
            r0.endReplaceableGroup()
        L_0x0476:
            boolean r12 = r1 instanceof io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer
            if (r12 != 0) goto L_0x0483
            java.lang.String r5 = io.intercom.android.sdk.utilities.PhoneNumberValidator.stripPrefix(r8)
            io.intercom.android.sdk.models.CountryAreaCode r5 = io.intercom.android.sdk.utilities.PhoneNumberValidator.getCountryAreaCodeFromNumber(r5)
            goto L_0x048b
        L_0x0483:
            java.lang.String r5 = r5.getCountry()
            io.intercom.android.sdk.models.CountryAreaCode r5 = io.intercom.android.sdk.utilities.PhoneNumberValidator.getCountryAreaCodeFromLocale(r5)
        L_0x048b:
            boolean r12 = r1 instanceof io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer.InitialNoAnswer
            if (r12 == 0) goto L_0x04a4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r12 = 43
            r8.append(r12)
            java.lang.String r12 = r5.getDialCode()
            r8.append(r12)
            java.lang.String r8 = r8.toString()
        L_0x04a4:
            r12 = 902739986(0x35ceb812, float:1.5401768E-6)
            io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt$ShortTextQuestion$3$1$1 r13 = new io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt$ShortTextQuestion$3$1$1
            r13.<init>(r5)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r12, r15, r13)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.String r12 = "+1 123 456 7890"
            r23 = r5
            goto L_0x04ba
        L_0x04b7:
            r14 = 0
            r23 = r17
        L_0x04ba:
            r0.endReplaceableGroup()
            boolean r5 = r6 instanceof io.intercom.android.sdk.survey.ValidationError.ValidationStringError
            if (r5 == 0) goto L_0x04db
            boolean r5 = r1 instanceof io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer.InitialNoAnswer
            if (r5 != 0) goto L_0x04db
            r5 = r6
            io.intercom.android.sdk.survey.ValidationError$ValidationStringError r5 = (io.intercom.android.sdk.survey.ValidationError.ValidationStringError) r5
            int r5 = r5.getStringRes()
            int r13 = io.intercom.android.sdk.R.string.intercom_surveys_required_response
            if (r5 == r13) goto L_0x04db
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r5.m1966getRed0d7_KjU()
            androidx.compose.ui.graphics.Color r5 = androidx.compose.ui.graphics.Color.m1922boximpl(r17)
            goto L_0x04dd
        L_0x04db:
            r5 = r17
        L_0x04dd:
            long r17 = r42.m5274getButton0d7_KjU()
            long r21 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5398getAccessibleColorOnWhiteBackground8_81llA(r17)
            boolean r13 = r39.getEnabled()
            if (r13 == 0) goto L_0x04f6
            boolean r13 = r6 instanceof io.intercom.android.sdk.survey.ValidationError.NoValidationError
            if (r13 == 0) goto L_0x04f6
            boolean r13 = r1 instanceof io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer
            if (r13 != 0) goto L_0x04f6
            r24 = 1
            goto L_0x04f8
        L_0x04f6:
            r24 = 0
        L_0x04f8:
            androidx.compose.ui.text.input.ImeAction$Companion r13 = androidx.compose.ui.text.input.ImeAction.Companion
            int r26 = r13.m4378getNexteUduSuo()
            boolean r30 = r39.getEnabled()
            r13 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            boolean r13 = r0.changed((java.lang.Object) r4)
            java.lang.Object r14 = r0.rememberedValue()
            if (r13 != 0) goto L_0x051f
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x052a
        L_0x051f:
            io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt$ShortTextQuestion$3$1$2$1 r13 = new io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt$ShortTextQuestion$3$1$2$1
            r13.<init>(r4)
            r14 = r13
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r0.updateRememberedValue(r14)
        L_0x052a:
            r0.endReplaceableGroup()
            r13 = r14
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r17 = 0
            r18 = 1
            r25 = 0
            int r10 = r11 << 3
            r10 = r10 & r16
            r11 = 1572864(0x180000, float:2.204052E-39)
            r27 = r10 | r11
            r28 = 0
            r29 = 8224(0x2020, float:1.1524E-41)
            r11 = r8
            r8 = 0
            r14 = r5
            r5 = 0
            r8 = 1
            r15 = r21
            r19 = r2
            r21 = r26
            r22 = r24
            r24 = r30
            r26 = r0
            io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt.m5354TextInputPillg5ZjG94(r11, r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType r10 = r39.getValidationType()
            r11 = -1468503054(0xffffffffa8786bf2, float:-1.3790172E-14)
            r0.startReplaceableGroup(r11)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType r11 = io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionValidation.ValidationType.NO_VALIDATION
            if (r10 != r11) goto L_0x0566
        L_0x0564:
            r15 = 1
            goto L_0x056c
        L_0x0566:
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType r11 = io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionValidation.ValidationType.TEXT
            if (r10 != r11) goto L_0x056b
            goto L_0x0564
        L_0x056b:
            r15 = 0
        L_0x056c:
            r36 = 4285756278(0xff737376, double:2.1174449434E-314)
            if (r15 == 0) goto L_0x05ea
            java.lang.Integer r8 = r39.getCharacterLimit()
            if (r8 != 0) goto L_0x057a
            goto L_0x05ea
        L_0x057a:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            int r11 = r1.getLength()
            r10.append(r11)
            r11 = 47
            r10.append(r11)
            r10.append(r8)
            java.lang.String r11 = r10.toString()
            r8 = 12
            long r15 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r8)
            long r13 = androidx.compose.ui.graphics.ColorKt.Color((long) r36)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r10 = r10.getEnd()
            androidx.compose.ui.Modifier r17 = r7.align(r8, r10)
            r18 = 0
            r7 = 4
            float r8 = (float) r7
            float r19 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r8)
            r20 = 0
            r21 = 0
            r22 = 13
            r23 = 0
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r17, r18, r19, r20, r21, r22, r23)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 3456(0xd80, float:4.843E-42)
            r33 = 0
            r34 = 65520(0xfff0, float:9.1813E-41)
            r31 = r0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r11, r12, r13, r15, r17, r18, r19, r20, r22, r23, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
        L_0x05ea:
            r0.endReplaceableGroup()
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType r7 = r39.getValidationType()
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType r8 = io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionValidation.ValidationType.EMAIL
            if (r7 != r8) goto L_0x0645
            int r7 = io.intercom.android.sdk.R.string.intercom_tickets_email_copy
            java.lang.String r11 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r7, r0, r5)
            long r13 = androidx.compose.ui.graphics.ColorKt.Color((long) r36)
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r5 = r5.getTypography(r0, r9)
            androidx.compose.ui.text.TextStyle r30 = r5.getBody2()
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            r15 = r5
            androidx.compose.ui.Modifier r15 = (androidx.compose.ui.Modifier) r15
            r16 = 0
            r5 = 4
            float r5 = (float) r5
            float r17 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r5)
            r18 = 0
            r19 = 0
            r20 = 13
            r21 = 0
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r15, r16, r17, r18, r19, r20, r21)
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r32 = 432(0x1b0, float:6.05E-43)
            r33 = 0
            r34 = 32760(0x7ff8, float:4.5907E-41)
            r31 = r0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r11, r12, r13, r15, r17, r18, r19, r20, r22, r23, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34)
        L_0x0645:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r7 = r2
            r8 = r3
            r3 = r1
            r1 = r35
        L_0x0668:
            androidx.compose.runtime.ScopeUpdateScope r11 = r0.endRestartGroup()
            if (r11 != 0) goto L_0x066f
            goto L_0x0686
        L_0x066f:
            io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt$ShortTextQuestion$4 r12 = new io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt$ShortTextQuestion$4
            r0 = r12
            r2 = r39
            r4 = r41
            r5 = r42
            r6 = r43
            r9 = r47
            r10 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x0686:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.text.ShortTextQuestionKt.ShortTextQuestion(androidx.compose.ui.Modifier, io.intercom.android.sdk.survey.model.SurveyData$Step$Question$ShortTextQuestionModel, io.intercom.android.sdk.survey.ui.models.Answer, kotlin.jvm.functions.Function1, io.intercom.android.sdk.survey.SurveyUiColors, io.intercom.android.sdk.survey.ValidationError, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void ShortTextPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(2147193389);
        ComposerKt.sourceInformation(startRestartGroup, "C(ShortTextPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$ShortTextQuestionKt.INSTANCE.m5345getLambda2$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ShortTextQuestionKt$ShortTextPreview$1(i));
        }
    }

    public static final void ShortTextAnsweredPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1590545552);
        ComposerKt.sourceInformation(startRestartGroup, "C(ShortTextAnsweredPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$ShortTextQuestionKt.INSTANCE.m5346getLambda3$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ShortTextQuestionKt$ShortTextAnsweredPreview$1(i));
        }
    }

    public static final void ShortTextPhoneNumberPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-38271892);
        ComposerKt.sourceInformation(startRestartGroup, "C(ShortTextPhoneNumberPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$ShortTextQuestionKt.INSTANCE.m5347getLambda4$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ShortTextQuestionKt$ShortTextPhoneNumberPreview$1(i));
        }
    }

    public static final void ShortTextDisabledPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1539795729);
        ComposerKt.sourceInformation(startRestartGroup, "C(ShortTextDisabledPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$ShortTextQuestionKt.INSTANCE.m5348getLambda5$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ShortTextQuestionKt$ShortTextDisabledPreview$1(i));
        }
    }
}
