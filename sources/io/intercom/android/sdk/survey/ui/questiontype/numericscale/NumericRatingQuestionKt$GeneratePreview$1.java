package io.intercom.android.sdk.survey.ui.questiontype.numericscale;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.survey.SurveyViewModelKt;
import io.intercom.android.sdk.survey.model.SurveyCustomization;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NumericRatingQuestion.kt */
final class NumericRatingQuestionKt$GeneratePreview$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Answer $answer;
    final /* synthetic */ int $end;
    final /* synthetic */ SurveyData.Step.Question.QuestionData.QuestionSubType $questionSubType;
    final /* synthetic */ int $start;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NumericRatingQuestion.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyData.Step.Question.QuestionData.QuestionSubType.values().length];
            iArr[SurveyData.Step.Question.QuestionData.QuestionSubType.EMOJI.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NumericRatingQuestionKt$GeneratePreview$1(SurveyData.Step.Question.QuestionData.QuestionSubType questionSubType, int i, int i2, Answer answer, int i3) {
        super(2);
        this.$questionSubType = questionSubType;
        this.$start = i;
        this.$end = i2;
        this.$answer = answer;
        this.$$dirty = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        List list;
        if ((i & 11) != 2 || !composer.getSkipping()) {
            String uuid = UUID.randomUUID().toString();
            List listOf = CollectionsKt.listOf(new Block.Builder().withText("How cool is this preview?"));
            if (WhenMappings.$EnumSwitchMapping$0[this.$questionSubType.ordinal()] == 1) {
                list = CollectionsKt.listOf(new SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption(1, "https://js.intercomcdn.com/images/emojis/v2/72x72/1f929.png", "😖"), new SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption(2, "https://js.intercomcdn.com/images/emojis/v2/72x72/1f929.png", "😕"), new SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption(3, "https://js.intercomcdn.com/images/emojis/v2/72x72/1f929.png", "😐"), new SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption(4, "https://js.intercomcdn.com/images/emojis/v2/72x72/1f929.png", "😃"), new SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption(5, "https://js.intercomcdn.com/images/emojis/v2/72x72/1f929.png", "🤩"));
            } else {
                Iterable intRange = new IntRange(this.$start, this.$end);
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
                Iterator it = intRange.iterator();
                while (it.hasNext()) {
                    arrayList.add(new SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.NumericRatingOption(((IntIterator) it).nextInt()));
                }
                list = (List) arrayList;
            }
            Intrinsics.checkNotNullExpressionValue(uuid, "toString()");
            NumericRatingQuestionKt.NumericRatingQuestion((Modifier) null, new SurveyData.Step.Question.NumericRatingQuestionModel(uuid, listOf, true, list, "Not likely", "Very likely", this.$start, this.$end, this.$questionSubType), this.$answer, AnonymousClass2.INSTANCE, SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)), (Function2<? super Composer, ? super Integer, Unit>) null, composer, ((this.$$dirty >> 3) & 896) | 3136, 33);
            return;
        }
        composer.skipToGroupEnd();
    }
}
