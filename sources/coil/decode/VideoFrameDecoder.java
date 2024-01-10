package coil.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import coil.ImageLoader;
import coil.decode.Decoder;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.size.Dimension;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcoil/decode/VideoFrameDecoder;", "Lcoil/decode/Decoder;", "source", "Lcoil/decode/ImageSource;", "options", "Lcoil/request/Options;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;)V", "decode", "Lcoil/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isConfigValid", "", "bitmap", "Landroid/graphics/Bitmap;", "isSizeValid", "size", "Lcoil/size/Size;", "normalizeBitmap", "inBitmap", "setDataSource", "", "Landroid/media/MediaMetadataRetriever;", "Companion", "Factory", "coil-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFrameDecoder.kt */
public final class VideoFrameDecoder implements Decoder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String VIDEO_FRAME_MICROS_KEY = "coil#video_frame_micros";
    public static final String VIDEO_FRAME_OPTION_KEY = "coil#video_frame_option";
    private final Options options;
    private final ImageSource source;

    public VideoFrameDecoder(ImageSource imageSource, Options options2) {
        this.source = imageSource;
        this.options = options2;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057 A[Catch:{ all -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071 A[Catch:{ all -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d A[Catch:{ all -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098 A[Catch:{ all -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a8 A[ADDED_TO_REGION, Catch:{ all -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0124 A[Catch:{ all -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0138 A[Catch:{ all -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x014b A[Catch:{ all -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0190 A[SYNTHETIC, Splitter:B:91:0x0190] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decode(kotlin.coroutines.Continuation<? super coil.decode.DecodeResult> r18) {
        /*
            r17 = this;
            r1 = r17
            android.media.MediaMetadataRetriever r8 = new android.media.MediaMetadataRetriever
            r8.<init>()
            r9 = 29
            coil.decode.ImageSource r0 = r1.source     // Catch:{ all -> 0x01b0 }
            r1.setDataSource(r8, r0)     // Catch:{ all -> 0x01b0 }
            coil.request.Options r0 = r1.options     // Catch:{ all -> 0x01b0 }
            coil.request.Parameters r0 = r0.getParameters()     // Catch:{ all -> 0x01b0 }
            java.lang.Integer r0 = coil.request.Videos.videoFrameOption(r0)     // Catch:{ all -> 0x01b0 }
            if (r0 != 0) goto L_0x001d
            r0 = 2
            r5 = 2
            goto L_0x0022
        L_0x001d:
            int r0 = r0.intValue()     // Catch:{ all -> 0x01b0 }
            r5 = r0
        L_0x0022:
            coil.request.Options r0 = r1.options     // Catch:{ all -> 0x01b0 }
            coil.request.Parameters r0 = r0.getParameters()     // Catch:{ all -> 0x01b0 }
            java.lang.Long r0 = coil.request.Videos.videoFrameMicros(r0)     // Catch:{ all -> 0x01b0 }
            if (r0 != 0) goto L_0x0031
            r2 = 0
            goto L_0x0035
        L_0x0031:
            long r2 = r0.longValue()     // Catch:{ all -> 0x01b0 }
        L_0x0035:
            r10 = r2
            r0 = 24
            java.lang.String r0 = r8.extractMetadata(r0)     // Catch:{ all -> 0x01b0 }
            if (r0 != 0) goto L_0x0040
        L_0x003e:
            r0 = 0
            goto L_0x004b
        L_0x0040:
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)     // Catch:{ all -> 0x01b0 }
            if (r0 != 0) goto L_0x0047
            goto L_0x003e
        L_0x0047:
            int r0 = r0.intValue()     // Catch:{ all -> 0x01b0 }
        L_0x004b:
            r2 = 90
            r3 = 18
            r4 = 19
            if (r0 == r2) goto L_0x007d
            r2 = 270(0x10e, float:3.78E-43)
            if (r0 == r2) goto L_0x007d
            java.lang.String r0 = r8.extractMetadata(r3)     // Catch:{ all -> 0x01b0 }
            if (r0 != 0) goto L_0x005f
        L_0x005d:
            r0 = 0
            goto L_0x006a
        L_0x005f:
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)     // Catch:{ all -> 0x01b0 }
            if (r0 != 0) goto L_0x0066
            goto L_0x005d
        L_0x0066:
            int r0 = r0.intValue()     // Catch:{ all -> 0x01b0 }
        L_0x006a:
            java.lang.String r2 = r8.extractMetadata(r4)     // Catch:{ all -> 0x01b0 }
            if (r2 != 0) goto L_0x0071
        L_0x0070:
            goto L_0x0096
        L_0x0071:
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)     // Catch:{ all -> 0x01b0 }
            if (r2 != 0) goto L_0x0078
            goto L_0x0070
        L_0x0078:
            int r2 = r2.intValue()     // Catch:{ all -> 0x01b0 }
            goto L_0x00a3
        L_0x007d:
            java.lang.String r0 = r8.extractMetadata(r4)     // Catch:{ all -> 0x01b0 }
            if (r0 != 0) goto L_0x0085
        L_0x0083:
            r0 = 0
            goto L_0x0090
        L_0x0085:
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)     // Catch:{ all -> 0x01b0 }
            if (r0 != 0) goto L_0x008c
            goto L_0x0083
        L_0x008c:
            int r0 = r0.intValue()     // Catch:{ all -> 0x01b0 }
        L_0x0090:
            java.lang.String r2 = r8.extractMetadata(r3)     // Catch:{ all -> 0x01b0 }
            if (r2 != 0) goto L_0x0098
        L_0x0096:
            r2 = 0
            goto L_0x00a3
        L_0x0098:
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)     // Catch:{ all -> 0x01b0 }
            if (r2 != 0) goto L_0x009f
            goto L_0x0096
        L_0x009f:
            int r2 = r2.intValue()     // Catch:{ all -> 0x01b0 }
        L_0x00a3:
            r13 = r2
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r0 <= 0) goto L_0x010b
            if (r13 <= 0) goto L_0x010b
            coil.request.Options r2 = r1.options     // Catch:{ all -> 0x01b0 }
            coil.size.Size r2 = r2.getSize()     // Catch:{ all -> 0x01b0 }
            coil.request.Options r3 = r1.options     // Catch:{ all -> 0x01b0 }
            coil.size.Scale r3 = r3.getScale()     // Catch:{ all -> 0x01b0 }
            boolean r4 = coil.size.Sizes.isOriginal(r2)     // Catch:{ all -> 0x01b0 }
            if (r4 == 0) goto L_0x00be
            r2 = r0
            goto L_0x00c6
        L_0x00be:
            coil.size.Dimension r2 = r2.getWidth()     // Catch:{ all -> 0x01b0 }
            int r2 = coil.util.VideoUtils.toPx(r2, r3)     // Catch:{ all -> 0x01b0 }
        L_0x00c6:
            coil.request.Options r3 = r1.options     // Catch:{ all -> 0x01b0 }
            coil.size.Size r3 = r3.getSize()     // Catch:{ all -> 0x01b0 }
            coil.request.Options r4 = r1.options     // Catch:{ all -> 0x01b0 }
            coil.size.Scale r4 = r4.getScale()     // Catch:{ all -> 0x01b0 }
            boolean r6 = coil.size.Sizes.isOriginal(r3)     // Catch:{ all -> 0x01b0 }
            if (r6 == 0) goto L_0x00da
            r3 = r13
            goto L_0x00e2
        L_0x00da:
            coil.size.Dimension r3 = r3.getHeight()     // Catch:{ all -> 0x01b0 }
            int r3 = coil.util.VideoUtils.toPx(r3, r4)     // Catch:{ all -> 0x01b0 }
        L_0x00e2:
            coil.request.Options r4 = r1.options     // Catch:{ all -> 0x01b0 }
            coil.size.Scale r4 = r4.getScale()     // Catch:{ all -> 0x01b0 }
            double r2 = coil.decode.DecodeUtils.computeSizeMultiplier((int) r0, (int) r13, (int) r2, (int) r3, (coil.size.Scale) r4)     // Catch:{ all -> 0x01b0 }
            coil.request.Options r4 = r1.options     // Catch:{ all -> 0x01b0 }
            boolean r4 = r4.getAllowInexactSize()     // Catch:{ all -> 0x01b0 }
            if (r4 == 0) goto L_0x00f8
            double r2 = kotlin.ranges.RangesKt.coerceAtMost((double) r2, (double) r14)     // Catch:{ all -> 0x01b0 }
        L_0x00f8:
            double r6 = (double) r0     // Catch:{ all -> 0x01b0 }
            double r6 = r6 * r2
            int r4 = kotlin.math.MathKt.roundToInt((double) r6)     // Catch:{ all -> 0x01b0 }
            double r6 = (double) r13     // Catch:{ all -> 0x01b0 }
            double r2 = r2 * r6
            int r2 = kotlin.math.MathKt.roundToInt((double) r2)     // Catch:{ all -> 0x01b0 }
            coil.size.Size r2 = coil.size.Sizes.Size((int) r4, (int) r2)     // Catch:{ all -> 0x01b0 }
            goto L_0x010d
        L_0x010b:
            coil.size.Size r2 = coil.size.Size.ORIGINAL     // Catch:{ all -> 0x01b0 }
        L_0x010d:
            r7 = r2
            coil.size.Dimension r2 = r7.component1()     // Catch:{ all -> 0x01b0 }
            coil.size.Dimension r3 = r7.component2()     // Catch:{ all -> 0x01b0 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01b0 }
            r6 = 27
            if (r4 < r6) goto L_0x0138
            boolean r4 = r2 instanceof coil.size.Dimension.Pixels     // Catch:{ all -> 0x01b0 }
            if (r4 == 0) goto L_0x0138
            boolean r4 = r3 instanceof coil.size.Dimension.Pixels     // Catch:{ all -> 0x01b0 }
            if (r4 == 0) goto L_0x0138
            coil.size.Dimension$Pixels r2 = (coil.size.Dimension.Pixels) r2     // Catch:{ all -> 0x01b0 }
            int r6 = r2.px     // Catch:{ all -> 0x01b0 }
            coil.size.Dimension$Pixels r3 = (coil.size.Dimension.Pixels) r3     // Catch:{ all -> 0x01b0 }
            int r3 = r3.px     // Catch:{ all -> 0x01b0 }
            r2 = r8
            r16 = r3
            r3 = r10
            r12 = r7
            r7 = r16
            android.graphics.Bitmap r2 = r2.getScaledFrameAtTime(r3, r5, r6, r7)     // Catch:{ all -> 0x01b0 }
            goto L_0x0149
        L_0x0138:
            r12 = r7
            android.graphics.Bitmap r2 = r8.getFrameAtTime(r10, r5)     // Catch:{ all -> 0x01b0 }
            if (r2 != 0) goto L_0x0141
            r2 = 0
            goto L_0x0149
        L_0x0141:
            int r0 = r2.getWidth()     // Catch:{ all -> 0x01b0 }
            int r13 = r2.getHeight()     // Catch:{ all -> 0x01b0 }
        L_0x0149:
            if (r2 == 0) goto L_0x0190
            android.graphics.Bitmap r2 = r1.normalizeBitmap(r2, r12)     // Catch:{ all -> 0x01b0 }
            r3 = 1
            if (r0 <= 0) goto L_0x016d
            if (r13 <= 0) goto L_0x016d
            int r4 = r2.getWidth()     // Catch:{ all -> 0x01b0 }
            int r5 = r2.getHeight()     // Catch:{ all -> 0x01b0 }
            coil.request.Options r6 = r1.options     // Catch:{ all -> 0x01b0 }
            coil.size.Scale r6 = r6.getScale()     // Catch:{ all -> 0x01b0 }
            double r4 = coil.decode.DecodeUtils.computeSizeMultiplier((int) r0, (int) r13, (int) r4, (int) r5, (coil.size.Scale) r6)     // Catch:{ all -> 0x01b0 }
            int r0 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r0 >= 0) goto L_0x016b
            goto L_0x016d
        L_0x016b:
            r12 = 0
            goto L_0x016e
        L_0x016d:
            r12 = 1
        L_0x016e:
            coil.decode.DecodeResult r0 = new coil.decode.DecodeResult     // Catch:{ all -> 0x01b0 }
            coil.request.Options r3 = r1.options     // Catch:{ all -> 0x01b0 }
            android.content.Context r3 = r3.getContext()     // Catch:{ all -> 0x01b0 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ all -> 0x01b0 }
            android.graphics.drawable.BitmapDrawable r4 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x01b0 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x01b0 }
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4     // Catch:{ all -> 0x01b0 }
            r0.<init>(r4, r12)     // Catch:{ all -> 0x01b0 }
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r9) goto L_0x018c
            r8.close()
            goto L_0x018f
        L_0x018c:
            r8.release()
        L_0x018f:
            return r0
        L_0x0190:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b0 }
            r0.<init>()     // Catch:{ all -> 0x01b0 }
            java.lang.String r2 = "Failed to decode frame at "
            r0.append(r2)     // Catch:{ all -> 0x01b0 }
            r0.append(r10)     // Catch:{ all -> 0x01b0 }
            java.lang.String r2 = " microseconds."
            r0.append(r2)     // Catch:{ all -> 0x01b0 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01b0 }
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x01b0 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01b0 }
            r2.<init>(r0)     // Catch:{ all -> 0x01b0 }
            throw r2     // Catch:{ all -> 0x01b0 }
        L_0x01b0:
            r0 = move-exception
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r9) goto L_0x01b9
            r8.close()
            goto L_0x01bc
        L_0x01b9:
            r8.release()
        L_0x01bc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.VideoFrameDecoder.decode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Bitmap normalizeBitmap(Bitmap bitmap, Size size) {
        Bitmap.Config config;
        if (isConfigValid(bitmap, this.options) && isSizeValid(bitmap, this.options, size)) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Dimension width2 = size.getWidth();
        int width3 = width2 instanceof Dimension.Pixels ? ((Dimension.Pixels) width2).px : bitmap.getWidth();
        Dimension height2 = size.getHeight();
        float computeSizeMultiplier = (float) DecodeUtils.computeSizeMultiplier(width, height, width3, height2 instanceof Dimension.Pixels ? ((Dimension.Pixels) height2).px : bitmap.getHeight(), this.options.getScale());
        int roundToInt = MathKt.roundToInt(((float) bitmap.getWidth()) * computeSizeMultiplier);
        int roundToInt2 = MathKt.roundToInt(((float) bitmap.getHeight()) * computeSizeMultiplier);
        if (Build.VERSION.SDK_INT < 26 || this.options.getConfig() != Bitmap.Config.HARDWARE) {
            config = this.options.getConfig();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Paint paint = new Paint(3);
        Bitmap createBitmap = Bitmap.createBitmap(roundToInt, roundToInt2, config);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, height, config)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.scale(computeSizeMultiplier, computeSizeMultiplier);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        bitmap.recycle();
        return createBitmap;
    }

    private final boolean isConfigValid(Bitmap bitmap, Options options2) {
        return Build.VERSION.SDK_INT < 26 || bitmap.getConfig() != Bitmap.Config.HARDWARE || options2.getConfig() == Bitmap.Config.HARDWARE;
    }

    private final boolean isSizeValid(Bitmap bitmap, Options options2, Size size) {
        if (options2.getAllowInexactSize()) {
            return true;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Dimension width2 = size.getWidth();
        int width3 = width2 instanceof Dimension.Pixels ? ((Dimension.Pixels) width2).px : bitmap.getWidth();
        Dimension height2 = size.getHeight();
        if (DecodeUtils.computeSizeMultiplier(width, height, width3, height2 instanceof Dimension.Pixels ? ((Dimension.Pixels) height2).px : bitmap.getHeight(), options2.getScale()) == 1.0d) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003b, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003a, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setDataSource(android.media.MediaMetadataRetriever r9, coil.decode.ImageSource r10) {
        /*
            r8 = this;
            coil.decode.ImageSource$Metadata r0 = r10.getMetadata()
            boolean r1 = r0 instanceof coil.decode.AssetMetadata
            if (r1 == 0) goto L_0x003f
            coil.request.Options r10 = r8.options
            android.content.Context r10 = r10.getContext()
            android.content.res.AssetManager r10 = r10.getAssets()
            coil.decode.AssetMetadata r0 = (coil.decode.AssetMetadata) r0
            java.lang.String r0 = r0.getFileName()
            android.content.res.AssetFileDescriptor r10 = r10.openFd(r0)
            java.io.Closeable r10 = (java.io.Closeable) r10
            r0 = 0
            r1 = r10
            android.content.res.AssetFileDescriptor r1 = (android.content.res.AssetFileDescriptor) r1     // Catch:{ all -> 0x0038 }
            java.io.FileDescriptor r3 = r1.getFileDescriptor()     // Catch:{ all -> 0x0038 }
            long r4 = r1.getStartOffset()     // Catch:{ all -> 0x0038 }
            long r6 = r1.getLength()     // Catch:{ all -> 0x0038 }
            r2 = r9
            r2.setDataSource(r3, r4, r6)     // Catch:{ all -> 0x0038 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0038 }
            kotlin.io.CloseableKt.closeFinally(r10, r0)
            goto L_0x008d
        L_0x0038:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x003a }
        L_0x003a:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r10, r9)
            throw r0
        L_0x003f:
            boolean r1 = r0 instanceof coil.decode.ContentMetadata
            if (r1 == 0) goto L_0x0053
            coil.request.Options r10 = r8.options
            android.content.Context r10 = r10.getContext()
            coil.decode.ContentMetadata r0 = (coil.decode.ContentMetadata) r0
            android.net.Uri r0 = r0.getUri()
            r9.setDataSource(r10, r0)
            goto L_0x008d
        L_0x0053:
            boolean r1 = r0 instanceof coil.decode.ResourceMetadata
            if (r1 == 0) goto L_0x007e
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "android.resource://"
            r10.append(r1)
            coil.decode.ResourceMetadata r0 = (coil.decode.ResourceMetadata) r0
            java.lang.String r1 = r0.getPackageName()
            r10.append(r1)
            r1 = 47
            r10.append(r1)
            int r0 = r0.getResId()
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            r9.setDataSource(r10)
            goto L_0x008d
        L_0x007e:
            okio.Path r10 = r10.file()
            java.io.File r10 = r10.toFile()
            java.lang.String r10 = r10.getPath()
            r9.setDataSource(r10)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.VideoFrameDecoder.setDataSource(android.media.MediaMetadataRetriever, coil.decode.ImageSource):void");
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002¨\u0006\u0014"}, d2 = {"Lcoil/decode/VideoFrameDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "()V", "create", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "equals", "", "other", "", "hashCode", "", "isApplicable", "mimeType", "", "coil-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoFrameDecoder.kt */
    public static final class Factory implements Decoder.Factory {
        public Decoder create(SourceResult sourceResult, Options options, ImageLoader imageLoader) {
            if (!isApplicable(sourceResult.getMimeType())) {
                return null;
            }
            return new VideoFrameDecoder(sourceResult.getSource(), options);
        }

        private final boolean isApplicable(String str) {
            return str != null && StringsKt.startsWith$default(str, "video/", false, 2, (Object) null);
        }

        public boolean equals(Object obj) {
            return obj instanceof Factory;
        }

        public int hashCode() {
            return getClass().hashCode();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil/decode/VideoFrameDecoder$Companion;", "", "()V", "VIDEO_FRAME_MICROS_KEY", "", "VIDEO_FRAME_OPTION_KEY", "coil-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoFrameDecoder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
