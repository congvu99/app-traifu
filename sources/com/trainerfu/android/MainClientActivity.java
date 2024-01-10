package com.trainerfu.android;

import android.os.Bundle;
import com.trainerfu.android.TabHostActivity;
import com.trainerfu.story.StoryListFragment;
import com.trainerfu.story.StoryListViewType;
import java.util.ArrayList;

public class MainClientActivity extends TabHostActivityWithDiary {
    /* access modifiers changed from: protected */
    public int getDiaryTabIndex() {
        return 2;
    }

    /* access modifiers changed from: package-private */
    public int getNewsTabIndex() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public int getNotificationTabIndex() {
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean hasNewsTab() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean hasNotificationTab() {
        return false;
    }

    /* access modifiers changed from: protected */
    public ArrayList<TabHostActivity.TabDefinition> getTabDefinition(Bundle bundle) {
        ArrayList<TabHostActivity.TabDefinition> arrayList = new ArrayList<>();
        arrayList.add(new TabHostActivity.TabDefinition("hf", HomeFragment.class.getName(), R.string.homeTab, R.drawable.ic_home_black_24dp, (Bundle) null, new HomeFragment()));
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("for_client_plan", true);
        bundle2.putBoolean("viewed_by_client", true);
        arrayList.add(new TabHostActivity.TabDefinition("wpf", WorkoutPlanListFragment.class.getName(), R.string.planTab, R.drawable.plan_icon, bundle2, new WorkoutPlanListFragment()));
        Bundle bundle3 = new Bundle();
        bundle3.putInt("story_list_view_type", StoryListViewType.DIARY_VIEW.getMask());
        arrayList.add(new TabHostActivity.TabDefinition("df", StoryListFragment.class.getName(), R.string.diaryTab, R.drawable.diary_icon, bundle3, new StoryListFragment()));
        Bundle bundle4 = new Bundle();
        bundle4.putInt("story_list_view_type", StoryListViewType.NEWS_VIEW.getMask());
        arrayList.add(new TabHostActivity.TabDefinition("sf", StoryListFragment.class.getName(), R.string.newsTab, R.drawable.ic_language_black_24dp, bundle4, new StoryListFragment()));
        arrayList.add(new TabHostActivity.TabDefinition("mf", MoreFragment.class.getName(), R.string.moreTab, R.drawable.more_icon, (Bundle) null, new MoreFragment()));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public StoryListFragment getDiaryFragment() {
        getSupportFragmentManager();
        return (StoryListFragment) getSupportFragmentManager().getFragments().get(1);
    }
}
