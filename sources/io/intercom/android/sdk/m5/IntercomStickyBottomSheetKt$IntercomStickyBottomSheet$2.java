package io.intercom.android.sdk.m5;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomStickyBottomSheet.kt */
final class IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Function0<Unit> $onSheetDismissed;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ ModalBottomSheetState $sheetState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2(ModalBottomSheetState modalBottomSheetState, int i, Shape shape, long j, float f, long j2, CoroutineScope coroutineScope, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(3);
        this.$sheetState = modalBottomSheetState;
        this.$$dirty = i;
        this.$shape = shape;
        this.$backgroundColor = j;
        this.$elevation = f;
        this.$scrimColor = j2;
        this.$scope = coroutineScope;
        this.$onSheetDismissed = function0;
        this.$content = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        int i2;
        float f;
        Function1 function1;
        BoxWithConstraintsScope boxWithConstraintsScope2 = boxWithConstraintsScope;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope2, "$this$BoxWithConstraints");
        if ((i & 14) == 0) {
            i2 = i | (composer2.changed((Object) boxWithConstraintsScope2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 91) != 18 || !composer.getSkipping()) {
            float r8 = (float) Constraints.m4623getMaxHeightimpl(boxWithConstraintsScope.m457getConstraintsmsEJaDk());
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            long j = this.$scrimColor;
            ModalBottomSheetState modalBottomSheetState = this.$sheetState;
            int i3 = this.$$dirty;
            CoroutineScope coroutineScope = this.$scope;
            Function0<Unit> function0 = this.$onSheetDismissed;
            composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
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
            float f2 = r8;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxSize$default);
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
            Composer r12 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r12, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r12, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r12, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r12, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            IntercomStickyBottomSheetKt.m5108Scrim3JVO9M(j, new IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2$1$1(coroutineScope, modalBottomSheetState, function0), modalBottomSheetState.getTargetValue() != ModalBottomSheetValue.Hidden, composer, (i3 >> 15) & 14);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), IntercomStickyBottomSheetKt.getPreUpPostDownNestedScrollConnection(this.$sheetState), (NestedScrollDispatcher) null, 2, (Object) null);
            composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed = composer2.changed((Object) mutableState);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2$2$1(mutableState);
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(nestedScroll$default, (Function1) rememberedValue2);
            ModalBottomSheetState modalBottomSheetState2 = this.$sheetState;
            Float valueOf = Float.valueOf(f2);
            ModalBottomSheetState modalBottomSheetState3 = this.$sheetState;
            composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed2 = composer2.changed((Object) modalBottomSheetState2) | composer2.changed((Object) valueOf);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                f = f2;
                function1 = new IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2$3$1(modalBottomSheetState3, f);
                composer2.updateRememberedValue(function1);
            } else {
                function1 = rememberedValue3;
                f = f2;
            }
            composer.endReplaceableGroup();
            Modifier access$bottomSheetSwipeable = IntercomStickyBottomSheetKt.bottomSheetSwipeable(OffsetKt.offset(onGloballyPositioned, function1), f, this.$sheetState, mutableState, true);
            Shape shape = this.$shape;
            long j2 = this.$backgroundColor;
            float f3 = this.$elevation;
            final Function2<Composer, Integer, Unit> function2 = this.$content;
            final int i4 = this.$$dirty;
            int i5 = this.$$dirty;
            SurfaceKt.m1419SurfaceFjzlyU(access$bottomSheetSwipeable, shape, j2, 0, (BorderStroke) null, f3, ComposableLambdaKt.composableLambda(composer2, 1485079720, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        function2.invoke(composer, Integer.valueOf((i4 >> 21) & 14));
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer, 1572864 | ((i5 >> 3) & 112) | ((i5 >> 6) & 896) | ((i5 << 6) & 458752), 24);
            return;
        }
        composer.skipToGroupEnd();
    }
}
