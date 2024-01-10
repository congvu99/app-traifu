package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetKt$ModalBottomSheetLayout$1$2$1 extends Lambda implements Function1<Density, IntOffset> {
    final /* synthetic */ float $fullHeight;
    final /* synthetic */ ModalBottomSheetState $sheetState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$ModalBottomSheetLayout$1$2$1(ModalBottomSheetState modalBottomSheetState, float f) {
        super(1);
        this.$sheetState = modalBottomSheetState;
        this.$fullHeight = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m4813boximpl(m1337invokeBjo55l4((Density) obj));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m1337invokeBjo55l4(Density density) {
        int i;
        Intrinsics.checkNotNullParameter(density, "$this$offset");
        if (this.$sheetState.getAnchors$material_release().isEmpty()) {
            i = MathKt.roundToInt(this.$fullHeight);
        } else {
            i = MathKt.roundToInt(this.$sheetState.getOffset().getValue().floatValue());
        }
        return IntOffsetKt.IntOffset(0, i);
    }
}
