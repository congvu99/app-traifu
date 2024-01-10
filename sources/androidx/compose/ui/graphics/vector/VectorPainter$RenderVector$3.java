package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: VectorPainter.kt */
final class VectorPainter$RenderVector$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function4<Float, Float, Composer, Integer, Unit> $content;
    final /* synthetic */ String $name;
    final /* synthetic */ VectorPainter $tmp0_rcvr;
    final /* synthetic */ float $viewportHeight;
    final /* synthetic */ float $viewportWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VectorPainter$RenderVector$3(VectorPainter vectorPainter, String str, float f, float f2, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, int i) {
        super(2);
        this.$tmp0_rcvr = vectorPainter;
        this.$name = str;
        this.$viewportWidth = f;
        this.$viewportHeight = f2;
        this.$content = function4;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.RenderVector$ui_release(this.$name, this.$viewportWidth, this.$viewportHeight, this.$content, composer, this.$$changed | 1);
    }
}
