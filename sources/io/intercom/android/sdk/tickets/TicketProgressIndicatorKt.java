package io.intercom.android.sdk.tickets;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.Shapes;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.tickets.TicketTimelineCardState;
import io.intercom.android.sdk.utilities.TimeFormatter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"TicketProgressIndicator", "", "ticketTimelineCardState", "Lio/intercom/android/sdk/tickets/TicketTimelineCardState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/intercom/android/sdk/tickets/TicketTimelineCardState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TicketProgressIndicatorPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketProgressIndicator.kt */
public final class TicketProgressIndicatorKt {
    public static final void TicketProgressIndicator(TicketTimelineCardState ticketTimelineCardState, Modifier modifier, Composer composer, int i, int i2) {
        RoundedCornerShape roundedCornerShape;
        String str;
        long j;
        TicketTimelineCardState ticketTimelineCardState2 = ticketTimelineCardState;
        int i3 = i2;
        Intrinsics.checkNotNullParameter(ticketTimelineCardState2, "ticketTimelineCardState");
        Composer startRestartGroup = composer.startRestartGroup(-1654447804);
        Modifier modifier2 = (i3 & 2) != 0 ? Modifier.Companion : modifier;
        String str2 = "C:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str2);
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        int i4 = 48;
        float r11 = Dp.m4704constructorimpl(Dp.m4704constructorimpl(Dp.m4704constructorimpl((float) ((Configuration) consume).screenWidthDp) - Dp.m4704constructorimpl((float) 48)) / ((float) ticketTimelineCardState.getProgressSections().size()));
        int i5 = 0;
        Modifier wrapContentSize$default = SizeKt.wrapContentSize$default(modifier2, (Alignment) null, false, 3, (Object) null);
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        String str3 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
        ComposerKt.sourceInformation(startRestartGroup, str3);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str2);
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density = (Density) consume2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str2);
        Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) consume3;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str2);
        Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume4;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(wrapContentSize$default);
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
        Composer r9 = Updater.m1543constructorimpl(startRestartGroup);
        Updater.m1550setimpl(r9, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1550setimpl(r9, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1550setimpl(r9, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1550setimpl(r9, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-678309503);
        ComposerKt.sourceInformation(startRestartGroup, "C80@4021L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        int i6 = 0;
        for (Object next : ticketTimelineCardState.getProgressSections()) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TicketTimelineCardState.ProgressSection progressSection = (TicketTimelineCardState.ProgressSection) next;
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Modifier r5 = PaddingKt.m514paddingqDBjuR0$default(SizeKt.m587width3ABfNKs(Modifier.Companion, r11), 0.0f, 0.0f, Dp.m4704constructorimpl(i6 < CollectionsKt.getLastIndex(ticketTimelineCardState.getProgressSections()) ? (float) 4 : (float) i5), 0.0f, 11, (Object) null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, i4);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, str3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str2);
            Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density2 = (Density) consume5;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str2);
            Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume6;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str2);
            Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume7;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r5);
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
            Composer r8 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r8, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r8, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r8, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r8, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf(i5));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(startRestartGroup, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            if (i6 == 0) {
                roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape$default(50, 0, 0, 50, 6, (Object) null);
            } else if (i6 == CollectionsKt.getLastIndex(ticketTimelineCardState.getProgressSections())) {
                roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape$default(0, 50, 50, 0, 9, (Object) null);
            } else {
                roundedCornerShape = RoundedCornerShapeKt.m855RoundedCornerShape0680j_4(Dp.m4704constructorimpl((float) i5));
            }
            String str4 = str3;
            float f = r11;
            ProgressIndicatorKt.m1365LinearProgressIndicatoreaDK9VM(progressSection.isDone() ? 1.0f : 0.0f, ClipKt.clip(Modifier.Companion, roundedCornerShape), ticketTimelineCardState.m5386getProgressColor0d7_KjU(), ColorKt.Color(4292993505L), startRestartGroup, 3072, 0);
            String text = progressSection.getTitle().getText(startRestartGroup, 0);
            Modifier r52 = PaddingKt.m514paddingqDBjuR0$default(Modifier.Companion, 0.0f, Dp.m4704constructorimpl((float) 8), 0.0f, 0.0f, 13, (Object) null);
            TextStyle subtitle2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getSubtitle2();
            FontWeight semiBold = progressSection.isCurrentStatus() ? FontWeight.Companion.getSemiBold() : FontWeight.Companion.getNormal();
            startRestartGroup.startReplaceableGroup(846239427);
            long r6 = progressSection.isCurrentStatus() ? MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU() : ColorKt.Color(4285887861L);
            startRestartGroup.endReplaceableGroup();
            Modifier modifier3 = modifier2;
            String str5 = str2;
            TextKt.m1496TextfLXpl1I(text, r52, r6, 0, (FontStyle) null, semiBold, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, subtitle2, startRestartGroup, 48, 0, 32728);
            if (progressSection.getTimestamp() == 0 || !progressSection.isDone()) {
                str = str5;
            } else {
                long timestamp = progressSection.getTimestamp();
                String str6 = str5;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str6);
                Object consume8 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                String formatTimeForTickets = TimeFormatter.formatTimeForTickets(timestamp, (Context) consume8);
                Modifier r4 = PaddingKt.m514paddingqDBjuR0$default(Modifier.Companion, 0.0f, Dp.m4704constructorimpl((float) 2), 0.0f, 0.0f, 13, (Object) null);
                TextStyle body2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2();
                if (progressSection.isCurrentStatus()) {
                    startRestartGroup.startReplaceableGroup(846240120);
                    j = MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU();
                } else {
                    startRestartGroup.startReplaceableGroup(846240166);
                    j = Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                startRestartGroup.endReplaceableGroup();
                Intrinsics.checkNotNullExpressionValue(formatTimeForTickets, "time");
                str = str6;
                TextKt.m1496TextfLXpl1I(formatTimeForTickets, r4, j, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, body2, startRestartGroup, 48, 0, 32760);
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            i6 = i7;
            str3 = str4;
            r11 = f;
            str2 = str;
            modifier2 = modifier3;
            i5 = 0;
            i4 = 48;
        }
        Modifier modifier4 = modifier2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TicketProgressIndicatorKt$TicketProgressIndicator$2(ticketTimelineCardState2, modifier4, i, i3));
        }
    }

    public static final void TicketProgressIndicatorPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1245553611);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TicketProgressIndicatorKt.INSTANCE.m5361getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TicketProgressIndicatorKt$TicketProgressIndicatorPreview$1(i));
        }
    }
}
