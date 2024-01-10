package com.trainerfu.android;

public enum RNEntryRoute {
    ML_APP_PICKER(1),
    MESSAGING(2),
    GROUPS(3),
    SELECT_GROUPS(4),
    SELECT_CLIENTS(5),
    USER_SETTINGS(6),
    TRAINERS(7),
    TRIGGERED_MESSAGING(8),
    NOTES(9),
    HABITS(10),
    CONTENT_VIEW(11);
    
    private final int mask;

    private RNEntryRoute(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static RNEntryRoute getEntryRoute(int i) {
        if (i == 1) {
            return ML_APP_PICKER;
        }
        if (i == 2) {
            return MESSAGING;
        }
        if (i == 3) {
            return GROUPS;
        }
        if (i == 4) {
            return SELECT_GROUPS;
        }
        if (i == 5) {
            return SELECT_CLIENTS;
        }
        if (i == 6) {
            return USER_SETTINGS;
        }
        if (i == 7) {
            return TRAINERS;
        }
        if (i == 8) {
            return TRIGGERED_MESSAGING;
        }
        if (i == 9) {
            return NOTES;
        }
        if (i == 10) {
            return HABITS;
        }
        if (i == 11) {
            return CONTENT_VIEW;
        }
        throw new IllegalArgumentException();
    }
}
