package com.trainerfu.android;

public enum WorkoutPlanStage {
    PAST_PLAN(1),
    CURRENT_PLAN(2),
    UPCOMING_PLAN(3);
    
    private final int mask;

    private WorkoutPlanStage(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static WorkoutPlanStage getWorkoutPlanStage(int i) {
        if (i == 1) {
            return PAST_PLAN;
        }
        if (i == 2) {
            return CURRENT_PLAN;
        }
        if (i == 3) {
            return UPCOMING_PLAN;
        }
        throw new IllegalArgumentException();
    }
}
