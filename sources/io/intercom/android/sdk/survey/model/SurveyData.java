package io.intercom.android.sdk.survey.model;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import io.intercom.android.sdk.blocks.lib.models.Block;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\"\b\b\u0018\u0000 52\u00020\u0001:\u000556789BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0010HÆ\u0003Jk\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001J\u0013\u00101\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u000eHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0011\u001a\u00020\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014¨\u0006:"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData;", "", "_format", "", "id", "steps", "", "Lio/intercom/android/sdk/survey/model/SurveyData$Step;", "surveyProgressId", "customization", "Lio/intercom/android/sdk/survey/model/SurveyCustomization;", "sender", "Lio/intercom/android/sdk/survey/model/SurveySenderData;", "stepCount", "", "isDismissible", "", "showProgressBar", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lio/intercom/android/sdk/survey/model/SurveyCustomization;Lio/intercom/android/sdk/survey/model/SurveySenderData;IZZ)V", "get_format", "()Ljava/lang/String;", "getCustomization", "()Lio/intercom/android/sdk/survey/model/SurveyCustomization;", "format", "Lio/intercom/android/sdk/survey/model/SurveyData$SurveyFormat;", "getFormat", "()Lio/intercom/android/sdk/survey/model/SurveyData$SurveyFormat;", "formatMetric", "getFormatMetric", "getId", "()Z", "getSender", "()Lio/intercom/android/sdk/survey/model/SurveySenderData;", "getShowProgressBar", "getStepCount", "()I", "getSteps", "()Ljava/util/List;", "getSurveyProgressId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "Step", "StepType", "SurveyActions", "SurveyFormat", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyData.kt */
public final class SurveyData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final SurveyData NULL = new SurveyData("1", "", CollectionsKt.emptyList(), AppEventsConstants.EVENT_PARAM_VALUE_NO, new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null), new SurveySenderData((String) null, (String) null, (String) null, (SurveySenderAvatar) null, 15, (DefaultConstructorMarker) null), 0, true, false, 256, (DefaultConstructorMarker) null);
    @SerializedName("format")
    private final String _format;
    @SerializedName("customization_options")
    private final SurveyCustomization customization;
    @SerializedName("id")
    private final String id;
    @SerializedName("dismissible")
    private final boolean isDismissible;
    @SerializedName("sender")
    private final SurveySenderData sender;
    @SerializedName("show_progress_bar")
    private final boolean showProgressBar;
    @SerializedName("step_count")
    private final int stepCount;
    @SerializedName("steps")
    private final List<Step> steps;
    @SerializedName("survey_progress_id")
    private final String surveyProgressId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$StepType;", "", "(Ljava/lang/String;I)V", "CONTENT", "QUESTION", "INTRO", "THANK_YOU", "UNSUPPORTED", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyData.kt */
    public enum StepType {
        CONTENT,
        QUESTION,
        INTRO,
        THANK_YOU,
        UNSUPPORTED
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$SurveyFormat;", "", "(Ljava/lang/String;I)V", "SMALL_FORMAT", "LARGE_FORMAT", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyData.kt */
    public enum SurveyFormat {
        SMALL_FORMAT,
        LARGE_FORMAT
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyData.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyFormat.values().length];
            iArr[SurveyFormat.SMALL_FORMAT.ordinal()] = 1;
            iArr[SurveyFormat.LARGE_FORMAT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ SurveyData copy$default(SurveyData surveyData, String str, String str2, List list, String str3, SurveyCustomization surveyCustomization, SurveySenderData surveySenderData, int i, boolean z, boolean z2, int i2, Object obj) {
        SurveyData surveyData2 = surveyData;
        int i3 = i2;
        return surveyData.copy((i3 & 1) != 0 ? surveyData2._format : str, (i3 & 2) != 0 ? surveyData2.id : str2, (i3 & 4) != 0 ? surveyData2.steps : list, (i3 & 8) != 0 ? surveyData2.surveyProgressId : str3, (i3 & 16) != 0 ? surveyData2.customization : surveyCustomization, (i3 & 32) != 0 ? surveyData2.sender : surveySenderData, (i3 & 64) != 0 ? surveyData2.stepCount : i, (i3 & 128) != 0 ? surveyData2.isDismissible : z, (i3 & 256) != 0 ? surveyData2.showProgressBar : z2);
    }

    public final String component1() {
        return this._format;
    }

    public final String component2() {
        return this.id;
    }

    public final List<Step> component3() {
        return this.steps;
    }

    public final String component4() {
        return this.surveyProgressId;
    }

    public final SurveyCustomization component5() {
        return this.customization;
    }

    public final SurveySenderData component6() {
        return this.sender;
    }

    public final int component7() {
        return this.stepCount;
    }

    public final boolean component8() {
        return this.isDismissible;
    }

    public final boolean component9() {
        return this.showProgressBar;
    }

    public final SurveyData copy(String str, String str2, List<Step> list, String str3, SurveyCustomization surveyCustomization, SurveySenderData surveySenderData, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "_format");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(list, "steps");
        Intrinsics.checkNotNullParameter(str3, "surveyProgressId");
        SurveyCustomization surveyCustomization2 = surveyCustomization;
        Intrinsics.checkNotNullParameter(surveyCustomization2, "customization");
        return new SurveyData(str, str2, list, str3, surveyCustomization2, surveySenderData, i, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurveyData)) {
            return false;
        }
        SurveyData surveyData = (SurveyData) obj;
        return Intrinsics.areEqual((Object) this._format, (Object) surveyData._format) && Intrinsics.areEqual((Object) this.id, (Object) surveyData.id) && Intrinsics.areEqual((Object) this.steps, (Object) surveyData.steps) && Intrinsics.areEqual((Object) this.surveyProgressId, (Object) surveyData.surveyProgressId) && Intrinsics.areEqual((Object) this.customization, (Object) surveyData.customization) && Intrinsics.areEqual((Object) this.sender, (Object) surveyData.sender) && this.stepCount == surveyData.stepCount && this.isDismissible == surveyData.isDismissible && this.showProgressBar == surveyData.showProgressBar;
    }

    public int hashCode() {
        int hashCode = ((((((((this._format.hashCode() * 31) + this.id.hashCode()) * 31) + this.steps.hashCode()) * 31) + this.surveyProgressId.hashCode()) * 31) + this.customization.hashCode()) * 31;
        SurveySenderData surveySenderData = this.sender;
        int hashCode2 = (((hashCode + (surveySenderData == null ? 0 : surveySenderData.hashCode())) * 31) + this.stepCount) * 31;
        boolean z = this.isDismissible;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.showProgressBar;
        if (!z3) {
            z2 = z3;
        }
        return i + (z2 ? 1 : 0);
    }

    public String toString() {
        return "SurveyData(_format=" + this._format + ", id=" + this.id + ", steps=" + this.steps + ", surveyProgressId=" + this.surveyProgressId + ", customization=" + this.customization + ", sender=" + this.sender + ", stepCount=" + this.stepCount + ", isDismissible=" + this.isDismissible + ", showProgressBar=" + this.showProgressBar + ')';
    }

    public SurveyData(String str, String str2, List<Step> list, String str3, SurveyCustomization surveyCustomization, SurveySenderData surveySenderData, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "_format");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(list, "steps");
        Intrinsics.checkNotNullParameter(str3, "surveyProgressId");
        Intrinsics.checkNotNullParameter(surveyCustomization, "customization");
        this._format = str;
        this.id = str2;
        this.steps = list;
        this.surveyProgressId = str3;
        this.customization = surveyCustomization;
        this.sender = surveySenderData;
        this.stepCount = i;
        this.isDismissible = z;
        this.showProgressBar = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SurveyData(String str, String str2, List list, String str3, SurveyCustomization surveyCustomization, SurveySenderData surveySenderData, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, str3, surveyCustomization, surveySenderData, i, z, (i2 & 256) != 0 ? true : z2);
    }

    public final String get_format() {
        return this._format;
    }

    public final String getId() {
        return this.id;
    }

    public final List<Step> getSteps() {
        return this.steps;
    }

    public final String getSurveyProgressId() {
        return this.surveyProgressId;
    }

    public final SurveyCustomization getCustomization() {
        return this.customization;
    }

    public final SurveySenderData getSender() {
        return this.sender;
    }

    public final int getStepCount() {
        return this.stepCount;
    }

    public final boolean isDismissible() {
        return this.isDismissible;
    }

    public final boolean getShowProgressBar() {
        return this.showProgressBar;
    }

    public final SurveyFormat getFormat() {
        if (Integer.parseInt(this._format) == 0) {
            return SurveyFormat.SMALL_FORMAT;
        }
        return SurveyFormat.LARGE_FORMAT;
    }

    public final String getFormatMetric() {
        int i = WhenMappings.$EnumSwitchMapping$0[getFormat().ordinal()];
        if (i == 1) {
            return "small_full_screen";
        }
        if (i == 2) {
            return "large_full_screen";
        }
        throw new NoWhenBranchMatchedException();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$SurveyActions;", "", "actionTitle", "", "id", "", "webUrl", "androidUri", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getActionTitle", "()Ljava/lang/String;", "getAndroidUri", "getId", "()I", "getWebUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyData.kt */
    public static final class SurveyActions {
        public static final int $stable = 0;
        @SerializedName("action_title")
        private final String actionTitle;
        @SerializedName("android_uri")
        private final String androidUri;
        @SerializedName("id")
        private final int id;
        @SerializedName("web_url")
        private final String webUrl;

        public static /* synthetic */ SurveyActions copy$default(SurveyActions surveyActions, String str, int i, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = surveyActions.actionTitle;
            }
            if ((i2 & 2) != 0) {
                i = surveyActions.id;
            }
            if ((i2 & 4) != 0) {
                str2 = surveyActions.webUrl;
            }
            if ((i2 & 8) != 0) {
                str3 = surveyActions.androidUri;
            }
            return surveyActions.copy(str, i, str2, str3);
        }

        public final String component1() {
            return this.actionTitle;
        }

        public final int component2() {
            return this.id;
        }

        public final String component3() {
            return this.webUrl;
        }

        public final String component4() {
            return this.androidUri;
        }

        public final SurveyActions copy(String str, int i, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "actionTitle");
            return new SurveyActions(str, i, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SurveyActions)) {
                return false;
            }
            SurveyActions surveyActions = (SurveyActions) obj;
            return Intrinsics.areEqual((Object) this.actionTitle, (Object) surveyActions.actionTitle) && this.id == surveyActions.id && Intrinsics.areEqual((Object) this.webUrl, (Object) surveyActions.webUrl) && Intrinsics.areEqual((Object) this.androidUri, (Object) surveyActions.androidUri);
        }

        public int hashCode() {
            int hashCode = ((this.actionTitle.hashCode() * 31) + this.id) * 31;
            String str = this.webUrl;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.androidUri;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "SurveyActions(actionTitle=" + this.actionTitle + ", id=" + this.id + ", webUrl=" + this.webUrl + ", androidUri=" + this.androidUri + ')';
        }

        public SurveyActions(String str, int i, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "actionTitle");
            this.actionTitle = str;
            this.id = i;
            this.webUrl = str2;
            this.androidUri = str3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SurveyActions(String str, int i, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3);
        }

        public final String getActionTitle() {
            return this.actionTitle;
        }

        public final int getId() {
            return this.id;
        }

        public final String getWebUrl() {
            return this.webUrl;
        }

        public final String getAndroidUri() {
            return this.androidUri;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001&BM\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÂ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003JY\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001R\u0010\u0010\t\u001a\u00020\n8\u0002X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step;", "", "blocks", "", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "id", "", "questions", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question;", "_type", "", "actions", "Lio/intercom/android/sdk/survey/model/SurveyData$SurveyActions;", "customButtonText", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;ILjava/util/List;Ljava/lang/String;)V", "getActions", "()Ljava/util/List;", "getBlocks", "getCustomButtonText", "()Ljava/lang/String;", "getId", "getQuestions", "type", "Lio/intercom/android/sdk/survey/model/SurveyData$StepType;", "getType", "()Lio/intercom/android/sdk/survey/model/SurveyData$StepType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Question", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyData.kt */
    public static final class Step {
        public static final int $stable = 8;
        @SerializedName("step_type")
        private final int _type;
        @SerializedName("actions")
        private final List<SurveyActions> actions;
        @SerializedName("blocks")
        private final List<Block.Builder> blocks;
        @SerializedName("custom_button_text")
        private final String customButtonText;
        @SerializedName("id")
        private final String id;
        @SerializedName("questions")
        private final List<Question> questions;

        private final int component4() {
            return this._type;
        }

        public static /* synthetic */ Step copy$default(Step step, List<Block.Builder> list, String str, List<Question> list2, int i, List<SurveyActions> list3, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = step.blocks;
            }
            if ((i2 & 2) != 0) {
                str = step.id;
            }
            String str3 = str;
            if ((i2 & 4) != 0) {
                list2 = step.questions;
            }
            List<Question> list4 = list2;
            if ((i2 & 8) != 0) {
                i = step._type;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                list3 = step.actions;
            }
            List<SurveyActions> list5 = list3;
            if ((i2 & 32) != 0) {
                str2 = step.customButtonText;
            }
            return step.copy(list, str3, list4, i3, list5, str2);
        }

        public final List<Block.Builder> component1() {
            return this.blocks;
        }

        public final String component2() {
            return this.id;
        }

        public final List<Question> component3() {
            return this.questions;
        }

        public final List<SurveyActions> component5() {
            return this.actions;
        }

        public final String component6() {
            return this.customButtonText;
        }

        public final Step copy(List<Block.Builder> list, String str, List<Question> list2, int i, List<SurveyActions> list3, String str2) {
            Intrinsics.checkNotNullParameter(list, "blocks");
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(list2, "questions");
            Intrinsics.checkNotNullParameter(list3, "actions");
            return new Step(list, str, list2, i, list3, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Step)) {
                return false;
            }
            Step step = (Step) obj;
            return Intrinsics.areEqual((Object) this.blocks, (Object) step.blocks) && Intrinsics.areEqual((Object) this.id, (Object) step.id) && Intrinsics.areEqual((Object) this.questions, (Object) step.questions) && this._type == step._type && Intrinsics.areEqual((Object) this.actions, (Object) step.actions) && Intrinsics.areEqual((Object) this.customButtonText, (Object) step.customButtonText);
        }

        public int hashCode() {
            int hashCode = ((((((((this.blocks.hashCode() * 31) + this.id.hashCode()) * 31) + this.questions.hashCode()) * 31) + this._type) * 31) + this.actions.hashCode()) * 31;
            String str = this.customButtonText;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Step(blocks=" + this.blocks + ", id=" + this.id + ", questions=" + this.questions + ", _type=" + this._type + ", actions=" + this.actions + ", customButtonText=" + this.customButtonText + ')';
        }

        public Step(List<Block.Builder> list, String str, List<Question> list2, int i, List<SurveyActions> list3, String str2) {
            Intrinsics.checkNotNullParameter(list, "blocks");
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(list2, "questions");
            Intrinsics.checkNotNullParameter(list3, "actions");
            this.blocks = list;
            this.id = str;
            this.questions = list2;
            this._type = i;
            this.actions = list3;
            this.customButtonText = str2;
        }

        public final List<Block.Builder> getBlocks() {
            return this.blocks;
        }

        public final String getId() {
            return this.id;
        }

        public final List<Question> getQuestions() {
            return this.questions;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Step(List list, String str, List list2, int i, List list3, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, str, list2, i, (i2 & 16) != 0 ? CollectionsKt.emptyList() : list3, (i2 & 32) != 0 ? null : str2);
        }

        public final List<SurveyActions> getActions() {
            return this.actions;
        }

        public final String getCustomButtonText() {
            return this.customButtonText;
        }

        public final StepType getType() {
            int i = this._type;
            if (i == 0) {
                return StepType.CONTENT;
            }
            if (i == 1) {
                return StepType.QUESTION;
            }
            if (i == 2) {
                return StepType.INTRO;
            }
            if (i != 3) {
                return StepType.UNSUPPORTED;
            }
            return StepType.THANK_YOU;
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001:\f\u001c\u001d\u001e\u001f !\"#$%&'B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÂ\u0003J\t\u0010\u0013\u001a\u00020\nHÂ\u0003J7\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\t\u001a\u00020\n8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question;", "", "blocks", "", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "id", "", "questionType", "", "questionData", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionData;", "(Ljava/util/List;Ljava/lang/String;ILio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionData;)V", "getBlocks", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getQuestionModel", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;", "hashCode", "toString", "DatePickerQuestionModel", "DropDownQuestionModel", "LongTextQuestionModel", "MultipleChoiceQuestionModel", "NumericRatingQuestionModel", "QuestionData", "QuestionModel", "QuestionType", "QuestionValidation", "ShortTextQuestionModel", "SingleChoiceQuestionModel", "UnsupportedQuestion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SurveyData.kt */
        public static final class Question {
            public static final int $stable = 8;
            @SerializedName("blocks")
            private final List<Block.Builder> blocks;
            @SerializedName("id")
            private final String id;
            @SerializedName("data")
            private final QuestionData questionData;
            @SerializedName("question_type")
            private final int questionType;

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionType;", "", "(Ljava/lang/String;I)V", "INPUT", "TEXT", "DROPDOWN", "RATING_SCALE", "MULTI_SELECT", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyData.kt */
            public enum QuestionType {
                INPUT,
                TEXT,
                DROPDOWN,
                RATING_SCALE,
                MULTI_SELECT
            }

            private final int component3() {
                return this.questionType;
            }

            private final QuestionData component4() {
                return this.questionData;
            }

            public static /* synthetic */ Question copy$default(Question question, List<Block.Builder> list, String str, int i, QuestionData questionData2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    list = question.blocks;
                }
                if ((i2 & 2) != 0) {
                    str = question.id;
                }
                if ((i2 & 4) != 0) {
                    i = question.questionType;
                }
                if ((i2 & 8) != 0) {
                    questionData2 = question.questionData;
                }
                return question.copy(list, str, i, questionData2);
            }

            public final List<Block.Builder> component1() {
                return this.blocks;
            }

            public final String component2() {
                return this.id;
            }

            public final Question copy(List<Block.Builder> list, String str, int i, QuestionData questionData2) {
                Intrinsics.checkNotNullParameter(list, "blocks");
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(questionData2, "questionData");
                return new Question(list, str, i, questionData2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Question)) {
                    return false;
                }
                Question question = (Question) obj;
                return Intrinsics.areEqual((Object) this.blocks, (Object) question.blocks) && Intrinsics.areEqual((Object) this.id, (Object) question.id) && this.questionType == question.questionType && Intrinsics.areEqual((Object) this.questionData, (Object) question.questionData);
            }

            public int hashCode() {
                return (((((this.blocks.hashCode() * 31) + this.id.hashCode()) * 31) + this.questionType) * 31) + this.questionData.hashCode();
            }

            public String toString() {
                return "Question(blocks=" + this.blocks + ", id=" + this.id + ", questionType=" + this.questionType + ", questionData=" + this.questionData + ')';
            }

            public Question(List<Block.Builder> list, String str, int i, QuestionData questionData2) {
                Intrinsics.checkNotNullParameter(list, "blocks");
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(questionData2, "questionData");
                this.blocks = list;
                this.id = str;
                this.questionType = i;
                this.questionData = questionData2;
            }

            public final List<Block.Builder> getBlocks() {
                return this.blocks;
            }

            public final String getId() {
                return this.id;
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation;", "", "_type", "", "(I)V", "validationType", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation$ValidationType;", "getValidationType", "()Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation$ValidationType;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "ValidationType", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyData.kt */
            public static final class QuestionValidation {
                public static final int $stable = 0;
                @SerializedName("type")
                private final int _type;

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation$ValidationType;", "", "(Ljava/lang/String;I)V", "TEXT", "NUMBER", "EMAIL", "PHONE", "NO_VALIDATION", "FLOAT", "INTEGER", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
                /* compiled from: SurveyData.kt */
                public enum ValidationType {
                    TEXT,
                    NUMBER,
                    EMAIL,
                    PHONE,
                    NO_VALIDATION,
                    FLOAT,
                    INTEGER
                }

                private final int component1() {
                    return this._type;
                }

                public static /* synthetic */ QuestionValidation copy$default(QuestionValidation questionValidation, int i, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        i = questionValidation._type;
                    }
                    return questionValidation.copy(i);
                }

                public final QuestionValidation copy(int i) {
                    return new QuestionValidation(i);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof QuestionValidation) && this._type == ((QuestionValidation) obj)._type;
                }

                public int hashCode() {
                    return this._type;
                }

                public String toString() {
                    return "QuestionValidation(_type=" + this._type + ')';
                }

                public QuestionValidation(int i) {
                    this._type = i;
                }

                public final ValidationType getValidationType() {
                    int i = this._type;
                    if (i == ValidationType.TEXT.ordinal()) {
                        return ValidationType.TEXT;
                    }
                    if (i == ValidationType.NUMBER.ordinal()) {
                        return ValidationType.NUMBER;
                    }
                    if (i == ValidationType.EMAIL.ordinal()) {
                        return ValidationType.EMAIL;
                    }
                    if (i == ValidationType.PHONE.ordinal()) {
                        return ValidationType.PHONE;
                    }
                    if (i == ValidationType.FLOAT.ordinal()) {
                        return ValidationType.FLOAT;
                    }
                    if (i == ValidationType.INTEGER.ordinal()) {
                        return ValidationType.INTEGER;
                    }
                    return ValidationType.NO_VALIDATION;
                }
            }

            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b,\b\b\u0018\u00002\u00020\u0001:\u0001=Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0014J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u000bHÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u000bHÆ\u0003J\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u000bHÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000f\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006>"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionData;", "", "_placeholder", "", "required", "", "options", "Lcom/google/gson/JsonArray;", "lowerLabel", "upperLabel", "scaleStart", "", "scaleEnd", "includeOther", "maxSelection", "minSelection", "questionSubtype", "validation", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation;", "characterLimit", "(Ljava/lang/String;ZLcom/google/gson/JsonArray;Ljava/lang/String;Ljava/lang/String;IIZIIILio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation;Ljava/lang/Integer;)V", "getCharacterLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIncludeOther", "()Z", "getLowerLabel", "()Ljava/lang/String;", "getMaxSelection", "()I", "getMinSelection", "getOptions", "()Lcom/google/gson/JsonArray;", "placeholder", "getPlaceholder", "getQuestionSubtype", "getRequired", "getScaleEnd", "getScaleStart", "getUpperLabel", "getValidation", "()Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ZLcom/google/gson/JsonArray;Ljava/lang/String;Ljava/lang/String;IIZIIILio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation;Ljava/lang/Integer;)Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionData;", "equals", "other", "hashCode", "toString", "QuestionSubType", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyData.kt */
            public static final class QuestionData {
                public static final int $stable = 8;
                @SerializedName("placeholder")
                private final String _placeholder;
                @SerializedName("character_limit")
                private final Integer characterLimit;
                @SerializedName("include_other")
                private final boolean includeOther;
                @SerializedName("lower_label")
                private final String lowerLabel;
                @SerializedName("maximum_selection")
                private final int maxSelection;
                @SerializedName("minimum_selection")
                private final int minSelection;
                @SerializedName("options")
                private final JsonArray options;
                @SerializedName("type")
                private final int questionSubtype;
                @SerializedName("required")
                private final boolean required;
                @SerializedName("scale_end")
                private final int scaleEnd;
                @SerializedName("scale_start")
                private final int scaleStart;
                @SerializedName("upper_label")
                private final String upperLabel;
                @SerializedName("validation")
                private final QuestionValidation validation;

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionData$QuestionSubType;", "", "(Ljava/lang/String;I)V", "NUMERIC", "STARS", "EMOJI", "NPS", "UNSUPPORTED", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
                /* compiled from: SurveyData.kt */
                public enum QuestionSubType {
                    NUMERIC,
                    STARS,
                    EMOJI,
                    NPS,
                    UNSUPPORTED
                }

                private final String component1() {
                    return this._placeholder;
                }

                public static /* synthetic */ QuestionData copy$default(QuestionData questionData, String str, boolean z, JsonArray jsonArray, String str2, String str3, int i, int i2, boolean z2, int i3, int i4, int i5, QuestionValidation questionValidation, Integer num, int i6, Object obj) {
                    QuestionData questionData2 = questionData;
                    int i7 = i6;
                    return questionData.copy((i7 & 1) != 0 ? questionData2._placeholder : str, (i7 & 2) != 0 ? questionData2.required : z, (i7 & 4) != 0 ? questionData2.options : jsonArray, (i7 & 8) != 0 ? questionData2.lowerLabel : str2, (i7 & 16) != 0 ? questionData2.upperLabel : str3, (i7 & 32) != 0 ? questionData2.scaleStart : i, (i7 & 64) != 0 ? questionData2.scaleEnd : i2, (i7 & 128) != 0 ? questionData2.includeOther : z2, (i7 & 256) != 0 ? questionData2.maxSelection : i3, (i7 & 512) != 0 ? questionData2.minSelection : i4, (i7 & 1024) != 0 ? questionData2.questionSubtype : i5, (i7 & 2048) != 0 ? questionData2.validation : questionValidation, (i7 & 4096) != 0 ? questionData2.characterLimit : num);
                }

                public final int component10() {
                    return this.minSelection;
                }

                public final int component11() {
                    return this.questionSubtype;
                }

                public final QuestionValidation component12() {
                    return this.validation;
                }

                public final Integer component13() {
                    return this.characterLimit;
                }

                public final boolean component2() {
                    return this.required;
                }

                public final JsonArray component3() {
                    return this.options;
                }

                public final String component4() {
                    return this.lowerLabel;
                }

                public final String component5() {
                    return this.upperLabel;
                }

                public final int component6() {
                    return this.scaleStart;
                }

                public final int component7() {
                    return this.scaleEnd;
                }

                public final boolean component8() {
                    return this.includeOther;
                }

                public final int component9() {
                    return this.maxSelection;
                }

                public final QuestionData copy(String str, boolean z, JsonArray jsonArray, String str2, String str3, int i, int i2, boolean z2, int i3, int i4, int i5, QuestionValidation questionValidation, Integer num) {
                    JsonArray jsonArray2 = jsonArray;
                    Intrinsics.checkNotNullParameter(jsonArray2, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                    String str4 = str2;
                    Intrinsics.checkNotNullParameter(str4, "lowerLabel");
                    String str5 = str3;
                    Intrinsics.checkNotNullParameter(str5, "upperLabel");
                    return new QuestionData(str, z, jsonArray2, str4, str5, i, i2, z2, i3, i4, i5, questionValidation, num);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof QuestionData)) {
                        return false;
                    }
                    QuestionData questionData = (QuestionData) obj;
                    return Intrinsics.areEqual((Object) this._placeholder, (Object) questionData._placeholder) && this.required == questionData.required && Intrinsics.areEqual((Object) this.options, (Object) questionData.options) && Intrinsics.areEqual((Object) this.lowerLabel, (Object) questionData.lowerLabel) && Intrinsics.areEqual((Object) this.upperLabel, (Object) questionData.upperLabel) && this.scaleStart == questionData.scaleStart && this.scaleEnd == questionData.scaleEnd && this.includeOther == questionData.includeOther && this.maxSelection == questionData.maxSelection && this.minSelection == questionData.minSelection && this.questionSubtype == questionData.questionSubtype && Intrinsics.areEqual((Object) this.validation, (Object) questionData.validation) && Intrinsics.areEqual((Object) this.characterLimit, (Object) questionData.characterLimit);
                }

                public int hashCode() {
                    String str = this._placeholder;
                    int i = 0;
                    int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                    boolean z = this.required;
                    boolean z2 = true;
                    if (z) {
                        z = true;
                    }
                    int hashCode2 = (((((((((((hashCode + (z ? 1 : 0)) * 31) + this.options.hashCode()) * 31) + this.lowerLabel.hashCode()) * 31) + this.upperLabel.hashCode()) * 31) + this.scaleStart) * 31) + this.scaleEnd) * 31;
                    boolean z3 = this.includeOther;
                    if (!z3) {
                        z2 = z3;
                    }
                    int i2 = (((((((hashCode2 + (z2 ? 1 : 0)) * 31) + this.maxSelection) * 31) + this.minSelection) * 31) + this.questionSubtype) * 31;
                    QuestionValidation questionValidation = this.validation;
                    int hashCode3 = (i2 + (questionValidation == null ? 0 : questionValidation.hashCode())) * 31;
                    Integer num = this.characterLimit;
                    if (num != null) {
                        i = num.hashCode();
                    }
                    return hashCode3 + i;
                }

                public String toString() {
                    return "QuestionData(_placeholder=" + this._placeholder + ", required=" + this.required + ", options=" + this.options + ", lowerLabel=" + this.lowerLabel + ", upperLabel=" + this.upperLabel + ", scaleStart=" + this.scaleStart + ", scaleEnd=" + this.scaleEnd + ", includeOther=" + this.includeOther + ", maxSelection=" + this.maxSelection + ", minSelection=" + this.minSelection + ", questionSubtype=" + this.questionSubtype + ", validation=" + this.validation + ", characterLimit=" + this.characterLimit + ')';
                }

                public QuestionData(String str, boolean z, JsonArray jsonArray, String str2, String str3, int i, int i2, boolean z2, int i3, int i4, int i5, QuestionValidation questionValidation, Integer num) {
                    Intrinsics.checkNotNullParameter(jsonArray, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                    Intrinsics.checkNotNullParameter(str2, "lowerLabel");
                    Intrinsics.checkNotNullParameter(str3, "upperLabel");
                    this._placeholder = str;
                    this.required = z;
                    this.options = jsonArray;
                    this.lowerLabel = str2;
                    this.upperLabel = str3;
                    this.scaleStart = i;
                    this.scaleEnd = i2;
                    this.includeOther = z2;
                    this.maxSelection = i3;
                    this.minSelection = i4;
                    this.questionSubtype = i5;
                    this.validation = questionValidation;
                    this.characterLimit = num;
                }

                public final boolean getRequired() {
                    return this.required;
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ QuestionData(String str, boolean z, JsonArray jsonArray, String str2, String str3, int i, int i2, boolean z2, int i3, int i4, int i5, QuestionValidation questionValidation, Integer num, int i6, DefaultConstructorMarker defaultConstructorMarker) {
                    this(str, z, (i6 & 4) != 0 ? new JsonArray() : jsonArray, str2, str3, i, i2, z2, i3, i4, i5, questionValidation, num);
                }

                public final JsonArray getOptions() {
                    return this.options;
                }

                public final String getLowerLabel() {
                    return this.lowerLabel;
                }

                public final String getUpperLabel() {
                    return this.upperLabel;
                }

                public final int getScaleStart() {
                    return this.scaleStart;
                }

                public final int getScaleEnd() {
                    return this.scaleEnd;
                }

                public final boolean getIncludeOther() {
                    return this.includeOther;
                }

                public final int getMaxSelection() {
                    return this.maxSelection;
                }

                public final int getMinSelection() {
                    return this.minSelection;
                }

                public final int getQuestionSubtype() {
                    return this.questionSubtype;
                }

                public final QuestionValidation getValidation() {
                    return this.validation;
                }

                public final Integer getCharacterLimit() {
                    return this.characterLimit;
                }

                public final String getPlaceholder() {
                    String str = this._placeholder;
                    return str == null ? "" : str;
                }
            }

            public final QuestionModel getQuestionModel() {
                List list;
                QuestionData.QuestionSubType questionSubType;
                int i = this.questionType;
                if (i == QuestionType.DROPDOWN.ordinal()) {
                    String str = this.id;
                    List<Block.Builder> list2 = this.blocks;
                    boolean required = this.questionData.getRequired();
                    String placeholder = this.questionData.getPlaceholder();
                    Iterable<JsonElement> options = this.questionData.getOptions();
                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(options, 10));
                    for (JsonElement asString : options) {
                        arrayList.add(asString.getAsString());
                    }
                    return new DropDownQuestionModel(str, list2, required, (List) arrayList, placeholder, (Integer) null, 32, (DefaultConstructorMarker) null);
                } else if (i == QuestionType.INPUT.ordinal()) {
                    return new ShortTextQuestionModel(this.id, this.blocks, this.questionData.getRequired(), this.questionData.getPlaceholder(), this.questionData.getValidation() != null ? this.questionData.getValidation().getValidationType() : QuestionValidation.ValidationType.NO_VALIDATION, this.questionData.getCharacterLimit(), false, (Integer) null, JfifUtil.MARKER_SOFn, (DefaultConstructorMarker) null);
                } else if (i == QuestionType.TEXT.ordinal()) {
                    return new LongTextQuestionModel(this.id, this.blocks, this.questionData.getRequired(), this.questionData.getPlaceholder(), this.questionData.getValidation() != null ? this.questionData.getValidation().getValidationType() : QuestionValidation.ValidationType.NO_VALIDATION, this.questionData.getCharacterLimit(), 0.0f, 0, (Integer) null, 448, (DefaultConstructorMarker) null);
                } else if (i == QuestionType.RATING_SCALE.ordinal()) {
                    String str2 = this.id;
                    List<Block.Builder> list3 = this.blocks;
                    boolean required2 = this.questionData.getRequired();
                    String lowerLabel = this.questionData.getLowerLabel();
                    String upperLabel = this.questionData.getUpperLabel();
                    int scaleStart = this.questionData.getScaleStart();
                    int scaleEnd = this.questionData.getScaleEnd();
                    if (this.questionData.getQuestionSubtype() == QuestionData.QuestionSubType.EMOJI.ordinal()) {
                        Gson gson = new Gson();
                        Iterable<JsonElement> options2 = this.questionData.getOptions();
                        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(options2, 10));
                        for (JsonElement fromJson : options2) {
                            arrayList2.add((NumericRatingQuestionModel.RatingOption.EmojiRatingOption) gson.fromJson(fromJson, NumericRatingQuestionModel.RatingOption.EmojiRatingOption.class));
                        }
                        list = (List) arrayList2;
                    } else {
                        Iterable intRange = new IntRange(this.questionData.getScaleStart(), this.questionData.getScaleEnd());
                        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
                        Iterator it = intRange.iterator();
                        while (it.hasNext()) {
                            arrayList3.add(new NumericRatingQuestionModel.RatingOption.NumericRatingOption(((IntIterator) it).nextInt()));
                        }
                        list = (List) arrayList3;
                    }
                    int questionSubtype = this.questionData.getQuestionSubtype();
                    if (questionSubtype == QuestionData.QuestionSubType.NUMERIC.ordinal()) {
                        questionSubType = QuestionData.QuestionSubType.NUMERIC;
                    } else if (questionSubtype == QuestionData.QuestionSubType.STARS.ordinal()) {
                        questionSubType = QuestionData.QuestionSubType.STARS;
                    } else if (questionSubtype == QuestionData.QuestionSubType.EMOJI.ordinal()) {
                        questionSubType = QuestionData.QuestionSubType.EMOJI;
                    } else if (questionSubtype == QuestionData.QuestionSubType.NPS.ordinal()) {
                        questionSubType = QuestionData.QuestionSubType.NPS;
                    } else {
                        questionSubType = QuestionData.QuestionSubType.UNSUPPORTED;
                    }
                    return new NumericRatingQuestionModel(str2, list3, required2, list, lowerLabel, upperLabel, scaleStart, scaleEnd, questionSubType);
                } else if (i != QuestionType.MULTI_SELECT.ordinal()) {
                    return UnsupportedQuestion.INSTANCE;
                } else {
                    if (this.questionData.getMaxSelection() == 1) {
                        String str3 = this.id;
                        List<Block.Builder> list4 = this.blocks;
                        boolean required3 = this.questionData.getRequired();
                        Iterable<JsonElement> options3 = this.questionData.getOptions();
                        Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(options3, 10));
                        for (JsonElement asString2 : options3) {
                            arrayList4.add(asString2.getAsString());
                        }
                        return new SingleChoiceQuestionModel(str3, list4, required3, (List) arrayList4, this.questionData.getIncludeOther());
                    }
                    String str4 = this.id;
                    List<Block.Builder> list5 = this.blocks;
                    boolean required4 = this.questionData.getRequired();
                    Iterable<JsonElement> options4 = this.questionData.getOptions();
                    Collection arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(options4, 10));
                    for (JsonElement asString3 : options4) {
                        arrayList5.add(asString3.getAsString());
                    }
                    return new MultipleChoiceQuestionModel(str4, list5, required4, (List) arrayList5, this.questionData.getIncludeOther(), this.questionData.getMinSelection(), this.questionData.getMaxSelection());
                }
            }

            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;", "", "id", "", "title", "", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "isRequired", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "getId", "()Ljava/lang/String;", "()Z", "getTitle", "()Ljava/util/List;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyData.kt */
            public static class QuestionModel {
                public static final int $stable = 8;
                private final String id;
                private final boolean isRequired;
                private final List<Block.Builder> title;

                public QuestionModel(String str, List<Block.Builder> list, boolean z) {
                    Intrinsics.checkNotNullParameter(str, "id");
                    Intrinsics.checkNotNullParameter(list, "title");
                    this.id = str;
                    this.title = list;
                    this.isRequired = z;
                }

                public final String getId() {
                    return this.id;
                }

                public final List<Block.Builder> getTitle() {
                    return this.title;
                }

                public final boolean isRequired() {
                    return this.isRequired;
                }
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$DropDownQuestionModel;", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;", "id", "", "title", "", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "isRequired", "", "options", "placeholder", "placeHolderStringRes", "", "(Ljava/lang/String;Ljava/util/List;ZLjava/util/List;Ljava/lang/String;Ljava/lang/Integer;)V", "getOptions", "()Ljava/util/List;", "getPlaceHolderStringRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPlaceholder", "()Ljava/lang/String;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyData.kt */
            public static final class DropDownQuestionModel extends QuestionModel {
                public static final int $stable = 8;
                private final List<String> options;
                private final Integer placeHolderStringRes;
                private final String placeholder;

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ DropDownQuestionModel(String str, List list, boolean z, List list2, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this(str, list, z, list2, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? null : num);
                }

                public final List<String> getOptions() {
                    return this.options;
                }

                public final String getPlaceholder() {
                    return this.placeholder;
                }

                public final Integer getPlaceHolderStringRes() {
                    return this.placeHolderStringRes;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public DropDownQuestionModel(String str, List<Block.Builder> list, boolean z, List<String> list2, String str2, Integer num) {
                    super(str, list, z);
                    Intrinsics.checkNotNullParameter(str, "id");
                    Intrinsics.checkNotNullParameter(list, "title");
                    Intrinsics.checkNotNullParameter(list2, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                    Intrinsics.checkNotNullParameter(str2, ReactTextInputShadowNode.PROP_PLACEHOLDER);
                    this.options = list2;
                    this.placeholder = str2;
                    this.placeHolderStringRes = num;
                }
            }

            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$SingleChoiceQuestionModel;", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;", "id", "", "title", "", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "isRequired", "", "options", "includeOther", "(Ljava/lang/String;Ljava/util/List;ZLjava/util/List;Z)V", "getIncludeOther", "()Z", "getOptions", "()Ljava/util/List;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyData.kt */
            public static final class SingleChoiceQuestionModel extends QuestionModel {
                public static final int $stable = 8;
                private final boolean includeOther;
                private final List<String> options;

                public final List<String> getOptions() {
                    return this.options;
                }

                public final boolean getIncludeOther() {
                    return this.includeOther;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public SingleChoiceQuestionModel(String str, List<Block.Builder> list, boolean z, List<String> list2, boolean z2) {
                    super(str, list, z);
                    Intrinsics.checkNotNullParameter(str, "id");
                    Intrinsics.checkNotNullParameter(list, "title");
                    Intrinsics.checkNotNullParameter(list2, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                    this.options = list2;
                    this.includeOther = z2;
                }
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$MultipleChoiceQuestionModel;", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;", "id", "", "title", "", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "isRequired", "", "options", "includeOther", "minSelection", "", "maxSelection", "(Ljava/lang/String;Ljava/util/List;ZLjava/util/List;ZII)V", "getIncludeOther", "()Z", "getMaxSelection", "()I", "getMinSelection", "getOptions", "()Ljava/util/List;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyData.kt */
            public static final class MultipleChoiceQuestionModel extends QuestionModel {
                public static final int $stable = 8;
                private final boolean includeOther;
                private final int maxSelection;
                private final int minSelection;
                private final List<String> options;

                public final List<String> getOptions() {
                    return this.options;
                }

                public final boolean getIncludeOther() {
                    return this.includeOther;
                }

                public final int getMinSelection() {
                    return this.minSelection;
                }

                public final int getMaxSelection() {
                    return this.maxSelection;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public MultipleChoiceQuestionModel(String str, List<Block.Builder> list, boolean z, List<String> list2, boolean z2, int i, int i2) {
                    super(str, list, z);
                    Intrinsics.checkNotNullParameter(str, "id");
                    Intrinsics.checkNotNullParameter(list, "title");
                    Intrinsics.checkNotNullParameter(list2, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                    this.options = list2;
                    this.includeOther = z2;
                    this.minSelection = i;
                    this.maxSelection = i2;
                }
            }

            @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$ShortTextQuestionModel;", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;", "id", "", "title", "", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "isRequired", "", "placeholder", "validationType", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation$ValidationType;", "characterLimit", "", "enabled", "placeHolderStringRes", "(Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation$ValidationType;Ljava/lang/Integer;ZLjava/lang/Integer;)V", "getCharacterLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnabled", "()Z", "getPlaceHolderStringRes", "getPlaceholder", "()Ljava/lang/String;", "getValidationType", "()Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation$ValidationType;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyData.kt */
            public static final class ShortTextQuestionModel extends QuestionModel {
                public static final int $stable = 0;
                private final Integer characterLimit;
                private final boolean enabled;
                private final Integer placeHolderStringRes;
                private final String placeholder;
                private final QuestionValidation.ValidationType validationType;

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public /* synthetic */ ShortTextQuestionModel(java.lang.String r12, java.util.List r13, boolean r14, java.lang.String r15, io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionValidation.ValidationType r16, java.lang.Integer r17, boolean r18, java.lang.Integer r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
                    /*
                        r11 = this;
                        r0 = r20
                        r1 = r0 & 8
                        if (r1 == 0) goto L_0x000a
                        java.lang.String r1 = ""
                        r6 = r1
                        goto L_0x000b
                    L_0x000a:
                        r6 = r15
                    L_0x000b:
                        r1 = r0 & 64
                        if (r1 == 0) goto L_0x0012
                        r1 = 1
                        r9 = 1
                        goto L_0x0014
                    L_0x0012:
                        r9 = r18
                    L_0x0014:
                        r0 = r0 & 128(0x80, float:1.794E-43)
                        if (r0 == 0) goto L_0x001b
                        r0 = 0
                        r10 = r0
                        goto L_0x001d
                    L_0x001b:
                        r10 = r19
                    L_0x001d:
                        r2 = r11
                        r3 = r12
                        r4 = r13
                        r5 = r14
                        r7 = r16
                        r8 = r17
                        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.model.SurveyData.Step.Question.ShortTextQuestionModel.<init>(java.lang.String, java.util.List, boolean, java.lang.String, io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType, java.lang.Integer, boolean, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
                }

                public final String getPlaceholder() {
                    return this.placeholder;
                }

                public final QuestionValidation.ValidationType getValidationType() {
                    return this.validationType;
                }

                public final Integer getCharacterLimit() {
                    return this.characterLimit;
                }

                public final boolean getEnabled() {
                    return this.enabled;
                }

                public final Integer getPlaceHolderStringRes() {
                    return this.placeHolderStringRes;
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public ShortTextQuestionModel(String str, List<Block.Builder> list, boolean z, String str2, QuestionValidation.ValidationType validationType2, Integer num, boolean z2, Integer num2) {
                    super(str, list, z);
                    Intrinsics.checkNotNullParameter(str, "id");
                    Intrinsics.checkNotNullParameter(list, "title");
                    Intrinsics.checkNotNullParameter(str2, ReactTextInputShadowNode.PROP_PLACEHOLDER);
                    Intrinsics.checkNotNullParameter(validationType2, "validationType");
                    this.placeholder = str2;
                    this.validationType = validationType2;
                    this.characterLimit = num;
                    this.enabled = z2;
                    this.placeHolderStringRes = num2;
                }
            }

            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$DatePickerQuestionModel;", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;", "id", "", "title", "", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "isRequired", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyData.kt */
            public static final class DatePickerQuestionModel extends QuestionModel {
                public static final int $stable = 0;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public DatePickerQuestionModel(String str, List<Block.Builder> list, boolean z) {
                    super(str, list, z);
                    Intrinsics.checkNotNullParameter(str, "id");
                    Intrinsics.checkNotNullParameter(list, "title");
                }
            }

            @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001Bb\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\rø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$LongTextQuestionModel;", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;", "id", "", "title", "", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "isRequired", "", "placeholder", "validationType", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation$ValidationType;", "characterLimit", "", "minHeight", "Landroidx/compose/ui/unit/Dp;", "maxLine", "placeHolderStringRes", "(Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation$ValidationType;Ljava/lang/Integer;FILjava/lang/Integer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCharacterLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxLine", "()I", "getMinHeight-D9Ej5fM", "()F", "F", "getPlaceHolderStringRes", "getPlaceholder", "()Ljava/lang/String;", "getValidationType", "()Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation$ValidationType;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyData.kt */
            public static final class LongTextQuestionModel extends QuestionModel {
                public static final int $stable = 0;
                private final Integer characterLimit;
                private final int maxLine;
                private final float minHeight;
                private final Integer placeHolderStringRes;
                private final String placeholder;
                private final QuestionValidation.ValidationType validationType;

                public /* synthetic */ LongTextQuestionModel(String str, List list, boolean z, String str2, QuestionValidation.ValidationType validationType2, Integer num, float f, int i, Integer num2, DefaultConstructorMarker defaultConstructorMarker) {
                    this(str, list, z, str2, validationType2, num, f, i, num2);
                }

                public final String getPlaceholder() {
                    return this.placeholder;
                }

                public final QuestionValidation.ValidationType getValidationType() {
                    return this.validationType;
                }

                public final Integer getCharacterLimit() {
                    return this.characterLimit;
                }

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public /* synthetic */ LongTextQuestionModel(java.lang.String r14, java.util.List r15, boolean r16, java.lang.String r17, io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionValidation.ValidationType r18, java.lang.Integer r19, float r20, int r21, java.lang.Integer r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
                    /*
                        r13 = this;
                        r0 = r23
                        r1 = r0 & 8
                        if (r1 == 0) goto L_0x000a
                        java.lang.String r1 = ""
                        r6 = r1
                        goto L_0x000c
                    L_0x000a:
                        r6 = r17
                    L_0x000c:
                        r1 = r0 & 64
                        if (r1 == 0) goto L_0x0018
                        androidx.compose.ui.unit.Dp$Companion r1 = androidx.compose.ui.unit.Dp.Companion
                        float r1 = r1.m4724getUnspecifiedD9Ej5fM()
                        r9 = r1
                        goto L_0x001a
                    L_0x0018:
                        r9 = r20
                    L_0x001a:
                        r1 = r0 & 128(0x80, float:1.794E-43)
                        if (r1 == 0) goto L_0x0021
                        r1 = 6
                        r10 = 6
                        goto L_0x0023
                    L_0x0021:
                        r10 = r21
                    L_0x0023:
                        r0 = r0 & 256(0x100, float:3.59E-43)
                        if (r0 == 0) goto L_0x002a
                        r0 = 0
                        r11 = r0
                        goto L_0x002c
                    L_0x002a:
                        r11 = r22
                    L_0x002c:
                        r12 = 0
                        r2 = r13
                        r3 = r14
                        r4 = r15
                        r5 = r16
                        r7 = r18
                        r8 = r19
                        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.model.SurveyData.Step.Question.LongTextQuestionModel.<init>(java.lang.String, java.util.List, boolean, java.lang.String, io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType, java.lang.Integer, float, int, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
                }

                /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
                public final float m5308getMinHeightD9Ej5fM() {
                    return this.minHeight;
                }

                public final int getMaxLine() {
                    return this.maxLine;
                }

                public final Integer getPlaceHolderStringRes() {
                    return this.placeHolderStringRes;
                }

                private LongTextQuestionModel(String str, List<Block.Builder> list, boolean z, String str2, QuestionValidation.ValidationType validationType2, Integer num, float f, int i, Integer num2) {
                    super(str, list, z);
                    this.placeholder = str2;
                    this.validationType = validationType2;
                    this.characterLimit = num;
                    this.minHeight = f;
                    this.maxLine = i;
                    this.placeHolderStringRes = num2;
                }
            }

            @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dBY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014¨\u0006\u001e"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$NumericRatingQuestionModel;", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;", "id", "", "title", "", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "isRequired", "", "options", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption;", "lowerLabel", "upperLabel", "scaleStart", "", "scaleEnd", "questionSubType", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionData$QuestionSubType;", "(Ljava/lang/String;Ljava/util/List;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;IILio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionData$QuestionSubType;)V", "getLowerLabel", "()Ljava/lang/String;", "getOptions", "()Ljava/util/List;", "getQuestionSubType", "()Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionData$QuestionSubType;", "getScaleEnd", "()I", "getScaleStart", "getUpperLabel", "RatingOption", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyData.kt */
            public static final class NumericRatingQuestionModel extends QuestionModel {
                public static final int $stable = 8;
                private final String lowerLabel;
                private final List<RatingOption> options;
                private final QuestionData.QuestionSubType questionSubType;
                private final int scaleEnd;
                private final int scaleStart;
                private final String upperLabel;

                public final List<RatingOption> getOptions() {
                    return this.options;
                }

                public final String getLowerLabel() {
                    return this.lowerLabel;
                }

                public final String getUpperLabel() {
                    return this.upperLabel;
                }

                public final int getScaleStart() {
                    return this.scaleStart;
                }

                public final int getScaleEnd() {
                    return this.scaleEnd;
                }

                public final QuestionData.QuestionSubType getQuestionSubType() {
                    return this.questionSubType;
                }

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption;", "", "()V", "EmojiRatingOption", "NumericRatingOption", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption$EmojiRatingOption;", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption$NumericRatingOption;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
                /* compiled from: SurveyData.kt */
                public static abstract class RatingOption {
                    public static final int $stable = 0;

                    public /* synthetic */ RatingOption(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private RatingOption() {
                    }

                    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption$EmojiRatingOption;", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption;", "value", "", "emojiUrl", "", "unicode", "(ILjava/lang/String;Ljava/lang/String;)V", "getEmojiUrl", "()Ljava/lang/String;", "getUnicode", "getValue", "()I", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
                    /* compiled from: SurveyData.kt */
                    public static final class EmojiRatingOption extends RatingOption {
                        public static final int $stable = 0;
                        @SerializedName("image_url")
                        private final String emojiUrl;
                        @SerializedName("unicodeEmoticon")
                        private final String unicode;
                        @SerializedName("value")
                        private final int value;

                        public final int getValue() {
                            return this.value;
                        }

                        public final String getEmojiUrl() {
                            return this.emojiUrl;
                        }

                        public final String getUnicode() {
                            return this.unicode;
                        }

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public EmojiRatingOption(int i, String str, String str2) {
                            super((DefaultConstructorMarker) null);
                            Intrinsics.checkNotNullParameter(str, "emojiUrl");
                            Intrinsics.checkNotNullParameter(str2, "unicode");
                            this.value = i;
                            this.emojiUrl = str;
                            this.unicode = str2;
                        }
                    }

                    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption$NumericRatingOption;", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption;", "value", "", "(I)V", "getValue", "()I", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
                    /* compiled from: SurveyData.kt */
                    public static final class NumericRatingOption extends RatingOption {
                        public static final int $stable = 0;
                        private final int value;

                        public NumericRatingOption(int i) {
                            super((DefaultConstructorMarker) null);
                            this.value = i;
                        }

                        public final int getValue() {
                            return this.value;
                        }
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public NumericRatingQuestionModel(String str, List<Block.Builder> list, boolean z, List<? extends RatingOption> list2, String str2, String str3, int i, int i2, QuestionData.QuestionSubType questionSubType2) {
                    super(str, list, z);
                    Intrinsics.checkNotNullParameter(str, "id");
                    Intrinsics.checkNotNullParameter(list, "title");
                    Intrinsics.checkNotNullParameter(list2, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                    Intrinsics.checkNotNullParameter(str2, "lowerLabel");
                    Intrinsics.checkNotNullParameter(str3, "upperLabel");
                    Intrinsics.checkNotNullParameter(questionSubType2, "questionSubType");
                    this.options = list2;
                    this.lowerLabel = str2;
                    this.upperLabel = str3;
                    this.scaleStart = i;
                    this.scaleEnd = i2;
                    this.questionSubType = questionSubType2;
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$UnsupportedQuestion;", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* compiled from: SurveyData.kt */
            public static final class UnsupportedQuestion extends QuestionModel {
                public static final int $stable = 0;
                public static final UnsupportedQuestion INSTANCE = new UnsupportedQuestion();

                private UnsupportedQuestion() {
                    super("", CollectionsKt.emptyList(), false);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/survey/model/SurveyData$Companion;", "", "()V", "NULL", "Lio/intercom/android/sdk/survey/model/SurveyData;", "getNULL", "()Lio/intercom/android/sdk/survey/model/SurveyData;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SurveyData getNULL() {
            return SurveyData.NULL;
        }
    }
}
