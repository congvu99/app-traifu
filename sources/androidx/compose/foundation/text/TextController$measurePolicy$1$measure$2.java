package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoreText.kt */
final class TextController$measurePolicy$1$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Pair<Placeable, IntOffset>> $placeables;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextController$measurePolicy$1$measure$2(List<? extends Pair<? extends Placeable, IntOffset>> list) {
        super(1);
        this.$placeables = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        List<Pair<Placeable, IntOffset>> list = this.$placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Pair pair = list.get(i);
            Placeable.PlacementScope.m3689place70tqf50$default(placementScope, (Placeable) pair.component1(), ((IntOffset) pair.component2()).m4831unboximpl(), 0.0f, 2, (Object) null);
        }
    }
}
