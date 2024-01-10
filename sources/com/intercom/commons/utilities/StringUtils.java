package com.intercom.commons.utilities;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static List<String> splitOnEmpty(String str) {
        ArrayList arrayList = new ArrayList(str.length());
        for (String str2 : str.split("")) {
            if (!str2.isEmpty()) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }
}
