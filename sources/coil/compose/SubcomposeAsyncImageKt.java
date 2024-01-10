package coil.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.size.SizeResolver;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a»\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a¯\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2&\b\u0002\u0010\u001e\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010!\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2&\b\u0002\u0010#\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a\u0001\u0010*\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010\u001e\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010!\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2$\u0010#\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003¢\u0006\u0002\u0010+\u001a[\u0010,\u001a\u00020\u0001*\u00020\u00192\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010/\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"SubcomposeAsyncImage", "", "model", "", "contentDescription", "", "imageLoader", "Lcoil/ImageLoader;", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "content", "Lcoil/compose/SubcomposeAsyncImageScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "SubcomposeAsyncImage-sKDTAoQ", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "loading", "Lkotlin/Function2;", "Lcoil/compose/AsyncImagePainter$State$Loading;", "success", "Lcoil/compose/AsyncImagePainter$State$Success;", "error", "Lcoil/compose/AsyncImagePainter$State$Error;", "onLoading", "onSuccess", "onError", "SubcomposeAsyncImage-Q4Kwu38", "(Ljava/lang/Object;Ljava/lang/String;Lcoil/ImageLoader;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "contentOf", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function3;", "SubcomposeAsyncImageContent", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "coil-compose-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubcomposeAsyncImage.kt */
public final class SubcomposeAsyncImageKt {
    /* renamed from: SubcomposeAsyncImage-Q4Kwu38  reason: not valid java name */
    public static final void m5024SubcomposeAsyncImageQ4Kwu38(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i2;
        int i8 = i4;
        Composer startRestartGroup = composer.startRestartGroup(-247982840);
        ComposerKt.sourceInformation(startRestartGroup, "C(SubcomposeAsyncImage)P(9,3,7,10,8,14,5,12,13,11!1,4!,6:c#ui.graphics.FilterQuality)");
        Modifier modifier2 = (i8 & 8) != 0 ? Modifier.Companion : modifier;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function44 = (i8 & 16) != 0 ? null : function4;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function45 = (i8 & 32) != 0 ? null : function42;
        Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function46 = (i8 & 64) != 0 ? null : function43;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i8 & 128) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i8 & 256) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i8 & 512) != 0 ? null : function13;
        Alignment center = (i8 & 1024) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i8 & 2048) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i8 & 4096) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i8 & 8192) != 0 ? null : colorFilter;
        if ((i8 & 16384) != 0) {
            i6 = i3 & -57345;
            i5 = DrawScope.Companion.m2518getDefaultFilterQualityfv9h1I();
        } else {
            i5 = i;
            i6 = i3;
        }
        int i9 = i6 << 18;
        m5025SubcomposeAsyncImagesKDTAoQ(obj, str, imageLoader, modifier2, (Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State>) null, UtilsKt.onStateOf(function14, function15, function16), center, fit, f2, colorFilter2, i5, contentOf(function44, function45, function46), startRestartGroup, (i7 & 112) | 520 | (i7 & 7168) | (i9 & 3670016) | (i9 & 29360128) | (i9 & 234881024) | (i9 & 1879048192), (i6 >> 12) & 14, 16);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SubcomposeAsyncImageKt$SubcomposeAsyncImage$1(obj, str, imageLoader, modifier2, function44, function45, function46, function14, function15, function16, center, fit, f2, colorFilter2, i5, i2, i3, i4));
        }
    }

    /* renamed from: SubcomposeAsyncImage-sKDTAoQ  reason: not valid java name */
    public static final void m5025SubcomposeAsyncImagesKDTAoQ(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i4;
        Composer startRestartGroup = composer.startRestartGroup(-247980060);
        ComposerKt.sourceInformation(startRestartGroup, "C(SubcomposeAsyncImage)P(8,4,7,9,11,10!1,5!2,6:c#ui.graphics.FilterQuality)");
        Modifier modifier2 = (i7 & 8) != 0 ? Modifier.Companion : modifier;
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> defaultTransform = (i7 & 16) != 0 ? AsyncImagePainter.Companion.getDefaultTransform() : function1;
        Function1<? super AsyncImagePainter.State, Unit> function13 = (i7 & 32) != 0 ? null : function12;
        Alignment center = (i7 & 64) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i7 & 128) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i7 & 256) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i7 & 512) != 0 ? null : colorFilter;
        if ((i7 & 1024) != 0) {
            i5 = DrawScope.Companion.m2518getDefaultFilterQualityfv9h1I();
            i6 = i3 & -15;
        } else {
            i5 = i;
            i6 = i3;
        }
        ImageRequest updateRequest = AsyncImageKt.updateRequest(UtilsKt.requestOf(obj, startRestartGroup, 8), fit, startRestartGroup, 8 | ((i2 >> 18) & 112));
        int i8 = i2 >> 6;
        int i9 = i2 >> 9;
        AsyncImagePainter r19 = AsyncImagePainterKt.m4998rememberAsyncImagePainter5jETZwI(updateRequest, imageLoader, defaultTransform, function13, fit, i5, startRestartGroup, (i8 & 7168) | (i8 & 896) | 72 | (i9 & 57344) | (458752 & (i6 << 15)), 0);
        SizeResolver sizeResolver = updateRequest.getSizeResolver();
        if (!(sizeResolver instanceof ConstraintsSizeResolver)) {
            startRestartGroup.startReplaceableGroup(-247979203);
            int i10 = (i9 & 14) | BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT | ((i2 >> 15) & 112);
            startRestartGroup.startReplaceableGroup(-1990474327);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            int i11 = i10 >> 3;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, true, startRestartGroup, (i11 & 112) | (i11 & 14));
            startRestartGroup.startReplaceableGroup(1376089394);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier2);
            int i12 = ((((i10 << 3) & 112) << 9) & 7168) | 6;
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
            Composer r6 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r6, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r6, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r6, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r6, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i12 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1253629305);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            int i13 = 2;
            if (((((i12 >> 9) & 14) & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
                int i14 = ((i10 >> 6) & 112) | 6;
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                if ((i14 & 14) == 0) {
                    if (startRestartGroup.changed((Object) boxScope)) {
                        i13 = 4;
                    }
                    i14 |= i13;
                }
                if (((i14 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
                    function3.invoke(new RealSubcomposeAsyncImageScope(boxScope, r19, str, center, fit, f2, colorFilter2), startRestartGroup, Integer.valueOf(i6 & 112));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                } else {
                    startRestartGroup.skipToGroupEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function32 = function3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            Function3<? super SubcomposeAsyncImageScope, ? super Composer, ? super Integer, Unit> function33 = function3;
            startRestartGroup.startReplaceableGroup(-247978567);
            BoxWithConstraintsKt.BoxWithConstraints(modifier2, center, true, ComposableLambdaKt.composableLambda(startRestartGroup, -819889657, true, new SubcomposeAsyncImageKt$SubcomposeAsyncImage$3(sizeResolver, function3, r19, str, center, fit, f2, colorFilter2, i6)), startRestartGroup, (i9 & 14) | 3456 | ((i2 >> 15) & 112), 0);
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SubcomposeAsyncImageKt$SubcomposeAsyncImage$4(obj, str, imageLoader, modifier2, defaultTransform, function13, center, fit, f2, colorFilter2, i5, function3, i2, i3, i4));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SubcomposeAsyncImageContent(coil.compose.SubcomposeAsyncImageScope r23, androidx.compose.ui.Modifier r24, androidx.compose.ui.graphics.painter.Painter r25, java.lang.String r26, androidx.compose.ui.Alignment r27, androidx.compose.ui.layout.ContentScale r28, float r29, androidx.compose.ui.graphics.ColorFilter r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r9 = r32
            r10 = r33
            r0 = -2089463611(0xffffffff837550c5, float:-7.209175E-37)
            r1 = r31
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SubcomposeAsyncImageContent)P(5,6,3!1,4)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r10
            r2 = 2
            if (r1 == 0) goto L_0x001e
            r1 = r9 | 6
            r3 = r1
            r1 = r23
            goto L_0x0032
        L_0x001e:
            r1 = r9 & 14
            if (r1 != 0) goto L_0x002f
            r1 = r23
            boolean r3 = r0.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r9
            goto L_0x0032
        L_0x002f:
            r1 = r23
            r3 = r9
        L_0x0032:
            r4 = r10 & 1
            if (r4 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x004c
        L_0x0039:
            r5 = r9 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004c
            r5 = r24
            boolean r6 = r0.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0048
            r6 = 32
            goto L_0x004a
        L_0x0048:
            r6 = 16
        L_0x004a:
            r3 = r3 | r6
            goto L_0x004e
        L_0x004c:
            r5 = r24
        L_0x004e:
            r6 = r10 & 2
            if (r6 == 0) goto L_0x0054
            r3 = r3 | 128(0x80, float:1.794E-43)
        L_0x0054:
            r7 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x006d
            r7 = r10 & 8
            if (r7 != 0) goto L_0x0067
            r7 = r26
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0069
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x006b
        L_0x0067:
            r7 = r26
        L_0x0069:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x006b:
            r3 = r3 | r8
            goto L_0x006f
        L_0x006d:
            r7 = r26
        L_0x006f:
            r8 = 57344(0xe000, float:8.0356E-41)
            r11 = r9 & r8
            if (r11 != 0) goto L_0x008b
            r11 = r10 & 16
            if (r11 != 0) goto L_0x0085
            r11 = r27
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0087
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0089
        L_0x0085:
            r11 = r27
        L_0x0087:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0089:
            r3 = r3 | r12
            goto L_0x008d
        L_0x008b:
            r11 = r27
        L_0x008d:
            r12 = 458752(0x70000, float:6.42848E-40)
            r13 = r9 & r12
            if (r13 != 0) goto L_0x00a8
            r13 = r10 & 32
            if (r13 != 0) goto L_0x00a2
            r13 = r28
            boolean r14 = r0.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00a4
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a6
        L_0x00a2:
            r13 = r28
        L_0x00a4:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00a6:
            r3 = r3 | r14
            goto L_0x00aa
        L_0x00a8:
            r13 = r28
        L_0x00aa:
            r14 = 3670016(0x380000, float:5.142788E-39)
            r15 = r9 & r14
            if (r15 != 0) goto L_0x00c6
            r15 = r10 & 64
            if (r15 != 0) goto L_0x00bf
            r15 = r29
            boolean r16 = r0.changed((float) r15)
            if (r16 == 0) goto L_0x00c1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c3
        L_0x00bf:
            r15 = r29
        L_0x00c1:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00c3:
            r3 = r3 | r16
            goto L_0x00c8
        L_0x00c6:
            r15 = r29
        L_0x00c8:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r9 & r16
            if (r16 != 0) goto L_0x00e4
            r14 = r10 & 128(0x80, float:1.794E-43)
            if (r14 != 0) goto L_0x00dd
            r14 = r30
            boolean r16 = r0.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x00df
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e1
        L_0x00dd:
            r14 = r30
        L_0x00df:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e1:
            r3 = r3 | r16
            goto L_0x00e6
        L_0x00e4:
            r14 = r30
        L_0x00e6:
            int r12 = ~r10
            r2 = r2 & r12
            if (r2 != 0) goto L_0x0108
            r2 = 23967451(0x16db6db, float:4.3661218E-38)
            r2 = r2 & r3
            r12 = 4793490(0x492492, float:6.71711E-39)
            r2 = r2 ^ r12
            if (r2 != 0) goto L_0x0108
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x00fb
            goto L_0x0108
        L_0x00fb:
            r0.skipToGroupEnd()
            r3 = r25
            r2 = r5
            r4 = r7
            r5 = r11
            r6 = r13
            r8 = r14
            r7 = r15
            goto L_0x01d5
        L_0x0108:
            r0.startDefaults()
            r2 = r9 & 1
            r12 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            if (r2 == 0) goto L_0x0149
            boolean r2 = r0.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0122
            goto L_0x0149
        L_0x0122:
            r0.skipToGroupEnd()
            if (r6 == 0) goto L_0x0129
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0129:
            r2 = r10 & 4
            if (r2 == 0) goto L_0x012f
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x012f:
            r2 = r10 & 8
            if (r2 == 0) goto L_0x0135
            r3 = r3 & r19
        L_0x0135:
            r2 = r10 & 16
            if (r2 == 0) goto L_0x013b
            r3 = r3 & r18
        L_0x013b:
            r2 = r10 & 32
            if (r2 == 0) goto L_0x0141
            r3 = r3 & r17
        L_0x0141:
            r2 = r10 & 64
            if (r2 == 0) goto L_0x0146
            r3 = r3 & r12
        L_0x0146:
            r2 = r25
            goto L_0x0196
        L_0x0149:
            if (r4 == 0) goto L_0x0150
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r5 = r2
        L_0x0150:
            if (r6 == 0) goto L_0x015b
            coil.compose.AsyncImagePainter r2 = r23.getPainter()
            androidx.compose.ui.graphics.painter.Painter r2 = (androidx.compose.ui.graphics.painter.Painter) r2
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x015d
        L_0x015b:
            r2 = r25
        L_0x015d:
            r4 = r10 & 4
            if (r4 == 0) goto L_0x0168
            java.lang.String r4 = r23.getContentDescription()
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r7 = r4
        L_0x0168:
            r4 = r10 & 8
            if (r4 == 0) goto L_0x0173
            androidx.compose.ui.Alignment r4 = r23.getAlignment()
            r3 = r3 & r19
            r11 = r4
        L_0x0173:
            r4 = r10 & 16
            if (r4 == 0) goto L_0x017e
            androidx.compose.ui.layout.ContentScale r4 = r23.getContentScale()
            r3 = r3 & r18
            r13 = r4
        L_0x017e:
            r4 = r10 & 32
            if (r4 == 0) goto L_0x0189
            float r4 = r23.getAlpha()
            r3 = r3 & r17
            r15 = r4
        L_0x0189:
            r4 = r10 & 64
            if (r4 == 0) goto L_0x0196
            androidx.compose.ui.graphics.ColorFilter r4 = r23.getColorFilter()
            r3 = r3 & r12
            r20 = r4
            r4 = r13
            goto L_0x0199
        L_0x0196:
            r4 = r13
            r20 = r14
        L_0x0199:
            r6 = r15
            r21 = r11
            r11 = r3
            r3 = r21
            r0.endDefaults()
            int r11 = r11 >> 3
            r12 = r11 & 14
            r12 = r12 | 64
            r13 = r11 & 896(0x380, float:1.256E-42)
            r12 = r12 | r13
            r13 = r11 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | r13
            r8 = r8 & r11
            r8 = r8 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r11
            r8 = r8 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r11 = r11 & r12
            r19 = r8 | r11
            r11 = r5
            r12 = r2
            r13 = r7
            r14 = r3
            r15 = r4
            r16 = r6
            r17 = r20
            r18 = r0
            coil.compose.AsyncImageKt.Content(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r8 = r20
            r21 = r3
            r3 = r2
            r2 = r5
            r5 = r21
            r22 = r6
            r6 = r4
            r4 = r7
            r7 = r22
        L_0x01d5:
            androidx.compose.runtime.ScopeUpdateScope r11 = r0.endRestartGroup()
            if (r11 != 0) goto L_0x01dc
            goto L_0x01ed
        L_0x01dc:
            coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$1 r12 = new coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImageContent$1
            r0 = r12
            r1 = r23
            r9 = r32
            r10 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x01ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.compose.SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(coil.compose.SubcomposeAsyncImageScope, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.painter.Painter, java.lang.String, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> contentOf(Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43) {
        return (function4 == null && function42 == null && function43 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.INSTANCE.m5000getLambda1$coil_compose_base_release() : ComposableLambdaKt.composableLambdaInstance(-985540635, true, new SubcomposeAsyncImageKt$contentOf$1(function4, function42, function43));
    }
}
