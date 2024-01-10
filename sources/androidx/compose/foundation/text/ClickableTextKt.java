package androidx.compose.foundation.text;

import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ay\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ClickableText.kt */
public final class ClickableTextKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0121  */
    /* renamed from: ClickableText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m869ClickableText4YKlhWE(androidx.compose.ui.text.AnnotatedString r25, androidx.compose.ui.Modifier r26, androidx.compose.ui.text.TextStyle r27, boolean r28, int r29, int r30, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r31, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r11 = r25
            r12 = r32
            r13 = r34
            r14 = r35
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -246609449(0xfffffffff14d09d7, float:-1.0153012E30)
            r1 = r33
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ClickableText)P(7,1,6,5,4:c#ui.text.style.TextOverflow!1,3)73@3340L52,74@3449L184,89@3854L76,82@3639L297:ClickableText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x0028
            r1 = r13 | 6
            goto L_0x0038
        L_0x0028:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0037
            boolean r1 = r15.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x0034
            r1 = 4
            goto L_0x0035
        L_0x0034:
            r1 = 2
        L_0x0035:
            r1 = r1 | r13
            goto L_0x0038
        L_0x0037:
            r1 = r13
        L_0x0038:
            r3 = r14 & 2
            if (r3 == 0) goto L_0x003f
            r1 = r1 | 48
            goto L_0x0052
        L_0x003f:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0052
            r4 = r26
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004e
            r5 = 32
            goto L_0x0050
        L_0x004e:
            r5 = 16
        L_0x0050:
            r1 = r1 | r5
            goto L_0x0054
        L_0x0052:
            r4 = r26
        L_0x0054:
            r5 = r14 & 4
            if (r5 == 0) goto L_0x005b
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x006e
        L_0x005b:
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006e
            r6 = r27
            boolean r7 = r15.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x006a
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x006a:
            r7 = 128(0x80, float:1.794E-43)
        L_0x006c:
            r1 = r1 | r7
            goto L_0x0070
        L_0x006e:
            r6 = r27
        L_0x0070:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x0077
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x0077:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x008a
            r8 = r28
            boolean r9 = r15.changed((boolean) r8)
            if (r9 == 0) goto L_0x0086
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0086:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r1 = r1 | r9
            goto L_0x008c
        L_0x008a:
            r8 = r28
        L_0x008c:
            r9 = r14 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0098
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r10 = r29
            goto L_0x00ab
        L_0x0098:
            r16 = r13 & r10
            r10 = r29
            if (r16 != 0) goto L_0x00ab
            boolean r16 = r15.changed((int) r10)
            if (r16 == 0) goto L_0x00a7
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a9
        L_0x00a7:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a9:
            r1 = r1 | r16
        L_0x00ab:
            r16 = r14 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b8
            r18 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r18
            r2 = r30
            goto L_0x00cb
        L_0x00b8:
            r18 = r13 & r17
            r2 = r30
            if (r18 != 0) goto L_0x00cb
            boolean r19 = r15.changed((int) r2)
            if (r19 == 0) goto L_0x00c7
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r1 = r1 | r19
        L_0x00cb:
            r19 = r14 & 64
            r20 = 3670016(0x380000, float:5.142788E-39)
            if (r19 == 0) goto L_0x00d8
            r21 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r21
            r0 = r31
            goto L_0x00eb
        L_0x00d8:
            r21 = r13 & r20
            r0 = r31
            if (r21 != 0) goto L_0x00eb
            boolean r22 = r15.changed((java.lang.Object) r0)
            if (r22 == 0) goto L_0x00e7
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e9
        L_0x00e7:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00e9:
            r1 = r1 | r22
        L_0x00eb:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f3
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00f1:
            r1 = r1 | r0
            goto L_0x0104
        L_0x00f3:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r13
            if (r0 != 0) goto L_0x0104
            boolean r0 = r15.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x0101
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f1
        L_0x0101:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00f1
        L_0x0104:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r1
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x0121
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x0114
            goto L_0x0121
        L_0x0114:
            r15.skipToGroupEnd()
            r7 = r31
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r10
            r6 = r30
            goto L_0x0241
        L_0x0121:
            if (r3 == 0) goto L_0x0128
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x0128:
            if (r5 == 0) goto L_0x0133
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r22 = r0
            goto L_0x0135
        L_0x0133:
            r22 = r6
        L_0x0135:
            if (r7 == 0) goto L_0x013b
            r0 = 1
            r23 = 1
            goto L_0x013d
        L_0x013b:
            r23 = r8
        L_0x013d:
            if (r9 == 0) goto L_0x0148
            androidx.compose.ui.text.style.TextOverflow$Companion r0 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r0 = r0.m4590getClipgIe3tQ8()
            r24 = r0
            goto L_0x014a
        L_0x0148:
            r24 = r10
        L_0x014a:
            if (r16 == 0) goto L_0x0153
            r0 = 2147483647(0x7fffffff, float:NaN)
            r16 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0155
        L_0x0153:
            r16 = r30
        L_0x0155:
            if (r19 == 0) goto L_0x015d
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$1 r0 = androidx.compose.foundation.text.ClickableTextKt$ClickableText$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r10 = r0
            goto L_0x015f
        L_0x015d:
            r10 = r31
        L_0x015f:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x016e
            r0 = -1
            java.lang.String r2 = "androidx.compose.foundation.text.ClickableText (ClickableText.kt:63)"
            r3 = -246609449(0xfffffffff14d09d7, float:-1.0153012E30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x016e:
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            java.lang.Object r0 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            r3 = 0
            if (r0 != r2) goto L_0x018e
            r2 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r3, r2, r3)
            r15.updateRememberedValue(r0)
        L_0x018e:
            r15.endReplaceableGroup()
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r15.startReplaceableGroup(r5)
            java.lang.String r6 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r6)
            boolean r7 = r15.changed((java.lang.Object) r0)
            boolean r8 = r15.changed((java.lang.Object) r12)
            r7 = r7 | r8
            java.lang.Object r8 = r15.rememberedValue()
            if (r7 != 0) goto L_0x01b9
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r8 != r7) goto L_0x01c4
        L_0x01b9:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1 r7 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1
            r7.<init>(r0, r12, r3)
            r8 = r7
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r15.updateRememberedValue(r8)
        L_0x01c4:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r2, (java.lang.Object) r12, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r8)
            androidx.compose.ui.Modifier r2 = r4.then(r2)
            r15.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r6)
            boolean r3 = r15.changed((java.lang.Object) r0)
            boolean r5 = r15.changed((java.lang.Object) r10)
            r3 = r3 | r5
            java.lang.Object r5 = r15.rememberedValue()
            if (r3 != 0) goto L_0x01ee
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x01f9
        L_0x01ee:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1 r3 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
            r3.<init>(r0, r10)
            r5 = r3
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r15.updateRememberedValue(r5)
        L_0x01f9:
            r15.endReplaceableGroup()
            r3 = r5
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r7 = 0
            r0 = r1 & 14
            r5 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r5
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r1
            r0 = r0 | r5
            int r5 = r1 << 6
            r5 = r5 & r17
            r0 = r0 | r5
            int r1 = r1 << 3
            r1 = r1 & r20
            r9 = r0 | r1
            r17 = 128(0x80, float:1.794E-43)
            r0 = r25
            r1 = r2
            r2 = r22
            r18 = r4
            r4 = r24
            r5 = r23
            r6 = r16
            r8 = r15
            r19 = r10
            r10 = r17
            androidx.compose.foundation.text.BasicTextKt.m867BasicText4YKlhWE(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0235
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0235:
            r6 = r16
            r2 = r18
            r7 = r19
            r3 = r22
            r4 = r23
            r5 = r24
        L_0x0241:
            androidx.compose.runtime.ScopeUpdateScope r15 = r15.endRestartGroup()
            if (r15 != 0) goto L_0x0248
            goto L_0x025e
        L_0x0248:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$3 r16 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$3
            r0 = r16
            r1 = r25
            r8 = r32
            r9 = r34
            r10 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x025e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.ClickableTextKt.m869ClickableText4YKlhWE(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, boolean, int, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
