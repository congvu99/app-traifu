package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Offset.kt */
final class OffsetPxModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ OffsetPxModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OffsetPxModifier$measure$1(OffsetPxModifier offsetPxModifier, MeasureScope measureScope, Placeable placeable) {
        super(1);
        this.this$0 = offsetPxModifier;
        this.$this_measure = measureScope;
        this.$placeable = placeable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        long r2 = this.this$0.getOffset().invoke(this.$this_measure).m4831unboximpl();
        if (this.this$0.getRtlAware()) {
            Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, this.$placeable, IntOffset.m4822getXimpl(r2), IntOffset.m4823getYimpl(r2), 0.0f, (Function1) null, 12, (Object) null);
            return;
        }
        Placeable.PlacementScope.placeWithLayer$default(placementScope, this.$placeable, IntOffset.m4822getXimpl(r2), IntOffset.m4823getYimpl(r2), 0.0f, (Function1) null, 12, (Object) null);
    }
}
