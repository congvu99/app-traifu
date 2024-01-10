package io.intercom.android.sdk.m5;

import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.models.ConfigModules;
import io.intercom.android.sdk.models.CustomizationColorsModel;
import io.intercom.android.sdk.models.CustomizationModel;
import io.intercom.android.sdk.utilities.ColorExtensionsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u00020\u00048@X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0007\u001a\u00020\u00048@X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u001d\u0010\t\u001a\u00020\u00048@X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/m5/IntercomTheme;", "", "()V", "colorOnWhite", "Landroidx/compose/ui/graphics/Color;", "getColorOnWhite-0d7_KjU$intercom_sdk_base_release", "()J", "header", "getHeader-0d7_KjU$intercom_sdk_base_release", "onHeader", "getOnHeader-0d7_KjU$intercom_sdk_base_release", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomTheme.kt */
public final class IntercomTheme {
    public static final IntercomTheme INSTANCE = new IntercomTheme();

    private IntercomTheme() {
    }

    /* renamed from: getHeader-0d7_KjU$intercom_sdk_base_release  reason: not valid java name */
    public final long m5119getHeader0d7_KjU$intercom_sdk_base_release() {
        String str;
        ConfigModules configModules;
        CustomizationModel customization;
        CustomizationColorsModel header;
        if (Injector.isNotInitialised() || (configModules = Injector.get().getAppConfigProvider().get().getConfigModules()) == null || (customization = configModules.getCustomization()) == null || (header = customization.getHeader()) == null || (str = header.getBackgroundColor()) == null) {
            str = "#FF6061EC";
        }
        return ColorExtensionsKt.toComposeColor$default(str, 0.0f, 1, (Object) null);
    }

    /* renamed from: getOnHeader-0d7_KjU$intercom_sdk_base_release  reason: not valid java name */
    public final long m5120getOnHeader0d7_KjU$intercom_sdk_base_release() {
        String str;
        ConfigModules configModules;
        CustomizationModel customization;
        CustomizationColorsModel header;
        if (Injector.isNotInitialised() || (configModules = Injector.get().getAppConfigProvider().get().getConfigModules()) == null || (customization = configModules.getCustomization()) == null || (header = customization.getHeader()) == null || (str = header.getForegroundColor()) == null) {
            str = "#FFFFFFFF";
        }
        return ColorExtensionsKt.toComposeColor$default(str, 0.0f, 1, (Object) null);
    }

    /* renamed from: getColorOnWhite-0d7_KjU$intercom_sdk_base_release  reason: not valid java name */
    public final long m5118getColorOnWhite0d7_KjU$intercom_sdk_base_release() {
        String str;
        CustomizationColorsModel action;
        CustomizationColorsModel actionContrastWhite;
        if (!Injector.isNotInitialised()) {
            ConfigModules configModules = Injector.get().getAppConfigProvider().get().getConfigModules();
            CustomizationModel customization = configModules != null ? configModules.getCustomization() : null;
            if (customization == null || (actionContrastWhite = customization.getActionContrastWhite()) == null || (str = actionContrastWhite.getBackgroundColor()) == null) {
                if (!(customization == null || (action = customization.getAction()) == null)) {
                    str = action.getBackgroundColor();
                }
            }
            return ColorExtensionsKt.toComposeColor$default(str, 0.0f, 1, (Object) null);
        }
        str = "#FFFFFFFF";
        return ColorExtensionsKt.toComposeColor$default(str, 0.0f, 1, (Object) null);
    }
}
