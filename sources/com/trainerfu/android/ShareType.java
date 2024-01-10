package com.trainerfu.android;

public enum ShareType {
    COMPLETED_WORKOUT(1),
    NEW_WORKOUT(2),
    PHOTO(3);
    
    private final int mask;

    private ShareType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static ShareType getShareViewType(int i) {
        if (i == 1) {
            return COMPLETED_WORKOUT;
        }
        if (i == 2) {
            return NEW_WORKOUT;
        }
        if (i == 3) {
            return PHOTO;
        }
        throw new IllegalArgumentException();
    }
}
