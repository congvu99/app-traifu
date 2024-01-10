package io.intercom.android.sdk.models;

import com.facebook.react.modules.appstate.AppStateModule;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lio/intercom/android/sdk/models/HeaderConfig;", "", "background", "Lio/intercom/android/sdk/models/HeaderBackgroundModel;", "content", "Lio/intercom/android/sdk/models/HeaderContentModel;", "headerExpanded", "", "(Lio/intercom/android/sdk/models/HeaderBackgroundModel;Lio/intercom/android/sdk/models/HeaderContentModel;Z)V", "getBackground", "()Lio/intercom/android/sdk/models/HeaderBackgroundModel;", "getContent", "()Lio/intercom/android/sdk/models/HeaderContentModel;", "getHeaderExpanded", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModules.kt */
public final class HeaderConfig {
    @SerializedName("background")
    private final HeaderBackgroundModel background;
    @SerializedName("content")
    private final HeaderContentModel content;
    @SerializedName("header_expanded")
    private final boolean headerExpanded;

    public HeaderConfig() {
        this((HeaderBackgroundModel) null, (HeaderContentModel) null, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HeaderConfig copy$default(HeaderConfig headerConfig, HeaderBackgroundModel headerBackgroundModel, HeaderContentModel headerContentModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            headerBackgroundModel = headerConfig.background;
        }
        if ((i & 2) != 0) {
            headerContentModel = headerConfig.content;
        }
        if ((i & 4) != 0) {
            z = headerConfig.headerExpanded;
        }
        return headerConfig.copy(headerBackgroundModel, headerContentModel, z);
    }

    public final HeaderBackgroundModel component1() {
        return this.background;
    }

    public final HeaderContentModel component2() {
        return this.content;
    }

    public final boolean component3() {
        return this.headerExpanded;
    }

    public final HeaderConfig copy(HeaderBackgroundModel headerBackgroundModel, HeaderContentModel headerContentModel, boolean z) {
        Intrinsics.checkNotNullParameter(headerBackgroundModel, AppStateModule.APP_STATE_BACKGROUND);
        Intrinsics.checkNotNullParameter(headerContentModel, "content");
        return new HeaderConfig(headerBackgroundModel, headerContentModel, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderConfig)) {
            return false;
        }
        HeaderConfig headerConfig = (HeaderConfig) obj;
        return Intrinsics.areEqual((Object) this.background, (Object) headerConfig.background) && Intrinsics.areEqual((Object) this.content, (Object) headerConfig.content) && this.headerExpanded == headerConfig.headerExpanded;
    }

    public int hashCode() {
        int hashCode = ((this.background.hashCode() * 31) + this.content.hashCode()) * 31;
        boolean z = this.headerExpanded;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "HeaderConfig(background=" + this.background + ", content=" + this.content + ", headerExpanded=" + this.headerExpanded + ')';
    }

    public HeaderConfig(HeaderBackgroundModel headerBackgroundModel, HeaderContentModel headerContentModel, boolean z) {
        Intrinsics.checkNotNullParameter(headerBackgroundModel, AppStateModule.APP_STATE_BACKGROUND);
        Intrinsics.checkNotNullParameter(headerContentModel, "content");
        this.background = headerBackgroundModel;
        this.content = headerContentModel;
        this.headerExpanded = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeaderConfig(HeaderBackgroundModel headerBackgroundModel, HeaderContentModel headerContentModel, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new HeaderBackgroundModel((String) null, (List) null, (String) null, false, (HeaderBackdropType) null, 31, (DefaultConstructorMarker) null) : headerBackgroundModel, (i & 2) != 0 ? new HeaderContentModel((String) null, false, (HeaderTextModel) null, (HeaderTextModel) null, (CloseButtonModel) null, 31, (DefaultConstructorMarker) null) : headerContentModel, (i & 4) != 0 ? true : z);
    }

    public final HeaderBackgroundModel getBackground() {
        return this.background;
    }

    public final HeaderContentModel getContent() {
        return this.content;
    }

    public final boolean getHeaderExpanded() {
        return this.headerExpanded;
    }
}
