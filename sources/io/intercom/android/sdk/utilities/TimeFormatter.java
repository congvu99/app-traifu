package io.intercom.android.sdk.utilities;

import android.content.Context;
import android.text.format.DateFormat;
import com.intercom.commons.utilities.TimeProvider;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class TimeFormatter {
    private SimpleDateFormat absoluteDateFormatter;
    private SimpleDateFormat absoluteTimeFormatter;
    private final Context context;
    private final TimeProvider timeProvider;

    public TimeFormatter(Context context2, TimeProvider timeProvider2) {
        this.context = context2;
        this.timeProvider = timeProvider2;
    }

    public CharSequence getFormattedTime(long j) {
        if (j <= 0) {
            return "";
        }
        return getFormattedTime(new Date(j * 1000));
    }

    private CharSequence getFormattedTime(Date date) {
        Phrase phrase;
        long differenceInMinutes = getDifferenceInMinutes(date);
        long differenceInHours = getDifferenceInHours(date);
        long differenceInDays = getDifferenceInDays(date);
        long j = differenceInDays / 7;
        if (j > 0) {
            phrase = Phrase.from(this.context, R.string.intercom_time_week_ago).put("delta", (CharSequence) Long.toString(j));
        } else if (differenceInDays > 0) {
            phrase = Phrase.from(this.context, R.string.intercom_time_day_ago).put("delta", (CharSequence) Long.toString(differenceInDays));
        } else if (differenceInHours > 0) {
            phrase = Phrase.from(this.context, R.string.intercom_time_hour_ago).put("delta", (CharSequence) Long.toString(differenceInHours));
        } else if (differenceInMinutes < 1) {
            return this.context.getText(R.string.intercom_time_just_now);
        } else {
            phrase = Phrase.from(this.context, R.string.intercom_time_minute_ago).put("delta", (CharSequence) Long.toString(differenceInMinutes));
        }
        return phrase.format();
    }

    public String getLastActiveMinutes(long j) {
        Date date = new Date(j * 1000);
        return getDifferenceInMinutes(date) + " minutes";
    }

    public CharSequence getAdminActiveStatus(LastParticipatingAdmin lastParticipatingAdmin, Provider<AppConfig> provider) {
        if (shouldShowActiveOrAwayState(provider.get().getLocale())) {
            if (lastParticipatingAdmin.isActive()) {
                return this.context.getString(R.string.intercom_active_state);
            }
            return this.context.getString(R.string.intercom_away_state);
        } else if (lastParticipatingAdmin.getLastActiveAt() <= 0) {
            return "";
        } else {
            return getAdminActiveStatus(getDateFromTimeStamp(lastParticipatingAdmin.getLastActiveAt()));
        }
    }

    private CharSequence getAdminActiveStatus(Date date) {
        Phrase phrase;
        long differenceInMinutes = getDifferenceInMinutes(date);
        if (differenceInMinutes > TimeUnit.DAYS.toMinutes(6)) {
            return this.context.getText(R.string.intercom_active_week_ago);
        }
        if (differenceInMinutes >= TimeUnit.HOURS.toMinutes(23) + 31) {
            phrase = Phrase.from(this.context, R.string.intercom_active_day_ago).put("days", (CharSequence) Long.toString((((differenceInMinutes / 60) - 13) / 24) + 1));
        } else if (differenceInMinutes >= 53) {
            phrase = Phrase.from(this.context, R.string.intercom_active_hour_ago).put("hours", (CharSequence) Long.toString(((differenceInMinutes - 31) / 60) + 1));
        } else if (differenceInMinutes >= 38) {
            phrase = Phrase.from(this.context, R.string.intercom_active_minute_ago).put("minutes", (CharSequence) Long.toString(45));
        } else if (differenceInMinutes >= 16) {
            phrase = Phrase.from(this.context, R.string.intercom_active_minute_ago).put("minutes", (CharSequence) Long.toString(30));
        } else {
            phrase = Phrase.from(this.context, R.string.intercom_active_15m_ago).put("minutes", (CharSequence) Long.toString(15));
        }
        return phrase.format();
    }

    /* access modifiers changed from: package-private */
    public boolean shouldShowActiveOrAwayState(String str) {
        return str.equals("en");
    }

    private long getDifferenceInMinutes(Date date) {
        return TimeUnit.MILLISECONDS.toMinutes(this.timeProvider.currentTimeMillis() - date.getTime());
    }

    private long getDifferenceInHours(Date date) {
        return TimeUnit.MILLISECONDS.toHours(this.timeProvider.currentTimeMillis() - date.getTime());
    }

    private long getDifferenceInDays(Date date) {
        return TimeUnit.MILLISECONDS.toDays(this.timeProvider.currentTimeMillis() - date.getTime());
    }

    private Date getDateFromTimeStamp(long j) {
        return new Date(j * 1000);
    }

    public String getAbsoluteDate(long j) {
        return getAbsoluteDate(j * 1000, this.context.getResources().getConfiguration().locale);
    }

    /* access modifiers changed from: package-private */
    public String getAbsoluteDate(long j, Locale locale) {
        if (this.absoluteDateFormatter == null) {
            this.absoluteDateFormatter = createDateFormatter(locale, "MMMM d");
        }
        return this.absoluteDateFormatter.format(new Date(j));
    }

    public String getAbsoluteTime(long j) {
        return getAbsoluteTime(j * 1000, this.context.getResources().getConfiguration().locale);
    }

    /* access modifiers changed from: package-private */
    public String getAbsoluteTime(long j, Locale locale) {
        if (this.absoluteTimeFormatter == null) {
            this.absoluteTimeFormatter = createDateFormatter(locale, "hh:mm");
        }
        return this.absoluteTimeFormatter.format(new Date(j));
    }

    private static SimpleDateFormat createDateFormatter(Locale locale, String str) {
        return new SimpleDateFormat(DateFormat.getBestDateTimePattern(locale, str), locale);
    }

    public CharSequence getUpdated(long j) {
        Date dateFromTimeStamp = getDateFromTimeStamp(j);
        long differenceInMinutes = getDifferenceInMinutes(dateFromTimeStamp);
        long differenceInHours = getDifferenceInHours(dateFromTimeStamp);
        long differenceInDays = getDifferenceInDays(dateFromTimeStamp);
        long j2 = differenceInDays / 7;
        if (j2 > 0) {
            return "Updated " + j2 + " weeks ago";
        } else if (differenceInDays > 0) {
            return "Updated " + differenceInDays + " days ago";
        } else if (differenceInHours > 0) {
            return "Updated " + differenceInHours + " hours ago";
        } else if (differenceInMinutes < 1) {
            return this.context.getText(R.string.intercom_time_just_now);
        } else {
            return "Updated " + differenceInMinutes + " minutes ago";
        }
    }

    public static String formatTimeInMillisAsDate(long j) {
        return formatTimeInMillisAsDate(j, "MMM dd, yyyy");
    }

    public static String formatTimeInMillisAsDate(long j, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }

    public static String formatTimeForTickets(long j, Context context2) {
        Phrase phrase;
        Date date = new Date(j * 1000);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - date.getTime());
        long hours = TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis() - date.getTime());
        long days = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - date.getTime());
        long j2 = days / 7;
        if (j2 > 0) {
            phrase = Phrase.from(context2, R.string.intercom_time_week_ago).put("delta", (CharSequence) Long.toString(j2));
        } else if (days > 0) {
            phrase = Phrase.from(context2, R.string.intercom_time_day_ago).put("delta", (CharSequence) Long.toString(days));
        } else if (hours > 0) {
            phrase = Phrase.from(context2, R.string.intercom_time_hour_ago).put("delta", (CharSequence) Long.toString(hours));
        } else if (minutes < 1) {
            return context2.getString(R.string.intercom_time_just_now);
        } else {
            phrase = Phrase.from(context2, R.string.intercom_time_minute_ago).put("delta", (CharSequence) Long.toString(minutes));
        }
        return phrase.format().toString();
    }

    public static String formatToUtcTime(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, i);
        instance.set(12, i2);
        Date time = instance.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(time);
    }

    public static String formatFromUtcTime(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getTimeZone("UTC"));
        instance.set(11, i);
        instance.set(12, i2);
        Date time = instance.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(time);
    }

    public static int getHour(long j) {
        return new Date(j).getHours();
    }

    public static int getMinute(long j) {
        return new Date(j).getMinutes();
    }
}
