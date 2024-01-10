package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Border.kt */
final class BorderKt$border$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Brush $brush;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BorderKt$border$2(float f, Shape shape, Brush brush) {
        super(3);
        this.$width = f;
        this.$shape = shape;
        this.$brush = brush;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-1498088849);
        ComposerKt.sourceInformation(composer, "C97@4024L31:Border.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1498088849, i, -1, "androidx.compose.foundation.border.<anonymous> (Border.kt:93)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Ref();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final Ref ref = (Ref) rememberedValue;
        final float f = this.$width;
        final Shape shape = this.$shape;
        final Brush brush = this.$brush;
        Modifier then = modifier.then(DrawModifierKt.drawWithCache(Modifier.Companion, new Function1<CacheDrawScope, DrawResult>() {
            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                CacheDrawScope cacheDrawScope2 = cacheDrawScope;
                Intrinsics.checkNotNullParameter(cacheDrawScope2, "$this$drawWithCache");
                if (!(cacheDrawScope2.m1588toPx0680j_4(f) >= 0.0f && Size.m1751getMinDimensionimpl(cacheDrawScope.m1580getSizeNHjbRc()) > 0.0f)) {
                    return BorderKt.drawContentWithoutBorder(cacheDrawScope);
                }
                float f = (float) 2;
                float min = Math.min(Dp.m4709equalsimpl0(f, Dp.Companion.m4722getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil((double) cacheDrawScope2.m1588toPx0680j_4(f)), (float) Math.ceil((double) (Size.m1751getMinDimensionimpl(cacheDrawScope.m1580getSizeNHjbRc()) / f)));
                float f2 = min / f;
                long Offset = OffsetKt.Offset(f2, f2);
                long Size = SizeKt.Size(Size.m1752getWidthimpl(cacheDrawScope.m1580getSizeNHjbRc()) - min, Size.m1749getHeightimpl(cacheDrawScope.m1580getSizeNHjbRc()) - min);
                boolean z = f * min > Size.m1751getMinDimensionimpl(cacheDrawScope.m1580getSizeNHjbRc());
                Outline r2 = shape.m2266createOutlinePq9zytI(cacheDrawScope.m1580getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope2);
                if (r2 instanceof Outline.Generic) {
                    return BorderKt.drawGenericBorder(cacheDrawScope, ref, brush, (Outline.Generic) r2, z, min);
                } else if (r2 instanceof Outline.Rounded) {
                    return BorderKt.m186drawRoundRectBorderSYlcjDY(cacheDrawScope, ref, brush, (Outline.Rounded) r2, Offset, Size, z, min);
                } else if (r2 instanceof Outline.Rectangle) {
                    return BorderKt.m185drawRectBorderNsqcLGU(cacheDrawScope, brush, Offset, Size, z, min);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
