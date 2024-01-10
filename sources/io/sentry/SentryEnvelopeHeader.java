package io.sentry;

import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;

public final class SentryEnvelopeHeader {
    private final SentryId eventId;
    private final SdkVersion sdkVersion;

    public SentryEnvelopeHeader(SentryId sentryId, SdkVersion sdkVersion2) {
        this.eventId = sentryId;
        this.sdkVersion = sdkVersion2;
    }

    public SentryEnvelopeHeader(SentryId sentryId) {
        this(sentryId, (SdkVersion) null);
    }

    public SentryEnvelopeHeader() {
        this(new SentryId());
    }

    public SentryId getEventId() {
        return this.eventId;
    }

    public SdkVersion getSdkVersion() {
        return this.sdkVersion;
    }
}
