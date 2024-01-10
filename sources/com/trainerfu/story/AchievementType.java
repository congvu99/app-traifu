package com.trainerfu.story;

public enum AchievementType {
    GOAL_UNLOCKED(1),
    PERFECT_WEEK(2),
    PERFECT_MONTH(3),
    PERFECT_QUARTER(4),
    PERFECT_HALF_YEAR(5),
    PERFECT_YEAR(6),
    LOGGED_25X_WORKOUTS(7),
    LOGGED_1ST_WORKOUT(8),
    PR(9);
    
    private final int mask;

    private AchievementType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static AchievementType getAchievementType(int i) {
        switch (i) {
            case 1:
                return GOAL_UNLOCKED;
            case 2:
                return PERFECT_WEEK;
            case 3:
                return PERFECT_MONTH;
            case 4:
                return PERFECT_QUARTER;
            case 5:
                return PERFECT_HALF_YEAR;
            case 6:
                return PERFECT_YEAR;
            case 7:
                return LOGGED_25X_WORKOUTS;
            case 8:
                return LOGGED_1ST_WORKOUT;
            case 9:
                return PR;
            default:
                throw new RuntimeException("Invalid achievement type");
        }
    }
}
