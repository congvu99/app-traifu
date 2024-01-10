package io.intercom.android.sdk.tickets.create.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.survey.SurveyUiColors;
import io.intercom.android.sdk.survey.model.SurveyData;
import io.intercom.android.sdk.survey.ui.components.QuestionComponentKt;
import io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a;\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0001¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u000f\u001a\u00020\u0006H\u0003¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0006H\u0003¢\u0006\u0002\u0010\u0010\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"questions", "", "Lio/intercom/android/sdk/survey/QuestionState;", "surveyUiColors", "Lio/intercom/android/sdk/survey/SurveyUiColors;", "CreateTicketContentScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Content;", "onCreateTicket", "Lkotlin/Function0;", "onCancel", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Content;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "CreateTicketContentScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "CreateTicketContentScreenPreviewShort", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: CreateTicketContentScreen.kt */
public final class CreateTicketContentScreenKt {
    /* access modifiers changed from: private */
    public static final List<QuestionState> questions = CollectionsKt.listOf(new QuestionState(new SurveyData.Step.Question.ShortTextQuestionModel("1", CollectionsKt.listOf(new Block.Builder().withText("Email").withType("paragraph")), false, "abc@example.com", SurveyData.Step.Question.QuestionValidation.ValidationType.EMAIL, (Integer) null, false, (Integer) null, JfifUtil.MARKER_SOFn, (DefaultConstructorMarker) null), surveyUiColors), new QuestionState(new SurveyData.Step.Question.LongTextQuestionModel(ExifInterface.GPS_MEASUREMENT_2D, CollectionsKt.listOf(new Block.Builder().withText("Multiline text").withType("paragraph")), true, "Enter text here...", SurveyData.Step.Question.QuestionValidation.ValidationType.EMAIL, (Integer) null, Dp.m4704constructorimpl((float) 120), 0, (Integer) null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, (DefaultConstructorMarker) null), surveyUiColors), new QuestionState(new SurveyData.Step.Question.DropDownQuestionModel(ExifInterface.GPS_MEASUREMENT_3D, CollectionsKt.listOf(new Block.Builder().withText("List attribute").withType("paragraph")), true, CollectionsKt.listOf("Option A", "Option B", "Option C"), "Please select...", (Integer) null, 32, (DefaultConstructorMarker) null), surveyUiColors), new QuestionState(new SurveyData.Step.Question.SingleChoiceQuestionModel("4", CollectionsKt.listOf(new Block.Builder().withText("Boolean").withType("paragraph")), false, CollectionsKt.listOf("True", "False"), false), surveyUiColors), new QuestionState(new SurveyData.Step.Question.DatePickerQuestionModel("5", CollectionsKt.listOf(new Block.Builder().withText("Date and Time").withType("paragraph")), true), surveyUiColors), new QuestionState(new SurveyData.Step.Question.DatePickerQuestionModel("5", CollectionsKt.listOf(new Block.Builder().withText("Date and Time").withType("paragraph")), true), surveyUiColors));
    private static final SurveyUiColors surveyUiColors = new SurveyUiColors(Color.Companion.m1958getBlack0d7_KjU(), Color.Companion.m1969getWhite0d7_KjU(), Color.Companion.m1970getYellow0d7_KjU(), Color.Companion.m1959getBlue0d7_KjU(), (Color) null, 16, (DefaultConstructorMarker) null);

