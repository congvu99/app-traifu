package io.intercom.android.sdk.middleware;

import io.intercom.android.sdk.NotificationStatuses;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.state.MessengerState;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import java.util.Arrays;

public class ApiMiddleware implements Store.Middleware<State> {
    private final Provider<Api> apiProvider;

    public ApiMiddleware(Provider<Api> provider) {
        this.apiProvider = provider;
    }

    public void dispatch(Store<State> store, Action<?> action, Store.NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        switch (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()]) {
            case 1:
                api().markConversationAsDismissed(((Conversation) action.value()).getId());
                return;
            case 2:
                int size = ((OverlayState) store.select(Selectors.OVERLAY)).conversations().size();
                if (size == 1 && ((Integer) store.select(Selectors.UNREAD_COUNT)).intValue() > size) {
                    api().getUnreadConversations();
                    return;
                }
                return;
            case 3:
                api().getInbox();
                return;
            case 4:
                api().getInboxBefore(((Long) action.value()).longValue());
                return;
            case 5:
                fetchDataForCurrentScreen(store, (String) action.value());
                return;
            case 6:
                Conversation conversation = (Conversation) action.value();
                if (shouldRecordOpenedInteraction(store, conversation)) {
                    api().recordInteractions(conversation.getId(), new String[]{"opened"});
                    return;
                }
                return;
            case 7:
                fetchProgrammaticCarousel(store, (String) action.value());
                return;
            default:
                return;
        }
    }

    /* renamed from: io.intercom.android.sdk.middleware.ApiMiddleware$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.intercom.android.sdk.actions.Action$Type[] r0 = io.intercom.android.sdk.actions.Action.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type = r0
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.CONVERSATION_MARKED_AS_DISMISSED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.CONVERSATION_MARKED_AS_READ     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.FETCH_INBOX_REQUEST     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.FETCH_INBOX_BEFORE_DATE_REQUEST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.NEW_COMMENT_EVENT_RECEIVED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.FETCH_CONVERSATION_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.OPEN_PROGRAMMATIC_CAROUSEL     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.middleware.ApiMiddleware.AnonymousClass1.<clinit>():void");
        }
    }

    private void fetchDataForCurrentScreen(Store<State> store, String str) {
        if (shouldFetchUnreadConversations(store)) {
            api().getUnreadConversations();
        } else {
            api().getConversation(str, store.state().activeConversationState().getClientAssignedUuid());
        }
    }

    private boolean shouldFetchUnreadConversations(Store<State> store) {
        return (((OverlayState) store.select(Selectors.OVERLAY)).resumedHostActivity() != null && !((MessengerState) store.select(Selectors.MESSENGER_STATE)).isOpened()) || ((Boolean) store.select(Selectors.APP_IS_BACKGROUNDED)).booleanValue();
    }

    private boolean shouldRecordOpenedInteraction(Store<State> store, Conversation conversation) {
        return store.state().activeConversationState().getConversationId().equals(conversation.getId()) && Arrays.asList(new String[]{NotificationStatuses.DELIVERED_STATUS, NotificationStatuses.RENOTIFYING_STATUS}).contains(conversation.getNotificationStatus());
    }

    private Api api() {
        return this.apiProvider.get();
    }

    private void fetchProgrammaticCarousel(Store<State> store, String str) {
        store.dispatch(Actions.programmaticCarouselLoading(str));
        api().fetchProgrammaticCarousel(str);
    }
}
