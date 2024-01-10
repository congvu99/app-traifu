package com.trainerfu.story;

import android.content.Context;
import android.os.Bundle;
import com.trainerfu.android.R;
import com.trainerfu.story.LikeCountBinder;
import com.trainerfu.story.LikesDetailBinder;
import com.trainerfu.story.ShowMoreCommentsBinder;
import com.trainerfu.story.StoryTitleView;
import com.trainerfu.story.ToolbarView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class StoryBaseViewModel extends SectionBaseViewModel {
    private Bundle bundle;
    private boolean commentsEnabled = false;
    private boolean expandComments = false;
    private boolean hasMoreOptions = false;
    private boolean isNewsModerated = false;
    private LikeCountBinder.EventListener likeCountEventListener;
    private LikesDetailBinder.EventListener likeDetailBinderListener;
    private String myFirstName = "";
    private int myUserId = 0;
    private boolean sharingEnabled = false;
    private ShowMoreCommentsBinder.EventListener showMoreCommentsListener;
    private JSONObject state;
    private StoryListViewType storyListViewType;
    private StoryTitleView.EventListener storyTitleViewEventListener;
    private ToolbarView.EventListener toolbarEventListener;

    public StoryBaseViewModel(Context context, JSONObject jSONObject) {
        super(context);
        this.state = jSONObject;
    }

    public StoryBaseViewModel(Context context, JSONObject jSONObject, Bundle bundle2) {
        super(context);
        this.state = jSONObject;
        this.bundle = bundle2;
    }

    public JSONObject getState() {
        return this.state;
    }

    public StoryListViewType getStoryListViewType() {
        Bundle bundle2 = this.bundle;
        if (bundle2 == null || !bundle2.containsKey("story_list_view_type")) {
            return null;
        }
        return StoryListViewType.getStoryListViewType(this.bundle.getInt("story_list_view_type"));
    }

    public boolean isViewedByTrainer() {
        Bundle bundle2 = this.bundle;
        if (bundle2 == null || !bundle2.containsKey("is_viewed_by_trainer")) {
            return false;
        }
        return this.bundle.getBoolean("is_viewed_by_trainer");
    }

    public void setToolbarEventListener(ToolbarView.EventListener eventListener) {
        this.toolbarEventListener = eventListener;
    }

    public ToolbarView.EventListener getToolbarEventListener() {
        return this.toolbarEventListener;
    }

    public void setLikeCountEventListener(LikeCountBinder.EventListener eventListener) {
        this.likeCountEventListener = eventListener;
    }

    public LikeCountBinder.EventListener getLikeCountEventListener() {
        return this.likeCountEventListener;
    }

    public void setStoryTitleViewEventListener(StoryTitleView.EventListener eventListener) {
        this.storyTitleViewEventListener = eventListener;
    }

    public StoryTitleView.EventListener getStoryTitleViewEventListener() {
        return this.storyTitleViewEventListener;
    }

    public void setShowMoreCommentsListener(ShowMoreCommentsBinder.EventListener eventListener) {
        this.showMoreCommentsListener = eventListener;
    }

    public ShowMoreCommentsBinder.EventListener getShowMoreCommentsListener() {
        return this.showMoreCommentsListener;
    }

    public void setLikeDetailBinderListener(LikesDetailBinder.EventListener eventListener) {
        this.likeDetailBinderListener = eventListener;
    }

    public LikesDetailBinder.EventListener getLikeDetailBinderListener() {
        return this.likeDetailBinderListener;
    }

    public void setMyUserId(int i) {
        this.myUserId = i;
    }

    public void setMyFirstName(String str) {
        this.myFirstName = str;
    }

    public void setSharingEnabled(boolean z) {
        this.sharingEnabled = z;
    }

    public void setCommentsEnabled(boolean z) {
        this.commentsEnabled = z;
    }

    public void setExpandComments(boolean z) {
        this.expandComments = z;
    }

    public void setHasMoreOptions(boolean z) {
        this.hasMoreOptions = z;
    }

    public void setShowAllComments(boolean z) {
        try {
            getState().put("show_all_comments", z);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public StoryType getStoryType() {
        try {
            return StoryType.getStoryType(getState().getInt("story_type"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public int getStoryId() {
        try {
            return getState().getInt("story_id");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public int getUserId() {
        try {
            return getState().getInt("user_id");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUserFirstName() {
        try {
            return getState().getString("first_name");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject getMeta() {
        try {
            return getState().getJSONObject("story");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isPublic() {
        try {
            return getState().getBoolean("is_public");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setIsPublic(boolean z) {
        try {
            getState().put("is_public", z);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isPinned() {
        try {
            return getState().getBoolean("pinned");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setIsPinned(boolean z) {
        try {
            getState().put("pinned", z);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean showToEveryone() {
        try {
            return getState().getBoolean("show_to_everyone");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setShowToEveryone(boolean z) {
        try {
            getState().put("show_to_everyone", z);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray getLikes() {
        try {
            return getState().getJSONArray("likes");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray getComments() {
        try {
            return getState().getJSONArray("comments");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public int getMyUserId() {
        return this.myUserId;
    }

    public String getMyFirstName() {
        return this.myFirstName;
    }

    public Integer getMyPrimaryTrainerId() {
        if (getState().isNull("primary_trainer")) {
            return null;
        }
        try {
            return Integer.valueOf(getState().getInt("primary_trainer"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setExpandLikes(boolean z) {
        try {
            getState().put("expand_likes", z);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setIsNewsModerated(boolean z) {
        this.isNewsModerated = z;
    }

    public boolean isSharingEnabled() {
        return this.sharingEnabled;
    }

    public boolean hasMoreOptions() {
        return this.hasMoreOptions;
    }

    public boolean areCommentsEnabled() {
        return this.commentsEnabled;
    }

    public boolean isNewsModerated() {
        return this.isNewsModerated;
    }

    public boolean showAllComments() {
        try {
            if (getState().has("show_all_comments")) {
                return getState().getBoolean("show_all_comments");
            }
            return false;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean expandLikes() {
        try {
            if (getState().has("expand_likes")) {
                return getState().getBoolean("expand_likes");
            }
            return false;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> partIndexesForSharing() {
        List<SectionPartDefinition> parts = getParts();
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < parts.size(); i++) {
            SectionPartDefinition sectionPartDefinition = parts.get(i);
            if (!sectionPartDefinition.getPartViewClass().equals(ClickableLabel.class)) {
                if (sectionPartDefinition.getPartViewClass().equals(ToolbarView.class)) {
                    break;
                }
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    public void addFooter(List<SectionPartDefinition> list) {
        List<SectionPartDefinition> list2 = list;
        list2.add(new SectionPartDefinition(ToolbarView.class, new ToolbarBinder(getContext(), this, getToolbarEventListener())));
        int i = 20;
        if (getLikes().length() > 0 || getComments().length() > 0) {
            if (getLikes().length() > 0) {
                addWhiteSpace(list2, 15);
                list2.add(new SectionPartDefinition(SectionIconTextView.class, new LikesDetailBinder(getContext(), this, getLikeDetailBinderListener())));
            }
            if (getComments().length() > 0) {
                JSONArray comments = getComments();
                Bundle bundle2 = this.bundle;
                if (bundle2 != null && bundle2.containsKey("story_list_view_type")) {
                    StoryListViewType storyListViewType2 = StoryListViewType.getStoryListViewType(this.bundle.getInt("story_list_view_type"));
                    StoryListViewType storyListViewType3 = StoryListViewType.SINGLE_STORY_VIEW;
                    int i2 = R.color.veryLightBackground;
                    if (storyListViewType2 == storyListViewType3) {
                        addWhiteSpace(list2, 20);
                        list2.add(new SectionPartDefinition(DividerView.class, new DividerBinder(getContext(), true)));
                        list2.add(new SectionPartDefinition(SeparatorView.class, new SeparatorBinder(getContext(), 25, R.color.veryLightBackground)));
                    } else {
                        addWhiteSpace(list2, 15);
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= comments.length()) {
                            break;
                        }
                        if (storyListViewType2 != StoryListViewType.DIARY_VIEW && storyListViewType2 != StoryListViewType.NEWS_VIEW && storyListViewType2 != StoryListViewType.CHECKINS_VIEW) {
                            try {
                                list2.add(new SectionPartDefinition(CommentView.class, new CommentBinder(getContext(), comments.getJSONObject(i3), true)));
                                list2.add(new SectionPartDefinition(SeparatorView.class, new SeparatorBinder(getContext(), i, i2)));
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        } else if (!this.expandComments) {
                            try {
                                list2.add(new SectionPartDefinition(CommentView.class, new CommentBinder(getContext(), comments.getJSONObject(i3), false)));
                                addWhiteSpace(list2, 5);
                                if (comments.length() > 3 && i3 == 2) {
                                    list2.add(new SectionPartDefinition(ClickableLabel.class, new ShowMoreCommentsBinder(getContext(), getState(), getShowMoreCommentsListener(), comments.length() - 3)));
                                }
                                if (i3 == 2) {
                                    addWhiteSpace(list2, 25);
                                    break;
                                } else if (i3 == comments.length() - 1) {
                                    addWhiteSpace(list2, 25);
                                }
                            } catch (JSONException e2) {
                                throw new RuntimeException(e2);
                            }
                        } else {
                            try {
                                list2.add(new SectionPartDefinition(CommentView.class, new CommentBinder(getContext(), comments.getJSONObject(i3), false)));
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            addWhiteSpace(list2, 10);
                        }
                        i3++;
                        i = 20;
                        i2 = R.color.veryLightBackground;
                    }
                    if (storyListViewType2 == StoryListViewType.SINGLE_STORY_VIEW) {
                        list2.add(new SectionPartDefinition(SeparatorView.class, new SeparatorBinder(getContext(), 55, R.color.veryLightBackground)));
                        return;
                    }
                    return;
                }
                return;
            }
            addWhiteSpace(list2, 20);
            return;
        }
        addWhiteSpace(list2, 20);
    }
}
