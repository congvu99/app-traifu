package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.SwitchManagerInterface;

public class SwitchManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & SwitchManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public SwitchManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r3, java.lang.String r4, java.lang.Object r5) {
        /*
            r2 = this;
            int r0 = r4.hashCode()
            r1 = 0
            switch(r0) {
                case -1742453971: goto L_0x0050;
                case 111972721: goto L_0x0045;
                case 270940796: goto L_0x003b;
                case 1084662482: goto L_0x0031;
                case 1296813577: goto L_0x0027;
                case 1327599912: goto L_0x001d;
                case 1912319986: goto L_0x0013;
                case 2113632767: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x005a
        L_0x0009:
            java.lang.String r0 = "trackColorForTrue"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 7
            goto L_0x005b
        L_0x0013:
            java.lang.String r0 = "thumbTintColor"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 4
            goto L_0x005b
        L_0x001d:
            java.lang.String r0 = "tintColor"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 2
            goto L_0x005b
        L_0x0027:
            java.lang.String r0 = "onTintColor"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 3
            goto L_0x005b
        L_0x0031:
            java.lang.String r0 = "trackColorForFalse"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 6
            goto L_0x005b
        L_0x003b:
            java.lang.String r0 = "disabled"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 0
            goto L_0x005b
        L_0x0045:
            java.lang.String r0 = "value"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 1
            goto L_0x005b
        L_0x0050:
            java.lang.String r0 = "thumbColor"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x005a
            r0 = 5
            goto L_0x005b
        L_0x005a:
            r0 = -1
        L_0x005b:
            switch(r0) {
                case 0: goto L_0x00d5;
                case 1: goto L_0x00c4;
                case 2: goto L_0x00b4;
                case 3: goto L_0x00a4;
                case 4: goto L_0x0094;
                case 5: goto L_0x0084;
                case 6: goto L_0x0074;
                case 7: goto L_0x0063;
                default: goto L_0x005e;
            }
        L_0x005e:
            super.setProperty(r3, r4, r5)
            goto L_0x00e5
        L_0x0063:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r4 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r4
            android.content.Context r0 = r3.getContext()
            java.lang.Integer r5 = com.facebook.react.bridge.ColorPropConverter.getColor(r5, r0)
            r4.setTrackColorForTrue(r3, r5)
            goto L_0x00e5
        L_0x0074:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r4 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r4
            android.content.Context r0 = r3.getContext()
            java.lang.Integer r5 = com.facebook.react.bridge.ColorPropConverter.getColor(r5, r0)
            r4.setTrackColorForFalse(r3, r5)
            goto L_0x00e5
        L_0x0084:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r4 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r4
            android.content.Context r0 = r3.getContext()
            java.lang.Integer r5 = com.facebook.react.bridge.ColorPropConverter.getColor(r5, r0)
            r4.setThumbColor(r3, r5)
            goto L_0x00e5
        L_0x0094:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r4 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r4
            android.content.Context r0 = r3.getContext()
            java.lang.Integer r5 = com.facebook.react.bridge.ColorPropConverter.getColor(r5, r0)
            r4.setThumbTintColor(r3, r5)
            goto L_0x00e5
        L_0x00a4:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r4 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r4
            android.content.Context r0 = r3.getContext()
            java.lang.Integer r5 = com.facebook.react.bridge.ColorPropConverter.getColor(r5, r0)
            r4.setOnTintColor(r3, r5)
            goto L_0x00e5
        L_0x00b4:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r4 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r4
            android.content.Context r0 = r3.getContext()
            java.lang.Integer r5 = com.facebook.react.bridge.ColorPropConverter.getColor(r5, r0)
            r4.setTintColor(r3, r5)
            goto L_0x00e5
        L_0x00c4:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r4 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r4
            if (r5 != 0) goto L_0x00cb
            goto L_0x00d1
        L_0x00cb:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r1 = r5.booleanValue()
        L_0x00d1:
            r4.setValue(r3, r1)
            goto L_0x00e5
        L_0x00d5:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.SwitchManagerInterface r4 = (com.facebook.react.viewmanagers.SwitchManagerInterface) r4
            if (r5 != 0) goto L_0x00dc
            goto L_0x00e2
        L_0x00dc:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r1 = r5.booleanValue()
        L_0x00e2:
            r4.setDisabled(r3, r1)
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.SwitchManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    public void receiveCommand(T t, String str, ReadableArray readableArray) {
        if (((str.hashCode() == 1406685743 && str.equals("setValue")) ? (char) 0 : 65535) == 0) {
            ((SwitchManagerInterface) this.mViewManager).setValue(t, readableArray.getBoolean(0));
        }
    }
}
