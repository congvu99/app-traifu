package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubcomposeAsyncImage.kt */
final class SubcomposeAsyncImageKt$SubcomposeAsyncImage$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ Alignment $alignment;
    final /* synthetic */ float $alpha;
    final /* synthetic */ ColorFilter $colorFilter;
    final /* synthetic */ String $contentDescription;
    final /* synthetic */ ContentScale $contentScale;
    final /* synthetic */ Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Error, Composer, Integer, Unit> $error;
    final /* synthetic */ int $filterQuality;
    final /* synthetic */ ImageLoader $imageLoader;
    final /* synthetic */ Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Loading, Composer, Integer, Unit> $loading;
    final /* synthetic */ Object $model;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<AsyncImagePainter.State.Error, Unit> $onError;
    final /* synthetic */ Function1<AsyncImagePainter.State.Loading, Unit> $onLoading;
    final /* synthetic */ Function1<AsyncImagePainter.State.Success, Unit> $onSuccess;
    final /* synthetic */ Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Success, Composer, Integer, Unit> $success;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubcomposeAsyncImageKt$SubcomposeAsyncImage$1(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, int i2, int i3, int i4) {
        super(2);
        this.$model = obj;
        this.$contentDescription = str;
        this.$imageLoader = imageLoader;
        this.$modifier = modifier;
        this.$loading = function4;
        this.$success = function42;
        this.$error = function43;
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
        SubcomposeAsyncImageKt.m5024SubcomposeAsyncImageQ4Kwu38(obj2, this.$contentDescription, this.$imageLoader, this.$modifier, this.$loading, this.$success, this.$error, this.$onLoading, this.$onSuccess, this.$onError, this.$alignment, this.$contentScale, this.$alpha, this.$colorFilter, this.$filterQuality, composer2, this.$$changed | 1, this.$$changed1, this.$$default);
    }
}
