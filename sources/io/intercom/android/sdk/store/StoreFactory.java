package io.intercom.android.sdk.store;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.intercom.twig.Twig;
import com.squareup.otto.Bus;
import io.intercom.android.nexus.NexusClient;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.api.UserUpdater;
import io.intercom.android.sdk.conversation.SoundPlayer;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.middleware.ApiMiddleware;
import io.intercom.android.sdk.middleware.AppConfigMiddleware;
import io.intercom.android.sdk.middleware.AudioMiddleware;
import io.intercom.android.sdk.middleware.FirstMessageMiddleware;
import io.intercom.android.sdk.middleware.LoggerMiddleware;
import io.intercom.android.sdk.middleware.MetricTrackerMiddleware;
import io.intercom.android.sdk.middleware.NexusClientMiddleware;
import io.intercom.android.sdk.middleware.OperatorClientConditionsMiddleware;
import io.intercom.android.sdk.middleware.OverlayPresenterMiddleware;
import io.intercom.android.sdk.middleware.UserIdentityMiddleware;
import io.intercom.android.sdk.middleware.UserUpdaterMiddleware;
import io.intercom.android.sdk.overlay.OverlayPresenter;
import io.intercom.android.sdk.state.State;

public class StoreFactory {
    static final State INITIAL_STATE = State.create(false, LastViewReducer.INITIAL_STATE, TeamPresenceReducer.INITIAL_STATE, UnreadConversationsReducer.INITIAL_STATE, InboxStateReducer.INITIAL_STATE, HostAppStateReducer.INITIAL_STATE, OverlayStateReducer.INITIAL_STATE, ActiveConversationStateReducer.INITIAL_STATE, ComposerSuggestionsReducer.INITIAL_STATE, MessengerStateReducer.INITIAL_STATE, ProgrammaticCarouselStateReducer.INITIAL_STATE, BotIntroReducer.Companion.getInitialState(), SurveyDataReducer.Companion.getInitialState(), TicketStateReducer.Companion.getInitialState());

    public static Store<State> createStore(Provider<Api> provider, Provider<AppConfig> provider2, Provider<NexusClient> provider3, Provider<OverlayPresenter> provider4, Provider<UserUpdater> provider5, SoundPlayer soundPlayer, Provider<UserIdentity> provider6, Context context, Twig twig, Bus bus, Provider<MetricTracker> provider7) {
        Provider<Api> provider8 = provider;
        Provider<AppConfig> provider9 = provider2;
        Provider<UserIdentity> provider10 = provider6;
        Twig twig2 = twig;
        StateReducer stateReducer = r5;
        StateReducer stateReducer2 = new StateReducer(new HasConversationsReducer(), new LastViewReducer(), new TeamPresenceReducer(), new UnreadConversationsReducer(), new InboxStateReducer(), new HostAppStateReducer(), new OverlayStateReducer(), new ActiveConversationStateReducer(), new ComposerSuggestionsReducer(), new MessengerStateReducer(), new ProgrammaticCarouselStateReducer(), new BotIntroReducer(), new SurveyDataReducer(), new TicketStateReducer());
        return new Store<>(stateReducer, INITIAL_STATE, new LoggerMiddleware(twig2), new ApiMiddleware(provider8), new UserUpdaterMiddleware(provider5, provider9, provider10), new NexusClientMiddleware(provider3, provider9, new Handler(Looper.getMainLooper())), new OverlayPresenterMiddleware(provider4), new AudioMiddleware(soundPlayer, provider10), new FirstMessageMiddleware(twig2, context), new UserIdentityMiddleware(provider10), new AppConfigMiddleware(provider9, bus), new MetricTrackerMiddleware(provider7), new OperatorClientConditionsMiddleware(provider8, new Handler(Looper.getMainLooper())));
    }
}
