package com.trainerfu.android;

public enum FavoriteType {
    WORKOUT_LOG(1),
    ACHIEVEMENT(2),
    MEAL_LOG(3),
    PHOTO_LOG(4);
    
    private final int mask;

    private FavoriteType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static FavoriteType getFavoriteType(int i) {
        if (i == 1) {
            return WORKOUT_LOG;
        }
        if (i == 2) {
            return ACHIEVEMENT;
        }
        if (i == 3) {
            return MEAL_LOG;
        }
        if (i == 4) {
            return PHOTO_LOG;
        }
        throw new IllegalArgumentException();
    }
}
