package com.trainerfu.story;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.trainerfu.android.BaseActivity;
import com.trainerfu.android.R;

public class StoryListActivity extends BaseActivity {
    public static int refreshStoryId;

    public StoryListActivity() {
        super(true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            StoryListFragment storyListFragment = new StoryListFragment();
            Bundle bundle2 = new Bundle();
            Bundle extras = getIntent().getExtras();
            StoryListViewType storyListViewType = StoryListViewType.getStoryListViewType(extras.getInt("story_list_view_type"));
            if (storyListViewType == StoryListViewType.PROGRESS_PHOTOS_VIEW) {
                setTitle(getString(R.string.ProgressPhotos));
            } else if (storyListViewType == StoryListViewType.CHECKINS_VIEW) {
                setTitle("Checkins");
            } else {
                setTitle(getString(R.string.News));
            }
            bundle2.putInt("story_list_view_type", storyListViewType.getMask());
            if (extras.containsKey("story_id")) {
                refreshStoryId = 0;
                bundle2.putInt("story_id", extras.getInt("story_id"));
            }
            if (extras.containsKey("diary_user_id")) {
                bundle2.putInt("diary_user_id", extras.getInt("diary_user_id"));
            }
            if (extras.containsKey("story_type_filter")) {
                bundle2.putInt("story_type_filter", extras.getInt("story_type_filter"));
            }
            storyListFragment.setArguments(bundle2);
            getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) storyListFragment, "slf").commit();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private StoryListFragment getSLF() {
        return (StoryListFragment) getSupportFragmentManager().findFragmentByTag("slf");
    }

    public static int getRefreshStoryId() {
        return refreshStoryId;
    }
}
