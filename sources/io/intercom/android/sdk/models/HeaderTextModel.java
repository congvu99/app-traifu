package io.intercom.android.sdk.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lio/intercom/android/sdk/models/HeaderTextModel;", "", "text", "", "opacity", "", "color", "(Ljava/lang/String;FLjava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getOpacity", "()F", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModules.kt */
public final class HeaderTextModel {
    @SerializedName("text_color")
    private final String color;
    @SerializedName("opacity")
    private final float opacity;
    @SerializedName("content")
    private final String text;

    public HeaderTextModel() {
        this((String) null, 0.0f, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HeaderTextModel copy$default(HeaderTextModel headerTextModel, String str, float f, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = headerTextModel.text;
        }
        if ((i & 2) != 0) {
            f = headerTextModel.opacity;
        }
        if ((i & 4) != 0) {
            str2 = headerTextModel.color;
        }
        return headerTextModel.copy(str, f, str2);
    }

    public final String component1() {
        return this.text;
    }

    public final float component2() {
        return this.opacity;
    }

    public final String component3() {
        return this.color;
    }

    public final HeaderTextModel copy(String str, float f, String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "color");
        return new HeaderTextModel(str, f, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderTextModel)) {
            return false;
        }
        HeaderTextModel headerTextModel = (HeaderTextModel) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) headerTextModel.text) && Intrinsics.areEqual((Object) Float.valueOf(this.opacity), (Object) Float.valueOf(headerTextModel.opacity)) && Intrinsics.areEqual((Object) this.color, (Object) headerTextModel.color);
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + Float.floatToIntBits(this.opacity)) * 31) + this.color.hashCode();
    }

    public String toString() {
        return "HeaderTextModel(text=" + this.text + ", opacity=" + this.opacity + ", color=" + this.color + ')';
    }

    public HeaderTextModel(String str, float f, String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "color");
        this.text = str;
        this.opacity = f;
        this.color = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeaderTextModel(String str, float f, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 1.0f : f, (i & 4) != 0 ? "#000000" : str2);
    }

    public final String getText() {
        return this.text;
    }

    public final float getOpacity() {
        return this.opacity;
    }

    public final String getColor() {
        return this.color;
    }
}
