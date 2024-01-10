package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SingletonAsyncImage.kt */
final class SingletonAsyncImageKt$AsyncImage$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ Alignment $alignment;
    final /* synthetic */ float $alpha;
    final /* synthetic */ ColorFilter $colorFilter;
    final /* synthetic */ String $contentDescription;
    final /* synthetic */ ContentScale $contentScale;
    final /* synthetic */ Painter $error;
    final /* synthetic */ Painter $fallback;
    final /* synthetic */ int $filterQuality;
    final /* synthetic */ Object $model;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<AsyncImagePainter.State.Error, Unit> $onError;
    final /* synthetic */ Function1<AsyncImagePainter.State.Loading, Unit> $onLoading;
    final /* synthetic */ Function1<AsyncImagePainter.State.Success, Unit> $onSuccess;
    final /* synthetic */ Painter $placeholder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingletonAsyncImageKt$AsyncImage$1(Object obj, String str, Modifier modifier, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, int i2, int i3, int i4) {
        super(2);
        this.$model = obj;
        this.$contentDescription = str;
        this.$modifier = modifier;
        this.$placeholder = painter;
        this.$error = painter2;
        this.$fallback = painter3;
        this.$onLoading = function1;
        this.$onSuccess = function12;
        this.$onError = function13;
        this.$alignment = alignment;
        this.$contentScale = contentScale;
        this.$alpha = f;
        this.$colorFilter = colorFilter;
        this.$filterQuality = i;
        this.$$changed = i2;
        this.$$changed1 = i3;
        this.$$default = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        Object obj = this.$model;
        Object obj2 = obj;
        SingletonAsyncImageKt.m5019AsyncImageylYTKUw(obj2, this.$contentDescription, this.$modifier, this.$placeholder, this.$error, this.$fallback, this.$onLoading, this.$onSuccess, this.$onError, this.$alignment, this.$contentScale, this.$alpha, this.$colorFilter, this.$filterQuality, composer2, this.$$changed | 1, this.$$changed1, this.$$default);
    }
}
