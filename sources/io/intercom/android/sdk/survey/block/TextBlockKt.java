package io.intercom.android.sdk.survey.block;

import android.content.Context;
import android.text.Spanned;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.selection.SelectionContainerKt;
import androidx.compose.material.Colors;
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
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
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
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.text.HtmlCompat;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a)\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"BlockAlignPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "BlockHeadingPreview", "BlockSubHeadingPreview", "BlockTextPreview", "TextBlock", "modifier", "Landroidx/compose/ui/Modifier;", "blockRenderData", "Lio/intercom/android/sdk/survey/block/BlockRenderData;", "suffixText", "Lio/intercom/android/sdk/survey/block/SuffixText;", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/survey/block/BlockRenderData;Lio/intercom/android/sdk/survey/block/SuffixText;Landroidx/compose/runtime/Composer;II)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextBlock.kt */
public final class TextBlockKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TextBlock.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlockType.values().length];
            iArr[BlockType.PARAGRAPH.ordinal()] = 1;
            iArr[BlockType.HEADING.ordinal()] = 2;
            iArr[BlockType.SUBHEADING.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: finally extract failed */
    public static final void TextBlock(Modifier modifier, BlockRenderData blockRenderData, SuffixText suffixText, Composer composer, int i, int i2) {
        AnnotatedString annotatedString;
        Intrinsics.checkNotNullParameter(blockRenderData, "blockRenderData");
        Composer startRestartGroup = composer.startRestartGroup(-1061554299);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.Companion : modifier;
        SuffixText no_suffix = (i2 & 4) != 0 ? SuffixText.Companion.getNO_SUFFIX() : suffixText;
        Block block = blockRenderData.getBlock();
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = TextUnitKt.getSp(16);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        T consume = startRestartGroup.consume(TextKt.getLocalTextStyle());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        objectRef.element = consume;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Context context = (Context) consume2;
        Ref.LongRef longRef2 = new Ref.LongRef();
        Color r9 = blockRenderData.m5296getTextColorQN2ZGVo();
        startRestartGroup.startReplaceableGroup(1564831053);
        long r11 = r9 == null ? MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU() : r9.m1942unboximpl();
        startRestartGroup.endReplaceableGroup();
        longRef2.element = r11;
        Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = TextUnit.Companion.m4896getUnspecifiedXSAIIZE();
        Ref.IntRef intRef = new Ref.IntRef();
        BlockAlignment align = block.getAlign();
        Intrinsics.checkNotNullExpressionValue(align, "block.align");
        intRef.element = BlockExtensionsKt.getTextAlign(align);
        BlockType type = block.getType();
        int i3 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i3 == 1) {
            startRestartGroup.startReplaceableGroup(1564831269);
            longRef.element = blockRenderData.m5289getParagraphFontSizeXSAIIZE();
            objectRef.element = TextStyle.m4228copyHL5avdY$default((TextStyle) objectRef.element, 0, 0, blockRenderData.getParagraphFontWeight(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262139, (Object) null);
            Color r6 = blockRenderData.m5292getParagraphTextColorQN2ZGVo();
            longRef2.element = r6 == null ? MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU() : r6.m1942unboximpl();
            longRef3.element = blockRenderData.m5290getParagraphLineHeightXSAIIZE();
            intRef.element = blockRenderData.m5291getParagraphTextAligne0LSkKk();
            startRestartGroup.endReplaceableGroup();
        } else if (i3 == 2) {
            startRestartGroup.startReplaceableGroup(1564831659);
            startRestartGroup.endReplaceableGroup();
            longRef.element = TextUnitKt.getSp(48);
            objectRef.element = TextStyle.m4228copyHL5avdY$default((TextStyle) objectRef.element, 0, 0, FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262139, (Object) null);
        } else if (i3 != 3) {
            startRestartGroup.startReplaceableGroup(1564832138);
            startRestartGroup.endReplaceableGroup();
            TextUnitKt.getSp(16);
        } else {
            startRestartGroup.startReplaceableGroup(1564831801);
            longRef.element = blockRenderData.m5293getSubHeadingFontSizeXSAIIZE();
            objectRef.element = TextStyle.m4228copyHL5avdY$default((TextStyle) objectRef.element, 0, 0, blockRenderData.getSubHeadingFontWeight(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262139, (Object) null);
            Color r62 = blockRenderData.m5295getSubHeadingTextColorQN2ZGVo();
            longRef2.element = r62 == null ? MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU() : r62.m1942unboximpl();
            longRef3.element = blockRenderData.m5294getSubHeadingLineHeightXSAIIZE();
            startRestartGroup.endReplaceableGroup();
        }
        Spanned fromHtml = HtmlCompat.fromHtml(block.getText(), 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(block.text, Htm…at.FROM_HTML_MODE_LEGACY)");
        if (!Intrinsics.areEqual((Object) no_suffix, (Object) SuffixText.Companion.getNO_SUFFIX())) {
            AnnotatedString annotatedString$default = BlockExtensionsKt.toAnnotatedString$default(fromHtml, (SpanStyle) null, 1, (Object) null);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            builder.append(annotatedString$default);
            int pushStyle = builder.pushStyle(new SpanStyle(no_suffix.m5305getColor0d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16382, (DefaultConstructorMarker) null));
            try {
                builder.append(no_suffix.getText());
                Unit unit = Unit.INSTANCE;
                builder.pop(pushStyle);
                annotatedString = builder.toAnnotatedString();
            } catch (Throwable th) {
                builder.pop(pushStyle);
                throw th;
            }
        } else {
            annotatedString = BlockExtensionsKt.toAnnotatedString$default(fromHtml, (SpanStyle) null, 1, (Object) null);
        }
        AnnotatedString annotatedString2 = annotatedString;
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        TextBlockKt$TextBlock$3 textBlockKt$TextBlock$3 = r4;
        Modifier modifier3 = modifier2;
        TextBlockKt$TextBlock$3 textBlockKt$TextBlock$32 = new TextBlockKt$TextBlock$3(longRef, longRef2, objectRef, intRef, longRef3, modifier2, annotatedString2, (MutableState) rememberedValue, fromHtml, no_suffix, context);
        SelectionContainerKt.DisableSelection(ComposableLambdaKt.composableLambda(startRestartGroup, 1417083990, true, textBlockKt$TextBlock$3), startRestartGroup, 6);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextBlockKt$TextBlock$4(modifier3, blockRenderData, no_suffix, i, i2));
        }
    }

    public static final void BlockTextPreview(Composer composer, int i) {
        int i2 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1899390283);
        ComposerKt.sourceInformation(startRestartGroup, "C(BlockTextPreview)");
        if (i2 != 0 || !startRestartGroup.getSkipping()) {
            Block build = new Block.Builder().withType(BlockType.PARAGRAPH.getSerializedName()).withText("Hello <b>World</b>. This <i><strike>text</strike>sentence</i> is form<b>att<u>ed</u></b> in simple html. <a href=\"https://github.com/ch4rl3x/HtmlText\">HtmlText</a>").build();
            Intrinsics.checkNotNullExpressionValue(build, "block");
            TextBlock((Modifier) null, new BlockRenderData(build, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 2046, (DefaultConstructorMarker) null), (SuffixText) null, startRestartGroup, 64, 5);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextBlockKt$BlockTextPreview$1(i2));
        }
    }

    public static final void BlockAlignPreview(Composer composer, int i) {
        int i2 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1121788945);
        ComposerKt.sourceInformation(startRestartGroup, "C(BlockAlignPreview)");
        if (i2 != 0 || !startRestartGroup.getSkipping()) {
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxWidth$default);
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
            Block r2 = m5306BlockAlignPreview$lambda5$buildBlock("left", "Left");
            Intrinsics.checkNotNullExpressionValue(r2, "buildBlock(\"left\", \"Left\")");
            Composer composer2 = startRestartGroup;
            TextBlock(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), new BlockRenderData(r2, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 2046, (DefaultConstructorMarker) null), (SuffixText) null, composer2, 70, 4);
            Block r22 = m5306BlockAlignPreview$lambda5$buildBlock("center", "Center");
            Intrinsics.checkNotNullExpressionValue(r22, "buildBlock(\"center\", \"Center\")");
            TextBlock(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), new BlockRenderData(r22, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 2046, (DefaultConstructorMarker) null), (SuffixText) null, composer2, 70, 4);
            Block r23 = m5306BlockAlignPreview$lambda5$buildBlock("right", "Right");
            Intrinsics.checkNotNullExpressionValue(r23, "buildBlock(\"right\", \"Right\")");
            TextBlock(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), new BlockRenderData(r23, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 2046, (DefaultConstructorMarker) null), (SuffixText) null, composer2, 70, 4);
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
            endRestartGroup.updateScope(new TextBlockKt$BlockAlignPreview$2(i2));
        }
    }

    /* renamed from: BlockAlignPreview$lambda-5$buildBlock  reason: not valid java name */
    private static final Block m5306BlockAlignPreview$lambda5$buildBlock(String str, String str2) {
        return new Block.Builder().withType(BlockType.PARAGRAPH.getSerializedName()).withAlign(str).withText(str2).build();
    }

    public static final void BlockHeadingPreview(Composer composer, int i) {
        int i2 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1914000980);
        ComposerKt.sourceInformation(startRestartGroup, "C(BlockHeadingPreview)");
        if (i2 != 0 || !startRestartGroup.getSkipping()) {
            Block build = new Block.Builder().withType(BlockType.HEADING.getSerializedName()).withText("Heading").build();
            Intrinsics.checkNotNullExpressionValue(build, "block");
            TextBlock((Modifier) null, new BlockRenderData(build, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 0, (FontWeight) null, (Color) null, 0, 2046, (DefaultConstructorMarker) null), (SuffixText) null, startRestartGroup, 64, 5);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextBlockKt$BlockHeadingPreview$1(i2));
        }
    }

    public static final void BlockSubHeadingPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1446359830);
        ComposerKt.sourceInformation(startRestartGroup, "C(BlockSubHeadingPreview)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$TextBlockKt.INSTANCE.m5301getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextBlockKt$BlockSubHeadingPreview$1(i));
        }
    }
}
