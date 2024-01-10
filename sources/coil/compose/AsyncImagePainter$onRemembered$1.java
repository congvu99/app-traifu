package coil.compose;

import androidx.compose.runtime.SnapshotStateKt;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "coil.compose.AsyncImagePainter$onRemembered$1", f = "AsyncImagePainter.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AsyncImagePainter.kt */
final class AsyncImagePainter$onRemembered$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AsyncImagePainter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AsyncImagePainter$onRemembered$1(AsyncImagePainter asyncImagePainter, Continuation<? super AsyncImagePainter$onRemembered$1> continuation) {
        super(2, continuation);
        this.this$0 = asyncImagePainter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsyncImagePainter$onRemembered$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AsyncImagePainter$onRemembered$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final AsyncImagePainter asyncImagePainter = this.this$0;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<ImageRequest>() {
                public final ImageRequest invoke() {
                    return asyncImagePainter.getRequest();
                }
            });
            final AsyncImagePainter asyncImagePainter2 = this.this$0;
            Flow mapLatest = FlowKt.mapLatest(snapshotFlow, new AnonymousClass2((Continuation<? super AnonymousClass2>) null));
            final AsyncImagePainter asyncImagePainter3 = this.this$0;
            this.label = 1;
            if (mapLatest.collect(new Object() {
                public final boolean equals(Object obj) {
                    if (!(obj instanceof FlowCollector) || !(obj instanceof FunctionAdapter)) {
                        return false;
                    }
                    return Intrinsics.areEqual((Object) getFunctionDelegate(), (Object) ((FunctionAdapter) obj).getFunctionDelegate());
                }

                public final Function<?> getFunctionDelegate() {
                    return new AdaptedFunctionReference(2, AsyncImagePainter.this, AsyncImagePainter.class, "updateState", "updateState(Lcoil/compose/AsyncImagePainter$State;)V", 4);
                }

                public final int hashCode() {
                    return getFunctionDelegate().hashCode();
                }

                public final Object emit(AsyncImagePainter.State state, Continuation<? super Unit> continuation) {
                    Object access$invokeSuspend$updateState = AsyncImagePainter.this.updateState(state);
                    return access$invokeSuspend$updateState == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$invokeSuspend$updateState : Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "Lcoil/compose/AsyncImagePainter$State;", "it", "Lcoil/request/ImageRequest;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "coil.compose.AsyncImagePainter$onRemembered$1$2", f = "AsyncImagePainter.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: coil.compose.AsyncImagePainter$onRemembered$1$2  reason: invalid class name */
    /* compiled from: AsyncImagePainter.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ImageRequest, Continuation<? super AsyncImagePainter.State>, Object> {
        Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(asyncImagePainter2, continuation);
        }

        public final Object invoke(ImageRequest imageRequest, Continuation<? super AsyncImagePainter.State> continuation) {
            return ((AnonymousClass2) create(imageRequest, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            AsyncImagePainter asyncImagePainter;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AsyncImagePainter asyncImagePainter2 = asyncImagePainter2;
                ImageLoader imageLoader = asyncImagePainter2.getImageLoader();
                AsyncImagePainter asyncImagePainter3 = asyncImagePainter2;
                this.L$0 = asyncImagePainter2;
                this.label = 1;
                Object execute = imageLoader.execute(asyncImagePainter3.updateRequest(asyncImagePainter3.getRequest()), this);
                if (execute == coroutine_suspended) {
                    return coroutine_suspended;
                }
                asyncImagePainter = asyncImagePainter2;
                obj = execute;
            } else if (i == 1) {
                asyncImagePainter = (AsyncImagePainter) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return asyncImagePainter.toState((ImageResult) obj);
        }
    }
}
