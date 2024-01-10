package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Row.kt */
final class RowKt$rowMeasurePolicy$1$1 extends Lambda implements Function5<Integer, int[], LayoutDirection, Density, int[], Unit> {
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RowKt$rowMeasurePolicy$1$1(Arrangement.Horizontal horizontal) {
        super(5);
        this.$horizontalArrangement = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        invoke(((Number) obj).intValue(), (int[]) obj2, (LayoutDirection) obj3, (Density) obj4, (int[]) obj5);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int[] iArr, LayoutDirection layoutDirection, Density density, int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(layoutDirection, ViewProps.LAYOUT_DIRECTION);
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        this.$horizontalArrangement.arrange(density, i, iArr, layoutDirection, iArr2);
    }
}
