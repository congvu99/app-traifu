package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$LinearProgressIndicator$3$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $color;
    final /* synthetic */ State<Float> $firstLineHead$delegate;
    final /* synthetic */ State<Float> $firstLineTail$delegate;
    final /* synthetic */ State<Float> $secondLineHead$delegate;
    final /* synthetic */ State<Float> $secondLineTail$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$3$1(long j, long j2, State<Float> state, State<Float> state2, State<Float> state3, State<Float> state4) {
        super(1);
        this.$backgroundColor = j;
        this.$color = j2;
        this.$firstLineHead$delegate = state;
        this.$firstLineTail$delegate = state2;
        this.$secondLineHead$delegate = state3;
        this.$secondLineTail$delegate = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        float r0 = Size.m1749getHeightimpl(drawScope.m2478getSizeNHjbRc());
        ProgressIndicatorKt.m1386drawLinearIndicatorBackgroundbw27NRU(drawScope, this.$backgroundColor, r0);
        if (ProgressIndicatorKt.m1366LinearProgressIndicator_RIQooxk$lambda1(this.$firstLineHead$delegate) - ProgressIndicatorKt.m1367LinearProgressIndicator_RIQooxk$lambda2(this.$firstLineTail$delegate) > 0.0f) {
            ProgressIndicatorKt.m1385drawLinearIndicator42QJj7c(drawScope, ProgressIndicatorKt.m1366LinearProgressIndicator_RIQooxk$lambda1(this.$firstLineHead$delegate), ProgressIndicatorKt.m1367LinearProgressIndicator_RIQooxk$lambda2(this.$firstLineTail$delegate), this.$color, r0);
        }
        if (ProgressIndicatorKt.m1368LinearProgressIndicator_RIQooxk$lambda3(this.$secondLineHead$delegate) - ProgressIndicatorKt.m1369LinearProgressIndicator_RIQooxk$lambda4(this.$secondLineTail$delegate) > 0.0f) {
            ProgressIndicatorKt.m1385drawLinearIndicator42QJj7c(drawScope, ProgressIndicatorKt.m1368LinearProgressIndicator_RIQooxk$lambda3(this.$secondLineHead$delegate), ProgressIndicatorKt.m1369LinearProgressIndicator_RIQooxk$lambda4(this.$secondLineTail$delegate), this.$color, r0);
        }
    }
}
