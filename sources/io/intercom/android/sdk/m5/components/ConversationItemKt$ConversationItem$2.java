package io.intercom.android.sdk.m5.components;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
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
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.tickets.StatusChip;
import io.intercom.android.sdk.tickets.TicketDetailReducerKt;
import io.intercom.android.sdk.tickets.TicketStatusChipKt;
import io.intercom.android.sdk.utilities.TimeFormatterExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConversationItem.kt */
final class ConversationItemKt$ConversationItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Context $context;
    final /* synthetic */ Conversation $conversation;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationItemKt$ConversationItem$2(Modifier modifier, PaddingValues paddingValues, Conversation conversation, Context context) {
        super(2);
        this.$modifier = modifier;
        this.$contentPadding = paddingValues;
        this.$conversation = conversation;
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        List list;
        Context context;
        String str;
        String str2;
        String str3;
        Conversation conversation;
        Composer composer2 = composer;
        if ((i & 11) != 2 || !composer.getSkipping()) {
            Modifier padding = PaddingKt.padding(this.$modifier, this.$contentPadding);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Conversation conversation2 = this.$conversation;
            Context context2 = this.$context;
            composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(padding);
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
            Composer r6 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r6, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r6, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r6, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r6, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation(composer2, "C80@4021L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            if (LastParticipatingAdmin.isNull(conversation2.getLastParticipatingAdmin())) {
                list = ConversationItemKt.getActiveAdminsAvatars();
            } else {
                list = CollectionsKt.listOf(conversation2.getLastParticipatingAdmin().getAvatar());
            }
            String str4 = "C80@4021L9:Row.kt#2w3rfo";
            Context context3 = context2;
            String str5 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo";
            String str6 = "C:CompositionLocal.kt#9igjgp";
            AvatarTriangleGroupKt.m5127AvatarTriangleGroupjt2gSs(list, rowScope.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), (Shape) null, Dp.m4704constructorimpl((float) 32), composer, 3080, 4);
            SpacerKt.Spacer(SizeKt.m587width3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 12)), composer2, 6);
            Modifier weight$default = RowScope.CC.weight$default(rowScope, Modifier.Companion, 2.0f, false, 2, (Object) null);
            composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str6);
            Object consume4 = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density2 = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str6);
            Object consume5 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str6);
            Object consume6 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(weight$default);
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
            Composer r62 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r62, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r62, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r62, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r62, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(composer2, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(2036807265);
            if (!Intrinsics.areEqual((Object) conversation2.getTicket(), (Object) Ticket.Companion.getNULL())) {
                TicketStatusChipKt.TicketStatusChip(new StatusChip(conversation2.getTicket().getTitle(), conversation2.getTicket().getCurrentStatus().getTitle(), TicketDetailReducerKt.toTicketStatus(conversation2.getTicket().getCurrentStatus()).m5382getColor0d7_KjU(), (DefaultConstructorMarker) null), composer2, 0);
            }
            composer.endReplaceableGroup();
            CharSequence summary = conversation2.getLastPart().getSummary();
            CharSequence charSequence = "";
            if (summary.length() == 0) {
                summary = !Intrinsics.areEqual((Object) conversation2.getTicket(), (Object) Ticket.Companion.getNULL()) ? conversation2.getTicket().getCurrentStatus().getStatusDetail() : charSequence;
            }
            String str7 = (String) summary;
            composer2.startReplaceableGroup(2036808040);
            Intrinsics.checkNotNullExpressionValue(str7, "lastPartSummary");
            if (str7.length() > 0) {
                composer2.startReplaceableGroup(2036808133);
                if (conversation2.getLastPart().getParticipant().isUserWithId(ConversationItemKt.getUserIntercomId())) {
                    StringBuilder sb = new StringBuilder();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str6);
                    Object consume7 = composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    sb.append(((Context) consume7).getString(R.string.intercom_you));
                    sb.append(": ");
                    sb.append(str7);
                    str7 = sb.toString();
                }
                composer.endReplaceableGroup();
                int r16 = TextOverflow.Companion.m4591getEllipsisgIe3tQ8();
                TextStyle r20 = TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer2, 8).getBody2(), 0, 0, (!conversation2.isRead() || !Intrinsics.areEqual((Object) conversation2.getTicket(), (Object) Ticket.Companion.getNULL())) ? FontWeight.Companion.getSemiBold() : FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262139, (Object) null);
                Modifier r2 = PaddingKt.m512paddingVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m4704constructorimpl((float) 4), 1, (Object) null);
                Intrinsics.checkNotNullExpressionValue(str7, "if (conversation.lastPar…                        }");
                str3 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
                str = str6;
                str2 = str5;
                context = context3;
                conversation = conversation2;
                TextKt.m1496TextfLXpl1I(str7, r2, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, r16, false, 1, (Function1<? super TextLayoutResult, Unit>) null, r20, composer, 48, 3120, 22524);
            } else {
                str3 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
                str = str6;
                conversation = conversation2;
                context = context3;
                str2 = str5;
            }
            composer.endReplaceableGroup();
            Composer composer3 = composer;
            composer3.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer3, str2);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer3, 0);
            composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer3, str3);
            String str8 = str;
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str8);
            Object consume8 = composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density3 = (Density) consume8;
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str8);
            Object consume9 = composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection3 = (LayoutDirection) consume9;
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str8);
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
            Updater.m1550setimpl(r5, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r5, density3, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r5, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r5, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            composer3.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation(composer3, str4);
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            TextStyle r52 = TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer3, 8).getBody2(), 0, 0, conversation.isRead() ? FontWeight.Companion.getNormal() : FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262139, (Object) null);
            CharSequence firstName = conversation.getLastParticipatingAdmin().getFirstName();
            if (firstName.length() == 0) {
                firstName = ConversationItemKt.getWorkspaceName();
            }
            Intrinsics.checkNotNullExpressionValue(firstName, "conversation.lastPartici…ty { getWorkspaceName() }");
            String str9 = (String) firstName;
            Context context4 = context;
            CharSequence formattedDateFromLong = TimeFormatterExtKt.formattedDateFromLong(conversation.getLastPart().getCreatedAt(), context4);
            if (formattedDateFromLong.length() == 0) {
                if (!Intrinsics.areEqual((Object) conversation.getTicket(), (Object) Ticket.Companion.getNULL())) {
                    charSequence = TimeFormatterExtKt.formattedDateFromLong(conversation.getTicket().getCurrentStatus().getCreatedDate(), context4);
                }
                formattedDateFromLong = charSequence;
            }
            TextWithSeparatorKt.m5179TextWithSeparatorljD6DUQ(str9, (String) formattedDateFromLong, (Modifier) null, (String) null, r52, ColorKt.Color(4285756278L), 0, 0, composer, 196608, 204);
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
            if (!conversation.isRead()) {
                composer3.startReplaceableGroup(334096189);
                ConversationItemKt.ConversationUnreadIndicator(composer3, 0);
                composer.endReplaceableGroup();
            } else {
                composer3.startReplaceableGroup(334096256);
                IntercomChevronKt.IntercomChevron(composer3, 0);
                composer.endReplaceableGroup();
            }
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
