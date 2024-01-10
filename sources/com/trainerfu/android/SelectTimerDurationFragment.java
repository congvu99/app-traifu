package com.trainerfu.android;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class SelectTimerDurationFragment extends DialogFragment {
    /* access modifiers changed from: private */
    public NumberPicker minutesPicker;
    /* access modifiers changed from: private */
    public int minutesVal = 1;
    /* access modifiers changed from: private */
    public NumberPicker secondsPicker;
    /* access modifiers changed from: private */
    public int secondsVal = 1;
    private String[] secondsValues = {"0 seconds", "15 seconds", "30 seconds", "45 seconds"};

    public interface EventListener {
        void timerSurationSelected(int i, int i2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        getArguments();
        try {
            MaterialDialog build = new MaterialDialog.Builder(getActivity()).customView((int) R.layout.select_timer_duration_view, false).positiveText((int) R.string.start).negativeText((int) R.string.cancel).positiveColor(ContextCompat.getColor(getActivity(), R.color.tintColor)).negativeColor(ContextCompat.getColor(getActivity(), R.color.grayColor)).onPositive(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    SelectTimerDurationFragment.this.getActivity().getWindow().setSoftInputMode(3);
                    ViewGroup viewGroup = (ViewGroup) materialDialog.getCustomView();
                    ((EventListener) SelectTimerDurationFragment.this.getActivity()).timerSurationSelected(SelectTimerDurationFragment.this.minutesVal, SelectTimerDurationFragment.this.secondsVal * 15);
                }
            }).onNegative(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    SelectTimerDurationFragment.this.getActivity().getWindow().setSoftInputMode(3);
                }
            }).build();
            this.minutesPicker = (NumberPicker) build.getCustomView().findViewById(R.id.minutes_picker);
            NumberPicker numberPicker = (NumberPicker) build.getCustomView().findViewById(R.id.seconds_picker);
            this.secondsPicker = numberPicker;
            numberPicker.setDisplayedValues(this.secondsValues);
            this.secondsPicker.setMaxValue(this.secondsValues.length - 1);
            this.secondsPicker.setMinValue(0);
            this.secondsPicker.setValue(this.secondsVal);
            String[] strArr = new String[30];
            for (int i = 0; i < 30; i++) {
                strArr[i] = i + " minutes";
            }
            this.minutesPicker.setMinValue(0);
            this.minutesPicker.setMaxValue(29);
            this.minutesPicker.setDisplayedValues(strArr);
            this.minutesPicker.setValue(this.minutesVal);
            this.minutesPicker.setDescendantFocusability(393216);
            this.secondsPicker.setDescendantFocusability(393216);
            this.minutesPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    SelectTimerDurationFragment selectTimerDurationFragment = SelectTimerDurationFragment.this;
                    int unused = selectTimerDurationFragment.minutesVal = selectTimerDurationFragment.minutesPicker.getValue();
                }
            });
            this.secondsPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    SelectTimerDurationFragment selectTimerDurationFragment = SelectTimerDurationFragment.this;
                    int unused = selectTimerDurationFragment.secondsVal = selectTimerDurationFragment.secondsPicker.getValue();
                }
            });
            return build;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
