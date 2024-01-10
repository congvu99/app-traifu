package com.trainerfu.android;

public enum PlanDrillViewType {
    FOR_TRACKING(1),
    FOR_EDITING(2),
    FOR_DELETING_AND_REORDERING(3);
    
    private final int mask;

    private PlanDrillViewType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static PlanDrillViewType getViewType(int i) {
        if (i == 1) {
            return FOR_TRACKING;
        }
        if (i == 2) {
            return FOR_EDITING;
        }
        if (i == 3) {
            return FOR_DELETING_AND_REORDERING;
        }
        throw new IllegalArgumentException();
    }
}
