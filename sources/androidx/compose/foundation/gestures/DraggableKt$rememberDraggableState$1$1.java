package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Draggable.kt */
final class DraggableKt$rememberDraggableState$1$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ State<Function1<Float, Unit>> $onDeltaState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DraggableKt$rememberDraggableState$1$1(State<? extends Function1<? super Float, Unit>> state) {
        super(1);
        this.$onDeltaState = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f) {
        this.$onDeltaState.getValue().invoke(Float.valueOf(f));
    }
}
