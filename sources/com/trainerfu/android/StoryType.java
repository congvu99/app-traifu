package com.trainerfu.android;

public enum StoryType {
    WORKOUT_LOG(1),
    PHOTO_LOG(2);
    
    private final int mask;

    private StoryType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static StoryType getStoryType(int i) {
        if (i == 1) {
            return WORKOUT_LOG;
        }
        if (i == 2) {
            return PHOTO_LOG;
        }
        throw new IllegalArgumentException();
    }
}
