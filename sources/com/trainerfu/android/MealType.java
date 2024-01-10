package com.trainerfu.android;

public enum MealType {
    BREAKFAST(1),
    LUNCH(2),
    DINNER(3),
    SNACK(4);
    
    private final int mask;

    private MealType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static MealType getMealType(int i) {
        if (i == 1) {
            return BREAKFAST;
        }
        if (i == 2) {
            return LUNCH;
        }
        if (i == 3) {
            return DINNER;
        }
        if (i == 4) {
            return SNACK;
        }
        throw new IllegalArgumentException();
    }
}
