package io.intercom.android.sdk.m5;

import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomStickyBottomSheet.kt */
final class IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onSheetDismissed;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ ModalBottomSheetState $sheetState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$3(Modifier modifier, ModalBottomSheetState modalBottomSheetState, Shape shape, float f, long j, long j2, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$sheetState = modalBottomSheetState;
        this.$shape = shape;
        this.$elevation = f;
        this.$backgroundColor = j;
        this.$scrimColor = j2;
        this.$onSheetDismissed = function0;
        this.$content = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        IntercomStickyBottomSheetKt.m5107IntercomStickyBottomSheeteVqBt0c(this.$modifier, this.$sheetState, this.$shape, this.$elevation, this.$backgroundColor, this.$scrimColor, this.$onSheetDismissed, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
