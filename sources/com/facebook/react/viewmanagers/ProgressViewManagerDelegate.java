package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.ProgressViewManagerInterface;

public class ProgressViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ProgressViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public ProgressViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r7, java.lang.String r8, java.lang.Object r9) {
        /*
            r6 = this;
            int r0 = r8.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1948954017: goto L_0x003f;
                case -1001078227: goto L_0x0035;
                case -287374307: goto L_0x002b;
                case 760630062: goto L_0x0021;
                case 962728315: goto L_0x0017;
                case 1139400400: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0049
        L_0x000d:
            java.lang.String r0 = "trackImage"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0049
            r0 = 5
            goto L_0x004a
        L_0x0017:
            java.lang.String r0 = "progressTintColor"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0049
            r0 = 2
            goto L_0x004a
        L_0x0021:
            java.lang.String r0 = "progressImage"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0049
            r0 = 4
            goto L_0x004a
        L_0x002b:
            java.lang.String r0 = "trackTintColor"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0049
            r0 = 3
            goto L_0x004a
        L_0x0035:
            java.lang.String r0 = "progress"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0049
            r0 = 1
            goto L_0x004a
        L_0x003f:
            java.lang.String r0 = "progressViewStyle"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0049
            r0 = 0
            goto L_0x004a
        L_0x0049:
            r0 = -1
        L_0x004a:
            if (r0 == 0) goto L_0x00a0
            if (r0 == r5) goto L_0x008e
            if (r0 == r4) goto L_0x007e
            if (r0 == r3) goto L_0x006e
            if (r0 == r2) goto L_0x0064
            if (r0 == r1) goto L_0x005a
            super.setProperty(r7, r8, r9)
            goto L_0x00a9
        L_0x005a:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.ProgressViewManagerInterface r8 = (com.facebook.react.viewmanagers.ProgressViewManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setTrackImage(r7, r9)
            goto L_0x00a9
        L_0x0064:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.ProgressViewManagerInterface r8 = (com.facebook.react.viewmanagers.ProgressViewManagerInterface) r8
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9
            r8.setProgressImage(r7, r9)
            goto L_0x00a9
        L_0x006e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.ProgressViewManagerInterface r8 = (com.facebook.react.viewmanagers.ProgressViewManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setTrackTintColor(r7, r9)
            goto L_0x00a9
        L_0x007e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.ProgressViewManagerInterface r8 = (com.facebook.react.viewmanagers.ProgressViewManagerInterface) r8
            android.content.Context r0 = r7.getContext()
            java.lang.Integer r9 = com.facebook.react.bridge.ColorPropConverter.getColor(r9, r0)
            r8.setProgressTintColor(r7, r9)
            goto L_0x00a9
        L_0x008e:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.ProgressViewManagerInterface r8 = (com.facebook.react.viewmanagers.ProgressViewManagerInterface) r8
            if (r9 != 0) goto L_0x0096
            r9 = 0
            goto L_0x009c
        L_0x0096:
            java.lang.Double r9 = (java.lang.Double) r9
            float r9 = r9.floatValue()
        L_0x009c:
            r8.setProgress(r7, r9)
            goto L_0x00a9
        L_0x00a0:
            com.facebook.react.uimanager.BaseViewManagerInterface r8 = r6.mViewManager
            com.facebook.react.viewmanagers.ProgressViewManagerInterface r8 = (com.facebook.react.viewmanagers.ProgressViewManagerInterface) r8
            java.lang.String r9 = (java.lang.String) r9
            r8.setProgressViewStyle(r7, r9)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.ProgressViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
