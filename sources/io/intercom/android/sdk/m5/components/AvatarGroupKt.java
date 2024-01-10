package io.intercom.android.sdk.m5.components;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.shapes.CutAvatarShape;
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aA\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"AvatarGroup", "", "avatars", "", "Lio/intercom/android/sdk/models/Avatar;", "modifier", "Landroidx/compose/ui/Modifier;", "avatarSize", "Landroidx/compose/ui/unit/Dp;", "placeHolderTextSize", "Landroidx/compose/ui/unit/TextUnit;", "AvatarGroup--J8mCjc", "(Ljava/util/List;Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "AvatarGroupPreview", "(Landroidx/compose/runtime/Composer;I)V", "AvatarGroupRoundedCornerPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AvatarGroup.kt */
public final class AvatarGroupKt {
    /* renamed from: AvatarGroup--J8mCjc  reason: not valid java name */
    public static final void m5121AvatarGroupJ8mCjc(List<? extends Avatar> list, Modifier modifier, float f, long j, Composer composer, int i, int i2) {
        Modifier modifier2;
        float f2;
        int i3;
        long j2;
        List<? extends Avatar> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "avatars");
        Composer startRestartGroup = composer.startRestartGroup(-258460642);
        if ((i2 & 2) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i2 & 4) != 0) {
            f2 = Dp.m4704constructorimpl((float) 38);
        } else {
            f2 = f;
        }
        if ((i2 & 8) != 0) {
            j2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getSubtitle2().m4239getFontSizeXSAIIZE();
            i3 = i & -7169;
        } else {
            j2 = j;
            i3 = i;
        }
        float f3 = (float) 2;
        float r3 = Dp.m4704constructorimpl(f3);
        CutAvatarShape cutAvatarShape = new CutAvatarShape(MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8).getSmall(), Dp.m4704constructorimpl(f3 * r3), (DefaultConstructorMarker) null);
        Arrangement.HorizontalOrVertical r2 = Arrangement.INSTANCE.m407spacedBy0680j_4(Dp.m4704constructorimpl(-r3));
        int i4 = 0;
        Modifier wrapContentSize$default = SizeKt.wrapContentSize$default(modifier2, (Alignment) null, false, 3, (Object) null);
        startRestartGroup.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(startRestartGroup, "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(r2, Alignment.Companion.getTop(), startRestartGroup, 0);
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
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(wrapContentSize$default);
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
        Updater.m1550setimpl(r7, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1550setimpl(r7, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1550setimpl(r7, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1550setimpl(r7, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-678309503);
        ComposerKt.sourceInformation(startRestartGroup, "C80@4021L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        for (Object next : list2) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AvatarIconKt.m5124AvatarIconRd90Nhg((Avatar) next, SizeKt.m582size3ABfNKs(Modifier.Companion, f2), i4 == 0 ? MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8).getSmall() : cutAvatarShape, false, j2, (Color) null, startRestartGroup, (57344 & (i3 << 3)) | 8, 40);
            i4 = i5;
            cutAvatarShape = cutAvatarShape;
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarGroupKt$AvatarGroup$2(list, modifier2, f2, j2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void AvatarGroupPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2091006176);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$AvatarGroupKt.INSTANCE.m5128getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarGroupKt$AvatarGroupPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void AvatarGroupRoundedCornerPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1534829582);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, Shapes.copy$default(MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8), RoundedCornerShapeKt.m855RoundedCornerShape0680j_4(Dp.m4704constructorimpl((float) 8)), (CornerBasedShape) null, (CornerBasedShape) null, 6, (Object) null), (Typography) null, ComposableSingletons$AvatarGroupKt.INSTANCE.m5129getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 5);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarGroupKt$AvatarGroupRoundedCornerPreview$1(i));
        }
    }
}
