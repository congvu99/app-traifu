package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface;

public class PullToRefreshViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & PullToRefreshViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public PullToRefreshViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r6, java.lang.String r7, java.lang.Object r8) {
        /*
            r5 = this;
            int r0 = r7.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1799367701: goto L_0x002a;
                case -321826009: goto L_0x0020;
                case 110371416: goto L_0x0016;
                case 1327599912: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0034
        L_0x000c:
            java.lang.String r0 = "tintColor"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            goto L_0x0035
        L_0x0016:
            java.lang.String r0 = "title"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "refreshing"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 3
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "titleColor"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 == 0) goto L_0x0070
            if (r0 == r4) goto L_0x0060
            if (r0 == r3) goto L_0x0052
            if (r0 == r2) goto L_0x0041
            super.setProperty(r6, r7, r8)
            goto L_0x007f
        L_0x0041:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface r7 = (com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface) r7
            if (r8 != 0) goto L_0x0048
            goto L_0x004e
        L_0x0048:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r1 = r8.booleanValue()
        L_0x004e:
            r7.setRefreshing(r6, r1)
            goto L_0x007f
        L_0x0052:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface r7 = (com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface) r7
            if (r8 != 0) goto L_0x005a
            r8 = 0
            goto L_0x005c
        L_0x005a:
            java.lang.String r8 = (java.lang.String) r8
        L_0x005c:
            r7.setTitle(r6, r8)
            goto L_0x007f
        L_0x0060:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface r7 = (com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface) r7
            android.content.Context r0 = r6.getContext()
            java.lang.Integer r8 = com.facebook.react.bridge.ColorPropConverter.getColor(r8, r0)
            r7.setTitleColor(r6, r8)
            goto L_0x007f
        L_0x0070:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface r7 = (com.facebook.react.viewmanagers.PullToRefreshViewManagerInterface) r7
            android.content.Context r0 = r6.getContext()
            java.lang.Integer r8 = com.facebook.react.bridge.ColorPropConverter.getColor(r8, r0)
            r7.setTintColor(r6, r8)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.PullToRefreshViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }

    public void receiveCommand(PullToRefreshViewManagerInterface<T> pullToRefreshViewManagerInterface, T t, String str, ReadableArray readableArray) {
        if (((str.hashCode() == 513968928 && str.equals("setNativeRefreshing")) ? (char) 0 : 65535) == 0) {
            pullToRefreshViewManagerInterface.setNativeRefreshing(t, readableArray.getBoolean(0));
        }
    }
}
