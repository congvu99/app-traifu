package com.trainerfu.story;

public enum StoryListViewType {
    NEWS_VIEW(1),
    DIARY_VIEW(2),
    SINGLE_STORY_VIEW(3),
    PROGRESS_PHOTOS_VIEW(4),
    CHECKINS_VIEW(5);
    
    private final int mask;

    private StoryListViewType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static StoryListViewType getStoryListViewType(int i) {
        if (i == 1) {
            return NEWS_VIEW;
        }
        if (i == 2) {
            return DIARY_VIEW;
        }
        if (i == 3) {
            return SINGLE_STORY_VIEW;
        }
        if (i == 4) {
            return PROGRESS_PHOTOS_VIEW;
        }
        if (i == 5) {
            return CHECKINS_VIEW;
        }
        throw new IllegalArgumentException();
    }
}
