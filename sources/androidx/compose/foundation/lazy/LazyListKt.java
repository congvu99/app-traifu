package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001a\u001d\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002\u001a\u0001\u0010$\u001a\u0019\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%¢\u0006\u0002\b\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020,H\u0003ø\u0001\u0000¢\u0006\u0002\u0010-\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)V", "refreshOverscrollInfo", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "result", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;Landroidx/compose/runtime/Composer;III)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyList.kt */
public final class LazyListKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03aa  */
    /* JADX WARNING: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyList(androidx.compose.ui.Modifier r33, androidx.compose.foundation.lazy.LazyListState r34, androidx.compose.foundation.layout.PaddingValues r35, boolean r36, boolean r37, androidx.compose.foundation.gestures.FlingBehavior r38, boolean r39, androidx.compose.ui.Alignment.Horizontal r40, androidx.compose.foundation.layout.Arrangement.Vertical r41, androidx.compose.ui.Alignment.Vertical r42, androidx.compose.foundation.layout.Arrangement.Horizontal r43, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r44, androidx.compose.runtime.Composer r45, int r46, int r47, int r48) {
        /*
            r1 = r33
            r0 = r34
            r15 = r35
            r14 = r36
            r13 = r37
            r12 = r38
            r11 = r44
            r10 = r46
            r9 = r48
            java.lang.String r2 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "contentPadding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            java.lang.String r2 = "flingBehavior"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r2)
            java.lang.String r2 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r2)
            r2 = 955299798(0x38f0b7d6, float:1.1478334E-4)
            r3 = r45
            androidx.compose.runtime.Composer r8 = r3.startRestartGroup(r2)
            java.lang.String r3 = "C(LazyList)P(6,8,1,7,5,2,9,3,11,10,4)76@3572L18,77@3614L44,79@3691L77,80@3796L39,81@3852L24,82@3905L92,87@4071L334,102@4411L42,109@4691L215,116@4970L68,117@5052L48,122@5324L7,105@4546L1257:LazyList.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            r3 = r9 & 1
            if (r3 == 0) goto L_0x0041
            r3 = r10 | 6
            goto L_0x0051
        L_0x0041:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x0050
            boolean r3 = r8.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x004d
            r3 = 4
            goto L_0x004e
        L_0x004d:
            r3 = 2
        L_0x004e:
            r3 = r3 | r10
            goto L_0x0051
        L_0x0050:
            r3 = r10
        L_0x0051:
            r6 = r9 & 2
            r16 = 16
            if (r6 == 0) goto L_0x005a
            r3 = r3 | 48
            goto L_0x006a
        L_0x005a:
            r6 = r10 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x006a
            boolean r6 = r8.changed((java.lang.Object) r0)
            if (r6 == 0) goto L_0x0067
            r6 = 32
            goto L_0x0069
        L_0x0067:
            r6 = 16
        L_0x0069:
            r3 = r3 | r6
        L_0x006a:
            r6 = r9 & 4
            if (r6 == 0) goto L_0x0071
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0081
        L_0x0071:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0081
            boolean r6 = r8.changed((java.lang.Object) r15)
            if (r6 == 0) goto L_0x007e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0080
        L_0x007e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0080:
            r3 = r3 | r6
        L_0x0081:
            r6 = r9 & 8
            if (r6 == 0) goto L_0x0088
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0098
        L_0x0088:
            r6 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0098
            boolean r6 = r8.changed((boolean) r14)
            if (r6 == 0) goto L_0x0095
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0097
        L_0x0095:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0097:
            r3 = r3 | r6
        L_0x0098:
            r6 = r9 & 16
            r18 = 57344(0xe000, float:8.0356E-41)
            if (r6 == 0) goto L_0x00a2
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00b2
        L_0x00a2:
            r6 = r10 & r18
            if (r6 != 0) goto L_0x00b2
            boolean r6 = r8.changed((boolean) r13)
            if (r6 == 0) goto L_0x00af
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b1
        L_0x00af:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x00b1:
            r3 = r3 | r6
        L_0x00b2:
            r6 = r9 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r6 == 0) goto L_0x00bc
            r6 = 196608(0x30000, float:2.75506E-40)
        L_0x00ba:
            r3 = r3 | r6
            goto L_0x00cc
        L_0x00bc:
            r6 = r10 & r17
            if (r6 != 0) goto L_0x00cc
            boolean r6 = r8.changed((java.lang.Object) r12)
            if (r6 == 0) goto L_0x00c9
            r6 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00c9:
            r6 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ba
        L_0x00cc:
            r6 = r9 & 64
            r19 = 3670016(0x380000, float:5.142788E-39)
            if (r6 == 0) goto L_0x00d6
            r6 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r6
            goto L_0x00ea
        L_0x00d6:
            r6 = r10 & r19
            if (r6 != 0) goto L_0x00ea
            r6 = r39
            boolean r20 = r8.changed((boolean) r6)
            if (r20 == 0) goto L_0x00e5
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r3 = r3 | r20
            goto L_0x00ec
        L_0x00ea:
            r6 = r39
        L_0x00ec:
            r4 = r9 & 128(0x80, float:1.794E-43)
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            if (r4 == 0) goto L_0x00f9
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r21
            r5 = r40
            goto L_0x010c
        L_0x00f9:
            r21 = r10 & r20
            r5 = r40
            if (r21 != 0) goto L_0x010c
            boolean r22 = r8.changed((java.lang.Object) r5)
            if (r22 == 0) goto L_0x0108
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010a
        L_0x0108:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x010a:
            r3 = r3 | r22
        L_0x010c:
            r7 = r9 & 256(0x100, float:3.59E-43)
            r23 = 234881024(0xe000000, float:1.5777218E-30)
            if (r7 == 0) goto L_0x0119
            r24 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r24
            r2 = r41
            goto L_0x012c
        L_0x0119:
            r24 = r10 & r23
            r2 = r41
            if (r24 != 0) goto L_0x012c
            boolean r25 = r8.changed((java.lang.Object) r2)
            if (r25 == 0) goto L_0x0128
            r25 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012a
        L_0x0128:
            r25 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012a:
            r3 = r3 | r25
        L_0x012c:
            r2 = r9 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0137
            r25 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r25
            r5 = r42
            goto L_0x014c
        L_0x0137:
            r25 = 1879048192(0x70000000, float:1.58456325E29)
            r25 = r10 & r25
            r5 = r42
            if (r25 != 0) goto L_0x014c
            boolean r25 = r8.changed((java.lang.Object) r5)
            if (r25 == 0) goto L_0x0148
            r25 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014a
        L_0x0148:
            r25 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014a:
            r3 = r3 | r25
        L_0x014c:
            r5 = r9 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0155
            r21 = r47 | 6
            r6 = r43
            goto L_0x016b
        L_0x0155:
            r25 = r47 & 14
            r6 = r43
            if (r25 != 0) goto L_0x0169
            boolean r25 = r8.changed((java.lang.Object) r6)
            if (r25 == 0) goto L_0x0164
            r21 = 4
            goto L_0x0166
        L_0x0164:
            r21 = 2
        L_0x0166:
            r21 = r47 | r21
            goto L_0x016b
        L_0x0169:
            r21 = r47
        L_0x016b:
            r6 = r9 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0172
            r21 = r21 | 48
            goto L_0x0180
        L_0x0172:
            r6 = r47 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0180
            boolean r6 = r8.changed((java.lang.Object) r11)
            if (r6 == 0) goto L_0x017e
            r16 = 32
        L_0x017e:
            r21 = r21 | r16
        L_0x0180:
            r6 = r21
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r9 = r3 & r16
            r10 = 306783378(0x12492492, float:6.3469493E-28)
            if (r9 != r10) goto L_0x01a8
            r9 = r6 & 91
            r10 = 18
            if (r9 != r10) goto L_0x01a8
            boolean r9 = r8.getSkipping()
            if (r9 != 0) goto L_0x0199
            goto L_0x01a8
        L_0x0199:
            r8.skipToGroupEnd()
            r9 = r41
            r10 = r42
            r26 = r43
            r11 = r8
            r13 = r14
            r8 = r40
            goto L_0x03a3
        L_0x01a8:
            r9 = 0
            if (r4 == 0) goto L_0x01ae
            r21 = r9
            goto L_0x01b0
        L_0x01ae:
            r21 = r40
        L_0x01b0:
            if (r7 == 0) goto L_0x01b5
            r22 = r9
            goto L_0x01b7
        L_0x01b5:
            r22 = r41
        L_0x01b7:
            if (r2 == 0) goto L_0x01bc
            r25 = r9
            goto L_0x01be
        L_0x01bc:
            r25 = r42
        L_0x01be:
            if (r5 == 0) goto L_0x01c3
            r26 = r9
            goto L_0x01c5
        L_0x01c3:
            r26 = r43
        L_0x01c5:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01d3
            java.lang.String r2 = "androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)"
            r4 = 955299798(0x38f0b7d6, float:1.1478334E-4)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r3, r6, r2)
        L_0x01d3:
            androidx.compose.foundation.gestures.ScrollableDefaults r2 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r10 = 6
            androidx.compose.foundation.OverscrollEffect r9 = r2.overscrollEffect(r8, r10)
            int r7 = r3 >> 3
            r2 = r7 & 14
            r4 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r2
            androidx.compose.foundation.lazy.LazyListItemProvider r5 = androidx.compose.foundation.lazy.LazyListItemProviderKt.rememberLazyListItemProvider(r0, r11, r8, r4)
            r24 = r5
            androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider r24 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider) r24
            r4 = r7 & 896(0x380, float:1.256E-42)
            r2 = r2 | r4
            r4 = r7 & 7168(0x1c00, float:1.0045E-41)
            r16 = r2 | r4
            r2 = r34
            r4 = r3
            r3 = r24
            r10 = r4
            r4 = r36
            r41 = r5
            r5 = r37
            r27 = r6
            r6 = r8
            r28 = r7
            r7 = r16
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r29 = androidx.compose.foundation.lazy.LazySemanticsKt.rememberLazyListSemanticState(r2, r3, r4, r5, r6, r7)
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            java.lang.Object r2 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0226
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r2 = new androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo
            r2.<init>()
            r8.updateRememberedValue(r2)
        L_0x0226:
            r8.endReplaceableGroup()
            r7 = r2
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r7 = (androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo) r7
            r2 = 773894976(0x2e20b340, float:3.6538994E-11)
            r8.startReplaceableGroup(r2)
            java.lang.String r2 = "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            java.lang.Object r2 = r8.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x025f
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r8)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r3.<init>(r2)
            r8.updateRememberedValue(r3)
            r2 = r3
        L_0x025f:
            r8.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            kotlinx.coroutines.CoroutineScope r2 = r2.getCoroutineScope()
            r8.endReplaceableGroup()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r37)
            r4 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r8.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r4)
            boolean r4 = r8.changed((java.lang.Object) r0)
            boolean r3 = r8.changed((java.lang.Object) r3)
            r3 = r3 | r4
            java.lang.Object r4 = r8.rememberedValue()
            if (r3 != 0) goto L_0x0291
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0299
        L_0x0291:
            androidx.compose.foundation.lazy.LazyListItemPlacementAnimator r4 = new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator
            r4.<init>(r2, r13)
            r8.updateRememberedValue(r4)
        L_0x0299:
            r8.endReplaceableGroup()
            r6 = r4
            androidx.compose.foundation.lazy.LazyListItemPlacementAnimator r6 = (androidx.compose.foundation.lazy.LazyListItemPlacementAnimator) r6
            r0.setPlacementAnimator$foundation_release(r6)
            r5 = r10 & 112(0x70, float:1.57E-43)
            int r2 = androidx.compose.runtime.collection.MutableVector.$stable
            r16 = 6
            int r2 = r2 << 6
            r2 = r2 | r5
            int r3 = r10 << 6
            r4 = r3 & r18
            r2 = r2 | r4
            r4 = r3 & r17
            r2 = r2 | r4
            r3 = r3 & r19
            r2 = r2 | r3
            r3 = r10 & r20
            r2 = r2 | r3
            r3 = r28 & r23
            r2 = r2 | r3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            int r4 = r27 << 27
            r3 = r3 & r4
            r17 = r2 | r3
            int r2 = r10 >> 24
            r2 = r2 & 14
            r19 = r2 | 64
            r20 = 0
            r2 = r41
            r3 = r34
            r4 = r7
            r1 = r5
            r5 = r9
            r23 = r6
            r6 = r35
            r40 = r7
            r7 = r36
            r42 = r8
            r8 = r37
            r30 = r9
            r9 = r21
            r31 = r10
            r27 = 6
            r10 = r25
            r11 = r26
            r12 = r22
            r13 = r23
            r14 = r42
            r15 = r17
            r16 = r19
            r17 = r20
            kotlin.jvm.functions.Function2 r10 = rememberLazyListMeasurePolicy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r11 = r42
            ScrollPositionUpdater(r2, r0, r11, r1)
            if (r37 == 0) goto L_0x0304
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0306
        L_0x0304:
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0306:
            r12 = r2
            androidx.compose.ui.layout.RemeasurementModifier r2 = r34.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r13 = r1
            r1 = r33
            androidx.compose.ui.Modifier r2 = r1.then(r2)
            androidx.compose.foundation.lazy.AwaitFirstLayoutModifier r3 = r34.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Modifier r3 = r2.then(r3)
            r2 = r31
            int r4 = r2 >> 6
            r9 = r4 & r18
            r4 = r24
            r5 = r29
            r6 = r12
            r7 = r39
            r8 = r11
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.ClipScrollableContainerKt.clipScrollableContainer(r3, r12)
            int r4 = androidx.compose.runtime.collection.MutableVector.$stable
            int r4 = r4 << 6
            r4 = r4 | r13
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r7 = r4 | r2
            r2 = r3
            r3 = r34
            r4 = r40
            r5 = r36
            r6 = r11
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.lazy.LazyBeyondBoundsModifierKt.lazyListBeyondBoundsModifier(r2, r3, r4, r5, r6, r7)
            int r3 = androidx.compose.runtime.collection.MutableVector.$stable
            int r3 = r3 << 6
            r3 = r3 | r13
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.lazy.LazyListPinningModifierKt.lazyListPinningModifier(r2, r0, r4, r11, r3)
            r5 = r30
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.OverscrollKt.overscroll(r2, r5)
            androidx.compose.foundation.gestures.ScrollableDefaults r3 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r6, r7)
            java.lang.Object r4 = r11.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            r13 = r36
            boolean r7 = r3.reverseDirection(r4, r12, r13)
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r34.getInternalInteractionSource$foundation_release()
            r3 = r0
            androidx.compose.foundation.gestures.ScrollableState r3 = (androidx.compose.foundation.gestures.ScrollableState) r3
            r4 = r12
            r6 = r39
            r8 = r38
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.gestures.ScrollableKt.scrollable(r2, r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r5 = r34.getPrefetchState$foundation_release()
            r8 = 0
            r9 = 0
            r3 = r24
            r6 = r10
            r7 = r11
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout(r3, r4, r5, r6, r7, r8, r9)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x039d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x039d:
            r8 = r21
            r9 = r22
            r10 = r25
        L_0x03a3:
            androidx.compose.runtime.ScopeUpdateScope r15 = r11.endRestartGroup()
            if (r15 != 0) goto L_0x03aa
            goto L_0x03d4
        L_0x03aa:
            androidx.compose.foundation.lazy.LazyListKt$LazyList$1 r16 = new androidx.compose.foundation.lazy.LazyListKt$LazyList$1
            r0 = r16
            r1 = r33
            r2 = r34
            r3 = r35
            r4 = r36
            r5 = r37
            r6 = r38
            r7 = r39
            r11 = r26
            r12 = r44
            r13 = r46
            r14 = r47
            r32 = r15
            r15 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r32
            r1.updateScope(r0)
        L_0x03d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.LazyList(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    @ExperimentalFoundationApi
    public static final void ScrollPositionUpdater(LazyListItemProvider lazyListItemProvider, LazyListState lazyListState, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(3173830);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollPositionUpdater):LazyList.kt#428nma");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) lazyListItemProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) lazyListState) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(3173830, i, -1, "androidx.compose.foundation.lazy.ScrollPositionUpdater (LazyList.kt:141)");
            }
            if (lazyListItemProvider.getItemCount() > 0) {
                lazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyListKt$ScrollPositionUpdater$1(lazyListItemProvider, lazyListState, i));
        }
    }

    @ExperimentalFoundationApi
    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(LazyListItemProvider lazyListItemProvider, LazyListState lazyListState, LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, OverscrollEffect overscrollEffect, PaddingValues paddingValues, boolean z, boolean z2, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        composer2.startReplaceableGroup(-1404987696);
        ComposerKt.sourceInformation(composer2, "C(rememberLazyListMeasurePolicy)P(5,9!1,6!1,8,4!1,10!1,11)177@7545L6554:LazyList.kt#428nma");
        Alignment.Horizontal horizontal3 = (i4 & 128) != 0 ? null : horizontal;
        Alignment.Vertical vertical3 = (i4 & 256) != 0 ? null : vertical;
        Arrangement.Horizontal horizontal4 = (i4 & 512) != 0 ? null : horizontal2;
        Arrangement.Vertical vertical4 = (i4 & 1024) != 0 ? null : vertical2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1404987696, i, i2, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:152)");
        }
        Object[] objArr = {lazyListState, lazyListBeyondBoundsInfo, overscrollEffect, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal3, vertical3, horizontal4, vertical4, lazyListItemPlacementAnimator};
        composer2.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
        boolean z3 = false;
        for (int i5 = 0; i5 < 11; i5++) {
            z3 |= composer2.changed(objArr[i5]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(z2, paddingValues, z, lazyListState, lazyListItemProvider, vertical4, horizontal4, lazyListItemPlacementAnimator, lazyListBeyondBoundsInfo, horizontal3, vertical3, overscrollEffect);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }

    /* access modifiers changed from: private */
    public static final void refreshOverscrollInfo(OverscrollEffect overscrollEffect, LazyListMeasureResult lazyListMeasureResult) {
        boolean canScrollForward = lazyListMeasureResult.getCanScrollForward();
        LazyMeasuredItem firstVisibleItem = lazyListMeasureResult.getFirstVisibleItem();
        boolean z = false;
        boolean z2 = ((firstVisibleItem != null ? firstVisibleItem.getIndex() : 0) == 0 && lazyListMeasureResult.getFirstVisibleItemScrollOffset() == 0) ? false : true;
        if (canScrollForward || z2) {
            z = true;
        }
        overscrollEffect.setEnabled(z);
    }
}
