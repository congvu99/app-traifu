package com.google.accompanist.flowlayout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Flow.kt */
final class FlowKt$Flow$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ FlowCrossAxisAlignment $crossAxisAlignment;
    final /* synthetic */ float $crossAxisSpacing;
    final /* synthetic */ MainAxisAlignment $lastLineMainAxisAlignment;
    final /* synthetic */ MainAxisAlignment $mainAxisAlignment;
    final /* synthetic */ SizeMode $mainAxisSize;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ LayoutOrientation $orientation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt$Flow$2(Modifier modifier, LayoutOrientation layoutOrientation, SizeMode sizeMode, MainAxisAlignment mainAxisAlignment, float f, FlowCrossAxisAlignment flowCrossAxisAlignment, float f2, MainAxisAlignment mainAxisAlignment2, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$modifier = modifier;
        this.$orientation = layoutOrientation;
        this.$mainAxisSize = sizeMode;
        this.$mainAxisAlignment = mainAxisAlignment;
        this.$mainAxisSpacing = f;
        this.$crossAxisAlignment = flowCrossAxisAlignment;
        this.$crossAxisSpacing = f2;
        this.$lastLineMainAxisAlignment = mainAxisAlignment2;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        FlowKt.m5048FlowF4y8cZ0(this.$modifier, this.$orientation, this.$mainAxisSize, this.$mainAxisAlignment, this.$mainAxisSpacing, this.$crossAxisAlignment, this.$crossAxisSpacing, this.$lastLineMainAxisAlignment, this.$content, composer, this.$$changed | 1);
    }
}
