package io.intercom.android.sdk.survey.ui.questiontype.numericscale;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\bH\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"EmojiQuestion", "", "options", "", "Lio/intercom/android/sdk/survey/model/SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption$EmojiRatingOption;", "answer", "Lio/intercom/android/sdk/survey/ui/models/Answer;", "onAnswer", "Lkotlin/Function1;", "(Ljava/util/List;Lio/intercom/android/sdk/survey/ui/models/Answer;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: EmojiQuestion.kt */
public final class EmojiQuestionKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void EmojiQuestion(java.util.List<io.intercom.android.sdk.survey.model.SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption> r21, io.intercom.android.sdk.survey.ui.models.Answer r22, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.survey.ui.models.Answer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25) {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "options"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "answer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "onAnswer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = 1738433356(0x679e634c, float:1.4959312E24)
            r4 = r24
            androidx.compose.runtime.Composer r3 = r4.startRestartGroup(r3)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r5 = 0
            r11 = 1
            r6 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r4, r5, r11, r6)
            androidx.compose.foundation.layout.Arrangement$Absolute r5 = androidx.compose.foundation.layout.Arrangement.Absolute.INSTANCE
            r6 = 12
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r7 = r7.getCenterHorizontally()
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = r5.m411spacedByD5KLDUw((float) r6, (androidx.compose.ui.Alignment.Horizontal) r7)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r6 = r6.getCenterVertically()
            r7 = 693286680(0x2952b718, float:4.6788176E-14)
            r3.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r7)
            r7 = 54
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r6, r3, r7)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r6)
            java.lang.String r6 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r7, r8)
            java.lang.Object r6 = r3.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r7, r8)
            java.lang.Object r9 = r3.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r7, r8)
            java.lang.Object r7 = r3.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            androidx.compose.runtime.Applier r10 = r3.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x00ae
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00ae:
            r3.startReusableNode()
            boolean r10 = r3.getInserting()
            if (r10 == 0) goto L_0x00bb
            r3.createNode(r8)
            goto L_0x00be
        L_0x00bb:
            r3.useNode()
        L_0x00be:
            r3.disableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m1543constructorimpl(r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r5, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r6, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r9, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r7, r5)
            r3.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r5)
            r12 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            r4.invoke(r5, r3, r6)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r4)
            r4 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r3.startReplaceableGroup(r4)
            java.lang.String r4 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            androidx.compose.foundation.layout.RowScopeInstance r4 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r4 = (androidx.compose.foundation.layout.RowScope) r4
            r4 = r0
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r13 = r4.iterator()
        L_0x0118:
            boolean r4 = r13.hasNext()
            if (r4 == 0) goto L_0x01b5
            java.lang.Object r4 = r13.next()
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$NumericRatingQuestionModel$RatingOption$EmojiRatingOption r4 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.NumericRatingQuestionModel.RatingOption.EmojiRatingOption) r4
            boolean r5 = r1 instanceof io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer
            if (r5 == 0) goto L_0x013f
            r5 = r1
            io.intercom.android.sdk.survey.ui.models.Answer$SingleAnswer r5 = (io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer) r5
            java.lang.String r5 = r5.getAnswer()
            int r6 = r4.getValue()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x013f
            r5 = 1
            goto L_0x0140
        L_0x013f:
            r5 = 0
        L_0x0140:
            java.lang.String r6 = r4.getEmojiUrl()
            java.lang.String r7 = r4.getUnicode()
            boolean r8 = r1 instanceof io.intercom.android.sdk.survey.ui.models.Answer.NoAnswer
            if (r8 != 0) goto L_0x0151
            if (r5 == 0) goto L_0x014f
            goto L_0x0151
        L_0x014f:
            r8 = 0
            goto L_0x0152
        L_0x0151:
            r8 = 1
        L_0x0152:
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            if (r5 == 0) goto L_0x015b
            r5 = 34
            goto L_0x015d
        L_0x015b:
            r5 = 32
        L_0x015d:
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r5)
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.layout.SizeKt.m582size3ABfNKs(r9, r5)
            r15 = 0
            r16 = 0
            r17 = 0
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r3.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r5)
            boolean r5 = r3.changed((java.lang.Object) r2)
            boolean r9 = r3.changed((java.lang.Object) r4)
            r5 = r5 | r9
            java.lang.Object r9 = r3.rememberedValue()
            if (r5 != 0) goto L_0x018d
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r9 != r5) goto L_0x0198
        L_0x018d:
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.EmojiQuestionKt$EmojiQuestion$1$1$1$1 r5 = new io.intercom.android.sdk.survey.ui.questiontype.numericscale.EmojiQuestionKt$EmojiQuestion$1$1$1$1
            r5.<init>(r2, r4)
            r9 = r5
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r3.updateRememberedValue(r9)
        L_0x0198:
            r3.endReplaceableGroup()
            r18 = r9
            kotlin.jvm.functions.Function0 r18 = (kotlin.jvm.functions.Function0) r18
            r19 = 7
            r20 = 0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r14, r15, r16, r17, r18, r19, r20)
            r10 = 0
            r14 = 0
            r4 = r6
            r5 = r7
            r6 = r8
            r7 = r9
            r8 = r3
            r9 = r10
            r10 = r14
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.EmojiRatingKt.EmojiRating(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0118
        L_0x01b5:
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            r3.endNode()
            r3.endReplaceableGroup()
            r3.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r3 = r3.endRestartGroup()
            if (r3 != 0) goto L_0x01cb
            goto L_0x01d7
        L_0x01cb:
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.EmojiQuestionKt$EmojiQuestion$2 r4 = new io.intercom.android.sdk.survey.ui.questiontype.numericscale.EmojiQuestionKt$EmojiQuestion$2
            r5 = r25
            r4.<init>(r0, r1, r2, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3.updateScope(r4)
        L_0x01d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.numericscale.EmojiQuestionKt.EmojiQuestion(java.util.List, io.intercom.android.sdk.survey.ui.models.Answer, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }
}
