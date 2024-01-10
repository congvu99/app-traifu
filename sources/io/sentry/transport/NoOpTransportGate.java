package io.sentry.transport;

public final class NoOpTransportGate implements ITransportGate {
    private static final NoOpTransportGate instance = new NoOpTransportGate();

    public boolean isConnected() {
        return true;
    }

    public static NoOpTransportGate getInstance() {
        return instance;
    }

    private NoOpTransportGate() {
    }
}
