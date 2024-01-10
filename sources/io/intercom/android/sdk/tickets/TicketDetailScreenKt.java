package io.intercom.android.sdk.tickets;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.tickets.TicketDetailState;
import io.intercom.android.sdk.tickets.TicketTimelineCardState;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\r\u001a\u0017\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\r\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0014"}, d2 = {"sampleTicketDetailState", "Lio/intercom/android/sdk/tickets/TicketDetailState$TicketDetailContentState;", "getSampleTicketDetailState", "()Lio/intercom/android/sdk/tickets/TicketDetailState$TicketDetailContentState;", "TicketDetailScreen", "", "ticketDetailContentState", "onBackClicked", "Lkotlin/Function0;", "showSubmissionCard", "", "(Lio/intercom/android/sdk/tickets/TicketDetailState$TicketDetailContentState;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "TicketPreview", "(Landroidx/compose/runtime/Composer;I)V", "TicketPreviewSubmittedCard", "TicketSubmissionCard", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TicketSubmissionCardPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketDetailScreen.kt */
public final class TicketDetailScreenKt {
    private static final TicketDetailState.TicketDetailContentState sampleTicketDetailState = new TicketDetailState.TicketDetailContentState("API issue", new TicketTimelineCardState(CollectionsKt.listOf(Avatar.create("https://static.intercomassets.com/avatars/5355644/square_128/002Bizimply-Headshots-1641919551.jpeg", "")), "Hannah will pick this up soon", "🕑  Estimated to be resolved today at 4pm", Color.Companion.m1959getBlue0d7_KjU(), CollectionsKt.listOf(new TicketTimelineCardState.ProgressSection(true, new TicketTimelineCardState.ActualStringOrRes.ActualString("Submitted"), Calendar.getInstance().getTimeInMillis(), true), new TicketTimelineCardState.ProgressSection(false, new TicketTimelineCardState.ActualStringOrRes.ActualString("In progress"), 0, false), new TicketTimelineCardState.ProgressSection(false, new TicketTimelineCardState.ActualStringOrRes.ActualString("Resolved"), 0, false)), (Integer) null, (DefaultConstructorMarker) null), CollectionsKt.listOf(new TicketAttribute("Description", new TicketTimelineCardState.ActualStringOrRes.ActualString("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Et, ut hendrerit et lacus, dictumst ridiculus morbi elementum.")), new TicketAttribute("API Version", new TicketTimelineCardState.ActualStringOrRes.ActualString("1.2")), new TicketAttribute("When did the issue occur?", new TicketTimelineCardState.ActualStringOrRes.ActualString("25 April 2022, 11:14"))), "test@gmail.com");

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TicketDetailScreen(io.intercom.android.sdk.tickets.TicketDetailState.TicketDetailContentState r37, kotlin.jvm.functions.Function0<kotlin.Unit> r38, boolean r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r1 = r37
            java.lang.String r0 = "ticketDetailContentState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 1912754378(0x720250ca, float:2.581166E30)
            r2 = r40
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r42 & 2
            if (r2 == 0) goto L_0x001b
            io.intercom.android.sdk.tickets.TicketDetailScreenKt$TicketDetailScreen$1 r2 = io.intercom.android.sdk.tickets.TicketDetailScreenKt$TicketDetailScreen$1.INSTANCE
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r17 = r2
            goto L_0x001d
        L_0x001b:
            r17 = r38
        L_0x001d:
            r2 = r42 & 4
            r14 = 0
            if (r2 == 0) goto L_0x0024
            r15 = 0
            goto L_0x0026
        L_0x0024:
            r15 = r39
        L_0x0026:
            java.lang.Object[] r2 = new java.lang.Object[r14]
            r3 = 0
            r4 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r15)
            r6 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            boolean r5 = r0.changed((java.lang.Object) r5)
            java.lang.Object r6 = r0.rememberedValue()
            if (r5 != 0) goto L_0x004b
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x0056
        L_0x004b:
            io.intercom.android.sdk.tickets.TicketDetailScreenKt$TicketDetailScreen$cardState$2$1 r5 = new io.intercom.android.sdk.tickets.TicketDetailScreenKt$TicketDetailScreen$cardState$2$1
            r5.<init>(r15)
            r6 = r5
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r0.updateRememberedValue(r6)
        L_0x0056:
            r0.endReplaceableGroup()
            r5 = r6
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r7 = 8
            r8 = 6
            r6 = r0
            java.lang.Object r2 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r2, r3, (java.lang.String) r4, r5, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
            r9 = r2
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r2)
            java.lang.String r3 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            java.lang.Object r4 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            r6 = 2
            r10 = 0
            if (r4 != r5) goto L_0x0092
            r4 = -56
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.unit.Dp r4 = androidx.compose.ui.unit.Dp.m4702boximpl(r4)
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r10, r6, r10)
            r0.updateRememberedValue(r4)
        L_0x0092:
            r0.endReplaceableGroup()
            r11 = r4
            androidx.compose.runtime.MutableState r11 = (androidx.compose.runtime.MutableState) r11
            r0.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            java.lang.Object r2 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            r12 = 0
            if (r2 != r3) goto L_0x00b6
            java.lang.Float r2 = java.lang.Float.valueOf(r12)
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r10, r6, r10)
            r0.updateRememberedValue(r2)
        L_0x00b6:
            r0.endReplaceableGroup()
            r13 = r2
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            r2 = -1289355961(0xffffffffb325fd47, float:-3.864741E-8)
            r0.startReplaceableGroup(r2)
            io.intercom.android.sdk.tickets.CardState r2 = m5373TicketDetailScreen$lambda1(r9)
            io.intercom.android.sdk.tickets.CardState r3 = io.intercom.android.sdk.tickets.CardState.SubmissionCard
            if (r2 != r3) goto L_0x0106
            r2 = 1618982084(0x607fb4c4, float:7.370227E19)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            boolean r2 = r0.changed((java.lang.Object) r11)
            boolean r3 = r0.changed((java.lang.Object) r13)
            r2 = r2 | r3
            boolean r3 = r0.changed((java.lang.Object) r9)
            r2 = r2 | r3
            java.lang.Object r3 = r0.rememberedValue()
            if (r2 != 0) goto L_0x00f1
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x00fc
        L_0x00f1:
            io.intercom.android.sdk.tickets.TicketDetailScreenKt$TicketDetailScreen$2$1 r2 = new io.intercom.android.sdk.tickets.TicketDetailScreenKt$TicketDetailScreen$2$1
            r2.<init>(r11, r13, r9, r10)
            r3 = r2
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r0.updateRememberedValue(r3)
        L_0x00fc:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r2 = 70
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r10, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r3, (androidx.compose.runtime.Composer) r0, (int) r2)
        L_0x0106:
            r0.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r18 = r2
            androidx.compose.ui.Modifier r18 = (androidx.compose.ui.Modifier) r18
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r8 = 8
            androidx.compose.material.Colors r2 = r2.getColors(r0, r8)
            long r19 = r2.m1218getSurface0d7_KjU()
            r21 = 0
            r22 = 2
            r23 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r18, r19, r21, r22, r23)
            r7 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r2, r12, r7, r10)
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r3)
            java.lang.String r4 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r14, r0, r14)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r3)
            java.lang.String r6 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r8 = r16
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r3, r7)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r10 = r19
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r3, r7)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r12 = r19
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r3, r7)
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r12 = (androidx.compose.ui.platform.ViewConfiguration) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r3 = r19.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r14 = r0.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x01a0
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01a0:
            r0.startReusableNode()
            boolean r14 = r0.getInserting()
            if (r14 == 0) goto L_0x01ad
            r0.createNode(r3)
            goto L_0x01b0
        L_0x01ad:
            r0.useNode()
        L_0x01b0:
            r0.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r5, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r8, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r10, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r12, r5)
            r0.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r3)
            r5 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            r2.invoke(r3, r0, r8)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r3 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r3)
            java.lang.String r5 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            androidx.compose.foundation.layout.BoxScopeInstance r8 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r8 = (androidx.compose.foundation.layout.BoxScope) r8
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            r10 = 1
            r12 = 0
            r14 = 0
            androidx.compose.ui.Modifier r23 = androidx.compose.foundation.layout.SizeKt.fillMaxHeight$default(r8, r12, r10, r14)
            r24 = 0
            r8 = 56
            float r8 = (float) r8
            float r25 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r8)
            r26 = 0
            r27 = 0
            r28 = 13
            r29 = 0
            androidx.compose.ui.Modifier r30 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r23, r24, r25, r26, r27, r28, r29)
            r8 = 1
            r10 = 0
            androidx.compose.foundation.ScrollState r31 = androidx.compose.foundation.ScrollKt.rememberScrollState(r10, r0, r10, r8)
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 14
            r36 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.ScrollKt.verticalScroll$default(r30, r31, r32, r33, r34, r35, r36)
            r10 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r10)
            java.lang.String r10 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r10)
            androidx.compose.foundation.layout.Arrangement r10 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r10 = r10.getTop()
            androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r12 = r12.getStart()
            r14 = 0
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r10, r12, r0, r14)
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r7)
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r22 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r3 = r22
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r7)
            java.lang.Object r3 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r22 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r2 = r22
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r7)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.materializerOf(r8)
            r25 = r15
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x02b0
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02b0:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x02bd
            r0.createNode(r14)
            goto L_0x02c0
        L_0x02bd:
            r0.useNode()
        L_0x02c0:
            r0.disableReusing()
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r10, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r12, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r3, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r2, r3)
            r0.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r2)
            r3 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            r8.invoke(r2, r0, r10)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r2 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.foundation.layout.ColumnScopeInstance r2 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r2 = (androidx.compose.foundation.layout.ColumnScope) r2
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r26 = r2
            androidx.compose.ui.Modifier r26 = (androidx.compose.ui.Modifier) r26
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r8 = 8
            androidx.compose.material.Colors r2 = r2.getColors(r0, r8)
            long r27 = r2.m1218getSurface0d7_KjU()
            r29 = 0
            r30 = 2
            r31 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r26, r27, r29, r30, r31)
            r3 = 0
            r10 = 1
            r12 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r2, r3, r10, r12)
            r14 = 194(0xc2, float:2.72E-43)
            float r14 = (float) r14
            float r14 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r14)
            r15 = 2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m570heightInVpY3zN4$default(r2, r14, r3, r15, r12)
            r14 = 7
            r3 = 0
            androidx.compose.animation.core.TweenSpec r18 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r3, r3, r12, r14, r12)
            r8 = r18
            androidx.compose.animation.core.FiniteAnimationSpec r8 = (androidx.compose.animation.core.FiniteAnimationSpec) r8
            androidx.compose.ui.Modifier r2 = androidx.compose.animation.AnimationModifierKt.animateContentSize$default(r2, r8, r12, r15, r12)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getCenter()
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            r12 = 6
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r8, r3, r0, r12)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r7)
            java.lang.Object r3 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r7)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r7)
            java.lang.Object r6 = r0.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x03bb
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03bb:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x03c8
            r0.createNode(r7)
            goto L_0x03cb
        L_0x03c8:
            r0.useNode()
        L_0x03cb:
            r0.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r7, r4, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r7, r3, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r7, r8, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r7, r6, r3)
            r0.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r3)
            r4 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r2.invoke(r3, r0, r6)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r2 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            io.intercom.android.sdk.tickets.TicketTimelineCardState r15 = r37.getTicketTimelineCardState()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r8 = r2
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            io.intercom.android.sdk.tickets.CardState r2 = m5373TicketDetailScreen$lambda1(r9)
            io.intercom.android.sdk.tickets.CardState r3 = io.intercom.android.sdk.tickets.CardState.TimelineCard
            if (r2 != r3) goto L_0x0430
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0431
        L_0x0430:
            r2 = 0
        L_0x0431:
            r3 = 0
            r4 = 0
            androidx.compose.animation.core.SpringSpec r5 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r3, r3, r4, r14, r4)
            r3 = r5
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r4 = 0
            r5 = 0
            r7 = 48
            r16 = 12
            r6 = r0
            r10 = r8
            r14 = 8
            r8 = r16
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r2, r3, r4, r5, r6, r7, r8)
            java.lang.Object r2 = r2.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.draw.AlphaKt.alpha(r10, r2)
            r3 = 0
            io.intercom.android.sdk.tickets.TicketTimelineCardKt.TicketTimelineCard(r15, r2, r0, r14, r3)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r10 = r2
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
            io.intercom.android.sdk.tickets.CardState r2 = m5373TicketDetailScreen$lambda1(r9)
            io.intercom.android.sdk.tickets.CardState r3 = io.intercom.android.sdk.tickets.CardState.SubmissionCard
            if (r2 != r3) goto L_0x046e
            float r2 = m5377TicketDetailScreen$lambda7(r13)
            goto L_0x046f
        L_0x046e:
            r2 = 0
        L_0x046f:
            io.intercom.android.sdk.tickets.CardState r3 = m5373TicketDetailScreen$lambda1(r9)
            io.intercom.android.sdk.tickets.CardState r4 = io.intercom.android.sdk.tickets.CardState.SubmissionCard
            r9 = 1000(0x3e8, float:1.401E-42)
            if (r3 != r4) goto L_0x0482
            r3 = 0
            r4 = 0
            androidx.compose.animation.core.TweenSpec r5 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r9, r3, r4, r12, r4)
            androidx.compose.animation.core.FiniteAnimationSpec r5 = (androidx.compose.animation.core.FiniteAnimationSpec) r5
            goto L_0x048c
        L_0x0482:
            r3 = 7
            r4 = 0
            r5 = 0
            androidx.compose.animation.core.SpringSpec r3 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r5, r5, r4, r3, r4)
            r5 = r3
            androidx.compose.animation.core.FiniteAnimationSpec r5 = (androidx.compose.animation.core.FiniteAnimationSpec) r5
        L_0x048c:
            r3 = r5
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r4 = 0
            r5 = 0
            r7 = 64
            r8 = 12
            r6 = r0
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r2, r3, r4, r5, r6, r7, r8)
            java.lang.Object r2 = r2.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.draw.AlphaKt.alpha(r10, r2)
            float r2 = m5375TicketDetailScreen$lambda4(r11)
            r3 = 0
            r4 = 0
            androidx.compose.animation.core.TweenSpec r5 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r9, r3, r4, r12, r4)
            r3 = r5
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r4 = 0
            r6 = 48
            r7 = 4
            r5 = r0
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.AnimateAsStateKt.m102animateDpAsStateKz89ssw(r2, r3, r4, r5, r6, r7)
            java.lang.Object r2 = r2.getValue()
            androidx.compose.ui.unit.Dp r2 = (androidx.compose.ui.unit.Dp) r2
            float r2 = r2.m4718unboximpl()
            r3 = 1
            r4 = 0
            r5 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.OffsetKt.m497offsetVpY3zN4$default(r8, r4, r2, r3, r5)
            r3 = 0
            TicketSubmissionCard(r2, r0, r3, r3)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r0, r14)
            long r4 = r2.m1218getSurface0d7_KjU()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 1
            r6 = 0
            r7 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r2, r6, r3, r7)
            r6 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 506897922(0x1e36a602, float:9.669329E-21)
            io.intercom.android.sdk.tickets.TicketDetailScreenKt$TicketDetailScreen$3$1$2 r12 = new io.intercom.android.sdk.tickets.TicketDetailScreenKt$TicketDetailScreen$3$1$2
            r12.<init>(r1)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r11, r3, r12)
            r11 = r3
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r12 = 1572870(0x180006, float:2.20406E-39)
            r13 = 58
            r3 = r6
            r6 = r7
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r0
            androidx.compose.material.SurfaceKt.m1419SurfaceFjzlyU(r2, r3, r4, r6, r8, r9, r10, r11, r12, r13)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r2 = 0
            java.lang.String r3 = r37.getTicketName()
            r4 = 0
            r5 = 0
            int r6 = io.intercom.android.sdk.R.drawable.intercom_close
            r7 = 0
            androidx.compose.ui.graphics.painter.Painter r7 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r6, r0, r7)
            r8 = 0
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r6 = r6.getColors(r0, r14)
            long r9 = r6.m1218getSurface0d7_KjU()
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r6 = r6.getColors(r0, r14)
            long r11 = r6.m1213getOnSurface0d7_KjU()
            r13 = 0
            r6 = 262144(0x40000, float:3.67342E-40)
            r14 = 57344(0xe000, float:8.0356E-41)
            int r15 = r41 << 9
            r14 = r14 & r15
            r15 = r14 | r6
            r16 = 589(0x24d, float:8.25E-43)
            r6 = r17
            r14 = r0
            r18 = r25
            io.intercom.android.sdk.m5.components.TopActionBarKt.m5180TopActionBar6oU6zVQ(r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x0576
            goto L_0x058b
        L_0x0576:
            io.intercom.android.sdk.tickets.TicketDetailScreenKt$TicketDetailScreen$4 r7 = new io.intercom.android.sdk.tickets.TicketDetailScreenKt$TicketDetailScreen$4
            r0 = r7
            r1 = r37
            r2 = r17
            r3 = r18
            r4 = r41
            r5 = r42
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x058b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.tickets.TicketDetailScreenKt.TicketDetailScreen(io.intercom.android.sdk.tickets.TicketDetailState$TicketDetailContentState, kotlin.jvm.functions.Function0, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: TicketDetailScreen$lambda-1  reason: not valid java name */
    private static final CardState m5373TicketDetailScreen$lambda1(MutableState<CardState> mutableState) {
        return (CardState) mutableState.getValue();
    }

    /* renamed from: TicketDetailScreen$lambda-4  reason: not valid java name */
    private static final float m5375TicketDetailScreen$lambda4(MutableState<Dp> mutableState) {
        return ((Dp) mutableState.getValue()).m4718unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: TicketDetailScreen$lambda-5  reason: not valid java name */
    public static final void m5376TicketDetailScreen$lambda5(MutableState<Dp> mutableState, float f) {
        mutableState.setValue(Dp.m4702boximpl(f));
    }

    /* renamed from: TicketDetailScreen$lambda-7  reason: not valid java name */
    private static final float m5377TicketDetailScreen$lambda7(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: TicketDetailScreen$lambda-8  reason: not valid java name */
    public static final void m5378TicketDetailScreen$lambda8(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* access modifiers changed from: private */
    public static final void TicketSubmissionCard(Modifier modifier, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4 = i;
        int i5 = i2;
        Composer startRestartGroup = composer.startRestartGroup(-1195643643);
        int i6 = i5 & 1;
        if (i6 != 0) {
            i3 = i4 | 6;
            modifier2 = modifier;
        } else if ((i4 & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i4;
        } else {
            modifier2 = modifier;
            i3 = i4;
        }
        if ((i3 & 11) != 2 || !startRestartGroup.getSkipping()) {
            Modifier modifier3 = i6 != 0 ? Modifier.Companion : modifier2;
            float f = (float) 16;
            Arrangement.HorizontalOrVertical r3 = Arrangement.INSTANCE.m407spacedBy0680j_4(Dp.m4704constructorimpl(f));
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Modifier r4 = PaddingKt.m510padding3ABfNKs(modifier3, Dp.m4704constructorimpl(f));
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(r3, centerHorizontally, startRestartGroup, 54);
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
            Composer r7 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r7, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r7, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r7, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r7, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(startRestartGroup, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            IconKt.m1313Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.intercom_submitted, startRestartGroup, 0), (String) null, SizeKt.m582size3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 48)), ColorKt.Color(4279072050L), startRestartGroup, 3512, 0);
            Composer composer2 = startRestartGroup;
            TextKt.m1496TextfLXpl1I(StringResources_androidKt.stringResource(R.string.intercom_tickets_submitted_confirmation_header, startRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m4547boximpl(TextAlign.Companion.m4554getCentere0LSkKk()), 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getSubtitle1(), composer2, 0, 0, 32250);
            TextKt.m1496TextfLXpl1I(StringResources_androidKt.stringResource(R.string.intercom_tickets_submitted_confirmation_paragraph, startRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m4547boximpl(TextAlign.Companion.m4554getCentere0LSkKk()), 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2(), composer2, 0, 0, 32250);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            modifier2 = modifier3;
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TicketDetailScreenKt$TicketSubmissionCard$2(modifier2, i4, i5));
        }
    }

    public static final void TicketSubmissionCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-469332270);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TicketDetailScreenKt.INSTANCE.m5358getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TicketDetailScreenKt$TicketSubmissionCardPreview$1(i));
        }
    }

    public static final void TicketPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1999435190);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TicketDetailScreenKt.INSTANCE.m5359getLambda3$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TicketDetailScreenKt$TicketPreview$1(i));
        }
    }

    public static final void TicketPreviewSubmittedCard(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(184982567);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TicketDetailScreenKt.INSTANCE.m5360getLambda4$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TicketDetailScreenKt$TicketPreviewSubmittedCard$1(i));
        }
    }

    public static final TicketDetailState.TicketDetailContentState getSampleTicketDetailState() {
        return sampleTicketDetailState;
    }

    /* access modifiers changed from: private */
    /* renamed from: TicketDetailScreen$lambda-2  reason: not valid java name */
    public static final void m5374TicketDetailScreen$lambda2(MutableState<CardState> mutableState, CardState cardState) {
        mutableState.setValue(cardState);
    }
}
