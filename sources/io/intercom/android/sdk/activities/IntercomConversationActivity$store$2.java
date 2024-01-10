package io.intercom.android.sdk.activities;

import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/store/Store;", "Lio/intercom/android/sdk/state/State;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomConversationActivity.kt */
final class IntercomConversationActivity$store$2 extends Lambda implements Function0<Store<State>> {
    public static final IntercomConversationActivity$store$2 INSTANCE = new IntercomConversationActivity$store$2();

    IntercomConversationActivity$store$2() {
        super(0);
    }

    public final Store<State> invoke() {
        return Injector.get().getStore();
    }
}
