package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$CircularProgressIndicator$3 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Float> $baseRotation$delegate;
    final /* synthetic */ long $color;
    final /* synthetic */ State<Integer> $currentRotation$delegate;
    final /* synthetic */ State<Float> $endAngle$delegate;
    final /* synthetic */ State<Float> $startAngle$delegate;
    final /* synthetic */ Stroke $stroke;
    final /* synthetic */ float $strokeWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$CircularProgressIndicator$3(float f, long j, Stroke stroke, State<Integer> state, State<Float> state2, State<Float> state3, State<Float> state4) {
        super(1);
        this.$strokeWidth = f;
        this.$color = j;
        this.$stroke = stroke;
        this.$currentRotation$delegate = state;
        this.$endAngle$delegate = state2;
        this.$startAngle$delegate = state3;
        this.$baseRotation$delegate = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        DrawScope drawScope2 = drawScope;
        ProgressIndicatorKt.m1384drawIndeterminateCircularIndicatorhrjfTZI(drawScope2, ProgressIndicatorKt.m1361CircularProgressIndicator_aM_cp0Q$lambda11(this.$startAngle$delegate) + (((((float) ProgressIndicatorKt.m1362CircularProgressIndicator_aM_cp0Q$lambda8(this.$currentRotation$delegate)) * 216.0f) % 360.0f) - 0.049804688f) + ProgressIndicatorKt.m1363CircularProgressIndicator_aM_cp0Q$lambda9(this.$baseRotation$delegate), this.$strokeWidth, Math.abs(ProgressIndicatorKt.m1360CircularProgressIndicator_aM_cp0Q$lambda10(this.$endAngle$delegate) - ProgressIndicatorKt.m1361CircularProgressIndicator_aM_cp0Q$lambda11(this.$startAngle$delegate)), this.$color, this.$stroke);
    }
}
