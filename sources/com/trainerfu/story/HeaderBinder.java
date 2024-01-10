package com.trainerfu.story;

import android.content.Context;
import com.trainerfu.story.HeaderView;

public class HeaderBinder extends SectionPartBinder {
    private HeaderView.EventListener eventListener;
    private boolean isViewedByTrainer;
    private StoryListViewType listViewType;

    public HeaderBinder(Context context, StoryListViewType storyListViewType, HeaderView.EventListener eventListener2, boolean z) {
        super(context);
        this.listViewType = storyListViewType;
        this.eventListener = eventListener2;
        this.isViewedByTrainer = z;
        if (storyListViewType == StoryListViewType.SINGLE_STORY_VIEW) {
            throw new IllegalArgumentException("Invalid story list view");
        }
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof HeaderView) {
            HeaderView headerView = (HeaderView) sectionPartView;
            headerView.setEventListener(this.eventListener);
            if (this.listViewType == StoryListViewType.NEWS_VIEW) {
                headerView.setNewPostButtonVisibility(true);
                headerView.setLogWorkoutButtonVisibility(false);
                headerView.setAddAProgressPhotoButtonVisibility(false);
                headerView.setClientBtnsVisibility(false);
            } else if (this.listViewType == StoryListViewType.DIARY_VIEW) {
                headerView.setNewPostButtonVisibility(false);
                headerView.setLogWorkoutButtonVisibility(true);
                headerView.setAddAProgressPhotoButtonVisibility(false);
            } else if (this.listViewType == StoryListViewType.PROGRESS_PHOTOS_VIEW) {
                headerView.setNewPostButtonVisibility(false);
                headerView.setLogWorkoutButtonVisibility(false);
                headerView.setAddAProgressPhotoButtonVisibility(true);
            } else if (this.listViewType == StoryListViewType.CHECKINS_VIEW) {
                headerView.setNewPostButtonVisibility(false);
                headerView.setAssignHabitButtonVisibility(true);
            }
            if (this.listViewType == StoryListViewType.DIARY_VIEW && this.isViewedByTrainer) {
                headerView.hideNewPostButton();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
