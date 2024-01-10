package com.trainerfu.story;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.flexbox.FlexboxLayout;
import com.trainerfu.android.MyApplication;
import com.trainerfu.android.R;
import com.trainerfu.utils.Util;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AchievementSummaryView extends SectionPartView {
    public static Drawable goalUnlocked;
    public static Drawable log100Workouts;
    public static Drawable log1stWorkout;
    public static Drawable log25Workouts;
    public static Drawable log75Workouts;
    public static Drawable perfectHalfYear;
    public static Drawable perfectMonth;
    public static Drawable perfectQuarter;
    public static Drawable perfectWeek;
    public static Drawable perfectYear;
    public static Drawable personalRecord;
    private LinearLayout achievementSummaryView;
    private Context context;

    static {
        Context appContext = MyApplication.getAppContext();
        log25Workouts = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.log_25_workouts, (Resources.Theme) null);
        log75Workouts = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.log_75_workouts, (Resources.Theme) null);
        log100Workouts = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.log_100_workouts, (Resources.Theme) null);
        log1stWorkout = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.logged_1st_workout, (Resources.Theme) null);
        personalRecord = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.personal_record, (Resources.Theme) null);
        perfectWeek = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.perfect_week, (Resources.Theme) null);
        perfectMonth = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.perfect_month, (Resources.Theme) null);
        perfectQuarter = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.perfect_quarter, (Resources.Theme) null);
        perfectHalfYear = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.perfect_half_year, (Resources.Theme) null);
        perfectYear = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.perfect_year, (Resources.Theme) null);
        goalUnlocked = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.goal_unlocked, (Resources.Theme) null);
    }

    public AchievementSummaryView(Context context2) {
        this(context2, (AttributeSet) null);
    }

    public AchievementSummaryView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public AchievementSummaryView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        initializeViews(context2);
    }

    private void initializeViews(Context context2) {
        ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(R.layout.achievement_summary_view, this);
        this.achievementSummaryView = (LinearLayout) findViewById(R.id.achievement_summary);
    }

    public void setAchievements(List<JSONObject> list) {
        this.achievementSummaryView.removeAllViews();
        FlexboxLayout flexboxLayout = new FlexboxLayout(this.context);
        flexboxLayout.setLayoutParams(new FlexboxLayout.LayoutParams(-1, -2));
        flexboxLayout.setFlexDirection(0);
        flexboxLayout.setFlexWrap(1);
        flexboxLayout.setAlignItems(0);
        int i = 0;
        while (i < list.size()) {
            ImageView imageView = new ImageView(this.context);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(Util.sizeInPx(this.context, 40), Util.sizeInPx(this.context, 60)));
            flexboxLayout.addView(imageView);
            Util.setMargins(imageView, 0, 0, Util.sizeInPx(this.context, 30), 0);
            try {
                AchievementType achievementType = AchievementType.getAchievementType(list.get(i).getInt("type"));
                if (achievementType == AchievementType.PR) {
                    imageView.setImageDrawable(goalUnlocked);
                } else if (achievementType == AchievementType.LOGGED_1ST_WORKOUT) {
                    imageView.setImageDrawable(log1stWorkout);
                } else if (achievementType == AchievementType.PERFECT_WEEK) {
                    imageView.setImageDrawable(perfectWeek);
                } else if (achievementType == AchievementType.PERFECT_MONTH) {
                    imageView.setImageDrawable(perfectMonth);
                } else if (achievementType == AchievementType.PERFECT_QUARTER) {
                    imageView.setImageDrawable(perfectQuarter);
                } else if (achievementType == AchievementType.PERFECT_HALF_YEAR) {
                    imageView.setImageDrawable(perfectHalfYear);
                } else if (achievementType == AchievementType.PERFECT_YEAR) {
                    imageView.setImageDrawable(perfectYear);
                } else if (achievementType == AchievementType.LOGGED_25X_WORKOUTS) {
                    int i2 = list.get(i).getInt("ref_id1") * 25;
                    if (i2 == 25) {
                        imageView.setImageDrawable(log25Workouts);
                    } else if (i2 == 75) {
                        imageView.setImageDrawable(log75Workouts);
                    } else if (i2 == 100) {
                        imageView.setImageDrawable(log100Workouts);
                    } else {
                        imageView.setImageDrawable(goalUnlocked);
                    }
                } else if (achievementType == AchievementType.GOAL_UNLOCKED) {
                    imageView.setImageDrawable(goalUnlocked);
                }
                i++;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        this.achievementSummaryView.addView(flexboxLayout);
    }
}
