package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$remeasurementModifier$1", "Landroidx/compose/ui/layout/RemeasurementModifier;", "onRemeasurementAvailable", "", "remeasurement", "Landroidx/compose/ui/layout/Remeasurement;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyStaggeredGridState.kt */
public final class LazyStaggeredGridState$remeasurementModifier$1 implements RemeasurementModifier {
    final /* synthetic */ LazyStaggeredGridState this$0;

    public /* synthetic */ boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    public /* synthetic */ boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return Modifier.Element.CC.$default$any(this, function1);
    }

    public /* synthetic */ <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return Modifier.Element.CC.$default$foldIn(this, r, function2);
    }

    public /* synthetic */ <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return Modifier.Element.CC.$default$foldOut(this, r, function2);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    LazyStaggeredGridState$remeasurementModifier$1(LazyStaggeredGridState lazyStaggeredGridState) {
        this.this$0 = lazyStaggeredGridState;
    }

    public void onRemeasurementAvailable(Remeasurement remeasurement) {
        Intrinsics.checkNotNullParameter(remeasurement, "remeasurement");
        this.this$0.remeasurement = remeasurement;
    }
}
