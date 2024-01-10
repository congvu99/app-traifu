package io.intercom.android.sdk.survey;

import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.survey.TopBarState;
import io.intercom.android.sdk.survey.model.SurveyCustomization;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u000b\f\r\u000eB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0004\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyState;", "", "()V", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "getSurveyUiColors", "()Lio/intercom/android/sdk/survey/SurveyUiColors;", "topBarState", "Lio/intercom/android/sdk/survey/TopBarState;", "getTopBarState", "()Lio/intercom/android/sdk/survey/TopBarState;", "Content", "Error", "Initial", "Loading", "Lio/intercom/android/sdk/survey/SurveyState$Content;", "Lio/intercom/android/sdk/survey/SurveyState$Error;", "Lio/intercom/android/sdk/survey/SurveyState$Initial;", "Lio/intercom/android/sdk/survey/SurveyState$Loading;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyViewModel.kt */
public abstract class SurveyState {
    public /* synthetic */ SurveyState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract SurveyUiColors getSurveyUiColors();

    public abstract TopBarState getTopBarState();

    private SurveyState() {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyState$Initial;", "Lio/intercom/android/sdk/survey/SurveyState;", "()V", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "getSurveyUiColors", "()Lio/intercom/android/sdk/survey/SurveyUiColors;", "topBarState", "Lio/intercom/android/sdk/survey/TopBarState;", "getTopBarState", "()Lio/intercom/android/sdk/survey/TopBarState;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public static final class Initial extends SurveyState {
        public static final int $stable = 0;
        public static final Initial INSTANCE = new Initial();
        private static final SurveyUiColors surveyUiColors = SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null));
        private static final TopBarState topBarState = new TopBarState.NoTopBarState(true, INSTANCE.getSurveyUiColors(), (ProgressBarState) null, 4, (DefaultConstructorMarker) null);

        private Initial() {
            super((DefaultConstructorMarker) null);
        }

        public SurveyUiColors getSurveyUiColors() {
            return surveyUiColors;
        }

