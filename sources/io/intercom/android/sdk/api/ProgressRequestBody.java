package io.intercom.android.sdk.api;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.intercom.input.gallery.GalleryImage;
import io.intercom.android.sdk.conversation.UploadProgressListener;
import java.io.Closeable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

class ProgressRequestBody extends RequestBody {
    private static final int SEGMENT_SIZE = 2048;
    private static final int SMOOTH_END_MIN_VALUE = 90;
    private final ContentResolver contentResolver;
    private final MediaType contentType;
    private final GalleryImage image;
    private final UploadProgressListener listener;

    public ProgressRequestBody(MediaType mediaType, GalleryImage galleryImage, ContentResolver contentResolver2, UploadProgressListener uploadProgressListener) {
        this.contentType = mediaType;
        this.image = galleryImage;
        this.contentResolver = contentResolver2;
        this.listener = uploadProgressListener;
    }

    public long contentLength() {
        return (long) this.image.getFileSize();
    }

    public MediaType contentType() {
        return this.contentType;
    }

    public void writeTo(BufferedSink bufferedSink) {
        Uri uri = this.image.getUri();
        if (uri != Uri.EMPTY) {
            boolean z = false;
            int fileSize = this.image.getFileSize();
            Source source = null;
            try {
                source = Okio.source(this.contentResolver.openInputStream(uri));
                if (!this.image.isVideo()) {
                    long j = 0;
                    while (true) {
                        long read = source.read(bufferedSink.buffer(), PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
                        if (read == -1) {
                            break;
                        }
                        j += read;
                        bufferedSink.flush();
                        byte calculateProgress = calculateProgress(j, fileSize);
                        if (calculateProgress < 90) {
                            this.listener.uploadNotice(calculateProgress);
                        } else if (!z) {
                            this.listener.uploadSmoothEnd();
                            z = true;
                        }
                    }
                } else {
                    bufferedSink.writeAll(Okio.buffer(source));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) null);
                throw th;
            }
            Util.closeQuietly((Closeable) source);
        }
    }

    private byte calculateProgress(long j, int i) {
        if (i <= 0) {
            return 100;
        }
        return (byte) ((int) ((j * 100) / ((long) i)));
    }
}
