package com.facebook.appevents.aam;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;

final class MetadataMatcher {
    private static final int MAX_INDICATOR_LENGTH = 100;
    private static final String TAG = MetadataMatcher.class.getCanonicalName();

    MetadataMatcher() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:3|4|(1:6)|7|(1:9)|10|11|(2:13|(1:15))|16|17|(4:20|(2:24|33)|29|18)|30|25) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0053 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062 A[Catch:{ all -> 0x007f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<java.lang.String> getCurrentViewIndicators(android.view.View r6) {
        /*
            java.lang.Class<com.facebook.appevents.aam.MetadataMatcher> r0 = com.facebook.appevents.aam.MetadataMatcher.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x007f }
            r1.<init>()     // Catch:{ all -> 0x007f }
            java.lang.String r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.getHintOfView(r6)     // Catch:{ all -> 0x007f }
            r1.add(r3)     // Catch:{ all -> 0x007f }
            java.lang.Object r3 = r6.getTag()     // Catch:{ all -> 0x007f }
            if (r3 == 0) goto L_0x0023
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x007f }
            r1.add(r3)     // Catch:{ all -> 0x007f }
        L_0x0023:
            java.lang.CharSequence r3 = r6.getContentDescription()     // Catch:{ all -> 0x007f }
            if (r3 == 0) goto L_0x0030
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x007f }
            r1.add(r3)     // Catch:{ all -> 0x007f }
        L_0x0030:
            int r3 = r6.getId()     // Catch:{ NotFoundException -> 0x0053 }
            r4 = -1
            if (r3 == r4) goto L_0x0053
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ NotFoundException -> 0x0053 }
            int r6 = r6.getId()     // Catch:{ NotFoundException -> 0x0053 }
            java.lang.String r6 = r3.getResourceName(r6)     // Catch:{ NotFoundException -> 0x0053 }
            java.lang.String r3 = "/"
            java.lang.String[] r6 = r6.split(r3)     // Catch:{ NotFoundException -> 0x0053 }
            int r3 = r6.length     // Catch:{ NotFoundException -> 0x0053 }
            r4 = 2
            if (r3 != r4) goto L_0x0053
            r3 = 1
            r6 = r6[r3]     // Catch:{ NotFoundException -> 0x0053 }
            r1.add(r6)     // Catch:{ NotFoundException -> 0x0053 }
        L_0x0053:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x007f }
            r6.<init>()     // Catch:{ all -> 0x007f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x007f }
        L_0x005c:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x007f }
            if (r3 == 0) goto L_0x007e
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x007f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x007f }
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x007f }
            if (r4 != 0) goto L_0x005c
            int r4 = r3.length()     // Catch:{ all -> 0x007f }
            r5 = 100
            if (r4 > r5) goto L_0x005c
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x007f }
            r6.add(r3)     // Catch:{ all -> 0x007f }
            goto L_0x005c
        L_0x007e:
            return r6
        L_0x007f:
            r6 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r6, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.aam.MetadataMatcher.getCurrentViewIndicators(android.view.View):java.util.List");
    }

    static List<String> getAroundViewIndicators(View view) {
        Class<MetadataMatcher> cls = MetadataMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            ViewGroup parentOfView = ViewHierarchy.getParentOfView(view);
            if (parentOfView != null) {
                for (View next : ViewHierarchy.getChildrenOfView(parentOfView)) {
                    if (view != next) {
                        arrayList.addAll(getTextIndicators(next));
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static boolean matchIndicator(List<String> list, List<String> list2) {
        Class<MetadataMatcher> cls = MetadataMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            for (String matchIndicator : list) {
                if (matchIndicator(matchIndicator, list2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    static boolean matchIndicator(String str, List<String> list) {
        Class<MetadataMatcher> cls = MetadataMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            for (String contains : list) {
                if (str.contains(contains)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    static boolean matchValue(String str, String str2) {
        Class<MetadataMatcher> cls = MetadataMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return str.matches(str2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    static List<String> getTextIndicators(View view) {
        Class<MetadataMatcher> cls = MetadataMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof EditText) {
                return arrayList;
            }
            if (view instanceof TextView) {
                String charSequence = ((TextView) view).getText().toString();
                if (!charSequence.isEmpty() && charSequence.length() < 100) {
                    arrayList.add(charSequence.toLowerCase());
                }
                return arrayList;
            }
            for (View textIndicators : ViewHierarchy.getChildrenOfView(view)) {
                arrayList.addAll(getTextIndicators(textIndicators));
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
