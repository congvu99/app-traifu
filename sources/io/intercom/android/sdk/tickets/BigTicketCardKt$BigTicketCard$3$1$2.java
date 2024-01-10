package io.intercom.android.sdk.tickets;

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
import androidx.compose.material.DividerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.tickets.TicketDetailState;
import io.intercom.android.sdk.utilities.ColorExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BigTicketCard.kt */
final class BigTicketCardKt$BigTicketCard$3$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ TicketDetailState.TicketDetailContentState $ticketDetailState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BigTicketCardKt$BigTicketCard$3$1$2(Modifier modifier, TicketDetailState.TicketDetailContentState ticketDetailContentState) {
        super(2);
        this.$modifier = modifier;
        this.$ticketDetailState = ticketDetailContentState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2;
        Composer composer2 = composer;
        if ((i & 11) != 2 || !composer.getSkipping()) {
            Modifier modifier = this.$modifier;
            TicketDetailState.TicketDetailContentState ticketDetailContentState = this.$ticketDetailState;
            composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
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
            Composer r9 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r9, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r9, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r9, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r9, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(composer2, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            float f = (float) 12;
            Modifier r1 = PaddingKt.m510padding3ABfNKs(modifier, Dp.m4704constructorimpl(f));
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density2 = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r1);
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
            Composer r7 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r7, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r7, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r7, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r7, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(composer2, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 4)), composer2, 6);
            String str = "C:CompositionLocal.kt#9igjgp";
            float f2 = f;
            ColumnScope columnScope3 = columnScope;
            String str2 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
            TicketDetailState.TicketDetailContentState ticketDetailContentState2 = ticketDetailContentState;
            Composer composer3 = composer2;
            Composer composer4 = composer3;
            TextKt.m1496TextfLXpl1I(ticketDetailContentState.getTicketName(), (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer3, 8).getBody2(), 0, 0, FontWeight.Companion.getW700(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262139, (Object) null), composer, 0, 0, 32766);
            Integer statusLabel = ticketDetailContentState2.getTicketTimelineCardState().getStatusLabel();
            composer4.startReplaceableGroup(-1168560703);
            if (statusLabel == null) {
                i2 = 0;
            } else {
                int intValue = statusLabel.intValue();
                SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 8)), composer4, 6);
                i2 = 0;
                TextKt.m1496TextfLXpl1I(StringResources_androidKt.stringResource(intValue, composer4, 0), (Modifier) null, ticketDetailContentState2.getTicketTimelineCardState().m5386getProgressColor0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer4, 8).getCaption(), 0, 0, FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262139, (Object) null), composer, 0, 0, 32762);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            composer.endReplaceableGroup();
            composer4.startReplaceableGroup(-1168560187);
            String statusTitle = ticketDetailContentState2.getTicketTimelineCardState().getStatusTitle();
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 8)), composer4, 6);
            TextKt.m1496TextfLXpl1I(statusTitle, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer4, 8).getBody2(), 0, 0, FontWeight.Companion.getW400(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262139, (Object) null), composer, 0, 0, 32766);
            Unit unit3 = Unit.INSTANCE;
            composer.endReplaceableGroup();
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 16)), composer4, 6);
            TicketProgressIndicatorKt.TicketProgressIndicator(ticketDetailContentState2.getTicketTimelineCardState(), (Modifier) null, composer4, 8, 2);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            DividerKt.m1254DivideroMI9zvI(PaddingKt.m512paddingVpY3zN4$default(Modifier.Companion, Dp.m4704constructorimpl(f2), 0.0f, 2, (Object) null), Color.m1931copywmQWz5c$default(ColorKt.Color(4292993505L), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, 0.0f, composer, 54, 12);
            Modifier r12 = PaddingKt.m512paddingVpY3zN4$default(columnScope3.align(Modifier.Companion, Alignment.Companion.getCenterHorizontally()), 0.0f, Dp.m4704constructorimpl((float) 14), 1, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            composer4.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer4, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer4, 48);
            composer4.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer4, str2);
            String str3 = str;
            ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, str3);
            Object consume7 = composer4.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density3 = (Density) consume7;
            ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, str3);
            Object consume8 = composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
            ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, str3);
            Object consume9 = composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(r12);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer4.createNode(constructor3);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r5 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r5, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r5, density3, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r5, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r5, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer4, Integer.valueOf(i2));
            composer4.startReplaceableGroup(2058660585);
            composer4.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation(composer4, "C80@4021L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            IconKt.m1313Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.intercom_ticket_detail_icon, composer4, 0), (String) null, PaddingKt.m514paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.m4704constructorimpl((float) 8), 0.0f, 11, (Object) null), ColorExtensionsKt.m5398getAccessibleColorOnWhiteBackground8_81llA(MaterialTheme.INSTANCE.getColors(composer4, 8).m1214getPrimary0d7_KjU()), composer, 440, 0);
            TextKt.m1496TextfLXpl1I(StringResources_androidKt.stringResource(R.string.intercom_tickets_view_ticket, composer4, 0), (Modifier) null, ColorExtensionsKt.m5398getAccessibleColorOnWhiteBackground8_81llA(MaterialTheme.INSTANCE.getColors(composer4, 8).m1214getPrimary0d7_KjU()), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer4, 8).getBody2(), 0, 0, FontWeight.Companion.getW700(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262139, (Object) null), composer, 0, 0, 32762);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
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
