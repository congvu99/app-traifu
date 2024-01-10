package androidx.compose.animation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u000e\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J/\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u0019\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/AnimatedContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "rootScope", "Landroidx/compose/animation/AnimatedContentScope;", "(Landroidx/compose/animation/AnimatedContentScope;)V", "getRootScope", "()Landroidx/compose/animation/AnimatedContentScope;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentMeasurePolicy implements MeasurePolicy {
    private final AnimatedContentScope<?> rootScope;

    public AnimatedContentMeasurePolicy(AnimatedContentScope<?> animatedContentScope) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "rootScope");
        this.rootScope = animatedContentScope;
    }

    public final AnimatedContentScope<?> getRootScope() {
        return this.rootScope;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m10measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Placeable placeable;
        List<? extends Measurable> list2 = list;
        long j2 = j;
        Intrinsics.checkNotNullParameter(measureScope, "$receiver");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        int size = list.size();
        Placeable[] placeableArr = new Placeable[size];
        int size2 = list.size() - 1;
        Placeable placeable2 = null;
        int i = 1;
        if (size2 >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                Measurable measurable = (Measurable) list2.get(i2);
                Object parentData = measurable.getParentData();
                AnimatedContentScope.ChildData childData = parentData instanceof AnimatedContentScope.ChildData ? (AnimatedContentScope.ChildData) parentData : null;
                if (childData != null && childData.isTarget()) {
                    placeableArr[i2] = measurable.m3649measureBRTryo0(j2);
                }
                if (i3 > size2) {
                    break;
                }
                i2 = i3;
            }
        }
        int size3 = list.size() - 1;
        if (size3 >= 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                Measurable measurable2 = (Measurable) list2.get(i4);
                if (placeableArr[i4] == null) {
                    placeableArr[i4] = measurable2.m3649measureBRTryo0(j2);
                }
                if (i5 > size3) {
                    break;
                }
                i4 = i5;
            }
        }
        if (size == 0) {
            placeable = null;
        } else {
            placeable = placeableArr[0];
            int lastIndex = ArraysKt.getLastIndex((T[]) placeableArr);
            if (lastIndex != 0) {
                int width = placeable == null ? 0 : placeable.getWidth();
                if (1 <= lastIndex) {
                    int i6 = 1;
                    while (true) {
                        int i7 = i6 + 1;
                        Placeable placeable3 = placeableArr[i6];
                        int width2 = placeable3 == null ? 0 : placeable3.getWidth();
                        if (width < width2) {
                            placeable = placeable3;
                            width = width2;
                        }
                        if (i6 == lastIndex) {
                            break;
                        }
                        i6 = i7;
                    }
                }
            }
        }
        int width3 = placeable == null ? 0 : placeable.getWidth();
        if (!(size == 0)) {
            placeable2 = placeableArr[0];
            int lastIndex2 = ArraysKt.getLastIndex((T[]) placeableArr);
            if (lastIndex2 != 0) {
                int height = placeable2 == null ? 0 : placeable2.getHeight();
                if (1 <= lastIndex2) {
                    while (true) {
                        int i8 = i + 1;
                        Placeable placeable4 = placeableArr[i];
                        int height2 = placeable4 == null ? 0 : placeable4.getHeight();
                        if (height < height2) {
                            placeable2 = placeable4;
                            height = height2;
                        }
                        if (i == lastIndex2) {
                            break;
                        }
                        i = i8;
                    }
                }
            }
        }
        int height3 = placeable2 == null ? 0 : placeable2.getHeight();
        this.rootScope.m22setMeasuredSizeozmzZPI$animation_release(IntSizeKt.IntSize(width3, height3));
        return MeasureScope.CC.layout$default(measureScope, width3, height3, (Map) null, new AnimatedContentMeasurePolicy$measure$3(placeableArr, this, width3, height3), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(list), new AnimatedContentMeasurePolicy$minIntrinsicWidth$1(i)));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(list), new AnimatedContentMeasurePolicy$minIntrinsicHeight$1(i)));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(list), new AnimatedContentMeasurePolicy$maxIntrinsicWidth$1(i)));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(list), new AnimatedContentMeasurePolicy$maxIntrinsicHeight$1(i)));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
