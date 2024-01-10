package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Surface.kt */
final class SurfaceKt$Surface$13 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ float $absoluteElevation;
    final /* synthetic */ BorderStroke $border;
    final /* synthetic */ long $color;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ float $elevation;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Indication $indication;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Role $role;
    final /* synthetic */ Shape $shape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SurfaceKt$Surface$13(Modifier modifier, Shape shape, long j, float f, int i, BorderStroke borderStroke, float f2, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$shape = shape;
        this.$color = j;
        this.$absoluteElevation = f;
        this.$$dirty = i;
        this.$border = borderStroke;
        this.$elevation = f2;
        this.$interactionSource = mutableInteractionSource;
        this.$indication = indication;
        this.$enabled = z;
        this.$onClickLabel = str;
        this.$role = role;
        this.$onClick = function0;
        this.$content = function2;
        this.$$dirty1 = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C598@29997L7,596@29868L221,591@29701L964:Surface.kt#jmzs0o");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            Modifier minimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(this.$modifier);
            Shape shape = this.$shape;
            long j = this.$color;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ElevationOverlayKt.getLocalElevationOverlay());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier then = SurfaceKt.m1425surface8ww4TTg(minimumTouchTargetSize, shape, SurfaceKt.m1426surfaceColorAtElevationcq6XJ1M(j, (ElevationOverlay) consume, this.$absoluteElevation, composer, (this.$$dirty >> 9) & 14), this.$border, this.$elevation).then(ClickableKt.m193clickableO2vRcR0(Modifier.Companion, this.$interactionSource, this.$indication, this.$enabled, this.$onClickLabel, this.$role, this.$onClick));
            Function2<Composer, Integer, Unit> function2 = this.$content;
            int i2 = this.$$dirty1;
            composer.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composer, 48);
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection = (LayoutDirection) consume3;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(then);
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
            Composer r6 = Updater.m1543constructorimpl(composer);
            Updater.m1550setimpl(r6, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r6, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r6, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r6, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(composer, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            composer.startReplaceableGroup(-1300719946);
            ComposerKt.sourceInformation(composer, "C616@30646L9:Surface.kt#jmzs0o");
            function2.invoke(composer, Integer.valueOf((i2 >> 6) & 14));
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
}