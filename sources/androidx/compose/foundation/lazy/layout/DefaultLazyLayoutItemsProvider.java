package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@ExperimentalFoundationApi
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003BN\u00121\u0010\u0004\u001a-\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010 J*\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001b2\u0006\u0010\"\u001a\u00020\u00102\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0003J\u0012\u0010$\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u0006H\u0016JT\u0010&\u001a\u0002H'\"\u0004\b\u0001\u0010'2\u0006\u0010\t\u001a\u00020\u000626\u0010(\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b()\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(*\u0012\u0004\u0012\u0002H'0\u0005H\b¢\u0006\u0002\u0010+R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R>\u0010\u0004\u001a-\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"Landroidx/compose/foundation/lazy/layout/DefaultLazyLayoutItemsProvider;", "IntervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "itemContentProvider", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "nearestItemsRange", "Lkotlin/ranges/IntRange;", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/foundation/lazy/layout/IntervalList;Lkotlin/ranges/IntRange;)V", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "getItemContentProvider", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "itemCount", "getItemCount", "()I", "keyToIndexMap", "", "", "getKeyToIndexMap", "()Ljava/util/Map;", "Item", "(ILandroidx/compose/runtime/Composer;I)V", "generateKeyToIndexMap", "range", "list", "getContentType", "getKey", "withLocalIntervalIndex", "T", "block", "localIndex", "content", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyLayoutItemProvider.kt */
final class DefaultLazyLayoutItemsProvider<IntervalContent extends LazyLayoutIntervalContent> implements LazyLayoutItemProvider {
    private final IntervalList<IntervalContent> intervals;
    private final Function4<IntervalContent, Integer, Composer, Integer, Unit> itemContentProvider;
    private final Map<Object, Integer> keyToIndexMap;

    public DefaultLazyLayoutItemsProvider(Function4<? super IntervalContent, ? super Integer, ? super Composer, ? super Integer, Unit> function4, IntervalList<? extends IntervalContent> intervalList, IntRange intRange) {
        Intrinsics.checkNotNullParameter(function4, "itemContentProvider");
        Intrinsics.checkNotNullParameter(intervalList, "intervals");
        Intrinsics.checkNotNullParameter(intRange, "nearestItemsRange");
        this.itemContentProvider = function4;
        this.intervals = intervalList;
        this.keyToIndexMap = generateKeyToIndexMap(intRange, intervalList);
    }

    public final Function4<IntervalContent, Integer, Composer, Integer, Unit> getItemContentProvider() {
        return this.itemContentProvider;
    }

    public final IntervalList<IntervalContent> getIntervals() {
        return this.intervals;
    }

    public int getItemCount() {
        return this.intervals.getSize();
    }

    public Map<Object, Integer> getKeyToIndexMap() {
        return this.keyToIndexMap;
    }

    public void Item(int i, Composer composer, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1877726744);
        ComposerKt.sourceInformation(startRestartGroup, "C(Item)*117@4203L31:LazyLayoutItemProvider.kt#wow0x6");
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) this) ? 32 : 16;
        }
        if ((i3 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1877726744, i2, -1, "androidx.compose.foundation.lazy.layout.DefaultLazyLayoutItemsProvider.Item (LazyLayoutItemProvider.kt:115)");
            }
            IntervalList.Interval<IntervalContent> interval = this.intervals.get(i);
            this.itemContentProvider.invoke((LazyLayoutIntervalContent) interval.getValue(), Integer.valueOf(i - interval.getStartIndex()), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DefaultLazyLayoutItemsProvider$Item$2(this, i, i2));
        }
    }

    private final <T> T withLocalIntervalIndex(int i, Function2<? super Integer, ? super IntervalContent, ? extends T> function2) {
        IntervalList.Interval<IntervalContent> interval = this.intervals.get(i);
        return function2.invoke(Integer.valueOf(i - interval.getStartIndex()), interval.getValue());
    }

    @ExperimentalFoundationApi
    private final Map<Object, Integer> generateKeyToIndexMap(IntRange intRange, IntervalList<? extends LazyLayoutIntervalContent> intervalList) {
        int first = intRange.getFirst();
        if (first >= 0) {
            int min = Math.min(intRange.getLast(), intervalList.getSize() - 1);
            if (min < first) {
                return MapsKt.emptyMap();
            }
            HashMap hashMap = new HashMap();
            intervalList.forEach(first, min, new DefaultLazyLayoutItemsProvider$generateKeyToIndexMap$1$1(first, min, hashMap));
            return hashMap;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r0 = r0.invoke(java.lang.Integer.valueOf(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getKey(int r3) {
        /*
            r2 = this;
            androidx.compose.foundation.lazy.layout.IntervalList<IntervalContent> r0 = r2.intervals
            androidx.compose.foundation.lazy.layout.IntervalList$Interval r0 = r0.get(r3)
            int r1 = r0.getStartIndex()
            int r1 = r3 - r1
            java.lang.Object r0 = r0.getValue()
            androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent r0 = (androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent) r0
            kotlin.jvm.functions.Function1 r0 = r0.getKey()
            if (r0 == 0) goto L_0x0022
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.invoke(r1)
            if (r0 != 0) goto L_0x0026
        L_0x0022:
            java.lang.Object r0 = androidx.compose.foundation.lazy.layout.Lazy_androidKt.getDefaultLazyLayoutKey(r3)
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.DefaultLazyLayoutItemsProvider.getKey(int):java.lang.Object");
    }

    public Object getContentType(int i) {
        IntervalList.Interval<IntervalContent> interval = this.intervals.get(i);
        return ((LazyLayoutIntervalContent) interval.getValue()).getType().invoke(Integer.valueOf(i - interval.getStartIndex()));
    }
}
