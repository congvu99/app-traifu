package androidx.compose.material;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0001\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a?\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0013\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\tH\u0002¢\u0006\u0002\u0010\u001d\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"BaselinesOffsetColumn", "", "offsets", "", "Landroidx/compose/ui/unit/Dp;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ListItem", "icon", "secondaryText", "singleLineSecondaryText", "", "overlineText", "trailing", "text", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OffsetToBaselineOrCenter", "offset", "OffsetToBaselineOrCenter-Kz89ssw", "(FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "applyTextStyle", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "(Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListItem.kt */
public final class ListItemKt {
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0101  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ListItem(androidx.compose.ui.Modifier r20, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, boolean r23, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r7 = r26
            r8 = r28
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -450923337(0xffffffffe51f74b7, float:-4.706308E22)
            r1 = r27
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ListItem)P(1!1,3,4!1,6)81@3397L10,83@3480L4,84@3570L6,85@3671L4,86@3764L4:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r29 & 1
            if (r1 == 0) goto L_0x0022
            r2 = r8 | 6
            r3 = r2
            r2 = r20
            goto L_0x0036
        L_0x0022:
            r2 = r8 & 14
            if (r2 != 0) goto L_0x0033
            r2 = r20
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0030
            r3 = 4
            goto L_0x0031
        L_0x0030:
            r3 = 2
        L_0x0031:
            r3 = r3 | r8
            goto L_0x0036
        L_0x0033:
            r2 = r20
            r3 = r8
        L_0x0036:
            r4 = r29 & 2
            if (r4 == 0) goto L_0x003d
            r3 = r3 | 48
            goto L_0x0050
        L_0x003d:
            r5 = r8 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0050
            r5 = r21
            boolean r6 = r0.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004c
            r6 = 32
            goto L_0x004e
        L_0x004c:
            r6 = 16
        L_0x004e:
            r3 = r3 | r6
            goto L_0x0052
        L_0x0050:
            r5 = r21
        L_0x0052:
            r6 = r29 & 4
            if (r6 == 0) goto L_0x0059
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x0059:
            r9 = r8 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x006c
            r9 = r22
            boolean r10 = r0.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0068
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r10 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r3 = r3 | r10
            goto L_0x006e
        L_0x006c:
            r9 = r22
        L_0x006e:
            r10 = r29 & 8
            if (r10 == 0) goto L_0x0075
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0075:
            r11 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x0088
            r11 = r23
            boolean r12 = r0.changed((boolean) r11)
            if (r12 == 0) goto L_0x0084
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r3 = r3 | r12
            goto L_0x008a
        L_0x0088:
            r11 = r23
        L_0x008a:
            r12 = r29 & 16
            if (r12 == 0) goto L_0x0091
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a6
        L_0x0091:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r8
            if (r13 != 0) goto L_0x00a6
            r13 = r24
            boolean r14 = r0.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00a2
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r3 = r3 | r14
            goto L_0x00a8
        L_0x00a6:
            r13 = r24
        L_0x00a8:
            r14 = r29 & 32
            if (r14 == 0) goto L_0x00b0
            r15 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r15
            goto L_0x00c5
        L_0x00b0:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r8
            if (r15 != 0) goto L_0x00c5
            r15 = r25
            boolean r16 = r0.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00c0
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r3 = r3 | r16
            goto L_0x00c7
        L_0x00c5:
            r15 = r25
        L_0x00c7:
            r16 = r29 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00d0
            r3 = r3 | r17
            goto L_0x00e3
        L_0x00d0:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r8 & r16
            if (r16 != 0) goto L_0x00e3
            boolean r16 = r0.changed((java.lang.Object) r7)
            if (r16 == 0) goto L_0x00df
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r3 = r3 | r16
        L_0x00e3:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r2 = r3 & r16
            r5 = 599186(0x92492, float:8.39638E-40)
            if (r2 != r5) goto L_0x0101
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x00f4
            goto L_0x0101
        L_0x00f4:
            r0.skipToGroupEnd()
            r1 = r20
            r2 = r21
            r3 = r9
            r4 = r11
            r5 = r13
            r6 = r15
            goto L_0x01e1
        L_0x0101:
            if (r1 == 0) goto L_0x0108
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x010a
        L_0x0108:
            r1 = r20
        L_0x010a:
            r2 = 0
            if (r4 == 0) goto L_0x010f
            r4 = r2
            goto L_0x0111
        L_0x010f:
            r4 = r21
        L_0x0111:
            if (r6 == 0) goto L_0x0115
            r5 = r2
            goto L_0x0116
        L_0x0115:
            r5 = r9
        L_0x0116:
            r6 = 1
            if (r10 == 0) goto L_0x011c
            r19 = 1
            goto L_0x011e
        L_0x011c:
            r19 = r11
        L_0x011e:
            if (r12 == 0) goto L_0x0121
            r13 = r2
        L_0x0121:
            if (r14 == 0) goto L_0x0124
            goto L_0x0125
        L_0x0124:
            r2 = r15
        L_0x0125:
            androidx.compose.material.MaterialTheme r9 = androidx.compose.material.MaterialTheme.INSTANCE
            r10 = 6
            androidx.compose.material.Typography r9 = r9.getTypography(r0, r10)
            androidx.compose.ui.text.TextStyle r11 = r9.getSubtitle1()
            androidx.compose.material.ContentAlpha r12 = androidx.compose.material.ContentAlpha.INSTANCE
            float r12 = r12.getHigh(r0, r10)
            kotlin.jvm.functions.Function2 r12 = applyTextStyle(r11, r12, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            androidx.compose.ui.text.TextStyle r11 = r9.getBody2()
            androidx.compose.material.ContentAlpha r14 = androidx.compose.material.ContentAlpha.INSTANCE
            float r14 = r14.getMedium(r0, r10)
            kotlin.jvm.functions.Function2 r14 = applyTextStyle(r11, r14, r5)
            androidx.compose.ui.text.TextStyle r11 = r9.getOverline()
            androidx.compose.material.ContentAlpha r15 = androidx.compose.material.ContentAlpha.INSTANCE
            float r15 = r15.getHigh(r0, r10)
            kotlin.jvm.functions.Function2 r15 = applyTextStyle(r11, r15, r13)
            androidx.compose.ui.text.TextStyle r9 = r9.getCaption()
            androidx.compose.material.ContentAlpha r11 = androidx.compose.material.ContentAlpha.INSTANCE
            float r10 = r11.getHigh(r0, r10)
            kotlin.jvm.functions.Function2 r16 = applyTextStyle(r9, r10, r2)
            androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1 r9 = androidx.compose.material.ListItemKt$ListItem$semanticsModifier$1.INSTANCE
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.ui.Modifier r10 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r1, r6, r9)
            if (r14 != 0) goto L_0x0193
            if (r15 != 0) goto L_0x0193
            r6 = -210280579(0xfffffffff3775f7d, float:-1.9598908E31)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "91@3942L61"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            androidx.compose.material.OneLine r9 = androidx.compose.material.OneLine.INSTANCE
            r3 = r3 & 112(0x70, float:1.57E-43)
            r15 = r3 | 24576(0x6000, float:3.4438E-41)
            r3 = 0
            r11 = r4
            r6 = r13
            r13 = r16
            r14 = r0
            r16 = r3
            r9.ListItem(r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            goto L_0x01db
        L_0x0193:
            r6 = r13
            if (r15 != 0) goto L_0x0198
            if (r19 != 0) goto L_0x019a
        L_0x0198:
            if (r14 != 0) goto L_0x01bb
        L_0x019a:
            r9 = -210280382(0xfffffffff3776042, float:-1.9599146E31)
            r0.startReplaceableGroup(r9)
            java.lang.String r9 = "95@4139L184"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            androidx.compose.material.TwoLine r9 = androidx.compose.material.TwoLine.INSTANCE
            r3 = r3 & 112(0x70, float:1.57E-43)
            r17 = r3 | r17
            r18 = 0
            r11 = r4
            r13 = r14
            r14 = r15
            r15 = r16
            r16 = r0
            r9.ListItem(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0.endReplaceableGroup()
            goto L_0x01db
        L_0x01bb:
            r9 = -210280168(0xfffffffff3776118, float:-1.9599405E31)
            r0.startReplaceableGroup(r9)
            java.lang.String r9 = "104@4355L184"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            androidx.compose.material.ThreeLine r9 = androidx.compose.material.ThreeLine.INSTANCE
            r3 = r3 & 112(0x70, float:1.57E-43)
            r17 = r3 | r17
            r18 = 0
            r11 = r4
            r13 = r14
            r14 = r15
            r15 = r16
            r16 = r0
            r9.ListItem(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0.endReplaceableGroup()
        L_0x01db:
            r3 = r5
            r5 = r6
            r6 = r2
            r2 = r4
            r4 = r19
        L_0x01e1:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x01e8
            goto L_0x01f9
        L_0x01e8:
            androidx.compose.material.ListItemKt$ListItem$1 r11 = new androidx.compose.material.ListItemKt$ListItem$1
            r0 = r11
            r7 = r26
            r8 = r28
            r9 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x01f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ListItemKt.ListItem(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void BaselinesOffsetColumn(List<Dp> list, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        Composer startRestartGroup = composer.startRestartGroup(1631148337);
        ComposerKt.sourceInformation(startRestartGroup, "C(BaselinesOffsetColumn)P(2,1)352@13107L1127:ListItem.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        Modifier modifier2 = modifier;
        MeasurePolicy listItemKt$BaselinesOffsetColumn$1 = new ListItemKt$BaselinesOffsetColumn$1(list);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier2);
        int i3 = (((((i >> 6) & 14) | (i & 112)) << 9) & 7168) | 6;
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r4 = Updater.m1543constructorimpl(startRestartGroup);
        Updater.m1550setimpl(r4, listItemKt$BaselinesOffsetColumn$1, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1550setimpl(r4, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1550setimpl(r4, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1550setimpl(r4, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i3 >> 3) & 112));
        startRestartGroup.startReplaceableGroup(2058660585);
        function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 9) & 14));
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$BaselinesOffsetColumn$2(list, modifier2, function2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: OffsetToBaselineOrCenter-Kz89ssw  reason: not valid java name */
    public static final void m1316OffsetToBaselineOrCenterKz89ssw(float f, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1062692685);
        ComposerKt.sourceInformation(startRestartGroup, "C(OffsetToBaselineOrCenter)P(2:c#ui.unit.Dp,1)394@14762L806:ListItem.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) modifier) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changed((Object) function2) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            MeasurePolicy listItemKt$OffsetToBaselineOrCenter$1 = new ListItemKt$OffsetToBaselineOrCenter$1(f);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i5 = ((((i3 & 112) | ((i3 >> 6) & 14)) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r4 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r4, listItemKt$OffsetToBaselineOrCenter$1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r4, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r4, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r4, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i5 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(startRestartGroup, Integer.valueOf((i5 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemKt$OffsetToBaselineOrCenter$2(f, modifier2, function2, i, i2));
        }
    }

    private static final Function2<Composer, Integer, Unit> applyTextStyle(TextStyle textStyle, float f, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (function2 == null) {
            return null;
        }
        return ComposableLambdaKt.composableLambdaInstance(-830176860, true, new ListItemKt$applyTextStyle$1(f, textStyle, function2));
    }
}
