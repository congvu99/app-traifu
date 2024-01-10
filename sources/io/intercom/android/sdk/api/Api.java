package io.intercom.android.sdk.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import com.brentvatne.react.ReactVideoView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.github.scribejava.core.model.OAuthConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.intercom.input.gallery.GalleryImage;
import com.intercom.twig.Twig;
import com.squareup.otto.Bus;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.IntercomError;
import io.intercom.android.sdk.IntercomStatusCallback;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.blocks.UploadingImageCache;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.conversation.UploadProgressListener;
import io.intercom.android.sdk.errorreporting.ErrorReport;
import io.intercom.android.sdk.helpcenter.articles.ArticleStatsArguments;
import io.intercom.android.sdk.helpcenter.utils.ConstantsKt;
import io.intercom.android.sdk.homescreen.ConversationListExtensionsKt;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.AppIdentity;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricObject;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.ops.OpsMetricObject;
import io.intercom.android.sdk.metrics.ops.OpsMetricTracker;
import io.intercom.android.sdk.models.ComposerSuggestions;
import io.intercom.android.sdk.models.GifResponse;
import io.intercom.android.sdk.models.LinkResponse;
import io.intercom.android.sdk.models.OpenMessengerResponse;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Sheet;
import io.intercom.android.sdk.models.Suggestion;
import io.intercom.android.sdk.models.UpdateUserResponse;
import io.intercom.android.sdk.models.Upload;
import io.intercom.android.sdk.models.carousel.Carousel;
import io.intercom.android.sdk.models.carousel.CarouselResponse;
import io.intercom.android.sdk.models.events.UploadEvent;
import io.intercom.android.sdk.models.events.failure.UploadFailedEvent;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.user.DeviceData;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.ws.WebSocketProtocol;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Api {
    private static final String CAROUSEL_AUTOMATIC = "shown_automatically";
    private static final String CAROUSEL_CREATED_VIA = "created_via";
    private static final String CAROUSEL_PROGRAMMATIC = "triggered_from_code";
    private static final String CAROUSEL_VISIBLE = "carousel_visible";
    private static final String DATA = "data";
    private static final String DEVICE_DATA = "device_data";
    private static final String DEVICE_TOKEN = "device_token";
    private static final String HMAC = "hmac";
    private static final String INSTANCE_ID = "instance_id";
    private static final String NEW_SESSION = "new_session";
    private static final String SCREEN_ID = "screen_id";
    private static final String SENT_FROM_BACKGROUND = "sent_from_background";
    /* access modifiers changed from: private */
    public static final Twig TWIG = LumberMill.getLogger();
    private static final String UPLOAD = "upload";
    private static final String USER = "user";
    private static final String USER_ATTRIBUTES = "user_attributes";
    private final OkHttpClient apiHttpClient;
    private final Provider<AppConfig> appConfigProvider;
    private final AppIdentity appIdentity;
    final Bus bus;
    final CallbackHolder callbacks;
    private final Context context;
    private final int defaultOkHttpMaxRequests;
    private final Callback<Void> emptyCallback = new Callback<Void>() {
        public void onFailure(Call<Void> call, Throwable th) {
        }

        public void onResponse(Call<Void> call, Response<Void> response) {
        }
    };
    private Gson gson;
    final OkHttpClient httpClient = new OkHttpClient();
    private final MessengerApi messengerApi;
    /* access modifiers changed from: private */
    public OpsMetricTracker opsMetricTracker;
    private final RateLimiter rateLimiter;
    /* access modifiers changed from: private */
    public final Store<State> store;
    final UserIdentity userIdentity;

    public Api(Context context2, AppIdentity appIdentity2, UserIdentity userIdentity2, Bus bus2, OkHttpClient okHttpClient, MessengerApi messengerApi2, CallbackHolder callbackHolder, RateLimiter rateLimiter2, Store<State> store2, Provider<AppConfig> provider, Gson gson2, OpsMetricTracker opsMetricTracker2) {
        this.context = context2;
        this.appIdentity = appIdentity2;
        this.userIdentity = userIdentity2;
        this.bus = bus2;
        this.messengerApi = messengerApi2;
        this.callbacks = callbackHolder;
        this.rateLimiter = rateLimiter2;
        this.store = store2;
        this.appConfigProvider = provider;
        this.gson = gson2;
        this.opsMetricTracker = opsMetricTracker2;
        this.apiHttpClient = okHttpClient;
        this.defaultOkHttpMaxRequests = okHttpClient.dispatcher().getMaxRequests();
        updateMaxRequests();
    }

    public void updateMaxRequests() {
        int i = this.userIdentity.hasIntercomId() ? this.defaultOkHttpMaxRequests : 1;
        Dispatcher dispatcher = this.apiHttpClient.dispatcher();
        if (dispatcher.getMaxRequests() != i) {
            dispatcher.setMaxRequests(i);
        }
    }

    public void setDeviceToken(String str) {
        Map<String, Object> generateDeviceData = DeviceData.generateDeviceData(this.context);
        generateDeviceData.put(DEVICE_TOKEN, str);
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        hashMap.put(DEVICE_DATA, generateDeviceData);
        addSecureHash(hashMap);
        this.messengerApi.setDeviceToken(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.emptyCallback);
    }

    public void removeDeviceToken(String str, UserIdentity userIdentity2) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", userIdentity2.toMap());
        hashMap.put(DEVICE_TOKEN, str);
        addSecureHash(hashMap);
        this.messengerApi.deleteDeviceToken(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.emptyCallback);
    }

    public void updateUser(UserUpdateRequest userUpdateRequest, IntercomStatusCallback intercomStatusCallback) {
        if (!userUpdateRequest.isInternalUpdate()) {
            if (this.rateLimiter.isLimited()) {
                this.rateLimiter.logError();
                intercomStatusCallback.onFailure(new IntercomError(WebSocketProtocol.CLOSE_NO_STATUS_CODE, "rate limit reached"));
                return;
            } else if (shouldStopBackgroundRequest(userUpdateRequest.isSentFromBackground())) {
                logBackgroundDisabledError();
                intercomStatusCallback.onFailure(new IntercomError(PointerIconCompat.TYPE_CELL, "Background requests are disabled"));
                return;
            } else {
                this.rateLimiter.recordRequest();
            }
        }
        retriableUpdateUser(generateUpdateUserParams(userUpdateRequest), intercomStatusCallback);
    }

    /* access modifiers changed from: package-private */
    public void retriableUpdateUser(Map<String, Object> map, IntercomStatusCallback intercomStatusCallback) {
        retriableUpdateUser(map, this.userIdentity.getFingerprint(), intercomStatusCallback);
    }

    /* access modifiers changed from: private */
    public void retriableUpdateUser(final Map<String, Object> map, final String str, final IntercomStatusCallback intercomStatusCallback) {
        this.messengerApi.updateUser(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(map)).enqueue(new BaseCallback<UpdateUserResponse.Builder>() {
            public void onSuccess(UpdateUserResponse.Builder builder) {
                Handler handler = new Handler(Looper.getMainLooper());
                IntercomStatusCallback intercomStatusCallback = intercomStatusCallback;
                Objects.requireNonNull(intercomStatusCallback);
                handler.post(new Runnable() {
                    public final void run() {
                        IntercomStatusCallback.this.onSuccess();
                    }
                });
                if (str.equals(Api.this.userIdentity.getFingerprint())) {
                    Api.TWIG.i("Successfully registered or updated user", new Object[0]);
                    Api.this.callbacks.unreadCallback().onSuccess(builder);
                    UpdateUserResponse build = builder.build();
                    Api.this.store.dispatch(Actions.teamPresenceUpdated(build.getTeamPresence()));
                    Api.this.store.dispatch(Actions.composerSuggestionsUpdated(build.getComposerSuggestions()));
                    Api.this.store.dispatch(Actions.carouselUpdated(build.getCarousel()));
                    Api.this.store.dispatch(Actions.botIntroUpdated(build.getBotIntro()));
                    Api.this.store.dispatch(Actions.surveyUpdated(build.getSurveyData()));
                    Api.this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.TIME_TO_COMPLETE_PING);
                }
            }

            public void onError(ErrorObject errorObject) {
                Map map = (Map) map.get("user");
                if (Api.isUserNotFound(errorObject, map)) {
                    map.remove(UserIdentity.INTERCOM_ID);
                    map.put("user", map);
                    Api.this.retriableUpdateUser(map, str, intercomStatusCallback);
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable(errorObject, ErrorStringExtractorKt.extractErrorString(errorObject)) {
                    public final /* synthetic */ ErrorObject f$1;
                    public final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        IntercomStatusCallback.this.onFailure(new IntercomError(1001, "ERROR - [HTTP " + this.f$1.getStatusCode() + "] - " + this.f$2));
                    }
                });
            }

            /* access modifiers changed from: package-private */
            public void logFailure(String str, ErrorObject errorObject) {
                super.logFailure("Failed to register or update user", errorObject);
            }
        });
    }

    public void logEvent(String str, Map<String, ?> map) {
        if (this.rateLimiter.isLimited()) {
            this.rateLimiter.logError();
            return;
        }
        boolean booleanValue = ((Boolean) this.store.select(Selectors.APP_IS_BACKGROUNDED)).booleanValue();
        if (shouldStopBackgroundRequest(booleanValue)) {
            logBackgroundDisabledError();
            return;
        }
        this.rateLimiter.recordRequest();
        HashMap hashMap = new HashMap();
        hashMap.put("event_name", str);
        if (!map.isEmpty()) {
            hashMap.put(ReactVideoView.EVENT_PROP_METADATA, map);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(NotificationCompat.CATEGORY_EVENT, hashMap);
        hashMap2.put(SENT_FROM_BACKGROUND, Boolean.valueOf(booleanValue));
        hashMap2.put("user", this.userIdentity.toMap());
        hashMap2.put(CAROUSEL_VISIBLE, Boolean.valueOf(isCarouselVisible()));
        addSecureHash(hashMap2);
        this.messengerApi.logEvent(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap2)).enqueue(this.callbacks.logEventCallback());
    }

    public void markConversationAsRead(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.appIdentity.appId());
        hashMap.put("user", this.userIdentity.toMap());
        addSecureHash(hashMap);
        this.messengerApi.markAsRead(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.emptyCallback);
    }

    public void markConversationAsDismissed(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        hashMap.put("conversation_ids", new String[]{str});
        addSecureHash(hashMap);
        this.messengerApi.markAsDismissed(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.emptyCallback);
    }

    public void recordInteractions(String str, String[] strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        hashMap.put("interactions", strArr);
        addSecureHash(hashMap);
        this.messengerApi.recordInteractions(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.emptyCallback);
    }

    public void getInbox() {
        Map<String, Object> map = this.userIdentity.toMap();
        map.put("per_page", "20");
        addSecureHash(map);
        this.messengerApi.getConversations(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(map)).enqueue(this.callbacks.inboxCallback());
    }

    public void getInboxBefore(long j) {
        Map<String, Object> map = this.userIdentity.toMap();
        map.put("before", String.valueOf(j));
        map.put("per_page", "20");
        addSecureHash(map);
        this.messengerApi.getConversations(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(map)).enqueue(this.callbacks.inboxCallback());
    }

    public void getUnreadConversations() {
        Map<String, Object> map = this.userIdentity.toMap();
        map.put("per_page", "20");
        addSecureHash(map);
        this.messengerApi.getUnreadConversations(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(map)).enqueue(this.callbacks.unreadCallback());
    }

    public void getConversation(String str, String str2) {
        Map<String, Object> map = this.userIdentity.toMap();
        addSecureHash(map);
        this.messengerApi.getConversation(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(map)).enqueue(this.callbacks.conversationCallback(str2));
    }

    public void openMessenger() {
        Map<String, Object> map = this.userIdentity.toMap();
        addSecureHash(map);
        this.messengerApi.openMessenger(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(map)).enqueue(new BaseCallback<OpenMessengerResponse>() {
            /* access modifiers changed from: protected */
            public void onSuccess(OpenMessengerResponse openMessengerResponse) {
                Api.this.store.dispatch(Actions.composerSuggestionsUpdated(openMessengerResponse.getComposerSuggestions().build()));
            }

            /* access modifiers changed from: protected */
            public void onError(ErrorObject errorObject) {
                super.onError(errorObject);
                ComposerSuggestions composerSuggestions = ((State) Api.this.store.state()).composerSuggestions();
                Api.this.store.dispatch(Actions.composerSuggestionsUpdated(ComposerSuggestions.create(composerSuggestions.getPrompt(), composerSuggestions.getSuggestions(), composerSuggestions.isComposerDisabled(), false)));
            }
        });
    }

    public void rateConversation(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        hashMap.put("rating_index", Integer.valueOf(i));
        addSecureHash(hashMap);
        this.messengerApi.rateConversation(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.callbacks.loggingCallback("conversation rating"));
    }

    public void addConversationRatingRemark(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        hashMap.put("remark", str2);
        addSecureHash(hashMap);
        this.messengerApi.addConversationRatingRemark(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.callbacks.loggingCallback("adding remark to conversation"));
    }

    public void addConversationQuickReply(String str, Part part, String str2, int i, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        String id = part.getId();
        if (!part.isInitialMessage()) {
            hashMap.put("quick_reply_part_id", id);
        }
        hashMap.put("reply_option_uuid", str2);
        addSecureHash(hashMap);
        this.messengerApi.addConversationQuickReply(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.callbacks.replyCallback(i, false, str3, str));
    }

    public void triggerInboundCustomBot(Part part, String str, int i, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        hashMap.put("id", str);
        hashMap.put("client_assigned_uuid", str2);
        addSecureHash(hashMap);
        this.messengerApi.triggerInboundConversation(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.callbacks.triggeredInboundBotCallback(i, part.getId()));
    }

    public void fetchDefaultGifs(Callback<GifResponse> callback) {
        this.messengerApi.getGifs(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(Collections.emptyMap())).enqueue(callback);
    }

    public void fetchGifs(String str, Callback<GifResponse> callback) {
        this.messengerApi.getGifs(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(Collections.singletonMap(SearchIntents.EXTRA_QUERY, str))).enqueue(callback);
    }

    public void satisfyOperatorCondition(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        hashMap.put("transition_id", str2);
        addSecureHash(hashMap);
        this.messengerApi.satisfyCondition(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.emptyCallback);
    }

    public void replyToConversation(String str, List<Block.Builder> list, int i, String str2, boolean z) {
        Map<String, Object> createBaseReplyParams = createBaseReplyParams();
        createBaseReplyParams.put("blocks", list);
        this.messengerApi.replyToConversation(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(createBaseReplyParams)).enqueue(this.callbacks.replyCallback(i, z, str2, str));
    }

    private Map<String, Object> createBaseReplyParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.appIdentity.appId());
        hashMap.put("type", "user");
        hashMap.put(Constants.MessagePayloadKeys.MESSAGE_TYPE, "comment");
        hashMap.put("user", this.userIdentity.toMap());
        addSecureHash(hashMap);
        return hashMap;
    }

    public void reactToConversation(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        hashMap.put("reaction_index", Integer.valueOf(i));
        addSecureHash(hashMap);
        this.messengerApi.reactToConversation(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.callbacks.loggingCallback("add reaction to conversation"));
    }

    public void submitForm(String str, String str2, String str3, Object obj, String str4) {
        Map<String, Object> map = this.userIdentity.toMap();
        addSecureHash(map);
        HashMap hashMap = new HashMap();
        hashMap.put("conversation_part_id", str2);
        hashMap.put(ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER, str3);
        hashMap.put("value", obj);
        hashMap.put("type", str4);
        map.put("form_params", hashMap);
        this.messengerApi.submitForm(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(map)).enqueue(this.callbacks.submitFormCallback(str2, str3));
    }

    public void startNewConversation(List<Block.Builder> list, int i, String str, List<Suggestion> list2, String str2, ArticleStatsArguments articleStatsArguments) {
        Map<String, Object> baseNewConversationParams = baseNewConversationParams();
        baseNewConversationParams.put("blocks", list);
        baseNewConversationParams.put(MetricTracker.Object.COMPOSER_SUGGESTIONS, this.gson.toJson((Object) list2));
        boolean hasRecentInboundConversation = ConversationListExtensionsKt.hasRecentInboundConversation(this.store.state().inboxState().conversations(), Injector.get().getTimeProvider().currentTimeMillis());
        boolean isPreventMultipleInboundConversationsEnabled = this.appConfigProvider.get().isPreventMultipleInboundConversationsEnabled();
        baseNewConversationParams.put("hasRecentInboundConversation", Boolean.valueOf(hasRecentInboundConversation));
        baseNewConversationParams.put("hasOpenInboundAndMustPreventMultipleInbound", Boolean.valueOf(isPreventMultipleInboundConversationsEnabled));
        if (str2 != null) {
            baseNewConversationParams.put("bot_intro", str2);
        }
        if (!articleStatsArguments.getArticleId().isEmpty()) {
            baseNewConversationParams.put("article_id", articleStatsArguments.getArticleId());
        }
        if (articleStatsArguments.isFromSearchBrowse()) {
            baseNewConversationParams.put(ConstantsKt.KEY_ARTICLE_SOURCE, "search_browse");
        }
        this.messengerApi.startNewConversation(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(baseNewConversationParams)).enqueue(this.callbacks.newConversationCallback(i, str));
    }

    private Map<String, Object> baseNewConversationParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.appIdentity.appId());
        hashMap.put("user", this.userIdentity.toMap());
        addSecureHash(hashMap);
        return hashMap;
    }

    public void uploadFile(GalleryImage galleryImage, int i, String str, UploadingImageCache uploadingImageCache, UploadProgressListener uploadProgressListener, Context context2) {
        final String fileName = galleryImage.getFileName();
        final String mimeType = galleryImage.getMimeType();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("original_filename", fileName);
        hashMap2.put("size_in_bytes", Integer.valueOf(galleryImage.getFileSize()));
        hashMap2.put(FirebaseAnalytics.Param.CONTENT_TYPE, mimeType);
        hashMap2.put("width", Integer.valueOf(galleryImage.getImageWidth()));
        hashMap2.put("height", Integer.valueOf(galleryImage.getImageHeight()));
        hashMap.put(UPLOAD, hashMap2);
        hashMap.put("user", this.userIdentity.toMap());
        addSecureHash(hashMap);
        final UploadingImageCache uploadingImageCache2 = uploadingImageCache;
        final GalleryImage galleryImage2 = galleryImage;
        final Context context3 = context2;
        final UploadProgressListener uploadProgressListener2 = uploadProgressListener;
        final int i2 = i;
        final String str2 = str;
        this.messengerApi.uploadFile(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(new BaseCallback<Upload.Builder>() {
            public void onSuccess(Upload.Builder builder) {
                final Upload build = builder.build();
                uploadingImageCache2.put(build.getPublicUrl(), galleryImage2);
                Api.this.httpClient.newCall(new Request.Builder().url(build.getUploadDestination()).post(new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart(SDKConstants.PARAM_KEY, build.getKey()).addFormDataPart("acl", build.getAcl()).addFormDataPart("Content-Type", build.getContentType()).addFormDataPart("AWSAccessKeyId", build.getAwsAccessKey()).addFormDataPart("policy", build.getPolicy()).addFormDataPart("signature", build.getSignature()).addFormDataPart("success_action_status", build.getSuccessActionStatus()).addFormDataPart("file", fileName, new ProgressRequestBody(MediaType.parse(mimeType), galleryImage2, context3.getContentResolver(), uploadProgressListener2)).build()).build()).enqueue(new okhttp3.Callback() {
                    public void onFailure(okhttp3.Call call, IOException iOException) {
                        Twig access$000 = Api.TWIG;
                        access$000.e("Upload failed: " + iOException.getMessage(), new Object[0]);
                        Api.this.bus.post(new UploadFailedEvent(i2, str2));
                    }

                    public void onResponse(okhttp3.Call call, okhttp3.Response response) {
                        Api.TWIG.internal("API Success", "Successfully uploaded");
                        if (response.isSuccessful()) {
                            Api.this.bus.post(new UploadEvent(build, (long) galleryImage2.getFileSize(), i2, str2));
                        } else {
                            Twig access$000 = Api.TWIG;
                            access$000.e("Upload failed: request body " + response.body(), new Object[0]);
                            Api.this.bus.post(new UploadFailedEvent(i2, str2));
                        }
                        response.body().close();
                    }
                });
                Api.TWIG.internal("API Success", "Successfully uploaded");
            }

            public void onError(ErrorObject errorObject) {
                Api.this.bus.post(new UploadFailedEvent(i2, str2));
            }

            /* access modifiers changed from: package-private */
            public void logFailure(String str, ErrorObject errorObject) {
                super.logFailure("Upload failed", errorObject);
            }
        });
    }

    public void getLink(String str, Callback<LinkResponse.Builder> callback) {
        Map<String, Object> map = this.userIdentity.toMap();
        addSecureHash(map);
        this.messengerApi.getLink(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(map)).enqueue(callback);
    }

    public void reactToLink(String str, String str2, int i, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        hashMap.put("article_content_id", str2);
        hashMap.put("reaction_index", Integer.valueOf(i));
        hashMap.put("allow_auto_responses", Boolean.valueOf(z));
        addSecureHash(hashMap);
        this.messengerApi.reactToLink(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.callbacks.loggingCallback("add reaction to link"));
    }

    public void sendMetrics(List<MetricObject> list, List<OpsMetricObject> list2, Callback<Void> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("metrics", list);
        hashMap.put("op_metrics", list2);
        this.messengerApi.sendMetrics(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(callback);
    }

    public void sendErrorReport(ErrorReport errorReport) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        hashMap.put("error_report", errorReport);
        addSecureHash(hashMap);
        this.messengerApi.reportError(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(this.callbacks.loggingCallback("report error"));
    }

    public void getVideo(String str, okhttp3.Callback callback) {
        this.httpClient.newCall(new Request.Builder().url(str).build()).enqueue(callback);
    }

    public void hitTrackingUrl(String str) {
        this.httpClient.newCall(new Request.Builder().url(str).build()).enqueue(new okhttp3.Callback() {
            public void onFailure(okhttp3.Call call, IOException iOException) {
                Api.TWIG.internal("Tracking Url", "Failed tracking url request");
            }

            public void onResponse(okhttp3.Call call, okhttp3.Response response) {
                Api.TWIG.internal("Tracking Url", "success");
                response.body().close();
            }
        });
    }

    public void fetchSheet(HashMap<String, Object> hashMap, Callback<Sheet.Builder> callback) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("user", this.userIdentity.toMap());
        addSecureHash(hashMap2);
        hashMap2.putAll(hashMap);
        this.messengerApi.getSheet(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap2)).enqueue(callback);
    }

    public void submitSheet(String str, Map<String, Object> map, Callback<Void> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        addSecureHash(hashMap);
        hashMap.put("uri", str);
        hashMap.put("sheet_values", map);
        this.messengerApi.submitSheet(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(hashMap)).enqueue(callback);
    }

    public void markPushAsOpened(String str) {
        this.messengerApi.markPushAsOpened(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(statsSystemParams(str))).enqueue(this.emptyCallback);
    }

    public void markCarouselAsDismissed(String str, boolean z) {
        Map<String, Object> statsSystemParams = statsSystemParams(str);
        addCarouselCreatedViaParam(statsSystemParams, z);
        this.messengerApi.markCarouselAsDismissed(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(statsSystemParams)).enqueue(this.emptyCallback);
    }

    public void markCarouselAsCompleted(String str, boolean z) {
        Map<String, Object> statsSystemParams = statsSystemParams(str);
        addCarouselCreatedViaParam(statsSystemParams, z);
        this.messengerApi.markCarouselAsCompleted(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(statsSystemParams)).enqueue(this.emptyCallback);
    }

    public void markCarouselScreenViewed(String str, String str2, boolean z) {
        Map<String, Object> statsSystemParams = statsSystemParams(str, str2);
        addCarouselCreatedViaParam(statsSystemParams, z);
        this.messengerApi.markCarouselScreenViewed(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(statsSystemParams)).enqueue(this.emptyCallback);
    }

    public void markPermissionGranted(String str, String str2, boolean z) {
        Map<String, Object> statsSystemParams = statsSystemParams(str, str2);
        addCarouselCreatedViaParam(statsSystemParams, z);
        this.messengerApi.markPermissionGranted(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(statsSystemParams)).enqueue(this.emptyCallback);
    }

    public void markCarouselActionButtonTapped(String str, String str2, boolean z) {
        Map<String, Object> statsSystemParams = statsSystemParams(str, str2);
        addCarouselCreatedViaParam(statsSystemParams, z);
        this.messengerApi.markCarouselActionButtonTapped(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(statsSystemParams)).enqueue(this.emptyCallback);
    }

    public void fetchProgrammaticCarousel(String str) {
        Map<String, Object> map = this.userIdentity.toMap();
        addSecureHash(map);
        this.messengerApi.getProgrammaticCarousel(str, MessengerApiHelper.INSTANCE.optionsMapToRequestBody(map)).enqueue(this.callbacks.getCarouselCallback(str));
    }

    public void fetchCarouselByEntityId(String str) {
        Map<String, Object> map = this.userIdentity.toMap();
        map.put("entity_id", str);
        map.put("entity_type", 44);
        addSecureHash(map);
        this.messengerApi.getCarousel(MessengerApiHelper.INSTANCE.optionsMapToRequestBody(map)).enqueue(new BaseCallback<CarouselResponse.Builder>() {
            /* access modifiers changed from: protected */
            public void onSuccess(CarouselResponse.Builder builder) {
                Api.this.store.dispatch(Actions.carouselUpdated(builder.build().carousel().build()));
            }
        });
    }

    protected static boolean isUserNotFound(ErrorObject errorObject, Map map) {
        if (errorObject.hasErrorBody() && errorObject.getStatusCode() == 404 && map != null && map.get(UserIdentity.INTERCOM_ID) != null && map.size() > 1) {
            try {
                if (new JSONObject(errorObject.getErrorBody()).getJSONArray("errors").getJSONObject(0).getString(OAuthConstants.CODE).equals("not_found")) {
                    return true;
                }
            } catch (Exception unused) {
                TWIG.internal("Could not parse error response");
            }
        }
        return false;
    }

    public void addSecureHash(Map<String, Object> map) {
        String hmac = this.userIdentity.getHmac();
        if (!TextUtils.isEmpty(hmac)) {
            map.put(HMAC, hmac);
        }
    }

    private Map<String, Object> generateUpdateUserParams(UserUpdateRequest userUpdateRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("user", this.userIdentity.toMap());
        hashMap.put(DEVICE_DATA, DeviceData.generateDeviceData(this.context));
        hashMap.put(NEW_SESSION, Boolean.valueOf(userUpdateRequest.isNewSession()));
        hashMap.put(SENT_FROM_BACKGROUND, Boolean.valueOf(userUpdateRequest.isSentFromBackground()));
        hashMap.put(USER_ATTRIBUTES, userUpdateRequest.getAttributes());
        hashMap.put(CAROUSEL_VISIBLE, Boolean.valueOf(isCarouselVisible()));
        addSecureHash(hashMap);
        return hashMap;
    }

    private void addCarouselCreatedViaParam(Map<String, Object> map, boolean z) {
        map.put(CAROUSEL_CREATED_VIA, z ? CAROUSEL_PROGRAMMATIC : CAROUSEL_AUTOMATIC);
    }

    private boolean isCarouselVisible() {
        return !Carousel.NULL.equals(((OverlayState) this.store.select(Selectors.OVERLAY)).carousel());
    }

    private Map<String, Object> statsSystemParams(String str, String str2) {
        Map<String, Object> statsSystemParams = statsSystemParams(str);
        statsSystemParams.put(SCREEN_ID, str2);
        return statsSystemParams;
    }

    private Map<String, Object> statsSystemParams(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(INSTANCE_ID, str);
        hashMap.put("user", this.userIdentity.toMap());
        addSecureHash(hashMap);
        return hashMap;
    }

    private boolean shouldStopBackgroundRequest(boolean z) {
        return z && this.appConfigProvider.get().backgroundRequestsDisabled();
    }

    private void logBackgroundDisabledError() {
        TWIG.e("Your request was not sent because the app is in the background. Please contact Intercom to enable background requests.", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    public boolean isSynchronous() {
        return this.apiHttpClient.dispatcher().getMaxRequests() == 1;
    }

    public void setIdleCallback(Runnable runnable) {
        this.apiHttpClient.dispatcher().setIdleCallback(runnable);
    }

    public boolean isIdle() {
        return this.apiHttpClient.dispatcher().runningCallsCount() == 0;
    }
}
