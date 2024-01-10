package com.trainerfu.story;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.trainerfu.story.StoryTitleView;
import com.trainerfu.utils.DateUtils;
import org.json.JSONException;

public class StoryTitleViewBinder extends StoryBasePartBinder {
    private StoryTitleView.EventListener eventListener;
    private boolean isNewsModerated;
    private StoryBaseViewModel viewModel;

    public StoryTitleViewBinder(Context context, StoryBaseViewModel storyBaseViewModel, boolean z, StoryTitleView.EventListener eventListener2) {
        super(context);
        this.viewModel = storyBaseViewModel;
        this.isNewsModerated = z;
        this.eventListener = eventListener2;
    }

    public void bind(SectionPartView sectionPartView) {
        if (sectionPartView instanceof StoryTitleView) {
            StoryTitleView storyTitleView = (StoryTitleView) sectionPartView;
            try {
                if (this.viewModel.getState().isNull("photo_id")) {
                    storyTitleView.setPhoto(0);
                } else {
                    storyTitleView.setPhoto(this.viewModel.getState().getInt("photo_id"));
                }
                storyTitleView.setStoryId(this.viewModel.getStoryId());
                storyTitleView.setHasMoreOptions(this.viewModel.hasMoreOptions());
                storyTitleView.setUserId(this.viewModel.getUserId());
                storyTitleView.setUserName(this.viewModel.getState().getString("first_name"));
                StoryListViewType storyListViewType = this.viewModel.getStoryListViewType();
                Boolean valueOf = Boolean.valueOf(this.viewModel.isViewedByTrainer());
                StoryType storyType = this.viewModel.getStoryType();
                Spanned fromHtml = Html.fromHtml(String.format(getContext().getString(getContext().getResources().getIdentifier(String.format("story_type_%d_title", new Object[]{Integer.valueOf(storyType.getMask())}), TypedValues.Custom.S_STRING, getContext().getPackageName())), new Object[]{this.viewModel.getState().getString("first_name")}));
                if (valueOf.booleanValue()) {
                    if (storyListViewType != StoryListViewType.NEWS_VIEW) {
                        if (storyListViewType != StoryListViewType.SINGLE_STORY_VIEW) {
                            storyTitleView.setTitle(fromHtml, false);
                        }
                    }
                    storyTitleView.setTitle(fromHtml, true);
                } else {
                    storyTitleView.setTitle(fromHtml, false);
                }
                String str = "";
                if (storyType == StoryType.WORKOUT_LOG) {
                    str = this.viewModel.getMeta().getString("log_date");
                } else if (storyType == StoryType.ASSESSMENT) {
                    str = this.viewModel.getMeta().getString("da");
                } else if (storyType == StoryType.MEAL_LOG) {
                    str = this.viewModel.getMeta().getString("d");
                } else if (storyType == StoryType.PROGRESS_PHOTO) {
                    str = this.viewModel.getMeta().getString("da");
                } else if (storyType == StoryType.LINK) {
                    str = this.viewModel.getMeta().getString("da");
                } else if (storyType == StoryType.POST) {
                    str = this.viewModel.getMeta().getString("da");
                } else if (storyType == StoryType.CHECKIN) {
                    try {
                        str = this.viewModel.getMeta().getString("cd");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new RuntimeException("Not supported story type");
                }
                storyTitleView.setSubtitle(DateUtils.getDisplayDate(getContext(), DateUtils.getDateFromISOFormat(str)));
                boolean z = this.viewModel.getState().getBoolean("pinned");
                boolean z2 = !this.viewModel.getState().getBoolean("is_public");
                boolean z3 = this.isNewsModerated && this.viewModel.getState().getBoolean("show_to_everyone");
                if (z) {
                    storyTitleView.setIcon(StoryTitleView.Icon.PINNED);
                } else if (z2) {
                    storyTitleView.setIcon(StoryTitleView.Icon.PRIVATE);
                } else if (z3) {
                    storyTitleView.setIcon(StoryTitleView.Icon.SHOWN_TO_EVERYONE);
                } else {
                    storyTitleView.setIcon(StoryTitleView.Icon.NONE);
                }
                if (this.viewModel.isPinned()) {
                    storyTitleView.togglePinnedBorder(true);
                } else {
                    storyTitleView.togglePinnedBorder(false);
                }
                StoryTitleView.EventListener eventListener2 = this.eventListener;
                if (eventListener2 != null) {
                    storyTitleView.setEventListener(eventListener2);
                }
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            throw new IllegalArgumentException("Invalid view");
        }
    }
}
