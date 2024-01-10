package io.intercom.android.sdk.push;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import coil.request.ImageRequest;
import coil.transform.CircleCropTransformation;
import com.intercom.commons.utilities.ScreenUtils;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.utilities.BitmapUtilsKt;
import io.intercom.android.sdk.utilities.IntercomCoilKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0013J \u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019JZ\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00130 J \u0010%\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0003J\u000e\u0010'\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lio/intercom/android/sdk/push/SystemNotificationManager;", "", "androidNotificationManager", "Landroid/app/NotificationManager;", "(Landroid/app/NotificationManager;)V", "systemNotificationFactory", "Lio/intercom/android/sdk/push/SystemNotificationFactory;", "(Landroid/app/NotificationManager;Lio/intercom/android/sdk/push/SystemNotificationFactory;)V", "receivedPayloads", "", "Lio/intercom/android/sdk/push/PushPayload;", "getReceivedPayloads$annotations", "()V", "getReceivedPayloads", "()Ljava/util/List;", "twig", "Lcom/intercom/twig/Twig;", "kotlin.jvm.PlatformType", "clear", "", "createNotification", "payload", "context", "Landroid/content/Context;", "appConfig", "Lio/intercom/android/sdk/identity/AppConfig;", "createPushOnlyNotification", "deleteNotificationChannels", "downloadContentImage", "Landroid/graphics/Bitmap;", "downloadImages", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "avatar", "content", "generateAvatar", "setUpNotificationChannels", "setUpNotificationChannelsIfSupported", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SystemNotificationManager.kt */
public final class SystemNotificationManager {
    public static final int $stable = 8;
    public static final String ACTIONS_CHANNEL = "intercom_actions_channel";
    public static final String CHAT_REPLIES_CHANNEL = "intercom_chat_replies_channel";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float LARGE_ICON_SIZE_IN_DP = 48.0f;
    public static final String NEW_CHATS_CHANNEL = "intercom_new_chats_channel";
    private static final int NOTIFICATION_ID = 9999997;
    /* access modifiers changed from: private */
    public final NotificationManager androidNotificationManager;
    private final List<PushPayload> receivedPayloads;
    /* access modifiers changed from: private */
    public final SystemNotificationFactory systemNotificationFactory;
    private final Twig twig;

    public static /* synthetic */ void getReceivedPayloads$annotations() {
    }

    public SystemNotificationManager(NotificationManager notificationManager, SystemNotificationFactory systemNotificationFactory2) {
        Intrinsics.checkNotNullParameter(notificationManager, "androidNotificationManager");
        Intrinsics.checkNotNullParameter(systemNotificationFactory2, "systemNotificationFactory");
        this.androidNotificationManager = notificationManager;
        this.systemNotificationFactory = systemNotificationFactory2;
        List<PushPayload> synchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(ArrayList())");
        this.receivedPayloads = synchronizedList;
        this.twig = LumberMill.getLogger();
    }

    public final List<PushPayload> getReceivedPayloads() {
        return this.receivedPayloads;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SystemNotificationManager(NotificationManager notificationManager) {
        this(notificationManager, new SystemNotificationFactory());
        Intrinsics.checkNotNullParameter(notificationManager, "androidNotificationManager");
    }

    public final void setUpNotificationChannelsIfSupported(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 26) {
            setUpNotificationChannels(context);
        }
    }

