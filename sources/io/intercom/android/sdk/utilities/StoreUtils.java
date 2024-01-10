package io.intercom.android.sdk.utilities;

import io.intercom.android.sdk.store.Store;

public class StoreUtils {
    public static void safeUnsubscribe(Store.Subscription subscription) {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
