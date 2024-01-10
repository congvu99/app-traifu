package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a©\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"Group", "", "name", "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: VectorCompose.kt */
public final class VectorComposeKt {
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Group(java.lang.String r20, float r21, float r22, float r23, float r24, float r25, float r26, float r27, java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode> r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r10 = r29
            r11 = r31
            r12 = r32
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -213417674(0xfffffffff3478136, float:-1.5806393E31)
            r1 = r30
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            java.lang.String r2 = "C(Group)P(2,5,3,4,6,7,8,9)40@1441L585:VectorCompose.kt#huu6hf"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x0023
            r3 = r11 | 6
            r4 = r3
            r3 = r20
            goto L_0x0037
        L_0x0023:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x0034
            r3 = r20
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0031
            r4 = 4
            goto L_0x0032
        L_0x0031:
            r4 = 2
        L_0x0032:
            r4 = r4 | r11
            goto L_0x0037
        L_0x0034:
            r3 = r20
            r4 = r11
        L_0x0037:
            r5 = r12 & 2
            if (r5 == 0) goto L_0x003e
            r4 = r4 | 48
            goto L_0x0051
        L_0x003e:
            r6 = r11 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0051
            r6 = r21
            boolean r7 = r1.changed((float) r6)
            if (r7 == 0) goto L_0x004d
            r7 = 32
            goto L_0x004f
        L_0x004d:
            r7 = 16
        L_0x004f:
            r4 = r4 | r7
            goto L_0x0053
        L_0x0051:
            r6 = r21
        L_0x0053:
            r7 = r12 & 4
            if (r7 == 0) goto L_0x005a
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r9 = r11 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x006d
            r9 = r22
            boolean r13 = r1.changed((float) r9)
            if (r13 == 0) goto L_0x0069
            r13 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r13 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r4 = r4 | r13
            goto L_0x006f
        L_0x006d:
            r9 = r22
        L_0x006f:
            r13 = r12 & 8
            if (r13 == 0) goto L_0x0076
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r14 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r14 != 0) goto L_0x0089
            r14 = r23
            boolean r15 = r1.changed((float) r14)
            if (r15 == 0) goto L_0x0085
            r15 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r15 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r4 = r4 | r15
            goto L_0x008b
        L_0x0089:
            r14 = r23
        L_0x008b:
            r15 = r12 & 16
            if (r15 == 0) goto L_0x0094
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            r0 = r24
            goto L_0x00aa
        L_0x0094:
            r16 = 57344(0xe000, float:8.0356E-41)
            r16 = r11 & r16
            r0 = r24
            if (r16 != 0) goto L_0x00aa
            boolean r17 = r1.changed((float) r0)
            if (r17 == 0) goto L_0x00a6
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a8
        L_0x00a6:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x00a8:
            r4 = r4 | r17
        L_0x00aa:
            r17 = r12 & 32
            if (r17 == 0) goto L_0x00b5
            r18 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r18
            r8 = r25
            goto L_0x00ca
        L_0x00b5:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r11 & r18
            r8 = r25
            if (r18 != 0) goto L_0x00ca
            boolean r18 = r1.changed((float) r8)
            if (r18 == 0) goto L_0x00c6
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00c6:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00c8:
            r4 = r4 | r18
        L_0x00ca:
            r18 = r12 & 64
            if (r18 == 0) goto L_0x00d5
            r19 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r19
            r0 = r26
            goto L_0x00ea
        L_0x00d5:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r19 = r11 & r19
            r0 = r26
            if (r19 != 0) goto L_0x00ea
            boolean r19 = r1.changed((float) r0)
            if (r19 == 0) goto L_0x00e6
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e8
        L_0x00e6:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00e8:
            r4 = r4 | r19
        L_0x00ea:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f5
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r19
            r3 = r27
            goto L_0x010a
        L_0x00f5:
            r19 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r11 & r19
            r3 = r27
            if (r19 != 0) goto L_0x010a
            boolean r19 = r1.changed((float) r3)
            if (r19 == 0) goto L_0x0106
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0108
        L_0x0106:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x0108:
            r4 = r4 | r19
        L_0x010a:
            r3 = r12 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0112
            r19 = 33554432(0x2000000, float:9.403955E-38)
            r4 = r4 | r19
        L_0x0112:
            r6 = r12 & 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x011a
            r6 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0118:
            r4 = r4 | r6
            goto L_0x012b
        L_0x011a:
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r6 = r6 & r11
            if (r6 != 0) goto L_0x012b
            boolean r6 = r1.changed((java.lang.Object) r10)
            if (r6 == 0) goto L_0x0128
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0118
        L_0x0128:
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0118
        L_0x012b:
            r6 = 256(0x100, float:3.59E-43)
            if (r3 != r6) goto L_0x0154
            r6 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r6 = r6 & r4
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            if (r6 != r8) goto L_0x0154
            boolean r6 = r1.getSkipping()
            if (r6 != 0) goto L_0x013f
            goto L_0x0154
        L_0x013f:
            r1.skipToGroupEnd()
            r2 = r20
            r5 = r21
            r13 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            r3 = r9
            r4 = r14
            r9 = r28
            goto L_0x0277
        L_0x0154:
            r1.startDefaults()
            r6 = r11 & 1
            r8 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            if (r6 == 0) goto L_0x017a
            boolean r6 = r1.getDefaultsInvalid()
            if (r6 == 0) goto L_0x0165
            goto L_0x017a
        L_0x0165:
            r1.skipToGroupEnd()
            if (r3 == 0) goto L_0x016b
            r4 = r4 & r8
        L_0x016b:
            r2 = r20
            r5 = r21
            r13 = r24
            r7 = r25
            r15 = r26
            r6 = r27
        L_0x0177:
            r0 = r28
            goto L_0x01ae
        L_0x017a:
            if (r2 == 0) goto L_0x017f
            java.lang.String r2 = ""
            goto L_0x0181
        L_0x017f:
            r2 = r20
        L_0x0181:
            r6 = 0
            if (r5 == 0) goto L_0x0186
            r5 = 0
            goto L_0x0188
        L_0x0186:
            r5 = r21
        L_0x0188:
            if (r7 == 0) goto L_0x018b
            r9 = 0
        L_0x018b:
            if (r13 == 0) goto L_0x018e
            r14 = 0
        L_0x018e:
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r15 == 0) goto L_0x0195
            r13 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0197
        L_0x0195:
            r13 = r24
        L_0x0197:
            if (r17 == 0) goto L_0x019a
            goto L_0x019c
        L_0x019a:
            r7 = r25
        L_0x019c:
            if (r18 == 0) goto L_0x01a0
            r15 = 0
            goto L_0x01a2
        L_0x01a0:
            r15 = r26
        L_0x01a2:
            if (r0 == 0) goto L_0x01a5
            goto L_0x01a7
        L_0x01a5:
            r6 = r27
        L_0x01a7:
            if (r3 == 0) goto L_0x0177
            java.util.List r0 = androidx.compose.ui.graphics.vector.VectorKt.getEmptyPath()
            r4 = r4 & r8
        L_0x01ae:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01c0
            r3 = -1
            java.lang.String r8 = "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:28)"
            r11 = -213417674(0xfffffffff3478136, float:-1.5806393E31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r4, r3, r8)
        L_0x01c0:
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1 r3 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1.INSTANCE
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r8 = -548224868(0xffffffffdf52c09c, float:-1.518631E19)
            r1.startReplaceableGroup(r8)
            java.lang.String r8 = "C(ComposeNode)P(1,2)334@12548L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r8)
            androidx.compose.runtime.Applier r8 = r1.getApplier()
            boolean r8 = r8 instanceof androidx.compose.ui.graphics.vector.VectorApplier
            if (r8 != 0) goto L_0x01da
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01da:
            r1.startNode()
            boolean r8 = r1.getInserting()
            if (r8 == 0) goto L_0x01e7
            r1.createNode(r3)
            goto L_0x01ea
        L_0x01e7:
            r1.useNode()
        L_0x01ea:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m1543constructorimpl(r1)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1 r8 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1.INSTANCE
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r2, r8)
            java.lang.Float r8 = java.lang.Float.valueOf(r5)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2.INSTANCE
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r9)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3.INSTANCE
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r14)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4.INSTANCE
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r13)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5.INSTANCE
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r7)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6.INSTANCE
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r15)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7.INSTANCE
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r6)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8.INSTANCE
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9 r8 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9.INSTANCE
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r0, r8)
            r3 = -983907633(0xffffffffc55ac2cf, float:-3500.1755)
            r1.startReplaceableGroup(r3)
            java.lang.String r3 = "C54@2011L9:VectorCompose.kt#huu6hf"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            int r3 = r4 >> 27
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r10.invoke(r1, r3)
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0271
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0271:
            r8 = r6
            r6 = r7
            r3 = r9
            r4 = r14
            r7 = r15
            r9 = r0
        L_0x0277:
            androidx.compose.runtime.ScopeUpdateScope r14 = r1.endRestartGroup()
            if (r14 != 0) goto L_0x027e
            goto L_0x0292
        L_0x027e:
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4 r15 = new androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4
            r0 = r15
            r1 = r2
            r2 = r5
            r5 = r13
            r10 = r29
            r11 = r31
            r12 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x0292:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.Group(java.lang.String, float, float, float, float, float, float, float, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Path-9cdaXJ4  reason: not valid java name */
    public static final void m2641Path9cdaXJ4(List<? extends PathNode> list, int i, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, Composer composer, int i4, int i5, int i6) {
        List<? extends PathNode> list2 = list;
        int i7 = i6;
        Intrinsics.checkNotNullParameter(list2, "pathData");
        Composer startRestartGroup = composer.startRestartGroup(-1478270750);
        ComposerKt.sourceInformation(startRestartGroup, "C(Path)P(3,4:c#ui.graphics.PathFillType,2!4,10,7:c#ui.graphics.StrokeCap,8:c#ui.graphics.StrokeJoin!1,13)76@2665L876:VectorCompose.kt#huu6hf");
        int defaultFillType = (i7 & 2) != 0 ? VectorKt.getDefaultFillType() : i;
        String str2 = (i7 & 4) != 0 ? "" : str;
        Brush brush3 = null;
        Brush brush4 = (i7 & 8) != 0 ? null : brush;
        float f8 = (i7 & 16) != 0 ? 1.0f : f;
        if ((i7 & 32) == 0) {
            brush3 = brush2;
        }
        float f9 = (i7 & 64) != 0 ? 1.0f : f2;
        float f10 = (i7 & 128) != 0 ? 0.0f : f3;
        int defaultStrokeLineCap = (i7 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i2;
        int defaultStrokeLineJoin = (i7 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i3;
        float f11 = (i7 & 1024) != 0 ? 4.0f : f4;
        float f12 = (i7 & 2048) != 0 ? 0.0f : f5;
        float f13 = (i7 & 4096) != 0 ? 1.0f : f6;
        float f14 = (i7 & 8192) != 0 ? 0.0f : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1478270750, i4, i5, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:60)");
        } else {
            int i8 = i4;
            int i9 = i5;
        }
        Function0 function0 = VectorComposeKt$Path$1.INSTANCE;
        startRestartGroup.startReplaceableGroup(1886828752);
        ComposerKt.sourceInformation(startRestartGroup, "C(ComposeNode):Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(new VectorComposeKt$Path9cdaXJ4$$inlined$ComposeNode$1(function0));
        } else {
            startRestartGroup.useNode();
        }
        Composer r0 = Updater.m1543constructorimpl(startRestartGroup);
        Updater.m1550setimpl(r0, str2, VectorComposeKt$Path$2$1.INSTANCE);
        Updater.m1550setimpl(r0, list2, VectorComposeKt$Path$2$2.INSTANCE);
        Updater.m1550setimpl(r0, PathFillType.m2192boximpl(defaultFillType), VectorComposeKt$Path$2$3.INSTANCE);
        Updater.m1550setimpl(r0, brush4, VectorComposeKt$Path$2$4.INSTANCE);
        Updater.m1550setimpl(r0, Float.valueOf(f8), VectorComposeKt$Path$2$5.INSTANCE);
        Updater.m1550setimpl(r0, brush3, VectorComposeKt$Path$2$6.INSTANCE);
        Updater.m1550setimpl(r0, Float.valueOf(f9), VectorComposeKt$Path$2$7.INSTANCE);
        Updater.m1550setimpl(r0, Float.valueOf(f10), VectorComposeKt$Path$2$8.INSTANCE);
        Updater.m1550setimpl(r0, StrokeJoin.m2290boximpl(defaultStrokeLineJoin), VectorComposeKt$Path$2$9.INSTANCE);
        Updater.m1550setimpl(r0, StrokeCap.m2280boximpl(defaultStrokeLineCap), VectorComposeKt$Path$2$10.INSTANCE);
        Updater.m1550setimpl(r0, Float.valueOf(f11), VectorComposeKt$Path$2$11.INSTANCE);
        Updater.m1550setimpl(r0, Float.valueOf(f12), VectorComposeKt$Path$2$12.INSTANCE);
        Updater.m1550setimpl(r0, Float.valueOf(f13), VectorComposeKt$Path$2$13.INSTANCE);
        Updater.m1550setimpl(r0, Float.valueOf(f14), VectorComposeKt$Path$2$14.INSTANCE);
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new VectorComposeKt$Path$3(list, defaultFillType, str2, brush4, f8, brush3, f9, f10, defaultStrokeLineCap, defaultStrokeLineJoin, f11, f12, f13, f14, i4, i5, i6));
        }
    }
}
