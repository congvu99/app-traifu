package com.github.mikephil.charting.formatter;

import com.facebook.appevents.AppEventsConstants;
import java.text.DecimalFormat;

public class DefaultAxisValueFormatter extends ValueFormatter {
    protected int digits;
    protected DecimalFormat mFormat;

    public DefaultAxisValueFormatter(int i) {
        this.digits = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public String getFormattedValue(float f) {
        return this.mFormat.format((double) f);
    }

    public int getDecimalDigits() {
        return this.digits;
    }
}
