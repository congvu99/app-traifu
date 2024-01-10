package io.intercom.android.sdk.blocks;

import io.intercom.android.sdk.blocks.lib.VideoProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"getEmbedUrl", "", "provider", "Lio/intercom/android/sdk/blocks/lib/VideoProvider;", "id", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: VideoUrlUtil.kt */
public final class VideoUrlUtilKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: VideoUrlUtil.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoProvider.values().length];
            iArr[VideoProvider.YOUTUBE.ordinal()] = 1;
            iArr[VideoProvider.VIMEO.ordinal()] = 2;
            iArr[VideoProvider.WISTIA.ordinal()] = 3;
            iArr[VideoProvider.LOOM.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String getEmbedUrl(VideoProvider videoProvider, String str) {
        Intrinsics.checkNotNullParameter(videoProvider, "provider");
        Intrinsics.checkNotNullParameter(str, "id");
        int i = WhenMappings.$EnumSwitchMapping$0[videoProvider.ordinal()];
        if (i == 1) {
            return "https://www.youtube.com/embed/" + str;
        } else if (i == 2) {
            return "https://player.vimeo.com/video/" + str;
        } else if (i == 3) {
            return "https://fast.wistia.net/embed/iframe/" + str;
        } else if (i != 4) {
            return "";
        } else {
            return "https://www.loom.com/embed/" + str;
        }
    }
}
