package io.intercom.android.sdk.push;

import android.content.Context;
import android.graphics.Bitmap;
import io.intercom.android.sdk.identity.AppConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.push.SystemNotificationManager$downloadImages$1", f = "SystemNotificationManager.kt", i = {0}, l = {130, 131}, m = "invokeSuspend", n = {"avatarImageJob"}, s = {"L$0"})
/* compiled from: SystemNotificationManager.kt */
final class SystemNotificationManager$downloadImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppConfig $appConfig;
    final /* synthetic */ Ref.ObjectRef<Bitmap> $avatarImage;
    final /* synthetic */ Ref.ObjectRef<Bitmap> $contentImage;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function2<Bitmap, Bitmap, Unit> $onComplete;
    final /* synthetic */ PushPayload $payload;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SystemNotificationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SystemNotificationManager$downloadImages$1(Function2<? super Bitmap, ? super Bitmap, Unit> function2, Ref.ObjectRef<Bitmap> objectRef, Ref.ObjectRef<Bitmap> objectRef2, SystemNotificationManager systemNotificationManager, PushPayload pushPayload, Context context, AppConfig appConfig, Continuation<? super SystemNotificationManager$downloadImages$1> continuation) {
        super(2, continuation);
        this.$onComplete = function2;
        this.$avatarImage = objectRef;
        this.$contentImage = objectRef2;
        this.this$0 = systemNotificationManager;
        this.$payload = pushPayload;
        this.$context = context;
        this.$appConfig = appConfig;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SystemNotificationManager$downloadImages$1 systemNotificationManager$downloadImages$1 = new SystemNotificationManager$downloadImages$1(this.$onComplete, this.$avatarImage, this.$contentImage, this.this$0, this.$payload, this.$context, this.$appConfig, continuation);
        systemNotificationManager$downloadImages$1.L$0 = obj;
        return systemNotificationManager$downloadImages$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SystemNotificationManager$downloadImages$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Job job;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Job launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SystemNotificationManager$downloadImages$1$contentImageJob$1(this.$contentImage, this.this$0, this.$payload, this.$context, this.$appConfig, (Continuation<? super SystemNotificationManager$downloadImages$1$contentImageJob$1>) null), 3, (Object) null);
            Job launch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SystemNotificationManager$downloadImages$1$avatarImageJob$1(this.$avatarImage, this.this$0, this.$payload, this.$context, this.$appConfig, (Continuation<? super SystemNotificationManager$downloadImages$1$avatarImageJob$1>) null), 3, (Object) null);
            this.L$0 = launch$default2;
            this.label = 1;
            if (launch$default.join(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            job = launch$default2;
        } else if (i == 1) {
            job = (Job) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            try {
                ResultKt.throwOnFailure(obj);
                this.$onComplete.invoke(this.$avatarImage.element, this.$contentImage.element);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                this.$onComplete.invoke(this.$avatarImage.element, this.$contentImage.element);
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.L$0 = null;
        this.label = 2;
        if (job.join(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.$onComplete.invoke(this.$avatarImage.element, this.$contentImage.element);
        return Unit.INSTANCE;
    }
}
