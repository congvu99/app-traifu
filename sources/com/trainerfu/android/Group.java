package com.trainerfu.android;

public enum Group {
    ADMIN(2),
    TRAINER(4),
    CLIENT(8),
    SLAdmin(16);
    
    private final int mask;

    private Group(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static Group getGroup(int i) {
        if (i == 2) {
            return ADMIN;
        }
        if (i == 4) {
            return TRAINER;
        }
        if (i == 8) {
            return CLIENT;
        }
        if (i == 16) {
            return SLAdmin;
        }
        throw new IllegalArgumentException();
    }
}
