package io.intercom.android.sdk.utilities;

import android.content.Context;
import com.google.gson.Gson;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.CountryAreaCode;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private static final int MAX_LENGTH_WITHOUT_PREFIX = 15;
    private static final int MIN_LENGTH_WITHOUT_PREFIX = 6;
    private static final String NON_NUMBER_PATTERN = "\\D";
    private static final String PREFIX_PATTERN = "^(\\+)|(00)";
    private static final int PRIORITY_CONFLICTS_WITH_NO_SUB_CODES = 1;
    private static final int PRIORITY_CONFLICTS_WITH_SUB_CODES = 2;
    private static final int PRIORITY_NO_CONFLICTING_CODES = 0;
    private static final String SPECIAL_CHARACTERS = "^(\\()|(\\))|(-)";
    private static final String WHITESPACE_PATTERN = "\\s+";
    private static final List<CountryAreaCode> countryAreaCodes = new ArrayList();

    public static void loadCountryAreaCodes(Context context) {
        if (countryAreaCodes.isEmpty()) {
            for (CountryAreaCode.Builder build : parseCodes(context)) {
                countryAreaCodes.add(build.build());
            }
        }
    }

    static List<CountryAreaCode.Builder> parseCodes(Context context) {
        CountryAreaCode.Builder[] builderArr = (CountryAreaCode.Builder[]) new Gson().fromJson(loadJsonFromAsset(context), CountryAreaCode.Builder[].class);
        return builderArr != null ? Arrays.asList(builderArr) : new ArrayList();
    }

    private static String loadJsonFromAsset(Context context) {
        try {
            InputStream openRawResource = context.getResources().openRawResource(R.raw.intercom_area_codes);
            byte[] bArr = new byte[openRawResource.available()];
            openRawResource.read(bArr);
            openRawResource.close();
            return new String(bArr, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    static int validatePhoneNumber(String str) {
        String normalizeNumber = normalizeNumber(str);
        if (!containsPrefix(normalizeNumber)) {
            return 4;
        }
        String stripPrefix = stripPrefix(normalizeNumber);
        if (Pattern.compile(NON_NUMBER_PATTERN).matcher(stripPrefix).find()) {
            return 3;
        }
        String replaceAll = stripPrefix.replaceAll(NON_NUMBER_PATTERN, "");
        if (replaceAll.length() > 15) {
            return 5;
        }
        CountryAreaCode countryAreaCodeFromNumber = getCountryAreaCodeFromNumber(replaceAll);
        int length = countryAreaCodeFromNumber.getDialCode().length();
        if (countryAreaCodeFromNumber.equals(CountryAreaCode.UNKNOWN)) {
            return 6;
        }
        return replaceAll.substring(length).length() < 6 ? 7 : 0;
    }

    public static String normalizeNumber(String str) {
        return str.replaceAll(WHITESPACE_PATTERN, "").replaceAll(SPECIAL_CHARACTERS, "");
    }

    static boolean containsPrefix(String str) {
        Matcher matcher = Pattern.compile(PREFIX_PATTERN).matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        return false;
    }

    public static String stripPrefix(String str) {
        return str.replaceFirst(PREFIX_PATTERN, "");
    }

    public static CountryAreaCode getCountryAreaCodeFromNumber(String str) {
        CountryAreaCode countryAreaCode = CountryAreaCode.UNKNOWN;
        for (CountryAreaCode next : countryAreaCodes) {
            if (str.startsWith(next.getDialCode())) {
                int priority = next.getPriority();
                if (priority == 0) {
                    return next;
                }
                if (priority == 1) {
                    countryAreaCode = next;
                } else if (priority == 2) {
                    String substring = str.substring(next.getDialCode().length());
                    for (String startsWith : next.getAreaCodes()) {
                        if (substring.startsWith(startsWith)) {
                            return next;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return countryAreaCode;
    }

    public static CountryAreaCode getCountryAreaCodeFromLocale(String str) {
        for (CountryAreaCode next : countryAreaCodes) {
            if (str.equalsIgnoreCase(next.getCode())) {
                return next;
            }
        }
        return CountryAreaCode.UNKNOWN;
    }
}
