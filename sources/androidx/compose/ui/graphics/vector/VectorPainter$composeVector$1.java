package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: VectorPainter.kt */
final class VectorPainter$composeVector$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function4<Float, Float, Composer, Integer, Unit> $composable;
    final /* synthetic */ VectorPainter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VectorPainter$composeVector$1(Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, VectorPainter vectorPainter) {
        super(2);
        this.$composable = function4;
        this.this$0 = vectorPainter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C212@8157L55:VectorPainter.kt#huu6hf");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1916507005, i, -1, "androidx.compose.ui.graphics.vector.VectorPainter.composeVector.<anonymous> (VectorPainter.kt:211)");
            }
            this.$composable.invoke(Float.valueOf(this.this$0.vector.getViewportWidth()), Float.valueOf(this.this$0.vector.getViewportHeight()), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
