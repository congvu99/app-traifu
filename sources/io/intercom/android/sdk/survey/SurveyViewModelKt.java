package io.intercom.android.sdk.survey;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import io.intercom.android.sdk.survey.model.SurveyCustomization;
import io.intercom.android.sdk.utilities.ColorExtensionsKt;
import io.intercom.android.sdk.utilities.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toSurveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "Lio/intercom/android/sdk/survey/model/SurveyCustomization;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyViewModel.kt */
public final class SurveyViewModelKt {
    public static final SurveyUiColors toSurveyUiColors(SurveyCustomization surveyCustomization) {
        Intrinsics.checkNotNullParameter(surveyCustomization, "<this>");
        long Color = ColorKt.Color(ColorUtils.parseColor(surveyCustomization.getBackgroundColor()));
        long Color2 = ColorKt.Color(ColorUtils.parseColor(surveyCustomization.getButtonColor()));
        return new SurveyUiColors(Color, ColorExtensionsKt.m5396generateTextColor8_81llA(Color), Color2, ColorExtensionsKt.m5396generateTextColor8_81llA(Color2), (Color) null, 16, (DefaultConstructorMarker) null);
    }
}
