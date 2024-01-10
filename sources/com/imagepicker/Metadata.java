package com.imagepicker;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

abstract class Metadata {
    protected String datetime;
    protected int height;
    protected int width;

    public abstract String getDateTime();

    public abstract int getHeight();

    public abstract int getWidth();

    Metadata() {
    }

    /* access modifiers changed from: protected */
    public String getDateTimeInUTC(String str, String str2) {
        try {
            Date parse = new SimpleDateFormat(str2, Locale.US).parse(str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
            if (parse != null) {
                return simpleDateFormat.format(parse);
            }
            return null;
        } catch (Exception e) {
            Log.e("RNIP", "Could not parse image datetime to UTC: " + e.getMessage());
            return null;
        }
    }
}
