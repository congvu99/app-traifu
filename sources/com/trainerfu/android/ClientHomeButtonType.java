package com.trainerfu.android;

public enum ClientHomeButtonType {
    NEXT_WORKOUT(1),
    LOG_WORKOUT(2),
    TRACK(3),
    CHAT(4);
    
    private final int mask;

    private ClientHomeButtonType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static ClientHomeButtonType get(int i) {
        if (i == 1) {
            return NEXT_WORKOUT;
        }
        if (i == 2) {
            return LOG_WORKOUT;
        }
        if (i == 3) {
            return TRACK;
        }
        if (i == 4) {
            return CHAT;
        }
        throw new IllegalArgumentException();
    }
}