        public TopBarState getTopBarState() {
            return topBarState;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyState$Loading;", "Lio/intercom/android/sdk/survey/SurveyState;", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "topBarState", "Lio/intercom/android/sdk/survey/TopBarState;", "(Lio/intercom/android/sdk/survey/SurveyUiColors;Lio/intercom/android/sdk/survey/TopBarState;)V", "getSurveyUiColors", "()Lio/intercom/android/sdk/survey/SurveyUiColors;", "getTopBarState", "()Lio/intercom/android/sdk/survey/TopBarState;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public static final class Loading extends SurveyState {
        public static final int $stable = 0;
        private final SurveyUiColors surveyUiColors;
        private final TopBarState topBarState;

        public static /* synthetic */ Loading copy$default(Loading loading, SurveyUiColors surveyUiColors2, TopBarState topBarState2, int i, Object obj) {
            if ((i & 1) != 0) {
                surveyUiColors2 = loading.getSurveyUiColors();
            }
            if ((i & 2) != 0) {
                topBarState2 = loading.getTopBarState();
            }
            return loading.copy(surveyUiColors2, topBarState2);
        }

        public final SurveyUiColors component1() {
            return getSurveyUiColors();
        }

        public final TopBarState component2() {
            return getTopBarState();
        }

        public final Loading copy(SurveyUiColors surveyUiColors2, TopBarState topBarState2) {
            Intrinsics.checkNotNullParameter(surveyUiColors2, "surveyUiColors");
            Intrinsics.checkNotNullParameter(topBarState2, "topBarState");
            return new Loading(surveyUiColors2, topBarState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Loading)) {
                return false;
            }
            Loading loading = (Loading) obj;
            return Intrinsics.areEqual((Object) getSurveyUiColors(), (Object) loading.getSurveyUiColors()) && Intrinsics.areEqual((Object) getTopBarState(), (Object) loading.getTopBarState());
        }

        public int hashCode() {
            return (getSurveyUiColors().hashCode() * 31) + getTopBarState().hashCode();
        }

        public String toString() {
            return "Loading(surveyUiColors=" + getSurveyUiColors() + ", topBarState=" + getTopBarState() + ')';
        }

        public SurveyUiColors getSurveyUiColors() {
            return this.surveyUiColors;
        }

        public TopBarState getTopBarState() {
            return this.topBarState;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Loading(SurveyUiColors surveyUiColors2, TopBarState topBarState2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(surveyUiColors2, "surveyUiColors");
            Intrinsics.checkNotNullParameter(topBarState2, "topBarState");
            this.surveyUiColors = surveyUiColors2;
            this.topBarState = topBarState2;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyState$Error;", "Lio/intercom/android/sdk/survey/SurveyState;", "()V", "messageResId", "", "getMessageResId", "()I", "WithCTA", "WithoutCTA", "Lio/intercom/android/sdk/survey/SurveyState$Error$WithCTA;", "Lio/intercom/android/sdk/survey/SurveyState$Error$WithoutCTA;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public static abstract class Error extends SurveyState {
        public static final int $stable = 0;

        public /* synthetic */ Error(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract int getMessageResId();

        private Error() {
            super((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyState$Error$WithCTA;", "Lio/intercom/android/sdk/survey/SurveyState$Error;", "messageResId", "", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "topBarState", "Lio/intercom/android/sdk/survey/TopBarState;", "onClick", "Lkotlin/Function0;", "", "(ILio/intercom/android/sdk/survey/SurveyUiColors;Lio/intercom/android/sdk/survey/TopBarState;Lkotlin/jvm/functions/Function0;)V", "getMessageResId", "()I", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getSurveyUiColors", "()Lio/intercom/android/sdk/survey/SurveyUiColors;", "getTopBarState", "()Lio/intercom/android/sdk/survey/TopBarState;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SurveyViewModel.kt */
        public static final class WithCTA extends Error {
            public static final int $stable = 0;
            private final int messageResId;
            private final Function0<Unit> onClick;
            private final SurveyUiColors surveyUiColors;
            private final TopBarState topBarState;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ WithCTA(int i, SurveyUiColors surveyUiColors2, TopBarState topBarState2, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? R.string.intercom_inbox_error_state_title : i, surveyUiColors2, topBarState2, function0);
            }

            public int getMessageResId() {
                return this.messageResId;
            }

            public SurveyUiColors getSurveyUiColors() {
                return this.surveyUiColors;
            }

            public TopBarState getTopBarState() {
                return this.topBarState;
            }

            public final Function0<Unit> getOnClick() {
                return this.onClick;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public WithCTA(int i, SurveyUiColors surveyUiColors2, TopBarState topBarState2, Function0<Unit> function0) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(surveyUiColors2, "surveyUiColors");
                Intrinsics.checkNotNullParameter(topBarState2, "topBarState");
                Intrinsics.checkNotNullParameter(function0, "onClick");
                this.messageResId = i;
                this.surveyUiColors = surveyUiColors2;
                this.topBarState = topBarState2;
                this.onClick = function0;
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyState$Error$WithoutCTA;", "Lio/intercom/android/sdk/survey/SurveyState$Error;", "messageResId", "", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "topBarState", "Lio/intercom/android/sdk/survey/TopBarState;", "(ILio/intercom/android/sdk/survey/SurveyUiColors;Lio/intercom/android/sdk/survey/TopBarState;)V", "getMessageResId", "()I", "getSurveyUiColors", "()Lio/intercom/android/sdk/survey/SurveyUiColors;", "getTopBarState", "()Lio/intercom/android/sdk/survey/TopBarState;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SurveyViewModel.kt */
        public static final class WithoutCTA extends Error {
            public static final int $stable = 0;
            private final int messageResId;
            private final SurveyUiColors surveyUiColors;
            private final TopBarState topBarState;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ WithoutCTA(int i, SurveyUiColors surveyUiColors2, TopBarState topBarState2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? R.string.intercom_inbox_error_state_title : i, surveyUiColors2, topBarState2);
            }

            public int getMessageResId() {
                return this.messageResId;
            }

            public SurveyUiColors getSurveyUiColors() {
                return this.surveyUiColors;
            }

            public TopBarState getTopBarState() {
                return this.topBarState;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public WithoutCTA(int i, SurveyUiColors surveyUiColors2, TopBarState topBarState2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(surveyUiColors2, "surveyUiColors");
                Intrinsics.checkNotNullParameter(topBarState2, "topBarState");
                this.messageResId = i;
                this.surveyUiColors = surveyUiColors2;
                this.topBarState = topBarState2;
            }
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0002)*BG\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000eHÆ\u0003JW\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006+"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyState$Content;", "Lio/intercom/android/sdk/survey/SurveyState;", "stepTitle", "", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "questions", "Lio/intercom/android/sdk/survey/QuestionState;", "secondaryCtaActions", "Lio/intercom/android/sdk/survey/SurveyState$Content$SecondaryCta;", "primaryCta", "Lio/intercom/android/sdk/survey/SurveyState$Content$PrimaryCta;", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "topBarState", "Lio/intercom/android/sdk/survey/TopBarState;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lio/intercom/android/sdk/survey/SurveyState$Content$PrimaryCta;Lio/intercom/android/sdk/survey/SurveyUiColors;Lio/intercom/android/sdk/survey/TopBarState;)V", "getPrimaryCta", "()Lio/intercom/android/sdk/survey/SurveyState$Content$PrimaryCta;", "getQuestions", "()Ljava/util/List;", "getSecondaryCtaActions", "getStepTitle", "getSurveyUiColors", "()Lio/intercom/android/sdk/survey/SurveyUiColors;", "getTopBarState", "()Lio/intercom/android/sdk/survey/TopBarState;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "PrimaryCta", "SecondaryCta", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public static final class Content extends SurveyState {
        public static final int $stable = 8;
        private final PrimaryCta primaryCta;
        private final List<QuestionState> questions;
        private final List<SecondaryCta> secondaryCtaActions;
        private final List<Block.Builder> stepTitle;
        private final SurveyUiColors surveyUiColors;
        private final TopBarState topBarState;

        public static /* synthetic */ Content copy$default(Content content, List<Block.Builder> list, List<QuestionState> list2, List<SecondaryCta> list3, PrimaryCta primaryCta2, SurveyUiColors surveyUiColors2, TopBarState topBarState2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = content.stepTitle;
            }
            if ((i & 2) != 0) {
                list2 = content.questions;
            }
            List<QuestionState> list4 = list2;
            if ((i & 4) != 0) {
                list3 = content.secondaryCtaActions;
            }
            List<SecondaryCta> list5 = list3;
            if ((i & 8) != 0) {
                primaryCta2 = content.primaryCta;
            }
            PrimaryCta primaryCta3 = primaryCta2;
            if ((i & 16) != 0) {
                surveyUiColors2 = content.getSurveyUiColors();
            }
            SurveyUiColors surveyUiColors3 = surveyUiColors2;
            if ((i & 32) != 0) {
                topBarState2 = content.getTopBarState();
            }
            return content.copy(list, list4, list5, primaryCta3, surveyUiColors3, topBarState2);
        }

        public final List<Block.Builder> component1() {
            return this.stepTitle;
        }

        public final List<QuestionState> component2() {
            return this.questions;
        }

        public final List<SecondaryCta> component3() {
            return this.secondaryCtaActions;
        }

        public final PrimaryCta component4() {
            return this.primaryCta;
        }

        public final SurveyUiColors component5() {
            return getSurveyUiColors();
        }

        public final TopBarState component6() {
            return getTopBarState();
        }

        public final Content copy(List<Block.Builder> list, List<QuestionState> list2, List<SecondaryCta> list3, PrimaryCta primaryCta2, SurveyUiColors surveyUiColors2, TopBarState topBarState2) {
            Intrinsics.checkNotNullParameter(list, "stepTitle");
            Intrinsics.checkNotNullParameter(list2, "questions");
            Intrinsics.checkNotNullParameter(list3, "secondaryCtaActions");
            Intrinsics.checkNotNullParameter(primaryCta2, "primaryCta");
            Intrinsics.checkNotNullParameter(surveyUiColors2, "surveyUiColors");
            Intrinsics.checkNotNullParameter(topBarState2, "topBarState");
            return new Content(list, list2, list3, primaryCta2, surveyUiColors2, topBarState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            return Intrinsics.areEqual((Object) this.stepTitle, (Object) content.stepTitle) && Intrinsics.areEqual((Object) this.questions, (Object) content.questions) && Intrinsics.areEqual((Object) this.secondaryCtaActions, (Object) content.secondaryCtaActions) && Intrinsics.areEqual((Object) this.primaryCta, (Object) content.primaryCta) && Intrinsics.areEqual((Object) getSurveyUiColors(), (Object) content.getSurveyUiColors()) && Intrinsics.areEqual((Object) getTopBarState(), (Object) content.getTopBarState());
        }

        public int hashCode() {
            return (((((((((this.stepTitle.hashCode() * 31) + this.questions.hashCode()) * 31) + this.secondaryCtaActions.hashCode()) * 31) + this.primaryCta.hashCode()) * 31) + getSurveyUiColors().hashCode()) * 31) + getTopBarState().hashCode();
        }

        public String toString() {
            return "Content(stepTitle=" + this.stepTitle + ", questions=" + this.questions + ", secondaryCtaActions=" + this.secondaryCtaActions + ", primaryCta=" + this.primaryCta + ", surveyUiColors=" + getSurveyUiColors() + ", topBarState=" + getTopBarState() + ')';
        }

        public final List<Block.Builder> getStepTitle() {
            return this.stepTitle;
        }

        public final List<QuestionState> getQuestions() {
            return this.questions;
        }

        public final List<SecondaryCta> getSecondaryCtaActions() {
            return this.secondaryCtaActions;
        }

        public final PrimaryCta getPrimaryCta() {
            return this.primaryCta;
        }

        public SurveyUiColors getSurveyUiColors() {
            return this.surveyUiColors;
        }

        public TopBarState getTopBarState() {
            return this.topBarState;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyState$Content$SecondaryCta;", "", "buttonText", "", "destination", "isExternalUrl", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getButtonText", "()Ljava/lang/String;", "getDestination", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SurveyViewModel.kt */
        public static final class SecondaryCta {
            public static final int $stable = 0;
            private final String buttonText;
            private final String destination;
            private final boolean isExternalUrl;

            public static /* synthetic */ SecondaryCta copy$default(SecondaryCta secondaryCta, String str, String str2, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = secondaryCta.buttonText;
                }
                if ((i & 2) != 0) {
                    str2 = secondaryCta.destination;
                }
                if ((i & 4) != 0) {
                    z = secondaryCta.isExternalUrl;
                }
                return secondaryCta.copy(str, str2, z);
            }

            public final String component1() {
                return this.buttonText;
            }

            public final String component2() {
                return this.destination;
            }

            public final boolean component3() {
                return this.isExternalUrl;
            }

            public final SecondaryCta copy(String str, String str2, boolean z) {
                Intrinsics.checkNotNullParameter(str, "buttonText");
                Intrinsics.checkNotNullParameter(str2, "destination");
                return new SecondaryCta(str, str2, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SecondaryCta)) {
                    return false;
                }
                SecondaryCta secondaryCta = (SecondaryCta) obj;
                return Intrinsics.areEqual((Object) this.buttonText, (Object) secondaryCta.buttonText) && Intrinsics.areEqual((Object) this.destination, (Object) secondaryCta.destination) && this.isExternalUrl == secondaryCta.isExternalUrl;
            }

            public int hashCode() {
                int hashCode = ((this.buttonText.hashCode() * 31) + this.destination.hashCode()) * 31;
                boolean z = this.isExternalUrl;
                if (z) {
                    z = true;
                }
                return hashCode + (z ? 1 : 0);
            }

            public String toString() {
                return "SecondaryCta(buttonText=" + this.buttonText + ", destination=" + this.destination + ", isExternalUrl=" + this.isExternalUrl + ')';
            }

            public SecondaryCta(String str, String str2, boolean z) {
                Intrinsics.checkNotNullParameter(str, "buttonText");
                Intrinsics.checkNotNullParameter(str2, "destination");
                this.buttonText = str;
                this.destination = str2;
                this.isExternalUrl = z;
            }

            public final String getButtonText() {
                return this.buttonText;
            }

            public final String getDestination() {
                return this.destination;
            }

            public final boolean isExternalUrl() {
                return this.isExternalUrl;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Content(List<Block.Builder> list, List<QuestionState> list2, List<SecondaryCta> list3, PrimaryCta primaryCta2, SurveyUiColors surveyUiColors2, TopBarState topBarState2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "stepTitle");
            Intrinsics.checkNotNullParameter(list2, "questions");
            Intrinsics.checkNotNullParameter(list3, "secondaryCtaActions");
            Intrinsics.checkNotNullParameter(primaryCta2, "primaryCta");
            Intrinsics.checkNotNullParameter(surveyUiColors2, "surveyUiColors");
            Intrinsics.checkNotNullParameter(topBarState2, "topBarState");
            this.stepTitle = list;
            this.questions = list2;
            this.secondaryCtaActions = list3;
            this.primaryCta = primaryCta2;
            this.surveyUiColors = surveyUiColors2;
            this.topBarState = topBarState2;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyState$Content$PrimaryCta;", "", "()V", "Custom", "Fallback", "Lio/intercom/android/sdk/survey/SurveyState$Content$PrimaryCta$Custom;", "Lio/intercom/android/sdk/survey/SurveyState$Content$PrimaryCta$Fallback;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SurveyViewModel.kt */
        public static abstract class PrimaryCta {
            public static final int $stable = 0;

            public /* synthetic */ PrimaryCta(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyState$Content$PrimaryCta$Fallback;", "Lio/intercom/android/sdk/survey/SurveyState$Content$PrimaryCta;", "fallbackTextRes", "", "(I)V", "getFallbackTextRes", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyViewModel.kt */
            public static final class Fallback extends PrimaryCta {
                public static final int $stable = 0;
                private final int fallbackTextRes;

                public static /* synthetic */ Fallback copy$default(Fallback fallback, int i, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        i = fallback.fallbackTextRes;
                    }
                    return fallback.copy(i);
                }

                public final int component1() {
                    return this.fallbackTextRes;
                }

                public final Fallback copy(int i) {
                    return new Fallback(i);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Fallback) && this.fallbackTextRes == ((Fallback) obj).fallbackTextRes;
                }

                public int hashCode() {
                    return this.fallbackTextRes;
                }

                public String toString() {
                    return "Fallback(fallbackTextRes=" + this.fallbackTextRes + ')';
                }

                public Fallback(int i) {
                    super((DefaultConstructorMarker) null);
                    this.fallbackTextRes = i;
                }

                public final int getFallbackTextRes() {
                    return this.fallbackTextRes;
                }
            }

            private PrimaryCta() {
            }

            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyState$Content$PrimaryCta$Custom;", "Lio/intercom/android/sdk/survey/SurveyState$Content$PrimaryCta;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyViewModel.kt */
            public static final class Custom extends PrimaryCta {
                public static final int $stable = 0;
                private final String text;

                public static /* synthetic */ Custom copy$default(Custom custom, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = custom.text;
                    }
                    return custom.copy(str);
                }

                public final String component1() {
                    return this.text;
                }

                public final Custom copy(String str) {
                    Intrinsics.checkNotNullParameter(str, "text");
                    return new Custom(str);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Custom) && Intrinsics.areEqual((Object) this.text, (Object) ((Custom) obj).text);
                }

                public int hashCode() {
                    return this.text.hashCode();
                }

                public String toString() {
                    return "Custom(text=" + this.text + ')';
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Custom(String str) {
                    super((DefaultConstructorMarker) null);
                    Intrinsics.checkNotNullParameter(str, "text");
                    this.text = str;
                }

                public final String getText() {
                    return this.text;
                }
            }
        }
    }
}
