package io.intercom.android.sdk.api;

import com.intercom.twig.Twig;
import com.squareup.otto.Bus;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.ConversationResponse;
import io.intercom.android.sdk.models.ConversationsResponse;
import io.intercom.android.sdk.models.LogEventResponse;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.UsersResponse;
import io.intercom.android.sdk.models.carousel.CarouselResponse;
import io.intercom.android.sdk.models.events.ConversationEvent;
import io.intercom.android.sdk.models.events.FormSubmitSuccessEvent;
import io.intercom.android.sdk.models.events.NewConversationEvent;
import io.intercom.android.sdk.models.events.NewTriggerConversationEvent;
import io.intercom.android.sdk.models.events.ReplyEvent;
import io.intercom.android.sdk.models.events.failure.ConversationFailedEvent;
import io.intercom.android.sdk.models.events.failure.FetchCarouselFailedEvent;
import io.intercom.android.sdk.models.events.failure.FormSubmitFailedEvent;
import io.intercom.android.sdk.models.events.failure.NewConversationFailedEvent;
import io.intercom.android.sdk.models.events.failure.ReplyFailedEvent;
import io.intercom.android.sdk.state.ReplyPart;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class CallbackHolder {
    /* access modifiers changed from: private */
    public static final Twig TWIG = LumberMill.getLogger();
    final Bus bus;
    final Store<State> store;

    CallbackHolder(Bus bus2, Store<State> store2) {
        this.bus = bus2;
        this.store = store2;
    }

    /* access modifiers changed from: package-private */
    public BaseCallback<LogEventResponse.Builder> logEventCallback() {
        return new BaseCallback<LogEventResponse.Builder>() {
            public void onSuccess(LogEventResponse.Builder builder) {
                LogEventResponse build = builder.build();
                CallbackHolder.this.store.dispatch(Actions.baseResponseReceived(build));
                CallbackHolder.this.store.dispatch(Actions.unreadConversationsSuccess(build));
                CallbackHolder.this.store.dispatch(Actions.carouselUpdated(build.getCarousel()));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public BaseCallback<UsersResponse.Builder> unreadCallback() {
        return new BaseCallback<UsersResponse.Builder>() {
            public void onSuccess(UsersResponse.Builder builder) {
                UsersResponse build = builder.build();
                CallbackHolder.this.store.dispatch(Actions.baseResponseReceived(build));
                CallbackHolder.this.store.dispatch(Actions.unreadConversationsSuccess(build));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Callback<ConversationsResponse.Builder> inboxCallback() {
        return new BaseCallback<ConversationsResponse.Builder>() {
            public void onSuccess(ConversationsResponse.Builder builder) {
                ConversationsResponse build = builder.build();
                CallbackHolder.this.store.dispatch(Actions.baseResponseReceived(build));
                CallbackHolder.this.store.dispatch(Actions.fetchInboxSuccess(build));
            }

            public void onError(ErrorObject errorObject) {
                CallbackHolder.this.store.dispatch(Actions.fetchInboxFailed());
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Callback<Part.Builder> replyCallback(int i, boolean z, String str, String str2) {
        final String str3 = str2;
        final int i2 = i;
        final String str4 = str;
        final boolean z2 = z;
        return new BaseCallback<Part.Builder>() {
            public void onSuccess(Part.Builder builder) {
                Part build = builder.build();
                CallbackHolder.this.store.dispatch(Actions.conversationReplySuccess(new ReplyPart(build, str3)));
                CallbackHolder.this.bus.post(new ReplyEvent(build, i2, str4, str3));
            }

            public void onError(ErrorObject errorObject) {
                CallbackHolder.this.bus.post(new ReplyFailedEvent(i2, z2, str4));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Callback<Conversation.Builder> conversationCallback(final String str) {
        return new BaseCallback<Conversation.Builder>() {
            public void onSuccess(Conversation.Builder builder) {
                CallbackHolder.this.conversationFetchSuccess(builder.build(), str);
            }

            public void onError(ErrorObject errorObject) {
                CallbackHolder.this.bus.post(new ConversationFailedEvent());
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Callback<ConversationResponse.Builder> newConversationCallback(final int i, final String str) {
        return new BaseCallback<ConversationResponse.Builder>() {
            public void onSuccess(ConversationResponse.Builder builder) {
                ConversationResponse build = builder.build();
                Conversation conversation = build.getConversation();
                CallbackHolder.this.store.dispatch(Actions.baseResponseReceived(build));
                CallbackHolder.this.store.dispatch(Actions.newConversationSuccess(conversation));
                CallbackHolder.this.bus.post(new NewConversationEvent(conversation, str));
            }

            /* access modifiers changed from: protected */
            public void onError(ErrorObject errorObject) {
                CallbackHolder.this.bus.post(new NewConversationFailedEvent(i, str));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Callback<Conversation.Builder> triggeredInboundBotCallback(final int i, final String str) {
        return new BaseCallback<Conversation.Builder>() {
            public void onSuccess(Conversation.Builder builder) {
                Conversation build = builder.build();
                CallbackHolder.this.store.dispatch(Actions.newConversationSuccess(build));
                CallbackHolder.this.bus.post(new NewTriggerConversationEvent(build, str));
            }

            /* access modifiers changed from: protected */
            public void onError(ErrorObject errorObject) {
                CallbackHolder.this.bus.post(new NewConversationFailedEvent(i, str));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Callback<Conversation.Builder> submitFormCallback(final String str, final String str2) {
        return new BaseCallback<Conversation.Builder>() {
            public void onSuccess(Conversation.Builder builder) {
                Conversation build = builder.build();
                CallbackHolder.this.store.dispatch(Actions.fetchConversationSuccess(build));
                CallbackHolder.this.bus.post(new FormSubmitSuccessEvent(build, str));
            }

            public void onError(ErrorObject errorObject) {
                CallbackHolder.this.bus.post(new FormSubmitFailedEvent(str, str2));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Callback<Void> loggingCallback(final String str) {
        return new Callback<Void>() {
            public void onResponse(Call<Void> call, Response<Void> response) {
                Twig access$100 = CallbackHolder.TWIG;
                access$100.internal(str + " success");
            }

            public void onFailure(Call<Void> call, Throwable th) {
                Twig access$100 = CallbackHolder.TWIG;
                access$100.internal(str + " failure");
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Callback<CarouselResponse.Builder> getCarouselCallback(final String str) {
        return new BaseCallback<CarouselResponse.Builder>() {
            /* access modifiers changed from: protected */
            public void onSuccess(CarouselResponse.Builder builder) {
                CallbackHolder.this.store.dispatch(Actions.programmaticCarouselSuccess(builder.build().carousel().build()));
            }

            /* access modifiers changed from: protected */
            public void onError(ErrorObject errorObject) {
                CallbackHolder.this.store.dispatch(Actions.programmaticCarouselError(FetchCarouselFailedEvent.create(str, errorObject)));
            }
        };
    }

    /* access modifiers changed from: private */
    public void conversationFetchSuccess(Conversation conversation, String str) {
        Part part = conversation.getParts().isEmpty() ? Part.NULL : conversation.getParts().get(0);
        if (Part.NULL.equals(part) || part.getUuid().isEmpty() || !part.getUuid().equals(str)) {
            this.store.dispatch(Actions.fetchConversationSuccess(conversation));
            this.bus.post(new ConversationEvent.Builder(conversation).build());
            return;
        }
        this.store.dispatch(Actions.newConversationSuccess(conversation));
        this.bus.post(new NewTriggerConversationEvent(conversation, part.getId()));
    }
}
