package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface;

public class AndroidProgressBarManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidProgressBarManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidProgressBarManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = 0
            r2 = 1
            switch(r0) {
                case -1001078227: goto L_0x0046;
                case -877170387: goto L_0x003c;
                case -676876213: goto L_0x0032;
                case 94842723: goto L_0x0028;
                case 633138363: goto L_0x001e;
                case 1118509918: goto L_0x0014;
                case 1804741442: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0050
        L_0x000a:
            java.lang.String r0 = "styleAttr"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0050
            r0 = 0
            goto L_0x0051
        L_0x0014:
            java.lang.String r0 = "animating"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0050
            r0 = 4
            goto L_0x0051
        L_0x001e:
            java.lang.String r0 = "indeterminate"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0050
            r0 = 2
            goto L_0x0051
        L_0x0028:
            java.lang.String r0 = "color"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0050
            r0 = 5
            goto L_0x0051
        L_0x0032:
            java.lang.String r0 = "typeAttr"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0050
            r0 = 1
            goto L_0x0051
        L_0x003c:
            java.lang.String r0 = "testID"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0050
            r0 = 6
            goto L_0x0051
        L_0x0046:
            java.lang.String r0 = "progress"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0050
            r0 = 3
            goto L_0x0051
        L_0x0050:
            r0 = -1
        L_0x0051:
            r3 = 0
            switch(r0) {
                case 0: goto L_0x00bc;
                case 1: goto L_0x00ae;
                case 2: goto L_0x009d;
                case 3: goto L_0x008a;
                case 4: goto L_0x0079;
                case 5: goto L_0x0069;
                case 6: goto L_0x005a;
                default: goto L_0x0055;
            }
        L_0x0055:
            super.setProperty(r5, r6, r7)
            goto L_0x00c9
        L_0x005a:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x0063
            java.lang.String r7 = ""
            goto L_0x0065
        L_0x0063:
            java.lang.String r7 = (java.lang.String) r7
        L_0x0065:
            r6.setTestID(r5, r7)
            goto L_0x00c9
        L_0x0069:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            r6.setColor(r5, r7)
            goto L_0x00c9
        L_0x0079:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x0080
            goto L_0x0086
        L_0x0080:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r2 = r7.booleanValue()
        L_0x0086:
            r6.setAnimating(r5, r2)
            goto L_0x00c9
        L_0x008a:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x0093
            r0 = 0
            goto L_0x0099
        L_0x0093:
            java.lang.Double r7 = (java.lang.Double) r7
            double r0 = r7.doubleValue()
        L_0x0099:
            r6.setProgress(r5, r0)
            goto L_0x00c9
        L_0x009d:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x00a4
            goto L_0x00aa
        L_0x00a4:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x00aa:
            r6.setIndeterminate(r5, r1)
            goto L_0x00c9
        L_0x00ae:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x00b5
            goto L_0x00b8
        L_0x00b5:
            r3 = r7
            java.lang.String r3 = (java.lang.String) r3
        L_0x00b8:
            r6.setTypeAttr(r5, r3)
            goto L_0x00c9
        L_0x00bc:
            com.facebook.react.uimanager.BaseViewManagerInterface r6 = r4.mViewManager
            com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface r6 = (com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface) r6
            if (r7 != 0) goto L_0x00c3
            goto L_0x00c6
        L_0x00c3:
            r3 = r7
            java.lang.String r3 = (java.lang.String) r3
        L_0x00c6:
            r6.setStyleAttr(r5, r3)
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.AndroidProgressBarManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
