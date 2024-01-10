package io.intercom.android.sdk.models;

import com.facebook.react.uimanager.ViewProps;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lio/intercom/android/sdk/models/CloseButtonModel;", "", "backgroundColor", "", "backgroundOpacity", "", "foregroundColor", "(Ljava/lang/String;FLjava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getBackgroundOpacity", "()F", "getForegroundColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModules.kt */
public final class CloseButtonModel {
    @SerializedName("background_color")
    private final String backgroundColor;
    @SerializedName("background_opacity")
    private final float backgroundOpacity;
    @SerializedName("foreground_color")
    private final String foregroundColor;

    public CloseButtonModel() {
        this((String) null, 0.0f, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CloseButtonModel copy$default(CloseButtonModel closeButtonModel, String str, float f, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = closeButtonModel.backgroundColor;
        }
        if ((i & 2) != 0) {
            f = closeButtonModel.backgroundOpacity;
        }
        if ((i & 4) != 0) {
            str2 = closeButtonModel.foregroundColor;
        }
        return closeButtonModel.copy(str, f, str2);
    }

    public final String component1() {
        return this.backgroundColor;
    }

    public final float component2() {
        return this.backgroundOpacity;
    }

    public final String component3() {
        return this.foregroundColor;
    }

    public final CloseButtonModel copy(String str, float f, String str2) {
        Intrinsics.checkNotNullParameter(str, ViewProps.BACKGROUND_COLOR);
        Intrinsics.checkNotNullParameter(str2, ViewProps.FOREGROUND_COLOR);
        return new CloseButtonModel(str, f, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloseButtonModel)) {
            return false;
        }
        CloseButtonModel closeButtonModel = (CloseButtonModel) obj;
        return Intrinsics.areEqual((Object) this.backgroundColor, (Object) closeButtonModel.backgroundColor) && Intrinsics.areEqual((Object) Float.valueOf(this.backgroundOpacity), (Object) Float.valueOf(closeButtonModel.backgroundOpacity)) && Intrinsics.areEqual((Object) this.foregroundColor, (Object) closeButtonModel.foregroundColor);
    }

    public int hashCode() {
        return (((this.backgroundColor.hashCode() * 31) + Float.floatToIntBits(this.backgroundOpacity)) * 31) + this.foregroundColor.hashCode();
    }

    public String toString() {
        return "CloseButtonModel(backgroundColor=" + this.backgroundColor + ", backgroundOpacity=" + this.backgroundOpacity + ", foregroundColor=" + this.foregroundColor + ')';
    }

    public CloseButtonModel(String str, float f, String str2) {
        Intrinsics.checkNotNullParameter(str, ViewProps.BACKGROUND_COLOR);
        Intrinsics.checkNotNullParameter(str2, ViewProps.FOREGROUND_COLOR);
        this.backgroundColor = str;
        this.backgroundOpacity = f;
        this.foregroundColor = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CloseButtonModel(String str, float f, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "#FFFFFF" : str, (i & 2) != 0 ? 1.0f : f, (i & 4) != 0 ? "#000000" : str2);
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final float getBackgroundOpacity() {
        return this.backgroundOpacity;
    }

    public final String getForegroundColor() {
        return this.foregroundColor;
    }
}
