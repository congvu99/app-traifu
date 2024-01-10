package com.trainerfu.android;

public enum MoreFragmentViewType {
    TRAINER_VIEW(1),
    CLIENT_VIEW(2),
    CLIENT_MANAGEMENT_VIEW(3);
    
    private final int mask;

    private MoreFragmentViewType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static MoreFragmentViewType getMoreFragmentType(int i) {
        if (i == 1) {
            return TRAINER_VIEW;
        }
        if (i == 2) {
            return CLIENT_VIEW;
        }
        if (i == 3) {
            return CLIENT_MANAGEMENT_VIEW;
        }
        throw new IllegalArgumentException();
    }
}
