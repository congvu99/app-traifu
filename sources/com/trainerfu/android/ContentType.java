package com.trainerfu.android;

public enum ContentType {
    HABIT(1),
    SCHEDULED_MESSAGES(2),
    TRAINING_PACKAGES(3),
    AUTO_RESPONDERS(4);
    
    private final int mask;

    private ContentType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static ContentType getContentType(int i) {
        if (i == 1) {
            return HABIT;
        }
        if (i == 2) {
            return SCHEDULED_MESSAGES;
        }
        if (i == 3) {
            return TRAINING_PACKAGES;
        }
        if (i == 4) {
            return AUTO_RESPONDERS;
        }
        throw new IllegalArgumentException();
    }
}
