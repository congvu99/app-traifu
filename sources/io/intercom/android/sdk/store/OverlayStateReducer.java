package io.intercom.android.sdk.store;

import android.app.Activity;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.UsersResponse;
import io.intercom.android.sdk.models.carousel.Carousel;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.utilities.ActivityUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class OverlayStateReducer implements Store.Reducer<OverlayState> {
    static final OverlayState INITIAL_STATE = OverlayState.create(Collections.emptyList(), Collections.emptySet(), Intercom.Visibility.VISIBLE, Intercom.Visibility.GONE, (Activity) null, (Activity) null, 0, Carousel.NULL, SurveyData.Companion.getNULL());

    OverlayStateReducer() {
    }

    /* renamed from: io.intercom.android.sdk.store.OverlayStateReducer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
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
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.SET_IN_APP_NOTIFICATION_VISIBILITY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.SET_LAUNCHER_VISIBILITY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.SET_BOTTOM_PADDING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.HARD_RESET     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.CONVERSATION_MARKED_AS_READ     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.CONVERSATION_MARKED_AS_DISMISSED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.UNREAD_CONVERSATIONS_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.ACTIVITY_READY_FOR_VIEW_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x006c }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.ACTIVITY_PAUSED     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.ACTIVITY_STOPPED     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0084 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.APP_ENTERED_BACKGROUND     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0090 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.CAROUSEL_UPDATED     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x009c }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.CAROUSEL_DISMISSED     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x00a8 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.SURVEY_UPDATED     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x00b4 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.SURVEY_DISMISSED     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.store.OverlayStateReducer.AnonymousClass1.<clinit>():void");
        }
    }

    public OverlayState reduce(Action<?> action, OverlayState overlayState) {
        Activity activity = null;
        switch (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()]) {
            case 1:
                return overlayState.toBuilder().notificationVisibility((Intercom.Visibility) action.value()).build();
            case 2:
                return overlayState.toBuilder().launcherVisibility((Intercom.Visibility) action.value()).build();
            case 3:
                return overlayState.toBuilder().bottomPadding(((Integer) action.value()).intValue()).build();
            case 4:
                return overlayState.toBuilder().conversations(Collections.emptyList()).dismissedPartIds(Collections.emptySet()).carousel(Carousel.NULL).build();
            case 5:
                ArrayList arrayList = new ArrayList(overlayState.conversations());
                removeConversationWithId(arrayList, (String) action.value());
                return overlayState.toBuilder().conversations(arrayList).build();
            case 6:
                ArrayList arrayList2 = new ArrayList(overlayState.conversations());
                HashSet hashSet = new HashSet(overlayState.dismissedPartIds());
                hashSet.add(((Conversation) action.value()).getLastPart().getId());
                removeDismissedConversations(arrayList2, hashSet);
                return overlayState.toBuilder().conversations(arrayList2).dismissedPartIds(hashSet).build();
            case 7:
                ArrayList arrayList3 = new ArrayList(((UsersResponse) action.value()).getUnreadConversations().getConversations());
                removeDismissedConversations(arrayList3, overlayState.dismissedPartIds());
                removeBadgeConversations(arrayList3);
                return overlayState.toBuilder().conversations(arrayList3).build();
            case 8:
                Activity activity2 = (Activity) action.value();
                if (!ActivityUtils.isHostActivity(activity2)) {
                    activity2 = null;
                }
                return newStateIfNewHostActivity(overlayState, activity2, (Activity) null);
            case 9:
                return newStateIfNewHostActivity(overlayState, (Activity) null, (Activity) action.value());
            case 10:
                if (((Activity) action.value()) != overlayState.pausedHostActivity()) {
                    activity = overlayState.pausedHostActivity();
                }
                return newStateIfNewHostActivity(overlayState, overlayState.resumedHostActivity(), activity);
            case 11:
                return newStateIfNewHostActivity(overlayState, (Activity) null, (Activity) null);
            case 12:
                return Carousel.NULL.equals(overlayState.carousel()) ? overlayState.toBuilder().carousel((Carousel) action.value()).build() : overlayState;
            case 13:
                return overlayState.toBuilder().carousel(Carousel.NULL).build();
            case 14:
                return SurveyData.Companion.getNULL().equals(overlayState.survey()) ? overlayState.toBuilder().survey((SurveyData) action.value()).build() : overlayState;
            case 15:
                return overlayState.toBuilder().survey(SurveyData.Companion.getNULL()).build();
            default:
                return overlayState;
        }
    }

    private static void removeConversationWithId(List<Conversation> list, String str) {
        for (Conversation next : list) {
            if (next.getId().equals(str)) {
                list.remove(next);
                return;
            }
        }
    }

    private static OverlayState newStateIfNewHostActivity(OverlayState overlayState, Activity activity, Activity activity2) {
        if (overlayState.resumedHostActivity() == activity && overlayState.pausedHostActivity() == activity2) {
            return overlayState;
        }
        return overlayState.toBuilder().resumedHostActivity(activity).pausedHostActivity(activity2).build();
    }

    private static void removeDismissedConversations(List<Conversation> list, Set<String> set) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (set.contains(list.get(size).getLastPart().getId())) {
                list.remove(size);
            }
        }
    }

    private static void removeBadgeConversations(List<Conversation> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).getLastPart().getDeliveryOption() == Part.DeliveryOption.BADGE) {
                list.remove(size);
            }
        }
    }
}
