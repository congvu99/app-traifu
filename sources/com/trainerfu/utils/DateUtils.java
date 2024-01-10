package com.trainerfu.utils;

import android.content.Context;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.trainerfu.android.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    private static SimpleDateFormat dateAndDayDf = new SimpleDateFormat("EEE, MMM d", Locale.getDefault());
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat feedDf = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());
    private static SimpleDateFormat largeDf = new SimpleDateFormat("d MMM yyyy", Locale.getDefault());
    private static SimpleDateFormat monthDayDf = new SimpleDateFormat("M/d", Locale.getDefault());

    public static String getTodaysFormattedDate() {
        Time time = new Time(Time.getCurrentTimezone());
        time.setToNow();
        return time.format("%Y-%m-%d");
    }

    public static String getISOFormattedDate(Date date) {
        return df.format(date);
    }

    public static Date getDateFromISOFormat(String str) {
        try {
            return df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static String getDisplayDate(Context context, Date date) {
        return DateFormat.getMediumDateFormat(context).format(date);
    }

    public static String getDayAndDate(Date date) {
        return dateAndDayDf.format(date);
    }

    public static String getStoryViewDisplayDate(Context context, Date date) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        instance.getTime();
        long timeInMillis = instance.getTimeInMillis();
        instance.add(5, -1);
        long timeInMillis2 = instance.getTimeInMillis();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis3 = instance.getTimeInMillis();
        if (timeInMillis == timeInMillis3) {
            return context.getString(R.string.Today);
        }
        if (timeInMillis2 == timeInMillis3) {
            return context.getString(R.string.Yesterday);
        }
        return feedDf.format(date);
    }

    public static String getFeedDisplayDate(Date date) {
        return feedDf.format(date);
    }

    public static String getLargeDisplayDate(Date date) {
        return largeDf.format(date);
    }

    public static Date addDays(Calendar calendar, Date date, int i) {
        calendar.setTime(date);
        calendar.add(5, i);
        return calendar.getTime();
    }

    public static Date addMonths(Calendar calendar, Date date, int i) {
        calendar.setTime(date);
        calendar.add(2, 1);
        return calendar.getTime();
    }

    public static int getDayOfWeek(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.get(7);
    }

    public static float getTimeZoneOffset() {
        return (float) TimeUnit.HOURS.convert((long) new GregorianCalendar().getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS);
    }

    public static Date dateOfLatestSunday() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        instance.add(5, (instance.get(7) - 1) * -1);
        return instance.getTime();
    }

    public static Date getTodaysDate() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime();
    }

    public static Date getTodaysDate(int i) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        instance.add(6, i);
        return instance.getTime();
    }

    public static String getMonthDayFormattedDate(Date date) {
        return monthDayDf.format(date);
    }

    public static int dateDifferenceInDays(Date date, Date date2) {
        return (int) ((date2.getTime() / 86400000) - ((long) ((int) (date.getTime() / 86400000))));
    }

    public static boolean isTodayDate(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        instance.getTime();
        long timeInMillis = instance.getTimeInMillis();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        if (timeInMillis == instance.getTimeInMillis()) {
            return true;
        }
        return false;
    }
}
