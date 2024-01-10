package io.intercom.android.sdk.utilities;

import android.content.Context;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.intercom.commons.utilities.TimeProvider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.Location;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class LocationFormatter {
    private static final String[] LOWER_CASE_ENGLISH_AM_PM = {"am", "pm"};
    private static final long ONE_MINUTE_IN_MILLIS = TimeUnit.MINUTES.toMillis(1);
    private static final String[] UPPER_CASE_EN_GB_AM_PM = {"a.m.", "p.m."};
    private static final String[] UPPER_CASE_EN_US_AM_PM = {"AM", "PM"};

    public static CharSequence getLocationString(Context context, Location location, Date date) {
        if (location.getTimezoneOffset() == null) {
            return "";
        }
        Locale locale = context.getResources().getConfiguration().locale;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mma", locale);
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        timeZone.setRawOffset((int) TimeUnit.SECONDS.toMillis((long) location.getTimezoneOffset().intValue()));
        simpleDateFormat.setTimeZone(timeZone);
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        if (Arrays.equals(dateFormatSymbols.getAmPmStrings(), UPPER_CASE_EN_GB_AM_PM) || Arrays.equals(dateFormatSymbols.getAmPmStrings(), UPPER_CASE_EN_US_AM_PM)) {
            dateFormatSymbols.setAmPmStrings(LOWER_CASE_ENGLISH_AM_PM);
        }
        simpleDateFormat.setDateFormatSymbols(dateFormatSymbols);
        Phrase put = Phrase.from(context, R.string.intercom_profile_location).put("time", (CharSequence) simpleDateFormat.format(date));
        return put.put(FirebaseAnalytics.Param.LOCATION, (CharSequence) location.getCityName() + ", " + location.getCountryName()).format();
    }

    public static void postOnNextMinute(View view, Runnable runnable, TimeProvider timeProvider) {
        long currentTimeMillis = timeProvider.currentTimeMillis();
        long j = ONE_MINUTE_IN_MILLIS;
        view.postDelayed(runnable, j - (currentTimeMillis % j));
    }
}
