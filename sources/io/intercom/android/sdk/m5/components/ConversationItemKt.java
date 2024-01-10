package io.intercom.android.sdk.m5.components;

import android.content.Context;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.SurfaceKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.Ticket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a7\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0001¢\u0006\u0002\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002\u001a\b\u0010\u0016\u001a\u00020\u0017H\u0002\u001a\b\u0010\u0018\u001a\u00020\u0017H\u0002\u001a\u0014\u0010\u0019\u001a\u00020\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0003¨\u0006\u001c"}, d2 = {"ConversationCardPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "ConversationItem", "modifier", "Landroidx/compose/ui/Modifier;", "conversation", "Lio/intercom/android/sdk/models/Conversation;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/models/Conversation;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ConversationUnreadIndicator", "ConversationWithInProgressTicketCardPreview", "ConversationWithResolvedTicketCardPreview", "ConversationWithSubmittedTicketCardPreview", "ConversationWithWaitingOnCustomerTicketCardPreview", "UnreadConversationCardPreview", "getActiveAdminsAvatars", "", "Lio/intercom/android/sdk/models/Avatar;", "getUserIntercomId", "", "getWorkspaceName", "sampleConversation", "ticket", "Lio/intercom/android/sdk/models/Ticket;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConversationItem.kt */
public final class ConversationItemKt {
    public static final void ConversationItem(Modifier modifier, Conversation conversation, PaddingValues paddingValues, Function0<Unit> function0, Composer composer, int i, int i2) {
        Modifier modifier2;
        Conversation conversation2 = conversation;
        Function0<Unit> function02 = function0;
        Intrinsics.checkNotNullParameter(conversation2, "conversation");
        Intrinsics.checkNotNullParameter(function02, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(508164065);
        if ((i2 & 1) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        PaddingValues r3 = (i2 & 4) != 0 ? PaddingKt.m503PaddingValues0680j_4(Dp.m4704constructorimpl((float) 0)) : paddingValues;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Context context = (Context) consume;
        Modifier modifier3 = Modifier.Companion;
        startRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed((Object) function02);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new ConversationItemKt$ConversationItem$1$1(function02);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        SurfaceKt.m1419SurfaceFjzlyU(ClickableKt.m196clickableXHw0xAI$default(modifier3, false, (String) null, (Role) null, (Function0) rememberedValue, 7, (Object) null), (Shape) null, 0, 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -1975085275, true, new ConversationItemKt$ConversationItem$2(modifier2, r3, conversation2, context)), startRestartGroup, 1572864, 62);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ConversationItemKt$ConversationItem$3(modifier2, conversation, r3, function0, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final List<Avatar> getActiveAdminsAvatars() {
        List<Participant> activeAdmins = Injector.get().getStore().state().teamPresence().getActiveAdmins();
        Intrinsics.checkNotNullExpressionValue(activeAdmins, "get().store.state().teamPresence().activeAdmins");
        Iterable<Participant> take = CollectionsKt.take(activeAdmins, 3);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
        for (Participant avatar : take) {
            arrayList.add(avatar.getAvatar());
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public static final String getWorkspaceName() {
        String name = Injector.get().getAppConfigProvider().get().getName();
        Intrinsics.checkNotNullExpressionValue(name, "get().appConfigProvider.get().name");
        return name;
    }

    /* access modifiers changed from: private */
    public static final String getUserIntercomId() {
        if (Injector.isNotInitialised()) {
            return "";
        }
        String intercomId = Injector.get().getUserIdentity().getIntercomId();
        Intrinsics.checkNotNullExpressionValue(intercomId, "get().userIdentity.intercomId");
        return intercomId;
    }

    public static final void ConversationUnreadIndicator(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-846398541);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            float f = (float) 16;
            Modifier r0 = SizeKt.m582size3ABfNKs(PaddingKt.m510padding3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl(f)), Dp.m4704constructorimpl(f));
            Alignment center = Alignment.Companion.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r0);
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
            Composer r5 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r5, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r5, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r5, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r5, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            CanvasKt.Canvas(SizeKt.m582size3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 8)), ConversationItemKt$ConversationUnreadIndicator$1$1.INSTANCE, startRestartGroup, 54);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ConversationItemKt$ConversationUnreadIndicator$2(i));
        }
    }

    public static final void ConversationCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(825009083);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ConversationItemKt.INSTANCE.m5140getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ConversationItemKt$ConversationCardPreview$1(i));
        }
    }

    public static final void ConversationWithSubmittedTicketCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1287089062);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ConversationItemKt.INSTANCE.m5141getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ConversationItemKt$ConversationWithSubmittedTicketCardPreview$1(i));
        }
    }

    public static final void ConversationWithResolvedTicketCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1748193317);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ConversationItemKt.INSTANCE.m5142getLambda3$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ConversationItemKt$ConversationWithResolvedTicketCardPreview$1(i));
        }
    }

    public static final void ConversationWithInProgressTicketCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-773841825);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ConversationItemKt.INSTANCE.m5143getLambda4$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ConversationItemKt$ConversationWithInProgressTicketCardPreview$1(i));
        }
    }

    public static final void ConversationWithWaitingOnCustomerTicketCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(341544617);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ConversationItemKt.INSTANCE.m5144getLambda5$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ConversationItemKt$ConversationWithWaitingOnCustomerTicketCardPreview$1(i));
        }
    }

    public static final void UnreadConversationCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1292079862);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ConversationItemKt.INSTANCE.m5145getLambda6$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ConversationItemKt$UnreadConversationCardPreview$1(i));
        }
    }

    static /* synthetic */ Conversation sampleConversation$default(Ticket ticket, int i, Object obj) {
        if ((i & 1) != 0) {
            ticket = null;
        }
        return sampleConversation(ticket);
    }

    /* access modifiers changed from: private */
    public static final Conversation sampleConversation(Ticket ticket) {
        Conversation.Builder withParts = new Conversation.Builder().withId("123").withLastParticipatingAdmin(new LastParticipatingAdmin.Builder().withFirstName("Santhosh Kumar").withAvatar(new Avatar.Builder().withInitials("SK"))).withParts(CollectionsKt.listOf(new Part.Builder().withSummary("This is the last message received/sent to/from this user").withCreatedAt(1659081886)));
        if (ticket != null) {
            withParts.withTicket(ticket);
        }
        Conversation build = withParts.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