    public final void deleteNotificationChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.androidNotificationManager.deleteNotificationChannel(CHAT_REPLIES_CHANNEL);
            this.androidNotificationManager.deleteNotificationChannel(NEW_CHATS_CHANNEL);
            this.androidNotificationManager.deleteNotificationChannel(ACTIONS_CHANNEL);
        }
    }

    private final void setUpNotificationChannels(Context context) {
        NotificationChannel notificationChannel = new NotificationChannel(CHAT_REPLIES_CHANNEL, context.getString(R.string.intercom_notification_channel_chat_replies_title), 4);
        notificationChannel.setDescription(context.getString(R.string.intercom_notification_channel_chat_replies_description));
        NotificationChannel notificationChannel2 = new NotificationChannel(NEW_CHATS_CHANNEL, context.getString(R.string.intercom_notification_channel_new_chats_title), 4);
        notificationChannel2.setDescription(context.getString(R.string.intercom_notification_channel_new_chats_description));
        NotificationChannel notificationChannel3 = new NotificationChannel(ACTIONS_CHANNEL, context.getString(R.string.intercom_notification_channel_actions_title), 4);
        notificationChannel3.setDescription(context.getString(R.string.intercom_notification_channel_actions_description));
        this.androidNotificationManager.createNotificationChannels(CollectionsKt.listOf(notificationChannel, notificationChannel2, notificationChannel3));
    }

    public final void clear() {
        if (!this.receivedPayloads.isEmpty()) {
            this.twig.i("Removing Intercom push notifications.", new Object[0]);
        }
        this.androidNotificationManager.cancel(NOTIFICATION_ID);
        this.receivedPayloads.clear();
    }

    public final void createPushOnlyNotification(PushPayload pushPayload, Context context, AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(pushPayload, "payload");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        downloadImages(pushPayload, context, appConfig, new SystemNotificationManager$createPushOnlyNotification$1(this, pushPayload, context, appConfig));
    }

    public final void createNotification(PushPayload pushPayload, Context context, AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(pushPayload, "payload");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        if (!this.receivedPayloads.contains(pushPayload)) {
            this.receivedPayloads.add(pushPayload);
            if (this.receivedPayloads.size() == 1) {
                downloadImages(pushPayload, context, appConfig, new SystemNotificationManager$createNotification$1(this, pushPayload, context, appConfig));
                return;
            }
            this.androidNotificationManager.notify(NOTIFICATION_ID, this.systemNotificationFactory.createGroupedNotification(this.receivedPayloads, context, appConfig));
        }
    }

    public final void downloadImages(PushPayload pushPayload, Context context, AppConfig appConfig, Function2<? super Bitmap, ? super Bitmap, Unit> function2) {
        Intrinsics.checkNotNullParameter(pushPayload, "payload");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Function2<? super Bitmap, ? super Bitmap, Unit> function22 = function2;
        Intrinsics.checkNotNullParameter(function22, "onComplete");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        CoroutineScope coroutineScope = GlobalScope.INSTANCE;
        CoroutineContext io2 = Dispatchers.getIO();
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, io2, (CoroutineStart) null, new SystemNotificationManager$downloadImages$1(function22, new Ref.ObjectRef(), objectRef, this, pushPayload, context, appConfig, (Continuation<? super SystemNotificationManager$downloadImages$1>) null), 2, (Object) null);
    }

    public final Bitmap downloadContentImage(PushPayload pushPayload, Context context, AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(pushPayload, "payload");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        int dpToPx = ScreenUtils.dpToPx(LARGE_ICON_SIZE_IN_DP, context);
        CharSequence contentImageUrl = pushPayload.getContentImageUrl();
        if (contentImageUrl == null || StringsKt.isBlank(contentImageUrl)) {
            return null;
        }
        Drawable loadIntercomImageBlocking = IntercomCoilKt.loadIntercomImageBlocking(context, new ImageRequest.Builder(context).dispatcher(Dispatchers.getIO()).data(pushPayload.getContentImageUrl()).build());
        if (loadIntercomImageBlocking == null) {
            loadIntercomImageBlocking = new BitmapDrawable(context.getResources(), PushAvatarUtils.getNotificationDefaultBitmap(context, appConfig));
        }
        return BitmapUtilsKt.drawableToBitmap(loadIntercomImageBlocking, dpToPx, dpToPx);
    }

    public final Bitmap generateAvatar(PushPayload pushPayload, Context context, AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(pushPayload, "payload");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        if (TextUtils.isEmpty(pushPayload.getImageUrl()) && !TextUtils.isEmpty(pushPayload.getAuthorName())) {
            return PushAvatarUtils.getNotificationInitialsBitmap(context, pushPayload.getAuthorName(), appConfig);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), PushAvatarUtils.getNotificationDefaultBitmap(context, appConfig));
        try {
            int dpToPx = ScreenUtils.dpToPx(LARGE_ICON_SIZE_IN_DP, context);
            Drawable loadIntercomImageBlocking = IntercomCoilKt.loadIntercomImageBlocking(context, new ImageRequest.Builder(context).error((Drawable) bitmapDrawable).transformations(new CircleCropTransformation()).data(pushPayload.getImageUrl()).dispatcher(Dispatchers.getIO()).size(dpToPx, dpToPx).build());
            Intrinsics.checkNotNull(loadIntercomImageBlocking);
            return BitmapUtilsKt.drawableToBitmap(loadIntercomImageBlocking, dpToPx, dpToPx);
        } catch (Exception unused) {
            this.twig.d("Failed to retrieve the notification image", new Object[0]);
            return bitmapDrawable.getBitmap();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/push/SystemNotificationManager$Companion;", "", "()V", "ACTIONS_CHANNEL", "", "CHAT_REPLIES_CHANNEL", "LARGE_ICON_SIZE_IN_DP", "", "NEW_CHATS_CHANNEL", "NOTIFICATION_ID", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SystemNotificationManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
