package io.intercom.android.sdk.models;

import com.facebook.react.uimanager.ViewProps;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lio/intercom/android/sdk/models/CustomizationColorsModel;", "", "backgroundColor", "", "foregroundColor", "foregroundLowContrastColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getForegroundColor", "getForegroundLowContrastColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModules.kt */
public final class CustomizationColorsModel {
    @SerializedName("background_color")
    private final String backgroundColor;
    @SerializedName("foreground_color")
    private final String foregroundColor;
    @SerializedName("foreground_color_low_contrast")
    private final String foregroundLowContrastColor;

    public CustomizationColorsModel() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CustomizationColorsModel copy$default(CustomizationColorsModel customizationColorsModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customizationColorsModel.backgroundColor;
        }
        if ((i & 2) != 0) {
            str2 = customizationColorsModel.foregroundColor;
        }
        if ((i & 4) != 0) {
            str3 = customizationColorsModel.foregroundLowContrastColor;
        }
        return customizationColorsModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.backgroundColor;
    }

    public final String component2() {
        return this.foregroundColor;
    }

    public final String component3() {
        return this.foregroundLowContrastColor;
    }

    public final CustomizationColorsModel copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, ViewProps.BACKGROUND_COLOR);
        Intrinsics.checkNotNullParameter(str2, ViewProps.FOREGROUND_COLOR);
        Intrinsics.checkNotNullParameter(str3, "foregroundLowContrastColor");
        return new CustomizationColorsModel(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomizationColorsModel)) {
            return false;
        }
        CustomizationColorsModel customizationColorsModel = (CustomizationColorsModel) obj;
        return Intrinsics.areEqual((Object) this.backgroundColor, (Object) customizationColorsModel.backgroundColor) && Intrinsics.areEqual((Object) this.foregroundColor, (Object) customizationColorsModel.foregroundColor) && Intrinsics.areEqual((Object) this.foregroundLowContrastColor, (Object) customizationColorsModel.foregroundLowContrastColor);
    }

    public int hashCode() {
        return (((this.backgroundColor.hashCode() * 31) + this.foregroundColor.hashCode()) * 31) + this.foregroundLowContrastColor.hashCode();
    }

    public String toString() {
        return "CustomizationColorsModel(backgroundColor=" + this.backgroundColor + ", foregroundColor=" + this.foregroundColor + ", foregroundLowContrastColor=" + this.foregroundLowContrastColor + ')';
    }

    public CustomizationColorsModel(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, ViewProps.BACKGROUND_COLOR);
        Intrinsics.checkNotNullParameter(str2, ViewProps.FOREGROUND_COLOR);
        Intrinsics.checkNotNullParameter(str3, "foregroundLowContrastColor");
        this.backgroundColor = str;
        this.foregroundColor = str2;
        this.foregroundLowContrastColor = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomizationColorsModel(java.lang.String r1, java.lang.String r2, java.lang.String r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            java.lang.String r1 = "#FFFFFF"
        L_0x0006:
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000c
            java.lang.String r2 = "#000000"
        L_0x000c:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0011
            r3 = r2
        L_0x0011:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.models.CustomizationColorsModel.<init>(java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getForegroundColor() {
        return this.foregroundColor;
    }

    public final String getForegroundLowContrastColor() {
        return this.foregroundLowContrastColor;
    }
}
