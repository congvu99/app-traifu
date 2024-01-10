package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.android.R;

public class HeaderView extends SectionPartView implements View.OnClickListener {
    private EventListener eventListener;

    public interface EventListener {
        void onAddANewProgressPhotoClicked();

        void onAssignHabitClicked();

        void onLogWorkoutClicked();

        void onNewPostClicked();
    }

    public HeaderView(Context context) {
        this(context, (AttributeSet) null);
    }

    public HeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.section_header_view, this);
        ((LinearLayout) findViewById(R.id.add_post_view)).setOnClickListener(this);
        ((IconTextView) findViewById(R.id.post_workout_btn)).setOnClickListener(this);
        ((IconTextView) findViewById(R.id.log_workout_btn)).setOnClickListener(this);
        ((IconTextView) findViewById(R.id.add_progress_photo_btn)).setOnClickListener(this);
        ((IconTextView) findViewById(R.id.assign_habit_btn)).setOnClickListener(this);
    }

    public void setEventListener(EventListener eventListener2) {
        this.eventListener = eventListener2;
    }

    public void setNewPostButtonVisibility(boolean z) {
        findViewById(R.id.add_post_view).setVisibility(z ? 0 : 8);
    }

    public void setLogWorkoutButtonVisibility(boolean z) {
        findViewById(R.id.log_workout_btn).setVisibility(z ? 0 : 8);
        findViewById(R.id.client_btns).setVisibility(0);
    }

    public void setAddAProgressPhotoButtonVisibility(boolean z) {
        int i = 8;
        findViewById(R.id.post_workout_btn).setVisibility(!z ? 0 : 8);
        findViewById(R.id.client_btns).setVisibility(0);
        View findViewById = findViewById(R.id.add_progress_photo_btn);
        if (z) {
            i = 0;
        }
        findViewById.setVisibility(i);
    }

    public void setAssignHabitButtonVisibility(boolean z) {
        int i = 0;
        findViewById(R.id.client_btns).setVisibility(0);
        findViewById(R.id.post_workout_btn).setVisibility(!z ? 0 : 8);
        View findViewById = findViewById(R.id.assign_habit_btn);
        if (!z) {
            i = 8;
        }
        findViewById.setVisibility(i);
    }

    public void setClientBtnsVisibility(boolean z) {
        findViewById(R.id.client_btns).setVisibility(z ? 0 : 8);
    }

    public void hideNewPostButton() {
        findViewById(R.id.post_workout_btn).setVisibility(8);
    }

    public void onClick(View view) {
        if (this.eventListener != null) {
            if (view.getId() == R.id.add_post_view || view.getId() == R.id.post_workout_btn) {
                this.eventListener.onNewPostClicked();
            } else if (view.getId() == R.id.log_workout_btn) {
                this.eventListener.onLogWorkoutClicked();
            } else if (view.getId() == R.id.add_progress_photo_btn) {
                this.eventListener.onAddANewProgressPhotoClicked();
            } else if (view.getId() == R.id.assign_habit_btn) {
                this.eventListener.onAssignHabitClicked();
            }
        }
    }
}
