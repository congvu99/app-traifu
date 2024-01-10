package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.state.UiState;
import io.intercom.android.sdk.store.Store;

class LastViewReducer implements Store.Reducer<UiState> {
    static final UiState INITIAL_STATE = UiState.create(UiState.Screen.NONE, (String) null);

    LastViewReducer() {
    }

    /* renamed from: io.intercom.android.sdk.store.LastViewReducer$1  reason: invalid class name */
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
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.HOME_OPENED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.INBOX_OPENED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.NEW_CONVERSATION_SCREEN_OPENED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.CONVERSATION_OPENED     // Catch:{ NoSuchFieldError -> 0x0033 }
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
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.SOFT_RESET     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.HARD_RESET     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.store.LastViewReducer.AnonymousClass1.<clinit>():void");
        }
    }

    public UiState reduce(Action<?> action, UiState uiState) {
        switch (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()]) {
            case 1:
                return UiState.create(UiState.Screen.HOME, (String) null);
            case 2:
                return UiState.create(UiState.Screen.INBOX, (String) null);
            case 3:
                return UiState.create(UiState.Screen.COMPOSER, (String) null);
            case 4:
                return UiState.create(UiState.Screen.CONVERSATION, (String) action.value());
            case 5:
                return UiState.create(UiState.Screen.CONVERSATION, ((Conversation) action.value()).getId());
            case 6:
            case 7:
                return UiState.create(UiState.Screen.NONE, (String) null);
            default:
                return uiState;
        }
    }
}
