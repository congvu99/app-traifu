package io.intercom.android.sdk.middleware;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.models.BaseResponse;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;

public class FirstMessageMiddleware implements Store.Middleware<State> {
    private final Context context;
    private final Twig twig;

    public FirstMessageMiddleware(Twig twig2, Context context2) {
        this.twig = twig2;
        this.context = context2;
    }

    public void dispatch(Store<State> store, Action<?> action, Store.NextDispatcher nextDispatcher) {
        nextDispatcher.dispatch(action);
        if (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()] == 1 && ((BaseResponse) action.value()).getConfig().isFirstRequest()) {
            this.twig.i(this.context.getString(R.string.intercom_android_activated_message), new Object[0]);
            try {
                showFirstMessageToast();
            } catch (Exception e) {
                Twig twig2 = this.twig;
                twig2.internal("Couldn't show first message toast: " + e.getMessage());
            }
        }
    }

    /* renamed from: io.intercom.android.sdk.middleware.FirstMessageMiddleware$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$actions$Action$Type;

        static {
            int[] iArr = new int[Action.Type.values().length];
            $SwitchMap$io$intercom$android$sdk$actions$Action$Type = iArr;
            try {
                iArr[Action.Type.BASE_RESPONSE_RECEIVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void showFirstMessageToast() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.intercom_onboarding_layout, (ViewGroup) null);
        Toast toast = new Toast(this.context);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1);
        toast.setView(inflate);
        toast.show();
    }
}
