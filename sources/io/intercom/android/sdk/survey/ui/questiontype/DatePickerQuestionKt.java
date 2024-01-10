package io.intercom.android.sdk.survey.ui.questiontype;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.survey.ui.models.Answer;
import io.intercom.android.sdk.utilities.TimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\b\u001aR\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00072\u0013\b\u0002\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\b\u001a\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002\u001a(\u0010\u001a\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007H\u0002\u001a(\u0010\u001c\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007H\u0002¨\u0006\u001d"}, d2 = {"DatePicker", "", "modifier", "Landroidx/compose/ui/Modifier;", "answer", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "onAnswer", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/survey/ui/models/Answer;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "DatePickerQuestion", "questionModel", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$DatePickerQuestionModel;", "questionHeader", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$DatePickerQuestionModel;Lio/intercom/android/sdk/survey/ui/models/Answer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DatePickerQuestionPreview", "(Landroidx/compose/runtime/Composer;I)V", "TimePicker", "getLocalTime", "", "", "getUtcTime", "hour", "", "minute", "showDatePicker", "Landroidx/appcompat/app/AppCompatActivity;", "showTimePicker", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: DatePickerQuestion.kt */
public final class DatePickerQuestionKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DatePickerQuestion(androidx.compose.ui.Modifier r17, io.intercom.android.sdk.survey.model.SurveyData.Step.Question.DatePickerQuestionModel r18, io.intercom.android.sdk.survey.ui.models.Answer r19, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.survey.ui.models.Answer, kotlin.Unit> r20, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r4 = r20
            r6 = r23
            java.lang.String r0 = "questionModel"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onAnswer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 1352728701(0x50a1007d, float:2.16093102E10)
            r1 = r22
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r24 & 1
            if (r1 == 0) goto L_0x0023
            r5 = r6 | 6
            r7 = r5
            r5 = r17
            goto L_0x0037
        L_0x0023:
            r5 = r6 & 14
            if (r5 != 0) goto L_0x0034
            r5 = r17
            boolean r7 = r0.changed((java.lang.Object) r5)
            if (r7 == 0) goto L_0x0031
            r7 = 4
            goto L_0x0032
        L_0x0031:
            r7 = 2
        L_0x0032:
            r7 = r7 | r6
            goto L_0x0037
        L_0x0034:
            r5 = r17
            r7 = r6
        L_0x0037:
            r8 = r24 & 4
            if (r8 == 0) goto L_0x003e
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x0051
        L_0x003e:
            r9 = r6 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0051
            r9 = r19
            boolean r10 = r0.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x004d
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x004f
        L_0x004d:
            r10 = 128(0x80, float:1.794E-43)
        L_0x004f:
            r7 = r7 | r10
            goto L_0x0053
        L_0x0051:
            r9 = r19
        L_0x0053:
            r10 = r24 & 8
            if (r10 == 0) goto L_0x005a
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x006a
        L_0x005a:
            r10 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x006a
            boolean r10 = r0.changed((java.lang.Object) r4)
            if (r10 == 0) goto L_0x0067
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0069
        L_0x0067:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0069:
            r7 = r7 | r10
        L_0x006a:
            r10 = r24 & 16
            if (r10 == 0) goto L_0x0071
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0086
        L_0x0071:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r6
            if (r11 != 0) goto L_0x0086
            r11 = r21
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0082
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0084
        L_0x0082:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0084:
            r7 = r7 | r12
            goto L_0x0088
        L_0x0086:
            r11 = r21
        L_0x0088:
            r12 = 46731(0xb68b, float:6.5484E-41)
            r12 = r12 & r7
            r13 = 9346(0x2482, float:1.3097E-41)
            if (r12 != r13) goto L_0x009f
            boolean r12 = r0.getSkipping()
            if (r12 != 0) goto L_0x0097
            goto L_0x009f
        L_0x0097:
            r0.skipToGroupEnd()
            r1 = r5
            r3 = r9
            r5 = r11
            goto L_0x032b
        L_0x009f:
            if (r1 == 0) goto L_0x00a6
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00a7
        L_0x00a6:
            r1 = r5
        L_0x00a7:
            if (r8 == 0) goto L_0x00ae
            io.intercom.android.sdk.survey.ui.models.Answer$NoAnswer$InitialNoAnswer r5 = io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer.InitialNoAnswer.INSTANCE
            io.intercom.android.sdk.survey.ui.models.Answer r5 = (io.intercom.android.sdk.survey.ui.models.Answer) r5
            r9 = r5
        L_0x00ae:
            if (r10 == 0) goto L_0x00b7
            io.intercom.android.sdk.survey.ui.questiontype.ComposableSingletons$DatePickerQuestionKt r5 = io.intercom.android.sdk.survey.ui.questiontype.ComposableSingletons$DatePickerQuestionKt.INSTANCE
            kotlin.jvm.functions.Function2 r5 = r5.m5316getLambda1$intercom_sdk_base_release()
            r11 = r5
        L_0x00b7:
            r5 = r7 & 14
            r8 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r8 = r8.getTop()
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r10 = r10.getStart()
            int r12 = r5 >> 3
            r13 = r12 & 14
            r12 = r12 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r8, r10, r0, r12)
            int r10 = r5 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r12)
            java.lang.String r13 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r12 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r12)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r3 = r16
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r12)
            java.lang.Object r3 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r12)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            int r10 = r10 << 9
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            r16 = r1
            r1 = 6
            r10 = r10 | r1
            androidx.compose.runtime.Applier r1 = r0.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x0146
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0146:
            r0.startReusableNode()
            boolean r1 = r0.getInserting()
            if (r1 == 0) goto L_0x0153
            r0.createNode(r15)
            goto L_0x0156
        L_0x0153:
            r0.useNode()
        L_0x0156:
            r0.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r8, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r14, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r3, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r2, r3)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            int r2 = r10 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.invoke(r1, r0, r2)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            int r2 = r10 >> 9
            r2 = r2 & 14
            r3 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r2 = r2 & 11
            r3 = 2
            if (r2 != r3) goto L_0x01bd
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x01b8
            goto L_0x01bd
        L_0x01b8:
            r0.skipToGroupEnd()
            goto L_0x0318
        L_0x01bd:
            androidx.compose.foundation.layout.ColumnScopeInstance r2 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            r3 = 6
            int r5 = r5 >> r3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | r3
            androidx.compose.foundation.layout.ColumnScope r2 = (androidx.compose.foundation.layout.ColumnScope) r2
            r2 = r5 & 81
            r3 = 16
            if (r2 != r3) goto L_0x01d8
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x01d3
            goto L_0x01d8
        L_0x01d3:
            r0.skipToGroupEnd()
            goto L_0x0318
        L_0x01d8:
            int r2 = r7 >> 12
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r11.invoke(r0, r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r5 = 8
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r5)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r2, r5)
            r5 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r2, r0, r5)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r5 = 0
            r6 = 0
            r8 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r2, r5, r8, r6)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r5 = r5.getSpaceBetween()
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r5
            r6 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r6 = r6.getTop()
            r8 = 6
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r6, r0, r8)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r12)
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r12)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r12)
            java.lang.Object r8 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r13 = r0.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x0276
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0276:
            r0.startReusableNode()
            boolean r13 = r0.getInserting()
            if (r13 == 0) goto L_0x0283
            r0.createNode(r12)
            goto L_0x0286
        L_0x0283:
            r0.useNode()
        L_0x0286:
            r0.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r5, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r6, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r10, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r8, r5)
            r0.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r5)
            r6 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2.invoke(r5, r0, r6)
            r0.startReplaceableGroup(r1)
            r1 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 1056964608(0x3f000000, float:0.5)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth(r1, r2)
            int r2 = r7 >> 3
            r5 = r2 & 112(0x70, float:1.57E-43)
            r6 = 6
            r5 = r5 | r6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r2 = r2 | r5
            DatePicker(r1, r9, r4, r0, r2)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r1, r3)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r0, r6)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r3 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth(r1, r3)
            TimePicker(r1, r9, r4, r0, r2)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x0318:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r3 = r9
            r5 = r11
            r1 = r16
        L_0x032b:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x0332
            goto L_0x0345
        L_0x0332:
            io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt$DatePickerQuestion$2 r9 = new io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt$DatePickerQuestion$2
            r0 = r9
            r2 = r18
            r4 = r20
            r6 = r23
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x0345:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt.DatePickerQuestion(androidx.compose.ui.Modifier, io.intercom.android.sdk.survey.model.SurveyData$Step$Question$DatePickerQuestionModel, io.intercom.android.sdk.survey.ui.models.Answer, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x021e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DatePicker(androidx.compose.ui.Modifier r30, io.intercom.android.sdk.survey.ui.models.Answer r31, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.survey.ui.models.Answer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34) {
        /*
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r34
            r4 = 2133326452(0x7f27fa74, float:2.232815E38)
            r5 = r33
            androidx.compose.runtime.Composer r4 = r5.startRestartGroup(r4)
            r5 = r3 & 14
            if (r5 != 0) goto L_0x0020
            boolean r5 = r4.changed((java.lang.Object) r0)
            if (r5 == 0) goto L_0x001d
            r5 = 4
            goto L_0x001e
        L_0x001d:
            r5 = 2
        L_0x001e:
            r5 = r5 | r3
            goto L_0x0021
        L_0x0020:
            r5 = r3
        L_0x0021:
            r6 = r3 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0031
            boolean r6 = r4.changed((java.lang.Object) r1)
            if (r6 == 0) goto L_0x002e
            r6 = 32
            goto L_0x0030
        L_0x002e:
            r6 = 16
        L_0x0030:
            r5 = r5 | r6
        L_0x0031:
            r6 = r3 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0041
            boolean r6 = r4.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x003e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0040
        L_0x003e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0040:
            r5 = r5 | r6
        L_0x0041:
            r5 = r5 & 731(0x2db, float:1.024E-42)
            r6 = 146(0x92, float:2.05E-43)
            if (r5 != r6) goto L_0x0053
            boolean r5 = r4.getSkipping()
            if (r5 != 0) goto L_0x004e
            goto L_0x0053
        L_0x004e:
            r4.skipToGroupEnd()
            goto L_0x02a5
        L_0x0053:
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r5 = r4.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            android.content.Context r5 = (android.content.Context) r5
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r9 = r4.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.focus.FocusManager r9 = (androidx.compose.ui.focus.FocusManager) r9
            java.lang.String r10 = "DD - MM - YYYY"
            boolean r11 = r1 instanceof io.intercom.android.sdk.survey.ui.models.Answer.DateTimeAnswer
            if (r11 == 0) goto L_0x009b
            r11 = r1
            io.intercom.android.sdk.survey.ui.models.Answer$DateTimeAnswer r11 = (io.intercom.android.sdk.survey.ui.models.Answer.DateTimeAnswer) r11
            long r12 = r11.getDate()
            r14 = -1
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 == 0) goto L_0x009b
            long r11 = r11.getDate()
            java.lang.String r13 = "dd - MM - YYYY"
            java.lang.String r11 = io.intercom.android.sdk.utilities.TimeFormatter.formatTimeInMillisAsDate(r11, r13)
            r14 = r11
            goto L_0x009c
        L_0x009b:
            r14 = r10
        L_0x009c:
            r11 = 1
            float r11 = (float) r11
            float r11 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r11)
            androidx.compose.material.MaterialTheme r12 = androidx.compose.material.MaterialTheme.INSTANCE
            r15 = 8
            androidx.compose.material.Colors r12 = r12.getColors(r4, r15)
            long r16 = r12.m1213getOnSurface0d7_KjU()
            r18 = 1036831949(0x3dcccccd, float:0.1)
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 14
            r23 = 0
            long r12 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r16, r18, r19, r20, r21, r22, r23)
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r7 = r7.getShapes(r4, r15)
            androidx.compose.foundation.shape.CornerBasedShape r7 = r7.getMedium()
            androidx.compose.ui.graphics.Shape r7 = (androidx.compose.ui.graphics.Shape) r7
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.BorderKt.m182borderxT4_qwU(r0, r11, r12, r7)
            androidx.compose.material.MaterialTheme r11 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r11 = r11.getShapes(r4, r15)
            androidx.compose.foundation.shape.CornerBasedShape r11 = r11.getMedium()
            androidx.compose.ui.graphics.Shape r11 = (androidx.compose.ui.graphics.Shape) r11
            androidx.compose.ui.Modifier r16 = androidx.compose.ui.draw.ClipKt.clip(r7, r11)
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r7 = r7.getColors(r4, r15)
            long r17 = r7.m1218getSurface0d7_KjU()
            r19 = 0
            r20 = 2
            r21 = 0
            androidx.compose.ui.Modifier r22 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r16, r17, r19, r20, r21)
            r23 = 0
            r24 = 0
            r25 = 0
            io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt$DatePicker$1 r7 = new io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt$DatePicker$1
            r7.<init>(r9, r5, r1, r2)
            r26 = r7
            kotlin.jvm.functions.Function0 r26 = (kotlin.jvm.functions.Function0) r26
            r27 = 7
            r28 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r22, r23, r24, r25, r26, r27, r28)
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r7 = r7.getSpaceBetween()
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r7
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r9 = r9.getCenterVertically()
            r11 = 693286680(0x2952b718, float:4.6788176E-14)
            r4.startReplaceableGroup(r11)
            java.lang.String r11 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r11)
            r11 = 54
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r7, r9, r4, r11)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r9)
            java.lang.String r9 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r9)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r9 = r4.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r11 = r4.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r6 = r4.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            androidx.compose.runtime.Applier r12 = r4.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x017f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x017f:
            r4.startReusableNode()
            boolean r12 = r4.getInserting()
            if (r12 == 0) goto L_0x018c
            r4.createNode(r8)
            goto L_0x018f
        L_0x018c:
            r4.useNode()
        L_0x018f:
            r4.disableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m1543constructorimpl(r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r7, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r9, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r11, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r6, r7)
            r4.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r6)
            r13 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)
            r5.invoke(r6, r4, r7)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r5)
            r5 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r4.startReplaceableGroup(r5)
            java.lang.String r5 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            androidx.compose.foundation.layout.RowScopeInstance r5 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r5 = (androidx.compose.foundation.layout.RowScope) r5
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r6 = 16
            float r6 = (float) r6
            float r7 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r5, r7)
            r7 = 3
            r8 = 0
            androidx.compose.ui.Modifier r24 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r5, r8, r13, r7, r8)
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r5 = r5.getTypography(r4, r15)
            androidx.compose.ui.text.TextStyle r25 = r5.getBody2()
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r5 = r5.getColors(r4, r15)
            long r16 = r5.m1213getOnSurface0d7_KjU()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r10)
            if (r5 == 0) goto L_0x021e
            r5 = -263656331(0xfffffffff048ec75, float:-2.4873144E29)
            r4.startReplaceableGroup(r5)
            androidx.compose.material.ContentAlpha r5 = androidx.compose.material.ContentAlpha.INSTANCE
            float r5 = r5.getMedium(r4, r15)
            goto L_0x022a
        L_0x021e:
            r5 = -263656306(0xfffffffff048ec8e, float:-2.4873192E29)
            r4.startReplaceableGroup(r5)
            androidx.compose.material.ContentAlpha r5 = androidx.compose.material.ContentAlpha.INSTANCE
            float r5 = r5.getHigh(r4, r15)
        L_0x022a:
            r4.endReplaceableGroup()
            r18 = r5
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 14
            r23 = 0
            long r7 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r16, r18, r19, r20, r21, r22, r23)
            java.lang.String r5 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r5)
            r9 = 0
            r11 = 0
            r12 = 0
            r5 = 0
            r13 = r5
            r16 = 0
            r5 = r14
            r14 = r16
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r26 = 48
            r27 = 0
            r28 = 32760(0x7ff8, float:4.5907E-41)
            r29 = r6
            r6 = r24
            r24 = r25
            r25 = r4
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r5, r6, r7, r9, r11, r12, r13, r14, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            int r5 = io.intercom.android.sdk.R.drawable.intercom_ic_pick_date
            r6 = 0
            androidx.compose.ui.graphics.painter.Painter r5 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r5, r4, r6)
            int r7 = io.intercom.android.sdk.R.string.intercom_choose_the_date
            java.lang.String r6 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r7, r4, r6)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            float r8 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r29)
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r7, r8)
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            r9 = 8
            androidx.compose.material.Colors r8 = r8.getColors(r4, r9)
            long r8 = r8.m1214getPrimary0d7_KjU()
            r11 = 392(0x188, float:5.5E-43)
            r12 = 0
            r10 = r4
            androidx.compose.material.IconKt.m1313Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r5, (java.lang.String) r6, (androidx.compose.ui.Modifier) r7, (long) r8, (androidx.compose.runtime.Composer) r10, (int) r11, (int) r12)
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
        L_0x02a5:
            androidx.compose.runtime.ScopeUpdateScope r4 = r4.endRestartGroup()
            if (r4 != 0) goto L_0x02ac
            goto L_0x02b6
        L_0x02ac:
            io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt$DatePicker$3 r5 = new io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt$DatePicker$3
            r5.<init>(r0, r1, r2, r3)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r4.updateScope(r5)
        L_0x02b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt.DatePicker(androidx.compose.ui.Modifier, io.intercom.android.sdk.survey.ui.models.Answer, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final void showDatePicker(AppCompatActivity appCompatActivity, Answer answer, Function1<? super Answer, Unit> function1) {
        long j;
        MaterialDatePicker.Builder<Long> titleText = MaterialDatePicker.Builder.datePicker().setTheme(R.style.Intercom_MaterialCalendar).setTitleText((CharSequence) "Select date");
        if (answer instanceof Answer.DateTimeAnswer) {
            Answer.DateTimeAnswer dateTimeAnswer = (Answer.DateTimeAnswer) answer;
            if (dateTimeAnswer.getDate() > 0) {
                j = dateTimeAnswer.getDate();
                MaterialDatePicker<Long> build = titleText.setSelection(Long.valueOf(j)).build();
                Intrinsics.checkNotNullExpressionValue(build, "datePicker()\n        .se…conds())\n        .build()");
                build.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener(function1) {
                    public final /* synthetic */ Function1 f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onPositiveButtonClick(Object obj) {
                        DatePickerQuestionKt.m5320showDatePicker$lambda3(Answer.this, this.f$1, (Long) obj);
                    }
                });
                build.show(appCompatActivity.getSupportFragmentManager(), build.toString());
            }
        }
        j = MaterialDatePicker.todayInUtcMilliseconds();
        MaterialDatePicker<Long> build2 = titleText.setSelection(Long.valueOf(j)).build();
        Intrinsics.checkNotNullExpressionValue(build2, "datePicker()\n        .se…conds())\n        .build()");
        build2.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener(function1) {
            public final /* synthetic */ Function1 f$1;

            {
                this.f$1 = r2;
            }

            public final void onPositiveButtonClick(Object obj) {
                DatePickerQuestionKt.m5320showDatePicker$lambda3(Answer.this, this.f$1, (Long) obj);
            }
        });
        build2.show(appCompatActivity.getSupportFragmentManager(), build2.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: showDatePicker$lambda-3  reason: not valid java name */
    public static final void m5320showDatePicker$lambda3(Answer answer, Function1 function1, Long l) {
        Answer.DateTimeAnswer dateTimeAnswer;
        Intrinsics.checkNotNullParameter(answer, "$answer");
        Intrinsics.checkNotNullParameter(function1, "$onAnswer");
        if (answer instanceof Answer.DateTimeAnswer) {
            Intrinsics.checkNotNullExpressionValue(l, "it");
            dateTimeAnswer = Answer.DateTimeAnswer.copy$default((Answer.DateTimeAnswer) answer, l.longValue(), 0, 0, 6, (Object) null);
        } else {
            long currentTimeMillis = Injector.get().getTimeProvider().currentTimeMillis();
            List<String> utcTime = getUtcTime(TimeFormatter.getHour(currentTimeMillis), TimeFormatter.getMinute(currentTimeMillis));
            Intrinsics.checkNotNullExpressionValue(l, "it");
            dateTimeAnswer = new Answer.DateTimeAnswer(l.longValue(), Integer.parseInt(utcTime.get(0)), Integer.parseInt(utcTime.get(1)));
        }
        function1.invoke(dateTimeAnswer);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x021b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TimePicker(androidx.compose.ui.Modifier r30, io.intercom.android.sdk.survey.ui.models.Answer r31, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.survey.ui.models.Answer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34) {
        /*
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r34
            r4 = 1270472949(0x4bb9e0f5, float:2.4363498E7)
            r5 = r33
            androidx.compose.runtime.Composer r4 = r5.startRestartGroup(r4)
            r5 = r3 & 14
            if (r5 != 0) goto L_0x0020
            boolean r5 = r4.changed((java.lang.Object) r0)
            if (r5 == 0) goto L_0x001d
            r5 = 4
            goto L_0x001e
        L_0x001d:
            r5 = 2
        L_0x001e:
            r5 = r5 | r3
            goto L_0x0021
        L_0x0020:
            r5 = r3
        L_0x0021:
            r6 = r3 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0031
            boolean r6 = r4.changed((java.lang.Object) r1)
            if (r6 == 0) goto L_0x002e
            r6 = 32
            goto L_0x0030
        L_0x002e:
            r6 = 16
        L_0x0030:
            r5 = r5 | r6
        L_0x0031:
            r6 = r3 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0041
            boolean r6 = r4.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x003e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0040
        L_0x003e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0040:
            r5 = r5 | r6
        L_0x0041:
            r5 = r5 & 731(0x2db, float:1.024E-42)
            r6 = 146(0x92, float:2.05E-43)
            if (r5 != r6) goto L_0x0053
            boolean r5 = r4.getSkipping()
            if (r5 != 0) goto L_0x004e
            goto L_0x0053
        L_0x004e:
            r4.skipToGroupEnd()
            goto L_0x029d
        L_0x0053:
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r5 = r4.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            android.content.Context r5 = (android.content.Context) r5
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r9 = r4.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.focus.FocusManager r9 = (androidx.compose.ui.focus.FocusManager) r9
            java.lang.String r10 = "HH:MM"
            boolean r11 = r1 instanceof io.intercom.android.sdk.survey.ui.models.Answer.DateTimeAnswer
            r12 = 1
            if (r11 == 0) goto L_0x0099
            r11 = r1
            io.intercom.android.sdk.survey.ui.models.Answer$DateTimeAnswer r11 = (io.intercom.android.sdk.survey.ui.models.Answer.DateTimeAnswer) r11
            java.lang.String r13 = r11.getLocalTime()
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r13 = kotlin.text.StringsKt.isBlank(r13)
            r13 = r13 ^ r12
            if (r13 == 0) goto L_0x0099
            java.lang.String r11 = r11.getLocalTime()
            r14 = r11
            goto L_0x009a
        L_0x0099:
            r14 = r10
        L_0x009a:
            float r11 = (float) r12
            float r11 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r11)
            androidx.compose.material.MaterialTheme r12 = androidx.compose.material.MaterialTheme.INSTANCE
            r15 = 8
            androidx.compose.material.Colors r12 = r12.getColors(r4, r15)
            long r16 = r12.m1213getOnSurface0d7_KjU()
            r18 = 1036831949(0x3dcccccd, float:0.1)
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 14
            r23 = 0
            long r12 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r16, r18, r19, r20, r21, r22, r23)
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r7 = r7.getShapes(r4, r15)
            androidx.compose.foundation.shape.CornerBasedShape r7 = r7.getMedium()
            androidx.compose.ui.graphics.Shape r7 = (androidx.compose.ui.graphics.Shape) r7
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.BorderKt.m182borderxT4_qwU(r0, r11, r12, r7)
            androidx.compose.material.MaterialTheme r11 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r11 = r11.getShapes(r4, r15)
            androidx.compose.foundation.shape.CornerBasedShape r11 = r11.getMedium()
            androidx.compose.ui.graphics.Shape r11 = (androidx.compose.ui.graphics.Shape) r11
            androidx.compose.ui.Modifier r16 = androidx.compose.ui.draw.ClipKt.clip(r7, r11)
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r7 = r7.getColors(r4, r15)
            long r17 = r7.m1218getSurface0d7_KjU()
            r19 = 0
            r20 = 2
            r21 = 0
            androidx.compose.ui.Modifier r22 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r16, r17, r19, r20, r21)
            r23 = 0
            r24 = 0
            r25 = 0
            io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt$TimePicker$1 r7 = new io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt$TimePicker$1
            r7.<init>(r9, r5, r1, r2)
            r26 = r7
            kotlin.jvm.functions.Function0 r26 = (kotlin.jvm.functions.Function0) r26
            r27 = 7
            r28 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r22, r23, r24, r25, r26, r27, r28)
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r7 = r7.getSpaceBetween()
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r7
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r9 = r9.getCenterVertically()
            r11 = 693286680(0x2952b718, float:4.6788176E-14)
            r4.startReplaceableGroup(r11)
            java.lang.String r11 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r11)
            r11 = 54
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r7, r9, r4, r11)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r9)
            java.lang.String r9 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r9)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r9 = r4.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r11 = r4.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r6 = r4.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            androidx.compose.runtime.Applier r12 = r4.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x017c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x017c:
            r4.startReusableNode()
            boolean r12 = r4.getInserting()
            if (r12 == 0) goto L_0x0189
            r4.createNode(r8)
            goto L_0x018c
        L_0x0189:
            r4.useNode()
        L_0x018c:
            r4.disableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m1543constructorimpl(r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r7, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r9, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r11, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r6, r7)
            r4.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r6)
            r13 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)
            r5.invoke(r6, r4, r7)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r5)
            r5 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r4.startReplaceableGroup(r5)
            java.lang.String r5 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            androidx.compose.foundation.layout.RowScopeInstance r5 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r5 = (androidx.compose.foundation.layout.RowScope) r5
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r6 = 16
            float r6 = (float) r6
            float r7 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r5, r7)
            r7 = 3
            r8 = 0
            androidx.compose.ui.Modifier r24 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r5, r8, r13, r7, r8)
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r5 = r5.getTypography(r4, r15)
            androidx.compose.ui.text.TextStyle r25 = r5.getBody2()
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r5 = r5.getColors(r4, r15)
            long r16 = r5.m1213getOnSurface0d7_KjU()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r10)
            if (r5 == 0) goto L_0x021b
            r5 = 1868671317(0x6f61a955, float:6.9838837E28)
            r4.startReplaceableGroup(r5)
            androidx.compose.material.ContentAlpha r5 = androidx.compose.material.ContentAlpha.INSTANCE
            float r5 = r5.getMedium(r4, r15)
            goto L_0x0227
        L_0x021b:
            r5 = 1868671342(0x6f61a96e, float:6.9838955E28)
            r4.startReplaceableGroup(r5)
            androidx.compose.material.ContentAlpha r5 = androidx.compose.material.ContentAlpha.INSTANCE
            float r5 = r5.getHigh(r4, r15)
        L_0x0227:
            r4.endReplaceableGroup()
            r18 = r5
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 14
            r23 = 0
            long r7 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r16, r18, r19, r20, r21, r22, r23)
            r9 = 0
            r11 = 0
            r12 = 0
            r5 = 0
            r13 = r5
            r16 = 0
            r5 = r14
            r14 = r16
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r26 = 48
            r27 = 0
            r28 = 32760(0x7ff8, float:4.5907E-41)
            r29 = r6
            r6 = r24
            r24 = r25
            r25 = r4
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r5, r6, r7, r9, r11, r12, r13, r14, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            int r5 = io.intercom.android.sdk.R.drawable.intercom_ic_pick_time
            r6 = 0
            androidx.compose.ui.graphics.painter.Painter r5 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r5, r4, r6)
            int r7 = io.intercom.android.sdk.R.string.intercom_choose_the_date
            java.lang.String r6 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r7, r4, r6)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            float r8 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r29)
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r7, r8)
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            r9 = 8
            androidx.compose.material.Colors r8 = r8.getColors(r4, r9)
            long r8 = r8.m1214getPrimary0d7_KjU()
            r11 = 392(0x188, float:5.5E-43)
            r12 = 0
            r10 = r4
            androidx.compose.material.IconKt.m1313Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r5, (java.lang.String) r6, (androidx.compose.ui.Modifier) r7, (long) r8, (androidx.compose.runtime.Composer) r10, (int) r11, (int) r12)
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
        L_0x029d:
            androidx.compose.runtime.ScopeUpdateScope r4 = r4.endRestartGroup()
            if (r4 != 0) goto L_0x02a4
            goto L_0x02ae
        L_0x02a4:
            io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt$TimePicker$3 r5 = new io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt$TimePicker$3
            r5.<init>(r0, r1, r2, r3)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r4.updateScope(r5)
        L_0x02ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt.TimePicker(androidx.compose.ui.Modifier, io.intercom.android.sdk.survey.ui.models.Answer, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final void showTimePicker(AppCompatActivity appCompatActivity, Answer answer, Function1<? super Answer, Unit> function1) {
        Collection arrayList = new ArrayList();
        for (String intOrNull : getLocalTime(answer)) {
            Integer intOrNull2 = StringsKt.toIntOrNull(intOrNull);
            if (intOrNull2 != null) {
                arrayList.add(intOrNull2);
            }
        }
        List list = (List) arrayList;
        MaterialTimePicker build = new MaterialTimePicker.Builder().setTheme(R.style.Intercom_TimePicker).setTitleText((CharSequence) "Select time").setTimeFormat(1).setHour(((Number) (CollectionsKt.getLastIndex(list) >= 0 ? list.get(0) : 0)).intValue()).setMinute(((Number) (1 <= CollectionsKt.getLastIndex(list) ? list.get(1) : 0)).intValue()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .setTh…) { 0 })\n        .build()");
        build.addOnPositiveButtonClickListener(new View.OnClickListener(answer, function1) {
            public final /* synthetic */ Answer f$1;
            public final /* synthetic */ Function1 f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                DatePickerQuestionKt.m5321showTimePicker$lambda8(MaterialTimePicker.this, this.f$1, this.f$2, view);
            }
        });
        build.show(appCompatActivity.getSupportFragmentManager(), build.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: showTimePicker$lambda-8  reason: not valid java name */
    public static final void m5321showTimePicker$lambda8(MaterialTimePicker materialTimePicker, Answer answer, Function1 function1, View view) {
        Answer.DateTimeAnswer dateTimeAnswer;
        Intrinsics.checkNotNullParameter(materialTimePicker, "$picker");
        Intrinsics.checkNotNullParameter(answer, "$answer");
        Intrinsics.checkNotNullParameter(function1, "$onAnswer");
        List<String> utcTime = getUtcTime(materialTimePicker.getHour(), materialTimePicker.getMinute());
        if (answer instanceof Answer.DateTimeAnswer) {
            dateTimeAnswer = Answer.DateTimeAnswer.copy$default((Answer.DateTimeAnswer) answer, 0, Integer.parseInt(utcTime.get(0)), Integer.parseInt(utcTime.get(1)), 1, (Object) null);
        } else {
            dateTimeAnswer = new Answer.DateTimeAnswer(-1, Integer.parseInt(utcTime.get(0)), Integer.parseInt(utcTime.get(1)));
        }
        function1.invoke(dateTimeAnswer);
    }

    private static final List<String> getUtcTime(int i, int i2) {
        String formatToUtcTime = TimeFormatter.formatToUtcTime(i, i2);
        Intrinsics.checkNotNullExpressionValue(formatToUtcTime, "formatToUtcTime(hour, minute)");
        return StringsKt.split$default((CharSequence) formatToUtcTime, new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null);
    }

    private static final List<String> getLocalTime(Answer answer) {
        if (answer instanceof Answer.DateTimeAnswer) {
            return StringsKt.split$default((CharSequence) ((Answer.DateTimeAnswer) answer).getLocalTime(), new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null);
        }
        return CollectionsKt.emptyList();
    }

    /* access modifiers changed from: private */
    public static final void DatePickerQuestionPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1652233850);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$DatePickerQuestionKt.INSTANCE.m5318getLambda3$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DatePickerQuestionKt$DatePickerQuestionPreview$1(i));
        }
    }
}
