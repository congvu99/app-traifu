package com.takeoffandroid.urllinkview.library;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static final int ALL = 0;
    public static final int FIRST = 1;

    public static String pregMatch(String str, String str2, int i) {
        Matcher matcher = Pattern.compile(str2).matcher(str);
        return TextCrawler.extendedTrim(matcher.find() ? matcher.group(i) : "");
    }

    public static List<String> pregMatchAll(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str2).matcher(str);
        while (matcher.find()) {
            arrayList.add(TextCrawler.extendedTrim(matcher.group(i)));
        }
        return arrayList;
    }

    public static List<String> pregMatchAllImages(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str2).matcher(str);
        while (matcher.find()) {
            arrayList.add(TextCrawler.extendedTrim(matcher.group(3)) + matcher.group(4));
        }
        return arrayList;
    }

    public static List<String> pregMatchAllExtraImages(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str2).matcher(str);
        while (matcher.find()) {
            arrayList.add(TextCrawler.extendedTrim(matcher.group(3)) + matcher.group(4));
        }
        return arrayList;
    }

    public static ArrayList<String> matches(String str) {
        return matches(str, 0);
    }

    public static ArrayList<String> matches(String str, int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String url : str.split(" ")) {
            try {
                arrayList.add(new URL(url).toString());
            } catch (Exception unused) {
            }
            if (i == 1 && arrayList.size() > 0) {
                break;
            }
        }
        return arrayList;
    }
}
