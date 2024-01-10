package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$CorrectValueSideEffect$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Float, Float> $scaleToOffset;
    final /* synthetic */ ClosedFloatingPointRange<Float> $trackRange;
    final /* synthetic */ float $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
    final /* synthetic */ MutableState<Float> $valueState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$CorrectValueSideEffect$1$1(ClosedFloatingPointRange<Float> closedFloatingPointRange, Function1<? super Float, Float> function1, float f, MutableState<Float> mutableState, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        super(0);
        this.$valueRange = closedFloatingPointRange;
        this.$scaleToOffset = function1;
        this.$value = f;
        this.$valueState = mutableState;
        this.$trackRange = closedFloatingPointRange2;
    }

    public final void invoke() {
        float floatValue = (this.$valueRange.getEndInclusive().floatValue() - this.$valueRange.getStart().floatValue()) / ((float) 1000);
        float floatValue2 = this.$scaleToOffset.invoke(Float.valueOf(this.$value)).floatValue();
        if (Math.abs(floatValue2 - this.$valueState.getValue().floatValue()) > floatValue && this.$trackRange.contains(this.$valueState.getValue())) {
            this.$valueState.setValue(Float.valueOf(floatValue2));
        }
    }
}
