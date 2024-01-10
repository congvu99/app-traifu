package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.InspectionModeKt;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.size.Dimension;
import coil.size.Dimensions;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000}\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0001\u001ai\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a§\u0001\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(H\u0002\u001a\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002\u001a\u001b\u0010-\u001a\u0004\u0018\u00010.*\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001b\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"FakeTransitionTarget", "coil/compose/AsyncImagePainterKt$FakeTransitionTarget$1", "Lcoil/compose/AsyncImagePainterKt$FakeTransitionTarget$1;", "isPositive", "", "Landroidx/compose/ui/geometry/Size;", "isPositive-uvyYCjk", "(J)Z", "rememberAsyncImagePainter", "Lcoil/compose/AsyncImagePainter;", "model", "", "imageLoader", "Lcoil/ImageLoader;", "transform", "Lkotlin/Function1;", "Lcoil/compose/AsyncImagePainter$State;", "onState", "", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "rememberAsyncImagePainter-5jETZwI", "(Ljava/lang/Object;Lcoil/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "placeholder", "Landroidx/compose/ui/graphics/painter/Painter;", "error", "fallback", "onLoading", "Lcoil/compose/AsyncImagePainter$State$Loading;", "onSuccess", "Lcoil/compose/AsyncImagePainter$State$Success;", "onError", "Lcoil/compose/AsyncImagePainter$State$Error;", "rememberAsyncImagePainter-3HmZ8SU", "(Ljava/lang/Object;Lcoil/ImageLoader;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;ILandroidx/compose/runtime/Composer;II)Lcoil/compose/AsyncImagePainter;", "unsupportedData", "", "name", "", "description", "validateRequest", "request", "Lcoil/request/ImageRequest;", "toSizeOrNull", "Lcoil/size/Size;", "toSizeOrNull-uvyYCjk", "(J)Lcoil/size/Size;", "coil-compose-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AsyncImagePainter.kt */
public final class AsyncImagePainterKt {
    /* access modifiers changed from: private */
    public static final AsyncImagePainterKt$FakeTransitionTarget$1 FakeTransitionTarget = new AsyncImagePainterKt$FakeTransitionTarget$1();

    /* renamed from: rememberAsyncImagePainter-3HmZ8SU  reason: not valid java name */
    public static final AsyncImagePainter m4997rememberAsyncImagePainter3HmZ8SU(Object obj, ImageLoader imageLoader, Painter painter, Painter painter2, Painter painter3, Function1<? super AsyncImagePainter.State.Loading, Unit> function1, Function1<? super AsyncImagePainter.State.Success, Unit> function12, Function1<? super AsyncImagePainter.State.Error, Unit> function13, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        composer2.startReplaceableGroup(294033699);
        ComposerKt.sourceInformation(composer2, "C(rememberAsyncImagePainter)P(5,4,9,1,2,7,8,6!,3:c#ui.graphics.FilterQuality)");
        Function1<? super AsyncImagePainter.State.Error, Unit> function14 = null;
        Painter painter4 = (i4 & 4) != 0 ? null : painter;
        Painter painter5 = (i4 & 8) != 0 ? null : painter2;
        Painter painter6 = (i4 & 16) != 0 ? painter5 : painter3;
        Function1<? super AsyncImagePainter.State.Loading, Unit> function15 = (i4 & 32) != 0 ? null : function1;
        Function1<? super AsyncImagePainter.State.Success, Unit> function16 = (i4 & 64) != 0 ? null : function12;
        if ((i4 & 128) == 0) {
            function14 = function13;
        }
        int i5 = i2 >> 12;
        AsyncImagePainter r0 = m4998rememberAsyncImagePainter5jETZwI(obj, imageLoader, UtilsKt.transformOf(painter4, painter5, painter6), UtilsKt.onStateOf(function15, function16, function14), (i4 & 256) != 0 ? ContentScale.Companion.getFit() : contentScale, (i4 & 512) != 0 ? DrawScope.Companion.m2518getDefaultFilterQualityfv9h1I() : i, composer, (57344 & i5) | 72 | (i5 & 458752), 0);
        composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: rememberAsyncImagePainter-5jETZwI  reason: not valid java name */
    public static final AsyncImagePainter m4998rememberAsyncImagePainter5jETZwI(Object obj, ImageLoader imageLoader, Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State> function1, Function1<? super AsyncImagePainter.State, Unit> function12, ContentScale contentScale, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(294036008);
        ComposerKt.sourceInformation(composer, "C(rememberAsyncImagePainter)P(3,2,5,4!,1:c#ui.graphics.FilterQuality)");
        Function1<AsyncImagePainter.State, AsyncImagePainter.State> function13 = function1;
        if ((i3 & 4) != 0) {
            function13 = AsyncImagePainter.Companion.getDefaultTransform();
        }
        if ((i3 & 8) != 0) {
            function12 = null;
        }
        if ((i3 & 16) != 0) {
            contentScale = ContentScale.Companion.getFit();
        }
        if ((i3 & 32) != 0) {
            i = DrawScope.Companion.m2518getDefaultFilterQualityfv9h1I();
        }
        ImageRequest requestOf = UtilsKt.requestOf(obj, composer, 8);
        validateRequest(requestOf);
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new AsyncImagePainter(requestOf, imageLoader);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        AsyncImagePainter asyncImagePainter = (AsyncImagePainter) rememberedValue;
        asyncImagePainter.setTransform$coil_compose_base_release(function13);
        asyncImagePainter.setOnState$coil_compose_base_release(function12);
        asyncImagePainter.setContentScale$coil_compose_base_release(contentScale);
        asyncImagePainter.m4994setFilterQualityvDHp3xo$coil_compose_base_release(i);
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(InspectionModeKt.getLocalInspectionMode());
        ComposerKt.sourceInformationMarkerEnd(composer);
        asyncImagePainter.setPreview$coil_compose_base_release(((Boolean) consume).booleanValue());
        asyncImagePainter.setImageLoader$coil_compose_base_release(imageLoader);
        asyncImagePainter.setRequest$coil_compose_base_release(requestOf);
        asyncImagePainter.onRemembered();
        composer.endReplaceableGroup();
        return asyncImagePainter;
    }

    private static final void validateRequest(ImageRequest imageRequest) {
        Object data = imageRequest.getData();
        if (data instanceof ImageRequest.Builder) {
            unsupportedData("ImageRequest.Builder", "Did you forget to call ImageRequest.Builder.build()?");
            throw new KotlinNothingValueException();
        } else if (data instanceof ImageBitmap) {
            unsupportedData$default("ImageBitmap", (String) null, 2, (Object) null);
            throw new KotlinNothingValueException();
        } else if (data instanceof ImageVector) {
            unsupportedData$default("ImageVector", (String) null, 2, (Object) null);
            throw new KotlinNothingValueException();
        } else if (!(data instanceof Painter)) {
            if (!(imageRequest.getTarget() == null)) {
                throw new IllegalArgumentException("request.target must be null.".toString());
            }
        } else {
            unsupportedData$default("Painter", (String) null, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    static /* synthetic */ Void unsupportedData$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "If you wish to display this " + str + ", use androidx.compose.foundation.Image.";
        }
        return unsupportedData(str, str2);
    }

    private static final Void unsupportedData(String str, String str2) {
        throw new IllegalArgumentException("Unsupported type: " + str + ". " + str2);
    }

    /* renamed from: isPositive-uvyYCjk  reason: not valid java name */
    private static final boolean m4996isPositiveuvyYCjk(long j) {
        return ((double) Size.m1752getWidthimpl(j)) >= 0.5d && ((double) Size.m1749getHeightimpl(j)) >= 0.5d;
    }

    /* access modifiers changed from: private */
    /* renamed from: toSizeOrNull-uvyYCjk  reason: not valid java name */
    public static final coil.size.Size m4999toSizeOrNulluvyYCjk(long j) {
        boolean z = true;
        if (j == Size.Companion.m1760getUnspecifiedNHjbRc()) {
            return coil.size.Size.ORIGINAL;
        }
        if (!m4996isPositiveuvyYCjk(j)) {
            return null;
        }
        float r1 = Size.m1752getWidthimpl(j);
        Dimension Dimension = !Float.isInfinite(r1) && !Float.isNaN(r1) ? Dimensions.Dimension(MathKt.roundToInt(Size.m1752getWidthimpl(j))) : Dimension.Undefined.INSTANCE;
        float r4 = Size.m1749getHeightimpl(j);
        if (Float.isInfinite(r4) || Float.isNaN(r4)) {
            z = false;
        }
        return new coil.size.Size(Dimension, z ? Dimensions.Dimension(MathKt.roundToInt(Size.m1749getHeightimpl(j))) : Dimension.Undefined.INSTANCE);
    }
}
