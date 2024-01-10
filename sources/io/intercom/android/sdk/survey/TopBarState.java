package io.intercom.android.sdk.survey;

import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Avatar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0000H&J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lio/intercom/android/sdk/survey/TopBarState;", "", "()V", "progressBarState", "Lio/intercom/android/sdk/survey/ProgressBarState;", "getProgressBarState", "()Lio/intercom/android/sdk/survey/ProgressBarState;", "showDismissButton", "", "getShowDismissButton", "()Z", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "getSurveyUiColors", "()Lio/intercom/android/sdk/survey/SurveyUiColors;", "enableDismissButton", "withProgressBarState", "NoTopBarState", "SenderTopBarState", "Lio/intercom/android/sdk/survey/TopBarState$NoTopBarState;", "Lio/intercom/android/sdk/survey/TopBarState$SenderTopBarState;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyViewModel.kt */
public abstract class TopBarState {
    public /* synthetic */ TopBarState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract TopBarState enableDismissButton();

    public abstract ProgressBarState getProgressBarState();

    public abstract boolean getShowDismissButton();

    public abstract SurveyUiColors getSurveyUiColors();

    public abstract TopBarState withProgressBarState(ProgressBarState progressBarState);

    private TopBarState() {
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\b\u0010\"\u001a\u00020\u0001H\u0016J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\u0010\u0010)\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lio/intercom/android/sdk/survey/TopBarState$SenderTopBarState;", "Lio/intercom/android/sdk/survey/TopBarState;", "avatar", "Lio/intercom/android/sdk/models/Avatar;", "senderName", "", "appConfig", "Lio/intercom/android/sdk/identity/AppConfig;", "showDismissButton", "", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "progressBarState", "Lio/intercom/android/sdk/survey/ProgressBarState;", "(Lio/intercom/android/sdk/models/Avatar;Ljava/lang/String;Lio/intercom/android/sdk/identity/AppConfig;ZLio/intercom/android/sdk/survey/SurveyUiColors;Lio/intercom/android/sdk/survey/ProgressBarState;)V", "getAppConfig", "()Lio/intercom/android/sdk/identity/AppConfig;", "getAvatar", "()Lio/intercom/android/sdk/models/Avatar;", "getProgressBarState", "()Lio/intercom/android/sdk/survey/ProgressBarState;", "getSenderName", "()Ljava/lang/String;", "getShowDismissButton", "()Z", "getSurveyUiColors", "()Lio/intercom/android/sdk/survey/SurveyUiColors;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "enableDismissButton", "equals", "other", "", "hashCode", "", "toString", "withProgressBarState", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public static final class SenderTopBarState extends TopBarState {
        public static final int $stable = 8;
        private final AppConfig appConfig;
        private final Avatar avatar;
        private final ProgressBarState progressBarState;
        private final String senderName;
        private final boolean showDismissButton;
        private final SurveyUiColors surveyUiColors;

        public static /* synthetic */ SenderTopBarState copy$default(SenderTopBarState senderTopBarState, Avatar avatar2, String str, AppConfig appConfig2, boolean z, SurveyUiColors surveyUiColors2, ProgressBarState progressBarState2, int i, Object obj) {
            if ((i & 1) != 0) {
                avatar2 = senderTopBarState.avatar;
            }
            if ((i & 2) != 0) {
                str = senderTopBarState.senderName;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                appConfig2 = senderTopBarState.appConfig;
            }
            AppConfig appConfig3 = appConfig2;
            if ((i & 8) != 0) {
                z = senderTopBarState.getShowDismissButton();
            }
            boolean z2 = z;
            if ((i & 16) != 0) {
                surveyUiColors2 = senderTopBarState.getSurveyUiColors();
            }
            SurveyUiColors surveyUiColors3 = surveyUiColors2;
            if ((i & 32) != 0) {
                progressBarState2 = senderTopBarState.getProgressBarState();
            }
            return senderTopBarState.copy(avatar2, str2, appConfig3, z2, surveyUiColors3, progressBarState2);
        }

        public final Avatar component1() {
            return this.avatar;
        }

        public final String component2() {
            return this.senderName;
        }

        public final AppConfig component3() {
            return this.appConfig;
        }

        public final boolean component4() {
            return getShowDismissButton();
        }

        public final SurveyUiColors component5() {
            return getSurveyUiColors();
        }

        public final ProgressBarState component6() {
            return getProgressBarState();
        }

        public final SenderTopBarState copy(Avatar avatar2, String str, AppConfig appConfig2, boolean z, SurveyUiColors surveyUiColors2, ProgressBarState progressBarState2) {
            Intrinsics.checkNotNullParameter(avatar2, "avatar");
            Intrinsics.checkNotNullParameter(str, "senderName");
            Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
            Intrinsics.checkNotNullParameter(surveyUiColors2, "surveyUiColors");
            Intrinsics.checkNotNullParameter(progressBarState2, "progressBarState");
            return new SenderTopBarState(avatar2, str, appConfig2, z, surveyUiColors2, progressBarState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SenderTopBarState)) {
                return false;
            }
            SenderTopBarState senderTopBarState = (SenderTopBarState) obj;
            return Intrinsics.areEqual((Object) this.avatar, (Object) senderTopBarState.avatar) && Intrinsics.areEqual((Object) this.senderName, (Object) senderTopBarState.senderName) && Intrinsics.areEqual((Object) this.appConfig, (Object) senderTopBarState.appConfig) && getShowDismissButton() == senderTopBarState.getShowDismissButton() && Intrinsics.areEqual((Object) getSurveyUiColors(), (Object) senderTopBarState.getSurveyUiColors()) && Intrinsics.areEqual((Object) getProgressBarState(), (Object) senderTopBarState.getProgressBarState());
        }

