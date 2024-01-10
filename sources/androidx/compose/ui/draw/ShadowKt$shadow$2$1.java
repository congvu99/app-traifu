package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Shadow.kt */
final class ShadowKt$shadow$2$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ long $ambientColor;
    final /* synthetic */ boolean $clip;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ long $spotColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShadowKt$shadow$2$1(float f, Shape shape, boolean z, long j, long j2) {
        super(1);
        this.$elevation = f;
        this.$shape = shape;
        this.$clip = z;
        this.$ambientColor = j;
        this.$spotColor = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setShadowElevation(graphicsLayerScope.m4649toPx0680j_4(this.$elevation));
        graphicsLayerScope.setShape(this.$shape);
        graphicsLayerScope.setClip(this.$clip);
        graphicsLayerScope.m2075setAmbientShadowColor8_81llA(this.$ambientColor);
        graphicsLayerScope.m2076setSpotShadowColor8_81llA(this.$spotColor);
    }
}
