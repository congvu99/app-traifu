package com.trainerfu.android;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import io.intercom.android.sdk.models.Part;

public class WorkoutOptionsDialogFragment extends BottomSheetDialogFragment {
    /* access modifiers changed from: private */
    public WorkoutPlanDayFragment callBack;
    private Boolean forClientPlan;
    private String note;
    private WorkoutPlanDayViewType viewType;

    public static WorkoutOptionsDialogFragment newInstance() {
        return new WorkoutOptionsDialogFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.callBack = (WorkoutPlanDayFragment) getTargetFragment();
        Bundle arguments = getArguments();
        this.forClientPlan = Boolean.valueOf(arguments.getBoolean("for_client_plan"));
        this.note = arguments.getString(Part.NOTE_MESSAGE_STYLE);
        this.viewType = WorkoutPlanDayViewType.getViewType(arguments.getInt("view_type"));
        View inflate = layoutInflater.inflate(R.layout.workout_options, viewGroup, false);
        WorkoutOptionsRowView workoutOptionsRowView = (WorkoutOptionsRowView) inflate.findViewById(R.id.add_note);
        WorkoutOptionsRowView workoutOptionsRowView2 = (WorkoutOptionsRowView) inflate.findViewById(R.id.add_superset);
        WorkoutOptionsRowView workoutOptionsRowView3 = (WorkoutOptionsRowView) inflate.findViewById(R.id.add_circuit);
        WorkoutOptionsRowView workoutOptionsRowView4 = (WorkoutOptionsRowView) inflate.findViewById(R.id.copy_workout);
        WorkoutOptionsRowView workoutOptionsRowView5 = (WorkoutOptionsRowView) inflate.findViewById(R.id.save_workout);
        WorkoutOptionsRowView workoutOptionsRowView6 = (WorkoutOptionsRowView) inflate.findViewById(R.id.track_workout);
        WorkoutOptionsRowView workoutOptionsRowView7 = (WorkoutOptionsRowView) inflate.findViewById(R.id.delete_exercise);
        if (this.note != null) {
            workoutOptionsRowView.setTitle("Edit Note");
        }
        workoutOptionsRowView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkoutOptionsDialogFragment.this.dismiss();
                WorkoutOptionsDialogFragment.this.callBack.addNotes();
            }
        });
        workoutOptionsRowView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkoutOptionsDialogFragment.this.dismiss();
                WorkoutOptionsDialogFragment.this.callBack.addExercise(1, ProgramDrillType.START_SUPERSET, 0);
            }
        });
        workoutOptionsRowView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkoutOptionsDialogFragment.this.dismiss();
                WorkoutOptionsDialogFragment.this.callBack.addExercise(1, ProgramDrillType.START_CIRCUIT, 0);
            }
        });
        workoutOptionsRowView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkoutOptionsDialogFragment.this.dismiss();
                WorkoutOptionsDialogFragment.this.callBack.copyWorkoutFromTemplate();
            }
        });
        workoutOptionsRowView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkoutOptionsDialogFragment.this.dismiss();
                WorkoutOptionsDialogFragment.this.callBack.saveToNewTemplate();
            }
        });
        workoutOptionsRowView6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkoutOptionsDialogFragment.this.dismiss();
                WorkoutOptionsDialogFragment.this.callBack.trackClientWorkout();
            }
        });
        workoutOptionsRowView7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WorkoutOptionsDialogFragment.this.dismiss();
                WorkoutOptionsDialogFragment.this.callBack.deleteOrReorder();
            }
        });
        if (this.viewType == WorkoutPlanDayViewType.EDITING_TEMPLATE) {
            workoutOptionsRowView4.setVisibility(8);
            workoutOptionsRowView5.setVisibility(8);
            workoutOptionsRowView6.setVisibility(8);
        }
        if (!this.forClientPlan.booleanValue()) {
            workoutOptionsRowView6.setVisibility(8);
        }
        return inflate;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(bundle);
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from((FrameLayout) ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet)).setState(3);
            }
        });
        return bottomSheetDialog;
    }
}
