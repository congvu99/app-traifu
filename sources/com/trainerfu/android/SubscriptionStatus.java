package com.trainerfu.android;

public enum SubscriptionStatus {
    TRAILING(1),
    ACTIVE(2),
    INACTIVE(3);
    
    private final int mask;

    private SubscriptionStatus(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static SubscriptionStatus getSubscriptionStatus(int i) {
        if (i == 1) {
            return TRAILING;
        }
        if (i == 2) {
            return ACTIVE;
        }
        if (i == 3) {
            return INACTIVE;
        }
        throw new IllegalArgumentException();
    }
}
