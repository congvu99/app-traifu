package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.DatePickerManagerInterface;

public class DatePickerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & DatePickerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public DatePickerManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, java.lang.Object r6) {
        /*
            r3 = this;
            int r0 = r5.hashCode()
            r1 = 1
            switch(r0) {
                case -1339516167: goto L_0x004f;
                case -1097462182: goto L_0x0045;
                case -292758706: goto L_0x003b;
                case 3076014: goto L_0x0031;
                case 3357091: goto L_0x0027;
                case 1007762652: goto L_0x001d;
                case 1232894226: goto L_0x0013;
                case 1685195246: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0059
        L_0x0009:
            java.lang.String r0 = "maximumDate"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 3
            goto L_0x005a
        L_0x0013:
            java.lang.String r0 = "initialDate"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 1
            goto L_0x005a
        L_0x001d:
            java.lang.String r0 = "minimumDate"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 4
            goto L_0x005a
        L_0x0027:
            java.lang.String r0 = "mode"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 6
            goto L_0x005a
        L_0x0031:
            java.lang.String r0 = "date"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 0
            goto L_0x005a
        L_0x003b:
            java.lang.String r0 = "timeZoneOffsetInMinutes"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 7
            goto L_0x005a
        L_0x0045:
            java.lang.String r0 = "locale"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 2
            goto L_0x005a
        L_0x004f:
            java.lang.String r0 = "minuteInterval"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0059
            r0 = 5
            goto L_0x005a
        L_0x0059:
            r0 = -1
        L_0x005a:
            r2 = 0
            switch(r0) {
                case 0: goto L_0x00d6;
                case 1: goto L_0x00c5;
                case 2: goto L_0x00b7;
                case 3: goto L_0x00a6;
                case 4: goto L_0x0095;
                case 5: goto L_0x0080;
                case 6: goto L_0x0075;
                case 7: goto L_0x0063;
                default: goto L_0x005e;
            }
        L_0x005e:
            super.setProperty(r4, r5, r6)
            goto L_0x00e6
        L_0x0063:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.DatePickerManagerInterface r5 = (com.facebook.react.viewmanagers.DatePickerManagerInterface) r5
            if (r6 != 0) goto L_0x006a
            goto L_0x0070
        L_0x006a:
            java.lang.Double r6 = (java.lang.Double) r6
            float r2 = r6.floatValue()
        L_0x0070:
            r5.setTimeZoneOffsetInMinutes(r4, r2)
            goto L_0x00e6
        L_0x0075:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.DatePickerManagerInterface r5 = (com.facebook.react.viewmanagers.DatePickerManagerInterface) r5
            java.lang.String r6 = (java.lang.String) r6
            r5.setMode(r4, r6)
            goto L_0x00e6
        L_0x0080:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.DatePickerManagerInterface r5 = (com.facebook.react.viewmanagers.DatePickerManagerInterface) r5
            if (r6 != 0) goto L_0x0087
            goto L_0x008d
        L_0x0087:
            java.lang.Double r6 = (java.lang.Double) r6
            int r1 = r6.intValue()
        L_0x008d:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            r5.setMinuteInterval(r4, r6)
            goto L_0x00e6
        L_0x0095:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.DatePickerManagerInterface r5 = (com.facebook.react.viewmanagers.DatePickerManagerInterface) r5
            if (r6 != 0) goto L_0x009c
            goto L_0x00a2
        L_0x009c:
            java.lang.Double r6 = (java.lang.Double) r6
            float r2 = r6.floatValue()
        L_0x00a2:
            r5.setMinimumDate(r4, r2)
            goto L_0x00e6
        L_0x00a6:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.DatePickerManagerInterface r5 = (com.facebook.react.viewmanagers.DatePickerManagerInterface) r5
            if (r6 != 0) goto L_0x00ad
            goto L_0x00b3
        L_0x00ad:
            java.lang.Double r6 = (java.lang.Double) r6
            float r2 = r6.floatValue()
        L_0x00b3:
            r5.setMaximumDate(r4, r2)
            goto L_0x00e6
        L_0x00b7:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.DatePickerManagerInterface r5 = (com.facebook.react.viewmanagers.DatePickerManagerInterface) r5
            if (r6 != 0) goto L_0x00bf
            r6 = 0
            goto L_0x00c1
        L_0x00bf:
            java.lang.String r6 = (java.lang.String) r6
        L_0x00c1:
            r5.setLocale(r4, r6)
            goto L_0x00e6
        L_0x00c5:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.DatePickerManagerInterface r5 = (com.facebook.react.viewmanagers.DatePickerManagerInterface) r5
            if (r6 != 0) goto L_0x00cc
            goto L_0x00d2
        L_0x00cc:
            java.lang.Double r6 = (java.lang.Double) r6
            float r2 = r6.floatValue()
        L_0x00d2:
            r5.setInitialDate(r4, r2)
            goto L_0x00e6
        L_0x00d6:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.DatePickerManagerInterface r5 = (com.facebook.react.viewmanagers.DatePickerManagerInterface) r5
            if (r6 != 0) goto L_0x00dd
            goto L_0x00e3
        L_0x00dd:
            java.lang.Double r6 = (java.lang.Double) r6
            float r2 = r6.floatValue()
        L_0x00e3:
            r5.setDate(r4, r2)
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.DatePickerManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    public void receiveCommand(DatePickerManagerInterface<T> datePickerManagerInterface, T t, String str, ReadableArray readableArray) {
        if (((str.hashCode() == -714877337 && str.equals("setNativeDate")) ? (char) 0 : 65535) == 0) {
            datePickerManagerInterface.setNativeDate(t, (float) readableArray.getDouble(0));
        }
    }
}
