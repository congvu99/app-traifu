package io.intercom.android.sdk.survey.ui.questiontype.text;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.survey.SurveyViewModelKt;
import io.intercom.android.sdk.survey.ValidationError;
import io.intercom.android.sdk.survey.model.SurveyCustomization;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a}\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u00122\u0013\b\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0015H\u0001¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"LongTextPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "LongTextQuestion", "modifier", "Landroidx/compose/ui/Modifier;", "textQuestionModel", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$LongTextQuestionModel;", "answer", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "onAnswer", "Lkotlin/Function1;", "colors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "validationError", "Lio/intercom/android/sdk/survey/ValidationError;", "onImeActionNext", "Landroidx/compose/foundation/text/KeyboardActionScope;", "Lkotlin/ExtensionFunctionType;", "questionHeader", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$LongTextQuestionModel;Lio/intercom/android/sdk/survey/ui/models/Answer;Lkotlin/jvm/functions/Function1;Lio/intercom/android/sdk/survey/SurveyUiColors;Lio/intercom/android/sdk/survey/ValidationError;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LongTextQuestion.kt */
public final class LongTextQuestionKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x049d  */
    /* JADX WARNING: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LongTextQuestion(androidx.compose.ui.Modifier r36, io.intercom.android.sdk.survey.model.SurveyData.Step.Question.LongTextQuestionModel r37, io.intercom.android.sdk.survey.ui.models.Answer r38, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.survey.ui.models.Answer, kotlin.Unit> r39, io.intercom.android.sdk.survey.SurveyUiColors r40, io.intercom.android.sdk.survey.ValidationError r41, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.text.KeyboardActionScope, kotlin.Unit> r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.runtime.Composer r44, int r45, int r46) {
        /*
            r2 = r37
            r4 = r39
            r5 = r40
            r6 = r41
            r9 = r45
            r10 = r46
            java.lang.String r0 = "textQuestionModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onAnswer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "validationError"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 1615764807(0x604e9d47, float:5.9552536E19)
            r1 = r44
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r10 & 1
            if (r1 == 0) goto L_0x0033
            r8 = r9 | 6
            r11 = r8
            r8 = r36
            goto L_0x0047
        L_0x0033:
            r8 = r9 & 14
            if (r8 != 0) goto L_0x0044
            r8 = r36
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
            r8 = r36
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
            r14 = r9 & 896(0x380, float:1.256E-42)
            if (r14 != 0) goto L_0x0078
            r14 = r38
            boolean r15 = r0.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x0074
            r15 = 256(0x100, float:3.59E-43)
            goto L_0x0076
        L_0x0074:
            r15 = 128(0x80, float:1.794E-43)
        L_0x0076:
            r11 = r11 | r15
            goto L_0x007a
        L_0x0078:
            r14 = r38
        L_0x007a:
            r15 = r10 & 8
            if (r15 == 0) goto L_0x0081
            r11 = r11 | 3072(0xc00, float:4.305E-42)
            goto L_0x0091
        L_0x0081:
            r15 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r15 != 0) goto L_0x0091
            boolean r15 = r0.changed((java.lang.Object) r4)
            if (r15 == 0) goto L_0x008e
            r15 = 2048(0x800, float:2.87E-42)
            goto L_0x0090
        L_0x008e:
            r15 = 1024(0x400, float:1.435E-42)
        L_0x0090:
            r11 = r11 | r15
        L_0x0091:
            r15 = r10 & 16
            if (r15 == 0) goto L_0x0098
            r11 = r11 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00aa
        L_0x0098:
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00aa
            boolean r15 = r0.changed((java.lang.Object) r5)
            if (r15 == 0) goto L_0x00a7
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a9
        L_0x00a7:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a9:
            r11 = r11 | r15
        L_0x00aa:
            r15 = r10 & 32
            if (r15 == 0) goto L_0x00b2
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00b0:
            r11 = r11 | r15
            goto L_0x00c3
        L_0x00b2:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00c3
            boolean r15 = r0.changed((java.lang.Object) r6)
            if (r15 == 0) goto L_0x00c0
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00c0:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b0
        L_0x00c3:
            r15 = r10 & 64
            if (r15 == 0) goto L_0x00ce
            r16 = 1572864(0x180000, float:2.204052E-39)
            r11 = r11 | r16
            r3 = r42
            goto L_0x00e3
        L_0x00ce:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r9 & r16
            r3 = r42
            if (r16 != 0) goto L_0x00e3
            boolean r16 = r0.changed((java.lang.Object) r3)
            if (r16 == 0) goto L_0x00df
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r11 = r11 | r16
        L_0x00e3:
            r13 = r10 & 128(0x80, float:1.794E-43)
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            if (r13 == 0) goto L_0x00f0
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r11 = r11 | r18
            r7 = r43
            goto L_0x0103
        L_0x00f0:
            r18 = r9 & r17
            r7 = r43
            if (r18 != 0) goto L_0x0103
            boolean r19 = r0.changed((java.lang.Object) r7)
            if (r19 == 0) goto L_0x00ff
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0101
        L_0x00ff:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x0101:
            r11 = r11 | r19
        L_0x0103:
            r19 = 23967451(0x16db6db, float:4.3661218E-38)
            r2 = r11 & r19
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r2 != r3) goto L_0x011f
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x0114
            goto L_0x011f
        L_0x0114:
            r0.skipToGroupEnd()
            r5 = r4
            r1 = r8
            r3 = r14
            r8 = r7
        L_0x011b:
            r7 = r42
            goto L_0x0496
        L_0x011f:
            if (r1 == 0) goto L_0x0126
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r8 = r1
        L_0x0126:
            if (r12 == 0) goto L_0x012d
            io.intercom.android.sdk.survey.ui.models.Answer$NoAnswer$InitialNoAnswer r1 = io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer.InitialNoAnswer.INSTANCE
            io.intercom.android.sdk.survey.ui.models.Answer r1 = (io.intercom.android.sdk.survey.ui.models.Answer) r1
            goto L_0x012e
        L_0x012d:
            r1 = r14
        L_0x012e:
            if (r15 == 0) goto L_0x0135
            io.intercom.android.sdk.survey.ui.questiontype.text.LongTextQuestionKt$LongTextQuestion$1 r2 = io.intercom.android.sdk.survey.ui.questiontype.text.LongTextQuestionKt$LongTextQuestion$1.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            goto L_0x0137
        L_0x0135:
            r2 = r42
        L_0x0137:
            if (r13 == 0) goto L_0x0140
            io.intercom.android.sdk.survey.ui.questiontype.text.ComposableSingletons$LongTextQuestionKt r3 = io.intercom.android.sdk.survey.ui.questiontype.text.ComposableSingletons$LongTextQuestionKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m5343getLambda1$intercom_sdk_base_release()
            r7 = r3
        L_0x0140:
            r3 = r11 & 14
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r12 = r12.getTopStart()
            int r13 = r3 >> 3
            r14 = r13 & 14
            r13 = r13 & 112(0x70, float:1.57E-43)
            r13 = r13 | r14
            r14 = 0
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r14, r0, r13)
            int r13 = r3 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r15)
            java.lang.String r15 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r14 = r19
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r5, r9)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r10 = r19
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r5, r9)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r42 = r2
            r2 = r19
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r5, r9)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r19.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r8)
            int r13 = r13 << 9
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r35 = r8
            r8 = 6
            r13 = r13 | r8
            androidx.compose.runtime.Applier r8 = r0.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x01ce
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01ce:
            r0.startReusableNode()
            boolean r8 = r0.getInserting()
            if (r8 == 0) goto L_0x01db
            r0.createNode(r5)
            goto L_0x01de
        L_0x01db:
            r0.useNode()
        L_0x01de:
            r0.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r12, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r14, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r10, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r2, r8)
            r0.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r2)
            int r5 = r13 >> 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.invoke(r2, r0, r5)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            int r4 = r13 >> 9
            r4 = r4 & 14
            r5 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            r4 = r4 & 11
            r5 = 2
            if (r4 != r5) goto L_0x0247
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x0240
            goto L_0x0247
        L_0x0240:
            r0.skipToGroupEnd()
        L_0x0243:
            r5 = r39
            goto L_0x0481
        L_0x0247:
            androidx.compose.foundation.layout.BoxScopeInstance r4 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r5 = 6
            int r3 = r3 >> r5
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | r5
            androidx.compose.foundation.layout.BoxScope r4 = (androidx.compose.foundation.layout.BoxScope) r4
            r3 = r3 & 81
            r4 = 16
            if (r3 != r4) goto L_0x0261
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x025d
            goto L_0x0261
        L_0x025d:
            r0.skipToGroupEnd()
            goto L_0x0243
        L_0x0261:
            r3 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.foundation.layout.Arrangement r4 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r4 = r4.getTop()
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r5 = r5.getStart()
            r8 = 0
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r4, r5, r0, r8)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r9)
            java.lang.Object r5 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r9)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r9)
            java.lang.Object r8 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            androidx.compose.runtime.Applier r12 = r0.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x02d8
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02d8:
            r0.startReusableNode()
            boolean r12 = r0.getInserting()
            if (r12 == 0) goto L_0x02e5
            r0.createNode(r9)
            goto L_0x02e8
        L_0x02e5:
            r0.useNode()
        L_0x02e8:
            r0.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r4, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r5, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r10, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r8, r4)
            r0.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r4)
            r5 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            r3.invoke(r4, r0, r8)
            r0.startReplaceableGroup(r2)
            r2 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.foundation.layout.ColumnScopeInstance r2 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r2 = (androidx.compose.foundation.layout.ColumnScope) r2
            int r3 = r11 >> 21
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.invoke(r0, r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = 8
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r3, r4)
            r4 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r3, r0, r4)
            r3 = 1507957100(0x59e1996c, float:7.9375699E15)
            r0.startReplaceableGroup(r3)
            java.lang.Integer r3 = r37.getPlaceHolderStringRes()
            if (r3 == 0) goto L_0x0370
            java.lang.Integer r3 = r37.getPlaceHolderStringRes()
            int r3 = r3.intValue()
            r4 = 0
            java.lang.String r3 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r3, r0, r4)
            goto L_0x0374
        L_0x0370:
            java.lang.String r3 = r37.getPlaceholder()
        L_0x0374:
            r12 = r3
            r0.endReplaceableGroup()
            boolean r3 = r1 instanceof io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer
            if (r3 == 0) goto L_0x0384
            r3 = r1
            io.intercom.android.sdk.survey.ui.models.Answer$SingleAnswer r3 = (io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer) r3
            java.lang.String r3 = r3.getAnswer()
            goto L_0x0386
        L_0x0384:
            java.lang.String r3 = ""
        L_0x0386:
            boolean r4 = r6 instanceof io.intercom.android.sdk.survey.ValidationError.ValidationStringError
            if (r4 == 0) goto L_0x0399
            boolean r4 = r1 instanceof io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer.InitialNoAnswer
            if (r4 != 0) goto L_0x0399
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r4 = r4.m1966getRed0d7_KjU()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m1922boximpl(r4)
            goto L_0x039a
        L_0x0399:
            r4 = 0
        L_0x039a:
            r14 = r4
            long r4 = r40.m5274getButton0d7_KjU()
            long r15 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5398getAccessibleColorOnWhiteBackground8_81llA(r4)
            androidx.compose.ui.text.input.ImeAction$Companion r4 = androidx.compose.ui.text.input.ImeAction.Companion
            int r21 = r4.m4375getDefaulteUduSuo()
            int r4 = r37.getMaxLine()
            float r25 = r37.m5308getMinHeightD9Ej5fM()
            r5 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            r5 = r39
            boolean r8 = r0.changed((java.lang.Object) r5)
            java.lang.Object r9 = r0.rememberedValue()
            if (r8 != 0) goto L_0x03d0
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x03db
        L_0x03d0:
            io.intercom.android.sdk.survey.ui.questiontype.text.LongTextQuestionKt$LongTextQuestion$2$1$1$1 r8 = new io.intercom.android.sdk.survey.ui.questiontype.text.LongTextQuestionKt$LongTextQuestion$2$1$1$1
            r8.<init>(r5)
            r9 = r8
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r0.updateRememberedValue(r9)
        L_0x03db:
            r0.endReplaceableGroup()
            r13 = r9
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r18 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            int r8 = r11 << 3
            r27 = r8 & r17
            r28 = 6
            r29 = 6464(0x1940, float:9.058E-42)
            r11 = r3
            r17 = r4
            r19 = r42
            r26 = r0
            io.intercom.android.sdk.survey.ui.questiontype.text.TextInputPillKt.m5354TextInputPillg5ZjG94(r11, r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            java.lang.Integer r3 = r37.getCharacterLimit()
            if (r3 == 0) goto L_0x0472
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r4 = r1.getLength()
            r3.append(r4)
            r4 = 47
            r3.append(r4)
            java.lang.Integer r4 = r37.getCharacterLimit()
            r3.append(r4)
            java.lang.String r11 = r3.toString()
            r3 = 12
            long r15 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r3)
            r3 = 4285756278(0xff737376, double:2.1174449434E-314)
            long r13 = androidx.compose.ui.graphics.ColorKt.Color((long) r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r4 = r4.getEnd()
            androidx.compose.ui.Modifier r17 = r2.align(r3, r4)
            r18 = 0
            r2 = 4
            float r2 = (float) r2
            float r19 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r2)
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
        L_0x0472:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x0481:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r3 = r1
            r8 = r7
            r1 = r35
            goto L_0x011b
        L_0x0496:
            androidx.compose.runtime.ScopeUpdateScope r11 = r0.endRestartGroup()
            if (r11 != 0) goto L_0x049d
            goto L_0x04b4
        L_0x049d:
            io.intercom.android.sdk.survey.ui.questiontype.text.LongTextQuestionKt$LongTextQuestion$3 r12 = new io.intercom.android.sdk.survey.ui.questiontype.text.LongTextQuestionKt$LongTextQuestion$3
            r0 = r12
            r2 = r37
            r4 = r39
            r5 = r40
            r6 = r41
            r9 = r45
            r10 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x04b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.text.LongTextQuestionKt.LongTextQuestion(androidx.compose.ui.Modifier, io.intercom.android.sdk.survey.model.SurveyData$Step$Question$LongTextQuestionModel, io.intercom.android.sdk.survey.ui.models.Answer, kotlin.jvm.functions.Function1, io.intercom.android.sdk.survey.SurveyUiColors, io.intercom.android.sdk.survey.ValidationError, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void LongTextPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-479343201);
        ComposerKt.sourceInformation(startRestartGroup, "C(LongTextPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            String uuid = UUID.randomUUID().toString();
            List listOf = CollectionsKt.listOf(new Block.Builder().withText("Is this a preview?"));
            SurveyData.Step.Question.QuestionValidation.ValidationType validationType = SurveyData.Step.Question.QuestionValidation.ValidationType.NO_VALIDATION;
            Intrinsics.checkNotNullExpressionValue(uuid, "toString()");
            LongTextQuestion((Modifier) null, new SurveyData.Step.Question.LongTextQuestionModel(uuid, listOf, true, "Placeholder text", validationType, 2000, 0.0f, 0, (Integer) null, 448, (DefaultConstructorMarker) null), (Answer) null, LongTextQuestionKt$LongTextPreview$1.INSTANCE, SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)), ValidationError.NoValidationError.INSTANCE, (Function1<? super KeyboardActionScope, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, startRestartGroup, 199680, 197);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LongTextQuestionKt$LongTextPreview$2(i));
        }
    }
}
