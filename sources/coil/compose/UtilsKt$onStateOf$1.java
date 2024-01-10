package coil.compose;

import coil.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "state", "Lcoil/compose/AsyncImagePainter$State;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Utils.kt */
final class UtilsKt$onStateOf$1 extends Lambda implements Function1<AsyncImagePainter.State, Unit> {
    final /* synthetic */ Function1<AsyncImagePainter.State.Error, Unit> $onError;
    final /* synthetic */ Function1<AsyncImagePainter.State.Loading, Unit> $onLoading;
    final /* synthetic */ Function1<AsyncImagePainter.State.Success, Unit> $onSuccess;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UtilsKt$onStateOf$1(Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13) {
        super(1);
        this.$onLoading = function1;
        this.$onSuccess = function12;
        this.$onError = function13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AsyncImagePainter.State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AsyncImagePainter.State state) {
        if (state instanceof AsyncImagePainter.State.Loading) {
            Function1<AsyncImagePainter.State.Loading, Unit> function1 = this.$onLoading;
            if (function1 != null) {
                function1.invoke(state);
            }
        } else if (state instanceof AsyncImagePainter.State.Success) {
            Function1<AsyncImagePainter.State.Success, Unit> function12 = this.$onSuccess;
            if (function12 != null) {
                function12.invoke(state);
            }
        } else if (state instanceof AsyncImagePainter.State.Error) {
            Function1<AsyncImagePainter.State.Error, Unit> function13 = this.$onError;
            if (function13 != null) {
                function13.invoke(state);
            }
        } else {
            boolean z = state instanceof AsyncImagePainter.State.Empty;
        }
    }
}
