package io.intercom.android.sdk.push;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import io.intercom.android.sdk.identity.AppConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/graphics/Bitmap;", "contentImage", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SystemNotificationManager.kt */
final class SystemNotificationManager$createPushOnlyNotification$1 extends Lambda implements Function2<Bitmap, Bitmap, Unit> {
    final /* synthetic */ AppConfig $appConfig;
    final /* synthetic */ Context $context;
    final /* synthetic */ PushPayload $payload;
    final /* synthetic */ SystemNotificationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SystemNotificationManager$createPushOnlyNotification$1(SystemNotificationManager systemNotificationManager, PushPayload pushPayload, Context context, AppConfig appConfig) {
        super(2);
        this.this$0 = systemNotificationManager;
        this.$payload = pushPayload;
        this.$context = context;
        this.$appConfig = appConfig;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Bitmap) obj, (Bitmap) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Bitmap bitmap, Bitmap bitmap2) {
        Notification createPushOnlyNotification = this.this$0.systemNotificationFactory.createPushOnlyNotification(this.$payload, this.$context, this.$appConfig, bitmap2);
        String pushOnlyConversationId = this.$payload.getPushOnlyConversationId();
        this.this$0.androidNotificationManager.notify(pushOnlyConversationId, pushOnlyConversationId.hashCode(), createPushOnlyNotification);
    }
}
