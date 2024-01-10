package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001aÓ\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"AsyncImage", "", "model", "", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "AsyncImage-3HmZ8SU", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lcoil/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "AsyncImage-ylYTKUw", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;III)V", "coil-compose-singleton_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SingletonAsyncImage.kt */
public final class SingletonAsyncImageKt {
    /* renamed from: AsyncImage-ylYTKUw  reason: not valid java name */
    public static final void m5019AsyncImageylYTKUw(Object obj, String str, Modifier modifier, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3, int i4) {
        Painter painter4;
        int i5;
        int i6;
        int i7;
        int i8 = i4;
        Composer startRestartGroup = composer.startRestartGroup(-1423046553);
        ComposerKt.sourceInformation(startRestartGroup, "C(AsyncImage)P(8,3,9,13,5,6,11,12,10!1,4!,7:c#ui.graphics.FilterQuality)");
        Modifier modifier2 = (i8 & 4) != 0 ? Modifier.Companion : modifier;
        Painter painter5 = (i8 & 8) != 0 ? null : painter;
        Painter painter6 = (i8 & 16) != 0 ? null : painter2;
        if ((i8 & 32) != 0) {
            i5 = i2 & -458753;
            painter4 = painter6;
        } else {
            painter4 = painter3;
            i5 = i2;
        }
        Function1<? super AsyncImagePainter.State.Loading, Unit> function14 = (i8 & 64) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function15 = (i8 & 128) != 0 ? null : function12;
        Function1<? super AsyncImagePainter.State.Error, Unit> function16 = (i8 & 256) != 0 ? null : function13;
        Alignment center = (i8 & 512) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i8 & 1024) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i8 & 2048) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i8 & 4096) != 0 ? null : colorFilter;
        if ((i8 & 8192) != 0) {
            i7 = i3 & -7169;
            i6 = DrawScope.Companion.m2518getDefaultFilterQualityfv9h1I();
        } else {
            i6 = i;
            i7 = i3;
        }
        int i9 = 2392584 | (i5 & 112);
        int i10 = i5 << 3;
        Composer composer2 = startRestartGroup;
        int i11 = i7 << 3;
        AsyncImageKt.m4988AsyncImageQ4Kwu38(obj, str, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), startRestartGroup, 6), modifier2, painter5, painter6, painter4, function14, function15, function16, center, fit, f2, colorFilter2, i6, composer2, (i10 & 7168) | i9 | (29360128 & i10) | (234881024 & i10) | (1879048192 & i10), ((i5 >> 27) & 14) | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (i11 & 57344), 0);
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SingletonAsyncImageKt$AsyncImage$1(obj, str, modifier2, painter5, painter6, painter4, function14, function15, function16, center, fit, f2, colorFilter2, i6, i2, i3, i4));
        }
    }

    /* renamed from: AsyncImage-3HmZ8SU  reason: not valid java name */
    public static final void m5018AsyncImage3HmZ8SU(Object obj, String str, Modifier modifier, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3) {
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> function13;
        int i4;
        int i5;
        int i6 = i3;
        Composer startRestartGroup = composer.startRestartGroup(-1423044094);
        ComposerKt.sourceInformation(startRestartGroup, "C(AsyncImage)P(6,3,7,9,8!1,4!,5:c#ui.graphics.FilterQuality)");
        Modifier modifier2 = (i6 & 4) != 0 ? Modifier.Companion : modifier;
        if ((i6 & 8) != 0) {
            i4 = i2 & -7169;
            function13 = AsyncImagePainter.Companion.getDefaultTransform();
        } else {
            function13 = function1;
            i4 = i2;
        }
        Function1<? super AsyncImagePainter.State, Unit> function14 = (i6 & 16) != 0 ? null : function12;
        Alignment center = (i6 & 32) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i6 & 64) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i6 & 128) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i6 & 256) != 0 ? null : colorFilter;
        if ((i6 & 512) != 0) {
            i4 &= -1879048193;
            i5 = DrawScope.Companion.m2518getDefaultFilterQualityfv9h1I();
        } else {
            i5 = i;
        }
        int i7 = i4 << 3;
        AsyncImageKt.m4987AsyncImageMvsnxeU(obj, str, ImageLoaderProvidableCompositionLocal.getCurrent(LocalImageLoaderKt.getLocalImageLoader(), startRestartGroup, 6), modifier2, function13, function14, center, fit, f2, colorFilter2, i5, startRestartGroup, (i4 & 112) | 520 | (i7 & 7168) | (57344 & i7) | (458752 & i7) | (3670016 & i7) | (29360128 & i7) | (234881024 & i7) | (i7 & 1879048192), (i4 >> 27) & 14, 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SingletonAsyncImageKt$AsyncImage$2(obj, str, modifier2, function13, function14, center, fit, f2, colorFilter2, i5, i2, i3));
        }
    }
}
