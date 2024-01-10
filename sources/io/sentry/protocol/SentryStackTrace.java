package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import java.util.List;
import java.util.Map;

public final class SentryStackTrace implements IUnknownPropertiesConsumer {
    private List<SentryStackFrame> frames;
    private Map<String, String> registers;
    private Map<String, Object> unknown;

    public SentryStackTrace() {
    }

    public SentryStackTrace(List<SentryStackFrame> list) {
        this.frames = list;
    }

    public List<SentryStackFrame> getFrames() {
        return this.frames;
    }

    public void setFrames(List<SentryStackFrame> list) {
        this.frames = list;
    }

    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public Map<String, String> getRegisters() {
        return this.registers;
    }

    public void setRegisters(Map<String, String> map) {
        this.registers = map;
    }
}
