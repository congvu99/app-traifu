package io.intercom.android.sdk.survey.ui.questiontype.choice;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.font.FontWeight;
import com.facebook.imageutils.JfifUtil;
import io.intercom.android.sdk.survey.SurveyViewModelKt;
import io.intercom.android.sdk.survey.model.SurveyCustomization;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.survey.ui.questiontype.choice.ComposableSingletons$ChoicePillKt$lambda-2$1  reason: invalid class name */
/* compiled from: ChoicePill.kt */
final class ComposableSingletons$ChoicePillKt$lambda2$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$ChoicePillKt$lambda2$1 INSTANCE = new ComposableSingletons$ChoicePillKt$lambda2$1();

    ComposableSingletons$ChoicePillKt$lambda2$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            ChoicePillKt.m5322ChoicePillUdaoDFU(true, (Function1<? super String, Unit>) null, "Option 1", 0, 0.0f, SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)).m5274getButton0d7_KjU(), (FontWeight) null, 0, composer, 390, JfifUtil.MARKER_SOS);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
