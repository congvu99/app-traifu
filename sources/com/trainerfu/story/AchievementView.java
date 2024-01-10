package com.trainerfu.story;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.ResourcesCompat;
import com.trainerfu.android.MyApplication;
import com.trainerfu.android.R;
import org.json.JSONException;
import org.json.JSONObject;

public class AchievementView extends SectionPartView {
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

    static {
        Context appContext = MyApplication.getAppContext();
        log25Workouts = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.log_25_workouts, (Resources.Theme) null);
        log75Workouts = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.log_75_workouts, (Resources.Theme) null);
        log100Workouts = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.log_100_workouts, (Resources.Theme) null);
        log1stWorkout = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.logged_1st_workout, (Resources.Theme) null);
        personalRecord = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.personal_record, (Resources.Theme) null);
        perfectWeek = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.perfect_week, (Resources.Theme) null);
        perfectMonth = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.perfect_week, (Resources.Theme) null);
        perfectQuarter = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.perfect_quarter, (Resources.Theme) null);
        perfectHalfYear = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.perfect_half_year, (Resources.Theme) null);
        perfectYear = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.perfect_year, (Resources.Theme) null);
        goalUnlocked = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.goal_unlocked, (Resources.Theme) null);
    }

    public AchievementView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AchievementView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AchievementView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.achievement_view, this);
    }

    public void setAchievement(JSONObject jSONObject) {
        String str;
        ImageView imageView = (ImageView) findViewById(R.id.badge_image_view);
        TextView textView = (TextView) findViewById(R.id.title_view);
        TextView textView2 = (TextView) findViewById(R.id.subtitle_view);
        textView2.setVisibility(0);
        textView2.setText("");
        try {
            AchievementType achievementType = AchievementType.getAchievementType(jSONObject.getInt("type"));
            if (achievementType == AchievementType.PR) {
                imageView.setImageDrawable(personalRecord);
                Integer valueOf = Integer.valueOf(jSONObject.getInt("count"));
                if (valueOf.intValue() == 1) {
                    str = String.format("%d PR Unlocked", new Object[]{valueOf});
                } else {
                    str = String.format("%d PRs Unlocked", new Object[]{valueOf});
                }
                textView.setText(str);
                textView2.setVisibility(8);
            } else if (achievementType == AchievementType.LOGGED_1ST_WORKOUT) {
                imageView.setImageDrawable(log1stWorkout);
                textView.setText(getContext().getString(R.string.logged1stWorkout));
                textView2.setVisibility(8);
            } else if (achievementType == AchievementType.PERFECT_WEEK) {
                imageView.setImageDrawable(perfectWeek);
                textView.setText(getContext().getString(R.string.unlockedPerfectWeek));
                textView2.setText(getContext().getString(R.string.unlockedPerfectWeekDetail));
            } else if (achievementType == AchievementType.PERFECT_MONTH) {
                String string = getContext().getString(getContext().getResources().getIdentifier(String.format("Month_%d_short", new Object[]{Integer.valueOf(jSONObject.getInt("ref_id1"))}), TypedValues.Custom.S_STRING, getContext().getPackageName()));
                imageView.setImageDrawable(perfectMonth);
                textView.setText(String.format(getContext().getString(R.string.unlockedPerfectMonth), new Object[]{string}));
                textView2.setText(getContext().getString(R.string.unlockedPerfectMonthDetail));
            } else if (achievementType == AchievementType.PERFECT_QUARTER) {
                String format = String.format("Q%d", new Object[]{Integer.valueOf(jSONObject.getInt("ref_id1"))});
                imageView.setImageDrawable(perfectQuarter);
                textView.setText(String.format(getContext().getString(R.string.unlockedPerfectQuarter), new Object[]{format}));
                textView2.setText(getContext().getString(R.string.unlockedPerfectQuarterDetail));
            } else if (achievementType == AchievementType.PERFECT_HALF_YEAR) {
                imageView.setImageDrawable(perfectHalfYear);
                if (jSONObject.getInt("ref_id1") == 1) {
                    textView.setText(getContext().getString(R.string.unlockedPerfectFirstHalfYear));
                } else {
                    textView.setText(getContext().getString(R.string.unlockedPerfectSecondHalfYear));
                }
                textView2.setText(getContext().getString(R.string.unlockedPerfectHalfYearDetail));
            } else if (achievementType == AchievementType.PERFECT_YEAR) {
                imageView.setImageDrawable(perfectYear);
                textView.setText(String.format(getContext().getString(R.string.unlockedPerfectYear), new Object[]{Integer.valueOf(jSONObject.getInt("ref_id1"))}));
                textView2.setText(getContext().getString(R.string.unlockedPerfectYearDetail));
            } else if (achievementType == AchievementType.LOGGED_25X_WORKOUTS) {
                int i = jSONObject.getInt("ref_id1") * 25;
                if (i == 25) {
                    imageView.setImageDrawable(log25Workouts);
                } else if (i == 75) {
                    imageView.setImageDrawable(log75Workouts);
                } else if (i == 100) {
                    imageView.setImageDrawable(log100Workouts);
                } else {
                    imageView.setImageDrawable(goalUnlocked);
                }
                textView.setText(String.format(getContext().getString(R.string.loggedNWorkouts), new Object[]{Integer.valueOf(i)}));
                textView2.setVisibility(8);
            } else if (achievementType == AchievementType.GOAL_UNLOCKED) {
                imageView.setImageDrawable(goalUnlocked);
                textView.setText(getContext().getString(R.string.goalUnlocked));
                textView2.setText(String.format("%s : %.1f", new Object[]{getContext().getString(R.string.Target), Double.valueOf(jSONObject.getDouble("ta"))}));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
