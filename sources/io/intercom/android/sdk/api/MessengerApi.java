package io.intercom.android.sdk.api;

import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import io.intercom.android.sdk.m5.home.data.HomeV2Response;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.ConversationResponse;
import io.intercom.android.sdk.models.ConversationsResponse;
import io.intercom.android.sdk.models.GifResponse;
import io.intercom.android.sdk.models.HomeCardsResponse;
import io.intercom.android.sdk.models.LinkResponse;
import io.intercom.android.sdk.models.LogEventResponse;
import io.intercom.android.sdk.models.OpenMessengerResponse;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Sheet;
import io.intercom.android.sdk.models.UpdateUserResponse;
import io.intercom.android.sdk.models.Upload;
import io.intercom.android.sdk.models.UsersResponse;
import io.intercom.android.sdk.models.carousel.CarouselResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\b\b\u0003\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00132\b\b\u0003\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00132\b\b\u0003\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u001e\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010 \u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u00102\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u00103\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u001e\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u00104\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u00106\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u00107\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u00108\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u00109\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010=\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'\u0002\u0004\n\u0002\b\u0019¨\u0006C"}, d2 = {"Lio/intercom/android/sdk/api/MessengerApi;", "", "addConversationQuickReply", "Lretrofit2/Call;", "Lio/intercom/android/sdk/models/Part$Builder;", "conversationId", "", "options", "Lokhttp3/RequestBody;", "addConversationRatingRemark", "Ljava/lang/Void;", "deleteDeviceToken", "getCarousel", "Lio/intercom/android/sdk/models/carousel/CarouselResponse$Builder;", "getConversation", "Lio/intercom/android/sdk/models/Conversation$Builder;", "getConversations", "Lio/intercom/android/sdk/models/ConversationsResponse$Builder;", "getConversationsSuspend", "Lio/intercom/android/sdk/helpcenter/utils/networking/NetworkResponse;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGifs", "Lio/intercom/android/sdk/models/GifResponse;", "getHomeCards", "Lio/intercom/android/sdk/models/HomeCardsResponse$Builder;", "getHomeCardsSuspend", "getHomeCardsV2Suspend", "Lio/intercom/android/sdk/m5/home/data/HomeV2Response;", "getLink", "Lio/intercom/android/sdk/models/LinkResponse$Builder;", "articleId", "getProgrammaticCarousel", "carouselId", "getSheet", "Lio/intercom/android/sdk/models/Sheet$Builder;", "getUnreadConversations", "Lio/intercom/android/sdk/models/UsersResponse$Builder;", "logEvent", "Lio/intercom/android/sdk/models/LogEventResponse$Builder;", "markAsDismissed", "markAsRead", "markCarouselActionButtonTapped", "markCarouselAsCompleted", "markCarouselAsDismissed", "markCarouselScreenViewed", "markPermissionGranted", "markPushAsOpened", "openMessenger", "Lio/intercom/android/sdk/models/OpenMessengerResponse;", "rateConversation", "reactToConversation", "reactToLink", "recordInteractions", "replyToConversation", "reportError", "satisfyCondition", "sendMetrics", "setDeviceToken", "startNewConversation", "Lio/intercom/android/sdk/models/ConversationResponse$Builder;", "submitForm", "submitSheet", "triggerInboundConversation", "updateUser", "Lio/intercom/android/sdk/models/UpdateUserResponse$Builder;", "uploadFile", "Lio/intercom/android/sdk/models/Upload$Builder;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MessengerApi.kt */
public interface MessengerApi {
    @POST("conversations/{conversationId}/quick_reply")
    Call<Part.Builder> addConversationQuickReply(@Path("conversationId") String str, @Body RequestBody requestBody);

    @POST("conversations/{conversationId}/remark")
    Call<Void> addConversationRatingRemark(@Path("conversationId") String str, @Body RequestBody requestBody);

    @PUT("device_tokens")
    Call<Void> deleteDeviceToken(@Body RequestBody requestBody);

    @POST("content/fetch_carousel")
    Call<CarouselResponse.Builder> getCarousel(@Body RequestBody requestBody);

    @POST("conversations/{conversationId}")
    Call<Conversation.Builder> getConversation(@Path("conversationId") String str, @Body RequestBody requestBody);

    @POST("conversations/inbox")
    Call<ConversationsResponse.Builder> getConversations(@Body RequestBody requestBody);

    @POST("conversations/inbox")
    Object getConversationsSuspend(@Body RequestBody requestBody, Continuation<? super NetworkResponse<ConversationsResponse.Builder>> continuation);

    @POST("gifs")
    Call<GifResponse> getGifs(@Body RequestBody requestBody);

    @POST("home_cards")
    Call<HomeCardsResponse.Builder> getHomeCards(@Body RequestBody requestBody);

    @POST("home_cards")
    Object getHomeCardsSuspend(@Body RequestBody requestBody, Continuation<? super NetworkResponse<? extends HomeCardsResponse.Builder>> continuation);

    @POST("home")
    Object getHomeCardsV2Suspend(@Body RequestBody requestBody, Continuation<? super NetworkResponse<HomeV2Response>> continuation);

