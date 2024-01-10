package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1 extends Lambda implements Function1<IntSize, Unit> {
    final /* synthetic */ MutableState<Float> $bottomSheetHeight$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1(MutableState<Float> mutableState) {
        super(1);
        this.$bottomSheetHeight$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1162invokeozmzZPI(((IntSize) obj).m4868unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final void m1162invokeozmzZPI(long j) {
        BottomSheetScaffoldKt.m1158BottomSheetScaffold_bGncdBI$lambda5(this.$bottomSheetHeight$delegate, Float.valueOf((float) IntSize.m4863getHeightimpl(j)));
    }
}
