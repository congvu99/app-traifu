package androidx.compose.foundation;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Image.kt */
final class ImageKt$Image$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    public static final ImageKt$Image$2$measure$1 INSTANCE = new ImageKt$Image$2$measure$1();

    ImageKt$Image$2$measure$1() {
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
