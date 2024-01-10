package io.intercom.android.sdk.blocks.function;

import io.intercom.android.sdk.models.Part;
import java.util.Calendar;
import java.util.List;

public class TimestampAdder {
    private final Calendar currentDate;
    private final Calendar nextDate;

    public static TimestampAdder create() {
        return new TimestampAdder(Calendar.getInstance(), Calendar.getInstance());
    }

    TimestampAdder(Calendar calendar, Calendar calendar2) {
        this.currentDate = calendar;
        this.nextDate = calendar2;
    }

    public void addDayDividers(List<Part> list) {
        this.currentDate.setTimeInMillis(0);
        this.nextDate.setTimeInMillis(0);
        int i = 0;
        while (i < list.size()) {
            if (!isDivider(list.get(i))) {
                long createdAt = list.get(i).getCreatedAt();
                this.nextDate.setTimeInMillis(1000 * createdAt);
                if (datesAreFromDifferentDays() && (i == 0 || !isDivider(list.get(i - 1)))) {
                    list.add(i, new Part.Builder().withStyle(Part.DAY_DIVIDER_STYLE).withCreatedAt(createdAt).build());
                    i++;
                }
                this.currentDate.setTimeInMillis(this.nextDate.getTimeInMillis());
            }
            i++;
        }
    }

    private boolean isDivider(Part part) {
        return Part.DAY_DIVIDER_STYLE.equals(part.getMessageStyle());
    }

    /* access modifiers changed from: package-private */
    public boolean datesAreFromDifferentDays() {
        if (this.currentDate.get(6) == this.nextDate.get(6) && this.currentDate.get(1) == this.nextDate.get(1)) {
            return false;
        }
        return true;
    }
}
