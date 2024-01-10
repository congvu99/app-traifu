package io.intercom.android.sdk.m5.components;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.IconKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.compose.SubcomposeAsyncImageKt;
import coil.compose.SubcomposeAsyncImageScope;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.shapes.CutAvatarWithIndicatorShape;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.utilities.ColorExtensionsKt;
import io.intercom.android.sdk.utilities.IntercomCoilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001aQ\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0016\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0018\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a7\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\rH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001e\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"AvatarActiveIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AvatarIcon", "avatar", "Lio/intercom/android/sdk/models/Avatar;", "shape", "Landroidx/compose/ui/graphics/Shape;", "isActive", "", "placeHolderTextSize", "Landroidx/compose/ui/unit/TextUnit;", "customBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "AvatarIcon-Rd90Nhg", "(Lio/intercom/android/sdk/models/Avatar;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;ZJLandroidx/compose/ui/graphics/Color;Landroidx/compose/runtime/Composer;II)V", "AvatarIconActivePreview", "(Landroidx/compose/runtime/Composer;I)V", "AvatarIconCutPreview", "AvatarIconPreview", "AvatarIconRoundActivePreview", "AvatarIconRoundPreview", "AvatarIconSquirclePreview", "AvatarPlaceholder", "textColor", "textSize", "AvatarPlaceholder-mhOCef0", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/models/Avatar;JJLandroidx/compose/runtime/Composer;II)V", "avatarBorder", "shouldDrawBorder", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AvatarIcon.kt */
public final class AvatarIconKt {
    /* renamed from: AvatarIcon-Rd90Nhg  reason: not valid java name */
    public static final void m5124AvatarIconRd90Nhg(Avatar avatar, Modifier modifier, Shape shape, boolean z, long j, Color color, Composer composer, int i, int i2) {
        Shape shape2;
        int i3;
        long j2;
        int i4;
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Composer startRestartGroup = composer.startRestartGroup(-568822209);
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.Companion : modifier;
        if ((i2 & 4) != 0) {
            i3 = i & -897;
            shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8).getSmall();
        } else {
            shape2 = shape;
            i3 = i;
        }
        boolean z2 = (i2 & 8) != 0 ? false : z;
        if ((i2 & 16) != 0) {
            i4 = -57345 & i3;
            j2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getSubtitle2().m4239getFontSizeXSAIIZE();
        } else {
            j2 = j;
            i4 = i3;
        }
        Color color2 = (i2 & 32) != 0 ? null : color;
        long r4 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1214getPrimary0d7_KjU();
        long r10 = color2 != null ? color2.m1942unboximpl() : ColorExtensionsKt.m5395darken8_81llA(r4);
        long r17 = color2 != null ? ColorExtensionsKt.m5396generateTextColor8_81llA(color2.m1942unboximpl()) : ColorExtensionsKt.m5396generateTextColor8_81llA(r4);
        if (color2 != null) {
            r4 = color2.m1942unboximpl();
        }
        boolean r1 = ColorExtensionsKt.m5401isDarkColor8_81llA(r4);
        float r7 = Dp.m4704constructorimpl((float) 8);
        Shape cutAvatarWithIndicatorShape = z2 ? new CutAvatarWithIndicatorShape(shape2, r7, (DefaultConstructorMarker) null) : shape2;
        Modifier avatarBorder = avatarBorder(BackgroundKt.m176backgroundbw27NRU(modifier2, r10, cutAvatarWithIndicatorShape), r1, cutAvatarWithIndicatorShape);
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
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(avatarBorder);
        float f = r7;
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
        Composer r72 = Updater.m1543constructorimpl(startRestartGroup);
        Updater.m1550setimpl(r72, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1550setimpl(r72, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1550setimpl(r72, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1550setimpl(r72, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2137368960);
        ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        Modifier clip = ClipKt.clip(modifier2, cutAvatarWithIndicatorShape);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density2 = (Density) consume4;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(clip);
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
        Composer r3 = Updater.m1543constructorimpl(startRestartGroup);
        Updater.m1550setimpl(r3, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1550setimpl(r3, density2, ComposeUiNode.Companion.getSetDensity());
        Updater.m1550setimpl(r3, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1550setimpl(r3, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2137368960);
        ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
        String imageUrl = avatar.getImageUrl();
        Modifier align = BoxScopeInstance.INSTANCE.align(modifier2, Alignment.Companion.getCenter());
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume7 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ImageLoader imageLoader = IntercomCoilKt.getImageLoader((Context) consume7);
        ContentScale crop = ContentScale.Companion.getCrop();
        Avatar avatar2 = avatar;
        AvatarIconKt$AvatarIcon$1$1$1 avatarIconKt$AvatarIcon$1$1$1 = r1;
        long j3 = r17;
        float f2 = f;
        BoxScope boxScope2 = boxScope;
        Shape shape3 = shape2;
        AvatarIconKt$AvatarIcon$1$1$1 avatarIconKt$AvatarIcon$1$1$12 = new AvatarIconKt$AvatarIcon$1$1$1(modifier2, avatar2, j3, j2, i4);
        Function4 composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 103787922, true, avatarIconKt$AvatarIcon$1$1$1);
        Modifier modifier3 = modifier2;
        AvatarIconKt$AvatarIcon$1$1$2 avatarIconKt$AvatarIcon$1$1$2 = r1;
        AvatarIconKt$AvatarIcon$1$1$2 avatarIconKt$AvatarIcon$1$1$22 = new AvatarIconKt$AvatarIcon$1$1$2(modifier3, avatar2, j3, j2, i4);
        SubcomposeAsyncImageKt.m5024SubcomposeAsyncImageQ4Kwu38(imageUrl, (String) null, imageLoader, align, composableLambda, (Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit>) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1199030328, true, avatarIconKt$AvatarIcon$1$1$2), (Function1<? super AsyncImagePainter.State.Loading, Unit>) null, (Function1<? super AsyncImagePainter.State.Success, Unit>) null, (Function1<? super AsyncImagePainter.State.Error, Unit>) null, (Alignment) null, crop, 0.0f, (ColorFilter) null, 0, startRestartGroup, 1598000, 48, 30624);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (z2) {
            AvatarActiveIndicator(boxScope2.align(SizeKt.m582size3ABfNKs(Modifier.Companion, f2), Alignment.Companion.getBottomEnd()), startRestartGroup, 0, 0);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarIconKt$AvatarIcon$2(avatar, modifier3, shape3, z2, j2, color2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void AvatarActiveIndicator(Modifier modifier, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1021706843);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i3 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            CanvasKt.Canvas(SizeKt.m582size3ABfNKs(modifier, Dp.m4704constructorimpl((float) 8)), AvatarIconKt$AvatarActiveIndicator$1.INSTANCE, startRestartGroup, 48);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarIconKt$AvatarActiveIndicator$2(modifier, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: AvatarPlaceholder-mhOCef0  reason: not valid java name */
    public static final void m5125AvatarPlaceholdermhOCef0(Modifier modifier, Avatar avatar, long j, long j2, Composer composer, int i, int i2) {
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1638422514);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.Companion : modifier;
        Alignment center = Alignment.Companion.getCenter();
        int i4 = (i3 & 14) | 48;
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        int i5 = i4 >> 3;
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, (i5 & 112) | (i5 & 14));
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
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier2);
        int i6 = ((((i4 << 3) & 112) << 9) & 7168) | 6;
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
        Composer r9 = Updater.m1543constructorimpl(startRestartGroup);
        Updater.m1550setimpl(r9, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1550setimpl(r9, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1550setimpl(r9, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1550setimpl(r9, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i6 >> 3) & 112));
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2137368960);
        ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
        if (((i6 >> 9) & 14 & 11) != 2 || !startRestartGroup.getSkipping()) {
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            if (((((i4 >> 6) & 112) | 6) & 81) != 16 || !startRestartGroup.getSkipping()) {
                String initials = avatar.getInitials();
                Intrinsics.checkNotNullExpressionValue(initials, "avatar.initials");
                if (!StringsKt.isBlank(initials)) {
                    startRestartGroup.startReplaceableGroup(-1609086280);
                    String initials2 = avatar.getInitials();
                    TextStyle subtitle2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getSubtitle2();
                    Intrinsics.checkNotNullExpressionValue(initials2, "initials");
                    TextKt.m1496TextfLXpl1I(initials2, (Modifier) null, j, j2, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, subtitle2, startRestartGroup, (i3 & 896) | (i3 & 7168), 0, 32754);
                    startRestartGroup.endReplaceableGroup();
                } else {
                    startRestartGroup.startReplaceableGroup(-1609086060);
                    IconKt.m1313Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.intercom_default_avatar_icon, startRestartGroup, 0), (String) null, PaddingKt.m510padding3ABfNKs(modifier2, Dp.m4704constructorimpl((float) 4)), j, startRestartGroup, ((i3 << 3) & 7168) | 56, 0);
                    startRestartGroup.endReplaceableGroup();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarIconKt$AvatarPlaceholder$2(modifier2, avatar, j, j2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void AvatarIconPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(2075002238);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, Shapes.copy$default(MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8), RoundedCornerShapeKt.RoundedCornerShape(0), (CornerBasedShape) null, (CornerBasedShape) null, 6, (Object) null), (Typography) null, ComposableSingletons$AvatarIconKt.INSTANCE.m5130getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 5);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarIconKt$AvatarIconPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void AvatarIconActivePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(654086436);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, Shapes.copy$default(MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8), RoundedCornerShapeKt.RoundedCornerShape(0), (CornerBasedShape) null, (CornerBasedShape) null, 6, (Object) null), (Typography) null, ComposableSingletons$AvatarIconKt.INSTANCE.m5131getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 5);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarIconKt$AvatarIconActivePreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void AvatarIconRoundPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1917752364);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$AvatarIconKt.INSTANCE.m5132getLambda3$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarIconKt$AvatarIconRoundPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void AvatarIconRoundActivePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1324803410);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$AvatarIconKt.INSTANCE.m5133getLambda4$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarIconKt$AvatarIconRoundActivePreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void AvatarIconSquirclePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1860134522);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, Shapes.copy$default(MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8), RoundedCornerShapeKt.RoundedCornerShape(10), (CornerBasedShape) null, (CornerBasedShape) null, 6, (Object) null), (Typography) null, ComposableSingletons$AvatarIconKt.INSTANCE.m5134getLambda5$intercom_sdk_base_release(), startRestartGroup, 3072, 5);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarIconKt$AvatarIconSquirclePreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void AvatarIconCutPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1055835104);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$AvatarIconKt.INSTANCE.m5135getLambda6$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarIconKt$AvatarIconCutPreview$1(i));
        }
    }

    public static final Modifier avatarBorder(Modifier modifier, boolean z, Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (!z) {
            return modifier;
        }
        return BorderKt.m184borderziNgDLE(modifier, Dp.m4704constructorimpl((float) 0.5d), Brush.Companion.m1870horizontalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf(Color.m1922boximpl(ColorKt.Color(872415231)), Color.m1922boximpl(ColorKt.Color(872415231))), 0.0f, 0.0f, 0, 14, (Object) null), shape);
    }
}
