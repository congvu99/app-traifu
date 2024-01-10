package io.intercom.android.sdk.utilities;

import android.content.Context;
import io.intercom.android.sdk.R;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\n\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0000¨\u0006\u000b"}, d2 = {"getDifferenceInDays", "", "date", "Ljava/util/Date;", "getDifferenceInHours", "getDifferenceInMinutes", "getFormattedTime", "", "context", "Landroid/content/Context;", "formattedDateFromLong", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TimeFormatterExt.kt */
public final class TimeFormatterExtKt {
    public static final String formattedDateFromLong(long j, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (j <= 0) {
            return "";
        }
        return getFormattedTime(context, new Date(j * ((long) 1000)));
    }

    private static final String getFormattedTime(Context context, Date date) {
        long differenceInMinutes = getDifferenceInMinutes(date);
        long differenceInHours = getDifferenceInHours(date);
        long differenceInDays = getDifferenceInDays(date);
        long j = differenceInDays / ((long) 7);
        if (j > 0) {
            return Phrase.from(context, R.string.intercom_time_week_ago).put("delta", (CharSequence) String.valueOf(j)).format().toString();
        }
        if (differenceInDays > 0) {
            return Phrase.from(context, R.string.intercom_time_day_ago).put("delta", (CharSequence) String.valueOf(differenceInDays)).format().toString();
        }
        if (differenceInHours > 0) {
            return Phrase.from(context, R.string.intercom_time_hour_ago).put("delta", (CharSequence) String.valueOf(differenceInHours)).format().toString();
        }
        if (differenceInMinutes >= 1) {
            return Phrase.from(context, R.string.intercom_time_minute_ago).put("delta", (CharSequence) String.valueOf(differenceInMinutes)).format().toString();
        }
        return context.getText(R.string.intercom_time_just_now).toString();
    }

    private static final long getDifferenceInMinutes(Date date) {
        return TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - date.getTime());
    }

    private static final long getDifferenceInHours(Date date) {
        return TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis() - date.getTime());
    }

    private static final long getDifferenceInDays(Date date) {
        return TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - date.getTime());
    }
}
