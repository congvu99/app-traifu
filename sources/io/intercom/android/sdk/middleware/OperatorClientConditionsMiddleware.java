package io.intercom.android.sdk.middleware;

import android.os.Handler;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.OperatorClientCondition;
import io.intercom.android.sdk.operator.OperatorClientConditionTimer;
import io.intercom.android.sdk.state.ActiveConversationState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.views.ClientConditionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OperatorClientConditionsMiddleware implements ClientConditionListener, Store.Middleware<State> {
    private static final String USER_INTERACTION_CONDITION = "user_interaction_condition";
    private final Provider<Api> apiProvider;
    final Map<String, List<OperatorClientConditionTimer>> conversationConditions = new HashMap();
    private final Handler handler;

    public OperatorClientConditionsMiddleware(Provider<Api> provider, Handler handler2) {
        this.apiProvider = provider;
        this.handler = handler2;
    }

    public void dispatch(Store<State> store, Action<?> action, Store.NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        int i = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            interruptCondition(store.state().activeConversationState().getConversationId());
        } else if (i == 4 || i == 5) {
            Conversation conversation = (Conversation) action.value();
            addClientConditionsForConversation(conversation.getId(), conversation.getOperatorClientConditions(), store.state().activeConversationState());
        }
    }

    /* renamed from: io.intercom.android.sdk.middleware.OperatorClientConditionsMiddleware$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
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
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.COMPOSER_TYPED_IN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.COMPOSER_CLEARED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.COMPOSER_INPUT_CHANGED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.FETCH_CONVERSATION_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.NEW_CONVERSATION_SUCCESS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.middleware.OperatorClientConditionsMiddleware.AnonymousClass1.<clinit>():void");
        }
    }

    private void addClientConditionsForConversation(String str, List<OperatorClientCondition> list, ActiveConversationState activeConversationState) {
        if (!list.isEmpty()) {
            List list2 = this.conversationConditions.get(str);
            if (list2 == null) {
                list2 = new ArrayList();
                this.conversationConditions.put(str, list2);
            }
            for (OperatorClientCondition next : list) {
                if (USER_INTERACTION_CONDITION.equals(next.conditionId())) {
                    createOperatorClientConditionTimer(str, activeConversationState, list2, next);
                }
            }
        }
    }

    private void createOperatorClientConditionTimer(String str, ActiveConversationState activeConversationState, List<OperatorClientConditionTimer> list, OperatorClientCondition operatorClientCondition) {
        OperatorClientConditionTimer operatorClientConditionTimer = new OperatorClientConditionTimer(str, operatorClientCondition.id(), this.handler, this);
        list.add(operatorClientConditionTimer);
        operatorClientConditionTimer.beginCountdown();
        if (userHasInteractedWithConversation(str, activeConversationState)) {
            operatorClientConditionTimer.interrupt();
        }
    }

    private boolean userHasInteractedWithConversation(String str, ActiveConversationState activeConversationState) {
        return activeConversationState.getConversationId().equals(str) && (activeConversationState.hasSwitchedInputType() || activeConversationState.hasTextInComposer());
    }

    private void interruptCondition(String str) {
        List<OperatorClientConditionTimer> list = this.conversationConditions.get(str);
        if (list != null) {
            for (OperatorClientConditionTimer interrupt : list) {
                interrupt.interrupt();
            }
        }
    }

    public void conditionSatisfied(String str, String str2) {
        Iterator it = this.conversationConditions.get(str).iterator();
        while (it.hasNext()) {
            if (((OperatorClientConditionTimer) it.next()).getCondition().equals(str2)) {
                it.remove();
            }
        }
        this.apiProvider.get().satisfyOperatorCondition(str, str2);
    }
}
