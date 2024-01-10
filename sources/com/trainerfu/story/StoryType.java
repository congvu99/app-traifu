package com.trainerfu.story;

public enum StoryType {
    WORKOUT_LOG(1),
    MEAL_LOG(3),
    POST(4),
    PROGRESS_PHOTO(5),
    ASSESSMENT(6),
    LINK(7),
    CHECKIN(8),
    UNKNOWN(1000);
    
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
        if (i == 3) {
            return MEAL_LOG;
        }
        if (i == 4) {
            return POST;
        }
        if (i == 5) {
            return PROGRESS_PHOTO;
        }
        if (i == 6) {
            return ASSESSMENT;
        }
        if (i == 7) {
            return LINK;
        }
        if (i == 8) {
            return CHECKIN;
        }
        return UNKNOWN;
    }
}
