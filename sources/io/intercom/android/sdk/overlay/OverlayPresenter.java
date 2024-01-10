package io.intercom.android.sdk.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.intercom.twig.Twig;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.activities.IntercomCarouselActivity;
import io.intercom.android.sdk.activities.IntercomConversationActivity;
import io.intercom.android.sdk.activities.IntercomNoteActivity;
import io.intercom.android.sdk.activities.IntercomPostActivity;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.m5.IntercomRootActivityLauncher;
import io.intercom.android.sdk.m5.IntercomScreenScenario;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.carousel.Carousel;
import io.intercom.android.sdk.models.events.ConfigUpdateEvent;
import io.intercom.android.sdk.overlay.InAppNotificationPresenter;
import io.intercom.android.sdk.overlay.LauncherOpenBehaviour;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.IntercomSurveyActivity;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.ContextLocaliser;
import io.intercom.android.sdk.utilities.ViewUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OverlayPresenter implements InAppNotificationPresenter.Listener, Store.Subscriber2<Integer, OverlayState> {
    private final Provider<AppConfig> appConfigProvider;
    private final Handler handler;
    final InAppNotificationPresenter inAppNotificationPresenter;
    final DefaultLauncherPresenter launcherPresenter;
    private final MetricTracker metricTracker;
    private final Store<State> store;
    private final Twig twig = LumberMill.getLogger();
    private final UserIdentity userIdentity;
    private final Set<String> viewedPartIds = new HashSet();

    public OverlayPresenter(Application application, Bus bus, Store<State> store2, Provider<AppConfig> provider, MetricTracker metricTracker2, UserIdentity userIdentity2) {
        this.appConfigProvider = provider;
        this.store = store2;
        this.metricTracker = metricTracker2;
        this.userIdentity = userIdentity2;
        LayoutInflater from = LayoutInflater.from(application);
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.handler = handler2;
        this.inAppNotificationPresenter = new InAppNotificationPresenter(from, handler2, this, metricTracker2, provider, new ContextLocaliser(provider), hostActivity());
        this.launcherPresenter = new DefaultLauncherPresenter(from, new LauncherOpenBehaviour(store2, LauncherOpenBehaviour.LauncherType.DEFAULT, metricTracker2, provider), metricTracker2);
        bus.register(this);
        store2.subscribeToChanges(Selectors.UNREAD_COUNT, Selectors.OVERLAY, this);
    }

    public void onStateChange(Integer num, OverlayState overlayState) {
        Intercom.Visibility notificationVisibility = overlayState.notificationVisibility();
        Activity resumedHostActivity = overlayState.resumedHostActivity();
        List<Conversation> conversations = overlayState.conversations();
        SurveyData survey = overlayState.survey();
        Carousel carousel = overlayState.carousel();
        this.launcherPresenter.setBottomPadding(overlayState.bottomPadding());
        this.inAppNotificationPresenter.setBottomPadding(overlayState.bottomPadding());
        if (resumedHostActivity != null && !resumedHostActivity.isFinishing() && !resumedHostActivity.isDestroyed()) {
            if (shouldDisplaySurvey(survey, resumedHostActivity)) {
                openSurvey(resumedHostActivity);
            } else if (shouldDisplayCarousel(carousel, resumedHostActivity)) {
                openCarousel(resumedHostActivity);
            } else if (shouldDisplayNotifications(conversations, notificationVisibility, resumedHostActivity)) {
                preloadAvatarThenDisplayNotifications(conversations, notificationVisibility, resumedHostActivity, this.userIdentity.getFingerprint());
            } else if (shouldDisplayLauncher(conversations, notificationVisibility, overlayState.launcherVisibility(), resumedHostActivity)) {
                ViewGroup rootView = getRootView(resumedHostActivity);
                ViewUtils.waitForViewAttachment(rootView, new Runnable(rootView, num) {
                    public final /* synthetic */ ViewGroup f$1;
                    public final /* synthetic */ Integer f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        OverlayPresenter.this.lambda$onStateChange$0$OverlayPresenter(this.f$1, this.f$2);
                    }
                });
            } else {
                removeOverlaysIfPresent(resumedHostActivity);
            }
        }
    }

    public /* synthetic */ void lambda$onStateChange$0$OverlayPresenter(ViewGroup viewGroup, Integer num) {
        this.inAppNotificationPresenter.reset(viewGroup);
        this.launcherPresenter.setUnreadCount(num.intValue());
        this.launcherPresenter.displayLauncherOnAttachedRoot(viewGroup, this.appConfigProvider.get());
    }

    public void softReset() {
        cancelAnimations();
        Activity hostActivity = hostActivity();
        if (hostActivity != null) {
            removeOverlaysIfPresent(hostActivity);
        }
    }

    @Subscribe
    public void configUpdated(ConfigUpdateEvent configUpdateEvent) {
        OverlayState overlayState = (OverlayState) this.store.select(Selectors.OVERLAY);
        Activity resumedHostActivity = overlayState.resumedHostActivity();
        if (shouldDisplayLauncher(overlayState.conversations(), overlayState.notificationVisibility(), overlayState.launcherVisibility(), resumedHostActivity)) {
            ViewGroup rootView = getRootView(resumedHostActivity);
            ViewUtils.waitForViewAttachment(rootView, new Runnable(rootView) {
                public final /* synthetic */ ViewGroup f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    OverlayPresenter.this.lambda$configUpdated$1$OverlayPresenter(this.f$1);
                }
            });
            return;
        }
        this.launcherPresenter.setLauncherBackgroundColor(this.appConfigProvider.get());
    }

    public /* synthetic */ void lambda$configUpdated$1$OverlayPresenter(ViewGroup viewGroup) {
        this.launcherPresenter.displayLauncherOnAttachedRoot(viewGroup, this.appConfigProvider.get());
    }

    public void cancelAnimations() {
        this.handler.removeCallbacksAndMessages((Object) null);
    }

    public void removeOverlaysIfPresent(Activity activity) {
        activity.runOnUiThread(new Runnable(activity.findViewById(R.id.intercom_overlay_root)) {
            public final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                OverlayPresenter.this.lambda$removeOverlaysIfPresent$2$OverlayPresenter(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$removeOverlaysIfPresent$2$OverlayPresenter(View view) {
        if (view != null) {
            this.launcherPresenter.removeLauncher();
            this.inAppNotificationPresenter.reset((ViewGroup) view);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void preloadAvatarThenDisplayNotifications(List<Conversation> list, Intercom.Visibility visibility, Activity activity, String str) {
        AvatarUtils.preloadAvatar(list.get(0).getLastAdmin().getAvatar(), new Runnable(str, list, visibility, activity) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ List f$2;
            public final /* synthetic */ Intercom.Visibility f$3;
            public final /* synthetic */ Activity f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void run() {
                OverlayPresenter.this.lambda$preloadAvatarThenDisplayNotifications$3$OverlayPresenter(this.f$1, this.f$2, this.f$3, this.f$4);
            }
        }, activity);
    }

    public /* synthetic */ void lambda$preloadAvatarThenDisplayNotifications$3$OverlayPresenter(String str, List list, Intercom.Visibility visibility, Activity activity) {
        if (str.equals(this.userIdentity.getFingerprint()) && shouldDisplayNotifications(list, visibility, activity)) {
            displayNotifications(list, activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void displayNotifications(final List<Conversation> list, Activity activity) {
        final ViewGroup rootView = getRootView(activity);
        Conversation conversation = list.get(0);
        String messageStyle = conversation.getLastPart().getMessageStyle();
        Part.DeliveryOption deliveryOption = conversation.getLastPart().getDeliveryOption();
        if (list.size() > 1 || this.inAppNotificationPresenter.isDisplaying() || deliveryOption == Part.DeliveryOption.SUMMARY || (deliveryOption == Part.DeliveryOption.FULL && Part.CHAT_MESSAGE_STYLE.equals(messageStyle))) {
            if (this.launcherPresenter.isDisplaying()) {
                final DefaultLauncher andUnsetLauncher = this.launcherPresenter.getAndUnsetLauncher();
                if (list.size() == 1) {
                    andUnsetLauncher.pulseForTransformation(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            andUnsetLauncher.fadeOffScreen(new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    andUnsetLauncher.removeView();
                                }
                            });
                            OverlayPresenter.this.inAppNotificationPresenter.displayNotifications(rootView, list);
                        }
                    });
                } else {
                    andUnsetLauncher.fadeOffScreen(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            andUnsetLauncher.removeView();
                            OverlayPresenter.this.inAppNotificationPresenter.displayNotifications(rootView, list);
                        }
                    });
                }
            } else {
                this.inAppNotificationPresenter.displayNotifications(rootView, list);
            }
        } else if (deliveryOption != Part.DeliveryOption.FULL) {
        } else {
            if (Part.POST_MESSAGE_STYLE.equals(messageStyle)) {
                trackInAppView(conversation.getId(), conversation.getLastPart().getId(), 1);
                openPost(conversation);
            } else if (Part.NOTE_MESSAGE_STYLE.equals(messageStyle)) {
                trackInAppView(conversation.getId(), conversation.getLastPart().getId(), 1);
                openNote(conversation);
            }
        }
    }

    public ViewGroup getRootView() {
        Activity hostActivity = hostActivity();
        if (hostActivity != null) {
            return getRootView(hostActivity);
        }
        throw null;
    }

    private ViewGroup getRootView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.intercom_overlay_root);
        if (viewGroup != null) {
            return viewGroup;
        }
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        frameLayout.setFitsSystemWindows(true);
        frameLayout.setId(R.id.intercom_overlay_root);
        activity.addContentView(frameLayout, new FrameLayout.LayoutParams(-1, -1, 80));
        return frameLayout;
    }

    public void markAsDismissed(Conversation conversation) {
        this.store.dispatch(Actions.conversationMarkedAsDismissed(conversation));
    }

    public void openNotification(Conversation conversation) {
        Part lastAdminPart = conversation.getLastAdminPart();
        String messageStyle = lastAdminPart.getMessageStyle();
        if (Part.POST_MESSAGE_STYLE.equals(messageStyle)) {
            trackInAppView(conversation.getId(), conversation.getLastPart().getId(), 0);
            openPost(conversation);
        } else if (Part.NOTE_MESSAGE_STYLE.equals(messageStyle)) {
            trackInAppView(conversation.getId(), conversation.getLastPart().getId(), 0);
            openNote(conversation);
        } else {
            openMessenger(conversation);
            if (!Part.CHAT_MESSAGE_STYLE.equals(messageStyle) || Part.DeliveryOption.FULL != lastAdminPart.getDeliveryOption()) {
                this.metricTracker.openedConversationFromSnippet(conversation.getId(), lastAdminPart.getId());
            } else {
                this.metricTracker.openedConversationFromFull(conversation.getId(), lastAdminPart.getId());
            }
        }
    }

    private void openMessenger(Conversation conversation) {
        Activity hostActivity = hostActivity();
        if (hostActivity != null) {
            TaskStackBuilder create = TaskStackBuilder.create(hostActivity);
            create.addNextIntent(hostActivity.getIntent());
            create.addNextIntent(IntercomRootActivityLauncher.INSTANCE.getIntentForScenario(hostActivity, IntercomScreenScenario.MessagesScreen.INSTANCE));
            create.addNextIntent(IntercomConversationActivity.Companion.openConversation(hostActivity, conversation.getId(), conversation.getLastParticipatingAdmin()));
            create.startActivities();
        }
    }

    private void openPost(Conversation conversation) {
        Activity hostActivity = hostActivity();
        if (hostActivity != null) {
            hostActivity.startActivity(IntercomPostActivity.buildPostIntent(hostActivity, conversation.getLastPart(), conversation.getId(), conversation.getLastParticipatingAdmin(), conversation.getComposerState().isVisible(), true));
        }
    }

    private void openNote(Conversation conversation) {
        try {
            Activity hostActivity = hostActivity();
            if (hostActivity != null) {
                hostActivity.startActivity(IntercomNoteActivity.buildNoteIntent(hostActivity, conversation.getLastPart(), conversation.getId(), conversation.getLastParticipatingAdmin(), conversation.getComposerState().isVisible()));
            }
        } catch (IllegalArgumentException e) {
            Twig twig2 = this.twig;
            twig2.internal("Overlay", "Error loading the note " + e.getMessage());
        }
    }

    private void openSurvey(Activity activity) {
        activity.startActivity(IntercomSurveyActivity.buildIntent(activity));
    }

    private void openCarousel(Activity activity) {
        activity.startActivity(new Intent(activity, IntercomCarouselActivity.class));
    }

    private Activity hostActivity() {
        return ((OverlayState) this.store.select(Selectors.OVERLAY)).resumedHostActivity();
    }

    private void trackInAppView(String str, String str2, int i) {
        if (!this.viewedPartIds.contains(str2)) {
            this.viewedPartIds.add(str2);
            this.metricTracker.viewedInApp(str, str2, i);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDisplaySurvey(SurveyData surveyData, Activity activity) {
        return !SurveyData.Companion.getNULL().equals(surveyData) && !this.userIdentity.isSoftReset() && activity != null;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDisplayCarousel(Carousel carousel, Activity activity) {
        return !Carousel.NULL.equals(carousel) && !this.userIdentity.isSoftReset() && activity != null;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDisplayNotifications(List<Conversation> list, Intercom.Visibility visibility, Activity activity) {
        return visibility == Intercom.Visibility.VISIBLE && !this.userIdentity.isSoftReset() && !list.isEmpty() && activity != null;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDisplayLauncher(List<Conversation> list, Intercom.Visibility visibility, Intercom.Visibility visibility2, Activity activity) {
        if (visibility == Intercom.Visibility.VISIBLE) {
            for (Conversation lastPart : list) {
                if (Part.DeliveryOption.BADGE != lastPart.getLastPart().getDeliveryOption()) {
                    return false;
                }
            }
        }
        if (visibility2 != Intercom.Visibility.VISIBLE || this.userIdentity.isSoftReset() || !this.userIdentity.identityExists() || !this.appConfigProvider.get().isReceivedFromServer() || activity == null) {
            return false;
        }
        return true;
    }

    public void refreshStateBecauseUserIdentityIsNotInStoreYet() {
        onStateChange((Integer) this.store.select(Selectors.UNREAD_COUNT), (OverlayState) this.store.select(Selectors.OVERLAY));
    }
}
