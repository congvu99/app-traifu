package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidCursorHandle.android.kt */
final class AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {
    final /* synthetic */ long $handleColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1(long j) {
        super(1);
        this.$handleColor = j;
    }

    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
        Intrinsics.checkNotNullParameter(cacheDrawScope, "$this$drawWithCache");
        final float r0 = Size.m1752getWidthimpl(cacheDrawScope.m1580getSizeNHjbRc()) / 2.0f;
        final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, r0);
        final ColorFilter r2 = ColorFilter.Companion.m1973tintxETnrds$default(ColorFilter.Companion, this.$handleColor, 0, 2, (Object) null);
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                contentDrawScope.drawContent();
                DrawScope drawScope = contentDrawScope;
                float f = r0;
                ImageBitmap imageBitmap = createHandleImage;
                ColorFilter colorFilter = r2;
                DrawContext drawContext = drawScope.getDrawContext();
                long r11 = drawContext.m2456getSizeNHjbRc();
                drawContext.getCanvas().save();
                DrawTransform transform = drawContext.getTransform();
                DrawTransform.CC.translate$default(transform, f, 0.0f, 2, (Object) null);
                transform.m2569rotateUv8p0NA(45.0f, Offset.Companion.m1699getZeroF1C5BW0());
                DrawScope.CC.m2504drawImagegbVJVH8$default(drawScope, imageBitmap, 0, 0.0f, (DrawStyle) null, colorFilter, 0, 46, (Object) null);
                drawContext.getCanvas().restore();
                drawContext.m2457setSizeuvyYCjk(r11);
            }
        });
    }
}
