package com.trainerfu.story;

import android.content.Context;
import com.trainerfu.story.ToolbarView;
import org.json.JSONArray;
import org.json.JSONException;

public class ToolbarBinder extends SectionPartBinder {
    private ToolbarView.EventListener eventListener;
    private StoryBaseViewModel viewModel;

    public ToolbarBinder(Context context, StoryBaseViewModel storyBaseViewModel, ToolbarView.EventListener eventListener2) {
        super(context);
        this.viewModel = storyBaseViewModel;
        this.eventListener = eventListener2;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof ToolbarView) {
            ToolbarView toolbarView = (ToolbarView) sectionPartView;
            toolbarView.setStoryId(this.viewModel.getStoryId());
            toolbarView.setShowCommentBtn(this.viewModel.areCommentsEnabled());
            StoryBaseViewModel storyBaseViewModel = this.viewModel;
            boolean z = true;
            if (storyBaseViewModel instanceof ProgressPhotoStoryViewModel) {
                ProgressPhotoStoryViewModel progressPhotoStoryViewModel = (ProgressPhotoStoryViewModel) storyBaseViewModel;
                if (progressPhotoStoryViewModel.hasNext() || progressPhotoStoryViewModel.hasPrev()) {
                    toolbarView.setShowPrevNextBtn(true, progressPhotoStoryViewModel.hasPrev(), progressPhotoStoryViewModel.hasNext(), progressPhotoStoryViewModel.showProgressPhotoTooltip());
                } else {
                    toolbarView.setShowPrevNextBtn(false, false, false, false);
                }
            } else {
                toolbarView.setShowPrevNextBtn(false, false, false, false);
            }
            JSONArray likes = this.viewModel.getLikes();
            int i = 0;
            while (true) {
                if (i >= likes.length()) {
                    z = false;
                    break;
                }
                try {
                    if (likes.getJSONObject(i).getInt("user_id") == this.viewModel.getMyUserId()) {
                        break;
                    }
                    i++;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            toolbarView.setLiked(z);
            ToolbarView.EventListener eventListener2 = this.eventListener;
            if (eventListener2 != null) {
                toolbarView.setEventListener(eventListener2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
