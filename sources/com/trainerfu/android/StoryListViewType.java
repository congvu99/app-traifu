package com.trainerfu.android;

public enum StoryListViewType {
    WORLD_VIEW(1),
    DIARY_VIEW(2);
    
    private final int mask;

    private StoryListViewType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static StoryListViewType getStoryListViewType(int i) {
        if (i == 1) {
            return WORLD_VIEW;
        }
        if (i == 2) {
            return DIARY_VIEW;
        }
        throw new IllegalArgumentException();
    }
}
