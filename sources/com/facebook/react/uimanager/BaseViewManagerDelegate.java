package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerInterface;

public abstract class BaseViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T>> implements ViewManagerDelegate<T> {
    protected final U mViewManager;

    public void receiveCommand(T t, String str, ReadableArray readableArray) {
    }

    public BaseViewManagerDelegate(U u) {
        this.mViewManager = u;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = 0
            switch(r0) {
                case -1721943862: goto L_0x0127;
                case -1721943861: goto L_0x011c;
                case -1589741021: goto L_0x0111;
                case -1267206133: goto L_0x0106;
                case -1228066334: goto L_0x00fb;
                case -908189618: goto L_0x00f0;
                case -908189617: goto L_0x00e5;
                case -877170387: goto L_0x00da;
                case -731417480: goto L_0x00ce;
                case -101663499: goto L_0x00c3;
                case -101359900: goto L_0x00b8;
                case -80891667: goto L_0x00ac;
                case -40300674: goto L_0x00a0;
                case -4379043: goto L_0x0094;
                case 36255470: goto L_0x0089;
                case 333432965: goto L_0x007d;
                case 581268560: goto L_0x0071;
                case 588239831: goto L_0x0065;
                case 746986311: goto L_0x0059;
                case 1052666732: goto L_0x004d;
                case 1146842694: goto L_0x0042;
                case 1153872867: goto L_0x0037;
                case 1287124693: goto L_0x002c;
                case 1349188574: goto L_0x0021;
                case 1505602511: goto L_0x0016;
                case 2045685618: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0132
        L_0x000a:
            java.lang.String r0 = "nativeID"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 15
            goto L_0x0133
        L_0x0016:
            java.lang.String r0 = "accessibilityActions"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 0
            goto L_0x0133
        L_0x0021:
            java.lang.String r0 = "borderRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 7
            goto L_0x0133
        L_0x002c:
            java.lang.String r0 = "backgroundColor"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 6
            goto L_0x0133
        L_0x0037:
            java.lang.String r0 = "accessibilityState"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 5
            goto L_0x0133
        L_0x0042:
            java.lang.String r0 = "accessibilityLabel"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 2
            goto L_0x0133
        L_0x004d:
            java.lang.String r0 = "transform"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 22
            goto L_0x0133
        L_0x0059:
            java.lang.String r0 = "importantForAccessibility"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 14
            goto L_0x0133
        L_0x0065:
            java.lang.String r0 = "borderBottomRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 9
            goto L_0x0133
        L_0x0071:
            java.lang.String r0 = "borderBottomLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 8
            goto L_0x0133
        L_0x007d:
            java.lang.String r0 = "borderTopRightRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 11
            goto L_0x0133
        L_0x0089:
            java.lang.String r0 = "accessibilityLiveRegion"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 3
            goto L_0x0133
        L_0x0094:
            java.lang.String r0 = "elevation"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 12
            goto L_0x0133
        L_0x00a0:
            java.lang.String r0 = "rotation"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 18
            goto L_0x0133
        L_0x00ac:
            java.lang.String r0 = "renderToHardwareTextureAndroid"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 17
            goto L_0x0133
        L_0x00b8:
            java.lang.String r0 = "accessibilityRole"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 4
            goto L_0x0133
        L_0x00c3:
            java.lang.String r0 = "accessibilityHint"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 1
            goto L_0x0133
        L_0x00ce:
            java.lang.String r0 = "zIndex"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 25
            goto L_0x0133
        L_0x00da:
            java.lang.String r0 = "testID"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 21
            goto L_0x0133
        L_0x00e5:
            java.lang.String r0 = "scaleY"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 20
            goto L_0x0133
        L_0x00f0:
            java.lang.String r0 = "scaleX"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 19
            goto L_0x0133
        L_0x00fb:
            java.lang.String r0 = "borderTopLeftRadius"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 10
            goto L_0x0133
        L_0x0106:
            java.lang.String r0 = "opacity"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 16
            goto L_0x0133
        L_0x0111:
            java.lang.String r0 = "shadowColor"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 13
            goto L_0x0133
        L_0x011c:
            java.lang.String r0 = "translateY"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 24
            goto L_0x0133
        L_0x0127:
            java.lang.String r0 = "translateX"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0132
            r6 = 23
            goto L_0x0133
        L_0x0132:
            r6 = -1
        L_0x0133:
            r0 = 1065353216(0x3f800000, float:1.0)
            r2 = 0
            r3 = 2143289344(0x7fc00000, float:NaN)
            switch(r6) {
                case 0: goto L_0x0291;
                case 1: goto L_0x0289;
                case 2: goto L_0x0281;
                case 3: goto L_0x0279;
                case 4: goto L_0x0271;
                case 5: goto L_0x0269;
                case 6: goto L_0x0254;
                case 7: goto L_0x0245;
                case 8: goto L_0x0236;
                case 9: goto L_0x0227;
                case 10: goto L_0x0217;
                case 11: goto L_0x0207;
                case 12: goto L_0x01f7;
                case 13: goto L_0x01e1;
                case 14: goto L_0x01d8;
                case 15: goto L_0x01cf;
                case 16: goto L_0x01bf;
                case 17: goto L_0x01af;
                case 18: goto L_0x019f;
                case 19: goto L_0x018f;
                case 20: goto L_0x017f;
                case 21: goto L_0x0176;
                case 22: goto L_0x016d;
                case 23: goto L_0x015d;
                case 24: goto L_0x014d;
                case 25: goto L_0x013d;
                default: goto L_0x013b;
            }
        L_0x013b:
            goto L_0x0298
        L_0x013d:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0142
            goto L_0x0148
        L_0x0142:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x0148:
            r6.setZIndex(r5, r2)
            goto L_0x0298
        L_0x014d:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0152
            goto L_0x0158
        L_0x0152:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x0158:
            r6.setTranslateY(r5, r2)
            goto L_0x0298
        L_0x015d:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0162
            goto L_0x0168
        L_0x0162:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x0168:
            r6.setTranslateX(r5, r2)
            goto L_0x0298
        L_0x016d:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setTransform(r5, r7)
            goto L_0x0298
        L_0x0176:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setTestId(r5, r7)
            goto L_0x0298
        L_0x017f:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0184
            goto L_0x018a
        L_0x0184:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x018a:
            r6.setScaleY(r5, r0)
            goto L_0x0298
        L_0x018f:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0194
            goto L_0x019a
        L_0x0194:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x019a:
            r6.setScaleX(r5, r0)
            goto L_0x0298
        L_0x019f:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01a4
            goto L_0x01aa
        L_0x01a4:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x01aa:
            r6.setRotation(r5, r2)
            goto L_0x0298
        L_0x01af:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01b4
            goto L_0x01ba
        L_0x01b4:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r1 = r7.booleanValue()
        L_0x01ba:
            r6.setRenderToHardwareTexture(r5, r1)
            goto L_0x0298
        L_0x01bf:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01c4
            goto L_0x01ca
        L_0x01c4:
            java.lang.Double r7 = (java.lang.Double) r7
            float r0 = r7.floatValue()
        L_0x01ca:
            r6.setOpacity(r5, r0)
            goto L_0x0298
        L_0x01cf:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setNativeId(r5, r7)
            goto L_0x0298
        L_0x01d8:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setImportantForAccessibility(r5, r7)
            goto L_0x0298
        L_0x01e1:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01e6
            goto L_0x01f2
        L_0x01e6:
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            int r1 = r7.intValue()
        L_0x01f2:
            r6.setShadowColor(r5, r1)
            goto L_0x0298
        L_0x01f7:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x01fc
            goto L_0x0202
        L_0x01fc:
            java.lang.Double r7 = (java.lang.Double) r7
            float r2 = r7.floatValue()
        L_0x0202:
            r6.setElevation(r5, r2)
            goto L_0x0298
        L_0x0207:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x020c
            goto L_0x0212
        L_0x020c:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0212:
            r6.setBorderTopRightRadius(r5, r3)
            goto L_0x0298
        L_0x0217:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x021c
            goto L_0x0222
        L_0x021c:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0222:
            r6.setBorderTopLeftRadius(r5, r3)
            goto L_0x0298
        L_0x0227:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x022c
            goto L_0x0232
        L_0x022c:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0232:
            r6.setBorderBottomRightRadius(r5, r3)
            goto L_0x0298
        L_0x0236:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x023b
            goto L_0x0241
        L_0x023b:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0241:
            r6.setBorderBottomLeftRadius(r5, r3)
            goto L_0x0298
        L_0x0245:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x024a
            goto L_0x0250
        L_0x024a:
            java.lang.Double r7 = (java.lang.Double) r7
            float r3 = r7.floatValue()
        L_0x0250:
            r6.setBorderRadius(r5, r3)
            goto L_0x0298
        L_0x0254:
            U r6 = r4.mViewManager
            if (r7 != 0) goto L_0x0259
            goto L_0x0265
        L_0x0259:
            android.content.Context r0 = r5.getContext()
            java.lang.Integer r7 = com.facebook.react.bridge.ColorPropConverter.getColor(r7, r0)
            int r1 = r7.intValue()
        L_0x0265:
            r6.setBackgroundColor(r5, r1)
            goto L_0x0298
        L_0x0269:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableMap r7 = (com.facebook.react.bridge.ReadableMap) r7
            r6.setViewState(r5, r7)
            goto L_0x0298
        L_0x0271:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityRole(r5, r7)
            goto L_0x0298
        L_0x0279:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLiveRegion(r5, r7)
            goto L_0x0298
        L_0x0281:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityLabel(r5, r7)
            goto L_0x0298
        L_0x0289:
            U r6 = r4.mViewManager
            java.lang.String r7 = (java.lang.String) r7
            r6.setAccessibilityHint(r5, r7)
            goto L_0x0298
        L_0x0291:
            U r6 = r4.mViewManager
            com.facebook.react.bridge.ReadableArray r7 = (com.facebook.react.bridge.ReadableArray) r7
            r6.setAccessibilityActions(r5, r7)
        L_0x0298:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.BaseViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
