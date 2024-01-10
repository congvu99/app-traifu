package com.trainerfu.android;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import com.trainerfu.utils.DateUtils;
import java.util.Calendar;
import java.util.Date;
import org.greenrobot.eventbus.EventBus;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private Calendar cal;
    private Boolean enableMinDate = false;
    private String info;
    private int requestCode;

    public void onCreate(Bundle bundle) {
        Date date;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments.containsKey("date")) {
            date = DateUtils.getDateFromISOFormat(arguments.getString("date"));
        } else {
            date = new Date();
        }
        this.requestCode = arguments.getInt("request_code");
        this.info = arguments.getString("info");
        this.enableMinDate = Boolean.valueOf(arguments.getBoolean("enable_min_date"));
        Calendar instance = Calendar.getInstance();
        this.cal = instance;
        instance.setTime(date);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, this.cal.get(1), this.cal.get(2), this.cal.get(5));
        if (this.enableMinDate.booleanValue()) {
            datePickerDialog.getDatePicker().setMinDate(DateUtils.getTodaysDate(-6).getTime());
        }
        return datePickerDialog;
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.cal.set(i, i2, i3);
        EventBus.getDefault().post(new DateSelectedEvent(this.requestCode, this.info, DateUtils.getISOFormattedDate(this.cal.getTime())));
    }
}
