package io.intercom.android.sdk.m5.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112 \b\u0002\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001b\u001a\r\u0010\u001c\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001b\u001a\r\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001b\u001a\r\u0010\u001e\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001b\u001a\r\u0010\u001f\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001b\u001a\r\u0010 \u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006!"}, d2 = {"TopActionBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "", "subtitle", "avatars", "", "Lio/intercom/android/sdk/models/Avatar;", "onBackClick", "Lkotlin/Function0;", "navIcon", "Landroidx/compose/ui/graphics/painter/Painter;", "isActive", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "menuItems", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "TopActionBar-6oU6zVQ", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/painter/Painter;ZJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopActionBarAvatarPreview", "(Landroidx/compose/runtime/Composer;I)V", "TopActionBarBackButtonPreview", "TopActionBarEndContentPreview", "TopActionBarGroupChatPreview", "TopActionBarMultipleAvatarsPreview", "TopActionBarTitlePreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TopActionBar.kt */
public final class TopActionBarKt {
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0746  */
    /* JADX WARNING: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0131  */
    /* renamed from: TopActionBar-6oU6zVQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5180TopActionBar6oU6zVQ(androidx.compose.ui.Modifier r60, java.lang.String r61, java.lang.String r62, java.util.List<? extends io.intercom.android.sdk.models.Avatar> r63, kotlin.jvm.functions.Function0<kotlin.Unit> r64, androidx.compose.ui.graphics.painter.Painter r65, boolean r66, long r67, long r69, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r71, androidx.compose.runtime.Composer r72, int r73, int r74) {
        /*
            r2 = r61
            r3 = r73
            r0 = r74
            java.lang.String r1 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            r1 = -644560533(0xffffffffd994c96b, float:-5.2349697E15)
            r4 = r72
            androidx.compose.runtime.Composer r13 = r4.startRestartGroup(r1)
            r1 = r0 & 1
            if (r1 == 0) goto L_0x001e
            r4 = r3 | 6
            r5 = r4
            r4 = r60
            goto L_0x0032
        L_0x001e:
            r4 = r3 & 14
            if (r4 != 0) goto L_0x002f
            r4 = r60
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x002c
            r5 = 4
            goto L_0x002d
        L_0x002c:
            r5 = 2
        L_0x002d:
            r5 = r5 | r3
            goto L_0x0032
        L_0x002f:
            r4 = r60
            r5 = r3
        L_0x0032:
            r6 = r0 & 2
            if (r6 == 0) goto L_0x0039
            r5 = r5 | 48
            goto L_0x0049
        L_0x0039:
            r6 = r3 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0049
            boolean r6 = r13.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r5 = r5 | r6
        L_0x0049:
            r6 = r0 & 4
            if (r6 == 0) goto L_0x0050
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r8 = r3 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0063
            r8 = r62
            boolean r9 = r13.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r5 = r5 | r9
            goto L_0x0065
        L_0x0063:
            r8 = r62
        L_0x0065:
            r9 = r0 & 8
            if (r9 == 0) goto L_0x006b
            r5 = r5 | 1024(0x400, float:1.435E-42)
        L_0x006b:
            r10 = r0 & 16
            if (r10 == 0) goto L_0x0072
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0087
        L_0x0072:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r3
            if (r11 != 0) goto L_0x0087
            r11 = r64
            boolean r12 = r13.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0083
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0085
        L_0x0083:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0085:
            r5 = r5 | r12
            goto L_0x0089
        L_0x0087:
            r11 = r64
        L_0x0089:
            r12 = r0 & 32
            if (r12 == 0) goto L_0x0090
            r15 = 65536(0x10000, float:9.18355E-41)
            r5 = r5 | r15
        L_0x0090:
            r15 = r0 & 64
            if (r15 == 0) goto L_0x009b
            r16 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r16
            r7 = r66
            goto L_0x00b0
        L_0x009b:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r3 & r16
            r7 = r66
            if (r16 != 0) goto L_0x00b0
            boolean r16 = r13.changed((boolean) r7)
            if (r16 == 0) goto L_0x00ac
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ae
        L_0x00ac:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00ae:
            r5 = r5 | r16
        L_0x00b0:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r3 & r16
            if (r16 != 0) goto L_0x00c9
            r14 = r0 & 128(0x80, float:1.794E-43)
            r7 = r67
            if (r14 != 0) goto L_0x00c5
            boolean r14 = r13.changed((long) r7)
            if (r14 == 0) goto L_0x00c5
            r14 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00c7
        L_0x00c5:
            r14 = 4194304(0x400000, float:5.877472E-39)
        L_0x00c7:
            r5 = r5 | r14
            goto L_0x00cb
        L_0x00c9:
            r7 = r67
        L_0x00cb:
            r14 = 234881024(0xe000000, float:1.5777218E-30)
            r14 = r14 & r3
            if (r14 != 0) goto L_0x00e3
            r14 = r0 & 256(0x100, float:3.59E-43)
            r7 = r69
            if (r14 != 0) goto L_0x00df
            boolean r14 = r13.changed((long) r7)
            if (r14 == 0) goto L_0x00df
            r14 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00e1
        L_0x00df:
            r14 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00e1:
            r5 = r5 | r14
            goto L_0x00e5
        L_0x00e3:
            r7 = r69
        L_0x00e5:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x00f0
            r17 = 805306368(0x30000000, float:4.656613E-10)
            r5 = r5 | r17
            r2 = r71
            goto L_0x0105
        L_0x00f0:
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r3 & r17
            r2 = r71
            if (r17 != 0) goto L_0x0105
            boolean r17 = r13.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x0101
            r17 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0103
        L_0x0101:
            r17 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0103:
            r5 = r5 | r17
        L_0x0105:
            r2 = r0 & 40
            r4 = 40
            if (r2 != r4) goto L_0x0131
            r2 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r2 & r5
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r4) goto L_0x0131
            boolean r2 = r13.getSkipping()
            if (r2 != 0) goto L_0x011b
            goto L_0x0131
        L_0x011b:
            r13.skipToGroupEnd()
            r36 = r60
            r3 = r62
            r4 = r63
            r6 = r65
            r12 = r71
            r5 = r11
            r1 = r13
            r10 = r7
            r7 = r66
            r8 = r67
            goto L_0x073f
        L_0x0131:
            r13.startDefaults()
            r2 = r3 & 1
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r8 = 0
            if (r2 == 0) goto L_0x0172
            boolean r2 = r13.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0143
            goto L_0x0172
        L_0x0143:
            r13.skipToGroupEnd()
            if (r9 == 0) goto L_0x014a
            r5 = r5 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x014a:
            if (r12 == 0) goto L_0x014d
            r5 = r5 & r4
        L_0x014d:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0155
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r5 = r5 & r1
        L_0x0155:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x015d
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r5 = r5 & r1
        L_0x015d:
            r2 = r60
            r26 = r62
            r27 = r63
            r28 = r64
            r14 = r65
            r29 = r66
            r30 = r67
            r9 = r69
            r12 = r71
        L_0x016f:
            r7 = r5
            goto L_0x01e9
        L_0x0172:
            if (r1 == 0) goto L_0x0179
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x017b
        L_0x0179:
            r1 = r60
        L_0x017b:
            if (r6 == 0) goto L_0x0180
            java.lang.String r2 = ""
            goto L_0x0182
        L_0x0180:
            r2 = r62
        L_0x0182:
            if (r9 == 0) goto L_0x018b
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            r5 = r5 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x018d
        L_0x018b:
            r6 = r63
        L_0x018d:
            if (r10 == 0) goto L_0x0191
            r7 = 0
            goto L_0x0193
        L_0x0191:
            r7 = r64
        L_0x0193:
            if (r12 == 0) goto L_0x019d
            int r9 = io.intercom.android.sdk.R.drawable.intercom_back
            androidx.compose.ui.graphics.painter.Painter r9 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r9, r13, r8)
            r5 = r5 & r4
            goto L_0x019f
        L_0x019d:
            r9 = r65
        L_0x019f:
            if (r15 == 0) goto L_0x01a3
            r4 = 0
            goto L_0x01a5
        L_0x01a3:
            r4 = r66
        L_0x01a5:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x01b4
            io.intercom.android.sdk.m5.IntercomTheme r10 = io.intercom.android.sdk.m5.IntercomTheme.INSTANCE
            long r17 = r10.m5119getHeader0d7_KjU$intercom_sdk_base_release()
            r10 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r5 = r5 & r10
            goto L_0x01b6
        L_0x01b4:
            r17 = r67
        L_0x01b6:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x01c5
            io.intercom.android.sdk.m5.IntercomTheme r10 = io.intercom.android.sdk.m5.IntercomTheme.INSTANCE
            long r19 = r10.m5120getOnHeader0d7_KjU$intercom_sdk_base_release()
            r10 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r5 = r5 & r10
            goto L_0x01c7
        L_0x01c5:
            r19 = r69
        L_0x01c7:
            if (r14 == 0) goto L_0x01d8
            r26 = r2
            r29 = r4
            r27 = r6
            r28 = r7
            r14 = r9
            r30 = r17
            r9 = r19
            r12 = 0
            goto L_0x01e7
        L_0x01d8:
            r12 = r71
            r26 = r2
            r29 = r4
            r27 = r6
            r28 = r7
            r14 = r9
            r30 = r17
            r9 = r19
        L_0x01e7:
            r2 = r1
            goto L_0x016f
        L_0x01e9:
            r13.endDefaults()
            r1 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.foundation.layout.Arrangement r4 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r4 = r4.getTop()
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r5 = r5.getStart()
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r4, r5, r13, r8)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r5)
            java.lang.String r6 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r11 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r11)
            java.lang.Object r15 = r13.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r15 = (androidx.compose.ui.unit.Density) r15
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r8 = r18
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r11)
            java.lang.Object r8 = r13.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r0 = r18
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r11)
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.platform.ViewConfiguration r0 = (androidx.compose.ui.platform.ViewConfiguration) r0
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r18.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r3 = r13.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x026a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x026a:
            r13.startReusableNode()
            boolean r3 = r13.getInserting()
            if (r3 == 0) goto L_0x0277
            r13.createNode(r5)
            goto L_0x027a
        L_0x0277:
            r13.useNode()
        L_0x027a:
            r13.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m1543constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r4, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r15, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r8, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r0, r4)
            r13.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r0)
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r1.invoke(r0, r13, r4)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            r1 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r1 = (androidx.compose.foundation.layout.ColumnScope) r1
            r1 = 0
            r3 = 1
            r8 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r2, r1, r3, r8)
            r4 = 0
            r5 = 2
            r15 = 0
            r62 = r1
            r63 = r30
            r65 = r4
            r66 = r5
            r67 = r15
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r62, r63, r65, r66, r67)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.WindowInsetsPadding_androidKt.statusBarsPadding(r1)
            r4 = 56
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r1, r4)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r4 = r4.getCenterVertically()
            r5 = 693286680(0x2952b718, float:4.6788176E-14)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = r5.getStart()
            r15 = 48
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r4, r13, r15)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r8, r11)
            java.lang.Object r5 = r13.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r15 = r18
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r8, r11)
            java.lang.Object r15 = r13.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r15 = (androidx.compose.ui.unit.LayoutDirection) r15
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r3 = r18
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r8, r11)
            java.lang.Object r3 = r13.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.platform.ViewConfiguration r3 = (androidx.compose.ui.platform.ViewConfiguration) r3
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r0 = r13.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x036c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x036c:
            r13.startReusableNode()
            boolean r0 = r13.getInserting()
            if (r0 == 0) goto L_0x0379
            r13.createNode(r8)
            goto L_0x037c
        L_0x0379:
            r13.useNode()
        L_0x037c:
            r13.disableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m1543constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r0, r4, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r0, r5, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r0, r15, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r0, r3, r4)
            r13.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r0)
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r1.invoke(r0, r13, r4)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            r0 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r13.startReplaceableGroup(r0)
            java.lang.String r0 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r3 = r0
            androidx.compose.foundation.layout.RowScope r3 = (androidx.compose.foundation.layout.RowScope) r3
            r0 = 633003750(0x25badee6, float:3.2416899E-16)
            r13.startReplaceableGroup(r0)
            r0 = 6
            if (r28 != 0) goto L_0x03da
            goto L_0x0419
        L_0x03da:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r8 = 4
            float r4 = (float) r8
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r1, r4)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r13, r0)
            r1 = 0
            r4 = 0
            r5 = 0
            r15 = 971091490(0x39e1ae22, float:4.3045083E-4)
            io.intercom.android.sdk.m5.components.TopActionBarKt$TopActionBar$1$1$1$1 r8 = new io.intercom.android.sdk.m5.components.TopActionBarKt$TopActionBar$1$1$1$1
            r8.<init>(r14, r9, r7)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r15, r0, r8)
            r0 = r8
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8 = 24576(0x6000, float:3.4438E-41)
            r15 = 14
            r62 = r28
            r63 = r1
            r64 = r4
            r65 = r5
            r66 = r0
            r67 = r13
            r68 = r8
            r69 = r15
            androidx.compose.material.IconButtonKt.IconButton(r62, r63, r64, r65, r66, r67, r68, r69)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0419:
            r13.endReplaceableGroup()
            int r0 = r27.size()
            r1 = 1
            if (r0 != r1) goto L_0x0477
            r0 = 633004196(0x25bae0a4, float:3.241808E-16)
            r13.startReplaceableGroup(r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = 16
            float r4 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r0, r1)
            r1 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r13, r1)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r27)
            io.intercom.android.sdk.models.Avatar r0 = (io.intercom.android.sdk.models.Avatar) r0
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r4 = 24
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m582size3ABfNKs(r1, r4)
            r4 = 0
            r22 = 0
            r5 = 0
            int r8 = r7 >> 9
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r8 = r8 | 56
            r15 = 52
            r62 = r0
            r63 = r1
            r64 = r4
            r65 = r29
            r66 = r22
            r68 = r5
            r69 = r13
            r70 = r8
            r71 = r15
            io.intercom.android.sdk.m5.components.AvatarIconKt.m5124AvatarIconRd90Nhg(r62, r63, r64, r65, r66, r68, r69, r70, r71)
            r13.endReplaceableGroup()
            r8 = 1
            goto L_0x04cc
        L_0x0477:
            int r0 = r27.size()
            r8 = 1
            if (r0 <= r8) goto L_0x04c3
            r0 = 633004481(0x25bae1c1, float:3.2418833E-16)
            r13.startReplaceableGroup(r0)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = 16
            float r4 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r0, r1)
            r1 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r13, r1)
            r0 = r27
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 3
            java.util.List r0 = kotlin.collections.CollectionsKt.take(r0, r1)
            r1 = 0
            r4 = 24
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            r22 = 0
            r5 = 392(0x188, float:5.5E-43)
            r15 = 10
            r62 = r0
            r63 = r1
            r64 = r4
            r65 = r22
            r67 = r13
            r68 = r5
            r69 = r15
            io.intercom.android.sdk.m5.components.AvatarGroupKt.m5121AvatarGroupJ8mCjc(r62, r63, r64, r65, r67, r68, r69)
            r13.endReplaceableGroup()
            goto L_0x04cc
        L_0x04c3:
            r0 = 633004686(0x25bae28e, float:3.2419376E-16)
            r13.startReplaceableGroup(r0)
            r13.endReplaceableGroup()
        L_0x04cc:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = 16
            float r4 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r0, r1)
            r5 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r13, r5)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = 1065353216(0x3f800000, float:1.0)
            r15 = 0
            r22 = 2
            r23 = 0
            r62 = r3
            r63 = r0
            r64 = r1
            r65 = r15
            r66 = r22
            r67 = r23
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r62, r63, r64, r65, r66, r67)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r1 = r1.getStart()
            r15 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r13.startReplaceableGroup(r15)
            java.lang.String r15 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r15)
            androidx.compose.foundation.layout.Arrangement r15 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r15 = r15.getTop()
            r5 = 48
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r15, r1, r13, r5)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r11)
            java.lang.Object r5 = r13.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r11)
            java.lang.Object r15 = r13.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r15 = (androidx.compose.ui.unit.LayoutDirection) r15
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r8 = r19
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r11)
            java.lang.Object r6 = r13.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r11 = r13.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0570
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0570:
            r13.startReusableNode()
            boolean r11 = r13.getInserting()
            if (r11 == 0) goto L_0x057d
            r13.createNode(r8)
            goto L_0x0580
        L_0x057d:
            r13.useNode()
        L_0x0580:
            r13.disableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m1543constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r1, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r5, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r15, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r6, r1)
            r13.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            r8 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r0.invoke(r1, r13, r5)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            r0 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r13.startReplaceableGroup(r0)
            java.lang.String r0 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            androidx.compose.foundation.layout.ColumnScopeInstance r0 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r0 = (androidx.compose.foundation.layout.ColumnScope) r0
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r11 = 8
            androidx.compose.material.Typography r0 = r0.getTypography(r13, r11)
            androidx.compose.ui.text.TextStyle r32 = r0.getH6()
            r35 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r55 = 0
            r56 = 262142(0x3fffe, float:3.67339E-40)
            r57 = 0
            r33 = r9
            androidx.compose.ui.text.TextStyle r19 = androidx.compose.ui.text.TextStyle.m4228copyHL5avdY$default(r32, r33, r35, r37, r38, r39, r40, r41, r42, r44, r45, r46, r47, r49, r50, r51, r52, r53, r55, r56, r57)
            androidx.compose.ui.text.style.TextAlign$Companion r0 = androidx.compose.ui.text.style.TextAlign.Companion
            int r0 = r0.m4559getStarte0LSkKk()
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r15 = r1.m4591getEllipsisgIe3tQ8()
            r1 = 0
            r5 = 0
            r32 = r4
            r20 = 6
            r4 = r5
            r6 = 0
            r18 = 0
            r25 = r7
            r7 = r18
            r16 = 0
            r17 = 4
            r24 = 1
            r8 = r18
            r21 = 0
            r9 = r21
            r11 = r18
            androidx.compose.ui.text.style.TextAlign r0 = androidx.compose.ui.text.style.TextAlign.m4547boximpl(r0)
            r58 = r12
            r12 = r0
            r0 = r13
            r35 = r14
            r13 = r21
            r16 = 0
            r17 = 1
            int r21 = r25 >> 3
            r21 = r21 & 14
            int r1 = r25 >> 18
            r1 = r1 & 896(0x380, float:1.256E-42)
            r21 = r21 | r1
            r22 = 3120(0xc30, float:4.372E-42)
            r23 = 22010(0x55fa, float:3.0843E-41)
            r62 = r0
            r0 = r61
            r36 = r2
            r59 = r3
            r2 = r33
            r20 = r62
            r24 = r1
            r1 = 0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = 633005184(0x25bae480, float:3.2420694E-16)
            r1 = r62
            r1.startReplaceableGroup(r0)
            r0 = r26
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0679
            r8 = 1
            goto L_0x067a
        L_0x0679:
            r8 = 0
        L_0x067a:
            if (r8 == 0) goto L_0x06be
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r2 = 8
            androidx.compose.material.Typography r0 = r0.getTypography(r1, r2)
            androidx.compose.ui.text.TextStyle r21 = r0.getCaption()
            androidx.compose.ui.text.style.TextAlign$Companion r0 = androidx.compose.ui.text.style.TextAlign.Companion
            int r0 = r0.m4559getStarte0LSkKk()
            androidx.compose.ui.text.style.TextOverflow$Companion r2 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r17 = r2.m4591getEllipsisgIe3tQ8()
            r3 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            androidx.compose.ui.text.style.TextAlign r14 = androidx.compose.ui.text.style.TextAlign.m4547boximpl(r0)
            r15 = 0
            r18 = 0
            r19 = 1
            r20 = 0
            r0 = 6
            int r2 = r25 >> 6
            r2 = r2 & 14
            r23 = r2 | r24
            r24 = 3120(0xc30, float:4.372E-42)
            r25 = 22010(0x55fa, float:3.0843E-41)
            r2 = r26
            r4 = r33
            r22 = r1
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r2, r3, r4, r6, r8, r9, r10, r11, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x06bf
        L_0x06be:
            r0 = 6
        L_0x06bf:
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r32)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r2, r3)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r2, r1, r0)
            r2 = -265180987(0xfffffffff031a8c5, float:-2.199315E29)
            r1.startReplaceableGroup(r2)
            r11 = r58
            if (r11 != 0) goto L_0x06eb
            goto L_0x0709
        L_0x06eb:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r3 = r59
            r11.invoke(r3, r1, r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 4
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r2, r3)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r2, r1, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0709:
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r0 = 0
            r2 = 0
            r3 = 1
            io.intercom.android.sdk.m5.components.IntercomDividerKt.IntercomDivider(r0, r1, r2, r3)
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r12 = r11
            r3 = r26
            r4 = r27
            r5 = r28
            r7 = r29
            r8 = r30
            r10 = r33
            r6 = r35
        L_0x073f:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 != 0) goto L_0x0746
            goto L_0x075c
        L_0x0746:
            io.intercom.android.sdk.m5.components.TopActionBarKt$TopActionBar$2 r16 = new io.intercom.android.sdk.m5.components.TopActionBarKt$TopActionBar$2
            r0 = r16
            r1 = r36
            r2 = r61
            r13 = r73
            r14 = r74
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r10, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x075c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.components.TopActionBarKt.m5180TopActionBar6oU6zVQ(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.util.List, kotlin.jvm.functions.Function0, androidx.compose.ui.graphics.painter.Painter, boolean, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void TopActionBarAvatarPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-876643721);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TopActionBarKt.INSTANCE.m5171getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TopActionBarKt$TopActionBarAvatarPreview$1(i));
        }
    }

    public static final void TopActionBarGroupChatPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(86306281);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TopActionBarKt.INSTANCE.m5172getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TopActionBarKt$TopActionBarGroupChatPreview$1(i));
        }
    }

    public static final void TopActionBarMultipleAvatarsPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1436789380);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TopActionBarKt.INSTANCE.m5173getLambda3$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TopActionBarKt$TopActionBarMultipleAvatarsPreview$1(i));
        }
    }

    public static final void TopActionBarBackButtonPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1611748073);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TopActionBarKt.INSTANCE.m5174getLambda4$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TopActionBarKt$TopActionBarBackButtonPreview$1(i));
        }
    }

    public static final void TopActionBarTitlePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1648201034);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TopActionBarKt.INSTANCE.m5175getLambda5$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TopActionBarKt$TopActionBarTitlePreview$1(i));
        }
    }

    public static final void TopActionBarEndContentPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1992822204);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TopActionBarKt.INSTANCE.m5178getLambda8$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TopActionBarKt$TopActionBarEndContentPreview$1(i));
        }
    }
}
