package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: GraphicsLayerModifier.kt */
final class SimpleGraphicsLayerModifier$layerBlock$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ SimpleGraphicsLayerModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleGraphicsLayerModifier$layerBlock$1(SimpleGraphicsLayerModifier simpleGraphicsLayerModifier) {
        super(1);
        this.this$0 = simpleGraphicsLayerModifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$null");
        graphicsLayerScope.setScaleX(this.this$0.scaleX);
        graphicsLayerScope.setScaleY(this.this$0.scaleY);
        graphicsLayerScope.setAlpha(this.this$0.alpha);
        graphicsLayerScope.setTranslationX(this.this$0.translationX);
        graphicsLayerScope.setTranslationY(this.this$0.translationY);
        graphicsLayerScope.setShadowElevation(this.this$0.shadowElevation);
        graphicsLayerScope.setRotationX(this.this$0.rotationX);
        graphicsLayerScope.setRotationY(this.this$0.rotationY);
        graphicsLayerScope.setRotationZ(this.this$0.rotationZ);
        graphicsLayerScope.setCameraDistance(this.this$0.cameraDistance);
        graphicsLayerScope.m2077setTransformOrigin__ExYCQ(this.this$0.transformOrigin);
        graphicsLayerScope.setShape(this.this$0.shape);
        graphicsLayerScope.setClip(this.this$0.clip);
        graphicsLayerScope.setRenderEffect(this.this$0.renderEffect);
        graphicsLayerScope.m2075setAmbientShadowColor8_81llA(this.this$0.ambientShadowColor);
        graphicsLayerScope.m2076setSpotShadowColor8_81llA(this.this$0.spotShadowColor);
    }
}
