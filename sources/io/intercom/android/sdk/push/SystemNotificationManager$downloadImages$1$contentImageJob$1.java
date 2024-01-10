package io.intercom.android.sdk.push;

import android.content.Context;
import android.graphics.Bitmap;
import io.intercom.android.sdk.identity.AppConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.push.SystemNotificationManager$downloadImages$1$contentImageJob$1", f = "SystemNotificationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SystemNotificationManager.kt */
final class SystemNotificationManager$downloadImages$1$contentImageJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppConfig $appConfig;
    final /* synthetic */ Ref.ObjectRef<Bitmap> $contentImage;
    final /* synthetic */ Context $context;
    final /* synthetic */ PushPayload $payload;
    int label;
    final /* synthetic */ SystemNotificationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SystemNotificationManager$downloadImages$1$contentImageJob$1(Ref.ObjectRef<Bitmap> objectRef, SystemNotificationManager systemNotificationManager, PushPayload pushPayload, Context context, AppConfig appConfig, Continuation<? super SystemNotificationManager$downloadImages$1$contentImageJob$1> continuation) {
        super(2, continuation);
        this.$contentImage = objectRef;
        this.this$0 = systemNotificationManager;
        this.$payload = pushPayload;
        this.$context = context;
        this.$appConfig = appConfig;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SystemNotificationManager$downloadImages$1$contentImageJob$1(this.$contentImage, this.this$0, this.$payload, this.$context, this.$appConfig, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SystemNotificationManager$downloadImages$1$contentImageJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$contentImage.element = this.this$0.downloadContentImage(this.$payload, this.$context, this.$appConfig);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
