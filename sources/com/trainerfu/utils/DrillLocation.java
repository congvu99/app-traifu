package com.trainerfu.utils;

public enum DrillLocation {
    START_MARKER(1),
    END_MARKER(2),
    NON_GROUP_EXERCISE(3),
    GROUP_EXERCISE_NON_EDGE(4),
    GROUP_EXERCISE_FIRST(5),
    GROUP_EXERCISE_LAST(6);
    
    private final int mask;

    private DrillLocation(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static DrillLocation getViewType(int i) {
        if (i == 1) {
            return START_MARKER;
        }
        if (i == 2) {
            return END_MARKER;
        }
        if (i == 3) {
            return NON_GROUP_EXERCISE;
        }
        if (i == 4) {
            return GROUP_EXERCISE_NON_EDGE;
        }
        if (i == 5) {
            return GROUP_EXERCISE_FIRST;
        }
        if (i == 6) {
            return GROUP_EXERCISE_LAST;
        }
        throw new IllegalArgumentException();
    }
}
