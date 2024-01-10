package io.intercom.android.sdk.survey.ui.components;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
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
import coil.compose.AsyncImagePainterKt;
import coil.request.ImageRequest;
import coil.transform.CircleCropTransformation;
import coil.transform.Transformation;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.utilities.ColorExtensionsKt;
import io.intercom.android.sdk.utilities.IntercomCoilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"CircularAvatar", "", "avatar", "Lio/intercom/android/sdk/models/Avatar;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "size", "Landroidx/compose/ui/unit/Dp;", "CircularAvatar-aM-cp0Q", "(Lio/intercom/android/sdk/models/Avatar;JFLandroidx/compose/runtime/Composer;II)V", "PreviewDefaultAvatar", "(Landroidx/compose/runtime/Composer;I)V", "PreviewInitialAvatar", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: CircularAvatarComponent.kt */
public final class CircularAvatarComponentKt {
    /* renamed from: CircularAvatar-aM-cp0Q  reason: not valid java name */
    public static final void m5309CircularAvataraMcp0Q(Avatar avatar, long j, float f, Composer composer, int i, int i2) {
        float f2;
        String str;
        String str2;
        int i3;
        char c;
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Composer startRestartGroup = composer.startRestartGroup(-276383091);
        if ((i2 & 4) != 0) {
            f2 = Dp.m4704constructorimpl((float) 40);
        } else {
            f2 = f;
        }
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
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
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
        Composer r13 = Updater.m1543constructorimpl(startRestartGroup);
        Updater.m1550setimpl(r13, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1550setimpl(r13, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1550setimpl(r13, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1550setimpl(r13, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2137368960);
        ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        String stringResource = StringResources_androidKt.stringResource(R.string.intercom_surveys_sender_image, startRestartGroup, 0);
        String initials = avatar.getInitials();
        Intrinsics.checkNotNullExpressionValue(initials, "avatar.initials");
        if (initials.length() > 0) {
            startRestartGroup.startReplaceableGroup(-1427852481);
            Modifier r10 = BackgroundKt.m177backgroundbw27NRU$default(ClipKt.clip(SizeKt.m582size3ABfNKs(Modifier.Companion, f2), RoundedCornerShapeKt.getCircleShape()), j, (Shape) null, 2, (Object) null);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r10);
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
            Composer r6 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r6, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r6, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r6, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r6, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            String initials2 = avatar.getInitials();
            Intrinsics.checkNotNullExpressionValue(initials2, "avatar.initials");
            Modifier align = BoxScopeInstance.INSTANCE.align(Modifier.Companion, Alignment.Companion.getCenter());
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) stringResource);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new CircularAvatarComponentKt$CircularAvatar$1$1$1$1(stringResource);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            str = stringResource;
            TextKt.m1496TextfLXpl1I(initials2, SemanticsModifierKt.semantics$default(align, false, (Function1) rememberedValue, 1, (Object) null), ColorExtensionsKt.m5396generateTextColor8_81llA(j), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 0, 0, 65528);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            str2 = "C:CompositionLocal.kt#9igjgp";
            c = 0;
            i3 = 2023513938;
        } else {
            str = stringResource;
            startRestartGroup.startReplaceableGroup(-1427851886);
            Modifier r62 = BackgroundKt.m177backgroundbw27NRU$default(ClipKt.clip(SizeKt.m582size3ABfNKs(Modifier.Companion, f2), RoundedCornerShapeKt.getCircleShape()), j, (Shape) null, 2, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            c = 0;
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            str2 = "C:CompositionLocal.kt#9igjgp";
            i3 = 2023513938;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str2);
            Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density3 = (Density) consume7;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str2);
            Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str2);
            Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(r62);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r102 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r102, rememberBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r102, density3, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r102, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r102, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.intercom_default_avatar_icon, startRestartGroup, 0), str, BoxScopeInstance.INSTANCE.align(Modifier.Companion, Alignment.Companion.getCenter()), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, ColorFilter.Companion.m1973tintxETnrds$default(ColorFilter.Companion, ColorExtensionsKt.m5396generateTextColor8_81llA(j), 0, 2, (Object) null), startRestartGroup, 24584, 40);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        }
        String imageUrl = avatar.getImageUrl();
        Intrinsics.checkNotNullExpressionValue(imageUrl, "avatar.imageUrl");
        if (imageUrl.length() > 0) {
            String imageUrl2 = avatar.getImageUrl();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, i3, str2);
            Object consume10 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ImageLoader imageLoader = IntercomCoilKt.getImageLoader((Context) consume10);
            startRestartGroup.startReplaceableGroup(604401124);
            ComposerKt.sourceInformation(startRestartGroup, "C(rememberImagePainter)P(1,2)");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, str2);
            Object consume11 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ImageRequest.Builder data = new ImageRequest.Builder((Context) consume11).data(imageUrl2);
            data.crossfade(true);
            Transformation[] transformationArr = new Transformation[1];
            transformationArr[c] = new CircleCropTransformation();
            data.transformations(transformationArr);
            AsyncImagePainter r3 = AsyncImagePainterKt.m4998rememberAsyncImagePainter5jETZwI(data.build(), imageLoader, (Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State>) null, (Function1<? super AsyncImagePainter.State, Unit>) null, (ContentScale) null, 0, startRestartGroup, 72, 60);
            startRestartGroup.endReplaceableGroup();
            ImageKt.Image((Painter) r3, str, SizeKt.m582size3ABfNKs(Modifier.Companion, f2), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 0, 120);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CircularAvatarComponentKt$CircularAvatar$2(avatar, j, f2, i, i2));
        }
    }

    public static final void PreviewDefaultAvatar(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1706634993);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            Avatar create = Avatar.create("", "");
            Intrinsics.checkNotNullExpressionValue(create, "create(\"\", \"\")");
            m5309CircularAvataraMcp0Q(create, Color.Companion.m1970getYellow0d7_KjU(), 0.0f, startRestartGroup, 56, 4);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CircularAvatarComponentKt$PreviewDefaultAvatar$1(i));
        }
    }

    public static final void PreviewInitialAvatar(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1788709612);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            Avatar create = Avatar.create("", "PS");
            Intrinsics.checkNotNullExpressionValue(create, "create(\"\", \"PS\")");
            m5309CircularAvataraMcp0Q(create, Color.Companion.m1959getBlue0d7_KjU(), 0.0f, startRestartGroup, 56, 4);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CircularAvatarComponentKt$PreviewInitialAvatar$1(i));
        }
    }
}
