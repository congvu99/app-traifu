package io.intercom.android.sdk.m5.home.viewmodel;

import androidx.compose.ui.graphics.Color;
import com.facebook.react.uimanager.ViewProps;
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState;", "", "()V", "CloseButtonColor", "ColoredText", "HeaderBackdropStyle", "HeaderContent", "NoHeader", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderContent;", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$NoHeader;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeViewModel.kt */
public abstract class HeaderState {
    public /* synthetic */ HeaderState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderContent;", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState;", "()V", "Expanded", "Reduced", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderContent$Expanded;", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderContent$Reduced;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeViewModel.kt */
    public static abstract class HeaderContent extends HeaderState {
        public static final int $stable = 0;

        public /* synthetic */ HeaderContent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private HeaderContent() {
            super((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u0010'\u001a\u00020\u0010HÆ\u0003Ja\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u0006/"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderContent$Expanded;", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderContent;", "showLogo", "", "logoUrl", "", "greeting", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$ColoredText;", "intro", "headerBackdropStyle", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle;", "showAvatars", "adminsAvatars", "", "Lio/intercom/android/sdk/models/Avatar;", "closeButtonColor", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$CloseButtonColor;", "(ZLjava/lang/String;Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$ColoredText;Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$ColoredText;Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle;ZLjava/util/List;Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$CloseButtonColor;)V", "getAdminsAvatars", "()Ljava/util/List;", "getCloseButtonColor", "()Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$CloseButtonColor;", "getGreeting", "()Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$ColoredText;", "getHeaderBackdropStyle", "()Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle;", "getIntro", "getLogoUrl", "()Ljava/lang/String;", "getShowAvatars", "()Z", "getShowLogo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: HomeViewModel.kt */
        public static final class Expanded extends HeaderContent {
            public static final int $stable = 8;
            private final List<Avatar> adminsAvatars;
            private final CloseButtonColor closeButtonColor;
            private final ColoredText greeting;
            private final HeaderBackdropStyle headerBackdropStyle;
            private final ColoredText intro;
            private final String logoUrl;
            private final boolean showAvatars;
            private final boolean showLogo;

            public static /* synthetic */ Expanded copy$default(Expanded expanded, boolean z, String str, ColoredText coloredText, ColoredText coloredText2, HeaderBackdropStyle headerBackdropStyle2, boolean z2, List list, CloseButtonColor closeButtonColor2, int i, Object obj) {
                Expanded expanded2 = expanded;
                int i2 = i;
                return expanded.copy((i2 & 1) != 0 ? expanded2.showLogo : z, (i2 & 2) != 0 ? expanded2.logoUrl : str, (i2 & 4) != 0 ? expanded2.greeting : coloredText, (i2 & 8) != 0 ? expanded2.intro : coloredText2, (i2 & 16) != 0 ? expanded2.headerBackdropStyle : headerBackdropStyle2, (i2 & 32) != 0 ? expanded2.showAvatars : z2, (i2 & 64) != 0 ? expanded2.adminsAvatars : list, (i2 & 128) != 0 ? expanded2.closeButtonColor : closeButtonColor2);
            }

            public final boolean component1() {
                return this.showLogo;
            }

            public final String component2() {
                return this.logoUrl;
            }

            public final ColoredText component3() {
                return this.greeting;
            }

            public final ColoredText component4() {
                return this.intro;
            }

            public final HeaderBackdropStyle component5() {
                return this.headerBackdropStyle;
            }

            public final boolean component6() {
                return this.showAvatars;
            }

            public final List<Avatar> component7() {
                return this.adminsAvatars;
            }

            public final CloseButtonColor component8() {
                return this.closeButtonColor;
            }

            public final Expanded copy(boolean z, String str, ColoredText coloredText, ColoredText coloredText2, HeaderBackdropStyle headerBackdropStyle2, boolean z2, List<? extends Avatar> list, CloseButtonColor closeButtonColor2) {
                Intrinsics.checkNotNullParameter(coloredText, "greeting");
                Intrinsics.checkNotNullParameter(coloredText2, "intro");
                Intrinsics.checkNotNullParameter(headerBackdropStyle2, "headerBackdropStyle");
                List<? extends Avatar> list2 = list;
                Intrinsics.checkNotNullParameter(list2, "adminsAvatars");
                CloseButtonColor closeButtonColor3 = closeButtonColor2;
                Intrinsics.checkNotNullParameter(closeButtonColor3, "closeButtonColor");
                return new Expanded(z, str, coloredText, coloredText2, headerBackdropStyle2, z2, list2, closeButtonColor3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Expanded)) {
                    return false;
                }
                Expanded expanded = (Expanded) obj;
                return this.showLogo == expanded.showLogo && Intrinsics.areEqual((Object) this.logoUrl, (Object) expanded.logoUrl) && Intrinsics.areEqual((Object) this.greeting, (Object) expanded.greeting) && Intrinsics.areEqual((Object) this.intro, (Object) expanded.intro) && Intrinsics.areEqual((Object) this.headerBackdropStyle, (Object) expanded.headerBackdropStyle) && this.showAvatars == expanded.showAvatars && Intrinsics.areEqual((Object) this.adminsAvatars, (Object) expanded.adminsAvatars) && Intrinsics.areEqual((Object) this.closeButtonColor, (Object) expanded.closeButtonColor);
            }

            public int hashCode() {
                boolean z = this.showLogo;
                boolean z2 = true;
                if (z) {
                    z = true;
                }
                int i = (z ? 1 : 0) * true;
                String str = this.logoUrl;
                int hashCode = (((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.greeting.hashCode()) * 31) + this.intro.hashCode()) * 31) + this.headerBackdropStyle.hashCode()) * 31;
                boolean z3 = this.showAvatars;
                if (!z3) {
                    z2 = z3;
                }
                return ((((hashCode + (z2 ? 1 : 0)) * 31) + this.adminsAvatars.hashCode()) * 31) + this.closeButtonColor.hashCode();
            }

            public String toString() {
                return "Expanded(showLogo=" + this.showLogo + ", logoUrl=" + this.logoUrl + ", greeting=" + this.greeting + ", intro=" + this.intro + ", headerBackdropStyle=" + this.headerBackdropStyle + ", showAvatars=" + this.showAvatars + ", adminsAvatars=" + this.adminsAvatars + ", closeButtonColor=" + this.closeButtonColor + ')';
            }

            public final boolean getShowLogo() {
                return this.showLogo;
            }

            public final String getLogoUrl() {
                return this.logoUrl;
            }

            public final ColoredText getGreeting() {
                return this.greeting;
            }

            public final ColoredText getIntro() {
                return this.intro;
            }

            public final HeaderBackdropStyle getHeaderBackdropStyle() {
                return this.headerBackdropStyle;
            }

            public final boolean getShowAvatars() {
                return this.showAvatars;
            }

            public final List<Avatar> getAdminsAvatars() {
                return this.adminsAvatars;
            }

            public final CloseButtonColor getCloseButtonColor() {
                return this.closeButtonColor;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Expanded(boolean z, String str, ColoredText coloredText, ColoredText coloredText2, HeaderBackdropStyle headerBackdropStyle2, boolean z2, List<? extends Avatar> list, CloseButtonColor closeButtonColor2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(coloredText, "greeting");
                Intrinsics.checkNotNullParameter(coloredText2, "intro");
                Intrinsics.checkNotNullParameter(headerBackdropStyle2, "headerBackdropStyle");
                Intrinsics.checkNotNullParameter(list, "adminsAvatars");
                Intrinsics.checkNotNullParameter(closeButtonColor2, "closeButtonColor");
                this.showLogo = z;
                this.logoUrl = str;
                this.greeting = coloredText;
                this.intro = coloredText2;
                this.headerBackdropStyle = headerBackdropStyle2;
                this.showAvatars = z2;
                this.adminsAvatars = list;
                this.closeButtonColor = closeButtonColor2;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderContent$Reduced;", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderContent;", "greeting", "", "backgroundColor", "foregroundColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getForegroundColor", "getGreeting", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: HomeViewModel.kt */
        public static final class Reduced extends HeaderContent {
            public static final int $stable = 0;
            private final String backgroundColor;
            private final String foregroundColor;
            private final String greeting;

            public static /* synthetic */ Reduced copy$default(Reduced reduced, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = reduced.greeting;
                }
                if ((i & 2) != 0) {
                    str2 = reduced.backgroundColor;
                }
                if ((i & 4) != 0) {
                    str3 = reduced.foregroundColor;
                }
                return reduced.copy(str, str2, str3);
            }

            public final String component1() {
                return this.greeting;
            }

            public final String component2() {
                return this.backgroundColor;
            }

            public final String component3() {
                return this.foregroundColor;
            }

            public final Reduced copy(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "greeting");
                Intrinsics.checkNotNullParameter(str2, ViewProps.BACKGROUND_COLOR);
                Intrinsics.checkNotNullParameter(str3, ViewProps.FOREGROUND_COLOR);
                return new Reduced(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Reduced)) {
                    return false;
                }
                Reduced reduced = (Reduced) obj;
                return Intrinsics.areEqual((Object) this.greeting, (Object) reduced.greeting) && Intrinsics.areEqual((Object) this.backgroundColor, (Object) reduced.backgroundColor) && Intrinsics.areEqual((Object) this.foregroundColor, (Object) reduced.foregroundColor);
            }

            public int hashCode() {
                return (((this.greeting.hashCode() * 31) + this.backgroundColor.hashCode()) * 31) + this.foregroundColor.hashCode();
            }

            public String toString() {
                return "Reduced(greeting=" + this.greeting + ", backgroundColor=" + this.backgroundColor + ", foregroundColor=" + this.foregroundColor + ')';
            }

            public final String getGreeting() {
                return this.greeting;
            }

            public final String getBackgroundColor() {
                return this.backgroundColor;
            }

            public final String getForegroundColor() {
                return this.foregroundColor;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Reduced(String str, String str2, String str3) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "greeting");
                Intrinsics.checkNotNullParameter(str2, ViewProps.BACKGROUND_COLOR);
                Intrinsics.checkNotNullParameter(str3, ViewProps.FOREGROUND_COLOR);
                this.greeting = str;
                this.backgroundColor = str2;
                this.foregroundColor = str3;
            }
        }
    }

    private HeaderState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$NoHeader;", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeViewModel.kt */
    public static final class NoHeader extends HeaderState {
        public static final int $stable = 0;
        public static final NoHeader INSTANCE = new NoHeader();

        private NoHeader() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$CloseButtonColor;", "", "backgroundColor", "", "foregroundColor", "backgroundOpacity", "", "(Ljava/lang/String;Ljava/lang/String;F)V", "getBackgroundColor", "()Ljava/lang/String;", "getBackgroundOpacity", "()F", "getForegroundColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeViewModel.kt */
    public static final class CloseButtonColor {
        public static final int $stable = 0;
        private final String backgroundColor;
        private final float backgroundOpacity;
        private final String foregroundColor;

        public static /* synthetic */ CloseButtonColor copy$default(CloseButtonColor closeButtonColor, String str, String str2, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                str = closeButtonColor.backgroundColor;
            }
            if ((i & 2) != 0) {
                str2 = closeButtonColor.foregroundColor;
            }
            if ((i & 4) != 0) {
                f = closeButtonColor.backgroundOpacity;
            }
            return closeButtonColor.copy(str, str2, f);
        }

        public final String component1() {
            return this.backgroundColor;
        }

        public final String component2() {
            return this.foregroundColor;
        }

        public final float component3() {
            return this.backgroundOpacity;
        }

        public final CloseButtonColor copy(String str, String str2, float f) {
            Intrinsics.checkNotNullParameter(str, ViewProps.BACKGROUND_COLOR);
            Intrinsics.checkNotNullParameter(str2, ViewProps.FOREGROUND_COLOR);
            return new CloseButtonColor(str, str2, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CloseButtonColor)) {
                return false;
            }
            CloseButtonColor closeButtonColor = (CloseButtonColor) obj;
            return Intrinsics.areEqual((Object) this.backgroundColor, (Object) closeButtonColor.backgroundColor) && Intrinsics.areEqual((Object) this.foregroundColor, (Object) closeButtonColor.foregroundColor) && Intrinsics.areEqual((Object) Float.valueOf(this.backgroundOpacity), (Object) Float.valueOf(closeButtonColor.backgroundOpacity));
        }

        public int hashCode() {
            return (((this.backgroundColor.hashCode() * 31) + this.foregroundColor.hashCode()) * 31) + Float.floatToIntBits(this.backgroundOpacity);
        }

        public String toString() {
            return "CloseButtonColor(backgroundColor=" + this.backgroundColor + ", foregroundColor=" + this.foregroundColor + ", backgroundOpacity=" + this.backgroundOpacity + ')';
        }

        public CloseButtonColor(String str, String str2, float f) {
            Intrinsics.checkNotNullParameter(str, ViewProps.BACKGROUND_COLOR);
            Intrinsics.checkNotNullParameter(str2, ViewProps.FOREGROUND_COLOR);
            this.backgroundColor = str;
            this.foregroundColor = str2;
            this.backgroundOpacity = f;
        }

        public final String getBackgroundColor() {
            return this.backgroundColor;
        }

        public final String getForegroundColor() {
            return this.foregroundColor;
        }

        public final float getBackgroundOpacity() {
            return this.backgroundOpacity;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$ColoredText;", "", "text", "", "color", "opacity", "", "(Ljava/lang/String;Ljava/lang/String;F)V", "getColor", "()Ljava/lang/String;", "getOpacity", "()F", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeViewModel.kt */
    public static final class ColoredText {
        public static final int $stable = 0;
        private final String color;
        private final float opacity;
        private final String text;

        public static /* synthetic */ ColoredText copy$default(ColoredText coloredText, String str, String str2, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                str = coloredText.text;
            }
            if ((i & 2) != 0) {
                str2 = coloredText.color;
            }
            if ((i & 4) != 0) {
                f = coloredText.opacity;
            }
            return coloredText.copy(str, str2, f);
        }

        public final String component1() {
            return this.text;
        }

        public final String component2() {
            return this.color;
        }

        public final float component3() {
            return this.opacity;
        }

        public final ColoredText copy(String str, String str2, float f) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(str2, "color");
            return new ColoredText(str, str2, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ColoredText)) {
                return false;
            }
            ColoredText coloredText = (ColoredText) obj;
            return Intrinsics.areEqual((Object) this.text, (Object) coloredText.text) && Intrinsics.areEqual((Object) this.color, (Object) coloredText.color) && Intrinsics.areEqual((Object) Float.valueOf(this.opacity), (Object) Float.valueOf(coloredText.opacity));
        }

        public int hashCode() {
            return (((this.text.hashCode() * 31) + this.color.hashCode()) * 31) + Float.floatToIntBits(this.opacity);
        }

        public String toString() {
            return "ColoredText(text=" + this.text + ", color=" + this.color + ", opacity=" + this.opacity + ')';
        }

        public ColoredText(String str, String str2, float f) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(str2, "color");
            this.text = str;
            this.color = str2;
            this.opacity = f;
        }

        public final String getColor() {
            return this.color;
        }

        public final float getOpacity() {
            return this.opacity;
        }

        public final String getText() {
            return this.text;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle;", "", "()V", "fade", "", "getFade", "()Z", "Gradient", "Image", "Solid", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle$Gradient;", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle$Image;", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle$Solid;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeViewModel.kt */
    public static abstract class HeaderBackdropStyle {
        public static final int $stable = 0;

        public /* synthetic */ HeaderBackdropStyle(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract boolean getFade();

        private HeaderBackdropStyle() {
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\f\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\bJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J*\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle$Solid;", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "fade", "", "(JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getFade", "()Z", "component1", "component1-0d7_KjU", "component2", "copy", "copy-DxMtmZc", "(JZ)Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle$Solid;", "equals", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: HomeViewModel.kt */
        public static final class Solid extends HeaderBackdropStyle {
            public static final int $stable = 0;
            private final long color;
            private final boolean fade;

            public /* synthetic */ Solid(long j, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
                this(j, z);
            }

            /* renamed from: copy-DxMtmZc$default  reason: not valid java name */
            public static /* synthetic */ Solid m5239copyDxMtmZc$default(Solid solid, long j, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = solid.color;
                }
                if ((i & 2) != 0) {
                    z = solid.getFade();
                }
                return solid.m5241copyDxMtmZc(j, z);
            }

            /* renamed from: component1-0d7_KjU  reason: not valid java name */
            public final long m5240component10d7_KjU() {
                return this.color;
            }

            public final boolean component2() {
                return getFade();
            }

            /* renamed from: copy-DxMtmZc  reason: not valid java name */
            public final Solid m5241copyDxMtmZc(long j, boolean z) {
                return new Solid(j, z, (DefaultConstructorMarker) null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Solid)) {
                    return false;
                }
                Solid solid = (Solid) obj;
                return Color.m1933equalsimpl0(this.color, solid.color) && getFade() == solid.getFade();
            }

            public int hashCode() {
                int r0 = Color.m1939hashCodeimpl(this.color) * 31;
                boolean fade2 = getFade();
                if (fade2) {
                    fade2 = true;
                }
                return r0 + (fade2 ? 1 : 0);
            }

            public String toString() {
                return "Solid(color=" + Color.m1940toStringimpl(this.color) + ", fade=" + getFade() + ')';
            }

            private Solid(long j, boolean z) {
                super((DefaultConstructorMarker) null);
                this.color = j;
                this.fade = z;
            }

            /* renamed from: getColor-0d7_KjU  reason: not valid java name */
            public final long m5242getColor0d7_KjU() {
                return this.color;
            }

            public boolean getFade() {
                return this.fade;
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001e\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003ø\u0001\u0000J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001ø\u0001\u0000J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle$Gradient;", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "fade", "", "(Ljava/util/List;Z)V", "getColors", "()Ljava/util/List;", "getFade", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: HomeViewModel.kt */
        public static final class Gradient extends HeaderBackdropStyle {
            public static final int $stable = 8;
            private final List<Color> colors;
            private final boolean fade;

            public static /* synthetic */ Gradient copy$default(Gradient gradient, List<Color> list, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = gradient.colors;
                }
                if ((i & 2) != 0) {
                    z = gradient.getFade();
                }
                return gradient.copy(list, z);
            }

            public final List<Color> component1() {
                return this.colors;
            }

            public final boolean component2() {
                return getFade();
            }

            public final Gradient copy(List<Color> list, boolean z) {
                Intrinsics.checkNotNullParameter(list, "colors");
                return new Gradient(list, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Gradient)) {
                    return false;
                }
                Gradient gradient = (Gradient) obj;
                return Intrinsics.areEqual((Object) this.colors, (Object) gradient.colors) && getFade() == gradient.getFade();
            }

            public int hashCode() {
                int hashCode = this.colors.hashCode() * 31;
                boolean fade2 = getFade();
                if (fade2) {
                    fade2 = true;
                }
                return hashCode + (fade2 ? 1 : 0);
            }

            public String toString() {
                return "Gradient(colors=" + this.colors + ", fade=" + getFade() + ')';
            }

            public final List<Color> getColors() {
                return this.colors;
            }

            public boolean getFade() {
                return this.fade;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Gradient(List<Color> list, boolean z) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(list, "colors");
                this.colors = list;
                this.fade = z;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0019\u0010\u0010\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J6\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle$Image;", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle;", "fallbackColor", "Landroidx/compose/ui/graphics/Color;", "imageUrl", "", "fade", "", "(JLjava/lang/String;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFade", "()Z", "getFallbackColor-0d7_KjU", "()J", "J", "getImageUrl", "()Ljava/lang/String;", "component1", "component1-0d7_KjU", "component2", "component3", "copy", "copy-ek8zF_U", "(JLjava/lang/String;Z)Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle$Image;", "equals", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: HomeViewModel.kt */
        public static final class Image extends HeaderBackdropStyle {
            public static final int $stable = 0;
            private final boolean fade;
            private final long fallbackColor;
            private final String imageUrl;

            public /* synthetic */ Image(long j, String str, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
                this(j, str, z);
            }

            /* renamed from: copy-ek8zF_U$default  reason: not valid java name */
            public static /* synthetic */ Image m5235copyek8zF_U$default(Image image, long j, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = image.fallbackColor;
                }
                if ((i & 2) != 0) {
                    str = image.imageUrl;
                }
                if ((i & 4) != 0) {
                    z = image.getFade();
                }
                return image.m5237copyek8zF_U(j, str, z);
            }

            /* renamed from: component1-0d7_KjU  reason: not valid java name */
            public final long m5236component10d7_KjU() {
                return this.fallbackColor;
            }

            public final String component2() {
                return this.imageUrl;
            }

            public final boolean component3() {
                return getFade();
            }

            /* renamed from: copy-ek8zF_U  reason: not valid java name */
            public final Image m5237copyek8zF_U(long j, String str, boolean z) {
                return new Image(j, str, z, (DefaultConstructorMarker) null);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Image)) {
                    return false;
                }
                Image image = (Image) obj;
                return Color.m1933equalsimpl0(this.fallbackColor, image.fallbackColor) && Intrinsics.areEqual((Object) this.imageUrl, (Object) image.imageUrl) && getFade() == image.getFade();
            }

            public int hashCode() {
                int r0 = Color.m1939hashCodeimpl(this.fallbackColor) * 31;
                String str = this.imageUrl;
                int hashCode = (r0 + (str == null ? 0 : str.hashCode())) * 31;
                boolean fade2 = getFade();
                if (fade2) {
                    fade2 = true;
                }
                return hashCode + (fade2 ? 1 : 0);
            }

            public String toString() {
                return "Image(fallbackColor=" + Color.m1940toStringimpl(this.fallbackColor) + ", imageUrl=" + this.imageUrl + ", fade=" + getFade() + ')';
            }

            /* renamed from: getFallbackColor-0d7_KjU  reason: not valid java name */
            public final long m5238getFallbackColor0d7_KjU() {
                return this.fallbackColor;
            }

            public final String getImageUrl() {
                return this.imageUrl;
            }

            public boolean getFade() {
                return this.fade;
            }

            private Image(long j, String str, boolean z) {
                super((DefaultConstructorMarker) null);
                this.fallbackColor = j;
                this.imageUrl = str;
                this.fade = z;
            }
        }
    }
}
