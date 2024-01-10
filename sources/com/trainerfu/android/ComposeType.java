package com.trainerfu.android;

public enum ComposeType {
    POST_STORY(1),
    LINK_STORY(2),
    WORKOUT_FEEDBACK(3),
    PROGRESS_PHOTO(4);
    
    private final int mask;

    private ComposeType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static ComposeType getComposeType(int i) {
        if (i == 1) {
            return POST_STORY;
        }
        if (i == 2) {
            return LINK_STORY;
        }
        if (i == 3) {
            return WORKOUT_FEEDBACK;
        }
        if (i == 4) {
            return PROGRESS_PHOTO;
        }
        throw new IllegalArgumentException();
    }
}
