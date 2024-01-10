package io.sentry;

import io.sentry.util.Objects;
import java.util.Random;

final class TracesSampler {
    private final SentryOptions options;
    private final Random random;

    public TracesSampler(SentryOptions sentryOptions) {
        this((SentryOptions) Objects.requireNonNull(sentryOptions, "options are required"), new Random());
    }

    TracesSampler(SentryOptions sentryOptions, Random random2) {
        this.options = sentryOptions;
        this.random = random2;
    }

    /* access modifiers changed from: package-private */
    public boolean sample(SamplingContext samplingContext) {
        Double sample;
        if (samplingContext.getTransactionContext().getSampled() != null) {
            return samplingContext.getTransactionContext().getSampled().booleanValue();
        }
        if (this.options.getTracesSampler() != null && (sample = this.options.getTracesSampler().sample(samplingContext)) != null) {
            return sample(sample);
        }
        if (samplingContext.getTransactionContext().getParentSampled() != null) {
            return samplingContext.getTransactionContext().getParentSampled().booleanValue();
        }
        if (this.options.getTracesSampleRate() != null) {
            return sample(this.options.getTracesSampleRate());
        }
        return false;
    }

    private boolean sample(Double d) {
        return d.doubleValue() >= this.random.nextDouble();
    }
}
