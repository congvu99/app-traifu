package io.intercom.android.sdk.survey.ui.questiontype.choice;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\rH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"OtherOption", "", "selected", "", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "text", "", "onClicked", "Lkotlin/Function0;", "onTextChanged", "Lkotlin/Function1;", "strokeColor", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "Landroidx/compose/ui/unit/Dp;", "backgroundColor", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontColor", "OtherOption-YCJL08c", "(ZLio/intercom/android/sdk/survey/SurveyUiColors;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;JFJLandroidx/compose/ui/text/font/FontWeight;JLandroidx/compose/runtime/Composer;II)V", "OtherOptionPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: OtherOption.kt */
public final class OtherOptionKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x012d  */
    /* renamed from: OtherOption-YCJL08c  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5332OtherOptionYCJL08c(boolean r33, io.intercom.android.sdk.survey.SurveyUiColors r34, java.lang.String r35, kotlin.jvm.functions.Function0<kotlin.Unit> r36, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r37, long r38, float r40, long r41, androidx.compose.ui.text.font.FontWeight r43, long r44, androidx.compose.runtime.Composer r46, int r47, int r48) {
        /*
            r2 = r34
            r3 = r35
            r4 = r36
            r5 = r37
            r14 = r47
            r15 = r48
            java.lang.String r0 = "surveyUiColors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onClicked"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "onTextChanged"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = -933969743(0xffffffffc854c0b1, float:-217858.77)
            r1 = r46
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x0033
            r1 = r14 | 6
            r6 = r1
            r1 = r33
            goto L_0x0047
        L_0x0033:
            r1 = r14 & 14
            if (r1 != 0) goto L_0x0044
            r1 = r33
            boolean r6 = r0.changed((boolean) r1)
            if (r6 == 0) goto L_0x0041
            r6 = 4
            goto L_0x0042
        L_0x0041:
            r6 = 2
        L_0x0042:
            r6 = r6 | r14
            goto L_0x0047
        L_0x0044:
            r1 = r33
            r6 = r14
        L_0x0047:
            r7 = r15 & 2
            if (r7 == 0) goto L_0x004e
            r6 = r6 | 48
            goto L_0x005e
        L_0x004e:
            r7 = r14 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x005e
            boolean r7 = r0.changed((java.lang.Object) r2)
            if (r7 == 0) goto L_0x005b
            r7 = 32
            goto L_0x005d
        L_0x005b:
            r7 = 16
        L_0x005d:
            r6 = r6 | r7
        L_0x005e:
            r7 = r15 & 4
            if (r7 == 0) goto L_0x0065
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x0075
        L_0x0065:
            r7 = r14 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0075
            boolean r7 = r0.changed((java.lang.Object) r3)
            if (r7 == 0) goto L_0x0072
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0074
        L_0x0072:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0074:
            r6 = r6 | r7
        L_0x0075:
            r7 = r15 & 8
            if (r7 == 0) goto L_0x007c
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            goto L_0x008c
        L_0x007c:
            r7 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008c
            boolean r7 = r0.changed((java.lang.Object) r4)
            if (r7 == 0) goto L_0x0089
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x008b
        L_0x0089:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x008b:
            r6 = r6 | r7
        L_0x008c:
            r7 = r15 & 16
            r8 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x0096
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a6
        L_0x0096:
            r7 = r14 & r8
            if (r7 != 0) goto L_0x00a6
            boolean r7 = r0.changed((java.lang.Object) r5)
            if (r7 == 0) goto L_0x00a3
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r6 = r6 | r7
        L_0x00a6:
            r7 = r15 & 32
            r9 = 458752(0x70000, float:6.42848E-40)
            if (r7 == 0) goto L_0x00b0
            r10 = 196608(0x30000, float:2.75506E-40)
            r6 = r6 | r10
            goto L_0x00c3
        L_0x00b0:
            r10 = r14 & r9
            if (r10 != 0) goto L_0x00c3
            r10 = r38
            boolean r12 = r0.changed((long) r10)
            if (r12 == 0) goto L_0x00bf
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r6 = r6 | r12
            goto L_0x00c5
        L_0x00c3:
            r10 = r38
        L_0x00c5:
            r12 = r15 & 64
            r13 = 3670016(0x380000, float:5.142788E-39)
            if (r12 == 0) goto L_0x00d2
            r16 = 1572864(0x180000, float:2.204052E-39)
            r6 = r6 | r16
            r13 = r40
            goto L_0x00e5
        L_0x00d2:
            r16 = r14 & r13
            r13 = r40
            if (r16 != 0) goto L_0x00e5
            boolean r16 = r0.changed((float) r13)
            if (r16 == 0) goto L_0x00e1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e3
        L_0x00e1:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e3:
            r6 = r6 | r16
        L_0x00e5:
            r9 = r15 & 128(0x80, float:1.794E-43)
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            if (r9 == 0) goto L_0x00f4
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r6 = r6 | r18
            r19 = r9
            r8 = r41
            goto L_0x0109
        L_0x00f4:
            r18 = r14 & r17
            r19 = r9
            r8 = r41
            if (r18 != 0) goto L_0x0109
            boolean r20 = r0.changed((long) r8)
            if (r20 == 0) goto L_0x0105
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r6 = r6 | r20
        L_0x0109:
            r1 = r15 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0114
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            r6 = r6 | r20
            r8 = r43
            goto L_0x0128
        L_0x0114:
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            r20 = r14 & r20
            r8 = r43
            if (r20 != 0) goto L_0x0128
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0125
            r9 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0127
        L_0x0125:
            r9 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0127:
            r6 = r6 | r9
        L_0x0128:
            r9 = 1879048192(0x70000000, float:1.58456325E29)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x0143
            r9 = r15 & 512(0x200, float:7.175E-43)
            if (r9 != 0) goto L_0x013c
            r8 = r44
            boolean r20 = r0.changed((long) r8)
            if (r20 == 0) goto L_0x013e
            r20 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0140
        L_0x013c:
            r8 = r44
        L_0x013e:
            r20 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0140:
            r6 = r6 | r20
            goto L_0x0145
        L_0x0143:
            r8 = r44
        L_0x0145:
            r20 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r6 & r20
            r9 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r9) goto L_0x0166
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x0156
            goto L_0x0166
        L_0x0156:
            r0.skipToGroupEnd()
            r15 = r43
            r30 = r44
            r9 = r2
            r14 = r5
            r6 = r10
            r8 = r13
            r11 = r41
            r13 = r3
            goto L_0x0364
        L_0x0166:
            r0.startDefaults()
            r8 = r14 & 1
            r9 = 1
            if (r8 == 0) goto L_0x0189
            boolean r8 = r0.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0175
            goto L_0x0189
        L_0x0175:
            r0.skipToGroupEnd()
            r1 = r15 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0180
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r6 = r6 & r1
        L_0x0180:
            r1 = r43
            r30 = r44
            r7 = r10
            r10 = r13
            r11 = r41
            goto L_0x01c3
        L_0x0189:
            if (r7 == 0) goto L_0x0192
            androidx.compose.ui.graphics.Color$Companion r7 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r7.m1958getBlack0d7_KjU()
            goto L_0x0193
        L_0x0192:
            r7 = r10
        L_0x0193:
            if (r12 == 0) goto L_0x019b
            float r10 = (float) r9
            float r10 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r10)
            goto L_0x019c
        L_0x019b:
            r10 = r13
        L_0x019c:
            if (r19 == 0) goto L_0x01a5
            androidx.compose.ui.graphics.Color$Companion r11 = androidx.compose.ui.graphics.Color.Companion
            long r11 = r11.m1969getWhite0d7_KjU()
            goto L_0x01a7
        L_0x01a5:
            r11 = r41
        L_0x01a7:
            if (r1 == 0) goto L_0x01b0
            androidx.compose.ui.text.font.FontWeight$Companion r1 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r1 = r1.getNormal()
            goto L_0x01b2
        L_0x01b0:
            r1 = r43
        L_0x01b2:
            r13 = r15 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x01c1
            long r21 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5396generateTextColor8_81llA(r11)
            r13 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r6 = r6 & r13
            r30 = r21
            goto L_0x01c3
        L_0x01c1:
            r30 = r44
        L_0x01c3:
            r0.endDefaults()
            r13 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r13)
            java.lang.String r13 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            androidx.compose.foundation.layout.Arrangement r19 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r9 = r19.getTop()
            androidx.compose.ui.Alignment$Companion r19 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r14 = r19.getStart()
            r15 = 0
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r9, r14, r0, r15)
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r14)
            java.lang.String r14 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r2)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r3 = r19
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r2)
            java.lang.Object r3 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r5 = r19
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r2)
            java.lang.Object r2 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r13 = androidx.compose.ui.layout.LayoutKt.materializerOf(r13)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x0245
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0245:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x0252
            r0.createNode(r5)
            goto L_0x0255
        L_0x0252:
            r0.useNode()
        L_0x0255:
            r0.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r9, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r14, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r3, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r2, r3)
            r0.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r2)
            r3 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r13.invoke(r2, r0, r5)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r2 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.foundation.layout.ColumnScopeInstance r2 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r2 = (androidx.compose.foundation.layout.ColumnScope) r2
            int r3 = io.intercom.android.sdk.R.string.intercom_surveys_multiselect_other_option_value
            r5 = 0
            java.lang.String r3 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r3, r0, r5)
            r5 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            boolean r5 = r0.changed((java.lang.Object) r4)
            java.lang.Object r9 = r0.rememberedValue()
            if (r5 != 0) goto L_0x02cc
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r9 != r5) goto L_0x02d7
        L_0x02cc:
            io.intercom.android.sdk.survey.ui.questiontype.choice.OtherOptionKt$OtherOption$1$1$1 r5 = new io.intercom.android.sdk.survey.ui.questiontype.choice.OtherOptionKt$OtherOption$1$1$1
            r5.<init>(r4)
            r9 = r5
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r0.updateRememberedValue(r9)
        L_0x02d7:
            r0.endReplaceableGroup()
            r5 = r9
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r9 = r6 & 14
            int r13 = r6 >> 6
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r14
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r13
            r9 = r9 | r14
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r13
            r9 = r9 | r14
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r13
            r9 = r9 | r14
            r13 = r13 & r17
            r28 = r9 | r13
            r29 = 0
            r16 = r33
            r17 = r5
            r18 = r3
            r19 = r7
            r21 = r10
            r22 = r11
            r24 = r1
            r25 = r30
            r27 = r0
            io.intercom.android.sdk.survey.ui.questiontype.choice.ChoicePillKt.m5322ChoicePillUdaoDFU(r16, r17, r18, r19, r21, r22, r24, r25, r27, r28, r29)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r5 = 8
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r5)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r3, r5)
            r5 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r3, r0, r5)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r3 = -252181085(0xfffffffff0f805a3, float:-6.1407277E29)
            io.intercom.android.sdk.survey.ui.questiontype.choice.OtherOptionKt$OtherOption$1$2 r5 = new io.intercom.android.sdk.survey.ui.questiontype.choice.OtherOptionKt$OtherOption$1$2
            r9 = r34
            r13 = r35
            r14 = r37
            r5.<init>(r9, r13, r14, r6)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r3, r15, r5)
            r22 = r3
            kotlin.jvm.functions.Function3 r22 = (kotlin.jvm.functions.Function3) r22
            r3 = 1572870(0x180006, float:2.20406E-39)
            int r5 = r6 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r24 = r3 | r5
            r25 = 30
            r16 = r2
            r17 = r33
            r23 = r0
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility((androidx.compose.foundation.layout.ColumnScope) r16, (boolean) r17, (androidx.compose.ui.Modifier) r18, (androidx.compose.animation.EnterTransition) r19, (androidx.compose.animation.ExitTransition) r20, (java.lang.String) r21, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r22, (androidx.compose.runtime.Composer) r23, (int) r24, (int) r25)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r15 = r1
            r6 = r7
            r8 = r10
        L_0x0364:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x036b
            goto L_0x0391
        L_0x036b:
            io.intercom.android.sdk.survey.ui.questiontype.choice.OtherOptionKt$OtherOption$2 r16 = new io.intercom.android.sdk.survey.ui.questiontype.choice.OtherOptionKt$OtherOption$2
            r0 = r16
            r1 = r33
            r2 = r34
            r3 = r35
            r4 = r36
            r5 = r37
            r14 = r10
            r9 = r11
            r11 = r15
            r12 = r30
            r15 = r14
            r14 = r47
            r32 = r15
            r15 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r9, r11, r12, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r32
            r1.updateScope(r0)
        L_0x0391:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.choice.OtherOptionKt.m5332OtherOptionYCJL08c(boolean, io.intercom.android.sdk.survey.SurveyUiColors, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, long, float, long, androidx.compose.ui.text.font.FontWeight, long, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void OtherOptionPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-469899921);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            SurfaceKt.m1419SurfaceFjzlyU(PaddingKt.m510padding3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 16)), (Shape) null, 0, 0, (BorderStroke) null, 0.0f, ComposableSingletons$OtherOptionKt.INSTANCE.m5328getLambda1$intercom_sdk_base_release(), startRestartGroup, 1572870, 62);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new OtherOptionKt$OtherOptionPreview$1(i));
        }
    }
}
