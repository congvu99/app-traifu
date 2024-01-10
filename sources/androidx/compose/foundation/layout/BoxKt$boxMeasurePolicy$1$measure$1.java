package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Box.kt */
final class BoxKt$boxMeasurePolicy$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    public static final BoxKt$boxMeasurePolicy$1$measure$1 INSTANCE = new BoxKt$boxMeasurePolicy$1$measure$1();

    BoxKt$boxMeasurePolicy$1$measure$1() {
        super(1);
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }
}
