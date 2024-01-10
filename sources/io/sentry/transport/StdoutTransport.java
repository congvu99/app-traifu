package io.sentry.transport;

import io.sentry.ISerializer;
import io.sentry.SentryEnvelope;
import io.sentry.transport.ITransport;
import io.sentry.util.Objects;
import java.io.IOException;
import java.io.OutputStream;

public final class StdoutTransport implements ITransport {
    private final ISerializer serializer;

    public void close() {
    }

    public /* synthetic */ void send(SentryEnvelope sentryEnvelope) throws IOException {
        ITransport.CC.$default$send(this, sentryEnvelope);
    }

    public StdoutTransport(ISerializer iSerializer) {
        this.serializer = (ISerializer) Objects.requireNonNull(iSerializer, "Serializer is required");
    }

    public void send(SentryEnvelope sentryEnvelope, Object obj) throws IOException {
        Objects.requireNonNull(sentryEnvelope, "SentryEnvelope is required");
        try {
            this.serializer.serialize(sentryEnvelope, (OutputStream) System.out);
        } catch (Exception unused) {
        }
    }
}
