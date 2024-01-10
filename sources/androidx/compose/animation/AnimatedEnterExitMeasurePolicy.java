package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u000e\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J/\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u0019\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/AnimatedEnterExitMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "scope", "Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "(Landroidx/compose/animation/AnimatedVisibilityScopeImpl;)V", "getScope", "()Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {
    private final AnimatedVisibilityScopeImpl scope;

    public AnimatedEnterExitMeasurePolicy(AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScopeImpl, "scope");
        this.scope = animatedVisibilityScopeImpl;
    }

    public final AnimatedVisibilityScopeImpl getScope() {
        return this.scope;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: androidx.compose.ui.layout.Placeable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.MeasureResult m40measure3p2s80s(androidx.compose.ui.layout.MeasureScope r10, java.util.List<? extends androidx.compose.ui.layout.Measurable> r11, long r12) {
        /*
            r9 = this;
            java.lang.String r0 = "$receiver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r11 = r11.iterator()
        L_0x001d:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x0031
            java.lang.Object r1 = r11.next()
            androidx.compose.ui.layout.Measurable r1 = (androidx.compose.ui.layout.Measurable) r1
            androidx.compose.ui.layout.Placeable r1 = r1.m3649measureBRTryo0(r12)
            r0.add(r1)
            goto L_0x001d
        L_0x0031:
            java.util.List r0 = (java.util.List) r0
            boolean r11 = r0.isEmpty()
            r12 = 0
            r13 = 1
            r1 = 0
            if (r11 == 0) goto L_0x003e
            r11 = r12
            goto L_0x0066
        L_0x003e:
            java.lang.Object r11 = r0.get(r1)
            r2 = r11
            androidx.compose.ui.layout.Placeable r2 = (androidx.compose.ui.layout.Placeable) r2
            int r2 = r2.getWidth()
            int r3 = kotlin.collections.CollectionsKt.getLastIndex(r0)
            if (r13 > r3) goto L_0x0066
            r4 = 1
        L_0x0050:
            int r5 = r4 + 1
            java.lang.Object r6 = r0.get(r4)
            r7 = r6
            androidx.compose.ui.layout.Placeable r7 = (androidx.compose.ui.layout.Placeable) r7
            int r7 = r7.getWidth()
            if (r2 >= r7) goto L_0x0061
            r11 = r6
            r2 = r7
        L_0x0061:
            if (r4 != r3) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r4 = r5
            goto L_0x0050
        L_0x0066:
            androidx.compose.ui.layout.Placeable r11 = (androidx.compose.ui.layout.Placeable) r11
            if (r11 != 0) goto L_0x006c
            r3 = 0
            goto L_0x0071
        L_0x006c:
            int r11 = r11.getWidth()
            r3 = r11
        L_0x0071:
            boolean r11 = r0.isEmpty()
            if (r11 == 0) goto L_0x0078
            goto L_0x00a0
        L_0x0078:
            java.lang.Object r11 = r0.get(r1)
            r12 = r11
            androidx.compose.ui.layout.Placeable r12 = (androidx.compose.ui.layout.Placeable) r12
            int r12 = r12.getHeight()
            int r2 = kotlin.collections.CollectionsKt.getLastIndex(r0)
            if (r13 > r2) goto L_0x009f
        L_0x0089:
            int r4 = r13 + 1
            java.lang.Object r5 = r0.get(r13)
            r6 = r5
            androidx.compose.ui.layout.Placeable r6 = (androidx.compose.ui.layout.Placeable) r6
            int r6 = r6.getHeight()
            if (r12 >= r6) goto L_0x009a
            r11 = r5
            r12 = r6
        L_0x009a:
            if (r13 != r2) goto L_0x009d
            goto L_0x009f
        L_0x009d:
            r13 = r4
            goto L_0x0089
        L_0x009f:
            r12 = r11
        L_0x00a0:
            androidx.compose.ui.layout.Placeable r12 = (androidx.compose.ui.layout.Placeable) r12
            if (r12 != 0) goto L_0x00a6
            r4 = 0
            goto L_0x00ab
        L_0x00a6:
            int r1 = r12.getHeight()
            r4 = r1
        L_0x00ab:
            androidx.compose.animation.AnimatedVisibilityScopeImpl r11 = r9.scope
            androidx.compose.runtime.MutableState r11 = r11.getTargetSize$animation_release()
            long r12 = androidx.compose.ui.unit.IntSizeKt.IntSize(r3, r4)
            androidx.compose.ui.unit.IntSize r12 = androidx.compose.ui.unit.IntSize.m4856boximpl(r12)
            r11.setValue(r12)
            r5 = 0
            androidx.compose.animation.AnimatedEnterExitMeasurePolicy$measure$1 r11 = new androidx.compose.animation.AnimatedEnterExitMeasurePolicy$measure$1
            r11.<init>(r0)
            r6 = r11
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7 = 4
            r8 = 0
            r2 = r10
            androidx.compose.ui.layout.MeasureResult r10 = androidx.compose.ui.layout.MeasureScope.CC.layout$default(r2, r3, r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedEnterExitMeasurePolicy.m40measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(list), new AnimatedEnterExitMeasurePolicy$minIntrinsicWidth$1(i)));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(list), new AnimatedEnterExitMeasurePolicy$minIntrinsicHeight$1(i)));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(list), new AnimatedEnterExitMeasurePolicy$maxIntrinsicWidth$1(i)));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(list), new AnimatedEnterExitMeasurePolicy$maxIntrinsicHeight$1(i)));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
