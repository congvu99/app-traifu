package com.trainerfu.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class DayOptionsDialogFragment extends BottomSheetDialogFragment {
    /* access modifiers changed from: private */
    public WorkoutPlanWeekFragment callBack;
    /* access modifiers changed from: private */
    public int dayOfWeek;

    public static DayOptionsDialogFragment newInstance() {
        return new DayOptionsDialogFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.callBack = (WorkoutPlanWeekFragment) getTargetFragment();
        this.dayOfWeek = getArguments().getInt("day");
        View inflate = layoutInflater.inflate(R.layout.fragment_day_options_dialog, viewGroup, false);
        ((LinearLayout) inflate.findViewById(R.id.copy_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DayOptionsDialogFragment.this.dismiss();
                DayOptionsDialogFragment.this.callBack.copyWorkout(DayOptionsDialogFragment.this.dayOfWeek);
            }
        });
        ((LinearLayout) inflate.findViewById(R.id.paste_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DayOptionsDialogFragment.this.dismiss();
                DayOptionsDialogFragment.this.callBack.pasteWorkout(DayOptionsDialogFragment.this.dayOfWeek);
            }
        });
        return inflate;
    }
}
