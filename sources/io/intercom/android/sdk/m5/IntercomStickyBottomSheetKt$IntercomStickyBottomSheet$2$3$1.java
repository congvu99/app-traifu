package io.intercom.android.sdk.m5;

import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomStickyBottomSheet.kt */
final class IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2$3$1 extends Lambda implements Function1<Density, IntOffset> {
    final /* synthetic */ float $maxHeight;
    final /* synthetic */ ModalBottomSheetState $sheetState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2$3$1(ModalBottomSheetState modalBottomSheetState, float f) {
        super(1);
        this.$sheetState = modalBottomSheetState;
        this.$maxHeight = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m4813boximpl(m5112invokeBjo55l4((Density) obj));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m5112invokeBjo55l4(Density density) {
        int i;
        Intrinsics.checkNotNullParameter(density, "$this$offset");
        if (IntercomStickyBottomSheetKt.isHidden(this.$sheetState)) {
            i = MathKt.roundToInt(this.$maxHeight);
        } else {
            i = MathKt.roundToInt(this.$sheetState.getOffset().getValue().floatValue());
        }
        return IntOffsetKt.IntOffset(0, i);
    }
}
