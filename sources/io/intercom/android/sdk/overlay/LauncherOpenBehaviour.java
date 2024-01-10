package io.intercom.android.sdk.overlay;

import android.content.Context;
import android.text.TextUtils;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.activities.IntercomConversationActivity;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.m5.IntercomRootActivityLauncher;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.state.UiState;
import io.intercom.android.sdk.store.Store;

@Deprecated
public class LauncherOpenBehaviour {
    private final AppConfig appConfig;
    private final LauncherType launcherType;
    private final MetricTracker metricTracker;
    private final Store<State> store;

    public enum LauncherType {
        DEFAULT,
        CUSTOM
    }

    public LauncherOpenBehaviour(Store<State> store2, LauncherType launcherType2, MetricTracker metricTracker2, Provider<AppConfig> provider) {
        this.store = store2;
        this.launcherType = launcherType2;
        this.metricTracker = metricTracker2;
        this.appConfig = provider.get();
    }

    public void openMessenger(Context context) {
        Injector.get().getMetricTracker().clickedLauncher();
        IntercomRootActivityLauncher.INSTANCE.startHome(context);
    }

    /* renamed from: io.intercom.android.sdk.overlay.LauncherOpenBehaviour$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$state$UiState$Screen;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.intercom.android.sdk.state.UiState$Screen[] r0 = io.intercom.android.sdk.state.UiState.Screen.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$intercom$android$sdk$state$UiState$Screen = r0
                io.intercom.android.sdk.state.UiState$Screen r1 = io.intercom.android.sdk.state.UiState.Screen.CONVERSATION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$state$UiState$Screen     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.state.UiState$Screen r1 = io.intercom.android.sdk.state.UiState.Screen.COMPOSER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$state$UiState$Screen     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.state.UiState$Screen r1 = io.intercom.android.sdk.state.UiState.Screen.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.overlay.LauncherOpenBehaviour.AnonymousClass1.<clinit>():void");
        }
    }

    private void openLastOrDefaultState(Context context) {
        UiState uiState = this.store.state().uiState();
        int i = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$state$UiState$Screen[uiState.screen().ordinal()];
        if (i == 1) {
            String conversationId = uiState.conversationId();
            if (TextUtils.isEmpty(conversationId)) {
                presentHome(context);
            } else {
                presentConversation(context, conversationId);
            }
        } else if (i != 2) {
            presentHome(context);
        } else {
            presentComposer(context);
        }
    }

    private void presentConversation(Context context, String str) {
        this.metricTracker.openedMessengerConversation(str, this.launcherType);
        context.startActivity(IntercomConversationActivity.Companion.openConversation(context, str, LastParticipatingAdmin.NULL));
    }

    private void presentComposer(Context context) {
        this.metricTracker.openedMessengerNewConversation(this.launcherType);
        context.startActivity(IntercomConversationActivity.Companion.openComposer(context, ""));
    }

    private void presentHome(Context context) {
        IntercomRootActivityLauncher.INSTANCE.startHome(context);
    }
}
