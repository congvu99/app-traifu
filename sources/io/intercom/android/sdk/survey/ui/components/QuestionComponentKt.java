package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.material.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.LocalSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.survey.SurveyUiColors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aq\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"QuestionComponent", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentModifier", "questionState", "Lio/intercom/android/sdk/survey/QuestionState;", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "onAnswerUpdated", "Lkotlin/Function0;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "elevation", "Landroidx/compose/ui/unit/Dp;", "questionFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "questionFontSize", "Landroidx/compose/ui/unit/TextUnit;", "QuestionComponent-3mDWlBA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/survey/QuestionState;Lio/intercom/android/sdk/survey/SurveyUiColors;Lkotlin/jvm/functions/Function0;JFLandroidx/compose/ui/text/font/FontWeight;JLandroidx/compose/runtime/Composer;II)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: QuestionComponent.kt */
public final class QuestionComponentKt {
    /* renamed from: QuestionComponent-3mDWlBA  reason: not valid java name */
    public static final void m5311QuestionComponent3mDWlBA(Modifier modifier, Modifier modifier2, QuestionState questionState, SurveyUiColors surveyUiColors, Function0<Unit> function0, long j, float f, FontWeight fontWeight, long j2, Composer composer, int i, int i2) {
        SurveyUiColors surveyUiColors2;
        int i3;
        long j3;
        float f2;
        QuestionState questionState2 = questionState;
        Function0<Unit> function02 = function0;
        int i4 = i2;
        Intrinsics.checkNotNullParameter(questionState2, "questionState");
        Intrinsics.checkNotNullParameter(function02, "onAnswerUpdated");
        Composer startRestartGroup = composer.startRestartGroup(-1123259434);
        Modifier modifier3 = (i4 & 1) != 0 ? Modifier.Companion : modifier;
        Modifier r12 = (i4 & 2) != 0 ? PaddingKt.m510padding3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 16)) : modifier2;
        if ((i4 & 8) != 0) {
            surveyUiColors2 = questionState.getSurveyUiColors();
            i3 = i & -7169;
        } else {
            surveyUiColors2 = surveyUiColors;
            i3 = i;
        }
        if ((i4 & 32) != 0) {
            j3 = ColorKt.Color(4294309365L);
        } else {
            j3 = j;
        }
        if ((i4 & 64) != 0) {
            f2 = Dp.m4704constructorimpl((float) 1);
        } else {
            f2 = f;
        }
        FontWeight normal = (i4 & 128) != 0 ? FontWeight.Companion.getNormal() : fontWeight;
        long sp = (i4 & 256) != 0 ? TextUnitKt.getSp(16) : j2;
        SoftwareKeyboardController current = LocalSoftwareKeyboardController.INSTANCE.getCurrent(startRestartGroup, 8);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier bringIntoViewRequester = BringIntoViewRequesterKt.bringIntoViewRequester(modifier3, questionState.getBringIntoViewRequester());
        QuestionComponentKt$QuestionComponent$1 questionComponentKt$QuestionComponent$1 = r0;
        QuestionComponentKt$QuestionComponent$1 questionComponentKt$QuestionComponent$12 = new QuestionComponentKt$QuestionComponent$1(questionState, r12, new QuestionComponentKt$QuestionComponent$onAnswer$1(questionState2, function02), surveyUiColors2, ComposableLambdaKt.composableLambda(startRestartGroup, 250901027, true, new QuestionComponentKt$QuestionComponent$questionHeader$1(questionState, normal, sp, i3)), i3, new QuestionComponentKt$QuestionComponent$onImeActionNext$1(questionState2, function02, current, (FocusManager) consume));
        CardKt.m1177CardFjzlyU(bringIntoViewRequester, (Shape) null, j3, 0, (BorderStroke) null, f2, ComposableLambdaKt.composableLambda(startRestartGroup, -79527303, true, questionComponentKt$QuestionComponent$1), startRestartGroup, 1572864 | ((i3 >> 9) & 896) | (458752 & (i3 >> 3)), 26);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new QuestionComponentKt$QuestionComponent$2(modifier3, r12, questionState, surveyUiColors2, function0, j3, f2, normal, sp, i, i2));
        }
    }
}
