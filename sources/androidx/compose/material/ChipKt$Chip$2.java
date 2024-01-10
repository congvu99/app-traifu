package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
final class ChipKt$Chip$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ ChipColors $colors;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ State<Color> $contentColor$delegate;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$Chip$2(State<Color> state, Function2<? super Composer, ? super Integer, Unit> function2, ChipColors chipColors, boolean z, int i, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$contentColor$delegate = state;
        this.$leadingIcon = function2;
        this.$colors = chipColors;
        this.$enabled = z;
        this.$$dirty = i;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C109@4831L1442:Chip.kt#jmzs0o");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1934getAlphaimpl(ChipKt.m1202Chip$lambda1(this.$contentColor$delegate))))};
            final Function2<Composer, Integer, Unit> function2 = this.$leadingIcon;
            final ChipColors chipColors = this.$colors;
            final boolean z = this.$enabled;
            final int i2 = this.$$dirty;
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 667535631, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C111@4973L10,110@4917L1346:Chip.kt#jmzs0o");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2();
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final ChipColors chipColors = chipColors;
                        final boolean z = z;
                        final int i2 = i2;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer, -1131213696, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                float f;
                                Composer composer2 = composer;
                                ComposerKt.sourceInformation(composer2, "C113@5022L1227:Chip.kt#jmzs0o");
                                if ((i & 11) != 2 || !composer.getSkipping()) {
                                    Modifier r8 = SizeKt.m567defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, ChipDefaults.INSTANCE.m1197getMinHeightD9Ej5fM(), 1, (Object) null);
                                    if (function2 == null) {
                                        f = ChipKt.HorizontalPadding;
                                    } else {
                                        f = Dp.m4704constructorimpl((float) 0);
                                    }
                                    Modifier r2 = PaddingKt.m514paddingqDBjuR0$default(r8, f, 0.0f, ChipKt.HorizontalPadding, 0.0f, 10, (Object) null);
                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    ChipColors chipColors = chipColors;
                                    boolean z = z;
                                    int i2 = i2;
                                    Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                                    composer2.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
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
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r2);
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
                                    Composer r13 = Updater.m1543constructorimpl(composer);
                                    Updater.m1550setimpl(r13, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m1550setimpl(r13, density, ComposeUiNode.Companion.getSetDensity());
                                    Updater.m1550setimpl(r13, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                                    Updater.m1550setimpl(r13, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                                    composer.enableReusing();
                                    materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-678309503);
                                    ComposerKt.sourceInformation(composer2, "C80@3988L9:Row.kt#2w3rfo");
                                    RowScope rowScope = RowScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(951468004);
                                    ComposerKt.sourceInformation(composer2, "C137@6222L9:Chip.kt#jmzs0o");
                                    composer2.startReplaceableGroup(2084788874);
                                    ComposerKt.sourceInformation(composer2, "128@5675L47,129@5785L32,130@5842L267,135@6134L45");
                                    if (function2 != null) {
                                        SpacerKt.Spacer(SizeKt.m587width3ABfNKs(Modifier.Companion, ChipKt.LeadingIconStartSpacing), composer2, 6);
                                        State<Color> leadingIconContentColor = chipColors.leadingIconContentColor(z, composer2, ((i2 >> 6) & 14) | ((i2 >> 15) & 112));
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1922boximpl(m1204invoke$lambda1$lambda0(leadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1934getAlphaimpl(m1204invoke$lambda1$lambda0(leadingIconContentColor))))}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer2, ((i2 >> 18) & 112) | 8);
                                        SpacerKt.Spacer(SizeKt.m587width3ABfNKs(Modifier.Companion, ChipKt.LeadingIconEndSpacing), composer2, 6);
                                    }
                                    composer.endReplaceableGroup();
                                    function3.invoke(rowScope, composer2, Integer.valueOf(((i2 >> 21) & 112) | 6));
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

                            /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
                            private static final long m1204invoke$lambda1$lambda0(State<Color> state) {
                                return state.getValue().m1942unboximpl();
                            }
                        }), composer, 48);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
