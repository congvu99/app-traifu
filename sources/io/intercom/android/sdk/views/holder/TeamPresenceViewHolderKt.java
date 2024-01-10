package io.intercom.android.sdk.views.holder;

import android.content.Context;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.InlineTextContentKt;
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
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
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
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.IntercomTheme;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.components.AvatarGroupKt;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.SocialAccount;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001aL\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000\u001a*\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¨\u0006\u001c"}, d2 = {"GroupParticipantsAvatars", "", "groupParticipants", "Lio/intercom/android/sdk/views/holder/GroupParticipants;", "(Lio/intercom/android/sdk/views/holder/GroupParticipants;Landroidx/compose/runtime/Composer;I)V", "TeamPresenceAvatarPreview", "(Landroidx/compose/runtime/Composer;I)V", "TeamPresenceAvatars", "teamPresenceState", "Lio/intercom/android/sdk/views/holder/TeamPresenceState;", "(Lio/intercom/android/sdk/views/holder/TeamPresenceState;Landroidx/compose/runtime/Composer;I)V", "TeamPresenceAvatarsPreview", "TeamPresenceBioAndTwitterPreview", "TeamPresenceGroupParticipantsPreview", "getAdminTeamPresence", "avatar", "Lio/intercom/android/sdk/models/Avatar;", "name", "", "jobTitle", "cityName", "countryName", "userBio", "twitter", "Lio/intercom/android/sdk/models/SocialAccount;", "getBotTeamPresence", "intro", "getLocationName", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TeamPresenceViewHolder.kt */
public final class TeamPresenceViewHolderKt {
    public static final TeamPresenceState getAdminTeamPresence(Avatar avatar, String str, String str2, String str3, String str4, String str5, GroupParticipants groupParticipants, SocialAccount socialAccount) {
        String str6 = str2;
        Avatar avatar2 = avatar;
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "jobTitle");
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str3, "cityName");
        Intrinsics.checkNotNullParameter(str4, "countryName");
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str8, "userBio");
        List listOf = CollectionsKt.listOf(avatar);
        return new TeamPresenceState(listOf, str, (String) null, str8, StringsKt.removeSuffix(StringsKt.removePrefix(str2 + " • " + getLocationName(str3, str4), (CharSequence) " • "), (CharSequence) " • "), groupParticipants, socialAccount, 4, (DefaultConstructorMarker) null);
    }

    public static final TeamPresenceState getBotTeamPresence(Avatar avatar, String str, String str2, GroupParticipants groupParticipants) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "intro");
        return new TeamPresenceState(CollectionsKt.listOf(avatar), str, str2, (String) null, (String) null, groupParticipants, (SocialAccount) null, 88, (DefaultConstructorMarker) null);
    }

    private static final String getLocationName(String str, String str2) {
        return StringsKt.removeSuffix(StringsKt.removePrefix(str + ", " + str2, (CharSequence) ", "), (CharSequence) ", ");
    }

    /* access modifiers changed from: private */
    public static final void TeamPresenceAvatars(TeamPresenceState teamPresenceState, Composer composer, int i) {
        float f;
        String str;
        int i2;
        TeamPresenceState teamPresenceState2 = teamPresenceState;
        Composer startRestartGroup = composer.startRestartGroup(-1357169404);
        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
        Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
        float f2 = (float) 16;
        Modifier r4 = PaddingKt.m512paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m4704constructorimpl(f2), 0.0f, 2, (Object) null);
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, startRestartGroup, 54);
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
        AvatarGroupKt.m5121AvatarGroupJ8mCjc(CollectionsKt.take(teamPresenceState.getAvatars(), 3), (Modifier) null, Dp.m4704constructorimpl((float) 64), TextUnitKt.getSp(24), startRestartGroup, 3464, 2);
        startRestartGroup.startReplaceableGroup(574565242);
        CharSequence title = teamPresenceState.getTitle();
        if (!(title == null || title.length() == 0)) {
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 8)), startRestartGroup, 6);
            str = "C:CompositionLocal.kt#9igjgp";
            f = f2;
            TextKt.m1496TextfLXpl1I(teamPresenceState.getTitle(), (Modifier) null, 0, 0, (FontStyle) null, FontWeight.Companion.getSemiBold(), (FontFamily) null, 0, (TextDecoration) null, TextAlign.m4547boximpl(TextAlign.Companion.m4554getCentere0LSkKk()), 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getSubtitle1(), startRestartGroup, 196608, 0, 32222);
        } else {
            str = "C:CompositionLocal.kt#9igjgp";
            f = f2;
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(574565596);
        CharSequence subtitle = teamPresenceState.getSubtitle();
        if (!(subtitle == null || subtitle.length() == 0)) {
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 8)), startRestartGroup, 6);
            TextKt.m1496TextfLXpl1I(teamPresenceState.getSubtitle(), (Modifier) null, ColorKt.Color(4285887861L), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m4547boximpl(TextAlign.Companion.m4554getCentere0LSkKk()), 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2(), startRestartGroup, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 0, 32250);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(574565945);
        CharSequence userBio = teamPresenceState.getUserBio();
        if (!(userBio == null || userBio.length() == 0)) {
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 8)), startRestartGroup, 6);
            TextKt.m1496TextfLXpl1I('\"' + teamPresenceState.getUserBio() + '\"', (Modifier) null, ColorKt.Color(4285887861L), 0, FontStyle.m4305boximpl(FontStyle.Companion.m4312getItalic_LCdwA()), (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m4547boximpl(TextAlign.Companion.m4554getCentere0LSkKk()), 0, TextOverflow.Companion.m4591getEllipsisgIe3tQ8(), false, 2, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2(), startRestartGroup, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 3120, 21994);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(574566427);
        CharSequence caption = teamPresenceState.getCaption();
        if (!(caption == null || caption.length() == 0)) {
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 8)), startRestartGroup, 6);
            TextKt.m1496TextfLXpl1I(teamPresenceState.getCaption(), SemanticsModifierKt.semantics$default(Modifier.Companion, false, new TeamPresenceViewHolderKt$TeamPresenceAvatars$1$1(teamPresenceState2), 1, (Object) null), ColorKt.Color(4285756278L), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m4547boximpl(TextAlign.Companion.m4554getCentere0LSkKk()), 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2(), startRestartGroup, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 0, 32248);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(574566930);
        if (teamPresenceState.getTwitter() == null || Intrinsics.areEqual((Object) teamPresenceState.getTwitter(), (Object) SocialAccount.NULL)) {
            i2 = 6;
        } else {
            i2 = 6;
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl(f)), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str);
            Object consume4 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume4;
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.intercom_twitter, startRestartGroup, 0);
            long r5 = IntercomTheme.INSTANCE.m5118getColorOnWhite0d7_KjU$intercom_sdk_base_release();
            Modifier r11 = SizeKt.m582size3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl(f));
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            IconKt.m1313Iconww6aTOc(painterResource, "Twitter", ClickableKt.m194clickableO2vRcR0$default(r11, (MutableInteractionSource) rememberedValue, (Indication) null, false, (String) null, (Role) null, new TeamPresenceViewHolderKt$TeamPresenceAvatars$1$3(teamPresenceState2, context), 28, (Object) null), r5, startRestartGroup, 56, 0);
        }
        startRestartGroup.endReplaceableGroup();
        GroupParticipants groupParticipants = teamPresenceState.getGroupParticipants();
        if (groupParticipants != null) {
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 20)), startRestartGroup, i2);
            GroupParticipantsAvatars(groupParticipants, startRestartGroup, 8);
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TeamPresenceViewHolderKt$TeamPresenceAvatars$2(teamPresenceState2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void GroupParticipantsAvatars(GroupParticipants groupParticipants, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(200743529);
        int i3 = 0;
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
        Iterator it = groupParticipants.getAvatars().iterator();
        int i4 = 0;
        while (true) {
            i2 = 2;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Avatar avatar = (Avatar) next;
            InlineTextContentKt.appendInlineContent$default(builder, "inlineContentId" + i4, (String) null, 2, (Object) null);
            builder.append(" ");
            i4 = i5;
        }
        builder.append(groupParticipants.getTitle());
        AnnotatedString annotatedString = builder.toAnnotatedString();
        Iterable avatars = groupParticipants.getAvatars();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(avatars, 10));
        for (Object next2 : avatars) {
            int i6 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            long em = TextUnitKt.getEm(i2);
            long em2 = TextUnitKt.getEm(i2);
            Placeholder placeholder = r12;
            Placeholder placeholder2 = new Placeholder(em, em2, PlaceholderVerticalAlign.Companion.m4160getCenterJ6kI3mc(), (DefaultConstructorMarker) null);
            arrayList.add(new Pair("inlineContentId" + i3, new InlineTextContent(placeholder, ComposableLambdaKt.composableLambda(startRestartGroup, -421804820, true, new TeamPresenceViewHolderKt$GroupParticipantsAvatars$inlineContent$1$1((Avatar) next2)))));
            i3 = i6;
            i2 = 2;
        }
        Map map = MapsKt.toMap((List) arrayList);
        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2();
        TextKt.m1495Text4IGK_g(annotatedString, (Modifier) null, ColorKt.Color(4285756278L), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m4547boximpl(TextAlign.Companion.m4554getCentere0LSkKk()), TextUnitKt.getEm(2), 0, false, 0, map, (Function1<? super TextLayoutResult, Unit>) null, body2, startRestartGroup, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 32774, 47610);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TeamPresenceViewHolderKt$GroupParticipantsAvatars$1(groupParticipants, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void TeamPresenceAvatarPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1021731958);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TeamPresenceViewHolderKt.INSTANCE.m5417getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TeamPresenceViewHolderKt$TeamPresenceAvatarPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void TeamPresenceAvatarsPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-559976299);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TeamPresenceViewHolderKt.INSTANCE.m5419getLambda4$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TeamPresenceViewHolderKt$TeamPresenceAvatarsPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void TeamPresenceGroupParticipantsPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(250461360);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TeamPresenceViewHolderKt.INSTANCE.m5421getLambda6$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TeamPresenceViewHolderKt$TeamPresenceGroupParticipantsPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void TeamPresenceBioAndTwitterPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-696135477);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TeamPresenceViewHolderKt.INSTANCE.m5423getLambda8$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TeamPresenceViewHolderKt$TeamPresenceBioAndTwitterPreview$1(i));
        }
    }
}
