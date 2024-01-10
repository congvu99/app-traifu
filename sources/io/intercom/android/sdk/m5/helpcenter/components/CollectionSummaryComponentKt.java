package io.intercom.android.sdk.m5.helpcenter.components;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.material.Colors;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.helpcenter.collections.CollectionViewState;
import io.intercom.android.sdk.helpcenter.sections.Author;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.components.AvatarGroupKt;
import io.intercom.android.sdk.m5.components.IntercomDividerKt;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.utilities.Phrase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\b\u001a\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¨\u0006\u0010"}, d2 = {"CollectionSummaryComponent", "", "state", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Content$CollectionContent;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Content$CollectionContent;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CollectionSummaryComponentPreview", "(Landroidx/compose/runtime/Composer;I)V", "constructByAuthorsText", "", "context", "Landroid/content/Context;", "authors", "", "Lio/intercom/android/sdk/helpcenter/sections/Author;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: CollectionSummaryComponent.kt */
public final class CollectionSummaryComponentKt {
    public static final void CollectionSummaryComponent(CollectionViewState.Content.CollectionContent collectionContent, Modifier modifier, Composer composer, int i, int i2) {
        CollectionViewState.Content.CollectionContent collectionContent2 = collectionContent;
        int i3 = i2;
        Intrinsics.checkNotNullParameter(collectionContent2, "state");
        Composer startRestartGroup = composer.startRestartGroup(60022900);
        Modifier modifier2 = (i3 & 2) != 0 ? Modifier.Companion : modifier;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier r3 = BackgroundKt.m177backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1218getSurface0d7_KjU(), (Shape) null, 2, (Object) null);
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
        Modifier modifier3 = modifier2;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Context context = (Context) consume;
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
        Modifier r32 = PaddingKt.m510padding3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 16));
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density2 = (Density) consume5;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection2 = (LayoutDirection) consume6;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume7;
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r32);
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
        Composer r82 = Updater.m1543constructorimpl(startRestartGroup);
        Updater.m1550setimpl(r82, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1550setimpl(r82, density2, ComposeUiNode.Companion.getSetDensity());
        Updater.m1550setimpl(r82, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1550setimpl(r82, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1163856341);
        ComposerKt.sourceInformation(startRestartGroup, "C79@4027L9:Column.kt#2w3rfo");
        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
        String str = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo";
        String str2 = "C79@4027L9:Column.kt#2w3rfo";
        Context context2 = context;
        String str3 = "C:CompositionLocal.kt#9igjgp";
        String str4 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
        Modifier modifier4 = modifier3;
        TextKt.m1496TextfLXpl1I(collectionContent.getTitle(), (Modifier) null, MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0, (FontStyle) null, FontWeight.Companion.getSemiBold(), (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getSubtitle1(), startRestartGroup, 196608, 0, 32730);
        startRestartGroup.startReplaceableGroup(1133299338);
        if (!StringsKt.isBlank(collectionContent.getSummary())) {
            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 4)), startRestartGroup, 6);
            TextKt.m1496TextfLXpl1I(collectionContent.getSummary(), (Modifier) null, MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2(), startRestartGroup, 0, 0, 32762);
        }
        startRestartGroup.endReplaceableGroup();
        SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 20)), startRestartGroup, 6);
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), centerVertically, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        String str5 = str4;
        ComposerKt.sourceInformation(startRestartGroup, str5);
        String str6 = str3;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str6);
        Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density3 = (Density) consume8;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str6);
        Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection3 = (LayoutDirection) consume9;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str6);
        Object consume10 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume10;
        Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(fillMaxWidth$default);
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
        Composer r12 = Updater.m1543constructorimpl(startRestartGroup);
        Updater.m1550setimpl(r12, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1550setimpl(r12, density3, ComposeUiNode.Companion.getSetDensity());
        Updater.m1550setimpl(r12, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1550setimpl(r12, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-678309503);
        ComposerKt.sourceInformation(startRestartGroup, "C80@4021L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation(startRestartGroup, str);
        MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, str5);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str6);
        Object consume11 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density4 = (Density) consume11;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str6);
        Object consume12 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection4 = (LayoutDirection) consume12;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str6);
        Object consume13 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration4 = (ViewConfiguration) consume13;
        Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(Modifier.Companion);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor4);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r9 = Updater.m1543constructorimpl(startRestartGroup);
        Updater.m1550setimpl(r9, columnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1550setimpl(r9, density4, ComposeUiNode.Companion.getSetDensity());
        Updater.m1550setimpl(r9, layoutDirection4, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1550setimpl(r9, viewConfiguration4, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf4.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1163856341);
        ComposerKt.sourceInformation(startRestartGroup, str2);
        ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
        ArticleCountComponentKt.ArticleCountComponent((Modifier) null, collectionContent.getArticlesCount(), startRestartGroup, 0, 1);
        TextKt.m1496TextfLXpl1I(constructByAuthorsText(context2, collectionContent.getAuthors()), (Modifier) null, ColorKt.Color(4285887861L), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m4591getEllipsisgIe3tQ8(), false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2(), startRestartGroup, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 48, 30714);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        Iterable<Author> take = CollectionsKt.take(collectionContent.getAuthors(), 3);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
        for (Author author : take) {
            arrayList.add(Avatar.create(author.getAvatar().getImageUrl(), author.getAvatar().getInitials()));
        }
        AvatarGroupKt.m5121AvatarGroupJ8mCjc((List) arrayList, (Modifier) null, Dp.m4704constructorimpl((float) 32), 0, startRestartGroup, 392, 10);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        IntercomDividerKt.IntercomDivider((Modifier) null, startRestartGroup, 0, 1);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CollectionSummaryComponentKt$CollectionSummaryComponent$2(collectionContent2, modifier4, i, i3));
        }
    }

    private static final String constructByAuthorsText(Context context, List<Author> list) {
        CharSequence charSequence;
        int size = list.size();
        if (size == 1) {
            charSequence = Phrase.from(context, R.string.intercom_article_single_author).put("author_first_name", (CharSequence) ((Author) CollectionsKt.first(list)).getName()).format();
        } else if (size != 2) {
            charSequence = Phrase.from(context, R.string.intercom_article_multiple_authors).put("author_first_name1", (CharSequence) ((Author) CollectionsKt.first(list)).getName()).put("number_of_other_authors", list.size() - 1).format();
        } else {
            charSequence = Phrase.from(context, R.string.intercom_article_double_author).put("author_first_name1", (CharSequence) ((Author) CollectionsKt.first(list)).getName()).put("author_first_name2", (CharSequence) ((Author) CollectionsKt.last(list)).getName()).format();
        }
        return charSequence.toString();
    }

    /* access modifiers changed from: private */
    public static final void CollectionSummaryComponentPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1044990942);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$CollectionSummaryComponentKt.INSTANCE.m5204getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CollectionSummaryComponentKt$CollectionSummaryComponentPreview$1(i));
        }
    }
}
