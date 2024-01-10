package io.intercom.android.sdk.survey.ui.questiontype.text;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.imageutils.JfifUtil;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.survey.SurveyViewModelKt;
import io.intercom.android.sdk.survey.ValidationError;
import io.intercom.android.sdk.survey.model.SurveyCustomization;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.survey.ui.questiontype.text.ComposableSingletons$ShortTextQuestionKt$lambda-2$1  reason: invalid class name */
/* compiled from: ShortTextQuestion.kt */
final class ComposableSingletons$ShortTextQuestionKt$lambda2$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$ShortTextQuestionKt$lambda2$1 INSTANCE = new ComposableSingletons$ShortTextQuestionKt$lambda2$1();

    ComposableSingletons$ShortTextQuestionKt$lambda2$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            String uuid = UUID.randomUUID().toString();
            List listOf = CollectionsKt.listOf(new Block.Builder().withText("Is this a preview?").withType(BlockType.PARAGRAPH.getSerializedName()));
            SurveyData.Step.Question.QuestionValidation.ValidationType validationType = SurveyData.Step.Question.QuestionValidation.ValidationType.NO_VALIDATION;
            Intrinsics.checkNotNullExpressionValue(uuid, "toString()");
            ShortTextQuestionKt.ShortTextQuestion((Modifier) null, new SurveyData.Step.Question.ShortTextQuestionModel(uuid, listOf, true, "Placeholder text", validationType, Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION), false, (Integer) null, JfifUtil.MARKER_SOFn, (DefaultConstructorMarker) null), (Answer) null, AnonymousClass1.INSTANCE, SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)), ValidationError.NoValidationError.INSTANCE, (Function1<? super KeyboardActionScope, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, composer, 199680, 197);
            return;
        }
        composer.skipToGroupEnd();
    }
}
