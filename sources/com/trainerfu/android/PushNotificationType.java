package com.trainerfu.android;

public enum PushNotificationType {
    NEW_MESSAGE(1);
    
    private final int mask;

    private PushNotificationType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }
}
