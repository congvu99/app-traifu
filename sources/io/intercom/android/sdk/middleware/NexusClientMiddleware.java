package io.intercom.android.sdk.middleware;

import android.os.Handler;
import io.intercom.android.nexus.NexusClient;
import io.intercom.android.nexus.NexusConfig;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;

public class NexusClientMiddleware implements Store.Middleware<State> {
    private final Provider<AppConfig> appConfigProvider;
    private final Runnable disconnectRunnable = new Runnable() {
        public void run() {
            NexusClientMiddleware.this.client().disconnect();
        }
    };
    private final Handler handler;
    private final Provider<NexusClient> nexusClient;

    public NexusClientMiddleware(Provider<NexusClient> provider, Provider<AppConfig> provider2, Handler handler2) {
        this.nexusClient = provider;
        this.appConfigProvider = provider2;
        this.handler = handler2;
    }

    public void dispatch(Store<State> store, Action<?> action, Store.NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        int i = AnonymousClass2.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i == 1) {
            connectWithConfig(this.appConfigProvider.get().getRealTimeConfig());
        } else if (i == 2) {
            scheduleDisconnect();
        } else if (i == 3) {
            disconnectImmediately();
        } else if (i == 4) {
            NexusConfig realTimeConfig = ((BaseResponse) action.value()).getConfig().getRealTimeConfig();
            if (realTimeConfig.getEndpoints().isEmpty()) {
                disconnectImmediately();
            } else if (!((Boolean) store.select(Selectors.APP_IS_BACKGROUNDED)).booleanValue()) {
                connectWithConfig(realTimeConfig);
            }
        }
    }

    /* renamed from: io.intercom.android.sdk.middleware.NexusClientMiddleware$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.intercom.android.sdk.actions.Action$Type[] r0 = io.intercom.android.sdk.actions.Action.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type = r0
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.APP_ENTERED_FOREGROUND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.APP_ENTERED_BACKGROUND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.SOFT_RESET     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.BASE_RESPONSE_RECEIVED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.middleware.NexusClientMiddleware.AnonymousClass2.<clinit>():void");
        }
    }

    private void scheduleDisconnect() {
        this.handler.removeCallbacks(this.disconnectRunnable);
        this.handler.postDelayed(this.disconnectRunnable, this.appConfigProvider.get().getNewSessionThresholdMs());
    }

    private void connectWithConfig(NexusConfig nexusConfig) {
        this.handler.removeCallbacks(this.disconnectRunnable);
        client().connect(nexusConfig, true);
    }

    private void disconnectImmediately() {
        this.handler.removeCallbacks(this.disconnectRunnable);
        client().disconnect();
    }

    /* access modifiers changed from: package-private */
    public NexusClient client() {
        return this.nexusClient.get();
    }
}
