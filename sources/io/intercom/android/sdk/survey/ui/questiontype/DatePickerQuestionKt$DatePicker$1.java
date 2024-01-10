package io.intercom.android.sdk.survey.ui.questiontype;

import android.content.Context;
import androidx.compose.ui.focus.FocusManager;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DatePickerQuestion.kt */
final class DatePickerQuestionKt$DatePicker$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Answer $answer;
    final /* synthetic */ Context $context;
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerQuestionKt$DatePicker$1(FocusManager focusManager, Context context, Answer answer, Function1<? super Answer, Unit> function1) {
        super(0);
        this.$focusManager = focusManager;
        this.$context = context;
        this.$answer = answer;
        this.$onAnswer = function1;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r4 = this;
            androidx.compose.ui.focus.FocusManager r0 = r4.$focusManager
            r1 = 0
            r2 = 1
            r3 = 0
            androidx.compose.ui.focus.FocusManager.CC.clearFocus$default(r0, r1, r2, r3)
            android.content.Context r0 = r4.$context
            boolean r1 = r0 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L_0x0011
            r3 = r0
            androidx.appcompat.app.AppCompatActivity r3 = (androidx.appcompat.app.AppCompatActivity) r3
        L_0x0011:
            if (r3 == 0) goto L_0x001a
            io.intercom.android.sdk.survey.ui.models.Answer r0 = r4.$answer
            kotlin.jvm.functions.Function1<io.intercom.android.sdk.survey.ui.models.Answer, kotlin.Unit> r1 = r4.$onAnswer
            io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt.showDatePicker(r3, r0, r1)
        L_0x001a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.DatePickerQuestionKt$DatePicker$1.invoke():void");
    }
}
