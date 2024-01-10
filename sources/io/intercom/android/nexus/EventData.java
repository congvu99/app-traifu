package io.intercom.android.nexus;

import java.util.HashMap;

public class EventData extends HashMap<String, Object> {
    public EventData() {
    }

    public EventData(int i) {
        super(i);
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        Object obj = get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    public long optLong(String str) {
        return optLong(str, -1);
    }

    public long optLong(String str, long j) {
        Object obj = get(str);
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue()).longValue();
        }
        return obj instanceof Long ? ((Long) obj).longValue() : j;
    }
}
