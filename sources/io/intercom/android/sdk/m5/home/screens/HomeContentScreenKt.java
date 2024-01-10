package io.intercom.android.sdk.m5.home.screens;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.components.ConversationHistoryCardKt;
import io.intercom.android.sdk.m5.components.SearchBrowseCardKt;
import io.intercom.android.sdk.m5.home.components.ExternalLinkCardKt;
import io.intercom.android.sdk.m5.home.components.LegacyMessengerAppCardKt;
import io.intercom.android.sdk.m5.home.components.NewConversationCardKt;
import io.intercom.android.sdk.m5.home.components.SpacesCardKt;
import io.intercom.android.sdk.m5.home.data.HomeCards;
import io.intercom.android.sdk.m5.home.viewmodel.HomeViewState;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Participant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ae\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0001¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"HomeContentScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState$Content;", "onMessagesClicked", "Lkotlin/Function0;", "onHelpClicked", "onNewConversationClicked", "onConversationClick", "Lkotlin/Function1;", "Lio/intercom/android/sdk/models/Conversation;", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState$Content;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "HomeM5ContentScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeContentScreen.kt */
public final class HomeContentScreenKt {
    public static final void HomeContentScreen(Modifier modifier, HomeViewState.Content content, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function1<? super Conversation, Unit> function1, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(63917653);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.Companion : modifier;
        Function0<Unit> function04 = (i2 & 4) != 0 ? HomeContentScreenKt$HomeContentScreen$1.INSTANCE : function0;
        Function0<Unit> function05 = (i2 & 8) != 0 ? HomeContentScreenKt$HomeContentScreen$2.INSTANCE : function02;
        Function0<Unit> function06 = (i2 & 16) != 0 ? HomeContentScreenKt$HomeContentScreen$3.INSTANCE : function03;
        Function1<? super Conversation, Unit> function12 = (i2 & 32) != 0 ? HomeContentScreenKt$HomeContentScreen$4.INSTANCE : function1;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Context context = (Context) consume;
        float f = (float) 16;
        Modifier r3 = PaddingKt.m514paddingqDBjuR0$default(modifier2, Dp.m4704constructorimpl(f), 0.0f, Dp.m4704constructorimpl(f), 0.0f, 10, (Object) null);
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m407spacedBy0680j_4(Dp.m4704constructorimpl((float) 12)), Alignment.Companion.getStart(), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density = (Density) consume2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) consume3;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume4;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r3);
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
        int i3 = 0;
        for (Object next : content.getCards()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            HomeCards homeCards = (HomeCards) next;
            if (homeCards instanceof HomeCards.HomeSpacesData) {
                startRestartGroup.startReplaceableGroup(343269391);
                HomeCards.HomeSpacesData homeSpacesData = (HomeCards.HomeSpacesData) homeCards;
                startRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean changed = startRestartGroup.changed((Object) function04) | startRestartGroup.changed((Object) function05);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new HomeContentScreenKt$HomeContentScreen$5$1$1$1(function04, function05);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                SpacesCardKt.SpacesCard(homeSpacesData, (Function1) rememberedValue, startRestartGroup, 8);
                startRestartGroup.endReplaceableGroup();
            } else if (homeCards instanceof HomeCards.HomeRecentConversationData) {
                startRestartGroup.startReplaceableGroup(343269851);
                HomeCards.HomeRecentConversationData homeRecentConversationData = (HomeCards.HomeRecentConversationData) homeCards;
                if (!homeRecentConversationData.getConversations().isEmpty()) {
                    Iterable<Conversation.Builder> conversations = homeRecentConversationData.getConversations();
                    Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(conversations, 10));
                    for (Conversation.Builder build : conversations) {
                        arrayList.add(build.build());
                    }
                    ConversationHistoryCardKt.ConversationHistoryCard((Modifier) null, homeCards.getCardTitle(), (List) arrayList, function12, startRestartGroup, ((i >> 6) & 7168) | 512, 1);
                }
                startRestartGroup.endReplaceableGroup();
            } else if (homeCards instanceof HomeCards.HomeNewConversationData) {
                startRestartGroup.startReplaceableGroup(343270298);
                NewConversationCardKt.NewConversationCard((HomeCards.HomeNewConversationData) homeCards, function06, startRestartGroup, ((i >> 9) & 112) | 8);
                startRestartGroup.endReplaceableGroup();
            } else if (homeCards instanceof HomeCards.HomeHelpCenterData) {
                startRestartGroup.startReplaceableGroup(343270552);
                Integer valueOf = Integer.valueOf(i3);
                startRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                boolean changed2 = startRestartGroup.changed((Object) valueOf);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new HomeContentScreenKt$HomeContentScreen$5$1$3$1(i3, (Continuation<? super HomeContentScreenKt$HomeContentScreen$5$1$3$1>) null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect((Object) "", (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, startRestartGroup, 70);
                HomeCards.HomeHelpCenterData homeHelpCenterData = (HomeCards.HomeHelpCenterData) homeCards;
                boolean isHelpCenterRequireSearchEnabled = Injector.get().getAppConfigProvider().get().isHelpCenterRequireSearchEnabled();
                List<Participant> activeAdmins = Injector.get().getStore().state().teamPresence().getActiveAdmins();
                Intrinsics.checkNotNullExpressionValue(activeAdmins, "get().store.state()\n    …amPresence().activeAdmins");
                Iterable<Participant> iterable = activeAdmins;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Participant avatar : iterable) {
                    arrayList2.add(avatar.getAvatar());
                }
                SearchBrowseCardKt.SearchBrowseCard(homeHelpCenterData, isHelpCenterRequireSearchEnabled, (List) arrayList2, Injector.get().getAppConfigProvider().get().isAccessToTeammateEnabled(), startRestartGroup, 520);
                startRestartGroup.endReplaceableGroup();
            } else if (homeCards instanceof HomeCards.HomeExternalLinkData) {
                startRestartGroup.startReplaceableGroup(343271342);
                ExternalLinkCardKt.ExternalLinkCard((HomeCards.HomeExternalLinkData) homeCards, startRestartGroup, 8);
                startRestartGroup.endReplaceableGroup();
            } else if (homeCards instanceof HomeCards.HomeMessengerAppData) {
                startRestartGroup.startReplaceableGroup(343271477);
                LegacyMessengerAppCardKt.LegacyMessengerAppCard(((HomeCards.HomeMessengerAppData) homeCards).getFallbackUrl(), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(343271582);
                startRestartGroup.endReplaceableGroup();
            }
            i3 = i4;
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HomeContentScreenKt$HomeContentScreen$6(modifier2, content, function04, function05, function06, function12, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void HomeM5ContentScreenPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-868613686);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$HomeContentScreenKt.INSTANCE.m5218getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HomeContentScreenKt$HomeM5ContentScreenPreview$1(i));
        }
    }
}
