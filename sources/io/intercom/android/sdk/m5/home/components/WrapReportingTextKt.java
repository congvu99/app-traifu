package io.intercom.android.sdk.m5.home.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\\\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2#\b\u0002\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\rH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"PreviewShortText", "", "(Landroidx/compose/runtime/Composer;I)V", "WrapReportingText", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "color", "Landroidx/compose/ui/graphics/Color;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextWrap", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "textWrapped", "WrapReportingText-T042LqI", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: WrapReportingText.kt */
public final class WrapReportingTextKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* renamed from: WrapReportingText-T042LqI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5217WrapReportingTextT042LqI(androidx.compose.ui.Modifier r33, java.lang.String r34, long r35, androidx.compose.ui.text.TextStyle r37, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            r15 = r34
            r13 = r37
            r14 = r40
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "style"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 176283035(0xa81dd9b, float:1.2505607E-32)
            r1 = r39
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r41 & 1
            r1 = 2
            if (r0 == 0) goto L_0x0024
            r2 = r14 | 6
            r3 = r2
            r2 = r33
            goto L_0x0038
        L_0x0024:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0035
            r2 = r33
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0032
            r3 = 4
            goto L_0x0033
        L_0x0032:
            r3 = 2
        L_0x0033:
            r3 = r3 | r14
            goto L_0x0038
        L_0x0035:
            r2 = r33
            r3 = r14
        L_0x0038:
            r4 = r41 & 2
            if (r4 == 0) goto L_0x003f
            r3 = r3 | 48
            goto L_0x004f
        L_0x003f:
            r4 = r14 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004f
            boolean r4 = r12.changed((java.lang.Object) r15)
            if (r4 == 0) goto L_0x004c
            r4 = 32
            goto L_0x004e
        L_0x004c:
            r4 = 16
        L_0x004e:
            r3 = r3 | r4
        L_0x004f:
            r4 = r41 & 4
            if (r4 == 0) goto L_0x0058
            r3 = r3 | 384(0x180, float:5.38E-43)
            r9 = r35
            goto L_0x006a
        L_0x0058:
            r4 = r14 & 896(0x380, float:1.256E-42)
            r9 = r35
            if (r4 != 0) goto L_0x006a
            boolean r4 = r12.changed((long) r9)
            if (r4 == 0) goto L_0x0067
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r3 = r3 | r4
        L_0x006a:
            r4 = r41 & 8
            if (r4 == 0) goto L_0x0071
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x0071:
            r4 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0081
            boolean r4 = r12.changed((java.lang.Object) r13)
            if (r4 == 0) goto L_0x007e
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r4
        L_0x0081:
            r4 = r41 & 16
            if (r4 == 0) goto L_0x0088
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x0088:
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r14
            if (r5 != 0) goto L_0x009d
            r5 = r38
            boolean r6 = r12.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0099
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r3 = r3 | r6
            goto L_0x009f
        L_0x009d:
            r5 = r38
        L_0x009f:
            r6 = 46811(0xb6db, float:6.5596E-41)
            r6 = r6 & r3
            r7 = 9362(0x2492, float:1.3119E-41)
            if (r6 != r7) goto L_0x00b7
            boolean r6 = r12.getSkipping()
            if (r6 != 0) goto L_0x00ae
            goto L_0x00b7
        L_0x00ae:
            r12.skipToGroupEnd()
            r1 = r2
            r6 = r5
            r32 = r12
            goto L_0x01a1
        L_0x00b7:
            if (r0 == 0) goto L_0x00bf
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r11 = r0
            goto L_0x00c0
        L_0x00bf:
            r11 = r2
        L_0x00c0:
            if (r4 == 0) goto L_0x00c8
            io.intercom.android.sdk.m5.home.components.WrapReportingTextKt$WrapReportingText$1 r0 = io.intercom.android.sdk.m5.home.components.WrapReportingTextKt$WrapReportingText$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r8 = r0
            goto L_0x00c9
        L_0x00c8:
            r8 = r5
        L_0x00c9:
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            java.lang.Object r0 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x00ed
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r2 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r2, r1, r2)
            r12.updateRememberedValue(r0)
        L_0x00ed:
            r12.endReplaceableGroup()
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            r1 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            boolean r1 = r12.changed((java.lang.Object) r0)
            java.lang.Object r2 = r12.rememberedValue()
            if (r1 != 0) goto L_0x010f
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x011a
        L_0x010f:
            io.intercom.android.sdk.m5.home.components.WrapReportingTextKt$WrapReportingText$2$1 r1 = new io.intercom.android.sdk.m5.home.components.WrapReportingTextKt$WrapReportingText$2$1
            r1.<init>(r0)
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12.updateRememberedValue(r2)
        L_0x011a:
            r12.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.draw.DrawModifierKt.drawWithContent(r11, r2)
            r4 = 0
            r6 = 0
            r16 = 0
            r19 = 0
            r17 = 0
            r24 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            boolean r2 = r12.changed((java.lang.Object) r8)
            boolean r18 = r12.changed((java.lang.Object) r0)
            r2 = r2 | r18
            java.lang.Object r7 = r12.rememberedValue()
            if (r2 != 0) goto L_0x0159
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r7 != r2) goto L_0x0164
        L_0x0159:
            io.intercom.android.sdk.m5.home.components.WrapReportingTextKt$WrapReportingText$3$1 r2 = new io.intercom.android.sdk.m5.home.components.WrapReportingTextKt$WrapReportingText$3$1
            r2.<init>(r8, r0)
            r7 = r2
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r12.updateRememberedValue(r7)
        L_0x0164:
            r12.endReplaceableGroup()
            r18 = r7
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            int r0 = r3 >> 3
            r0 = r0 & 14
            r2 = r3 & 896(0x380, float:1.256E-42)
            r21 = r0 | r2
            r0 = 458752(0x70000, float:6.42848E-40)
            int r2 = r3 << 6
            r22 = r2 & r0
            r23 = 16376(0x3ff8, float:2.2948E-41)
            r0 = r34
            r2 = r35
            r7 = 0
            r30 = r8
            r8 = r16
            r9 = r19
            r31 = r11
            r11 = r17
            r32 = r12
            r12 = r24
            r13 = r25
            r15 = r27
            r16 = r28
            r17 = r29
            r19 = r37
            r20 = r32
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r6 = r30
            r1 = r31
        L_0x01a1:
            androidx.compose.runtime.ScopeUpdateScope r9 = r32.endRestartGroup()
            if (r9 != 0) goto L_0x01a8
            goto L_0x01bd
        L_0x01a8:
            io.intercom.android.sdk.m5.home.components.WrapReportingTextKt$WrapReportingText$4 r10 = new io.intercom.android.sdk.m5.home.components.WrapReportingTextKt$WrapReportingText$4
            r0 = r10
            r2 = r34
            r3 = r35
            r5 = r37
            r7 = r40
            r8 = r41
            r0.<init>(r1, r2, r3, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x01bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.home.components.WrapReportingTextKt.m5217WrapReportingTextT042LqI(androidx.compose.ui.Modifier, java.lang.String, long, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void PreviewShortText(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1491242039);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$WrapReportingTextKt.INSTANCE.m5216getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new WrapReportingTextKt$PreviewShortText$1(i));
        }
    }
}
