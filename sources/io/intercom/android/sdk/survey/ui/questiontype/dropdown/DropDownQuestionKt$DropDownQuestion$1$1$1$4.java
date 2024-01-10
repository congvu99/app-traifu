package io.intercom.android.sdk.survey.ui.questiontype.dropdown;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusManager;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.models.Answer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DropDownQuestion.kt */
final class DropDownQuestionKt$DropDownQuestion$1$1$1$4 extends Lambda implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SurveyData.Step.Question.DropDownQuestionModel $dropDownQuestionModel;
    final /* synthetic */ MutableState<Boolean> $expanded$delegate;
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ Function1<Answer, Unit> $onAnswer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DropDownQuestionKt$DropDownQuestion$1$1$1$4(SurveyData.Step.Question.DropDownQuestionModel dropDownQuestionModel, FocusManager focusManager, Function1<? super Answer, Unit> function1, MutableState<Boolean> mutableState, int i) {
        super(3);
        this.$dropDownQuestionModel = dropDownQuestionModel;
        this.$focusManager = focusManager;
        this.$onAnswer = function1;
        this.$expanded$delegate = mutableState;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.ColumnScope r16, androidx.compose.runtime.Composer r17, int r18) {
        /*
            r15 = this;
            r0 = r15
            r10 = r17
            java.lang.String r1 = "$this$DropdownMenu"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            r1 = r18 & 81
            r2 = 16
            if (r1 != r2) goto L_0x001c
            boolean r1 = r17.getSkipping()
            if (r1 != 0) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            r17.skipToGroupEnd()
            goto L_0x00ae
        L_0x001c:
            io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$4$1 r1 = new io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$4$1
            androidx.compose.ui.focus.FocusManager r2 = r0.$focusManager
            r3 = 0
            r1.<init>(r2, r3)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = 70
            java.lang.String r3 = ""
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r3, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r1, (androidx.compose.runtime.Composer) r10, (int) r2)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$DropDownQuestionModel r1 = r0.$dropDownQuestionModel
            java.util.List r1 = r1.getOptions()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            kotlin.jvm.functions.Function1<io.intercom.android.sdk.survey.ui.models.Answer, kotlin.Unit> r11 = r0.$onAnswer
            androidx.compose.runtime.MutableState<java.lang.Boolean> r12 = r0.$expanded$delegate
            r2 = 0
            java.util.Iterator r13 = r1.iterator()
        L_0x003e:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x00ae
            java.lang.Object r1 = r13.next()
            int r14 = r2 + 1
            if (r2 >= 0) goto L_0x004f
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x004f:
            java.lang.String r1 = (java.lang.String) r1
            r2 = 1618982084(0x607fb4c4, float:7.370227E19)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            boolean r2 = r10.changed((java.lang.Object) r11)
            boolean r3 = r10.changed((java.lang.Object) r1)
            r2 = r2 | r3
            boolean r3 = r10.changed((java.lang.Object) r12)
            r2 = r2 | r3
            java.lang.Object r3 = r17.rememberedValue()
            if (r2 != 0) goto L_0x0078
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0083
        L_0x0078:
            io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$4$2$1$1 r2 = new io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$4$2$1$1
            r2.<init>(r11, r1, r12)
            r3 = r2
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r10.updateRememberedValue(r3)
        L_0x0083:
            r17.endReplaceableGroup()
            r2 = r3
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = -2109339486(0xffffffff824608a2, float:-1.454922E-37)
            io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$4$2$2 r8 = new io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$4$2$2
            r8.<init>(r1)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r7, r1, r8)
            r7 = r1
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            r8 = 196608(0x30000, float:2.75506E-40)
            r9 = 30
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r17
            androidx.compose.material.AndroidMenu_androidKt.DropdownMenuItem(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r2 = r14
            goto L_0x003e
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.dropdown.DropDownQuestionKt$DropDownQuestion$1$1$1$4.invoke(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):void");
    }
}
