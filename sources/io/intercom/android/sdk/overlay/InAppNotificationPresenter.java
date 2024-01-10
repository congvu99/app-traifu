package io.intercom.android.sdk.overlay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import com.intercom.commons.utilities.ScreenUtils;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.m5.IntercomRootActivityLauncher;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.overlay.InAppNotification;
import io.intercom.android.sdk.utilities.ContextLocaliser;
import io.intercom.android.sdk.utilities.SystemSettings;
import io.intercom.android.sdk.utilities.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class InAppNotificationPresenter implements InAppNotification.Listener, View.OnClickListener {
    private static final int MAX_DISPLAYED_NOTIFICATIONS = 3;
    private static final int PILL_START_OFFSET_DP = 66;
    private final Activity activity;
    private final Provider<AppConfig> appConfigProvider;
    private int bottomPadding = 0;
    private final ContextLocaliser contextLocaliser;
    final Handler handler;
    private boolean hasAnimated = false;
    private final LayoutInflater inflater;
    private final List<Conversation> lastDisplayedConversations = new ArrayList();
    private final Listener listener;
    private final MetricTracker metricTracker;
    private final Map<String, InAppNotification> notifications = new HashMap();
    /* access modifiers changed from: private */
    public float pillPosition;
    private final Twig twig = LumberMill.getLogger();

    interface Listener {
        ViewGroup getRootView() throws Exception;

        void markAsDismissed(Conversation conversation);

        void openNotification(Conversation conversation);
    }

    public InAppNotificationPresenter(LayoutInflater layoutInflater, Handler handler2, Listener listener2, MetricTracker metricTracker2, Provider<AppConfig> provider, ContextLocaliser contextLocaliser2, Activity activity2) {
        this.inflater = layoutInflater;
        this.listener = listener2;
        this.handler = handler2;
        this.metricTracker = metricTracker2;
        this.appConfigProvider = provider;
        this.contextLocaliser = contextLocaliser2;
        this.activity = activity2;
    }

    public void displayNotifications(final ViewGroup viewGroup, final List<Conversation> list) {
        ViewUtils.waitForViewAttachment(viewGroup, new Runnable() {
            public void run() {
                InAppNotificationPresenter.this.displayNotificationsAfterAttach(list, viewGroup);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void displayNotificationsAfterAttach(List<Conversation> list, ViewGroup viewGroup) {
        boolean z = !this.lastDisplayedConversations.equals(list) && !this.notifications.isEmpty();
        HashMap hashMap = new HashMap(this.notifications);
        if (z) {
            updateNotifications(list, hashMap, viewGroup);
        } else if (!isDisplaying()) {
            addNewNotifications(list, viewGroup);
        }
        this.hasAnimated = true;
        Resources resources = viewGroup.getResources();
        this.pillPosition = (float) (((viewGroup.getHeight() - resources.getDimensionPixelSize(R.dimen.intercom_overlay_pill_bottom_margin)) - resources.getDimensionPixelSize(R.dimen.intercom_bottom_padding)) - this.bottomPadding);
        displayPill(this.inflater, viewGroup);
        this.lastDisplayedConversations.clear();
        this.lastDisplayedConversations.addAll(list);
    }

    public boolean isDisplaying() {
        return !this.notifications.isEmpty();
    }

    public void reset(ViewGroup viewGroup) {
        for (InAppNotification removeView : this.notifications.values()) {
            removeView.removeView();
        }
        View findViewById = viewGroup.findViewById(R.id.notification_pill);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        this.notifications.clear();
    }

    public void onInAppNotificationTap(Conversation conversation) {
        this.listener.openNotification(conversation);
    }

    public void onInAppNotificationDismiss(InAppNotification inAppNotification) {
        ViewGroup viewGroup;
        try {
            viewGroup = this.listener.getRootView();
        } catch (Exception e) {
            Twig twig2 = this.twig;
            twig2.internal("Couldn't get root view: " + e.getMessage());
            viewGroup = null;
        }
        Conversation conversation = inAppNotification.getConversation();
        if (viewGroup != null) {
            this.listener.markAsDismissed(conversation);
            viewGroup.removeView(inAppNotification.getRootView());
            this.notifications.remove(conversation.getId());
            this.lastDisplayedConversations.remove(conversation);
            for (InAppNotification moveForward : this.notifications.values()) {
                moveForward.moveForward(viewGroup, this.inflater);
            }
            displayPill(this.inflater, viewGroup);
            if (this.notifications.isEmpty()) {
                this.hasAnimated = false;
            }
        }
        Part lastAdminPart = conversation.getLastAdminPart();
        if (Part.CHAT_MESSAGE_STYLE.equals(lastAdminPart.getMessageStyle()) && Part.DeliveryOption.FULL == lastAdminPart.getDeliveryOption()) {
            this.metricTracker.closedInAppFromFull(conversation.getId(), lastAdminPart.getId());
        } else if (lastAdminPart.isInitialMessage()) {
            this.metricTracker.dismissInAppMessageSnippet(conversation.getId(), lastAdminPart.getId());
        } else {
            this.metricTracker.dismissInAppCommentSnippet(conversation.getId(), lastAdminPart.getId());
        }
    }

    public void onClick(View view) {
        IntercomRootActivityLauncher.INSTANCE.startMessages(view.getContext());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: io.intercom.android.sdk.overlay.ChatSnippet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: io.intercom.android.sdk.overlay.StackableSnippet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: io.intercom.android.sdk.overlay.ChatSnippet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: io.intercom.android.sdk.overlay.ChatFull} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: io.intercom.android.sdk.overlay.ChatSnippet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: io.intercom.android.sdk.overlay.ChatSnippet} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addNewNotifications(java.util.List<io.intercom.android.sdk.models.Conversation> r14, android.view.ViewGroup r15) {
        /*
            r13 = this;
            int r0 = r14.size()
            r1 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x0085
            java.lang.Object r2 = r14.get(r1)
            r11 = r2
            io.intercom.android.sdk.models.Conversation r11 = (io.intercom.android.sdk.models.Conversation) r11
            io.intercom.android.sdk.utilities.ContextLocaliser r2 = r13.contextLocaliser
            android.content.Context r3 = r15.getContext()
            android.content.Context r3 = r2.createLocalisedContext(r3)
            io.intercom.android.sdk.models.Part r2 = r11.getLastPart()
            r4 = 2
            if (r0 >= r4) goto L_0x0059
            java.lang.String r4 = r2.getMessageStyle()
            java.lang.String r5 = "chat"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x002c
            goto L_0x0059
        L_0x002c:
            io.intercom.android.sdk.models.Part$DeliveryOption r2 = r2.getDeliveryOption()
            io.intercom.android.sdk.models.Part$DeliveryOption r4 = io.intercom.android.sdk.models.Part.DeliveryOption.SUMMARY
            if (r2 != r4) goto L_0x0044
            io.intercom.android.sdk.overlay.ChatSnippet r9 = new io.intercom.android.sdk.overlay.ChatSnippet
            int r6 = r15.getHeight()
            io.intercom.android.sdk.Provider<io.intercom.android.sdk.identity.AppConfig> r8 = r13.appConfigProvider
            r2 = r9
            r4 = r11
            r5 = r1
            r7 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x006b
        L_0x0044:
            io.intercom.android.sdk.overlay.ChatFull r12 = new io.intercom.android.sdk.overlay.ChatFull
            int r6 = r15.getHeight()
            io.intercom.android.sdk.metrics.MetricTracker r8 = r13.metricTracker
            io.intercom.android.sdk.Provider<io.intercom.android.sdk.identity.AppConfig> r9 = r13.appConfigProvider
            android.app.Activity r10 = r13.activity
            r2 = r12
            r4 = r11
            r5 = r1
            r7 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r9 = r12
            goto L_0x006b
        L_0x0059:
            io.intercom.android.sdk.overlay.StackableSnippet r10 = new io.intercom.android.sdk.overlay.StackableSnippet
            android.os.Handler r6 = r13.handler
            int r7 = r15.getHeight()
            io.intercom.android.sdk.Provider<io.intercom.android.sdk.identity.AppConfig> r9 = r13.appConfigProvider
            r2 = r10
            r4 = r11
            r5 = r1
            r8 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r9 = r10
        L_0x006b:
            java.util.Map<java.lang.String, io.intercom.android.sdk.overlay.InAppNotification> r2 = r13.notifications
            java.lang.String r3 = r11.getId()
            r2.put(r3, r9)
            r2 = 3
            if (r1 >= r2) goto L_0x0082
            android.view.LayoutInflater r2 = r13.inflater
            boolean r3 = r13.hasAnimated
            r3 = r3 ^ 1
            int r4 = r13.bottomPadding
            r9.display(r15, r2, r3, r4)
        L_0x0082:
            int r1 = r1 + 1
            goto L_0x0005
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.overlay.InAppNotificationPresenter.addNewNotifications(java.util.List, android.view.ViewGroup):void");
    }

    private void updateNotifications(final List<Conversation> list, final Map<String, InAppNotification> map, final ViewGroup viewGroup) {
        InAppNotification inAppNotification;
        final Conversation conversation = list.get(0);
        Iterator<InAppNotification> it = map.values().iterator();
        InAppNotification next = it.next();
        loop0:
        while (true) {
            inAppNotification = next;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                next = it.next();
                if (next.getPosition() < inAppNotification.getPosition()) {
                }
            }
        }
        if (isReply(conversation)) {
            inAppNotification.update(conversation, new Runnable() {
                public void run() {
                    InAppNotificationPresenter.this.syncUpdates(list, map, viewGroup);
                }
            });
        } else if (map.size() != 1 || !(inAppNotification instanceof ChatSnippet)) {
            for (InAppNotification next2 : map.values()) {
                if (next2.getPosition() < 3) {
                    next2.moveBackward(viewGroup);
                } else {
                    next2.setPosition(next2.getPosition() + 1);
                }
            }
            addNewView(conversation, viewGroup, map);
            syncUpdates(list, map, viewGroup);
        } else {
            final ViewGroup viewGroup2 = viewGroup;
            final Map<String, InAppNotification> map2 = map;
            final List<Conversation> list2 = list;
            inAppNotification.moveBackward(viewGroup, new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    InAppNotificationPresenter.this.addNewView(conversation, viewGroup2, map2);
                    InAppNotificationPresenter.this.handler.postDelayed(new Runnable() {
                        public void run() {
                            InAppNotificationPresenter.this.syncUpdates(list2, map2, viewGroup2);
                        }
                    }, 220);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void addNewView(Conversation conversation, ViewGroup viewGroup, Map<String, InAppNotification> map) {
        StackableSnippet stackableSnippet = new StackableSnippet(this.contextLocaliser.createLocalisedContext(viewGroup.getContext()), conversation, 0, this.handler, viewGroup.getHeight(), this, this.appConfigProvider);
        stackableSnippet.display(viewGroup, this.inflater, true, this.bottomPadding);
        if (map.containsKey(conversation.getId())) {
            map.get(conversation.getId()).removeView();
        }
        map.put(conversation.getId(), stackableSnippet);
    }

    /* access modifiers changed from: package-private */
    public void syncUpdates(List<Conversation> list, Map<String, InAppNotification> map, ViewGroup viewGroup) {
        for (int i = 0; i < list.size(); i++) {
            Conversation conversation = list.get(i);
            InAppNotification remove = map.remove(conversation.getId());
            if (((remove instanceof ChatSnippet) && i > 0) || remove == null) {
                if (remove != null) {
                    remove.removeView();
                }
                remove = new StackableSnippet(this.contextLocaliser.createLocalisedContext(viewGroup.getContext()), conversation, i, this.handler, viewGroup.getHeight(), this, this.appConfigProvider);
            }
            if (i < 3) {
                remove.display(viewGroup, conversation, this.inflater, false, this.bottomPadding);
            } else {
                remove.removeView();
            }
            this.notifications.put(conversation.getId(), remove);
        }
        for (InAppNotification removeView : map.values()) {
            removeView.removeView();
        }
    }

    /* JADX WARNING: type inference failed for: r4v6, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void displayPill(android.view.LayoutInflater r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            int r0 = io.intercom.android.sdk.R.id.notification_pill
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.util.Map<java.lang.String, io.intercom.android.sdk.overlay.InAppNotification> r1 = r3.notifications
            int r1 = r1.size()
            r2 = 3
            if (r1 > r2) goto L_0x0017
            if (r0 == 0) goto L_0x0060
            r5.removeView(r0)
            goto L_0x0060
        L_0x0017:
            if (r0 != 0) goto L_0x0040
            int r0 = io.intercom.android.sdk.R.layout.intercom_notification_pill
            r1 = 1
            r4.inflate(r0, r5, r1)
            int r4 = io.intercom.android.sdk.R.id.notification_pill
            android.view.View r4 = r5.findViewById(r4)
            r0 = r4
            android.widget.TextView r0 = (android.widget.TextView) r0
            r4 = 0
            r0.setAlpha(r4)
            r4 = 1053609165(0x3ecccccd, float:0.4)
            r0.setScaleX(r4)
            r0.setScaleY(r4)
            float r4 = r3.pillPosition
            r0.setY(r4)
            r0.setOnClickListener(r3)
            r3.animatePill(r0)
        L_0x0040:
            io.intercom.android.sdk.utilities.ContextLocaliser r4 = r3.contextLocaliser
            android.content.Context r5 = r0.getContext()
            android.content.Context r4 = r4.createLocalisedContext(r5)
            int r5 = io.intercom.android.sdk.R.string.intercom_plus_x_more
            io.intercom.android.sdk.utilities.Phrase r4 = io.intercom.android.sdk.utilities.Phrase.from((android.content.Context) r4, (int) r5)
            java.util.Map<java.lang.String, io.intercom.android.sdk.overlay.InAppNotification> r5 = r3.notifications
            int r5 = r5.size()
            int r5 = r5 - r2
            java.lang.String r1 = "n"
            io.intercom.android.sdk.utilities.Phrase r4 = r4.put((java.lang.String) r1, (int) r5)
            r4.into(r0)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.overlay.InAppNotificationPresenter.displayPill(android.view.LayoutInflater, android.view.ViewGroup):void");
    }

    private void animatePill(final View view) {
        this.handler.postDelayed(new Runnable() {
            public void run() {
                view.setY(InAppNotificationPresenter.this.pillPosition + ((float) ScreenUtils.dpToPx(66.0f, view.getContext())));
                view.animate().setInterpolator(new OvershootInterpolator()).y(InAppNotificationPresenter.this.pillPosition).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).start();
            }
        }, (long) (SystemSettings.getTransitionScale(view.getContext()) * 500.0f));
    }

    private void updatePillPosition(View view) {
        ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("y", new float[]{view.getY(), this.pillPosition})}).setDuration(300).start();
    }

    private boolean isReply(Conversation conversation) {
        if (this.lastDisplayedConversations.isEmpty() || !conversation.getId().equals(this.lastDisplayedConversations.get(0).getId())) {
            return false;
        }
        return true;
    }

    public void setBottomPadding(int i) {
        this.bottomPadding = i;
        if (isDisplaying()) {
            for (InAppNotification updateBottomPadding : this.notifications.values()) {
                updateBottomPadding.updateBottomPadding(this.inflater.getContext(), this.bottomPadding);
            }
            ViewGroup viewGroup = null;
            try {
                viewGroup = this.listener.getRootView();
            } catch (Exception e) {
                Twig twig2 = this.twig;
                twig2.internal("Couldn't get root view: " + e.getMessage());
            }
            if (viewGroup != null) {
                Resources resources = viewGroup.getResources();
                this.pillPosition = (float) (((viewGroup.getHeight() - resources.getDimensionPixelSize(R.dimen.intercom_overlay_pill_bottom_margin)) - resources.getDimensionPixelSize(R.dimen.intercom_bottom_padding)) - i);
                View findViewById = viewGroup.findViewById(R.id.notification_pill);
                if (findViewById != null) {
                    updatePillPosition(findViewById);
                }
            }
        }
    }
}
