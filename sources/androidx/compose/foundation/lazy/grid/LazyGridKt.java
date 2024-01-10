package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\fH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010 \u001a\u0018\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0001\u0010&\u001a\u0019\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020(0\u0007¢\u0006\u0002\b\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010)\u001a\u00020*H\u0003ø\u0001\u0000¢\u0006\u0002\u0010+\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slotSizesSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "", "", "Lkotlin/ExtensionFunctionType;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/runtime/Composer;I)V", "refreshOverscrollInfo", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "result", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "rememberLazyGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureResult;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyGrid.kt */
public final class LazyGridKt {
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyGrid(androidx.compose.ui.Modifier r35, androidx.compose.foundation.lazy.grid.LazyGridState r36, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super androidx.compose.ui.unit.Constraints, ? extends java.util.List<java.lang.Integer>> r37, androidx.compose.foundation.layout.PaddingValues r38, boolean r39, boolean r40, androidx.compose.foundation.gestures.FlingBehavior r41, boolean r42, androidx.compose.foundation.layout.Arrangement.Vertical r43, androidx.compose.foundation.layout.Arrangement.Horizontal r44, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, int r47, int r48, int r49) {
        /*
            r13 = r36
            r14 = r37
            r15 = r40
            r12 = r43
            r11 = r44
            r10 = r45
            r9 = r47
            r8 = r49
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "slotSizesSums"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "verticalArrangement"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "horizontalArrangement"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 152645664(0x9193020, float:1.8439333E-33)
            r1 = r46
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LazyGrid)P(5,8,7,1,6,4,2,9,10,3)66@3100L15,76@3541L18,78@3584L44,80@3654L65,82@3737L24,83@3790L92,88@3956L275,103@4272L42,110@4552L215,121@5041L7,106@4407L1113:LazyGrid.kt#7791vq"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r8 & 1
            if (r1 == 0) goto L_0x0044
            r4 = r9 | 6
            r5 = r4
            r4 = r35
            goto L_0x0058
        L_0x0044:
            r4 = r9 & 14
            if (r4 != 0) goto L_0x0055
            r4 = r35
            boolean r5 = r7.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0052
            r5 = 4
            goto L_0x0053
        L_0x0052:
            r5 = 2
        L_0x0053:
            r5 = r5 | r9
            goto L_0x0058
        L_0x0055:
            r4 = r35
            r5 = r9
        L_0x0058:
            r6 = r8 & 2
            if (r6 == 0) goto L_0x005f
            r5 = r5 | 48
            goto L_0x006f
        L_0x005f:
            r6 = r9 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x006f
            boolean r6 = r7.changed((java.lang.Object) r13)
            if (r6 == 0) goto L_0x006c
            r6 = 32
            goto L_0x006e
        L_0x006c:
            r6 = 16
        L_0x006e:
            r5 = r5 | r6
        L_0x006f:
            r6 = r8 & 4
            if (r6 == 0) goto L_0x0076
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0086
        L_0x0076:
            r6 = r9 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0086
            boolean r6 = r7.changed((java.lang.Object) r14)
            if (r6 == 0) goto L_0x0083
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0085
        L_0x0083:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0085:
            r5 = r5 | r6
        L_0x0086:
            r6 = r8 & 8
            if (r6 == 0) goto L_0x008d
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x00a1
        L_0x008d:
            r2 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x00a1
            r2 = r38
            boolean r16 = r7.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x009c
            r16 = 2048(0x800, float:2.87E-42)
            goto L_0x009e
        L_0x009c:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x009e:
            r5 = r5 | r16
            goto L_0x00a3
        L_0x00a1:
            r2 = r38
        L_0x00a3:
            r16 = r8 & 16
            r17 = 57344(0xe000, float:8.0356E-41)
            if (r16 == 0) goto L_0x00af
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r0 = r39
            goto L_0x00c2
        L_0x00af:
            r18 = r9 & r17
            r0 = r39
            if (r18 != 0) goto L_0x00c2
            boolean r19 = r7.changed((boolean) r0)
            if (r19 == 0) goto L_0x00be
            r19 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00c0
        L_0x00be:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x00c0:
            r5 = r5 | r19
        L_0x00c2:
            r19 = r8 & 32
            r20 = 458752(0x70000, float:6.42848E-40)
            if (r19 == 0) goto L_0x00cd
            r19 = 196608(0x30000, float:2.75506E-40)
        L_0x00ca:
            r5 = r5 | r19
            goto L_0x00dd
        L_0x00cd:
            r19 = r9 & r20
            if (r19 != 0) goto L_0x00dd
            boolean r19 = r7.changed((boolean) r15)
            if (r19 == 0) goto L_0x00da
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ca
        L_0x00da:
            r19 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ca
        L_0x00dd:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r21 = r9 & r19
            if (r21 != 0) goto L_0x00f7
            r21 = r8 & 64
            r3 = r41
            if (r21 != 0) goto L_0x00f2
            boolean r22 = r7.changed((java.lang.Object) r3)
            if (r22 == 0) goto L_0x00f2
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f4
        L_0x00f2:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00f4:
            r5 = r5 | r22
            goto L_0x00f9
        L_0x00f7:
            r3 = r41
        L_0x00f9:
            r0 = r8 & 128(0x80, float:1.794E-43)
            r22 = 29360128(0x1c00000, float:7.052966E-38)
            if (r0 == 0) goto L_0x0103
            r0 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r0
            goto L_0x0117
        L_0x0103:
            r0 = r9 & r22
            if (r0 != 0) goto L_0x0117
            r0 = r42
            boolean r23 = r7.changed((boolean) r0)
            if (r23 == 0) goto L_0x0112
            r23 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0114
        L_0x0112:
            r23 = 4194304(0x400000, float:5.877472E-39)
        L_0x0114:
            r5 = r5 | r23
            goto L_0x0119
        L_0x0117:
            r0 = r42
        L_0x0119:
            r0 = r8 & 256(0x100, float:3.59E-43)
            r23 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x0123
            r0 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0121:
            r5 = r5 | r0
            goto L_0x0133
        L_0x0123:
            r0 = r9 & r23
            if (r0 != 0) goto L_0x0133
            boolean r0 = r7.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x0130
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0121
        L_0x0130:
            r0 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0121
        L_0x0133:
            r0 = r8 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x013b
            r0 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0139:
            r5 = r5 | r0
            goto L_0x014c
        L_0x013b:
            r0 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r9
            if (r0 != 0) goto L_0x014c
            boolean r0 = r7.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x0149
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0139
        L_0x0149:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0139
        L_0x014c:
            r0 = r8 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0153
            r0 = r48 | 6
            goto L_0x0165
        L_0x0153:
            r0 = r48 & 14
            if (r0 != 0) goto L_0x0163
            boolean r0 = r7.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x015f
            r0 = 4
            goto L_0x0160
        L_0x015f:
            r0 = 2
        L_0x0160:
            r0 = r48 | r0
            goto L_0x0165
        L_0x0163:
            r0 = r48
        L_0x0165:
            r24 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r5 & r24
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r3) goto L_0x0188
            r2 = r0 & 11
            r3 = 2
            if (r2 != r3) goto L_0x0188
            boolean r2 = r7.getSkipping()
            if (r2 != 0) goto L_0x017b
            goto L_0x0188
        L_0x017b:
            r7.skipToGroupEnd()
            r5 = r39
            r1 = r4
            r8 = r7
            r4 = r38
            r7 = r41
            goto L_0x0371
        L_0x0188:
            r7.startDefaults()
            r2 = r9 & 1
            r3 = 6
            if (r2 == 0) goto L_0x01ab
            boolean r2 = r7.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0197
            goto L_0x01ab
        L_0x0197:
            r7.skipToGroupEnd()
            r1 = r8 & 64
            if (r1 == 0) goto L_0x01a2
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r5 = r5 & r1
        L_0x01a2:
            r16 = r38
            r21 = r41
            r6 = r4
            r4 = r5
            r5 = r39
            goto L_0x01e4
        L_0x01ab:
            if (r1 == 0) goto L_0x01b2
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x01b3
        L_0x01b2:
            r1 = r4
        L_0x01b3:
            r2 = 0
            if (r6 == 0) goto L_0x01c0
            float r4 = (float) r2
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.foundation.layout.PaddingValues r4 = androidx.compose.foundation.layout.PaddingKt.m503PaddingValues0680j_4(r4)
            goto L_0x01c2
        L_0x01c0:
            r4 = r38
        L_0x01c2:
            if (r16 == 0) goto L_0x01c5
            goto L_0x01c7
        L_0x01c5:
            r2 = r39
        L_0x01c7:
            r6 = r8 & 64
            if (r6 == 0) goto L_0x01dd
            androidx.compose.foundation.gestures.ScrollableDefaults r6 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.foundation.gestures.FlingBehavior r6 = r6.flingBehavior(r7, r3)
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r5 = r5 & r16
            r16 = r4
            r4 = r5
            r21 = r6
            r6 = r1
            goto L_0x01e3
        L_0x01dd:
            r21 = r41
            r6 = r1
            r16 = r4
            r4 = r5
        L_0x01e3:
            r5 = r2
        L_0x01e4:
            r7.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01f5
            java.lang.String r1 = "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:52)"
            r2 = 152645664(0x9193020, float:1.8439333E-33)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r4, r0, r1)
        L_0x01f5:
            androidx.compose.foundation.gestures.ScrollableDefaults r1 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.foundation.OverscrollEffect r3 = r1.overscrollEffect(r7, r3)
            int r1 = r4 >> 3
            r1 = r1 & 14
            int r0 = r0 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            androidx.compose.foundation.lazy.grid.LazyGridItemProvider r2 = androidx.compose.foundation.lazy.grid.LazyGridItemProviderKt.rememberLazyGridItemProvider(r13, r10, r7, r0)
            r0 = r2
            androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider r0 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider) r0
            r35 = r6
            int r6 = r4 >> 6
            r8 = r6 & 896(0x380, float:1.256E-42)
            r1 = r1 | r8
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r18 = androidx.compose.foundation.lazy.grid.LazySemanticsKt.rememberLazyGridSemanticState(r13, r0, r5, r7, r1)
            r1 = 773894976(0x2e20b340, float:3.6538994E-11)
            r7.startReplaceableGroup(r1)
            java.lang.String r1 = "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r7.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            java.lang.Object r1 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r1 != r8) goto L_0x0249
            kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r7)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r8 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r8.<init>(r1)
            r7.updateRememberedValue(r8)
            r1 = r8
        L_0x0249:
            r7.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r1 = r1.getCoroutineScope()
            r7.endReplaceableGroup()
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r40)
            r38 = r0
            r0 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r7.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            boolean r0 = r7.changed((java.lang.Object) r13)
            boolean r8 = r7.changed((java.lang.Object) r8)
            r0 = r0 | r8
            java.lang.Object r8 = r7.rememberedValue()
            if (r0 != 0) goto L_0x027d
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r8 != r0) goto L_0x0285
        L_0x027d:
            androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator r8 = new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator
            r8.<init>(r1, r15)
            r7.updateRememberedValue(r8)
        L_0x0285:
            r7.endReplaceableGroup()
            androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator r8 = (androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator) r8
            r13.setPlacementAnimator$foundation_release(r8)
            r0 = 1073741824(0x40000000, float:2.0)
            r1 = r4 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r39 = r1
            int r1 = r4 << 3
            r24 = r5
            r5 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r5
            r5 = r1 & r17
            r0 = r0 | r5
            r5 = r1 & r20
            r0 = r0 | r5
            r1 = r1 & r19
            r0 = r0 | r1
            r1 = r6 & r22
            r0 = r0 | r1
            r1 = r4 & r23
            r19 = r0 | r1
            r20 = 0
            r22 = r38
            r0 = r2
            r6 = r39
            r1 = r36
            r5 = r2
            r2 = r3
            r31 = r3
            r3 = r37
            r23 = r4
            r4 = r16
            r32 = r5
            r38 = r24
            r5 = r38
            r34 = r35
            r33 = r6
            r6 = r40
            r35 = r7
            r7 = r44
            r24 = r8
            r8 = r43
            r9 = r24
            r10 = r35
            r11 = r19
            r12 = r20
            kotlin.jvm.functions.Function2 r0 = rememberLazyGridMeasurePolicy(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.setVertical$foundation_release(r15)
            r8 = r35
            r1 = r32
            r2 = r33
            ScrollPositionUpdater(r1, r13, r8, r2)
            if (r15 == 0) goto L_0x02ef
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x02f1
        L_0x02ef:
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x02f1:
            r9 = r1
            androidx.compose.ui.layout.RemeasurementModifier r1 = r36.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r10 = r34
            androidx.compose.ui.Modifier r1 = r10.then(r1)
            androidx.compose.foundation.lazy.AwaitFirstLayoutModifier r2 = r36.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r1 = r1.then(r2)
            int r2 = r23 >> 9
            r7 = r2 & r17
            r2 = r22
            r3 = r18
            r4 = r9
            r5 = r42
            r6 = r8
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.ClipScrollableContainerKt.clipScrollableContainer(r1, r9)
            r2 = r31
            androidx.compose.ui.Modifier r23 = androidx.compose.foundation.OverscrollKt.overscroll(r1, r2)
            androidx.compose.foundation.gestures.ScrollableDefaults r1 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r5)
            java.lang.Object r3 = r8.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            r11 = r38
            boolean r28 = r1.reverseDirection(r3, r9, r11)
            androidx.compose.foundation.interaction.MutableInteractionSource r30 = r36.getInternalInteractionSource$foundation_release()
            r24 = r13
            androidx.compose.foundation.gestures.ScrollableState r24 = (androidx.compose.foundation.gestures.ScrollableState) r24
            r25 = r9
            r26 = r2
            r27 = r42
            r29 = r21
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.gestures.ScrollableKt.scrollable(r23, r24, r25, r26, r27, r28, r29, r30)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r3 = r36.getPrefetchState$foundation_release()
            r6 = 0
            r7 = 0
            r1 = r22
            r4 = r0
            r5 = r8
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x036b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x036b:
            r1 = r10
            r5 = r11
            r4 = r16
            r7 = r21
        L_0x0371:
            androidx.compose.runtime.ScopeUpdateScope r12 = r8.endRestartGroup()
            if (r12 != 0) goto L_0x0378
            goto L_0x039b
        L_0x0378:
            androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1 r16 = new androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1
            r0 = r16
            r2 = r36
            r3 = r37
            r6 = r40
            r8 = r42
            r9 = r43
            r10 = r44
            r11 = r45
            r15 = r12
            r12 = r47
            r13 = r48
            r14 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x039b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void ScrollPositionUpdater(LazyGridItemProvider lazyGridItemProvider, LazyGridState lazyGridState, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(950944068);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollPositionUpdater):LazyGrid.kt#7791vq");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) lazyGridItemProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) lazyGridState) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(950944068, i, -1, "androidx.compose.foundation.lazy.grid.ScrollPositionUpdater (LazyGrid.kt:140)");
            }
            if (lazyGridItemProvider.getItemCount() > 0) {
                lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyGridKt$ScrollPositionUpdater$1(lazyGridItemProvider, lazyGridState, i));
        }
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(LazyGridItemProvider lazyGridItemProvider, LazyGridState lazyGridState, OverscrollEffect overscrollEffect, Function2<? super Density, ? super Constraints, ? extends List<Integer>> function2, PaddingValues paddingValues, boolean z, boolean z2, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        composer2.startReplaceableGroup(1958911962);
        ComposerKt.sourceInformation(composer2, "C(rememberLazyGridMeasurePolicy)P(3,8,4,7!1,6,2!1,9)172@6984L8234:LazyGrid.kt#7791vq");
        Arrangement.Horizontal horizontal2 = (i3 & 128) != 0 ? null : horizontal;
        Arrangement.Vertical vertical2 = (i3 & 256) != 0 ? null : vertical;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1958911962, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:151)");
        }
        Object[] objArr = {lazyGridState, overscrollEffect, function2, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal2, vertical2, lazyGridItemPlacementAnimator};
        composer2.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
        boolean z3 = false;
        for (int i4 = 0; i4 < 9; i4++) {
            z3 |= composer2.changed(objArr[i4]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1(z2, paddingValues, z, lazyGridState, lazyGridItemProvider, function2, vertical2, horizontal2, lazyGridItemPlacementAnimator, overscrollEffect);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function22;
    }

    /* access modifiers changed from: private */
    public static final void refreshOverscrollInfo(OverscrollEffect overscrollEffect, LazyGridMeasureResult lazyGridMeasureResult) {
        Object obj;
        LazyMeasuredItem[] items;
        boolean canScrollForward = lazyGridMeasureResult.getCanScrollForward();
        LazyMeasuredLine firstVisibleLine = lazyGridMeasureResult.getFirstVisibleLine();
        boolean z = false;
        if (firstVisibleLine == null || (items = firstVisibleLine.getItems()) == null || (obj = (LazyMeasuredItem) ArraysKt.firstOrNull((T[]) items)) == null) {
            obj = 0;
        }
        boolean z2 = !Intrinsics.areEqual(obj, (Object) 0) || lazyGridMeasureResult.getFirstVisibleLineScrollOffset() != 0;
        if (canScrollForward || z2) {
            z = true;
        }
        overscrollEffect.setEnabled(z);
    }
}
