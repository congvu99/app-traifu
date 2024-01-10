package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$Track$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Color> $activeTickColor;
    final /* synthetic */ State<Color> $activeTrackColor;
    final /* synthetic */ State<Color> $inactiveTickColor;
    final /* synthetic */ State<Color> $inactiveTrackColor;
    final /* synthetic */ float $positionFractionEnd;
    final /* synthetic */ float $positionFractionStart;
    final /* synthetic */ float $thumbPx;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ float $trackStrokeWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Track$1(float f, State<Color> state, float f2, float f3, float f4, State<Color> state2, List<Float> list, State<Color> state3, State<Color> state4) {
        super(1);
        this.$thumbPx = f;
        this.$inactiveTrackColor = state;
        this.$trackStrokeWidth = f2;
        this.$positionFractionEnd = f3;
        this.$positionFractionStart = f4;
        this.$activeTrackColor = state2;
        this.$tickFractions = list;
        this.$inactiveTickColor = state3;
        this.$activeTickColor = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long Offset = OffsetKt.Offset(this.$thumbPx, Offset.m1684getYimpl(drawScope.m2477getCenterF1C5BW0()));
        long Offset2 = OffsetKt.Offset(Size.m1752getWidthimpl(drawScope.m2478getSizeNHjbRc()) - this.$thumbPx, Offset.m1684getYimpl(drawScope.m2477getCenterF1C5BW0()));
        long j = z ? Offset2 : Offset;
        long j2 = z ? Offset : Offset2;
        long j3 = j2;
        long j4 = j;
        DrawScope.CC.m2506drawLineNGM6Ib0$default(drawScope, this.$inactiveTrackColor.getValue().m1942unboximpl(), j, j2, this.$trackStrokeWidth, StrokeCap.Companion.m2288getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        DrawScope.CC.m2506drawLineNGM6Ib0$default(drawScope, this.$activeTrackColor.getValue().m1942unboximpl(), OffsetKt.Offset(Offset.m1683getXimpl(j4) + ((Offset.m1683getXimpl(j3) - Offset.m1683getXimpl(j4)) * this.$positionFractionStart), Offset.m1684getYimpl(drawScope.m2477getCenterF1C5BW0())), OffsetKt.Offset(Offset.m1683getXimpl(j4) + ((Offset.m1683getXimpl(j3) - Offset.m1683getXimpl(j4)) * this.$positionFractionEnd), Offset.m1684getYimpl(drawScope.m2477getCenterF1C5BW0())), this.$trackStrokeWidth, StrokeCap.Companion.m2288getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        float f = this.$positionFractionEnd;
        float f2 = this.$positionFractionStart;
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : this.$tickFractions) {
            float floatValue = ((Number) next).floatValue();
            Boolean valueOf = Boolean.valueOf(floatValue > f || floatValue < f2);
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(valueOf, obj);
            }
            ((List) obj).add(next);
        }
        State<Color> state = this.$inactiveTickColor;
        State<Color> state2 = this.$activeTickColor;
        float f3 = this.$trackStrokeWidth;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
            Iterable<Number> iterable = (List) entry.getValue();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Number floatValue2 : iterable) {
                arrayList.add(Offset.m1672boximpl(OffsetKt.Offset(Offset.m1683getXimpl(OffsetKt.m1706lerpWko1d7g(j4, j3, floatValue2.floatValue())), Offset.m1684getYimpl(drawScope.m2477getCenterF1C5BW0()))));
            }
            long j5 = j3;
            long j6 = j4;
            DrawScope.CC.m2511drawPointsF8ZwMP8$default(drawScope, (List) arrayList, PointMode.Companion.m2222getPointsr_lszbg(), (booleanValue ? state : state2).getValue().m1942unboximpl(), f3, StrokeCap.Companion.m2288getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
            j4 = j6;
            f3 = f3;
            j3 = j5;
        }
    }
}
