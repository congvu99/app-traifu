package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidSwitchManagerInterface;

public class AndroidSwitchManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidSwitchManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidSwitchManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r4, java.lang.String r5, java.lang.Object r6) {
        /*
            r3 = this;
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1742453971: goto L_0x005c;
                case -1609594047: goto L_0x0052;
                case -287374307: goto L_0x0047;
                case 3551: goto L_0x003d;
                case 111972721: goto L_0x0032;
                case 270940796: goto L_0x0028;
                case 1084662482: goto L_0x001e;
                case 1912319986: goto L_0x0014;
                case 2113632767: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0066
        L_0x000a:
            java.lang.String r0 = "trackColorForTrue"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 4
            goto L_0x0067
        L_0x0014:
            java.lang.String r0 = "thumbTintColor"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 7
            goto L_0x0067
        L_0x001e:
            java.lang.String r0 = "trackColorForFalse"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 3
            goto L_0x0067
        L_0x0028:
            java.lang.String r0 = "disabled"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 0
            goto L_0x0067
        L_0x0032:
            java.lang.String r0 = "value"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 5
            goto L_0x0067
        L_0x003d:
            java.lang.String r0 = "on"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 6
            goto L_0x0067
        L_0x0047:
            java.lang.String r0 = "trackTintColor"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 8
            goto L_0x0067
        L_0x0052:
            java.lang.String r0 = "enabled"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 1
            goto L_0x0067
        L_0x005c:
            java.lang.String r0 = "thumbColor"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0066
            r0 = 2
            goto L_0x0067
        L_0x0066:
            r0 = -1
        L_0x0067:
            switch(r0) {
                case 0: goto L_0x00f4;
                case 1: goto L_0x00e3;
                case 2: goto L_0x00d3;
                case 3: goto L_0x00c3;
                case 4: goto L_0x00b3;
                case 5: goto L_0x00a2;
                case 6: goto L_0x0091;
                case 7: goto L_0x0080;
                case 8: goto L_0x006f;
                default: goto L_0x006a;
            }
        L_0x006a:
            super.setProperty(r4, r5, r6)
            goto L_0x0104
        L_0x006f:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r5
            android.content.Context r0 = r4.getContext()
            java.lang.Integer r6 = com.facebook.react.bridge.ColorPropConverter.getColor(r6, r0)
            r5.setTrackTintColor(r4, r6)
            goto L_0x0104
        L_0x0080:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r5
            android.content.Context r0 = r4.getContext()
            java.lang.Integer r6 = com.facebook.react.bridge.ColorPropConverter.getColor(r6, r0)
            r5.setThumbTintColor(r4, r6)
            goto L_0x0104
        L_0x0091:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r5
            if (r6 != 0) goto L_0x0098
            goto L_0x009e
        L_0x0098:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r2 = r6.booleanValue()
        L_0x009e:
            r5.setOn(r4, r2)
            goto L_0x0104
        L_0x00a2:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r5
            if (r6 != 0) goto L_0x00a9
            goto L_0x00af
        L_0x00a9:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r2 = r6.booleanValue()
        L_0x00af:
            r5.setValue(r4, r2)
            goto L_0x0104
        L_0x00b3:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r5
            android.content.Context r0 = r4.getContext()
            java.lang.Integer r6 = com.facebook.react.bridge.ColorPropConverter.getColor(r6, r0)
            r5.setTrackColorForTrue(r4, r6)
            goto L_0x0104
        L_0x00c3:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r5
            android.content.Context r0 = r4.getContext()
            java.lang.Integer r6 = com.facebook.react.bridge.ColorPropConverter.getColor(r6, r0)
            r5.setTrackColorForFalse(r4, r6)
            goto L_0x0104
        L_0x00d3:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r5
            android.content.Context r0 = r4.getContext()
            java.lang.Integer r6 = com.facebook.react.bridge.ColorPropConverter.getColor(r6, r0)
            r5.setThumbColor(r4, r6)
            goto L_0x0104
        L_0x00e3:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r5
            if (r6 != 0) goto L_0x00ea
            goto L_0x00f0
        L_0x00ea:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00f0:
            r5.setEnabled(r4, r1)
            goto L_0x0104
        L_0x00f4:
            com.facebook.react.uimanager.BaseViewManagerInterface r5 = r3.mViewManager
            com.facebook.react.viewmanagers.AndroidSwitchManagerInterface r5 = (com.facebook.react.viewmanagers.AndroidSwitchManagerInterface) r5
            if (r6 != 0) goto L_0x00fb
            goto L_0x0101
        L_0x00fb:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r2 = r6.booleanValue()
        L_0x0101:
            r5.setDisabled(r4, r2)
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidSwitchManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    public void receiveCommand(T t, String str, ReadableArray readableArray) {
        if (((str.hashCode() == -669744680 && str.equals("setNativeValue")) ? (char) 0 : 65535) == 0) {
            ((AndroidSwitchManagerInterface) this.mViewManager).setNativeValue(t, readableArray.getBoolean(0));
        }
    }
}
