package coil.request;

import coil.decode.VideoFrameDecoder;
import coil.request.ImageRequest;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0003*\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\n\u001a\u0011\u0010\b\u001a\u0004\u0018\u00010\n*\u00020\u0004¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"videoFrameMicros", "Lcoil/request/ImageRequest$Builder;", "frameMicros", "", "Lcoil/request/Parameters;", "(Lcoil/request/Parameters;)Ljava/lang/Long;", "videoFrameMillis", "frameMillis", "videoFrameOption", "option", "", "(Lcoil/request/Parameters;)Ljava/lang/Integer;", "coil-video_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Videos.kt */
public final class Videos {
    public static final ImageRequest.Builder videoFrameMillis(ImageRequest.Builder builder, long j) {
        return videoFrameMicros(builder, ((long) 1000) * j);
    }

    public static final ImageRequest.Builder videoFrameMicros(ImageRequest.Builder builder, long j) {
        if (j >= 0) {
            return ImageRequest.Builder.setParameter$default(builder, VideoFrameDecoder.VIDEO_FRAME_MICROS_KEY, Long.valueOf(j), (String) null, 4, (Object) null);
        }
        throw new IllegalArgumentException("frameMicros must be >= 0.".toString());
    }

    public static final ImageRequest.Builder videoFrameOption(ImageRequest.Builder builder, int i) {
        boolean z = true;
        if (!(i == 0 || i == 1 || i == 2 || i == 3)) {
            z = false;
        }
        if (z) {
            return ImageRequest.Builder.setParameter$default(builder, VideoFrameDecoder.VIDEO_FRAME_OPTION_KEY, Integer.valueOf(i), (String) null, 4, (Object) null);
        }
        throw new IllegalArgumentException(("Invalid video frame option: " + i + '.').toString());
    }

    public static final Long videoFrameMicros(Parameters parameters) {
        return (Long) parameters.value(VideoFrameDecoder.VIDEO_FRAME_MICROS_KEY);
    }

    public static final Integer videoFrameOption(Parameters parameters) {
        return (Integer) parameters.value(VideoFrameDecoder.VIDEO_FRAME_OPTION_KEY);
    }
}