    @POST("articles/{articleId}")
    Call<LinkResponse.Builder> getLink(@Path("articleId") String str, @Body RequestBody requestBody);

    @POST("carousels/{carouselId}/fetch")
    Call<CarouselResponse.Builder> getProgrammaticCarousel(@Path("carouselId") String str, @Body RequestBody requestBody);

    @POST("sheets/open")
    Call<Sheet.Builder> getSheet(@Body RequestBody requestBody);

    @POST("conversations/unread")
    Call<UsersResponse.Builder> getUnreadConversations(@Body RequestBody requestBody);

    @POST("events")
    Call<LogEventResponse.Builder> logEvent(@Body RequestBody requestBody);

    @POST("conversations/dismiss")
    Call<Void> markAsDismissed(@Body RequestBody requestBody);

    @POST("conversations/{conversationId}/read")
    Call<Void> markAsRead(@Path("conversationId") String str, @Body RequestBody requestBody);

    @POST("stats_system/carousel_button_action_tapped")
    Call<Void> markCarouselActionButtonTapped(@Body RequestBody requestBody);

    @POST("stats_system/carousel_completed")
    Call<Void> markCarouselAsCompleted(@Body RequestBody requestBody);

    @POST("stats_system/carousel_dismissed")
    Call<Void> markCarouselAsDismissed(@Body RequestBody requestBody);

    @POST("stats_system/carousel_screen_viewed")
    Call<Void> markCarouselScreenViewed(@Body RequestBody requestBody);

    @POST("stats_system/carousel_permission_granted")
    Call<Void> markPermissionGranted(@Body RequestBody requestBody);

    @POST("stats_system/push_opened")
    Call<Void> markPushAsOpened(@Body RequestBody requestBody);

    @POST("open")
    Call<OpenMessengerResponse> openMessenger(@Body RequestBody requestBody);

    @POST("conversations/{conversationId}/rate")
    Call<Void> rateConversation(@Path("conversationId") String str, @Body RequestBody requestBody);

    @POST("conversations/{conversationId}/react")
    Call<Void> reactToConversation(@Path("conversationId") String str, @Body RequestBody requestBody);

    @POST("articles/{articleId}/react")
    Call<Void> reactToLink(@Path("articleId") String str, @Body RequestBody requestBody);

    @POST("conversations/{conversationId}/record_interactions")
    Call<Void> recordInteractions(@Path("conversationId") String str, @Body RequestBody requestBody);

    @POST("conversations/{conversationId}/reply")
    Call<Part.Builder> replyToConversation(@Path("conversationId") String str, @Body RequestBody requestBody);

    @POST("error_reports")
    Call<Void> reportError(@Body RequestBody requestBody);

    @POST("conversations/{conversationId}/conditions_satisfied")
    Call<Void> satisfyCondition(@Path("conversationId") String str, @Body RequestBody requestBody);

    @POST("metrics")
    Call<Void> sendMetrics(@Body RequestBody requestBody);

    @POST("device_tokens")
    Call<Void> setDeviceToken(@Body RequestBody requestBody);

    @POST("conversations")
    Call<ConversationResponse.Builder> startNewConversation(@Body RequestBody requestBody);

    @POST("conversations/{conversationId}/form")
    Call<Conversation.Builder> submitForm(@Path("conversationId") String str, @Body RequestBody requestBody);

    @POST("sheets/submit")
    Call<Void> submitSheet(@Body RequestBody requestBody);

    @POST("custom_bots/trigger_inbound_conversation")
    Call<Conversation.Builder> triggerInboundConversation(@Body RequestBody requestBody);

    @POST("users")
    Call<UpdateUserResponse.Builder> updateUser(@Body RequestBody requestBody);

    @POST("uploads")
    Call<Upload.Builder> uploadFile(@Body RequestBody requestBody);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MessengerApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getConversationsSuspend$default(MessengerApi messengerApi, RequestBody requestBody, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    requestBody = MessengerApiHelper.getDefaultRequestBody$intercom_sdk_base_release$default(MessengerApiHelper.INSTANCE, (Map) null, 1, (Object) null);
                }
                return messengerApi.getConversationsSuspend(requestBody, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConversationsSuspend");
        }

        public static /* synthetic */ Object getHomeCardsSuspend$default(MessengerApi messengerApi, RequestBody requestBody, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    requestBody = MessengerApiHelper.getDefaultRequestBody$intercom_sdk_base_release$default(MessengerApiHelper.INSTANCE, (Map) null, 1, (Object) null);
                }
                return messengerApi.getHomeCardsSuspend(requestBody, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHomeCardsSuspend");
        }

        public static /* synthetic */ Object getHomeCardsV2Suspend$default(MessengerApi messengerApi, RequestBody requestBody, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    requestBody = MessengerApiHelper.getDefaultRequestBody$intercom_sdk_base_release$default(MessengerApiHelper.INSTANCE, (Map) null, 1, (Object) null);
                }
                return messengerApi.getHomeCardsV2Suspend(requestBody, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHomeCardsV2Suspend");
        }
    }
}