    public static final void CreateTicketContentScreen(Modifier modifier, CreateTicketViewModel.CreateTicketFormUiState.Content content, Function0<Unit> function0, Function0<Unit> function02, Composer composer, int i, int i2) {
        SurveyUiColors surveyUiColors2;
        CreateTicketViewModel.CreateTicketFormUiState.Content content2 = content;
        Intrinsics.checkNotNullParameter(content2, "state");
        Intrinsics.checkNotNullParameter(function0, "onCreateTicket");
        Intrinsics.checkNotNullParameter(function02, "onCancel");
        Composer startRestartGroup = composer.startRestartGroup(1112571823);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.Companion : modifier;
        Modifier r22 = BackgroundKt.m177backgroundbw27NRU$default(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), true, (FlingBehavior) null, false, 12, (Object) null), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1218getSurface0d7_KjU(), (Shape) null, 2, (Object) null);
        float f = (float) 16;
        float r23 = Dp.m4704constructorimpl(f);
        float r25 = Dp.m4704constructorimpl(f);
        float f2 = (float) 24;
        Modifier r4 = PaddingKt.m514paddingqDBjuR0$default(r22, r23, 0.0f, r25, Dp.m4704constructorimpl(f2), 2, (Object) null);
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r4);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r8 = Updater.m1543constructorimpl(startRestartGroup);
        Updater.m1550setimpl(r8, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1550setimpl(r8, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1550setimpl(r8, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1550setimpl(r8, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1163856341);
        ComposerKt.sourceInformation(startRestartGroup, "C79@4027L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(-1253713994);
        for (QuestionState questionState : content.getQuestions()) {
            if (questionState.getQuestionModel() instanceof SurveyData.Step.Question.SingleChoiceQuestionModel) {
                startRestartGroup.startReplaceableGroup(245528572);
                surveyUiColors2 = new SurveyUiColors(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1218getSurface0d7_KjU(), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1214getPrimary0d7_KjU(), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1211getOnPrimary0d7_KjU(), (Color) null, 16, (DefaultConstructorMarker) null);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(245528973);
                surveyUiColors2 = new SurveyUiColors(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1218getSurface0d7_KjU(), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1218getSurface0d7_KjU(), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), Color.m1922boximpl(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1214getPrimary0d7_KjU()), (DefaultConstructorMarker) null);
                startRestartGroup.endReplaceableGroup();
            }
            SurveyUiColors surveyUiColors3 = surveyUiColors2;
            Modifier onFocusChanged = FocusChangedModifierKt.onFocusChanged(Modifier.Companion, new CreateTicketContentScreenKt$CreateTicketContentScreen$1$1$1(questionState));
            long r21 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1218getSurface0d7_KjU();
            float r232 = Dp.m4704constructorimpl((float) 0);
            Modifier modifier3 = onFocusChanged;
            QuestionState questionState2 = questionState;
            QuestionComponentKt.m5311QuestionComponent3mDWlBA(modifier3, PaddingKt.m514paddingqDBjuR0$default(Modifier.Companion, 0.0f, Dp.m4704constructorimpl(f2), 0.0f, 0.0f, 13, (Object) null), questionState2, surveyUiColors3, CreateTicketContentScreenKt$CreateTicketContentScreen$1$1$2.INSTANCE, r21, r232, FontWeight.Companion.getSemiBold(), TextUnitKt.getSp(14), startRestartGroup, 114844208, 0);
        }
        startRestartGroup.endReplaceableGroup();
        SpacerKt.Spacer(ColumnScope.CC.weight$default(columnScope, modifier2, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
        float f3 = (float) 48;
        Modifier r17 = SizeKt.m568height3ABfNKs(PaddingKt.m514paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.m4704constructorimpl(f2), 0.0f, 0.0f, 13, (Object) null), Dp.m4704constructorimpl(f3));
        Modifier modifier4 = modifier2;
        ButtonKt.Button(function0, r17, !content.getShowCreatingTicketProgress(), (MutableInteractionSource) null, (ButtonElevation) null, MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8).getMedium(), (BorderStroke) null, ButtonDefaults.INSTANCE.m1164buttonColorsro_MJ88(0, 0, Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1214getPrimary0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0, startRestartGroup, 32768, 11), (PaddingValues) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1752984213, true, new CreateTicketContentScreenKt$CreateTicketContentScreen$1$2(content2)), startRestartGroup, ((i >> 6) & 14) | 805306416, 344);
        Modifier r15 = SizeKt.m568height3ABfNKs(PaddingKt.m514paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.m4704constructorimpl((float) 8), 0.0f, Dp.m4704constructorimpl(f2), 5, (Object) null), Dp.m4704constructorimpl(f3));
        ButtonKt.Button(function02, r15, false, (MutableInteractionSource) null, ButtonDefaults.INSTANCE.m1165elevationR_JCAzs(Dp.m4704constructorimpl((float) 0), 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 262150, 30), MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8).getMedium(), (BorderStroke) null, ButtonDefaults.INSTANCE.m1164buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1218getSurface0d7_KjU(), 0, 0, 0, startRestartGroup, 32768, 14), (PaddingValues) null, ComposableSingletons$CreateTicketContentScreenKt.INSTANCE.m5389getLambda1$intercom_sdk_base_release(), startRestartGroup, ((i >> 9) & 14) | 805306416, 332);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CreateTicketContentScreenKt$CreateTicketContentScreen$2(modifier4, content, function0, function02, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void CreateTicketContentScreenPreviewShort(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-104998753);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$CreateTicketContentScreenKt.INSTANCE.m5390getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CreateTicketContentScreenKt$CreateTicketContentScreenPreviewShort$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void CreateTicketContentScreenPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1070922859);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$CreateTicketContentScreenKt.INSTANCE.m5391getLambda3$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CreateTicketContentScreenKt$CreateTicketContentScreenPreview$1(i));
        }
    }
}
