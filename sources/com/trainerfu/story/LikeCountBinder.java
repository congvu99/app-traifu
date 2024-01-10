package com.trainerfu.story;

import android.content.Context;
import android.view.View;
import com.trainerfu.android.R;

public class LikeCountBinder extends SectionPartBinder implements View.OnClickListener {
    private EventListener eventListener;
    private StoryBaseViewModel storyViewModel;

    public interface EventListener {
        void onLikeCountLabelClicked(int i);
    }

    public LikeCountBinder(Context context, StoryBaseViewModel storyBaseViewModel, EventListener eventListener2) {
        super(context);
        this.storyViewModel = storyBaseViewModel;
        this.eventListener = eventListener2;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof ClickableLabel) {
            ClickableLabel clickableLabel = (ClickableLabel) sectionPartView;
            int length = this.storyViewModel.getLikes().length();
            clickableLabel.setMargin(2);
            clickableLabel.setTextSize(14.0f);
            if (length == 1) {
                clickableLabel.setTitle(String.format("1 %s", new Object[]{getContext().getString(R.string.Like)}));
            } else {
                clickableLabel.setTitle(String.format("%d %s", new Object[]{Integer.valueOf(length), getContext().getString(R.string.Likes)}));
            }
            clickableLabel.setOnClickListener(this);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }

    public void onClick(View view) {
        EventListener eventListener2 = this.eventListener;
        if (eventListener2 != null) {
            eventListener2.onLikeCountLabelClicked(this.storyViewModel.getStoryId());
        }
    }
}
