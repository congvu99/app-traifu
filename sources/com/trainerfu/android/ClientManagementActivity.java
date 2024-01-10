package com.trainerfu.android;

import android.os.Bundle;
import com.trainerfu.android.TabHostActivity;
import com.trainerfu.story.StoryListFragment;
import com.trainerfu.story.StoryListViewType;
import com.trainerfu.story.StoryType;
import java.util.ArrayList;

public class ClientManagementActivity extends TabHostActivityWithDiary {
    /* access modifiers changed from: protected */
    public int getDiaryTabIndex() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public int getNewsTabIndex() {
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int getNotificationTabIndex() {
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean hasNewsTab() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean hasNotificationTab() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<TabHostActivity.TabDefinition> getTabDefinition(Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        int i = extras.getInt("client_id");
        String string = extras.getString("client_first_name");
        StoryType storyType = (extras == null || !extras.containsKey("selected_diary_filter") || extras.getInt("selected_diary_filter") != R.id.checkins) ? null : StoryType.CHECKIN;
        ArrayList<TabHostActivity.TabDefinition> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("context_user_id", i);
        bundle2.putBoolean("for_client_plan", true);
        bundle2.putBoolean("viewed_by_client", false);
        bundle2.putString("context_user_first_name", string);
        arrayList.add(new TabHostActivity.TabDefinition("wpf", WorkoutPlanListFragment.class.getName(), R.string.planTab, R.drawable.ic_event_note_black_24dp, bundle2, new WorkoutPlanListFragment()));
        Bundle bundle3 = new Bundle();
        bundle3.putInt("story_list_view_type", StoryListViewType.DIARY_VIEW.getMask());
        bundle3.putInt("diary_user_id", i);
        bundle3.putString("context_user_first_name", string);
        if (storyType != null) {
            bundle3.putInt("story_type_filter", storyType.getMask());
        }
        arrayList.add(new TabHostActivity.TabDefinition("df", StoryListFragment.class.getName(), R.string.diaryTab, R.drawable.ic_book_black_24dp, bundle3, new StoryListFragment()));
        Bundle bundle4 = new Bundle();
        bundle4.putInt("client_id", i);
        bundle4.putInt("view_type", MoreFragmentViewType.CLIENT_MANAGEMENT_VIEW.getMask());
        bundle4.putString("context_user_first_name", string);
        arrayList.add(new TabHostActivity.TabDefinition("mf", MoreFragment.class.getName(), R.string.moreTab, R.drawable.ic_menu_black_24dp, bundle4, new MoreFragment()));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public StoryListFragment getDiaryFragment() {
        getSupportFragmentManager();
        return (StoryListFragment) getSupportFragmentManager().getFragments().get(1);
    }
}
