package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.ConversationsResponse;
import io.intercom.android.sdk.models.HomeCardsResponse;
import io.intercom.android.sdk.state.InboxState;
import io.intercom.android.sdk.state.ReplyPart;
import io.intercom.android.sdk.store.Store;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

class InboxStateReducer implements Store.Reducer<InboxState> {
    static final InboxState INITIAL_STATE = InboxState.create(Collections.emptyList(), InboxState.Status.INITIAL, true);

    InboxStateReducer() {
    }

    /* renamed from: io.intercom.android.sdk.store.InboxStateReducer$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
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
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.FETCH_INBOX_REQUEST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.FETCH_INBOX_BEFORE_DATE_REQUEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.FETCH_INBOX_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.FETCH_INBOX_FAILED     // Catch:{ NoSuchFieldError -> 0x0033 }
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
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.CONVERSATION_REPLY_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.FETCH_CONVERSATION_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.NEW_CONVERSATION_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x006c }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.FETCH_HOME_CARDS_SUCCESS     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.SOFT_RESET     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0084 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.HARD_RESET     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.store.InboxStateReducer.AnonymousClass2.<clinit>():void");
        }
    }

    public InboxState reduce(Action<?> action, InboxState inboxState) {
        switch (AnonymousClass2.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()]) {
            case 1:
            case 2:
                if (inboxState.status() == InboxState.Status.LOADING) {
                    return inboxState;
                }
                return InboxState.create(inboxState.conversations(), InboxState.Status.LOADING, inboxState.hasMorePages());
            case 3:
                ConversationsResponse conversationsResponse = (ConversationsResponse) action.value();
                List<Conversation> mergeConversationLists = mergeConversationLists(inboxState.conversations(), conversationsResponse.getConversationPage().getConversations());
                sortByLastPartDate(mergeConversationLists);
                return InboxState.create(mergeConversationLists, InboxState.Status.SUCCESS, conversationsResponse.getConversationPage().hasMorePages());
            case 4:
                return InboxState.create(inboxState.conversations(), InboxState.Status.FAILED, inboxState.hasMorePages());
            case 5:
                ArrayList arrayList = new ArrayList(inboxState.conversations());
                markConversationAsRead((String) action.value(), arrayList);
                return InboxState.create(arrayList, InboxState.Status.SUCCESS, inboxState.hasMorePages());
            case 6:
                ArrayList arrayList2 = new ArrayList(inboxState.conversations());
                updateRepliedConversationAndMoveToTop((ReplyPart) action.value(), arrayList2);
                return InboxState.create(arrayList2, InboxState.Status.SUCCESS, inboxState.hasMorePages());
            case 7:
                ArrayList arrayList3 = new ArrayList(inboxState.conversations());
                updateOrAddConversation((Conversation) action.value(), arrayList3);
                sortByLastPartDate(arrayList3);
                return InboxState.create(arrayList3, InboxState.Status.SUCCESS, inboxState.hasMorePages());
            case 8:
                ArrayList arrayList4 = new ArrayList(inboxState.conversations());
                updateOrAddConversation((Conversation) action.value(), arrayList4);
                return InboxState.create(arrayList4, InboxState.Status.SUCCESS, inboxState.hasMorePages());
            case 9:
                List<Conversation> mergeConversationLists2 = mergeConversationLists(inboxState.conversations(), ((HomeCardsResponse) action.value()).getConversations());
                sortByLastPartDate(mergeConversationLists2);
                return InboxState.create(mergeConversationLists2, InboxState.Status.SUCCESS, inboxState.hasMorePages());
            case 10:
            case 11:
                return INITIAL_STATE;
            default:
                return inboxState;
        }
    }

    private List<Conversation> mergeConversationLists(List<Conversation> list, List<Conversation> list2) {
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        HashSet hashSet = new HashSet(list2.size());
        for (Conversation next : list2) {
            hashSet.add(next.getId());
            arrayList.add(next);
        }
        for (Conversation next2 : list) {
            if (!hashSet.contains(next2.getId())) {
                arrayList.add(next2);
            }
        }
        return arrayList;
    }

    private void sortByLastPartDate(List<Conversation> list) {
        Collections.sort(list, new Comparator<Conversation>() {
            public int compare(Conversation conversation, Conversation conversation2) {
                return (int) (conversation2.getLastPart().getCreatedAt() - conversation.getLastPart().getCreatedAt());
            }
        });
    }

    private void markConversationAsRead(String str, List<Conversation> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Conversation conversation = list.get(i);
            if (str.equals(conversation.getId())) {
                list.set(i, conversation.withRead(true));
            }
        }
    }

    private void updateRepliedConversationAndMoveToTop(ReplyPart replyPart, List<Conversation> list) {
        for (int i = 0; i < list.size(); i++) {
            Conversation conversation = list.get(i);
            if (replyPart.getConversationId().equals(conversation.getId())) {
                conversation.getParts().add(replyPart.getPart());
                list.remove(conversation);
                addConversationAtTop(list, conversation);
            }
        }
    }

    private void updateOrAddConversation(Conversation conversation, List<Conversation> list) {
        int i = 0;
        while (i < list.size()) {
            Conversation conversation2 = list.get(i);
            String id = conversation.getId();
            if (id == null || !id.equals(conversation2.getId())) {
                i++;
            } else {
                list.set(i, conversation);
                return;
            }
        }
        addConversationAtTop(list, conversation);
    }

    private void addConversationAtTop(List<Conversation> list, Conversation conversation) {
        list.add(0, conversation);
    }
}
