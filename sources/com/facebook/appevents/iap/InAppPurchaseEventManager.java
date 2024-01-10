package com.facebook.appevents.iap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);

    static Object asInterface(Context context, IBinder iBinder) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, (Object) null, new Object[]{iBinder});
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Map<String, String> readSkuDetailsFromCache = readSkuDetailsFromCache(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!readSkuDetailsFromCache.containsKey(next)) {
                    arrayList2.add(next);
                }
            }
            readSkuDetailsFromCache.putAll(getSkuDetailsFromGoogle(context, arrayList2, obj, z));
            return readSkuDetailsFromCache;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            if (obj != null) {
                if (!arrayList.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
                    Object[] objArr = new Object[4];
                    objArr[0] = 3;
                    objArr[1] = PACKAGE_NAME;
                    objArr[2] = z ? "subs" : "inapp";
                    objArr[3] = bundle;
                    Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, objArr);
                    if (invokeMethod != null) {
                        Bundle bundle2 = (Bundle) invokeMethod;
                        if (bundle2.getInt(RESPONSE_CODE) == 0) {
                            ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                            if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                                for (int i = 0; i < arrayList.size(); i++) {
                                    hashMap.put(arrayList.get(i), stringArrayList.get(i));
                                }
                            }
                            writeSkuDetailsToCache(hashMap);
                        }
                    }
                }
            }
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                String string = skuDetailSharedPrefs.getString(next, (String) null);
                if (string != null) {
                    String[] split = string.split(";", 2);
                    if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                        hashMap.put(next, split[1]);
                    }
                }
            }
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static void writeSkuDetailsToCache(Map<String, String> map) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                SharedPreferences.Editor edit = skuDetailSharedPrefs.edit();
                for (Map.Entry next : map.entrySet()) {
                    edit.putString((String) next.getKey(), currentTimeMillis + ";" + ((String) next.getValue()));
                }
                edit.apply();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static Boolean isBillingSupported(Context context, Object obj, String str) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        boolean z = false;
        if (obj == null) {
            try {
                return false;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
                return null;
            }
        } else {
            Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{3, PACKAGE_NAME, str});
            if (invokeMethod != null && ((Integer) invokeMethod).intValue() == 0) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    static ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return filterPurchases(getPurchases(context, obj, "inapp"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static ArrayList<String> getPurchasesSubs(Context context, Object obj) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return filterPurchases(getPurchases(context, obj, "subs"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065 A[EDGE_INSN: B:25:0x0065->B:21:0x0065 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r10, java.lang.Object r11, java.lang.String r12) {
        /*
            java.lang.Class<com.facebook.appevents.iap.InAppPurchaseEventManager> r0 = com.facebook.appevents.iap.InAppPurchaseEventManager.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0066 }
            r1.<init>()     // Catch:{ all -> 0x0066 }
            if (r11 != 0) goto L_0x0012
            return r1
        L_0x0012:
            java.lang.Boolean r3 = isBillingSupported(r10, r11, r12)     // Catch:{ all -> 0x0066 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0066 }
            if (r3 == 0) goto L_0x0065
            r3 = 0
            r4 = r2
            r5 = 0
        L_0x001f:
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0066 }
            r7 = 3
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0066 }
            r6[r3] = r8     // Catch:{ all -> 0x0066 }
            r8 = 1
            java.lang.String r9 = PACKAGE_NAME     // Catch:{ all -> 0x0066 }
            r6[r8] = r9     // Catch:{ all -> 0x0066 }
            r8 = 2
            r6[r8] = r12     // Catch:{ all -> 0x0066 }
            r6[r7] = r4     // Catch:{ all -> 0x0066 }
            java.lang.String r4 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r7 = "getPurchases"
            java.lang.Object r4 = invokeMethod(r10, r4, r7, r11, r6)     // Catch:{ all -> 0x0066 }
            if (r4 == 0) goto L_0x005e
            android.os.Bundle r4 = (android.os.Bundle) r4     // Catch:{ all -> 0x0066 }
            java.lang.String r6 = "RESPONSE_CODE"
            int r6 = r4.getInt(r6)     // Catch:{ all -> 0x0066 }
            if (r6 != 0) goto L_0x005e
            java.lang.String r6 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r6 = r4.getStringArrayList(r6)     // Catch:{ all -> 0x0066 }
            if (r6 == 0) goto L_0x0065
            int r7 = r6.size()     // Catch:{ all -> 0x0066 }
            int r5 = r5 + r7
            r1.addAll(r6)     // Catch:{ all -> 0x0066 }
            java.lang.String r6 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r4 = r4.getString(r6)     // Catch:{ all -> 0x0066 }
            goto L_0x005f
        L_0x005e:
            r4 = r2
        L_0x005f:
            r6 = 30
            if (r5 >= r6) goto L_0x0065
            if (r4 != 0) goto L_0x001f
        L_0x0065:
            return r1
        L_0x0066:
            r10 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r10, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    public static boolean hasFreeTrialPeirod(String str) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            String optString = new JSONObject(str).optString("freeTrialPeriod");
            if (optString == null || optString.isEmpty()) {
                return false;
            }
            return true;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    static ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        Class<?> cls;
        Class<InAppPurchaseEventManager> cls2 = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls2)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            if (obj == null || (cls = getClass(context, IN_APP_BILLING_SERVICE)) == null || getMethod(cls, GET_PURCHASE_HISTORY) == null) {
                return arrayList;
            }
            return filterPurchases(getPurchaseHistory(context, obj, "inapp"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls2);
            return null;
        }
    }

    private static ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            if (isBillingSupported(context, obj, str).booleanValue()) {
                char c = 0;
                String str2 = null;
                int i = 0;
                boolean z = false;
                while (true) {
                    Object[] objArr = new Object[5];
                    objArr[c] = 6;
                    objArr[1] = PACKAGE_NAME;
                    objArr[2] = str;
                    objArr[3] = str2;
                    objArr[4] = new Bundle();
                    Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, obj, objArr);
                    if (invokeMethod != null) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        Bundle bundle = (Bundle) invokeMethod;
                        if (bundle.getInt(RESPONSE_CODE) == 0) {
                            ArrayList<String> stringArrayList = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST);
                            if (stringArrayList != null) {
                                Iterator<String> it = stringArrayList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    String next = it.next();
                                    try {
                                        if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                            z = true;
                                            break;
                                        }
                                        arrayList.add(next);
                                        i++;
                                    } catch (JSONException unused) {
                                    }
                                }
                                str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                                if (i >= 30 || str2 == null || z) {
                                    break;
                                }
                                c = 0;
                            }
                        }
                    }
                    str2 = null;
                    c = 0;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static ArrayList<String> filterPurchases(ArrayList<String> arrayList) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            ArrayList<String> arrayList2 = new ArrayList<>();
            SharedPreferences.Editor edit = purchaseInappSharedPrefs.edit();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    JSONObject jSONObject = new JSONObject(next);
                    String string = jSONObject.getString("productId");
                    long j = jSONObject.getLong("purchaseTime");
                    String string2 = jSONObject.getString("purchaseToken");
                    if (currentTimeMillis - (j / 1000) <= 86400) {
                        if (!purchaseInappSharedPrefs.getString(string, "").equals(string2)) {
                            edit.putString(string, string2);
                            arrayList2.add(next);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            edit.apply();
            return arrayList2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static Method getMethod(Class<?> cls, String str) {
        Class[] clsArr;
        Class<InAppPurchaseEventManager> cls2 = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls2)) {
            return null;
        }
        try {
            Method method = methodMap.get(str);
            if (method != null) {
                return method;
            }
            char c = 65535;
            try {
                switch (str.hashCode()) {
                    case -1801122596:
                        if (str.equals(GET_PURCHASES)) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1450694211:
                        if (str.equals(IS_BILLING_SUPPORTED)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1123215065:
                        if (str.equals(AS_INTERFACE)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -594356707:
                        if (str.equals(GET_PURCHASE_HISTORY)) {
                            c = 4;
                            break;
                        }
                        break;
                    case -573310373:
                        if (str.equals(GET_SKU_DETAILS)) {
                            c = 1;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    clsArr = new Class[]{IBinder.class};
                } else if (c == 1) {
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class, Bundle.class};
                } else if (c == 2) {
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class};
                } else if (c != 3) {
                    clsArr = c != 4 ? null : new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class};
                } else {
                    clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class};
                }
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                methodMap.put(str, declaredMethod);
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls2);
            return null;
        }
    }

    private static Class<?> getClass(Context context, String str) {
        Class<?> loadClass;
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Class<?> cls2 = classMap.get(str);
            if (cls2 != null) {
                return cls2;
            }
            try {
                loadClass = context.getClassLoader().loadClass(str);
                classMap.put(str, loadClass);
                return loadClass;
            } catch (ClassNotFoundException unused) {
                return loadClass;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Class<?> cls2 = getClass(context, str);
            if (cls2 == null || (method = getMethod(cls2, str2)) == null) {
                return null;
            }
            if (obj != null) {
                obj = cls2.cast(obj);
            }
            try {
                return method.invoke(obj, objArr);
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static void clearSkuDetailsCache() {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long j = skuDetailSharedPrefs.getLong(LAST_CLEARED_TIME, 0);
                if (j == 0) {
                    skuDetailSharedPrefs.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
                } else if (currentTimeMillis - j > 604800) {
                    skuDetailSharedPrefs.edit().clear().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
