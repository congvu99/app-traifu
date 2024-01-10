package io.intercom.android.sdk.survey.block;

import android.content.Context;
import android.view.View;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.AsyncImagePainterKt;
import coil.request.ImageRequest;
import com.google.accompanist.placeholder.PlaceholderHighlight;
import com.google.accompanist.placeholder.PlaceholderHighlightKt;
import com.google.accompanist.placeholder.PlaceholderKt;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.LightboxOpeningImageClickListener;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.utilities.ImageUtils;
import io.intercom.android.sdk.utilities.IntercomCoilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageBlock.kt */
final class ImageBlockKt$ImageBlock$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ double $aspectRatio;
    final /* synthetic */ Block $block;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ int $width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageBlockKt$ImageBlock$1(int i, double d, Block block, Modifier modifier) {
        super(3);
        this.$width = i;
        this.$aspectRatio = d;
        this.$block = block;
        this.$modifier = modifier;
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
        if ((i & 14) == 0) {
            i2 = i | (composer2.changed((Object) boxWithConstraintsScope2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 91) != 18 || !composer.getSkipping()) {
            final int coerceAtMost = RangesKt.coerceAtMost((int) boxWithConstraintsScope.m459getMaxWidthD9Ej5fM(), this.$width);
            final int aspectHeight = ImageUtils.getAspectHeight(coerceAtMost, this.$aspectRatio);
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(composer);
            ImageRequest.Builder data = new ImageRequest.Builder((Context) consume).data(this.$block.getUrl());
            data.crossfade(true);
            data.error(R.drawable.intercom_image_load_failed);
            ImageRequest build = data.build();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(composer);
            AsyncImagePainter r1 = AsyncImagePainterKt.m4998rememberAsyncImagePainter5jETZwI(build, IntercomCoilKt.getImageLoader((Context) consume2), (Function1<? super AsyncImagePainter.State, ? extends AsyncImagePainter.State>) null, (Function1<? super AsyncImagePainter.State, Unit>) null, (ContentScale) null, 0, composer, 72, 60);
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer2.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd(composer);
            final View view = (View) consume3;
            Painter painter = r1;
            CharSequence text = this.$block.getText();
            if (StringsKt.isBlank(text)) {
                text = StringResources_androidKt.stringResource(R.string.intercom_image_attached, composer2, 0);
            }
            String str = (String) text;
            Modifier focusable$default = FocusableKt.focusable$default(PlaceholderKt.m5065placeholdercf5BqRc$default(SizeKt.m584sizeVpY3zN4(this.$modifier, Dp.m4704constructorimpl((float) coerceAtMost), Dp.m4704constructorimpl((float) aspectHeight)), (r1.getState() instanceof AsyncImagePainter.State.Empty) || (r1.getState() instanceof AsyncImagePainter.State.Loading), ColorKt.Color(869059788), (Shape) null, PlaceholderHighlightKt.m5061shimmerRPmYEkk$default(PlaceholderHighlight.Companion, ColorKt.Color(2499805183L), (InfiniteRepeatableSpec) null, 0.0f, 6, (Object) null), (Function3) null, (Function3) null, 52, (Object) null), false, (MutableInteractionSource) null, 3, (Object) null);
            final Block block = this.$block;
            ImageKt.Image(painter, str, ClickableKt.m196clickableXHw0xAI$default(focusable$default, false, (String) null, (Role) null, new Function0<Unit>() {
                public final void invoke() {
                    new LightboxOpeningImageClickListener(Injector.get().getApi()).onImageClicked(block.getUrl(), block.getLinkUrl(), view, coerceAtMost, aspectHeight);
                }
            }, 7, (Object) null), (Alignment) null, ContentScale.Companion.getFit(), 0.0f, (ColorFilter) null, composer, 24576, 104);
            return;
        }
        composer.skipToGroupEnd();
    }
}
