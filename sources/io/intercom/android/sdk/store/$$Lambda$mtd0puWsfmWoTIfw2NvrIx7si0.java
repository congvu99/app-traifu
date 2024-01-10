package io.intercom.android.sdk.store;

import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;

/* renamed from: io.intercom.android.sdk.store.-$$Lambda$mtd0puWsfmWoT-Ifw2NvrIx7si0  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$mtd0puWsfmWoTIfw2NvrIx7si0 implements Store.Selector {
    public static final /* synthetic */ $$Lambda$mtd0puWsfmWoTIfw2NvrIx7si0 INSTANCE = new $$Lambda$mtd0puWsfmWoTIfw2NvrIx7si0();

    private /* synthetic */ $$Lambda$mtd0puWsfmWoTIfw2NvrIx7si0() {
    }

    public final Object transform(Object obj) {
        return ((State) obj).programmaticCarouselState();
    }
}
