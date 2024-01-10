package com.trainerfu.android;

public enum WorkoutPlanDayViewType {
    TRACKING(1),
    EDITING_CLIENT_PLAN(2),
    EDITING_TEMPLATE(3);
    
    private final int mask;

    private WorkoutPlanDayViewType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static WorkoutPlanDayViewType getViewType(int i) {
        if (i == 1) {
            return TRACKING;
        }
        if (i == 2) {
            return EDITING_CLIENT_PLAN;
        }
        if (i == 3) {
            return EDITING_TEMPLATE;
        }
        throw new IllegalArgumentException();
    }
}
