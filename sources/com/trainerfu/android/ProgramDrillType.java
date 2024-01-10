package com.trainerfu.android;

public enum ProgramDrillType {
    EXERCISE(1),
    START_SUPERSET(2),
    END_SUPERSET(3),
    START_CIRCUIT(4),
    END_CIRCUIT(5);
    
    private final int mask;

    private ProgramDrillType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static ProgramDrillType get(int i) {
        if (i == 1) {
            return EXERCISE;
        }
        if (i == 2) {
            return START_SUPERSET;
        }
        if (i == 3) {
            return END_SUPERSET;
        }
        if (i == 4) {
            return START_CIRCUIT;
        }
        if (i == 5) {
            return END_CIRCUIT;
        }
        throw new IllegalArgumentException();
    }
}
