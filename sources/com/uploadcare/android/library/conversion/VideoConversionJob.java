package com.uploadcare.android.library.conversion;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bJ \u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\u0017\u001a\u00020\u0012R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/uploadcare/android/library/conversion/VideoConversionJob;", "Lcom/uploadcare/android/library/conversion/ConversionJob;", "fileId", "", "(Ljava/lang/String;)V", "cut", "format", "Lcom/uploadcare/android/library/conversion/VideoFormat;", "size", "thumbnails", "videoQuality", "Lcom/uploadcare/android/library/conversion/VideoQuality;", "startTime", "length", "getPath", "quality", "resize", "width", "", "height", "resizeMode", "Lcom/uploadcare/android/library/conversion/VideoResizeMode;", "setFormat", "numberOfThumbnails", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ConversionJob.kt */
public final class VideoConversionJob extends ConversionJob {
    private String cut;
    private VideoFormat format = VideoFormat.MP4;
    private String size;
    private String thumbnails;
    private VideoQuality videoQuality = VideoQuality.NORMAL;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoConversionJob(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "fileId");
    }

    public final VideoConversionJob setFormat(VideoFormat videoFormat) {
        Intrinsics.checkNotNullParameter(videoFormat, "format");
        this.format = videoFormat;
        return this;
    }

    public final VideoConversionJob quality(VideoQuality videoQuality2) {
        Intrinsics.checkNotNullParameter(videoQuality2, "quality");
        this.videoQuality = videoQuality2;
        return this;
    }

    public static /* synthetic */ VideoConversionJob resize$default(VideoConversionJob videoConversionJob, int i, int i2, VideoResizeMode videoResizeMode, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            videoResizeMode = VideoResizeMode.PRESERVE_RATIO;
        }
        return videoConversionJob.resize(i, i2, videoResizeMode);
    }

    public final VideoConversionJob resize(int i, int i2, VideoResizeMode videoResizeMode) {
        Intrinsics.checkNotNullParameter(videoResizeMode, "resizeMode");
        Integer num = null;
        Integer valueOf = (i <= 0 || i % 4 != 0) ? null : Integer.valueOf(i);
        if (i2 > 0 && i2 % 4 == 0) {
            num = Integer.valueOf(i2);
        }
        if (valueOf != null && num != null) {
            this.size = valueOf + 'x' + num + '/' + videoResizeMode.getRawValue();
        } else if (valueOf != null) {
            this.size = valueOf + "x/" + videoResizeMode.getRawValue();
        } else if (num != null) {
            this.size = 'x' + num + '/' + videoResizeMode.getRawValue();
        }
        return this;
    }

    public static /* synthetic */ VideoConversionJob cut$default(VideoConversionJob videoConversionJob, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = ViewProps.END;
        }
        return videoConversionJob.cut(str, str2);
    }

    public final VideoConversionJob cut(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "startTime");
        Intrinsics.checkNotNullParameter(str2, "length");
        this.cut = str + '/' + str2;
        return this;
    }

    public final VideoConversionJob thumbnails(int i) {
        this.thumbnails = "thumbs~" + i;
        return this;
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFileId() + "/video/-/format/" + this.format.getRawValue() + '/');
        if (this.videoQuality != null) {
            sb.append("-/quality/" + this.videoQuality.getRawValue() + '/');
        }
        String str = this.size;
        if (str != null) {
            sb.append("-/size/" + str + '/');
        }
        String str2 = this.cut;
        if (str2 != null) {
            sb.append("-/cut/" + str2 + '/');
        }
        String str3 = this.thumbnails;
        if (str3 != null) {
            sb.append("-/" + str3 + '/');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }
}
