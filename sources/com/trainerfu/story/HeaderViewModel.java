package com.trainerfu.story;

import android.content.Context;
import com.trainerfu.story.HeaderView;
import java.util.ArrayList;
import java.util.List;

public class HeaderViewModel extends SectionBaseViewModel {
    private HeaderView.EventListener eventListener;
    private boolean isViewedByTrainer;
    private StoryListViewType listViewType;

    public HeaderViewModel(Context context, StoryListViewType storyListViewType, HeaderView.EventListener eventListener2, boolean z) {
        super(context);
        this.listViewType = storyListViewType;
        this.eventListener = eventListener2;
        this.isViewedByTrainer = z;
        if (storyListViewType == StoryListViewType.SINGLE_STORY_VIEW) {
            throw new IllegalArgumentException("Invalid story list view");
        }
    }

    public List<SectionPartDefinition> getParts() {
        ArrayList arrayList = new ArrayList();
        if (checkIsTablet()) {
            addSectionSeparator(arrayList);
        }
        arrayList.add(new SectionPartDefinition(HeaderView.class, new HeaderBinder(getContext(), this.listViewType, this.eventListener, this.isViewedByTrainer)));
        addSectionSeparator(arrayList);
        return arrayList;
    }
}
