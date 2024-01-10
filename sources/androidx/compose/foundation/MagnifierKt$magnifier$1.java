package androidx.compose.foundation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/unit/Density;", "invoke-tuRUvjQ", "(Landroidx/compose/ui/unit/Density;)J"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Magnifier.kt */
final class MagnifierKt$magnifier$1 extends Lambda implements Function1<Density, Offset> {
    public static final MagnifierKt$magnifier$1 INSTANCE = new MagnifierKt$magnifier$1();

    MagnifierKt$magnifier$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Offset.m1672boximpl(m228invoketuRUvjQ((Density) obj));
    }

    /* renamed from: invoke-tuRUvjQ  reason: not valid java name */
    public final long m228invoketuRUvjQ(Density density) {
        Intrinsics.checkNotNullParameter(density, "$this$null");
        return Offset.Companion.m1698getUnspecifiedF1C5BW0();
    }
}
