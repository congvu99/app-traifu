package io.intercom.android.sdk.survey.ui.components;

import android.content.Context;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.survey.ProgressBarState;
import io.intercom.android.sdk.survey.SurveyUiColors;
import io.intercom.android.sdk.survey.SurveyViewModelKt;
import io.intercom.android.sdk.survey.TopBarState;
import io.intercom.android.sdk.survey.model.SurveyCustomization;
import io.intercom.android.sdk.utilities.ColorExtensionsKt;
import io.intercom.android.sdk.utilities.Phrase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a#\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"NoTopBar", "", "(Landroidx/compose/runtime/Composer;I)V", "SurveyAvatarBar", "SurveyTopBar", "topBarState", "Lio/intercom/android/sdk/survey/TopBarState;", "onClose", "Lkotlin/Function0;", "(Lio/intercom/android/sdk/survey/TopBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyTopBarComponent.kt */
public final class SurveyTopBarComponentKt {
    public static final void SurveyTopBar(TopBarState topBarState, Function0<Unit> function0, Composer composer, int i) {
        int i2;
        Composer composer2;
        int i3;
        Composer composer3;
        float f;
        int i4;
        int i5;
        long j;
        long j2;
        TopBarState topBarState2 = topBarState;
        Function0<Unit> function02 = function0;
        int i6 = i;
        Intrinsics.checkNotNullParameter(topBarState2, "topBarState");
        Intrinsics.checkNotNullParameter(function02, "onClose");
        Composer startRestartGroup = composer.startRestartGroup(309773028);
        if ((i6 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) topBarState2) ? 4 : 2) | i6;
        } else {
            i2 = i6;
        }
        if ((i6 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function02) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxWidth$default);
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
            Composer r3 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r3, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r3, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r3, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(startRestartGroup, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            float f2 = (float) 16;
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl(f2)), startRestartGroup, 6);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(PaddingKt.m512paddingVpY3zN4$default(Modifier.Companion, Dp.m4704constructorimpl(f2), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density2 = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(fillMaxWidth$default2);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r1 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r1, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r1, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r1, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r1, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation(startRestartGroup, "C80@4021L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            if (topBarState2 instanceof TopBarState.SenderTopBarState) {
                startRestartGroup.startReplaceableGroup(742272877);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                TopBarState.SenderTopBarState senderTopBarState = (TopBarState.SenderTopBarState) topBarState2;
                CharSequence format = Phrase.from((Context) consume7, R.string.intercom_teammate_from_company).put("name", (CharSequence) senderTopBarState.getSenderName()).put("company", (CharSequence) senderTopBarState.getAppConfig().getName()).format();
                Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                startRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(startRestartGroup, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, startRestartGroup, 48);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density3 = (Density) consume8;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) consume9;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume10 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume10;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(Modifier.Companion);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r11 = Updater.m1543constructorimpl(startRestartGroup);
                Updater.m1550setimpl(r11, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1550setimpl(r11, density3, ComposeUiNode.Companion.getSetDensity());
                Updater.m1550setimpl(r11, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1550setimpl(r11, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation(startRestartGroup, "C80@4021L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                i3 = 0;
                CircularAvatarComponentKt.m5309CircularAvataraMcp0Q(senderTopBarState.getAvatar(), ColorKt.Color(senderTopBarState.getAppConfig().getSecondaryColor()), 0.0f, startRestartGroup, 8, 4);
                SpacerKt.Spacer(SizeKt.m587width3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 8)), startRestartGroup, 6);
                TextKt.m1496TextfLXpl1I(format.toString(), (Modifier) null, topBarState.getSurveyUiColors().m5277getOnBackground0d7_KjU(), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m4591getEllipsisgIe3tQ8(), false, 1, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 199680, 3120, 55250);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                i3 = 0;
                if (topBarState2 instanceof TopBarState.NoTopBarState) {
                    startRestartGroup.startReplaceableGroup(742273936);
                    SpacerKt.Spacer(SizeKt.m587width3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 1)), startRestartGroup, 6);
                    startRestartGroup.endReplaceableGroup();
                } else {
                    startRestartGroup.startReplaceableGroup(742274029);
                    startRestartGroup.endReplaceableGroup();
                }
            }
            startRestartGroup.startReplaceableGroup(933804633);
            if (topBarState.getShowDismissButton()) {
                f = f2;
                composer3 = startRestartGroup;
                i5 = 1;
                i4 = 6;
                IconKt.m1314Iconww6aTOc(CloseKt.getClose(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.intercom_dismiss, startRestartGroup, i3), ClickableKt.m196clickableXHw0xAI$default(Modifier.Companion, false, (String) null, (Role) null, function0, 7, (Object) null), topBarState.getSurveyUiColors().m5277getOnBackground0d7_KjU(), composer3, 0, 0);
            } else {
                f = f2;
                composer3 = startRestartGroup;
                i5 = 1;
                i4 = 6;
            }
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            composer3.endNode();
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            ProgressBarState progressBarState = topBarState.getProgressBarState();
            if (progressBarState.isVisible()) {
                composer2 = composer3;
                SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl(f)), composer2, i4);
                State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(progressBarState.getProgress(), AnimationSpecKt.tween$default(200, 0, (Easing) null, i4, (Object) null), 0.0f, (Function1<? super Float, Unit>) null, composer2, 48, 12);
                if (ColorExtensionsKt.m5401isDarkColor8_81llA(topBarState.getSurveyUiColors().m5273getBackground0d7_KjU())) {
                    j = ColorKt.Color(1728053247);
                } else {
                    j = ColorKt.Color(1291845632);
                }
                long j3 = j;
                SurveyUiColors surveyUiColors = topBarState.getSurveyUiColors();
                if (Color.m1933equalsimpl0(surveyUiColors.m5273getBackground0d7_KjU(), surveyUiColors.m5274getButton0d7_KjU()) && ColorExtensionsKt.m5403isWhite8_81llA(surveyUiColors.m5273getBackground0d7_KjU())) {
                    j2 = ColorKt.Color(3439329279L);
                } else if (!Color.m1933equalsimpl0(surveyUiColors.m5273getBackground0d7_KjU(), surveyUiColors.m5274getButton0d7_KjU()) || !ColorExtensionsKt.m5399isBlack8_81llA(surveyUiColors.m5273getBackground0d7_KjU())) {
                    j2 = surveyUiColors.m5274getButton0d7_KjU();
                } else {
                    j2 = ColorKt.Color(2147483648L);
                }
                ProgressIndicatorKt.m1365LinearProgressIndicatoreaDK9VM(animateFloatAsState.getValue().floatValue(), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i5, (Object) null), j2, j3, composer2, 48, 0);
            } else {
                composer2 = composer3;
            }
            Unit unit = Unit.INSTANCE;
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SurveyTopBarComponentKt$SurveyTopBar$2(topBarState2, function02, i6));
        }
    }

    public static final void SurveyAvatarBar(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1511683997);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            Avatar build = new Avatar.Builder().withInitials("VR").build();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AppConfig appConfig = new AppConfig((Context) consume);
            SurveyUiColors surveyUiColors = SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null));
            Intrinsics.checkNotNullExpressionValue(build, "build()");
            SurveyTopBar(new TopBarState.SenderTopBarState(build, "Vinesh", appConfig, false, surveyUiColors, (ProgressBarState) null, 32, (DefaultConstructorMarker) null), SurveyTopBarComponentKt$SurveyAvatarBar$1.INSTANCE, startRestartGroup, 56);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SurveyTopBarComponentKt$SurveyAvatarBar$2(i));
        }
    }

    public static final void NoTopBar(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1502798722);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            SurveyTopBar(new TopBarState.NoTopBarState(true, SurveyViewModelKt.toSurveyUiColors(new SurveyCustomization((String) null, (String) null, 3, (DefaultConstructorMarker) null)), new ProgressBarState(false, 0.0f, 3, (DefaultConstructorMarker) null)), SurveyTopBarComponentKt$NoTopBar$1.INSTANCE, startRestartGroup, 48);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SurveyTopBarComponentKt$NoTopBar$2(i));
        }
    }
}
