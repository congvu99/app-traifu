package io.intercom.android.sdk.survey.ui.components;

import android.content.Context;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.imageutils.JfifUtil;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.survey.ProgressBarState;
import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.survey.SurveyState;
import io.intercom.android.sdk.survey.SurveyUiColors;
import io.intercom.android.sdk.survey.SurveyViewModelKt;
import io.intercom.android.sdk.survey.TopBarState;
import io.intercom.android.sdk.survey.model.SurveyCustomization;
import io.intercom.android.sdk.survey.model.SurveyData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a]\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0007H\u0001¢\u0006\u0002\u0010\u000e\u001aK\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00102\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0007H\u0001¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0013"}, d2 = {"SimpleSurvey", "", "(Landroidx/compose/runtime/Composer;I)V", "SurveyComponent", "state", "Lio/intercom/android/sdk/survey/SurveyState;", "onContinue", "Lkotlin/Function1;", "Lkotlinx/coroutines/CoroutineScope;", "onClose", "Lkotlin/Function0;", "onAnswerUpdated", "onSecondaryCtaClicked", "Lio/intercom/android/sdk/survey/SurveyState$Content$SecondaryCta;", "(Lio/intercom/android/sdk/survey/SurveyState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SurveyContent", "Lio/intercom/android/sdk/survey/SurveyState$Content;", "(Lio/intercom/android/sdk/survey/SurveyState$Content;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SurveyErrorState", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyComponent.kt */
public final class SurveyComponentKt {
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SurveyComponent(io.intercom.android.sdk.survey.SurveyState r39, kotlin.jvm.functions.Function1<? super kotlinx.coroutines.CoroutineScope, kotlin.Unit> r40, kotlin.jvm.functions.Function0<kotlin.Unit> r41, kotlin.jvm.functions.Function0<kotlin.Unit> r42, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.survey.SurveyState.Content.SecondaryCta, kotlin.Unit> r43, androidx.compose.runtime.Composer r44, int r45, int r46) {
        /*
            r6 = r39
            r7 = r40
            r8 = r41
            r9 = r45
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "onContinue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "onClose"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 675467263(0x2842cfff, float:1.0814265E-14)
            r1 = r44
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            r0 = r46 & 1
            r1 = 4
            r2 = 2
            if (r0 == 0) goto L_0x0029
            r0 = r9 | 6
            goto L_0x0039
        L_0x0029:
            r0 = r9 & 14
            if (r0 != 0) goto L_0x0038
            boolean r0 = r5.changed((java.lang.Object) r6)
            if (r0 == 0) goto L_0x0035
            r0 = 4
            goto L_0x0036
        L_0x0035:
            r0 = 2
        L_0x0036:
            r0 = r0 | r9
            goto L_0x0039
        L_0x0038:
            r0 = r9
        L_0x0039:
            r3 = r46 & 2
            if (r3 == 0) goto L_0x0040
            r0 = r0 | 48
            goto L_0x0050
        L_0x0040:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0050
            boolean r3 = r5.changed((java.lang.Object) r7)
            if (r3 == 0) goto L_0x004d
            r3 = 32
            goto L_0x004f
        L_0x004d:
            r3 = 16
        L_0x004f:
            r0 = r0 | r3
        L_0x0050:
            r3 = r46 & 4
            if (r3 == 0) goto L_0x0057
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0057:
            r3 = r9 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0067
            boolean r3 = r5.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0064
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r3
        L_0x0067:
            r3 = r46 & 8
            if (r3 == 0) goto L_0x006e
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r4 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0081
            r4 = r42
            boolean r10 = r5.changed((java.lang.Object) r4)
            if (r10 == 0) goto L_0x007d
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r0 = r0 | r10
            goto L_0x0083
        L_0x0081:
            r4 = r42
        L_0x0083:
            r10 = r46 & 16
            if (r10 == 0) goto L_0x008a
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008a:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r9
            if (r11 != 0) goto L_0x009f
            r11 = r43
            boolean r12 = r5.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x009b
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r0 = r0 | r12
            goto L_0x00a1
        L_0x009f:
            r11 = r43
        L_0x00a1:
            r12 = 46811(0xb6db, float:6.5596E-41)
            r12 = r12 & r0
            r13 = 9362(0x2492, float:1.3119E-41)
            if (r12 != r13) goto L_0x00b7
            boolean r12 = r5.getSkipping()
            if (r12 != 0) goto L_0x00b0
            goto L_0x00b7
        L_0x00b0:
            r5.skipToGroupEnd()
            r0 = r5
            r5 = r11
            goto L_0x02d8
        L_0x00b7:
            if (r3 == 0) goto L_0x00c0
            io.intercom.android.sdk.survey.ui.components.SurveyComponentKt$SurveyComponent$1 r3 = io.intercom.android.sdk.survey.ui.components.SurveyComponentKt$SurveyComponent$1.INSTANCE
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r37 = r3
            goto L_0x00c2
        L_0x00c0:
            r37 = r4
        L_0x00c2:
            if (r10 == 0) goto L_0x00cb
            io.intercom.android.sdk.survey.ui.components.SurveyComponentKt$SurveyComponent$2 r3 = io.intercom.android.sdk.survey.ui.components.SurveyComponentKt$SurveyComponent$2.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r38 = r3
            goto L_0x00cd
        L_0x00cb:
            r38 = r11
        L_0x00cd:
            io.intercom.android.sdk.survey.SurveyUiColors r3 = r39.getSurveyUiColors()
            long r3 = r3.m5273getBackground0d7_KjU()
            boolean r3 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5401isDarkColor8_81llA(r3)
            r4 = 3
            r10 = 0
            r15 = 1
            if (r3 == 0) goto L_0x0125
            androidx.compose.ui.graphics.Color[] r1 = new androidx.compose.ui.graphics.Color[r1]
            io.intercom.android.sdk.survey.SurveyUiColors r3 = r39.getSurveyUiColors()
            long r11 = r3.m5273getBackground0d7_KjU()
            long r11 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5395darken8_81llA(r11)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m1922boximpl(r11)
            r1[r10] = r3
            io.intercom.android.sdk.survey.SurveyUiColors r3 = r39.getSurveyUiColors()
            long r11 = r3.m5273getBackground0d7_KjU()
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m1922boximpl(r11)
            r1[r15] = r3
            io.intercom.android.sdk.survey.SurveyUiColors r3 = r39.getSurveyUiColors()
            long r11 = r3.m5273getBackground0d7_KjU()
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m1922boximpl(r11)
            r1[r2] = r3
            io.intercom.android.sdk.survey.SurveyUiColors r2 = r39.getSurveyUiColors()
            long r2 = r2.m5273getBackground0d7_KjU()
            long r2 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5395darken8_81llA(r2)
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m1922boximpl(r2)
            r1[r4] = r2
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r1)
            goto L_0x016b
        L_0x0125:
            androidx.compose.ui.graphics.Color[] r1 = new androidx.compose.ui.graphics.Color[r1]
            io.intercom.android.sdk.survey.SurveyUiColors r3 = r39.getSurveyUiColors()
            long r11 = r3.m5273getBackground0d7_KjU()
            long r11 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5404lighten8_81llA(r11)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m1922boximpl(r11)
            r1[r10] = r3
            io.intercom.android.sdk.survey.SurveyUiColors r3 = r39.getSurveyUiColors()
            long r11 = r3.m5273getBackground0d7_KjU()
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m1922boximpl(r11)
            r1[r15] = r3
            io.intercom.android.sdk.survey.SurveyUiColors r3 = r39.getSurveyUiColors()
            long r11 = r3.m5273getBackground0d7_KjU()
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m1922boximpl(r11)
            r1[r2] = r3
            io.intercom.android.sdk.survey.SurveyUiColors r2 = r39.getSurveyUiColors()
            long r2 = r2.m5273getBackground0d7_KjU()
            long r2 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5404lighten8_81llA(r2)
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m1922boximpl(r2)
            r1[r4] = r2
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r1)
        L_0x016b:
            r17 = r1
            androidx.compose.ui.graphics.Brush$Companion r16 = androidx.compose.ui.graphics.Brush.Companion
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 14
            r22 = 0
            androidx.compose.ui.graphics.Brush r24 = androidx.compose.ui.graphics.Brush.Companion.m1878verticalGradient8A3gB4$default((androidx.compose.ui.graphics.Brush.Companion) r16, (java.util.List) r17, (float) r18, (float) r19, (int) r20, (int) r21, (java.lang.Object) r22)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r23 = r1
            androidx.compose.ui.Modifier r23 = (androidx.compose.ui.Modifier) r23
            r25 = 0
            r26 = 0
            r27 = 6
            r28 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BackgroundKt.background$default(r23, r24, r25, r26, r27, r28)
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r5.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r10, r5, r10)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r11 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r11)
            java.lang.Object r3 = r5.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r11)
            java.lang.Object r12 = r5.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r4, r11)
            java.lang.Object r4 = r5.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r13 = r5.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x01ff
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01ff:
            r5.startReusableNode()
            boolean r13 = r5.getInserting()
            if (r13 == 0) goto L_0x020c
            r5.createNode(r11)
            goto L_0x020f
        L_0x020c:
            r5.useNode()
        L_0x020f:
            r5.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m1543constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r2, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r3, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r12, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r4, r2)
            r5.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            r1.invoke(r2, r5, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r1)
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r5.startReplaceableGroup(r1)
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r28 = r1.m1967getTransparent0d7_KjU()
            r10 = 0
            r11 = 0
            r1 = -2063045238(0xffffffff85086d8a, float:-6.4148084E-36)
            io.intercom.android.sdk.survey.ui.components.SurveyComponentKt$SurveyComponent$3$1 r2 = new io.intercom.android.sdk.survey.ui.components.SurveyComponentKt$SurveyComponent$3$1
            r2.<init>(r6, r8, r0)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r1, r15, r2)
            r12 = r1
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = 0
            r14 = 0
            r1 = 0
            r4 = 1
            r15 = r1
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r26 = 0
            r30 = 0
            r3 = 1719008579(0x6675fd43, float:2.9041291E23)
            io.intercom.android.sdk.survey.ui.components.SurveyComponentKt$SurveyComponent$3$2 r2 = new io.intercom.android.sdk.survey.ui.components.SurveyComponentKt$SurveyComponent$3$2
            r32 = r0
            r0 = r2
            r1 = r39
            r10 = r2
            r2 = r40
            r11 = 1719008579(0x6675fd43, float:2.9041291E23)
            r3 = r37
            r13 = 1
            r4 = r38
            r14 = r5
            r5 = r32
            r0.<init>(r1, r2, r3, r4, r5)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r11, r13, r10)
            r32 = r0
            kotlin.jvm.functions.Function3 r32 = (kotlin.jvm.functions.Function3) r32
            r34 = 384(0x180, float:5.38E-43)
            r35 = 12779520(0xc30000, float:1.7907922E-38)
            r36 = 98299(0x17ffb, float:1.37746E-40)
            r33 = r14
            r0 = r14
            r10 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            androidx.compose.material.ScaffoldKt.m1388Scaffold27mzLpw(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r24, r26, r28, r30, r32, r33, r34, r35, r36)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r4 = r37
            r5 = r38
        L_0x02d8:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x02df
            goto L_0x02f4
        L_0x02df:
            io.intercom.android.sdk.survey.ui.components.SurveyComponentKt$SurveyComponent$4 r11 = new io.intercom.android.sdk.survey.ui.components.SurveyComponentKt$SurveyComponent$4
            r0 = r11
            r1 = r39
            r2 = r40
            r3 = r41
            r6 = r45
            r7 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x02f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.components.SurveyComponentKt.SurveyComponent(io.intercom.android.sdk.survey.SurveyState, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void SurveyContent(SurveyState.Content content, Function1<? super CoroutineScope, Unit> function1, Function0<Unit> function0, Function1<? super SurveyState.Content.SecondaryCta, Unit> function12, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(content, "state");
        Intrinsics.checkNotNullParameter(function1, "onContinue");
        Intrinsics.checkNotNullParameter(function0, "onAnswerUpdated");
        Intrinsics.checkNotNullParameter(function12, "onSecondaryCtaClicked");
        Composer startRestartGroup = composer.startRestartGroup(-1878196783);
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
            startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        startRestartGroup.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
        SurveyComponentKt$SurveyContent$1 surveyComponentKt$SurveyContent$1 = r1;
        SurveyComponentKt$SurveyContent$1 surveyComponentKt$SurveyContent$12 = new SurveyComponentKt$SurveyContent$1(content, function12, i, function0, function1, coroutineScope);
        BoxWithConstraintsKt.BoxWithConstraints(fillMaxSize$default, (Alignment) null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 1819157543, true, surveyComponentKt$SurveyContent$1), startRestartGroup, 3078, 6);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SurveyComponentKt$SurveyContent$2(content, function1, function0, function12, i));
        }
    }

    public static final void SimpleSurvey(Composer composer, int i) {
        int i2 = i;
        Composer startRestartGroup = composer.startRestartGroup(126014647);
        if (i2 != 0 || !startRestartGroup.getSkipping()) {
            SurveyUiColors surveyUiColors = SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null));
            Avatar create = Avatar.create("", "AD");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AppConfig appConfig = new AppConfig((Context) consume);
            ProgressBarState progressBarState = new ProgressBarState(true, 0.5f);
            Intrinsics.checkNotNullExpressionValue(create, "create(\"\", \"AD\")");
            TopBarState.SenderTopBarState senderTopBarState = new TopBarState.SenderTopBarState(create, "Andy", appConfig, true, surveyUiColors, progressBarState);
            List listOf = CollectionsKt.listOf(new Block.Builder().withText("<b>Step 1</b>").withType(BlockType.HEADING.getSerializedName()), new Block.Builder().withText("Get tailored discounts to your inbox").withType(BlockType.PARAGRAPH.getSerializedName()));
            QuestionState[] questionStateArr = new QuestionState[3];
            String uuid = UUID.randomUUID().toString();
            List listOf2 = CollectionsKt.listOf(new Block.Builder().withText("Is this a preview?"));
            SurveyData.Step.Question.QuestionValidation.ValidationType validationType = SurveyData.Step.Question.QuestionValidation.ValidationType.NO_VALIDATION;
            Intrinsics.checkNotNullExpressionValue(uuid, "toString()");
            questionStateArr[0] = new QuestionState(new SurveyData.Step.Question.ShortTextQuestionModel(uuid, listOf2, true, "Let us know", validationType, Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION), false, (Integer) null, JfifUtil.MARKER_SOFn, (DefaultConstructorMarker) null), surveyUiColors);
            String uuid2 = UUID.randomUUID().toString();
            List listOf3 = CollectionsKt.listOf(new Block.Builder().withText("Question Title"));
            List listOf4 = CollectionsKt.listOf("Option A", "Option B", "Option C", "Option D");
            Intrinsics.checkNotNullExpressionValue(uuid2, "toString()");
            questionStateArr[1] = new QuestionState(new SurveyData.Step.Question.SingleChoiceQuestionModel(uuid2, listOf3, true, listOf4, false), SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)));
            String uuid3 = UUID.randomUUID().toString();
            List listOf5 = CollectionsKt.listOf(new Block.Builder().withText("How would your rate your experience?"));
            SurveyData.Step.Question.QuestionData.QuestionSubType questionSubType = SurveyData.Step.Question.QuestionData.QuestionSubType.STARS;
            Iterable intRange = new IntRange(1, 5);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator it = intRange.iterator();
            while (it.hasNext()) {
                arrayList.add(new SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.NumericRatingOption(((IntIterator) it).nextInt()));
            }
            Intrinsics.checkNotNullExpressionValue(uuid3, "toString()");
            questionStateArr[2] = new QuestionState(new SurveyData.Step.Question.NumericRatingQuestionModel(uuid3, listOf5, true, (List) arrayList, "Poor", "Excellent", 1, 5, questionSubType), surveyUiColors);
            SurveyComponent(new SurveyState.Content(listOf, CollectionsKt.listOf(questionStateArr), CollectionsKt.emptyList(), new SurveyState.Content.PrimaryCta.Fallback(R.string.intercom_surveys_next_button), surveyUiColors, senderTopBarState), SurveyComponentKt$SimpleSurvey$2.INSTANCE, SurveyComponentKt$SimpleSurvey$3.INSTANCE, SurveyComponentKt$SimpleSurvey$4.INSTANCE, (Function1<? super SurveyState.Content.SecondaryCta, Unit>) null, startRestartGroup, 3512, 16);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SurveyComponentKt$SimpleSurvey$5(i2));
        }
    }

    public static final void SurveyErrorState(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1165269984);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            Avatar create = Avatar.create("", "AD");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AppConfig appConfig = new AppConfig((Context) consume);
            SurveyUiColors surveyUiColors = SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null));
            Intrinsics.checkNotNullExpressionValue(create, "create(\"\", \"AD\")");
            SurveyComponent(new SurveyState.Error.WithCTA(0, SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)), new TopBarState.SenderTopBarState(create, "Andy", appConfig, true, surveyUiColors, (ProgressBarState) null, 32, (DefaultConstructorMarker) null), SurveyComponentKt$SurveyErrorState$1.INSTANCE, 1, (DefaultConstructorMarker) null), SurveyComponentKt$SurveyErrorState$2.INSTANCE, SurveyComponentKt$SurveyErrorState$3.INSTANCE, SurveyComponentKt$SurveyErrorState$4.INSTANCE, (Function1<? super SurveyState.Content.SecondaryCta, Unit>) null, startRestartGroup, 3504, 16);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SurveyComponentKt$SurveyErrorState$5(i));
        }
    }
}
