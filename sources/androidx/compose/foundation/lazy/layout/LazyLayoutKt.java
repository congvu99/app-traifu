package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"MaxItemsToRetainForReuse", "", "LazyLayout", "", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyLayout.kt */
public final class LazyLayoutKt {
    private static final int MaxItemsToRetainForReuse = 7;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @androidx.compose.foundation.ExperimentalFoundationApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyLayout(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider r15, androidx.compose.ui.Modifier r16, androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r17, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult> r18, androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r1 = r15
            r8 = r18
            r9 = r20
            java.lang.String r0 = "itemProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "measurePolicy"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 852831187(0x32d52bd3, float:2.4816392E-8)
            r2 = r19
            androidx.compose.runtime.Composer r10 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(LazyLayout)P(!1,2,3)47@1933L34,49@1973L909:LazyLayout.kt#wow0x6"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            r2 = r21 & 1
            if (r2 == 0) goto L_0x0024
            r2 = r9 | 6
            goto L_0x0034
        L_0x0024:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x0033
            boolean r2 = r10.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x0030
            r2 = 4
            goto L_0x0031
        L_0x0030:
            r2 = 2
        L_0x0031:
            r2 = r2 | r9
            goto L_0x0034
        L_0x0033:
            r2 = r9
        L_0x0034:
            r3 = r21 & 2
            if (r3 == 0) goto L_0x003b
            r2 = r2 | 48
            goto L_0x004e
        L_0x003b:
            r4 = r9 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r16
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004a
            r5 = 32
            goto L_0x004c
        L_0x004a:
            r5 = 16
        L_0x004c:
            r2 = r2 | r5
            goto L_0x0050
        L_0x004e:
            r4 = r16
        L_0x0050:
            r5 = r21 & 4
            if (r5 == 0) goto L_0x0057
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x0057:
            r6 = r9 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006a
            r6 = r17
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0066
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r2 = r2 | r7
            goto L_0x006c
        L_0x006a:
            r6 = r17
        L_0x006c:
            r7 = r21 & 8
            if (r7 == 0) goto L_0x0073
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0073:
            r7 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0083
            boolean r7 = r10.changed((java.lang.Object) r8)
            if (r7 == 0) goto L_0x0080
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r2 = r2 | r7
        L_0x0083:
            r7 = r2
            r2 = r7 & 5851(0x16db, float:8.199E-42)
            r11 = 1170(0x492, float:1.64E-42)
            if (r2 != r11) goto L_0x0097
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L_0x0091
            goto L_0x0097
        L_0x0091:
            r10.skipToGroupEnd()
            r2 = r4
            r3 = r6
            goto L_0x00dd
        L_0x0097:
            if (r3 == 0) goto L_0x009f
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r11 = r2
            goto L_0x00a0
        L_0x009f:
            r11 = r4
        L_0x00a0:
            if (r5 == 0) goto L_0x00a5
            r2 = 0
            r12 = r2
            goto L_0x00a6
        L_0x00a5:
            r12 = r6
        L_0x00a6:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00b2
            r2 = -1
            java.lang.String r3 = "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:41)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r2, r3)
        L_0x00b2:
            r0 = r7 & 14
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r15, r10, r0)
            r13 = 1342877611(0x500aafab, float:9.3070735E9)
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1 r14 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1
            r2 = r14
            r3 = r12
            r4 = r11
            r5 = r18
            r6 = r7
            r7 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r13, r0, r14)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r2 = 6
            androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt.LazySaveableStateHolderProvider(r0, r10, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00db
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00db:
            r2 = r11
            r3 = r12
        L_0x00dd:
            androidx.compose.runtime.ScopeUpdateScope r7 = r10.endRestartGroup()
            if (r7 != 0) goto L_0x00e4
            goto L_0x00f6
        L_0x00e4:
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2 r10 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2
            r0 = r10
            r1 = r15
            r4 = r18
            r5 = r20
            r6 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r7.updateScope(r10)
        L_0x00f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
