package com.trainerfu.android;

public enum BrandedIAPTransactionType {
    NEW_PURCHASE(1),
    EXTENSION(2),
    REACTIVATION(3);
    
    private final int mask;

    private BrandedIAPTransactionType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static BrandedIAPTransactionType getBrandedIAPTransactionType(int i) {
        if (i == 1) {
            return NEW_PURCHASE;
        }
        if (i == 2) {
            return EXTENSION;
        }
        if (i == 3) {
            return REACTIVATION;
        }
        throw new IllegalArgumentException();
    }
}
