package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.SliderManagerInterface;

public class SliderManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & SliderManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public SliderManagerDelegate(U u) {
        super(u);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r6, java.lang.String r7, java.lang.Object r8) {
        /*
            r5 = this;
            int r0 = r7.hashCode()
            r1 = 0
            r2 = 1
            switch(r0) {
                case -1900655011: goto L_0x0098;
                case -1736983259: goto L_0x008d;
                case -1609594047: goto L_0x0083;
                case -1021497397: goto L_0x0079;
                case -981448432: goto L_0x006f;
                case -877170387: goto L_0x0064;
                case 3540684: goto L_0x0059;
                case 111972721: goto L_0x004d;
                case 270940796: goto L_0x0043;
                case 718061361: goto L_0x0039;
                case 1139400400: goto L_0x002d;
                case 1192487427: goto L_0x0022;
                case 1333596542: goto L_0x0017;
                case 1912319986: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x00a2
        L_0x000b:
            java.lang.String r0 = "thumbTintColor"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 11
            goto L_0x00a3
        L_0x0017:
            java.lang.String r0 = "minimumTrackImage"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 5
            goto L_0x00a3
        L_0x0022:
            java.lang.String r0 = "minimumValue"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 7
            goto L_0x00a3
        L_0x002d:
            java.lang.String r0 = "trackImage"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 12
            goto L_0x00a3
        L_0x0039:
            java.lang.String r0 = "maximumValue"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 4
            goto L_0x00a3
        L_0x0043:
            java.lang.String r0 = "disabled"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 0
            goto L_0x00a3
        L_0x004d:
            java.lang.String r0 = "value"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 13
            goto L_0x00a3
        L_0x0059:
            java.lang.String r0 = "step"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 8
            goto L_0x00a3
        L_0x0064:
            java.lang.String r0 = "testID"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 9
            goto L_0x00a3
        L_0x006f:
            java.lang.String r0 = "maximumTrackImage"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 2
            goto L_0x00a3
        L_0x0079:
            java.lang.String r0 = "minimumTrackTintColor"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 6
            goto L_0x00a3
        L_0x0083:
            java.lang.String r0 = "enabled"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 1
            goto L_0x00a3
        L_0x008d:
            java.lang.String r0 = "thumbImage"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 10
            goto L_0x00a3
        L_0x0098:
            java.lang.String r0 = "maximumTrackTintColor"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x00a2
            r0 = 3
            goto L_0x00a3
        L_0x00a2:
            r0 = -1
        L_0x00a3:
            r3 = 0
            switch(r0) {
                case 0: goto L_0x0172;
                case 1: goto L_0x0161;
                case 2: goto L_0x0157;
                case 3: goto L_0x0147;
                case 4: goto L_0x0134;
                case 5: goto L_0x012a;
                case 6: goto L_0x011a;
                case 7: goto L_0x0108;
                case 8: goto L_0x00f6;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00db;
                case 11: goto L_0x00ca;
                case 12: goto L_0x00bf;
                case 13: goto L_0x00ad;
                default: goto L_0x00a8;
            }
        L_0x00a8:
            super.setProperty(r6, r7, r8)
            goto L_0x0182
        L_0x00ad:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            if (r8 != 0) goto L_0x00b4
            goto L_0x00ba
        L_0x00b4:
            java.lang.Double r8 = (java.lang.Double) r8
            double r3 = r8.doubleValue()
        L_0x00ba:
            r7.setValue(r6, r3)
            goto L_0x0182
        L_0x00bf:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            com.facebook.react.bridge.ReadableMap r8 = (com.facebook.react.bridge.ReadableMap) r8
            r7.setTrackImage(r6, r8)
            goto L_0x0182
        L_0x00ca:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            android.content.Context r0 = r6.getContext()
            java.lang.Integer r8 = com.facebook.react.bridge.ColorPropConverter.getColor(r8, r0)
            r7.setThumbTintColor(r6, r8)
            goto L_0x0182
        L_0x00db:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            com.facebook.react.bridge.ReadableMap r8 = (com.facebook.react.bridge.ReadableMap) r8
            r7.setThumbImage(r6, r8)
            goto L_0x0182
        L_0x00e6:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            if (r8 != 0) goto L_0x00ef
            java.lang.String r8 = ""
            goto L_0x00f1
        L_0x00ef:
            java.lang.String r8 = (java.lang.String) r8
        L_0x00f1:
            r7.setTestID(r6, r8)
            goto L_0x0182
        L_0x00f6:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            if (r8 != 0) goto L_0x00fd
            goto L_0x0103
        L_0x00fd:
            java.lang.Double r8 = (java.lang.Double) r8
            double r3 = r8.doubleValue()
        L_0x0103:
            r7.setStep(r6, r3)
            goto L_0x0182
        L_0x0108:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            if (r8 != 0) goto L_0x010f
            goto L_0x0115
        L_0x010f:
            java.lang.Double r8 = (java.lang.Double) r8
            double r3 = r8.doubleValue()
        L_0x0115:
            r7.setMinimumValue(r6, r3)
            goto L_0x0182
        L_0x011a:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            android.content.Context r0 = r6.getContext()
            java.lang.Integer r8 = com.facebook.react.bridge.ColorPropConverter.getColor(r8, r0)
            r7.setMinimumTrackTintColor(r6, r8)
            goto L_0x0182
        L_0x012a:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            com.facebook.react.bridge.ReadableMap r8 = (com.facebook.react.bridge.ReadableMap) r8
            r7.setMinimumTrackImage(r6, r8)
            goto L_0x0182
        L_0x0134:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            if (r8 != 0) goto L_0x013d
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x0143
        L_0x013d:
            java.lang.Double r8 = (java.lang.Double) r8
            double r0 = r8.doubleValue()
        L_0x0143:
            r7.setMaximumValue(r6, r0)
            goto L_0x0182
        L_0x0147:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            android.content.Context r0 = r6.getContext()
            java.lang.Integer r8 = com.facebook.react.bridge.ColorPropConverter.getColor(r8, r0)
            r7.setMaximumTrackTintColor(r6, r8)
            goto L_0x0182
        L_0x0157:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            com.facebook.react.bridge.ReadableMap r8 = (com.facebook.react.bridge.ReadableMap) r8
            r7.setMaximumTrackImage(r6, r8)
            goto L_0x0182
        L_0x0161:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            if (r8 != 0) goto L_0x0168
            goto L_0x016e
        L_0x0168:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r2 = r8.booleanValue()
        L_0x016e:
            r7.setEnabled(r6, r2)
            goto L_0x0182
        L_0x0172:
            com.facebook.react.uimanager.BaseViewManagerInterface r7 = r5.mViewManager
            com.facebook.react.viewmanagers.SliderManagerInterface r7 = (com.facebook.react.viewmanagers.SliderManagerInterface) r7
            if (r8 != 0) goto L_0x0179
            goto L_0x017f
        L_0x0179:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r1 = r8.booleanValue()
        L_0x017f:
            r7.setDisabled(r6, r1)
        L_0x0182:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.SliderManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
