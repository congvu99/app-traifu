package io.intercom.android.sdk.survey.ui.components;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.survey.SurveyState;
import io.intercom.android.sdk.survey.SurveyUiColors;
import io.intercom.android.sdk.survey.block.BlockRenderData;
import io.intercom.android.sdk.survey.block.BlockViewKt;
import io.intercom.android.sdk.survey.block.SuffixText;
import io.intercom.android.sdk.utilities.Phrase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyComponent.kt */
final class SurveyComponentKt$SurveyContent$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Function0<Unit> $onAnswerUpdated;
    final /* synthetic */ Function1<CoroutineScope, Unit> $onContinue;
    final /* synthetic */ Function1<SurveyState.Content.SecondaryCta, Unit> $onSecondaryCtaClicked;
    final /* synthetic */ SurveyState.Content $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurveyComponentKt$SurveyContent$1(SurveyState.Content content, Function1<? super SurveyState.Content.SecondaryCta, Unit> function1, int i, Function0<Unit> function0, Function1<? super CoroutineScope, Unit> function12, CoroutineScope coroutineScope) {
        super(3);
        this.$state = content;
        this.$onSecondaryCtaClicked = function1;
        this.$$dirty = i;
        this.$onAnswerUpdated = function0;
        this.$onContinue = function12;
        this.$coroutineScope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        int i2;
        String str;
        BoxWithConstraintsScope boxWithConstraintsScope2 = boxWithConstraintsScope;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope2, "$this$BoxWithConstraints");
        if ((i & 14) == 0) {
            i2 = i | (composer2.changed((Object) boxWithConstraintsScope2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 91) != 18 || !composer.getSkipping()) {
            float r1 = boxWithConstraintsScope.m458getMaxHeightD9Ej5fM();
            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, composer2, 0, 1);
            composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed = composer2.changed((Object) rememberScrollState);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SurveyComponentKt$SurveyContent$1$1$1(rememberScrollState, (Continuation<? super SurveyComponentKt$SurveyContent$1$1$1>) null);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            EffectsKt.LaunchedEffect((Object) "", (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue, composer2, 70);
            float f = (float) 16;
            float f2 = f;
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m512paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m4704constructorimpl(f), 0.0f, 2, (Object) null), rememberScrollState, true, (FlingBehavior) null, false, 12, (Object) null);
            SurveyState.Content content = this.$state;
            Function1<SurveyState.Content.SecondaryCta, Unit> function1 = this.$onSecondaryCtaClicked;
            int i3 = this.$$dirty;
            Function0<Unit> function0 = this.$onAnswerUpdated;
            Function1<CoroutineScope, Unit> function12 = this.$onContinue;
            CoroutineScope coroutineScope = this.$coroutineScope;
            composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Function1<SurveyState.Content.SecondaryCta, Unit> function13 = function1;
            Function0<Unit> function02 = function0;
            String str2 = "C:CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str2);
            Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str2);
            Object consume2 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str2);
            Object consume3 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(verticalScroll$default);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r0 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r0, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r0, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r0, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r0, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(composer2, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl(f2)), composer2, 6);
            float r12 = Dp.m4704constructorimpl(r1 - Dp.m4704constructorimpl((float) 96));
            int size = content.getSecondaryCtaActions().size();
            for (int i4 = 0; i4 < size; i4++) {
                r12 = Dp.m4704constructorimpl(r12 - Dp.m4704constructorimpl((float) 64));
                Unit unit = Unit.INSTANCE;
            }
            Modifier r13 = SizeKt.m567defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, r12, 1, (Object) null);
            composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str2);
            Object consume4 = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density2 = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str2);
            Object consume5 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str2);
            Object consume6 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r13);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r11 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r11, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r11, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r11, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r11, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(composer2, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(1537329382);
            Iterable<Block.Builder> stepTitle = content.getStepTitle();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(stepTitle, 10));
            for (Block.Builder build : stepTitle) {
                arrayList.add(build.build());
            }
            for (Block block : (List) arrayList) {
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Intrinsics.checkNotNullExpressionValue(block, "it");
                BlockViewKt.m5297BlockViewFU0evQE(fillMaxWidth$default, new BlockRenderData(block, Color.m1922boximpl(content.getSurveyUiColors().m5277getOnBackground0d7_KjU()), 0, 0, (FontWeight) null, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 2044, (DefaultConstructorMarker) null), content.getSurveyUiColors().m5277getOnBackground0d7_KjU(), (SuffixText) null, false, (ViewGroup) null, composer, 70, 56);
                function12 = function12;
                coroutineScope = coroutineScope;
                str2 = str2;
                i3 = i3;
                content = content;
            }
            CoroutineScope coroutineScope2 = coroutineScope;
            Function1<CoroutineScope, Unit> function14 = function12;
            String str3 = str2;
            int i5 = i3;
            SurveyState.Content content2 = content;
            int i6 = 2023513938;
            composer.endReplaceableGroup();
            float f3 = (float) 8;
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl(f3)), composer2, 6);
            composer2.startReplaceableGroup(-2115005864);
            Iterator it = content2.getQuestions().iterator();
            int i7 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                int i8 = i7 + 1;
                if (i7 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ComposerKt.sourceInformationMarkerStart(composer2, i6, str3);
                Object consume7 = composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposerKt.sourceInformationMarkerEnd(composer);
                QuestionComponentKt.m5311QuestionComponent3mDWlBA(PaddingKt.m512paddingVpY3zN4$default(SemanticsModifierKt.semantics(Modifier.Companion, true, new SurveyComponentKt$SurveyContent$1$2$2$3$1(Phrase.from((Context) consume7, R.string.intercom_surveys_question_question_number_of_question_count).put("questioin_number", i8).put("question_count", content2.getQuestions().size()).format())), 0.0f, Dp.m4704constructorimpl(f3), 1, (Object) null), (Modifier) null, (QuestionState) next, (SurveyUiColors) null, function02, 0, 0.0f, (FontWeight) null, 0, composer, ((i5 << 6) & 57344) | 512, 490);
                it = it;
                coroutineScope2 = coroutineScope2;
                f3 = f3;
                str3 = str3;
                i7 = i8;
                function14 = function14;
                i6 = 2023513938;
            }
            Function1<CoroutineScope, Unit> function15 = function14;
            CoroutineScope coroutineScope3 = coroutineScope2;
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 8)), composer2, 6);
            SurveyState.Content.PrimaryCta primaryCta = content2.getPrimaryCta();
            composer2.startReplaceableGroup(-2115004854);
            if (primaryCta instanceof SurveyState.Content.PrimaryCta.Custom) {
                str = ((SurveyState.Content.PrimaryCta.Custom) primaryCta).getText();
            } else if (primaryCta instanceof SurveyState.Content.PrimaryCta.Fallback) {
                str = StringResources_androidKt.stringResource(((SurveyState.Content.PrimaryCta.Fallback) primaryCta).getFallbackTextRes(), composer2, 0);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            composer.endReplaceableGroup();
            SurveyCtaButtonComponentKt.SurveyCtaButtonComponent((Modifier) null, str, content2.getSecondaryCtaActions(), new SurveyComponentKt$SurveyContent$1$2$3(function15, coroutineScope3), function13, content2.getSurveyUiColors(), composer, (57344 & (i5 << 3)) | 512, 1);
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl(f2)), composer2, 6);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            return;
        }
        composer.skipToGroupEnd();
    }
}
