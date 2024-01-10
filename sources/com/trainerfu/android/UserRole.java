package com.trainerfu.android;

public enum UserRole {
    CLIENT(1),
    TRAINER(2);
    
    private final int mask;

    private UserRole(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static UserRole getUserRole(int i) {
        if (i == 1) {
            return CLIENT;
        }
        if (i == 2) {
            return TRAINER;
        }
        throw new IllegalArgumentException();
    }
}
