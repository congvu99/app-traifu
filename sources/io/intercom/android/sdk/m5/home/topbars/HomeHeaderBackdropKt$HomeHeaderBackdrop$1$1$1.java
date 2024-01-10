package io.intercom.android.sdk.m5.home.topbars;

import coil.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeHeaderBackdrop.kt */
final class HomeHeaderBackdropKt$HomeHeaderBackdrop$1$1$1 extends Lambda implements Function1<AsyncImagePainter.State.Success, Unit> {
    final /* synthetic */ Function0<Unit> $onImageLoaded;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeHeaderBackdropKt$HomeHeaderBackdrop$1$1$1(Function0<Unit> function0) {
        super(1);
        this.$onImageLoaded = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AsyncImagePainter.State.Success) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AsyncImagePainter.State.Success success) {
        Intrinsics.checkNotNullParameter(success, "it");
        this.$onImageLoaded.invoke();
    }
}
