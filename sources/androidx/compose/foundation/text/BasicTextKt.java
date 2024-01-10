package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a{\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00132\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001e\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: BasicText.kt */
public final class BasicTextKt {
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00fc  */
    /* renamed from: BasicText-BpD7jsM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m868BasicTextBpD7jsM(java.lang.String r30, androidx.compose.ui.Modifier r31, androidx.compose.ui.text.TextStyle r32, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r33, int r34, boolean r35, int r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r8 = r30
            r9 = r38
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1022429478(0x3cf10926, float:0.029423308)
            r1 = r37
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)73@3673L7,74@3712L7,75@3773L7,95@4758L473,132@5929L69:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r39 & 1
            if (r1 == 0) goto L_0x001f
            r1 = r9 | 6
            goto L_0x002f
        L_0x001f:
            r1 = r9 & 14
            if (r1 != 0) goto L_0x002e
            boolean r1 = r10.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x002b
            r1 = 4
            goto L_0x002c
        L_0x002b:
            r1 = 2
        L_0x002c:
            r1 = r1 | r9
            goto L_0x002f
        L_0x002e:
            r1 = r9
        L_0x002f:
            r3 = r39 & 2
            if (r3 == 0) goto L_0x0036
            r1 = r1 | 48
            goto L_0x0049
        L_0x0036:
            r4 = r9 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0049
            r4 = r31
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0045
            r5 = 32
            goto L_0x0047
        L_0x0045:
            r5 = 16
        L_0x0047:
            r1 = r1 | r5
            goto L_0x004b
        L_0x0049:
            r4 = r31
        L_0x004b:
            r5 = r39 & 4
            if (r5 == 0) goto L_0x0052
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r6 = r9 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0065
            r6 = r32
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0061
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r1 = r1 | r7
            goto L_0x0067
        L_0x0065:
            r6 = r32
        L_0x0067:
            r7 = r39 & 8
            if (r7 == 0) goto L_0x006e
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x0081
            r11 = r33
            boolean r12 = r10.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x007d
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r1 = r1 | r12
            goto L_0x0083
        L_0x0081:
            r11 = r33
        L_0x0083:
            r12 = r39 & 16
            if (r12 == 0) goto L_0x008a
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008a:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r9
            if (r13 != 0) goto L_0x009f
            r13 = r34
            boolean r14 = r10.changed((int) r13)
            if (r14 == 0) goto L_0x009b
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r1 = r1 | r14
            goto L_0x00a1
        L_0x009f:
            r13 = r34
        L_0x00a1:
            r14 = r39 & 32
            if (r14 == 0) goto L_0x00a9
            r15 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r15
            goto L_0x00be
        L_0x00a9:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r9
            if (r15 != 0) goto L_0x00be
            r15 = r35
            boolean r16 = r10.changed((boolean) r15)
            if (r16 == 0) goto L_0x00b9
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r1 = r1 | r16
            goto L_0x00c0
        L_0x00be:
            r15 = r35
        L_0x00c0:
            r16 = r39 & 64
            if (r16 == 0) goto L_0x00cb
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r2 = r36
            goto L_0x00e0
        L_0x00cb:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r9 & r17
            r2 = r36
            if (r17 != 0) goto L_0x00e0
            boolean r17 = r10.changed((int) r2)
            if (r17 == 0) goto L_0x00dc
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r1 = r1 | r17
        L_0x00e0:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r1 = r1 & r17
            r0 = 599186(0x92492, float:8.39638E-40)
            if (r1 != r0) goto L_0x00fc
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x00f1
            goto L_0x00fc
        L_0x00f1:
            r10.skipToGroupEnd()
            r7 = r2
            r2 = r4
            r3 = r6
            r4 = r11
            r5 = r13
            r6 = r15
            goto L_0x0361
        L_0x00fc:
            if (r3 == 0) goto L_0x0103
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x0103:
            if (r5 == 0) goto L_0x010e
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r29 = r0
            goto L_0x0110
        L_0x010e:
            r29 = r6
        L_0x0110:
            if (r7 == 0) goto L_0x0117
            androidx.compose.foundation.text.BasicTextKt$BasicText$1 r0 = androidx.compose.foundation.text.BasicTextKt$BasicText$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r11 = r0
        L_0x0117:
            if (r12 == 0) goto L_0x0120
            androidx.compose.ui.text.style.TextOverflow$Companion r0 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r0 = r0.m4590getClipgIe3tQ8()
            r13 = r0
        L_0x0120:
            r0 = 1
            if (r14 == 0) goto L_0x0124
            r15 = 1
        L_0x0124:
            if (r16 == 0) goto L_0x012d
            r1 = 2147483647(0x7fffffff, float:NaN)
            r12 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x012e
        L_0x012d:
            r12 = r2
        L_0x012e:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x013d
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.text.BasicText (BasicText.kt:58)"
            r3 = 1022429478(0x3cf10926, float:0.029423308)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r9, r1, r2)
        L_0x013d:
            r1 = 0
            if (r12 <= 0) goto L_0x0142
            r2 = 1
            goto L_0x0143
        L_0x0142:
            r2 = 0
        L_0x0143:
            if (r2 == 0) goto L_0x037a
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.SelectionRegistrarKt.getLocalSelectionRegistrar()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r14, r7)
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r6 = r2
            androidx.compose.foundation.text.selection.SelectionRegistrar r6 = (androidx.compose.foundation.text.selection.SelectionRegistrar) r6
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r14, r7)
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r3 = r2
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r14, r7)
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r5 = r2
            androidx.compose.ui.text.font.FontFamily$Resolver r5 = (androidx.compose.ui.text.font.FontFamily.Resolver) r5
            r2 = 959238313(0x392cd0a9, float:1.648093E-4)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "90@4579L150"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            if (r6 != 0) goto L_0x0193
            r0 = 0
            goto L_0x01c2
        L_0x0193:
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r8
            r2[r0] = r6
            androidx.compose.runtime.saveable.Saver r0 = selectionIdSaver(r6)
            r1 = 0
            androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$1 r14 = new androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$1
            r14.<init>(r6)
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r17 = 72
            r18 = 4
            r31 = r2
            r32 = r0
            r33 = r1
            r34 = r14
            r35 = r10
            r36 = r17
            r37 = r18
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r31, r32, (java.lang.String) r33, r34, (androidx.compose.runtime.Composer) r35, (int) r36, (int) r37)
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
        L_0x01c2:
            r10.endReplaceableGroup()
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            java.lang.Object r2 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r2 != r14) goto L_0x021e
            androidx.compose.foundation.text.TextController r2 = new androidx.compose.foundation.text.TextController
            androidx.compose.foundation.text.TextState r14 = new androidx.compose.foundation.text.TextState
            androidx.compose.ui.text.AnnotatedString r19 = new androidx.compose.ui.text.AnnotatedString
            r17 = 0
            r18 = 0
            r20 = 6
            r21 = 0
            r31 = r19
            r32 = r30
            r33 = r17
            r34 = r18
            r35 = r20
            r36 = r21
            r31.<init>(r32, r33, r34, r35, r36)
            r31 = r4
            androidx.compose.foundation.text.TextDelegate r4 = new androidx.compose.foundation.text.TextDelegate
            r26 = 0
            r27 = 128(0x80, float:1.794E-43)
            r28 = 0
            r18 = r4
            r20 = r29
            r21 = r12
            r22 = r15
            r23 = r13
            r24 = r3
            r25 = r5
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r14.<init>(r4, r0)
            r2.<init>(r14)
            r10.updateRememberedValue(r2)
            goto L_0x0220
        L_0x021e:
            r31 = r4
        L_0x0220:
            r10.endReplaceableGroup()
            r14 = r2
            androidx.compose.foundation.text.TextController r14 = (androidx.compose.foundation.text.TextController) r14
            androidx.compose.foundation.text.TextState r4 = r14.getState()
            boolean r0 = r10.getInserting()
            if (r0 != 0) goto L_0x024d
            androidx.compose.foundation.text.TextDelegate r0 = r4.getTextDelegate()
            r1 = r30
            r2 = r29
            r9 = r31
            r8 = r4
            r4 = r5
            r5 = r15
            r31 = r15
            r15 = r6
            r6 = r13
            r32 = r13
            r13 = r7
            r7 = r12
            androidx.compose.foundation.text.TextDelegate r0 = androidx.compose.foundation.text.CoreTextKt.m880updateTextDelegatey0kMQk(r0, r1, r2, r3, r4, r5, r6, r7)
            r14.setTextDelegate(r0)
            goto L_0x0256
        L_0x024d:
            r9 = r31
            r8 = r4
            r32 = r13
            r31 = r15
            r15 = r6
            r13 = r7
        L_0x0256:
            r8.setOnTextLayout(r11)
            r14.update(r15)
            r0 = 959239630(0x392cd5ce, float:1.6482847E-4)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "129@5894L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            if (r15 == 0) goto L_0x0285
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r13)
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.foundation.text.selection.TextSelectionColors r0 = (androidx.compose.foundation.text.selection.TextSelectionColors) r0
            long r0 = r0.m1108getBackgroundColor0d7_KjU()
            r8.m975setSelectionBackgroundColor8_81llA(r0)
        L_0x0285:
            r10.endReplaceableGroup()
            androidx.compose.ui.Modifier r0 = r14.getModifiers()
            androidx.compose.ui.Modifier r0 = r9.then(r0)
            androidx.compose.ui.layout.MeasurePolicy r1 = r14.getMeasurePolicy()
            r2 = 544976794(0x207baf9a, float:2.1318629E-19)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Layout)P(1)120@4589L7,121@4644L7,122@4703L7,124@4776L439:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r13)
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r13)
            java.lang.Object r4 = r10.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r13)
            java.lang.Object r3 = r10.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.ViewConfiguration r3 = (androidx.compose.ui.platform.ViewConfiguration) r3
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materialize(r10, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            r6 = 1405779621(0x53ca7ea5, float:1.73941627E12)
            r10.startReplaceableGroup(r6)
            java.lang.String r6 = "C(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r6)
            androidx.compose.runtime.Applier r6 = r10.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x02f8
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02f8:
            r10.startReusableNode()
            boolean r6 = r10.getInserting()
            if (r6 == 0) goto L_0x030c
            androidx.compose.foundation.text.BasicTextKt$BasicText-BpD7jsM$$inlined$Layout$1 r6 = new androidx.compose.foundation.text.BasicTextKt$BasicText-BpD7jsM$$inlined$Layout$1
            r6.<init>(r5)
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r10.createNode(r6)
            goto L_0x030f
        L_0x030c:
            r10.useNode()
        L_0x030f:
            r10.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1543constructorimpl(r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r2, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r3, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r0, r1)
            r10.enableReusing()
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0358
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0358:
            r6 = r31
            r5 = r32
            r2 = r9
            r4 = r11
            r7 = r12
            r3 = r29
        L_0x0361:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x0368
            goto L_0x0379
        L_0x0368:
            androidx.compose.foundation.text.BasicTextKt$BasicText$3 r11 = new androidx.compose.foundation.text.BasicTextKt$BasicText$3
            r0 = r11
            r1 = r30
            r8 = r38
            r9 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0379:
            return
        L_0x037a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "maxLines should be greater than 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m868BasicTextBpD7jsM(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0400  */
    /* JADX WARNING: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010f  */
    /* renamed from: BasicText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m867BasicText4YKlhWE(androidx.compose.ui.text.AnnotatedString r36, androidx.compose.ui.Modifier r37, androidx.compose.ui.text.TextStyle r38, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r39, int r40, boolean r41, int r42, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r43, androidx.compose.runtime.Composer r44, int r45, int r46) {
        /*
            r10 = r36
            r11 = r45
            r12 = r46
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -648605928(0xffffffffd9570f18, float:-3.78335723E15)
            r1 = r44
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)172@8209L7,173@8248L7,174@8309L7,175@8377L7,197@9465L504,235@10641L270:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0021
            r1 = r11 | 6
            goto L_0x0031
        L_0x0021:
            r1 = r11 & 14
            if (r1 != 0) goto L_0x0030
            boolean r1 = r13.changed((java.lang.Object) r10)
            if (r1 == 0) goto L_0x002d
            r1 = 4
            goto L_0x002e
        L_0x002d:
            r1 = 2
        L_0x002e:
            r1 = r1 | r11
            goto L_0x0031
        L_0x0030:
            r1 = r11
        L_0x0031:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0038
            r1 = r1 | 48
            goto L_0x004b
        L_0x0038:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004b
            r4 = r37
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0047
            r5 = 32
            goto L_0x0049
        L_0x0047:
            r5 = 16
        L_0x0049:
            r1 = r1 | r5
            goto L_0x004d
        L_0x004b:
            r4 = r37
        L_0x004d:
            r5 = r12 & 4
            if (r5 == 0) goto L_0x0054
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0054:
            r7 = r11 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0067
            r7 = r38
            boolean r8 = r13.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0063
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r1 = r1 | r8
            goto L_0x0069
        L_0x0067:
            r7 = r38
        L_0x0069:
            r8 = r12 & 8
            if (r8 == 0) goto L_0x0070
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0070:
            r9 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0083
            r9 = r39
            boolean r14 = r13.changed((java.lang.Object) r9)
            if (r14 == 0) goto L_0x007f
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r1 = r1 | r14
            goto L_0x0085
        L_0x0083:
            r9 = r39
        L_0x0085:
            r14 = r12 & 16
            if (r14 == 0) goto L_0x008c
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x008c:
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00a2
            r15 = r40
            boolean r16 = r13.changed((int) r15)
            if (r16 == 0) goto L_0x009d
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r1 = r1 | r16
            goto L_0x00a4
        L_0x00a2:
            r15 = r40
        L_0x00a4:
            r16 = r12 & 32
            if (r16 == 0) goto L_0x00af
            r17 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r17
            r2 = r41
            goto L_0x00c4
        L_0x00af:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r11 & r17
            r2 = r41
            if (r17 != 0) goto L_0x00c4
            boolean r17 = r13.changed((boolean) r2)
            if (r17 == 0) goto L_0x00c0
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r1 = r1 | r17
        L_0x00c4:
            r17 = r12 & 64
            if (r17 == 0) goto L_0x00cf
            r18 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r18
            r0 = r42
            goto L_0x00e4
        L_0x00cf:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r11 & r18
            r0 = r42
            if (r18 != 0) goto L_0x00e4
            boolean r19 = r13.changed((int) r0)
            if (r19 == 0) goto L_0x00e0
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e2
        L_0x00e0:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00e2:
            r1 = r1 | r19
        L_0x00e4:
            r6 = r12 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00ec
            r20 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 | r20
        L_0x00ec:
            r0 = 128(0x80, float:1.794E-43)
            if (r6 != r0) goto L_0x010f
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r1
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x010f
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x0100
            goto L_0x010f
        L_0x0100:
            r13.skipToGroupEnd()
            r6 = r41
            r8 = r43
            r2 = r4
            r3 = r7
            r4 = r9
            r5 = r15
            r7 = r42
            goto L_0x03e7
        L_0x010f:
            r13.startDefaults()
            r0 = r11 & 1
            r2 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r9 = 1
            if (r0 == 0) goto L_0x0136
            boolean r0 = r13.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0121
            goto L_0x0136
        L_0x0121:
            r13.skipToGroupEnd()
            if (r6 == 0) goto L_0x0127
            r1 = r1 & r2
        L_0x0127:
            r8 = r39
            r17 = r41
            r19 = r42
            r6 = r1
            r14 = r4
        L_0x012f:
            r16 = r15
            r15 = r7
            r7 = r43
            goto L_0x0182
        L_0x0136:
            if (r3 == 0) goto L_0x013d
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x013e
        L_0x013d:
            r0 = r4
        L_0x013e:
            if (r5 == 0) goto L_0x0147
            androidx.compose.ui.text.TextStyle$Companion r3 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r3 = r3.getDefault()
            r7 = r3
        L_0x0147:
            if (r8 == 0) goto L_0x014e
            androidx.compose.foundation.text.BasicTextKt$BasicText$4 r3 = androidx.compose.foundation.text.BasicTextKt$BasicText$4.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            goto L_0x0150
        L_0x014e:
            r3 = r39
        L_0x0150:
            if (r14 == 0) goto L_0x0159
            androidx.compose.ui.text.style.TextOverflow$Companion r4 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r4 = r4.m4590getClipgIe3tQ8()
            r15 = r4
        L_0x0159:
            if (r16 == 0) goto L_0x015d
            r4 = 1
            goto L_0x015f
        L_0x015d:
            r4 = r41
        L_0x015f:
            if (r17 == 0) goto L_0x0165
            r5 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0167
        L_0x0165:
            r5 = r42
        L_0x0167:
            if (r6 == 0) goto L_0x017a
            java.util.Map r6 = kotlin.collections.MapsKt.emptyMap()
            r1 = r1 & r2
            r14 = r0
            r8 = r3
            r17 = r4
            r19 = r5
            r16 = r15
            r15 = r7
            r7 = r6
            r6 = r1
            goto L_0x0182
        L_0x017a:
            r14 = r0
            r6 = r1
            r8 = r3
            r17 = r4
            r19 = r5
            goto L_0x012f
        L_0x0182:
            r13.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0194
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.text.BasicText (BasicText.kt:159)"
            r2 = -648605928(0xffffffffd9570f18, float:-3.78335723E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r6, r0, r1)
        L_0x0194:
            r18 = 0
            if (r19 <= 0) goto L_0x019a
            r0 = 1
            goto L_0x019b
        L_0x019a:
            r0 = 0
        L_0x019b:
            if (r0 == 0) goto L_0x0400
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.SelectionRegistrarKt.getLocalSelectionRegistrar()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r4)
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r3 = r0
            androidx.compose.foundation.text.selection.SelectionRegistrar r3 = (androidx.compose.foundation.text.selection.SelectionRegistrar) r3
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r4)
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r20 = r0
            androidx.compose.ui.unit.Density r20 = (androidx.compose.ui.unit.Density) r20
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r4)
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r21 = r0
            androidx.compose.ui.text.font.FontFamily$Resolver r21 = (androidx.compose.ui.text.font.FontFamily.Resolver) r21
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r4)
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.foundation.text.selection.TextSelectionColors r0 = (androidx.compose.foundation.text.selection.TextSelectionColors) r0
            long r1 = r0.m1108getBackgroundColor0d7_KjU()
            kotlin.Pair r0 = androidx.compose.foundation.text.CoreTextKt.resolveInlineContent(r10, r7)
            java.lang.Object r22 = r0.component1()
            java.util.List r22 = (java.util.List) r22
            java.lang.Object r0 = r0.component2()
            java.util.List r0 = (java.util.List) r0
            r5 = 959243020(0x392ce30c, float:1.648778E-4)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "192@9286L150"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            if (r3 != 0) goto L_0x0213
            r24 = 0
            goto L_0x0243
        L_0x0213:
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r18] = r10
            r5[r9] = r3
            androidx.compose.runtime.saveable.Saver r24 = selectionIdSaver(r3)
            r25 = 0
            androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$2 r9 = new androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$2
            r9.<init>(r3)
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r26 = 72
            r27 = 4
            r37 = r5
            r38 = r24
            r39 = r25
            r40 = r9
            r41 = r13
            r42 = r26
            r43 = r27
            java.lang.Object r5 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r37, r38, (java.lang.String) r39, r40, (androidx.compose.runtime.Composer) r41, (int) r42, (int) r43)
            java.lang.Number r5 = (java.lang.Number) r5
            long r24 = r5.longValue()
        L_0x0243:
            r28 = r24
            r13.endReplaceableGroup()
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            java.lang.Object r5 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r5 != r9) goto L_0x02a1
            androidx.compose.foundation.text.TextController r9 = new androidx.compose.foundation.text.TextController
            androidx.compose.foundation.text.TextState r5 = new androidx.compose.foundation.text.TextState
            r37 = r9
            androidx.compose.foundation.text.TextDelegate r9 = new androidx.compose.foundation.text.TextDelegate
            r24 = 0
            r38 = r0
            r0 = r9
            r30 = r1
            r1 = r36
            r2 = r15
            r32 = r3
            r3 = r19
            r33 = r4
            r4 = r17
            r34 = r5
            r5 = r16
            r35 = r6
            r6 = r20
            r23 = r7
            r7 = r21
            r11 = r8
            r8 = r22
            r12 = r37
            r25 = r14
            r14 = r9
            r9 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r28
            r2 = r34
            r2.<init>(r14, r0)
            r12.<init>(r2)
            r13.updateRememberedValue(r12)
            r5 = r12
            goto L_0x02b0
        L_0x02a1:
            r38 = r0
            r30 = r1
            r32 = r3
            r33 = r4
            r35 = r6
            r23 = r7
            r11 = r8
            r25 = r14
        L_0x02b0:
            r13.endReplaceableGroup()
            r9 = r5
            androidx.compose.foundation.text.TextController r9 = (androidx.compose.foundation.text.TextController) r9
            androidx.compose.foundation.text.TextState r12 = r9.getState()
            boolean r0 = r13.getInserting()
            if (r0 != 0) goto L_0x02da
            androidx.compose.foundation.text.TextDelegate r0 = r12.getTextDelegate()
            r1 = r36
            r2 = r15
            r3 = r20
            r4 = r21
            r5 = r17
            r6 = r16
            r7 = r19
            r8 = r22
            androidx.compose.foundation.text.TextDelegate r0 = androidx.compose.foundation.text.CoreTextKt.m878updateTextDelegatex_uQXYA(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r9.setTextDelegate(r0)
        L_0x02da:
            r12.setOnTextLayout(r11)
            r0 = r30
            r12.m975setSelectionBackgroundColor8_81llA(r0)
            r0 = r32
            r9.update(r0)
            boolean r0 = r38.isEmpty()
            if (r0 == 0) goto L_0x02f4
            androidx.compose.foundation.text.ComposableSingletons$BasicTextKt r0 = androidx.compose.foundation.text.ComposableSingletons$BasicTextKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m873getLambda1$foundation_release()
            goto L_0x0307
        L_0x02f4:
            r0 = 1892283635(0x70c9f4f3, float:5.000209E29)
            androidx.compose.foundation.text.BasicTextKt$BasicText$6 r1 = new androidx.compose.foundation.text.BasicTextKt$BasicText$6
            r3 = r38
            r2 = r35
            r1.<init>(r10, r3, r2)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r2, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
        L_0x0307:
            androidx.compose.ui.Modifier r1 = r9.getModifiers()
            r4 = r25
            androidx.compose.ui.Modifier r1 = r4.then(r1)
            androidx.compose.ui.layout.MeasurePolicy r2 = r9.getMeasurePolicy()
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r5 = r33
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r5)
            java.lang.Object r3 = r13.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r5)
            java.lang.Object r7 = r13.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r5)
            java.lang.Object r5 = r13.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r8 = r13.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0370
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0370:
            r13.startReusableNode()
            boolean r8 = r13.getInserting()
            if (r8 == 0) goto L_0x037d
            r13.createNode(r6)
            goto L_0x0380
        L_0x037d:
            r13.useNode()
        L_0x0380:
            r13.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1543constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r3, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r7, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r5, r2)
            r13.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r18)
            r1.invoke(r2, r13, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r18)
            r0.invoke(r13, r1)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03dc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03dc:
            r2 = r4
            r4 = r11
            r3 = r15
            r5 = r16
            r6 = r17
            r7 = r19
            r8 = r23
        L_0x03e7:
            androidx.compose.runtime.ScopeUpdateScope r11 = r13.endRestartGroup()
            if (r11 != 0) goto L_0x03ee
            goto L_0x03ff
        L_0x03ee:
            androidx.compose.foundation.text.BasicTextKt$BasicText$7 r12 = new androidx.compose.foundation.text.BasicTextKt$BasicText$7
            r0 = r12
            r1 = r36
            r9 = r45
            r10 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x03ff:
            return
        L_0x0400:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "maxLines should be greater than 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m867BasicText4YKlhWE(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Saver<Long, Long> selectionIdSaver(SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new BasicTextKt$selectionIdSaver$1(selectionRegistrar), BasicTextKt$selectionIdSaver$2.INSTANCE);
    }
}
