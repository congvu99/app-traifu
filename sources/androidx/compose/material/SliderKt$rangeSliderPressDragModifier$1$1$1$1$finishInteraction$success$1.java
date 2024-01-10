package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1 extends Lambda implements Function1<PointerInputChange, Unit> {
    final /* synthetic */ Ref.BooleanRef $draggingStart;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1(State<? extends Function2<? super Boolean, ? super Float, Unit>> state, Ref.BooleanRef booleanRef, boolean z) {
        super(1);
        this.$onDrag = state;
        this.$draggingStart = booleanRef;
        this.$isRtl = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "it");
        float r4 = Offset.m1683getXimpl(PointerEventKt.positionChange(pointerInputChange));
        Function2 value = this.$onDrag.getValue();
        Boolean valueOf = Boolean.valueOf(this.$draggingStart.element);
        if (this.$isRtl) {
            r4 = -r4;
        }
        value.invoke(valueOf, Float.valueOf(r4));
    }
}
