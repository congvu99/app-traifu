package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.ModalHostViewManagerInterface;

public class ModalHostViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ModalHostViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public ModalHostViewManagerDelegate(U u) {
        super(u);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: boolean} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(T r3, java.lang.String r4, java.lang.Object r5) {
        /*
            r2 = this;
            int r0 = r4.hashCode()
            r1 = 0
            switch(r0) {
                case -1851617609: goto L_0x005b;
                case -1850124175: goto L_0x0051;
                case -1726194350: goto L_0x0047;
                case -1618432855: goto L_0x003c;
                case -1156137512: goto L_0x0032;
                case -795203165: goto L_0x0028;
                case 466743410: goto L_0x001d;
                case 1195991583: goto L_0x0013;
                case 2031205598: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0065
        L_0x0009:
            java.lang.String r0 = "animationType"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0065
            r0 = 0
            goto L_0x0066
        L_0x0013:
            java.lang.String r0 = "hardwareAccelerated"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0065
            r0 = 4
            goto L_0x0066
        L_0x001d:
            java.lang.String r0 = "visible"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0065
            r0 = 5
            goto L_0x0066
        L_0x0028:
            java.lang.String r0 = "animated"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0065
            r0 = 6
            goto L_0x0066
        L_0x0032:
            java.lang.String r0 = "statusBarTranslucent"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0065
            r0 = 3
            goto L_0x0066
        L_0x003c:
            java.lang.String r0 = "identifier"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0065
            r0 = 8
            goto L_0x0066
        L_0x0047:
            java.lang.String r0 = "transparent"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0065
            r0 = 2
            goto L_0x0066
        L_0x0051:
            java.lang.String r0 = "supportedOrientations"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0065
            r0 = 7
            goto L_0x0066
        L_0x005b:
            java.lang.String r0 = "presentationStyle"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0065
            r0 = 1
            goto L_0x0066
        L_0x0065:
            r0 = -1
        L_0x0066:
            switch(r0) {
                case 0: goto L_0x00ea;
                case 1: goto L_0x00e0;
                case 2: goto L_0x00cf;
                case 3: goto L_0x00be;
                case 4: goto L_0x00ad;
                case 5: goto L_0x009c;
                case 6: goto L_0x008b;
                case 7: goto L_0x0080;
                case 8: goto L_0x006e;
                default: goto L_0x0069;
            }
        L_0x0069:
            super.setProperty(r3, r4, r5)
            goto L_0x00f3
        L_0x006e:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            if (r5 != 0) goto L_0x0075
            goto L_0x007b
        L_0x0075:
            java.lang.Double r5 = (java.lang.Double) r5
            int r1 = r5.intValue()
        L_0x007b:
            r4.setIdentifier(r3, r1)
            goto L_0x00f3
        L_0x0080:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            com.facebook.react.bridge.ReadableArray r5 = (com.facebook.react.bridge.ReadableArray) r5
            r4.setSupportedOrientations(r3, r5)
            goto L_0x00f3
        L_0x008b:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            if (r5 != 0) goto L_0x0092
            goto L_0x0098
        L_0x0092:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r1 = r5.booleanValue()
        L_0x0098:
            r4.setAnimated(r3, r1)
            goto L_0x00f3
        L_0x009c:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            if (r5 != 0) goto L_0x00a3
            goto L_0x00a9
        L_0x00a3:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r1 = r5.booleanValue()
        L_0x00a9:
            r4.setVisible(r3, r1)
            goto L_0x00f3
        L_0x00ad:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            if (r5 != 0) goto L_0x00b4
            goto L_0x00ba
        L_0x00b4:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r1 = r5.booleanValue()
        L_0x00ba:
            r4.setHardwareAccelerated(r3, r1)
            goto L_0x00f3
        L_0x00be:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            if (r5 != 0) goto L_0x00c5
            goto L_0x00cb
        L_0x00c5:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r1 = r5.booleanValue()
        L_0x00cb:
            r4.setStatusBarTranslucent(r3, r1)
            goto L_0x00f3
        L_0x00cf:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            if (r5 != 0) goto L_0x00d6
            goto L_0x00dc
        L_0x00d6:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r1 = r5.booleanValue()
        L_0x00dc:
            r4.setTransparent(r3, r1)
            goto L_0x00f3
        L_0x00e0:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            java.lang.String r5 = (java.lang.String) r5
            r4.setPresentationStyle(r3, r5)
            goto L_0x00f3
        L_0x00ea:
            com.facebook.react.uimanager.BaseViewManagerInterface r4 = r2.mViewManager
            com.facebook.react.viewmanagers.ModalHostViewManagerInterface r4 = (com.facebook.react.viewmanagers.ModalHostViewManagerInterface) r4
            java.lang.String r5 = (java.lang.String) r5
            r4.setAnimationType(r3, r5)
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.viewmanagers.ModalHostViewManagerDelegate.setProperty(android.view.View, java.lang.String, java.lang.Object):void");
    }
}
