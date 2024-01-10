package com.trainerfu.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.utils.Tuple;
import java.util.ArrayList;

public class DrillQuickEntryView extends LinearLayout implements View.OnClickListener {
    private static ArrayList<Tuple<String, String>> distanceKeys = new ArrayList<>();
    private static ArrayList<Tuple<String, String>> durationKeys = new ArrayList<>();
    private static ArrayList<Tuple<String, String>> repKeys = new ArrayList<>();
    private static ArrayList<Tuple<String, String>> restKeys = new ArrayList<>();
    private static ArrayList<Tuple<String, String>> setKeys = new ArrayList<>();
    private static ArrayList<Tuple<String, String>> weightKeys = new ArrayList<>();
    private ArrayList<IconTextView> btns;
    private EventListener listener;
    private boolean showPrefix;
    private DrillQuickEntryViewType viewType;

    public interface EventListener {
        void keyPressedWithText(String str);
    }

    public DrillQuickEntryView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DrillQuickEntryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrillQuickEntryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.showPrefix = false;
        this.btns = new ArrayList<>();
        int i2 = 1;
        setOrientation(1);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DrillQuickEntryView, 0, 0);
        i2 = obtainStyledAttributes.hasValue(0) ? obtainStyledAttributes.getInt(0, 1) : i2;
        obtainStyledAttributes.recycle();
        this.viewType = DrillQuickEntryViewType.fromId(i2);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.drill_quick_entry_view, this);
        initializeView(context);
    }

    private void initializeView(Context context) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.buttonsWrapper);
        ArrayList<Tuple<String, String>> keys = getKeys();
        for (int i = 0; i < keys.size(); i++) {
            LinearLayout linearLayout2 = (LinearLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.drill_quick_enty_view_button, (ViewGroup) null, false);
            IconTextView iconTextView = (IconTextView) linearLayout2.findViewById(R.id.btn);
            iconTextView.setText((CharSequence) keys.get(i).x);
            iconTextView.setOnClickListener(this);
            linearLayout.addView(linearLayout2);
            this.btns.add(iconTextView);
        }
    }

    public void onClick(View view) {
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.keyPressedWithText(((IconTextView) view).getText().toString());
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.listener = eventListener;
    }

    public void showPrefix(boolean z) {
        ArrayList<Tuple<String, String>> keys = getKeys();
        for (int i = 0; i < this.btns.size(); i++) {
            Tuple tuple = keys.get(i);
            this.btns.get(i).setText(z ? tuple.y : tuple.x);
        }
    }

    private ArrayList<Tuple<String, String>> getKeys() {
        if (this.viewType == DrillQuickEntryViewType.set) {
            return setKeys;
        }
        if (this.viewType == DrillQuickEntryViewType.rep) {
            return repKeys;
        }
        if (this.viewType == DrillQuickEntryViewType.weight) {
            return weightKeys;
        }
        if (this.viewType == DrillQuickEntryViewType.duration) {
            return durationKeys;
        }
        if (this.viewType == DrillQuickEntryViewType.distance) {
            return distanceKeys;
        }
        return restKeys;
    }

    static {
        for (int i = 1; i <= 20; i++) {
            setKeys.add(new Tuple(String.valueOf(i), String.valueOf(i)));
        }
        for (int i2 = 1; i2 <= 20; i2++) {
            ArrayList<Tuple<String, String>> arrayList = repKeys;
            String valueOf = String.valueOf(i2);
            arrayList.add(new Tuple(valueOf, ", " + String.valueOf(i2)));
        }
        repKeys.add(new Tuple("each side", " each side"));
        repKeys.add(new Tuple("AMRAP", ", AMRAP"));
        repKeys.add(new Tuple("failure", ", failure"));
        weightKeys.add(new Tuple(" lbs", " lbs"));
        weightKeys.add(new Tuple(" kgs", " kgs"));
        for (int i3 = 1; i3 <= 30; i3++) {
            ArrayList<Tuple<String, String>> arrayList2 = weightKeys;
            int i4 = i3 * 5;
            String valueOf2 = String.valueOf(i4);
            arrayList2.add(new Tuple(valueOf2, ", " + String.valueOf(i4)));
        }
        distanceKeys.add(new Tuple(" miles", " miles"));
        distanceKeys.add(new Tuple(" kms", " kms"));
        distanceKeys.add(new Tuple(" yards", " yards"));
        distanceKeys.add(new Tuple(" meters", " meters"));
        distanceKeys.add(new Tuple(".5", ".5"));
        distanceKeys.add(new Tuple("1", "1"));
        distanceKeys.add(new Tuple("1.5", "1.5"));
        distanceKeys.add(new Tuple(ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_2D));
        distanceKeys.add(new Tuple("2.5", "2.5"));
        distanceKeys.add(new Tuple(ExifInterface.GPS_MEASUREMENT_3D, ExifInterface.GPS_MEASUREMENT_3D));
        distanceKeys.add(new Tuple("4", "4"));
        distanceKeys.add(new Tuple("5", "5"));
        distanceKeys.add(new Tuple("10", "10"));
        distanceKeys.add(new Tuple("100", "100"));
        distanceKeys.add(new Tuple("200", "200"));
        distanceKeys.add(new Tuple("500", "500"));
        durationKeys.add(new Tuple("30 sec", "30 sec"));
        durationKeys.add(new Tuple("45 sec", "45 sec"));
        durationKeys.add(new Tuple("1 min", "1 min"));
        durationKeys.add(new Tuple("1.5 min", "1.5 min"));
        durationKeys.add(new Tuple("2 min", "2 min"));
        durationKeys.add(new Tuple("2.5 min", "2.5 min"));
        durationKeys.add(new Tuple("3 min", "3 min"));
        durationKeys.add(new Tuple("5 min", "5 min"));
        durationKeys.add(new Tuple("10 min", "10 min"));
        durationKeys.add(new Tuple("20 min", "20 min"));
        durationKeys.add(new Tuple("30 min", "30 min"));
        durationKeys.add(new Tuple("45 min", "45 min"));
        durationKeys.add(new Tuple("1 hr", "1 hr"));
        durationKeys.add(new Tuple("1.5 hr", "1.5 hr"));
        restKeys.add(new Tuple("10 sec", "10 sec"));
        restKeys.add(new Tuple("20 sec", "20 sec"));
        restKeys.add(new Tuple("30 sec", "30 sec"));
        restKeys.add(new Tuple("45 sec", "45 sec"));
        restKeys.add(new Tuple("1 min", "1 min"));
        restKeys.add(new Tuple("1.5 min", "1.5 min"));
        restKeys.add(new Tuple("2 min", "2 min"));
        restKeys.add(new Tuple("2.5 min", "2.5 min"));
        restKeys.add(new Tuple("3 min", "3 min"));
    }
}
