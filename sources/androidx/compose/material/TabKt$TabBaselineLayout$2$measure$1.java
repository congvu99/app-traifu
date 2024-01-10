package androidx.compose.material;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Tab.kt */
final class TabKt$TabBaselineLayout$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Integer $firstBaseline;
    final /* synthetic */ Placeable $iconPlaceable;
    final /* synthetic */ Integer $lastBaseline;
    final /* synthetic */ int $tabHeight;
    final /* synthetic */ int $tabWidth;
    final /* synthetic */ Placeable $textPlaceable;
    final /* synthetic */ MeasureScope $this_Layout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabKt$TabBaselineLayout$2$measure$1(Placeable placeable, Placeable placeable2, MeasureScope measureScope, int i, int i2, Integer num, Integer num2) {
        super(1);
        this.$textPlaceable = placeable;
        this.$iconPlaceable = placeable2;
        this.$this_Layout = measureScope;
        this.$tabWidth = i;
        this.$tabHeight = i2;
        this.$firstBaseline = num;
        this.$lastBaseline = num2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable placeable;
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable placeable2 = this.$textPlaceable;
        if (placeable2 == null || (placeable = this.$iconPlaceable) == null) {
            Placeable placeable3 = this.$textPlaceable;
            if (placeable3 != null) {
                TabKt.placeTextOrIcon(placementScope, placeable3, this.$tabHeight);
                return;
            }
            Placeable placeable4 = this.$iconPlaceable;
            if (placeable4 != null) {
                TabKt.placeTextOrIcon(placementScope, placeable4, this.$tabHeight);
                return;
            }
            return;
        }
        int i = this.$tabWidth;
        int i2 = this.$tabHeight;
        Integer num = this.$firstBaseline;
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        Integer num2 = this.$lastBaseline;
        Intrinsics.checkNotNull(num2);
        TabKt.placeTextAndIcon(placementScope, this.$this_Layout, placeable2, placeable, i, i2, intValue, num2.intValue());
    }
}
