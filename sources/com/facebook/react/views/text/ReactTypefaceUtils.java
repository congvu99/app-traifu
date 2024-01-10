package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import java.util.ArrayList;

public class ReactTypefaceUtils {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int parseFontWeight(java.lang.String r2) {
        /*
            r0 = -1
            if (r2 == 0) goto L_0x009e
            int r1 = r2.hashCode()
            switch(r1) {
                case -1039745817: goto L_0x0074;
                case 48625: goto L_0x006a;
                case 49586: goto L_0x0060;
                case 50547: goto L_0x0056;
                case 51508: goto L_0x004c;
                case 52469: goto L_0x0042;
                case 53430: goto L_0x0038;
                case 54391: goto L_0x002d;
                case 55352: goto L_0x0022;
                case 56313: goto L_0x0017;
                case 3029637: goto L_0x000c;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x007e
        L_0x000c:
            java.lang.String r1 = "bold"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x007e
            r2 = 7
            goto L_0x007f
        L_0x0017:
            java.lang.String r1 = "900"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x007e
            r2 = 10
            goto L_0x007f
        L_0x0022:
            java.lang.String r1 = "800"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x007e
            r2 = 9
            goto L_0x007f
        L_0x002d:
            java.lang.String r1 = "700"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x007e
            r2 = 8
            goto L_0x007f
        L_0x0038:
            java.lang.String r1 = "600"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x007e
            r2 = 6
            goto L_0x007f
        L_0x0042:
            java.lang.String r1 = "500"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x007e
            r2 = 5
            goto L_0x007f
        L_0x004c:
            java.lang.String r1 = "400"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x007e
            r2 = 4
            goto L_0x007f
        L_0x0056:
            java.lang.String r1 = "300"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x007e
            r2 = 2
            goto L_0x007f
        L_0x0060:
            java.lang.String r1 = "200"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x007e
            r2 = 1
            goto L_0x007f
        L_0x006a:
            java.lang.String r1 = "100"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x007e
            r2 = 0
            goto L_0x007f
        L_0x0074:
            java.lang.String r1 = "normal"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x007e
            r2 = 3
            goto L_0x007f
        L_0x007e:
            r2 = -1
        L_0x007f:
            switch(r2) {
                case 0: goto L_0x009b;
                case 1: goto L_0x0098;
                case 2: goto L_0x0095;
                case 3: goto L_0x0092;
                case 4: goto L_0x0092;
                case 5: goto L_0x008f;
                case 6: goto L_0x008c;
                case 7: goto L_0x0089;
                case 8: goto L_0x0089;
                case 9: goto L_0x0086;
                case 10: goto L_0x0083;
                default: goto L_0x0082;
            }
        L_0x0082:
            goto L_0x009e
        L_0x0083:
            r2 = 900(0x384, float:1.261E-42)
            return r2
        L_0x0086:
            r2 = 800(0x320, float:1.121E-42)
            return r2
        L_0x0089:
            r2 = 700(0x2bc, float:9.81E-43)
            return r2
        L_0x008c:
            r2 = 600(0x258, float:8.41E-43)
            return r2
        L_0x008f:
            r2 = 500(0x1f4, float:7.0E-43)
            return r2
        L_0x0092:
            r2 = 400(0x190, float:5.6E-43)
            return r2
        L_0x0095:
            r2 = 300(0x12c, float:4.2E-43)
            return r2
        L_0x0098:
            r2 = 200(0xc8, float:2.8E-43)
            return r2
        L_0x009b:
            r2 = 100
            return r2
        L_0x009e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTypefaceUtils.parseFontWeight(java.lang.String):int");
    }

    public static int parseFontStyle(String str) {
        if (str == null) {
            return -1;
        }
        if ("italic".equals(str)) {
            return 2;
        }
        return "normal".equals(str) ? 0 : -1;
    }

    public static String parseFontVariant(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            if (string != null) {
                char c = 65535;
                switch (string.hashCode()) {
                    case -1195362251:
                        if (string.equals("proportional-nums")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1061392823:
                        if (string.equals("lining-nums")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -771984547:
                        if (string.equals("tabular-nums")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -659678800:
                        if (string.equals("oldstyle-nums")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1183323111:
                        if (string.equals("small-caps")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    arrayList.add("'smcp'");
                } else if (c == 1) {
                    arrayList.add("'onum'");
                } else if (c == 2) {
                    arrayList.add("'lnum'");
                } else if (c == 3) {
                    arrayList.add("'tnum'");
                } else if (c == 4) {
                    arrayList.add("'pnum'");
                }
            }
        }
        return TextUtils.join(", ", arrayList);
    }

    public static Typeface applyStyles(Typeface typeface, int i, int i2, String str, AssetManager assetManager) {
        TypefaceStyle typefaceStyle = new TypefaceStyle(i, i2);
        if (str != null) {
            return ReactFontManager.getInstance().getTypeface(str, typefaceStyle, assetManager);
        }
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        return typefaceStyle.apply(typeface);
    }
}
