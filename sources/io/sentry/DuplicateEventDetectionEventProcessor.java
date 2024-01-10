package io.sentry;

import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public final class DuplicateEventDetectionEventProcessor implements EventProcessor {
    private final WeakHashMap<Throwable, Object> capturedObjects = new WeakHashMap<>();
    private final SentryOptions options;

    public DuplicateEventDetectionEventProcessor(SentryOptions sentryOptions) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "options are required");
    }

    public SentryEvent process(SentryEvent sentryEvent, Object obj) {
        Throwable originThrowable = sentryEvent.getOriginThrowable();
        if (originThrowable != null) {
            if (this.capturedObjects.containsKey(originThrowable) || containsAnyKey(this.capturedObjects, allCauses(originThrowable))) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Duplicate Exception detected. Event %s will be discarded.", sentryEvent.getEventId());
                return null;
            }
            this.capturedObjects.put(originThrowable, (Object) null);
        }
        return sentryEvent;
    }

    private static <T> boolean containsAnyKey(Map<T, Object> map, List<T> list) {
        for (T containsKey : list) {
            if (map.containsKey(containsKey)) {
                return true;
            }
        }
        return false;
    }

    private static List<Throwable> allCauses(Throwable th) {
        ArrayList arrayList = new ArrayList();
        while (th.getCause() != null) {
            arrayList.add(th.getCause());
            th = th.getCause();
        }
        return arrayList;
    }
}
