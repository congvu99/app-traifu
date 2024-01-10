package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Chip.kt */
final class ChipKt$FilterChip$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ SelectableChipColors $colors;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ State<Color> $contentColor;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ Function2<Composer, Integer, Unit> $selectedIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$FilterChip$3(State<Color> state, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i, SelectableChipColors selectableChipColors, boolean z2, int i2) {
        super(2);
        this.$contentColor = state;
        this.$leadingIcon = function2;
        this.$selected = z;
        this.$selectedIcon = function22;
        this.$trailingIcon = function23;
        this.$content = function3;
        this.$$dirty1 = i;
        this.$colors = selectableChipColors;
        this.$enabled = z2;
        this.$$dirty = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C209@9597L3645:Chip.kt#jmzs0o");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1934getAlphaimpl(this.$contentColor.getValue().m1942unboximpl())))};
            final Function2<Composer, Integer, Unit> function2 = this.$leadingIcon;
            final boolean z = this.$selected;
            final Function2<Composer, Integer, Unit> function22 = this.$selectedIcon;
            final Function2<Composer, Integer, Unit> function23 = this.$trailingIcon;
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
            final int i2 = this.$$dirty1;
            final SelectableChipColors selectableChipColors = this.$colors;
            final boolean z2 = this.$enabled;
            final int i3 = this.$$dirty;
            AnonymousClass1 r2 = r5;
            final State<Color> state = this.$contentColor;
            AnonymousClass1 r5 = new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    Composer composer2 = composer;
                    ComposerKt.sourceInformation(composer2, "C211@9745L10,210@9689L3543:Chip.kt#jmzs0o");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer2, 6).getBody2();
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final boolean z = z;
                        final Function2<Composer, Integer, Unit> function22 = function22;
                        final Function2<Composer, Integer, Unit> function23 = function23;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        final int i2 = i2;
                        final SelectableChipColors selectableChipColors = selectableChipColors;
                        final boolean z2 = z2;
                        final int i3 = i3;
                        AnonymousClass1 r3 = r5;
                        final State<Color> state = state;
                        AnonymousClass1 r5 = new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                float f;
                                float f2;
                                RowScope rowScope;
                                int i2;
                                Composer composer2 = composer;
                                ComposerKt.sourceInformation(composer2, "C213@9794L3424:Chip.kt#jmzs0o");
                                if ((i & 11) != 2 || !composer.getSkipping()) {
                                    Modifier r8 = SizeKt.m567defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, ChipDefaults.INSTANCE.m1197getMinHeightD9Ej5fM(), 1, (Object) null);
                                    if (function2 != null || (z && function22 != null)) {
                                        f = Dp.m4704constructorimpl((float) 0);
                                    } else {
                                        f = ChipKt.HorizontalPadding;
                                    }
                                    float f3 = f;
                                    if (function23 == null) {
                                        f2 = ChipKt.HorizontalPadding;
                                    } else {
                                        f2 = Dp.m4704constructorimpl((float) 0);
                                    }
                                    Modifier r2 = PaddingKt.m514paddingqDBjuR0$default(r8, f3, 0.0f, f2, 0.0f, 10, (Object) null);
                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    boolean z = z;
                                    Function2<Composer, Integer, Unit> function22 = function22;
                                    Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                                    int i3 = i2;
                                    Function2<Composer, Integer, Unit> function23 = function23;
                                    SelectableChipColors selectableChipColors = selectableChipColors;
                                    boolean z2 = z2;
                                    int i4 = i3;
                                    State<Color> state = state;
                                    composer2.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    Function2<Composer, Integer, Unit> function24 = function23;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    Density density = (Density) consume;
                                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume2 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    LayoutDirection layoutDirection = (LayoutDirection) consume2;
                                    int i5 = i3;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume3 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r2);
                                    State<Color> state2 = state;
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
                                    Composer r0 = Updater.m1543constructorimpl(composer);
                                    Updater.m1550setimpl(r0, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m1550setimpl(r0, density, ComposeUiNode.Companion.getSetDensity());
                                    Updater.m1550setimpl(r0, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                                    Updater.m1550setimpl(r0, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                                    composer.enableReusing();
                                    materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-678309503);
                                    ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                                    RowScope rowScope2 = RowScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(1218705642);
                                    ComposerKt.sourceInformation(composer2, "C275@12946L9,277@13028L43,278@13096L14,279@13135L43:Chip.kt#jmzs0o");
                                    composer2.startReplaceableGroup(-1943412137);
                                    ComposerKt.sourceInformation(composer2, "236@10806L47,237@10878L1955,273@12858L45");
                                    if (function2 != null || (z && function22 != null)) {
                                        SpacerKt.Spacer(SizeKt.m587width3ABfNKs(Modifier.Companion, ChipKt.LeadingIconStartSpacing), composer2, 6);
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
                                        rowScope = rowScope2;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume6 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposerKt.sourceInformationMarkerEnd(composer);
                                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(Modifier.Companion);
                                        String str = "C:CompositionLocal.kt#9igjgp";
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
                                        Composer r4 = Updater.m1543constructorimpl(composer);
                                        Updater.m1550setimpl(r4, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m1550setimpl(r4, density2, ComposeUiNode.Companion.getSetDensity());
                                        Updater.m1550setimpl(r4, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
                                        Updater.m1550setimpl(r4, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
                                        composer.enableReusing();
                                        materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        composer2.startReplaceableGroup(-2137368960);
                                        ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                        composer2.startReplaceableGroup(-626917591);
                                        ComposerKt.sourceInformation(composer2, "C:Chip.kt#jmzs0o");
                                        composer2.startReplaceableGroup(649985595);
                                        ComposerKt.sourceInformation(composer2, "239@11001L141,243@11175L297");
                                        if (function2 != null) {
                                            State<Color> leadingIconColor = selectableChipColors.leadingIconColor(z2, z, composer2, ((i4 >> 9) & 14) | ((i4 << 3) & 112) | ((i4 >> 15) & 896));
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(leadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1934getAlphaimpl(leadingIconColor.getValue().m1942unboximpl())))}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer2, ((i4 >> 21) & 112) | 8);
                                        }
                                        composer.endReplaceableGroup();
                                        composer2.startReplaceableGroup(-1943411323);
                                        ComposerKt.sourceInformation(composer2, "262@12326L451");
                                        if (z && function22 != null) {
                                            Modifier modifier = Modifier.Companion;
                                            long r11 = state2.getValue().m1942unboximpl();
                                            composer2.startReplaceableGroup(649986426);
                                            ComposerKt.sourceInformation(composer2, "260@12219L34");
                                            if (function2 != null) {
                                                modifier = ClipKt.clip(BackgroundKt.m176backgroundbw27NRU(SizeKt.m574requiredSize3ABfNKs(Modifier.Companion, ChipKt.SelectedIconContainerSize), state2.getValue().m1942unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                r11 = selectableChipColors.backgroundColor(z2, z, composer2, ((i4 >> 9) & 14) | ((i4 << 3) & 112) | ((i4 >> 15) & 896)).getValue().m1942unboximpl();
                                            }
                                            composer.endReplaceableGroup();
                                            Alignment center = Alignment.Companion.getCenter();
                                            composer2.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                            composer2.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            String str2 = str;
                                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str2);
                                            Object consume7 = composer2.consume(CompositionLocalsKt.getLocalDensity());
                                            ComposerKt.sourceInformationMarkerEnd(composer);
                                            Density density3 = (Density) consume7;
                                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str2);
                                            Object consume8 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ComposerKt.sourceInformationMarkerEnd(composer);
                                            LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
                                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str2);
                                            Object consume9 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposerKt.sourceInformationMarkerEnd(composer);
                                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(modifier);
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
                                            Composer r82 = Updater.m1543constructorimpl(composer);
                                            Updater.m1550setimpl(r82, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m1550setimpl(r82, density3, ComposeUiNode.Companion.getSetDensity());
                                            Updater.m1550setimpl(r82, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
                                            Updater.m1550setimpl(r82, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
                                            composer.enableReusing();
                                            materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
                                            composer2.startReplaceableGroup(2058660585);
                                            composer2.startReplaceableGroup(-2137368960);
                                            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                                            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                                            composer2.startReplaceableGroup(-370889391);
                                            ComposerKt.sourceInformation(composer2, "C266@12539L204:Chip.kt#jmzs0o");
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1922boximpl(r11))}, (Function2<? super Composer, ? super Integer, Unit>) function22, composer2, ((i4 >> 24) & 112) | 8);
                                            composer.endReplaceableGroup();
                                            composer.endReplaceableGroup();
                                            composer.endReplaceableGroup();
                                            composer.endNode();
                                            composer.endReplaceableGroup();
                                            composer.endReplaceableGroup();
                                        }
                                        composer.endReplaceableGroup();
                                        composer.endReplaceableGroup();
                                        composer.endReplaceableGroup();
                                        composer.endReplaceableGroup();
                                        composer.endNode();
                                        composer.endReplaceableGroup();
                                        composer.endReplaceableGroup();
                                        i2 = 6;
                                        SpacerKt.Spacer(SizeKt.m587width3ABfNKs(Modifier.Companion, ChipKt.LeadingIconEndSpacing), composer2, 6);
                                    } else {
                                        rowScope = rowScope2;
                                        i2 = 6;
                                    }
                                    composer.endReplaceableGroup();
                                    function32.invoke(rowScope, composer2, Integer.valueOf((i5 & 112) | i2));
                                    if (function24 != null) {
                                        SpacerKt.Spacer(SizeKt.m587width3ABfNKs(Modifier.Companion, ChipKt.TrailingIconSpacing), composer2, i2);
                                        function24.invoke(composer2, Integer.valueOf(i5 & 14));
                                        SpacerKt.Spacer(SizeKt.m587width3ABfNKs(Modifier.Companion, ChipKt.TrailingIconSpacing), composer2, i2);
                                    }
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
                        };
                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer2, -1543702066, true, r3), composer2, 48);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 1582291359, true, r2), composer2, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
