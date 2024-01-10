package coil.util;

import android.media.MediaMetadataRetriever;
import android.os.Build;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\b\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a,\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\n0\rH\b¢\u0006\u0002\u0010\u000e\u001a#\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\b¨\u0006\u0010"}, d2 = {"heightPx", "", "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "original", "Lkotlin/Function0;", "toPx", "Lcoil/size/Dimension;", "use", "T", "Landroid/media/MediaMetadataRetriever;", "block", "Lkotlin/Function1;", "(Landroid/media/MediaMetadataRetriever;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "widthPx", "coil-video_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* renamed from: coil.util.-VideoUtils  reason: invalid class name */
/* compiled from: Utils.kt */
public final class VideoUtils {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: coil.util.-VideoUtils$WhenMappings */
    /* compiled from: Utils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scale.values().length];
            iArr[Scale.FILL.ordinal()] = 1;
            iArr[Scale.FIT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final <T> T use(MediaMetadataRetriever mediaMetadataRetriever, Function1<? super MediaMetadataRetriever, ? extends T> function1) {
        int i;
        try {
            T invoke = function1.invoke(mediaMetadataRetriever);
            if (i < 29) {
                mediaMetadataRetriever.release();
            }
            return invoke;
        } finally {
            InlineMarker.finallyStart(1);
            if (Build.VERSION.SDK_INT >= 29) {
                mediaMetadataRetriever.close();
            } else {
                mediaMetadataRetriever.release();
            }
            InlineMarker.finallyEnd(1);
        }
    }

    public static final int widthPx(Size size, Scale scale, Function0<Integer> function0) {
        return Sizes.isOriginal(size) ? function0.invoke().intValue() : toPx(size.getWidth(), scale);
    }

    public static final int heightPx(Size size, Scale scale, Function0<Integer> function0) {
        return Sizes.isOriginal(size) ? function0.invoke().intValue() : toPx(size.getHeight(), scale);
    }

    public static final int toPx(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).px;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i == 1) {
            return Integer.MIN_VALUE;
        }
        if (i == 2) {
            return Integer.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
