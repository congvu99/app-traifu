package com.trainerfu.android;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.viewpager.widget.ViewPager;
import com.trainerfu.android.TabHostActivity;
import com.trainerfu.story.StoryListFragment;
import com.trainerfu.story.StoryType;

public abstract class TabHostActivityWithDiary extends TabHostActivity {
    private int selectedDiaryFilter = R.id.all;

    /* access modifiers changed from: protected */
    public abstract StoryListFragment getDiaryFragment();

    /* access modifiers changed from: protected */
    public abstract int getDiaryTabIndex();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.selectedDiaryFilter = bundle.getInt("selected_diary_filter");
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("selected_diary_filter")) {
            this.selectedDiaryFilter = extras.getInt("selected_diary_filter");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("selected_diary_filter", this.selectedDiaryFilter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        String str;
        getMenuInflater().inflate(R.menu.diary_filter, menu);
        MenuItem findItem = menu.findItem(R.id.filter_item);
        if (getSelectedTabIndex() == getDiaryTabIndex()) {
            findItem.setVisible(true);
            int i = this.selectedDiaryFilter;
            if (i == R.id.all) {
                str = getString(R.string.All);
            } else if (i == R.id.workouts) {
                str = getString(R.string.Workouts);
            } else if (i == R.id.assessments) {
                str = getString(R.string.Assessments);
            } else if (i == R.id.meals) {
                str = getString(R.string.Meals);
            } else if (i == R.id.progress_photos) {
                str = getString(R.string.ProgressPhotos);
            } else if (i == R.id.checkins) {
                str = getString(R.string.Checkins);
            } else {
                str = i == R.id.post ? getString(R.string.Post) : " ";
            }
            findItem.setTitle(String.format("▼ %s ", new Object[]{str}));
            menu.findItem(this.selectedDiaryFilter).setChecked(true);
        } else {
            findItem.setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (menuItem.getGroupId() == R.id.sub_menu) {
            this.selectedDiaryFilter = menuItem.getItemId();
            StoryListFragment storyListFragment = (StoryListFragment) ((TabHostActivity.TabDefinition) this.tabs.get(viewPager.getCurrentItem())).fragment;
            int i = this.selectedDiaryFilter;
            if (i == R.id.all) {
                storyListFragment.setStoryTypeFilter((StoryType) null);
            } else if (i == R.id.workouts) {
                storyListFragment.setStoryTypeFilter(StoryType.WORKOUT_LOG);
            } else if (i == R.id.assessments) {
                storyListFragment.setStoryTypeFilter(StoryType.ASSESSMENT);
            } else if (i == R.id.meals) {
                storyListFragment.setStoryTypeFilter(StoryType.MEAL_LOG);
            } else if (i == R.id.progress_photos) {
                storyListFragment.setStoryTypeFilter(StoryType.PROGRESS_PHOTO);
            } else if (i == R.id.checkins) {
                storyListFragment.setStoryTypeFilter(StoryType.CHECKIN);
            } else if (i == R.id.post) {
                storyListFragment.setStoryTypeFilter(StoryType.POST);
            }
            invalidateOptionsMenu();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
