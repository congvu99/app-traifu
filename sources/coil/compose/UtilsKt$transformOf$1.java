package coil.compose;

import androidx.compose.ui.graphics.painter.Painter;
import coil.compose.AsyncImagePainter;
import coil.request.ErrorResult;
import coil.request.NullRequestDataException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcoil/compose/AsyncImagePainter$State;", "state", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Utils.kt */
final class UtilsKt$transformOf$1 extends Lambda implements Function1<AsyncImagePainter.State, AsyncImagePainter.State> {
    final /* synthetic */ Painter $error;
    final /* synthetic */ Painter $fallback;
    final /* synthetic */ Painter $placeholder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UtilsKt$transformOf$1(Painter painter, Painter painter2, Painter painter3) {
        super(1);
        this.$placeholder = painter;
        this.$fallback = painter2;
        this.$error = painter3;
    }

    public final AsyncImagePainter.State invoke(AsyncImagePainter.State state) {
        if (state instanceof AsyncImagePainter.State.Loading) {
            Painter painter = this.$placeholder;
            AsyncImagePainter.State.Loading loading = (AsyncImagePainter.State.Loading) state;
            if (painter != null) {
                loading = loading.copy(painter);
            }
            return loading;
        } else if (!(state instanceof AsyncImagePainter.State.Error)) {
            return state;
        } else {
            AsyncImagePainter.State.Error error = (AsyncImagePainter.State.Error) state;
            if (error.getResult().getThrowable() instanceof NullRequestDataException) {
                Painter painter2 = this.$fallback;
                if (painter2 != null) {
                    error = AsyncImagePainter.State.Error.copy$default(error, painter2, (ErrorResult) null, 2, (Object) null);
                }
            } else {
                Painter painter3 = this.$error;
                if (painter3 != null) {
                    error = AsyncImagePainter.State.Error.copy$default(error, painter3, (ErrorResult) null, 2, (Object) null);
                }
            }
            return error;
        }
    }
}
