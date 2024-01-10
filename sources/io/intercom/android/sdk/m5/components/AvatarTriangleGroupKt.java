package io.intercom.android.sdk.m5.components;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.shapes.CutAvatarBoxShape;
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aA\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"AvatarTriangleGroup", "", "avatars", "", "Lio/intercom/android/sdk/models/Avatar;", "modifier", "Landroidx/compose/ui/Modifier;", "avatarShape", "Landroidx/compose/ui/graphics/Shape;", "size", "Landroidx/compose/ui/unit/Dp;", "AvatarTriangleGroup--jt2gSs", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/runtime/Composer;II)V", "DoubleAvatarsPreview", "(Landroidx/compose/runtime/Composer;I)V", "SingleAvatarPreview", "TripleAvatarsPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AvatarTriangleGroup.kt */
public final class AvatarTriangleGroupKt {
    /* renamed from: AvatarTriangleGroup--jt2gSs  reason: not valid java name */
    public static final void m5127AvatarTriangleGroupjt2gSs(List<? extends Avatar> list, Modifier modifier, Shape shape, float f, Composer composer, int i, int i2) {
        int i3;
        Shape shape2;
        float f2;
        Modifier modifier2;
        float f3;
        List<? extends Avatar> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "avatars");
        Composer startRestartGroup = composer.startRestartGroup(-534156342);
        Modifier modifier3 = (i2 & 2) != 0 ? Modifier.Companion : modifier;
        if ((i2 & 4) != 0) {
            shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8).getSmall();
            i3 = i & -897;
        } else {
            shape2 = shape;
            i3 = i;
        }
        if ((i2 & 8) != 0) {
            f2 = Dp.m4704constructorimpl((float) 32);
        } else {
            f2 = f;
        }
        long sp = TextUnitKt.getSp(12);
        if (list.size() > 1) {
            startRestartGroup.startReplaceableGroup(738098718);
            float f4 = (float) 2;
            float r7 = Dp.m4704constructorimpl(Dp.m4704constructorimpl(f2 / f4) + Dp.m4704constructorimpl(Dp.m4704constructorimpl((float) 1) * f4));
            Modifier r2 = SizeKt.m582size3ABfNKs(modifier3, f2);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r2);
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
            Composer r10 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r10, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r10, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r10, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r10, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            Object obj = CollectionsKt.getLastIndex(list) >= 0 ? list2.get(0) : Avatar.NULL;
            Intrinsics.checkNotNullExpressionValue(obj, "avatars.getOrElse(0) { Avatar.NULL }");
            float f5 = f2 - r7;
            float f6 = f4;
            float f7 = r7;
            Modifier modifier4 = modifier3;
            float f8 = f2;
            AvatarIconKt.m5124AvatarIconRd90Nhg((Avatar) obj, boxScope.align(SizeKt.m582size3ABfNKs(Modifier.Companion, r7), Alignment.Companion.getTopCenter()), new CutAvatarBoxShape(shape2, Dp.m4704constructorimpl(f4), CollectionsKt.listOf(TuplesKt.to(Dp.m4702boximpl(Dp.m4704constructorimpl(Dp.m4704constructorimpl(f5) / f4)), Dp.m4702boximpl(Dp.m4704constructorimpl(f5))), TuplesKt.to(Dp.m4702boximpl(Dp.m4704constructorimpl(-Dp.m4704constructorimpl(Dp.m4704constructorimpl(f5) / f4))), Dp.m4702boximpl(Dp.m4704constructorimpl(f5)))), (DefaultConstructorMarker) null), false, sp, (Color) null, startRestartGroup, 24584, 40);
            Object obj2 = 1 <= CollectionsKt.getLastIndex(list) ? list2.get(1) : Avatar.NULL;
            Intrinsics.checkNotNullExpressionValue(obj2, "avatars.getOrElse(1) { Avatar.NULL }");
            float f9 = f7;
            float f10 = f8;
            float f11 = f9;
            AvatarIconKt.m5124AvatarIconRd90Nhg((Avatar) obj2, boxScope.align(SizeKt.m582size3ABfNKs(Modifier.Companion, f9), Alignment.Companion.getBottomStart()), new CutAvatarBoxShape(shape2, Dp.m4704constructorimpl(f6), CollectionsKt.listOf(TuplesKt.to(Dp.m4702boximpl(Dp.m4704constructorimpl(f5)), Dp.m4702boximpl(Dp.m4704constructorimpl((float) 0)))), (DefaultConstructorMarker) null), false, sp, (Color) null, startRestartGroup, 24584, 40);
            Object obj3 = 2 <= CollectionsKt.getLastIndex(list) ? list2.get(2) : Avatar.NULL;
            Intrinsics.checkNotNullExpressionValue(obj3, "avatars.getOrElse(2) { Avatar.NULL }");
            AvatarIconKt.m5124AvatarIconRd90Nhg((Avatar) obj3, boxScope.align(SizeKt.m582size3ABfNKs(Modifier.Companion, f11), Alignment.Companion.getBottomEnd()), shape2, false, sp, (Color) null, startRestartGroup, (i3 & 896) | 24584, 40);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            modifier2 = modifier4;
            f3 = f10;
        } else {
            float f12 = f2;
            Modifier modifier5 = modifier3;
            startRestartGroup.startReplaceableGroup(738100550);
            Object obj4 = CollectionsKt.getLastIndex(list) >= 0 ? list2.get(0) : Avatar.NULL;
            Intrinsics.checkNotNullExpressionValue(obj4, "avatars.getOrElse(0) { Avatar.NULL }");
            modifier2 = modifier5;
            f3 = f12;
            AvatarIconKt.m5124AvatarIconRd90Nhg((Avatar) obj4, SizeKt.m582size3ABfNKs(modifier2, f3), shape2, false, 0, (Color) null, startRestartGroup, (i3 & 896) | 8, 56);
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarTriangleGroupKt$AvatarTriangleGroup$3(list, modifier2, shape2, f3, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void SingleAvatarPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-932654159);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$AvatarTriangleGroupKt.INSTANCE.m5136getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarTriangleGroupKt$SingleAvatarPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void DoubleAvatarsPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2121947035);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$AvatarTriangleGroupKt.INSTANCE.m5137getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarTriangleGroupKt$DoubleAvatarsPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void TripleAvatarsPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-724464974);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$AvatarTriangleGroupKt.INSTANCE.m5138getLambda3$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarTriangleGroupKt$TripleAvatarsPreview$1(i));
        }
    }
}
