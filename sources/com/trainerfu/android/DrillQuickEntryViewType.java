package com.trainerfu.android;

public enum DrillQuickEntryViewType {
    set(1),
    rep(2),
    weight(3),
    distance(4),
    duration(5),
    rest(6);
    
    int id;

    private DrillQuickEntryViewType(int i) {
        this.id = i;
    }

    static DrillQuickEntryViewType fromId(int i) {
        for (DrillQuickEntryViewType drillQuickEntryViewType : values()) {
            if (drillQuickEntryViewType.id == i) {
                return drillQuickEntryViewType;
            }
        }
        throw new IllegalArgumentException();
    }
}
