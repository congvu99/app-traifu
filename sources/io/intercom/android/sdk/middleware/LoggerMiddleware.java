package io.intercom.android.sdk.middleware;

import android.app.Activity;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.store.Store;

public class LoggerMiddleware<S> implements Store.Middleware<S> {
    private final Twig twig;

    public LoggerMiddleware(Twig twig2) {
        this.twig = twig2;
    }

    public void dispatch(Store<S> store, Action<?> action, Store.NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        Twig twig2 = this.twig;
        twig2.i("Dispatched Action: " + action.toString(), new Object[0]);
        int i = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i == 1) {
            Twig twig3 = this.twig;
            twig3.i("Ready to show in-app messages in " + ((Activity) action.value()), new Object[0]);
        } else if (i == 2) {
            Twig twig4 = this.twig;
            twig4.i(((Activity) action.value()) + " was paused", new Object[0]);
        }
    }

    /* renamed from: io.intercom.android.sdk.middleware.LoggerMiddleware$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.intercom.android.sdk.actions.Action$Type[] r0 = io.intercom.android.sdk.actions.Action.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$intercom$android$sdk$actions$Action$Type = r0
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.ACTIVITY_READY_FOR_VIEW_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.ACTIVITY_PAUSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.middleware.LoggerMiddleware.AnonymousClass1.<clinit>():void");
        }
    }
}
