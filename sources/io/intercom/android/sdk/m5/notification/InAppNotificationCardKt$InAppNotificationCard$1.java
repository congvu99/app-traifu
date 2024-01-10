package io.intercom.android.sdk.m5.notification;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.components.AvatarIconKt;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.tickets.StatusChip;
import io.intercom.android.sdk.tickets.TicketDetailReducerKt;
import io.intercom.android.sdk.tickets.TicketStatusChipKt;
import io.intercom.android.sdk.utilities.Phrase;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppNotificationCard.kt */
final class InAppNotificationCardKt$InAppNotificationCard$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Conversation $conversation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppNotificationCardKt$InAppNotificationCard$1(Conversation conversation) {
        super(2);
        this.$conversation = conversation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2;
        Context context;
        int i3;
        Composer composer2;
        Composer composer3 = composer;
        if ((i & 11) != 2 || !composer.getSkipping()) {
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Context context2 = (Context) consume;
            float f = (float) 16;
            float f2 = (float) 8;
            Modifier r0 = PaddingKt.m511paddingVpY3zN4(BackgroundKt.m176backgroundbw27NRU(ShadowKt.m1600shadows4CzXII$default(PaddingKt.m511paddingVpY3zN4(Modifier.Companion, Dp.m4704constructorimpl(f), Dp.m4704constructorimpl(f2)), Dp.m4704constructorimpl((float) 2), MaterialTheme.INSTANCE.getShapes(composer3, 8).getMedium(), false, 0, 0, 24, (Object) null), MaterialTheme.INSTANCE.getColors(composer3, 8).m1218getSurface0d7_KjU(), MaterialTheme.INSTANCE.getShapes(composer3, 8).getMedium()), Dp.m4704constructorimpl(f), Dp.m4704constructorimpl((float) 12));
            Conversation conversation = this.$conversation;
            composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer3, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer3, 0);
            composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection = (LayoutDirection) consume3;
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r0);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r10 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r10, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r10, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r10, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r10, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            composer3.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(composer3, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical top = Alignment.Companion.getTop();
            composer3.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer3, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.m407spacedBy0680j_4(Dp.m4704constructorimpl(f2)), top, composer3, 54);
            composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density2 = (Density) consume5;
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume6;
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7 = composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume7;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(fillMaxWidth$default);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer3.createNode(constructor2);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r6 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r6, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r6, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r6, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r6, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            composer3.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation(composer3, "C80@4021L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            Avatar avatar = conversation.getLastAdmin().getAvatar();
            Intrinsics.checkNotNullExpressionValue(avatar, "conversation.lastAdmin.avatar");
            Conversation conversation2 = conversation;
            AvatarIconKt.m5124AvatarIconRd90Nhg(avatar, SizeKt.m582size3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 32)), (Shape) null, false, 0, (Color) null, composer, 56, 60);
            composer3.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer3, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m407spacedBy0680j_4(Dp.m4704constructorimpl((float) 4)), Alignment.Companion.getStart(), composer3, 6);
            composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume8 = composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density3 = (Density) consume8;
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection3 = (LayoutDirection) consume9;
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume10 = composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume10;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(Modifier.Companion);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer3.createNode(constructor3);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r5 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r5, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r5, density3, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r5, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r5, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            composer3.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(composer3, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            composer3.startReplaceableGroup(919329543);
            if (!Intrinsics.areEqual((Object) conversation2.getTicket(), (Object) Ticket.Companion.getNULL())) {
                i2 = 0;
                TicketStatusChipKt.TicketStatusChip(new StatusChip(conversation2.getTicket().getTitle(), conversation2.getTicket().getCurrentStatus().getTitle(), TicketDetailReducerKt.toTicketStatus(conversation2.getTicket().getCurrentStatus()).m5382getColor0d7_KjU(), (DefaultConstructorMarker) null), composer3, 0);
            } else {
                i2 = 0;
            }
            composer.endReplaceableGroup();
            List<Part> parts = conversation2.getParts();
            Intrinsics.checkNotNullExpressionValue(parts, "conversation.parts");
            if (!parts.isEmpty()) {
                composer3.startReplaceableGroup(919330117);
                Part part = conversation2.getParts().get(i2);
                String messageStyle = part.getMessageStyle();
                if (Intrinsics.areEqual((Object) messageStyle, (Object) Part.TICKET_UPDATED_MESSAGE_STYLE)) {
                    composer3.startReplaceableGroup(919330304);
                    String forename = Intrinsics.areEqual((Object) part.getEventData().getStatus(), (Object) MetricTracker.Action.SUBMITTED) ? null : part.getParticipant().getForename();
                    String eventAsPlainText = part.getEventData().getEventAsPlainText();
                    Intrinsics.checkNotNullExpressionValue(eventAsPlainText, "part.eventData.eventAsPlainText");
                    InAppNotificationCardKt.TicketInAppNotificationContent(forename, eventAsPlainText, composer3, i2);
                    composer.endReplaceableGroup();
                    composer2 = composer3;
                    context = context2;
                    i3 = 12;
                } else if (Intrinsics.areEqual((Object) messageStyle, (Object) Part.CHAT_MESSAGE_STYLE)) {
                    composer3.startReplaceableGroup(919330692);
                    String summary = part.getSummary();
                    TextStyle subtitle1 = MaterialTheme.INSTANCE.getTypography(composer3, 8).getSubtitle1();
                    long sp = TextUnitKt.getSp(12);
                    int r15 = TextOverflow.Companion.m4591getEllipsisgIe3tQ8();
                    i3 = 12;
                    Intrinsics.checkNotNullExpressionValue(summary, "summary");
                    context = context2;
                    TextKt.m1496TextfLXpl1I(summary, (Modifier) null, 0, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, r15, false, 2, (Function1<? super TextLayoutResult, Unit>) null, subtitle1, composer, 3072, 3120, 22518);
                    composer.endReplaceableGroup();
                    composer2 = composer;
                } else {
                    context = context2;
                    i3 = 12;
                    composer2 = composer;
                    composer2.startReplaceableGroup(919331167);
                    composer.endReplaceableGroup();
                }
                composer.endReplaceableGroup();
            } else {
                composer2 = composer3;
                context = context2;
                i3 = 12;
                if (!Intrinsics.areEqual((Object) conversation2.getTicket(), (Object) Ticket.Companion.getNULL())) {
                    composer2.startReplaceableGroup(919331256);
                    Ticket ticket = conversation2.getTicket();
                    InAppNotificationCardKt.TicketInAppNotificationContent(Intrinsics.areEqual((Object) ticket.getCurrentStatus().getType(), (Object) MetricTracker.Action.SUBMITTED) ? null : ticket.getAssignee().build().getForename(), ticket.getCurrentStatus().getTitle(), composer2, i2);
                    composer.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(919331641);
                    composer.endReplaceableGroup();
                }
            }
            if (Intrinsics.areEqual((Object) conversation2.getTicket(), (Object) Ticket.Companion.getNULL())) {
                TextKt.m1496TextfLXpl1I(Phrase.from(context, R.string.intercom_reply_from_admin).put("name", (CharSequence) conversation2.getLastAdmin().getName()).format().toString(), (Modifier) null, ColorKt.Color(4285887861L), TextUnitKt.getSp(i3), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 1, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, 8).getCaption(), composer, 3456, 3072, 24562);
            }
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
