package io.intercom.android.sdk.m5;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.ResistanceConfig;
import androidx.compose.material.Shapes;
import androidx.compose.material.SwipeableKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u001a\r\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\t\u001at\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\b0\u0016¢\u0006\u0002\b\u0018H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a3\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!\u001a4\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u00022\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0&2\u0006\u0010'\u001a\u00020\u001fH\u0002\u001a\u001a\u0010(\u001a\u00020\u000f*\u00020\u00022\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&H\u0000\u001a\"\u0010)\u001a\u00020$*\u00020\u00022\u0006\u0010*\u001a\u00020+2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&H\u0000\u001a\f\u0010,\u001a\u00020\u001f*\u00020\u0002H\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006-"}, d2 = {"PreUpPostDownNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/ModalBottomSheetState;", "getPreUpPostDownNestedScrollConnection$annotations", "(Landroidx/compose/material/ModalBottomSheetState;)V", "getPreUpPostDownNestedScrollConnection", "(Landroidx/compose/material/ModalBottomSheetState;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "IntercomRootScreenPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "IntercomStickyBottomSheet", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "shape", "Landroidx/compose/ui/graphics/Shape;", "elevation", "Landroidx/compose/ui/unit/Dp;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "scrimColor", "onSheetDismissed", "Lkotlin/Function0;", "content", "Landroidx/compose/runtime/Composable;", "IntercomStickyBottomSheet-eVqBt0c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;Landroidx/compose/ui/graphics/Shape;FJJLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "color", "onDismiss", "visible", "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "bottomSheetSwipeable", "maxHeight", "", "sheetHeightAsState", "Landroidx/compose/runtime/MutableState;", "enabled", "getEquivalentCorner", "getEquivalentTopPadding", "statusBarHeightPx", "", "isHidden", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomStickyBottomSheet.kt */
public final class IntercomStickyBottomSheetKt {
    @ExperimentalMaterialApi
    public static /* synthetic */ void getPreUpPostDownNestedScrollConnection$annotations(ModalBottomSheetState modalBottomSheetState) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010f  */
    /* renamed from: IntercomStickyBottomSheet-eVqBt0c  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5107IntercomStickyBottomSheeteVqBt0c(androidx.compose.ui.Modifier r30, androidx.compose.material.ModalBottomSheetState r31, androidx.compose.ui.graphics.Shape r32, float r33, long r34, long r36, kotlin.jvm.functions.Function0<kotlin.Unit> r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r12 = r39
            r13 = r41
            r14 = r42
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -784773226(0xffffffffd1394f96, float:-4.9744011E10)
            r1 = r40
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            r0 = r14 & 1
            if (r0 == 0) goto L_0x001e
            r1 = r13 | 6
            r2 = r1
            r1 = r30
            goto L_0x0032
        L_0x001e:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x002f
            r1 = r30
            boolean r2 = r15.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002c
            r2 = 4
            goto L_0x002d
        L_0x002c:
            r2 = 2
        L_0x002d:
            r2 = r2 | r13
            goto L_0x0032
        L_0x002f:
            r1 = r30
            r2 = r13
        L_0x0032:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004b
            r3 = r14 & 2
            if (r3 != 0) goto L_0x0045
            r3 = r31
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0047
            r4 = 32
            goto L_0x0049
        L_0x0045:
            r3 = r31
        L_0x0047:
            r4 = 16
        L_0x0049:
            r2 = r2 | r4
            goto L_0x004d
        L_0x004b:
            r3 = r31
        L_0x004d:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0064
            r4 = r14 & 4
            r7 = r32
            if (r4 != 0) goto L_0x0060
            boolean r4 = r15.changed((java.lang.Object) r7)
            if (r4 == 0) goto L_0x0060
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r2 = r2 | r4
            goto L_0x0066
        L_0x0064:
            r7 = r32
        L_0x0066:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x007d
            r4 = r14 & 8
            r8 = r33
            if (r4 != 0) goto L_0x0079
            boolean r4 = r15.changed((float) r8)
            if (r4 == 0) goto L_0x0079
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r2 = r2 | r4
            goto L_0x007f
        L_0x007d:
            r8 = r33
        L_0x007f:
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r13
            if (r4 != 0) goto L_0x0098
            r4 = r14 & 16
            r9 = r34
            if (r4 != 0) goto L_0x0094
            boolean r4 = r15.changed((long) r9)
            if (r4 == 0) goto L_0x0094
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r2 = r2 | r4
            goto L_0x009a
        L_0x0098:
            r9 = r34
        L_0x009a:
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r13
            if (r4 != 0) goto L_0x00b2
            r4 = r14 & 32
            r5 = r36
            if (r4 != 0) goto L_0x00ae
            boolean r4 = r15.changed((long) r5)
            if (r4 == 0) goto L_0x00ae
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b0
        L_0x00ae:
            r4 = 65536(0x10000, float:9.18355E-41)
        L_0x00b0:
            r2 = r2 | r4
            goto L_0x00b4
        L_0x00b2:
            r5 = r36
        L_0x00b4:
            r11 = r14 & 64
            if (r11 == 0) goto L_0x00bc
            r4 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r4
            goto L_0x00d1
        L_0x00bc:
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r13
            if (r4 != 0) goto L_0x00d1
            r4 = r38
            boolean r16 = r15.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x00cc
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00cc:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r2 = r2 | r16
            goto L_0x00d3
        L_0x00d1:
            r4 = r38
        L_0x00d3:
            r1 = r14 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x00db
            r1 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00d9:
            r2 = r2 | r1
            goto L_0x00ec
        L_0x00db:
            r1 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r13
            if (r1 != 0) goto L_0x00ec
            boolean r1 = r15.changed((java.lang.Object) r12)
            if (r1 == 0) goto L_0x00e9
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00d9
        L_0x00e9:
            r1 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00d9
        L_0x00ec:
            r16 = r2
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r16 & r1
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r2) goto L_0x010f
            boolean r1 = r15.getSkipping()
            if (r1 != 0) goto L_0x00ff
            goto L_0x010f
        L_0x00ff:
            r15.skipToGroupEnd()
            r1 = r30
            r2 = r3
            r3 = r7
            r28 = r9
            r9 = r4
            r4 = r8
            r7 = r5
            r5 = r28
            goto L_0x0287
        L_0x010f:
            r15.startDefaults()
            r1 = r13 & 1
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x0158
            boolean r1 = r15.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0123
            goto L_0x0158
        L_0x0123:
            r15.skipToGroupEnd()
            r0 = r14 & 2
            if (r0 == 0) goto L_0x012c
            r16 = r16 & -113(0xffffffffffffff8f, float:NaN)
        L_0x012c:
            r0 = r16
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0134
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0134:
            r1 = r14 & 8
            if (r1 == 0) goto L_0x013a
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x013a:
            r1 = r14 & 16
            if (r1 == 0) goto L_0x0140
            r0 = r0 & r18
        L_0x0140:
            r1 = r14 & 32
            if (r1 == 0) goto L_0x0146
            r0 = r0 & r17
        L_0x0146:
            r16 = r30
            r25 = r0
            r17 = r3
            r24 = r4
            r22 = r5
            r18 = r7
            r19 = r8
            r20 = r9
            goto L_0x01fd
        L_0x0158:
            if (r0 == 0) goto L_0x015f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0161
        L_0x015f:
            r0 = r30
        L_0x0161:
            r1 = r14 & 2
            if (r1 == 0) goto L_0x0179
            androidx.compose.material.ModalBottomSheetValue r1 = androidx.compose.material.ModalBottomSheetValue.Hidden
            r2 = 0
            r3 = 0
            r19 = 6
            r20 = 6
            r4 = r15
            r5 = r19
            r6 = r20
            androidx.compose.material.ModalBottomSheetState r1 = androidx.compose.material.ModalBottomSheetKt.rememberModalBottomSheetState(r1, r2, r3, r4, r5, r6)
            r16 = r16 & -113(0xffffffffffffff8f, float:NaN)
            r3 = r1
        L_0x0179:
            r1 = r16
            r2 = r14 & 4
            r4 = 8
            if (r2 == 0) goto L_0x0190
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r2 = r2.getShapes(r15, r4)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getLarge()
            androidx.compose.ui.graphics.Shape r2 = (androidx.compose.ui.graphics.Shape) r2
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r7 = r2
        L_0x0190:
            r2 = r14 & 8
            if (r2 == 0) goto L_0x019d
            androidx.compose.material.ModalBottomSheetDefaults r2 = androidx.compose.material.ModalBottomSheetDefaults.INSTANCE
            float r2 = r2.m1331getElevationD9Ej5fM()
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r8 = r2
        L_0x019d:
            r2 = r14 & 16
            if (r2 == 0) goto L_0x01ae
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r15, r4)
            long r5 = r2.m1218getSurface0d7_KjU()
            r1 = r1 & r18
            goto L_0x01af
        L_0x01ae:
            r5 = r9
        L_0x01af:
            r2 = r14 & 32
            if (r2 == 0) goto L_0x01de
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r15, r4)
            long r9 = r2.m1213getOnSurface0d7_KjU()
            r2 = 1050924810(0x3ea3d70a, float:0.32)
            r4 = 0
            r16 = 0
            r18 = 0
            r19 = 14
            r20 = 0
            r30 = r9
            r32 = r2
            r33 = r4
            r34 = r16
            r35 = r18
            r36 = r19
            r37 = r20
            long r9 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r30, r32, r33, r34, r35, r36, r37)
            r1 = r1 & r17
            goto L_0x01e0
        L_0x01de:
            r9 = r36
        L_0x01e0:
            if (r11 == 0) goto L_0x01ed
            io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$1 r2 = io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$1.INSTANCE
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r16 = r0
            r25 = r1
            r24 = r2
            goto L_0x01f3
        L_0x01ed:
            r24 = r38
            r16 = r0
            r25 = r1
        L_0x01f3:
            r17 = r3
            r20 = r5
            r18 = r7
            r19 = r8
            r22 = r9
        L_0x01fd:
            r15.endDefaults()
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r15.startReplaceableGroup(r0)
            java.lang.String r0 = "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            java.lang.Object r0 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x0233
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r15)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r15.updateRememberedValue(r1)
            r0 = r1
        L_0x0233:
            r15.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r9 = r0.getCoroutineScope()
            r15.endReplaceableGroup()
            r26 = 0
            r27 = 0
            r11 = 132187500(0x7e1056c, float:3.3857424E-34)
            io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2 r10 = new io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2
            r0 = r10
            r1 = r17
            r2 = r25
            r3 = r18
            r4 = r20
            r6 = r19
            r7 = r22
            r12 = r10
            r10 = r24
            r13 = 132187500(0x7e1056c, float:3.3857424E-34)
            r11 = r39
            r0.<init>(r1, r2, r3, r4, r6, r7, r9, r10, r11)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r13, r0, r12)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r1 = r25 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r2 = 6
            r30 = r16
            r31 = r26
            r32 = r27
            r33 = r0
            r34 = r15
            r35 = r1
            r36 = r2
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r30, r31, r32, r33, r34, r35, r36)
            r1 = r16
            r2 = r17
            r4 = r19
            r5 = r20
            r9 = r24
        L_0x0287:
            androidx.compose.runtime.ScopeUpdateScope r13 = r15.endRestartGroup()
            if (r13 != 0) goto L_0x028e
            goto L_0x029f
        L_0x028e:
            io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$3 r15 = new io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$3
            r0 = r15
            r10 = r39
            r11 = r41
            r12 = r42
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r13.updateScope(r15)
        L_0x029f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt.m5107IntercomStickyBottomSheeteVqBt0c(androidx.compose.ui.Modifier, androidx.compose.material.ModalBottomSheetState, androidx.compose.ui.graphics.Shape, float, long, long, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M  reason: not valid java name */
    public static final void m5108Scrim3JVO9M(long j, Function0<Unit> function0, boolean z, Composer composer, int i) {
        int i2;
        Modifier modifier;
        long j2 = j;
        Function0<Unit> function02 = function0;
        boolean z2 = z;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1459473139);
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed(j2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function02) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (j2 != Color.Companion.m1968getUnspecified0d7_KjU()) {
                State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z2 ? 1.0f : 0.0f, new TweenSpec(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null), 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, 0, 12);
                startRestartGroup.startReplaceableGroup(-2115998797);
                if (z2) {
                    Modifier modifier2 = Modifier.Companion;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean changed = startRestartGroup.changed((Object) function02);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new IntercomStickyBottomSheetKt$Scrim$dismissModifier$1$1(function02, (Continuation<? super IntercomStickyBottomSheetKt$Scrim$dismissModifier$1$1>) null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier2, (Object) function02, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue);
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    boolean changed2 = startRestartGroup.changed((Object) function02);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new IntercomStickyBottomSheetKt$Scrim$dismissModifier$2$1(function02);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceableGroup();
                    modifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
                } else {
                    modifier = Modifier.Companion;
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null).then(modifier);
                Color r8 = Color.m1922boximpl(j);
                startRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean changed3 = startRestartGroup.changed((Object) r8) | startRestartGroup.changed((Object) animateFloatAsState);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new IntercomStickyBottomSheetKt$Scrim$1$1(j2, animateFloatAsState);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IntercomStickyBottomSheetKt$Scrim$2(j, function0, z, i));
        }
    }

    /* access modifiers changed from: private */
    public static final Modifier bottomSheetSwipeable(Modifier modifier, float f, ModalBottomSheetState modalBottomSheetState, MutableState<Float> mutableState, boolean z) {
        Modifier modifier2;
        Map map;
        Float value = mutableState.getValue();
        if (!z || value == null) {
            modifier2 = Modifier.Companion;
        } else {
            float f2 = f / ((float) 2);
            if (value.floatValue() < f2) {
                map = MapsKt.mapOf(TuplesKt.to(Float.valueOf(f), ModalBottomSheetValue.Hidden), TuplesKt.to(Float.valueOf(f - value.floatValue()), ModalBottomSheetValue.Expanded));
            } else {
                map = MapsKt.mapOf(TuplesKt.to(Float.valueOf(f), ModalBottomSheetValue.Hidden), TuplesKt.to(Float.valueOf(f2), ModalBottomSheetValue.HalfExpanded), TuplesKt.to(Float.valueOf(Math.max(0.0f, f - value.floatValue())), ModalBottomSheetValue.Expanded));
            }
            modifier2 = SwipeableKt.m1430swipeablepPrIpRY$default(Modifier.Companion, modalBottomSheetState, map, Orientation.Vertical, modalBottomSheetState.getCurrentValue() == ModalBottomSheetValue.HalfExpanded, false, (MutableInteractionSource) null, (Function2) null, (ResistanceConfig) null, 0.0f, 368, (Object) null);
        }
        return modifier.then(modifier2);
    }

    public static final Shape getEquivalentCorner(ModalBottomSheetState modalBottomSheetState, MutableState<Float> mutableState) {
        Intrinsics.checkNotNullParameter(modalBottomSheetState, "<this>");
        Intrinsics.checkNotNullParameter(mutableState, "sheetHeightAsState");
        float floatValue = mutableState.getValue().floatValue() / ((float) 2);
        float floatValue2 = modalBottomSheetState.getOffset().getValue().floatValue();
        return RoundedCornerShapeKt.m855RoundedCornerShape0680j_4(floatValue2 < floatValue ? ((Dp) RangesKt.coerceAtLeast(Dp.m4702boximpl(Dp.m4704constructorimpl(Dp.m4704constructorimpl((float) 24) * (floatValue2 / floatValue))), Dp.m4702boximpl(Dp.m4704constructorimpl((float) 0)))).m4718unboximpl() : Dp.m4704constructorimpl((float) 24));
    }

    public static final float getEquivalentTopPadding(ModalBottomSheetState modalBottomSheetState, int i, MutableState<Float> mutableState) {
        Intrinsics.checkNotNullParameter(modalBottomSheetState, "<this>");
        Intrinsics.checkNotNullParameter(mutableState, "sheetHeightAsState");
        float floatValue = mutableState.getValue().floatValue();
        return ((float) i) * RangesKt.coerceIn((floatValue - modalBottomSheetState.getOffset().getValue().floatValue()) / floatValue, 0.0f, 1.0f);
    }

    public static final boolean isHidden(ModalBottomSheetState modalBottomSheetState) {
        Intrinsics.checkNotNullParameter(modalBottomSheetState, "<this>");
        return modalBottomSheetState.getCurrentValue() == ModalBottomSheetValue.Hidden && modalBottomSheetState.getTargetValue() == ModalBottomSheetValue.Hidden;
    }

    public static final NestedScrollConnection getPreUpPostDownNestedScrollConnection(ModalBottomSheetState modalBottomSheetState) {
        Intrinsics.checkNotNullParameter(modalBottomSheetState, "<this>");
        return new IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1(modalBottomSheetState);
    }

    /* access modifiers changed from: private */
    public static final void IntercomRootScreenPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(70365203);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$IntercomStickyBottomSheetKt.INSTANCE.m5105getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IntercomStickyBottomSheetKt$IntercomRootScreenPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Scrim_3J_VO9M$lambda-0  reason: not valid java name */
    public static final float m5109Scrim_3J_VO9M$lambda0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
