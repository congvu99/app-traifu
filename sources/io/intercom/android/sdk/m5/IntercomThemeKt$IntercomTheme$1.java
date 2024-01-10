package io.intercom.android.sdk.m5;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomTheme.kt */
final class IntercomThemeKt$IntercomTheme$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Colors $lightColors;
    final /* synthetic */ Shapes $shapes;
    final /* synthetic */ Typography $typography;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomThemeKt$IntercomTheme$1(Colors colors, Shapes shapes, Typography typography, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
        super(2);
        this.$lightColors = colors;
        this.$shapes = shapes;
        this.$typography = typography;
        this.$content = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        IntercomThemeKt.IntercomTheme(this.$lightColors, this.$shapes, this.$typography, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
