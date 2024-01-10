package coil.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b¢\u0006\u0002\u0010\u0004\u001ac\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032H\u0010\u0005\u001aD\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\fH\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u0000\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\b¢\u0006\u0002\u0010\u0010\u001ae\u0010\u0000\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2H\u0010\u0005\u001aD\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\fH\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a~\u0010\u0000\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2H\u0010\u0005\u001aD\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\f2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a1\u0010\u0000\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\b¢\u0006\u0002\u0010\u0018*\\\b\u0002\u0010\u0019\"\u0014\u0012\u0004\u0012\u0002`\n\u0012\u0004\u0012\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u00062@\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u0006*0\b\u0002\u0010\u001a\"\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u00072\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"rememberImagePainter", "Lcoil/compose/AsyncImagePainter;", "request", "Lcoil/request/ImageRequest;", "(Lcoil/request/ImageRequest;Landroidx/compose/runtime/Composer;I)Lcoil/compose/AsyncImagePainter;", "onExecute", "Lkotlin/Function2;", "Lkotlin/Triple;", "Lcoil/compose/AsyncImagePainter$State;", "Landroidx/compose/ui/geometry/Size;", "Lcoil/compose/Snapshot;", "", "Lcoil/compose/ExecuteCallback;", "(Lcoil/request/ImageRequest;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Lcoil/compose/AsyncImagePainter;", "data", "", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Lcoil/compose/AsyncImagePainter;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Lcoil/compose/AsyncImagePainter;", "builder", "Lkotlin/Function1;", "Lcoil/request/ImageRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lcoil/compose/AsyncImagePainter;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lcoil/compose/AsyncImagePainter;", "ExecuteCallback", "Snapshot", "coil-compose-singleton_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SingletonImagePainter.kt */
public final class SingletonImagePainterKt {
    @Deprecated(message = "ImagePainter has been renamed to AsyncImagePainter.", replaceWith = @ReplaceWith(expression = "rememberAsyncImagePainter(data)", imports = {"coil.compose.rememberAsyncImagePainter"}))
    public static final AsyncImagePainter rememberImagePainter(Object obj, Composer composer, int i) {
        composer.startReplaceableGroup(604399723);
        ComposerKt.sourceInformation(composer, "C(rememberImagePainter)");
        AsyncImagePainter r8 = SingletonAsyncImagePainterKt.m5020rememberAsyncImagePainter19ie5dc(obj, (Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State>) null, (Function1<? super AsyncImagePainter.State, Unit>) null, (ContentScale) null, 0, composer, 8, 30);
        composer.endReplaceableGroup();
        return r8;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "ImagePainter has been renamed to AsyncImagePainter.", replaceWith = @ReplaceWith(expression = "rememberAsyncImagePainter(data)", imports = {"coil.compose.rememberAsyncImagePainter"}))
    public static final AsyncImagePainter rememberImagePainter(Object obj, Function2<? super Triple<? extends AsyncImagePainter.State, ImageRequest, Size>, ? super Triple<? extends AsyncImagePainter.State, ImageRequest, Size>, Boolean> function2, Composer composer, int i) {
        composer.startReplaceableGroup(604400138);
        ComposerKt.sourceInformation(composer, "C(rememberImagePainter)");
        AsyncImagePainter r8 = SingletonAsyncImagePainterKt.m5020rememberAsyncImagePainter19ie5dc(obj, (Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State>) null, (Function1<? super AsyncImagePainter.State, Unit>) null, (ContentScale) null, 0, composer, 8, 30);
        composer.endReplaceableGroup();
        return r8;
    }

    @Deprecated(message = "ImagePainter has been renamed to AsyncImagePainter.", replaceWith = @ReplaceWith(expression = "rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current).data(data).apply(builder).build())", imports = {"androidx.compose.ui.platform.LocalContext", "coil.compose.rememberAsyncImagePainter", "coil.request.ImageRequest"}))
    public static final AsyncImagePainter rememberImagePainter(Object obj, Function1<? super ImageRequest.Builder, Unit> function1, Composer composer, int i) {
        composer.startReplaceableGroup(604400716);
        ComposerKt.sourceInformation(composer, "C(rememberImagePainter)P(1)");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageRequest.Builder data = new ImageRequest.Builder((Context) consume).data(obj);
        function1.invoke(data);
        AsyncImagePainter r8 = SingletonAsyncImagePainterKt.m5020rememberAsyncImagePainter19ie5dc(data.build(), (Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State>) null, (Function1<? super AsyncImagePainter.State, Unit>) null, (ContentScale) null, 0, composer, 8, 30);
        composer.endReplaceableGroup();
        return r8;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "ImagePainter has been renamed to AsyncImagePainter.", replaceWith = @ReplaceWith(expression = "rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current).data(data).apply(builder).build())", imports = {"androidx.compose.ui.platform.LocalContext", "coil.compose.rememberAsyncImagePainter", "coil.request.ImageRequest"}))
    public static final AsyncImagePainter rememberImagePainter(Object obj, Function2<? super Triple<? extends AsyncImagePainter.State, ImageRequest, Size>, ? super Triple<? extends AsyncImagePainter.State, ImageRequest, Size>, Boolean> function2, Function1<? super ImageRequest.Builder, Unit> function1, Composer composer, int i) {
        composer.startReplaceableGroup(604401473);
        ComposerKt.sourceInformation(composer, "C(rememberImagePainter)P(1,2)");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageRequest.Builder data = new ImageRequest.Builder((Context) consume).data(obj);
        function1.invoke(data);
        AsyncImagePainter r8 = SingletonAsyncImagePainterKt.m5020rememberAsyncImagePainter19ie5dc(data.build(), (Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State>) null, (Function1<? super AsyncImagePainter.State, Unit>) null, (ContentScale) null, 0, composer, 8, 30);
        composer.endReplaceableGroup();
        return r8;
    }

    @Deprecated(message = "ImagePainter has been renamed to AsyncImagePainter.", replaceWith = @ReplaceWith(expression = "rememberAsyncImagePainter(request)", imports = {"coil.compose.rememberAsyncImagePainter"}))
    public static final AsyncImagePainter rememberImagePainter(ImageRequest imageRequest, Composer composer, int i) {
        composer.startReplaceableGroup(604401976);
        ComposerKt.sourceInformation(composer, "C(rememberImagePainter)");
        AsyncImagePainter r8 = SingletonAsyncImagePainterKt.m5020rememberAsyncImagePainter19ie5dc(imageRequest, (Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State>) null, (Function1<? super AsyncImagePainter.State, Unit>) null, (ContentScale) null, 0, composer, 8, 30);
        composer.endReplaceableGroup();
        return r8;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "ImagePainter has been renamed to AsyncImagePainter.", replaceWith = @ReplaceWith(expression = "rememberAsyncImagePainter(request)", imports = {"coil.compose.rememberAsyncImagePainter"}))
    public static final AsyncImagePainter rememberImagePainter(ImageRequest imageRequest, Function2<? super Triple<? extends AsyncImagePainter.State, ImageRequest, Size>, ? super Triple<? extends AsyncImagePainter.State, ImageRequest, Size>, Boolean> function2, Composer composer, int i) {
        composer.startReplaceableGroup(604402408);
        ComposerKt.sourceInformation(composer, "C(rememberImagePainter)P(1)");
        AsyncImagePainter r8 = SingletonAsyncImagePainterKt.m5020rememberAsyncImagePainter19ie5dc(imageRequest, (Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State>) null, (Function1<? super AsyncImagePainter.State, Unit>) null, (ContentScale) null, 0, composer, 8, 30);
        composer.endReplaceableGroup();
        return r8;
    }
}
