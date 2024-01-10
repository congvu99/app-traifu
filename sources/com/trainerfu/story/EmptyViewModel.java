package com.trainerfu.story;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class EmptyViewModel extends SectionBaseViewModel {
    private StoryType filter;

    public EmptyViewModel(Context context, StoryType storyType) {
        super(context);
        this.filter = storyType;
    }

    public List<SectionPartDefinition> getParts() {
        ArrayList arrayList = new ArrayList();
        addSectionSeparator(arrayList);
        if (this.filter == StoryType.CHECKIN) {
            arrayList.add(new SectionPartDefinition(EmptyView.class, new EmptyViewBinder(getContext(), true)));
        } else {
            arrayList.add(new SectionPartDefinition(EmptyView.class, new EmptyViewBinder(getContext(), false)));
        }
        return arrayList;
    }
}
