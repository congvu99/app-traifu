package com.facebook.react.shell;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.BlobModule;
import com.facebook.react.modules.blob.FileReaderModule;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.sound.SoundManagerModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.storage.AsyncStorageModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.slider.ReactSliderManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.unimplementedview.ReactUnimplementedViewManager;
import com.facebook.react.views.view.ReactViewManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainReactPackage extends TurboReactPackage {
    private MainPackageConfig mConfig;

    public MainReactPackage() {
    }

    public MainReactPackage(MainPackageConfig mainPackageConfig) {
        this.mConfig = mainPackageConfig;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.NativeModule getModule(java.lang.String r4, com.facebook.react.bridge.ReactApplicationContext r5) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            switch(r0) {
                case -2115067288: goto L_0x0102;
                case -2033388651: goto L_0x00f8;
                case -1962922905: goto L_0x00ed;
                case -1850625090: goto L_0x00e2;
                case -1654566518: goto L_0x00d7;
                case -1344126773: goto L_0x00cd;
                case -1062061717: goto L_0x00c2;
                case -657277650: goto L_0x00b7;
                case -570370161: goto L_0x00ac;
                case -504784764: goto L_0x00a1;
                case -457866500: goto L_0x0096;
                case -382654004: goto L_0x008a;
                case -254310125: goto L_0x007e;
                case 163245714: goto L_0x0072;
                case 174691539: goto L_0x0067;
                case 403570038: goto L_0x005c;
                case 563961875: goto L_0x0050;
                case 1221389072: goto L_0x0045;
                case 1515242260: goto L_0x0039;
                case 1547941001: goto L_0x002e;
                case 1555425035: goto L_0x0022;
                case 1721274886: goto L_0x0016;
                case 1922110066: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x010d
        L_0x000a:
            java.lang.String r0 = "Vibration"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 21
            goto L_0x010e
        L_0x0016:
            java.lang.String r0 = "NativeAnimatedModule"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 14
            goto L_0x010e
        L_0x0022:
            java.lang.String r0 = "ShareModule"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 17
            goto L_0x010e
        L_0x002e:
            java.lang.String r0 = "BlobModule"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 3
            goto L_0x010e
        L_0x0039:
            java.lang.String r0 = "Networking"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 15
            goto L_0x010e
        L_0x0045:
            java.lang.String r0 = "AppState"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 2
            goto L_0x010e
        L_0x0050:
            java.lang.String r0 = "IntentAndroid"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 13
            goto L_0x010e
        L_0x005c:
            java.lang.String r0 = "Clipboard"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 6
            goto L_0x010e
        L_0x0067:
            java.lang.String r0 = "DatePickerAndroid"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 7
            goto L_0x010e
        L_0x0072:
            java.lang.String r0 = "FrescoModule"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 9
            goto L_0x010e
        L_0x007e:
            java.lang.String r0 = "WebSocketModule"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 22
            goto L_0x010e
        L_0x008a:
            java.lang.String r0 = "StatusBarManager"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 18
            goto L_0x010e
        L_0x0096:
            java.lang.String r0 = "AccessibilityInfo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 0
            goto L_0x010e
        L_0x00a1:
            java.lang.String r0 = "Appearance"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 1
            goto L_0x010e
        L_0x00ac:
            java.lang.String r0 = "I18nManager"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 10
            goto L_0x010e
        L_0x00b7:
            java.lang.String r0 = "ImageLoader"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 11
            goto L_0x010e
        L_0x00c2:
            java.lang.String r0 = "PermissionsAndroid"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 16
            goto L_0x010e
        L_0x00cd:
            java.lang.String r0 = "FileReaderModule"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 4
            goto L_0x010e
        L_0x00d7:
            java.lang.String r0 = "DialogManagerAndroid"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 8
            goto L_0x010e
        L_0x00e2:
            java.lang.String r0 = "SoundManager"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 19
            goto L_0x010e
        L_0x00ed:
            java.lang.String r0 = "ImageStoreManager"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 12
            goto L_0x010e
        L_0x00f8:
            java.lang.String r0 = "AsyncSQLiteDBStorage"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 5
            goto L_0x010e
        L_0x0102:
            java.lang.String r0 = "ToastAndroid"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x010d
            r4 = 20
            goto L_0x010e
        L_0x010d:
            r4 = -1
        L_0x010e:
            r0 = 0
            switch(r4) {
                case 0: goto L_0x019f;
                case 1: goto L_0x0199;
                case 2: goto L_0x0193;
                case 3: goto L_0x018d;
                case 4: goto L_0x0187;
                case 5: goto L_0x0181;
                case 6: goto L_0x017b;
                case 7: goto L_0x0175;
                case 8: goto L_0x016f;
                case 9: goto L_0x0161;
                case 10: goto L_0x015b;
                case 11: goto L_0x0155;
                case 12: goto L_0x014f;
                case 13: goto L_0x0149;
                case 14: goto L_0x0143;
                case 15: goto L_0x013d;
                case 16: goto L_0x0137;
                case 17: goto L_0x0131;
                case 18: goto L_0x012b;
                case 19: goto L_0x0125;
                case 20: goto L_0x011f;
                case 21: goto L_0x0119;
                case 22: goto L_0x0113;
                default: goto L_0x0112;
            }
        L_0x0112:
            return r0
        L_0x0113:
            com.facebook.react.modules.websocket.WebSocketModule r4 = new com.facebook.react.modules.websocket.WebSocketModule
            r4.<init>(r5)
            return r4
        L_0x0119:
            com.facebook.react.modules.vibration.VibrationModule r4 = new com.facebook.react.modules.vibration.VibrationModule
            r4.<init>(r5)
            return r4
        L_0x011f:
            com.facebook.react.modules.toast.ToastModule r4 = new com.facebook.react.modules.toast.ToastModule
            r4.<init>(r5)
            return r4
        L_0x0125:
            com.facebook.react.modules.sound.SoundManagerModule r4 = new com.facebook.react.modules.sound.SoundManagerModule
            r4.<init>(r5)
            return r4
        L_0x012b:
            com.facebook.react.modules.statusbar.StatusBarModule r4 = new com.facebook.react.modules.statusbar.StatusBarModule
            r4.<init>(r5)
            return r4
        L_0x0131:
            com.facebook.react.modules.share.ShareModule r4 = new com.facebook.react.modules.share.ShareModule
            r4.<init>(r5)
            return r4
        L_0x0137:
            com.facebook.react.modules.permissions.PermissionsModule r4 = new com.facebook.react.modules.permissions.PermissionsModule
            r4.<init>(r5)
            return r4
        L_0x013d:
            com.facebook.react.modules.network.NetworkingModule r4 = new com.facebook.react.modules.network.NetworkingModule
            r4.<init>(r5)
            return r4
        L_0x0143:
            com.facebook.react.animated.NativeAnimatedModule r4 = new com.facebook.react.animated.NativeAnimatedModule
            r4.<init>(r5)
            return r4
        L_0x0149:
            com.facebook.react.modules.intent.IntentModule r4 = new com.facebook.react.modules.intent.IntentModule
            r4.<init>(r5)
            return r4
        L_0x014f:
            com.facebook.react.modules.camera.ImageStoreManager r4 = new com.facebook.react.modules.camera.ImageStoreManager
            r4.<init>(r5)
            return r4
        L_0x0155:
            com.facebook.react.modules.image.ImageLoaderModule r4 = new com.facebook.react.modules.image.ImageLoaderModule
            r4.<init>(r5)
            return r4
        L_0x015b:
            com.facebook.react.modules.i18nmanager.I18nManagerModule r4 = new com.facebook.react.modules.i18nmanager.I18nManagerModule
            r4.<init>(r5)
            return r4
        L_0x0161:
            com.facebook.react.modules.fresco.FrescoModule r4 = new com.facebook.react.modules.fresco.FrescoModule
            com.facebook.react.shell.MainPackageConfig r2 = r3.mConfig
            if (r2 == 0) goto L_0x016b
            com.facebook.imagepipeline.core.ImagePipelineConfig r0 = r2.getFrescoConfig()
        L_0x016b:
            r4.<init>((com.facebook.react.bridge.ReactApplicationContext) r5, (boolean) r1, (com.facebook.imagepipeline.core.ImagePipelineConfig) r0)
            return r4
        L_0x016f:
            com.facebook.react.modules.dialog.DialogModule r4 = new com.facebook.react.modules.dialog.DialogModule
            r4.<init>(r5)
            return r4
        L_0x0175:
            com.facebook.react.modules.datepicker.DatePickerDialogModule r4 = new com.facebook.react.modules.datepicker.DatePickerDialogModule
            r4.<init>(r5)
            return r4
        L_0x017b:
            com.facebook.react.modules.clipboard.ClipboardModule r4 = new com.facebook.react.modules.clipboard.ClipboardModule
            r4.<init>(r5)
            return r4
        L_0x0181:
            com.facebook.react.modules.storage.AsyncStorageModule r4 = new com.facebook.react.modules.storage.AsyncStorageModule
            r4.<init>(r5)
            return r4
        L_0x0187:
            com.facebook.react.modules.blob.FileReaderModule r4 = new com.facebook.react.modules.blob.FileReaderModule
            r4.<init>(r5)
            return r4
        L_0x018d:
            com.facebook.react.modules.blob.BlobModule r4 = new com.facebook.react.modules.blob.BlobModule
            r4.<init>(r5)
            return r4
        L_0x0193:
            com.facebook.react.modules.appstate.AppStateModule r4 = new com.facebook.react.modules.appstate.AppStateModule
            r4.<init>(r5)
            return r4
        L_0x0199:
            com.facebook.react.modules.appearance.AppearanceModule r4 = new com.facebook.react.modules.appearance.AppearanceModule
            r4.<init>(r5)
            return r4
        L_0x019f:
            com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule r4 = new com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule
            r4.<init>(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.shell.MainReactPackage.getModule(java.lang.String, com.facebook.react.bridge.ReactApplicationContext):com.facebook.react.bridge.NativeModule");
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ReactDrawerLayoutManager());
        arrayList.add(new ReactHorizontalScrollViewManager());
        arrayList.add(new ReactHorizontalScrollContainerViewManager());
        arrayList.add(new ReactProgressBarViewManager());
        arrayList.add(new ReactScrollViewManager());
        arrayList.add(new ReactSliderManager());
        arrayList.add(new ReactSwitchManager());
        arrayList.add(new SwipeRefreshLayoutManager());
        arrayList.add(new FrescoBasedReactTextInlineImageViewManager());
        arrayList.add(new ReactImageManager());
        arrayList.add(new ReactModalHostManager());
        arrayList.add(new ReactRawTextManager());
        arrayList.add(new ReactTextInputManager());
        arrayList.add(new ReactTextViewManager());
        arrayList.add(new ReactViewManager());
        arrayList.add(new ReactVirtualTextViewManager());
        arrayList.add(new ReactUnimplementedViewManager());
        return arrayList;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        try {
            return (ReactModuleInfoProvider) Class.forName("com.facebook.react.shell.MainReactPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            Class[] clsArr = {AccessibilityInfoModule.class, AppearanceModule.class, AppStateModule.class, BlobModule.class, FileReaderModule.class, AsyncStorageModule.class, ClipboardModule.class, DatePickerDialogModule.class, DialogModule.class, FrescoModule.class, I18nManagerModule.class, ImageLoaderModule.class, ImageStoreManager.class, IntentModule.class, NativeAnimatedModule.class, NetworkingModule.class, PermissionsModule.class, ShareModule.class, StatusBarModule.class, SoundManagerModule.class, ToastModule.class, VibrationModule.class, WebSocketModule.class};
            final HashMap hashMap = new HashMap();
            for (int i = 0; i < 23; i++) {
                Class cls = clsArr[i];
                ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
                hashMap.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), cls.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), TurboModule.class.isAssignableFrom(cls)));
            }
            return new ReactModuleInfoProvider() {
                public Map<String, ReactModuleInfo> getReactModuleInfos() {
                    return hashMap;
                }
            };
        } catch (InstantiationException e) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e2);
        }
    }
}
