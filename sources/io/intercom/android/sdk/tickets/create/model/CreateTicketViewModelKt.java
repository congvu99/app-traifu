package io.intercom.android.sdk.tickets.create.model;

import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"EmailId", "", "formatAnswerForServer", "", "questionState", "Lio/intercom/android/sdk/survey/QuestionState;", "getInputType", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionValidation$ValidationType;", "type", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: CreateTicketViewModel.kt */
public final class CreateTicketViewModelKt {
    public static final String EmailId = "-1";

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CreateTicketViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyData.Step.Question.QuestionValidation.ValidationType.values().length];
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.NUMBER.ordinal()] = 1;
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.FLOAT.ordinal()] = 2;
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.INTEGER.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public static final SurveyData.Step.Question.QuestionValidation.ValidationType getInputType(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 96619420) {
            if (hashCode != 97526364) {
                if (hashCode == 1958052158 && str.equals("integer")) {
                    return SurveyData.Step.Question.QuestionValidation.ValidationType.INTEGER;
                }
            } else if (str.equals("float")) {
                return SurveyData.Step.Question.QuestionValidation.ValidationType.FLOAT;
            }
        } else if (str.equals("email")) {
            return SurveyData.Step.Question.QuestionValidation.ValidationType.EMAIL;
        }
        return SurveyData.Step.Question.QuestionValidation.ValidationType.TEXT;
    }

    /* access modifiers changed from: private */
    public static final Object formatAnswerForServer(QuestionState questionState) {
        Answer answer = questionState.getAnswer();
        if (answer instanceof Answer.DateTimeAnswer) {
            return ((Answer.DateTimeAnswer) answer).getAnswer();
        }
        if (answer instanceof Answer.MultipleAnswer) {
            return ((Answer.MultipleAnswer) answer).getAnswers().toString();
        }
        if (Intrinsics.areEqual((Object) answer, (Object) Answer.NoAnswer.InitialNoAnswer.INSTANCE) ? true : Intrinsics.areEqual((Object) answer, (Object) Answer.NoAnswer.ResetNoAnswer.INSTANCE)) {
            return Unit.INSTANCE;
        }
        if (answer instanceof Answer.SingleAnswer) {
            SurveyData.Step.Question.QuestionModel questionModel = questionState.getQuestionModel();
            if (questionModel instanceof SurveyData.Step.Question.SingleChoiceQuestionModel) {
                return Boolean.valueOf(Boolean.parseBoolean(((Answer.SingleAnswer) answer).getAnswer()));
            }
            if (!(questionModel instanceof SurveyData.Step.Question.ShortTextQuestionModel)) {
                return ((Answer.SingleAnswer) answer).getAnswer();
            }
            int i = WhenMappings.$EnumSwitchMapping$0[((SurveyData.Step.Question.ShortTextQuestionModel) questionModel).getValidationType().ordinal()];
            if (i == 1) {
                return Integer.valueOf(Integer.parseInt(((Answer.SingleAnswer) answer).getAnswer()));
            }
            if (i == 2) {
                return Float.valueOf(Float.parseFloat(((Answer.SingleAnswer) answer).getAnswer()));
            }
            if (i != 3) {
                return ((Answer.SingleAnswer) answer).getAnswer();
            }
            return Integer.valueOf(Integer.parseInt(((Answer.SingleAnswer) answer).getAnswer()));
        }
        throw new NoWhenBranchMatchedException();
    }
}
