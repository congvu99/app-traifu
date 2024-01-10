package com.trainerfu.utils;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RNUtil {
    public static JSONArray toJSONArray(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < readableArray.size(); i++) {
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    jSONArray.put(i, (Object) null);
                    break;
                case 2:
                    jSONArray.put(i, readableArray.getBoolean(i));
                    break;
                case 3:
                    jSONArray.put(i, readableArray.getDouble(i));
                    break;
                case 4:
                    jSONArray.put(i, readableArray.getString(i));
                    break;
                case 5:
                    jSONArray.put(i, toJSONObject(readableArray.getMap(i)));
                    break;
                case 6:
                    jSONArray.put(i, toJSONArray(readableArray.getArray(i)));
                    break;
            }
        }
        return jSONArray;
    }

    /* renamed from: com.trainerfu.utils.RNUtil$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Array     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.utils.RNUtil.AnonymousClass1.<clinit>():void");
        }
    }

    public static Object[] toArray(JSONArray jSONArray) throws JSONException {
        Object[] objArr = new Object[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                obj = toArray((JSONArray) obj);
            }
            objArr[i] = obj;
        }
        return objArr;
    }

    public static Object[] toArray(ReadableArray readableArray) {
        Object[] objArr = new Object[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    objArr[i] = null;
                    break;
                case 2:
                    objArr[i] = Boolean.valueOf(readableArray.getBoolean(i));
                    break;
                case 3:
                    objArr[i] = Double.valueOf(readableArray.getDouble(i));
                    break;
                case 4:
                    objArr[i] = readableArray.getString(i);
                    break;
                case 5:
                    objArr[i] = toMap(readableArray.getMap(i));
                    break;
                case 6:
                    objArr[i] = toArray(readableArray.getArray(i));
                    break;
            }
        }
        return objArr;
    }

    public static WritableArray toWritableArray(Object[] objArr) {
        WritableArray createArray = Arguments.createArray();
        for (Boolean bool : objArr) {
            if (bool == null) {
                createArray.pushNull();
            }
            if (bool instanceof Boolean) {
                createArray.pushBoolean(bool.booleanValue());
            }
            if (bool instanceof Double) {
                createArray.pushDouble(((Double) bool).doubleValue());
            }
            if (bool instanceof Integer) {
                createArray.pushInt(bool.intValue());
            }
            if (bool instanceof String) {
                createArray.pushString(bool);
            }
            if (bool instanceof Map) {
                createArray.pushMap(toWritableMap(bool));
            }
            if (bool.getClass().isArray()) {
                createArray.pushArray(toWritableArray((Object[]) bool));
            }
        }
        return createArray;
    }

    public static JSONObject toJSONObject(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    jSONObject.put(nextKey, (Object) null);
                    break;
                case 2:
                    jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case 3:
                    jSONObject.put(nextKey, readableMap.getDouble(nextKey));
                    break;
                case 4:
                    jSONObject.put(nextKey, readableMap.getString(nextKey));
                    break;
                case 5:
                    jSONObject.put(nextKey, toJSONObject(readableMap.getMap(nextKey)));
                    break;
                case 6:
                    jSONObject.put(nextKey, toJSONArray(readableMap.getArray(nextKey)));
                    break;
            }
        }
        return jSONObject;
    }

    public static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                obj = toArray((JSONArray) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public static Map<String, Object> toMap(ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    hashMap.put(nextKey, (Object) null);
                    break;
                case 2:
                    hashMap.put(nextKey, Boolean.valueOf(readableMap.getBoolean(nextKey)));
                    break;
                case 3:
                    hashMap.put(nextKey, Double.valueOf(readableMap.getDouble(nextKey)));
                    break;
                case 4:
                    hashMap.put(nextKey, readableMap.getString(nextKey));
                    break;
                case 5:
                    hashMap.put(nextKey, toMap(readableMap.getMap(nextKey)));
                    break;
                case 6:
                    hashMap.put(nextKey, toArray(readableMap.getArray(nextKey)));
                    break;
            }
        }
        return hashMap;
    }

    public static WritableMap toWritableMap(Map<String, Object> map) {
        WritableMap createMap = Arguments.createMap();
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            Object value = next.getValue();
            if (value == null) {
                createMap.putNull((String) next.getKey());
            } else if (value instanceof Boolean) {
                createMap.putBoolean((String) next.getKey(), ((Boolean) value).booleanValue());
            } else if (value instanceof Double) {
                createMap.putDouble((String) next.getKey(), ((Double) value).doubleValue());
            } else if (value instanceof Integer) {
                createMap.putInt((String) next.getKey(), ((Integer) value).intValue());
            } else if (value instanceof String) {
                createMap.putString((String) next.getKey(), (String) value);
            } else if (value instanceof Map) {
                createMap.putMap((String) next.getKey(), toWritableMap((Map) value));
            } else if (value.getClass() != null && value.getClass().isArray()) {
                createMap.putArray((String) next.getKey(), toWritableArray((Object[]) value));
            }
            it.remove();
        }
        return createMap;
    }
}
