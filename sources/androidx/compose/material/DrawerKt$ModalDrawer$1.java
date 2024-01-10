package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
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
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$ModalDrawer$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$ModalDrawer$1(DrawerState drawerState, boolean z, int i, long j, Shape shape, long j2, long j3, float f, Function2<? super Composer, ? super Integer, Unit> function2, CoroutineScope coroutineScope, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$drawerState = drawerState;
        this.$gesturesEnabled = z;
        this.$$dirty = i;
        this.$scrimColor = j;
        this.$drawerShape = shape;
        this.$drawerBackgroundColor = j2;
        this.$drawerContentColor = j3;
        this.$drawerElevation = f;
        this.$content = function2;
        this.$scope = coroutineScope;
        this.$drawerContent = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        int i2;
        BoxWithConstraintsScope boxWithConstraintsScope2 = boxWithConstraintsScope;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope2, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer2, "C397@13855L7,398@13894L2641:Drawer.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = i | (composer2.changed((Object) boxWithConstraintsScope2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 91) != 18 || !composer.getSkipping()) {
            long r8 = boxWithConstraintsScope.m457getConstraintsmsEJaDk();
            if (Constraints.m4620getHasBoundedWidthimpl(r8)) {
                float f = -((float) Constraints.m4624getMaxWidthimpl(r8));
                Map mapOf = MapsKt.mapOf(TuplesKt.to(Float.valueOf(f), DrawerValue.Closed), TuplesKt.to(Float.valueOf(0.0f), DrawerValue.Open));
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier r3 = SwipeableKt.m1430swipeablepPrIpRY$default(Modifier.Companion, this.$drawerState.getSwipeableState$material_release(), mapOf, Orientation.Horizontal, this.$gesturesEnabled, consume == LayoutDirection.Rtl, (MutableInteractionSource) null, AnonymousClass1.INSTANCE, (ResistanceConfig) null, DrawerKt.DrawerVelocityThreshold, 32, (Object) null);
                DrawerState drawerState = this.$drawerState;
                int i3 = this.$$dirty;
                long j = this.$scrimColor;
                Shape shape = this.$drawerShape;
                Modifier modifier = r3;
                long j2 = this.$drawerBackgroundColor;
                long j3 = this.$drawerContentColor;
                float f2 = this.$drawerElevation;
                long j4 = j2;
                Function2<Composer, Integer, Unit> function2 = this.$content;
                boolean z = this.$gesturesEnabled;
                float f3 = f2;
                CoroutineScope coroutineScope = this.$scope;
                long j5 = j3;
                Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$drawerContent;
                composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Shape shape2 = shape;
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                long j6 = r8;
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume2 = composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer);
                Density density = (Density) consume2;
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume3 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutDirection layoutDirection = (LayoutDirection) consume3;
                long j7 = j;
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(composer);
                ViewConfiguration viewConfiguration = (ViewConfiguration) consume4;
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
                float f4 = f;
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
                Composer r1 = Updater.m1543constructorimpl(composer);
                Updater.m1550setimpl(r1, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1550setimpl(r1, density, ComposeUiNode.Companion.getSetDensity());
                Updater.m1550setimpl(r1, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1550setimpl(r1, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                composer.enableReusing();
                materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(-1263168067);
                ComposerKt.sourceInformation(composer2, "C410@14358L45,423@14805L103,413@14416L542,428@14992L33,*430@15092L7,439@15556L55,429@15038L1487:Drawer.kt#jmzs0o");
                composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer);
                Density density2 = (Density) consume5;
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutDirection layoutDirection2 = (LayoutDirection) consume6;
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(composer);
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume7;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(Modifier.Companion);
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
                Composer r12 = Updater.m1543constructorimpl(composer);
                Updater.m1550setimpl(r12, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1550setimpl(r12, density2, ComposeUiNode.Companion.getSetDensity());
                Updater.m1550setimpl(r12, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1550setimpl(r12, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
                composer.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(32495683);
                ComposerKt.sourceInformation(composer2, "C411@14380L9:Drawer.kt#jmzs0o");
                function2.invoke(composer2, Integer.valueOf((i3 >> 27) & 14));
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                boolean isOpen = drawerState.isOpen();
                Function0 drawerKt$ModalDrawer$1$2$2 = new DrawerKt$ModalDrawer$1$2$2(z, drawerState, coroutineScope);
                Float valueOf = Float.valueOf(f4);
                Float valueOf2 = Float.valueOf(0.0f);
                composer2.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composer2, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                boolean changed = composer2.changed((Object) valueOf) | composer2.changed((Object) valueOf2) | composer2.changed((Object) drawerState);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DrawerKt$ModalDrawer$1$2$3$1(f4, 0.0f, drawerState);
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                long j8 = j4;
                Shape shape3 = shape2;
                DrawerKt.m1264ScrimBx497Mc(isOpen, drawerKt$ModalDrawer$1$2$2, (Function0) rememberedValue, j7, composer, (i3 >> 15) & 7168);
                String r0 = Strings_androidKt.m1417getString4foXLRw(Strings.Companion.m1414getNavigationMenuUdPEhr4(), composer2, 6);
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer);
                Density density3 = (Density) consume8;
                Modifier r13 = SizeKt.m585sizeInqDBjuR0(Modifier.Companion, density3.m4646toDpu2uoSUM(Constraints.m4626getMinWidthimpl(j6)), density3.m4646toDpu2uoSUM(Constraints.m4625getMinHeightimpl(j6)), density3.m4646toDpu2uoSUM(Constraints.m4624getMaxWidthimpl(j6)), density3.m4646toDpu2uoSUM(Constraints.m4623getMaxHeightimpl(j6)));
                composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
                boolean changed2 = composer2.changed((Object) drawerState);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new DrawerKt$ModalDrawer$1$2$5$1(drawerState);
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceableGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(PaddingKt.m514paddingqDBjuR0$default(OffsetKt.offset(r13, (Function1) rememberedValue2), 0.0f, 0.0f, DrawerKt.EndDrawerPadding, 0.0f, 11, (Object) null), false, new DrawerKt$ModalDrawer$1$2$6(r0, drawerState, coroutineScope), 1, (Object) null);
                int i4 = i3 >> 12;
                SurfaceKt.m1419SurfaceFjzlyU(semantics$default, shape3, j8, j5, (BorderStroke) null, f3, ComposableLambdaKt.composableLambda(composer2, -1941234439, true, new DrawerKt$ModalDrawer$1$2$7(function32, i3)), composer, 1572864 | ((i3 >> 9) & 112) | (i4 & 896) | (i4 & 7168) | (458752 & i3), 16);
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                return;
            }
            throw new IllegalStateException("Drawer shouldn't have infinite width");
        }
        composer.skipToGroupEnd();
    }
}
