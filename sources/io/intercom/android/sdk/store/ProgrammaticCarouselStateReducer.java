package io.intercom.android.sdk.store;

import io.intercom.android.sdk.actions.Action;
import io.intercom.android.sdk.models.carousel.Carousel;
import io.intercom.android.sdk.models.events.failure.FetchCarouselFailedEvent;
import io.intercom.android.sdk.state.ProgrammaticCarouselState;
import io.intercom.android.sdk.store.Store;

public class ProgrammaticCarouselStateReducer implements Store.Reducer<ProgrammaticCarouselState> {
    static final ProgrammaticCarouselState INITIAL_STATE = ProgrammaticCarouselState.Idle.create();

    /* renamed from: io.intercom.android.sdk.store.ProgrammaticCarouselStateReducer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.PROGRAMMATIC_CAROUSEL_LOADING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.PROGRAMMATIC_CAROUSEL_SUCCESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.PROGRAMMATIC_CAROUSEL_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$actions$Action$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.actions.Action$Type r1 = io.intercom.android.sdk.actions.Action.Type.CAROUSEL_DISMISSED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.store.ProgrammaticCarouselStateReducer.AnonymousClass1.<clinit>():void");
        }
    }

    public ProgrammaticCarouselState reduce(Action<?> action, ProgrammaticCarouselState programmaticCarouselState) {
        int i = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$actions$Action$Type[action.type().ordinal()];
        if (i == 1) {
            return ProgrammaticCarouselState.Loading.create((String) action.value());
        }
        if (i == 2) {
            return ProgrammaticCarouselState.Success.create((Carousel) action.value());
        }
        if (i != 3) {
            return i != 4 ? programmaticCarouselState : INITIAL_STATE;
        }
        FetchCarouselFailedEvent fetchCarouselFailedEvent = (FetchCarouselFailedEvent) action.value();
        return ProgrammaticCarouselState.Error.create(fetchCarouselFailedEvent.carouselId(), fetchCarouselFailedEvent.errorObject().getStatusCode());
    }
}