        public int hashCode() {
            int hashCode = ((((this.avatar.hashCode() * 31) + this.senderName.hashCode()) * 31) + this.appConfig.hashCode()) * 31;
            boolean showDismissButton2 = getShowDismissButton();
            if (showDismissButton2) {
                showDismissButton2 = true;
            }
            return ((((hashCode + (showDismissButton2 ? 1 : 0)) * 31) + getSurveyUiColors().hashCode()) * 31) + getProgressBarState().hashCode();
        }

        public String toString() {
            return "SenderTopBarState(avatar=" + this.avatar + ", senderName=" + this.senderName + ", appConfig=" + this.appConfig + ", showDismissButton=" + getShowDismissButton() + ", surveyUiColors=" + getSurveyUiColors() + ", progressBarState=" + getProgressBarState() + ')';
        }

        public final Avatar getAvatar() {
            return this.avatar;
        }

        public final String getSenderName() {
            return this.senderName;
        }

        public final AppConfig getAppConfig() {
            return this.appConfig;
        }

        public boolean getShowDismissButton() {
            return this.showDismissButton;
        }

        public SurveyUiColors getSurveyUiColors() {
            return this.surveyUiColors;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SenderTopBarState(Avatar avatar2, String str, AppConfig appConfig2, boolean z, SurveyUiColors surveyUiColors2, ProgressBarState progressBarState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(avatar2, str, appConfig2, z, surveyUiColors2, (i & 32) != 0 ? new ProgressBarState(false, 0.0f, 3, (DefaultConstructorMarker) null) : progressBarState2);
        }

        public ProgressBarState getProgressBarState() {
            return this.progressBarState;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SenderTopBarState(Avatar avatar2, String str, AppConfig appConfig2, boolean z, SurveyUiColors surveyUiColors2, ProgressBarState progressBarState2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(avatar2, "avatar");
            Intrinsics.checkNotNullParameter(str, "senderName");
            Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
            Intrinsics.checkNotNullParameter(surveyUiColors2, "surveyUiColors");
            Intrinsics.checkNotNullParameter(progressBarState2, "progressBarState");
            this.avatar = avatar2;
            this.senderName = str;
            this.appConfig = appConfig2;
            this.showDismissButton = z;
            this.surveyUiColors = surveyUiColors2;
            this.progressBarState = progressBarState2;
        }

        public TopBarState enableDismissButton() {
            return copy$default(this, (Avatar) null, (String) null, (AppConfig) null, true, (SurveyUiColors) null, (ProgressBarState) null, 55, (Object) null);
        }

        public TopBarState withProgressBarState(ProgressBarState progressBarState2) {
            Intrinsics.checkNotNullParameter(progressBarState2, "progressBarState");
            return copy$default(this, (Avatar) null, (String) null, (AppConfig) null, false, (SurveyUiColors) null, progressBarState2, 31, (Object) null);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\b\u0010\u0013\u001a\u00020\u0001H\u0016J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lio/intercom/android/sdk/survey/TopBarState$NoTopBarState;", "Lio/intercom/android/sdk/survey/TopBarState;", "showDismissButton", "", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "progressBarState", "Lio/intercom/android/sdk/survey/ProgressBarState;", "(ZLio/intercom/android/sdk/survey/SurveyUiColors;Lio/intercom/android/sdk/survey/ProgressBarState;)V", "getProgressBarState", "()Lio/intercom/android/sdk/survey/ProgressBarState;", "getShowDismissButton", "()Z", "getSurveyUiColors", "()Lio/intercom/android/sdk/survey/SurveyUiColors;", "component1", "component2", "component3", "copy", "enableDismissButton", "equals", "other", "", "hashCode", "", "toString", "", "withProgressBarState", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public static final class NoTopBarState extends TopBarState {
        public static final int $stable = 0;
        private final ProgressBarState progressBarState;
        private final boolean showDismissButton;
        private final SurveyUiColors surveyUiColors;

        public static /* synthetic */ NoTopBarState copy$default(NoTopBarState noTopBarState, boolean z, SurveyUiColors surveyUiColors2, ProgressBarState progressBarState2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = noTopBarState.getShowDismissButton();
            }
            if ((i & 2) != 0) {
                surveyUiColors2 = noTopBarState.getSurveyUiColors();
            }
            if ((i & 4) != 0) {
                progressBarState2 = noTopBarState.getProgressBarState();
            }
            return noTopBarState.copy(z, surveyUiColors2, progressBarState2);
        }

        public final boolean component1() {
            return getShowDismissButton();
        }

        public final SurveyUiColors component2() {
            return getSurveyUiColors();
        }

        public final ProgressBarState component3() {
            return getProgressBarState();
        }

        public final NoTopBarState copy(boolean z, SurveyUiColors surveyUiColors2, ProgressBarState progressBarState2) {
            Intrinsics.checkNotNullParameter(surveyUiColors2, "surveyUiColors");
            Intrinsics.checkNotNullParameter(progressBarState2, "progressBarState");
            return new NoTopBarState(z, surveyUiColors2, progressBarState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NoTopBarState)) {
                return false;
            }
            NoTopBarState noTopBarState = (NoTopBarState) obj;
            return getShowDismissButton() == noTopBarState.getShowDismissButton() && Intrinsics.areEqual((Object) getSurveyUiColors(), (Object) noTopBarState.getSurveyUiColors()) && Intrinsics.areEqual((Object) getProgressBarState(), (Object) noTopBarState.getProgressBarState());
        }

        public int hashCode() {
            boolean showDismissButton2 = getShowDismissButton();
            if (showDismissButton2) {
                showDismissButton2 = true;
            }
            return ((((showDismissButton2 ? 1 : 0) * true) + getSurveyUiColors().hashCode()) * 31) + getProgressBarState().hashCode();
        }

        public String toString() {
            return "NoTopBarState(showDismissButton=" + getShowDismissButton() + ", surveyUiColors=" + getSurveyUiColors() + ", progressBarState=" + getProgressBarState() + ')';
        }

        public boolean getShowDismissButton() {
            return this.showDismissButton;
        }

        public SurveyUiColors getSurveyUiColors() {
            return this.surveyUiColors;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NoTopBarState(boolean z, SurveyUiColors surveyUiColors2, ProgressBarState progressBarState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, surveyUiColors2, (i & 4) != 0 ? new ProgressBarState(false, 0.0f, 3, (DefaultConstructorMarker) null) : progressBarState2);
        }

        public ProgressBarState getProgressBarState() {
            return this.progressBarState;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NoTopBarState(boolean z, SurveyUiColors surveyUiColors2, ProgressBarState progressBarState2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(surveyUiColors2, "surveyUiColors");
            Intrinsics.checkNotNullParameter(progressBarState2, "progressBarState");
            this.showDismissButton = z;
            this.surveyUiColors = surveyUiColors2;
            this.progressBarState = progressBarState2;
        }

        public TopBarState enableDismissButton() {
            return copy$default(this, true, (SurveyUiColors) null, (ProgressBarState) null, 6, (Object) null);
        }

        public TopBarState withProgressBarState(ProgressBarState progressBarState2) {
            Intrinsics.checkNotNullParameter(progressBarState2, "progressBarState");
            return copy$default(this, false, (SurveyUiColors) null, progressBarState2, 3, (Object) null);
        }
    }
}
