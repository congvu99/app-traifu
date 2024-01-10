package io.intercom.android.sdk.survey;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.survey.ValidationError;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import io.intercom.android.sdk.utilities.AttributeValidatorUtils;
import io.intercom.android.sdk.views.holder.AttributeType;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u001d\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\u000e\u0010/\u001a\u0002002\u0006\u0010\u0010\u001a\u00020\bJ\t\u00101\u001a\u000202HÖ\u0001J\u0006\u00103\u001a\u000200R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8B@BX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c8F@FX\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u000f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00064"}, d2 = {"Lio/intercom/android/sdk/survey/QuestionState;", "", "questionModel", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "(Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;Lio/intercom/android/sdk/survey/SurveyUiColors;)V", "<set-?>", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "_answer", "get_answer", "()Lio/intercom/android/sdk/survey/ui/models/Answer;", "set_answer", "(Lio/intercom/android/sdk/survey/ui/models/Answer;)V", "_answer$delegate", "Landroidx/compose/runtime/MutableState;", "answer", "getAnswer", "answer$delegate", "Landroidx/compose/runtime/State;", "bringIntoViewRequester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "getBringIntoViewRequester", "()Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "getQuestionModel", "()Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$QuestionModel;", "getSurveyUiColors", "()Lio/intercom/android/sdk/survey/SurveyUiColors;", "Lio/intercom/android/sdk/survey/ValidationError;", "validationError", "getValidationError", "()Lio/intercom/android/sdk/survey/ValidationError;", "setValidationError", "(Lio/intercom/android/sdk/survey/ValidationError;)V", "validationError$delegate", "bringIntoView", "Lkotlinx/coroutines/Job;", "compositionAwareScope", "Lkotlinx/coroutines/CoroutineScope;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "setAnswer", "", "toString", "", "validate", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyViewModel.kt */
public final class QuestionState {
    private final MutableState _answer$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Answer.NoAnswer.InitialNoAnswer.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final State answer$delegate = SnapshotStateKt.derivedStateOf(new QuestionState$answer$2(this));
    private final BringIntoViewRequester bringIntoViewRequester = BringIntoViewRequesterKt.BringIntoViewRequester();
    private final SurveyData.Step.Question.QuestionModel questionModel;
    private final SurveyUiColors surveyUiColors;
    private final MutableState validationError$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ValidationError.Unchecked.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyData.Step.Question.QuestionValidation.ValidationType.values().length];
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.TEXT.ordinal()] = 1;
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.NO_VALIDATION.ordinal()] = 2;
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.NUMBER.ordinal()] = 3;
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.EMAIL.ordinal()] = 4;
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.PHONE.ordinal()] = 5;
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.FLOAT.ordinal()] = 6;
            iArr[SurveyData.Step.Question.QuestionValidation.ValidationType.INTEGER.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ QuestionState copy$default(QuestionState questionState, SurveyData.Step.Question.QuestionModel questionModel2, SurveyUiColors surveyUiColors2, int i, Object obj) {
        if ((i & 1) != 0) {
            questionModel2 = questionState.questionModel;
        }
        if ((i & 2) != 0) {
            surveyUiColors2 = questionState.surveyUiColors;
        }
        return questionState.copy(questionModel2, surveyUiColors2);
    }

    public final SurveyData.Step.Question.QuestionModel component1() {
        return this.questionModel;
    }

    public final SurveyUiColors component2() {
        return this.surveyUiColors;
    }

    public final QuestionState copy(SurveyData.Step.Question.QuestionModel questionModel2, SurveyUiColors surveyUiColors2) {
        Intrinsics.checkNotNullParameter(questionModel2, "questionModel");
        Intrinsics.checkNotNullParameter(surveyUiColors2, "surveyUiColors");
        return new QuestionState(questionModel2, surveyUiColors2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuestionState)) {
            return false;
        }
        QuestionState questionState = (QuestionState) obj;
        return Intrinsics.areEqual((Object) this.questionModel, (Object) questionState.questionModel) && Intrinsics.areEqual((Object) this.surveyUiColors, (Object) questionState.surveyUiColors);
    }

    public int hashCode() {
        return (this.questionModel.hashCode() * 31) + this.surveyUiColors.hashCode();
    }

    public String toString() {
        return "QuestionState(questionModel=" + this.questionModel + ", surveyUiColors=" + this.surveyUiColors + ')';
    }

    public QuestionState(SurveyData.Step.Question.QuestionModel questionModel2, SurveyUiColors surveyUiColors2) {
        Intrinsics.checkNotNullParameter(questionModel2, "questionModel");
        Intrinsics.checkNotNullParameter(surveyUiColors2, "surveyUiColors");
        this.questionModel = questionModel2;
        this.surveyUiColors = surveyUiColors2;
    }

    public final SurveyData.Step.Question.QuestionModel getQuestionModel() {
        return this.questionModel;
    }

    public final SurveyUiColors getSurveyUiColors() {
        return this.surveyUiColors;
    }

    public final ValidationError getValidationError() {
        return (ValidationError) this.validationError$delegate.getValue();
    }

    public final void setValidationError(ValidationError validationError) {
        Intrinsics.checkNotNullParameter(validationError, "<set-?>");
        this.validationError$delegate.setValue(validationError);
    }

    /* access modifiers changed from: private */
    public final Answer get_answer() {
        return (Answer) this._answer$delegate.getValue();
    }

    private final void set_answer(Answer answer) {
        this._answer$delegate.setValue(answer);
    }

    public final Answer getAnswer() {
        return (Answer) this.answer$delegate.getValue();
    }

    public final BringIntoViewRequester getBringIntoViewRequester() {
        return this.bringIntoViewRequester;
    }

    public final void setAnswer(Answer answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        set_answer(answer);
        if (answer instanceof Answer.NoAnswer.ResetNoAnswer) {
            setValidationError(ValidationError.Unchecked.INSTANCE);
        }
    }

    public final void validate() {
        ValidationError validationError;
        ValidationError validationError2;
        ValidationError validationError3;
        String str;
        if ((getAnswer() instanceof Answer.NoAnswer) && this.questionModel.isRequired()) {
            setValidationError(new ValidationError.ValidationStringError(R.string.intercom_surveys_required_response, (List) null, 2, (DefaultConstructorMarker) null));
        } else if (getAnswer() instanceof Answer.NoAnswer) {
            setValidationError(ValidationError.NoValidationError.INSTANCE);
        } else {
            SurveyData.Step.Question.QuestionModel questionModel2 = this.questionModel;
            if (questionModel2 instanceof SurveyData.Step.Question.MultipleChoiceQuestionModel) {
                if (getAnswer() instanceof Answer.MultipleAnswer) {
                    Answer answer = getAnswer();
                    Intrinsics.checkNotNull(answer, "null cannot be cast to non-null type io.intercom.android.sdk.survey.ui.models.Answer.MultipleAnswer");
                    int size = ((Answer.MultipleAnswer) answer).getAnswers().size();
                    if (size < ((SurveyData.Step.Question.MultipleChoiceQuestionModel) this.questionModel).getMinSelection()) {
                        setValidationError(new ValidationError.ValidationStringError(R.string.intercom_surveys_multi_select_too_few_responses, CollectionsKt.listOf(TuplesKt.to("response_count", String.valueOf(((SurveyData.Step.Question.MultipleChoiceQuestionModel) this.questionModel).getMinSelection())))));
                    } else if (size > ((SurveyData.Step.Question.MultipleChoiceQuestionModel) this.questionModel).getMaxSelection()) {
                        setValidationError(new ValidationError.ValidationStringError(R.string.intercom_surveys_multi_select_too_many_responses, CollectionsKt.listOf(TuplesKt.to("response_count", String.valueOf(((SurveyData.Step.Question.MultipleChoiceQuestionModel) this.questionModel).getMaxSelection())))));
                    } else {
                        setValidationError(ValidationError.NoValidationError.INSTANCE);
                    }
                }
            } else if (questionModel2 instanceof SurveyData.Step.Question.ShortTextQuestionModel) {
                if (!((SurveyData.Step.Question.ShortTextQuestionModel) questionModel2).getEnabled()) {
                    validationError3 = ValidationError.NoValidationError.INSTANCE;
                } else if (((SurveyData.Step.Question.ShortTextQuestionModel) this.questionModel).getCharacterLimit() == null || getAnswer().getLength() <= ((SurveyData.Step.Question.ShortTextQuestionModel) this.questionModel).getCharacterLimit().intValue()) {
                    switch (WhenMappings.$EnumSwitchMapping$0[((SurveyData.Step.Question.ShortTextQuestionModel) this.questionModel).getValidationType().ordinal()]) {
                        case 1:
                        case 2:
                            str = "text";
                            break;
                        case 3:
                            str = AttributeType.NUMBER;
                            break;
                        case 4:
                            str = "email";
                            break;
                        case 5:
                            str = "phone";
                            break;
                        case 6:
                            str = "float";
                            break;
                        case 7:
                            str = "integer";
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    Answer answer2 = getAnswer();
                    switch (AttributeValidatorUtils.validateAttribute(answer2 instanceof Answer.SingleAnswer ? ((Answer.SingleAnswer) answer2).getAnswer() : "", str)) {
                        case 1:
                            validationError3 = new ValidationError.ValidationStringError(R.string.intercom_string_is_incorrect, (List) null, 2, (DefaultConstructorMarker) null);
                            break;
                        case 2:
                            validationError3 = new ValidationError.ValidationStringError(R.string.intercom_surveys_email_error, (List) null, 2, (DefaultConstructorMarker) null);
                            break;
                        case 3:
                            validationError3 = new ValidationError.ValidationStringError(R.string.intercom_number_is_incorrect, (List) null, 2, (DefaultConstructorMarker) null);
                            break;
                        case 4:
                            validationError3 = new ValidationError.ValidationStringError(R.string.intercom_that_number_needs_a_prefix, (List) null, 2, (DefaultConstructorMarker) null);
                            break;
                        case 5:
                            validationError3 = new ValidationError.ValidationStringError(R.string.intercom_that_number_has_too_many_digits, (List) null, 2, (DefaultConstructorMarker) null);
                            break;
                        case 6:
                            validationError3 = new ValidationError.ValidationStringError(R.string.intercom_that_country_code_doesnt_look_quite_right, (List) null, 2, (DefaultConstructorMarker) null);
                            break;
                        case 7:
                            validationError3 = new ValidationError.ValidationStringError(R.string.intercom_that_number_is_missing_a_few_digits, (List) null, 2, (DefaultConstructorMarker) null);
                            break;
                        default:
                            validationError3 = ValidationError.NoValidationError.INSTANCE;
                            break;
                    }
                } else {
                    validationError3 = new ValidationError.ValidationStringError(R.string.intercom_surveys_response_too_long, CollectionsKt.listOf(TuplesKt.to("character_count", String.valueOf(((SurveyData.Step.Question.ShortTextQuestionModel) this.questionModel).getCharacterLimit()))));
                }
                setValidationError(validationError3);
            } else if (questionModel2 instanceof SurveyData.Step.Question.LongTextQuestionModel) {
                if (((SurveyData.Step.Question.LongTextQuestionModel) questionModel2).getCharacterLimit() == null || getAnswer().getLength() <= ((SurveyData.Step.Question.LongTextQuestionModel) this.questionModel).getCharacterLimit().intValue()) {
                    validationError2 = ValidationError.NoValidationError.INSTANCE;
                } else {
                    validationError2 = new ValidationError.ValidationStringError(R.string.intercom_surveys_response_too_long, CollectionsKt.listOf(TuplesKt.to("character_count", String.valueOf(((SurveyData.Step.Question.LongTextQuestionModel) this.questionModel).getCharacterLimit()))));
                }
                setValidationError(validationError2);
            } else if (!(questionModel2 instanceof SurveyData.Step.Question.DatePickerQuestionModel)) {
                setValidationError(ValidationError.NoValidationError.INSTANCE);
            } else if (getAnswer() instanceof Answer.DateTimeAnswer) {
                Answer answer3 = getAnswer();
                Intrinsics.checkNotNull(answer3, "null cannot be cast to non-null type io.intercom.android.sdk.survey.ui.models.Answer.DateTimeAnswer");
                if (StringsKt.isBlank(((Answer.DateTimeAnswer) answer3).getDateAsString())) {
                    validationError = new ValidationError.ValidationStringError(R.string.intercom_choose_the_date, (List) null, 2, (DefaultConstructorMarker) null);
                } else {
                    validationError = ValidationError.NoValidationError.INSTANCE;
                }
                setValidationError(validationError);
            }
        }
    }

    public final Job bringIntoView(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "compositionAwareScope");
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new QuestionState$bringIntoView$1(this, (Continuation<? super QuestionState$bringIntoView$1>) null), 3, (Object) null);
    }
}
