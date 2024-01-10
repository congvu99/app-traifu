package io.intercom.android.sdk.survey.ui.questiontype.numericscale;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: StarRating.kt */
final class StarRatingKt$StarRating$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $strokeColor;
    final /* synthetic */ float $strokeWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StarRatingKt$StarRating$1$1(long j, float f, long j2) {
        super(1);
        this.$strokeColor = j;
        this.$strokeWidth = f;
        this.$backgroundColor = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        DrawScope drawScope2 = drawScope;
        Intrinsics.checkNotNullParameter(drawScope2, "$this$Canvas");
        float r1 = Size.m1752getWidthimpl(drawScope.m2478getSizeNHjbRc());
        Path starPath = StarRatingKt.getStarPath();
        long Offset = OffsetKt.Offset(0.0f, 0.0f);
        long j = this.$strokeColor;
        float f = this.$strokeWidth;
        long j2 = this.$backgroundColor;
        DrawContext drawContext = drawScope.getDrawContext();
        long r9 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2570scale0AR0LA0(r1 / 33.0f, Size.m1749getHeightimpl(drawScope.m2478getSizeNHjbRc()) / 32.0f, Offset);
        DrawScope.CC.m2510drawPathLG529CI$default(drawScope, starPath, j, 0.0f, new Stroke(drawScope2.m4649toPx0680j_4(f), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 52, (Object) null);
        DrawScope drawScope3 = drawScope;
        Path path = starPath;
        long j3 = j2;
        DrawScope.CC.m2510drawPathLG529CI$default(drawScope3, path, j3, 0.0f, Fill.INSTANCE, ColorFilter.Companion.m1976tintxETnrds(j2, BlendMode.Companion.m1862getSrcIn0nO6VwU()), 0, 36, (Object) null);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r9);
    }
}
