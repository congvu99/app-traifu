package com.trainerfu.utils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import java.util.Calendar;

public class DatePickerFragmentOld extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private OnDateSetListener listener;
    private long maxDate;
    private long minDate;

    public interface OnDateSetListener {
        void onDateSet(DatePicker datePicker, int i, int i2, int i3);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.maxDate = arguments.getLong("max_date");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, instance.get(1), instance.get(2), instance.get(5));
        if (this.maxDate > 0) {
            datePickerDialog.getDatePicker().setMaxDate(this.maxDate);
        }
        if (this.minDate > 0) {
            datePickerDialog.getDatePicker().setMinDate(this.maxDate);
        }
        return datePickerDialog;
    }

    public void setOnDateSetListener(OnDateSetListener onDateSetListener) {
        this.listener = onDateSetListener;
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        OnDateSetListener onDateSetListener = this.listener;
        if (onDateSetListener != null) {
            onDateSetListener.onDateSet(datePicker, i, i2, i3);
        }
    }
}
