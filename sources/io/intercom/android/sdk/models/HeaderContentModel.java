package io.intercom.android.sdk.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lio/intercom/android/sdk/models/HeaderContentModel;", "", "logoUrl", "", "showAvatars", "", "greeting", "Lio/intercom/android/sdk/models/HeaderTextModel;", "intro", "closeButton", "Lio/intercom/android/sdk/models/CloseButtonModel;", "(Ljava/lang/String;ZLio/intercom/android/sdk/models/HeaderTextModel;Lio/intercom/android/sdk/models/HeaderTextModel;Lio/intercom/android/sdk/models/CloseButtonModel;)V", "getCloseButton", "()Lio/intercom/android/sdk/models/CloseButtonModel;", "getGreeting", "()Lio/intercom/android/sdk/models/HeaderTextModel;", "getIntro", "getLogoUrl", "()Ljava/lang/String;", "getShowAvatars", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConfigModules.kt */
public final class HeaderContentModel {
    @SerializedName("close_button")
    private final CloseButtonModel closeButton;
    @SerializedName("greeting")
    private final HeaderTextModel greeting;
    @SerializedName("introduction")
    private final HeaderTextModel intro;
    @SerializedName("logo_url")
    private final String logoUrl;
    @SerializedName("show_avatars")
    private final boolean showAvatars;

    public HeaderContentModel() {
        this((String) null, false, (HeaderTextModel) null, (HeaderTextModel) null, (CloseButtonModel) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HeaderContentModel copy$default(HeaderContentModel headerContentModel, String str, boolean z, HeaderTextModel headerTextModel, HeaderTextModel headerTextModel2, CloseButtonModel closeButtonModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = headerContentModel.logoUrl;
        }
        if ((i & 2) != 0) {
            z = headerContentModel.showAvatars;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            headerTextModel = headerContentModel.greeting;
        }
        HeaderTextModel headerTextModel3 = headerTextModel;
        if ((i & 8) != 0) {
            headerTextModel2 = headerContentModel.intro;
        }
        HeaderTextModel headerTextModel4 = headerTextModel2;
        if ((i & 16) != 0) {
            closeButtonModel = headerContentModel.closeButton;
        }
        return headerContentModel.copy(str, z2, headerTextModel3, headerTextModel4, closeButtonModel);
    }

    public final String component1() {
        return this.logoUrl;
    }

    public final boolean component2() {
        return this.showAvatars;
    }

    public final HeaderTextModel component3() {
        return this.greeting;
    }

    public final HeaderTextModel component4() {
        return this.intro;
    }

    public final CloseButtonModel component5() {
        return this.closeButton;
    }

    public final HeaderContentModel copy(String str, boolean z, HeaderTextModel headerTextModel, HeaderTextModel headerTextModel2, CloseButtonModel closeButtonModel) {
        Intrinsics.checkNotNullParameter(str, "logoUrl");
        Intrinsics.checkNotNullParameter(headerTextModel, "greeting");
        Intrinsics.checkNotNullParameter(headerTextModel2, "intro");
        Intrinsics.checkNotNullParameter(closeButtonModel, "closeButton");
        return new HeaderContentModel(str, z, headerTextModel, headerTextModel2, closeButtonModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderContentModel)) {
            return false;
        }
        HeaderContentModel headerContentModel = (HeaderContentModel) obj;
        return Intrinsics.areEqual((Object) this.logoUrl, (Object) headerContentModel.logoUrl) && this.showAvatars == headerContentModel.showAvatars && Intrinsics.areEqual((Object) this.greeting, (Object) headerContentModel.greeting) && Intrinsics.areEqual((Object) this.intro, (Object) headerContentModel.intro) && Intrinsics.areEqual((Object) this.closeButton, (Object) headerContentModel.closeButton);
    }

    public int hashCode() {
        int hashCode = this.logoUrl.hashCode() * 31;
        boolean z = this.showAvatars;
        if (z) {
            z = true;
        }
        return ((((((hashCode + (z ? 1 : 0)) * 31) + this.greeting.hashCode()) * 31) + this.intro.hashCode()) * 31) + this.closeButton.hashCode();
    }

    public String toString() {
        return "HeaderContentModel(logoUrl=" + this.logoUrl + ", showAvatars=" + this.showAvatars + ", greeting=" + this.greeting + ", intro=" + this.intro + ", closeButton=" + this.closeButton + ')';
    }

    public HeaderContentModel(String str, boolean z, HeaderTextModel headerTextModel, HeaderTextModel headerTextModel2, CloseButtonModel closeButtonModel) {
        Intrinsics.checkNotNullParameter(str, "logoUrl");
        Intrinsics.checkNotNullParameter(headerTextModel, "greeting");
        Intrinsics.checkNotNullParameter(headerTextModel2, "intro");
        Intrinsics.checkNotNullParameter(closeButtonModel, "closeButton");
        this.logoUrl = str;
        this.showAvatars = z;
        this.greeting = headerTextModel;
        this.intro = headerTextModel2;
        this.closeButton = closeButtonModel;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final boolean getShowAvatars() {
        return this.showAvatars;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HeaderContentModel(java.lang.String r9, boolean r10, io.intercom.android.sdk.models.HeaderTextModel r11, io.intercom.android.sdk.models.HeaderTextModel r12, io.intercom.android.sdk.models.CloseButtonModel r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r8 = this;
            r15 = r14 & 1
            if (r15 == 0) goto L_0x0006
            java.lang.String r9 = ""
        L_0x0006:
            r15 = r14 & 2
            if (r15 == 0) goto L_0x000d
            r10 = 1
            r15 = 1
            goto L_0x000e
        L_0x000d:
            r15 = r10
        L_0x000e:
            r10 = r14 & 4
            if (r10 == 0) goto L_0x001e
            io.intercom.android.sdk.models.HeaderTextModel r11 = new io.intercom.android.sdk.models.HeaderTextModel
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            r0 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x001f
        L_0x001e:
            r0 = r11
        L_0x001f:
            r10 = r14 & 8
            if (r10 == 0) goto L_0x002f
            io.intercom.android.sdk.models.HeaderTextModel r12 = new io.intercom.android.sdk.models.HeaderTextModel
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 7
            r6 = 0
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0030
        L_0x002f:
            r1 = r12
        L_0x0030:
            r10 = r14 & 16
            if (r10 == 0) goto L_0x0040
            io.intercom.android.sdk.models.CloseButtonModel r13 = new io.intercom.android.sdk.models.CloseButtonModel
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 7
            r7 = 0
            r2 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0041
        L_0x0040:
            r2 = r13
        L_0x0041:
            r10 = r8
            r11 = r9
            r12 = r15
            r13 = r0
            r14 = r1
            r15 = r2
            r10.<init>(r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.models.HeaderContentModel.<init>(java.lang.String, boolean, io.intercom.android.sdk.models.HeaderTextModel, io.intercom.android.sdk.models.HeaderTextModel, io.intercom.android.sdk.models.CloseButtonModel, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final HeaderTextModel getGreeting() {
        return this.greeting;
    }

    public final HeaderTextModel getIntro() {
        return this.intro;
    }

    public final CloseButtonModel getCloseButton() {
        return this.closeButton;
    }
}
