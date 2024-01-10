package io.intercom.android.sdk.inbox;

import io.intercom.android.sdk.api.MessengerApi;
import io.intercom.android.sdk.api.MessengerApiHelper;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.ConversationsResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/inbox/InboxRepository;", "", "api", "Lio/intercom/android/sdk/api/MessengerApi;", "(Lio/intercom/android/sdk/api/MessengerApi;)V", "getConversations", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse;", "Lio/intercom/android/sdk/models/ConversationsResponse$Builder;", "before", "", "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxRepository.kt */
public final class InboxRepository {
    private final MessengerApi api;

    public InboxRepository() {
        this((MessengerApi) null, 1, (DefaultConstructorMarker) null);
    }

    public InboxRepository(MessengerApi messengerApi) {
        Intrinsics.checkNotNullParameter(messengerApi, MetricTracker.Place.API);
        this.api = messengerApi;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InboxRepository(io.intercom.android.sdk.api.MessengerApi r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x0011
            io.intercom.android.sdk.Injector r1 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.api.MessengerApi r1 = r1.getMessengerApi()
            java.lang.String r2 = "get().messengerApi"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x0011:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.inbox.InboxRepository.<init>(io.intercom.android.sdk.api.MessengerApi, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ Object getConversations$default(InboxRepository inboxRepository, Long l, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return inboxRepository.getConversations(l, continuation);
    }

    public final Object getConversations(Long l, Continuation<? super NetworkResponse<ConversationsResponse.Builder>> continuation) {
        Map map;
        MessengerApi messengerApi = this.api;
        MessengerApiHelper messengerApiHelper = MessengerApiHelper.INSTANCE;
        if (l == null) {
            map = MapsKt.mapOf(TuplesKt.to("per_page", "20"));
        } else {
            map = MapsKt.mapOf(TuplesKt.to("per_page", "20"), TuplesKt.to("before", l.toString()));
        }
        return messengerApi.getConversationsSuspend(messengerApiHelper.getDefaultRequestBody$intercom_sdk_base_release(map), continuation);
    }
}
