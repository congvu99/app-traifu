package coil.compose;

import coil.size.Size;
import coil.size.SizeResolver;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", "Lcoil/size/Size;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AsyncImagePainter.kt */
final class AsyncImagePainter$updateRequest$2$1 implements SizeResolver {
    final /* synthetic */ AsyncImagePainter this$0;

    AsyncImagePainter$updateRequest$2$1(AsyncImagePainter asyncImagePainter) {
        this.this$0 = asyncImagePainter;
    }

    public final Object size(Continuation<? super Size> continuation) {
        return FlowKt.first(new AsyncImagePainter$updateRequest$2$1$size$$inlined$mapNotNull$1(this.this$0.drawSize), continuation);
    }
}
