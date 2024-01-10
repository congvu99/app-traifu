package io.intercom.android.sdk.m5.components;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
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
import io.intercom.android.sdk.m5.IntercomTheme;
import io.intercom.android.sdk.m5.home.data.HomeCards;
import io.intercom.android.sdk.m5.home.data.SuggestedArticle;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.utilities.ColorExtensionsKt;
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
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SearchBrowseCard.kt */
final class SearchBrowseCardKt$SearchBrowseCard$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $accessToTeammateEnabled;
    final /* synthetic */ List<Avatar> $avatars;
    final /* synthetic */ Context $context;
    final /* synthetic */ HomeCards.HomeHelpCenterData $helpCenterData;
    final /* synthetic */ boolean $isSearchFirstEnabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBrowseCardKt$SearchBrowseCard$1(boolean z, HomeCards.HomeHelpCenterData homeHelpCenterData, boolean z2, Context context, List<? extends Avatar> list) {
        super(2);
        this.$isSearchFirstEnabled = z;
        this.$helpCenterData = homeHelpCenterData;
        this.$accessToTeammateEnabled = z2;
        this.$context = context;
        this.$avatars = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        float f;
        int i2;
        long j;
        String str;
        String str2;
        String str3;
        int i3;
        String str4;
        Object obj;
        float f2;
        int i4;
        Object obj2;
        Composer composer2 = composer;
        if ((i & 11) != 2 || !composer.getSkipping()) {
            boolean z = this.$isSearchFirstEnabled || (this.$helpCenterData.getSuggestedArticles().isEmpty() ^ true);
            HomeCards.HomeHelpCenterData homeHelpCenterData = this.$helpCenterData;
            boolean z2 = this.$isSearchFirstEnabled;
            boolean z3 = this.$accessToTeammateEnabled;
            Context context = this.$context;
            List<Avatar> list = this.$avatars;
            composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            HomeCards.HomeHelpCenterData homeHelpCenterData2 = homeHelpCenterData;
            boolean z4 = z2;
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
            Composer r10 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r10, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r10, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r10, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r10, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation(composer2, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion = Modifier.Companion;
            if (z) {
                f = Dp.m4704constructorimpl((float) 8);
                i2 = 0;
            } else {
                i2 = 0;
                f = Dp.m4704constructorimpl((float) 0);
            }
            float f3 = (float) i2;
            float r3 = Dp.m4704constructorimpl(f3);
            float r13 = z ? Dp.m4704constructorimpl((float) 8) : Dp.m4704constructorimpl(f3);
            if (z) {
                f3 = (float) 8;
            }
            Modifier clip = ClipKt.clip(PaddingKt.m513paddingqDBjuR0(companion, r13, f, Dp.m4704constructorimpl(f3), r3), MaterialTheme.INSTANCE.getShapes(composer2, 8).getMedium());
            composer2.startReplaceableGroup(-1235841786);
            if (z) {
                j = Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 8).m1213getOnSurface0d7_KjU(), 0.05f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            } else {
                j = Color.Companion.m1967getTransparent0d7_KjU();
            }
            composer.endReplaceableGroup();
            Modifier r2 = ClickableKt.m196clickableXHw0xAI$default(BackgroundKt.m177backgroundbw27NRU$default(clip, j, (Shape) null, 2, (Object) null), false, (String) null, (Role) null, new SearchBrowseCardKt$SearchBrowseCard$1$1$1(context), 7, (Object) null);
            composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r2);
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
            Composer r0 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r0, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r0, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r0, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r0, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Modifier r02 = PaddingKt.m511paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m4704constructorimpl(z ? (float) 8 : (float) 16), Dp.m4704constructorimpl(z ? (float) 12 : (float) 20));
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer2, 54);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7 = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density3 = (Density) consume7;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume8 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(r02);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor3);
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
            materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation(composer2, "C80@4021L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = 16;
            String str5 = "C80@4021L9:Row.kt#2w3rfo";
            String str6 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo";
            List<Avatar> list2 = list;
            Context context2 = context;
            boolean z5 = z3;
            String str7 = "C79@4027L9:Column.kt#2w3rfo";
            String str8 = "C:CompositionLocal.kt#9igjgp";
            boolean z6 = z4;
            String str9 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo";
            String str10 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
            TextKt.m1496TextfLXpl1I(StringResources_androidKt.stringResource(R.string.intercom_search_for_help, composer2, 0), (Modifier) null, 0, 0, (FontStyle) null, FontWeight.Companion.getSemiBold(), (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 196608, 0, 65502);
            Composer composer3 = composer;
            int i6 = 0;
            IconKt.m1313Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.intercom_gif_search_icon, composer3, 0), (String) null, SizeKt.m582size3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 16)), IntercomTheme.INSTANCE.m5118getColorOnWhite0d7_KjU$intercom_sdk_base_release(), composer, 440, 0);
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
            List<SuggestedArticle> suggestedArticles = homeHelpCenterData2.getSuggestedArticles();
            composer3.startReplaceableGroup(-1235840033);
            Collection collection = suggestedArticles;
            int i7 = 1;
            int i8 = 48;
            if (!collection.isEmpty()) {
                composer3.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(composer3, str6);
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
                int i9 = -1323940314;
                composer3.startReplaceableGroup(-1323940314);
                String str11 = str10;
                ComposerKt.sourceInformation(composer3, str11);
                String str12 = str8;
                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str12);
                Object consume10 = composer3.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer);
                Density density4 = (Density) consume10;
                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str12);
                Object consume11 = composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutDirection layoutDirection4 = (LayoutDirection) consume11;
                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str12);
                Object consume12 = composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(composer);
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) consume12;
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(Modifier.Companion);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer3.createNode(constructor4);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Composer r7 = Updater.m1543constructorimpl(composer);
                Updater.m1550setimpl(r7, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1550setimpl(r7, density4, ComposeUiNode.Companion.getSetDensity());
                Updater.m1550setimpl(r7, layoutDirection4, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1550setimpl(r7, viewConfiguration4, ComposeUiNode.Companion.getSetViewConfiguration());
                composer.enableReusing();
                materializerOf4.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer3, 0);
                int i10 = 2058660585;
                composer3.startReplaceableGroup(2058660585);
                composer3.startReplaceableGroup(-1163856341);
                ComposerKt.sourceInformation(composer3, str7);
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                composer3.startReplaceableGroup(-572342444);
                if (!collection.isEmpty()) {
                    obj2 = null;
                    EffectsKt.LaunchedEffect((Object) "", (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SearchBrowseCardKt$SearchBrowseCard$1$1$3$1(suggestedArticles, (Continuation<? super SearchBrowseCardKt$SearchBrowseCard$1$1$3$1>) null), composer3, 70);
                } else {
                    obj2 = null;
                }
                composer.endReplaceableGroup();
                int i11 = 0;
                for (Object next : suggestedArticles) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    SuggestedArticle suggestedArticle = (SuggestedArticle) next;
                    Context context3 = context2;
                    float f4 = (float) i5;
                    float f5 = (float) 8;
                    Modifier r22 = PaddingKt.m514paddingqDBjuR0$default(ClickableKt.m196clickableXHw0xAI$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, i7, obj2), false, (String) null, (Role) null, new SearchBrowseCardKt$SearchBrowseCard$1$1$3$2$1(suggestedArticle, context3), 7, (Object) null), Dp.m4704constructorimpl(f4), Dp.m4704constructorimpl(f5), 0.0f, Dp.m4704constructorimpl(f5), 4, (Object) null);
                    Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                    composer3.startReplaceableGroup(693286680);
                    String str13 = str9;
                    ComposerKt.sourceInformation(composer3, str13);
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer3, i8);
                    composer3.startReplaceableGroup(i9);
                    ComposerKt.sourceInformation(composer3, str11);
                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str12);
                    Object consume13 = composer3.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    Density density5 = (Density) consume13;
                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str12);
                    Object consume14 = composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    LayoutDirection layoutDirection5 = (LayoutDirection) consume14;
                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str12);
                    Object consume15 = composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ViewConfiguration viewConfiguration5 = (ViewConfiguration) consume15;
                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf5 = LayoutKt.materializerOf(r22);
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer3.createNode(constructor5);
                    } else {
                        composer.useNode();
                    }
                    composer.disableReusing();
                    Composer r102 = Updater.m1543constructorimpl(composer);
                    Updater.m1550setimpl(r102, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m1550setimpl(r102, density5, ComposeUiNode.Companion.getSetDensity());
                    Updater.m1550setimpl(r102, layoutDirection5, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m1550setimpl(r102, viewConfiguration5, ComposeUiNode.Companion.getSetViewConfiguration());
                    composer.enableReusing();
                    materializerOf5.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer3, Integer.valueOf(i6));
                    composer3.startReplaceableGroup(i10);
                    composer3.startReplaceableGroup(-678309503);
                    String str14 = str5;
                    ComposerKt.sourceInformation(composer3, str14);
                    TextKt.m1496TextfLXpl1I(suggestedArticle.getTitle(), RowScope.CC.weight$default(RowScopeInstance.INSTANCE, Modifier.Companion, 1.0f, false, 2, (Object) null), 0, 0, (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m4591getEllipsisgIe3tQ8(), false, 2, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 196608, 3120, 55260);
                    composer3 = composer;
                    IntercomChevronKt.IntercomChevron(composer3, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl(f4)), composer3, 6);
                    str9 = str13;
                    i11 = i12;
                    context2 = context3;
                    str12 = str12;
                    str11 = str11;
                    str5 = str14;
                    i5 = 16;
                    obj2 = null;
                    i10 = 2058660585;
                    i9 = -1323940314;
                    i8 = 48;
                    i7 = 1;
                    i6 = 0;
                }
                str3 = str12;
                str2 = str11;
                str = str5;
                str4 = str9;
                i3 = 0;
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else {
                str = str5;
                str3 = str8;
                str4 = str9;
                str2 = str10;
                i3 = 0;
            }
            composer.endReplaceableGroup();
            if (z6 && z5) {
                composer3.startReplaceableGroup(-1235837688);
                if (!collection.isEmpty()) {
                    i4 = 16;
                    f2 = 0.0f;
                    obj = null;
                    IntercomDividerKt.IntercomDivider(PaddingKt.m512paddingVpY3zN4$default(Modifier.Companion, Dp.m4704constructorimpl((float) 16), 0.0f, 2, (Object) null), composer3, 6, i3);
                } else {
                    i4 = 16;
                    f2 = 0.0f;
                    obj = null;
                }
                composer.endReplaceableGroup();
                Modifier r23 = PaddingKt.m511paddingVpY3zN4(Modifier.Companion, Dp.m4704constructorimpl((float) i4), Dp.m4704constructorimpl((float) 12));
                Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
                composer3.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(composer3, str4);
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composer3, 48);
                composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer3, str2);
                String str15 = str3;
                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str15);
                Object consume16 = composer3.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer);
                Density density6 = (Density) consume16;
                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str15);
                Object consume17 = composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutDirection layoutDirection6 = (LayoutDirection) consume17;
                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str15);
                Object consume18 = composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(composer);
                ViewConfiguration viewConfiguration6 = (ViewConfiguration) consume18;
                Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf6 = LayoutKt.materializerOf(r23);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer3.createNode(constructor6);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Composer r6 = Updater.m1543constructorimpl(composer);
                Updater.m1550setimpl(r6, rowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1550setimpl(r6, density6, ComposeUiNode.Companion.getSetDensity());
                Updater.m1550setimpl(r6, layoutDirection6, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1550setimpl(r6, viewConfiguration6, ComposeUiNode.Companion.getSetViewConfiguration());
                composer.enableReusing();
                materializerOf6.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer3, Integer.valueOf(i3));
                composer3.startReplaceableGroup(2058660585);
                composer3.startReplaceableGroup(-678309503);
                ComposerKt.sourceInformation(composer3, str);
                TextKt.m1496TextfLXpl1I(StringResources_androidKt.stringResource(R.string.intercom_the_team_can_help_if_needed, composer3, i3), RowScope.CC.weight$default(RowScopeInstance.INSTANCE, Modifier.Companion, 1.0f, false, 2, (Object) null), 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer3, 8).getBody2(), ColorExtensionsKt.toComposeColor$default("#757575", f2, 1, obj), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), composer, 0, 0, 32764);
                AvatarGroupKt.m5121AvatarGroupJ8mCjc(CollectionsKt.take(list2, 3), (Modifier) null, Dp.m4704constructorimpl((float) 24), 0, composer, 392, 10);
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
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
