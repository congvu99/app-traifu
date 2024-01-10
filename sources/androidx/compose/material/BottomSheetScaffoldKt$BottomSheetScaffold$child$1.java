package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffold$child$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $$dirty2;
    final /* synthetic */ MutableState<Float> $bottomSheetHeight$delegate;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ Modifier $semantics;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$child$1(BottomSheetScaffoldState bottomSheetScaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, float f, int i, int i2, int i3, int i4, float f2, boolean z, Modifier modifier, MutableState<Float> mutableState, Shape shape, long j, long j2, float f3, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function33) {
        super(2);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$topBar = function2;
        this.$content = function3;
        this.$floatingActionButton = function22;
        this.$sheetPeekHeight = f;
        this.$floatingActionButtonPosition = i;
        this.$$dirty = i2;
        this.$$dirty2 = i3;
        this.$$dirty1 = i4;
        this.$peekHeightPx = f2;
        this.$sheetGesturesEnabled = z;
        this.$semantics = modifier;
        this.$bottomSheetHeight$delegate = mutableState;
        this.$sheetShape = shape;
        this.$sheetBackgroundColor = j;
        this.$sheetContentColor = j2;
        this.$sheetElevation = f3;
        this.$sheetContent = function32;
        this.$snackbarHost = function33;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Object obj;
        ComposerKt.sourceInformation(composer, "C316@13233L2758:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            State<Float> offset = this.$scaffoldState.getBottomSheetState().getOffset();
            BottomSheetState bottomSheetState = this.$scaffoldState.getBottomSheetState();
            Function2<Composer, Integer, Unit> function2 = this.$topBar;
            Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
            final float f = this.$peekHeightPx;
            final BottomSheetScaffoldState bottomSheetScaffoldState = this.$scaffoldState;
            final boolean z = this.$sheetGesturesEnabled;
            final Modifier modifier = this.$semantics;
            float f2 = this.$sheetPeekHeight;
            MutableState<Float> mutableState = this.$bottomSheetHeight$delegate;
            Shape shape = this.$sheetShape;
            long j = this.$sheetBackgroundColor;
            long j2 = this.$sheetContentColor;
            float f3 = this.$sheetElevation;
            Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
            int i2 = this.$$dirty;
            Function2<Composer, Integer, Unit> function22 = function2;
            final float f4 = f3;
            final float f5 = f2;
            final MutableState<Float> mutableState2 = mutableState;
            final Shape shape2 = shape;
            final long j3 = j;
            final long j4 = j2;
            final int i3 = i2;
            final int i4 = this.$$dirty1;
            final Function3<ColumnScope, Composer, Integer, Unit> function33 = this.$sheetContent;
            new Function3<Integer, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i, Composer composer, int i2) {
                    int i3;
                    Modifier modifier;
                    Map map;
                    int i4 = i;
                    Composer composer2 = composer;
                    ComposerKt.sourceInformation(composer2, "C354@15208L95,347@14851L711:BottomSheetScaffold.kt#jmzs0o");
                    if ((i2 & 14) == 0) {
                        i3 = i2 | (composer2.changed(i4) ? 4 : 2);
                    } else {
                        i3 = i2;
                    }
                    if ((i3 & 91) != 18 || !composer.getSkipping()) {
                        Float r2 = BottomSheetScaffoldKt.m1157BottomSheetScaffold_bGncdBI$lambda4(mutableState2);
                        if (r2 == null) {
                            modifier = Modifier.Companion;
                        } else {
                            if (MathKt.roundToInt(r2.floatValue()) == MathKt.roundToInt(f)) {
                                map = MapsKt.mapOf(TuplesKt.to(Float.valueOf(((float) i4) - r2.floatValue()), BottomSheetValue.Collapsed));
                            } else {
                                float f = (float) i4;
                                Float r6 = BottomSheetScaffoldKt.m1157BottomSheetScaffold_bGncdBI$lambda4(mutableState2);
                                Intrinsics.checkNotNull(r6);
                                map = MapsKt.mapOf(TuplesKt.to(Float.valueOf(f - r6.floatValue()), BottomSheetValue.Expanded), TuplesKt.to(Float.valueOf(f - f), BottomSheetValue.Collapsed));
                            }
                            modifier = SwipeableKt.m1430swipeablepPrIpRY$default(Modifier.Companion, bottomSheetScaffoldState.getBottomSheetState(), map, Orientation.Vertical, z, false, (MutableInteractionSource) null, (Function2) null, (ResistanceConfig) null, 0.0f, 368, (Object) null);
                        }
                        Modifier r1 = SizeKt.m573requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(NestedScrollModifierKt.nestedScroll$default(Modifier.Companion, bottomSheetScaffoldState.getBottomSheetState().getNestedScrollConnection$material_release(), (NestedScrollDispatcher) null, 2, (Object) null).then(modifier).then(modifier), 0.0f, 1, (Object) null), f5, 0.0f, 2, (Object) null);
                        MutableState<Float> mutableState = mutableState2;
                        composer2.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
                        boolean changed = composer2.changed((Object) mutableState);
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1(mutableState);
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceableGroup();
                        Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(r1, (Function1) rememberedValue);
                        Shape shape = shape2;
                        long j = j3;
                        long j2 = j4;
                        float f2 = f4;
                        final Function3<ColumnScope, Composer, Integer, Unit> function3 = function33;
                        final int i5 = i3;
                        int i6 = i3;
                        int i7 = i4;
                        SurfaceKt.m1419SurfaceFjzlyU(onSizeChanged, shape, j, j2, (BorderStroke) null, f2, ComposableLambdaKt.composableLambda(composer2, -698903261, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                ComposerKt.sourceInformation(composer, "C361@15529L30:BottomSheetScaffold.kt#jmzs0o");
                                if ((i & 11) != 2 || !composer.getSkipping()) {
                                    Function3<ColumnScope, Composer, Integer, Unit> function3 = function3;
                                    int i2 = (i5 << 9) & 7168;
                                    composer.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                                    int i3 = i2 >> 3;
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, (i3 & 112) | (i3 & 14));
                                    composer.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    Density density = (Density) consume;
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    LayoutDirection layoutDirection = (LayoutDirection) consume2;
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
                                    int i4 = ((((i2 << 3) & 112) << 9) & 7168) | 6;
                                    if (!(composer.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer.startReusableNode();
                                    if (composer.getInserting()) {
                                        composer.createNode(constructor);
                                    } else {
                                        composer.useNode();
                                    }
                                    composer.disableReusing();
                                    Composer r7 = Updater.m1543constructorimpl(composer);
                                    Updater.m1550setimpl(r7, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m1550setimpl(r7, density, ComposeUiNode.Companion.getSetDensity());
                                    Updater.m1550setimpl(r7, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                                    Updater.m1550setimpl(r7, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                                    composer.enableReusing();
                                    materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer, Integer.valueOf((i4 >> 3) & 112));
                                    composer.startReplaceableGroup(2058660585);
                                    composer.startReplaceableGroup(-1163856341);
                                    ComposerKt.sourceInformation(composer, "C79@3994L9:Column.kt#2w3rfo");
                                    if (((i4 >> 9) & 14 & 11) != 2 || !composer.getSkipping()) {
                                        function3.invoke(ColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i2 >> 6) & 112) | 6));
                                    } else {
                                        composer.skipToGroupEnd();
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
                        }), composer, 1572864 | ((i6 >> 21) & 112) | ((i7 << 6) & 896) | ((i7 << 6) & 7168) | ((i6 >> 12) & 458752), 16);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            Composer composer2 = composer;
            Function2<Composer, Integer, Unit> function23 = this.$floatingActionButton;
            final Function3<SnackbarHostState, Composer, Integer, Unit> function34 = this.$snackbarHost;
            final BottomSheetScaffoldState bottomSheetScaffoldState2 = this.$scaffoldState;
            final int i5 = this.$$dirty;
            float f6 = this.$sheetPeekHeight;
            int i6 = this.$floatingActionButtonPosition;
            int i7 = this.$$dirty;
            int i8 = ((i7 >> 9) & 14) | 24960 | ((this.$$dirty2 >> 3) & 112) | ((i7 >> 6) & 7168) | (458752 & (this.$$dirty1 << 9)) | (i7 & 3670016);
            Function2<Composer, Integer, Unit> function24 = function22;
            Function3<PaddingValues, Composer, Integer, Unit> function35 = function32;
            BottomSheetScaffoldKt.m1156BottomSheetScaffoldLayoutKCBPh4w(function24, function35, ComposableLambdaKt.composableLambda(composer2, -1378534681, true, obj), function23, ComposableLambdaKt.composableLambda(composer2, -486138068, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C365@15680L45:BottomSheetScaffold.kt#jmzs0o");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        function34.invoke(bottomSheetScaffoldState2.getSnackbarHostState(), composer, Integer.valueOf((i5 >> 9) & 112));
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), f6, i6, offset, bottomSheetState, composer2, i8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
