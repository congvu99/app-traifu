package androidx.compose.foundation.text.selection;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {
    final /* synthetic */ ResolvedTextDirection $direction;
    final /* synthetic */ long $handleColor;
    final /* synthetic */ boolean $handlesCrossed;
    final /* synthetic */ boolean $isStartHandle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1(long j, boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        super(1);
        this.$handleColor = j;
        this.$isStartHandle = z;
        this.$direction = resolvedTextDirection;
        this.$handlesCrossed = z2;
    }

    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
        Intrinsics.checkNotNullParameter(cacheDrawScope, "$this$drawWithCache");
        final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, Size.m1752getWidthimpl(cacheDrawScope.m1580getSizeNHjbRc()) / 2.0f);
        final ColorFilter r6 = ColorFilter.Companion.m1973tintxETnrds$default(ColorFilter.Companion, this.$handleColor, 0, 2, (Object) null);
        final boolean z = this.$isStartHandle;
        final ResolvedTextDirection resolvedTextDirection = this.$direction;
        final boolean z2 = this.$handlesCrossed;
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                contentDrawScope.drawContent();
                if (AndroidSelectionHandles_androidKt.isLeft(z, resolvedTextDirection, z2)) {
                    DrawScope drawScope = contentDrawScope;
                    ImageBitmap imageBitmap = createHandleImage;
                    ColorFilter colorFilter = r6;
                    long r3 = drawScope.m2477getCenterF1C5BW0();
                    DrawContext drawContext = drawScope.getDrawContext();
                    long r12 = drawContext.m2456getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    drawContext.getTransform().m2570scale0AR0LA0(-1.0f, 1.0f, r3);
                    DrawScope.CC.m2504drawImagegbVJVH8$default(drawScope, imageBitmap, 0, 0.0f, (DrawStyle) null, colorFilter, 0, 46, (Object) null);
                    drawContext.getCanvas().restore();
                    drawContext.m2457setSizeuvyYCjk(r12);
                    return;
                }
                DrawScope.CC.m2504drawImagegbVJVH8$default(contentDrawScope, createHandleImage, 0, 0.0f, (DrawStyle) null, r6, 0, 46, (Object) null);
            }
        });
    }
}
