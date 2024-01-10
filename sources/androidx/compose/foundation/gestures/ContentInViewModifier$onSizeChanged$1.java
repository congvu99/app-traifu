package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewModifier$onSizeChanged$1", f = "ContentInViewModifier.kt", i = {0}, l = {195}, m = "invokeSuspend", n = {"job"}, s = {"L$0"})
/* compiled from: ContentInViewModifier.kt */
final class ContentInViewModifier$onSizeChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Rect $focusedBounds;
    final /* synthetic */ Rect $targetBounds;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ContentInViewModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentInViewModifier$onSizeChanged$1(ContentInViewModifier contentInViewModifier, Rect rect, Rect rect2, Continuation<? super ContentInViewModifier$onSizeChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = contentInViewModifier;
        this.$focusedBounds = rect;
        this.$targetBounds = rect2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContentInViewModifier$onSizeChanged$1 contentInViewModifier$onSizeChanged$1 = new ContentInViewModifier$onSizeChanged$1(this.this$0, this.$focusedBounds, this.$targetBounds, continuation);
        contentInViewModifier$onSizeChanged$1.L$0 = obj;
        return contentInViewModifier$onSizeChanged$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentInViewModifier$onSizeChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th;
        Job job;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Job launch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new ContentInViewModifier$onSizeChanged$1$job$1(this.this$0, this.$focusedBounds, this.$targetBounds, (Continuation<? super ContentInViewModifier$onSizeChanged$1$job$1>) null), 3, (Object) null);
            this.this$0.focusAnimationJob = launch$default;
            try {
                this.L$0 = launch$default;
                this.label = 1;
                if (launch$default.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                job = launch$default;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                job = launch$default;
                th = th3;
                if (this.this$0.focusAnimationJob == job) {
                    this.this$0.focusedChildBeingAnimated = null;
                    this.this$0.setFocusTargetBounds((Rect) null);
                    this.this$0.focusAnimationJob = null;
                }
                throw th;
            }
        } else if (i == 1) {
            job = (Job) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.this$0.focusAnimationJob == job) {
            this.this$0.focusedChildBeingAnimated = null;
            this.this$0.setFocusTargetBounds((Rect) null);
            this.this$0.focusAnimationJob = null;
        }
        return Unit.INSTANCE;
    }
}
