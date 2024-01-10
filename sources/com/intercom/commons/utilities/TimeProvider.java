package com.intercom.commons.utilities;

public interface TimeProvider {
    public static final TimeProvider SYSTEM = new TimeProvider() {
        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    };

    long currentTimeMillis();
}
