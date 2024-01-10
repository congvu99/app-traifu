package io.intercom.android.sdk.api;

import com.intercom.commons.utilities.TimeProvider;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;

class RateLimiter {
    private final AppConfig appConfig;
    private int limitedRequestCount;
    private long periodStartTimestamp;
    private final TimeProvider timeProvider;
    private final Twig twig;

    RateLimiter(AppConfig appConfig2) {
        this(appConfig2, TimeProvider.SYSTEM);
    }

    RateLimiter(AppConfig appConfig2, TimeProvider timeProvider2) {
        this.twig = LumberMill.getLogger();
        this.appConfig = appConfig2;
        this.timeProvider = timeProvider2;
    }

    /* access modifiers changed from: package-private */
    public void recordRequest() {
        if (!isInsideCurrentTimePeriod()) {
            this.periodStartTimestamp = this.timeProvider.currentTimeMillis();
            this.limitedRequestCount = 0;
        }
        this.limitedRequestCount++;
    }

    /* access modifiers changed from: package-private */
    public void logError() {
        this.twig.e("Your app is being rate limited because you're performing too many requests per minute", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    public boolean isLimited() {
        return isInsideCurrentTimePeriod() && hasReachedMaxCount();
    }

    private boolean isInsideCurrentTimePeriod() {
        return this.timeProvider.currentTimeMillis() - this.periodStartTimestamp < this.appConfig.getRateLimitPeriodMs();
    }

    private boolean hasReachedMaxCount() {
        return this.limitedRequestCount >= this.appConfig.getRateLimitCount();
    }
}
