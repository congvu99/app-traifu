package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a~\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001a&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0002\u001aE\u0010!\u001a\u001f\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\"¢\u0006\u0002\b\u00162\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010%\u001aE\u0010&\u001a\u001f\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\"¢\u0006\u0002\b\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010'\u001aá\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u001420\b\n\u00100\u001a*\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\"¢\u0006\u0002\b\u00162%\b\n\u00103\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u001423\b\u0004\u00104\u001a-\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u00107\u001aá\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0\u001c2%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u001420\b\n\u00100\u001a*\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\"¢\u0006\u0002\b\u00162%\b\n\u00103\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u001423\b\u0004\u00104\u001a-\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u00108\u001aµ\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\"2E\b\n\u00100\u001a?\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010;¢\u0006\u0002\b\u00162:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\"2H\b\u0004\u00104\u001aB\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010<\u001aµ\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0\u001c2:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\"2E\b\n\u00100\u001a?\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010;¢\u0006\u0002\b\u00162:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\"2H\b\u0004\u00104\u001aB\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010=\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006>"}, d2 = {"LazyHorizontalGrid", "", "rows", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid", "columns", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "rememberColumnWidthSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "span", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyGridDsl.kt */
public final class LazyGridDslKt {
    /* JADX WARNING: Removed duplicated region for block: B:101:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyVerticalGrid(androidx.compose.foundation.lazy.grid.GridCells r27, androidx.compose.ui.Modifier r28, androidx.compose.foundation.lazy.grid.LazyGridState r29, androidx.compose.foundation.layout.PaddingValues r30, boolean r31, androidx.compose.foundation.layout.Arrangement.Vertical r32, androidx.compose.foundation.layout.Arrangement.Horizontal r33, androidx.compose.foundation.gestures.FlingBehavior r34, boolean r35, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r1 = r27
            r0 = r36
            r15 = r38
            r14 = r39
            java.lang.String r2 = "columns"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = 1485410512(0x588990d0, float:1.21004046E15)
            r3 = r37
            androidx.compose.runtime.Composer r13 = r3.startRestartGroup(r2)
            java.lang.String r3 = "C(LazyVerticalGrid)P(!1,5,7,2,6,9,4,3,8)65@3041L23,71@3401L15,75@3523L71,76@3599L431:LazyGridDsl.kt#7791vq"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            r3 = r14 & 1
            if (r3 == 0) goto L_0x0027
            r3 = r15 | 6
            goto L_0x0037
        L_0x0027:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x0036
            boolean r3 = r13.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0033
            r3 = 4
            goto L_0x0034
        L_0x0033:
            r3 = 2
        L_0x0034:
            r3 = r3 | r15
            goto L_0x0037
        L_0x0036:
            r3 = r15
        L_0x0037:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x003e
            r3 = r3 | 48
            goto L_0x0051
        L_0x003e:
            r5 = r15 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0051
            r5 = r28
            boolean r6 = r13.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004d
            r6 = 32
            goto L_0x004f
        L_0x004d:
            r6 = 16
        L_0x004f:
            r3 = r3 | r6
            goto L_0x0053
        L_0x0051:
            r5 = r28
        L_0x0053:
            r6 = r15 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006c
            r6 = r14 & 4
            if (r6 != 0) goto L_0x0066
            r6 = r29
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0068
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0066:
            r6 = r29
        L_0x0068:
            r7 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r3 = r3 | r7
            goto L_0x006e
        L_0x006c:
            r6 = r29
        L_0x006e:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x0075
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0075:
            r8 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0088
            r8 = r30
            boolean r9 = r13.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0084
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r3 = r3 | r9
            goto L_0x008a
        L_0x0088:
            r8 = r30
        L_0x008a:
            r9 = r14 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0094
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a7
        L_0x0094:
            r11 = r15 & r10
            if (r11 != 0) goto L_0x00a7
            r11 = r31
            boolean r12 = r13.changed((boolean) r11)
            if (r12 == 0) goto L_0x00a3
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r3 = r3 | r12
            goto L_0x00a9
        L_0x00a7:
            r11 = r31
        L_0x00a9:
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r15
            if (r12 != 0) goto L_0x00c4
            r12 = r14 & 32
            if (r12 != 0) goto L_0x00bd
            r12 = r32
            boolean r16 = r13.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x00bf
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bd:
            r12 = r32
        L_0x00bf:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r3 = r3 | r16
            goto L_0x00c6
        L_0x00c4:
            r12 = r32
        L_0x00c6:
            r16 = r14 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00d3
            r18 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r18
            r10 = r33
            goto L_0x00e6
        L_0x00d3:
            r18 = r15 & r17
            r10 = r33
            if (r18 != 0) goto L_0x00e6
            boolean r18 = r13.changed((java.lang.Object) r10)
            if (r18 == 0) goto L_0x00e2
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e4
        L_0x00e2:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00e4:
            r3 = r3 | r18
        L_0x00e6:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r15 & r18
            if (r19 != 0) goto L_0x0102
            r2 = r14 & 128(0x80, float:1.794E-43)
            if (r2 != 0) goto L_0x00fb
            r2 = r34
            boolean r20 = r13.changed((java.lang.Object) r2)
            if (r20 == 0) goto L_0x00fd
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ff
        L_0x00fb:
            r2 = r34
        L_0x00fd:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ff:
            r3 = r3 | r20
            goto L_0x0104
        L_0x0102:
            r2 = r34
        L_0x0104:
            r2 = r14 & 256(0x100, float:3.59E-43)
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            if (r2 == 0) goto L_0x0111
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r21
            r5 = r35
            goto L_0x0124
        L_0x0111:
            r21 = r15 & r20
            r5 = r35
            if (r21 != 0) goto L_0x0124
            boolean r21 = r13.changed((boolean) r5)
            if (r21 == 0) goto L_0x0120
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0122
        L_0x0120:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0122:
            r3 = r3 | r21
        L_0x0124:
            r5 = r14 & 512(0x200, float:7.175E-43)
            r21 = 1879048192(0x70000000, float:1.58456325E29)
            if (r5 == 0) goto L_0x012e
            r5 = 805306368(0x30000000, float:4.656613E-10)
        L_0x012c:
            r3 = r3 | r5
            goto L_0x013e
        L_0x012e:
            r5 = r15 & r21
            if (r5 != 0) goto L_0x013e
            boolean r5 = r13.changed((java.lang.Object) r0)
            if (r5 == 0) goto L_0x013b
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012c
        L_0x013b:
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x012c
        L_0x013e:
            r5 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r5 & r3
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r0) goto L_0x0160
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x014e
            goto L_0x0160
        L_0x014e:
            r13.skipToGroupEnd()
            r2 = r28
            r9 = r35
            r3 = r6
            r4 = r8
            r7 = r10
            r5 = r11
            r6 = r12
            r21 = r13
            r8 = r34
            goto L_0x028c
        L_0x0160:
            r13.startDefaults()
            r0 = r15 & 1
            r5 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x0197
            boolean r0 = r13.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0171
            goto L_0x0197
        L_0x0171:
            r13.skipToGroupEnd()
            r0 = r14 & 4
            if (r0 == 0) goto L_0x017a
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x017a:
            r0 = r14 & 32
            if (r0 == 0) goto L_0x017f
            r3 = r3 & r5
        L_0x017f:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0187
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r0
        L_0x0187:
            r0 = r28
            r25 = r34
            r26 = r35
            r22 = r6
            r23 = r11
            r24 = r12
            r12 = r8
            r11 = r10
            goto L_0x020e
        L_0x0197:
            if (r4 == 0) goto L_0x019e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01a0
        L_0x019e:
            r0 = r28
        L_0x01a0:
            r4 = r14 & 4
            r5 = 0
            if (r4 == 0) goto L_0x01ad
            r4 = 3
            androidx.compose.foundation.lazy.grid.LazyGridState r4 = androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(r5, r5, r13, r5, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01ae
        L_0x01ad:
            r4 = r6
        L_0x01ae:
            if (r7 == 0) goto L_0x01ba
            float r6 = (float) r5
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.foundation.layout.PaddingValues r6 = androidx.compose.foundation.layout.PaddingKt.m503PaddingValues0680j_4(r6)
            goto L_0x01bb
        L_0x01ba:
            r6 = r8
        L_0x01bb:
            if (r9 == 0) goto L_0x01be
            goto L_0x01bf
        L_0x01be:
            r5 = r11
        L_0x01bf:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x01d5
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r5 != 0) goto L_0x01cc
            androidx.compose.foundation.layout.Arrangement$Vertical r7 = r7.getTop()
            goto L_0x01d0
        L_0x01cc:
            androidx.compose.foundation.layout.Arrangement$Vertical r7 = r7.getBottom()
        L_0x01d0:
            r8 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r8
            goto L_0x01d6
        L_0x01d5:
            r7 = r12
        L_0x01d6:
            if (r16 == 0) goto L_0x01df
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r8 = r8.getStart()
            goto L_0x01e0
        L_0x01df:
            r8 = r10
        L_0x01e0:
            r9 = r14 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x01f0
            androidx.compose.foundation.gestures.ScrollableDefaults r9 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r10 = 6
            androidx.compose.foundation.gestures.FlingBehavior r9 = r9.flingBehavior(r13, r10)
            r10 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r10
            goto L_0x01f2
        L_0x01f0:
            r9 = r34
        L_0x01f2:
            if (r2 == 0) goto L_0x0202
            r2 = 1
            r22 = r4
            r23 = r5
            r12 = r6
            r24 = r7
            r11 = r8
            r25 = r9
            r26 = 1
            goto L_0x020e
        L_0x0202:
            r26 = r35
            r22 = r4
            r23 = r5
            r12 = r6
            r24 = r7
            r11 = r8
            r25 = r9
        L_0x020e:
            r13.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0220
            r2 = -1
            java.lang.String r4 = "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:62)"
            r5 = 1485410512(0x588990d0, float:1.21004046E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r2, r4)
        L_0x0220:
            r2 = r3 & 14
            int r4 = r3 >> 15
            r4 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | r4
            int r4 = r3 >> 3
            r5 = r4 & 896(0x380, float:1.256E-42)
            r2 = r2 | r5
            kotlin.jvm.functions.Function2 r5 = rememberColumnWidthSums(r1, r11, r12, r13, r2)
            r7 = 1
            r2 = 196608(0x30000, float:2.75506E-40)
            r6 = r4 & 14
            r2 = r2 | r6
            r6 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | r6
            r6 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r6
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r3
            r2 = r2 | r6
            r6 = r4 & r17
            r2 = r2 | r6
            r4 = r4 & r18
            r2 = r2 | r4
            int r4 = r3 << 9
            r6 = r4 & r20
            r2 = r2 | r6
            r4 = r4 & r21
            r16 = r2 | r4
            int r2 = r3 >> 27
            r17 = r2 & 14
            r18 = 0
            r2 = r0
            r3 = r22
            r4 = r5
            r5 = r12
            r6 = r23
            r8 = r25
            r9 = r26
            r10 = r24
            r19 = r11
            r20 = r12
            r12 = r36
            r21 = r13
            r14 = r16
            r15 = r17
            r16 = r18
            androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x027d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x027d:
            r2 = r0
            r7 = r19
            r4 = r20
            r3 = r22
            r5 = r23
            r6 = r24
            r8 = r25
            r9 = r26
        L_0x028c:
            androidx.compose.runtime.ScopeUpdateScope r13 = r21.endRestartGroup()
            if (r13 != 0) goto L_0x0293
            goto L_0x02a6
        L_0x0293:
            androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1 r14 = new androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyVerticalGrid$1
            r0 = r14
            r1 = r27
            r10 = r36
            r11 = r38
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x02a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0297  */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyHorizontalGrid(androidx.compose.foundation.lazy.grid.GridCells r27, androidx.compose.ui.Modifier r28, androidx.compose.foundation.lazy.grid.LazyGridState r29, androidx.compose.foundation.layout.PaddingValues r30, boolean r31, androidx.compose.foundation.layout.Arrangement.Horizontal r32, androidx.compose.foundation.layout.Arrangement.Vertical r33, androidx.compose.foundation.gestures.FlingBehavior r34, boolean r35, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r1 = r27
            r0 = r36
            r15 = r38
            r14 = r39
            java.lang.String r2 = "rows"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = 2123608858(0x7e93b31a, float:9.816323E37)
            r3 = r37
            androidx.compose.runtime.Composer r13 = r3.startRestartGroup(r2)
            java.lang.String r3 = "C(LazyHorizontalGrid)P(6,4,7,1,5,3,9,2,8)119@5584L23,125@5941L15,129@6063L64,130@6132L432:LazyGridDsl.kt#7791vq"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            r3 = r14 & 1
            if (r3 == 0) goto L_0x0028
            r3 = r15 | 6
            goto L_0x0038
        L_0x0028:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x0037
            boolean r3 = r13.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0034
            r3 = 4
            goto L_0x0035
        L_0x0034:
            r3 = 2
        L_0x0035:
            r3 = r3 | r15
            goto L_0x0038
        L_0x0037:
            r3 = r15
        L_0x0038:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x003f
            r3 = r3 | 48
            goto L_0x0052
        L_0x003f:
            r5 = r15 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0052
            r5 = r28
            boolean r6 = r13.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004e
            r6 = 32
            goto L_0x0050
        L_0x004e:
            r6 = 16
        L_0x0050:
            r3 = r3 | r6
            goto L_0x0054
        L_0x0052:
            r5 = r28
        L_0x0054:
            r6 = r15 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006d
            r6 = r14 & 4
            if (r6 != 0) goto L_0x0067
            r6 = r29
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0069
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0067:
            r6 = r29
        L_0x0069:
            r7 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r3 = r3 | r7
            goto L_0x006f
        L_0x006d:
            r6 = r29
        L_0x006f:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x0076
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r8 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0089
            r8 = r30
            boolean r9 = r13.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0085
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r3 = r3 | r9
            goto L_0x008b
        L_0x0089:
            r8 = r30
        L_0x008b:
            r9 = r14 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0095
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a8
        L_0x0095:
            r11 = r15 & r10
            if (r11 != 0) goto L_0x00a8
            r11 = r31
            boolean r12 = r13.changed((boolean) r11)
            if (r12 == 0) goto L_0x00a4
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a4:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r3 = r3 | r12
            goto L_0x00aa
        L_0x00a8:
            r11 = r31
        L_0x00aa:
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r15
            if (r12 != 0) goto L_0x00c5
            r12 = r14 & 32
            if (r12 != 0) goto L_0x00be
            r12 = r32
            boolean r16 = r13.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x00c0
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00be:
            r12 = r32
        L_0x00c0:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r3 = r3 | r16
            goto L_0x00c7
        L_0x00c5:
            r12 = r32
        L_0x00c7:
            r16 = r14 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00d4
            r18 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r18
            r10 = r33
            goto L_0x00e7
        L_0x00d4:
            r18 = r15 & r17
            r10 = r33
            if (r18 != 0) goto L_0x00e7
            boolean r18 = r13.changed((java.lang.Object) r10)
            if (r18 == 0) goto L_0x00e3
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e5
        L_0x00e3:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00e5:
            r3 = r3 | r18
        L_0x00e7:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r15 & r18
            if (r19 != 0) goto L_0x0103
            r2 = r14 & 128(0x80, float:1.794E-43)
            if (r2 != 0) goto L_0x00fc
            r2 = r34
            boolean r20 = r13.changed((java.lang.Object) r2)
            if (r20 == 0) goto L_0x00fe
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0100
        L_0x00fc:
            r2 = r34
        L_0x00fe:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0100:
            r3 = r3 | r20
            goto L_0x0105
        L_0x0103:
            r2 = r34
        L_0x0105:
            r2 = r14 & 256(0x100, float:3.59E-43)
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            if (r2 == 0) goto L_0x0112
            r21 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r21
            r5 = r35
            goto L_0x0125
        L_0x0112:
            r21 = r15 & r20
            r5 = r35
            if (r21 != 0) goto L_0x0125
            boolean r21 = r13.changed((boolean) r5)
            if (r21 == 0) goto L_0x0121
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0123
        L_0x0121:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0123:
            r3 = r3 | r21
        L_0x0125:
            r5 = r14 & 512(0x200, float:7.175E-43)
            r21 = 1879048192(0x70000000, float:1.58456325E29)
            if (r5 == 0) goto L_0x012f
            r5 = 805306368(0x30000000, float:4.656613E-10)
        L_0x012d:
            r3 = r3 | r5
            goto L_0x013f
        L_0x012f:
            r5 = r15 & r21
            if (r5 != 0) goto L_0x013f
            boolean r5 = r13.changed((java.lang.Object) r0)
            if (r5 == 0) goto L_0x013c
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012d
        L_0x013c:
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x012d
        L_0x013f:
            r5 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r5 & r3
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r0) goto L_0x0161
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x014f
            goto L_0x0161
        L_0x014f:
            r13.skipToGroupEnd()
            r2 = r28
            r9 = r35
            r3 = r6
            r4 = r8
            r7 = r10
            r5 = r11
            r6 = r12
            r21 = r13
            r8 = r34
            goto L_0x0290
        L_0x0161:
            r13.startDefaults()
            r0 = r15 & 1
            r5 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r0 == 0) goto L_0x0198
            boolean r0 = r13.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0172
            goto L_0x0198
        L_0x0172:
            r13.skipToGroupEnd()
            r0 = r14 & 4
            if (r0 == 0) goto L_0x017b
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x017b:
            r0 = r14 & 32
            if (r0 == 0) goto L_0x0180
            r3 = r3 & r5
        L_0x0180:
            r0 = r14 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0188
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r0
        L_0x0188:
            r0 = r28
            r25 = r34
            r26 = r35
            r22 = r6
            r23 = r11
            r24 = r12
            r12 = r8
            r11 = r10
            goto L_0x020f
        L_0x0198:
            if (r4 == 0) goto L_0x019f
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01a1
        L_0x019f:
            r0 = r28
        L_0x01a1:
            r4 = r14 & 4
            r5 = 0
            if (r4 == 0) goto L_0x01ae
            r4 = 3
            androidx.compose.foundation.lazy.grid.LazyGridState r4 = androidx.compose.foundation.lazy.grid.LazyGridStateKt.rememberLazyGridState(r5, r5, r13, r5, r4)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x01af
        L_0x01ae:
            r4 = r6
        L_0x01af:
            if (r7 == 0) goto L_0x01bb
            float r6 = (float) r5
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.foundation.layout.PaddingValues r6 = androidx.compose.foundation.layout.PaddingKt.m503PaddingValues0680j_4(r6)
            goto L_0x01bc
        L_0x01bb:
            r6 = r8
        L_0x01bc:
            if (r9 == 0) goto L_0x01bf
            goto L_0x01c0
        L_0x01bf:
            r5 = r11
        L_0x01c0:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x01d6
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r5 != 0) goto L_0x01cd
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r7.getStart()
            goto L_0x01d1
        L_0x01cd:
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r7.getEnd()
        L_0x01d1:
            r8 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r8
            goto L_0x01d7
        L_0x01d6:
            r7 = r12
        L_0x01d7:
            if (r16 == 0) goto L_0x01e0
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r8 = r8.getTop()
            goto L_0x01e1
        L_0x01e0:
            r8 = r10
        L_0x01e1:
            r9 = r14 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x01f1
            androidx.compose.foundation.gestures.ScrollableDefaults r9 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r10 = 6
            androidx.compose.foundation.gestures.FlingBehavior r9 = r9.flingBehavior(r13, r10)
            r10 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r10
            goto L_0x01f3
        L_0x01f1:
            r9 = r34
        L_0x01f3:
            if (r2 == 0) goto L_0x0203
            r2 = 1
            r22 = r4
            r23 = r5
            r12 = r6
            r24 = r7
            r11 = r8
            r25 = r9
            r26 = 1
            goto L_0x020f
        L_0x0203:
            r26 = r35
            r22 = r4
            r23 = r5
            r12 = r6
            r24 = r7
            r11 = r8
            r25 = r9
        L_0x020f:
            r13.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0221
            r2 = -1
            java.lang.String r4 = "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:116)"
            r5 = 2123608858(0x7e93b31a, float:9.816323E37)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r3, r2, r4)
        L_0x0221:
            r2 = r3 & 14
            int r4 = r3 >> 15
            r4 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | r4
            int r4 = r3 >> 3
            r5 = r4 & 896(0x380, float:1.256E-42)
            r2 = r2 | r5
            kotlin.jvm.functions.Function2 r5 = rememberRowHeightSums(r1, r11, r12, r13, r2)
            r7 = 0
            r2 = 196608(0x30000, float:2.75506E-40)
            r6 = r4 & 14
            r2 = r2 | r6
            r6 = r4 & 112(0x70, float:1.57E-43)
            r2 = r2 | r6
            r6 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r6
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r3
            r2 = r2 | r6
            r6 = r4 & r17
            r2 = r2 | r6
            r4 = r4 & r18
            r2 = r2 | r4
            int r4 = r3 << 6
            r4 = r4 & r20
            r2 = r2 | r4
            int r4 = r3 << 12
            r4 = r4 & r21
            r16 = r2 | r4
            int r2 = r3 >> 27
            r17 = r2 & 14
            r18 = 0
            r2 = r0
            r3 = r22
            r4 = r5
            r5 = r12
            r6 = r23
            r8 = r25
            r9 = r26
            r10 = r11
            r19 = r11
            r11 = r24
            r20 = r12
            r12 = r36
            r21 = r13
            r14 = r16
            r15 = r17
            r16 = r18
            androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0281
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0281:
            r2 = r0
            r7 = r19
            r4 = r20
            r3 = r22
            r5 = r23
            r6 = r24
            r8 = r25
            r9 = r26
        L_0x0290:
            androidx.compose.runtime.ScopeUpdateScope r13 = r21.endRestartGroup()
            if (r13 != 0) goto L_0x0297
            goto L_0x02aa
        L_0x0297:
            androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1 r14 = new androidx.compose.foundation.lazy.grid.LazyGridDslKt$LazyHorizontalGrid$1
            r0 = r14
            r1 = r27
            r10 = r36
            r11 = r38
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x02aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid(androidx.compose.foundation.lazy.grid.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.gestures.FlingBehavior, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function2<Density, Constraints, List<Integer>> rememberColumnWidthSums(GridCells gridCells, Arrangement.Horizontal horizontal, PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(-1355301804);
        ComposerKt.sourceInformation(composer, "C(rememberColumnWidthSums)P(!1,2)152@6816L830:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1355301804, i, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:148)");
        }
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) gridCells) | composer.changed((Object) horizontal) | composer.changed((Object) paddingValues);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyGridDslKt$rememberColumnWidthSums$1$1(paddingValues, gridCells, horizontal);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<Density, Constraints, List<Integer>> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }

    private static final Function2<Density, Constraints, List<Integer>> rememberRowHeightSums(GridCells gridCells, Arrangement.Vertical vertical, PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(239683573);
        ComposerKt.sourceInformation(composer, "C(rememberRowHeightSums)P(1,2)184@7885L786:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(239683573, i, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:180)");
        }
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) gridCells) | composer.changed((Object) vertical) | composer.changed((Object) paddingValues);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyGridDslKt$rememberRowHeightSums$1$1(paddingValues, gridCells, vertical);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<Density, Constraints, List<Integer>> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }

    /* access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i, int i2, int i3) {
        int i4 = i - (i3 * (i2 - 1));
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i7 = 0;
        while (i7 < i2) {
            arrayList.add(Integer.valueOf((i7 < i6 ? 1 : 0) + i5));
            i7++;
        }
        return arrayList;
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List list, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        Function2 function22 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = LazyGridDslKt$items$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function12, "contentType");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int size = list.size();
        Function1 lazyGridDslKt$items$2 = function1 != null ? new LazyGridDslKt$items$2(function1, list) : null;
        if (function2 != null) {
            function22 = new LazyGridDslKt$items$3(function2, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$items$2, function22, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(function4, list)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function12, "contentType");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int size = list.size();
        Function2 function22 = null;
        Function1 lazyGridDslKt$items$2 = function1 != null ? new LazyGridDslKt$items$2(function1, list) : null;
        if (function2 != null) {
            function22 = new LazyGridDslKt$items$3(function2, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$items$2, function22, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(699646206, true, new LazyGridDslKt$items$5(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List list, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        Function2 function23 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = LazyGridDslKt$itemsIndexed$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function22, "contentType");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int size = list.size();
        Function1 lazyGridDslKt$itemsIndexed$2 = function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null;
        if (function3 != null) {
            function23 = new LazyGridDslKt$itemsIndexed$3(function3, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$itemsIndexed$2, function23, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function22, "contentType");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int size = list.size();
        Function2 function23 = null;
        Function1 lazyGridDslKt$itemsIndexed$2 = function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null;
        if (function3 != null) {
            function23 = new LazyGridDslKt$itemsIndexed$3(function3, list);
        }
        lazyGridScope.items(size, lazyGridDslKt$itemsIndexed$2, function23, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] objArr, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        Function2 function22 = null;
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = LazyGridDslKt$items$6.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(objArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function12, "contentType");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int length = objArr.length;
        Function1 lazyGridDslKt$items$7 = function1 != null ? new LazyGridDslKt$items$7(function1, objArr) : null;
        if (function2 != null) {
            function22 = new LazyGridDslKt$items$8(function2, objArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$items$7, function22, new LazyGridDslKt$items$9(function12, objArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(function4, objArr)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(tArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function12, "contentType");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int length = tArr.length;
        Function2 function22 = null;
        Function1 lazyGridDslKt$items$7 = function1 != null ? new LazyGridDslKt$items$7(function1, tArr) : null;
        if (function2 != null) {
            function22 = new LazyGridDslKt$items$8(function2, tArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$items$7, function22, new LazyGridDslKt$items$9(function12, tArr), ComposableLambdaKt.composableLambdaInstance(407562193, true, new LazyGridDslKt$items$10(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] objArr, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        Function2 function23 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = LazyGridDslKt$itemsIndexed$6.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(objArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function22, "contentType");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int length = objArr.length;
        Function1 lazyGridDslKt$itemsIndexed$7 = function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, objArr) : null;
        if (function3 != null) {
            function23 = new LazyGridDslKt$itemsIndexed$8(function3, objArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$itemsIndexed$7, function23, new LazyGridDslKt$itemsIndexed$9(function22, objArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(tArr, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function22, "contentType");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int length = tArr.length;
        Function2 function23 = null;
        Function1 lazyGridDslKt$itemsIndexed$7 = function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, tArr) : null;
        if (function3 != null) {
            function23 = new LazyGridDslKt$itemsIndexed$8(function3, tArr);
        }
        lazyGridScope.items(length, lazyGridDslKt$itemsIndexed$7, function23, new LazyGridDslKt$itemsIndexed$9(function22, tArr), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new LazyGridDslKt$itemsIndexed$10(function5, tArr)));
    }
}
