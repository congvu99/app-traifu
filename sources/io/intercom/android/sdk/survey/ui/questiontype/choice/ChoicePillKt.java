package io.intercom.android.sdk.survey.ui.questiontype.choice;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.survey.ui.ThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001am\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\tH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0016\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"ChoicePill", "", "selected", "", "onClicked", "Lkotlin/Function1;", "", "text", "strokeColor", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "Landroidx/compose/ui/unit/Dp;", "backgroundColor", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontColor", "ChoicePill-UdaoDFU", "(ZLkotlin/jvm/functions/Function1;Ljava/lang/String;JFJLandroidx/compose/ui/text/font/FontWeight;JLandroidx/compose/runtime/Composer;II)V", "EmptyPill", "(Landroidx/compose/runtime/Composer;I)V", "SelectedPill", "SelectedPillDark", "SelectedPillLongBigText", "SelectedPillLongText", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ChoicePill.kt */
public final class ChoicePillKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x03b7  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0115  */
    /* renamed from: ChoicePill-UdaoDFU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5322ChoicePillUdaoDFU(boolean r37, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r38, java.lang.String r39, long r40, float r42, long r43, androidx.compose.ui.text.font.FontWeight r45, long r46, androidx.compose.runtime.Composer r48, int r49, int r50) {
        /*
            r1 = r37
            r0 = r39
            r9 = r49
            r4 = r50
            java.lang.String r2 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = 418926179(0x18f84e63, float:6.4185648E-24)
            r3 = r48
            androidx.compose.runtime.Composer r5 = r3.startRestartGroup(r2)
            r2 = r4 & 1
            if (r2 == 0) goto L_0x001d
            r2 = r9 | 6
            goto L_0x002d
        L_0x001d:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x002c
            boolean r2 = r5.changed((boolean) r1)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r9
            goto L_0x002d
        L_0x002c:
            r2 = r9
        L_0x002d:
            r3 = r4 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0047
        L_0x0034:
            r7 = r9 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0047
            r7 = r38
            boolean r8 = r5.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0043
            r8 = 32
            goto L_0x0045
        L_0x0043:
            r8 = 16
        L_0x0045:
            r2 = r2 | r8
            goto L_0x0049
        L_0x0047:
            r7 = r38
        L_0x0049:
            r8 = r4 & 4
            if (r8 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x0050:
            r8 = r9 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0060
            boolean r8 = r5.changed((java.lang.Object) r0)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r8
        L_0x0060:
            r8 = r4 & 8
            if (r8 == 0) goto L_0x0067
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r10 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x007a
            r10 = r40
            boolean r12 = r5.changed((long) r10)
            if (r12 == 0) goto L_0x0076
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r2 = r2 | r12
            goto L_0x007c
        L_0x007a:
            r10 = r40
        L_0x007c:
            r12 = r4 & 16
            if (r12 == 0) goto L_0x0083
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0083:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r9
            if (r13 != 0) goto L_0x0098
            r13 = r42
            boolean r14 = r5.changed((float) r13)
            if (r14 == 0) goto L_0x0094
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r2 = r2 | r14
            goto L_0x009a
        L_0x0098:
            r13 = r42
        L_0x009a:
            r14 = r4 & 32
            r22 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00a6
            r15 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r15
            r6 = r43
            goto L_0x00b8
        L_0x00a6:
            r15 = r9 & r22
            r6 = r43
            if (r15 != 0) goto L_0x00b8
            boolean r15 = r5.changed((long) r6)
            if (r15 == 0) goto L_0x00b5
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r2 = r2 | r15
        L_0x00b8:
            r15 = r4 & 64
            if (r15 == 0) goto L_0x00c3
            r16 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r16
            r6 = r45
            goto L_0x00d7
        L_0x00c3:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r9 & r16
            r6 = r45
            if (r16 != 0) goto L_0x00d7
            boolean r7 = r5.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x00d4
            r7 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r7 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r2 = r2 | r7
        L_0x00d7:
            r7 = 29360128(0x1c00000, float:7.052966E-38)
            r7 = r7 & r9
            if (r7 != 0) goto L_0x00f2
            r7 = r4 & 128(0x80, float:1.794E-43)
            if (r7 != 0) goto L_0x00eb
            r6 = r46
            boolean r16 = r5.changed((long) r6)
            if (r16 == 0) goto L_0x00ed
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00eb:
            r6 = r46
        L_0x00ed:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r2 = r2 | r16
            goto L_0x00f4
        L_0x00f2:
            r6 = r46
        L_0x00f4:
            r16 = 23967451(0x16db6db, float:4.3661218E-38)
            r6 = r2 & r16
            r7 = 4793490(0x492492, float:6.71711E-39)
            if (r6 != r7) goto L_0x0115
            boolean r6 = r5.getSkipping()
            if (r6 != 0) goto L_0x0105
            goto L_0x0115
        L_0x0105:
            r5.skipToGroupEnd()
            r2 = r38
            r7 = r43
            r9 = r45
            r0 = r5
            r4 = r10
            r6 = r13
            r10 = r46
            goto L_0x03b0
        L_0x0115:
            r5.startDefaults()
            r6 = r9 & 1
            r7 = 1
            if (r6 == 0) goto L_0x013c
            boolean r6 = r5.getDefaultsInvalid()
            if (r6 == 0) goto L_0x0124
            goto L_0x013c
        L_0x0124:
            r5.skipToGroupEnd()
            r3 = r4 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x012f
            r3 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = r2 & r3
        L_0x012f:
            r26 = r43
            r28 = r45
            r29 = r46
            r31 = r2
            r14 = r10
            r2 = r38
            goto L_0x0190
        L_0x013c:
            if (r3 == 0) goto L_0x0143
            io.intercom.android.sdk.survey.ui.questiontype.choice.ChoicePillKt$ChoicePill$1 r3 = io.intercom.android.sdk.survey.ui.questiontype.choice.ChoicePillKt$ChoicePill$1.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            goto L_0x0145
        L_0x0143:
            r3 = r38
        L_0x0145:
            if (r8 == 0) goto L_0x014d
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r10 = r6.m1958getBlack0d7_KjU()
        L_0x014d:
            if (r12 == 0) goto L_0x0155
            float r6 = (float) r7
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            goto L_0x0156
        L_0x0155:
            r6 = r13
        L_0x0156:
            if (r14 == 0) goto L_0x015f
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            long r12 = r8.m1969getWhite0d7_KjU()
            goto L_0x0161
        L_0x015f:
            r12 = r43
        L_0x0161:
            if (r15 == 0) goto L_0x016a
            androidx.compose.ui.text.font.FontWeight$Companion r8 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r8 = r8.getNormal()
            goto L_0x016c
        L_0x016a:
            r8 = r45
        L_0x016c:
            r14 = r4 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x0185
            long r14 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5396generateTextColor8_81llA(r12)
            r16 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r2 = r2 & r16
            r31 = r2
            r2 = r3
            r28 = r8
            r26 = r12
            r29 = r14
            r13 = r6
            r14 = r10
            goto L_0x0190
        L_0x0185:
            r29 = r46
            r31 = r2
            r2 = r3
            r28 = r8
            r14 = r10
            r26 = r12
            r13 = r6
        L_0x0190:
            r5.endDefaults()
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r11 = 8
            androidx.compose.material.Shapes r3 = r3.getShapes(r5, r11)
            androidx.compose.foundation.shape.CornerBasedShape r3 = r3.getMedium()
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r8 = 0
            r10 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r6, r8, r7, r10)
            androidx.compose.foundation.BorderStroke r7 = androidx.compose.foundation.BorderStrokeKt.m191BorderStrokecXLIe8U(r13, r14)
            androidx.compose.ui.graphics.Shape r3 = (androidx.compose.ui.graphics.Shape) r3
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.BorderKt.border(r6, r7, r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.draw.ClipKt.clip(r6, r3)
            r6 = 0
            r7 = 2
            r8 = 0
            r40 = r3
            r41 = r26
            r43 = r6
            r44 = r7
            r45 = r8
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r40, r41, r43, r44, r45)
            r6 = 0
            r7 = 0
            int r23 = r31 >> 3
            r10 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r5.startReplaceableGroup(r10)
            java.lang.String r10 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r10)
            boolean r10 = r5.changed((java.lang.Object) r2)
            boolean r12 = r5.changed((java.lang.Object) r0)
            r10 = r10 | r12
            java.lang.Object r12 = r5.rememberedValue()
            if (r10 != 0) goto L_0x01ee
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r12 != r10) goto L_0x01f9
        L_0x01ee:
            io.intercom.android.sdk.survey.ui.questiontype.choice.ChoicePillKt$ChoicePill$2$1 r10 = new io.intercom.android.sdk.survey.ui.questiontype.choice.ChoicePillKt$ChoicePill$2$1
            r10.<init>(r2, r0)
            r12 = r10
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r5.updateRememberedValue(r12)
        L_0x01f9:
            r5.endReplaceableGroup()
            r10 = r12
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            r12 = 7
            r16 = 0
            r40 = r3
            r41 = r6
            r42 = r7
            r43 = r8
            r44 = r10
            r45 = r12
            r46 = r16
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r40, r41, r42, r43, r44, r45, r46)
            r6 = 16
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r3, r6)
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r6 = r6.getSpaceBetween()
            androidx.compose.foundation.layout.Arrangement$Horizontal r6 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r6
            r7 = 693286680(0x2952b718, float:4.6788176E-14)
            r5.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r7)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r7 = r7.getTop()
            r8 = 6
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r6, r7, r5, r8)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r8, r10)
            java.lang.Object r7 = r5.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r8, r10)
            java.lang.Object r12 = r5.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r11 = r16
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r8, r10)
            java.lang.Object r8 = r5.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            androidx.compose.runtime.Applier r11 = r5.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x029a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x029a:
            r5.startReusableNode()
            boolean r11 = r5.getInserting()
            if (r11 == 0) goto L_0x02a7
            r5.createNode(r10)
            goto L_0x02aa
        L_0x02a7:
            r5.useNode()
        L_0x02aa:
            r5.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m1543constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r6, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r7, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r12, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r8, r6)
            r5.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r6)
            r11 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)
            r3.invoke(r6, r5, r7)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r3)
            r3 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r5.startReplaceableGroup(r3)
            java.lang.String r3 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
            androidx.compose.foundation.layout.RowScopeInstance r3 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r12 = r3
            androidx.compose.foundation.layout.RowScope r12 = (androidx.compose.foundation.layout.RowScope) r12
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r6 = 1062836634(0x3f59999a, float:0.85)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth(r3, r6)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r6 = r6.getCenterVertically()
            androidx.compose.ui.Modifier r3 = r12.align(r3, r6)
            r6 = 0
            r8 = 0
            r10 = 0
            r16 = 0
            r32 = r12
            r6 = 8
            r11 = r16
            r7 = 0
            r33 = r13
            r13 = r7
            r34 = r14
            r14 = r7
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r6 = r7.getTypography(r5, r6)
            androidx.compose.ui.text.TextStyle r21 = r6.getBody2()
            int r6 = r31 >> 6
            r6 = r6 & 14
            int r7 = r31 >> 15
            r7 = r7 & 896(0x380, float:1.256E-42)
            r6 = r6 | r7
            r7 = r23 & r22
            r23 = r6 | r7
            r24 = 0
            r25 = 32728(0x7fd8, float:4.5862E-41)
            r36 = r2
            r2 = r39
            r6 = r5
            r4 = r29
            r9 = r28
            r22 = r6
            r0 = r6
            r6 = 0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r2, r3, r4, r6, r8, r9, r10, r11, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            if (r1 == 0) goto L_0x0395
            androidx.compose.material.icons.Icons r2 = androidx.compose.material.icons.Icons.INSTANCE
            androidx.compose.material.icons.Icons$Filled r2 = r2.getDefault()
            androidx.compose.ui.graphics.vector.ImageVector r2 = androidx.compose.material.icons.filled.CheckKt.getCheck(r2)
            int r3 = io.intercom.android.sdk.R.string.selected
            r4 = 0
            java.lang.String r3 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r3, r0, r4)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r5 = r5.getCenterVertically()
            r6 = r32
            androidx.compose.ui.Modifier r4 = r6.align(r4, r5)
            int r5 = r31 >> 12
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r6 = 0
            r40 = r2
            r41 = r3
            r42 = r4
            r43 = r29
            r45 = r0
            r46 = r5
            r47 = r6
            androidx.compose.material.IconKt.m1314Iconww6aTOc((androidx.compose.ui.graphics.vector.ImageVector) r40, (java.lang.String) r41, (androidx.compose.ui.Modifier) r42, (long) r43, (androidx.compose.runtime.Composer) r45, (int) r46, (int) r47)
        L_0x0395:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r7 = r26
            r9 = r28
            r10 = r29
            r6 = r33
            r4 = r34
            r2 = r36
        L_0x03b0:
            androidx.compose.runtime.ScopeUpdateScope r14 = r0.endRestartGroup()
            if (r14 != 0) goto L_0x03b7
            goto L_0x03ca
        L_0x03b7:
            io.intercom.android.sdk.survey.ui.questiontype.choice.ChoicePillKt$ChoicePill$4 r15 = new io.intercom.android.sdk.survey.ui.questiontype.choice.ChoicePillKt$ChoicePill$4
            r0 = r15
            r1 = r37
            r3 = r39
            r12 = r49
            r13 = r50
            r0.<init>(r1, r2, r3, r4, r6, r7, r9, r10, r12, r13)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x03ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.choice.ChoicePillKt.m5322ChoicePillUdaoDFU(boolean, kotlin.jvm.functions.Function1, java.lang.String, long, float, long, androidx.compose.ui.text.font.FontWeight, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void EmptyPill(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1274080153);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$ChoicePillKt.INSTANCE.m5323getLambda1$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChoicePillKt$EmptyPill$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void SelectedPill(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1118291055);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$ChoicePillKt.INSTANCE.m5324getLambda2$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChoicePillKt$SelectedPill$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void SelectedPillDark(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-774877671);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$ChoicePillKt.INSTANCE.m5325getLambda3$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChoicePillKt$SelectedPillDark$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void SelectedPillLongText(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(173524454);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            ThemeKt.IntercomSurveyTheme(false, ComposableSingletons$ChoicePillKt.INSTANCE.m5326getLambda4$intercom_sdk_base_release(), startRestartGroup, 48, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChoicePillKt$SelectedPillLongText$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void SelectedPillLongBigText(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1982481602);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            SelectedPillLongText(startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChoicePillKt$SelectedPillLongBigText$1(i));
        }
    }
}
