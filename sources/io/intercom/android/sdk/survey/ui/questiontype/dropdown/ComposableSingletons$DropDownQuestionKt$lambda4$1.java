package io.intercom.android.sdk.survey.ui.questiontype.dropdown;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import io.intercom.android.sdk.survey.SurveyUiColors;
import io.intercom.android.sdk.survey.SurveyViewModelKt;
import io.intercom.android.sdk.survey.model.SurveyCustomization;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.survey.ui.questiontype.dropdown.ComposableSingletons$DropDownQuestionKt$lambda-4$1  reason: invalid class name */
/* compiled from: DropDownQuestion.kt */
final class ComposableSingletons$DropDownQuestionKt$lambda4$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$DropDownQuestionKt$lambda4$1 INSTANCE = new ComposableSingletons$DropDownQuestionKt$lambda4$1();

    ComposableSingletons$DropDownQuestionKt$lambda4$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            DropDownQuestionKt.DropDownQuestion((Modifier) null, DropDownQuestionKt.dropDownQuestionModel, new Answer.SingleAnswer("Option A"), AnonymousClass1.INSTANCE, SurveyUiColors.m5266copyqa9m3tE$default(SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)), 0, 0, Color.Companion.m1959getBlue0d7_KjU(), 0, (Color) null, 27, (Object) null), (Function2<? super Composer, ? super Integer, Unit>) null, composer, 3136, 33);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
